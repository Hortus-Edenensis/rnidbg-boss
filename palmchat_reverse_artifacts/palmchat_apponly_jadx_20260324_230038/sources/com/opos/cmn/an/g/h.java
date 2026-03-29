package com.opos.cmn.an.g;

import android.content.Context;
import com.opos.cmn.an.g.e;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f7787a;
    private static final byte[] b = new byte[0];
    private static AtomicLong c = new AtomicLong(0);

    public static long a() {
        return c.getAndIncrement();
    }

    private static void b() {
        if (f7787a == null) {
            synchronized (b) {
                if (f7787a == null) {
                    f7787a = new e.a().a(new com.opos.cmn.an.g.a.c.a()).a(new com.opos.cmn.an.g.a.b.a()).a(new com.opos.cmn.an.g.a.d.a()).a(new com.opos.cmn.an.g.a.e.a()).a();
                }
            }
        }
    }

    public static g a(Context context, long j, f fVar) {
        b bVar;
        Context applicationContext;
        b();
        if (context != null && fVar != null) {
            try {
                int i = fVar.f7783a;
                if (i == 0) {
                    bVar = f7787a.f7781a;
                    applicationContext = context.getApplicationContext();
                } else {
                    if (i == 1) {
                        return f7787a.b.a(context.getApplicationContext(), j, fVar);
                    }
                    if (i == 2) {
                        return f7787a.c.a(context.getApplicationContext(), j, fVar);
                    }
                    if (i == 3) {
                        return f7787a.d.a(context.getApplicationContext(), j, fVar);
                    }
                    bVar = f7787a.f7781a;
                    applicationContext = context.getApplicationContext();
                }
                return bVar.a(applicationContext, j, fVar);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("NetTool", "execute", e);
            }
        }
        return null;
    }

    public static void a(long j) {
        try {
            f7787a.f7781a.a(j);
            f7787a.b.a(j);
            f7787a.c.a(j);
            f7787a.d.a(j);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("NetTool", "shutDown", e);
        }
    }
}
