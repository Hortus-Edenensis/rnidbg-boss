package com.amap.api.col.p0002sl;

import android.os.SystemClock;
import com.amap.api.col.p0002sl.jk;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class jh extends jg {
    public jh() {
        super(2048);
    }

    private static void b(List<kr> list) {
        for (kr krVar : list) {
            krVar.g = kg.b(krVar.f2946a);
        }
    }

    public final byte[] a(kq kqVar, jk.a aVar, long j, List<kr> list) {
        List<kk> list2;
        super.a();
        try {
            int iA = a(kqVar);
            int iA2 = -1;
            int iA3 = (aVar == null || (list2 = aVar.f) == null || list2.size() <= 0) ? -1 : a(aVar);
            if (list != null && list.size() > 0) {
                iA2 = a(j, list);
            }
            jp.a(this.f2929a);
            jp.a(this.f2929a, iA);
            if (iA3 > 0) {
                jp.c(this.f2929a, iA3);
            }
            if (iA2 > 0) {
                jp.b(this.f2929a, iA2);
            }
            this.f2929a.c(jp.b(this.f2929a));
            return this.f2929a.c();
        } catch (Throwable th) {
            ku.a(th);
            return null;
        }
    }

    private int a(kq kqVar) {
        return jw.a(this.f2929a, kqVar.c, kqVar.k, (int) (kqVar.e * 1000000.0d), (int) (kqVar.d * 1000000.0d), (int) kqVar.f, (int) kqVar.i, (int) kqVar.g, (short) kqVar.h, kqVar.l);
    }

    private int a(jk.a aVar) {
        int iA;
        int i;
        int i2;
        byte b;
        int iA2;
        int iA3;
        int iA4;
        a(aVar.f);
        int size = aVar.f.size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            kk kkVar = aVar.f.get(i3);
            if (kkVar instanceof km) {
                km kmVar = (km) kkVar;
                if (!kmVar.i) {
                    iA4 = jx.a(this.f2929a, kmVar.j, kmVar.k, kmVar.c, kmVar.l);
                } else {
                    iA4 = jx.a(this.f2929a, kmVar.b(), kmVar.c(), kmVar.j, kmVar.k, kmVar.c, kmVar.m, kmVar.n, kmVar.d, kmVar.l);
                }
                iA2 = iA4;
                i2 = -1;
                b = 1;
            } else if (kkVar instanceof kn) {
                kn knVar = (kn) kkVar;
                iA2 = jy.a(this.f2929a, knVar.b(), knVar.c(), knVar.j, knVar.k, knVar.l, knVar.c, knVar.m, knVar.d);
                i2 = -1;
                b = 3;
            } else if (kkVar instanceof kl) {
                kl klVar = (kl) kkVar;
                if (!klVar.i) {
                    iA3 = jr.a(this.f2929a, klVar.j, klVar.k, klVar.l, klVar.m, klVar.n, klVar.c);
                } else {
                    iA3 = jr.a(this.f2929a, klVar.j, klVar.k, klVar.l, klVar.m, klVar.n, klVar.c, klVar.d);
                }
                iA2 = iA3;
                i2 = -1;
                b = 2;
            } else if (kkVar instanceof ko) {
                ko koVar = (ko) kkVar;
                iA2 = kb.a(this.f2929a, koVar.b(), koVar.c(), koVar.j, koVar.k, koVar.l, koVar.c, koVar.m, koVar.d);
                i2 = -1;
                b = 4;
            } else {
                i2 = -1;
                b = 0;
                iA2 = -1;
            }
            if (iA2 == i2) {
                return i2;
            }
            iArr[i3] = ju.a(this.f2929a, kkVar.h ? (byte) 1 : (byte) 0, kkVar.i ? (byte) 1 : (byte) 0, (short) kkVar.g, b, iA2);
        }
        int iA5 = this.f2929a.a(aVar.b);
        int iA6 = js.a(this.f2929a, iArr);
        int size2 = aVar.g.size();
        int[] iArr2 = new int[size2];
        for (int i4 = 0; i4 < size2; i4++) {
            kk kkVar2 = aVar.g.get(i4);
            long jElapsedRealtime = (SystemClock.elapsedRealtime() - kkVar2.e) / 1000;
            if (jElapsedRealtime > 32767 || jElapsedRealtime < 0) {
                jElapsedRealtime = 32767;
            }
            if (kkVar2 instanceof km) {
                km kmVar2 = (km) kkVar2;
                iA = ka.a(this.f2929a, kmVar2.j, kmVar2.k, (short) jElapsedRealtime);
            } else if (kkVar2 instanceof kn) {
                kn knVar2 = (kn) kkVar2;
                iA = ka.a(this.f2929a, knVar2.j, knVar2.k, (short) jElapsedRealtime);
            } else {
                if (kkVar2 instanceof kl) {
                    kl klVar2 = (kl) kkVar2;
                    iA = jz.a(this.f2929a, klVar2.j, klVar2.k, klVar2.l, (short) jElapsedRealtime);
                    i = 2;
                } else if (kkVar2 instanceof ko) {
                    ko koVar2 = (ko) kkVar2;
                    iA = ka.a(this.f2929a, koVar2.j, koVar2.k, (short) jElapsedRealtime);
                } else {
                    iA = 0;
                    i = 0;
                }
                iArr2[i4] = jt.a(this.f2929a, (byte) i, iA);
            }
            i = 1;
            iArr2[i4] = jt.a(this.f2929a, (byte) i, iA);
        }
        return js.a(this.f2929a, iA5, aVar.f2931a, iA6, js.b(this.f2929a, iArr2));
    }

    private int a(long j, List<kr> list) {
        b(list);
        int size = list.size();
        if (size <= 0) {
            return -1;
        }
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            kr krVar = list.get(i);
            int iA = this.f2929a.a(krVar.b);
            long j2 = krVar.f2946a;
            iArr[i] = kd.a(this.f2929a, j2 == j && j2 != -1, j2, (short) krVar.c, iA, krVar.g, (short) krVar.d);
        }
        return kc.a(this.f2929a, kc.a(this.f2929a, iArr));
    }

    private static void a(List<kk> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (kk kkVar : list) {
            if (kkVar instanceof km) {
                km kmVar = (km) kkVar;
                kkVar.g = kg.a(kg.a(kmVar.j, kmVar.k));
            } else if (kkVar instanceof kn) {
                kn knVar = (kn) kkVar;
                kkVar.g = kg.a(kg.a(knVar.j, knVar.k));
            } else if (kkVar instanceof ko) {
                ko koVar = (ko) kkVar;
                kkVar.g = kg.a(kg.a(koVar.j, koVar.k));
            } else if (kkVar instanceof kl) {
                kl klVar = (kl) kkVar;
                kkVar.g = kg.a(kg.a(klVar.k, klVar.l));
            }
        }
    }
}
