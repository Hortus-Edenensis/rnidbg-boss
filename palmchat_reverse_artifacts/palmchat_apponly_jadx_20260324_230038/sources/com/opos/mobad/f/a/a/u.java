package com.opos.mobad.f.a.a;

import com.opos.mobad.c.a.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<Integer, d.a> f8825a = new HashMap<>();

    public u(List<d.a> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (d.a aVar : list) {
            this.f8825a.put(Integer.valueOf(aVar.f), aVar);
        }
    }

    private <T extends com.opos.mobad.ad.j> int a(int i, T t) {
        if (i == d.a.f8585a) {
            return t.e();
        }
        int iE = t.e();
        if (iE > 0) {
            return iE;
        }
        com.opos.cmn.an.f.a.b("NativeBiddingDispatchController", "bidding channel:" + i + "real fail, use default");
        d.a aVar = this.f8825a.get(Integer.valueOf(i));
        return aVar != null ? aVar.l : iE;
    }

    public <T extends com.opos.mobad.ad.j> d.a a(HashMap<Integer, List<T>> map) {
        List<T> value;
        T t;
        if (map != null && map.size() > 0) {
            int iIntValue = -1;
            int i = 0;
            for (Map.Entry<Integer, List<T>> entry : map.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null && value.size() > 0 && (t = value.get(0)) != null) {
                    int iA = a(entry.getKey().intValue(), t);
                    if (iA <= 0 && entry.getKey().intValue() != d.a.f8585a) {
                        com.opos.cmn.an.f.a.b("NativeBiddingDispatchController", "biding with fail result" + entry.getKey());
                        return null;
                    }
                    if (i > iA) {
                        com.opos.cmn.an.f.a.b("NativeBiddingDispatchController", "biding fail by compare:" + entry.getKey());
                    } else if (i != iA) {
                        iIntValue = entry.getKey().intValue();
                        i = iA;
                    } else if (entry.getKey().intValue() == d.a.f8585a) {
                        iIntValue = entry.getKey().intValue();
                    }
                }
            }
            com.opos.cmn.an.f.a.b("NativeBiddingDispatchController", "biding result:" + iIntValue);
            if (iIntValue != -1) {
                a(iIntValue, map);
                return this.f8825a.get(Integer.valueOf(iIntValue));
            }
        }
        return null;
    }

    public <T extends com.opos.mobad.ad.j> void a(int i, HashMap<Integer, List<T>> map) {
        List<T> value;
        for (Map.Entry<Integer, List<T>> entry : map.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && value.size() > 0) {
                if (i == entry.getKey().intValue()) {
                    com.opos.cmn.an.f.a.b("NativeBiddingDispatchController", "notify win " + i);
                    a(value);
                } else {
                    com.opos.cmn.an.f.a.b("NativeBiddingDispatchController", "notify loss " + entry.getKey() + ":1");
                    a(value, 1);
                }
            }
        }
    }

    private <T extends com.opos.mobad.ad.j> void a(List<T> list) {
        for (T t : list) {
            if (t != null) {
                t.b(0);
            }
        }
    }

    private <T extends com.opos.mobad.ad.j> void a(List<T> list, int i) {
        for (T t : list) {
            if (t != null) {
                t.a(i, null, 0);
            }
        }
    }
}
