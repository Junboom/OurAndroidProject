package edu.hansung.ait.wediary.Week;

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
        String str = "";

        if(!(textview.getText().toString() == "")) {
            if(i%7 == 0) {
                str = textview.getText().toString();
                textview.setText("      " + str + " (Sun)");
                textview.setTextColor(Color.RED);
            }
            else if(i%7 == 6) {
                str = textview.getText().toString();
                textview.setText("      " + str + " (Sat)");
                textview.setTextColor(Color.BLUE);
            }
            else {
                switch(i % 7) {
                    case 1:
                        str = textview.getText().toString();
                        textview.setText("      " + str + " (Mon)");
                        break;
                    case 2:
                        str = textview.getText().toString();
                        textview.setText("      " + str + " (Tue)");
                        break;
                    case 3:
                        str = textview.getText().toString();
                        textview.setText("      " + str + " (Wed)");
                        break;
                    case 4:
                        str = textview.getText().toString();
                        textview.setText("      " + str + " (Thu)");
                        break;
                    case 5:
                        str = textview.getText().toString();
                        textview.setText("      " + str + " (Fri)");
                        break;
                }
                textview.setTextColor(Color.WHITE);
            }
        }
        return textview;
    }
}