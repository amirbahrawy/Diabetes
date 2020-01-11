package com.example.android.diabetes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.diabetes.database.Models.Medical;
import com.example.android.diabetes.database.MyDataBase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class Uri_Water_Update_Activity extends AppCompatActivity implements View.OnClickListener {


    private Button updatebtn;
    private Button progresbtn;
    private EditText editdate;
    private EditText Syastolic;
    private EditText diastolic;
    private EditText PulseRate;
    private EditText BloodGlucose;
    private EditText Height;
    private EditText Weight;
    private TextView BodymassIndex;
    private TextView BMICase;
    private EditText urinationn;
    private Spinner uricolorsSpinner;
    private EditText wateramount;
    String Sdate;
    String SSyastolic;
    String Sdiastolic;
    String SPulseRate;
    String SBloodGlucose;
    String SHeight ;
    String SWeight;
    String SBodymassIndex;
    String SBMICase;
    String SuricolorsSpinner;
    String Swateramount;
    String SnumberOfUniration ;
    ColorsAdapter colorsAdapter;
    ArrayList<Integer> colorsList;
    double DBMI=0.0;
    Date c;
    SimpleDateFormat s;
    String FormatDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood__and__glucose__update);
        initView();
        date();
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Medical> medicalModel = MyDataBase.getInstance(getApplicationContext())
                .medicalDao().getAllInformation();
        getAll(medicalModel);
    }
    private void initView() {
        updatebtn = (Button) findViewById(R.id.updatebtn);
        updatebtn.setOnClickListener(Uri_Water_Update_Activity.this);
        progresbtn = (Button) findViewById(R.id.progresbtn);
        progresbtn.setOnClickListener(Uri_Water_Update_Activity.this);
        editdate = (EditText) findViewById(R.id.editdate);
        Syastolic = (EditText) findViewById(R.id.Syastolic);
        diastolic = (EditText) findViewById(R.id.diastolic);
        PulseRate = (EditText) findViewById(R.id.PulseRate);
        BloodGlucose = (EditText) findViewById(R.id.BloodGlucose);
        Height = (EditText) findViewById(R.id.Height);
        Weight = (EditText) findViewById(R.id.Weight);
        BodymassIndex = (TextView) findViewById(R.id.Bodymass_index);
        BMICase = (TextView) findViewById(R.id.BMI_Case);
        urinationn = (EditText) findViewById(R.id.urinationn);
        wateramount = (EditText) findViewById(R.id.wateramount);
        uricolorsSpinner = (Spinner) findViewById(R.id.uricolors_spinner);
        colorsList=new ArrayList<>();
        colorsList.add(R.drawable.orange);
        colorsList.add(R.drawable.darkbrown);
        colorsList.add(R.drawable.black);
        colorsList.add(R.drawable.pink);
        colorsList.add(R.drawable.blue_green);
        colorsList.add(R.drawable.white);
        colorsAdapter=new ColorsAdapter(this,colorsList);
        uricolorsSpinner.setAdapter(colorsAdapter);
        uricolorsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:SuricolorsSpinner="Orange";
                        break;
                    case 1:SuricolorsSpinner="Dark Brown";
                        break;
                    case 2:SuricolorsSpinner="Black";
                        break;
                    case 3:SuricolorsSpinner="Pink / Red";
                        break;
                    case 4:SuricolorsSpinner="Blue / Green";
                        break;
                    case 5:SuricolorsSpinner="White / Milky";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void getText() {

        Sdate = editdate.getText().toString().trim();
        SnumberOfUniration = urinationn.getText().toString().trim();
        SSyastolic = Syastolic.getText().toString().trim();
        Sdiastolic = diastolic.getText().toString().trim();
        SPulseRate = PulseRate.getText().toString().trim();
        SBloodGlucose = BloodGlucose.getText().toString().trim();
        SHeight = Height.getText().toString().trim();
        SWeight = Weight.getText().toString().trim();
        SBodymassIndex = BodymassIndex.getText().toString().trim();
        SBMICase = BMICase.getText().toString().trim();
        Swateramount = wateramount.getText().toString().trim();

    }
    private void date() {
        c = Calendar.getInstance().getTime();
        s = new SimpleDateFormat("dd-MM-yyyy");
        FormatDate = s.format(c);
        editdate.setText(FormatDate);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.updatebtn) {
            getText();
            if (SSyastolic.isEmpty()) {
                Syastolic.requestFocus();
                Syastolic.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (Sdiastolic.isEmpty()) {
                diastolic.requestFocus();
                diastolic.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (SPulseRate.isEmpty()) {
                PulseRate.requestFocus();
                PulseRate.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (SBloodGlucose.isEmpty()) {
                BloodGlucose.requestFocus();
                BloodGlucose.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (SHeight.isEmpty()) {
                Height.requestFocus();
                Height.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (SWeight.isEmpty()) {
                Weight.requestFocus();
                Weight.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (Swateramount.isEmpty()) {
                wateramount.requestFocus();
                wateramount.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (SnumberOfUniration.isEmpty()) {
                urinationn.requestFocus();
                urinationn.setError("FIELD CANNOT BE EMPTY");
                return;
            } else {
                Medical medicalModel = new Medical(Sdate,
                        SHeight,
                        SWeight,
                        SSyastolic,
                        Sdiastolic,
                        SPulseRate,
                        SBloodGlucose,
                        SnumberOfUniration,
                        SuricolorsSpinner,
                        Swateramount);
                MyDataBase.getInstance(getApplicationContext()).
                        medicalDao().AddInfo(medicalModel);

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        }
        else if (view.getId() == R.id.progresbtn) {

            startActivity(new Intent(getApplicationContext(),Progress_Uri_Water_Activity.class));
        }
    }
    private void getAll(List<Medical> informationsModels) {

        for (Medical n : informationsModels) {

            Syastolic.setText(n.getSyastolic());
            diastolic.setText(n.getDiastolic());
            PulseRate.setText(n.getPulse_rate());
            BloodGlucose.setText(n.getGlucose());
            Height.setText(n.getHeight());
            Weight.setText(n.getWeight());
            BodymassIndex.setText(n.getBody_mass_index());
            urinationn.setText(n.getUrinations());
            wateramount.setText(n.getWater_amount());
            DBMI=Double.parseDouble(n.getBody_mass_index());
            if (DBMI<=18.5){
                BMICase.setText("Underweight");
                BMICase.setTextColor(getResources().getColor(R.color.dangrous));
            }
            else if (DBMI>18.5&& DBMI<=24.9){
                BMICase.setText("Normal Weight");
                BMICase.setTextColor(getResources().getColor(R.color.excallent));
            }
            else if (DBMI>= 25.0 && DBMI <= 29.9){
                BMICase.setText("Over weight");
                BMICase.setTextColor(getResources().getColor(R.color.colorYellow));
            }
            else
            {
                BMICase.setText("Obesity");
                BMICase.setTextColor(getResources().getColor(R.color.dangrous));
            }

        }


    }
}
