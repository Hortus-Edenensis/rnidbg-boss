package com.amap.api.col.p0002sl;

import com.amap.api.col.p0002sl.eh;
import com.amap.api.services.core.LatLonPoint;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class ej extends ei {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f2728a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        LatLonPoint f2729a;
        double b;

        public a(double d, double d2, double d3) {
            this.f2729a = null;
            this.b = 0.0d;
            this.f2729a = new LatLonPoint(d, d2);
            this.b = d3;
        }

        public final boolean a(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                LatLonPoint latLonPoint = this.f2729a;
                a aVar = (a) obj;
                if (latLonPoint == aVar.f2729a) {
                    return true;
                }
                if (latLonPoint != null && di.a(latLonPoint, r3) <= aVar.b) {
                    return true;
                }
            }
            return false;
        }
    }

    public ej(String... strArr) {
        super(strArr);
        this.f2728a = 0.0d;
    }

    @Override // com.amap.api.col.p0002sl.ei
    public final boolean a(LinkedHashMap<eh.b, Object> linkedHashMap, eh.b bVar) {
        String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.b == null) {
                return super.a(linkedHashMap, bVar);
            }
            for (eh.b bVar2 : linkedHashMap.keySet()) {
                if (bVar2 != null && (str = bVar2.f2725a) != null && str.equals(bVar.f2725a)) {
                    Object obj = bVar2.b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.amap.api.col.p0002sl.ei
    public final Object b(LinkedHashMap<eh.b, Object> linkedHashMap, eh.b bVar) {
        String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.b == null) {
                return super.b(linkedHashMap, bVar);
            }
            for (eh.b bVar2 : linkedHashMap.keySet()) {
                if (bVar2 != null && (str = bVar2.f2725a) != null && str.equals(bVar.f2725a)) {
                    Object obj = bVar2.b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.b)) {
                        return linkedHashMap.get(bVar2);
                    }
                }
            }
        }
        return null;
    }

    @Override // com.amap.api.col.p0002sl.ei
    public final Object c(LinkedHashMap<eh.b, Object> linkedHashMap, eh.b bVar) {
        eh.b next;
        String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.b == null) {
                return super.c(linkedHashMap, bVar);
            }
            Iterator<eh.b> it = linkedHashMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next != null && (str = next.f2725a) != null && str.equals(bVar.f2725a)) {
                    Object obj = next.b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.b)) {
                        break;
                    }
                }
            }
            if (next != null) {
                return linkedHashMap.remove(next);
            }
        }
        return null;
    }

    public final double a() {
        return this.f2728a;
    }

    @Override // com.amap.api.col.p0002sl.ei
    public final void a(eh.a aVar) {
        super.a(aVar);
        if (aVar != null) {
            this.f2728a = aVar.d();
        }
    }
}
