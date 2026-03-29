package com.heytap.msp.opos.sv.api.innerapi;

import android.content.Context;
import android.os.Bundle;
import com.heytap.mspsdk.constants.Constants;
import com.opos.cmn.an.f.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class KitUtils {
    private static final String TAG = "KitUtils";
    private static Object sGetKitVersionLock = new Object();
    private static Object sGetSupportAuthVerCodeListLock = new Object();
    private static volatile String sKitSupportAuthVerCodeList;
    private static volatile Integer sKitVersion;

    public static void assembleBundle(Bundle bundle) {
        bundle.putInt(Constants.BUNDLE_KEY_APP_MIN_VERSIONCODE, 1);
        bundle.putString(Constants.BUNDLE_KEY_MSP_SDK_KIT_NAME, "opos_sv");
    }

    public static int getKitVersion(Context context) {
        synchronized (sGetKitVersionLock) {
            if (sKitVersion != null) {
                return sKitVersion.intValue();
            }
            try {
                Bundle bundle = context.getApplicationContext().getPackageManager().getApplicationInfo("com.heytap.htms", 128).metaData;
                if (bundle != null) {
                    sKitVersion = Integer.valueOf(bundle.getInt("opos_sv_kit_ver_code"));
                }
            } catch (Throwable th) {
                a.c(TAG, "", th);
            }
            if (sKitVersion == null) {
                sKitVersion = 0;
            }
            a.a(TAG, "getKitVersion:" + sKitVersion);
            return sKitVersion.intValue();
        }
    }

    public static String getSupportAuthVerCodeList(Context context) {
        synchronized (sGetSupportAuthVerCodeListLock) {
            if (sKitSupportAuthVerCodeList != null) {
                return sKitSupportAuthVerCodeList;
            }
            try {
                Bundle bundle = context.getApplicationContext().getPackageManager().getApplicationInfo("com.heytap.htms", 128).metaData;
                if (bundle != null) {
                    sKitSupportAuthVerCodeList = bundle.getString("opos_ipc_auth_support_ver_code");
                }
            } catch (Throwable th) {
                a.c(TAG, "", th);
            }
            if (sKitSupportAuthVerCodeList == null) {
                sKitSupportAuthVerCodeList = "";
            }
            a.a(TAG, "getSupportAuthVerCodeList:" + sKitSupportAuthVerCodeList);
            return sKitSupportAuthVerCodeList;
        }
    }
}
