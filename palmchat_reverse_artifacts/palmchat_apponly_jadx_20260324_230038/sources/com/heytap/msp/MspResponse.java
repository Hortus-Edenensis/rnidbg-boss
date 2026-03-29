package com.heytap.msp;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class MspResponse implements Parcelable {
    public static final Parcelable.Creator<MspResponse> CREATOR = new Parcelable.Creator<MspResponse>() { // from class: com.heytap.msp.MspResponse.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MspResponse createFromParcel(Parcel parcel) {
            return new MspResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MspResponse[] newArray(int i) {
            return new MspResponse[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6361a;
    private String b;
    private Bundle c;

    public MspResponse() {
    }

    public MspResponse(Parcel parcel) {
        this.f6361a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readBundle();
    }

    public int a() {
        return this.f6361a;
    }

    public String b() {
        return this.b;
    }

    public Bundle c() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MspResponse{code='" + this.f6361a + "', message='" + this.b + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f6361a);
        parcel.writeString(this.b);
        parcel.writeBundle(this.c);
    }

    public void a(int i) {
        this.f6361a = i;
    }

    public void a(Bundle bundle) {
        this.c = bundle;
    }

    public void a(String str) {
        this.b = str;
    }
}
