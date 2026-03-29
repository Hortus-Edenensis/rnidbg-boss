package com.amap.api.maps2d.model;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class PoiPara {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f3106a;
    private String b;

    public LatLng getCenter() {
        return this.f3106a;
    }

    public String getKeywords() {
        return this.b;
    }

    public void setCenter(LatLng latLng) {
        this.f3106a = latLng;
    }

    public void setKeywords(String str) {
        this.b = str;
    }
}
