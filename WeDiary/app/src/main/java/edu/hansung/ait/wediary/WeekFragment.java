package edu.hansung.ait.wediary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class WeekFragment extends Fragment implements OnClickListener, OnItemClickListener {
    ArrayList<String> mItems;
    WeekAdapter adapter;
    TextView textYear;
    TextView textMon;

    int year, mon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Toast.makeText(getContext(), "This is Week Page", Toast.LENGTH_SHORT).show();
        View view = inflater.inflate(R.layout.fragment_week, container, false);

        String[] items = {"일", "월", "화", "수", "목", "금", "토"};
        Date date = new Date();
        year = date.getYear() + 1900;
        mon = date.getMonth() + 1;

        mItems = new ArrayList<>();
        adapter = new WeekAdapter(getContext(), mItems, year, mon);
        textYear = (TextView)view.findViewById(R.id.wedit1);
        textMon = (TextView)view.findViewById(R.id.wedit2);

        ListView list2 = (ListView)view.findViewById(R.id.list2);
        ArrayAdapter<String> adapt = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, items);
        list2.setAdapter(adapt);

        ListView list = (ListView)view.findViewById(R.id.list1);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);

        textYear.setText(year + "");
        textMon.setText(mon + "");

        matchDate(year, mon);

        Button btnmove = (Button)view.findViewById(R.id.wbt1);
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
        if(view.getId() == R.id.wbt1) {
            int year = Integer.parseInt(textYear.getText().toString());
            int mon = Integer.parseInt(textMon.getText().toString());
            matchDate(year, mon);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(!mItems.get(i).equals("")) {
            Intent intent = new Intent(this.getContext(), DetailActivity.class);
            intent.putExtra("Param1", textYear.getText().toString() + "/" + textMon.getText().toString() + "/" + mItems.get(i));
            startActivity(intent);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(!mItems.get(i).equals("")) {
            Intent intent = new Intent(this.getContext(), DetailActivity.class);
            intent.putExtra("Param1", textYear.getText().toString() + "/" + textMon.getText().toString() + "/" + mItems.get(i));
            startActivity(intent);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(!mItems.get(i).equals("")) {
            Intent intent = new Intent(this.getContext(), DetailActivity.class);
            intent.putExtra("Param1", textYear.getText().toString() + "/" + textMon.getText().toString() + "/" + mItems.get(i));
            startActivity(intent);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(!mItems.get(i).equals("")) {
            Intent intent = new Intent(this.getContext(), DetailActivity.class);
            intent.putExtra("Param1", textYear.getText().toString() + "/" + textMon.getText().toString() + "/" + mItems.get(i));
            startActivity(intent);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(!mItems.get(i).equals("")) {
            Intent intent = new Intent(this.getContext(), DetailActivity.class);
            intent.putExtra("Param1", textYear.getText().toString() + "/" + textMon.getText().toString() + "/" + mItems.get(i));
            startActivity(intent);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(!mItems.get(i).equals("")) {
            Intent intent = new Intent(this.getContext(), DetailActivity.class);
            intent.putExtra("Param1", textYear.getText().toString() + "/" + textMon.getText().toString() + "/" + mItems.get(i));
            startActivity(intent);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(!mItems.get(i).equals("")) {
            Intent intent = new Intent(this.getContext(), DetailActivity.class);
            intent.putExtra("Param1", textYear.getText().toString() + "/" + textMon.getText().toString() + "/" + mItems.get(i));
            startActivity(intent);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(!mItems.get(i).equals("")) {
            Intent intent = new Intent(this.getContext(), DetailActivity.class);
            intent.putExtra("Param1", textYear.getText().toString() + "/" + textMon.getText().toString() + "/" + mItems.get(i));
            startActivity(intent);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(!mItems.get(i).equals("")) {
            Intent intent = new Intent(this.getContext(), DetailActivity.class);
            intent.putExtra("Param1", textYear.getText().toString() + "/" + textMon.getText().toString() + "/" + mItems.get(i));
            startActivity(intent);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(!mItems.get(i).equals("")) {
            Intent intent = new Intent(this.getContext(), DetailActivity.class);
            intent.putExtra("Param1", textYear.getText().toString() + "/" + textMon.getText().toString() + "/" + mItems.get(i));
            startActivity(intent);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(!mItems.get(i).equals("")) {
            Intent intent = new Intent(this.getContext(), DetailActivity.class);
            intent.putExtra("Param1", textYear.getText().toString() + "/" + textMon.getText().toString() + "/" + mItems.get(i));
            startActivity(intent);
        }
    }
    
}