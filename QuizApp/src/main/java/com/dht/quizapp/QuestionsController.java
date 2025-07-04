/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.dht.quizapp;

import com.dht.pojo.Category;
import com.dht.pojo.Choice;
import com.dht.pojo.Level;
import com.dht.pojo.Question;
import com.dht.services.CategoryServices;
import com.dht.services.LevelServices;
import com.dht.services.QuestionServices;
import com.dht.utils.JdbcConnector;
import com.dht.utils.MyAlert;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionsController implements Initializable {
    @FXML private TextArea txtContent;
    @FXML private ComboBox<Category> cbCates;
    @FXML private ComboBox<Level> cbLevels;
    @FXML private VBox vboxChoices;
    @FXML private TableView<Question> tbQuestions;
    @FXML private TextField searchTextField;
    @FXML private ToggleGroup toggleChoice;
    
    private final static CategoryServices cateServices = new CategoryServices();
    private final static LevelServices levelServices = new LevelServices();
    private final static QuestionServices questionServices = new QuestionServices();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.cbCates.setItems(FXCollections.observableList(cateServices.getCates()));
            this.cbLevels.setItems(FXCollections.observableList(levelServices.getLevels()));
            loadTbQuestionsColumn();
            loadQuestions(questionServices.getQuestions());
            this.searchTextField.textProperty().addListener((e) -> {
                try {
                    loadQuestions(questionServices.getQuestions(searchTextField.getText()));
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionsController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            });
        } catch (SQLException ex) {
        }
    }  
    public void loadQuestions(List <Question> ques) throws SQLException{
        this.tbQuestions.setItems(FXCollections.observableList(ques));
    }
    public void addChoice(ActionEvent event) {
        HBox h = new HBox();
        h.getStyleClass().add("Main");
        
        RadioButton r = new RadioButton();
        r.setToggleGroup(toggleChoice);
        
        TextField txt = new TextField();
        txt.getStyleClass().add("Input");
        h.getChildren().addAll(r, txt);
        
        this.vboxChoices.getChildren().add(h);
    }
    
    public void addQuestion(ActionEvent event) {
        try {
            Question.Builder b = new Question.Builder(this.txtContent.getText(),
                    this.cbCates.getSelectionModel().getSelectedItem(),
                    this.cbLevels.getSelectionModel().getSelectedItem());
            
            for (var c: this.vboxChoices.getChildren()) {
                HBox h = (HBox) c;
                
                Choice choice = new Choice(((TextField)h.getChildren().get(1)).getText(), 
                            ((RadioButton)h.getChildren().get(0)).isSelected());
                b.addChoice(choice);
            }
            
            questionServices.addQuestion(b.build());
            
            MyAlert.getInstance().showMsg("Thêm câu hỏi thành công!");
            this.tbQuestions.getItems().add(b.build());
            
        } catch (SQLException ex) {
            MyAlert.getInstance().showMsg("Thêm câu hỏi thất bại!");
        } catch (Exception ex) {
            MyAlert.getInstance().showMsg("Dữ liệu không hợp lệ!");
        }
        
    }
    public void loadTbQuestionsColumn(){
        TableColumn tcId = new TableColumn("Id");
        tcId.setCellValueFactory(new PropertyValueFactory("id"));
        tcId.setPrefWidth(100);
        
        TableColumn tcContent = new TableColumn("Content");
        tcContent.setCellValueFactory(new PropertyValueFactory("content"));
        tcContent.setPrefWidth(200);
        
        TableColumn tcDel = new TableColumn();
//        tcDel.setCellFactory((p) -> {
//            return null;
//        });
        this.tbQuestions.getColumns().addAll(tcId,tcContent,tcDel);
    }
    public void deleteQuestion(int questionId) throws SQLException{
        if (questionServices.deleteQuestion(questionId)){
            MyAlert.getInstance().showMsg("Xóa dữ liệu thành công", Alert.AlertType.WARNING);
        }
        else {
            MyAlert.getInstance().showMsg("Xóa dữ liệu thất bại", Alert.AlertType.WARNING);
        }
    }
    public void test() throws SQLException{
        deleteQuestion(Integer.parseInt(searchTextField.getText()));
    }
    
}
