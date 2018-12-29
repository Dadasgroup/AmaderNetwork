package com.mubassir.amadernetwork;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<ListViewModel> {

    private ArrayList<ListViewModel> mList;
    Context mContext;

    //View for lookup
    private static  class ViewHolder{
        TextView Title;
        TextView Url ;
        TextView  Description ;
        ImageView Image ;
    }


    public ListViewAdapter(@NonNull Context context, ArrayList<ListViewModel> list) {
        super(context, R.layout.custom_listview_row, list);
        this.mList = list;
        this.mContext=context;
    }



    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ListViewModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.custom_listview_row, parent, false);
            viewHolder.Title = (TextView) convertView.findViewById(R.id.ctmLvTitle);
            viewHolder.Description = (TextView) convertView.findViewById(R.id.ctmLvDescription);
            viewHolder.Image = (ImageView) convertView.findViewById(R.id.ctmLvIcon);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.Title.setText(dataModel.getTitle());
        viewHolder.Description.setText(dataModel.getDescription());
        viewHolder.Image.setImageResource(dataModel.getImage());
        // Return the completed view to render on screen
        return convertView;
    }
}
