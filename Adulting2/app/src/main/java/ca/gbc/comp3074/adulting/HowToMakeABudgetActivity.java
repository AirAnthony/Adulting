package ca.gbc.comp3074.adulting;

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
import android.widget.TextView;

public class HowToMakeABudgetActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_make_a_budget);

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

        Button budgetbtn = (Button) findViewById(R.id.budgetbtn);

        budgetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBudget();
            }
        });

    }

    private void showBudget(){
        double income = Double.valueOf(incomeTotal.getText().toString());
        double mortgage = Double.valueOf(mortgageCost.getText().toString());
        double insurance = Double.valueOf(insuranceCost.getText().toString());
        double utility = Double.valueOf(phoneCost.getText().toString());
        double phone = Double.valueOf(internetCost.getText().toString());
        double internet = Double.valueOf(tvCost.getText().toString());
        double tv = Double.valueOf(gasCost.getText().toString());
        double gas = Double.valueOf(groceryCost.getText().toString());
        double grocery = Double.valueOf(entertainmentCost.getText().toString());
        double entertainment = Double.valueOf(childCareCost.getText().toString());
        double childCare = Double.valueOf(insuranceCost.getText().toString());
        double debt = Double.valueOf(debtCost.getText().toString());
        double loans = Double.valueOf(loansCost.getText().toString());
        double clothes = Double.valueOf(clothesCost.getText().toString());
        double car = Double.valueOf(carCost.getText().toString());
        double saving = Double.valueOf(savings.getText().toString());


        incomeTotal.setText("Income: "+ income);
        mortgageCost.setText("Mortgage: " + mortgage);
        insuranceCost.setText("Insurance: " + insurance);
        utilityCost.setText("Utilities: " + utility);
        phoneCost.setText("Phone: " + phone);
        internetCost.setText("Internet: " + internet);
        tvCost.setText("T.V: " + tv);
        gasCost.setText("Gas: " + gas);
        groceryCost.setText("Groceries: " + grocery);
        entertainmentCost.setText("Entertainment: " + entertainment);
        childCareCost.setText("Child Care: " + childCare);
        debtCost.setText("Debt: " + debt);
        loansCost.setText("Loans: " + loans);
        clothesCost.setText("Clothes: " + clothes);
        carCost.setText("Car: " + car);
        savings.setText("Savings: " + saving);

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