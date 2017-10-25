package com.example.bobantalevski.sobiranjeodzemanje;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MultiplicationActivity extends OperationsActivity {

    private static final int MIN_OPERAND = 2;
    private static final int MAX_OPERAND = 10;

    @Override
    String getTitleForOperation() {
        return getResources().getString(R.string.multiplication);
    }

    @Override
    int getFirstOperand() {
        Random random = new Random();
        return random.nextInt(MAX_OPERAND - MIN_OPERAND + 1) + MIN_OPERAND;
    }

    @Override
    int getSecondOperand(int firstOperand) {
        Random random = new Random();
        return random.nextInt(MAX_OPERAND - MIN_OPERAND + 1) + MIN_OPERAND;
    }

    @Override
    void setOperationSignTextView() {
        operationSignTextView.setText(R.string.multiplication_sign);
    }

    @Override
    int getResultInt() {
        return firstOperand * secondOperand;
    }

}
