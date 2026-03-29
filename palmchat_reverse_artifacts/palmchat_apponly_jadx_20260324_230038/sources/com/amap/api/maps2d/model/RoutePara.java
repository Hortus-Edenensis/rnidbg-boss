package com.amap.api.maps2d.model;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class RoutePara {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3111a = 0;
    private int b = 0;
    private LatLng c;
    private LatLng d;
    private String e;
    private String f;

    public int getDrivingRouteStyle() {
        return this.f3111a;
    }

    public String getEndName() {
        return this.f;
    }

    public LatLng getEndPoint() {
        return this.d;
    }

    public String getStartName() {
        return this.e;
    }

    public LatLng getStartPoint() {
        return this.c;
    }

    public int getTransitRouteStyle() {
        return this.b;
    }

    public void setDrivingRouteStyle(int i) {
        if (i < 0 || i >= 9) {
            return;
        }
        this.f3111a = i;
    }

    public void setEndName(String str) {
        this.f = str;
    }

    public void setEndPoint(LatLng latLng) {
        this.d = latLng;
    }

    public void setStartName(String str) {
        this.e = str;
    }

    public void setStartPoint(LatLng latLng) {
        this.c = latLng;
    }

    public void setTransitRouteStyle(int i) {
        if (i < 0 || i >= 6) {
            return;
        }
        this.b = i;
    }
}
