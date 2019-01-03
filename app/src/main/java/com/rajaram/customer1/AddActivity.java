package com.rajaram.customer1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    Button button;
    DatabaseHelper myDb;
    EditText name,area,street,cusid,rent;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle =  getIntent().getExtras();
        if(bundle != null);{
            if(bundle.getString("Adding Customer") != null){
                Toast.makeText(getApplicationContext(),"Data:" + bundle.getString("Adding Customer"),Toast.LENGTH_SHORT).show();
            }
        }
        button = (Button) findViewById(R.id.cancel_button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(menuIntent);
            }
        });
        myDb = new DatabaseHelper(this);
        name = (EditText)findViewById(R.id.nameid);
        area = (EditText)findViewById(R.id.areaid);
        street = (EditText)findViewById(R.id.streetid);
        cusid = (EditText)findViewById(R.id.cus_Id);
        rent = (EditText)findViewById(R.id.rentid);
        btnAddData = (Button)findViewById(R.id.add_button);
        AddData();
    }

    private void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(name.getText().toString(),area.getText().toString(),
                                street.getText().toString(),cusid.getText().toString(),rent.getText().toString());
                        if(isInserted == true){
                            Toast.makeText(AddActivity.this, "Data Added Customer", Toast.LENGTH_LONG).show();
                            Intent menuIntent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(menuIntent);
                        }else {
                            Toast.makeText(AddActivity.this, "Data not Add", Toast.LENGTH_LONG).show();
                        }

                    }


                }
        );
    }

}
