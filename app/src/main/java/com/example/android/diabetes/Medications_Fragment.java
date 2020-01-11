package com.example.android.diabetes;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.android.diabetes.BroadcastRecevier.medicineAlarmReceiver;
import com.example.android.diabetes.database.Models.Alarm;
import com.example.android.diabetes.database.Models.Medical;
import com.example.android.diabetes.database.MyDataBase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import androidx.fragment.app.Fragment;

import static android.content.Context.ALARM_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Medications_Fragment extends Fragment {

    private LinearLayout linearLayout;
    private EditText nameMedicene;
    private Button addMore;
    private Spinner mediceneLibrary;
    private EditText dailyDose;
    private EditText dailyTime;
    private Button addToAlarm;
    private View view;
    String medicene_nameSpinner;
    List<String> medicene_list;

    TimePickerDialog timePickerDialog;
    int hour;
    int min;
    int id = 0;
    int requestCode = 0 ;
    public Medications_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_medications_, container, false);
        initView();
        medicene_list=MyDataBase.getInstance(getContext()).alarmDao().getMediceneName();
       SpinnerMediceneLibrary();
        return view;
    }

    private void initView() {
        linearLayout=view.findViewById(R.id.linear);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        nameMedicene = (EditText) view.findViewById(R.id.name_medicene);
        medicene_list=new ArrayList<>();
        addMore = (Button) view.findViewById(R.id.add_more);
        addMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameMedicene.getText().toString().isEmpty())
                    nameMedicene.setError("Medicene Name cannot be empty");
                else {
                    Alarm alarm=new Alarm(nameMedicene.getText().toString());
                    MyDataBase.getInstance(getContext()).alarmDao().AddInfo(alarm);
                    medicene_list=MyDataBase.getInstance(getContext()).alarmDao().getMediceneName();
                    SpinnerMediceneLibrary();
                    nameMedicene.setText("");
                    Toast.makeText(getContext(), "Medicene Added", Toast.LENGTH_SHORT).show();}
            }
        });
        mediceneLibrary = (Spinner) view.findViewById(R.id.medicene_library);
        dailyDose = (EditText) view.findViewById(R.id.daily_dose);
        dailyTime = (EditText) view.findViewById(R.id.daily_time);
        dailyTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        dailyTime.setText(hourOfDay + ":" + minute);
                        hour = hourOfDay;
                        min = minute;
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false);
                timePickerDialog.show();
            }
        });
        addToAlarm = (Button) view.findViewById(R.id.add_to_alarm);
        addToAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dailyDose.getText().toString().trim().isEmpty())
                    dailyDose.setError("cannot be empty");
                else {

                    addAlarm();
                    Toast.makeText(getContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addAlarm() {
        Calendar now = Calendar.getInstance();
        Calendar chosedTime = Calendar.getInstance();
        chosedTime.set(Calendar.HOUR_OF_DAY, hour);
        chosedTime.set(Calendar.MINUTE, min);
        long alarmMillis = chosedTime.getTimeInMillis();
        if (chosedTime.before(now))
            chosedTime.add(Calendar.DAY_OF_MONTH, 1);
        AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(getContext(), medicineAlarmReceiver.class);
        intent.putExtra("name", medicene_nameSpinner);
        id++ ;
        intent.putExtra("id",id);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), requestCode,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        requestCode++;

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, chosedTime.getTimeInMillis(),
                1000 * 60 * 60*24, pendingIntent);
        dailyDose.setText("");
        dailyTime.setText("");
    }


    private void SpinnerMediceneLibrary() {

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, medicene_list);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mediceneLibrary.setAdapter(adapter);
        mediceneLibrary.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                medicene_nameSpinner = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}
