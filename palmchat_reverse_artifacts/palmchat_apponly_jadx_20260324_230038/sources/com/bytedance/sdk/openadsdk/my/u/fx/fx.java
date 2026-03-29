package com.bytedance.sdk.openadsdk.my.u.fx;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;
import defpackage.wc7;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements LocationProvider {
    private ValueSet u;

    public fx(ValueSet valueSet) {
        this.u = valueSet == null ? wc7.c : valueSet;
    }

    public static SparseArray<Object> u(LocationProvider locationProvider) {
        if (locationProvider == null) {
            return null;
        }
        wc7 wc7VarB = wc7.b();
        wc7VarB.d(262001, locationProvider.getLatitude());
        wc7VarB.d(262002, locationProvider.getLongitude());
        return wc7VarB.a().sparseArray();
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.u.doubleValue(262001);
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.u.doubleValue(262002);
    }
}
