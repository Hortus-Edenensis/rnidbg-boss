package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class WayPointInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3747a;
    private LatLng b;

    public LatLng getLatLng() {
        return this.b;
    }

    public String getWayPointName() {
        return this.f3747a;
    }

    public WayPointInfo setLatLng(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalStateException("BDMapSDKException: The latitude and longitude of the waypoint cannot be null");
        }
        this.b = latLng;
        return this;
    }

    public WayPointInfo setWayPointName(String str) {
        this.f3747a = str;
        return this;
    }
}
