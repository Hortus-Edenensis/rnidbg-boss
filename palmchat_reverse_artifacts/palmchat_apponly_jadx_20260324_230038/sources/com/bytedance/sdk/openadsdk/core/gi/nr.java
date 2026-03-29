package com.bytedance.sdk.openadsdk.core.gi;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.oa;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.qq;
import com.bytedance.sdk.openadsdk.core.ugeno.x;
import com.bytedance.sdk.openadsdk.core.y.jp;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.gi.nr$nr, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0259nr {
        void u();

        void u(JSONObject jSONObject);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(int i, String str);

        void u(JSONObject jSONObject);
    }

    public static void u(com.bytedance.sdk.openadsdk.core.ugeno.x.u uVar, InterfaceC0259nr interfaceC0259nr) {
        if (uVar != null) {
            u(uVar.fx(), uVar.u(), uVar.nr(), interfaceC0259nr);
        } else if (interfaceC0259nr != null) {
            interfaceC0259nr.u();
        }
    }

    public static void u(String str, final String str2, final String str3, final InterfaceC0259nr interfaceC0259nr) {
        if (TextUtils.isEmpty(str)) {
            if (interfaceC0259nr != null) {
                interfaceC0259nr.u();
            }
        } else {
            com.bytedance.sdk.component.a.nr.fx fxVarFx = pn.u().nr().fx();
            fxVarFx.u(str);
            fxVarFx.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.gi.nr.1
                @Override // com.bytedance.sdk.component.a.u.u
                public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                    if (nrVar == null) {
                        return;
                    }
                    if (!nrVar.a()) {
                        InterfaceC0259nr interfaceC0259nr2 = interfaceC0259nr;
                        if (interfaceC0259nr2 != null) {
                            interfaceC0259nr2.u();
                            return;
                        }
                        return;
                    }
                    String strPn = nrVar.pn();
                    x.u().u(str2, str3, strPn);
                    if (interfaceC0259nr != null) {
                        try {
                            interfaceC0259nr.u(new JSONObject(strPn));
                        } catch (JSONException unused) {
                            interfaceC0259nr.u();
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.a.u.u
                public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                    InterfaceC0259nr interfaceC0259nr2 = interfaceC0259nr;
                    if (interfaceC0259nr2 != null) {
                        interfaceC0259nr2.u();
                    }
                }
            });
        }
    }

    public static void u(bc bcVar, JSONObject jSONObject, final com.bytedance.sdk.openadsdk.core.dw.fx fxVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        if (fxVar == null) {
            return;
        }
        if (bcVar != null) {
            try {
                if (!TextUtils.isEmpty(bcVar.ap())) {
                    int iJk = jp.jk(bcVar);
                    com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVarTm = bcVar.tm();
                    if (nrVarTm != null) {
                        nrVar = nrVarTm;
                    }
                    oa oaVar = new oa();
                    oaVar.b = 2;
                    if (tk.iz(bcVar) != null) {
                        oaVar.iz = 2;
                    }
                    JSONObject jSONObjectYy = bcVar.yy();
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObjectYy != null) {
                        try {
                            Iterator<String> itKeys = jSONObjectYy.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                jSONObject2.put(next, jSONObjectYy.opt(next));
                            }
                        } catch (JSONException unused) {
                        }
                    }
                    if (jSONObject != null) {
                        Iterator<String> itKeys2 = jSONObject.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            jSONObject2.put(next2, jSONObject.opt(next2));
                        }
                    }
                    oaVar.l = jSONObject2;
                    dw.u().u(nrVar, oaVar, iJk, new qq.nr() { // from class: com.bytedance.sdk.openadsdk.core.gi.nr.2
                        @Override // com.bytedance.sdk.openadsdk.core.qq.nr
                        public void u(int i, String str, com.bytedance.sdk.openadsdk.core.kj.nr nrVar2) {
                            fxVar.u(false, null, false);
                            nrVar2.u(i);
                            com.bytedance.sdk.openadsdk.core.kj.nr.u(nrVar2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.qq.nr
                        public void u(com.bytedance.sdk.openadsdk.core.kj.u uVar, com.bytedance.sdk.openadsdk.core.kj.nr nrVar2) {
                            if (uVar.nr() != null && !uVar.nr().isEmpty()) {
                                fxVar.u(true, uVar.nr(), false);
                                return;
                            }
                            fxVar.u(false, null, false);
                            nrVar2.u(-3);
                            com.bytedance.sdk.openadsdk.core.kj.nr.u(nrVar2);
                        }
                    });
                    return;
                }
            } catch (Exception e) {
                k.u("PageNetUtils", "get ads error", e);
                return;
            }
        }
        fxVar.u(false, null, false);
    }

    public static void u(String str, final u uVar) {
        com.bytedance.sdk.component.a.nr.fx fxVarFx = pn.u().nr().fx();
        fxVarFx.u(str);
        fxVarFx.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.gi.nr.3
            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                if (nrVar == null || !nrVar.a()) {
                    u uVar2 = uVar;
                    if (uVar2 == null || nrVar == null) {
                        return;
                    }
                    uVar2.u(nrVar.nr(), nrVar.fx());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(nrVar.pn());
                    u uVar3 = uVar;
                    if (uVar3 != null) {
                        uVar3.u(jSONObject);
                    }
                } catch (JSONException unused) {
                }
            }

            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.u(601, iOException.getMessage());
                }
            }
        });
    }
}
