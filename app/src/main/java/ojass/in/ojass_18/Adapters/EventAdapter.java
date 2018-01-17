package ojass.in.ojass_18.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ojass.in.ojass_18.R;

/**
 * Created by dellpc on 1/17/2018.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private ArrayList<String> dataset;
    public EventAdapter(ArrayList<String> dataset) {
        this.dataset = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.event_element,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.eventele.setText(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView eventele;
        public ImageView eventImg;
        public ViewHolder(View itemView) {
            super(itemView);
            eventele=itemView.findViewById(R.id.event_ele);
            eventImg=itemView.findViewById(R.id.eventImg);
        }
    }
}
