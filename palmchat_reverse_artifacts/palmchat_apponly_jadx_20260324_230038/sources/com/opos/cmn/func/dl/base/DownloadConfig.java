package com.opos.cmn.func.dl.base;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DownloadConfig implements Parcelable {
    public static final Parcelable.Creator<DownloadConfig> CREATOR = new Parcelable.Creator<DownloadConfig>() { // from class: com.opos.cmn.func.dl.base.DownloadConfig.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DownloadConfig createFromParcel(Parcel parcel) {
            return new DownloadConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DownloadConfig[] newArray(int i) {
            return new DownloadConfig[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7954a;
    private int b;
    private boolean c;
    private float d;
    private int e;
    private int f;

    public DownloadConfig() {
        this.f7954a = 1;
        this.b = 1;
        this.c = false;
        this.d = 0.02f;
        this.e = 100;
        this.f = 8192;
    }

    public int a() {
        return this.f7954a;
    }

    public int b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public float d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public String toString() {
        return "DownloadConfig{, writeThreadCount=" + this.f7954a + ", maxDownloadNum=" + this.b + ", listenOnUi=" + this.c + ", notifyRatio=" + this.d + ", notifyInterval=" + this.e + ", notifyIntervalSize=" + this.f + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7954a);
        parcel.writeInt(this.b);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
    }

    private DownloadConfig(Parcel parcel) {
        this.f7954a = 1;
        this.b = 1;
        this.c = false;
        this.d = 0.02f;
        this.e = 100;
        this.f = 8192;
        this.f7954a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readByte() != 0;
        this.d = parcel.readFloat();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
    }

    public DownloadConfig a(float f, int i, int i2) {
        this.d = f;
        this.e = i;
        this.f = i2;
        return this;
    }

    public DownloadConfig b(int i) {
        this.f7954a = Math.min(Math.max(1, i), 3);
        return this;
    }

    public DownloadConfig a(int i) {
        this.b = Math.min(Math.max(1, i), 5);
        return this;
    }

    public DownloadConfig a(boolean z) {
        this.c = z;
        return this;
    }
}
