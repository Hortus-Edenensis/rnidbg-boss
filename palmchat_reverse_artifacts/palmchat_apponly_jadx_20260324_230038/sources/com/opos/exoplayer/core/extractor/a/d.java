package com.opos.exoplayer.core.extractor.a;

import com.opos.exoplayer.core.m;
import com.opos.exoplayer.core.util.p;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class d extends b {
    private long b;

    public d() {
        super(null);
        this.b = -9223372036854775807L;
    }

    private static int b(p pVar) {
        return pVar.g();
    }

    private static Boolean c(p pVar) {
        return Boolean.valueOf(pVar.g() == 1);
    }

    private static Double d(p pVar) {
        return Double.valueOf(Double.longBitsToDouble(pVar.q()));
    }

    private static String e(p pVar) {
        int iH = pVar.h();
        int iD = pVar.d();
        pVar.d(iH);
        return new String(pVar.f8400a, iD, iH);
    }

    private static ArrayList<Object> f(p pVar) {
        int iU = pVar.u();
        ArrayList<Object> arrayList = new ArrayList<>(iU);
        for (int i = 0; i < iU; i++) {
            arrayList.add(a(pVar, b(pVar)));
        }
        return arrayList;
    }

    private static HashMap<String, Object> g(p pVar) {
        HashMap<String, Object> map = new HashMap<>();
        while (true) {
            String strE = e(pVar);
            int iB = b(pVar);
            if (iB == 9) {
                return map;
            }
            map.put(strE, a(pVar, iB));
        }
    }

    private static HashMap<String, Object> h(p pVar) {
        int iU = pVar.u();
        HashMap<String, Object> map = new HashMap<>(iU);
        for (int i = 0; i < iU; i++) {
            map.put(e(pVar), a(pVar, b(pVar)));
        }
        return map;
    }

    private static Date i(p pVar) {
        Date date = new Date((long) d(pVar).doubleValue());
        pVar.d(2);
        return date;
    }

    public long a() {
        return this.b;
    }

    private static Object a(p pVar, int i) {
        if (i == 8) {
            return h(pVar);
        }
        if (i == 10) {
            return f(pVar);
        }
        if (i == 11) {
            return i(pVar);
        }
        if (i == 0) {
            return d(pVar);
        }
        if (i == 1) {
            return c(pVar);
        }
        if (i == 2) {
            return e(pVar);
        }
        if (i != 3) {
            return null;
        }
        return g(pVar);
    }

    @Override // com.opos.exoplayer.core.extractor.a.b
    public void b(p pVar, long j) throws m {
        if (b(pVar) != 2) {
            throw new m();
        }
        if ("onMetaData".equals(e(pVar)) && b(pVar) == 8) {
            HashMap<String, Object> mapH = h(pVar);
            if (mapH.containsKey("duration")) {
                double dDoubleValue = ((Double) mapH.get("duration")).doubleValue();
                if (dDoubleValue > 0.0d) {
                    this.b = (long) (dDoubleValue * 1000000.0d);
                }
            }
        }
    }

    @Override // com.opos.exoplayer.core.extractor.a.b
    public boolean a(p pVar) {
        return true;
    }
}
