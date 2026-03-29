package com.vivo.push.util;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class x {
    public static int a(com.vivo.push.b.c cVar) {
        ac acVarC = ac.c();
        int iB = cVar.b();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iB2 = acVarC.b("com.vivo.push_preferences.operate." + iB + "OPERATE_COUNT", 0);
        long jB = jCurrentTimeMillis - acVarC.b("com.vivo.push_preferences.operate." + iB + "START_TIME", 0L);
        if (jB > 86400000 || jB < 0) {
            acVarC.a("com.vivo.push_preferences.operate." + iB + "START_TIME", System.currentTimeMillis());
            acVarC.a("com.vivo.push_preferences.operate." + iB + "OPERATE_COUNT", 1);
        } else {
            if (iB2 >= cVar.d()) {
                return 1001;
            }
            acVarC.a("com.vivo.push_preferences.operate." + iB + "OPERATE_COUNT", iB2 + 1);
        }
        return 0;
    }
}
