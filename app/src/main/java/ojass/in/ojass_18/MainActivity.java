package ojass.in.ojass_18;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppBarLayout appBar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    ImageView imageView,facebookIcon,instagramIcon,twitterIcon,youtubeIcon,profileImage;
    Toolbar toolBar;
    Button logoutButton,detailsButton;
    TextView profileName,profileEmail,profileOjassId;
    RecyclerView recyclerView;

    private List<String> listText=new ArrayList<>();
    int a=0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        appBar=(AppBarLayout)findViewById(R.id.appBar);
        toolBar=(Toolbar)findViewById(R.id.toolBar);
        collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsingToolBarLayout);

        imageView=(ImageView)findViewById(R.id.barcode_image);
        profileImage=(ImageView)findViewById(R.id.profile_image);
        facebookIcon=(ImageView)findViewById(R.id.facebook_icon);
        instagramIcon=(ImageView)findViewById(R.id.instagram_icon);
        twitterIcon=(ImageView)findViewById(R.id.twitter_icon);
        youtubeIcon=(ImageView)findViewById(R.id.youtube_icon);

        logoutButton=(Button)findViewById(R.id.logout_button);
        detailsButton=(Button)findViewById(R.id.details_button);

        profileName=(TextView)findViewById(R.id.profile_name);
        profileEmail=(TextView)findViewById(R.id.proile_email);
        profileOjassId=(TextView)findViewById(R.id.profile_ojassId);

        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);

        setSupportActionBar(toolBar);


        recyclerView.setVisibility(recyclerView.GONE);

        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(a==0)
                {    a++;
                    recyclerView.setVisibility(recyclerView.VISIBLE);
                }else
                {
                    a--;
                    recyclerView.setVisibility(recyclerView.GONE);
                }
            }
        });


        facebookIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    Intent facebookIntent =new Intent(Intent.ACTION_VIEW);
                    facebookIntent.setPackage("com.facebook.katana");
                    facebookIntent.setData(Uri.parse("https://www.facebook.com/Ojassnitjamshedpur"));
                    startActivity(facebookIntent);
                } catch (ActivityNotFoundException e) {
                    Intent  facebookIntent= new Intent(Intent.ACTION_VIEW);
                    facebookIntent.setData(Uri.parse("https://www.facebook.com/Ojassnitjamshedpur"));
                    startActivity(facebookIntent);
                }

            }
        });



        twitterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent twitterIntent =new Intent(Intent.ACTION_VIEW);
                    twitterIntent.setPackage("com.twitter.android");
                    twitterIntent.setData(Uri.parse("https://www.twitter.com/search?q=ojass%20nit%20jamshedpur&s=09"));
                    startActivity(twitterIntent);
                } catch (ActivityNotFoundException e) {
                    Intent  twitterIntent = new Intent(Intent.ACTION_VIEW);
                    twitterIntent.setData(Uri.parse("https://www.twitter.com/search?q=ojass%20nit%20jamshedpur&s=09"));
                    startActivity(twitterIntent);
                }
            }
        });
        instagramIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                try {
                    Intent instagramIntent =new Intent(Intent.ACTION_VIEW);
                    instagramIntent.setPackage("com.instagram.android");
                    instagramIntent.setData(Uri.parse("https://www.instagram.com/ojass_nitjsr/"));
                    startActivity( instagramIntent);
                } catch (ActivityNotFoundException e) {
                    Intent   instagramIntent = new Intent(Intent.ACTION_VIEW);
                    instagramIntent.setData(Uri.parse("https://www.instagram.com/ojass_nitjsr/"));
                    startActivity( instagramIntent);
                }
            }
        });



        youtubeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                try {
                    Intent youtubeIntent=new Intent(Intent.ACTION_VIEW);
                    youtubeIntent.setPackage("com.google.android.youtube");
                    youtubeIntent.setData(Uri.parse("https://www.youtube.com/user/ojassnitjsr"));
                    startActivity(youtubeIntent);
                } catch (ActivityNotFoundException e) {
                    Intent  youtubeIntent= new Intent(Intent.ACTION_VIEW);
                    youtubeIntent.setData(Uri.parse("https://www.youtube.com/user/ojassnitjsr"));
                    startActivity(youtubeIntent);
                }
            }
        });



        setUpRecycerList();

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(listText,this);
        recyclerView.setAdapter(recyclerAdapter);


    }

    private void setUpRecycerList() {


        listText.add("Text1");
        listText.add("Text2");
        listText.add("Text3");
        listText.add("Text4");
        listText.add("Text5");



    }


}





