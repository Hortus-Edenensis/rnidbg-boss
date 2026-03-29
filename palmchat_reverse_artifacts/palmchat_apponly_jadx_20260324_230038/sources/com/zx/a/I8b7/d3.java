package com.zx.a.I8b7;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class d3 implements Runnable {
    public d3(x2 x2Var, boolean z) {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            x2.a().a(false);
        } catch (Throwable th) {
            r.b(th.getMessage());
        }
    }
}
