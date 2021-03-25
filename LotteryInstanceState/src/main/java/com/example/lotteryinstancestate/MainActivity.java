package com.example.lotteryinstancestate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static final int LOTTO_NUMBERS = 5;

    // Counter for invoking the app
    private int counter;
    // GUI controls
    private TextView tvCounter;
    private TextView tvResult;
    private Button btGenerateNumbers;

    // EuroMillions numbers
    private int[] numbers = new int[LOTTO_NUMBERS];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get reference to the Button
        btGenerateNumbers = findViewById(R.id.btGenerateNumbers);
        // Get reference to the TextView which shows the result
        tvResult = findViewById(R.id.tvResult);
        // Get reference to the TextView which shows the counter
        tvCounter = findViewById(R.id.tvCounter);

        // Event Handler with Anonymous Inner Class
        btGenerateNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;      // Incrementing the counter
                tvCounter.setText("Counter: " + counter);
                tvResult.setText("");      // Initialize TextView
                Random random = new Random();
                for (int i = 0; i < LOTTO_NUMBERS; i++) {
                    numbers[i] = random.nextInt(50) + 1;
                    tvResult.append(numbers[i] + "  ");
                }
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
        outState.putInt("number1", numbers[0]);
        outState.putInt("number2", numbers[1]);
        outState.putInt("number3", numbers[2]);
        outState.putInt("number4", numbers[3]);
        outState.putInt("number5", numbers[4]);
    }


    // For using onCreate or onRestoreInstanceState for restoring see https://stackoverflow.com/questions/36408776/using-oncreate-vs-onrestoreinstancestate
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(), "onRestoreInstanceState", Toast.LENGTH_SHORT).show();
        counter = savedInstanceState.getInt("counter");
        tvCounter.setText("Counter: " + counter);
        numbers[0] = savedInstanceState.getInt("number1");
        numbers[1] = savedInstanceState.getInt("number2");
        numbers[2] = savedInstanceState.getInt("number3");
        numbers[3] = savedInstanceState.getInt("number4");
        numbers[4] = savedInstanceState.getInt("number5");
        for (int i = 0; i <= 4; i++) {
            tvResult.append(numbers[i] + " ");
        }


    }

}
