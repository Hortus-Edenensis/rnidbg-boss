package com.bytedance.sdk.openadsdk.core.ugeno.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.fx.bq;
import com.bytedance.adsdk.ugeno.fx.k;
import com.bytedance.adsdk.ugeno.fx.my;
import com.bytedance.adsdk.ugeno.fx.s;
import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.adsdk.ugeno.nr.fx;
import com.bytedance.adsdk.ugeno.pn.iz;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.gi.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jk;
import com.bytedance.sdk.openadsdk.core.nr.nr;
import com.bytedance.sdk.openadsdk.core.ugeno.webview.PageWebView;
import com.bytedance.sdk.openadsdk.core.ugeno.x;
import com.bytedance.sdk.openadsdk.core.y.kj;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements bq, sx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f5371a;
    private bc b;
    private com.bytedance.sdk.openadsdk.core.ugeno.x.u fx;
    private com.bytedance.sdk.openadsdk.core.ugeno.pn.u iz;
    private Map<String, Object> jk;
    private jk n;
    private ViewGroup nr;
    private fx pn;
    private Context u;
    private nr x;

    public u(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.ugeno.x.u uVar, bc bcVar) {
        this.u = context;
        this.nr = viewGroup;
        this.fx = uVar;
        this.b = bcVar;
    }

    @Override // com.bytedance.adsdk.ugeno.fx.sx
    public void u(fx fxVar, String str, iz.u uVar) {
    }

    public void nr() {
        PageWebView.u(this.f5371a);
    }

    public void u(com.bytedance.sdk.openadsdk.core.ugeno.pn.u uVar) {
        this.iz = uVar;
    }

    public void u(DownloadListener downloadListener) {
        PageWebView.u(this.f5371a, downloadListener);
    }

    public void u() {
        com.bytedance.sdk.openadsdk.core.ugeno.x.u uVar = this.fx;
        if (uVar == null) {
            com.bytedance.sdk.openadsdk.core.ugeno.pn.u uVar2 = this.iz;
            if (uVar2 != null) {
                uVar2.u(-1);
                return;
            }
            return;
        }
        JSONObject jSONObjectU = x.u().u(uVar.u(), this.fx.nr());
        if (jSONObjectU == null) {
            com.bytedance.sdk.openadsdk.core.gi.nr.u(this.fx, new nr.InterfaceC0259nr() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.a.u.1
                @Override // com.bytedance.sdk.openadsdk.core.gi.nr.InterfaceC0259nr
                public void u(JSONObject jSONObject) {
                    u.this.u(jSONObject);
                }

                @Override // com.bytedance.sdk.openadsdk.core.gi.nr.InterfaceC0259nr
                public void u() {
                    if (u.this.iz != null) {
                        u.this.iz.u(-1);
                    }
                }
            });
        } else {
            u(jSONObjectU);
        }
    }

    public void u(final JSONObject jSONObject) {
        final k kVar = new k(this.u);
        final JSONObject jSONObjectEt = this.b.et();
        this.f5371a = jSONObjectEt;
        s sVar = new s();
        sVar.u(this.u);
        HashMap map = new HashMap();
        map.put("key_reward_page", this.jk);
        sVar.u(map);
        kVar.u("reward_page", sVar);
        kVar.u((sx) this);
        bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.a.u.2
            @Override // java.lang.Runnable
            public void run() {
                u.this.pn = kVar.u(jSONObject);
                if (u.this.pn == null) {
                    if (u.this.iz != null) {
                        u.this.iz.u(-1);
                    }
                } else {
                    kVar.nr(jSONObjectEt);
                    u.this.nr.addView(u.this.pn.a(), new FrameLayout.LayoutParams(u.this.pn.wq(), u.this.pn.pb()));
                    if (u.this.iz != null) {
                        u.this.iz.u(u.this.pn.a());
                    }
                }
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.fx.sx
    public void u(my myVar, sx.nr nrVar, sx.u uVar) {
        if (myVar != null && myVar.nr() == 1) {
            u(myVar, myVar.fx());
        }
    }

    private void u(my myVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("type");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        strOptString.hashCode();
        if (!strOptString.equals("clickEvent")) {
            if (strOptString.equals("openPolicy")) {
                com.bytedance.sdk.openadsdk.core.y.iz.u(this.u, this.b);
            }
        } else {
            com.bytedance.sdk.openadsdk.core.nr.nr nrVar = this.x;
            if (nrVar != null) {
                nrVar.u(myVar.u().a(), this.n);
            }
        }
    }

    public void u(com.bytedance.sdk.openadsdk.core.nr.nr nrVar) {
        this.x = nrVar;
    }

    @Override // com.bytedance.adsdk.ugeno.fx.bq
    public void u(fx fxVar, MotionEvent motionEvent) {
        this.n.fx(motionEvent.getDeviceId());
        this.n.nr(motionEvent.getToolType(0));
        this.n.b(motionEvent.getSource());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.n.fx(motionEvent.getRawX());
                this.n.b(motionEvent.getRawY());
                this.n.nr(System.currentTimeMillis());
                return;
            } else {
                if (actionMasked != 2) {
                    return;
                }
                this.n.fx(motionEvent.getRawX());
                this.n.b(motionEvent.getRawY());
                return;
            }
        }
        this.n.pn((int) motionEvent.getRawX());
        this.n.iz((int) motionEvent.getRawY());
        this.n.u(motionEvent.getRawX());
        this.n.nr(motionEvent.getRawY());
        this.n.u(System.currentTimeMillis());
        this.n.nr(motionEvent.getToolType(0));
        this.n.fx(motionEvent.getDeviceId());
        this.n.b(motionEvent.getSource());
        this.n.nr(true);
        kj.u(motionEvent);
    }

    public void u(Map<String, Object> map) {
        this.jk = map;
    }
}
