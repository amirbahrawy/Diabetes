package com.example.android.diabetes;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.diabetes.database.Models.Personal;
import com.example.android.diabetes.database.MyDataBase;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Community_Fragment extends Fragment {

    private View rootView;
    private Button Emergencybtn;
    private TextView Pname;
    private TextView Pnum;
    private TextView PEmail;
    private TextView phName;
    private TextView phNum;
    private TextView docName;
    private TextView docNum;
    private String parent_num;
    private String User_Name;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    private String MESSAGE="";
    public Community_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_community_, container, false);
        initView(rootView);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        List<Personal> personals= MyDataBase.getInstance(getContext())
                .personalDao()
                .getAllInformation();
        getAll(personals);
    }

    private void initView(View rootView) {
        Emergencybtn =  rootView.findViewById(R.id.Emergencybtn);
        Emergencybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send_SMS();
                makeCall();
            }
        });
        Pname = (TextView) rootView.findViewById(R.id.pname);
        Pnum = (TextView) rootView.findViewById(R.id.pnum);
        PEmail = (TextView) rootView.findViewById(R.id.pemail);
        phName = (TextView) rootView.findViewById(R.id.ph_name);
        phNum = (TextView) rootView.findViewById(R.id.ph_num);
        docName = (TextView) rootView.findViewById(R.id.doc_name);
        docNum = (TextView) rootView.findViewById(R.id.doc_num);
    }
    private void getAll(List<Personal> personals) {
        for (Personal s:personals){
            User_Name=s.getName();
            MESSAGE="Hello, this is an emergency. " +User_Name+
                    "  in danger most likely caused by diabetes. Please help them immediately.";
            Pname.setText(s.getParentName());
            Pnum.setText(s.getParentPhone());
            parent_num=Pnum.getText().toString();
            PEmail.setText(s.getParentEmail());
            phName.setText(s.getPharmacyName());
            phNum.setText(s.getPharmacyPhone());
            docName.setText(s.getDoctorName());
            docNum.setText(s.getDoctorPhone());
        }
    }
    private void send_SMS(){
    int permissionCheck=ContextCompat
            .checkSelfPermission(getContext(),Manifest.permission.SEND_SMS);
        if (permissionCheck==PackageManager.PERMISSION_GRANTED){
              SmsManager.getDefault()
                      .sendTextMessage(parent_num,null, MESSAGE,
                              null,null);
            Toast.makeText(getContext(), "Message Sent", Toast.LENGTH_SHORT).show();
        }
        else {
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.SEND_SMS},0);
        }
    }
    private void makeCall(){
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+parent_num));

        if (ActivityCompat.checkSelfPermission(getContext(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE},1);

        }
        startActivity(callIntent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
       if (requestCode==1){
           if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
               makeCall();
           }
       }
        if (requestCode==0){
            if (grantResults.length>=0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                SmsManager.getDefault()
                        .sendTextMessage(parent_num,null,MESSAGE,
                                null,null);
                Toast.makeText(getContext(), "Message Sent", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getContext(), "Permession Needed", Toast.LENGTH_SHORT).show();
            }

        }
    }
}





