package ojass.in.ojass_18.Adapters;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import ojass.in.ojass_18.Modals.EventsModel;
import ojass.in.ojass_18.R;



public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private ArrayList<EventsModel> dataset;
    private Context context;
    public EventAdapter(ArrayList<EventsModel> dataset, Context context) {
        this.dataset = dataset;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.event_element,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        EventsModel current=dataset.get(position);
        Picasso.with(context).load(current.getImage()).fit().into(holder.eventImg);
        holder.eventele.setText(current.getEventName());
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
