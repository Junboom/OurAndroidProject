package edu.hansung.ait.wediary;

import android.app.ActionBar;
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
                getSupportFragmentManager().beginTransaction().replace(R.id.frag, fragM).addToBackStack(null).commit();
                return true;

            
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}