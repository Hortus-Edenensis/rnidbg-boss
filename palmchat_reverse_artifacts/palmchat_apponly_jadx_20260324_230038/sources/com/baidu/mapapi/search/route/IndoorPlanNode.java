package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class IndoorPlanNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f3801a;
    private String b;

    public IndoorPlanNode(LatLng latLng, String str) {
        this.f3801a = latLng;
        this.b = str;
    }

    public String getFloor() {
        return this.b;
    }

    public LatLng getLocation() {
        return this.f3801a;
    }
}
