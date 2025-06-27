/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.utils;

import com.dht.quizapp.App;
import com.dht.utils.AbstractFactory.DarkThemeFactory;
import com.dht.utils.AbstractFactory.DefaultThemeFactory;
import com.dht.utils.AbstractFactory.LightThemeFactory;
import javafx.scene.Scene;

/**
 *
 * @author admin
 */
public enum Theme {
    DEFAULT {
        @Override
        public void applyTheme() {
            ThemeManager tm = ThemeManager.getInstance();
            tm.setThemeFactory(new DefaultThemeFactory());
            
        }
    }, DARK {
        @Override
        public void applyTheme() {
            ThemeManager tm = ThemeManager.getInstance();
            tm.setThemeFactory(new DarkThemeFactory());
            
        }
    }, LIGHT {
        @Override
        public void applyTheme() {
            ThemeManager tm = ThemeManager.getInstance();
            tm.setThemeFactory(new LightThemeFactory());
            
        }
    };

    public abstract void applyTheme();
}
