package edu.hansung.ait.wediary.Week;

import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

import edu.hansung.ait.wediary.DetailActivity;
import edu.hansung.ait.wediary.R;

public class WeekFragment extends Fragment implements OnClickListener, OnItemClickListener {
    SimpleDateFormat dateFormat;
    Date date;
    int year, mon, dated;

    ArrayList<String> mItems;
    WeekAdapter adapter;
    TextView textYear, textMon;

    /*
    viewpager
     */
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar ;


    /*


     */
//    private RecyclerView recyclerView;
//    private WeekViewHolder holderAdapter;
//    private ArrayList<WeekDate> weekDateList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Toast.makeText(getContext(), "This is Week Page", Toast.LENGTH_SHORT).show();
        View view = inflater.inflate(R.layout.fragment_week, container, false);


        /*
        tabLayout
         */

        initView(view);


        dateFormat = new SimpleDateFormat("E", java.util.Locale.getDefault());
        date = new Date();
        year = date.getYear() + 1900;
        mon = date.getMonth() + 1;
        dated = date.getDay();
//
//        mItems = new ArrayList<>();
//        adapter = new WeekAdapter(getContext(), mItems, year, mon);
//        textYear = (TextView)view.findViewById(R.id.edit1);
//        textMon = (TextView)view.findViewById(R.id.edit2);
//
//        GridView grid = (GridView)view.findViewById(R.id.grid1);
//        grid.setAdapter(adapter);
//        grid.setOnItemClickListener(this);
//        grid.setNumColumns(1);
//
//        textYear.setText(year + "");
//        textMon.setText(mon + "");
//
//        matchDate(year, mon);
//
//        Button btnmove = (Button)view.findViewById(R.id.bt1);
//        btnmove.setOnClickListener(this);
//        btnmove.requestFocus();

        return view;
    }

    private void initView(final View view) {
        tabLayout = (TabLayout)view.findViewById(R.id.tabLayout);
        toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        tabLayout.addTab(tabLayout.newTab().setText("1주차"));
        tabLayout.addTab(tabLayout.newTab().setText("2주차"));
        tabLayout.addTab(tabLayout.newTab().setText("3주차"));
        tabLayout.addTab(tabLayout.newTab().setText("4주차"));
        tabLayout.addTab(tabLayout.newTab().setText("5주차"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager)view.findViewById(R.id.weekPager);


        WeekPageAdapter pAdater = new WeekPageAdapter(getFragmentManager(),tabLayout.getTabCount());

        Log.i("weekFragment", String.valueOf(tabLayout.getTabCount()));
        viewPager.setAdapter(pAdater);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int index2 = tab.getPosition();
                if(index2 == 4){
                    Toast.makeText(view.getContext(),"마지막 페이지 입니다.",Toast.LENGTH_SHORT).show();
                }
                else if(index2 ==0 ){
                    Toast.makeText(view.getContext(),"처음 페이지 입니다",Toast.LENGTH_SHORT).show();
                }
                viewPager.setCurrentItem(tab.getPosition());
                Log.i("tabLayout", String.valueOf(tab.getPosition()));

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public static class WeekPageAdapter extends FragmentStatePagerAdapter {

        private int tabCount;

        public WeekPageAdapter(FragmentManager fm, int count) {
            super(fm);
            this.tabCount = count;
        }



        @Override
        public int getCount() {
            return tabCount;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    WeekFragment1 week1 = new WeekFragment1();
                    return week1;
                case 1:
                    WeekFragment2 week2 = new WeekFragment2();
                    return week2;
                case 2:
                    WeekFragment3 week3 = new WeekFragment3();
                    return week3;
                case 3:
                    WeekFragment4 week4 = new WeekFragment4();
                    return week4;
                case 4:
                    WeekFragment5 week5 = new WeekFragment5();
                    return week5;
                default:
                    return null;
            }

        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }

    // private void initView(View view, int year, int mon, int dated) {

//        weekDateList = new ArrayList<>();
//        // 추가할 것.
//
//      //  fillViews(weekDateList,year,mon,dated);
//
//        holderAdapter = new WeekViewHolder(view.getContext(), weekDateList);
//        LinearLayoutManager HZLayoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false);
//        recyclerView.setLayoutManager(HZLayoutManager);
//        recyclerView.setAdapter(holderAdapter);

  //  }

    private void fillViews(ArrayList<WeekDate> weekDateList, int year, int mon, int dated) {
        Date current = new Date(year-1900,mon-1,1);
        int day = current.getDay();
        int last = 32-current.getDate();

        Log.i("date", String.valueOf(day));
        Log.i("date2", String.valueOf(last));
        for(int i=1;i<=last;i++)
            weekDateList.add(new WeekDate(day,String.valueOf(last)));



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