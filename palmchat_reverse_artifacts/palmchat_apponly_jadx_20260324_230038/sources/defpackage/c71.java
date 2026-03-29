package defpackage;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.source.i;
import defpackage.kj4;
import defpackage.oc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class c71 implements kj4 {
    public static final qo5<String> i = new qo5() { // from class: z61
        @Override // defpackage.qo5
        /* JADX INFO: renamed from: get */
        public final Object get2() {
            return c71.l();
        }
    };
    public static final Random j = new Random();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0.d f1909a;
    public final e0.b b;
    public final HashMap<String, a> c;
    public final qo5<String> d;
    public kj4.a e;
    public e0 f;

    @Nullable
    public String g;
    public long h;

    /* JADX INFO: compiled from: SearchBox */
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1910a;
        public int b;
        public long c;
        public i.b d;
        public boolean e;
        public boolean f;

        public a(String str, int i, @Nullable i.b bVar) {
            this.f1910a = str;
            this.b = i;
            this.c = bVar == null ? -1L : bVar.d;
            if (bVar == null || !bVar.b()) {
                return;
            }
            this.d = bVar;
        }

        public boolean i(int i, @Nullable i.b bVar) {
            if (bVar == null) {
                return i == this.b;
            }
            i.b bVar2 = this.d;
            return bVar2 == null ? !bVar.b() && bVar.d == this.c : bVar.d == bVar2.d && bVar.b == bVar2.b && bVar.c == bVar2.c;
        }

        public boolean j(oc.a aVar) {
            i.b bVar = aVar.d;
            if (bVar == null) {
                return this.b != aVar.c;
            }
            long j = this.c;
            if (j == -1) {
                return false;
            }
            if (bVar.d > j) {
                return true;
            }
            if (this.d == null) {
                return false;
            }
            int iF = aVar.b.f(bVar.f18710a);
            int iF2 = aVar.b.f(this.d.f18710a);
            i.b bVar2 = aVar.d;
            if (bVar2.d < this.d.d || iF < iF2) {
                return false;
            }
            if (iF > iF2) {
                return true;
            }
            if (!bVar2.b()) {
                int i = aVar.d.e;
                return i == -1 || i > this.d.b;
            }
            i.b bVar3 = aVar.d;
            int i2 = bVar3.b;
            int i3 = bVar3.c;
            i.b bVar4 = this.d;
            int i4 = bVar4.b;
            if (i2 <= i4) {
                return i2 == i4 && i3 > bVar4.c;
            }
            return true;
        }

        public void k(int i, @Nullable i.b bVar) {
            if (this.c != -1 || i != this.b || bVar == null || bVar.d < c71.this.m()) {
                return;
            }
            this.c = bVar.d;
        }

        public final int l(e0 e0Var, e0 e0Var2, int i) {
            if (i >= e0Var.t()) {
                if (i < e0Var2.t()) {
                    return i;
                }
                return -1;
            }
            e0Var.r(i, c71.this.f1909a);
            for (int i2 = c71.this.f1909a.o; i2 <= c71.this.f1909a.p; i2++) {
                int iF = e0Var2.f(e0Var.q(i2));
                if (iF != -1) {
                    return e0Var2.j(iF, c71.this.b).c;
                }
            }
            return -1;
        }

        public boolean m(e0 e0Var, e0 e0Var2) {
            int iL = l(e0Var, e0Var2, this.b);
            this.b = iL;
            if (iL == -1) {
                return false;
            }
            i.b bVar = this.d;
            return bVar == null || e0Var2.f(bVar.f18710a) != -1;
        }
    }

    public c71() {
        this(i);
    }

    public static String l() {
        byte[] bArr = new byte[12];
        j.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    @Override // defpackage.kj4
    public synchronized void a(oc.a aVar) {
        vh.e(this.e);
        e0 e0Var = this.f;
        this.f = aVar.b;
        Iterator<a> it = this.c.values().iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!next.m(e0Var, this.f) || next.j(aVar)) {
                it.remove();
                if (next.e) {
                    if (next.f1910a.equals(this.g)) {
                        k(next);
                    }
                    this.e.b0(aVar, next.f1910a, false);
                }
            }
        }
        o(aVar);
    }

    @Override // defpackage.kj4
    public synchronized void b(oc.a aVar, int i2) {
        vh.e(this.e);
        boolean z = i2 == 0;
        Iterator<a> it = this.c.values().iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.j(aVar)) {
                it.remove();
                if (next.e) {
                    boolean zEquals = next.f1910a.equals(this.g);
                    boolean z2 = z && zEquals && next.f;
                    if (zEquals) {
                        k(next);
                    }
                    this.e.b0(aVar, next.f1910a, z2);
                }
            }
        }
        o(aVar);
    }

    @Override // defpackage.kj4
    public synchronized void c(oc.a aVar) {
        kj4.a aVar2;
        String str = this.g;
        if (str != null) {
            k((a) vh.e(this.c.get(str)));
        }
        Iterator<a> it = this.c.values().iterator();
        while (it.hasNext()) {
            a next = it.next();
            it.remove();
            if (next.e && (aVar2 = this.e) != null) {
                aVar2.b0(aVar, next.f1910a, false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00db A[Catch: all -> 0x0112, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0018, B:15:0x0024, B:17:0x0030, B:19:0x003a, B:23:0x0044, B:25:0x0050, B:26:0x0056, B:28:0x005b, B:30:0x0061, B:32:0x007a, B:34:0x00d5, B:36:0x00db, B:38:0x00f1, B:40:0x00fd, B:42:0x0103), top: B:48:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ed  */
    @Override // defpackage.kj4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void d(oc.a aVar) {
        a aVar2;
        oc.a aVar3;
        a aVar4;
        vh.e(this.e);
        if (aVar.b.u()) {
            return;
        }
        i.b bVar = aVar.d;
        if (bVar != null) {
            if (bVar.d < m()) {
                return;
            }
            a aVar5 = this.c.get(this.g);
            if (aVar5 != null && aVar5.c == -1 && aVar5.b != aVar.c) {
                return;
            }
        }
        a aVarN = n(aVar.c, aVar.d);
        if (this.g == null) {
            this.g = aVarN.f1910a;
        }
        i.b bVar2 = aVar.d;
        if (bVar2 == null || !bVar2.b()) {
            aVar2 = aVarN;
            if (aVar2.e) {
                aVar4 = aVar2;
                aVar4.e = true;
                aVar3 = aVar;
                this.e.Z(aVar3, aVar4.f1910a);
            } else {
                aVar3 = aVar;
                aVar4 = aVar2;
            }
            if (aVar4.f1910a.equals(this.g) && !aVar4.f) {
                aVar4.f = true;
                this.e.f(aVar3, aVar4.f1910a);
            }
            return;
        }
        i.b bVar3 = aVar.d;
        i.b bVar4 = new i.b(bVar3.f18710a, bVar3.d, bVar3.b);
        a aVarN2 = n(aVar.c, bVar4);
        if (!aVarN2.e) {
            aVarN2.e = true;
            aVar.b.l(aVar.d.f18710a, this.b);
            aVar2 = aVarN;
            this.e.Z(new oc.a(aVar.f19735a, aVar.b, aVar.c, bVar4, Math.max(0L, g86.m1(this.b.i(aVar.d.b)) + this.b.p()), aVar.f, aVar.g, aVar.h, aVar.i, aVar.j), aVarN2.f1910a);
        }
        if (aVar2.e) {
        }
        if (aVar4.f1910a.equals(this.g)) {
            aVar4.f = true;
            this.e.f(aVar3, aVar4.f1910a);
        }
        return;
    }

    @Override // defpackage.kj4
    public synchronized String e(e0 e0Var, i.b bVar) {
        return n(e0Var.l(bVar.f18710a, this.b).c, bVar).f1910a;
    }

    @Override // defpackage.kj4
    public void f(kj4.a aVar) {
        this.e = aVar;
    }

    @Override // defpackage.kj4
    @Nullable
    public synchronized String getActiveSessionId() {
        return this.g;
    }

    public final void k(a aVar) {
        if (aVar.c != -1) {
            this.h = aVar.c;
        }
        this.g = null;
    }

    public final long m() {
        a aVar = this.c.get(this.g);
        return (aVar == null || aVar.c == -1) ? this.h + 1 : aVar.c;
    }

    public final a n(int i2, @Nullable i.b bVar) {
        a aVar = null;
        long j2 = Long.MAX_VALUE;
        for (a aVar2 : this.c.values()) {
            aVar2.k(i2, bVar);
            if (aVar2.i(i2, bVar)) {
                long j3 = aVar2.c;
                if (j3 == -1 || j3 < j2) {
                    aVar = aVar2;
                    j2 = j3;
                } else if (j3 == j2 && ((a) g86.j(aVar)).d != null && aVar2.d != null) {
                    aVar = aVar2;
                }
            }
        }
        if (aVar != null) {
            return aVar;
        }
        String str = this.d.get2();
        a aVar3 = new a(str, i2, bVar);
        this.c.put(str, aVar3);
        return aVar3;
    }

    public final void o(oc.a aVar) {
        if (aVar.b.u()) {
            String str = this.g;
            if (str != null) {
                k((a) vh.e(this.c.get(str)));
                return;
            }
            return;
        }
        a aVar2 = this.c.get(this.g);
        a aVarN = n(aVar.c, aVar.d);
        this.g = aVarN.f1910a;
        d(aVar);
        i.b bVar = aVar.d;
        if (bVar == null || !bVar.b()) {
            return;
        }
        if (aVar2 != null && aVar2.c == aVar.d.d && aVar2.d != null && aVar2.d.b == aVar.d.b && aVar2.d.c == aVar.d.c) {
            return;
        }
        i.b bVar2 = aVar.d;
        this.e.i(aVar, n(aVar.c, new i.b(bVar2.f18710a, bVar2.d)).f1910a, aVarN.f1910a);
    }

    public c71(qo5<String> qo5Var) {
        this.d = qo5Var;
        this.f1909a = new e0.d();
        this.b = new e0.b();
        this.c = new HashMap<>();
        this.f = e0.f5869a;
        this.h = -1L;
    }
}
