package com.amap.api.col.p0002sl;

import androidx.media3.muxer.MuxerUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class kg {

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements ke {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2941a;
        private int b;
        private int c;

        public a(int i, int i2, int i3) {
            this.f2941a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // com.amap.api.col.p0002sl.ke
        public final long a() {
            return kg.a(this.f2941a, this.b);
        }

        @Override // com.amap.api.col.p0002sl.ke
        public final int b() {
            return this.c;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements ke {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f2942a;
        private int b;

        public b(long j, int i) {
            this.f2942a = j;
            this.b = i;
        }

        @Override // com.amap.api.col.p0002sl.ke
        public final long a() {
            return this.f2942a;
        }

        @Override // com.amap.api.col.p0002sl.ke
        public final int b() {
            return this.b;
        }
    }

    public static long a(int i, int i2) {
        return (((long) i2) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | ((((long) i) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) << 32);
    }

    public static synchronized void b(List<kr> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                ArrayList arrayList = new ArrayList(list.size());
                for (kr krVar : list) {
                    arrayList.add(new b(krVar.f2946a, krVar.c));
                }
                kf.a().b(arrayList);
            }
        }
    }

    public static synchronized void a(List<kk> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                ArrayList arrayList = new ArrayList(list.size());
                for (kk kkVar : list) {
                    if (kkVar instanceof km) {
                        km kmVar = (km) kkVar;
                        arrayList.add(new a(kmVar.j, kmVar.k, kmVar.c));
                    } else if (kkVar instanceof kn) {
                        kn knVar = (kn) kkVar;
                        arrayList.add(new a(knVar.j, knVar.k, knVar.c));
                    } else if (kkVar instanceof ko) {
                        ko koVar = (ko) kkVar;
                        arrayList.add(new a(koVar.j, koVar.k, koVar.c));
                    } else if (kkVar instanceof kl) {
                        kl klVar = (kl) kkVar;
                        arrayList.add(new a(klVar.k, klVar.l, klVar.c));
                    }
                }
                kf.a().a(arrayList);
            }
        }
    }

    public static synchronized short b(long j) {
        return kf.a().b(j);
    }

    public static synchronized short a(long j) {
        return kf.a().a(j);
    }
}
