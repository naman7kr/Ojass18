package ojass.in.ojass_18.Modals;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import ojass.in.ojass_18.Activities.TeamPage;
import ojass.in.ojass_18.R;

/**
 * Created by Sanay on 1/19/2018.
 */

public class teamPageElement extends RecyclerView.Adapter<myViewHolder> {

    private LayoutInflater inflator;
    List<teamPageInformation> teamPageList = Collections.emptyList();


    public teamPageElement(Context context, List<teamPageInformation> teamPageList)
    {
        inflator = LayoutInflater.from(context);
        this.teamPageList = teamPageList;
    }


    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflator.inflate(R.layout.team_member_element, parent, false);
        myViewHolder myviewholder = new myViewHolder(view);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {

        final teamPageInformation current=teamPageList.get(position);
        holder.description.setText(current.getDescription());
        holder.displayImage.setImageResource(current.getIconId());
        holder.name.setText(current.getName());
        holder.displayImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeamPage.setTeamImage(current);
            }
        });
    }

    @Override
    public int getItemCount() {
        return teamPageList.size();
    }
}

class myViewHolder extends RecyclerView.ViewHolder{

    ImageView displayImage;
    TextView name;
    TextView description;

    public myViewHolder(View itemView) {
        super(itemView);

        displayImage = itemView.findViewById(R.id.teampage_image);
        name = itemView.findViewById(R.id.teampage_name);
        description = itemView.findViewById(R.id.teampage_description);


    }
}


