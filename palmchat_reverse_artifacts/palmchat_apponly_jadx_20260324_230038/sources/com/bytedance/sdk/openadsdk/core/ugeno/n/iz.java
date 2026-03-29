package com.bytedance.sdk.openadsdk.core.ugeno.n;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.fx.jk;
import com.bytedance.adsdk.ugeno.fx.k;
import com.bytedance.adsdk.ugeno.fx.my;
import com.bytedance.adsdk.ugeno.fx.s;
import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.adsdk.ugeno.pn.iz;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.nativeexpress.t;
import com.bytedance.sdk.openadsdk.core.ugeno.component.nr.iz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements sx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private n f5385a;
    private b b;
    private com.bytedance.adsdk.ugeno.nr.fx<View> fx;
    private bc iz;
    private t jk;
    private String l;
    private int mv;
    private nr n;
    private com.bytedance.sdk.openadsdk.core.s.x nr;
    private fx pn;
    private ja t;
    private Context u;
    private com.bytedance.adsdk.ugeno.nr.fx x;

    public iz(Context context, com.bytedance.sdk.openadsdk.core.s.x xVar, bc bcVar, String str, int i) {
        this.u = context;
        this.nr = xVar;
        this.iz = bcVar;
        this.l = str;
        this.mv = i;
    }

    @Override // com.bytedance.adsdk.ugeno.fx.sx
    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(JSONObject jSONObject, List<com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx> list, x xVar) {
        k kVar = new k(this.u);
        s sVar = new s();
        sVar.u(this.u);
        HashMap map = new HashMap();
        map.put("key_material", this.iz);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size() && i <= 2; i++) {
            arrayList.add(list.get(i).u());
        }
        ja jaVar = new ja(this.u);
        this.t = jaVar;
        jaVar.u(this.jk);
        this.t.u(this.n);
        this.t.u(this.l);
        this.t.fx(this.mv);
        map.put("key_data_list", arrayList);
        map.put("key_js_object", this.t);
        sVar.u(map);
        kVar.u("aggPage", sVar);
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVarU = kVar.u(jSONObject);
        this.fx = fxVarU;
        if (fxVarU == null || list.size() <= 0) {
            com.bytedance.sdk.openadsdk.core.s.x xVar2 = this.nr;
            if (xVar2 != null) {
                xVar2.u(-1, "ugeno render fail");
            }
            if (xVar != null) {
                xVar.u(-1, "");
                return;
            }
            return;
        }
        com.bytedance.adsdk.ugeno.nr.fx<T> fxVarB = this.fx.b("recycler_layout");
        this.x = fxVarB;
        if (fxVarB instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.nr.iz) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.nr.iz) fxVarB).u(list);
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.nr.iz) this.x).u(new iz.nr() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.iz.2
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.nr.iz.nr
                public void u() {
                    if (iz.this.b != null) {
                        iz.this.b.b(iz.this.x);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.nr.iz.nr
                public void u(int i2, int i3) {
                    if (iz.this.b != null) {
                        iz.this.b.u(i2, i3);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.nr.iz.nr
                public void u(RecyclerView recyclerView, int i2) {
                    if (iz.this.b != null) {
                        iz.this.b.u(recyclerView, i2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.nr.iz.nr
                public void u(int i2, View view, com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx fxVar) {
                    if (iz.this.b != null) {
                        iz.this.b.u(iz.this.x, i2, view, fxVar);
                    }
                }
            });
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.nr.iz) this.x).u(new com.bytedance.sdk.openadsdk.core.ugeno.component.nr.b() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.iz.3
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.nr.b
                public void nr(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
                    if (iz.this.b != null) {
                        iz.this.b.iz(fxVar);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.nr.b
                public void u(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
                    if (iz.this.b != null) {
                        iz.this.b.pn(fxVar);
                    }
                }
            });
        }
        kVar.u(new jk() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.iz.4
            @Override // com.bytedance.adsdk.ugeno.fx.jk
            public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
                if (iz.this.pn != null) {
                    iz.this.pn.fx(fxVar);
                }
            }
        });
        kVar.u(this);
        JSONObject jSONObjectEt = this.iz.et();
        if (list.size() > 0) {
            try {
                jSONObjectEt.put("ugen_sub_meta", list.get(0).u());
            } catch (JSONException unused) {
            }
        }
        kVar.nr(jSONObjectEt);
        this.nr.u(0L);
        if (xVar != null) {
            xVar.u(this.fx);
        }
    }

    public void u(b bVar) {
        this.b = bVar;
    }

    public void u(n nVar) {
        this.f5385a = nVar;
    }

    public void u(fx fxVar) {
        this.pn = fxVar;
    }

    public void u(final JSONObject jSONObject, final List<com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx> list, final x xVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            nr(jSONObject, list, xVar);
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.iz.1
                @Override // java.lang.Runnable
                public void run() {
                    iz.this.nr(jSONObject, (List<com.bytedance.sdk.openadsdk.core.ugeno.component.nr.fx>) list, xVar);
                }
            });
        }
    }

    public void u(t tVar) {
        this.jk = tVar;
    }

    public void u(nr nrVar) {
        this.n = nrVar;
    }

    public com.bytedance.adsdk.ugeno.nr.fx u() {
        return this.x;
    }

    @Override // com.bytedance.adsdk.ugeno.fx.sx
    public void u(my myVar, sx.nr nrVar, sx.u uVar) {
        n nVar;
        if (myVar == null) {
            return;
        }
        if (myVar.nr() == 1) {
            nr(myVar, (sx.nr) null, (sx.u) null);
            return;
        }
        if (myVar.nr() != 10 || (nVar = this.f5385a) == null) {
            return;
        }
        nVar.nr(myVar.u());
        ja jaVar = this.t;
        if (jaVar != null) {
            jaVar.nr("webviewVisible", (JSONObject) null);
        }
    }

    private void nr(my myVar, sx.nr nrVar, sx.u uVar) {
        if (myVar == null || myVar.u() == null) {
            return;
        }
        JSONObject jSONObjectFx = myVar.fx();
        String strOptString = jSONObjectFx.optString("type");
        String strOptString2 = jSONObjectFx.optString("nodeId");
        strOptString.hashCode();
        if (strOptString.equals("onDismiss")) {
            com.bytedance.adsdk.ugeno.nr.fx<T> fxVarB = this.fx.b(strOptString2);
            if (fxVarB != 0) {
                fxVarB.nr(8);
            }
        } else if (!strOptString.equals("onShow")) {
            fx fxVar = this.pn;
            if (fxVar != null) {
                fxVar.fx(myVar.u());
            }
        } else {
            com.bytedance.adsdk.ugeno.nr.fx<T> fxVarB2 = this.fx.b(strOptString2);
            if (fxVarB2 != 0) {
                fxVarB2.nr(0);
            }
        }
        final String strOptString3 = jSONObjectFx.optString("reportType");
        if (!TextUtils.isEmpty(strOptString3)) {
            com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.n.iz.5
                @Override // com.bytedance.sdk.openadsdk.t.u.u
                public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("type", strOptString3);
                    return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("agg_click").nr(jSONObject.toString());
                }
            }, "agg_click");
        }
        if (nrVar == null || myVar.b() == null) {
            return;
        }
        nrVar.u(myVar.b());
    }
}
