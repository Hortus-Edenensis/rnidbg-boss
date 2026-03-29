package com.bytedance.sdk.openadsdk.core.live;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.dw.b;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.s.iz;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.gi.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class EcMallWebView extends SSWebView {
    private final bc iz;
    ja pn;
    private b x;

    public EcMallWebView(final Context context, bc bcVar, final int i) {
        super(context);
        this.iz = bcVar;
        x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.EcMallWebView.1
            @Override // java.lang.Runnable
            public void run() {
                EcMallWebView.this.u(context, i);
            }
        });
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, android.view.View, com.bytedance.sdk.component.mv.fx
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        ja jaVar = this.pn;
        if (jaVar != null) {
            jaVar.t(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Context context, int i) {
        this.pn = new ja(context);
        final String strU = jp.u(i);
        this.x = new b() { // from class: com.bytedance.sdk.openadsdk.core.live.EcMallWebView.2
            @Override // com.bytedance.sdk.openadsdk.core.dw.b
            public void u() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.dw.b
            public void u(int i2) {
                com.bytedance.sdk.openadsdk.my.fx.u.nr nrVar;
                if (EcMallWebView.this.iz != null && (nrVar = (com.bytedance.sdk.openadsdk.my.fx.u.nr) c.u(EcMallWebView.this.iz.dv(), com.bytedance.sdk.openadsdk.my.fx.u.nr.class)) != null) {
                    nrVar.u(2, null);
                }
                com.bytedance.sdk.openadsdk.core.s.b.u(strU, EcMallWebView.this.iz);
            }

            @Override // com.bytedance.sdk.openadsdk.core.dw.b
            public void nr() {
            }
        };
        this.pn.nr(this).u(this.iz).nr(this.iz.lk()).b(this.iz.ap()).fx(i).pn(jp.sx(this.iz)).u((SSWebView) this).u(strU).u(this.x).u(true);
        setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.u.b(context, this.pn, this.iz.lk(), new iz(this.iz, this).nr(true)));
        setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.u.fx(this.pn));
        String strIz = bg.iz(this.iz);
        if (TextUtils.isEmpty(strIz)) {
            strIz = this.iz.jf();
        }
        if (TextUtils.isEmpty(strIz)) {
            return;
        }
        loadUrl(strIz);
    }
}
