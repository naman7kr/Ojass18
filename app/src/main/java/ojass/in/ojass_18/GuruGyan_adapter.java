package ojass.in.ojass_18;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by dellpc on 1/14/2018.
 */

public class GuruGyan_adapter extends RecyclerView.Adapter<GuruGyan_adapter.MyviewHolder> {


    private LayoutInflater inflater;
    private List<GuruGyan_element> elements= Collections.emptyList();
    public GuruGyan_adapter(Context context, List<GuruGyan_element> element)
    {
        inflater=LayoutInflater.from(context);
        elements=element;
    }

    @Override
    public GuruGyan_adapter.MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=inflater.inflate(R.layout.gurugyan_ele,parent,false);
        MyviewHolder holder=new MyviewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(GuruGyan_adapter.MyviewHolder holder, int position) {

        GuruGyan_element current=elements.get(position);
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
