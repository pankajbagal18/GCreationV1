package com.dev.pankaj.gcreationv1;


import android.os.Parcel;
import android.os.Parcelable;

public class ProfileData implements Parcelable {
    private String name;
    private String dob;
    private String dobTime;
    private String birthPlace;
    private String city;
    private String qualification;
    private String gotra;
    private String occupation;
    private String mobile_no;
    public ProfileData()
    {

    }
    public ProfileData(String name, String dob, String dobTime, String birthPlace, String city, String qualification, String gotra, String occupation, String mobile_no) {
        this.name = name;
        this.dob = dob;
        this.dobTime = dobTime;
        this.birthPlace = birthPlace;
        this.city = city;
        this.qualification = qualification;
        this.gotra = gotra;
        this.occupation = occupation;
        this.mobile_no = mobile_no;
    }

    protected ProfileData(Parcel in) {
        name = in.readString();
        dob = in.readString();
        dobTime = in.readString();
        birthPlace = in.readString();
        city = in.readString();
        qualification = in.readString();
        gotra = in.readString();
        occupation = in.readString();
        mobile_no = in.readString();
    }

    public static final Creator<ProfileData> CREATOR = new Creator<ProfileData>() {
        @Override
        public ProfileData createFromParcel(Parcel in) {
            return new ProfileData(in);
        }

        @Override
        public ProfileData[] newArray(int size) {
            return new ProfileData[size];
        }
    };

    @Override
    public String toString() {
        return "ProfileData{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", dobTime='" + dobTime + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", city='" + city + '\'' +
                ", qualification='" + qualification + '\'' +
                ", gotra='" + gotra + '\'' +
                ", occupation='" + occupation + '\'' +
                ", mobile_no='" + mobile_no + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDobTime() {
        return dobTime;
    }

    public void setDobTime(String dobTime) {
        this.dobTime = dobTime;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getGotra() {
        return gotra;
    }

    public void setGotra(String gotra) {
        this.gotra = gotra;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(dob);
        dest.writeString(dobTime);
        dest.writeString(birthPlace);
        dest.writeString(city);
        dest.writeString(qualification);
        dest.writeString(gotra);
        dest.writeString(occupation);
        dest.writeString(mobile_no);

    }
}
