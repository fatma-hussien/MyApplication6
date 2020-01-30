package com.example.zahran.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zahran on 1/30/2020.
 */

public class productadapter extends ArrayAdapter<product> {

    public productadapter(@NonNull Context context, ArrayList<product> product1) {
        super(context, 0, product1);


    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_product_list, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        product current = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.tv_nameprofile);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(current.getName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        ImageView imageView_profile = (ImageView) listItemView.findViewById(R.id.circleimageprofile);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        imageView_profile.setImageResource(current.getProfilrimage());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imageView_delete = (ImageView) listItemView.findViewById(R.id.delete);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        imageView_delete.setImageResource(current.getDeleteimage());


        ImageView imageView_main = (ImageView) listItemView.findViewById(R.id.mainimage);
        imageView_main.setImageResource(current.getMainimage());

        ImageView imageView_like = (ImageView) listItemView.findViewById(R.id.like);
        imageView_like.setImageResource(current.getLikimage());

        ImageView imageView_comment = (ImageView) listItemView.findViewById(R.id.comment);
        imageView_comment.setImageResource(current.getCommentimage());

        ImageView imageView_rate = (ImageView) listItemView.findViewById(R.id.rate);
        imageView_rate.setImageResource(current.getSmileyimage());

        ImageView imageView_share = (ImageView) listItemView.findViewById(R.id.share);
        imageView_share.setImageResource(current.getShareimage());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}