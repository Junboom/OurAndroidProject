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
<<<<<<< HEAD
    Date current;

    int year, mon, day;
    int last;
=======

    int year, mon;
>>>>>>> 0e944e9b81a381fcd2e338c9e4c9231bcafe2d10

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
<<<<<<< HEAD
/*
        int year1 = Integer.parseInt(textYear.getText().toString());
        int mon1 = Integer.parseInt(textMon.getText().toString());

        Date current = new Date(year1-1900, mon1-1, 1);
        day1 = current.getDay();
*/
=======

>>>>>>> 0e944e9b81a381fcd2e338c9e4c9231bcafe2d10
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

<<<<<<< HEAD
        Button btn1 = (Button)view.findViewById(R.id.wbtn1);
        Button btn2 = (Button)view.findViewById(R.id.wbtn2);
        Button btn3 = (Button)view.findViewById(R.id.wbtn3);
        Button btn4 = (Button)view.findViewById(R.id.wbtn4);
        Button btn5 = (Button)view.findViewById(R.id.wbtn5);
        Button btn6 = (Button)view.findViewById(R.id.wbtn6);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);

=======
>>>>>>> 0e944e9b81a381fcd2e338c9e4c9231bcafe2d10
        return view;
    }

    private void matchDate(int year, int mon) {
        mItems.clear();

<<<<<<< HEAD
        current = new Date(year-1900, mon-1, 1);
        day = current.getDay();
=======
        Date current = new Date(year-1900, mon-1, 1);
        int day = current.getDay();
>>>>>>> 0e944e9b81a381fcd2e338c9e4c9231bcafe2d10

        for(int i=0; i<day; i++)
            mItems.add("");

        current.setDate(32);
<<<<<<< HEAD
        last = 32 - current.getDate();

        for(int i=1; i<=7-day; i++)
=======
        int last = 32 - current.getDate();

        for(int i=1; i<=last; i++)
>>>>>>> 0e944e9b81a381fcd2e338c9e4c9231bcafe2d10
            mItems.add(i + "");

        adapter.notifyDataSetChanged();
    }

<<<<<<< HEAD
    private void matchDate(int year, int mon, int date) {
        mItems.clear();

        for(int i=8-date; i<=15-date; i++) {
            if(i > last)
                break;
            else
                mItems.add(i + "");
        }

        adapter.notifyDataSetChanged();
    }

=======
>>>>>>> 0e944e9b81a381fcd2e338c9e4c9231bcafe2d10
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.wbt1) {
            int year = Integer.parseInt(textYear.getText().toString());
            int mon = Integer.parseInt(textMon.getText().toString());
            matchDate(year, mon);
        }
<<<<<<< HEAD

        if(view.getId() == R.id.wbtn1) {
            int year = Integer.parseInt(textYear.getText().toString());
            int mon = Integer.parseInt(textMon.getText().toString());
            matchDate(year, mon);
        }
        else if(view.getId() == R.id.wbtn2) {
            int year = Integer.parseInt(textYear.getText().toString());
            int mon = Integer.parseInt(textMon.getText().toString());
            matchDate(year, mon, day);
        }
        else if(view.getId() == R.id.wbtn3) {
            int year = Integer.parseInt(textYear.getText().toString());
            int mon = Integer.parseInt(textMon.getText().toString());
            matchDate(year, mon, day-7);
        }
        else if(view.getId() == R.id.wbtn4) {
            int year = Integer.parseInt(textYear.getText().toString());
            int mon = Integer.parseInt(textMon.getText().toString());
            matchDate(year, mon, day-14);
        }
        else if(view.getId() == R.id.wbtn5) {
            int year = Integer.parseInt(textYear.getText().toString());
            int mon = Integer.parseInt(textMon.getText().toString());
            matchDate(year, mon, day-21);
        }
        else if(view.getId() == R.id.wbtn6) {
            int year = Integer.parseInt(textYear.getText().toString());
            int mon = Integer.parseInt(textMon.getText().toString());
            matchDate(year, mon, day-28);
        }
    }

=======
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
>>>>>>> 0e944e9b81a381fcd2e338c9e4c9231bcafe2d10
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(!mItems.get(i).equals("")) {
            Intent intent = new Intent(this.getContext(), DetailActivity.class);
            intent.putExtra("Param1", textYear.getText().toString() + "/" + textMon.getText().toString() + "/" + mItems.get(i));
            startActivity(intent);
        }
    }
<<<<<<< HEAD
=======
    
>>>>>>> 0e944e9b81a381fcd2e338c9e4c9231bcafe2d10
}