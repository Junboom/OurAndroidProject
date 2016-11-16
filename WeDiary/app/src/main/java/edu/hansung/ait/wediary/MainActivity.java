package edu.hansung.ait.wediary;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final MonthFragment fragM = new MonthFragment();
    final WeekFragment fragW = new WeekFragment();
    final DayFragment fragD = new DayFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            Drawable drawable = getDrawable(R.drawable.ic_keyboard_arrow_left_black_24dp);
            if(drawable != null) {
                drawable.setTint(Color.WHITE);
                actionBar.setHomeAsUpIndicator(drawable);
            }
        }

        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frag, fragM);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.android:
                Toast.makeText(getApplicationContext(), "Quick", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.frag1:
                getFragmentManager().beginTransaction().replace(R.id.frag, fragM).addToBackStack(null).commit();
                return true;

            case R.id.frag2:
                getFragmentManager().beginTransaction().replace(R.id.frag, fragW).addToBackStack(null).commit();
                return true;

            case R.id.frag3:
                getFragmentManager().beginTransaction().replace(R.id.frag, fragD).addToBackStack(null).commit();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}