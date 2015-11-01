package models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xzbla on 31/10/2015.
 */
public class Result implements Parcelable {
    private String _region;
    private String _city;
    private String _suburb;
    private String _genderOfStudents;
    private String _schoolType;
    private String _decile;

    public Result(String region, String city, String suburb, String genderOfStudents,
                  String schoolType, String decile)
    {
        _region = region;
        _city = city;
        _suburb = suburb;
        _genderOfStudents = genderOfStudents;
        _schoolType = schoolType;
        _decile = decile;
    }

    protected Result(Parcel in) {
        _region = in.readString();
        _city = in.readString();
        _suburb = in.readString();
        _genderOfStudents = in.readString();
        _schoolType = in.readString();
        _decile = in.readString();
    }

    public String getRegion() {
        return _region;
    }

    public void setRegion(String region) {
        _region = region;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String city) {
        _city = city;
    }

    public String getSuburb() {
        return _suburb;
    }

    public void setSuburb(String suburb) {
        _suburb = suburb;
    }

    public String getGenderOfStudents() {
        return _genderOfStudents;
    }

    public void setGenderOfStudents(String gender) {
        _genderOfStudents = gender;
    }

    public String getSchoolType() {
        return _schoolType;
    }

    public void setSchoolType(String schoolType) {
        _schoolType = schoolType;
    }

    public String getDecile() {
        return _decile;
    }

    public void setDecile(String decile) {
        _decile = decile;
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_region);
        dest.writeString(_city);
        dest.writeString(_suburb);
        dest.writeString(_genderOfStudents);
        dest.writeString(_schoolType);
        dest.writeString(_decile);
    }
}
