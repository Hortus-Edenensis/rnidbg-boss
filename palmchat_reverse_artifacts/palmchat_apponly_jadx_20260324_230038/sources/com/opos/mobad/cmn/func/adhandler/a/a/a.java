package com.opos.mobad.cmn.func.adhandler.a.a;

import android.content.Context;
import com.opos.cmn.i.f;
import com.opos.cmn.i.h;
import com.opos.mobad.cmn.func.adhandler.a.b;
import com.opos.mobad.cmn.func.adhandler.b;
import com.opos.mobad.cmn.func.adhandler.d;
import com.opos.mobad.cmn.func.b.e;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a extends b {
    private static String d = "AdHandler_InstallDeepLinkDataV2";
    public final String b;
    public final String c;

    public a(String str, String str2) {
        super(str);
        this.b = str2;
        this.c = f.a();
    }

    public void a(com.opos.mobad.b bVar, d dVar, b.InterfaceC0726b interfaceC0726b) {
        String str;
        String str2;
        com.opos.cmn.an.f.a.b(d, "handle() dpRequestId=", this.c);
        try {
            if (!a()) {
                a(interfaceC0726b, -1);
                com.opos.cmn.an.f.a.b(d, "handle() fail because data is invalid.");
                return;
            }
            if (a(bVar, dVar)) {
                a(interfaceC0726b, 1);
                str = d;
                str2 = "handle() success. DeepLinkUrl=" + this.f8648a;
            } else {
                a(interfaceC0726b, -3);
                str = d;
                str2 = "handle() fail because jump result is false.";
            }
            com.opos.cmn.an.f.a.b(str, str2);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d(d, "handle() fail", e);
            a(interfaceC0726b, -2);
        }
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 20;
    }

    private void a(b.InterfaceC0726b interfaceC0726b, int i) {
        if (interfaceC0726b != null) {
            interfaceC0726b.a(new b.c(b(), i));
        }
    }

    private boolean a(com.opos.mobad.b bVar, d dVar) {
        String str;
        String strG;
        String strC = "";
        Context contextB = bVar != null ? bVar.b() : null;
        HashMap map = new HashMap();
        boolean zA = false;
        try {
            strG = dVar.b().g();
        } catch (Exception e) {
            e = e;
            str = "";
        }
        try {
            strC = dVar.b().c();
            String strI = dVar.b.i();
            h.a(map, "dpUrl", this.f8648a);
            h.a(map, "dpToken", this.b);
            h.a(map, "reqId", strC);
            h.a(map, "appPackageName", strI);
            h.a(map, "dpRequestId", this.c);
            zA = com.opos.cmn.e.a.a().a(contextB, map);
            h.a(map, "dpResult", String.valueOf(zA));
        } catch (Exception e2) {
            e = e2;
            str = strC;
            strC = strG;
            com.opos.cmn.an.f.a.d(d, "executeDeeplink() fail", e);
            strG = strC;
            strC = str;
        }
        e.a(bVar, strG, strC, map);
        return zA;
    }
}
