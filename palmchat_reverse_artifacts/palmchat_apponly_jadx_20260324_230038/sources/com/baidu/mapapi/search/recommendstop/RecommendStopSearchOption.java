package com.baidu.mapapi.search.recommendstop;

import com.baidu.mapapi.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class RecommendStopSearchOption {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3795a = false;
    public LatLng mLocation;

    public LatLng getLocation() {
        return this.mLocation;
    }

    public boolean isNeedStationInfo() {
        return this.f3795a;
    }

    public RecommendStopSearchOption location(LatLng latLng) {
        this.mLocation = latLng;
        return this;
    }

    public RecommendStopSearchOption setNeedStationInfo(boolean z) {
        this.f3795a = z;
        return this;
    }
}
