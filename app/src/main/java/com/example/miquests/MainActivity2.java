package com.example.miquests;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.miquests.adapter.DetailSCardAdapter;
import com.example.miquests.object.FaceData;
import com.example.miquests.object.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    View.OnClickListener listener;
    private boolean help50x50 = true;
    private ArrayList<String> arrayList;
    private Question question;
    private FaceData faceData;
    private ListView lsvDetails;
    private DetailSCardAdapter detailSCardAdapter;
    private TextView txvAnswer1;
    private TextView txvAnswer2;
    private TextView txvAnswer3;
    private TextView txvAnswer4;
    private TextView txvQuestion;
    private TextView txvDescription;
    private int currentPrize = 1;
    private ArrayList<TextView> arrTextView;
    private String answer;
    private ImageView img50x50;
    private boolean survay = true;
    private boolean restart=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();
        setVariables();
        setUp();
        setClick();
    }

    public void init() {
        question = new Question();
        arrTextView = new ArrayList<>();
        faceData = new FaceData();
        arrayList = new ArrayList<>();

        for (int i = 100; i < 2000000; i *= 2) {
            arrayList.add(String.valueOf(i));
        }
        Collections.reverse(arrayList);

        detailSCardAdapter = new DetailSCardAdapter(this, 0, arrayList);
    }

    public void addQuestion() {
//        question.setQuestion("My first question is about..? " + currentPrize);
//        question.setAnswer("a " + currentPrize);
//        ArrayList<String> arrWhat = new ArrayList<>();
//        arrWhat.add("b");
//        arrWhat.add("c");
//        arrWhat.add("d");
//        question.setArrData(arrWhat);
        question = faceData.questionMethod(currentPrize);
    }

    public void setQuestionInQuiz() {
        addQuestion();

        txvQuestion.setText(question.getQuestion());
        ArrayList<String> arrAnswers = new ArrayList<>(question.getArrData());
        arrAnswers.add(question.getAnswer());

        Collections.shuffle(arrAnswers);

//        txvAnswer1.setText(arrAnswers.get(0));
//        txvAnswer2.setText(arrAnswers.get(1));
//        txvAnswer3.setText(arrAnswers.get(2));
//        txvAnswer4.setText(arrAnswers.get(3));

        for (int i = 0; i < arrTextView.size(); i++) {
            arrTextView.get(i).setOnClickListener(listener);
            arrTextView.get(i).setVisibility(View.VISIBLE);
            arrTextView.get(i).setBackgroundResource(R.drawable.bg_btn);
            arrTextView.get(i).setText(arrAnswers.get(i));
        }

        detailSCardAdapter.setCurrentPrize(currentPrize);
    }

    public void setVariables() {
        lsvDetails = findViewById(R.id.lsvDetails);
        txvAnswer1 = findViewById(R.id.txvAnswer1);
        txvAnswer2 = findViewById(R.id.txvAnswer2);
        txvAnswer3 = findViewById(R.id.txvAnswer3);
        txvAnswer4 = findViewById(R.id.txvAnswer4);
        txvQuestion = findViewById(R.id.txvQuestion);
        txvDescription = findViewById(R.id.txvDescription);

        img50x50 = findViewById(R.id.img50x50);

        arrTextView.add(txvAnswer1);
        arrTextView.add(txvAnswer2);
        arrTextView.add(txvAnswer3);
        arrTextView.add(txvAnswer4);

    }

    public void setUp() {
        txvDescription.setVisibility(View.GONE);
        lsvDetails.setAdapter(detailSCardAdapter);

        setQuestionInQuiz();
    }

    public void setClick() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer((TextView) v);
            }
        };
//        txvAnswer1.setOnClickListener(listener);
//        txvAnswer2.setOnClickListener(listener);
//        txvAnswer3.setOnClickListener(listener);
//        txvAnswer4.setOnClickListener(listener);
        for (TextView tv : arrTextView) {
            tv.setOnClickListener(listener);
        }
    }

    public void checkAnswer(TextView txv) {
        answer = txv.getText().toString();
        txv.setBackgroundResource(R.drawable.bg_btn_click);
        new CountDownTimer(1000, 100) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                for (TextView tv : arrTextView) {
                    String s = tv.getText().toString();
                    if (s.equals(question.getAnswer())) {
                        tv.setBackgroundResource(R.drawable.bg_btn_succes);
                        break;
                    }
                }
                new CountDownTimer(1000, 100) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                    }

                    @Override
                    public void onFinish() {
                        String youWin;
                        int guaranteedPrize = (currentPrize / 5) * 5;
                        if (guaranteedPrize > 0) youWin = arrayList.get(15 - guaranteedPrize);
                        else youWin = "0";

                        if (answer.equals(question.getAnswer())) {
                            currentPrize++;
                            if (currentPrize > 15) {
                                currentPrize = 15;
                                txvDescription.setVisibility(View.VISIBLE);
                                txvDescription.setText("Eureko!!!\nYou win: $" + youWin);
                                txvDescription.setBackgroundColor(Color.parseColor("#FFFFB2"));
                                return;
                            }
                            setQuestionInQuiz();
                        } else {
                            txvDescription.setVisibility(View.VISIBLE);
                            txvDescription.setText("wrong answer :(\nYou win: $" + youWin);
                            txvDescription.setBackgroundColor(Color.parseColor("#dc6b52"));
//                            Toast.makeText(MainActivity2.this, "wrong answer :(", Toast.LENGTH_LONG).show();
                        }
                    }
                }.start();
            }
        }.start();

    }

    public void help50x50(View view) {
        if (!help50x50) {
            return;
        } else {
            Random r = new Random();

            for (int loop = 0, counter = 0; counter < 2; loop++) {
                int randomId = r.nextInt(4);
//                Toast.makeText(MainActivity2.this, "something gone wrong: "+randomId+", "+arrayList, Toast.LENGTH_LONG).show();
                TextView tv = arrTextView.get(randomId);
                if (!tv.getText().toString().equals(question.getAnswer()) && tv.getVisibility() == View.VISIBLE) {
                    tv.setVisibility(View.INVISIBLE);
                    tv.setOnClickListener(null);
                    img50x50.setColorFilter(Color.BLACK);
//                    img50x50.setColorFilter(Color.RED, PorterDuff.Mode.LIGHTEN);
                    counter++;
                }
            }
            help50x50 = false;
        }
    }

    public void Dialog(View view) {
        if (!survay) {
            return;
        } else {
            for (int i = 0; i < arrTextView.size(); i++) {
                TextView t = arrTextView.get(i);
                if (t.getText().toString().equals(question.getAnswer())) {
                    new Dialog(this, i).show();
                    break;
                }
            }
            survay = false;
        }
    }

    public void restart(View view) {
        if (!restart) {
            return;
        } else {
            setQuestionInQuiz();
        }
        restart = false;
    }
}