package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.platform.comapi.bmsdk.BmLocated;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class TileOverlayOptions implements Parcelable {
    public static final k CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3116a;
    private TileProvider b;
    private boolean c;
    private float d;
    private int e;
    private int f;
    private String g;
    private boolean h;
    private boolean i;

    public TileOverlayOptions() {
        this.c = true;
        this.e = BmLocated.HALF_LEFT_TOP;
        this.f = 20480;
        this.g = null;
        this.h = true;
        this.i = true;
        this.f3116a = 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final TileOverlayOptions diskCacheDir(String str) {
        this.g = str;
        return this;
    }

    public final TileOverlayOptions diskCacheEnabled(boolean z) {
        this.i = z;
        return this;
    }

    public final TileOverlayOptions diskCacheSize(int i) {
        this.f = i * 1024;
        return this;
    }

    public final String getDiskCacheDir() {
        return this.g;
    }

    public final boolean getDiskCacheEnabled() {
        return this.i;
    }

    public final int getDiskCacheSize() {
        return this.f;
    }

    public final int getMemCacheSize() {
        return this.e;
    }

    public final boolean getMemoryCacheEnabled() {
        return this.h;
    }

    public final TileProvider getTileProvider() {
        return this.b;
    }

    public final float getZIndex() {
        return this.d;
    }

    public final boolean isVisible() {
        return this.c;
    }

    public final TileOverlayOptions memCacheSize(int i) {
        this.e = i;
        return this;
    }

    public final TileOverlayOptions memoryCacheEnabled(boolean z) {
        this.h = z;
        return this;
    }

    public final TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.b = tileProvider;
        return this;
    }

    public final TileOverlayOptions visible(boolean z) {
        this.c = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3116a);
        parcel.writeValue(this.b);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
    }

    public final TileOverlayOptions zIndex(float f) {
        this.d = f;
        return this;
    }

    public TileOverlayOptions(int i, boolean z, float f) {
        this.e = BmLocated.HALF_LEFT_TOP;
        this.f = 20480;
        this.g = null;
        this.h = true;
        this.i = true;
        this.f3116a = i;
        this.c = z;
        this.d = f;
    }
}
