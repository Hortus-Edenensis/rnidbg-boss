package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class t1 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f3902a;
    public int b;

    public t1(int i, InputStream inputStream) {
        this.f3902a = inputStream;
        this.b = i;
    }

    public int a() {
        return this.b;
    }

    public final void b() {
        InputStream inputStream = this.f3902a;
        if (inputStream instanceof q1) {
            q1 q1Var = (q1) inputStream;
            q1Var.f = true;
            q1Var.c();
        }
    }
}
