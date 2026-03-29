package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class WeatherSearchAlerts implements Parcelable {
    public static final Parcelable.Creator<WeatherSearchAlerts> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3827a;
    private String b;
    private String c;
    private String d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Parcelable.Creator<WeatherSearchAlerts> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherSearchAlerts createFromParcel(Parcel parcel) {
            return new WeatherSearchAlerts(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherSearchAlerts[] newArray(int i) {
            return new WeatherSearchAlerts[i];
        }
    }

    public WeatherSearchAlerts() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDesc() {
        return this.d;
    }

    public String getLevel() {
        return this.b;
    }

    public String getTitle() {
        return this.c;
    }

    public String getType() {
        return this.f3827a;
    }

    public void setDesc(String str) {
        this.d = str;
    }

    public void setLevel(String str) {
        this.b = str;
    }

    public void setTitle(String str) {
        this.c = str;
    }

    public void setType(String str) {
        this.f3827a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3827a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }

    public WeatherSearchAlerts(Parcel parcel) {
        this.f3827a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
    }
}
