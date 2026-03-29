package com.amap.api.maps2d.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tblplayer.processor.util.EffectConstants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class MyLocationStyle implements Parcelable {
    public static final MyLocationStyleCreator CREATOR = new MyLocationStyleCreator();
    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_INFO = "errorInfo";
    public static final String LOCATION_TYPE = "locationType";
    public static final int LOCATION_TYPE_FOLLOW = 2;
    public static final int LOCATION_TYPE_FOLLOW_NO_CENTER = 6;
    public static final int LOCATION_TYPE_LOCATE = 1;
    public static final int LOCATION_TYPE_SHOW = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BitmapDescriptor f3103a;
    private float b = 0.5f;
    private float c = 0.5f;
    private int d = Color.argb(100, 0, 0, EffectConstants.ROTATION_DEGREES_180);
    private int e = Color.argb(255, 0, 0, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM);
    private float f = 1.0f;
    private int g = 1;
    private long h = 2000;
    private boolean i = true;

    public MyLocationStyle anchor(float f, float f2) {
        this.b = f;
        this.c = f2;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.b;
    }

    public float getAnchorV() {
        return this.c;
    }

    public long getInterval() {
        return this.h;
    }

    public BitmapDescriptor getMyLocationIcon() {
        return this.f3103a;
    }

    public int getMyLocationType() {
        return this.g;
    }

    public int getRadiusFillColor() {
        return this.d;
    }

    public int getStrokeColor() {
        return this.e;
    }

    public float getStrokeWidth() {
        return this.f;
    }

    public MyLocationStyle interval(long j) {
        this.h = j;
        return this;
    }

    public boolean isMyLocationShowing() {
        return this.i;
    }

    public MyLocationStyle myLocationIcon(BitmapDescriptor bitmapDescriptor) {
        this.f3103a = bitmapDescriptor;
        return this;
    }

    public MyLocationStyle myLocationType(int i) {
        this.g = i;
        return this;
    }

    public MyLocationStyle radiusFillColor(int i) {
        this.d = i;
        return this;
    }

    public MyLocationStyle showMyLocation(boolean z) {
        this.i = z;
        return this;
    }

    public MyLocationStyle strokeColor(int i) {
        this.e = i;
        return this;
    }

    public MyLocationStyle strokeWidth(float f) {
        this.f = f;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3103a, i);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeFloat(this.f);
        parcel.writeInt(this.g);
        parcel.writeLong(this.h);
        parcel.writeBooleanArray(new boolean[]{this.i});
    }
}
