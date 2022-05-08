package ca.georgebrown.comp3074.adulting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PersonalSkillsStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_skills_start);
    }

    public void startQuiz(View view) {

        int quizCategory = 0; //All

        switch(view.getId()) {
            case R.id.time:
                quizCategory = 1;
                break;
            case R.id.cooking:
                quizCategory = 2;
                break;
            case R.id.relationship:
                quizCategory = 3;
                break;
        }

        Intent intent = new Intent(getApplicationContext(), PersonalSkillsQuizzesActivity.class);
        intent.putExtra("QUIZ_CATEGORY", quizCategory);
        startActivity(intent);



    }

}