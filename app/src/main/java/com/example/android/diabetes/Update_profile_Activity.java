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

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class Update_profile_Activity extends AppCompatActivity implements View.OnClickListener {

    private CircleImageView crop;
    private EditText Name;
    private EditText PhoneNum;
    private EditText BirthDate;
    private Spinner gender;
    private Spinner MaritalStatus;
    private EditText Country;
    private EditText Governorate;
    private EditText PName;
    private EditText PNum;
    private EditText PEmail;
    private EditText PhName;
    private EditText PhNum;
    private EditText spName;
    private EditText spNum;
    private EditText spEmail;
    private Button Finish;
    Uri photoPath=null;
    String UserName;
    String UserPhone;
    String birthDate;
    String Gender;
    String maritalStatus;
    String country;
    String governerate;
    String Pname;
    String PPhone;
    String Pemail;
    String Phname;
    String phPhone;
    String SPname;
    String SPPhone;
    String SPEmail;
    String photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile_);
        initView();
        SpinnerDataGender();
        SpinnerDataMarital();
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Personal> personalModel = MyDataBase.getInstance(getApplicationContext())
                .personalDao().getAllInformation();
        getAll(personalModel);
    }
    private void initView() {
        crop = (CircleImageView) findViewById(R.id.crop);
        crop.setOnClickListener(Update_profile_Activity.this);
        Name = (EditText) findViewById(R.id.Name);
        PhoneNum = (EditText) findViewById(R.id.Phone_num);
        BirthDate = (EditText) findViewById(R.id.birth_date);
        gender = (Spinner) findViewById(R.id.gender);
        MaritalStatus = (Spinner) findViewById(R.id.Marital_status);
        Country = (EditText) findViewById(R.id.Country);
        Governorate = (EditText) findViewById(R.id.Governorate);
        PName = (EditText) findViewById(R.id.P_name);
        PNum = (EditText) findViewById(R.id.P_num);
        PEmail = (EditText) findViewById(R.id.P_email);
        PhName = (EditText) findViewById(R.id.Ph_name);
        PhNum = (EditText) findViewById(R.id.Ph_num);
        spName = (EditText) findViewById(R.id.sp_name);
        spNum = (EditText) findViewById(R.id.sp_num);
        spEmail = (EditText) findViewById(R.id.sp_email);
        Finish = (Button) findViewById(R.id.Finish);
        Finish.setOnClickListener(Update_profile_Activity.this);

    }
    private void getText() {
        UserName = Name.getText().toString();
        UserPhone = PhoneNum.getText().toString();
        birthDate = BirthDate.getText().toString();
        country = Country.getText().toString();
        governerate = Governorate.getText().toString();
        Pname = PName.getText().toString();
        PPhone = PNum.getText().toString();
        Pemail = PEmail.getText().toString();
        Phname = PhName.getText().toString();
        phPhone = PhNum.getText().toString();
        SPname = spName.getText().toString();
        SPPhone = spNum.getText().toString();
        SPEmail = spEmail.getText().toString();
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
                BirthDate.requestFocus();
                BirthDate.setError("FIELD CANNOT BE EMPTY");
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
                if (photoPath==null)
                     photo="";
                else {photo=photoPath.toString();}
                Personal personalModel = new Personal(
                        photo,
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
                MyDataBase.getInstance(getApplicationContext()).
                        personalDao().AddInfo(personalModel);
                Toast.makeText(this, "Updated sucessfully", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();

            }
        }
        if (view.getId()==R.id.crop){
            CropImage.activity()
                    .setGuidelines(CropImageView.Guidelines.ON_TOUCH)
                    .setAspectRatio(1,1)
                    .start(Update_profile_Activity.this);
        }

    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE&&resultCode==RESULT_OK&&data!=null){
            CropImage.ActivityResult activityResult=CropImage.getActivityResult(data);
            photoPath=activityResult.getUri();
            Picasso.get()
                    .load(photoPath)
                    .into(crop); }
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
    private void getAll(List<Personal> personalModel) {
        for (Personal n : personalModel) {
           Name.setText(n.getName());
           PhoneNum.setText(n.getPhone());
           BirthDate.setText(n.getBirthdate());
           Country.setText(n.getCountry());
           Governorate.setText(n.getGovernorate());
           PName.setText(n.getParentName());
           PNum.setText(n.getParentPhone());
           PEmail.setText(n.getParentEmail());
           PhName.setText(n.getPharmacyName());
           PhNum.setText(n.getPharmacyPhone());
           spName.setText(n.getDoctorName());
           spNum.setText(n.getDoctorPhone());
           spEmail.setText(n.getDoctorEmail());
        }
    }
}
