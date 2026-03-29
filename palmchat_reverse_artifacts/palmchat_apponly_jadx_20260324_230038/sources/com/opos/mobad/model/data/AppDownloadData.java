package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AppDownloadData extends a implements Parcelable {
    public static final Parcelable.Creator<AppDownloadData> CREATOR = new Parcelable.Creator<AppDownloadData>() { // from class: com.opos.mobad.model.data.AppDownloadData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppDownloadData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            AppDownloadData appDownloadData = new AppDownloadData();
            appDownloadData.a(parcel.readString());
            appDownloadData.b(parcel.readString());
            appDownloadData.d(parcel.readString());
            appDownloadData.c(parcel.readString());
            return appDownloadData;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppDownloadData[] newArray(int i) {
            return new AppDownloadData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9080a;
    private String b;
    private String c;
    private String d;

    public String a() {
        return this.f9080a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "appDownloadData{url=" + this.f9080a + ", md5=" + this.b + ", pkgName=" + this.c + ", appName=" + this.d + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9080a);
        parcel.writeString(this.b);
        parcel.writeString(this.d);
        parcel.writeString(this.c);
    }

    public void a(String str) {
        this.f9080a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.d = str;
    }
}
