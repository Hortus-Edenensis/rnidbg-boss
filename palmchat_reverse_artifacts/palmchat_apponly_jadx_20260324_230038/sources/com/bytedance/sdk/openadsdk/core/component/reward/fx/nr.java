package com.bytedance.sdk.openadsdk.core.component.reward.fx;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.fx.k;
import com.bytedance.adsdk.ugeno.fx.my;
import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.adsdk.ugeno.pn.iz;
import com.bytedance.sdk.component.t.u.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.ob;
import com.bytedance.sdk.openadsdk.core.ugeno.n.pn;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ob f5234a;
    protected k jk;
    protected String k;
    protected String l;
    protected u mv;
    protected Map<String, Object> my;
    protected Activity n;
    protected AtomicBoolean s;
    protected String t;
    protected bc x;

    public nr(Activity activity, bc bcVar) {
        this.mv = new u(false, 0, "");
        this.s = new AtomicBoolean(false);
        this.n = activity;
        this.x = bcVar;
    }

    public String a() {
        return !TextUtils.isEmpty(this.k) ? this.k : u();
    }

    public void b() {
    }

    public void fx() {
    }

    public boolean iz() {
        return true;
    }

    public float n() {
        return 0.55f;
    }

    public boolean nr() {
        return false;
    }

    public u u(jk jkVar) {
        return new u(false, 0, "");
    }

    public abstract String u();

    public int x() {
        return 0;
    }

    public void b(String str) {
        this.t = str;
    }

    public void fx(String str) {
        this.l = str;
    }

    public u nr(jk jkVar) {
        return new u(false, 0, "");
    }

    public void u(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        Map<String, Object> map2 = this.my;
        if (map2 == null) {
            this.my = map;
        } else {
            map2.putAll(map);
        }
    }

    public void b(jk jkVar) {
        if (jkVar != null) {
            jkVar.u();
        }
    }

    public u fx(final jk jkVar) {
        if (!iz()) {
            return new u(false, 0, "");
        }
        final com.bytedance.sdk.openadsdk.core.widget.iz izVar = new com.bytedance.sdk.openadsdk.core.widget.iz(this.n);
        u(izVar);
        final FrameLayout frameLayout = new FrameLayout(this.n);
        izVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.fx.nr.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                k kVar = nr.this.jk;
                if (kVar != null) {
                    kVar.u((sx) null);
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.ugeno.x.u uVar = new com.bytedance.sdk.openadsdk.core.ugeno.x.u();
        uVar.u(this.f5234a.b());
        uVar.nr(this.f5234a.pn());
        uVar.fx(this.f5234a.b());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        com.bytedance.sdk.openadsdk.core.ugeno.n.pn.u(uVar, new pn.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.fx.nr.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.pn.u
            public void u(JSONObject jSONObject) {
                if (nr.this.s.get()) {
                    return;
                }
                if (jSONObject == null) {
                    nr.this.mv = new u(false, 0, "");
                    countDownLatch.countDown();
                } else {
                    nr.this.u(izVar, frameLayout, jkVar, jSONObject);
                    nr nrVar = nr.this;
                    nrVar.mv = new u(true, nrVar.x(), nr.this.f5234a.b(), izVar);
                    countDownLatch.countDown();
                }
            }
        });
        try {
            countDownLatch.await(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        }
        this.s.set(true);
        return this.mv;
    }

    public void nr(String str) {
        this.k = str;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private Dialog b;
        private String fx;
        private int nr;
        private boolean u;

        public u(boolean z, int i, String str, Dialog dialog) {
            this.u = z;
            this.nr = i;
            this.fx = str;
            this.b = dialog;
        }

        public boolean b() {
            Dialog dialog = this.b;
            if (dialog == null) {
                return false;
            }
            return dialog.isShowing();
        }

        public boolean fx() {
            return this.u;
        }

        public String nr() {
            return this.fx;
        }

        public void pn() {
            Dialog dialog = this.b;
            if (dialog != null) {
                dialog.dismiss();
            }
        }

        public int u() {
            return this.nr;
        }

        public u(boolean z, int i, String str) {
            this(z, i, str, null);
        }
    }

    public void u(final com.bytedance.sdk.openadsdk.core.widget.iz izVar, final ViewGroup viewGroup, final jk jkVar, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(a());
        } catch (JSONException unused) {
            jSONObject2 = new JSONObject();
        }
        final View viewU = u(jSONObject, jSONObject2, new sx() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.fx.nr.3
            @Override // com.bytedance.adsdk.ugeno.fx.sx
            public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
            }

            @Override // com.bytedance.adsdk.ugeno.fx.sx
            public void u(my myVar, sx.nr nrVar, sx.u uVar) {
                JSONObject jSONObjectFx = myVar.fx();
                if (jSONObjectFx == null) {
                    return;
                }
                String strOptString = jSONObjectFx.optString("type");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("event_template");
                boolean zOptBoolean = jSONObjectFx.optBoolean("uchain", false);
                if (jSONObjectOptJSONObject != null && zOptBoolean && nr.this.x != null) {
                    izVar.dismiss();
                    jp.gi();
                    com.bytedance.sdk.component.t.fx.nr.INSTANCE.u(jSONObjectOptJSONObject);
                    HashMap map = new HashMap();
                    map.put("reward_dialog_callback", jkVar);
                    new nr.u(strOptString).u(nr.this.x.et()).u(map).u().u();
                    return;
                }
                strOptString.hashCode();
                if (!strOptString.equals("exit_watch")) {
                    if (strOptString.equals("continue_watch")) {
                        izVar.dismiss();
                        nr.this.b(jkVar);
                        return;
                    }
                    return;
                }
                izVar.dismiss();
                jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.nr();
                }
            }
        });
        if (viewU == null) {
            return;
        }
        this.n.getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.fx.nr.4
            @Override // java.lang.Runnable
            public void run() {
                viewGroup.addView(viewU);
                nr nrVar = nr.this;
                nrVar.u(izVar, viewU, nrVar.n());
                izVar.u(viewGroup);
                izVar.show();
            }
        });
    }

    public nr(Activity activity, bc bcVar, ob obVar) {
        this(activity, bcVar);
        this.f5234a = obVar;
    }

    public void u(com.bytedance.sdk.openadsdk.core.widget.iz izVar) {
        izVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    public View u(JSONObject jSONObject, JSONObject jSONObject2, sx sxVar) {
        k kVar = new k(this.n);
        this.jk = kVar;
        com.bytedance.adsdk.ugeno.nr.fx<View> fxVarU = kVar.u(jSONObject);
        this.jk.u(sxVar);
        this.jk.nr(jSONObject2);
        if (fxVarU == null) {
            return null;
        }
        return fxVarU.a();
    }

    public void u(Dialog dialog, View view, float f) {
        if (dialog == null || view == null) {
            return;
        }
        if (this.x.sv() == 1) {
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.y = y.fx(this.n, -20.0f);
            dialog.getWindow().setAttributes(attributes);
        }
        if (this.x.sv() == 2) {
            view.setScaleX(f);
            view.setScaleY(f);
            view.setPivotY(0.0f);
            view.measure(0, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, view.getMeasuredHeight());
            layoutParams.leftMargin = (int) (view.getMeasuredWidth() * (1.0f - f));
            layoutParams.topMargin = (int) Math.max(((y.pn((Context) this.n) - (view.getMeasuredHeight() * f)) / 2.0f) - y.t((Context) this.n), y.t((Context) this.n));
            view.setLayoutParams(layoutParams);
        }
    }

    public void pn() {
    }
}
