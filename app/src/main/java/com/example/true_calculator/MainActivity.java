package com.example.true_calculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultTxt;

    private EditText inputVal1;
    private EditText inputVal2;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        resultTxt = findViewById(R.id.textView);
        inputVal1 = findViewById(R.id.input1);
        inputVal2 = findViewById(R.id.input2);

        btnAdd = findViewById(R.id.button);
        btnSubtract = findViewById(R.id.button1);
        btnMultiply = findViewById(R.id.button2);
        btnDivide = findViewById(R.id.button3);

        btnAdd.setOnClickListener(view -> {
            float number1 = Float.parseFloat(inputVal1.getText().toString());
            float number2 = Float.parseFloat(inputVal2.getText().toString());
            float result = number1 + number2;
            resultTxt.setText(String.valueOf(result));
        });

        // Вычитание
        btnSubtract.setOnClickListener(view -> {
            float number1 = Float.parseFloat(inputVal1.getText().toString());
            float number2 = Float.parseFloat(inputVal2.getText().toString());
            float result = number1 - number2;
            resultTxt.setText(String.valueOf(result));
        });

        // Умножение
        btnMultiply.setOnClickListener(view -> {
            float number1 = Float.parseFloat(inputVal1.getText().toString());
            float number2 = Float.parseFloat(inputVal2.getText().toString());
            float result = number1 * number2;
            resultTxt.setText(String.valueOf(result));
        });

        // Деление
        btnDivide.setOnClickListener(view -> {
            float number1 = Float.parseFloat(inputVal1.getText().toString());
            float number2 = Float.parseFloat(inputVal2.getText().toString());
            if (number2 != 0) {
                float result = number1 / number2;
                resultTxt.setText(String.valueOf(result));
            } else {
                resultTxt.setText("Ошибка: Деление на ноль");
            }
        });
    }
}