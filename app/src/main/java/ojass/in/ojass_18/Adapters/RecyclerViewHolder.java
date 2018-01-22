package ojass.in.ojass_18.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ojass.in.ojass_18.R;


class RecyclerViewHolder extends RecyclerView.ViewHolder{


    TextView recyclerText1;


    public RecyclerViewHolder(View itemView) {
        super(itemView);


        recyclerText1=(TextView) itemView.findViewById(R.id.recycler_view_text1);


    }
}
