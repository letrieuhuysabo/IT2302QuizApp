/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.utils.AbstractFactory;

import com.dht.quizapp.App;
import javafx.scene.Scene;
import com.dht.utils.Theme;
import com.dht.utils.ThemeManager;
/**
 *
 * @author admin
 */
public class DefaultThemeFactory implements ThemeFactory{

    @Override
    public String getTheme() {
        
        return App.class.getResource("styles.css").toExternalForm();
    }
    
}
