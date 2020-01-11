package com.example.android.diabetes.database.Models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Personal {
    @PrimaryKey(autoGenerate = true)
    int Userid ;
    String photopath;
    String name;
    String phone;
    String birthdate;
    String gender;
    String maritalStatus;
    String country;
    String governorate;

    String ParentName ;
    String ParentPhone ;
    String ParentEmail;
    String PharmacyName ;
    String PharmacyPhone;
    String DoctorName ;
    String DoctorPhone;
    String DoctorEmail;

    public Personal(){};

    public Personal(String photopath,
                    String name,
                    String phone,
                    String birthdate,
                    String gender,
                    String maritalStatus,
                    String country,
                    String governorate,
                    String parentName,
                    String parentPhone,
                    String parentEmail,
                    String pharmacyName,
                    String pharmacyPhone,
                    String doctorName,
                    String doctorPhone,
                    String doctorEmail) {
        this.photopath=photopath;
        this.name = name;
        this.phone = phone;
        this.birthdate = birthdate;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.country = country;
        this.governorate = governorate;
        ParentName = parentName;
        ParentPhone = parentPhone;
        ParentEmail = parentEmail;
        PharmacyName = pharmacyName;
        PharmacyPhone = pharmacyPhone;
        DoctorName = doctorName;
        DoctorPhone = doctorPhone;
        DoctorEmail = doctorEmail;
    }

    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }

    public int getUserid() {
        return Userid;
    }

    public void setUserid(int userid) {
        Userid = userid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGovernorate() {
        return governorate;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public String getParentName() {
        return ParentName;
    }

    public void setParentName(String parentName) {
        ParentName = parentName;
    }

    public String getParentPhone() {
        return ParentPhone;
    }

    public void setParentPhone(String parentPhone) {
        ParentPhone = parentPhone;
    }

    public String getParentEmail() {
        return ParentEmail;
    }

    public void setParentEmail(String parentEmail) {
        ParentEmail = parentEmail;
    }

    public String getPharmacyName() {
        return PharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        PharmacyName = pharmacyName;
    }

    public String getPharmacyPhone() {
        return PharmacyPhone;
    }

    public void setPharmacyPhone(String pharmacyPhone) {
        PharmacyPhone = pharmacyPhone;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public String getDoctorPhone() {
        return DoctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        DoctorPhone = doctorPhone;
    }

    public String getDoctorEmail() {
        return DoctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        DoctorEmail = doctorEmail;
    }
}
