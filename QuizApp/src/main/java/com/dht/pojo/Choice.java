/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.pojo;

/**
 *
 * @author admin
 */
public class Choice {
    private int id;
    String content, isCorrect;

    public Choice(int id, String content, String isCorrect) {
        this.id = id;
        this.content = content;
        this.isCorrect = isCorrect;
    }
    public Choice(String content, String isCorrect) {
        this.content = content;
        this.isCorrect = isCorrect;
    }
}
