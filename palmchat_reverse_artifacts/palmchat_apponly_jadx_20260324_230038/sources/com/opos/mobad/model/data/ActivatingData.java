package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ActivatingData extends a implements Parcelable {
    public static final Parcelable.Creator<ActivatingData> CREATOR = new Parcelable.Creator<ActivatingData>() { // from class: com.opos.mobad.model.data.ActivatingData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivatingData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                return new ActivatingData(parcel.readString(), parcel.readString(), parcel.readArrayList(ApkSignerData.class.getClassLoader()), parcel.readInt());
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivatingData[] newArray(int i) {
            return new ActivatingData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9073a;
    public final String b;
    public final List<ApkSignerData> c;
    public final int d;

    public ActivatingData(String str, String str2, List<ApkSignerData> list, int i) {
        this.f9073a = str;
        this.b = str2;
        this.c = list;
        this.d = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivatingData{pkgName=" + this.f9073a + ", target='" + this.b + "', apkSignerDataList=" + this.c + ", minVerCode=" + this.d + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9073a);
        parcel.writeString(this.b);
        parcel.writeList(this.c);
        parcel.writeInt(this.d);
    }
}
