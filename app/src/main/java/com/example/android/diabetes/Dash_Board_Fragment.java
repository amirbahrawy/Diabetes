package com.example.android.diabetes;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.diabetes.database.Models.Medical;
import com.example.android.diabetes.database.MyDataBase;

import java.util.List;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dash_Board_Fragment extends Fragment implements View.OnClickListener {


    private TextView blood;
    private Button BloodU;
    private TextView Glucose;
    private Button GlucoseU;
    private TextView Bodymass;
    private Button BodymassU;
    private TextView Urination;
    private Button UrinationU;
    private TextView Wateramount;
    private Button WateramountU;
    private View view;

    public Dash_Board_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_dash__board_, container, false);
        initView();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        List<Medical> medicals  = MyDataBase.getInstance(getContext())
                .medicalDao().getAllInformation();
        getAll(medicals);
    }

    private void initView() {
        blood = (TextView) view.findViewById(R.id.blood);
        BloodU = (Button) view.findViewById(R.id.Blood_U);
        BloodU.setOnClickListener(this);
        Glucose = (TextView) view.findViewById(R.id.Glucose);
        GlucoseU = (Button) view.findViewById(R.id.Glucose_U);
        GlucoseU.setOnClickListener(this);
        Bodymass = (TextView) view.findViewById(R.id.Bodymass);
        BodymassU = (Button) view.findViewById(R.id.Bodymass_U);
        BodymassU.setOnClickListener(this);
        Urination = (TextView) view.findViewById(R.id.Urination);
        UrinationU = (Button) view.findViewById(R.id.Urination_U);
        UrinationU.setOnClickListener(this);
        Wateramount = (TextView) view.findViewById(R.id.Wateramount);
        WateramountU = (Button) view.findViewById(R.id.Wateramount_U);
        WateramountU.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.Blood_U:
                startActivity(new Intent(getActivity(),Blood_And_Glucose_UpdateActivity.class));
                break;

            case R.id.Glucose_U:
                startActivity(new Intent(getActivity(),Blood_And_Glucose_UpdateActivity.class));
                break;

            case R.id.Bodymass_U:
                startActivity(new Intent(getActivity(),Blood_And_Glucose_UpdateActivity.class));
                break;
            case R.id.Urination_U:
                startActivity(new Intent(getActivity(),Uri_Water_Update_Activity.class));
                break;
            case R.id.Wateramount_U:
                startActivity(new Intent(getActivity(),Uri_Water_Update_Activity.class));
                break;
            default:
                break;
        }
    }

    private void getAll(List<Medical> medicals) {
    for (Medical s:medicals){
        blood.setText(s.getSyastolic()+" / "+s.getDiastolic());
        Glucose.setText(s.getGlucose());
        Urination.setText(s.getUrinations());
        Wateramount.setText(s.getWater_amount());
        Bodymass.setText(s.getBody_mass_index());
    }

    }
}
