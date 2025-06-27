package com.dht.quizapp;

import com.dht.utils.AbstractFactory.DefaultThemeFactory;
import com.dht.utils.AbstractFactory.LightThemeFactory;
import com.dht.utils.MyAlert;
import com.dht.utils.MyStage;
import com.dht.utils.Theme;
import static com.dht.utils.Theme.DEFAULT;
import com.dht.utils.ThemeManager;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;


public class PrimaryController implements Initializable{
    @FXML private ComboBox<Theme> cbTheme;
    public void handleQuestionManagement(ActionEvent event) throws IOException {
        MyStage.getInstance().showScene("questions.fxml");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Theme t = Theme.DEFAULT;
//        System.out.println(FXCollections.observableArrayList(Theme.values()));
//        cbTheme.setSelectionModel(Theme.DEFAULT);
        cbTheme.setItems(FXCollections.observableArrayList(Theme.values()));
//        cbTheme.
    }
    public void changeTheme(ActionEvent event){
        Theme t = cbTheme.getSelectionModel().getSelectedItem();
        t.applyTheme();
        ThemeManager tm = ThemeManager.getInstance();
//        tm.setThemeFactory(new LightThemeFactory());
        tm.applyTheme(cbTheme.getScene());
    }
    public void handlePractice(ActionEvent event) {
        MyAlert.getInstance().showMsg("Comming soon...");
    }
    
    public void handleExam(ActionEvent event) {
        MyAlert.getInstance().showMsg("Comming soon...");
    }
    
    public void handleRegister(ActionEvent event) {
        MyAlert.getInstance().showMsg("Comming soon...");
    }
    
    public void handleLogin(ActionEvent event) {
        MyAlert.getInstance().showMsg("Comming soon...");
    }

    
}
