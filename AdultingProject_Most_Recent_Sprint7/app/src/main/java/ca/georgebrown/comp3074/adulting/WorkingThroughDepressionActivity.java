package ca.georgebrown.comp3074.adulting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


public class WorkingThroughDepressionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working_through_depression);


        ConstraintLayout constraintLayout = findViewById(R.id.layoutForWorkingThroughDepression);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        VideoView videoView = findViewById(R.id.wellnessVideo);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video3;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);



        Button journalbtn = (Button) findViewById(R.id.journalbtn);

        //set text for wellness depression page
        TextView wellnessText1 =(TextView) findViewById(R.id.wellnessText1);
        String wT1 ="Maintaining Your mental health has never been so important. Depression " +
                "is a common struggle in society, but there are ways that you can overcome!";
        wellnessText1.setText(wT1);

        TextView wellnessText2 =(TextView) findViewById(R.id.wellnessText2);
        String wT2 ="Breathing exercises can be an effective tool to relieving stress, anxiety and depression." +
                "Watch this instructional video and see how the simple act of breathing can improve your mood!";
        wellnessText2.setText(wT2);

        TextView wellnessText3 =(TextView) findViewById(R.id.wellnessText3);
        String wT3 ="1. Stay in the present: With technology constantly evolving and being integrated more " +
                "into our daily lives, people spend less time in the present now more than ever before.  " +
                "It is important to set certain times within your day to turn off your devices. Try disconnecting " +
                "when you’re eating, talking to others, or traveling. Social media " +
                "can cause people to compare their lives with what they see on social platforms. " +
                "By taking time to step away from your device you become more grateful for what " +
                "you have.  ";
        wellnessText3.setText(wT3);

        TextView wellnessText4 =(TextView) findViewById(R.id.wellnessText4);
        String wT4 ="2. Get outside: Going for a nice walk is a good way to distract yourself from your thoughts.  " +
                "Not only does it benefit your mental health, but also your physical health.  The longer the walk " +
                "the better.  When we exercise endorphins are released, which helps our mood.  You should try to " +
                "walk at least three times a week and for a duration of fifty minutes or more.  A short walk will " +
                "have a big impact on your mood.";
        wellnessText4.setText(wT4);

        TextView wellnessText5 =(TextView) findViewById(R.id.wellnessText5);
        String wT5 ="3. Get a good sleep: Sleep is very crucial to a good mood.  Adults should get at least 7 – 8 " +
                "hours a night.  It is also important to keep a consistent sleep schedule in order to fall asleep " +
                "easily. Seeing the natural light of the sun has an effect on an individual’s mood.  " +
                "If you struggle to sleep remember to not look at any screens for at least two hours prior to going " +
                "to bed.  Reading a book and taking a bath also help. ";
        wellnessText5.setText(wT5);

        TextView wellnessText6 =(TextView) findViewById(R.id.wellnessText6);
        String wT6 ="4. Meditate: Meditation is one of the best ways to improve your mental health.  What makes " +
                "mediation so great is it’s accessibility to everyone.  All you need is yourself and a quiet " +
                "environment.  Meditation not only reduces stress and anxiety, but also improves sleep.  It is said " +
                "that meditation is about as effective as antidepressants.  If you are just starting out, try " +
                "meditation for five to ten minutes. Over time you can build up to longer sessions." +
                "Throughout your meditation remember to focus on your breathing and being in the present moment.";
        wellnessText6.setText(wT6);

        TextView wellnessText7 =(TextView) findViewById(R.id.wellnessText7);
        String wT7 ="It has been proven that keeping a gratitude journal can exponentially improve your mood. " +
                "Use the space below to write some things in your life that you are grateful for! You'll notice " +
                "that taking part in this simple activity just for two minutes a day can have a wonderful impact " +
                "on your overall attitude and happiness!";
        wellnessText7.setText(wT7);

        journalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WorkingThroughDepressionActivity.this,
                        "Your Journal Input is Saved", Toast.LENGTH_LONG).show();
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
