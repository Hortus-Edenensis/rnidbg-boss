package defpackage;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class wt2 {
    public static String a() {
        return jo6.c("LX-32837", "A");
    }

    public static boolean b(String str) {
        return c() && !TextUtils.isEmpty(str) && str.equalsIgnoreCase("tab_small_video");
    }

    public static boolean c() {
        String strA = a();
        return (TextUtils.isEmpty(strA) || "A".equalsIgnoreCase(strA)) ? false : true;
    }
}
