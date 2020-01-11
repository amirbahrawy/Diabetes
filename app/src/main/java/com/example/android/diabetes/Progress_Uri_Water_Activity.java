package com.example.android.diabetes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.diabetes.database.Models.Medical;
import com.example.android.diabetes.database.MyDataBase;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Progress_Uri_Water_Activity extends AppCompatActivity {


    RecyclerView Recycler_Uri_Water;
    List<ProgressModel> progressModels;
    RecyclerView.LayoutManager layoutManager;
    UriProgressAdapter adapter;
    private RecyclerView RecyclerUriWater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress__uri__water_);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Medical> medicalModel = MyDataBase.getInstance(getApplicationContext())
                .medicalDao().getAllInformation();
        getAll(medicalModel);
    }

    private void getAll(List<Medical> medicals) {
        for (Medical n : medicals) {
            progressModels.add(new ProgressModel(n.getDate(), n.getUrinations(), n.getWater_amount(),n.getUrine_color()));
        }
    }

    private void initView() {
        Recycler_Uri_Water =findViewById(R.id.rec_uri);
        progressModels = new ArrayList<>();
        adapter = new UriProgressAdapter(progressModels);
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        Recycler_Uri_Water.setLayoutManager(layoutManager);
        Recycler_Uri_Water.setAdapter(adapter);
    }

    public class UriProgressAdapter extends RecyclerView.Adapter<UriProgressAdapter.ProgressHolder> {

        List<ProgressModel> progressModels ;

        public UriProgressAdapter(List<ProgressModel> progressModels) {
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
            String date , text1 , text2,urine_color ;
            date = progressModel.getDate();
            text1=progressModel.getText2();
            text2=progressModel.getSystolic();
            urine_color=progressModel.getDiastolic();
            if (urine_color==null)
                urine_color="";
            if (urine_color.equals("Orange"))
                holder.text1.setTextColor(getResources().getColor(R.color.orange_urine));
            else if (urine_color.equals("Dark Brown"))
                holder.text1.setTextColor(getResources().getColor(R.color.brown));
            else if (urine_color.equals("Black"))
                holder.text1.setTextColor(getResources().getColor(R.color.black_urine));
           else if (urine_color.equals("Pink / Red"))
                holder.text1.setTextColor(getResources().getColor(R.color.pink_urine));
            else if (urine_color.equals("Blue / Green"))
                holder.text1.setTextColor(getResources().getColor(R.color.blue_urine));
            else if (urine_color.equals("White / Milky"))
                holder.text1.setTextColor(getResources().getColor(R.color.colorWhite));
            else
                holder.text1.setTextColor(getResources().getColor(R.color.black));

            holder.date.setText(date);
            holder.text1.setText(text1);
            holder.text2.setText(text2);



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
