package com.example.miquests.object;

import java.util.ArrayList;

public class Question {
    private String quest, answer;
    private ArrayList<String> arrData;

    public String getQuestion() {
        return quest;
    }

    public void setQuestion(String quest) {
        this.quest = quest;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ArrayList<String> getArrData() {
        return arrData;
    }

    public void setArrData(ArrayList<String> arrData) {
        this.arrData = arrData;
    }

    public void setArrData(String string) {//q1;q2;q3;q4
        String arrS[] = string.split(";");
        this.arrData = new ArrayList<>();
        for(String s:arrS){
            this.arrData.add(s);
        }
    }
}
