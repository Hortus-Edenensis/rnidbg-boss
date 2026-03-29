package com.zx.a.I8b7;

import com.zx.a.I8b7.v3;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class g1 extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f16796a;
    public final /* synthetic */ h1 b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                g1 g1Var = g1.this;
                h1.a(g1Var.b, g1Var.f16796a);
                h1.a(g1.this.b);
            } catch (Throwable th) {
                r2.a(th);
            }
        }
    }

    public g1(h1 h1Var, long j) {
        this.b = h1Var;
        this.f16796a = j;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            v3.f.f16875a.e.execute(new a());
        } catch (Throwable th) {
            r2.a(th);
        }
    }
}
