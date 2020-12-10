package ca.georgebrown.comp3074.adulting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Variables
    private EditText email;
    private EditText password;
    private TextView numOfAttempts;
    private TextView signUp;
    private Button signIn;
    private int count = 5;
    private TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking the variables to the UI components
        email = (EditText)findViewById(R.id.inputEmail);
        password = (EditText)findViewById(R.id.inputPassword);
        numOfAttempts = (TextView)findViewById(R.id.attempts);
        signIn = (Button)findViewById(R.id.btnSignIn);
        signUp = (TextView)findViewById(R.id.signUpLink);
        errorMessage = (TextView)findViewById(R.id.signInErrorMessage);

        numOfAttempts.setText("Number of attempts left: 5");

        //When the sign in button is clicked, the validation function will be called to check email and password
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation(email.getText().toString(), password.getText().toString());
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

    }

    //Validation function to check that the username and password are correct.
    //If the credentials are correct the user is taken to the welcome activity.
    //If the credentials are not correct the user has a certain amount of attempts until the button disappears.
    private void validation(String userEmail, String userPassword) {
        //Hardcoded username and password.  Will make it more dynamic for prototype two when database will be implemented.
        if((userEmail.equals("userOne@georgebrown.ca")) && (userPassword.equals("05945"))) {
            Intent intent = new Intent(MainActivity.this, WelcomePage.class);
            startActivity(intent);
        }else {
            count--;

            numOfAttempts.setText("Number of attempts left: " + String.valueOf(count));
            //Error message for bad credentials attempt, and displayed login info for testing purposes.
            errorMessage.setText("Incorrect username and password. For testing purposes, use 'userOne@georgebrown.ca' for the username, and '05945' for the password.");

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