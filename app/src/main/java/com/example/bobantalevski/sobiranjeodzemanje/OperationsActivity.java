package com.example.bobantalevski.sobiranjeodzemanje;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class OperationsActivity extends AppCompatActivity {

    @BindView(R.id.firstOperandTextView) TextView firstOperandTextView;
    @BindView(R.id.secondOperandTextView) TextView secondOperandTextView;
    @BindView(R.id.operationSignTextView) TextView operationSignTextView;
    @BindView(R.id.feedBackTextView) TextView feedBackTextView;
    @BindView(R.id.operationResultEditText) EditText resultEditText;
    @BindView(R.id.newTaskButton) Button newTaskButton;

    int firstOperand;
    int secondOperand;

    // abstract methods
    abstract String getTitleForOperation();
    abstract int getFirstOperand();
    abstract int getSecondOperand(int firstOperand);
    abstract void setOperationSignTextView();
    abstract int getResultInt();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations);
        ButterKnife.bind(this);

        setTitle(getTitleForOperation());
        setOperationSignTextView();

        initializeOperands();

        resultEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((keyEvent != null && (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (i == EditorInfo.IME_ACTION_DONE)) {
                    processAnswer();
                }
                return false;
            }
        });

        newTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initializeOperands();
            }
        });
    }

    private void initializeOperands() {
        firstOperand = getFirstOperand();
        firstOperandTextView.setText(String.valueOf(firstOperand));
        firstOperandTextView.setTag(firstOperand);

        secondOperand = getSecondOperand(firstOperand);
        secondOperandTextView.setText(String.valueOf(secondOperand));
        secondOperandTextView.setTag(secondOperand);

        newTaskButton.setVisibility(View.INVISIBLE);
        feedBackTextView.setVisibility(View.INVISIBLE);
    }

    private void processAnswer() {
        // if input is empty we do nothing
        if (!resultEditText.getText().toString().equals("")) {
            feedBackTextView.setVisibility(View.VISIBLE);
            if (Integer.parseInt(resultEditText.getText().toString())
                    == getResultInt()) {
                feedBackTextView.setText(R.string.feedback_correct);
                feedBackTextView.setTextColor(Color.GREEN);
                newTaskButton.setVisibility(View.VISIBLE);
            } else {
                feedBackTextView.setText(R.string.feedback_wrong);
                feedBackTextView.setTextColor(Color.RED);
            }
            resultEditText.setText("");
        }
    }

}
