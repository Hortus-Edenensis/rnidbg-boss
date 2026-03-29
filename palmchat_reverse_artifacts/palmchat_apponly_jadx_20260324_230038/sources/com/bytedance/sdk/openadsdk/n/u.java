package com.bytedance.sdk.openadsdk.n;

import android.content.Context;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.sdk.component.iz.bg;
import com.bytedance.sdk.component.iz.c;
import com.bytedance.sdk.component.iz.fx.pn;
import com.bytedance.sdk.component.iz.iz;
import com.bytedance.sdk.component.iz.nr.b;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.s;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.gi.jk;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static Context getContext() {
        return dw.getContext();
    }

    public static c u(Context context, bg bgVar) {
        return com.bytedance.sdk.component.iz.fx.nr.u(context, bgVar);
    }

    public static bg u() {
        return new pn.u().u(new com.bytedance.sdk.component.iz.fx.u.u(Math.max(Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, BmLocated.ALIGN_RIGHT_BOTTOM), 5242880), 0, 41943040L, true, true, new File(jk.iz()))).u(x.u()).u(new com.bytedance.sdk.component.iz.pn() { // from class: com.bytedance.sdk.openadsdk.n.u.1
            private Map<String, String> u(iz izVar, my myVar) {
                HashMap map = new HashMap();
                if (izVar.nr()) {
                    com.bytedance.sdk.component.nr.u.iz izVarX = myVar.x();
                    int iU = izVarX.u();
                    for (int i = 0; i < iU; i++) {
                        String strU = izVarX.u(i);
                        String strNr = izVarX.nr(i);
                        if (strU != null) {
                            map.put(strU, strNr);
                        }
                    }
                }
                return map;
            }

            @Override // com.bytedance.sdk.component.iz.pn
            public b call(iz izVar) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                l lVarIz = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().iz();
                s sVarNr = new s.u().u(izVar.u()).u().u("csj_client_source_from", "2").nr();
                my myVar = null;
                com.bytedance.sdk.component.iz.nr.pn pnVar = izVar.fx() ? new com.bytedance.sdk.component.iz.nr.pn() : null;
                if (pnVar != null) {
                    pnVar.u(jCurrentTimeMillis);
                }
                try {
                    my myVarNr = lVarIz.u(sVarNr).nr();
                    if (pnVar != null) {
                        try {
                            pnVar.nr(System.currentTimeMillis());
                        } catch (Throwable th) {
                            th = th;
                            myVar = myVarNr;
                            try {
                                return u(pnVar, th);
                            } finally {
                                com.bytedance.sdk.component.iz.fx.fx.nr.u(myVar);
                            }
                        }
                    }
                    if (izVar.b() != null) {
                        izVar.b().onStep(3, null);
                    }
                    Map<String, String> mapU = u(izVar, myVarNr);
                    byte[] bArrB = myVarNr.iz().b();
                    mapU.put("image_size", String.valueOf(bArrB == null ? 0 : bArrB.length));
                    b bVar = new b(myVarNr.fx(), bArrB, "", mapU);
                    if (pnVar != null) {
                        pnVar.fx(System.currentTimeMillis());
                    }
                    bVar.u(pnVar);
                    com.bytedance.sdk.component.iz.fx.fx.nr.u(myVarNr);
                    return bVar;
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            private b u(com.bytedance.sdk.component.iz.nr.pn pnVar, Throwable th) {
                th.getMessage();
                if (pnVar != null) {
                    pnVar.fx(System.currentTimeMillis());
                }
                b bVar = new b(0, th, "net failed");
                bVar.u(pnVar);
                return bVar;
            }
        }).u();
    }
}
