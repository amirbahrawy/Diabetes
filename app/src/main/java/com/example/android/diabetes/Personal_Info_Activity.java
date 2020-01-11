package com.example.android.diabetes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.diabetes.database.Models.Medical;
import com.example.android.diabetes.database.Models.Personal;
import com.example.android.diabetes.database.MyDataBase;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class Personal_Info_Activity extends AppCompatActivity implements View.OnClickListener {
    CircleImageView circleImageView;
    Uri photoPath=null;
    private EditText Name;
    private EditText PhoneNum;
    private EditText BithDate;
    private Spinner gender;
    private Spinner MaritalStatus;
    private EditText Country;
    private EditText Governorate;
    private EditText Hieght;
    private EditText Weight;
    private EditText Syastolic;
    private EditText diastolic;
    private EditText glucose;
    private EditText bloodType;
    private EditText urination;
    private EditText waterAmount;
    private EditText PName;
    private EditText PNum;
    private EditText PEmail;
    private EditText PhName;
    private EditText PhNum;
    private EditText spName;
    private EditText spNum;
    private EditText spEmail;
    private EditText PulseRate;
    private Spinner uricolorsSpinner;
    private Button Finish;

    String UserName;
    String UserPhone;
    String birthDate;
    String Gender;
    String maritalStatus;
    String country;
    String governerate;
    String hieght;
    String weight;
    String SSystolic;
    String SPulseRate;
    String SuricolorsSpinner;
    String SDiastolic;
    String BloodType;
    String Urination;
    String Glucose;
    String WaterAmount;
    String Pname;
    String PPhone;
    String Pemail;
    String Phname;
    String phPhone;
    String SPname;
    String SPPhone;
    String SPEmail;
    ColorsAdapter colorsAdapter;
    ArrayList<Integer> colorsList;
    Date c;
    SimpleDateFormat s;
    String FormatDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal__info_);
        initView();
        SpinnerDataGender();
        SpinnerDataMarital();
    }

    private void initView() {
        circleImageView=(CircleImageView) findViewById(R.id.crop);
        circleImageView.setOnClickListener(Personal_Info_Activity.this);
        Name = (EditText) findViewById(R.id.Name);
        PhoneNum = (EditText) findViewById(R.id.Phone_num);
        BithDate = (EditText) findViewById(R.id.birth_date);
        gender = (Spinner) findViewById(R.id.gender);
        MaritalStatus = (Spinner) findViewById(R.id.Marital_status);
        Country = (EditText) findViewById(R.id.Country);
        Governorate = (EditText) findViewById(R.id.Governorate);
        Hieght = (EditText) findViewById(R.id.Hieght);
        Weight = (EditText) findViewById(R.id.Weight);
        Syastolic = (EditText) findViewById(R.id.Syastolic);
        diastolic = (EditText) findViewById(R.id.diastolic);
        glucose = (EditText) findViewById(R.id.glucose);
        bloodType = (EditText) findViewById(R.id.blood_type);
        urination = (EditText) findViewById(R.id.urination);
        waterAmount = (EditText) findViewById(R.id.water_amount);
        PName = (EditText) findViewById(R.id.P_name);
        PNum = (EditText) findViewById(R.id.P_num);
        PEmail = (EditText) findViewById(R.id.P_email);
        PhName = (EditText) findViewById(R.id.Ph_name);
        PhNum = (EditText) findViewById(R.id.Ph_num);
        spName = (EditText) findViewById(R.id.sp_name);
        spNum = (EditText) findViewById(R.id.sp_num);
        spEmail = (EditText) findViewById(R.id.sp_email);
        Finish = (Button) findViewById(R.id.Finish);
        Finish.setOnClickListener(Personal_Info_Activity.this);
        PulseRate = (EditText) findViewById(R.id.PulseRate);
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
        UserName = Name.getText().toString();
        UserPhone = PhoneNum.getText().toString();
        birthDate = BithDate.getText().toString();
        country = Country.getText().toString();
        governerate = Governorate.getText().toString();
        hieght = Hieght.getText().toString();
        weight = Weight.getText().toString();
        SSystolic = Syastolic.getText().toString();
        SDiastolic = diastolic.getText().toString();
        Glucose = glucose.getText().toString();
        BloodType = bloodType.getText().toString();
        Urination = urination.getText().toString();
        SPulseRate=PulseRate.getText().toString();
        WaterAmount = waterAmount.getText().toString();
        Pname = PName.getText().toString();
        PPhone = PNum.getText().toString();
        Pemail = PEmail.getText().toString();
        Phname = PhName.getText().toString();
        phPhone = PhNum.getText().toString();
        SPname = spName.getText().toString();
        SPPhone = spNum.getText().toString();
        SPEmail = spEmail.getText().toString();
    }

    private String date() {
        c = Calendar.getInstance().getTime();
        s = new SimpleDateFormat("dd-MM-yyyy");
        FormatDate = s.format(c);
        return FormatDate;
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.Finish) {
            getText();

            if (UserName.isEmpty()) {
                Name.requestFocus();
                Name.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (UserPhone.isEmpty()) {
                PhoneNum.requestFocus();
                PhoneNum.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (UserPhone.length() < 11) {
                PhoneNum.setError("enter a vaild number");
                PhoneNum.requestFocus();
                return;
            }
            if (birthDate.isEmpty()) {
                BithDate.requestFocus();
                BithDate.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (country.isEmpty()) {
                Country.requestFocus();
                Country.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (governerate.isEmpty()) {
                Governorate.requestFocus();
                Governorate.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (hieght.isEmpty()) {
                Hieght.requestFocus();
                Hieght.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (weight.isEmpty()) {
                Weight.requestFocus();
                Weight.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (SSystolic.isEmpty()) {
                Syastolic.requestFocus();
                Syastolic.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (SDiastolic.isEmpty()) {
                diastolic.requestFocus();
                diastolic.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (BloodType.isEmpty()) {
                bloodType.requestFocus();
                bloodType.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (Urination.isEmpty()) {
                urination.requestFocus();
                urination.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (Glucose.isEmpty()) {
                glucose.requestFocus();
                glucose.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (WaterAmount.isEmpty()) {
                waterAmount.requestFocus();
                waterAmount.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (Pname.isEmpty()) {
                PName.requestFocus();
                PName.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (PPhone.isEmpty()) {
                PNum.requestFocus();
                PNum.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (PPhone.length() < 11) {
                PNum.setError("enter a vaild number");
                PNum.requestFocus();
                return;
            }
            if (Pemail.isEmpty()) {
                PEmail.requestFocus();
                PEmail.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (Phname.isEmpty()) {
                PhName.requestFocus();
                PhName.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (phPhone.isEmpty()) {
                PhNum.requestFocus();
                PhNum.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (phPhone.length() < 11) {
                PhNum.setError("enter a vaild number");
                PhNum.requestFocus();
                return;
            }
            if (SPname.isEmpty()) {
                spName.requestFocus();
                spName.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (SPPhone.isEmpty()) {
                spNum.requestFocus();
                spNum.setError("FIELD CANNOT BE EMPTY");
                return;
            }
            if (SPPhone.length() < 11) {
                spNum.setError("enter a vaild number");
                spNum.requestFocus();
                return;
            }
            if (SPEmail.isEmpty()) {
                spEmail.requestFocus();
                spEmail.setError("FIELD CANNOT BE EMPTY");
                return;
            } else {
                Personal personalModel = new Personal(
                        photoPath.toString(),
                        UserName,
                        UserPhone,
                        birthDate,
                        Gender,
                        maritalStatus,
                        country,
                        governerate,
                        Pname,
                        PPhone,
                        Pemail,
                        Phname,
                        phPhone,
                        SPname,
                        SPPhone,
                        SPEmail);
                Medical medicalModel = new Medical(date(), hieght, weight, SSystolic, SDiastolic,
                        Glucose, BloodType,SPulseRate, Urination,SuricolorsSpinner, WaterAmount);
                MyDataBase.getInstance(getApplicationContext()).
                        personalDao().AddInfo(personalModel);
                MyDataBase.getInstance(getApplicationContext()).medicalDao().AddInfo(medicalModel);

                Toast.makeText(this, "Regestired sucessfully", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();

            }
        }
        if (view.getId()==R.id.crop){
            CropImage.activity()
                    .setGuidelines(CropImageView.Guidelines.ON_TOUCH)
                    .setAspectRatio(1,1)
                    .start(Personal_Info_Activity.this);
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE&&resultCode==RESULT_OK&&data!=null){
            CropImage.ActivityResult activityResult=CropImage.getActivityResult(data);
            photoPath=activityResult.getUri();
            Picasso.get()
                    .load(photoPath)
                    .into(circleImageView); }
    }

    private void SpinnerDataMarital() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.MaritalStatus, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        MaritalStatus.setAdapter(adapter);
        MaritalStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                maritalStatus = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void SpinnerDataGender() {

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.Gender, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        gender.setAdapter(adapter);
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Gender = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
