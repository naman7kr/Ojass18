package ojass.in.ojass_18.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ojass.in.ojass_18.Modals.teamPageElement;
import ojass.in.ojass_18.Modals.teamPageInformation;
import ojass.in.ojass_18.R;

public class teamPage extends AppCompatActivity {

    RecyclerView teamMembers;
    teamPageElement adapter;
    ImageButton imageButton;
     static ImageView imageView;
     static TextView largeName;
     static TextView largedescription;
     static String telephone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_page_activity);

        imageView = findViewById(R.id.teampage_largeimage);
        largedescription = findViewById(R.id.teampage_largedescription);
        largeName = findViewById(R.id.teampage_largename);
        imageButton = findViewById(R.id.teampage_callbutton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+telephone));
                startActivity(intent);
            }
        });
        List<teamPageInformation> list1=new ArrayList<>();
        adapter = new teamPageElement(this, list1);

        list1.add(new teamPageInformation(R.drawable.portrait, "Sanay" , "President","123456789"));
        list1.add(new teamPageInformation(R.drawable.portraittwo, "Anirudh" , "Vice President","2979789"));
        list1.add(new teamPageInformation(R.drawable.portraitthree, "Aditya" , "Tech Secratary","3526191"));
        list1.add(new teamPageInformation(R.drawable.portraitfour, "Abhishek" , "Ojass Head","4662290"));
        list1.add(new teamPageInformation(R.drawable.portrait, "Sanay" , "President","123456789"));
        list1.add(new teamPageInformation(R.drawable.portraittwo, "Anirudh" , "Vice President","2979789"));
        list1.add(new teamPageInformation(R.drawable.portraitthree, "Aditya" , "Tech Secratary","3526191"));
        list1.add(new teamPageInformation(R.drawable.portraitfour, "Abhishek" , "Ojass Head","4662290"));
        list1.add(new teamPageInformation(R.drawable.portrait, "Sanay" , "President","123456789"));
        list1.add(new teamPageInformation(R.drawable.portraittwo, "Anirudh" , "Vice President","2979789"));
        list1.add(new teamPageInformation(R.drawable.portraitthree, "Aditya" , "Tech Secratary","3526191"));
        list1.add(new teamPageInformation(R.drawable.portraitfour, "Abhishek" , "Ojass Head","4662290"));

        telephone = list1.get(0).getPhone();
        largeName.setText(list1.get(0).getName());
        largedescription.setText(list1.get(0).getDescription());
        imageView.setImageResource(list1.get(0).getIconId());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        teamMembers = findViewById(R.id.teampage_recyclerView);
        teamMembers.setAdapter(adapter);
        teamMembers.setLayoutManager(linearLayoutManager);

    }
    public static void setTeamImage(teamPageInformation current)
    {
        imageView.setImageResource(current.getIconId());
        largeName.setText(current.getName());
        largedescription.setText(current.getDescription());
        telephone = current.getPhone();
    }
}
