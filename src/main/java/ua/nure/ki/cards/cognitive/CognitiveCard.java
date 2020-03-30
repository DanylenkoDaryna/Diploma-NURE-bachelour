package ua.nure.ki.cards.cognitive;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import ua.nure.ki.cards.data.*;
import ua.nure.ki.cards.service.*;

import java.util.ArrayList;
import java.util.List;

public class CognitiveCard {

    private int cardId;
    private int userId;
    private List<Topic> topics = new ArrayList<>(1);
    private List<Qdependency> dependencies = new ArrayList<>();
    private List<Question> questions = new ArrayList<>();
    private List<TestDependency> tDependencies = new ArrayList<>();
    private List<Ansver> ansvers = new ArrayList<>();
    private List<TestsEthalon> ethalons = new ArrayList<>();
    List<ResultAnsver> resultAnsvers = new ArrayList<>();
    List<TestDependency> testDependencies = new ArrayList<>();
    private static String border= "---------------------------------------------------";

    private int complexity;
    private int importance;

    private TableView<Qdependency> table = new TableView<>();

    public CognitiveCard(){
            setCardId(0);
            setUserId(0);
            this.setTopics(new ArrayList<Topic>(1));
            this.setDependencies(new ArrayList<Qdependency>());
            this.setQuestions(new ArrayList<Question>());
            setComplexity(0);
            setImportance(0);

    }

    public CognitiveCard(int cardId, int userId, List<Topic> topics, List<Qdependency> depends, List<Question> questions, int complex, int important){
        setCardId(cardId);
        setUserId(userId);
        this.setTopics(new ArrayList<Topic>(topics));
        this.setDependencies(new ArrayList<Qdependency>(depends));
        this.setQuestions(new ArrayList<Question>(questions));
        setComplexity(complex);
        setImportance(important);

    }


    public void getDataToGenerateCard(int testId){
        TopicService topicService = new TopicService();
        this.topics=topicService.findBy(testId);
        System.out.println(this.topics.toString());
        QuestionService questionService = new QuestionService();
        this.questions=questionService.findBy(this.topics.get(0).getTopicId());
        System.out.println(questions.toString());
        this.showCard(questions);

    }

    private void showCard(List<Question> quests) {

        // Create column UserName (Data type of String).
        TableColumn<Qdependency, Integer> questNumbCol //
                = new TableColumn<>("Question Number");
        TableColumn<Qdependency, Integer> dependQuestNumbCol //
                = new TableColumn<>("Dependent Question Number");
        TableColumn<Qdependency, Integer> weightCol //
                = new TableColumn<>("Weight");

        // Defines how to fill data for each cell.
        // Get value from property of Qdependency. .
        questNumbCol.setCellValueFactory(new PropertyValueFactory<>("questionId"));
        dependQuestNumbCol.setCellValueFactory(new PropertyValueFactory<>("dependenceOfId"));
        weightCol.setCellValueFactory(new PropertyValueFactory<>("weight"));
        questNumbCol.setSortType(TableColumn.SortType.ASCENDING);

            QdependencyService depService = new QdependencyService();

        for (Question quest : quests) {
            this.dependencies.addAll(depService.findBy(quest.getQuestionId()));
        }

        ObservableList<Qdependency> list = FXCollections.observableArrayList(dependencies);
        for (Qdependency aList : list) {
            table.getItems().add(aList);
        }
        table.getColumns().addAll(questNumbCol, dependQuestNumbCol, weightCol);
        StackPane root = new StackPane();
        root.setPadding(new Insets(10));
        root.getChildren().add(table);
        Stage stage = new Stage();
        stage.setTitle("Table of dependencies");

        Scene scene = new Scene(root, 350, 250);
        stage.setScene(scene);
        stage.show();

    }

    public StringBuilder createRelations(List<Result> results, Result result, int testId, List<Test> tests){
        StringBuilder advise = new StringBuilder();
        AnsverService ansverService=new AnsverService();
        ResultAnsverService raService = new ResultAnsverService();
        resultAnsvers = raService.findBy(result.getResultId());

        if(result.getMark()<5 && result.getMark()>2)
        {
            advise.append("Test passed! \n");
            for(Question q: questions){
                int questIdIndex=0;
                for(int i=0; i<resultAnsvers.size(); i++){
                        if(resultAnsvers.get(i).getQuestionId()==q.getQuestionId()){
                            questIdIndex=i;
                        }
                }
                Ansver ansver=ansverService.findAnsverById(resultAnsvers.get(questIdIndex).getAnswerId());
                advise.append(chooseRelation(q, q.getQuestionId(), ansver, testId));
            }

        }else if(result.getMark()<=2){
            advise.append("Test NOT passed! \n");
            advise.append(createAdviseIfTestIsFailed(testId, tests));
        }else{
            advise.append("Test passed! \n");
        }

        return advise;
    }

