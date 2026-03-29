package com.ss.android.ttvecamera;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Size;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TEFrameSizei implements Parcelable {
    public static final Parcelable.Creator<TEFrameSizei> CREATOR = new Parcelable.Creator<TEFrameSizei>() { // from class: com.ss.android.ttvecamera.TEFrameSizei.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TEFrameSizei createFromParcel(Parcel parcel) {
            return new TEFrameSizei(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TEFrameSizei[] newArray(int i) {
            return new TEFrameSizei[i];
        }
    };
    public int height;
    public int width;

    public TEFrameSizei() {
        this.width = 720;
        this.height = 1280;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TEFrameSizei)) {
            return false;
        }
        TEFrameSizei tEFrameSizei = (TEFrameSizei) obj;
        return this.width == tEFrameSizei.width && this.height == tEFrameSizei.height;
    }

    public int hashCode() {
        return (this.width * 65537) + 1 + this.height;
    }

    public boolean isValid() {
        return this.width > 0 && this.height > 0;
    }

    @RequiresApi(api = 21)
    public Size toSize() {
        return new Size(this.width, this.height);
    }

    public String toString() {
        return this.width + "x" + this.height;
    }

    public void update(TEFrameSizei tEFrameSizei) {
        this.width = tEFrameSizei.width;
        this.height = tEFrameSizei.height;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    public void update(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public TEFrameSizei(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public TEFrameSizei(Parcel parcel) {
        this.width = 720;
        this.height = 1280;
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }
}
