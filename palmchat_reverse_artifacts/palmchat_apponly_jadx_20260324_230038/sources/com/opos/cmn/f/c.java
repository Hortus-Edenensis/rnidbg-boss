package com.opos.cmn.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f7916a;

    public static b a() {
        b aVar;
        b bVar = f7916a;
        if (bVar != null) {
            return bVar;
        }
        synchronized (c.class) {
            aVar = f7916a;
            if (aVar == null) {
                aVar = new a();
                f7916a = aVar;
            }
        }
        return aVar;
    }

    public static String b() {
        return "";
    }
}
