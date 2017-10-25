package com.example.bobantalevski.sobiranjeodzemanje;

import java.util.ArrayList;
import java.util.Random;

public class DivisionActivity extends OperationsActivity {

    private static final int MAX_DIVIDEND = 100;
    private static final int MIN_DIVIDEND = 10;

    @Override
    String getTitleForOperation() {
        return getResources().getString(R.string.division);
    }

    // need to get a composite number to avoid very simple tasks of dividing a number
    // with itself or with 1
    @Override
    int getFirstOperand() {
        Random random = new Random();
        int randomNumber;
        do {
            randomNumber = random.nextInt(MAX_DIVIDEND - MIN_DIVIDEND + 1) + MIN_DIVIDEND;
        }
        while (!isComposite(randomNumber));
        return randomNumber;
    }

    // returns true if x is a composite number, false otherwise (if it's prime)
    private boolean isComposite(int x) {
        // x shouldn't really be in the range 1-3, but check this just in case
        if (x == 1 || x == 2 || x == 3) {
            return false;
        }

        // loop starting at 2 up to (inclusive) the square root + 1 and if we encounter
        // even one divider return true as the number is composite
        for (int i = 2; i <= Math.sqrt(x) + 1; i++) {
            if (x % i == 0) {
                return true;
            }
        }

        // otherwise return false, the number is prime
        return false;
    }

    @Override
    int getSecondOperand(int firstOperand) {
        ArrayList<Integer> divisors = getDivisors(firstOperand);
        Random random = new Random();
        return divisors.get(random.nextInt(divisors.size()));
    }

    // get divisors for the dividend, excluding 1 as an option
    // as we are no considering prime numbers for the dividend and
    // the MIN_DIVIDEND should be larger than 1 anyway.
    // The list of possible divisors should start at 2
    private ArrayList<Integer> getDivisors(int dividend) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(dividend) + 1; i++) {
            if (dividend % i == 0) {
                if (dividend / i == i) {
                    divisors.add(i);
                } else {
                    divisors.add(i);
                    divisors.add(dividend/i);
                }
            }
        }
        return divisors;
    }

    @Override
    void setOperationSignTextView() {
        operationSignTextView.setText(R.string.division_sign);
    }

    @Override
    int getResultInt() {
        return firstOperand / secondOperand;
    }

}
