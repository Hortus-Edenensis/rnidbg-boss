package com.opos.mobad.model.e;

import android.content.Context;
import com.opos.mobad.provider.ad.AdEntity;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f9094a;
    private Context b;
    private com.opos.mobad.provider.ad.a c;
    private com.opos.mobad.model.b.a d = new com.opos.mobad.model.a.d();
    private com.opos.mobad.model.b.e e = new com.opos.mobad.model.a.k();

    private b(Context context) {
        this.b = context;
        this.c = new com.opos.mobad.provider.ad.a(context);
    }

    public com.opos.mobad.model.c.d a(String str, int i) throws Exception {
        String str2;
        AdEntity adEntityA = this.c.a(str);
        if (adEntityA == null) {
            str2 = "getCache null:" + str;
        } else {
            int i2 = adEntityA.d;
            if (-1 == i2 || i2 == i) {
                return this.d.a(adEntityA);
            }
            str2 = "get cache but diff posType:" + adEntityA.d + "," + i + "," + str;
        }
        com.opos.cmn.an.f.a.b("acManager", str2);
        return null;
    }

    public static final b a(Context context) {
        b bVar;
        b bVar2 = f9094a;
        if (bVar2 != null) {
            return bVar2;
        }
        synchronized (b.class) {
            bVar = f9094a;
            if (bVar == null) {
                bVar = new b(context);
                f9094a = bVar;
            }
        }
        return bVar;
    }

    public void a(final com.opos.mobad.b bVar, final String str, final com.opos.mobad.model.c.d dVar, final List<T> list, final int i, final boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("cache list num:");
        sb.append(list != null ? list.size() : 0);
        com.opos.cmn.an.f.a.b("acManager", sb.toString());
        if (list == null || list.size() <= 0) {
            return;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.e.b.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.c.a(str, b.this.d.a(list, dVar, i));
                    if (z) {
                        b.this.e.a(bVar, list.get(0), i);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("acManager", "cache fail", (Throwable) e);
                }
            }
        });
    }
}
