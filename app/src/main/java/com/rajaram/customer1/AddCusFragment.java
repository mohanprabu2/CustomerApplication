package com.rajaram.customer1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.time.Instant;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddCusFragment extends Fragment {
   // EditText name,rent,area,street,cusid;

    public AddCusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_cus, container, false);
        Button cus_button = (Button) v.findViewById(R.id.cus_button);
        cus_button.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                Intent  in =  new Intent( getActivity(),AddActivity.class);
                in.putExtra("Add","Add Customer");
               startActivity(in);
            }
        });
       // myDb = new DatabaseHelper(this);
         return v;
    }
}
