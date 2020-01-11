package com.example.android.diabetes.database.Models;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Medical {
    @PrimaryKey(autoGenerate = true)
    int Userid ;
    String Date ;
    String height;
    String weight;
    String diastolic;
    String syastolic;
    String pulse_rate;
    String glucose;
    String blood_type;
    String urinations;
    String urine_color;
    String water_amount;
    String body_mass_index;

    public double h  = 0;
    public double w = 0;
    public double x= 0.0;
    public double rounded;

    public Medical(){}
   @Ignore
    public Medical(String date,
                   String height,
                   String weight,
                   String syastolic,
                   String diastolic,
                   String glucose,
                   String blood_type,
                   String pulse_rate,
                   String urinations,
                   String urine_color,
                   String water_amount) {
        Date = date;
        this.height = height;
        this.weight = weight;
        this.diastolic = diastolic;
        this.syastolic = syastolic;
        this.glucose = glucose;
        this.blood_type = blood_type;
        this.pulse_rate=pulse_rate;
        this.urinations = urinations;
        this.urine_color=urine_color;
        this.water_amount = water_amount;
    }
@Ignore
    public Medical(String date,
                   String height,
                   String weight,
                   String syastolic,
                   String diastolic,
                   String pulse_rate,
                   String glucose,
                   String urinations,
                   String urine_color,
                   String water_amount) {
        Date = date;
        this.height = height;
        this.weight = weight;
        this.diastolic = diastolic;
        this.syastolic = syastolic;
        this.pulse_rate = pulse_rate;
        this.glucose = glucose;
        this.urinations = urinations;
        this.urine_color = urine_color;
        this.water_amount = water_amount;
    }

    public int getUserid() {
        return Userid;
    }

    public void setUserid(int userid) {
        Userid = userid;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(String diastolic) {
        this.diastolic = diastolic;
    }

    public String getSyastolic() {
        return syastolic;
    }

    public void setSyastolic(String syastolic) {
        this.syastolic = syastolic;
    }

    public String getPulse_rate() {
        return pulse_rate;
    }

    public void setPulse_rate(String pulse_rate) {
        this.pulse_rate = pulse_rate;
    }

    public String getGlucose() {
        return glucose;
    }

    public void setGlucose(String glucose) {
        this.glucose = glucose;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public String getUrinations() {
        return urinations;
    }

    public void setUrinations(String urinations) {
        this.urinations = urinations;
    }

    public String getUrine_color() {
        return urine_color;
    }

    public void setUrine_color(String urine_color) {
        this.urine_color = urine_color;
    }

    public String getWater_amount() {
        return water_amount;
    }

    public void setWater_amount(String water_amount) {
        this.water_amount = water_amount;
    }
    public String getBody_mass_index() {

        h = (double) (Integer.parseInt(height)) / 100;
        w = (double) (Integer.parseInt(weight));
        x = (w / (h * h)) ;
        rounded = Math.round(x * 10) / 10.0;
        body_mass_index = rounded+"";
        return body_mass_index;
    }

    public void setBody_mass_index(String body_mass_index) {
        this.body_mass_index = body_mass_index;
    }
    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
