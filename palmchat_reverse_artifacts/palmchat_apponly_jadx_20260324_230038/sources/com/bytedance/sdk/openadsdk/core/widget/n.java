package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.widget.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n extends AlertDialog {
    private x.u b;
    private Context fx;
    private com.bytedance.sdk.openadsdk.core.ugeno.u iz;
    private boolean n;
    private JSONObject nr;
    private String pn;
    private JSONObject u;
    private com.bytedance.sdk.openadsdk.core.ugeno.n.x x;

    public n(String str, Context context, JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.sdk.openadsdk.core.ugeno.n.x xVar, bc bcVar) {
        super(context, q.x(context, "tt_dialog_full"));
        this.x = xVar;
        this.fx = context;
        this.u = jSONObject;
        this.pn = str;
        this.nr = jSONObject2;
        this.iz = new com.bytedance.sdk.openadsdk.core.ugeno.u(context, bcVar);
    }

    private void nr() {
        if (this.u == null || this.nr == null || this.iz == null) {
            return;
        }
        this.n = false;
        final FrameLayout frameLayout = new FrameLayout(this.fx);
        this.iz.u(this.u, this.nr, new com.bytedance.sdk.openadsdk.core.ugeno.n.x() { // from class: com.bytedance.sdk.openadsdk.core.widget.n.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.x
            public void u(int i, String str) {
                n.this.n = true;
                if (n.this.x != null) {
                    FrameLayout frameLayout2 = frameLayout;
                    if (frameLayout2 != null) {
                        frameLayout2.removeAllViews();
                    }
                    n.this.x.u(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.x
            public void u(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
                n.this.n = false;
                if (n.this.x != null) {
                    n.this.x.u(null);
                }
                frameLayout.addView(fxVar.a(), new FrameLayout.LayoutParams(fxVar.wq(), fxVar.pb()));
                n.this.setContentView(frameLayout);
            }
        });
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        x.u uVar = this.b;
        if (uVar != null) {
            uVar.fx(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        nr();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.n) {
            hide();
            dismiss();
        }
    }

    public String u() {
        return this.pn;
    }

    public void u(x.u uVar) {
        this.b = uVar;
        com.bytedance.sdk.openadsdk.core.ugeno.u uVar2 = this.iz;
        if (uVar2 != null) {
            uVar2.u(uVar);
        }
    }

    public void u(com.bytedance.sdk.openadsdk.core.ugeno.n.x xVar) {
        this.x = xVar;
    }
}
