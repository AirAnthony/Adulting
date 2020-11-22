package ca.georgebrown.comp3074.prototypeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText email;
    private EditText password;
    private TextView numOfAttempts;
    private TextView signUp;
    private Button signIn;
    private int count = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText)findViewById(R.id.inputEmail);
        password = (EditText)findViewById(R.id.inputPassword);
        numOfAttempts = (TextView)findViewById(R.id.attempts);
        signIn = (Button)findViewById(R.id.btnSignIn);
        signUp = (TextView)findViewById(R.id.signUpLink);

        numOfAttempts.setText("Number of attempts left: 5");

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation(email.getText().toString(), password.getText().toString());
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

    private void validation(String userEmail, String userPassword) {
        if((userEmail.equals("userOne@georgebrown.ca")) && (userPassword.equals("05945"))) {
            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(intent);
        }else {
            count--;

            numOfAttempts.setText("Number of attempts left: " + String.valueOf(count));

            if(count == 0) {
                signIn.setEnabled(false);
                signIn.setBackgroundColor(808080);
            }
        }
    }


}