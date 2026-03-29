package com.opos.mobad.f.a;

import com.opos.mobad.c.a.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class h {
    private static int a(int i, float f) {
        com.opos.cmn.an.f.a.b("PriceCalculateTool", "getChannelPrice:" + i + "*" + f);
        return (int) (i * f);
    }

    public static int a(int i, com.opos.mobad.ad.b bVar, d.a aVar) {
        if (bVar == null) {
            com.opos.cmn.an.f.a.b("PriceCalculateTool", "ad is null");
            return -103;
        }
        if (i != d.a.f8585a && i != 1001) {
            if (aVar != null) {
                return a(bVar.f(), aVar);
            }
            com.opos.cmn.an.f.a.b("PriceCalculateTool", "entity is null");
            return -104;
        }
        com.opos.cmn.an.f.a.b("PriceCalculateTool", "channel union return price:" + bVar.f());
        return bVar.f();
    }

    public static int a(int i, com.opos.mobad.ad.e.h hVar, d.a aVar) {
        if (hVar == null) {
            com.opos.cmn.an.f.a.b("PriceCalculateTool", "ad is null");
            return -103;
        }
        if (i != d.a.f8585a && i != 1001) {
            if (aVar != null) {
                return a(hVar.f(), aVar);
            }
            com.opos.cmn.an.f.a.b("PriceCalculateTool", "entity is null");
            return -104;
        }
        com.opos.cmn.an.f.a.b("PriceCalculateTool", "channel union return price:" + hVar.f());
        return hVar.f();
    }

    private static int a(int i, d.a aVar) {
        int i2 = aVar.f;
        if (i2 == d.a.f8585a || i2 == 1001) {
            com.opos.cmn.an.f.a.b("PriceCalculateTool", "channel union return price:" + i);
            return i;
        }
        if (i > 0) {
            return a(i, aVar.a());
        }
        int i3 = aVar.l;
        if (i3 > 0) {
            return a(i3, aVar.a());
        }
        com.opos.cmn.an.f.a.b("PriceCalculateTool", "entity.ecpm:" + aVar.l);
        return -105;
    }

    public static int a(com.opos.mobad.ad.b bVar, d.a aVar) {
        if (bVar == null) {
            com.opos.cmn.an.f.a.b("PriceCalculateTool", "ad is null");
            return -103;
        }
        if (aVar != null) {
            return a(bVar.f(), aVar);
        }
        com.opos.cmn.an.f.a.b("PriceCalculateTool", "entity is null");
        return -104;
    }

    public static int a(com.opos.mobad.ad.e.p pVar, d.a aVar) {
        if (pVar == null || aVar == null) {
            return 0;
        }
        return a(pVar.f(), aVar);
    }
}
