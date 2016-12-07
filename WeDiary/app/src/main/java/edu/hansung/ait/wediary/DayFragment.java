package edu.hansung.ait.wediary;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class DayFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    MyDBHelper mDBHelper;
    Cursor cursor;
    SimpleCursorAdapter adapter;
    ListView list;
    String today;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Toast.makeText(getContext(), "This is Day Page", Toast.LENGTH_SHORT).show();
        View view = inflater.inflate(R.layout.fragment_day, container, false);

        Date date = new Date();
        int year = date.getYear() + 1900;
        int mon = date.getMonth() + 1;
        int day = date.getDate() + 1;

        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra("Param1", year + "/" + mon + "/" + day);
        today = intent.getStringExtra("Param1");

        mDBHelper = new MyDBHelper(getContext(), "Today2.db", null, 1);
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        cursor = db.rawQuery("SELECT * FROM today WHERE date = '" + today + "'", null);

        adapter = new SimpleCursorAdapter(getContext(), android.R.layout.simple_list_item_2, cursor,
                new String[] { "title", "startTime" }, new int[] { android.R.id.text1, android.R.id.text2 });

        list = (ListView)view.findViewById(R.id.list1);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);

        mDBHelper.close();

        TextView textView = (TextView)view.findViewById(R.id.daytext);
        textView.setText(year + " / " + mon + " / " + day);

        Button btn = (Button)view.findViewById(R.id.btnadd2);
        btn.setOnClickListener(this);

        return view;
    }

    public void onStart() {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        cursor = db.rawQuery("SELECT * FROM today WHERE date = '" + today + "'", null);
        adapter = new SimpleCursorAdapter(getContext(), android.R.layout.simple_list_item_2, cursor,
                new String[] { "title", "startTime" }, new int[] { android.R.id.text1, android.R.id.text2 });
        list.setAdapter(adapter);
        super.onStart();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getContext(), EditActivity.class);
        cursor.moveToPosition(position);
        intent.putExtra("ParamID", cursor.getInt(0));
        startActivityForResult(intent, 0);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), EditActivity.class);
        intent.putExtra("ParamDate", today);
        startActivityForResult(intent, 1);
    }
}