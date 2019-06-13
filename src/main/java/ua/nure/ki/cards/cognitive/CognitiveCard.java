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
import ua.nure.ki.cards.data.Qdependency;
import ua.nure.ki.cards.data.Question;
import ua.nure.ki.cards.data.Topic;
import ua.nure.ki.cards.service.QdependencyService;
import ua.nure.ki.cards.service.QuestionService;
import ua.nure.ki.cards.service.TopicService;


import java.util.ArrayList;
import java.util.List;

public class CognitiveCard {

    private int cardId;
    private int userId;
    private List<Topic> topics = new ArrayList<>(1);
    private List<Qdependency> dependencies = new ArrayList<>();
    private List<Question> questions = new ArrayList<>();

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
