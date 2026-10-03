package com.example.myapplication;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText etName, etDob, etAddress, etPhone, etEmail, etAadhaar;
    Spinner spinnerAccountType;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etDob = findViewById(R.id.etDob);
        etAddress = findViewById(R.id.etAddress);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etAadhaar = findViewById(R.id.etAadhaar);
        spinnerAccountType = findViewById(R.id.spinnerAccountType);
        btnSubmit = findViewById(R.id.btnSubmit);
        // Account Type options
        String[] accountTypes = {"Savings Account", "Current Account"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, accountTypes);
        spinnerAccountType.setAdapter(adapter);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String dob = etDob.getText().toString().trim();
                String address = etAddress.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String aadhaar = etAadhaar.getText().toString().trim();
                String accountType = spinnerAccountType.getSelectedItem().toString();
                if (name.isEmpty() || dob.isEmpty() || address.isEmpty() ||
                        phone.isEmpty() || email.isEmpty() || aadhaar.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                String message = "Name: " + name + "\n"
                        + "DOB: " + dob + "\n"
                        + "Address: " + address + "\n"
                        + "Phone: " + phone + "\n"
                        + "Email: " + email + "\n"
                        + "Aadhaar: " + aadhaar + "\n"
                        + "Account Type: " + accountType;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Registration Successful");
                builder.setMessage(message);
                builder.setPositiveButton("OK", null);
                builder.show();
            }
        });
    }
}
