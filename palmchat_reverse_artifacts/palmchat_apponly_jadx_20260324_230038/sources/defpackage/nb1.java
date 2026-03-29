package defpackage;

import com.google.zxing.NotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class nb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ht f19477a;
    public final pk6 b;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final sx4 f19478a;
        public final sx4 b;
        public final int c;

        public sx4 a() {
            return this.f19478a;
        }

        public sx4 b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public String toString() {
            return this.f19478a + "/" + this.b + '/' + this.c;
        }

        public b(sx4 sx4Var, sx4 sx4Var2, int i) {
            this.f19478a = sx4Var;
            this.b = sx4Var2;
            this.c = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c implements Serializable, Comparator<b> {
        public c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar.c() - bVar2.c();
        }
    }

    public nb1(ht htVar) throws NotFoundException {
        this.f19477a = htVar;
        this.b = new pk6(htVar);
    }

    public static int d(sx4 sx4Var, sx4 sx4Var2) {
        return ae3.c(sx4.b(sx4Var, sx4Var2));
    }

    public static void e(Map<sx4, Integer> map, sx4 sx4Var) {
        Integer num = map.get(sx4Var);
        map.put(sx4Var, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public static ht g(ht htVar, sx4 sx4Var, sx4 sx4Var2, sx4 sx4Var3, sx4 sx4Var4, int i, int i2) throws NotFoundException {
        float f = i - 0.5f;
        float f2 = i2 - 0.5f;
        return od2.b().c(htVar, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, sx4Var.c(), sx4Var.d(), sx4Var4.c(), sx4Var4.d(), sx4Var3.c(), sx4Var3.d(), sx4Var2.c(), sx4Var2.d());
    }

    public final sx4 a(sx4 sx4Var, sx4 sx4Var2, sx4 sx4Var3, sx4 sx4Var4, int i) {
        float f = i;
        float fD = d(sx4Var, sx4Var2) / f;
        float fD2 = d(sx4Var3, sx4Var4);
        sx4 sx4Var5 = new sx4(sx4Var4.c() + (((sx4Var4.c() - sx4Var3.c()) / fD2) * fD), sx4Var4.d() + (fD * ((sx4Var4.d() - sx4Var3.d()) / fD2)));
        float fD3 = d(sx4Var, sx4Var3) / f;
        float fD4 = d(sx4Var2, sx4Var4);
        sx4 sx4Var6 = new sx4(sx4Var4.c() + (((sx4Var4.c() - sx4Var2.c()) / fD4) * fD3), sx4Var4.d() + (fD3 * ((sx4Var4.d() - sx4Var2.d()) / fD4)));
        if (f(sx4Var5)) {
            return (f(sx4Var6) && Math.abs(h(sx4Var3, sx4Var5).c() - h(sx4Var2, sx4Var5).c()) > Math.abs(h(sx4Var3, sx4Var6).c() - h(sx4Var2, sx4Var6).c())) ? sx4Var6 : sx4Var5;
        }
        if (f(sx4Var6)) {
            return sx4Var6;
        }
        return null;
    }

    public final sx4 b(sx4 sx4Var, sx4 sx4Var2, sx4 sx4Var3, sx4 sx4Var4, int i, int i2) {
        float fD = d(sx4Var, sx4Var2) / i;
        float fD2 = d(sx4Var3, sx4Var4);
        sx4 sx4Var5 = new sx4(sx4Var4.c() + (((sx4Var4.c() - sx4Var3.c()) / fD2) * fD), sx4Var4.d() + (fD * ((sx4Var4.d() - sx4Var3.d()) / fD2)));
        float fD3 = d(sx4Var, sx4Var3) / i2;
        float fD4 = d(sx4Var2, sx4Var4);
        sx4 sx4Var6 = new sx4(sx4Var4.c() + (((sx4Var4.c() - sx4Var2.c()) / fD4) * fD3), sx4Var4.d() + (fD3 * ((sx4Var4.d() - sx4Var2.d()) / fD4)));
        if (f(sx4Var5)) {
            return (f(sx4Var6) && Math.abs(i - h(sx4Var3, sx4Var5).c()) + Math.abs(i2 - h(sx4Var2, sx4Var5).c()) > Math.abs(i - h(sx4Var3, sx4Var6).c()) + Math.abs(i2 - h(sx4Var2, sx4Var6).c())) ? sx4Var6 : sx4Var5;
        }
        if (f(sx4Var6)) {
            return sx4Var6;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public qb1 c() throws NotFoundException {
        sx4 sx4Var;
        ht htVarG;
        sx4[] sx4VarArrC = this.b.c();
        sx4 sx4Var2 = sx4VarArrC[0];
        sx4 sx4Var3 = sx4VarArrC[1];
        sx4 sx4Var4 = sx4VarArrC[2];
        sx4 sx4Var5 = sx4VarArrC[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(h(sx4Var2, sx4Var3));
        arrayList.add(h(sx4Var2, sx4Var4));
        arrayList.add(h(sx4Var3, sx4Var5));
        arrayList.add(h(sx4Var4, sx4Var5));
        sx4 sx4Var6 = null;
        Collections.sort(arrayList, new c());
        b bVar = (b) arrayList.get(0);
        b bVar2 = (b) arrayList.get(1);
        HashMap map = new HashMap();
        e(map, bVar.a());
        e(map, bVar.b());
        e(map, bVar2.a());
        e(map, bVar2.b());
        sx4 sx4Var7 = null;
        sx4 sx4Var8 = null;
        for (Map.Entry entry : map.entrySet()) {
            sx4 sx4Var9 = (sx4) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                sx4Var7 = sx4Var9;
            } else if (sx4Var6 == null) {
                sx4Var6 = sx4Var9;
            } else {
                sx4Var8 = sx4Var9;
            }
        }
        if (sx4Var6 == null || sx4Var7 == null || sx4Var8 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        sx4[] sx4VarArr = {sx4Var6, sx4Var7, sx4Var8};
        sx4.e(sx4VarArr);
        sx4 sx4Var10 = sx4VarArr[0];
        sx4 sx4Var11 = sx4VarArr[1];
        sx4 sx4Var12 = sx4VarArr[2];
        sx4 sx4Var13 = !map.containsKey(sx4Var2) ? sx4Var2 : !map.containsKey(sx4Var3) ? sx4Var3 : !map.containsKey(sx4Var4) ? sx4Var4 : sx4Var5;
        int iC = h(sx4Var12, sx4Var13).c();
        int iC2 = h(sx4Var10, sx4Var13).c();
        if ((iC & 1) == 1) {
            iC++;
        }
        int i = iC + 2;
        if ((iC2 & 1) == 1) {
            iC2++;
        }
        int i2 = iC2 + 2;
        if (i * 4 >= i2 * 7 || i2 * 4 >= i * 7) {
            sx4Var = sx4Var12;
            sx4 sx4VarB = b(sx4Var11, sx4Var10, sx4Var12, sx4Var13, i, i2);
            if (sx4VarB != null) {
                sx4Var13 = sx4VarB;
            }
            int iC3 = h(sx4Var, sx4Var13).c();
            int iC4 = h(sx4Var10, sx4Var13).c();
            if ((iC3 & 1) == 1) {
                iC3++;
            }
            int i3 = iC3;
            if ((iC4 & 1) == 1) {
                iC4++;
            }
            htVarG = g(this.f19477a, sx4Var, sx4Var11, sx4Var10, sx4Var13, i3, iC4);
        } else {
            sx4 sx4VarA = a(sx4Var11, sx4Var10, sx4Var12, sx4Var13, Math.min(i2, i));
            if (sx4VarA != null) {
                sx4Var13 = sx4VarA;
            }
            int iMax = Math.max(h(sx4Var12, sx4Var13).c(), h(sx4Var10, sx4Var13).c()) + 1;
            if ((iMax & 1) == 1) {
                iMax++;
            }
            int i4 = iMax;
            htVarG = g(this.f19477a, sx4Var12, sx4Var11, sx4Var10, sx4Var13, i4, i4);
            sx4Var = sx4Var12;
        }
        return new qb1(htVarG, new sx4[]{sx4Var, sx4Var11, sx4Var10, sx4Var13});
    }

    public final boolean f(sx4 sx4Var) {
        return sx4Var.c() >= 0.0f && sx4Var.c() < ((float) this.f19477a.k()) && sx4Var.d() > 0.0f && sx4Var.d() < ((float) this.f19477a.h());
    }

    public final b h(sx4 sx4Var, sx4 sx4Var2) {
        int iC = (int) sx4Var.c();
        int iD = (int) sx4Var.d();
        int iC2 = (int) sx4Var2.c();
        int iD2 = (int) sx4Var2.d();
        int i = 0;
        boolean z = Math.abs(iD2 - iD) > Math.abs(iC2 - iC);
        if (z) {
            iD = iC;
            iC = iD;
            iD2 = iC2;
            iC2 = iD2;
        }
        int iAbs = Math.abs(iC2 - iC);
        int iAbs2 = Math.abs(iD2 - iD);
        int i2 = (-iAbs) / 2;
        int i3 = iD < iD2 ? 1 : -1;
        int i4 = iC >= iC2 ? -1 : 1;
        boolean zE = this.f19477a.e(z ? iD : iC, z ? iC : iD);
        while (iC != iC2) {
            boolean zE2 = this.f19477a.e(z ? iD : iC, z ? iC : iD);
            if (zE2 != zE) {
                i++;
                zE = zE2;
            }
            i2 += iAbs2;
            if (i2 > 0) {
                if (iD == iD2) {
                    break;
                }
                iD += i3;
                i2 -= iAbs;
            }
            iC += i4;
        }
        return new b(sx4Var, sx4Var2, i);
    }
}
