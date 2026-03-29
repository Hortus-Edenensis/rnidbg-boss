package com.heytap.mspsdk.util;

import android.os.Bundle;
import com.heytap.mspsdk.constants.Constants;
import com.opos.process.bridge.client.BaseActivityClient;
import com.opos.process.bridge.client.BaseProviderClient;
import com.opos.process.bridge.client.BaseServiceClient;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Bundle a(T t) {
        return t instanceof BaseProviderClient ? ((BaseProviderClient) t).getData() : t instanceof BaseServiceClient ? ((BaseServiceClient) t).getData() : t instanceof BaseActivityClient ? ((BaseActivityClient) t).getData() : new Bundle();
    }

    public static <T> Bundle a(T t, Bundle bundle) {
        if (bundle == null) {
            bundle = a(t);
        }
        bundle.putBundle(Constants.BUNDLE_KEY_MSP_SDK_COMMON_BUNDLE, a(bundle.getString(Constants.BUNDLE_KEY_MSP_SDK_KIT_NAME)));
        return bundle;
    }

    private static Bundle a(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.BUNDLE_KEY_MSP_SDK_VERSION_CODE, 2000112);
        bundle.putString(Constants.BUNDLE_KEY_MSP_SDK_VERSION_NAME, "2.0.1.12");
        bundle.putString(Constants.BUNDLE_KEY_MSP_SDK_CALLING_PKG, com.heytap.mspsdk.core.e.a().b().getPackageName());
        bundle.putString(Constants.BUNDLE_KEY_MSP_SDK_KIT_NAME, str);
        bundle.putBundle(Constants.BUNDLE_KEY_MSP_SDK_IPC_TIME_RECORDER, new Bundle());
        return bundle;
    }
}
