package edu.hansung.ait.wediary;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WeekFragment extends Fragment implements OnClickListener, OnItemClickListener {
    SimpleDateFormat dateFormat;
    Date date;
    int year, mon, dated;

    ArrayList<String> mItems;
    WeekAdapter adapter;
    TextView textYear, textMon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Toast.makeText(getContext(), "This is Week Page", Toast.LENGTH_SHORT).show();
        View view = inflater.inflate(R.layout.fragment_week, container, false);

        dateFormat = new SimpleDateFormat("E", java.util.Locale.getDefault());
        date = new Date();
        year = date.getYear() + 1900;
        mon = date.getMonth() + 1;
        dated = date.getDay();

        mItems = new ArrayList<>();
        adapter = new WeekAdapter(getContext(), mItems, year, mon);
        textYear = (TextView)view.findViewById(R.id.edit1);
        textMon = (TextView)view.findViewById(R.id.edit2);

        GridView grid = (GridView)view.findViewById(R.id.grid1);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(this);
        grid.setNumColumns(1);

        textYear.setText(year + "");
        textMon.setText(mon + "");

        matchDate(year, mon);

        Button btnmove = (Button)view.findViewById(R.id.bt1);
        btnmove.setOnClickListener(this);
        btnmove.requestFocus();

        return view;
    }

    private void matchDate(int year, int mon) {
        mItems.clear();

        Date current = new Date(year-1900, mon-1, 1);
        int day = current.getDay();

        for(int i=0; i<day; i++)
            mItems.add("");

        current.setDate(32);
        int last = 32 - current.getDate();

        for(int i=1; i<=last; i++)
            mItems.add(i + "");

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.bt1) {
            int year = Integer.parseInt(textYear.getText().toString());
            int mon = Integer.parseInt(textMon.getText().toString());
            matchDate(year, mon);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(!mItems.get(i).equals("")) {
            Intent intent = new Intent(this.getContext(), DetailActivity.class);
            intent.putExtra("Param1", textYear.getText().toString() + "/" + textMon.getText().toString() + "/ " + mItems.get(i) + " (" + dateFormat.format(dated).toString() + ")");
            startActivity(intent);
        }
    }
}