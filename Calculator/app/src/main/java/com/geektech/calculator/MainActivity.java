package com.geektech.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Double first, second, result;
    boolean isOperationClick;
    boolean isDotClick = false;
    private String operation;
    Button buttonNA;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    @SuppressLint("NonConstantResourceId")
    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_clear:
                textView.setText("0");
                first = 0.0;
                second = 0.0;
                isDotClick = false;
                break;
            case R.id.btn_one:
                listenClick("1");
                break;
            case R.id.btn_two:
                listenClick("2");
                break;
            case R.id.btn_three:
                listenClick("3");
                break;
            case R.id.btn_four:
                listenClick("4");
                break;
            case R.id.btn_five:
                listenClick("5");
                break;
            case R.id.btn_six:
                listenClick("6");
                break;
            case R.id.btn_seven:
                listenClick("7");
                break;
            case R.id.btn_vosim:
                listenClick("8");
                break;
            case R.id.btn_nine:
                listenClick("9");
                break;
            case R.id.btn_zero:
                listenClick("0");
                break;
            case R.id.btn_nipple:
                if (!isDotClick) {
                    textView.append(".");
                }
                isDotClick = true;
                break;
            case R.id.btn_pos_neg:
                if (!textView.getText().toString().equals("0")) {
                    String s = textView.getText().toString();
                    if (s.startsWith("-")) {
                        String newS = s.replace("-", "");
                        textView.setText(newS);
                    } else {
                        textView.setText("-".concat(s));
                    }
                } else {
                    Toast.makeText(MainActivity.this, "'0' не может быть отрицательным.",
                            Toast.LENGTH_SHORT).show();
                }
        }
        isOperationClick = false;
        buttonNA.setVisibility(View.GONE);
    }


    private void listenClick(String i) {
        if (textView.getText().toString().equals("0")) {
            textView.setText(i);
        } else if (isOperationClick) {
            textView.setText(i);
        } else {
            textView.append(i);
        }
    }


    @SuppressLint("NonConstantResourceId")
    public void setOperationClick(View view) {
        String txtNewResult;
        switch (view.getId()) {
            case R.id.btn_plus:
                first = Double.valueOf(textView.getText().toString());
                operation = "plus";
                isDotClick = false;
                buttonNA.setVisibility(View.GONE);
                break;
            case R.id.btn_minus:
                first = Double.valueOf(textView.getText().toString());
                operation = "subtraction";
                isDotClick = false;
                buttonNA.setVisibility(View.GONE);
                break;
            case R.id.btn_slash:
                first = Double.valueOf(textView.getText().toString());
                operation = "division";
                isDotClick = false;
                buttonNA.setVisibility(View.GONE);
                break;
            case R.id.btn_Umno:
                first = Double.valueOf(textView.getText().toString());
                operation = "multiply";
                isDotClick = false;
                buttonNA.setVisibility(View.GONE);
                break;
            case R.id.btn_proc:
                first = Double.valueOf(textView.getText().toString());
                result = first / 100;
                String txtResult = result.toString();
                if (txtResult.endsWith(".0")) {
                    txtNewResult = txtResult.substring(0, txtResult.length()-2);
                    textView.setText(txtNewResult);
                    isDotClick = false;
                } else {
                    textView.setText(txtResult);
                }
                isDotClick = false;
                buttonNA.setVisibility(View.GONE);
                break;

            case R.id.btn_equal:
                switch (operation) {
                    case "plus":
                        second = Double.valueOf(textView.getText().toString());
                        result = first + second;
                        break;
                    case "subtraction":
                        second = Double.valueOf(textView.getText().toString());
                        result = first - second;
                        break;
                    case "division":
                        second = Double.valueOf(textView.getText().toString());
                        if (second == 0) {
                            result = 0.0;
                        } else {
                            result = first / second;
                        }
                        break;
                    case "multiply":
                        second = Double.valueOf(textView.getText().toString());
                        result = first * second;
                        break;
                }
                txtResult = result.toString();
                if (txtResult.endsWith(".0")) {
                    txtNewResult = txtResult.substring(0, txtResult.length()-2);
                    textView.setText(txtNewResult);
                    isDotClick = false;
                } else {
                    textView.setText(txtResult);
                }
                buttonNA.setVisibility(View.VISIBLE);
                break;
        }
        isOperationClick = true;
    }


}
