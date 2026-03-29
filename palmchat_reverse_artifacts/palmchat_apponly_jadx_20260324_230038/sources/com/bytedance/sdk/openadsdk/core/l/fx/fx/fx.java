package com.bytedance.sdk.openadsdk.core.l.fx.fx;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bq;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.l.fx.jk;
import com.bytedance.sdk.openadsdk.core.ugeno.n.x;
import com.bytedance.sdk.openadsdk.core.y.iz;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private u fx;
    private Context nr;
    private com.bytedance.sdk.openadsdk.core.l.fx.u.u pn;
    private bc u;
    private boolean b = true;
    private boolean iz = false;
    private int x = 0;
    private boolean n = false;

    public fx(Context context, bc bcVar) {
        this.nr = context;
        this.u = bcVar;
    }

    public boolean b(boolean z) {
        u uVar = this.fx;
        boolean z2 = true;
        if (uVar == null) {
            return true;
        }
        if (uVar instanceof nr) {
            nr nrVar = (nr) uVar;
            if (!z && !this.n) {
                z2 = false;
            }
            nrVar.fx(z2);
            nrVar.nr(this.iz);
            nrVar.u(this.x);
        }
        return this.fx.u();
    }

    public void fx(boolean z) {
        this.n = z;
    }

    public void nr(boolean z) {
        this.iz = z;
    }

    private void nr(final String str) {
        if (bq.sx(this.u) != 4) {
            return;
        }
        TTDelegateActivity.u(new x() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.fx.fx.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.x
            public void u(int i, String str2) {
                fx.this.u(str, 1, str2);
                TTDelegateActivity.u((x) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.x
            public void u(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
                fx.this.u(str, 0, "");
                TTDelegateActivity.u((x) null);
            }
        });
    }

    public String fx(long j) {
        return j <= 0 ? "-" : String.format("%.1fMB", Double.valueOf((j / 1024.0d) / 1024.0d));
    }

    private x fx(final String str) {
        return new x() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.fx.fx.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.x
            public void u(int i, String str2) {
                fx fxVar = fx.this;
                fxVar.u(fxVar.u, str, 6, i, str2);
                TTDelegateActivity.u((x) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.x
            public void u(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
                fx fxVar2 = fx.this;
                fxVar2.u(fxVar2.u, str, 5, 0, "");
                TTDelegateActivity.u((x) null);
            }
        };
    }

    public String nr(long j) {
        return j >= 100000000 ? String.format("%d亿+", Long.valueOf(Math.round(j / 1.0E8d))) : j >= 10000 ? String.format("%d万+", Long.valueOf(Math.round(j / 10000.0d))) : j > 0 ? String.valueOf(j) : "-";
    }

    public void u(u uVar) {
        u(uVar, this.u);
    }

    public void u(u uVar, bc bcVar) {
        this.fx = uVar;
        if (uVar == null) {
            return;
        }
        uVar.u(this.nr);
        uVar.u(bcVar);
        uVar.u(this.b);
    }

    private String b(String str) {
        com.bytedance.sdk.component.b.nr.fx fxVarU = com.bytedance.sdk.openadsdk.core.nr.u();
        if (fxVarU == null) {
            return null;
        }
        return fxVarU.get(str, "");
    }

    private iz.u nr(final String str, final com.bytedance.sdk.openadsdk.core.l.fx.u.nr nrVar) {
        return new iz.u() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.fx.fx.4
            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnYes() {
                com.bytedance.sdk.openadsdk.core.l.fx.u.nr nrVar2 = nrVar;
                if (nrVar2 != null) {
                    nrVar2.u();
                }
                if (fx.this.pn != null) {
                    fx.this.pn.u();
                }
                iz.nr = true;
                com.bytedance.sdk.openadsdk.core.s.b.nr(fx.this.u, str, "pop_up_download", fx.this.u());
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogCancel() {
                com.bytedance.sdk.openadsdk.core.s.b.nr(fx.this.u, str, "pop_up_cancel", fx.this.u());
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnNo() {
            }
        };
    }

    public void u(boolean z) {
        this.b = z;
    }

    public void u(com.bytedance.sdk.openadsdk.core.l.fx.u.u uVar) {
        this.pn = uVar;
    }

    public void u(int i) {
        this.x = i;
    }

    public void u(String str, com.bytedance.sdk.openadsdk.core.l.fx.u.nr nrVar) {
        if (this.u == null) {
            return;
        }
        u((com.bytedance.sdk.openadsdk.core.kj.b) null, str, nrVar);
    }

    public void u(com.bytedance.sdk.openadsdk.core.kj.b bVar, final String str, final String str2, final com.bytedance.sdk.openadsdk.core.l.fx.u.nr nrVar) {
        bc bcVar = this.u;
        if (bcVar == null) {
            return;
        }
        if (bVar == null && bcVar.xh() == 2 && !(this.fx instanceof pn)) {
            com.bytedance.sdk.component.jk.x.nr(new a("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.l.fx.fx.fx.1
                @Override // java.lang.Runnable
                public void run() {
                    fx.this.u(dw.u().u(fx.this.u, str2), str, nrVar);
                }
            });
        } else {
            u(bVar, str, nrVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.core.kj.b bVar, String str, com.bytedance.sdk.openadsdk.core.l.fx.u.nr nrVar) {
        String strWu;
        String strNr;
        String strU;
        iz.u uVarNr = nr(str, nrVar);
        try {
            if (bVar != null) {
                com.bytedance.sdk.openadsdk.core.kj.iz izVarHm = this.u.hm();
                if (izVarHm != null) {
                    bVar.u(izVarHm.b());
                    bVar.u(izVarHm.fx());
                }
                strWu = bVar.iz();
                strNr = bVar.u();
                strU = bVar.fx();
            } else {
                strWu = this.u.wu();
                strNr = jk.nr(this.u);
                rh rhVarDd = this.u.dd();
                strU = rhVarDd != null ? rhVarDd.u() : "";
            }
            if (com.bytedance.sdk.openadsdk.core.ugeno.jk.a(this.u)) {
                if (!com.bytedance.sdk.openadsdk.core.ugeno.jk.u(this.nr, this.u, strNr)) {
                    bc bcVar = this.u;
                    u(bcVar, str, com.bytedance.sdk.openadsdk.core.ugeno.jk.nr(this.nr, bcVar, strNr), 0, "");
                }
            } else {
                com.bytedance.sdk.openadsdk.core.s.b.nr(this.u, str, "pop_up", u());
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dialog_title", strNr);
            jSONObject.put("dialog_icon_url", strU);
            jSONObject.put("dialog_app_description", this.u.ym());
            String strU2 = u(strWu);
            nr(str);
            if (com.bytedance.sdk.openadsdk.core.ugeno.jk.u(this.nr, this.u, strNr)) {
                u(str, uVarNr, strU2, strU, jSONObject);
            } else {
                com.bytedance.sdk.openadsdk.core.y.iz.u(this.nr, this.u.lk(), strU2, jSONObject.toString(), uVarNr, this.u);
            }
        } catch (JSONException unused) {
        }
    }

    private String u(String str) {
        int iSx = bq.sx(this.u);
        try {
            if (iSx != 4) {
                if (iSx != 3) {
                    return str;
                }
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put("hand_icon_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/ugeno-source/download_hand_tap.json");
                return jSONObject.toString();
            }
            JSONObject jSONObject2 = new JSONObject(str);
            jSONObject2.put("ugen_url", bq.bq(this.u));
            jSONObject2.put("ugen_md5", bq.dw(this.u));
            jSONObject2.put("download_num", nr(this.u.bp()));
            if (this.u.pu() == null) {
                return jSONObject2.toString();
            }
            jSONObject2.put("app_size", fx(r1.x()));
            jSONObject2.put("comment_num", u(r1.iz()));
            return jSONObject2.toString();
        } catch (JSONException unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, int i, String str2) {
        JSONObject jSONObjectU = u();
        try {
            jSONObjectU.put("ugen_dl_render_fail_msg", str2);
            jSONObjectU.put("ugen_dl_render_fail", i);
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.core.s.b.nr(this.u, str, "pop_up", jSONObjectU);
    }

    public String u(long j) {
        return j >= 100000000 ? String.format("%d亿+", Long.valueOf(j / 100000000)) : j >= 10000 ? String.format("%d万+", Long.valueOf(j / 10000)) : j > 0 ? String.valueOf(j) : "-";
    }

    private void u(String str, iz.u uVar, String str2, String str3, JSONObject jSONObject) throws JSONException {
        jSONObject.put("is_easy_dl_dialog_pop_up_style", true);
        com.bytedance.sdk.openadsdk.core.y.iz.u(this.nr, this.u.lk(), com.bytedance.sdk.openadsdk.core.ugeno.jk.u(this.nr, str2, this.u, str3), jSONObject.toString(), uVar, fx(str), this.u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(bc bcVar, String str, int i, int i2, String str2) {
        JSONObject jSONObjectU = u();
        if (6 == i) {
            try {
                jSONObjectU.put("easy_dl_render_fail_code", i2);
                if (bcVar != null) {
                    String strFx = bcVar.fa().fx();
                    jSONObjectU.put("easy_dl_render_fail_msg", str2);
                    jSONObjectU.put("easy_dl_render_fail_dsl", b(strFx));
                }
            } catch (Exception unused) {
            }
        }
        jSONObjectU.put("show_easy_dl_dialog_code", i);
        com.bytedance.sdk.openadsdk.core.s.b.nr(this.u, str, "pop_up", jSONObjectU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            u uVar = this.fx;
            jSONObject.put("download_type", uVar != null ? uVar.nr() : 0);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
