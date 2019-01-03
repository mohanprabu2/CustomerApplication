package com.rajaram.customer1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    Button button;
    DatabaseHelper myDb;
    EditText name,area,street,cusid,rent;
    Button  btnDelete;
    Button btnviewUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_form);

        myDb = new DatabaseHelper(this);
        name = (EditText)findViewById(R.id.nameid);
        area = (EditText)findViewById(R.id.areaid);
        street = (EditText)findViewById(R.id.streetid);
        cusid = (EditText)findViewById(R.id.cus_Id);
        rent = (EditText)findViewById(R.id.rentid);
        btnDelete= (Button)findViewById(R.id.delete_button);
        btnviewUpdate= (Button)findViewById(R.id.update_button);
        populateRecord(getIntent().getStringExtra("CUSTOMERID_Value"));

        cusid.setInputType(InputType.TYPE_NULL);
        UpdateData();
    }

    private void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(name.getText().toString(),area.getText().toString(),
                                street.getText().toString(),cusid.getText().toString(),rent.getText().toString());
                        if (isUpdate == true){
                            Toast.makeText(Update.this, "Data Update", Toast.LENGTH_LONG).show();
                            Intent menuIntent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(menuIntent);
                        }
                        else

                        {
                            Toast.makeText(Update.this, "Data not Updated", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

    }

    private void populateRecord(String id) {
        Cursor cur = myDb.getData(id);
        cur.moveToFirst();
        name.setText(cur.getString(cur.getColumnIndex("NAME")));
        area.setText(cur.getString(cur.getColumnIndex("AREA")));
        street.setText(cur.getString(cur.getColumnIndex("STREET")));
        cusid.setText(cur.getString(cur.getColumnIndex("CUSTOMERID")));
        rent.setText(cur.getString(cur.getColumnIndex("RENT")));
    }




}