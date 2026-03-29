package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.u.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class MediationNativeAppInfoImpl extends u {
    private SparseArray<Object> nr = new SparseArray<>();
    private MediationNativeAdAppInfo u;

    public MediationNativeAppInfoImpl(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.u = mediationNativeAdAppInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.u.u
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) values();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.u.u
    public SparseArray<Object> get() {
        SparseArray<Object> sparseArrayValues = values();
        if (sparseArrayValues != null) {
            return sparseArrayValues;
        }
        return null;
    }

    public SparseArray<Object> values() {
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.u;
        if (mediationNativeAdAppInfo != null) {
            this.nr.put(8505, mediationNativeAdAppInfo.getAppName());
            this.nr.put(8506, this.u.getAuthorName());
            this.nr.put(8507, Long.valueOf(this.u.getPackageSizeBytes()));
            this.nr.put(8508, this.u.getPermissionsUrl());
            this.nr.put(8509, this.u.getPermissionsMap());
            this.nr.put(8510, this.u.getPrivacyAgreement());
            this.nr.put(8511, this.u.getVersionName());
            this.nr.put(8512, this.u.getAppInfoExtra());
        }
        return this.nr;
    }
}
