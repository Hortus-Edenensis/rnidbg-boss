package com.heytap.mspsdk.idmapping.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.msp.MspResponse;
import com.heytap.mspsdk.MspSdk;
import com.heytap.mspsdk.exception.MspSdkException;
import com.heytap.mspsdk.idmapping.impl.IIdMappingServiceModule;
import com.heytap.mspsdk.idmapping.impl.IdMappingServiceModuleClient;
import com.heytap.mspsdk.idmapping.impl.IdMappingServiceModuleInterface;
import com.heytap.mspsdk.util.e;
import com.lantern.auth.server.WkParams;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class Utils {
    public static void assembleBundle(Bundle bundle) {
        bundle.putInt(com.heytap.mspsdk.constants.Constants.BUNDLE_KEY_APP_MIN_VERSIONCODE, 2010000);
        bundle.putString(com.heytap.mspsdk.constants.Constants.BUNDLE_KEY_MSP_SDK_KIT_NAME, Constants.IDMAPPING_KIT_NAME);
    }

    public static IdMappingServiceModuleInterface getIdMappingServiceProxyer(Context context) throws MspSdkException {
        Bundle bundle = new Bundle();
        assembleBundle(bundle);
        return (IdMappingServiceModuleInterface) MspSdk.apiProxy(new IdMappingServiceModuleClient(context, bundle));
    }

    public static IIdMappingServiceModule getIdMappingServiceProxyer1(Context context) throws MspSdkException {
        Bundle bundle = new Bundle();
        assembleBundle(bundle);
        return (IIdMappingServiceModule) MspSdk.apiProxy(IIdMappingServiceModule.class, bundle);
    }

    public static Bundle obtainBundleParam(Context context, HashMap<String, String> map) {
        Bundle bundle = new Bundle();
        bundle.putString(WkParams.SESSIONID, e.a());
        bundle.putString("pkg", context.getPackageName());
        bundle.putSerializable("params", map);
        return bundle;
    }

    public static MspResponse obtainResponse(int i, String str, HashMap<String, String> map) {
        MspResponse mspResponse = new MspResponse();
        mspResponse.a(i);
        mspResponse.a(str);
        Bundle bundle = new Bundle();
        if (map != null && !map.isEmpty()) {
            bundle.putSerializable("result_map", map);
        }
        mspResponse.a(bundle);
        return mspResponse;
    }

    public static String sensitiveInfoReplace(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "*****" + str.substring(str.length() - (str.length() < 3 ? 1 : 3), str.length());
    }
}
