/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.dht.quizapp;

import com.dht.pojo.Choice;
import com.dht.pojo.Question;
import com.dht.services.QuestionServices;
import com.dht.utils.JdbcConnector;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class PracticeController implements Initializable {

    @FXML private Text questionText;
    @FXML private VBox choicesContainer;
    private QuestionServices quesionService = new QuestionServices();
    private ToggleGroup choicesGroup;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choicesContainer.getChildren().clear();
        int rand = (int)(Math.random()*10);
        System.out.printf("%d",rand);
        rand = 9;
        Question q = quesionService.getQuestionById(rand);
        if (q != null){
            questionText.setText(q.getContent());
            for (Choice c : q.getChoices()) {
                HBox hbox = new HBox();
                RadioButton radioButton = new RadioButton();
                Text t = new Text(c.getContent());
                hbox.getChildren().addAll(radioButton, t);
                choicesContainer.getChildren().add(hbox);
            }
        }
        
    }    
    
}
