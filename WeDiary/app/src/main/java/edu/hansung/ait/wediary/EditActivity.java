package edu.hansung.ait.wediary;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity implements OnClickListener {
    MyDBHelper mDBHelper;
    int mId;
    String today;
    EditText editDate, editTitle, editTime1, editTime2, editPlace, editMemo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editDate = (EditText)findViewById(R.id.editdate);
        editTitle = (EditText)findViewById(R.id.edittitle);
        editTime1 = (EditText)findViewById(R.id.edittime1);
        editTime2 = (EditText)findViewById(R.id.edittime2);
        editPlace = (EditText)findViewById(R.id.editplace);
        editMemo = (EditText)findViewById(R.id.editmemo);

        Intent intent = getIntent();
        mId = intent.getIntExtra("ParamID", -1);
        today = intent.getStringExtra("ParamDate");

        mDBHelper = new MyDBHelper(this, "Today2.db", null, 1);

        if(mId == -1)
            editDate.setText(today);
        else {
            SQLiteDatabase db = mDBHelper.getWritableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM today WHERE _id='" + mId + "'", null);

            if(cursor.moveToNext()) {
                editTitle.setText(cursor.getString(1));
                editDate.setText(cursor.getString(2));
                editTime1.setText(cursor.getString(3));
                editTime2.setText(cursor.getString(4));
                editPlace.setText(cursor.getString(5));
                editMemo.setText(cursor.getString(6));
            }
            mDBHelper.close();
        }

        Button btn1 = (Button)findViewById(R.id.btnsave);
        btn1.setOnClickListener(this);
        Button btn2 = (Button)findViewById(R.id.btndel);
        btn2.setOnClickListener(this);
        Button btn3 = (Button)findViewById(R.id.btncancel);
        btn3.setOnClickListener(this);

        if(mId == -1)
            btn2.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View view) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();

        switch(view.getId()) {
            case R.id.btnsave:
                if(mId != -1) {
                    db.execSQL("UPDATE today SET title='"
                            + editTitle.getText().toString() + "',title='"
                            + editDate.getText().toString() + "', date='"
                            + editTime1.getText().toString() + "', startTime='"
                            + editTime2.getText().toString() + "', endTime='"
                            + editPlace.getText().toString() + "', place='"
                            + editMemo.getText().toString() + "' WHERE _id='" + mId
                            + "';");
                }
                else {
                    db.execSQL("INSERT INTO today VALUES(null, '"
                            + editTitle.getText().toString() + "', '"
                            + editDate.getText().toString() + "', '"
                            + editTime1.getText().toString() + "', '"
                            + editTime2.getText().toString() + "', '"
                            + editPlace.getText().toString() + "', '"
                            + editMemo.getText().toString() + "');");
                }
                mDBHelper.close();
                setResult(RESULT_OK);
                break;

            case R.id.btndel:
                if(mId != -1) {
                    db.execSQL("DELETE FROM today WHERE _id='" + mId + "';");
                    mDBHelper.close();
                }
                setResult(RESULT_OK);
                break;

            case R.id.btncancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}