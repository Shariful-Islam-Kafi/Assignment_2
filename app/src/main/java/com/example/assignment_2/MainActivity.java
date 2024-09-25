package com.example.assignment_2;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;
    RadioGroup radioGroup;
    RadioButton radioButtonCSE, radioButtonEEE, radioButtonCivil, radioButtonBBA;
    RatingBar ratingBar;
    SeekBar seekBar;
    Switch switch1;
    TextView seekBarProgressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the UI components
        checkBox = findViewById(R.id.checkBox);
        radioGroup = findViewById(R.id.radioGroup);
        radioButtonCSE = findViewById(R.id.radioButtonCSE);
        radioButtonEEE = findViewById(R.id.radioButtonEEE);
        radioButtonCivil = findViewById(R.id.radioButtonCivil);
        radioButtonBBA = findViewById(R.id.radioButtonBBA);
        ratingBar = findViewById(R.id.ratingBar);
        seekBar = findViewById(R.id.seekBar);
        switch1 = findViewById(R.id.switch1);
        seekBarProgressText = findViewById(R.id.seekBarProgressText);

        // CheckBox interaction
        checkBox.setOnClickListener(v -> {
            if (checkBox.isChecked()) {
                Toast.makeText(MainActivity.this, "Checked", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Unchecked", Toast.LENGTH_SHORT).show();
            }
        });

        // RadioGroup interaction
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            Toast.makeText(MainActivity.this, "Selected: " + selectedRadioButton.getText(), Toast.LENGTH_SHORT).show();
        });

        // RatingBar interaction
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) ->
                Toast.makeText(MainActivity.this, "Rating: " + rating, Toast.LENGTH_SHORT).show()
        );

        // SeekBar interaction with progress display
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgressText.setText("Progress: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Optional
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Optional
            }
        });

        // Switch interaction
        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(MainActivity.this, "Notifications Enabled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Notifications Disabled", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
