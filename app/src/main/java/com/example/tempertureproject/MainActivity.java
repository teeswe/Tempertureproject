package com.example.tempertureproject;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tempertureproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //text from the box
                String fStr = binding.editFahrenheit.getText().toString();
                String cStr = binding.editCelsius.getText().toString();


                if (fStr.length() > 0) {
                    double fValue = Double.parseDouble(fStr);
                    double resultC = (fValue - 32) * 5.0 / 9.0;
                    //result in the clsius box
                    binding.editCelsius.setText(String.format("%.1f", resultC));
                }
                //  If Fareheit empty check if cellsius have a number
                else if (cStr.length() > 0) {
                    double cValue = Double.parseDouble(cStr);
                    double resultF = (cValue * 9.0 / 5.0) + 32;
                    // Put the result in the Fahrenheit box
                    binding.editFahrenheit.setText(String.format("%.1f", resultF));
                }

            }
        });
    }
}