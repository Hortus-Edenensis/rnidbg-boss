package com.amap.api.maps2d.model;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.platform.comapi.map.MapBundleKey;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class TextOptions implements Parcelable {
    public static final TextOptionsCreator CREATOR = new TextOptionsCreator();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3113a;
    private float d;
    private LatLng e;
    private Object h;
    private Typeface b = Typeface.DEFAULT;
    private boolean c = true;
    private float f = 0.0f;
    private int g = 0;
    private int i = -16777216;
    private int j = 20;
    private int k = 3;
    private int l = 6;

    public TextOptions align(int i, int i2) {
        this.k = i;
        this.l = i2;
        return this;
    }

    public TextOptions backgroundColor(int i) {
        this.g = i;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TextOptions fontColor(int i) {
        this.i = i;
        return this;
    }

    public TextOptions fontSize(int i) {
        this.j = i;
        return this;
    }

    public int getAlignX() {
        return this.k;
    }

    public int getAlignY() {
        return this.l;
    }

    public int getBackgroundColor() {
        return this.g;
    }

    public int getFontColor() {
        return this.i;
    }

    public int getFontSize() {
        return this.j;
    }

    public Object getObject() {
        return this.h;
    }

    public LatLng getPosition() {
        return this.e;
    }

    public float getRotate() {
        return this.f;
    }

    public String getText() {
        return this.f3113a;
    }

    public Typeface getTypeface() {
        return this.b;
    }

    public float getZIndex() {
        return this.d;
    }

    public boolean isVisible() {
        return this.c;
    }

    public TextOptions position(LatLng latLng) {
        this.e = latLng;
        return this;
    }

    public TextOptions rotate(float f) {
        this.f = f;
        return this;
    }

    public TextOptions setObject(Object obj) {
        this.h = obj;
        return this;
    }

    public TextOptions text(String str) {
        this.f3113a = str;
        return this;
    }

    public TextOptions typeface(Typeface typeface) {
        this.b = typeface;
        return this;
    }

    public TextOptions visible(boolean z) {
        this.c = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.e;
        if (latLng != null) {
            bundle.putDouble(com.umeng.analytics.pro.f.C, latLng.latitude);
            bundle.putDouble(com.umeng.analytics.pro.f.D, this.e.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeString(this.f3113a);
        parcel.writeInt(this.b.getStyle());
        parcel.writeFloat(this.f);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.g);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeFloat(this.d);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        if (this.h instanceof Parcelable) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MapBundleKey.MapObjKey.OBJ_SL_OBJ, (Parcelable) this.h);
            parcel.writeBundle(bundle2);
        }
    }

    public TextOptions zIndex(float f) {
        this.d = f;
        return this;
    }
}
