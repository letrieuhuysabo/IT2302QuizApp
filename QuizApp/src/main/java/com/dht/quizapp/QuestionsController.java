/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.dht.quizapp;

import com.dht.pojo.Category;
import com.dht.pojo.Level;
import com.dht.services.CategoryServices;
import com.dht.services.LevelService;
import com.dht.utils.JdbcConnector;
import com.dht.utils.ThemeManager;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionsController implements Initializable {
    @FXML private ComboBox<Category> cbCates;
    @FXML private ComboBox<Level> cbLevels;
    @FXML private VBox questionContainer;
    private final static CategoryServices cateServices = new CategoryServices();
    private final static LevelService levelService = new LevelService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        System.out.println(cbCates.getScene() == null);
//        ThemeManager.getInstance().applyTheme();
        try {
            this.cbCates.setItems(FXCollections.observableList(cateServices.getCates()));
            this.cbLevels.setItems(FXCollections.observableList(levelService.getLevels()));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void addQuestions(ActionEvent event){
        HBox hb = new HBox();
        hb.getStyleClass().add("Main");
        RadioButton rb = new RadioButton();
        TextField tf = new TextField();
//        tf.getStyleClass().add("Main")
        hb.getChildren().add(rb);
        hb.getChildren().add(tf);
        questionContainer.getChildren().add(hb);
        
    }
}
