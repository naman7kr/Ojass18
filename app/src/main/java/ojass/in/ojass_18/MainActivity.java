package ojass.in.ojass_18;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    AppBarLayout appbar;
    CollapsingToolbarLayout ctool;
    ImageView iv1;
    Toolbar toolbar;
    CircleImageView itemImage;


    boolean ExpandedActionBar =true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar=(Toolbar)findViewById(R.id.tool);
        ctool=(CollapsingToolbarLayout)findViewById(R.id.ctool);
        iv1=(ImageView)findViewById(R.id.iv1);
        appbar=(AppBarLayout)findViewById(R.id.appbar);
        itemImage=(CircleImageView)findViewById(R.id.itemImage);

        setSupportActionBar(toolbar);


    }
}





