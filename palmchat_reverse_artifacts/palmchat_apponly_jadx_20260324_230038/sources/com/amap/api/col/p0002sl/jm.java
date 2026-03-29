package com.amap.api.col.p0002sl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class jm {
    private kq b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<kr> f2934a = new ArrayList();
    private ArrayList<kr> c = new ArrayList<>();

    private boolean b(kq kqVar, List<kr> list, boolean z, long j, long j2) {
        if (!z || !a(kqVar, j, j2) || list == null || list.size() <= 0) {
            return false;
        }
        if (this.b == null) {
            return true;
        }
        boolean zA = a(kqVar);
        return !zA ? true ^ a(list, this.f2934a) : zA;
    }

    public final List<kr> a(kq kqVar, List<kr> list, boolean z, long j, long j2) {
        if (!b(kqVar, list, z, j, j2)) {
            return null;
        }
        b(this.c, list);
        this.f2934a.clear();
        this.f2934a.addAll(list);
        this.b = kqVar;
        return this.c;
    }

    private void b(List<kr> list, List<kr> list2) {
        list.clear();
        if (list2 != null) {
            List<kr> listB = b(a(list2));
            int size = listB.size();
            if (size > 40) {
                size = 40;
            }
            for (int i = 0; i < size; i++) {
                list.add(listB.get(i));
            }
        }
    }

    private static boolean a(kq kqVar, long j, long j2) {
        return j > 0 && j2 - j < ((long) ((kqVar.g > 10.0f ? 1 : (kqVar.g == 10.0f ? 0 : -1)) >= 0 ? 2000 : 3500));
    }

    private boolean a(kq kqVar) {
        float f = kqVar.g;
        float f2 = 10.0f;
        if (f > 10.0f) {
            f2 = 200.0f;
        } else if (f > 2.0f) {
            f2 = 50.0f;
        }
        return kqVar.a(this.b) > ((double) f2);
    }

    private static boolean a(List<kr> list, List<kr> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            int size2 = list2.size();
            int i = size + size2;
            if (size <= size2) {
                list2 = list;
                list = list2;
            }
            HashMap map = new HashMap(list.size());
            Iterator<kr> it = list.iterator();
            while (it.hasNext()) {
                map.put(Long.valueOf(it.next().f2946a), 1);
            }
            Iterator<kr> it2 = list2.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                if (((Integer) map.get(Long.valueOf(it2.next().f2946a))) != null) {
                    i2++;
                }
            }
            if (((double) i2) * 2.0d >= ((double) i) * 0.5d) {
                return true;
            }
        }
        return false;
    }

    private List<kr> b(List<kr> list) {
        Collections.sort(list, new Comparator<kr>() { // from class: com.amap.api.col.2sl.jm.1
            private static int a(kr krVar, kr krVar2) {
                return krVar2.c - krVar.c;
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(kr krVar, kr krVar2) {
                return a(krVar, krVar2);
            }
        });
        return list;
    }

    private static List<kr> a(List<kr> list) {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            kr krVar = list.get(i);
            map.put(Integer.valueOf(krVar.c), krVar);
        }
        arrayList.addAll(map.values());
        return arrayList;
    }
}
