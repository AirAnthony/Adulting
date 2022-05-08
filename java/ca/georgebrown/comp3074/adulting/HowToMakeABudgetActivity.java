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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HowToMakeABudgetActivity extends AppCompatActivity {

    //Input Variables
    private EditText incomeTotal;
    private EditText mortgageCost;
    private EditText insuranceCost;
    private EditText utilityCost;
    private EditText phoneCost;
    private EditText internetCost;
    private EditText tvCost;
    private EditText gasCost;
    private EditText groceryCost;
    private EditText entertainmentCost;
    private EditText childCareCost;
    private EditText debtCost;
    private EditText loansCost;
    private EditText clothesCost;
    private EditText carCost;
    private EditText savings;



    //Output Variables
    private TextView incomeOutput;
    private TextView mortgageOutput;
    private TextView insuranceOutput;
    private TextView utilitiesOutput;
    private TextView phoneOutput;
    private TextView internetOutput;
    private TextView tvOutput;
    private TextView gasOutput;
    private TextView groceriesOutput;
    private TextView entertainmentOutput;
    private TextView childCareOutput;
    private TextView creditCardOutput;
    private TextView loansOutput;
    private TextView clothesOutput;
    private TextView carOutput;
    private TextView savingsOutput;
    private TextView totalOutput;

    private TextView totalExpenses;



    private Button budgetbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_make_a_budget);

        /*
        ConstraintLayout constraintLayout = findViewById(R.id.layoutForHowToMakeABudget);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

         */

        //Set Text for finance basics page
        TextView financeText1 =(TextView) findViewById(R.id.financeText1);
        String fT1 ="To take control of your spending and achieve your financial goals, " +
                "you need an accurate and realistic budget that is suited to your life.";
        financeText1.setText(fT1);

        TextView financeText2 =(TextView) findViewById(R.id.financeText2);
        String fT2 ="A budget tracks and compares your income and expenses for a set period if time." +
                "A proper budget will show you how much money you bring in and compare that amount to your " +
                "expenses and non-essential spending.If utilized, a budget can help you save money and can " +
                "assist you in achieving your financial goals.";
        financeText2.setText(fT2);

        TextView financeText3 =(TextView) findViewById(R.id.financeText3);
        String fT3 ="The key to a budget is to have balance. If you spend less in one area, you can spend more " +
                "in another or are able to utilize that money to achieve a monetary  goal.";
        financeText3.setText(fT3);

        TextView financeText4 =(TextView) findViewById(R.id.financeText4);
        String fT4 ="After following a few important steps, you will soon enter information into your very own budget." +
        "Let's start by gathering the figures needed so that you can make a list of your expenses.";
        financeText4.setText(fT4);

        TextView financeText5 =(TextView) findViewById(R.id.financeText5);
        String fT5 ="First, you must determine your fixed expenses. These expenses are essential payments " +
                "that tend to be the same from month to month.";
        financeText5.setText(fT5);

        TextView financeText6 =(TextView) findViewById(R.id.financeText6);
        String fT6 ="Next up, determine your variable expenses. These expenses change from month to month.";
        financeText6.setText(fT6);

        TextView financeText7 =(TextView) findViewById(R.id.financeText7);
        String fT7 ="Now make totals of your income and expenses. If your income total is " +
                "higher than your expenses total, any extra funds can be put towards specific goals.";
        financeText7.setText(fT7);

        TextView financeText8 =(TextView) findViewById(R.id.financeText8);
        String fT8 ="If your expenses are greater than your income, find areas in your variable expenses that" +
                " can be reduced or cut. If you have significant debt you may need to trim your fixed expenses " +
                "and consider possibilities to increase your income to balance your budget.";
        financeText8.setText(fT8);

        TextView financeText9 =(TextView) findViewById(R.id.financeText9);
        String fT9 ="Now let’s make your budget!";
        financeText9.setText(fT9);

        incomeTotal = (EditText) findViewById(R.id.incomeTotal);
        mortgageCost = (EditText) findViewById(R.id.mortgageCost);
        insuranceCost = (EditText) findViewById(R.id.insuranceCost);
        utilityCost = (EditText) findViewById(R.id.utilityCost);
        phoneCost = (EditText) findViewById(R.id.phoneCost);
        internetCost = (EditText) findViewById(R.id.internetCost);
        tvCost = (EditText) findViewById(R.id.tvCost);
        gasCost = (EditText) findViewById(R.id.gasCost);
        groceryCost = (EditText) findViewById(R.id.groceryCost);
        entertainmentCost = (EditText) findViewById(R.id.entertainmentCost);
        childCareCost = (EditText) findViewById(R.id.childCareCost);
        debtCost = (EditText) findViewById(R.id.debtCost);
        loansCost = (EditText) findViewById(R.id.loansCost);
        clothesCost = (EditText) findViewById(R.id.clothesCost);
        carCost = (EditText) findViewById(R.id.carCost);
        savings = (EditText) findViewById(R.id.savings);

        incomeOutput = (TextView) findViewById(R.id.incomeOutput);
        mortgageOutput = (TextView) findViewById(R.id.mortgageOutput);
        insuranceOutput = (TextView) findViewById(R.id.insuranceOutput);
        utilitiesOutput = (TextView) findViewById(R.id.utilitiesOutput);
        phoneOutput = (TextView) findViewById(R.id.phoneOutput);
        internetOutput = (TextView) findViewById(R.id.internetOutput);
        tvOutput = (TextView) findViewById(R.id.tvOutput);
        gasOutput = (TextView) findViewById(R.id.gasOutput);
        groceriesOutput = (TextView) findViewById(R.id.groceriesOutput);
        entertainmentOutput = (TextView) findViewById(R.id.entertainmentOutput);
        childCareOutput = (TextView) findViewById(R.id.childCareOutput);
        creditCardOutput = (TextView) findViewById(R.id.creditCardOutput);
        loansOutput = (TextView) findViewById(R.id.loansOutput);
        clothesOutput = (TextView) findViewById(R.id.clothesOutput);
        carOutput = (TextView) findViewById(R.id.carOutput);
        savingsOutput = (TextView) findViewById(R.id.savingsOutput);
        totalOutput = (TextView) findViewById(R.id.totalOutput);




        budgetbtn = (Button) findViewById(R.id.budgetbtn);

        budgetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpValidationTwo();
                //showBudget();
            }
        });

    }

    private void signUpValidationTwo() {

        String s7 = incomeTotal.getText().toString();

        if(incomeTotal.getText().toString().isEmpty() == false
            && mortgageCost.getText().toString().isEmpty() == false
            && insuranceCost.getText().toString().isEmpty() == false
            && utilityCost.getText().toString().isEmpty() == false
            && phoneCost.getText().toString().isEmpty() == false
            && internetCost.getText().toString().isEmpty() == false
            && tvCost.getText().toString().isEmpty() == false
            && gasCost.getText().toString().isEmpty() == false
            && groceryCost.getText().toString().isEmpty() == false
            && entertainmentCost.getText().toString().isEmpty() == false
            && childCareCost.getText().toString().isEmpty() == false
            && debtCost.getText().toString().isEmpty() == false
            && loansCost.getText().toString().isEmpty() == false
            && clothesCost.getText().toString().isEmpty() == false
            && carCost.getText().toString().isEmpty() == false
            && savings.getText().toString().isEmpty() == false)
        {
            showBudget();
            Intent intentSix = new Intent(HowToMakeABudgetActivity.this, ProfileActivity.class);
            intentSix.putExtra("keynameTwo", s7);

        }
        else
        {
            Toast.makeText(getApplicationContext(), "Entry Can't Be Blank", Toast.LENGTH_SHORT).show();
        }
    }

    private void showBudget(){

        double income = Double.valueOf(incomeTotal.getText().toString());
        double mortgage = Double.valueOf(mortgageCost.getText().toString());
        double insurance = Double.valueOf(insuranceCost.getText().toString());
        double utility = Double.valueOf(utilityCost.getText().toString());
        double phone = Double.valueOf(phoneCost.getText().toString());
        double internet = Double.valueOf(internetCost.getText().toString());
        double tv = Double.valueOf(tvCost.getText().toString());
        double gas = Double.valueOf(gasCost.getText().toString());
        double grocery = Double.valueOf(groceryCost.getText().toString());
        double entertainment = Double.valueOf(entertainmentCost.getText().toString());
        double childCare = Double.valueOf(childCareCost.getText().toString());
        double debt = Double.valueOf(debtCost.getText().toString());
        double loans = Double.valueOf(loansCost.getText().toString());
        double clothes = Double.valueOf(clothesCost.getText().toString());
        double car = Double.valueOf(carCost.getText().toString());
        double saving = Double.valueOf(savings.getText().toString());
        double totalExpenses = Double.valueOf(mortgage + insurance + utility + phone + internet + tv + gas + grocery +
                entertainment + childCare + debt + loans + clothes + car + saving);

        incomeOutput.setText("Income: " + income);
        mortgageOutput.setText("Mortgage: " + mortgage);
        insuranceOutput.setText("Insurance: " + insurance);
        utilitiesOutput.setText("Utilities: " + utility);
        phoneOutput.setText("Phone: " + phone);
        internetOutput.setText("Internet: " + internet);
        tvOutput.setText("T.V: " + tv);
        gasOutput.setText("Gas: " + gas);
        groceriesOutput.setText("Groceries: " + grocery);
        entertainmentOutput.setText("Entertainment: " + entertainment);
        childCareOutput.setText("Child Care: " + childCare);
        creditCardOutput.setText("Debt: " + debt);
        loansOutput.setText("Loans: " + loans);
        clothesOutput.setText("Clothes: " + clothes);
        carOutput.setText("Car: " + car);
        savingsOutput.setText("Savings: " + saving);
        totalOutput.setText("Total Expenses: " + totalExpenses);

        double d1 = totalExpenses;


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