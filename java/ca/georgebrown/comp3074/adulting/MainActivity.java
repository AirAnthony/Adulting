package ca.georgebrown.comp3074.adulting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    //Variables
    private EditText email;
    private EditText password;
    private TextView numOfAttempts;
    private TextView signUp;
    private Button signIn;
    private int count = 5;
    private TextView errorMessage;
    private TextView forgotPassword;

    private FirebaseAuth mAuth;
    private ProgressBar progressBarMainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        //Linking the variables to the UI components
        email = (EditText)findViewById(R.id.inputEmail);
        password = (EditText)findViewById(R.id.inputPassword);
        numOfAttempts = (TextView)findViewById(R.id.attempts);
        signIn = (Button)findViewById(R.id.btnSignIn);
        signUp = (TextView)findViewById(R.id.signUpLink);
        errorMessage = (TextView)findViewById(R.id.signInErrorMessage);
        progressBarMainActivity = (ProgressBar)findViewById(R.id.progressBarMain);
        mAuth = FirebaseAuth.getInstance();
        forgotPassword = (TextView)findViewById(R.id.txtForgotPassword);

        numOfAttempts.setText("Number of attempts left: 5");

        //When the sign in button is clicked, the validation function will be called to check email and password
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailValue = email.getText().toString().trim();
                String passwordValue = password.getText().toString().trim();

                if(emailValue.isEmpty()){
                    email.setError("Email is required!");
                    email.requestFocus();
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(emailValue).matches()){
                    email.setError("Please enter a valid email!");
                    email.requestFocus();
                    return;
                }

                if(passwordValue.isEmpty()){
                    password.setError("Password is required!");
                    password.requestFocus();
                    return;
                }

                if(passwordValue.length() < 6){
                    password.setError("Min password length is 6 characters!");
                    password.requestFocus();
                    return;
                }

                progressBarMainActivity.setVisibility(View.VISIBLE);

                mAuth.signInWithEmailAndPassword(emailValue, passwordValue).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            /*
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                            if(user.isEmailVerified()){
                                // redirect to user profile
                                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                            }else {
                                user.sendEmailVerification();
                                Toast.makeText(MainActivity.this, "Check your email to verify your account!", Toast.LENGTH_LONG).show();
                                progressBarMainActivity.setVisibility(View.GONE);
                            }
                            */

                            // redirect to user profile
                            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                        }else{
                            Toast.makeText(MainActivity.this, "Failed to login!  Please check your credentials", Toast.LENGTH_LONG).show();
                            progressBarMainActivity.setVisibility(View.GONE);
                        }
                    }
                });


            }
        });

        //When the sign up button is clicked, user will be taken to the sign up activity.
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentForgotPassword = new Intent(MainActivity.this, ForgotPassword.class);
                startActivity(intentForgotPassword);
            }
        });

    }

    //Validation function to check that the username and password are correct.
    //If the credentials are correct the user is taken to the welcome activity.
    //If the credentials are not correct the user has a certain amount of attempts until the button disappears.
    private void validation(String userEmail, String userPassword) {



        if(((userEmail.equals("testUser@georgebrown.ca")) && (userPassword.equals("Yivkfnt3$"))) ||
                ((userEmail.equals("johnThomas@yahoo.ca")) && (userPassword.equals("Guiv8^")))) {
            Intent intent = new Intent(MainActivity.this, WelcomePage.class);
            startActivity(intent);
        }else {
            count--;

            numOfAttempts.setText("Number of attempts left: " + String.valueOf(count));
            //Error message for bad credentials attempt, and displayed login info for testing purposes.
            errorMessage.setText("Incorrect username and password.");

            //If the count(attempts) is zero then the sign in button is no longer enabled and the background is set to a color to make it invisible.
            if(count == 0) {
                signIn.setEnabled(false);
                signIn.setBackgroundColor(808080);
            }
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
            default: return super.onOptionsItemSelected(item);
        }
    }

}