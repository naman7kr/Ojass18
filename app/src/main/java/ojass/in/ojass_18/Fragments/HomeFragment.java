package ojass.in.ojass_18.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import ojass.in.ojass_18.Infrastructure.GuruGyanElement;
import ojass.in.ojass_18.R;



public class HomeFragment extends Fragment implements View.OnClickListener {
    private RecyclerView gurugyanRecycle;
    private GuruGyanAdapter guruAdapter;
    private List<GuruGyanElement> gurugyanList;

    private RecyclerView sponsors;
    private TextView seeGuru;
    private TextView seeSpons;
    private View v;

    private RecyclerView eventrecycler;
    private RecyclerView.LayoutManager eventlayoutmanager;
    private RecyclerView.Adapter eventadapter;
    private TextView eventSeeAll;
    private ArrayList<String> dataset;
    ViewPager mviewPager;
    SliderAdapter sliderAdapter;
    CircleIndicator indicator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        v=view;
        //Sanays Work
        mviewPager = view.findViewById(R.id.mainactivity_viewpager);
        indicator = view.findViewById(R.id.mainactivity_dots);
        sliderAdapter = new SliderAdapter(getContext());
        mviewPager.setAdapter(sliderAdapter);
        indicator.setViewPager(mviewPager);


        //Anirudhs Work
        gurugyanList=new ArrayList<>();
        gurugyanList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"Title1"));
        gurugyanList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"TITLE2"));
        gurugyanList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"TITLE3"));
        gurugyanList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"TITLE4"));
        gurugyanList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"TITLE5"));
        seeGuru=view.findViewById(R.id.gurugyan_seeall);
        seeSpons=view.findViewById(R.id.sponsor_seeall);

        seeGuru.setOnClickListener(this);
        seeSpons.setOnClickListener(this);
        guruAdapter=new GuruGyanAdapter(getContext(),gurugyanList);
        gurugyanRecycle=view.findViewById(R.id.guru_recycler);
        gurugyanRecycle.setAdapter(guruAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        gurugyanRecycle.setLayoutManager(linearLayoutManager);

        sponsors=view.findViewById(R.id.sponsor_recycler);
        LinearLayoutManager sponsorlayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        sponsors.setAdapter(guruAdapter);
        sponsors.setLayoutManager(sponsorlayoutManager);

        //Gaurav Sethis work
        eventSeeAll=view.findViewById(R.id.events_seeall);
        eventSeeAll.setOnClickListener(this);
        dataset=new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            dataset.add("gaurav");
        }

        eventrecycler=view.findViewById(R.id.event_recycler);
        eventrecycler.setHasFixedSize(true);

        eventlayoutmanager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        eventrecycler.setLayoutManager(eventlayoutmanager);

        eventadapter = new EventAdapter(dataset);
        eventrecycler.setAdapter(eventadapter);
        return view;
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
}

