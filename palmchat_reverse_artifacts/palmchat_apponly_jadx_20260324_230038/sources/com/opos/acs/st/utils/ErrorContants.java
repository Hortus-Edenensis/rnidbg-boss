package com.opos.acs.st.utils;

import android.content.Context;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ErrorContants {
    public static final String CHANNEL_BD = "1";
    public static final String CHANNEL_FEEDS = "4";
    public static final String CHANNEL_ST = "5";
    public static final String CHANNEL_UNION = "2";
    public static final String INIT_LOADAD_ERROR = "202";
    public static final String LOAD_STRATEGY_ERROR = "601";
    public static final String LOCAL_BIZ_DE_ERROR = "609";
    public static final String LOCAL_BIZ_EN_ERROR = "608";
    public static final String LOCAL_DE_ERROR = "607";
    public static final String LOCAL_EN_ERROR = "606";
    public static final String NET_ERROR = "-1";
    public static final String NET_NO_CALLBACK = "-2";
    public static final String NEW_PERIODIC_REPORT_ERROR = "610";
    public static final String NEW_REALTIME_REPORT_ERROR = "611";
    public static final String NO_NEW_OLD_ASSOCIATE = "612";
    public static final String NO_NEW_STRATEGY_ERROR = "613";
    public static final String PERIODIC_REPORT_ERROR = "602";
    public static final String REALTIME_LOADAD_ERROR = "201";
    public static final String REALTIME_REPORT_ERROR = "603";
    public static final String REPORT_ERROR = "604";
    public static final String THIRDPARTY_ST_ERROR = "1";
    public static final String THIRD_PARTY_ST = "605";

    public static Map errorContantseMap(Context context, String str) {
        HashMap map = new HashMap();
        map.put(TKDownloadReason.KSAD_TK_NET, k.b(context));
        if (str == null) {
            str = "";
        }
        map.put("chn", str);
        map.put("evtId", "-1");
        map.put("ct", Long.valueOf(System.currentTimeMillis()));
        map.put("url", "");
        map.put("ret", "-1");
        map.put("rt", 0);
        map.put("mt", 0);
        map.put("ext", "");
        return map;
    }

    public static Map errorContantseMap(Context context, String str, String str2, String str3, String str4, long j, long j2, String str5) {
        Map mapErrorContantseMap = errorContantseMap(context, str);
        mapErrorContantseMap.put("evtId", str2);
        mapErrorContantseMap.put("url", str3);
        mapErrorContantseMap.put("ret", str4);
        mapErrorContantseMap.put("rt", Long.valueOf(j));
        mapErrorContantseMap.put("mt", Long.valueOf(j2));
        mapErrorContantseMap.put("ext", str5);
        return mapErrorContantseMap;
    }
}
