package ca.georgebrown.comp3074.prototypeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private TextView signIn;
    private Button continue_;
    private CheckBox termsAndConditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = (EditText)findViewById(R.id.inputEmail);
        password = (EditText)findViewById(R.id.inputPassword);
        continue_ = (Button)findViewById(R.id.btnContinue);
        signIn = (TextView)findViewById(R.id.signInLink);
        termsAndConditions = (CheckBox)findViewById(R.id.chkBoxOne);

        continue_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(termsAndConditions.isChecked()) {
                    checkBoxValidation();
                }
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }

    private void checkBoxValidation() {

        Intent intent = new Intent(SignUpActivity.this, WelcomeActivity.class);
        startActivity(intent);

    }

}