    private StringBuilder createAdviseIfTestIsFailed(int testId, List<Test> tests){
        StringBuilder advise = new StringBuilder();
        TdependencyServie tdService = new TdependencyServie();
        testDependencies = tdService.findBy(testId);
        List<Test> adjacentTests= new ArrayList<>();//набор зависимых ответов
        TestService tserwice= new TestService();
        Test test= new Test();

        //заполняем набор зависимых ответов с помощью getDependencyId() каждого из набора зависимостей вопросов
        for(int i=0; i<testDependencies.size(); i++) {
            if (testDependencies.size() != 0) {
                adjacentTests.add(tserwice.findById(testDependencies.get(i).getDependencyOf()));
            }else{
                for(int j=0; j< tests.size(); j++){
                    if(tests.get(i).getTestId()==testId){
                        test=tests.get(i);
                    }
                }

                return  advise.append("You failed test! You NEED to learn this theme:" +  test.getTestName()
                        + "before writing this test!\n" + border + "\n");
            }
        }

        StringBuilder themes = new StringBuilder();
        for(Test t:adjacentTests){
            themes.append(t.getTestName()+"\n");
        }

        advise.append("You failed test! You NEED to learn other themes:" +  themes
                + "before writing this test!\n" + border + "\n");
        return advise;
    }

    private StringBuilder chooseRelation(Question q, int questionId, Ansver ansver, int testId){
        StringBuilder advise = new StringBuilder();
        QdependencyService depService = new QdependencyService();
        List<Qdependency> depends = depService.findBy(questionId);

         if(ansver.getAnswerTrue() == 1){
             if(depends.size()!=0){
                 advise.append(createAdviseIfAnswerOk(depends, q));
             }
         }else if(ansver.getAnswerTrue() == 0){
             if(depends.size()!=0){
                 advise.append(createAdviseIfWrongAnswer(depends, ansver, questionId, testId, q));
             }else{
                 advise.append("The answer for " + q.getQuestionText() + " is wrong!!! it was the easiest question, but You failed!!" +
                         " You need to learn all of this theme again.\n" + border + "\n");
             }
         }
        return advise;
    }

    private StringBuilder createAdviseIfAnswerOk(List<Qdependency> depends, Question q) {
        AnsverService ansverService=new AnsverService();
        StringBuilder advice = new StringBuilder();
        List<Ansver> adjacentAnsvers= new ArrayList<>();//набор зависимых ответов

        List<Integer> adjacentQuestionsIds= new ArrayList<>();
        for(int i=0; i<depends.size(); i++){
            adjacentQuestionsIds.add(depends.get(i).getDependenceOfId());
        }

        //заполняем набор зависимых ответов с помощью getDependencyId() каждого из набора зависимостей вопросов
        for(Integer qd:adjacentQuestionsIds) {

            adjacentAnsvers.add(ansverService.findAnsver(qd));

        }

        // показатель того, как справились со связанными заданиями = если справились - значит 1, отсюда показатель = 1+1+1...
        int result=adjacentAnsvers.size();
        //для набора вопросов, которые нужно перепройти
        StringBuilder efr=new StringBuilder();
        //в наборе ответов смотрим сколько правильных и заполняем показатель + собираем неправильные вопросы для Совета
        for(Ansver a:adjacentAnsvers){
            if(a.getAnswerTrue()==0) {
                result=result-1;

                int toFindQuestion = a.getQuestionId();
                int questionIndex=0;
                for(int i=0; i<questions.size(); i++){
                    if(questions.get(i).getQuestionId()==toFindQuestion){
                        questionIndex=i;
                    }
                }
                efr.append(questions.get(questionIndex).getQuestionText());
            }
        }
        //если в смежных ответах половина - ошибки, то тема изучена неполностью, нужно переучить
        if(result<adjacentAnsvers.size()){
            StringBuilder sb=efr;
            advice.append( "The answer for "+ q.getQuestionText() + " is ok, BUT adjacent questions are wrong. " +
                    "Please, pay Your attention to the questions: "+ sb +
                    " coz it seems like You don`t understand this theme completely\n" + border + "\n");
        }else{
            advice.append("The answer for "+ q.getQuestionText() + " is ok, You just need more practice. You can try again.\n" + border + "\n"); }
            return advice;
    }

