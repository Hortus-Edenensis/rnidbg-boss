package com.amap.api.col.p0002sl;

import com.baidu.platform.comapi.bmsdk.BmLocated;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class jj extends jg {
    private static jj b = new jj();

    private jj() {
        super(BmLocated.HALF_LEFT_TOP);
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    public static jj b() {
        return b;
    }

    public final byte[] c() {
        super.a();
        try {
            this.f2929a.c(kt.a(this.f2929a, ks.a(), this.f2929a.a(ks.f()), this.f2929a.a(ks.c()), (byte) ks.m(), this.f2929a.a(ks.i()), this.f2929a.a(ks.h()), this.f2929a.a(a(ks.g())), this.f2929a.a(a(ks.j())), kr.a(ks.n()), this.f2929a.a(ks.l()), this.f2929a.a(ks.k()), this.f2929a.a(ks.d()), this.f2929a.a(ks.e())));
            return this.f2929a.c();
        } catch (Exception e) {
            ku.a(e);
            return null;
        }
    }

    public final byte[] a(byte[] bArr, byte[] bArr2, List<? extends jn> list) {
        if (list == null) {
            return null;
        }
        try {
            int size = list.size();
            if (size <= 0 || bArr == null) {
                return null;
            }
            a();
            int iA = jq.a((mo) this.f2929a, bArr);
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                jn jnVar = list.get(i);
                iArr[i] = jv.a(this.f2929a, (byte) jnVar.a(), jv.a(this.f2929a, jnVar.b()));
            }
            this.f2929a.c(jq.a(this.f2929a, iA, bArr2 != null ? jq.b(this.f2929a, bArr2) : 0, jq.a(this.f2929a, iArr)));
            return this.f2929a.c();
        } catch (Throwable th) {
            ku.a(th);
            return null;
        }
    }
}
