package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.api.iz;
import com.bytedance.sdk.openadsdk.api.plugin.jk;
import com.bytedance.sdk.openadsdk.api.pn;
import com.bytedance.sdk.openadsdk.api.u;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.live.fx;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.MediationManagerVisitor;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class TTAdSdk {
    public static final String BRANCH = "v7200";
    public static final String BUILT_IN_PLUGIN_NAME = "com.byted.pangle";
    public static final String C_H = "a5b2d15";
    public static final int EXT_API_VERSION_CODE = 999;
    public static final boolean INCLUDE_LIVE = true;
    public static final String INITIALIZER_CLASS_NAME = "com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder";
    public static final boolean IS_BOOST = true;
    public static final boolean IS_P = false;
    public static final String LIVE_PLUGIN_PACKAGE_NAME = "com.byted.live.lite";
    public static final boolean ONLY_API = false;
    public static final boolean PC_BOOST_ABI = false;
    public static final String PLUGIN_ADAPTER_PACKAGE_NAME = "com.byted.mixed";
    public static final int SDK_VERSION_CODE = 7232;
    public static final String SDK_VERSION_NAME = "7.2.3.2";
    public static final String S_C = "main";
    private static volatile TTAdConfig nr;
    private static final u u = new jk();

    /* JADX INFO: compiled from: SearchBox */
    public interface Callback extends InitCallback {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Deprecated
    public interface InitCallback {
        void fail(int i, String str);

        void success();
    }

    public static TTAdManager getAdManager() {
        u uVar = u;
        if (uVar != null) {
            return uVar.nr();
        }
        return null;
    }

    public static View getEcMallBackUpView() {
        u.fx fxVarNr = u.nr();
        if (fxVarNr == null) {
            return null;
        }
        return (View) fxVarNr.getExtra(View.class, null);
    }

    public static IMediationManager getMediationManager() {
        if (u != null) {
            return MediationManagerVisitor.getInstance().getMediationManager();
        }
        return null;
    }

    public static boolean init(Context context, TTAdConfig tTAdConfig) {
        dw.u(context);
        nr = tTAdConfig;
        u(context, nr);
        return true;
    }

    @Deprecated
    public static boolean isInitSuccess() {
        u uVar = u;
        if (uVar != null) {
            return uVar.u();
        }
        return false;
    }

    public static boolean isOpenMediationMap() {
        TTAdManager adManager = getAdManager();
        if (adManager == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extra_name", "use_mediation_map");
        Map map = (Map) adManager.getExtra(Map.class, bundle);
        if (map == null || !(map.get("use_mediation_map") instanceof Boolean)) {
            return false;
        }
        return ((Boolean) map.get("use_mediation_map")).booleanValue();
    }

    public static boolean isSdkReady() {
        u uVar = u;
        if (uVar != null) {
            return uVar.u();
        }
        return false;
    }

    public static void start(Callback callback) {
        u(nr, "TTAdConfig is null, please exec TTAdSdk.init before TTAdSdk.start.");
        u uVar = u;
        if (uVar == null) {
            callback.fail(4100, "Load initializer failed");
        } else {
            uVar.u(TTAppContextHolder.getContext(), nr, callback);
        }
    }

    private static void u(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig != null && tTAdConfig.isDebug()) {
            iz.u();
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            iz.nr("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
        }
        u(context, "Context is null, please check.");
        u(tTAdConfig, "TTAdConfig is null, please check.");
        TTAppContextHolder.setContext(context);
        updateConfigAuth(tTAdConfig);
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        u.fx fxVarNr;
        if (pn.u() || tTAdConfig == null || (fxVarNr = u.nr()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(tTAdConfig.getData())) {
            bundle.putString("extra_data", tTAdConfig.getData());
        }
        if (!TextUtils.isEmpty(tTAdConfig.getKeywords())) {
            bundle.putString("keywords", tTAdConfig.getKeywords());
        }
        if (!bundle.keySet().isEmpty()) {
            fxVarNr.getExtra(SparseArray.class, bundle);
        }
        IMediationManager mediationManager = getMediationManager();
        if (mediationManager != null) {
            if (tTAdConfig.getCustomController() != null) {
                mediationManager.updatePrivacyConfig(tTAdConfig.getCustomController());
            }
            Map<String, Object> initExtra = tTAdConfig.getInitExtra();
            if (initExtra == null || initExtra.isEmpty()) {
                return;
            }
            mediationManager.updateLocalExtra(tTAdConfig.getInitExtra());
        }
    }

    public static void updateConfigAuth(TTAdConfig tTAdConfig) {
        Map<String, Object> initExtra;
        if (pn.u() || tTAdConfig == null || (initExtra = tTAdConfig.getInitExtra()) == null) {
            return;
        }
        Object obj = initExtra.get(TTAdConstant.KEY_INIT_FOR_LIVE);
        if (obj instanceof Map) {
            fx.u().u((Map<String, String>) obj);
        }
    }

    public static void updatePaid(boolean z) {
        u.fx fxVarNr = u.nr();
        if (fxVarNr == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        fxVarNr.getExtra(SparseArray.class, bundle);
    }

    private static void u(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}
