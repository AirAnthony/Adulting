package ca.georgebrown.comp3074.adulting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CookingBasicsActivity extends AppCompatActivity {
    //initialize quiz variables
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

        //Set Text for cooking basics page
        TextView personalSkillsText1 =(TextView) findViewById(R.id.personalSkillsText1);
        String pST1 ="Whether you want to learn to feed yourself or to impress others, " +
                "knowing how to cook is an essential skill to possess. If you don’t " +
                "know your way around a kitchen it may be easy to feel lost- but don’t fear! " +
                "We have outlined the absolute basics to get you on your way to knowing exactly what to do!";
        personalSkillsText1.setText(pST1);

        TextView personalSkillsText2 = (TextView) findViewById(R.id.personalSkillsText2);
        String pST2 = "1. Always follow the recipe. Recipes are rules made to be followed- do not break them! " +
                "Think of a recipe as your guide to success, stick to it, and your chances of a successful dish " +
                "is within your grasp.";
        personalSkillsText2.setText(pST2);

        TextView personalSkillsText3 = (TextView) findViewById(R.id.personalSkillsText3);
        String pST3 = "2. Prep your ingredients before you start. Nothing is worse than being scattered " +
                "when your working with the elements. Not only will prepping ahead of time reduce " +
                "the mess, but it will also ensure that you are not jumping frantically from step " +
                "to step and will reduce your risk for errors.";
        personalSkillsText3.setText(pST3);

        TextView personalSkillsText4 = (TextView) findViewById(R.id.personalSkillsText4);
        String pST4 = "3. Do not overcrowd your cookware. Different ingredients react differently " +
                "as they cook. The safest way to prevent uneven cooking and unpleasant texture is " +
                "to be sure that you do not over fill your cookware. Give your food " +
                "the space it needs to cook!";
        personalSkillsText4.setText(pST4);

        TextView personalSkillsText5 = (TextView) findViewById(R.id.personalSkillsText5);
        String pST5 = "4. Keep your cookware handles away from burners. There is no easier way to " +
                "say this, keep your handles away from heat and you will keep your hands away " +
                "from potential burns and pains!";
        personalSkillsText5.setText(pST5);

        TextView personalSkillsText6 = (TextView) findViewById(R.id.personalSkillsText6);
        String pST6 = "5. Invest in a quality knife. The best way to prevent injury is to use " +
                "the proper tools. Use a good quality knife, so you can keep your hands in good quality!";
        personalSkillsText6.setText(pST6);

        TextView personalSkillsText7 = (TextView) findViewById(R.id.personalSkillsText7);
        String pST7 = "6. Never leave the kitchen unattended. Last thing we want is a potential ruined " +
                "meal, or worse, a fire! Never leave your cooking food unattended!";
        personalSkillsText7.setText(pST7);

        TextView personalSkillsText8 = (TextView) findViewById(R.id.personalSkillsText8);
        String pST8 = "7. Do not put food in a cold pan. Always build up the heat before putting food " +
                "in your cookware. This prevents losing all those yummy juices to keep your food tasty!";
        personalSkillsText8.setText(pST8);

        TextView personalSkillsText9 = (TextView) findViewById(R.id.personalSkillsText9);
        String pST9 = "Test Your Knowledge: See if you can match the kitchen utensils to their image. " +
                "For each row you must enter the kitchen utensil name, separated by commas. How many can you get right?!";
        personalSkillsText9.setText(pST9);

        //assigning id's to quiz input, images and buttons for input
        utensilName = findViewById(R.id.inputBoxUtensil2);
        btnSubmit = findViewById(R.id.submitBtn2);
        quizPicture = findViewById(R.id.imageViewResult);

        //assigning id's to quiz input, images and buttons for input
        utensilNameTwo = findViewById(R.id.inputBoxUtensil3);
        btnSubmitTwo = findViewById(R.id.submitBtn3);
        quizPictureTwo = findViewById(R.id.imageViewResultThree);

        //assigning id's to quiz input, images and buttons for input
        utensilNameThree = findViewById(R.id.inputBoxUtensil4);
        btnSubmitThree = findViewById(R.id.submitBtn4);
        quizPictureThree = findViewById(R.id.imageViewResultFour);

        //assigning id's to quiz input, images and buttons for input
        utensilNameFour = findViewById(R.id.inputBoxUtensil5);
        btnSubmitFour = findViewById(R.id.submitBtn5);
        quizPictureFour = findViewById(R.id.imageViewResultFive);

        //assignind id's to quiz input, images and buttons for input
        utensilNameFive = findViewById(R.id.inputBoxUtensil6);
        btnSubmitFive = findViewById(R.id.submitBtn6);
        quizPictureFive = findViewById(R.id.imageViewResultSix);

    }

    //button for quiz input
    public void start(View view) {
        String name = utensilName.getText().toString().trim();
        if(btnSubmit.isPressed()) {
            validationTwo(name);
        }
    }

    //button for quiz input 2
    public void startTwo(View view) {
        String nameTwo = utensilNameTwo.getText().toString().trim();
        if (btnSubmitTwo.isPressed()) {
            validationThree(nameTwo);
        }
    }

    //button for quiz input 3
    public void startThree(View view) {
        String nameThree = utensilNameThree.getText().toString().trim();
        if (btnSubmitThree.isPressed()) {
            validationFour(nameThree);
        }
    }

    //button for quiz input 4
    public void startFour(View view) {
        String nameFour = utensilNameFour.getText().toString().trim();
        if (btnSubmitFour.isPressed()) {
            validationFive(nameFour);
        }
    }

    //button for quiz input 5
    public void startFive(View view) {
        String nameFive = utensilNameFive.getText().toString().trim();
        if (btnSubmitFive.isPressed()) {
            validationSix(nameFive);
        }
    }


    //if statement for validation for first input
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

    //if statement for validation for second input
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

    //if statement for validation for third input
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

    //if statement for validation for fourth input
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

    //if statement for validation for fifth input
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