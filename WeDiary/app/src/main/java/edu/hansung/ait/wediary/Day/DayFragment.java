package edu.hansung.ait.wediary.Day;


import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Date;
import java.util.Locale;

import edu.hansung.ait.wediary.R;

public class DayFragment extends Fragment {

    int year,month,day;
    Calendar calendar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Toast.makeText(getContext(), "This is Day Page", Toast.LENGTH_SHORT).show();
        View view = inflater.inflate(R.layout.fragment_day, container, false);
        Date date = new Date();
        year = date.getYear() + 1900;
        month = date.getMonth() + 1;

        String[] items = {"오전12시","오전1시","오전2시","오전3시","오전4시","오전5시",
                "오전6시","오전7시","오전8시","오전9시","오전10시","오전11시","정오",
                "오후1시","오후2시","오후3시","오후4시","오후5시","오후6시","오후7시",
                "오후8시","오후9시","오후10시","오후11시","오전12시",};

        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, items);

        Date current = new Date(year-1900, month-1, 1);
        int day = current.getDay()-1;

        TextView text = (TextView)view.findViewById(R.id.daytext);
        text.setText(year+"년"+month+"월"+day+"일");


        ListView list = (ListView)view.findViewById(R.id.daylist);
        list.setAdapter(adapt);


        return view;
    }
}