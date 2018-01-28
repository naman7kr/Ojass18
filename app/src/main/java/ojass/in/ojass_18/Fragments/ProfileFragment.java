package ojass.in.ojass_18.Fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ojass.in.ojass_18.Adapters.ProfileRecyclerAdapter;
import ojass.in.ojass_18.R;



public class ProfileFragment extends Fragment {
    AppBarLayout appBar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    ImageView imageView,facebookIcon,instagramIcon,twitterIcon,youtubeIcon,profileImage;
    Toolbar toolBar;
    Button logoutButton,detailsButton;
    TextView profileName,profileEmail,profileOjassId;
    RecyclerView recyclerView;
    private List<String> listText=new ArrayList<>();

    int a=0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile, container, false);

        appBar=(AppBarLayout)view.findViewById(R.id.appBar);
        collapsingToolbarLayout=(CollapsingToolbarLayout)view.findViewById(R.id.collapsingToolBarLayout);


        imageView=(ImageView)view.findViewById(R.id.barcode_image);
        profileImage=(ImageView)view.findViewById(R.id.profile_image);
        facebookIcon=(ImageView)view.findViewById(R.id.facebook_icon);
        instagramIcon=(ImageView)view.findViewById(R.id.instagram_icon);
        twitterIcon=(ImageView)view.findViewById(R.id.twitter_icon);
        youtubeIcon=(ImageView)view.findViewById(R.id.youtube_icon);

        logoutButton=(Button)view.findViewById(R.id.logout_button);
        detailsButton=(Button)view.findViewById(R.id.details_button);

        profileName=(TextView)view.findViewById(R.id.profile_name);
        profileEmail=(TextView)view.findViewById(R.id.proile_email);
        profileOjassId=(TextView)view.findViewById(R.id.profile_ojassId);

        recyclerView=view.findViewById(R.id.recycler_view);

//        setSupportActionBar(toolBar);


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
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        ProfileRecyclerAdapter recyclerAdapter=new ProfileRecyclerAdapter(listText,getContext());
        recyclerView.setAdapter(recyclerAdapter);
        return view;

    }
    private void setUpRecycerList() {


        listText.add("Text1");
        listText.add("Text2");
        listText.add("Text3");
        listText.add("Text4");
        listText.add("Text5");



    }
}
