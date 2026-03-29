package com.amap.api.maps2d.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0002sl.ct;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class BitmapDescriptor implements Parcelable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a f3092a = new a();
    int b;
    int c;
    Bitmap d;

    public BitmapDescriptor(Bitmap bitmap) {
        this.b = 0;
        this.c = 0;
        if (bitmap != null) {
            this.b = bitmap.getWidth();
            this.c = bitmap.getHeight();
            this.d = bitmap;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final Bitmap getBitmap() {
        return this.d;
    }

    public final int getHeight() {
        return this.c;
    }

    public final int getWidth() {
        return this.b;
    }

    public final void recycle() {
        Bitmap bitmap = this.d;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.d.recycle();
        this.d = null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.d, i);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final BitmapDescriptor m13clone() {
        try {
            return new BitmapDescriptor(Bitmap.createBitmap(this.d), this.b, this.c);
        } catch (Throwable th) {
            ct.a(th, "BitmapDescriptor", "clone");
            return null;
        }
    }

    private BitmapDescriptor(Bitmap bitmap, int i, int i2) {
        this.b = i;
        this.c = i2;
        this.d = bitmap;
    }
}
