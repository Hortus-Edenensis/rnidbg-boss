package com.opos.mobad.mediaplayer.a;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(String str);
    }

    public static String a(Context context, String str, int i) {
        com.opos.cmn.an.f.a.b("VideoProxyUtils", str);
        return str;
    }

    public static void a(final Context context, final String str, final int i, final a aVar) {
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.mediaplayer.a.d.1
            @Override // java.lang.Runnable
            public void run() {
                String strA = d.a(context, str, i);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(strA);
                }
            }
        });
    }
}
