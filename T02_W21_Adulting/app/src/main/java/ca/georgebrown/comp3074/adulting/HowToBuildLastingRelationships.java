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
import android.widget.Toast;

public class HowToBuildLastingRelationships extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_build_lasting_relationships);

        /*
        ConstraintLayout constraintLayout = findViewById(R.id.layoutForHowToBuildLastingRelationships);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        */


        //yes buttons
        Button yes1 = (Button) findViewById(R.id.yes1);
        Button yes2 = (Button) findViewById(R.id.yes2);
        Button yes3 = (Button) findViewById(R.id.yes3);
        Button yes4 = (Button) findViewById(R.id.yes4);
        Button yes5 = (Button) findViewById(R.id.yes5);
        //no buttons
        Button no1 = (Button) findViewById(R.id.no1);
        Button no2 = (Button) findViewById(R.id.no2);
        Button no3 = (Button) findViewById(R.id.no3);
        Button no4 = (Button) findViewById(R.id.no4);
        Button no5 = (Button) findViewById(R.id.no5);

        //question 1
        yes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HowToBuildLastingRelationships.this,
                        "You are Correct!", Toast.LENGTH_LONG).show();
            }
        });

        no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HowToBuildLastingRelationships.this,
                        "You are Incorrect!", Toast.LENGTH_LONG).show();
            }
        });

        //question 2
        yes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HowToBuildLastingRelationships.this,
                        "You are Incorrect!", Toast.LENGTH_LONG).show();
            }
        });

        no2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HowToBuildLastingRelationships.this,
                        "You are Correct!", Toast.LENGTH_LONG).show();
            }
        });

        //question 3
        yes3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HowToBuildLastingRelationships.this,
                        "You are Incorrect!", Toast.LENGTH_LONG).show();
            }
        });

        no3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HowToBuildLastingRelationships.this,
                        "You are Correct!", Toast.LENGTH_LONG).show();
            }
        });

        //question 4
        yes4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HowToBuildLastingRelationships.this,
                        "You are Correct!", Toast.LENGTH_LONG).show();
            }
        });

        no4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HowToBuildLastingRelationships.this,
                        "You are Incorrect!", Toast.LENGTH_LONG).show();
            }
        });

        //question 5
        yes5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HowToBuildLastingRelationships.this,
                        "You are Correct!", Toast.LENGTH_LONG).show();
            }
        });

        no5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HowToBuildLastingRelationships.this,
                        "You are Incorrect!", Toast.LENGTH_LONG).show();
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