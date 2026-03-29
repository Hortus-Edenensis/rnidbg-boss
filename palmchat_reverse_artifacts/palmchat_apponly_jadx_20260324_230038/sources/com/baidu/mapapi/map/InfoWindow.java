package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class InfoWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f3633a;
    BitmapDescriptor b;
    View c;
    LatLng d;
    boolean e;
    int f;
    int g;
    OnInfoWindowClickListener h;
    a i;
    int j;
    boolean k;
    int l;
    boolean m;
    boolean n;
    boolean o;

    /* JADX INFO: compiled from: SearchBox */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(InfoWindow infoWindow);

        void b(InfoWindow infoWindow);
    }

    public InfoWindow(View view, LatLng latLng, int i) {
        this.f3633a = "";
        this.e = false;
        this.k = false;
        this.l = SysOSUtil.getDensityDpi();
        this.m = false;
        this.n = false;
        this.o = false;
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
        }
        this.c = view;
        this.d = latLng;
        this.j = i;
        this.n = true;
    }

    public BitmapDescriptor getBitmapDescriptor() {
        return this.b;
    }

    public LatLng getPosition() {
        return this.d;
    }

    public String getTag() {
        return this.f3633a;
    }

    public View getView() {
        return this.c;
    }

    public int getYOffset() {
        return this.j;
    }

    public void setBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        a aVar;
        if (bitmapDescriptor == null || (aVar = this.i) == null) {
            return;
        }
        this.b = bitmapDescriptor;
        aVar.b(this);
    }

    public void setPosition(LatLng latLng) {
        a aVar;
        if (latLng == null || (aVar = this.i) == null) {
            return;
        }
        this.d = latLng;
        aVar.b(this);
    }

    public void setScreenPosition(int i, int i2) {
        this.e = true;
        this.f = i;
        this.g = i2;
    }

    public void setTag(String str) {
        this.f3633a = str;
    }

    public void setView(View view) {
        a aVar;
        if (view == null || (aVar = this.i) == null) {
            return;
        }
        this.c = view;
        aVar.b(this);
    }

    public void setYOffset(int i) {
        a aVar = this.i;
        if (aVar == null) {
            return;
        }
        this.j = i;
        aVar.b(this);
    }

    public InfoWindow(BitmapDescriptor bitmapDescriptor, LatLng latLng, int i, OnInfoWindowClickListener onInfoWindowClickListener) {
        this.f3633a = "";
        this.e = false;
        this.k = false;
        this.l = SysOSUtil.getDensityDpi();
        this.m = false;
        this.n = false;
        this.o = false;
        if (bitmapDescriptor != null && latLng != null) {
            this.b = bitmapDescriptor;
            this.d = latLng;
            this.h = onInfoWindowClickListener;
            this.j = i;
            this.o = true;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: bitmapDescriptor and position can not be null");
    }

    public InfoWindow(View view, LatLng latLng, int i, boolean z, int i2) {
        this.f3633a = "";
        this.e = false;
        this.k = false;
        this.l = SysOSUtil.getDensityDpi();
        this.m = false;
        this.n = false;
        this.o = false;
        if (view != null && latLng != null) {
            this.c = view;
            this.d = latLng;
            this.j = i;
            this.k = z;
            this.l = i2;
            this.n = true;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
    }
}
