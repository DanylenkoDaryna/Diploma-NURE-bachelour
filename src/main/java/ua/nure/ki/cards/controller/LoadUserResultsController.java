package ua.nure.ki.cards.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ua.nure.ki.cards.cognitive.CognitiveCard;
import ua.nure.ki.cards.data.*;
import ua.nure.ki.cards.service.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;

public class LoadUserResultsController {

    private TestSystem ts = new TestSystem();

    private List<GroupCategory> groupCategoriesFxml = new ArrayList<>();
    private List<Group> groupsFxml = new ArrayList<>();
    private List<User> usersFxml = new ArrayList<>();
    private List<TestCategory> testCategoriesFxml = new ArrayList<>();
    private List<Test> testsFxml = new ArrayList<>();
    private List<Result> resultsFxml = new ArrayList<>();

    private int groupId =0;
    private int userId=0;
    private int testId=0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuBar menu_bar2;

    @FXML
    private MenuItem File_Generate;

    @FXML
    private MenuItem File_Clear;

    @FXML
    private MenuItem File_Return;

    @FXML
    private MenuItem Help_about;

    @FXML
    private MenuItem Help_close;

    @FXML
    private Label label_Creator;

    @FXML
    private ChoiceBox<GroupCategory> choicebox_GroupCategory;

    @FXML
    private Label label_title;

    @FXML
    private Button button_dialog;

    @FXML
    private ChoiceBox<Group> choicebox_Group;

    @FXML
    private ChoiceBox<User> choicebox_User;

    @FXML
    private ChoiceBox<TestCategory> choicebox_TestCategory;

    @FXML
    private ChoiceBox<Test> choicebox_Test;

    @FXML
    private ChoiceBox<Result> choicebox_Result;

    @FXML
    private Label label_GroupCategory;

    @FXML
    private Label label_Group;

    @FXML
    private Label label_User;

    @FXML
    private Label label_TestCategory;

    @FXML
    private Label label_Test;

    @FXML
    private Label label_Result;

    @FXML
    private TextArea res_Out;

    @FXML
    private LineChart<Number,Number> results_chart;

    @FXML
    private NumberAxis x;

    @FXML
    private NumberAxis y;


    GridPane matrix = new GridPane();
    Scene matrixScene;

