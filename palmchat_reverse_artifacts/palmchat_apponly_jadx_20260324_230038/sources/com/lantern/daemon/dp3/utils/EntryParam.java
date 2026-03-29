package com.lantern.daemon.dp3.utils;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class EntryParam implements Parcelable {
    public static Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.lantern.daemon.dp3.utils.EntryParam.1
        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return new EntryParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i) {
            return new EntryParam[i];
        }
    };
    public Intent broadcastIntent;
    public String[] files;
    public Intent instrumentationIntent;
    public String processName;
    public Intent serviceIntent;

    public EntryParam() {
    }

    public static EntryParam fromBase64(String str) {
        Parcel parcelObtain = Parcel.obtain();
        byte[] bArrDecode = Base64.decode(str, 2);
        parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
        parcelObtain.setDataPosition(0);
        EntryParam entryParam = (EntryParam) CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return entryParam;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        Parcel parcelObtain = Parcel.obtain();
        writeToParcel(parcelObtain, 0);
        String strEncodeToString = Base64.encodeToString(parcelObtain.marshall(), 2);
        parcelObtain.recycle();
        return strEncodeToString;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(this.files);
        parcel.writeString(this.processName);
        if (this.serviceIntent == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            this.serviceIntent.writeToParcel(parcel, 0);
        }
        if (this.broadcastIntent == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            this.broadcastIntent.writeToParcel(parcel, 0);
        }
        if (this.instrumentationIntent == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            this.instrumentationIntent.writeToParcel(parcel, 0);
        }
    }

    public EntryParam(Parcel parcel) {
        this.files = parcel.createStringArray();
        this.processName = parcel.readString();
        if (parcel.readInt() != 0) {
            this.serviceIntent = (Intent) Intent.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() != 0) {
            this.broadcastIntent = (Intent) Intent.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() != 0) {
            this.instrumentationIntent = (Intent) Intent.CREATOR.createFromParcel(parcel);
        }
    }
}
