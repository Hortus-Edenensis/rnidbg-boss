package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Patterns;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.b.n;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.s.iz;
import com.bytedance.sdk.openadsdk.core.s.jk;
import com.bytedance.sdk.openadsdk.core.xg;
import com.bytedance.sdk.openadsdk.core.y.c;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected jk f5232a;
    protected boolean b;
    protected int bg;
    protected int bq;
    protected int dw;
    protected String fx;
    protected String jk;
    iz l;
    protected ja n;
    protected bc nr;
    protected AtomicInteger sx;
    protected com.bytedance.sdk.openadsdk.core.widget.u.b t;
    protected TTBaseVideoActivity u;
    protected SSWebView x;
    int pn = 0;
    int iz = 0;
    int mv = 0;
    String s = "";
    protected boolean k = false;
    protected boolean my = false;
    protected final AtomicBoolean o = new AtomicBoolean(true);
    protected AtomicBoolean c = new AtomicBoolean(false);
    protected com.bytedance.sdk.openadsdk.core.dw.u q = new com.bytedance.sdk.openadsdk.core.dw.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.u.1
        @Override // com.bytedance.sdk.openadsdk.core.dw.u
        public int nr() {
            SSWebView sSWebView = u.this.x;
            int measuredWidth = sSWebView != null ? sSWebView.getMeasuredWidth() : -1;
            return measuredWidth <= 0 ? y.b((Context) u.this.u) : measuredWidth;
        }

        @Override // com.bytedance.sdk.openadsdk.core.dw.u
        public int u() {
            SSWebView sSWebView = u.this.x;
            int measuredHeight = sSWebView != null ? sSWebView.getMeasuredHeight() : -1;
            return measuredHeight <= 0 ? y.pn((Context) u.this.u) : measuredHeight;
        }
    };
    protected com.bytedance.sdk.openadsdk.core.dw.iz qq = new com.bytedance.sdk.openadsdk.core.dw.iz() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.u.2
        @Override // com.bytedance.sdk.openadsdk.core.dw.iz
        public void nr() {
            SSWebView sSWebView = u.this.x;
            if (sSWebView == null) {
                return;
            }
            sSWebView.pauseTimers();
        }

        @Override // com.bytedance.sdk.openadsdk.core.dw.iz
        public void u() {
            SSWebView sSWebView = u.this.x;
            if (sSWebView == null) {
                return;
            }
            sSWebView.onPause();
        }
    };

    public u(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, String str, int i, int i2, boolean z) {
        this.u = tTBaseVideoActivity;
        this.nr = bcVar;
        this.fx = str;
        this.bg = bcVar.sv();
        if (dw.nr().uc()) {
            float f = this.u.getResources().getDisplayMetrics().density;
            float f2 = Resources.getSystem().getDisplayMetrics().density;
            this.bq = y.nr(f2, y.u(f, i));
            this.dw = y.nr(f2, y.u(f, i2));
        } else {
            this.bq = i;
            this.dw = i2;
        }
        this.b = z;
    }

    private void d() {
        if (this.c.getAndSet(true)) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.x, "translationY", 0.0f, y.pn((Context) this.u));
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.u.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                y.u((View) u.this.x, 8);
                u.this.c.set(false);
            }
        });
        objectAnimatorOfFloat.start();
    }

    private void gi() {
        if (this.c.getAndSet(true)) {
            return;
        }
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.x, "translationY", y.pn((Context) this.u), 0.0f);
            objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.u.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    u.this.c.set(false);
                }
            });
            objectAnimatorOfFloat.start();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(int i, int i2) {
        if (this.n == null || this.u.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
            this.n.nr("resize", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void a() {
        this.f5232a = null;
    }

    public void b(boolean z) {
    }

    public void bg() {
        jk jkVar = this.f5232a;
        if (jkVar != null) {
            jkVar.l();
        }
    }

    public void bq() {
        jk jkVar = this.f5232a;
        if (jkVar != null) {
            jkVar.fx();
            this.f5232a.b();
        }
    }

    public boolean c() {
        return u(this.jk);
    }

    public boolean dw() {
        ja jaVar = this.n;
        if (jaVar == null) {
            return false;
        }
        return jaVar.c();
    }

    public void fx(boolean z) {
        if (this.n == null || this.u.isFinishing()) {
            return;
        }
        try {
            this.n.iz(z);
        } catch (Exception unused) {
        }
    }

    public void iz() {
        if (this.u.yd() instanceof n) {
            d();
        } else {
            y.u((View) this.x, 8);
        }
    }

    public int jk() {
        return this.mv;
    }

    public void k() {
        ja jaVar = this.n;
        if (jaVar != null) {
            jaVar.rh();
        }
        jk jkVar = this.f5232a;
        if (jkVar != null) {
            jkVar.u(true);
            this.f5232a.my();
        }
        iz izVar = this.l;
        if (izVar != null) {
            izVar.iz();
        }
        SSWebView sSWebView = this.x;
        if (sSWebView != null) {
            xg.u(this.u, sSWebView);
            xg.u(this.x);
            this.x.destroy();
        }
        this.x = null;
    }

    public void l() {
        SSWebView sSWebView = this.x;
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        ja jaVar = this.n;
        if (jaVar != null) {
            jaVar.d();
            SSWebView sSWebView2 = this.x;
            if (sSWebView2 != null) {
                if (sSWebView2.getVisibility() == 0) {
                    this.n.iz(true);
                    u(true);
                    u(false, true);
                } else {
                    this.n.iz(false);
                    u(false);
                    u(true, false);
                }
            }
        }
        iz izVar = this.l;
        if (izVar != null) {
            izVar.b();
        }
        com.bytedance.sdk.openadsdk.core.widget.u.b bVar = this.t;
        if (bVar != null) {
            bVar.nr(false);
        }
    }

    public void mv() {
        SSWebView sSWebView = this.x;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        ja jaVar = this.n;
        if (jaVar != null) {
            jaVar.h();
            this.n.iz(false);
            u(false);
            u(true, false);
        }
        com.bytedance.sdk.openadsdk.core.widget.u.b bVar = this.t;
        if (bVar != null) {
            bVar.fx();
        }
    }

    public void my() {
        SSWebView sSWebView = this.x;
        if (sSWebView != null) {
            sSWebView.onResume();
            this.x.resumeTimers();
            y.u((View) this.x, 1.0f);
            z();
        }
    }

    public void n() {
        SSWebView sSWebView = this.x;
        if (sSWebView == null || !sSWebView.canGoBack()) {
            return;
        }
        this.x.goBack();
    }

    public void o() {
        jk jkVar = this.f5232a;
        if (jkVar != null) {
            jkVar.a();
        }
    }

    public void pn() {
        iz izVar = this.l;
        if (izVar != null) {
            izVar.u(System.currentTimeMillis());
        }
    }

    public void q() {
        SSWebView sSWebView = this.x;
        if (sSWebView != null) {
            sSWebView.loadUrl("about:blank");
        }
    }

    public abstract String qq();

    public void s() {
        iz izVar = this.l;
        if (izVar != null) {
            izVar.pn();
        }
    }

    public void sx() {
        jk jkVar = this.f5232a;
        if (jkVar != null) {
            jkVar.t();
        }
    }

    public String t() {
        return this.s;
    }

    public abstract void u(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.nr.nr nrVar);

    public abstract void u(boolean z, Map<String, Object> map, View view);

    public boolean x() {
        SSWebView sSWebView = this.x;
        if (sSWebView != null) {
            return sSWebView.canGoBack();
        }
        return false;
    }

    public void z() {
        ja jaVar = this.n;
        if (jaVar == null) {
            return;
        }
        jaVar.u(new SSWebView.nr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.u.6
            @Override // com.bytedance.sdk.component.widget.SSWebView.nr
            public void u(int i) {
                ja jaVar2 = u.this.n;
                if (jaVar2 != null) {
                    jaVar2.u(i);
                }
            }
        });
    }

    public boolean b() {
        return this.k;
    }

    public void u() {
        SSWebView sSWebView = this.x;
        if (sSWebView != null) {
            sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.u.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    SSWebView sSWebView2 = u.this.x;
                    if (sSWebView2 == null || sSWebView2.getViewTreeObserver() == null) {
                        return;
                    }
                    u.this.x.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredWidth = u.this.x.getMeasuredWidth();
                    int measuredHeight = u.this.x.getMeasuredHeight();
                    if (u.this.x.getVisibility() == 0) {
                        u.this.nr(measuredWidth, measuredHeight);
                    }
                }
            });
        }
    }

    public boolean fx() {
        if (!c()) {
            return false;
        }
        AtomicInteger atomicInteger = this.sx;
        if (atomicInteger == null || atomicInteger.get() == 0) {
            return this.o.get();
        }
        return true;
    }

    public void u(boolean z) {
        if (this.n == null || this.u.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.n.nr("viewableChange", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void nr(boolean z) {
        if (this.n == null || this.u.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            this.n.nr("volumeChange", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void u(boolean z, boolean z2) {
        if (this.n == null || this.u.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.n.nr("endcard_control_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    public boolean nr() {
        return this.my;
    }

    public void u(int i, int i2) {
        if (this.n == null || this.u.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("downloadStatus", i);
            jSONObject.put("downloadProcessRate", i2);
            this.n.fx("showDownloadStatus", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void u(long j, long j2, int i) {
        if (j2 > 0) {
            u(i, (int) ((j * 100) / j2));
        }
    }

    public void u(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.u.nr.u(this.u).u(false).nr(false).u(sSWebView);
        c.u(sSWebView, d.fx, bc.b(this.nr));
        y.u((com.bytedance.sdk.component.mv.fx) sSWebView);
        int i = Build.VERSION.SDK_INT;
        sSWebView.setMixedContentMode(0);
        if (i < 24) {
            this.x.setLayerType(0, null);
        }
    }

    public void kj() {
    }

    public void u(int i) {
        y.u((View) this.x, 0);
        if (i == 1) {
            y.u((View) this.x, 0.0f);
        }
        if (i == 2) {
            gi();
        }
        ja jaVar = this.n;
        if (jaVar != null) {
            jaVar.u(jp.sx(this.nr), false);
        }
    }

    public void u(Map<String, Object> map) {
        jk jkVar = this.f5232a;
        if (jkVar != null) {
            jkVar.jk();
        }
    }

    public void u(boolean z, int i, String str) {
        jk jkVar = this.f5232a;
        if (jkVar == null) {
            return;
        }
        if (z) {
            jkVar.nr();
        } else {
            jkVar.u(i, str);
        }
    }

    private boolean u(String str) {
        try {
            new URL(str);
            if (URLUtil.isValidUrl(str)) {
                if (Patterns.WEB_URL.matcher(str).matches()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void u(JSONObject jSONObject) {
        ja jaVar = this.n;
        if (jaVar == null) {
            k.nr("BaseEndCard", "mJsObject is null!");
        } else {
            jaVar.nr("showPlayAgainEntrance", jSONObject);
        }
    }

    public void u(bc bcVar) {
        this.nr = bcVar;
        this.k = false;
    }
}
