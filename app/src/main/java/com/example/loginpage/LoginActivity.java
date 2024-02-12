package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText emailId , Password;
    TextView LoginText, ForgotPassWord ,SignUpNow ;
    Button LoginBtn;
    ImageView FacebookImg , GoogleImg , TweetImg ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailId = findViewById(R.id.emailId);
        Password = findViewById(R.id.Password);
        LoginText = findViewById(R.id.LoginText);
        ForgotPassWord = findViewById(R.id.ForgotPassWord);
        SignUpNow = findViewById(R.id.SignUpNow);
        LoginBtn = findViewById(R.id.LoginBtn);
        FacebookImg = findViewById(R.id.FacebookImg);
        GoogleImg = findViewById(R.id.GoogleImg);
        TweetImg = findViewById(R.id.TweetImg);


        // When Sign up Now button is clicked, navigate to the registration activity
        SignUpNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegisterActivity();
            }

        });

        // When Forgot PassWord button is clicked, show a toast message about password recovery
        ForgotPassWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"We sent an Email with a link to get back into your account. ",Toast.LENGTH_SHORT).show();
            }
        });

        // When Login Button button is clicked, check user credentials
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 checkCredentials();
                }

        });

        // When Facebook Img is clicked, show a toast message about an upcoming feature
        FacebookImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Upcoming Feature ",Toast.LENGTH_SHORT).show();
            }
        });

        // When GoogleImg is clicked, show a toast message about an upcoming feature
        GoogleImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Upcoming Feature ",Toast.LENGTH_SHORT).show();
            }
        });

        // When Tweeter Img is clicked, show a toast message about an upcoming feature
        TweetImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Upcoming Feature ",Toast.LENGTH_SHORT).show();
            }
        });

    }

// Other methods and code...

    // Method to check the validity of entered email and password
    private void checkCredentials(){
        String email = emailId.getText().toString();
        String password = Password.getText().toString();

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
        else
        {
            // If credentials are valid, show a success toast and navigate to the home page of application
            Toast.makeText(getApplicationContext(), "Login Successfully  ", Toast.LENGTH_SHORT).show();
            goToMainActivity();
        }


    }


    // Method to navigate to the main activity (Home Page)
    private void goToMainActivity() {
        Intent intent = new Intent(this, WelcomePageActivity.class);
        startActivity(intent);
        finish();
    }

    // Method to show an error message for an input field
    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }

    // Method to navigate to the registration activity
    private void goToRegisterActivity() {
        Intent intent = new Intent(this, RegistartionActivity.class);
        startActivity(intent);
        finish();

    }

}
