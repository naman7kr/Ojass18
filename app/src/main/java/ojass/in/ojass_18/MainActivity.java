package ojass.in.ojass_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView gurugyan_recycle;
    private GuruGyan_adapter guru_adapter;
    private List<GuruGyan_element> gurugyan_list;

    private RecyclerView sponsors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gurugyan_list=new ArrayList<>();
        gurugyan_list.add(new GuruGyan_element(R.drawable.ic_launcher_background,"Title1"));
        gurugyan_list.add(new GuruGyan_element(R.drawable.ic_launcher_background,"TITLE2"));
        gurugyan_list.add(new GuruGyan_element(R.drawable.ic_launcher_background,"TITLE3"));
        gurugyan_list.add(new GuruGyan_element(R.drawable.ic_launcher_background,"TITLE4"));
        gurugyan_list.add(new GuruGyan_element(R.drawable.ic_launcher_background,"TITLE5"));

        guru_adapter=new GuruGyan_adapter(this,gurugyan_list);
        gurugyan_recycle=findViewById(R.id.guru_recycler);
        gurugyan_recycle.setAdapter(guru_adapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager sponsorlayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        gurugyan_recycle.setLayoutManager(linearLayoutManager);

        sponsors=findViewById(R.id.sponsor_recycler);
        sponsors.setAdapter(guru_adapter);
        sponsors.setLayoutManager(sponsorlayoutManager);

    }
}
