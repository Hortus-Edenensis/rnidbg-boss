package defpackage;

import com.google.common.base.Equivalence;
import defpackage.fr3;
import defpackage.rc3;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class qc3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20225a;
    public int b = -1;
    public int c = -1;
    public rc3.o d;
    public rc3.o e;
    public Equivalence<Object> f;

    public qc3 a(int i) {
        int i2 = this.c;
        dm4.v(i2 == -1, "concurrency level was already set to %s", i2);
        dm4.d(i > 0);
        this.c = i;
        return this;
    }

    public int b() {
        int i = this.c;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    public int c() {
        int i = this.b;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    public Equivalence<Object> d() {
        return (Equivalence) fr3.a(this.f, e().defaultEquivalence());
    }

    public rc3.o e() {
        return (rc3.o) fr3.a(this.d, rc3.o.STRONG);
    }

    public rc3.o f() {
        return (rc3.o) fr3.a(this.e, rc3.o.STRONG);
    }

    public qc3 g(int i) {
        int i2 = this.b;
        dm4.v(i2 == -1, "initial capacity was already set to %s", i2);
        dm4.d(i >= 0);
        this.b = i;
        return this;
    }

    public qc3 h(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f;
        dm4.w(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f = (Equivalence) dm4.o(equivalence);
        this.f20225a = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        return !this.f20225a ? new ConcurrentHashMap(c(), 0.75f, b()) : rc3.a(this);
    }

    public qc3 j(rc3.o oVar) {
        rc3.o oVar2 = this.d;
        dm4.w(oVar2 == null, "Key strength was already set to %s", oVar2);
        this.d = (rc3.o) dm4.o(oVar);
        if (oVar != rc3.o.STRONG) {
            this.f20225a = true;
        }
        return this;
    }

    public qc3 k(rc3.o oVar) {
        rc3.o oVar2 = this.e;
        dm4.w(oVar2 == null, "Value strength was already set to %s", oVar2);
        this.e = (rc3.o) dm4.o(oVar);
        if (oVar != rc3.o.STRONG) {
            this.f20225a = true;
        }
        return this;
    }

    public qc3 l() {
        return j(rc3.o.WEAK);
    }

    public String toString() {
        fr3.b bVarB = fr3.b(this);
        int i = this.b;
        if (i != -1) {
            bVarB.b("initialCapacity", i);
        }
        int i2 = this.c;
        if (i2 != -1) {
            bVarB.b("concurrencyLevel", i2);
        }
        rc3.o oVar = this.d;
        if (oVar != null) {
            bVarB.d("keyStrength", th.e(oVar.toString()));
        }
        rc3.o oVar2 = this.e;
        if (oVar2 != null) {
            bVarB.d("valueStrength", th.e(oVar2.toString()));
        }
        if (this.f != null) {
            bVarB.j("keyEquivalence");
        }
        return bVarB.toString();
    }
}
