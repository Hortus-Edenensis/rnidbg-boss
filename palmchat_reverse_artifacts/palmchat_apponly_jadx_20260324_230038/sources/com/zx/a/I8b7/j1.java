package com.zx.a.I8b7;

import com.zx.a.I8b7.n0;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class j1 implements n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16813a;
    public final List<n0> b;
    public final q1 c;
    public final HttpURLConnection d;

    public j1(List<n0> list, HttpURLConnection httpURLConnection, int i, q1 q1Var) {
        this.b = list;
        this.d = httpURLConnection;
        this.f16813a = i;
        this.c = q1Var;
    }

    public t1 a(q1 q1Var, HttpURLConnection httpURLConnection) throws IOException {
        if (this.f16813a >= this.b.size()) {
            throw new AssertionError();
        }
        List<n0> list = this.b;
        int i = this.f16813a;
        j1 j1Var = new j1(list, httpURLConnection, i + 1, q1Var);
        n0 n0Var = list.get(i);
        t1 t1VarA = n0Var.a(j1Var);
        if (t1VarA == null) {
            throw new NullPointerException("interceptor " + n0Var + " returned null");
        }
        if (t1VarA.e != null) {
            return t1VarA;
        }
        throw new IllegalStateException("interceptor " + n0Var + " returned a response with no body");
    }
}
