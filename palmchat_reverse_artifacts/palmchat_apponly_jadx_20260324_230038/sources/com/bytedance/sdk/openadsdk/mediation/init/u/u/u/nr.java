package com.bytedance.sdk.openadsdk.mediation.init.u.u.u;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import defpackage.wc7;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public static final SparseArray<Object> u(final IMediationPrivacyConfig iMediationPrivacyConfig) {
        wc7 wc7VarB = wc7.b();
        if (iMediationPrivacyConfig == null) {
            return null;
        }
        wc7VarB.h(262114, new Supplier<List<String>>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.u.u.u.nr.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public List<String> get() {
                return iMediationPrivacyConfig.getCustomAppList();
            }
        });
        wc7VarB.h(262115, new Supplier<List<String>>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.u.u.u.nr.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public List<String> get() {
                return iMediationPrivacyConfig.getCustomDevImeis();
            }
        });
        wc7VarB.h(262116, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.u.u.u.nr.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isCanUseOaid());
            }
        });
        wc7VarB.h(262117, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.u.u.u.nr.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isLimitPersonalAds());
            }
        });
        wc7VarB.h(262118, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.u.u.u.nr.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isProgrammaticRecommend());
            }
        });
        return wc7VarB.a().sparseArray();
    }
}
