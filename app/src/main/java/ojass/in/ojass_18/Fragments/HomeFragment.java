package ojass.in.ojass_18.Fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import me.relex.circleindicator.CircleIndicator;
import ojass.in.ojass_18.Activities.EventActivity;
import ojass.in.ojass_18.Activities.GurugyanActivity;
import ojass.in.ojass_18.Activities.SponsorsActivity;
import ojass.in.ojass_18.Adapters.EventAdapter;
import ojass.in.ojass_18.Adapters.GuruGyanAdapter;
import ojass.in.ojass_18.Adapters.SliderAdapter;
import ojass.in.ojass_18.Modals.GuruGyanElement;
import ojass.in.ojass_18.R;



public class HomeFragment extends Fragment implements View.OnClickListener {
    private RecyclerView rvGuruGyan, rvSponsors, rvEvents;
    private GuruGyanAdapter guruAdapter;
    private GuruGyanAdapter sponsorAdapter;
    private List<GuruGyanElement> gurugyanList;
    private List<GuruGyanElement> sponsorList;
    private TextView seeGuru;
    private TextView seeSpons;
    private View v;
    private RecyclerView.LayoutManager eventlayoutmanager;
    private RecyclerView.Adapter eventadapter;
    private TextView eventSeeAll;
    private ArrayList<String> dataset;
    private ViewPager mviewPager;
    private SliderAdapter sliderAdapter;
    private CircleIndicator indicator;
    private int itemCount;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        v=view;
        mviewPager = view.findViewById(R.id.home_fragment_viewpager);
        sliderAdapter = new SliderAdapter(getContext());


        changeSlider();

        mviewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changeSlider();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //Sanays Work
        addImageSlider(view);

        //Gaurav Sethis work
        prepareEvents(view);

        //Anirudhs Work
        prepareGuruGyan(view);

        //another Anirudh Work
        prepareSponsor(view);

        return view;
    }

    private void prepareEvents(View view) {
        eventSeeAll=view.findViewById(R.id.events_seeall);
        eventSeeAll.setOnClickListener(this);
        dataset=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dataset.add("gaurav");
        }
        rvEvents =view.findViewById(R.id.event_recycler);
        rvEvents.setHasFixedSize(true);
        eventlayoutmanager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvEvents.setLayoutManager(eventlayoutmanager);
        eventadapter = new EventAdapter(dataset);
        rvEvents.setAdapter(eventadapter);
    }

    private void prepareGuruGyan(View view) {
        gurugyanList=new ArrayList<>();
        gurugyanList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"Title1"));
        gurugyanList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"TITLE2"));
        gurugyanList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"TITLE3"));
        gurugyanList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"TITLE4"));
        gurugyanList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"TITLE5"));
        seeGuru=view.findViewById(R.id.gurugyan_seeall);


        seeGuru.setOnClickListener(this);

        guruAdapter=new GuruGyanAdapter(getContext(),gurugyanList);
        rvGuruGyan =view.findViewById(R.id.guru_recycler);
        rvGuruGyan.setAdapter(guruAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvGuruGyan.setLayoutManager(linearLayoutManager);



    }

    private void prepareSponsor(View view)
    {
        sponsorList=new ArrayList<>();
        sponsorList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"sponsor1"));
        sponsorList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"sponsor2"));
        sponsorList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"sponsor3"));
        sponsorList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"sponsor4"));
        sponsorList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"sponsor5"));
        seeSpons=view.findViewById(R.id.sponsor_seeall);
        seeSpons.setOnClickListener(this);

        sponsorAdapter=new GuruGyanAdapter(getContext(),sponsorList);
        rvSponsors =view.findViewById(R.id.sponsor_recycler);
        LinearLayoutManager sponsorlayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvSponsors.setAdapter(sponsorAdapter);
        rvSponsors.setLayoutManager(sponsorlayoutManager);
    }

    private void addImageSlider(View view) {

        indicator = view.findViewById(R.id.mainactivity_dots);
        mviewPager.setAdapter(sliderAdapter);
        indicator.setViewPager(mviewPager);

    }


    @Override
    public void onClick(View view) {

        if(view==v.findViewById(R.id.gurugyan_seeall))
        {
            startActivity(new Intent(getContext(),GurugyanActivity.class));
        }
         if(view==v.findViewById(R.id.sponsor_seeall))
        {
            startActivity(new Intent(getContext(),SponsorsActivity.class));
        }
        if(view==v.findViewById(R.id.events_seeall))
        {
            startActivity(new Intent(getContext(),EventActivity.class));
        }
    }

    public void changeSlider()
    {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int currentItem=mviewPager.getCurrentItem();
                itemCount=sliderAdapter.getCount();
                if(currentItem<itemCount-1)
                {
                    mviewPager.setCurrentItem(currentItem+1);
                }
                else
                {
                    mviewPager.setCurrentItem(0);
                }
            }
        }, 5*1000);

    }
}

