package com.mubassir.amadernetwork;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CardListViewAdapter extends RecyclerView.Adapter<CardListViewAdapter.myViewHolder>  {
    Context mContext;
    List<Card> mData;

    private int lastPosition = -1;


    public CardListViewAdapter(Context mContext, List<Card> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater=LayoutInflater.from(mContext);
        View v=inflater.inflate(R.layout.card_ftp,viewGroup,false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder myViewHolder, final int i) {
        myViewHolder.iv_backgroundImag.setImageResource(mData.get(i).getBackgroundImage());
        myViewHolder.tv_Title.setText(mData.get(i).getTitle());

        //onclick
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String className = mContext.getClass().getSimpleName();

                Log.d("FTPAdapter","onClick: clicked on "+className);
                if (className.equals("FtpMain") || className.equals("TVActivity") || className.equals("BdixActivity") || className.equals("SportsActivity")){

                    Log.d("FTPAdapter","inside ftp "+className);
                    Intent intent=new Intent(mContext,WebViewer.class);
                    intent.putExtra("url",mData.get(i).URL);
                    mContext.startActivity(intent);
                }
                if (className.equals("RouterLists") || className.equals("RouterVideoActivity")){
                    Log.d("FTPAdapter","inside router"+className);
                    Intent intent=new Intent(mContext,testActivity.class);
                    intent.putExtra("url",mData.get(i).URL);
                    mContext.startActivity(intent);
                }
                 /*else {
                    Log.d("FTPAdapter","inside ftp "+className);
                    Intent intent=new Intent(mContext,WebViewer.class);
                    intent.putExtra("url",mData.get(i).URL);
                    mContext.startActivity(intent);
                }*/
            }
        });

        setAnimation(myViewHolder.itemView, i);
    }

    /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_backgroundImag;
        TextView tv_Title;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_backgroundImag=itemView.findViewById(R.id.bgimage);
            tv_Title=itemView.findViewById(R.id.tv_title);
        }


        public void onViewDetachedFromWindow(final RecyclerView.ViewHolder holder)
        {
            ((myViewHolder)holder).clearAnimation();
        }
        public void clearAnimation()
        {
            itemView.clearAnimation();
        }
    }
}
