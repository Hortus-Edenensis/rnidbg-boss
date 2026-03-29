package com.wifi.csj.ad;

import com.bytedance.sdk.openadsdk.LocationProvider;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/wifi/csj/ad/CsjDefaultLocationMode;", "Lcom/bytedance/sdk/openadsdk/LocationProvider;", "mLongitude", "", "mLatitude", "(DD)V", "getMLatitude", "()D", "setMLatitude", "(D)V", "getMLongitude", "setMLongitude", "getLatitude", "getLongitude", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class CsjDefaultLocationMode implements LocationProvider {
    private double mLatitude;
    private double mLongitude;

    public CsjDefaultLocationMode(double d, double d2) {
        this.mLongitude = d;
        this.mLatitude = d2;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    /* JADX INFO: renamed from: getLatitude, reason: from getter */
    public double getMLatitude() {
        return this.mLatitude;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    /* JADX INFO: renamed from: getLongitude, reason: from getter */
    public double getMLongitude() {
        return this.mLongitude;
    }

    public final double getMLatitude() {
        return this.mLatitude;
    }

    public final double getMLongitude() {
        return this.mLongitude;
    }

    public final void setMLatitude(double d) {
        this.mLatitude = d;
    }

    public final void setMLongitude(double d) {
        this.mLongitude = d;
    }
}
