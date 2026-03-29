package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class yg5 {
    public static void a(String str, String str2) {
        HashMap map = new HashMap();
        map.put("fuid", str2);
        zn6.h("noticebar_permanent", str, map);
    }

    public static void b(boolean z, String str, int i, String str2) {
        HashMap map = new HashMap();
        map.put("type", String.valueOf(i));
        map.put("fuid", str2);
        zn6.h(z ? "specialattention_alert" : "specialattention_profile", str, map);
    }
}
