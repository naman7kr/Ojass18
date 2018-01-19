package ojass.in.ojass_18.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import ojass.in.ojass_18.R;

public class MainActivity extends AppCompatActivity  {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private RelativeLayout rLayout;
    private Toolbar toolbar;
    private Dialog mDialog;
    private Button slideUpButton;
    private SlidingUpPanelLayout slidingLayout;
    Animation slide_down;
    Animation slide_up;
    private Button teampagebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.include_toolbar);
        setSupportActionBar(toolbar);
        //setBottomNavigation();
        teampagebutton = findViewById(R.id.teampage_button);
        teampagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, teamPage.class);
                startActivity(intent);
            }
        });
    }


}