package com.zm.fissionsdk.api;

import android.content.Context;
import com.zm.fissionsdk.VZV2Z;
import com.zm.fissionsdk.WZVW2;
import com.zm.fissionsdk.WzWVz;
import com.zm.fissionsdk.api.interfaces.IFissionLoadManager;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FissionSdk {

    /* JADX INFO: compiled from: SearchBox */
    public interface InitCallback {
        void onFailed(int i, String str);

        void onSuccess();
    }

    private FissionSdk() {
    }

    public static IFissionLoadManager getLoadManager() {
        return WZVW2.a();
    }

    public static int getSdkVersionCode() {
        return VZV2Z.c();
    }

    public static String getSdkVersionName() {
        return VZV2Z.d();
    }

    public static void init(Context context, FissionConfig fissionConfig, InitCallback initCallback) {
        WzWVz.a(context, fissionConfig, initCallback);
    }

    public static boolean isGameProcess(Context context) {
        return VZV2Z.a(context);
    }

    public static boolean isInitSuccess() {
        return WzWVz.a();
    }

    public static void startGameCenter(Context context) {
        VZV2Z.b(context);
    }

    public static void startGameCenter(Context context, Map<String, Object> map) {
        VZV2Z.a(context, map);
    }
}
