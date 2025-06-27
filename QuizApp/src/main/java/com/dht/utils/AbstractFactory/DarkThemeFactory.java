/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.utils.AbstractFactory;

import com.dht.quizapp.App;
import com.dht.utils.Theme;

/**
 *
 * @author admin
 */
public class DarkThemeFactory implements ThemeFactory{

    @Override
    public String getTheme() {
        return App.class.getResource("dark.css").toExternalForm();
    }
    
}
