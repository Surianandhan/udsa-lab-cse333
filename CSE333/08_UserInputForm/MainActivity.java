package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword, etAddress, etAge;
    RadioGroup rgGender;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etAddress = findViewById(R.id.etAddress);
        etAge = findViewById(R.id.etAge);
        rgGender = findViewById(R.id.rgGender);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String address = etAddress.getText().toString().trim();
                String age = etAge.getText().toString().trim();

                int selectedId = rgGender.getCheckedRadioButtonId();
                RadioButton selectedRadio = findViewById(selectedId);
                String gender = selectedRadio.getText().toString();

                if (username.isEmpty() || password.isEmpty() ||
                        address.isEmpty() || age.isEmpty()) {

                    Toast.makeText(
                            MainActivity.this,
                            "Please fill all fields",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

                String result = "User Name: " + username +
                        "\nPassword: " + password +
                        "\nAddress: " + address +
                        "\nGender: " + gender +
                        "\nAge: " + age;

                tvResult.setText(result);
            }
        });
    }
}
