package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.widget.fx;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class mv extends fx {
    private com.bytedance.sdk.openadsdk.core.ugeno.n.x b;
    Window fx;
    private com.bytedance.sdk.openadsdk.core.ugeno.n iz;
    private boolean n;
    private JSONObject pn;
    private volatile boolean x;

    public mv(Activity activity, JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.ugeno.n.x xVar) {
        super(activity);
        this.fx = activity == null ? null : activity.getWindow();
        this.pn = jSONObject;
        this.b = xVar;
        this.iz = new com.bytedance.sdk.openadsdk.core.ugeno.n(activity);
    }

    private void iz() {
        JSONObject jSONObject = this.pn;
        if (jSONObject == null || this.b == null) {
            return;
        }
        JSONObject jSONObjectU = com.bytedance.sdk.openadsdk.core.ugeno.jk.u(jSONObject.remove("ugen_url").toString(), this.pn.remove("ugen_md5").toString(), (com.bytedance.sdk.openadsdk.core.ugeno.fx) null);
        if (jSONObjectU == null) {
            this.b.u(11, "uegnTemplate is empty");
            this.x = true;
        } else {
            final FrameLayout frameLayout = new FrameLayout(this.u);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.iz.u(jSONObjectU, this.pn, new com.bytedance.sdk.openadsdk.core.ugeno.n.x() { // from class: com.bytedance.sdk.openadsdk.core.widget.mv.1
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.x
                public void u(int i, String str) {
                    mv.this.x = true;
                    if (mv.this.b != null) {
                        FrameLayout frameLayout2 = frameLayout;
                        if (frameLayout2 != null) {
                            frameLayout2.removeAllViews();
                        }
                        mv.this.b.u(i, str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.x
                public void u(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
                    mv.this.x = false;
                    if (mv.this.b != null) {
                        mv.this.b.u(null);
                    }
                    frameLayout.addView(fxVar.a(), new FrameLayout.LayoutParams(fxVar.wq(), fxVar.pb()));
                    mv.this.setContentView(frameLayout);
                }
            });
        }
    }

    private void pn() {
        if (this.fx != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            this.fx.setBackgroundDrawable(gradientDrawable);
            WindowManager.LayoutParams attributes = this.fx.getAttributes();
            attributes.alpha = 1.0f;
            this.fx.setAttributes(attributes);
        }
    }

    private void x() {
        JSONObject jSONObject = this.pn;
        if (jSONObject == null) {
            return;
        }
        u(jSONObject.optString("app_name"));
        pn(this.pn.optString("app_version"));
        iz(this.pn.optString("reg_number"));
        x(this.pn.optString("reg_url"));
        nr(this.pn.optString("icon_url"));
        n(this.pn.optString(WfConstant.EXTRA_KEY_DEVELOPER_NAME));
        u(this.pn.optInt("score"));
        u(this.pn.optJSONArray("creative_tags"));
        b(this.pn.optString("description"));
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.fx
    public void fx() {
        if (this.n) {
            super.fx();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.fx
    public void nr() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.fx, android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.fx, android.app.Dialog
    public void show() {
        super.show();
        if (this.x) {
            hide();
            dismiss();
        }
    }

    public void nr(fx.u uVar) {
        super.u(uVar);
        com.bytedance.sdk.openadsdk.core.ugeno.n nVar = this.iz;
        if (nVar != null) {
            nVar.u(uVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.fx
    public void u() {
        if (this.u == null) {
            this.u = dw.getContext();
        }
        if (this.u.getResources().getConfiguration().orientation != 1) {
            this.n = true;
            super.u();
            super.nr();
            x();
            return;
        }
        pn();
        iz();
    }
}
