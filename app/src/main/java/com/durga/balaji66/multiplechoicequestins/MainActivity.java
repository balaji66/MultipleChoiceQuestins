package com.durga.balaji66.multiplechoicequestins;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private TextView mQuestion, mA, mB, mC, mD;
    private Button mNext, mSubmit;
    //This list is for storing the Static array list items.
    public List<ModelList> defaultList = new ArrayList<>();;
    //This list is for storing the Answered questions.
    public static List<ModelList> resultList =new ArrayList<>();
    public int count=0;
    public int mAnswerCount;
    //This list for storing the correct answers count.
    public List<ModelList> countList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeListeners();
        count=1;
        mAnswerCount=0;
        resultList.clear();
        countList.clear();
        addItemsToDefaultList();
        //Here we are loading the first record from the list At the time of onCreate.
        ModelList item =defaultList.get(0);
        mQuestion.setText(item.getmQuestion());
        mA.setText(item.getmOption_A());
        mB.setText(item.getmOption_B());
        mC.setText(item.getmOption_C());
        mD.setText(item.getmOption_D());
    }
    public void initializeViews() {
        mQuestion =findViewById(R.id.textViewQuestion);
        mA =findViewById(R.id.textViewOptionA);
        mB =findViewById(R.id.textViewOptionB);
        mC =findViewById(R.id.textViewOptionC);
        mD =findViewById(R.id.textViewOptionD);
        mNext =findViewById(R.id.buttonNext);
        mSubmit = findViewById(R.id.buttonSubmit);
    }
    public void initializeListeners() {
        mNext.setOnClickListener(this);
        mSubmit.setOnClickListener(this);
        mA.setOnClickListener(this);
        mB.setOnClickListener(this);
        mC.setOnClickListener(this);
        mD.setOnClickListener(this);
    }

    /**
     * This method is for adding the static items to array list.
     */
    public void addItemsToDefaultList() {
        defaultList.add(0, new ModelList("Whats Your Country ?","India","US", "Japan","China","India"));
        defaultList.add(1, new ModelList("Whats Your State ?","Karnataka ","Andhra Pradesh", "Maharastra","Kerala","Andhra Pradesh"));
        defaultList.add(2, new ModelList("Whats Your Qualification ?","BCA","BSC", "CA","MCA","MCA"));
        defaultList.add(3, new ModelList("Whats Your Mother Tongue ?","Kanada ","Telugu", "Tamil","Bhojpuri","Telugu"));
        defaultList.add(4, new ModelList("Whats Your Mother Tongue ?","Telugu ","Kanada", "Tamil","Bhojpuri","Kanada"));

    }
    public void showQuestions()
    {
        int size  =defaultList.size();
            for(int i=1; i<size && count<size; i++)
            {
                if(count == size-1)
                {
                    mSubmit.setVisibility(View.VISIBLE);
                    mNext.setVisibility(View.GONE);
                }
                ModelList item =defaultList.get(count);
                mQuestion.setText(item.getmQuestion());
                mA.setText(item.getmOption_A());
                mB.setText(item.getmOption_B());
                mC.setText(item.getmOption_C());
                mD.setText(item.getmOption_D());

            }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            //This case is for showing the next question.
            case R.id.buttonNext:
                ModelList list =new ModelList();
                list.setmQuestion(mQuestion.getText().toString());
                list.setmOption_A("");
                list.setmOption_B("");
                list.setmOption_C("");
                list.setmOption_D("");
                if(mAnswerCount == 1)
                {

                    list.setmAnswer(mA.getText().toString());
                    resultList.add(list);
                }
                else if(mAnswerCount == 2)
                {
                    //list.setmQuestion(mQuestion.getText().toString());
                    list.setmAnswer(mB.getText().toString());
                    resultList.add(list);
                }
                else if(mAnswerCount == 3)
                {
                    //list.setmQuestion(mQuestion.getText().toString());
                    list.setmAnswer(mC.getText().toString());
                    resultList.add(list);
                }
                else if(mAnswerCount == 4)
                {
                    //list.setmQuestion(mQuestion.getText().toString());
                    list.setmAnswer(mD.getText().toString());
                    resultList.add(list);
                }

                mAnswerCount=0;
                showQuestions();
                count=count +1;
                mA.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));
                mB.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));
                mC.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));
                mD.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));

                break;
                //This case is for calculating the result.
            case R.id.buttonSubmit:
                ModelList list1 =new ModelList();
                list1.setmQuestion(mQuestion.getText().toString());
                list1.setmOption_A("");
                list1.setmOption_B("");
                list1.setmOption_C("");
                list1.setmOption_D("");
                if(mAnswerCount == 1)
                {
                    list1.setmAnswer(mA.getText().toString());
                    resultList.add(list1);
                }
                else if(mAnswerCount == 2)
                {

                    list1.setmAnswer(mB.getText().toString());
                    resultList.add(list1);
                }
                else if(mAnswerCount == 3)
                {

                    list1.setmAnswer(mC.getText().toString());
                    resultList.add(list1);
                }
                else if(mAnswerCount == 4)
                {

                    list1.setmAnswer(mD.getText().toString());
                    resultList.add(list1);
                }

                //Toast.makeText(getApplicationContext(),resultList.toString(),Toast.LENGTH_LONG).show();
                mAnswerCount=0;
                showQuestions();
                count=count +1;
                mA.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));
                mB.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));
                mC.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));
                mD.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));

                //Here we are comparing the two lists.
                //Whether selected answers are correct or not we are comparing here.
                for(ModelList user1 : defaultList) {
                    for(ModelList user2 : resultList) {
                        if(user1.getmQuestion().equals(user2.getmQuestion())) {
                            if(user1.getmAnswer().equals(user2.getmAnswer())) {
                                    ModelList finalListSize =new ModelList();
                                    finalListSize.setmCount(1);
                                countList.add(finalListSize);
                            }
                        }
                    }
                }
              final  AlertDialog.Builder builder =new AlertDialog.Builder(this);
                builder.setTitle("Result is");
                builder.setCancelable(false);
                builder.setMessage("Correct Answers:- "+String.valueOf(countList.size())+"\n"+ " Wrong Answers:- "+ String.valueOf(defaultList.size()- countList.size())+ "\n Percentage is :- " + String.valueOf((countList.size()*100)/defaultList.size()));
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(intent);
                        mNext.setVisibility(View.VISIBLE);
                        mSubmit.setVisibility(View.GONE);
                        mQuestion.setText("");
                        mA.setText("");
                        mB.setText("");
                        mC.setText("");
                        mD.setText("");
                        finish();
                    }
                });
                builder.show();
                break;

                //Here we are showing selected answering the white color remaining all are same color.
                // For knowing the selected answer we are maintaining the mAnswerCount.
                //mAnswerCount is default value is 0.
            case R.id.textViewOptionA:
                mAnswerCount =1;
                mA.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                mB.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));
                mC.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));
                mD.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));
                break;
            case R.id.textViewOptionB:
                mAnswerCount=2;
                mA.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));
                mB.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                mC.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));
                mD.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));
                break;
            case R.id.textViewOptionC:
                mAnswerCount=3;
                mA.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));
                mB.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));
                mC.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                mD.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));
                break;
            case R.id.textViewOptionD:
                mAnswerCount =4;
                mA.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));
                mB.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));
                mC.setBackgroundColor(getResources().getColor(R.color.colorLiteBlue));
                mD.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                break;
        }
    }
}
