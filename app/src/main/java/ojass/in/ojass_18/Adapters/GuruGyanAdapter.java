package ojass.in.ojass_18.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import ojass.in.ojass_18.Infrastructure.GuruGyanElement;
import ojass.in.ojass_18.R;

/**
 * Created by dellpc on 1/14/2018.
 */

public class GuruGyanAdapter extends RecyclerView.Adapter<GuruGyanAdapter.MyviewHolder> {


    private LayoutInflater inflater;
    private List<GuruGyanElement> elements= Collections.emptyList();
    public GuruGyanAdapter(Context context, List<GuruGyanElement> element)
    {
        inflater=LayoutInflater.from(context);
        elements=element;
    }

    @Override
    public GuruGyanAdapter.MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=inflater.inflate(R.layout.gurugyan_ele,parent,false);
        MyviewHolder holder=new MyviewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(GuruGyanAdapter.MyviewHolder holder, int position) {

        GuruGyanElement current=elements.get(position);
        holder.image.setImageResource(current.getImage());
        holder.title.setText(current.getTitle());
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder
    {
        ImageView image;
        TextView title;
        public MyviewHolder(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.gurugyan_image);
            title=itemView.findViewById(R.id.gurugyan_title);
        }
    }
}
