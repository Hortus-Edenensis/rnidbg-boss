package com.opos.mobad.cmn.func.adhandler;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.cmn.func.adhandler.a.h;
import com.opos.mobad.cmn.func.adhandler.a.i;
import com.opos.mobad.cmn.func.adhandler.a.j;
import com.opos.mobad.cmn.func.adhandler.a.k;
import com.opos.mobad.cmn.func.adhandler.a.l;
import com.opos.mobad.cmn.func.adhandler.a.m;
import com.opos.mobad.cmn.func.adhandler.b;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.cmn.service.pkginstall.c;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdItemData f8674a;
    public MaterialData b;
    public c.b c;
    public b.d d;
    public com.opos.mobad.service.e.b e;
    public com.opos.mobad.cmn.func.adhandler.a.e f;
    public List<com.opos.mobad.cmn.func.adhandler.a.e> g;
    private String h;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.opos.mobad.cmn.func.adhandler.a.e f8675a;
        public final List<com.opos.mobad.cmn.func.adhandler.a.e> b;

        public a(com.opos.mobad.cmn.func.adhandler.a.e eVar, List<com.opos.mobad.cmn.func.adhandler.a.e> list) {
            this.f8675a = eVar;
            this.b = list;
        }
    }

    private d(AdItemData adItemData, com.opos.mobad.cmn.func.adhandler.a.e eVar, List<com.opos.mobad.cmn.func.adhandler.a.e> list) {
        this.g = null;
        this.f8674a = adItemData;
        this.b = adItemData.i().get(0);
        this.f = eVar;
        this.g = list;
        this.h = g.d(adItemData.al());
    }

    public static int a(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 12;
            case 10:
                return 13;
            default:
                return 0;
        }
    }

    public AdItemData b() {
        return this.f8674a;
    }

    public MaterialData c() {
        return this.b;
    }

    public static int a(MaterialData materialData, com.opos.mobad.cmn.func.b.a aVar) {
        return a((aVar == com.opos.mobad.cmn.func.b.a.SHAKE || aVar == com.opos.mobad.cmn.func.b.a.CLICK_BT || aVar == com.opos.mobad.cmn.func.b.a.LIGHT_INTERACTIVE || aVar == com.opos.mobad.cmn.func.b.a.FORWARD || aVar == com.opos.mobad.cmn.func.b.a.TILT || aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_INTERSTITIAL_RETAIN || aVar == com.opos.mobad.cmn.func.b.a.OUT_COUPONS || aVar == com.opos.mobad.cmn.func.b.a.E_COMMERCE_DIALOG_BTN) ? materialData.d() : aVar == com.opos.mobad.cmn.func.b.a.NON_CLICK_BT ? materialData.G() : (aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_CLICK_BT || aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_SHAKE) ? materialData.S() : aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_NON_CLICK_BT ? materialData.T() : aVar == com.opos.mobad.cmn.func.b.a.VIDEO ? materialData.H() : 0);
    }

    private static a a(Context context, AdItemData adItemData, MaterialData materialData, int i) {
        return a(context, adItemData, materialData, i, null, null, null, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
    
        if (r5.F() == 2) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006e, code lost:
    
        if (r5.F() == 2) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
    
        r1 = com.opos.mobad.cmn.func.adhandler.a.b.b(r5.q());
        r3 = com.opos.mobad.cmn.func.adhandler.a.d.b(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007d, code lost:
    
        r3 = com.opos.mobad.cmn.func.adhandler.a.d.b(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a a(Context context, AdItemData adItemData, MaterialData materialData, int i, b.a aVar, com.opos.mobad.p.a aVar2, com.opos.mobad.p.c cVar, String str, String str2) {
        com.opos.mobad.cmn.func.adhandler.a.e eVarA;
        List<com.opos.mobad.cmn.func.adhandler.a.e> listA;
        com.opos.mobad.cmn.func.adhandler.a.e eVarA2;
        com.opos.mobad.cmn.func.adhandler.a.e eVarA3 = null;
        switch (i) {
            case 1:
                eVarA3 = com.opos.mobad.cmn.func.adhandler.a.b.a(materialData.q());
                eVarA = m.a(adItemData, materialData, aVar2, cVar, str);
                if (!TextUtils.isEmpty(materialData.ag())) {
                    com.opos.mobad.cmn.func.adhandler.a.a.a aVarA = com.opos.mobad.cmn.func.adhandler.a.b.a(materialData);
                    List<com.opos.mobad.cmn.func.adhandler.a.e> listA2 = a(eVarA3);
                    listA2.add(eVarA);
                    listA = listA2;
                    eVarA3 = aVarA;
                } else {
                    listA = a(eVarA);
                }
                break;
            case 2:
                if (!com.opos.cmn.an.h.d.a.d(context, materialData.i())) {
                    eVarA2 = (1 == materialData.I() || 3 == materialData.I()) ? h.a(materialData) : 2 == materialData.I() ? com.opos.mobad.cmn.func.adhandler.a.c.a(materialData, aVar) : j.a(materialData, adItemData.ag());
                    eVarA3 = eVarA2;
                    listA = null;
                }
                break;
            case 3:
                if (!com.opos.cmn.an.h.d.a.d(context, materialData.i())) {
                    eVarA2 = m.b(adItemData, materialData, aVar2, cVar, str);
                    eVarA3 = eVarA2;
                    listA = null;
                }
                break;
            case 4:
                eVarA2 = com.opos.mobad.cmn.func.adhandler.a.d.a(materialData);
                eVarA3 = eVarA2;
                listA = null;
                break;
            case 5:
                eVarA3 = com.opos.mobad.cmn.func.adhandler.a.b.c(materialData.q());
                eVarA = m.a(adItemData, materialData, aVar2, cVar, materialData.k());
                listA = a(eVarA);
                break;
            case 6:
                eVarA3 = com.opos.mobad.cmn.func.adhandler.a.f.a(adItemData, materialData);
                eVarA = m.a(adItemData, materialData, aVar2, cVar, str);
                listA = a(eVarA);
                break;
            case 7:
                eVarA3 = i.a(adItemData, materialData);
                eVarA = m.a(adItemData, materialData, aVar2, cVar, str);
                listA = a(eVarA);
                break;
            case 8:
                eVarA2 = l.a(adItemData);
                eVarA3 = eVarA2;
                listA = null;
                break;
            case 9:
                eVarA2 = com.opos.mobad.cmn.func.adhandler.a.g.a(adItemData, materialData, aVar2);
                eVarA3 = eVarA2;
                listA = null;
                break;
            case 10:
                eVarA2 = com.opos.mobad.cmn.func.adhandler.a.a.a(adItemData);
                eVarA3 = eVarA2;
                listA = null;
                break;
            case 11:
                eVarA2 = k.a(adItemData, materialData);
                eVarA3 = eVarA2;
                listA = null;
                break;
            default:
                listA = null;
                break;
        }
        com.opos.cmn.an.f.a.b("AdHandler_HandlerParams", "createActionData() actionData=", eVarA3);
        return new a(eVarA3, listA);
    }

    public static final d a(Context context, AdItemData adItemData, int i) {
        if (adItemData == null || adItemData.i() == null || adItemData.i().get(0) == null) {
            return null;
        }
        a aVarA = a(context, adItemData, adItemData.i().get(0), i);
        return new d(adItemData, aVarA.f8675a, aVarA.b);
    }

    public static final d a(Context context, AdItemData adItemData, int i, b.a aVar, com.opos.mobad.p.a aVar2, com.opos.mobad.p.c cVar, String str) {
        return a(context, adItemData, i, aVar, aVar2, cVar, str, "");
    }

    public static final d a(Context context, AdItemData adItemData, int i, b.a aVar, com.opos.mobad.p.a aVar2, com.opos.mobad.p.c cVar, String str, String str2) {
        if (adItemData == null || adItemData.i() == null || adItemData.i().get(0) == null) {
            return null;
        }
        a aVarA = a(context, adItemData, adItemData.i().get(0), i, aVar, aVar2, cVar, str, str2);
        return new d(adItemData, aVarA.f8675a, aVarA.b);
    }

    public static final d a(Context context, AdItemData adItemData, com.opos.mobad.cmn.func.b.a aVar, b.a aVar2, com.opos.mobad.p.a aVar3, com.opos.mobad.p.c cVar, String str, String str2) {
        if (adItemData == null || adItemData.i() == null || adItemData.i().get(0) == null) {
            return null;
        }
        return a(context, adItemData, a(adItemData.i().get(0), aVar), aVar2, aVar3, cVar, str, str2);
    }

    public d a(b.d dVar) {
        this.d = dVar;
        return this;
    }

    public d a(c.b bVar) {
        this.c = bVar;
        return this;
    }

    public d a(com.opos.mobad.service.e.b bVar) {
        this.e = bVar;
        return this;
    }

    public String a() {
        return this.h;
    }

    private static List<com.opos.mobad.cmn.func.adhandler.a.e> a(com.opos.mobad.cmn.func.adhandler.a.e eVar) {
        if (eVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        return arrayList;
    }
}
