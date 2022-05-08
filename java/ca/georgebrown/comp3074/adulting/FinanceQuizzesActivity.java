package ca.georgebrown.comp3074.adulting;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FinanceQuizzesActivity extends AppCompatActivity {

    private TextView countLabel;
    private TextView questionLabel;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            // {"Country", "Right Answer", "Choice1", "Choice2", "Choice3"}
            {"What is a budget?", "compares income and expenses for a set period of time", "compares credit and debit", "related to stocks", "not important"},
            {"Groceries, gas, and insurance are examples of expenses", "true", "false", "depends", "both"},
            {"A budget helps you...", "save money", "build credit", "spend money", "it does not help you"},
            {"The key to a budget is to", "have balance", "spend more than you make", "neither balanced or unbalanced", "have slight balance"},
            {"Savings is calculated by ", "income - expenses", "expenses - income", "income x expenses", "income / expenses"},
            {"A credit score ranges from ", "300-850", "200-340", "0-100", "500-1000"},
            {"Excellent credit ranges from", "800-850", "300-579", "670-739", "740-799"},
            {"A step to build/maintain credit is", "make payments on time", "keep balances high", "open many accounts", "pay off loans and debts irregularly"},
            {"Credit scores are calculated by looking at", "If you've paid past credit accounts on time", "the amount of time you've had a debit card", "the amount of debit products you have", "credit can't be calculated"},
            {"Having a good credit score is", "essential", "not essential", "neither essential or non essential", "you want a bad credit score"},
            {"Pay the", "smallest debts first", "largest debts first", "smallest or largest debts first", "median debts first"},
            {"A step to conquer debt is", "get a side job", "get rid of coupons", "shop at expensive stores", "go out to eat"},
            {"A debt tracker includes", "payee, balance, and interest, min pay, actual pay", "balance and interest", "min and actual pay", "payee only"},
            {"A debt tracker", "helps you track debt repayment", "helps you track your income", "helps you track credit", "is not important"},
            {"You should", "pay more than the minimum on monthly debt payments", "pay less than the minimum on monthly debt payments", "pay more than the minimum on yearly debt payments", "pay the minimum on monthly debt payments"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_quizzes);

        countLabel = (TextView)findViewById(R.id.countLabel);
        questionLabel = (TextView)findViewById(R.id.questionLabel);
        answerBtn1 = (Button)findViewById(R.id.answerBtn1);
        answerBtn2 = (Button)findViewById(R.id.answerBtn2);
        answerBtn3 = (Button)findViewById(R.id.answerBtn3);
        answerBtn4 = (Button)findViewById(R.id.answerBtn4);

        // Receive quizCategory from StartActivity.
        int quizCategory = getIntent().getIntExtra("QUIZ_CATEGORY", 0);

        Log.v("CATEGORY_TAG", quizCategory + "");


        // Create quizArray from quizData.
        for (int i = 0; i < quizData.length; i++) {

            // Prepare array.
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); // Country
            tmpArray.add(quizData[i][1]); // Right Answer
            tmpArray.add(quizData[i][2]); // Choice1
            tmpArray.add(quizData[i][3]); // Choice2
            tmpArray.add(quizData[i][4]); // Choice3

            // Add tmpArray to quizArray.
            quizArray.add(tmpArray);
        }

        showNextQuiz();

    }

    public void showNextQuiz() {

        // Update quizCountLabel.
        countLabel.setText("Q" + quizCount);

        // Generate random number between 0 and 14 (quizArray's size - 1).
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        // Pick one quiz set.
        ArrayList<String> quiz = quizArray.get(randomNum);

        //Set question and right answer.
        // Array format: {"Country", "Right Answer", "Choice1", "Choice2", "Choice3"}
        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        // Remove "Country" from quiz and Shuffle choices.
        quiz.remove(0);
        Collections.shuffle(quiz);

        // Set Choices.
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        // Remove this quiz from quizArray.
        quizArray.remove(randomNum);

    }

    public void checkAnswer(View view) {

        // Get pushed button.
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if(btnText.equals(rightAnswer)) {
            // Correct!
            alertTitle = "Correct!";
            rightAnswerCount++;
        } else {
            // Wrong...
            alertTitle = "Wrong...";
        }

        // Create Dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer : " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizCount == QUIZ_COUNT) {
                    // Show Result.
                    Intent intent = new Intent(getApplicationContext(), FinanceResultActivity.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);

                } else {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();

    }

}