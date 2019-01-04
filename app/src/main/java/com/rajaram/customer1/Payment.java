package com.rajaram.customer1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Payment extends AppCompatActivity {
    private Spinner spinner1;
    Button button;
    EditText disid;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_form);
        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner1.setOnItemSelectedListener(new ItemSelectedListener());
        button = (Button) findViewById(R.id.cancel);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(menuIntent);
            }
        });

        button = (Button) findViewById(R.id.Pay_button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Payment.this, Receipt.class);
                startActivity(intent);
            }
        });

//        disid.setInputType(InputType.TYPE_NULL);
    }

    private class ItemSelectedListener implements android.widget.AdapterView.OnItemSelectedListener {
        String firstItem = String.valueOf(spinner1.getSelectedItem());
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (firstItem.equals(String.valueOf(spinner1.getSelectedItem()))) {
                // ToDo when first item is selected
            } else {
                Toast.makeText(parent.getContext(),
                        "You have selected : " + parent.getItemAtPosition(position).toString(),
                        Toast.LENGTH_LONG).show();
                // Todo when item is selected by the user
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {


        }
    }
}
