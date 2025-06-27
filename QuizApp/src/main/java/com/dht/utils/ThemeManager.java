/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.utils;

import com.dht.quizapp.App;
import com.dht.utils.AbstractFactory.DefaultThemeFactory;
import com.dht.utils.AbstractFactory.ThemeFactory;
import javafx.scene.Scene;

/**
 *
 * @author admin
 */
public class ThemeManager {

    private static ThemeManager instance;
    private ThemeFactory themeFactoty = new DefaultThemeFactory();
    private ThemeManager() {

    }
    public void setThemeFactory(ThemeFactory tf){
        themeFactoty = tf;
    }
    public static ThemeManager getInstance() {
        if (instance == null) {
            instance = new ThemeManager();
        }
        return instance;
    }

    public void applyTheme(Scene scene) {
        scene.getRoot().getStylesheets().clear();
        scene.getRoot().getStylesheets().add(themeFactoty.getTheme());
    }
}
