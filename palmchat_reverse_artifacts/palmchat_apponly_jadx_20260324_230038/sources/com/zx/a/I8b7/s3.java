package com.zx.a.I8b7;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class s3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f16860a;
    public final /* synthetic */ t3 b;

    public s3(t3 t3Var, Context context) {
        this.b = t3Var;
        this.f16860a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            m3.a(this.f16860a);
        } catch (Throwable th) {
            g3.a(th, f3.a("ZXCore init failed: "));
            this.b.b.set(false);
        }
    }
}
