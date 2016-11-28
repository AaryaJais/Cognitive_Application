package com.example.h119230.cognitive;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Khushbu on 11/27/2016.
 */
public class ListAdapter extends BaseAdapter{


    MainActivity main;
    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String,String>> data;
    ImageLoader imageLoader;

    ListAdapter(Context context, ArrayList<HashMap<String,String>> arrayList)
    {
        this.context = context;
        data = arrayList;
        imageLoader = new ImageLoader(context);
    }
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }






    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        TextView title;
        TextView tags;
        TextView Rating;
        TextView link;
        TextView image;
        ImageView imageJson;



            LayoutInflater inflater = (LayoutInflater) main.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemView = inflater.inflate(R.layout.list_item, parent, false);
            HashMap<String, String> h = new HashMap<String, String>();
            h = data.get(position);

            title = (TextView) convertView.findViewById(R.id.title);
            tags = (TextView) convertView.findViewById(R.id.tags);
            Rating = (TextView) convertView.findViewById(R.id.title);
            link = (TextView) convertView.findViewById(R.id.title);
            imageJson = (ImageView) convertView.findViewById(R.id.image);

            title.setText(h.get(MainActivity.TITLE));
            tags.setText(h.get(MainActivity.TAG));
            Rating.setText(h.get(MainActivity.RATING));
            link.setText(h.get(MainActivity.LINK));

            //For image Parse the image URL  to get the image

            imageLoader.DisplayImage(h.get(MainActivity.IMAGE), imageJson);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HashMap<String, String> p = new HashMap<String, String>();
                    p = data.get(position);
                    Intent intent = new Intent(context, SingleItemView.class);
                    //Pass the title
                    intent.putExtra("title", p.get(MainActivity.TITLE));
                    intent.putExtra("tags", p.get(MainActivity.TAG));
                    intent.putExtra("Rating", p.get(MainActivity.RATING));
                    intent.putExtra("Link", p.get(MainActivity.LINK));
                    intent.putExtra("imageJson", p.get(MainActivity.IMAGE));
                    context.startActivity(intent);
                }
            });


            return itemView;

        }


    }