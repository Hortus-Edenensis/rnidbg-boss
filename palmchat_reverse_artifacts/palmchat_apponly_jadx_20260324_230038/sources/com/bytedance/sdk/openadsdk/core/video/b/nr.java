package com.bytedance.sdk.openadsdk.core.video.b;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bykv.vk.openvk.component.video.api.pn.u;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.bf;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.rh.a;
import com.bytedance.sdk.openadsdk.core.rh.fx;
import com.bytedance.sdk.openadsdk.core.rh.n;
import com.bytedance.sdk.openadsdk.core.rh.s;
import com.bytedance.sdk.openadsdk.core.rh.t;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.gi.x;
import com.bytedance.sdk.openadsdk.iz.fx.jk;
import com.bytedance.sdk.openadsdk.iz.fx.l;
import com.bytedance.sdk.openadsdk.iz.fx.mv;
import com.bytedance.sdk.openadsdk.iz.nr.b;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static volatile com.bykv.vk.openvk.component.video.api.pn.u nr;
    private static volatile com.bykv.vk.openvk.component.video.api.pn.u u;

    private static void b(final iz izVar, final u.InterfaceC0155u interfaceC0155u, final bc bcVar) {
        izVar.iz(6000);
        izVar.x(6000);
        izVar.n(6000);
        if (bcVar != null) {
            if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar)) {
                return;
            }
            if (izVar.fx() == 400) {
                fx(izVar, bcVar);
                return;
            }
            nr(izVar, bcVar);
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        u.InterfaceC0155u interfaceC0155u2 = new u.InterfaceC0155u() { // from class: com.bytedance.sdk.openadsdk.core.video.b.nr.3
            @Override // com.bykv.vk.openvk.component.video.api.pn.u.InterfaceC0155u
            public void nr(iz izVar2, int i) {
                u.InterfaceC0155u interfaceC0155u3 = interfaceC0155u;
                if (interfaceC0155u3 != null) {
                    interfaceC0155u3.u(izVar2, i);
                }
                bc bcVar2 = bcVar;
                if (bcVar2 != null) {
                    nr.fx(izVar, bcVar2);
                }
                izVar.o();
            }

            @Override // com.bykv.vk.openvk.component.video.api.pn.u.InterfaceC0155u
            public void u(iz izVar2, int i) {
                u.InterfaceC0155u interfaceC0155u3 = interfaceC0155u;
                if (interfaceC0155u3 != null) {
                    interfaceC0155u3.u(izVar2, i);
                }
                if (bcVar != null) {
                    nr.u(izVar, bcVar, SystemClock.elapsedRealtime() - jElapsedRealtime);
                }
                izVar.o();
            }

            @Override // com.bykv.vk.openvk.component.video.api.pn.u.InterfaceC0155u
            public void u(iz izVar2, int i, String str) {
                u.InterfaceC0155u interfaceC0155u3 = interfaceC0155u;
                if (interfaceC0155u3 != null) {
                    interfaceC0155u3.u(izVar2, i, str);
                }
                if (bcVar != null) {
                    nr.nr(izVar, bcVar, SystemClock.elapsedRealtime() - jElapsedRealtime, i, str);
                }
                izVar.o();
            }
        };
        try {
            if (izVar.sx() != 0 || Build.VERSION.SDK_INT >= 23) {
                nr(izVar).u(dw.getContext(), izVar, interfaceC0155u2);
            } else {
                com.bykv.vk.openvk.component.video.u.nr.iz.u.u().u(izVar);
            }
        } catch (Exception e) {
            if (interfaceC0155u != null) {
                izVar.o();
                interfaceC0155u.u(izVar, -1, e.getMessage());
            }
            if (bcVar != null) {
                nr(izVar, bcVar, SystemClock.elapsedRealtime() - jElapsedRealtime, -1, e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fx(final iz izVar, final u.InterfaceC0155u interfaceC0155u, final bc bcVar) {
        try {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            int iJk = bcVar != null ? jp.jk(bcVar) : 0;
            boolean zU = t.u();
            if (!nr(iJk) || !zU) {
                u(izVar, interfaceC0155u, bcVar, jCurrentTimeMillis, zU);
                return;
            }
            if (dw.u(10003) == null) {
                u(izVar, interfaceC0155u, bcVar, jCurrentTimeMillis, zU);
                return;
            }
            fx fxVar = (fx) com.bytedance.sdk.openadsdk.ats.fx.u("pitaya");
            if (fxVar == null || !fxVar.isPitayaInitSuccess()) {
                u(izVar, -1000, -8, "not init", (JSONObject) null, System.currentTimeMillis() - jCurrentTimeMillis);
                b(izVar, interfaceC0155u, bcVar);
            } else {
                final JSONObject jSONObjectU = new s().u(izVar);
                fxVar.runTask("video_cache", jSONObjectU, new n() { // from class: com.bytedance.sdk.openadsdk.core.video.b.nr.2
                    @Override // com.bytedance.sdk.openadsdk.core.rh.n
                    public PluginValueSet u(int i, a aVar) {
                        com.bytedance.sdk.openadsdk.core.qq.s.u();
                        com.bytedance.sdk.openadsdk.core.qq.s.u(aVar == null ? null : aVar.b(), jSONObjectU);
                        return nr.nr(i, aVar, izVar, interfaceC0155u, jCurrentTimeMillis, bcVar);
                    }
                });
            }
        } catch (Exception e) {
            k.u("pit predict error:" + e.getMessage());
        }
    }

    private static boolean nr(int i) {
        return i == 8 || i == 7;
    }

    private static boolean u(int i) {
        return i == 3 || i == 4;
    }

    private static com.bykv.vk.openvk.component.video.api.pn.u nr(iz izVar) {
        if (izVar.sx() == 1) {
            if (nr == null) {
                synchronized (nr.class) {
                    if (nr == null) {
                        nr = new com.bytedance.sdk.component.l.nr.nr.u();
                    }
                }
            }
            return nr;
        }
        if (u == null) {
            synchronized (nr.class) {
                if (u == null) {
                    u = new com.bykv.vk.openvk.component.video.u.u.nr.u();
                }
            }
        }
        return u;
    }

    public static void u(final iz izVar, final u.InterfaceC0155u interfaceC0155u) {
        if (izVar == null) {
            nr(null, interfaceC0155u, null);
            return;
        }
        izVar.my();
        izVar.iz();
        izVar.iz();
        izVar.mv();
        final bc bcVarU = u(izVar);
        if (izVar.iz() <= 0 && !izVar.mv()) {
            nr(izVar, interfaceC0155u, bcVarU);
        } else if (x.u()) {
            x.u(new com.bytedance.sdk.component.jk.a("csj_vPreload") { // from class: com.bytedance.sdk.openadsdk.core.video.b.nr.1
                @Override // java.lang.Runnable
                public void run() {
                    nr.fx(izVar, interfaceC0155u, bcVarU);
                }
            });
        } else {
            fx(izVar, interfaceC0155u, bcVarU);
        }
    }

    private static void nr(iz izVar, u.InterfaceC0155u interfaceC0155u, bc bcVar) {
        if (interfaceC0155u != null) {
            interfaceC0155u.u(izVar, -100);
        }
        if (bcVar != null) {
            if (nr(jp.jk(bcVar)) || u(jp.jk(bcVar))) {
                u(izVar, bcVar, 0L);
            }
        }
    }

    private static void u(iz izVar, u.InterfaceC0155u interfaceC0155u, bc bcVar, long j, boolean z) {
        u(izVar, -1000, z ? -6 : -9, "bridge is null", (JSONObject) null, System.currentTimeMillis() - j);
        b(izVar, interfaceC0155u, bcVar);
    }

    private static boolean fx(iz izVar) {
        return Build.VERSION.SDK_INT >= 23 || izVar.sx() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fx(iz izVar, bc bcVar) {
        if (fx(izVar)) {
            String strNr = jp.nr(bcVar);
            JSONObject jSONObjectU = b.u(izVar, null, -1, izVar.sx(), bcVar, -1L);
            jk jkVar = new jk(izVar.my(), izVar.iz());
            jkVar.u(izVar);
            b.b((com.bytedance.sdk.openadsdk.iz.fx.nr<jk>) new com.bytedance.sdk.openadsdk.iz.fx.nr(bcVar, strNr, jSONObjectU, jkVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PluginValueSet nr(int i, a aVar, iz izVar, u.InterfaceC0155u interfaceC0155u, long j, bc bcVar) {
        int iOptInt;
        int i2;
        String string;
        try {
        } catch (Exception e) {
            e.getMessage();
        }
        if (aVar == null) {
            u(izVar, -1000, -2, "resultModel is null", (JSONObject) null, System.currentTimeMillis() - j);
            b(izVar, interfaceC0155u, bcVar);
            return null;
        }
        com.bytedance.sdk.openadsdk.my.u uVarFx = aVar.fx();
        if (uVarFx == null) {
            u(izVar, -1000, -3, "result is null", (JSONObject) null, System.currentTimeMillis() - j);
            b(izVar, interfaceC0155u, bcVar);
            return null;
        }
        PluginValueSet pluginValueSetB = uVarFx.b();
        if (pluginValueSetB == null) {
            u(izVar, -1000, -4, "value is null", (JSONObject) null, System.currentTimeMillis() - j);
            b(izVar, interfaceC0155u, bcVar);
            return null;
        }
        JSONObject jSONObject = (JSONObject) pluginValueSetB.objectValue(2, JSONObject.class);
        pluginValueSetB.stringValue(5);
        JSONObject jSONObject2 = (JSONObject) pluginValueSetB.objectValue(3, JSONObject.class);
        JSONObject jSONObject3 = (JSONObject) pluginValueSetB.objectValue(4, JSONObject.class);
        if (!uVarFx.u() || jSONObject == null) {
            iOptInt = -1000;
            i2 = -5;
            string = null;
        } else {
            iOptInt = jSONObject.optInt("pitaya_cache_size", -1);
            int iOptInt2 = jSONObject.optInt("pitaya_code", 200);
            string = "success";
            s.u(izVar, jSONObject, iOptInt, iOptInt2);
            i2 = iOptInt2;
        }
        if (!uVarFx.u() && jSONObject3 != null) {
            string = jSONObject3.toString();
        }
        u(izVar, iOptInt, i2, string, jSONObject2, System.currentTimeMillis() - j);
        b(izVar, interfaceC0155u, bcVar);
        return null;
    }

    private static void u(iz izVar, int i, int i2, String str, JSONObject jSONObject, long j) {
        JSONObject jSONObjectU = izVar.u();
        try {
            jSONObjectU.put("pitaya_cache_size", i);
            jSONObjectU.put("pitaya_code", i2);
            jSONObjectU.put("pitaya_msg", str);
            jSONObjectU.put("ext_plugin_code", bf.nr());
            jSONObjectU.put("package", jSONObject);
            jSONObjectU.put("run_task_mills", j);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static bc u(iz izVar) {
        if (izVar == null) {
            return null;
        }
        Object objPn = izVar.pn("material_meta");
        if (objPn instanceof bc) {
            return (bc) objPn;
        }
        return null;
    }

    public static void u(iz izVar, bc bcVar, long j) {
        if (fx(izVar)) {
            String strNr = jp.nr(bcVar);
            JSONObject jSONObjectU = b.u(izVar, null, -1, izVar.sx(), bcVar, -1L);
            mv mvVar = new mv();
            mvVar.u(izVar.my());
            mvVar.u(izVar.iz());
            mvVar.nr(j);
            mvVar.u(izVar);
            if (izVar.c() == 1) {
                mvVar.fx(1L);
            } else {
                mvVar.fx(0L);
            }
            b.nr((com.bytedance.sdk.openadsdk.iz.fx.nr<mv>) new com.bytedance.sdk.openadsdk.iz.fx.nr(bcVar, strNr, jSONObjectU, mvVar));
        }
    }

    private static void nr(iz izVar, bc bcVar) {
        if (fx(izVar)) {
            long jL = izVar.mv() ? izVar.l() : izVar.iz();
            String strNr = jp.nr(bcVar);
            JSONObject jSONObjectU = b.u(izVar, null, -1, izVar.sx(), bcVar, -1L);
            l lVar = new l(izVar.my(), jL);
            lVar.u(izVar);
            b.u((com.bytedance.sdk.openadsdk.iz.fx.nr<l>) new com.bytedance.sdk.openadsdk.iz.fx.nr(bcVar, strNr, jSONObjectU, lVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(iz izVar, bc bcVar, long j, int i, String str) {
        if (fx(izVar)) {
            String strNr = jp.nr(bcVar);
            JSONObject jSONObjectU = b.u(izVar, null, -1, izVar.sx(), bcVar, -1L);
            com.bytedance.sdk.openadsdk.iz.fx.t tVar = new com.bytedance.sdk.openadsdk.iz.fx.t();
            tVar.u(izVar.my());
            tVar.u(izVar.iz());
            tVar.nr(j);
            tVar.u(i);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            tVar.nr(str);
            tVar.fx("");
            tVar.u(izVar);
            b.fx((com.bytedance.sdk.openadsdk.iz.fx.nr<com.bytedance.sdk.openadsdk.iz.fx.t>) new com.bytedance.sdk.openadsdk.iz.fx.nr(bcVar, strNr, jSONObjectU, tVar));
        }
    }
}
