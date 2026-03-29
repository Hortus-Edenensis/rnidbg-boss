package defpackage;

import android.text.TextUtils;
import com.qiniu.android.collect.ReportItem;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class xq3 {
    public static Map<String, Object> a(String str, String str2, String str3, int i) {
        HashMap map = new HashMap();
        map.put(ReportItem.RequestKeyRequestId, str);
        map.put("apiKey", str2);
        if (i > -1) {
            map.put("page", Integer.valueOf(i));
        }
        if (!TextUtils.isEmpty(str3)) {
            map.put("bus", str3);
        }
        return map;
    }

    public static void b(String str, String str2, String str3, int i) {
        zn6.j("square_net_req", null, a(str, str2, str3, i));
    }

    public static void c(String str, String str2, String str3, int i, long j, long j2, int i2, String str4) {
        Map<String, Object> mapA = a(str, str2, str3, i);
        mapA.put("time", Long.valueOf(j));
        mapA.put("netTime", Long.valueOf(j2));
        mapA.put("errCode", Integer.valueOf(i2));
        if (!TextUtils.isEmpty(str4)) {
            mapA.put(WifiNestConst.OtherConst.KEY_MSG, str4);
        }
        zn6.j("square_net_resp", null, mapA);
    }
}
