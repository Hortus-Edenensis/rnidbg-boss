package com.zx.a.I8b7;

import com.zx.a.I8b7.h1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class k1 implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        try {
            h1 h1Var = h1.b.f16802a;
            h1Var.getClass();
            if (h1.i != null && h1.i.length() > 0) {
                h1.i.a(h1Var.c - 1);
                h1Var.c = h1.i.length();
            }
            if (h1.j == null || h1.j.length() <= 0) {
                return;
            }
            h1.j.a(h1Var.d - 1);
            h1Var.d = h1.j.length();
        } catch (Throwable th) {
            r2.a(th);
        }
    }
}
