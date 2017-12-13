package com.huazhume.hole.hole.main.home.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.huazhume.hole.hole.R;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by xiaobaizhang on 2017/12/10.
 */

public class HLHomeAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Context context;
    public HLHomeAdapter() {
        // TODO Auto-generated constructor stub
    }
    public HLHomeAdapter(Context context) {
        // TODO Auto-generated constructor stub
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 20;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        // TODO Auto-generated method stub
        View homeView = null;
        if (convertView == null) {
            if (position % 2 == 0) {
                convertView = inflater.inflate(R.layout.layout_listitem_main_home_article, null);
            } else {
                convertView = inflater.inflate(R.layout.layout_listitem_main_home_topic, null);
            }
            convertView.setTag(homeView);
        } else {
            homeView = (View) convertView.getTag();
        }
        return convertView;
    }
}
