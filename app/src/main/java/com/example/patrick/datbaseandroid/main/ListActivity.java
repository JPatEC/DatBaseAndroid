package com.example.patrick.datbaseandroid.main;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.patrick.datbaseandroid.DBHelper;
import com.example.patrick.datbaseandroid.R;

/**
 * Created by Patrick on 7/1/2018.
 */

public class ListActivity extends AppCompatActivity {

    DBHelper myDb;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        myDb = new DBHelper(this);
        txtResult = (TextView) findViewById(R.id.idResult);

        Cursor res= myDb.getAllData();
        StringBuffer stringBuffer = new StringBuffer();
        if(res!=null && res.getCount()>0){
            while (res.moveToNext()){
                stringBuffer.append("ID: "+res.getString(0)+"\n");
                stringBuffer.append("NAME: "+res.getString(1)+"\n");
                stringBuffer.append("SURNAME: "+res.getString(2)+"\n");
                stringBuffer.append("DESCRIPTION: "+res.getString(3)+"\n");
            }
            txtResult.setText(stringBuffer.toString());
            Toast.makeText(this,"Data Recuperada Exisitosamente",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Data No Recuperada ",Toast.LENGTH_SHORT).show();
        }
    }

}
