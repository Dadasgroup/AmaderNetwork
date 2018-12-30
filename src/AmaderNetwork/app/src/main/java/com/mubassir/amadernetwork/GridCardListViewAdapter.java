package com.mubassir.amadernetwork;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class GridCardListViewAdapter extends RecyclerView.Adapter <GridCardListViewAdapter.MyRecycleViewHolder>{

    private Context mContext;
    private List<Card> mData;

    public GridCardListViewAdapter(Context mContext, List<Card> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater mInflater=LayoutInflater.from(mContext);
        view=mInflater.inflate(R.layout.grid_card,viewGroup,false);
        return new MyRecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleViewHolder holder, int i) {

        holder.tvTitle.setText(mData.get(i).getTitle());
        holder.imgView.setImageResource(mData.get(i).getBackgroundImage());
        //setting color
        int backgroundColor=mData.get(i).getLayoutBackgroundColor();
        int textColor=mData.get(i).getTextBackgroundColor();

        if (textColor>0)
            holder.tvTitle.setBackgroundColor(ContextCompat.getColor(mContext,textColor));
        if (backgroundColor>0)
            holder.gridItemLayout.setBackgroundColor(ContextCompat.getColor(mContext,backgroundColor));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyRecycleViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        ImageView imgView;
        LinearLayout gridItemLayout;

        public MyRecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle=(TextView) itemView.findViewById(R.id.gridCardTitle);
            imgView=(ImageView) itemView.findViewById(R.id.gridCardImg);
            gridItemLayout=(LinearLayout) itemView.findViewById(R.id.gridCardLl);
        }
    }
}
