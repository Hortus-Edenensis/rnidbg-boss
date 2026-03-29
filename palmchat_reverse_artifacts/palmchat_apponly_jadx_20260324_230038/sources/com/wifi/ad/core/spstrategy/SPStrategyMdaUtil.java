package com.wifi.ad.core.spstrategy;

import android.content.Context;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.NestSdkVersion;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class SPStrategyMdaUtil {
    public static void startRequestMda(String str, String str2, String str3, String str4, Context context) {
        try {
            HashMap map = new HashMap();
            map.put("requestId", str);
            map.put("type", str2);
            if (context != null) {
                map.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(context));
            }
            NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
            map.put("channel", nestInfoTaker.getChannel());
            map.put("version", nestInfoTaker.getAppVer());
            map.put("versionName", nestInfoTaker.getAppVerName());
            map.put("taichi", str3);
            map.put("scene", str4);
            WifiNestAd.reporter.onEvent("nest_sdk_req_strategy", new EventParams.Builder().build(), map);
        } catch (Exception unused) {
        }
    }

    public static void startRespMda(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Context context) {
        try {
            HashMap map = new HashMap();
            map.put("requestId", str);
            map.put("type", str2);
            if (context != null) {
                map.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(context));
            }
            NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
            map.put("channel", nestInfoTaker.getChannel());
            map.put("version", nestInfoTaker.getAppVer());
            map.put("versionName", nestInfoTaker.getAppVerName());
            map.put("taichi", str3);
            map.put("scene", str4);
            map.put(EventParams.KEY_STRATEGY_VER, str5);
            map.put("strategyid", str6);
            map.put("resultcode", str7);
            map.put("msg", str8);
            WifiNestAd.reporter.onEvent("nest_sdk_req_strategy_result", new EventParams.Builder().build(), map);
        } catch (Exception unused) {
        }
    }
}
