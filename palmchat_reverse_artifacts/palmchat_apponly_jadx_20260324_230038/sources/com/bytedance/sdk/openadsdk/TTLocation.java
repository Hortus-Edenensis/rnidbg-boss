package com.bytedance.sdk.openadsdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTLocation implements LocationProvider {
    private double nr;
    private double u;

    public TTLocation(double d, double d2) {
        this.u = d;
        this.nr = d2;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.nr;
    }

    public void setLatitude(double d) {
        this.u = d;
    }

    public void setLongitude(double d) {
        this.nr = d;
    }
}
