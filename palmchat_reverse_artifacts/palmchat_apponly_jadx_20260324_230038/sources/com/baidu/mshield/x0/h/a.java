package com.baidu.mshield.x0.h;

import android.content.Context;
import com.baidu.mshield.x0.d.d;
import com.baidu.mshield.x6.EngineImpl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile long f4067a;

    /* JADX INFO: renamed from: com.baidu.mshield.x0.h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0098a extends com.baidu.mshield.x0.d.h.b {
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ int e;

        public C0098a(a aVar, int i, long j, Context context, int i2) {
            this.b = i;
            this.c = j;
            this.d = context;
            this.e = i2;
        }

        @Override // com.baidu.mshield.x0.d.h.b
        public void a() {
            try {
                if (this.b != 1) {
                    EngineImpl.getInstance(this.d).uccs(this.e, this.b);
                    return;
                }
                synchronized (a.class) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (a.f4067a == 0 || jCurrentTimeMillis - a.f4067a >= this.c) {
                        long unused = a.f4067a = jCurrentTimeMillis;
                        EngineImpl.getInstance(this.d).uccs(this.e, this.b);
                    }
                }
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    public void a(Context context, int i, int i2, long j) {
        com.baidu.mshield.x0.d.h.d.b().a(new C0098a(this, i2, j, context, i));
    }
}
