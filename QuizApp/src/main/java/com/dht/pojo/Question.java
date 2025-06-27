/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
/**
 *
 * @author admin
 */
public class Question {

    private int id;
    private String content, hint, image;
    List<Choice> choices = new ArrayList<>();

    public Question(QuestionBuilder builder) {
        this.id = builder.id;
        this.content = builder.content;
        this.image = builder.image;
        this.choices = builder.choices;
    }

    public static class QuestionBuilder {

        private int id;
        private String content, hint, image;
        List<Choice> choices = new ArrayList<>();
        public QuestionBuilder(int i, String c){
            this.id = i;
            this.content = c;
        }
        public QuestionBuilder hint(String s){
            this.hint = s;
            return this;
        }
        public QuestionBuilder image(String s){
            this.image = s;
            return this;
        }
        public QuestionBuilder choice(Choice... chs){
            this.choices.addAll(Arrays.asList(chs));
            return this;
        }
        public Question build(){
            return new Question(this);
        }
    }
}
