package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class InteractionSensorData extends a implements Parcelable {
    public static final Parcelable.Creator<InteractionSensorData> CREATOR = new Parcelable.Creator<InteractionSensorData>() { // from class: com.opos.mobad.model.data.InteractionSensorData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InteractionSensorData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                return new InteractionSensorData(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readByte() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InteractionSensorData[] newArray(int i) {
            return new InteractionSensorData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9086a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;

    public InteractionSensorData(int i, int i2, int i3, int i4, boolean z, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        this.f9086a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = z;
        this.f = i5;
        this.g = i6;
        this.h = i7;
        this.i = i8;
        this.j = i9;
        this.k = i10;
        this.l = i11;
        this.m = i12;
        this.n = i13;
    }

    public int a() {
        return this.f9086a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.h;
    }

    public int i() {
        return this.i;
    }

    public int j() {
        return this.j;
    }

    public int k() {
        return this.k;
    }

    public int l() {
        return this.l;
    }

    public int m() {
        return this.m;
    }

    public int n() {
        return this.n;
    }

    public String toString() {
        return "InteractionSensorData{shakeSensorTime=" + this.f9086a + ", shakeSensorDiff=" + this.b + ", tiltAngle=" + this.c + ", tiltTime=" + this.d + ", isBidirectionalTilt=" + this.e + ", forwardAngle=" + this.f + ", forwardTime=" + this.g + ", upSlideDistance=" + this.h + ", fullScreenSlideDistance=" + this.i + ", shakeAndUpSlideSensorTime=" + this.j + ", shakeAndUpSlideSensorDiff=" + this.k + ", shakeAndUpSlideDistance=" + this.l + ", slideLayerDistance=" + this.m + ", rotationAngle=" + this.n + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f9086a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
    }
}
