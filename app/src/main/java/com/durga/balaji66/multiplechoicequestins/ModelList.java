package com.durga.balaji66.multiplechoicequestins;

public class ModelList {
    private String mQuestion;
    private String mOption_A;
    private String mOption_B;
    private String mOption_C;
    private String mOption_D;
    private int mCount;



    ModelList ()
    {

    }

    @Override
    public String toString() {
        return "ModelList{" +
                "mQuestion='" + mQuestion + '\'' +
                ", mOption_A='" + mOption_A + '\'' +
                ", mOption_B='" + mOption_B + '\'' +
                ", mOption_C='" + mOption_C + '\'' +
                ", mOption_D='" + mOption_D + '\'' +
                ", mAnswer='" + mAnswer + '\'' +
                '}';
    }

    public int getmCount() {
        return mCount;
    }

    public void setmCount(int mCount) {
        this.mCount = mCount;
    }

    public String getmQuestion() {
        return mQuestion;
    }

    public void setmQuestion(String mQuestion) {
        this.mQuestion = mQuestion;
    }

    public String getmOption_A() {
        return mOption_A;
    }

    public void setmOption_A(String mOption_A) {
        this.mOption_A = mOption_A;
    }

    public String getmOption_B() {
        return mOption_B;
    }

    public void setmOption_B(String mOption_B) {
        this.mOption_B = mOption_B;
    }

    public String getmOption_C() {
        return mOption_C;
    }

    public void setmOption_C(String mOption_C) {
        this.mOption_C = mOption_C;
    }

    public String getmOption_D() {
        return mOption_D;
    }

    public void setmOption_D(String mOption_D) {
        this.mOption_D = mOption_D;
    }

    public String getmAnswer() {
        return mAnswer;
    }

    public void setmAnswer(String mAnswer) {
        this.mAnswer = mAnswer;
    }

    private String mAnswer;

    ModelList(String mQuestion, String mOption_A, String mOption_B, String mOption_C, String mOption_D,String mAnswer)
    {
        this.mQuestion =mQuestion;
        this.mOption_A =mOption_A;
        this.mOption_B = mOption_B;
        this.mOption_C = mOption_C;
        this.mOption_D = mOption_D;
        this.mAnswer = mAnswer;
    }
    ModelList (int mCount)
    {
        this.mCount =mCount;
    }
}
