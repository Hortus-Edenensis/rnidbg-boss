package defpackage;

import com.wifi.ad.core.config.DeviceInfoUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class c65 {
    public static void a(String str) {
        b(str, null);
    }

    public static void b(String str, Map<String, String> map) {
        if (!str.startsWith("lx")) {
            str = "lx_" + str;
        }
        zn6.i(str, map);
    }

    public static void c(String str, String str2) {
        if (str2 == null) {
            b(str, null);
            return;
        }
        HashMap map = new HashMap();
        map.put(DeviceInfoUtil.UID_TAG, str2);
        b(str, map);
    }
}
