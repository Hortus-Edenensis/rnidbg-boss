package com.zx.a.I8b7;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class t1 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1 f16863a;
    public final int b;
    public final String c;
    public final Map<String, List<String>> d;
    public final u1 e;

    public t1(a aVar) {
        this.f16863a = aVar.f16864a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = new HashMap(aVar.d);
        this.e = aVar.e;
    }

    public String a(String str) {
        List<String> list = this.d.get(str);
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("; ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        u1 u1Var = this.e;
        if (u1Var == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        u1Var.close();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public q1 f16864a;
        public int b;
        public String c;
        public Map<String, List<String>> d;
        public u1 e;

        public a() {
            this.b = -1;
            this.d = new HashMap();
        }

        public t1 a() {
            if (this.f16864a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.b >= 0) {
                if (this.c != null) {
                    return new t1(this);
                }
                throw new IllegalStateException("message == null");
            }
            StringBuilder sbA = f3.a("code < 0: ");
            sbA.append(this.b);
            throw new IllegalStateException(sbA.toString());
        }

        public a(t1 t1Var) {
            this.b = -1;
            this.f16864a = t1Var.f16863a;
            this.b = t1Var.b;
            this.c = t1Var.c;
            this.d = new HashMap(t1Var.d);
            this.e = t1Var.e;
        }
    }
}
