package com.ss.android.ttvecamera;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TEFocusParameters implements Parcelable {
    public static final Parcelable.Creator<TEFocusParameters> CREATOR = new Parcelable.Creator<TEFocusParameters>() { // from class: com.ss.android.ttvecamera.TEFocusParameters.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TEFocusParameters createFromParcel(Parcel parcel) {
            return new TEFocusParameters(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TEFocusParameters[] newArray(int i) {
            return new TEFocusParameters[i];
        }
    };
    public Rect mActiveSize;
    public Rect mCropSize;
    public int mMaxRegionsAE;
    public int mMaxRegionsAF;

    public TEFocusParameters(Parcel parcel) {
        this.mActiveSize = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        this.mMaxRegionsAF = parcel.readInt();
        this.mMaxRegionsAE = parcel.readInt();
        this.mCropSize = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "active size is:" + this.mActiveSize.toString() + " crop size is: " + this.mCropSize.toString() + "  max AF regions is: " + this.mMaxRegionsAF + "  max AE regions is: " + this.mMaxRegionsAE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mActiveSize, i);
        parcel.writeInt(this.mMaxRegionsAF);
        parcel.writeInt(this.mMaxRegionsAE);
        parcel.writeParcelable(this.mCropSize, i);
    }

    public TEFocusParameters() {
    }
}
