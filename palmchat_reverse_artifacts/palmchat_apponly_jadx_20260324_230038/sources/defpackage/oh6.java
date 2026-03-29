package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class oh6 {
    public static void a(String str, String str2, Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            zn6.c(str, str2);
        } else {
            zn6.j(str, str2, map);
        }
    }

    public static void b(int i) {
        HashMap map = new HashMap();
        map.put("friendType", Integer.valueOf(i));
        a("pagegroup_personcard_sendmsg", "click", map);
    }
}
