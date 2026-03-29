package com.opos.mobad.mediaplayer.a;

import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {
    public static int a(Map<String, String> map) {
        try {
            return Integer.parseInt(map.get("errCode"));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("VideoPlayerUtils", "getErrCode", e);
            return -1;
        }
    }

    public static String b(Map<String, String> map) {
        return (map == null || !map.containsKey(WifiNestConst.OtherConst.KEY_MSG)) ? "" : map.get(WifiNestConst.OtherConst.KEY_MSG);
    }

    public static String c(Map<String, String> map) {
        return (map == null || !map.containsKey("playerType")) ? "" : map.get("playerType");
    }

    public static String d(Map<String, String> map) {
        return (map == null || !map.containsKey("errType")) ? "" : map.get("errType");
    }

    public static boolean a() {
        com.opos.cmn.an.f.a.b("VideoPlayerUtils", "isSupportOKHttp", true);
        return true;
    }
}
