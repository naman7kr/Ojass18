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

    private RecyclerView gurugyan_recycle;
    private GuruGyanAdapter guru_adapter;
    private List<GuruGyanElement> gurugyan_list;

    private RecyclerView sponsors;
    private TextView seeGuru;
    private TextView seeSpons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gurugyan_list=new ArrayList<>();
        gurugyan_list.add(new GuruGyanElement(R.drawable.ic_launcher_background,"Title1"));
        gurugyan_list.add(new GuruGyanElement(R.drawable.ic_launcher_background,"TITLE2"));
        gurugyan_list.add(new GuruGyanElement(R.drawable.ic_launcher_background,"TITLE3"));
        gurugyan_list.add(new GuruGyanElement(R.drawable.ic_launcher_background,"TITLE4"));
        gurugyan_list.add(new GuruGyanElement(R.drawable.ic_launcher_background,"TITLE5"));
        seeGuru=findViewById(R.id.gurugyan_seeall);
        seeSpons=findViewById(R.id.sponsor_seeall);

        seeGuru.setOnClickListener(this);
        seeSpons.setOnClickListener(this);
        guru_adapter=new GuruGyanAdapter(this,gurugyan_list);
        gurugyan_recycle=findViewById(R.id.guru_recycler);
        gurugyan_recycle.setAdapter(guru_adapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager sponsorlayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        gurugyan_recycle.setLayoutManager(linearLayoutManager);

        sponsors=findViewById(R.id.sponsor_recycler);
        sponsors.setAdapter(guru_adapter);
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
