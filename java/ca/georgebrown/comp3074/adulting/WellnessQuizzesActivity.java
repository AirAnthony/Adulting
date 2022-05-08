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

public class WellnessQuizzesActivity extends AppCompatActivity {

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
            {"Depression is", "a common struggle in society", "not a common struggle in society", "not a big deal", "not related to mental health"},
            {"Ways to overcome depression include", "be in the present, go outside, good sleep, and meditate", "be in the present, go outside, meditate", "stay inside, be in the present, meditate", "get good sleep, go outside, meditate"},
            {"Meditation is", "accessible to everyone", "not accessible to everyone", "accessible to the rich only", "accessible to smart people only"},
            {"People new to meditation should meditate for", "5-10 minutes", "1 minute", "30 minutes", "1 hour"},
            {"Adults should get", "7-8 hours of sleep", "at least 6 hours of sleep", "12 hours of sleep", "7 hours of sleep"},
            {"Stress", "can be different for everybody", "is the same for everybody", "not important", "not understandable"},
            {"This app introduced", "7 stress management techniques", "2 stress management techniques", "5 stress management techniques", "6 stress management techniques"},
            {"Signs that you are stressed out are", "low tolerance, headaches, and stomach pains", "headaches", "headaches and stomach pains", "headaches and low tolerance"},
            {"Meditating or talking to someone are examples of", "healthy stress management techniques", "recognizing your stress signals", "recognizing your stress strategies", "understanding your stress"},
            {"You should take care of yourself before helping others", "true", "not true", "either or", "you shouldn't take care of yourself"},
            {"You should", "leave toxic people", "stay with toxic people", "become toxic with them", "either stay or leave toxic people"},
            {"Speaking up to toxic people", "is necessary", "is not a good idea", "depends who the toxic person is", "should be delayed"},
            {"You should show sympathy to toxic people when", "they are depressed or mentally ill", "you should never show sympathy", "you've known them for a long time", "it doesn't make sense"},
            {"When toxic people put the blame on you you should", "not take it personally", "take it personally", "get angry", "get angry", "try to get even"},
            {"If a person is toxic", "you should take time to distance yourself from them", "stay close to them", "mix of distance and close", "should never distance yourself"}
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellness_quizzes);


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
                    Intent intent = new Intent(getApplicationContext(), WellnessResultActivity.class);
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