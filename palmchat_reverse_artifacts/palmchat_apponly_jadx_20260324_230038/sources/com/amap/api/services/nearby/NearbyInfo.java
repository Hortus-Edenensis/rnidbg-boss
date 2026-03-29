package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class NearbyInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3164a;
    private LatLonPoint b;
    private long c;
    private int d;
    private int e;

    public int getDistance() {
        return this.d;
    }

    public int getDrivingDistance() {
        return this.e;
    }

    public LatLonPoint getPoint() {
        return this.b;
    }

    public long getTimeStamp() {
        return this.c;
    }

    public String getUserID() {
        return this.f3164a;
    }

    public void setDistance(int i) {
        this.d = i;
    }

    public void setDrivingDistance(int i) {
        this.e = i;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public void setTimeStamp(long j) {
        this.c = j;
    }

    public void setUserID(String str) {
        this.f3164a = str;
    }
}
