package com.bytedance.sdk.component.adexpress.pn;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.component.sdk.annotation.UiThread;
import com.bytedance.sdk.component.adexpress.nr.mv;
import com.bytedance.sdk.component.adexpress.nr.n;
import com.bytedance.sdk.component.adexpress.nr.t;
import com.bytedance.sdk.component.adexpress.nr.x;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u implements com.bytedance.sdk.component.adexpress.nr.b<SSWebView>, t, com.bytedance.sdk.component.adexpress.theme.u, com.bytedance.sdk.component.adexpress.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile x f5103a;
    protected SSWebView fx;
    private Context iz;
    private boolean jk;
    private mv l;
    private boolean mv;
    private String n;
    protected boolean nr;
    private int s;
    private n t;
    protected JSONObject u;
    private String x;
    protected int b = 8;
    protected AtomicBoolean pn = new AtomicBoolean(false);
    private boolean k = false;

    public u(Context context, mv mvVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        this.jk = false;
        this.iz = context;
        this.l = mvVar;
        this.x = mvVar.iz();
        themeStatusBroadcastReceiver.u(this);
        if (com.bytedance.sdk.component.adexpress.b.u()) {
            l();
            return;
        }
        SSWebView sSWebViewMv = mv();
        this.fx = sSWebViewMv;
        if (sSWebViewMv != null) {
            this.jk = true;
        } else if (com.bytedance.sdk.component.adexpress.b.getContext() != null) {
            this.fx = new SSWebView(com.bytedance.sdk.component.adexpress.b.getContext());
        }
    }

    private void l() {
        if (this.iz == null && com.bytedance.sdk.component.adexpress.b.getContext() != null) {
            this.iz = com.bytedance.sdk.component.adexpress.b.getContext();
        }
        if (this.iz != null) {
            SSWebView sSWebViewMv = mv();
            this.fx = sSWebViewMv;
            if (sSWebViewMv == null) {
                this.fx = new SSWebView(new MutableContextWrapper(this.iz.getApplicationContext()));
            } else {
                this.jk = true;
            }
        }
    }

    private SSWebView mv() {
        return this.l.z() ? pn.u().u(this.iz, this.x) : pn.u().nr(this.iz, this.x);
    }

    private void s() {
        if (this.l.z()) {
            pn.u().nr(this.fx);
        } else {
            pn.u().fx(this.fx);
        }
    }

    public void b() {
        if (this.pn.get()) {
            return;
        }
        this.pn.set(true);
        iz();
        if (this.fx.getParent() != null) {
            ((ViewGroup) this.fx.getParent()).removeView(this.fx);
        }
        if (this.nr) {
            s();
        } else {
            pn.u().pn(this.fx);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.b
    public int fx() {
        return 0;
    }

    public abstract void iz();

    public void n() {
        a();
        Activity activityU = com.bytedance.sdk.component.utils.nr.u(this.fx);
        if (activityU != null) {
            this.s = nr(activityU);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.b
    /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
    public SSWebView x() {
        return u();
    }

    public abstract void nr(int i);

    public void pn() {
        if (u() == null) {
            return;
        }
        try {
            u().getWebView().resumeTimers();
        } catch (Exception unused) {
        }
    }

    public mv t() {
        return this.l;
    }

    public void u(boolean z, int i) {
    }

    private int nr(Activity activity) {
        return activity.hashCode();
    }

    public void u(String str) {
        this.n = str;
    }

    public SSWebView u() {
        return this.fx;
    }

    public void u(n nVar) {
        this.t = nVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.b
    public void u(x xVar) {
        this.f5103a = xVar;
        if (u() != null && u().getWebView() != null) {
            if (TextUtils.isEmpty(this.n)) {
                this.f5103a.u(102, "url is empty");
                return;
            }
            if (!this.l.z()) {
                if (!this.k && !com.bytedance.sdk.component.adexpress.u.nr.nr.u(this.u)) {
                    x xVar2 = this.f5103a;
                    StringBuilder sb = new StringBuilder("data null is ");
                    sb.append(this.u == null);
                    xVar2.u(103, sb.toString());
                    return;
                }
                if (this.k && !com.bytedance.sdk.component.adexpress.u.nr.nr.fx(this.u)) {
                    x xVar3 = this.f5103a;
                    StringBuilder sb2 = new StringBuilder("choice ad data null is ");
                    sb2.append(this.u == null);
                    xVar3.u(103, sb2.toString());
                    return;
                }
            } else if (fx() == 9 && !com.bytedance.sdk.component.adexpress.u.nr.nr.nr(this.u)) {
                x xVar4 = this.f5103a;
                StringBuilder sb3 = new StringBuilder("data null is ");
                sb3.append(this.u == null);
                xVar4.u(103, sb3.toString());
                return;
            }
            this.l.x().nr(this.jk);
            if (this.jk) {
                try {
                    this.fx.clearView();
                    this.l.x().x();
                    s.u(this.fx.getWebView(), "javascript:window.SDK_RESET_RENDER();window.SDK_TRIGGER_RENDER();");
                    return;
                } catch (Exception e) {
                    pn.u().pn(this.fx);
                    this.f5103a.u(102, "load exception is " + e.getMessage());
                    return;
                }
            }
            SSWebView sSWebViewU = u();
            sSWebViewU.clearView();
            this.l.x().x();
            sSWebViewU.loadUrl(this.n);
            return;
        }
        x xVar5 = this.f5103a;
        StringBuilder sb4 = new StringBuilder("SSWebview null is ");
        sb4.append(u() == null);
        sb4.append(" or Webview is null");
        xVar5.u(102, sb4.toString());
    }

    public void a() {
    }

    public void jk() {
    }

    public void u(boolean z) {
        this.mv = z;
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.t
    public void u(final com.bytedance.sdk.component.adexpress.nr.s sVar) {
        if (sVar == null) {
            if (this.f5103a != null) {
                this.f5103a.u(105, "renderResult is null");
                return;
            }
            return;
        }
        boolean zFx = sVar.fx();
        final float fB = (float) sVar.b();
        final float fPn = (float) sVar.pn();
        if (fx() == 0 && (fB <= 0.0f || fPn <= 0.0f)) {
            if (this.f5103a != null) {
                this.f5103a.u(105, "width is " + fB + "height is " + fPn);
                return;
            }
            return;
        }
        this.nr = zFx;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            u(sVar, fB, fPn);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.pn.u.1
                @Override // java.lang.Runnable
                public void run() {
                    u.this.u(sVar, fB, fPn);
                }
            });
        }
    }

    public void u(com.bytedance.sdk.component.adexpress.nr.s sVar, float f, float f2) {
        u(this.nr, sVar.t());
        boolean z = this.nr;
        if (z && !this.mv) {
            u(f, f2);
            nr(this.b);
            if (this.f5103a != null) {
                this.f5103a.u(u(), sVar);
                return;
            }
            return;
        }
        if (!z) {
            pn.u().pn(this.fx);
        }
        u(sVar.t(), sVar.jk());
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.t
    public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar) {
        n nVar = this.t;
        if (nVar != null) {
            nVar.u(view, i, fxVar);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.t
    public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar, int i2) {
        n nVar = this.t;
        if (nVar != null) {
            nVar.u(view, i, fxVar, i2);
        }
    }

    @UiThread
    public void u(float f, float f2) {
        this.l.x().n();
        if (com.bytedance.sdk.component.adexpress.b.u() && fx() == 9) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) u().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
            u().setLayoutParams(layoutParams);
            return;
        }
        int iU = (int) com.bytedance.sdk.component.adexpress.b.n.u(this.iz, f);
        int iU2 = (int) com.bytedance.sdk.component.adexpress.b.n.u(this.iz, f2);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) u().getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(iU, iU2);
        }
        layoutParams2.width = iU;
        layoutParams2.height = iU2;
        u().setLayoutParams(layoutParams2);
    }

    private void u(int i, String str) {
        if (this.f5103a != null) {
            this.f5103a.u(i, str);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.u
    public void u(Activity activity) {
        if (this.s == 0 || activity == null || activity.hashCode() != this.s) {
            return;
        }
        b();
        jk();
    }
}
