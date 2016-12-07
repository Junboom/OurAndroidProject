package edu.hansung.ait.wediary;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WeekAdapter extends BaseAdapter {
    Context mContext;
    int mYear, mMon;
    ArrayList<String> mItems;

    public WeekAdapter(Context context, ArrayList<String> mItems, int year, int mon) {
        mContext = context;
        this.mItems = mItems;
        mYear = year;
        mMon = mon;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textview = new TextView(mContext);
        textview.setText(mItems.get(i));
        textview.setHeight(100);
        textview.setPadding(50, 5, 0, 0);

        if(i%7 == 0)
            textview.setTextColor(Color.RED);
        else if(i%7 == 6)
            textview.setTextColor(Color.BLUE);
        else
            textview.setTextColor(Color.WHITE);

        return textview;
    }
}