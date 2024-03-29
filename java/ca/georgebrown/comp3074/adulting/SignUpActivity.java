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
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    //Variables
    private EditText email;
    private EditText password;
    private EditText fullName;
    private EditText age;
    private ProgressBar progressBar;
    private TextView signIn;
    private Button continue_;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


        ConstraintLayout constraintLayout = findViewById(R.id.layoutForSignUp);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        


        //Linking the variables to the UI components
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        fullName = (EditText) findViewById(R.id.fullName);
        age = (EditText) findViewById(R.id.age);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        continue_ = (Button) findViewById(R.id.btnContinue);
        signIn = (TextView) findViewById(R.id.signInLink);





        


        //When continue button is clicked and the check box is checked, signUpValidation() function will be called.
        continue_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    final String email_string = email.getText().toString().trim();
                    String password_string = password.getText().toString().trim();
                    final String fullName_string = fullName.getText().toString().trim();
                    final String age_string = age.getText().toString().trim();

                    if(fullName_string.isEmpty()){
                        fullName.setError("Full name is required!");
                        fullName.requestFocus();
                        return;
                    }

                    if(age_string.isEmpty()){
                        age.setError("Age is required!");
                        age.requestFocus();
                        return;
                    }

                    if(email_string.isEmpty()){
                        email.setError("Email is required!");
                        email.requestFocus();
                        return;
                    }

                    if(!Patterns.EMAIL_ADDRESS.matcher(email_string).matches()){
                        email.setError("Please provide valid email!");
                        email.requestFocus();
                        return;
                    }

                    if(password_string.isEmpty()){
                        password.setError("Password is required!");
                        password.requestFocus();
                        return;
                    }

                    if(password_string.length() < 6){
                        password.setError("Min password length should be 6 characters!");
                        password.requestFocus();
                        return;
                    }

                    progressBar.setVisibility(View.VISIBLE);
                    mAuth.createUserWithEmailAndPassword(email_string, password_string)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        User user = new User(fullName_string, age_string, email_string);

                                        FirebaseDatabase.getInstance().getReference("Users")
                                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {

                                                if(task.isSuccessful()){
                                                    Toast.makeText(SignUpActivity.this, "User has been registered successfully!", Toast.LENGTH_LONG).show();
                                                    progressBar.setVisibility(View.GONE);

                                                    // redirect to login layout!
                                                }else{
                                                    Toast.makeText(SignUpActivity.this, "Failed to register!  Try again!", Toast.LENGTH_LONG).show();
                                                    progressBar.setVisibility(View.GONE);
                                                }
                                            }
                                        });

                                    }else{
                                        Toast.makeText(SignUpActivity.this, "Failed to register  Try again!", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });


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





    //start sign up activity
    private void getSignUpActivity() {
        Intent start = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(start);
    }

    //start profile activity
    private void getProfile() {
        Intent start = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(start);
    }

    //start main content activity
    private void getMainContent() {
        Intent start = new Intent(getApplicationContext(), MainContentActivity.class);
        startActivity(start);
    }

    //start welcome page activity
    private void getWelcomePage() {
        Intent start = new Intent(getApplicationContext(), WelcomePage.class);
        startActivity(start);
    }

    //start cooking activity
    private void getCookingPage() {
        Intent start = new Intent(getApplicationContext(), CookingBasicsActivity.class);
        startActivity(start);
    }

    //start budget activity
    private void getBudgetPage() {
        Intent start = new Intent(getApplicationContext(), HowToMakeABudgetActivity.class);
        startActivity(start);
    }

    //start depression activity
    private void getDepressionPage() {
        Intent start = new Intent(getApplicationContext(), WorkingThroughDepressionActivity.class);
        startActivity(start);
    }

    //start signIn activity
    private void getSignInPage() {
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}



