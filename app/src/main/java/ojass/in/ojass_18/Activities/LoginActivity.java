package ojass.in.ojass_18.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ojass.in.ojass_18.R;

public class LoginActivity extends AppCompatActivity {

    Button Gotodash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final SharedPreferences sharedPref = getSharedPreferences("sharedPref", MODE_PRIVATE);
        Gotodash=(Button) findViewById(R.id.dash);
        Gotodash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });
    }
}
