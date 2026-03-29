package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class MultiPointItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f3660a;
    private String b;

    public MultiPointItem(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: MultiPointItem point can not be null");
        }
        this.f3660a = latLng;
    }

    public LatLng getPoint() {
        return this.f3660a;
    }

    public String getTitle() {
        return this.b;
    }

    public void setTitle(String str) {
        this.b = str;
    }
}
