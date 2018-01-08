package com.example.patrick.datbaseandroid.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.patrick.datbaseandroid.DBHelper;
import com.example.patrick.datbaseandroid.R;

/**
 * Created by Patrick on 7/1/2018.
 */

public class DeleteActivity extends AppCompatActivity {
    DBHelper myDb;
    EditText txtId;
    Button btnDeleteStudents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        myDb = new DBHelper(this);
        txtId=(EditText) findViewById(R.id.idID);
        btnDeleteStudents=(Button) findViewById(R.id.btnDeleteStudents);
        btnDeleteStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickMe();
            }
        });
    }
    private void ClickMe(){
        String id= txtId.getText().toString();
        int result=myDb.deleteData(id);
        Toast.makeText(this,result+" :Fila Afectada", Toast.LENGTH_SHORT).show();
    }
}
