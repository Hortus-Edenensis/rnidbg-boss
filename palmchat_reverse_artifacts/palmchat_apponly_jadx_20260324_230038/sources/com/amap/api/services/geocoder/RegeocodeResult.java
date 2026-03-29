package com.amap.api.services.geocoder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class RegeocodeResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RegeocodeQuery f3158a;
    private RegeocodeAddress b;

    public RegeocodeResult(RegeocodeQuery regeocodeQuery, RegeocodeAddress regeocodeAddress) {
        this.f3158a = regeocodeQuery;
        this.b = regeocodeAddress;
    }

    public RegeocodeAddress getRegeocodeAddress() {
        return this.b;
    }

    public RegeocodeQuery getRegeocodeQuery() {
        return this.f3158a;
    }

    public void setRegeocodeAddress(RegeocodeAddress regeocodeAddress) {
        this.b = regeocodeAddress;
    }

    public void setRegeocodeQuery(RegeocodeQuery regeocodeQuery) {
        this.f3158a = regeocodeQuery;
    }
}
