package com.zenmen.palmchat.Vo;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SyncKeys implements Parcelable {
    public static final Parcelable.Creator<SyncKeys> CREATOR = new Parcelable.Creator<SyncKeys>() { // from class: com.zenmen.palmchat.Vo.SyncKeys.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SyncKeys createFromParcel(Parcel parcel) {
            SyncKeys syncKeys = new SyncKeys();
            String[] strArr = new String[parcel.readInt()];
            parcel.readStringArray(strArr);
            syncKeys.keys = strArr;
            return syncKeys;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SyncKeys[] newArray(int i) {
            return new SyncKeys[i];
        }
    };
    public String[] keys;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.keys.length);
        parcel.writeStringArray(this.keys);
    }
}
