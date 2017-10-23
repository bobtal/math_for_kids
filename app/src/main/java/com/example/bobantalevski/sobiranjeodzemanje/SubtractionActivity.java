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

public class SubtractionActivity extends OperationsActivity {
    // The first operand of a subtraction operation is called minuend
    private static final int MIN_MINUEND = 5;
    private static final int MAX_MINUEND = 20;

    @Override
    String getTitleForOperation() {
        return getResources().getText(R.string.subtraction).toString();
    }

    int getFirstOperand() {
        Random random = new Random();
        return (MIN_MINUEND + random.nextInt(MAX_MINUEND - MIN_MINUEND + 1));
    }

    int getSecondOperand(int firstOperand) {
        Random random = new Random();
        return random.nextInt(firstOperand + 1);
    }

    @Override
    void setOperationSignTextView() {
        operationSignTextView.setText(R.string.minus_sign);
    }

    @Override
    int getResultInt() {
        return firstOperand - secondOperand;
    }
}
