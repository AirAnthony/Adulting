package ca.georgebrown.comp3074.adulting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WellnessActivity extends AppCompatActivity {


    //Variables
    private TextView stress;
    private TextView depression;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellness);

        ConstraintLayout constraintLayout = findViewById(R.id.layoutForWellness);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        //initialize buttons
        Button goBackBtnForWellness = (Button) findViewById(R.id.btnBackToMenuForWellness);
        stress = (TextView)findViewById(R.id.txtHowToDealWithStress);
        depression = (TextView)findViewById(R.id.txtWorkingThroughDepression);

        //Go back to menu
        goBackBtnForWellness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(getApplicationContext(), MainContentActivity.class);
                startActivity(start);
            }
        });


        //When budget text is clicked the user is taken to the sign in page(MainActivity)
        depression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WellnessActivity.this, WorkingThroughDepressionActivity.class);
                startActivity(intent);
            }
        });

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
    //create menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.main_menu, menu);
        return true;
    }
    //start signIn activity
    private void getSignInPage(){
        Intent start = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(start);
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