package com.example.emi_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        final EditText p = (EditText) findViewById(R.id.amount);
        final EditText r = (EditText) findViewById(R.id.Rate);
        final EditText t = (EditText) findViewById(R.id.year);
        final Button btr = (Button) findViewById(R.id.button);
        final TextView emi = (TextView) findViewById(R.id.emi);
        final TextView total = (TextView) findViewById(R.id.total_amount);

        btr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = p.getText().toString();
                String str2 = r.getText().toString();
                String str3 = t.getText().toString();
                if (TextUtils.isEmpty(str1))
                {
                    p.setError("Enter the amount ");
                    p.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(str2))
                {
                    r.setError("Enter the insterest ");
                    r.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(str3))
                {
                    t.setError("Enter the years ");
                    t.requestFocus();
                    return;
                }

                float p = Float.parseFloat(str1);
                float r = Float.parseFloat(str2);
                float y = Float.parseFloat(str3);
                float si = (p*r*y)/100;


                emi.setText("Emi : "+String.valueOf(si));
                float ti = si+p;
                total.setText("TOTAL Amount : "+String.valueOf(ti));

            }
        });

    }



}