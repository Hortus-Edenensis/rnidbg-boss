package com.opos.mobad.mediaplayer.b;

import android.content.Context;
import com.oplus.tblplayer.TBLPlayerManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static AtomicBoolean f9007a = new AtomicBoolean(false);
    private static int b = -1;

    public static final com.opos.mobad.d.d.a a(Context context, int i, com.opos.mobad.d.d.b bVar) {
        return 1 == i ? new com.opos.mobad.mediaplayer.c.b(context, bVar) : 2 == i ? new com.opos.mobad.mediaplayer.c.a(context, bVar) : new com.opos.mobad.mediaplayer.c.c(context, bVar);
    }

    public static boolean b() {
        if (b == -1) {
            try {
                new TBLPlayerManager();
                b = 1;
            } catch (Throwable th) {
                b = 0;
                com.opos.cmn.an.f.a.b("VideoPlayerFactory", "isSupportTbl", th);
            }
        }
        com.opos.cmn.an.f.a.a("VideoPlayerFactory", "isSupportTbl:" + b);
        return b == 1;
    }

    public static int c() {
        if (com.opos.mobad.mediaplayer.a.f9001a.booleanValue()) {
            return 2;
        }
        return b() ? 3 : 1;
    }

    public static final com.opos.mobad.d.d.a a(Context context, com.opos.mobad.d.d.b bVar) {
        return a(context, c(), bVar);
    }

    public static com.opos.mobad.template.l.a a(int i) {
        return 1 == i ? new b() : 2 == i ? new a() : new c();
    }

    public static void a(boolean z) {
        f9007a.set(z);
    }

    public static boolean a() {
        return f9007a.get();
    }
}
