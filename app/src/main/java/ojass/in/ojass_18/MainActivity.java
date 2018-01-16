package ojass.in.ojass_18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView gurugyanRecycle;
    private GuruGyanAdapter guruAdapter;
    private List<GuruGyanElement> gurugyanList;

    private RecyclerView sponsors;
    private TextView seeGuru;
    private TextView seeSpons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gurugyanList=new ArrayList<>();
        gurugyanList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"Title1"));
        gurugyanList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"TITLE2"));
        gurugyanList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"TITLE3"));
        gurugyanList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"TITLE4"));
        gurugyanList.add(new GuruGyanElement(R.drawable.ic_launcher_background,"TITLE5"));
        seeGuru=findViewById(R.id.gurugyan_seeall);
        seeSpons=findViewById(R.id.sponsor_seeall);

        seeGuru.setOnClickListener(this);
        seeSpons.setOnClickListener(this);
        guruAdapter=new GuruGyanAdapter(this,gurugyanList);
        gurugyanRecycle=findViewById(R.id.guru_recycler);
        gurugyanRecycle.setAdapter(guruAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        gurugyanRecycle.setLayoutManager(linearLayoutManager);

        sponsors=findViewById(R.id.sponsor_recycler);
        LinearLayoutManager sponsorlayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        sponsors.setAdapter(guruAdapter);
        sponsors.setLayoutManager(sponsorlayoutManager);

    }

    @Override
    public void onClick(View view) {

        if(view==findViewById(R.id.gurugyan_seeall))
        {
            startActivity(new Intent(this,GurugyanActivity.class));
        }
        else if(view==findViewById(R.id.sponsor_seeall))
        {
            startActivity(new Intent(this,SponsorsActivity.class));
        }
    }
}
