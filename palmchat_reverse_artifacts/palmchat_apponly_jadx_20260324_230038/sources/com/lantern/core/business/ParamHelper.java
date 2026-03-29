package com.lantern.core.business;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ParamHelper {
    private static IPubParams params;

    public static List<String> getAdvancedPresetEventList() {
        IPubParams iPubParams = params;
        return iPubParams != null ? iPubParams.getAdvancedPresetEventList() : new ArrayList();
    }

    public static String getAesIv() {
        IPubParams iPubParams = params;
        return iPubParams != null ? iPubParams.getAesIv() : "";
    }

    public static String getAesKey() {
        IPubParams iPubParams = params;
        return iPubParams != null ? iPubParams.getAesKey() : "";
    }

    public static String getConfigPid() {
        IPubParams iPubParams = params;
        return iPubParams != null ? iPubParams.getConfigPid() : "";
    }

    public static String getConfigUrl() {
        IPubParams iPubParams = params;
        return iPubParams != null ? iPubParams.getConfigUrl() : "";
    }

    public static String getEventPid() {
        IPubParams iPubParams = params;
        return iPubParams != null ? iPubParams.getEventPid() : "";
    }

    public static String getInstEventUrl() {
        IPubParams iPubParams = params;
        return iPubParams != null ? iPubParams.getInstEventUrl() : "";
    }

    public static int getKv() {
        IPubParams iPubParams = params;
        if (iPubParams != null) {
            return iPubParams.getKv();
        }
        return 0;
    }

    public static String getOfflineEventUrl() {
        IPubParams iPubParams = params;
        return iPubParams != null ? iPubParams.getOfflineEventUrl() : "";
    }

    public static String getOnceEventUrl() {
        IPubParams iPubParams = params;
        return iPubParams != null ? iPubParams.getOnceEventUrl() : "";
    }

    public static List<String> getPresetEventList() {
        ArrayList arrayList = new ArrayList();
        IPubParams iPubParams = params;
        List<String> advancedPresetEventList = iPubParams != null ? iPubParams.getAdvancedPresetEventList() : new ArrayList<>();
        if (!advancedPresetEventList.isEmpty()) {
            arrayList.addAll(advancedPresetEventList);
        }
        IPubParams iPubParams2 = params;
        List<String> presetEventList = iPubParams2 != null ? iPubParams2.getPresetEventList() : new ArrayList<>();
        if (!presetEventList.isEmpty()) {
            arrayList.addAll(presetEventList);
        }
        return arrayList;
    }

    public static String getWifiEventUrl() {
        IPubParams iPubParams = params;
        return iPubParams != null ? iPubParams.getWifiEventUrl() : "";
    }

    public static void setParams(IPubParams iPubParams) {
        params = iPubParams;
        Log.i("CX_EVENT", "ParamHelper setParams");
    }
}
