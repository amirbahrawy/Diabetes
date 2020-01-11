package com.example.android.diabetes;

public class ProgressModel {
    String Date;
    String Text1;
    String Text2;
    String systolic;

    public String getSystolic() {
        return systolic;
    }

    public void setSystolic(String systolic) {
        this.systolic = systolic;
    }

    public String getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(String diastolic) {
        this.diastolic = diastolic;
    }

    public ProgressModel(String date, String text2, String systolic, String diastolic) {
        Date = date;
        Text2 = text2;
        this.systolic = systolic;
        this.diastolic = diastolic;
    }

    String diastolic ;

    public ProgressModel(String date, String text1, String text2) {
        Date = date;
        Text1 = text1;
        Text2 = text2;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getText1() {
        return Text1;
    }

    public void setText1(String text1) {
        Text1 = text1;
    }

    public String getText2() {
        return Text2;
    }

    public void setText2(String text2) {
        Text2 = text2;
    }
}
