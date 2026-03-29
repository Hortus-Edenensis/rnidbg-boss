package com.zx.a.I8b7;

import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q1 f16811a;
    public o2 b;
    public boolean c;

    /* JADX INFO: compiled from: SearchBox */
    public final class a implements Runnable {
        /* JADX WARN: Code restructure failed: missing block: B:12:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            try {
                throw null;
            } catch (Throwable th) {
                new Exception(th.getMessage(), th.getCause());
                throw null;
            }
        }
    }

    public i1(o2 o2Var, q1 q1Var) {
        this.b = o2Var;
        this.f16811a = q1Var;
    }

    public t1 a() throws Exception {
        synchronized (this) {
            if (this.c) {
                throw new IllegalStateException("Already Executed");
            }
            this.c = true;
        }
        try {
            x xVar = this.b.f16839a;
            synchronized (xVar) {
                xVar.d.add(this);
            }
            return b();
        } finally {
            x xVar2 = this.b.f16839a;
            xVar2.a(xVar2.d, this, false);
        }
    }

    public t1 b() throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.b.b);
        this.f16811a.getClass();
        arrayList.add(new e());
        arrayList.add(new o(this.b));
        arrayList.add(new j());
        q1 q1Var = this.f16811a;
        if (arrayList.size() <= 0) {
            throw new AssertionError();
        }
        j1 j1Var = new j1(arrayList, null, 1, q1Var);
        n0 n0Var = (n0) arrayList.get(0);
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
