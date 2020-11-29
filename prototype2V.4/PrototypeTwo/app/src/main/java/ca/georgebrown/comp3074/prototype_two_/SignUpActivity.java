package ca.georgebrown.comp3074.prototype_two_;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    //Variables
    private EditText email;
    private EditText password;
    private TextView signIn;
    private Button continue_;
    private CheckBox termsAndConditions;
    private TextView errorMessage;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Linking the variables to the UI components
        email = (EditText)findViewById(R.id.inputEmail);
        password = (EditText)findViewById(R.id.inputPassword);
        continue_ = (Button)findViewById(R.id.btnContinue);
        signIn = (TextView)findViewById(R.id.signInLink);
        termsAndConditions = (CheckBox)findViewById(R.id.chkBoxOne);
        errorMessage = (TextView)findViewById(R.id.signUpErrorMessage);

        db = new DatabaseHelper(this);


        //When continue button is clicked and the check box is checked, signUpValidation() function will be called.
        continue_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(termsAndConditions.isChecked()) {
                    signUpValidation();
                }else {
                    errorMessage.setText("Please agree to the terms and conditions.");
                }
            }
        });

        //When sign in button is clicked the user is taken to the sign in page(MainActivity)
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }

    //Takes user to the Welcome Activity
    private void signUpValidation() {
        String s1 = email.getText().toString();
        String s2= password.getText().toString();


        //If email and password are not empty and the email and password follow the regex requirements then take the user to the Welcome Activity.
        //If not, then an appropriate error message will be displayed to the user.
        //Regex for password is 6-12 characters in length, contain at least one uppercase letter, and contain at least one special character.
        if(email.getText().toString().isEmpty() == false) {
            if(password.getText().toString().isEmpty() == false) {
                if (email.getText().toString().matches("\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")) {
                    if (password.getText().toString().matches("((?=.*[A-Z])(?=.*\\W).{6,12})")) {
                        Boolean checkEmail = db.chkemail(s1);
                        if(checkEmail == true) {
                            Boolean insert = db.insert(s1,s2);
                            if(insert==true) {
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Email Already Exists", Toast.LENGTH_SHORT).show();
                        }

                        Intent intent = new Intent(SignUpActivity.this, WelcomePage.class);
                        startActivity(intent);
                    }
                    else {
                        errorMessage.setText("Password must be between 6 and 12 characters containing at least one upper case character, and one special character.");
                    }
                }
                else {
                    errorMessage.setText("Must use a valid email address.");
                }
            }
            else {
                errorMessage.setText("Password cannot be empty.");
            }
        } else {
            errorMessage.setText("Email cannot be empty.");
        }

    }

    //start sign up activity
    private void getSignUpActivity(){
        Intent start = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(start);
    }
    //start profile activity
    private void getProfile(){
        Intent start = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(start);
    }
    //start main content activity
    private void getMainContent(){
        Intent start = new Intent(getApplicationContext(), MainContentActivity.class);
        startActivity(start);
    }
    //start welcome page activity
    private void getWelcomePage(){
        Intent start = new Intent(getApplicationContext(), WelcomePage.class);
        startActivity(start);
    }
    //start cooking activity
    private void getCookingPage(){
        Intent start = new Intent(getApplicationContext(), CookingBasicsActivity.class);
        startActivity(start);
    }
    //start budget activity
    private void getBudgetPage(){
        Intent start = new Intent(getApplicationContext(), HowToMakeABudgetActivity.class);
        startActivity(start);
    }
    //start depression activity
    private void getDepressionPage(){
        Intent start = new Intent(getApplicationContext(), WorkingThroughDepressionActivity.class);
        startActivity(start);
    }
    //start signIn activity
    private void getSignInPage(){
        Intent start = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(start);
    }
    //create menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.main_menu, menu);
        return true;
    }

    //switch to fire menu options
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.signUpbtn:
                getSignUpActivity();
                return true;
            case R.id.signInbtn:
                getSignInPage();
                return true;
            case R.id.profilebtn:
                getProfile();
                return true;
            case R.id.mainContentbtn:
                getMainContent();
                return true;
            case R.id.welcomepgbtn:
                getWelcomePage();
                return true;
            case R.id.budgetbtn:
                getBudgetPage();
                return true;
            case R.id.cookingbtn:
                getCookingPage();
                return true;
            case R.id.depressionbtn:
                getDepressionPage();
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

}