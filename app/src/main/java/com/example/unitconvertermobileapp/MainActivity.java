package com.example.unitconvertermobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Spinner  spinnerType;
    private TextView mToCm, mToFoot, mToInch, celToFah, celToKelvin, kgToG, kgToOunce, kgToPound;
    private EditText valueEditText;
    private String types;
    private ImageView imageMetre, imageCel, imageKg;
    private LinearLayout llMetre, llCel, llKG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        valueEditText = findViewById(R.id.valueEditText);
        spinnerType = findViewById(R.id.spinnerType);
        mToCm = findViewById(R.id.mToCm);
        mToFoot = findViewById(R.id.mToFoot);
        mToInch = findViewById(R.id.mToInch);
        celToFah = findViewById(R.id.celToFah);
        celToKelvin = findViewById(R.id.celToKelvin);
        kgToG = findViewById(R.id.kgToG);
        kgToOunce = findViewById(R.id.kgToOunce);
        kgToPound = findViewById(R.id.kgToPound);
        llMetre = findViewById(R.id.llMetre);
        llCel = findViewById(R.id.llCel);
        llKG = findViewById(R.id.llKg);
        imageMetre = findViewById(R.id.imageMetre);
        imageCel = findViewById(R.id.imageCel);
        imageKg = findViewById(R.id.imageKg);
        types = "Metre";
        final String[] string = new String[] {"Metre", "Celsuis", "Kilograms"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, string);
        spinnerType.setAdapter(adapter);
        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                types = string[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        imageCel.setOnClickListener(this);
        imageMetre.setOnClickListener(this);
        imageKg.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageMetre:
                String menu = valueEditText.getText().toString().trim();
                if(menu.equals("")){
                    Toast.makeText(this,"Value is empty!", Toast.LENGTH_LONG).show();
                    return;
                }
                if(!types.equals("Metre")){
                    Toast.makeText(this,"Please select the correct conversion icon",Toast.LENGTH_LONG).show();
                    return;
                }
                double dm = Integer.parseInt(menu) * 100.00;
                BigDecimal b = new BigDecimal(dm);
                double dm1 = b.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
                DecimalFormat df = new DecimalFormat("0.00");
                mToCm.setText(df.format(dm1)+"");

                double dm2 = Integer.parseInt(menu) * 3.28;
                BigDecimal b1 = new BigDecimal(dm2);
                double dm3 = b1.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
                DecimalFormat df1= new DecimalFormat("0.00");
                mToFoot.setText(df1.format(dm3)+"");

                double dm4 = Integer.parseInt(menu) * 39.37;
                BigDecimal b2 = new BigDecimal(dm4);
                double dm5 = b2.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
                DecimalFormat df2 = new DecimalFormat("0.00");
                mToInch.setText(df2.format(dm5)+"");

                llMetre.setVisibility(View.VISIBLE);
                llKG.setVisibility(View.GONE);
                llCel.setVisibility(View.GONE);
                break;



            case R.id.imageCel:
                 menu = valueEditText.getText().toString().trim();
                if(menu.equals("")){
                    Toast.makeText(this,"Value is empty!", Toast.LENGTH_LONG).show();
                    return;
                }
                if(!types.equals("Celsuis")){
                    Toast.makeText(this,"Please select the correct conversion icon",Toast.LENGTH_LONG).show();
                    return;
                }
                double dc = Integer.parseInt(menu) * 33.80;
                BigDecimal b3 = new BigDecimal(dc);
                double dc1 = b3.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
                DecimalFormat df3 = new DecimalFormat("0.00");
                celToFah.setText(df3.format(dc1)+"");

                double dc2 = Integer.parseInt(menu) * 274.15;
                BigDecimal bm = new BigDecimal(dc2);
                double dc3 = bm.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
                DecimalFormat df4 = new DecimalFormat("0.00");
                celToKelvin.setText(df4.format(dc3)+"");

                llCel.setVisibility(View.VISIBLE);
                llKG.setVisibility(View.GONE);
                llMetre.setVisibility(View.GONE);

                break;

            case R.id.imageKg:
                menu = valueEditText.getText().toString().trim();
                if(menu.equals("")){
                    Toast.makeText(this,"Value is empty!", Toast.LENGTH_LONG).show();
                    return;
                }
                if(!types.equals("Kilograms")){
                    Toast.makeText(this,"Please select the correct conversion icon",Toast.LENGTH_LONG).show();
                    return;
                }
                double dk = Integer.parseInt(menu) * 1000;
                BigDecimal bk = new BigDecimal(dk);
                double  dk1= bk.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
                DecimalFormat df5 = new DecimalFormat("0.00");
                kgToG.setText(df5.format(dk1)+"");

                double dk2 = Integer.parseInt(menu) * 35.27;
                BigDecimal bk1 = new BigDecimal(dk2);
                double dk3 = bk1.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
                DecimalFormat df6 = new DecimalFormat("0.00");
                kgToOunce.setText(df6.format(dk3)+"");

                double dk4 = Integer.parseInt(menu) * 2.20;
                BigDecimal bk4 = new BigDecimal(dk4);
                double dk5 = bk4.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
                DecimalFormat df7 = new DecimalFormat("0.00");
                kgToPound.setText(df7.format(dk5) + "");

                llMetre.setVisibility(View.GONE);
                llKG.setVisibility(View.VISIBLE);
                llCel.setVisibility(View.GONE);
                break;
        }

    }
}