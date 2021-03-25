package com.example.lotterylifecycle;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // GUI controls
    private Button btGenerateNumbers;
    private TextView tvResult;

    static final int LOTTO_NUMBERS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle", "onCreate invoked");

        // Get reference to the Button
        btGenerateNumbers = findViewById(R.id.btGenerateNumbers);
        // Get reference to the TextView which shows the result
        tvResult = findViewById(R.id.tvResult);
        // Event Handler with Anonymous Inner Class
        btGenerateNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText("");      // Initialize TextView
                Random random = new Random();
                int numbers[] = new int[LOTTO_NUMBERS];
                for (int i = 0; i < LOTTO_NUMBERS; i++) {
                    numbers[i] = random.nextInt(50) + 1;
                    tvResult.append(numbers[i] + "  ");
                }
            }
        });


    }

    // See for Activity Lifecycle: https://developer.android.com/reference/android/app/Activity

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "onPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle", "onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "onDestroy invoked");
    }

}
