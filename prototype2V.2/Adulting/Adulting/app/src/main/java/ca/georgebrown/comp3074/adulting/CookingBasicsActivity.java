package ca.georgebrown.comp3074.adulting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CookingBasicsActivity extends AppCompatActivity {

    EditText utensilName;
    ImageView quizPicture;
    Button btnSubmit;

    EditText utensilNameTwo;
    ImageView quizPictureTwo;
    Button btnSubmitTwo;

    EditText utensilNameThree;
    ImageView quizPictureThree;
    Button btnSubmitThree;

    EditText utensilNameFour;
    ImageView quizPictureFour;
    Button btnSubmitFour;

    EditText utensilNameFive;
    ImageView quizPictureFive;
    Button btnSubmitFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking_basics);

        utensilName = findViewById(R.id.inputBoxUtensil2);
        btnSubmit = findViewById(R.id.submitBtn2);
        quizPicture = findViewById(R.id.imageViewResult);

        utensilNameTwo = findViewById(R.id.inputBoxUtensil3);
        btnSubmitTwo = findViewById(R.id.submitBtn3);
        quizPictureTwo = findViewById(R.id.imageViewResultThree);

        utensilNameThree = findViewById(R.id.inputBoxUtensil4);
        btnSubmitThree = findViewById(R.id.submitBtn4);
        quizPictureThree = findViewById(R.id.imageViewResultFour);

        utensilNameFour = findViewById(R.id.inputBoxUtensil5);
        btnSubmitFour = findViewById(R.id.submitBtn5);
        quizPictureFour = findViewById(R.id.imageViewResultFive);

        utensilNameFive = findViewById(R.id.inputBoxUtensil6);
        btnSubmitFive = findViewById(R.id.submitBtn6);
        quizPictureFive = findViewById(R.id.imageViewResultSix);


    }

    public void start(View view) {
        String name = utensilName.getText().toString().trim();
        if(btnSubmit.isPressed()) {
            validationTwo(name);
        }
    }

    public void startTwo(View view) {
        String nameTwo = utensilNameTwo.getText().toString().trim();
        if (btnSubmitTwo.isPressed()) {
            validationThree(nameTwo);
        }
    }

    public void startThree(View view) {
        String nameThree = utensilNameThree.getText().toString().trim();
        if (btnSubmitThree.isPressed()) {
            validationFour(nameThree);
        }
    }

    public void startFour(View view) {
        String nameFour = utensilNameFour.getText().toString().trim();
        if (btnSubmitFour.isPressed()) {
            validationFive(nameFour);
        }
    }

    public void startFive(View view) {
        String nameFive = utensilNameFive.getText().toString().trim();
        if (btnSubmitFive.isPressed()) {
            validationSix(nameFive);
        }
    }


    private void validationTwo(String enteredUtensil) {
        if (enteredUtensil.toLowerCase().equals("measuring cup, measuring spoons, spatula, roasting pan")) {
            quizPicture.setImageResource(R.drawable.correct);
            Toast.makeText(this, "All Correct, " + enteredUtensil, Toast.LENGTH_LONG).show();
        }
        else {
            quizPicture.setImageResource(R.drawable.wrong);
            Toast.makeText(this, "Wrong, some answer(s) are not correct " + enteredUtensil, Toast.LENGTH_LONG).show();
        }

    }

    private void validationThree(String enteredUtensilTwo) {
        if (enteredUtensilTwo.toLowerCase().equals("rolling pin, frying pan, mixing bowl, grater")) {
            quizPictureTwo.setImageResource(R.drawable.correct);
            Toast.makeText(this, "All Correct, " + enteredUtensilTwo, Toast.LENGTH_LONG).show();
        }
        else {
            quizPictureTwo.setImageResource(R.drawable.wrong);
            Toast.makeText(this, "Wrong, some answer(s) are not correct " + enteredUtensilTwo, Toast.LENGTH_LONG).show();
        }

    }

    private void validationFour(String enteredUtensilThree) {
        if (enteredUtensilThree.toLowerCase().equals("ladle, whisk, tongs, strainer")) {
            quizPictureThree.setImageResource(R.drawable.correct);
            Toast.makeText(this, "All Correct, " + enteredUtensilThree, Toast.LENGTH_LONG).show();
        }
        else {
            quizPictureThree.setImageResource(R.drawable.wrong);
            Toast.makeText(this, "Wrong, some answer(s) are not correct " + enteredUtensilThree, Toast.LENGTH_LONG).show();
        }

    }

    private void validationFive(String enteredUtensilFour) {
        if (enteredUtensilFour.toLowerCase().equals("meat cleaver, garlic press, colander, mixer")) {
            quizPictureFour.setImageResource(R.drawable.correct);
            Toast.makeText(this, "All Correct, " + enteredUtensilFour, Toast.LENGTH_LONG).show();
        }
        else {
            quizPictureFour.setImageResource(R.drawable.wrong);
            Toast.makeText(this, "Wrong, some answer(s) are not correct " + enteredUtensilFour, Toast.LENGTH_LONG).show();
        }

    }

    private void validationSix(String enteredUtensilFive) {
        if (enteredUtensilFive.toLowerCase().equals("corkscrew, blender, can opener, potato masher")) {
            quizPictureFive.setImageResource(R.drawable.correct);
            Toast.makeText(this, "All Correct, " + enteredUtensilFive, Toast.LENGTH_LONG).show();
        }
        else {
            quizPictureFive.setImageResource(R.drawable.wrong);
            Toast.makeText(this, "Wrong, some answer(s) are not correct " + enteredUtensilFive, Toast.LENGTH_LONG).show();
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