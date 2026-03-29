package defpackage;

import android.net.Uri;
import com.lantern.auth.server.WkParams;
import com.umeng.analytics.pro.bd;
import com.umeng.ccg.a;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.c;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class mu4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19370a = vm0.a0;

    public static Uri a(Uri uri, Map<String, String>... mapArr) {
        return Uri.parse(b(uri.toString(), mapArr));
    }

    public static String b(String str, Map<String, String>... mapArr) {
        String strC;
        Map<String, String> map;
        if (!nl0.g()) {
            return str;
        }
        try {
            strC = zy4.c(str);
        } catch (Exception unused) {
            strC = "";
        }
        if (strC != null && (strC.endsWith(".youni.im") || strC.endsWith(".lianxinapp.com"))) {
            return str;
        }
        String strP = AccountUtils.p(AppContext.getContext());
        Map<String, String> map2 = new HashMap<>();
        if (mapArr != null && mapArr.length > 0 && (map = mapArr[0]) != null) {
            map2 = map;
        }
        map2.put(DeviceInfoUtil.UID_TAG, strP);
        map2.put("deviceId", ac1.h);
        map2.put(a.F, str);
        map2.put("token", om1.a());
        map2.put(WkParams.SESSIONID, v4.c(c.b()));
        map2.put("requestId", xn3.a());
        map2.put(bd.h, v4.b(c.b()));
        return zy4.b(f19370a, map2);
    }
}
