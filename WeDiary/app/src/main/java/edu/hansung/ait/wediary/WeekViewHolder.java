package edu.hansung.ait.wediary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import edu.hansung.ait.wediary.Week.WeekDate;

/**
 * Created by tickt on 2016-12-01.
 */

public class WeekViewHolder extends RecyclerView.Adapter<WeekViewHolder.ViewHolder> {

    private ArrayList<WeekDate> weekDateList;
    private Context vContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView monthView,monthText;
        private Context context;
        private WeekViewHolder holder;

        public ViewHolder(Context context,View itemView,WeekViewHolder holder) {
            super(itemView);
            monthView = (TextView)itemView.findViewById(R.id.monthDate);
            monthText = (TextView)itemView.findViewById(R.id.monthText);
            this.context = context;
            this.holder = holder;
        }
    }

    public WeekViewHolder(Context context,ArrayList<WeekDate> weekDateList){
        this.vContext = context;
        this.weekDateList = weekDateList;
    }

    @Override
    public WeekViewHolder.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        vContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(vContext);
        View weekView = inflater.inflate(R.layout.week_view_items,parent,false);

        ViewHolder viewholder = new ViewHolder(vContext,weekView,this);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(WeekViewHolder.ViewHolder holder, int position) {
        TextView weekTextView = holder.monthText;
        TextView weekDateView = holder.monthView;
        weekTextView.setText(weekDateList.get(position).getWeekText());
        Log.d("weekviewholder",weekTextView.toString());
        Log.d("weekviewholder2", String.valueOf(weekDateList.get(position).getWeekDate()));
        weekDateView.setText(weekDateList.get(position).getWeekDate());

    }

    @Override
    public int getItemCount() {
        return weekDateList.size();
    }

}
