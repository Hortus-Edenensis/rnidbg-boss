package defpackage;

import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class es {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f17348a;
    public final Map<Integer, Long> b;
    public final Map<List<Pair<String, Integer>>, cs> c;
    public final Random d;

    public es() {
        this(new Random());
    }

    public static <T> void b(T t, long j, Map<T, Long> map) {
        if (map.containsKey(t)) {
            j = Math.max(j, ((Long) g86.j(map.get(t))).longValue());
        }
        map.put(t, Long.valueOf(j));
    }

    public static int d(cs csVar, cs csVar2) {
        int iCompare = Integer.compare(csVar.c, csVar2.c);
        return iCompare != 0 ? iCompare : csVar.b.compareTo(csVar2.b);
    }

    public static int f(List<cs> list) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            hashSet.add(Integer.valueOf(list.get(i).c));
        }
        return hashSet.size();
    }

    public static <T> void h(long j, Map<T, Long> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<T, Long> entry : map.entrySet()) {
            if (entry.getValue().longValue() <= j) {
                arrayList.add(entry.getKey());
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            map.remove(arrayList.get(i));
        }
    }

    public final List<cs> c(List<cs> list) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        h(jElapsedRealtime, this.f17348a);
        h(jElapsedRealtime, this.b);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            cs csVar = list.get(i);
            if (!this.f17348a.containsKey(csVar.b) && !this.b.containsKey(Integer.valueOf(csVar.c))) {
                arrayList.add(csVar);
            }
        }
        return arrayList;
    }

    public void e(cs csVar, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() + j;
        b(csVar.b, jElapsedRealtime, this.f17348a);
        int i = csVar.c;
        if (i != Integer.MIN_VALUE) {
            b(Integer.valueOf(i), jElapsedRealtime, this.b);
        }
    }

    public int g(List<cs> list) {
        HashSet hashSet = new HashSet();
        List<cs> listC = c(list);
        for (int i = 0; i < listC.size(); i++) {
            hashSet.add(Integer.valueOf(listC.get(i).c));
        }
        return hashSet.size();
    }

    public void i() {
        this.f17348a.clear();
        this.b.clear();
        this.c.clear();
    }

    @Nullable
    public cs j(List<cs> list) {
        List<cs> listC = c(list);
        if (listC.size() < 2) {
            return (cs) bv2.f(listC, null);
        }
        Collections.sort(listC, new Comparator() { // from class: ds
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return es.d((cs) obj, (cs) obj2);
            }
        });
        ArrayList arrayList = new ArrayList();
        int i = listC.get(0).c;
        int i2 = 0;
        while (true) {
            if (i2 >= listC.size()) {
                break;
            }
            cs csVar = listC.get(i2);
            if (i == csVar.c) {
                arrayList.add(new Pair(csVar.b, Integer.valueOf(csVar.d)));
                i2++;
            } else if (arrayList.size() == 1) {
                return listC.get(0);
            }
        }
        cs csVar2 = this.c.get(arrayList);
        if (csVar2 != null) {
            return csVar2;
        }
        cs csVarK = k(listC.subList(0, arrayList.size()));
        this.c.put(arrayList, csVarK);
        return csVarK;
    }

    public final cs k(List<cs> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            i += list.get(i2).d;
        }
        int iNextInt = this.d.nextInt(i);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            cs csVar = list.get(i4);
            i3 += csVar.d;
            if (iNextInt < i3) {
                return csVar;
            }
        }
        return (cs) bv2.g(list);
    }

    @VisibleForTesting
    public es(Random random) {
        this.c = new HashMap();
        this.d = random;
        this.f17348a = new HashMap();
        this.b = new HashMap();
    }
}
