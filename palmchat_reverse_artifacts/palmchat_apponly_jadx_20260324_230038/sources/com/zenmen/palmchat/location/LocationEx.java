package com.zenmen.palmchat.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class LocationEx implements Parcelable {
    public static final Parcelable.Creator<LocationEx> CREATOR = new a();
    private String adName;
    private String address;
    private String aoiName;
    private String city;
    private String cityCode;
    private String coorType;
    private String country;
    private double latitude;
    private double longitude;
    private String name;
    private String province;
    private String realCityName;
    private String staticMapImageUrl;
    private long time;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<LocationEx> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocationEx createFromParcel(Parcel parcel) {
            LocationEx locationEx = new LocationEx();
            locationEx.setLatitude(parcel.readDouble());
            locationEx.setLongitude(parcel.readDouble());
            locationEx.setCoorType(parcel.readString());
            locationEx.setName(parcel.readString());
            locationEx.setAddress(parcel.readString());
            locationEx.setStaticMapImageUrl(parcel.readString());
            locationEx.setCountry(parcel.readString());
            locationEx.setProvince(parcel.readString());
            locationEx.setAoiName(parcel.readString());
            locationEx.setCity(parcel.readString());
            locationEx.setCityCode(parcel.readString());
            locationEx.setRealCityName(parcel.readString());
            locationEx.setTime(parcel.readLong());
            return locationEx;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public LocationEx[] newArray(int i) {
            return new LocationEx[i];
        }
    }

    public LocationEx() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdName() {
        return this.adName;
    }

    public String getAddress() {
        return this.address;
    }

    public String getAoiName() {
        return this.aoiName;
    }

    public String getCity() {
        return this.city;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public String getCoorType() {
        return this.coorType;
    }

    public String getCountry() {
        return this.country;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getName() {
        return this.name;
    }

    public String getNameForSquare() {
        return !TextUtils.isEmpty(this.aoiName) ? this.aoiName : this.name;
    }

    public String getProvince() {
        return this.province;
    }

    public String getRealCityName() {
        return this.realCityName;
    }

    public String getStaticMapImageUrl() {
        return this.staticMapImageUrl;
    }

    public long getTime() {
        return this.time;
    }

    public void setAdName(String str) {
        this.adName = str;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAoiName(String str) {
        this.aoiName = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public void setCoorType(String str) {
        this.coorType = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setRealCityName(String str) {
        this.realCityName = str;
    }

    public void setStaticMapImageUrl(String str) {
        this.staticMapImageUrl = str;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public String toString() {
        return "LocationEx_latitude" + this.latitude + "_longitude" + this.longitude + "_coorType" + this.coorType + "_name" + this.name + "_address" + this.address + "_staticMapImageUrl" + this.staticMapImageUrl + "_cityCode" + this.cityCode + "city=" + this.city;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeString(this.coorType);
        parcel.writeString(this.name);
        parcel.writeString(this.address);
        parcel.writeString(this.staticMapImageUrl);
        parcel.writeString(this.country);
        parcel.writeString(this.province);
        parcel.writeString(this.aoiName);
        parcel.writeString(this.city);
        parcel.writeString(this.cityCode);
        parcel.writeString(this.realCityName);
        parcel.writeLong(this.time);
    }

    public LocationEx(double d, double d2, String str, String str2, String str3, String str4, String str5) {
        this.latitude = d;
        this.longitude = d2;
        this.coorType = str;
        this.name = str2;
        this.address = str3;
        this.country = str4;
        this.cityCode = str5;
    }

    public LocationEx(double d, double d2, String str, String str2, String str3) {
        this(d, d2, str, str2, str3, null, null);
    }
}
