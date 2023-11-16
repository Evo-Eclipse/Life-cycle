package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lifecycle.databinding.ElementsBinding;

public class MainActivity extends AppCompatActivity {

    int a = 1;
    public static final String TAG = "MainActivity";

    TextView textView;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ElementsBinding binding = ElementsBinding.inflate(getLayoutInflater());

        // setContentView(R.layout.elements);
        setContentView(binding.getRoot());
        // setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "Create", Toast.LENGTH_SHORT).show();
        textView = findViewById(R.id.TV);
        // radioGroup = findViewById(R.id.RG);
        // radioGroup.setOnCheckedChangeListener(new RadioGroup.OnClickListener() {
        binding.RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedID) {
                if (checkedID == R.id.rb1) {
                    textView.setText("Вкусный!");
                }
                if (checkedID == R.id.rb2) {
                    textView.setText("Он фисташковый");
                }
            }
        });

        binding.ET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG + "before", s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG + "on change", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG + "after", s.toString());
                a = Integer.parseInt(s.toString());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Start", Toast.LENGTH_SHORT).show();
    }

    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Pause", Toast.LENGTH_SHORT).show();
    }

    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Destroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "Restart", Toast.LENGTH_SHORT).show();
    }
}