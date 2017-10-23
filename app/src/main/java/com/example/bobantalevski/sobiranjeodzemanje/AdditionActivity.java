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

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdditionActivity extends OperationsActivity {

    private static final int MAX_ADDITION_RESULT = 20;

    @Override
    String getTitleForOperation() {
        return getResources().getText(R.string.addition).toString();
    }

    int getFirstOperand() {
        Random random = new Random();
        return random.nextInt(MAX_ADDITION_RESULT - 1);
    }

    int getSecondOperand(int firstOperand) {
        Random random = new Random();
        return random.nextInt(MAX_ADDITION_RESULT - firstOperand);
    }

    @Override
    void setOperationSignTextView() {
        operationSignTextView.setText(R.string.plus_sign);
    }

    @Override
    int getResultInt() {
        return firstOperand + secondOperand;
    }
}
