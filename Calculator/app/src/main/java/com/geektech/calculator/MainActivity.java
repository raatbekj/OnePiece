package com.geektech.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer first, second, result;
    private Boolean isOperationClick;
    private String operator;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        switch (view.getId()){
            case R.id.btn_one:
                //нажал на единицу
                if (textView.getText().toString().equals("0")){
                    textView.setText("1");
                }else if (isOperationClick){
                    textView.setText("1");
                }else {
                    textView.append("1");
                }
                break;
            case R.id.btn_two:
                //2
                if (textView.getText().toString().equals("0")){
                    textView.setText("2");
                }else if (isOperationClick){
                    textView.setText("2");
                }else {
                    textView.append("2");
                }
                break;
            case R.id.btn_three:
                //3
                if (textView.getText().toString().equals("0")){
                    textView.setText("3");
                }else if (isOperationClick){
                    textView.setText("3");
                }else {
                    textView.append("3");
                }
                break;
             case R.id.btn_four:
                //4
                if (textView.getText().toString().equals("0")){
                    textView.setText("4");
                }else if (isOperationClick){
                    textView.setText("4");
                }else {
                    textView.append("4");
                }
                break;
            case R.id.btn_five:
                //5
                if (textView.getText().toString().equals("0")){
                    textView.setText("5");
                }else if (isOperationClick){
                    textView.setText("5");
                }else {
                    textView.append("5");
                }
                break;
            case R.id.btn_six:
                //6
                if (textView.getText().toString().equals("0")){
                    textView.setText("6");
                }else if (isOperationClick){
                    textView.setText("6");
                }else {
                    textView.append("6");
                }
                break;
            case R.id.btn_seven:
                //7
                if (textView.getText().toString().equals("0")){
                    textView.setText("7");
                }else if (isOperationClick){
                    textView.setText("7");
                }else {
                    textView.append("7");
                }
                break;
            case R.id.btn_vosim:
                //8
                if (textView.getText().toString().equals("0")){
                    textView.setText("8");
                }else if (isOperationClick){
                    textView.setText("8");
                }else {
                    textView.append("8");
                }
                break;
            case R.id.btn_nine:
                //9
                if (textView.getText().toString().equals("0")){
                    textView.setText("9");
                }else if (isOperationClick){
                    textView.setText("9");
                }else {
                    textView.append("9");
                }
                break;
            case R.id.btn_zero:
                //0
                if (textView.getText().toString().equals("0")){
                    textView.setText("0");
                }else if (isOperationClick){
                    textView.setText("0");
                }else {
                    textView.append("0");
                }
                break;
             case R.id.btn_clear:
                textView.setText("0");
                first = 0;
                second = 0;
                break;


        }isOperationClick = false;

    }

    public void onOperationClick(View view) {
        switch (view.getId()){
            case R.id.btn_Umno:
                first = Integer.valueOf(textView.getText().toString());
                operator = "*";
                break;
            case R.id.btn_slash:
                first = Integer.valueOf(textView.getText().toString());
                operator = "/";
                break;
            case R.id.btn_minus:
                first = Integer.valueOf(textView.getText().toString());
                operator = "-";
                break;
            case R.id.btn_equal:
                second = Integer.valueOf(textView.getText().toString());
                if (operator == "+") {
                    result = first + second;
                }
                if (operator == "-"){
                    result = first - second;
                }
                if (operator == "*"){
                    result = first * second;
                }
                if (operator == "/"){
                    result = first / second;
                }
                textView.setText(result.toString());
                break;}
        isOperationClick = true;

    }
}