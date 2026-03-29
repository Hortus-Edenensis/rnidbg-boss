package defpackage;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class lj2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19011a;
    public Map<String, String> d;
    public Object f;
    public boolean g;
    public boolean h;
    public boolean i;
    public n05 m;
    public boolean n;
    public HostnameVerifier o;
    public boolean j = true;
    public boolean k = false;
    public boolean l = false;
    public int b = -1;
    public int c = -1;
    public Map<String, String> e = new HashMap();

    public lj2(String str) {
        this.f19011a = str;
    }

    public int a() {
        return this.b;
    }

    public HostnameVerifier b() {
        return this.o;
    }

    public byte[] c() {
        Object obj = this.f;
        if (obj != null) {
            if (obj instanceof String) {
                if (!TextUtils.isEmpty((CharSequence) obj)) {
                    return ((String) this.f).getBytes();
                }
            } else if (obj instanceof byte[]) {
                return (byte[]) obj;
            }
        }
        String strD = sj2.d(this.d);
        if (TextUtils.isEmpty(strD)) {
            return null;
        }
        return strD.getBytes();
    }

    public int d() {
        return this.c;
    }

    public Map<String, String> e() {
        return this.e;
    }

    public n05 f() {
        return this.m;
    }

    public String g() {
        return this.f19011a;
    }

    public boolean h() {
        return this.j;
    }

    public boolean i() {
        return this.l;
    }

    public boolean j() {
        return this.k;
    }

    public void k(Object obj) {
        this.f = obj;
    }

    public void l(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        this.b = i;
    }

    public void m(boolean z) {
        this.h = z;
    }

    public void n(boolean z) {
        this.g = z;
    }

    public void o(boolean z) {
        this.j = z;
    }

    public void p(boolean z) {
        this.l = z;
    }

    public void q(boolean z) {
        this.n = z;
    }

    public void r(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        this.c = i;
    }

    public void s(String str, String str2) {
        this.e.put(str, str2);
    }

    public void t(boolean z) {
        this.k = z;
    }

    public void u(n05 n05Var) {
        this.m = n05Var;
    }

    public void v(boolean z) {
        this.i = z;
    }
}
