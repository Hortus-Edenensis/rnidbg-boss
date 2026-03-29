package com.bytedance.sdk.openadsdk.my.u.fx;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.AdConfig;
import defpackage.wc7;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static SparseArray<Object> u(final AdConfig adConfig) {
        if (adConfig == null) {
            return new SparseArray<>();
        }
        wc7 wc7VarB = wc7.b();
        wc7VarB.i(261001, adConfig.getAppId());
        wc7VarB.i(261002, adConfig.getAppName());
        wc7VarB.j(261003, adConfig.isPaid());
        wc7VarB.i(261004, adConfig.getKeywords());
        wc7VarB.i(261005, adConfig.getData());
        wc7VarB.f(261006, adConfig.getTitleBarTheme());
        wc7VarB.j(261007, adConfig.isAllowShowNotify());
        wc7VarB.j(261008, adConfig.isDebug());
        wc7VarB.h(261009, adConfig.getDirectDownloadNetworkType());
        wc7VarB.j(261011, adConfig.isSupportMultiProcess());
        wc7VarB.h(261012, b.u(adConfig.getCustomController()));
        wc7VarB.h(261013, new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.u.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getPluginUpdateConfig());
            }
        });
        wc7VarB.h(261014, new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.u.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getAgeGroup());
            }
        });
        wc7VarB.h(261015, new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.u.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getThemeStatus());
            }
        });
        wc7VarB.h(261016, adConfig.getMediationConfig() != null ? com.bytedance.sdk.openadsdk.mediation.init.u.u.u.u.u(adConfig.getMediationConfig()) : null);
        wc7VarB.j(261017, adConfig.isUseMediation());
        wc7VarB.h(261018, new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.u.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return adConfig.getInitExtra();
            }
        });
        return wc7VarB.a().sparseArray();
    }
}
