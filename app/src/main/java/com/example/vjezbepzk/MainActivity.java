package com.example.vjezbepzk;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button mTrueBtn;
    private Button mFalseBtn;
    private Button mNextBtn;
    private TextView mQTextView;

    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_oceans, true),
            new TrueFalse(R.string.question_mideast, false),
            new TrueFalse(R.string.question_africa, false),
            new TrueFalse(R.string.question_americas, true),
            new TrueFalse(R.string.question_asia, true),
    };
    private int mCurrentIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueBtn = (Button) findViewById(R.id.true_button);
        mFalseBtn = (Button) findViewById(R.id.false_button);
        mQTextView = (TextView) findViewById(R.id.question_text_view);

        int q = mQuestionBank[mCurrentIndex].getQuestion();
        mQTextView.setText(q);

        mNextBtn = (Button) findViewById(R.id.next_button);
        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;

                int question = mQuestionBank[mCurrentIndex].getQuestion();
                mQTextView.setText(question);
            }
        });


        mTrueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);

            }

        });

        mFalseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }

        });


    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.odg_tacan;
        } else {
            messageResId = R.string.odg_netacan;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();

    }
}