    private StringBuilder createAdviseIfWrongAnswer(List<Qdependency> dependes, Ansver ansver, int questionId, int testId, Question q) {
        AnsverService ansverService=new AnsverService();
        EthalonService ethalonService=new EthalonService();
        List<Ansver> adjacentAnsvers= new ArrayList<>();//набор зависимых ответов

        List<Integer> adjacentQuestionsIds= new ArrayList<>();
        for(int i=0; i<dependes.size(); i++){
            adjacentQuestionsIds.add(dependes.get(i).getDependenceOfId());
        }

        //заполняем набор зависимых ответов с помощью getDependencyId() каждого из набора зависимостей вопросов
        for(Integer qd:adjacentQuestionsIds) {

            adjacentAnsvers.add(ansverService.findAnsver(qd));

        }
        // показатель того, как справились со связанными заданиями = если справились - значит 1, отсюда показатель = 1+1+1...
        int result=adjacentAnsvers.size();
        //для набора вопросов, которые нужно перепройти
        StringBuilder efr=new StringBuilder();
        //в наборе ответов смотрим сколько правильных и заполняем показатель + собираем текст вопросов для Совета
        for(Ansver a:adjacentAnsvers){
            if(a.getAnswerTrue()==0) {
                result=result-1;

                int toFindQuestion = a.getQuestionId();
                int questionIndex=0;
                for(int i=0; i<questions.size(); i++){
                    if(questions.get(i).getQuestionId()==toFindQuestion){
                        questionIndex=i;
                    }
                }
                efr.append(questions.get(questionIndex).getQuestionText());
            }
        }

        StringBuilder advice = new StringBuilder();

        ethalons = ethalonService.findBy(questionId);
        int maxComplexity = ethalonService.findMaxComplexity(testId);
        TestsEthalon ethalon= ethalons.get(0);

        if (ethalon.getComplexity() == maxComplexity && ethalon.getImportance()==3){

            //если в смежных ответах половина - ошибки, то тема не изучена и нужно переучить
            if(result<Math.ceil(adjacentAnsvers.size()/2)){

                System.out.println(Math.ceil(adjacentAnsvers.size()/2));
                advice.append("The answer for " + q.getQuestionText() + " is wrong but it was complicated, so You should try again!\n "
                        + "You failed also in adjacent Tests of one theme:" + efr +" \n" + border + "\n");
            }

        }else if(ethalon.getComplexity()<3 && ethalon.getImportance()>=3){
            //если в смежных ответах половина - ошибки, то тема не изучена и нужно переучить
            if(result<Math.ceil(adjacentAnsvers.size()/2)){
               String theme ="";
                for(Topic t:topics){
                    if(t.getTestId()==testId){
                        theme= t.getTopicName();
                    }
                }
                System.out.println(Math.ceil(adjacentAnsvers.size()/2));
                advice.append("The answer for "+ q.getQuestionText() + " is wrong!!! it was easy but You failed!! You need to learn all of this theme.\n "
                        + "You failed also in adjacent Tests:" + efr + " You need to repeat basics of theme"+ theme +"!!!\n" + border + "\n");
            }else{
                advice.append("The answer for "+ q.getQuestionText() +" is wrong!!! it was easy but You failed!! You need to learn this theme again.\n "
                        + "Adjacent Test`s Answers are ok:" + efr +"\n" + border + "\n");
            }
        }else if(ethalon.getComplexity()== maxComplexity && ethalon.getImportance()<2){
            advice.append("The answer for "+ q.getQuestionText() + " is wrong but it was complicated and not important\n" + border + "\n");
        }else if(ethalon.getComplexity()<3 && ethalon.getImportance()<2){
            advice.append("The answer for "+ q.getQuestionText() + " is wrong. It was easy to do but not important\n" + border + "\n");
        }
        return advice;
    }

    public int getCardId() {
        return cardId;
    }

    private void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getUserId() {
        return userId;
    }

    private void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    private void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<Qdependency> getDependencies() {
        return dependencies;
    }

    private void setDependencies(List<Qdependency> dependencies) {
        this.dependencies = dependencies;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    private void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getComplexity() {
        return complexity;
    }

    private void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public int getImportance() {
        return importance;
    }

    private void setImportance(int imp) {
        importance = imp;
    }
}
