package com.example.android.diabetes;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import de.hdodenhof.circleimageview.CircleImageView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.diabetes.database.Models.Medical;
import com.example.android.diabetes.database.Models.Personal;
import com.example.android.diabetes.database.MyDataBase;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileFragment extends Fragment {
    CircleImageView circleImageView;
    protected TextView update_profile;
    protected View rootView;
    protected TextView UserNamee;
    protected TextView Email;
    protected TextView PhoneNum;
    protected TextView birthDate;
    protected TextView gender;
    protected TextView MaritalStatus;
    protected TextView Country;
    protected TextView Governorate;
    protected TextView Hieght;
    protected TextView Weight;
    protected TextView BMI;
    protected TextView bodyState;
    protected TextView pulseRate;
    protected TextView bloodType;
    protected TextView urineColor;
    protected TextView parentName;
    protected TextView num;
    protected TextView parentNum;
    protected TextView parentEmail;
    protected TextView pharmacyName;
    protected TextView pharmacyNum;
    protected TextView doctorName;
    protected TextView doctorNum;
    protected TextView Logout;
    public static String USER_NAME;
    double DBMI=0.0;


    public MyProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_my_profile, container,
                false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        circleImageView=(CircleImageView) rootView.findViewById(R.id.my_photo);
        update_profile=rootView.findViewById(R.id.update_profile);
        update_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),Update_profile_Activity.class));
            }
        });
        UserNamee = (TextView) rootView.findViewById(R.id.UserNamee);
        Email = (TextView) rootView.findViewById(R.id.Email);
        Email.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
        PhoneNum = (TextView) rootView.findViewById(R.id.Phone_num);
        birthDate = (TextView) rootView.findViewById(R.id.birth_date);
        gender = (TextView) rootView.findViewById(R.id.gender);
        MaritalStatus = (TextView) rootView.findViewById(R.id.Marital_status);
        Country = (TextView) rootView.findViewById(R.id.Country);
        Governorate = (TextView) rootView.findViewById(R.id.Governorate);
        Hieght = (TextView) rootView.findViewById(R.id.Hieght);
        Weight = (TextView) rootView.findViewById(R.id.Weight);
        BMI = (TextView) rootView.findViewById(R.id.B_M_I);
        bodyState = (TextView) rootView.findViewById(R.id.body_state);
        pulseRate = (TextView) rootView.findViewById(R.id.pulse_rate);
        bloodType = (TextView) rootView.findViewById(R.id.blood_type);
        urineColor = (TextView) rootView.findViewById(R.id.urine_color);
        parentName = (TextView) rootView.findViewById(R.id.parent_name);
        num = (TextView) rootView.findViewById(R.id.num);
        parentNum = (TextView) rootView.findViewById(R.id.parent_num);
        parentEmail = (TextView) rootView.findViewById(R.id.parent_email);
        pharmacyName = (TextView) rootView.findViewById(R.id.pharmacy_name);
        pharmacyNum = (TextView) rootView.findViewById(R.id.pharmacy_num);
        doctorName = (TextView) rootView.findViewById(R.id.doctor_name);
        doctorNum = (TextView) rootView.findViewById(R.id.doctor_num);
        Logout=rootView.findViewById(R.id.LogOut_btn);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getContext(),LogIn.class));
                getActivity().onBackPressed();
            }
        });
    }

    public void onStart() {
        super.onStart();
        List<Personal> personals = MyDataBase.getInstance(getContext())
                .personalDao().getAllInformation();
        getAllPersonal(personals);
        List<Medical> medicals  = MyDataBase.getInstance(getContext())
                .medicalDao().getAllInformation();
        getAllMedicals(medicals);

    }

    private void getAllMedicals(List<Medical> medicals) {
        for (Medical n :medicals ) {
           Hieght.setText(n.getHeight());
           Weight.setText(n.getWeight());
           BMI.setText(n.getBody_mass_index());
           pulseRate.setText(n.getPulse_rate());
           urineColor.setText(n.getUrine_color());
           if (n.getBlood_type()!=null)
               bloodType.setText(n.getBlood_type());
               DBMI=Double.parseDouble(n.getBody_mass_index());
            if (DBMI<=18.5){
                bodyState.setText("Underweight");
                bodyState.setTextColor(getResources().getColor(R.color.dangrous));
            }
            else if (DBMI>18.5&& DBMI<=24.9){
                bodyState.setText("Normal Weight");
                bodyState.setTextColor(getResources().getColor(R.color.excallent));
            }
            else if (DBMI>= 25.0 && DBMI <= 29.9){
                bodyState.setText("Over weight");
                bodyState.setTextColor(getResources().getColor(R.color.colorYellow));
            }
            else
            {
                bodyState.setText("Obesity");
                bodyState.setTextColor(getResources().getColor(R.color.dangrous));
            }

        }
    }

    private void getAllPersonal(List<Personal> personals) {

        for (Personal n : personals) {
            if (n.getPhotopath()!=null){
                Picasso.get()
                        .load(Uri.parse(n.getPhotopath()))
                        .into(circleImageView);
            }
                UserNamee.setText(n.getName());
                USER_NAME=n.getName();
                PhoneNum.setText(n.getPhone());
                birthDate.setText(n.getBirthdate());
                gender.setText(n.getGender());
                MaritalStatus.setText(n.getMaritalStatus());
                Country.setText(n.getCountry());
                Governorate.setText(n.getGovernorate());
                parentName.setText(n.getParentName());
                parentNum.setText(n.getParentPhone());
                parentEmail.setText(n.getParentEmail());
                pharmacyName.setText(n.getPharmacyName());
                pharmacyNum.setText(n.getPharmacyPhone());
                doctorName.setText(n.getDoctorName());
                doctorNum.setText(n.getDoctorPhone());
        }
    }

}
