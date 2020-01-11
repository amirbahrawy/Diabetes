package com.example.android.diabetes;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


/**
 * A simple {@link Fragment} subclass.
 */
public class Heal_Fragment extends Fragment {

   private View view;
    private Button medication;
    private Button healthTips;
    FragmentTransaction fragmentTransaction;

    public Heal_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_heal_, container, false);
        initView(view);
        return view;
    }

    private void initView(View v) {
        medication = (Button) v.findViewById(R.id.medication);
        medication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame1,new Medications_Fragment());
                fragmentTransaction.addToBackStack(null).commit();

            }
        });
        healthTips = (Button) v.findViewById(R.id.health_tips);
        healthTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame1,new Health_tips_Fragment());
                fragmentTransaction.addToBackStack(null).commit();
            }
        });
    }
}