    @FXML
    void closeAction(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void helpAbout(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/about.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = fxmlLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root,525, 340));
        stage.show();
    }

    @FXML
    void findTestAction(ActionEvent event) {

    }

    @FXML
    void goInMainWindow(ActionEvent event) {

        menu_bar2.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/sample.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = fxmlLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root,1100, 600));
        Image windIcon=new Image("/images/icon3.png");
        stage.getIcons().add(windIcon);
        stage.setTitle("- - - TestSystem - - -");
        stage.show();

    }

    @FXML
    void generateCard(ActionEvent event) {

        CognitiveCard cognitiveCard = new CognitiveCard();
        cognitiveCard.getDataToGenerateCard(testId);


        ////////////////////////////////////////////////////////////////////////////////////
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(getClass().getResource("/fxml/CognitiveCard.fxml"));
//        try {
//            fxmlLoader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Parent root = fxmlLoader.getRoot();
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root,800, 500));
//        Image windIcon=new Image("/images/icon3.png");
//        stage.getIcons().add(windIcon);
//        stage.setTitle("- - - TestSystem - - -");
//        stage.show();
    }

    @FXML
    void gotItButton(ActionEvent press) {

        choicebox_GroupCategory.setDisable(false);
        label_GroupCategory.setDisable(false);

        GroupCategoryService gcs= new GroupCategoryService();
        groupCategoriesFxml=gcs.findAll();
        ts.setSysGroupCategories(groupCategoriesFxml);
        for(int i =0; i<ts.getSysGroupCategories().size(); i++) {
            choicebox_GroupCategory.getItems().add(ts.getSysGroupCategories().get(i));
        }
    }

    @FXML
    void initialize() {

        choicebox_GroupCategory.setOnAction(event -> {
            choicebox_Group.setDisable(false);
            label_Group.setDisable(false);
            GroupCategory gc= choicebox_GroupCategory.getValue();
            GroupService gs= new GroupService();

            for(int i=0; i<ts.getSysGroupCategories().size(); i++){
                if(ts.getSysGroupCategories().get(i).getGrCategId()==gc.getGrCategId()){
                    groupsFxml=gs.findAllbyId(gc.getGrCategId());
                    ts.getSysGroupCategories().get(i).setGroups(groupsFxml);
                }
            }

            for(int i=0; i<groupsFxml.size(); i++) {
                choicebox_Group.getItems().add(groupsFxml.get(i));
            }
        });

        choicebox_Group.setOnAction(event -> {
            choicebox_User.setDisable(false);
            label_User.setDisable(false);
            Group group= choicebox_Group.getValue();
            groupId=group.getGroupId();
            UserService service= new UserService();

            for(int i=0; i<groupsFxml.size(); i++){
                if(groupsFxml.get(i).getGroupId()==groupId){
                    usersFxml=service.findAllbyId(groupId);

                }
            }

            for(int i=0; i<usersFxml.size(); i++) {
                choicebox_User.getItems().add(usersFxml.get(i));
            }
        });

        choicebox_User.setOnAction(event -> {
            choicebox_TestCategory.setDisable(false);
            label_TestCategory.setDisable(false);
            User user=choicebox_User.getValue();
            userId=user.getUserId();
            TestCategoryService service= new TestCategoryService();
            testCategoriesFxml=service.findAll();
            ts.setSysTestCategories(testCategoriesFxml);
            for(int i =0; i<ts.getSysTestCategories().size(); i++) {
                choicebox_TestCategory.getItems().add(ts.getSysTestCategories().get(i));
            }
        });

        choicebox_TestCategory.setOnAction(event -> {
            choicebox_Test.setDisable(false);
            label_Test.setDisable(false);
            TestCategory testCategory= choicebox_TestCategory.getValue();
            TestService service= new TestService();

            for(int i=0; i<testCategoriesFxml.size(); i++){
                if(testCategoriesFxml.get(i).getTestCategId()==testCategory.getTestCategId()){
                    testsFxml=service.findAllbyId(testCategory.getTestCategId());
                }
            }

            for(int i=0; i<testsFxml.size(); i++) {
                choicebox_Test.getItems().add(testsFxml.get(i));
            }
        });

        choicebox_Test.setOnAction(event -> {
            choicebox_Result.setDisable(false);
            label_Result.setDisable(false);
            Test test = choicebox_Test.getValue();
            testId=test.getTestId();
            ResultService service = new ResultService();

            for(int i=0; i<testsFxml.size(); i++){
                if(testsFxml.get(i).getTestId()==testId){
                    resultsFxml = service.findAllby(groupId, userId, testId);
                }
            }

            for(int i=0; i<resultsFxml.size(); i++) {
                choicebox_Result.getItems().add(resultsFxml.get(i));
            }

            XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
            series1.setName("Your marks");
            for(int i=0; i<resultsFxml.size(); i++) {
                int a0 = i+1;
                int b0 = resultsFxml.get(i).getMark();
                Integer a1 = new Integer(a0);
                Integer b1 = new Integer(b0);
                Number a2 = (Number)a1;
                Number b2 = (Number)b1;
                series1.getData().add(new XYChart.Data<>(a2, b2));
            }
            results_chart.getData().add(series1);

        });


        choicebox_Result.setOnAction(event -> {
            Result result = choicebox_Result.getValue();
           // resultsFxml
                    res_Out.appendText("Result \n" + "Your mark is " +
                            result.getMark() + "\n" +
                            "In percents" + result.getPercent() + "\n" +
                            "Testing time  is " + result.getTimeOfTest() + "\n"

                    );

        });


    }
}