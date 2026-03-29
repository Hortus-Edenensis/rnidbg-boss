package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class PoiParaOption {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f3842a;
    String b;
    LatLng c;
    int d;

    public PoiParaOption center(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public LatLng getCenter() {
        return this.c;
    }

    public String getKey() {
        return this.b;
    }

    public int getRadius() {
        return this.d;
    }

    public String getUid() {
        return this.f3842a;
    }

    public PoiParaOption key(String str) {
        this.b = str;
        return this;
    }

    public PoiParaOption radius(int i) {
        this.d = i;
        return this;
    }

    public PoiParaOption uid(String str) {
        this.f3842a = str;
        return this;
    }
}
