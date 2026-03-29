package com.ss.android.ttvecamera;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TEFrameRateRange implements Parcelable {
    public static final Parcelable.Creator<TEFrameRateRange> CREATOR = new Parcelable.Creator<TEFrameRateRange>() { // from class: com.ss.android.ttvecamera.TEFrameRateRange.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TEFrameRateRange createFromParcel(Parcel parcel) {
            return new TEFrameRateRange(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TEFrameRateRange[] newArray(int i) {
            return new TEFrameRateRange[i];
        }
    };
    public int fpsUnitFactor;
    public int max;
    public int min;

    public TEFrameRateRange(int i, int i2) {
        this.fpsUnitFactor = 1;
        this.min = i;
        this.max = i2;
        this.fpsUnitFactor = i2 > 1000 ? 1000 : 1;
    }

    public static int getFpsUnitFactor(List<int[]> list) {
        return (list.size() > 0 && list.get(0)[1] > 1000) ? 1000 : 1;
    }

    public static TEFrameRateRange mul(TEFrameRateRange tEFrameRateRange, int i) {
        return new TEFrameRateRange(tEFrameRateRange.min * i, tEFrameRateRange.max * i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TEFrameRateRange)) {
            return false;
        }
        TEFrameRateRange tEFrameRateRange = (TEFrameRateRange) obj;
        return this.min == tEFrameRateRange.min && this.max == tEFrameRateRange.max;
    }

    public int[] getRealFpsRange() {
        int i = this.min;
        int i2 = this.fpsUnitFactor;
        return new int[]{i / i2, this.max / i2};
    }

    public int hashCode() {
        return (this.min * 65537) + 1 + this.max;
    }

    public boolean isValid() {
        int i = this.min;
        return i >= 0 && this.max >= i && this.fpsUnitFactor > 0;
    }

    public int[] mulFactor(int i) {
        int i2 = this.min;
        int i3 = this.fpsUnitFactor;
        return new int[]{(i2 / i3) * i, (this.max / i3) * i};
    }

    public int setFpsUnitFactor(List<int[]> list) {
        return (list.size() > 0 && list.get(0)[1] > 1000) ? 1000 : 1;
    }

    @NonNull
    public String toString() {
        return "[" + (this.min / this.fpsUnitFactor) + ", " + (this.max / this.fpsUnitFactor) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.min);
        parcel.writeInt(this.max);
        parcel.writeInt(this.fpsUnitFactor);
    }

    @RequiresApi(api = 21)
    public int setFpsUnitFactor(Range<Integer>[] rangeArr) {
        return (rangeArr.length > 0 && ((Integer) rangeArr[0].getUpper()).intValue() < 1000) ? 1000 : 1;
    }

    public TEFrameRateRange(Parcel parcel) {
        this.fpsUnitFactor = 1;
        this.min = parcel.readInt();
        this.max = parcel.readInt();
        this.fpsUnitFactor = parcel.readInt();
    }
}
