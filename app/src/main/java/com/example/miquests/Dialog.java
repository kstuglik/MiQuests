package com.example.miquests;

import android.content.Context;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.NonNull;

import java.util.Random;

public class Dialog extends android.app.Dialog {

    private final TextView txvHint1;
    private final TextView txvHint2;
    private final TextView txvHint3;
    private final TextView txvHint4;
    private final TextView txvSurvayQuestion;

    public Dialog(@NonNull Context context, int i) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.audience_survey);
        txvHint1 = findViewById(R.id.txvHint1);
        txvHint2 = findViewById(R.id.txvHint2);
        txvHint3 = findViewById(R.id.txvHint3);
        txvHint4 = findViewById(R.id.txvHint4);


        Random r = new Random();
        int[] arrPercent = new int[]{0, 0, 0, 0};
        int low = 2;
        int medium = 60;
        int high = 100;
        int sum = 0;

        for (int j = 0; j < 4; j++) {
            if (j == i) arrPercent[j] += r.nextInt(high - medium) + medium;
            else arrPercent[j] += r.nextInt(high - low) + low;
            sum +=  arrPercent[j];
        }

        float f = 100.0f/sum;
        for (int j = 0; j < 4; j++) {
            arrPercent[j] *= f;
        }

        txvSurvayQuestion = findViewById(R.id.txvSurvayQuestion);
        txvSurvayQuestion.setText("CHANGE QUESTION");
        txvHint1.setText("A) \t\t" + arrPercent[0] + "%");
        txvHint2.setText("B) \t\t" + arrPercent[1]  + "%");
        txvHint3.setText("C) \t\t" + arrPercent[2]  + "%");
        txvHint4.setText("D) \t\t" + arrPercent[3]  + "%");

    }
}
