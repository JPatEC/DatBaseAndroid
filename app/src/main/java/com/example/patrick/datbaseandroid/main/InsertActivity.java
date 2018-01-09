package com.example.patrick.datbaseandroid.main;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.patrick.datbaseandroid.DBHelper;
import com.example.patrick.datbaseandroid.R;

public class InsertActivity extends AppCompatActivity {

    DBHelper myDb;
    EditText txtName, txtSurname, txtDescription;
    Button btnStudents, btnReadStudents, btnUpdateStudents,btnDeleteStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        myDb = new DBHelper(this);
        txtName = (EditText) findViewById(R.id.idName);
        txtSurname = (EditText) findViewById(R.id.idSurName);
        txtDescription = (EditText) findViewById(R.id.idDescription);

        //button insert
        btnStudents = (Button) findViewById(R.id.btnStudents);
        btnStudents.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ClikMe();
            }
        });

        // /button read
        btnReadStudents = (Button) findViewById(R.id.btnReadStudents);
        btnReadStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leer= new Intent(v.getContext(),ListActivity.class);
                startActivity(leer);
            }
        });
      //button update
        btnUpdateStudents = (Button) findViewById(R.id.btnUpdateStudents);
        btnUpdateStudents.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent btnUpdateStudents = new Intent(InsertActivity.this, UpdateActivity.class);
                startActivity(btnUpdateStudents);
            }
        });
        //button delete
        btnDeleteStudents = (Button) findViewById(R.id.btnDeleteStudents);
        btnDeleteStudents.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View v) {
                Intent btnDeleteStudents = new Intent(InsertActivity.this, DeleteActivity.class);
                startActivity(btnDeleteStudents);
            }
        });

    }
    private void ClikMe() {
        String name=txtName.getText().toString();
        String surname=txtSurname.getText().toString();
        String description=txtDescription.getText().toString();
        Boolean result=myDb.insertData(name,surname,description);
        if(result==true){
            Toast.makeText(this,"Data Insertada",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Insercion de datos fallo",Toast.LENGTH_SHORT).show();
        }

    }

}
