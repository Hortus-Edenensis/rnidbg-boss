package com.zenmen.palmchat.Vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ParcelPair implements Parcelable {
    public static final Parcelable.Creator<ParcelPair> CREATOR = new Parcelable.Creator<ParcelPair>() { // from class: com.zenmen.palmchat.Vo.ParcelPair.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelPair createFromParcel(Parcel parcel) {
            return new ParcelPair(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelPair[] newArray(int i) {
            return new ParcelPair[i];
        }
    };
    public byte[] first;
    public byte[] second;

    public ParcelPair() {
    }

    public Pair<byte[], byte[]> convert() {
        if (this.first == null || this.second == null) {
            return null;
        }
        return new Pair<>(this.first, this.second);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.first);
        parcel.writeByteArray(this.second);
    }

    public ParcelPair(Parcel parcel) {
        this.first = parcel.createByteArray();
        this.second = parcel.createByteArray();
    }
}
