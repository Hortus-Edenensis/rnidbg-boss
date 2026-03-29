package com.bytedance.sdk.openadsdk.my.u.fx;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTCustomController;
import defpackage.wc7;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    public static final SparseArray<Object> u(final TTCustomController tTCustomController) {
        wc7 wc7VarB = wc7.b();
        wc7VarB.h(262101, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.b.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseLocation());
            }
        });
        wc7VarB.h(262102, new Supplier<SparseArray<Object>>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.b.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public SparseArray<Object> get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return fx.u(tTCustomController2 == null ? null : tTCustomController2.getTTLocation());
            }
        });
        wc7VarB.h(262103, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.b.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.alist());
            }
        });
        wc7VarB.h(262104, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.b.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUsePhoneState());
            }
        });
        wc7VarB.h(262105, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.b.11
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getDevImei();
            }
        });
        wc7VarB.h(262106, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.b.12
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseWifiState());
            }
        });
        wc7VarB.h(262107, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.b.13
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getMacAddress();
            }
        });
        wc7VarB.h(262108, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.b.14
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseWriteExternal());
            }
        });
        wc7VarB.h(262109, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.b.15
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getDevOaid();
            }
        });
        wc7VarB.h(262110, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.b.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseAndroidId());
            }
        });
        wc7VarB.h(262113, (tTCustomController == null || tTCustomController.getMediationPrivacyConfig() == null) ? null : com.bytedance.sdk.openadsdk.mediation.init.u.u.u.nr.u(tTCustomController.getMediationPrivacyConfig()));
        wc7VarB.h(262112, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.b.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getAndroidId();
            }
        });
        wc7VarB.h(262111, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.b.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUsePermissionRecordAudio());
            }
        });
        wc7VarB.h(262119, new Supplier<Map>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.b.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Map get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.userPrivacyConfig();
            }
        });
        wc7VarB.h(262120, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.b.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseMessage());
            }
        });
        wc7VarB.h(262121, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.my.u.fx.b.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(tTCustomController == null);
            }
        });
        return wc7VarB.a().sparseArray();
    }
}
