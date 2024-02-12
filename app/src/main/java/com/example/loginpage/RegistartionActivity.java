package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistartionActivity extends AppCompatActivity {

    EditText emailId , Password , FullName , Contact ;
    TextView LoginNow ;
    Button SignUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailId = findViewById(R.id.emailId);
        Password = findViewById(R.id.Password);
        FullName = findViewById(R.id.FullName);
        Contact = findViewById(R.id.Contact);
        LoginNow = findViewById(R.id.LoginNow);
        SignUpBtn = findViewById(R.id.SignUpBtn);


        // When Login  button is clicked, navigate to the login activity
        LoginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLoginActivity();
            }
        });

        // When Sign up Button is clicked, check user credentials for registration
        SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials();
            }
        });

    }

// Other methods and code...

    // Method to navigate to the login activity
    private void goToLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }



    // Method to check the validity of entered email, password, and contact for registration
    private void checkCredentials(){
        String email = emailId.getText().toString();
        String password = Password.getText().toString();
        String conact = Contact.getText().toString();

        if(!email.contains("@") || !email.contains("."))
        {
            // Show an error if the email is not valid
            showError(emailId, "Email Address is not valid !");
        }
        else if (password.isEmpty() || password.length()<7)
        {
            // Show an error if the password is not valid
            showError(Password, "Password must be 7 character !");
        }
        else if (conact.length() != 10)
        {
            // Show an error if the contact is not valid
            showError(Contact, "Contact must contain 10 digits !");
        }
        else
        {
            // If credentials are valid, show a success toast and navigate to the login activity
            Toast.makeText(getApplicationContext(), "Register Successfully  ", Toast.LENGTH_SHORT).show();
            goToLoginActivity();
        }


    }

    // Method to show an error message for an input field
    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }

}