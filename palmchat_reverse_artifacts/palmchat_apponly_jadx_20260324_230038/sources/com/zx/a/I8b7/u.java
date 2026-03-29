package com.zx.a.I8b7;

import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ File f16867a;
    public final /* synthetic */ String b;
    public final /* synthetic */ File c;
    public final /* synthetic */ File d;

    public u(v vVar, File file, String str, File file2, File file3) {
        this.f16867a = file;
        this.b = str;
        this.c = file2;
        this.d = file3;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Thread.sleep(1000L);
            this.f16867a.delete();
            new File(this.b).delete();
            this.c.delete();
            this.d.delete();
            m0.a(this.d);
        } catch (Throwable th) {
            r2.a(th);
        }
    }
}
