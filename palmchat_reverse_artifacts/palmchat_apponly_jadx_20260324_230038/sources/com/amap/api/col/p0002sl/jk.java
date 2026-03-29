package com.amap.api.col.p0002sl;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class jk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private kk f2930a;
    private kk b;
    private kq c;
    private a d = new a();
    private final List<kk> e = new ArrayList(3);

    public final a a(kq kqVar, boolean z, byte b, String str, List<kk> list) {
        if (z) {
            this.d.a();
            return null;
        }
        this.d.a(b, str, list);
        if (this.d.c == null) {
            return null;
        }
        if (!(this.c == null || a(kqVar) || !a.a(this.d.d, this.f2930a) || !a.a(this.d.e, this.b))) {
            return null;
        }
        a aVar = this.d;
        this.f2930a = aVar.d;
        this.b = aVar.e;
        this.c = kqVar;
        kg.a(aVar.f);
        a(this.d);
        return this.d;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte f2931a;
        public String b;
        public kk c;
        public kk d;
        public kk e;
        public List<kk> f = new ArrayList();
        public List<kk> g = new ArrayList();

        public final void a() {
            this.f2931a = (byte) 0;
            this.b = "";
            this.c = null;
            this.d = null;
            this.e = null;
            this.f.clear();
            this.g.clear();
        }

        public final String toString() {
            return "CellInfo{radio=" + ((int) this.f2931a) + ", operator='" + this.b + "', mainCell=" + this.c + ", mainOldInterCell=" + this.d + ", mainNewInterCell=" + this.e + ", cells=" + this.f + ", historyMainCellList=" + this.g + '}';
        }

        public final void a(byte b, String str, List<kk> list) {
            a();
            this.f2931a = b;
            this.b = str;
            if (list != null) {
                this.f.addAll(list);
                for (kk kkVar : this.f) {
                    boolean z = kkVar.i;
                    if (!z && kkVar.h) {
                        this.d = kkVar;
                    } else if (z && kkVar.h) {
                        this.e = kkVar;
                    }
                }
            }
            kk kkVar2 = this.d;
            if (kkVar2 == null) {
                kkVar2 = this.e;
            }
            this.c = kkVar2;
        }

        public static boolean a(kk kkVar, kk kkVar2) {
            if (kkVar == null || kkVar2 == null) {
                return (kkVar == null) == (kkVar2 == null);
            }
            if ((kkVar instanceof km) && (kkVar2 instanceof km)) {
                km kmVar = (km) kkVar;
                km kmVar2 = (km) kkVar2;
                return kmVar.j == kmVar2.j && kmVar.k == kmVar2.k;
            }
            if ((kkVar instanceof kl) && (kkVar2 instanceof kl)) {
                kl klVar = (kl) kkVar;
                kl klVar2 = (kl) kkVar2;
                return klVar.l == klVar2.l && klVar.k == klVar2.k && klVar.j == klVar2.j;
            }
            if ((kkVar instanceof kn) && (kkVar2 instanceof kn)) {
                kn knVar = (kn) kkVar;
                kn knVar2 = (kn) kkVar2;
                return knVar.j == knVar2.j && knVar.k == knVar2.k;
            }
            if ((kkVar instanceof ko) && (kkVar2 instanceof ko)) {
                ko koVar = (ko) kkVar;
                ko koVar2 = (ko) kkVar2;
                if (koVar.j == koVar2.j && koVar.k == koVar2.k) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean a(kq kqVar) {
        float f = kqVar.g;
        return kqVar.a(this.c) > ((double) ((f > 10.0f ? 1 : (f == 10.0f ? 0 : -1)) > 0 ? 2000.0f : (f > 2.0f ? 1 : (f == 2.0f ? 0 : -1)) > 0 ? 500.0f : 100.0f));
    }

    private void a(a aVar) {
        synchronized (this.e) {
            for (kk kkVar : aVar.f) {
                if (kkVar != null && kkVar.h) {
                    kk kkVarClone = kkVar.clone();
                    kkVarClone.e = SystemClock.elapsedRealtime();
                    a(kkVarClone);
                }
            }
            this.d.g.clear();
            this.d.g.addAll(this.e);
        }
    }

    private void a(kk kkVar) {
        if (kkVar == null) {
            return;
        }
        int size = this.e.size();
        if (size == 0) {
            this.e.add(kkVar);
            return;
        }
        int i = -1;
        long jMin = Long.MAX_VALUE;
        int i2 = 0;
        int i3 = -1;
        while (true) {
            if (i2 >= size) {
                i = i3;
                break;
            }
            kk kkVar2 = this.e.get(i2);
            if (kkVar.equals(kkVar2)) {
                int i4 = kkVar.c;
                if (i4 != kkVar2.c) {
                    kkVar2.e = i4;
                    kkVar2.c = i4;
                }
            } else {
                jMin = Math.min(jMin, kkVar2.e);
                if (jMin == kkVar2.e) {
                    i3 = i2;
                }
                i2++;
            }
        }
        if (i >= 0) {
            if (size < 3) {
                this.e.add(kkVar);
            } else {
                if (kkVar.e <= jMin || i >= size) {
                    return;
                }
                this.e.remove(i);
                this.e.add(kkVar);
            }
        }
    }
}
