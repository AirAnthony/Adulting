package ca.georgebrown.comp3074.adulting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PersonalSkillsResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_skills_result);

        TextView resultLabel = (TextView) findViewById(R.id.resultLabel);
        TextView totalScoreLabel = (TextView) findViewById(R.id.totalScoreLabel);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);

        SharedPreferences settings = getSharedPreferences("quizApp", Context.MODE_PRIVATE);
        int totalScore = settings.getInt("totalScore", 0);
        totalScore += score;

        resultLabel.setText(score + " / 5");
        totalScoreLabel.setText("Total Score : " + totalScore);

        // Update total score.
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("totalScore", totalScore);
        editor.commit();

    }

    public void returnTop3(View view) {
        Intent intent = new Intent(getApplicationContext(), PersonalSkillsStartActivity.class);
        startActivity(intent);

    }

}