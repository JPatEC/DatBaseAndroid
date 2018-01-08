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

public class UpdateActivity extends AppCompatActivity {

    DBHelper myDb;
    EditText txtId, txtName, txtSurname, txtDescription;
    Button btnUpdateStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        txtId=(EditText) findViewById(R.id.idID);
        txtName=(EditText) findViewById(R.id.idName);;
        txtSurname=(EditText) findViewById(R.id.idSurName);;
        txtDescription=(EditText) findViewById(R.id.idDescription);

        btnUpdateStudents= (Button) findViewById(R.id.UpdateStudents);
        btnUpdateStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClikMe();
            }
        });


    }
    private void ClikMe(){
        String id=txtId.getText().toString();
        String name=txtName.getText().toString();
        String surname=txtSurname.getText().toString();
        String description=txtDescription.getText().toString();
        Boolean result=myDb.updateData(id,name,surname,description);
        if(result==true){
            Toast.makeText(this,"Data actualizada Correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Filas no Afectadas", Toast.LENGTH_SHORT).show();
        }
    }
}
