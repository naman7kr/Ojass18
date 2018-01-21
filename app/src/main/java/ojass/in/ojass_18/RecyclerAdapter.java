package ojass.in.ojass_18;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skshubhamiitkmr on 19-01-2018.
 */


class RecyclerViewHolder extends RecyclerView.ViewHolder{


    TextView recyclerText1;


    public RecyclerViewHolder(View itemView) {
        super(itemView);


        recyclerText1=(TextView) itemView.findViewById(R.id.recycler_view_text1);


    }
}
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {


    private List<String> listText = new ArrayList<>();
    private Context context;

    public RecyclerAdapter(List<String> listText, Context context) {
        this.listText = listText;
        this.context = context;

    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.recycler_view_layout, parent, false);
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
