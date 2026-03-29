package com.tencent.turingfd.sdk.ams.ad;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.private, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class Cprivate extends Eridanus implements Cloneable {
    public static Map<String, String> h = null;
    public static Map<Integer, Integer> i = null;
    public static Map<String, String> j = null;
    public static final /* synthetic */ boolean k = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10767a = 0;
    public boolean b = true;
    public long c = 0;
    public Map<String, String> d = null;
    public Map<Integer, Integer> e = null;
    public long f = 0;
    public Map<String, String> g = null;

    static {
        HashMap map = new HashMap();
        h = map;
        map.put("", "");
        i = new HashMap();
        i.put(0, 0);
        HashMap map2 = new HashMap();
        j = map2;
        map2.put("", "");
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.Eridanus
    public void a(Draco draco) {
        draco.a(this.f10767a, 0);
        draco.a(this.b ? (byte) 1 : (byte) 0, 1);
        draco.a(this.c, 2);
        draco.a((Map) this.d, 3);
        draco.a((Map) this.e, 4);
        draco.a(this.f, 5);
        Map<String, String> map = this.g;
        if (map != null) {
            draco.a((Map) map, 6);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (k) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Cprivate cprivate = (Cprivate) obj;
        if (Equuleus.a(this.f10767a, cprivate.f10767a)) {
            return (this.b == cprivate.b) && Equuleus.a(this.c, cprivate.c) && this.d.equals(cprivate.d) && this.e.equals(cprivate.e) && Equuleus.a(this.f, cprivate.f) && this.g.equals(cprivate.g);
        }
        return false;
    }

    public int hashCode() {
        try {
            throw new Exception("");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.Eridanus
    public void a(Dorado dorado) {
        this.f10767a = dorado.a(this.f10767a, 0, true);
        this.b = dorado.a(this.b, 1, true);
        this.c = dorado.a(this.c, 2, true);
        this.d = (Map) dorado.a(h, 3, true);
        this.e = (Map) dorado.a(i, 4, true);
        this.f = dorado.a(this.f, 5, true);
        this.g = (Map) dorado.a(j, 6, false);
    }
}
