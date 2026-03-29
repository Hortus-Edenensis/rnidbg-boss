package com.baidu.mshield.x6.e;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile f f4083a;
    public final Context b;
    public final Runnable c = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f fVar = f.this;
                fVar.a(fVar.b);
            } catch (Throwable th) {
                com.baidu.mshield.x6.f.f.b(th);
            }
        }
    }

    public f(Context context) {
        this.b = context;
    }

    public static f b(Context context) {
        if (f4083a == null) {
            synchronized (f.class) {
                if (f4083a == null) {
                    f4083a = new f(context);
                }
            }
        }
        return f4083a;
    }

    public synchronized void a(long j) {
        try {
            com.baidu.mshield.b.c.a.a("startCheckDelayTime=" + j);
            com.baidu.mshield.x6.f.c.b().postDelayed(this.c, j);
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }

    public final void a(Context context) {
        try {
            if (com.baidu.mshield.b.a.d.b(context)) {
                com.baidu.mshield.b.c.a.a(" doDelayWork ");
                com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(context);
                if (!com.baidu.mshield.x6.f.f.c().equals(bVar.c())) {
                    h.a(context).a(1, true);
                }
                if (bVar.n() || h.b) {
                    return;
                }
                h.a(context).a(4);
            }
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }
}
