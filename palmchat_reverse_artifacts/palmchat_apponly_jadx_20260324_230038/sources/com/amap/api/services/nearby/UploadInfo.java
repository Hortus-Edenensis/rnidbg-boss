package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class UploadInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3170a = 1;
    private String b;
    private LatLonPoint c;

    public int getCoordType() {
        return this.f3170a;
    }

    public LatLonPoint getPoint() {
        return this.c;
    }

    public String getUserID() {
        return this.b;
    }

    public void setCoordType(int i) {
        if (i == 0 || i == 1) {
            this.f3170a = i;
        } else {
            this.f3170a = 1;
        }
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public void setUserID(String str) {
        this.b = str;
    }
}
