package edu.hansung.ait.wediary.Week;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import edu.hansung.ait.wediary.R;

/**
 * Created by tickt on 2016-12-01.
 */

public class WeekFragment1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Toast.makeText(getContext(), "This is Week Page22", Toast.LENGTH_SHORT).show();
        View view = inflater.inflate(R.layout.fragment_week1, container, false);
        return view;
    }
}
