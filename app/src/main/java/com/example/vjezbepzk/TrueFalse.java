package com.example.vjezbepzk;

public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQ;

    public  TrueFalse(int q,boolean trueQ){
        mQuestion=q;
        mTrueQ=trueQ;
    }
    //getters
    public int getQuestion(){
        return mQuestion;
    }

    public boolean isTrueQuestion() {
        return mTrueQ;
    }
    //setters
    public void setQuestion(int Question) {
        this.mQuestion = Question;
    }

    public void setTrueQuestion(boolean TrueQ) {
        this.mTrueQ = TrueQ;
    }
}
