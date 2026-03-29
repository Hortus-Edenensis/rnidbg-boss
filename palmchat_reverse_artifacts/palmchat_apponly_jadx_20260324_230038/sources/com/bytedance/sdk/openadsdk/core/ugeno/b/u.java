package com.bytedance.sdk.openadsdk.core.ugeno.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.fx.my;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.gi.nr;
import com.bytedance.sdk.openadsdk.core.kj.b;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.iz;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.l.fx.jk;
import com.bytedance.sdk.openadsdk.core.l.n;
import com.bytedance.sdk.openadsdk.core.qq;
import com.bytedance.sdk.openadsdk.core.s.x;
import com.bytedance.sdk.openadsdk.core.ugeno.b.nr;
import com.bytedance.sdk.openadsdk.core.ugeno.n.pn;
import com.bytedance.sdk.openadsdk.core.y.iz;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.huawei.hms.ads.ClickAreaSource;
import com.huawei.hms.ads.ex;
import com.huawei.openalliance.ad.constant.dc;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements nr.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.nr.fx f5373a;
    protected String b;
    protected com.bytedance.sdk.openadsdk.core.ugeno.pn.u fx;
    private x iz;
    private com.bytedance.sdk.openadsdk.core.l.nr.fx jk;
    private com.bytedance.adsdk.ugeno.widget.image.nr k;
    private b l;
    private String mv;
    private com.bytedance.sdk.openadsdk.core.multipro.nr.u my;
    private ViewGroup n;
    protected nr nr;
    private com.bytedance.sdk.openadsdk.core.l.nr.u o = new com.bytedance.sdk.openadsdk.core.l.nr.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.b.u.8
        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void u() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void u(long j, long j2, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void u(long j, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void u(String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void fx(long j, long j2, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void nr(long j, long j2, String str, String str2) {
        }
    };
    protected int pn;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr s;
    private JSONObject t;
    protected bc u;
    private Activity x;

    public u(Activity activity, ViewGroup viewGroup, x xVar, bc bcVar, String str, int i, com.bytedance.sdk.openadsdk.core.multipro.nr.u uVar) {
        this.u = bcVar;
        this.x = activity;
        this.iz = xVar;
        this.n = viewGroup;
        this.b = str;
        this.pn = i;
        this.my = uVar;
    }

    private void a() {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr nrVar = this.s;
        if (nrVar != null) {
            nrVar.u(this.my);
        }
    }

    private void n() {
        if (this.jk == null) {
            com.bytedance.sdk.openadsdk.core.l.nr.fx fxVarU = n.u(this.x, this.mv, this.u, this.b);
            this.jk = fxVarU;
            fxVarU.u(jk.u(this.u));
            this.jk.u(this.o, false);
            this.jk.nr(false);
        }
        this.jk.u(this.x);
    }

    private String x() {
        return jp.sx(this.u);
    }

    public void u(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
    }

    private void b(final JSONObject jSONObject) {
        if (this.l != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(this.l.iz());
                jSONObject2.put("is_support_func_desc", ex.Code);
                jSONObject.put("app", jSONObject2);
                fx(jSONObject);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        String strIz = iz();
        this.mv = strIz;
        if (!TextUtils.isEmpty(strIz)) {
            com.bytedance.sdk.component.jk.x.nr(new a("tt_pl_download_check") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.b.u.4
                @Override // java.lang.Runnable
                public void run() {
                    u uVar = u.this;
                    qq<com.bytedance.sdk.openadsdk.core.s.u> qqVarU = dw.u();
                    u uVar2 = u.this;
                    uVar.l = qqVarU.u(uVar2.u, uVar2.mv);
                    try {
                        JSONObject jSONObject3 = u.this.l != null ? new JSONObject(u.this.l.iz()) : u.this.u.wu() != null ? new JSONObject(u.this.u.wu()) : new JSONObject();
                        jSONObject3.put("is_support_func_desc", ex.Code);
                        jSONObject.put("app", jSONObject3);
                        jSONObject3.put(WfConstant.EXTRA_KEY_DOWNLOAD_URL, u.this.mv);
                        u.this.fx(jSONObject);
                    } catch (Throwable unused2) {
                    }
                }
            });
            return;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.pn.u uVar = this.fx;
        if (uVar != null) {
            uVar.u(-4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(final JSONObject jSONObject) {
        pn.u(this.u.q(), "lp_" + this.u.c(), this.u.qq(), new pn.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.b.u.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.pn.u
            public void u(JSONObject jSONObject2) {
                if (jSONObject2 != null) {
                    try {
                        jSONObject.put(ClickAreaSource.CREATIVE, u.this.u.et());
                        u.this.u(jSONObject);
                        u.this.u(jSONObject2, jSONObject);
                        return;
                    } catch (JSONException unused) {
                        return;
                    }
                }
                u.this.iz.u(-1, "template info load fail");
                com.bytedance.sdk.openadsdk.core.ugeno.pn.u uVar = u.this.fx;
                if (uVar != null) {
                    uVar.u(-1);
                }
            }
        });
    }

    private String iz() {
        JSONObject jSONObject = this.t;
        if (jSONObject == null) {
            return x();
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("download_buttons");
        if (jSONArrayOptJSONArray == null) {
            return x();
        }
        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null) {
            return x();
        }
        String strOptString = jSONObjectOptJSONObject.optString("url");
        return TextUtils.isEmpty(strOptString) ? x() : strOptString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pn() {
        bc bcVar = this.u;
        if (bcVar == null || zx.jk(bcVar) != 200) {
            return;
        }
        com.bytedance.adsdk.ugeno.nr.fx fxVarB = this.f5373a.b("video");
        if (fxVarB instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr nrVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr) fxVarB;
            this.s = nrVar;
            nrVar.pn(true);
            a();
        }
        com.bytedance.adsdk.ugeno.nr.fx fxVarB2 = this.f5373a.b(dc.C);
        if (fxVarB2 instanceof com.bytedance.adsdk.ugeno.widget.image.nr) {
            this.k = (com.bytedance.adsdk.ugeno.widget.image.nr) fxVarB2;
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.getPaint().setColor(Color.parseColor("#99333333"));
            shapeDrawable.setIntrinsicWidth(y.fx(this.x, 28.0f));
            shapeDrawable.setIntrinsicHeight(y.fx(this.x, 28.0f));
            this.k.a().setBackground(shapeDrawable);
        }
        com.bytedance.sdk.openadsdk.core.multipro.nr.u uVar = this.my;
        if (uVar != null) {
            u(uVar.n);
        } else {
            u(true);
        }
    }

    public void u(JSONObject jSONObject) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(JSONObject jSONObject) {
        this.t = jSONObject;
        b(jSONObject);
    }

    private void nr(boolean z) {
        n();
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.jk;
        if (fxVar instanceof com.bytedance.sdk.openadsdk.core.l.fx.n) {
            ((com.bytedance.sdk.openadsdk.core.l.fx.n) fxVar).iz().u(z);
        }
    }

    private void fx(boolean z) {
        nr(false);
        b(z);
    }

    private void fx(bc bcVar) {
        String strA;
        if (bcVar == null) {
            return;
        }
        iz izVarHm = bcVar.hm();
        b bVar = this.l;
        if (bVar != null) {
            strA = bVar.b();
        } else {
            strA = izVarHm == null ? "" : izVarHm.a();
        }
        com.bytedance.sdk.openadsdk.core.y.iz.nr(this.x, strA, bcVar.lk(), new iz.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.b.u.7
            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnNo() {
                if (u.this.x instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) u.this.x).b();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnYes() {
                u.this.b(true);
                if (u.this.x instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) u.this.x).b();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogCancel() {
                if (u.this.x instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) u.this.x).b();
                }
            }
        });
    }

    private boolean nr(my myVar) {
        if (myVar == null) {
            return false;
        }
        View viewA = myVar.u().a();
        if (!(viewA instanceof TextView)) {
            return false;
        }
        CharSequence text = ((TextView) viewA).getText();
        if (TextUtils.isEmpty(text)) {
            return false;
        }
        return text.toString().contains("下载");
    }

    public void u(com.bytedance.sdk.openadsdk.core.ugeno.pn.u uVar) {
        this.fx = uVar;
    }

    public void u() {
        this.nr = new nr(this.x, this.iz, this.b, this.pn);
        if (this.u.z() != null) {
            try {
                nr(new JSONObject(this.u.z().toString()));
                return;
            } catch (JSONException unused) {
                return;
            }
        }
        int iC = this.u.c();
        if (iC != 5 && iC != 4) {
            com.bytedance.sdk.openadsdk.core.gi.nr.u(this.u.dw(), new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.b.u.1
                @Override // com.bytedance.sdk.openadsdk.core.gi.nr.u
                public void u(JSONObject jSONObject) {
                    u.this.nr(jSONObject);
                }

                @Override // com.bytedance.sdk.openadsdk.core.gi.nr.u
                public void u(int i, String str) {
                    u.this.iz.u(-3, "ad meta info load fail");
                    com.bytedance.sdk.openadsdk.core.ugeno.pn.u uVar = u.this.fx;
                    if (uVar != null) {
                        uVar.u(-3);
                    }
                }
            });
        } else {
            nr(new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        n();
        com.bytedance.sdk.openadsdk.core.nr.u uVar = new com.bytedance.sdk.openadsdk.core.nr.u(this.x, this.u, "embeded_ad_landingpage", this.pn);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).fx(true);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(true);
        this.jk.fx(z);
        this.jk.u(this.u, false);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.jk);
        this.jk.u(jp.dw(this.u), false);
    }

    public void fx() {
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.jk;
        if (fxVar != null) {
            fxVar.u();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr nrVar = this.s;
        if (nrVar != null) {
            nrVar.v();
        }
    }

    private void nr(bc bcVar) {
        String strWu;
        if (bcVar == null) {
            return;
        }
        if (this.l != null) {
            com.bytedance.sdk.openadsdk.core.kj.iz izVarHm = bcVar.hm();
            if (izVarHm != null) {
                this.l.u(izVarHm.b());
                this.l.u(izVarHm.fx());
            }
            strWu = this.l.iz();
        } else {
            strWu = bcVar.wu();
        }
        Activity activity = this.x;
        if (activity instanceof TTNativePageActivity) {
            ((TTNativePageActivity) activity).fx();
        }
        com.bytedance.sdk.openadsdk.core.y.iz.u(this.x, bcVar.lk(), new iz.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.b.u.6
            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnNo() {
                if (u.this.x instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) u.this.x).b();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnYes() {
                u.this.b(true);
                if (u.this.x instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) u.this.x).b();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogCancel() {
                if (u.this.x instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) u.this.x).b();
                }
            }
        }, strWu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(JSONObject jSONObject, JSONObject jSONObject2) {
        this.iz.nr();
        this.nr.u(this);
        this.nr.u(jSONObject, jSONObject2, new com.bytedance.sdk.openadsdk.core.ugeno.n.x() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.b.u.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.x
            public void u(int i, String str) {
                com.bytedance.sdk.openadsdk.core.ugeno.pn.u uVar = u.this.fx;
                if (uVar != null) {
                    uVar.u(i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.x
            public void u(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
                u.this.f5373a = fxVar;
                u.this.n.addView(fxVar.a(), new FrameLayout.LayoutParams(fxVar.wq(), fxVar.pb()));
                com.bytedance.sdk.openadsdk.core.ugeno.pn.u uVar = u.this.fx;
                if (uVar != null) {
                    uVar.u(fxVar.a());
                }
                u.this.pn();
                u.this.u(fxVar);
            }
        });
    }

    private void u(boolean z) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr nrVar = this.s;
        if (nrVar != null) {
            nrVar.b(z);
        }
        com.bytedance.adsdk.ugeno.widget.image.nr nrVar2 = this.k;
        if (nrVar2 == null || nrVar2.a() == null) {
            return;
        }
        q.u((Context) this.x, z ? "tt_mute" : "tt_unmute", (ImageView) this.k.a());
    }

    public void b() {
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.jk;
        if (fxVar != null) {
            fxVar.nr();
        }
    }

    public void nr() {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr nrVar = this.s;
        if (nrVar != null) {
            nrVar.eh();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.b.nr.u
    public void u(my myVar) {
        JSONObject jSONObjectFx;
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr nrVar;
        if (myVar == null || myVar.nr() != 1 || (jSONObjectFx = myVar.fx()) == null) {
            return;
        }
        String strOptString = jSONObjectFx.optString("type");
        strOptString.hashCode();
        switch (strOptString) {
            case "openAppPermission":
                u(this.u);
                break;
            case "clickVideo":
                com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr nrVar2 = this.s;
                if (nrVar2 != null) {
                    nrVar2.mk();
                    break;
                }
                break;
            case "openAppFunctionDesc":
                fx(this.u);
                break;
            case "downloadEvent":
                nr(true);
                b(nr(myVar));
                break;
            case "downloadDirect":
                fx(nr(myVar));
                break;
            case "muteVideo":
                if (this.k != null && (nrVar = this.s) != null) {
                    u(!nrVar.n());
                    break;
                }
                break;
            case "openAppPolicy":
                nr(this.u);
                break;
            case "openInfringement":
                com.bytedance.sdk.openadsdk.core.y.iz.u(this.x, this.b, this.u);
                break;
        }
    }

    private void u(bc bcVar) {
        String strWu;
        if (bcVar == null) {
            return;
        }
        if (this.l != null) {
            com.bytedance.sdk.openadsdk.core.kj.iz izVarHm = bcVar.hm();
            if (izVarHm != null) {
                this.l.u(izVarHm.b());
                this.l.u(izVarHm.fx());
            }
            strWu = this.l.iz();
        } else {
            strWu = bcVar.wu();
        }
        Activity activity = this.x;
        if (activity instanceof TTNativePageActivity) {
            ((TTNativePageActivity) activity).fx();
        }
        com.bytedance.sdk.openadsdk.core.y.iz.u(this.x, bcVar.lk(), strWu, new iz.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.b.u.5
            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnNo() {
                if (u.this.x instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) u.this.x).b();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogBtnYes() {
                u.this.b(true);
                if (u.this.x instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) u.this.x).b();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.iz.u
            public void onDialogCancel() {
                if (u.this.x instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) u.this.x).b();
                }
            }
        });
    }
}
