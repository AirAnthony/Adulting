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

public class PersonalSkillsQuizzesActivity extends AppCompatActivity {

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
            {"When cooking you should", "always follow the recipe", "try new ideas with an existing recipe", "don't follow the recipe", "recipes aren't important"},
            {"To avoid burning yourself", "keep cookware handles away from burners", "keep cookware handles near burners", "keep cookware handles a bit close to burners", "burns aren't that bad"},
            {"Leaving the kitchen unattended can", "ruin the meal and start a fire", "ruin the meal", "start a fire", "won't do anything"},
            {"When cooking", "do not put food in a cold pan", "put food in a cold pan", "overcrowd cookware", "prep your ingredients after you start cooking"},
            {"The best way to prevent injury is to", "use good quality utensils", "use cheap utensils", "use any quality utensils", "not sure"},
            {"A task list consists of", "high, medium, and low priorities plus due dates", "low and medium priorities plus due dates", "high, medium, and low priorities", "high and medium priorities plus due dates"},
            {"Time management skills can lead to being more", "dependable, productive, and efficient", "not much", "dependable and productive", "productive and efficient"},
            {"Time management is the practice of", "planning out your daily activities and sticking to it", "being on time", "planning out your daily activities", "checking the time"},
            {"Some of the tips for time management include", "Do the most critical tasks in the morning", "do multiple tasks at the same time", "make another to do list next week", "group unrelated tasks together"},
            {"Poor time management can lead to", "poor work quality and higher stress", "a bit of a nuisance", "poor work quality", "higher stress"},
            {"When it comes to relationships being honest", "is important", "should be avoided if the truth hurts", "depends on the situation", "is never a good idea"},
            {"When it comes to other people's feelings and thoughts", "you should be understanding", "you should never compromise", "compromise after they hear your thoughts first", "compromise only until you disagree"},
            {"When it comes to trust", "you should be trusting of those close to you", "only trust yourself", "trust those close to you if they trust you", "trust those close to you when you feel like it"},
            {"With people close to you, you should", "be yourself", "be what people want you to be", "not express feelings if they're embarrassing", "emulate someone you admire"},
            {"When there is conflict", "it can be healthy", "it never leads to anything good", "blame should be placed", "let your anger take over"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_skills_quizzes);

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
                    Intent intent = new Intent(getApplicationContext(), PersonalSkillsResultActivity.class);
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