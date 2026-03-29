package com.bytedance.sdk.openadsdk.mediation.init.u.u.u;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import defpackage.wc7;
import java.util.Map;
import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static final SparseArray<Object> u(final IMediationConfig iMediationConfig) {
        wc7 wc7VarB = wc7.b();
        if (iMediationConfig == null) {
            return null;
        }
        wc7VarB.h(264101, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.u.u.u.u.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return iMediationConfig.getPublisherDid();
            }
        });
        wc7VarB.h(264102, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.u.u.u.u.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isOpenAdnTest());
            }
        });
        wc7VarB.h(264103, iMediationConfig.getMediationConfigUserInfoForSegment() != null ? fx.u(iMediationConfig.getMediationConfigUserInfoForSegment()) : null);
        wc7VarB.h(264104, new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.u.u.u.u.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return iMediationConfig.getLocalExtra();
            }
        });
        wc7VarB.h(264105, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.u.u.u.u.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.getHttps());
            }
        });
        wc7VarB.h(264106, new Supplier<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.u.u.u.u.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public JSONObject get() {
                return iMediationConfig.getCustomLocalConfig();
            }
        });
        wc7VarB.h(264107, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.u.u.u.u.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return iMediationConfig.getOpensdkVer();
            }
        });
        wc7VarB.h(264108, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.u.u.u.u.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isWxInstalled());
            }
        });
        wc7VarB.h(264109, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.u.u.u.u.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isSupportH265());
            }
        });
        wc7VarB.h(264110, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.u.u.u.u.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isSupportSplashZoomout());
            }
        });
        wc7VarB.h(264111, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.u.u.u.u.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                return iMediationConfig.wxAppId();
            }
        });
        return wc7VarB.a().sparseArray();
    }
}
