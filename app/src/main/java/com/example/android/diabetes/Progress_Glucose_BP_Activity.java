package com.example.android.diabetes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.diabetes.database.Models.Medical;
import com.example.android.diabetes.database.MyDataBase;

import java.util.ArrayList;
import java.util.List;

public class Progress_Glucose_BP_Activity extends AppCompatActivity {

    RecyclerView RecyclerBlood;
    List<ProgressModel> progressModels;
    RecyclerView.LayoutManager layoutManager;
    ProgressAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_progress__glucose__bp_);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Medical> medicalModel = MyDataBase.getInstance(getApplicationContext())
                .medicalDao().getAllInformation();
        getAll(medicalModel);
    }

    private void getAll(List<Medical> medicalModel) {
        for (Medical n : medicalModel) {

            progressModels.add(new ProgressModel(n.getDate(), n.getGlucose(),n.getSyastolic(),n.getDiastolic()));
        }
        }

    private void initView() {
        RecyclerBlood = (RecyclerView) findViewById(R.id.Recycler_Blood);
        progressModels=new ArrayList<>();
        adapter = new ProgressAdapter(progressModels);
        layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        RecyclerBlood.setLayoutManager(layoutManager);
        RecyclerBlood.setAdapter(adapter);
    }

    public class ProgressAdapter extends RecyclerView.Adapter<ProgressAdapter.ProgressHolder> {

        List<ProgressModel> progressModels ;

        public ProgressAdapter(List<ProgressModel> progressModels) {
            this.progressModels = progressModels;
        }

        @NonNull
        @Override
        public ProgressHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_progress, parent,false);
            return new ProgressHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProgressHolder holder, int position) {
            ProgressModel progressModel = progressModels.get(position);
            String date , systolic ,diastolic, glucose ;
            date = progressModel.getDate();
            glucose=progressModel.getText2();
            int int_glucose=Integer.parseInt(glucose);
            systolic=progressModel.getSystolic();
            int int_systolic=Integer.parseInt(systolic);
            diastolic=progressModel.getDiastolic();
            int int_diastolic=Integer.parseInt(diastolic);
            if (int_glucose>=9)
                holder.text2.setTextColor(getResources().getColor(R.color.dangrous));
            else if (int_glucose==7||int_glucose==8)
                holder.text2.setTextColor(getResources().getColor(R.color.colorYellow));
            else if(int_glucose>=4&&int_glucose<=6)
                holder.text2.setTextColor(getResources().getColor(R.color.excallent));
           // colors of blood pressure
            if (int_systolic<120&&int_diastolic<80)
                holder.text1.setTextColor(getResources().getColor(R.color.excallent));
           else if (int_systolic>=120&&int_systolic<=130&&int_diastolic<80)
                holder.text1.setTextColor(getResources().getColor(R.color.colorYellow));
           else if (int_systolic>=130&&int_systolic<=140&&int_diastolic>=80&&int_diastolic<=90)
                holder.text1.setTextColor(getResources().getColor(R.color.highblood));
           else if (int_systolic>=140&&int_diastolic>=90&&int_diastolic<120)
                holder.text1.setTextColor(getResources().getColor(R.color.highblood2));
            else if (int_systolic>=140&&int_diastolic>=90)
                holder.text1.setTextColor(getResources().getColor(R.color.dangrous));
            holder.date.setText(date);
            holder.text1.setText(systolic+"/"+diastolic);
            holder.text2.setText(glucose);



        }

        @Override
        public int getItemCount() {
            if (progressModels == null) return 0;
            return progressModels.size();
        }

        class ProgressHolder extends RecyclerView.ViewHolder{
            TextView date , text1 , text2 ;

            public ProgressHolder(@NonNull View itemView) {
                super(itemView);

                date = itemView.findViewById(R.id.date);
                text1 = itemView.findViewById(R.id.Text1);
                text2 = itemView.findViewById(R.id.Text2);
            }
        }

    }
}
