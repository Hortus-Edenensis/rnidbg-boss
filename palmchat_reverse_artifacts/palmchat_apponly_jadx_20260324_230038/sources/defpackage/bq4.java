package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class bq4 {
    public static void a(int i, String str, boolean z, long j) {
        HashMap map = new HashMap();
        map.put("tab", z ? "pack" : "gift");
        map.put("giftid", Long.valueOf(j));
        map.put("scene", Integer.valueOf(i));
        map.put("roomId", str);
        map.put("fastlane", 1);
        zn6.j("gift_pick", "click", map);
    }

    public static void b(String str) {
        HashMap map = new HashMap();
        map.put("roomid", str);
        zn6.j("gift_fastlane", "view", map);
    }

    public static void c(boolean z, int i) {
        if (z) {
            zn6.c("gift_fastlane_check", "view");
            return;
        }
        HashMap map = new HashMap();
        map.put("option", Integer.valueOf(i));
        zn6.j("gift_fastlane_check", "click", map);
    }
}
