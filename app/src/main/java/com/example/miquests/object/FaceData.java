package com.example.miquests.object;

import java.util.ArrayList;
import java.util.Random;

public class FaceData {
    private final ArrayList<Question> listArrayList = new ArrayList<>();

    public FaceData() {
        prepareALQ();
    }

    public Question questionMethod(int i) {
        Random r = new Random();
//        ArrayList<Question> arr = listArrayList.get(i - 1);
        return listArrayList.get(r.nextInt(listArrayList.size()));
//        int so1 = r.nextInt(100);
//        int so2 = r.nextInt(100);
//        int rightAnswer = so1 + so2;
//        String s = "(" + i + ")\t\t" + so1 + " + " + so2 + " = ?";
//        Question q = new Question();
//        q.setQuestion(s);
//        q.setAnswer("" + rightAnswer);
//        ArrayList<String> arrayList = new ArrayList<>();
//        for (int j = 0; j < 3; j++) {
//            int anotherAnswer = r.nextInt(200);
//            if (anotherAnswer != rightAnswer) {
//                arrayList.add(String.valueOf(anotherAnswer));
//            } else {
//                j--;
//            }
//        }
//        q.setArrData(arrayList);
//        return q;
    }

    public void prepareALQ() {
//        ArrayList<Question> qal = new ArrayList<>();
        listArrayList.add(prepareQ("Pytanie-1", "a", "b;c;d"));
        listArrayList.add(prepareQ("Pytanie-2", "aa", "bb;cc;dd"));
        listArrayList.add(prepareQ("Pytanie-3", "aaa", "bbb;ccc;ddd"));
        listArrayList.add(prepareQ("Pytanie-4", "aaaa", "bbbb;cccc;dddd"));
        listArrayList.add(prepareQ("Pytanie-5", "aaaaa", "bbbbb;ccccc;ddddd"));
        listArrayList.add(prepareQ("Pytanie-6", "a", "b;c;d"));
        listArrayList.add(prepareQ("Pytanie-7", "aa", "bb;cc;dd"));
        listArrayList.add(prepareQ("Pytanie-3", "aaa", "bbb;ccc;ddd"));
        listArrayList.add(prepareQ("Pytanie-9", "aaaa", "bbbb;cccc;dddd"));
        listArrayList.add(prepareQ("Pytanie-10", "aaaaa", "bbbbb;ccccc;ddddd"));
        listArrayList.add(prepareQ("Pytanie-11", "a", "b;c;d"));
        listArrayList.add(prepareQ("Pytanie-12", "aa", "bb;cc;dd"));
        listArrayList.add(prepareQ("Pytanie-13", "aaa", "bbb;ccc;ddd"));
        listArrayList.add(prepareQ("Pytanie-14", "aaaa", "bbbb;cccc;dddd"));
        listArrayList.add(prepareQ("Pytanie-15", "aaaaa", "bbbbb;ccccc;ddddd"));
    }

    private Question prepareQ(String s1, String s2, String s3) {
        Question q = new Question();
        q.setQuestion(s1);
        q.setAnswer(s2);
        q.setArrData(s3);
        return q;
    }
}
