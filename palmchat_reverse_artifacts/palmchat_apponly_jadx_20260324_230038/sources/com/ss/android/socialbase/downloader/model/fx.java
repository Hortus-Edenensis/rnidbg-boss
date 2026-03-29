package com.ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx implements Parcelable, Comparable {
    public static final Parcelable.Creator<fx> CREATOR = new Parcelable.Creator<fx>() { // from class: com.ss.android.socialbase.downloader.model.fx.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public fx createFromParcel(Parcel parcel) {
            return new fx(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public fx[] newArray(int i) {
            return new fx[i];
        }
    };
    private final String nr;
    private final String u;

    public fx(String str, String str2) {
        this.u = str;
        this.nr = str2;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof fx)) {
            return 1;
        }
        fx fxVar = (fx) obj;
        if (TextUtils.equals(this.u, fxVar.u())) {
            return 0;
        }
        String str = this.u;
        if (str == null) {
            return -1;
        }
        int iCompareTo = str.compareTo(fxVar.u());
        if (iCompareTo > 0) {
            return 1;
        }
        return iCompareTo < 0 ? -1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            fx fxVar = (fx) obj;
            if (TextUtils.equals(this.u, fxVar.u) && TextUtils.equals(this.nr, fxVar.nr)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.u;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.nr;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String nr() {
        return this.nr;
    }

    public String toString() {
        return "HttpHeader{name='" + this.u + "', value='" + this.nr + "'}";
    }

    public String u() {
        return this.u;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.u);
        parcel.writeString(this.nr);
    }

    public fx(Parcel parcel) {
        this.u = parcel.readString();
        this.nr = parcel.readString();
    }
}
