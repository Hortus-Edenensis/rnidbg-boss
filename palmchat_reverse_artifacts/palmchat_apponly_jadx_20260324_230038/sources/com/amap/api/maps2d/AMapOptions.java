package com.amap.api.maps2d;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps2d.model.CameraPosition;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class AMapOptions implements Parcelable {
    public static final AMapOptionsCreator CREATOR = new AMapOptionsCreator();
    public static final int LOGO_POSITION_BOTTOM_CENTER = 1;
    public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
    public static final int LOGO_POSITION_BOTTOM_RIGHT = 2;
    public static final int ZOOM_POSITION_RIGHT_BUTTOM = 0;
    public static final int ZOOM_POSITION_RIGHT_CENTER = 1;
    private CameraPosition f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3080a = 1;
    private boolean b = true;
    private boolean c = true;
    private boolean d = true;
    private boolean e = false;
    private boolean g = false;
    private boolean h = false;
    private int i = 0;

    public AMapOptions camera(CameraPosition cameraPosition) {
        this.f = cameraPosition;
        return this;
    }

    public AMapOptions compassEnabled(boolean z) {
        this.g = z;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CameraPosition getCamera() {
        return this.f;
    }

    public Boolean getCompassEnabled() {
        return Boolean.valueOf(this.g);
    }

    public int getLogoPosition() {
        return this.i;
    }

    public int getMapType() {
        return this.f3080a;
    }

    public Boolean getScaleControlsEnabled() {
        return Boolean.valueOf(this.h);
    }

    public Boolean getScrollGesturesEnabled() {
        return Boolean.valueOf(this.b);
    }

    public Boolean getZOrderOnTop() {
        return Boolean.valueOf(this.e);
    }

    public Boolean getZoomControlsEnabled() {
        return Boolean.valueOf(this.d);
    }

    public Boolean getZoomGesturesEnabled() {
        return Boolean.valueOf(this.c);
    }

    public AMapOptions logoPosition(int i) {
        this.i = i;
        return this;
    }

    public AMapOptions mapType(int i) {
        this.f3080a = i;
        return this;
    }

    public AMapOptions scaleControlsEnabled(boolean z) {
        this.h = z;
        return this;
    }

    public AMapOptions scrollGesturesEnabled(boolean z) {
        this.b = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f, i);
        parcel.writeInt(this.f3080a);
        parcel.writeBooleanArray(new boolean[]{this.b, this.c, this.d, this.e, this.g, this.h});
    }

    public AMapOptions zOrderOnTop(boolean z) {
        this.e = z;
        return this;
    }

    public AMapOptions zoomControlsEnabled(boolean z) {
        this.d = z;
        return this;
    }

    public AMapOptions zoomGesturesEnabled(boolean z) {
        this.c = z;
        return this;
    }
}
