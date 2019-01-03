package com.rajaram.customer1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
    Button button;
    DatabaseHelper myDb;
    EditText agent,amount;
    Button btnSaveData;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_form);
        button =(Button)findViewById(R.id.can_button);
        button.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick (View v){
                Intent menuIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(menuIntent);
            }
        });

        myDb = new DatabaseHelper(this);
        agent = (EditText)findViewById(R.id.agentid);
        amount = (EditText)findViewById(R.id.amountid);
        btnSaveData = (Button)findViewById(R.id.save_button);
        SaveData();
    }

    private void SaveData() {
        btnSaveData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.saveData(amount.getText().toString(),agent.getText().toString() );
                        if(isInserted == true){
                            Toast.makeText(Settings.this, "Saved Customer", Toast.LENGTH_LONG).show();
                            Intent menuIntent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(menuIntent);
                        }else {
                            Toast.makeText(Settings.this, "Customer not Save", Toast.LENGTH_LONG).show();
                        }

                    }


                }
        );
    }
}

