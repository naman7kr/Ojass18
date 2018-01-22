package ojass.in.ojass_18.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ojass.in.ojass_18.R;


public class ProfileRecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {


    private List<String> listText = new ArrayList<>();
    private Context context;

    public ProfileRecyclerAdapter(List<String> listText, Context context) {
        this.listText = listText;
        this.context = context;

    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.profile_recycler_layout, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.recyclerText1.setText(listText.get(position));


    }

    @Override
    public int getItemCount() {
        return listText.size();
    }
}