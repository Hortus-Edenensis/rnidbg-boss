package com.ss.android.downloadlib.u.u;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr implements Parcelable {
    public static final Parcelable.Creator<nr> CREATOR = new Parcelable.Creator<nr>() { // from class: com.ss.android.downloadlib.u.u.nr.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public nr createFromParcel(Parcel parcel) {
            return new nr(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public nr[] newArray(int i) {
            return new nr[i];
        }
    };
    public int b;
    public String fx;
    public String iz;
    public int nr;
    public String pn;
    public int u;

    public nr() {
        this.fx = "";
        this.pn = "";
        this.iz = "";
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
            nr nrVar = (nr) obj;
            if (this.u == nrVar.u && this.nr == nrVar.nr) {
                String str = this.fx;
                if (str != null) {
                    return str.equals(nrVar.fx);
                }
                if (nrVar.fx == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.u * 31) + this.nr) * 31;
        String str = this.fx;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.u);
        parcel.writeInt(this.nr);
        parcel.writeString(this.fx);
        parcel.writeString(this.pn);
        parcel.writeString(this.iz);
        parcel.writeInt(this.b);
    }

    public nr(Parcel parcel) {
        this.fx = "";
        this.pn = "";
        this.iz = "";
        this.u = parcel.readInt();
        this.nr = parcel.readInt();
        this.fx = parcel.readString();
        this.pn = parcel.readString();
        this.iz = parcel.readString();
        this.b = parcel.readInt();
    }
}
