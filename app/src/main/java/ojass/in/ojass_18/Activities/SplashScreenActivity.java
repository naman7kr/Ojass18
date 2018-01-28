package ojass.in.ojass_18.Activities;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


import ojass.in.ojass_18.R;


public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);
        final SharedPreferences sharedPref = getSharedPreferences("sharedPref", MODE_PRIVATE);

        startActivity(new Intent(this, MainActivity.class));
        finish();

        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sharedPref.getBoolean("isFirst", true)){
                    startActivity(new Intent(SplashScreenActivity.this, IntroActivity.class));
                    sharedPref.edit().putBoolean("isFirst", false).apply();
                    finish();
                } else {
                    startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                    finish();
                }
            }
        }, 2000); */
    }



}
