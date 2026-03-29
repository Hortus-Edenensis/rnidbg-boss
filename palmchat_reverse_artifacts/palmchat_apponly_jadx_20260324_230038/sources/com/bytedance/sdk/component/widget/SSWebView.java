package com.bytedance.sdk.component.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.bytedance.sdk.component.utils.qq;
import com.bytedance.sdk.component.widget.web.BizWebView;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class SSWebView extends BizWebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f5175a;
    private int bg;
    private nr bq;
    private AtomicBoolean c;
    private JSONObject d;
    private qq dw;
    private JSONObject gi;
    private boolean h;
    private String iz;
    private float jk;
    private float k;
    private AtomicInteger kj;
    private long l;
    private long mv;
    private float my;
    private boolean n;
    private float o;
    private com.bytedance.sdk.component.widget.nr.u pn;
    private AtomicBoolean q;
    private AtomicBoolean qq;
    private fx rh;
    private boolean s;
    private int sx;
    private long t;
    private JSONObject x;
    private JSONObject z;

    /* JADX INFO: compiled from: SearchBox */
    public interface fx {
        void u(MotionEvent motionEvent);

        void u(boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void u(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            if (webView == null) {
                return true;
            }
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(webView);
            }
            webView.destroy();
            return true;
        }
    }

    public SSWebView(Context context) {
        super(context);
        this.f5175a = 0.0f;
        this.jk = 0.0f;
        this.t = 0L;
        this.l = 0L;
        this.mv = 0L;
        this.s = false;
        this.k = 20.0f;
        this.o = 50.0f;
        this.c = new AtomicBoolean();
        this.q = new AtomicBoolean();
        this.qq = new AtomicBoolean(true);
        this.kj = new AtomicInteger();
    }

    private boolean fx(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (clsLoadClass != null) {
                if (clsLoadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (clsLoadClass2 != null) {
                return clsLoadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable unused2) {
            return false;
        }
    }

    private void iz() {
        this.dw = null;
        this.bq = null;
        setTouchStateListener(null);
        K_();
        this.pn = null;
        this.x = null;
        this.n = false;
    }

    private static boolean nr(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (clsLoadClass != null) {
                if (clsLoadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (clsLoadClass2 != null) {
                return clsLoadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable unused2) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.widget.web.MultiWebview
    public void I_() {
        iz();
        super.I_();
    }

    public boolean J_() {
        qq qqVar = this.dw;
        if (qqVar == null) {
            return false;
        }
        return qqVar.u();
    }

    public void K_() {
        this.q.set(false);
        qq qqVar = this.dw;
        if (qqVar != null) {
            com.bytedance.sdk.component.widget.nr.u uVar = this.pn;
            qqVar.b(uVar != null ? uVar.u() : 0);
        }
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.widget.web.MultiWebview, com.bytedance.sdk.component.mv.fx
    public void destroy() {
        super.destroy();
        iz();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        fx fxVar = this.rh;
        if (fxVar != null) {
            fxVar.u(true);
            this.rh.u(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public com.bytedance.sdk.component.widget.nr.u getMaterialMeta() {
        return this.pn;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c.set(true);
        if (this.q.get()) {
            nr(this.kj.get(), this.qq.get(), this.h);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c.set(false);
        qq qqVar = this.dw;
        if (qqVar != null) {
            com.bytedance.sdk.component.widget.nr.u uVar = this.pn;
            qqVar.nr(uVar != null ? uVar.u() : 0);
        }
    }

    @Override // android.view.ViewGroup
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent viewParentU;
        try {
            u(motionEvent);
            boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.s && (viewParentU = u((View) this)) != null) {
                viewParentU.requestDisallowInterceptTouchEvent(true);
            }
            return zOnInterceptTouchEvent;
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.mv.fx
    public void onPause() {
        super.onPause();
        fx fxVar = this.rh;
        if (fxVar != null) {
            fxVar.u(false);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        qq qqVar = this.dw;
        if (qqVar != null) {
            if (z) {
                com.bytedance.sdk.component.widget.nr.u uVar = this.pn;
                qqVar.u(uVar != null ? uVar.u() : 0);
            } else {
                com.bytedance.sdk.component.widget.nr.u uVar2 = this.pn;
                qqVar.nr(uVar2 != null ? uVar2.u() : 0);
            }
        }
    }

    public void setCalculationMethod(int i) {
        this.sx = i;
    }

    public void setCalculationTwistMethod(int i) {
        this.bg = i;
    }

    public void setDeepShakeValue(float f) {
        this.my = f;
    }

    public void setIsPreventTouchEvent(boolean z) {
        this.s = z;
    }

    public void setLandingPage(boolean z) {
        this.n = z;
    }

    public void setMaterialMeta(com.bytedance.sdk.component.widget.nr.u uVar) {
        this.pn = uVar;
    }

    public void setOnShakeListener(nr nrVar) {
        this.bq = nrVar;
    }

    public void setShakeInteractConf(JSONObject jSONObject) {
        this.gi = jSONObject;
    }

    public void setShakeValue(float f) {
        this.k = f;
    }

    public void setTag(String str) {
        this.iz = str;
    }

    public void setTouchStateListener(fx fxVar) {
        this.rh = fxVar;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.z = jSONObject;
    }

    public void setTwistInteractConf(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.mv.fx
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient instanceof fx) {
            setTouchStateListener((fx) webViewClient);
        } else {
            setTouchStateListener(null);
        }
        if (webViewClient == 0) {
            webViewClient = new u();
        }
        super.setWebViewClient(webViewClient);
    }

    public void setWriggleValue(float f) {
        this.o = f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewParent u(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
            return parent;
        }
        View view2 = (View) parent;
        return (nr(view2) || fx(view2)) ? parent : u(view2);
    }

    @Override // android.view.View
    public String getTag() {
        return this.iz;
    }

    private void nr(int i, boolean z, boolean z2) {
        qq qqVar = this.dw;
        if (qqVar == null) {
            this.dw = new qq(getContext(), i, z, z2);
        } else {
            qqVar.u(z);
        }
        this.dw.u(this.k);
        this.dw.fx(this.my);
        this.dw.nr(this.o);
        this.dw.u(this.z);
        this.dw.fx(this.gi);
        this.dw.nr(this.d);
        this.dw.pn(this.sx);
        this.dw.iz(this.bg);
        this.dw.u(new qq.u() { // from class: com.bytedance.sdk.component.widget.SSWebView.1
            @Override // com.bytedance.sdk.component.utils.qq.u
            public void u(int i2) {
                if (i2 == 1) {
                    SSWebView.this.u(1);
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    SSWebView.this.u(2);
                }
            }
        });
        qq qqVar2 = this.dw;
        com.bytedance.sdk.component.widget.nr.u uVar = this.pn;
        qqVar2.fx(uVar != null ? uVar.u() : 0);
    }

    public void u(int i, boolean z, boolean z2) {
        this.qq.set(z);
        this.kj.set(i);
        this.q.set(true);
        this.h = z2;
        if (this.c.get()) {
            nr(i, z, z2);
        }
    }

    public void u(int i) {
        nr nrVar = this.bq;
        if (nrVar != null) {
            nrVar.u(i);
        }
    }

    private void u(MotionEvent motionEvent) {
        if (!this.n || this.pn == null) {
            return;
        }
        if ((this.iz == null && this.x == null) || motionEvent == null) {
            return;
        }
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f5175a = motionEvent.getRawX();
                this.jk = motionEvent.getRawY();
                this.t = System.currentTimeMillis();
                this.x = new JSONObject();
                if (this.nr != null) {
                    this.nr.setTag(2064056319, Long.valueOf(this.t));
                    return;
                }
                return;
            }
            if (action == 1 || action == 3) {
                this.x.put("start_x", String.valueOf(this.f5175a));
                this.x.put("start_y", String.valueOf(this.jk));
                this.x.put("offset_x", String.valueOf(motionEvent.getRawX() - this.f5175a));
                this.x.put("offset_y", String.valueOf(motionEvent.getRawY() - this.jk));
                this.x.put("url", String.valueOf(getUrl()));
                this.x.put("tag", "");
                this.l = System.currentTimeMillis();
                if (this.nr != null) {
                    this.nr.setTag(2064056318, Long.valueOf(this.l));
                }
                this.x.put("down_time", this.t);
                this.x.put("up_time", this.l);
                if (com.bytedance.sdk.component.widget.u.u.u().nr() != null) {
                    long j = this.mv;
                    long j2 = this.t;
                    if (j != j2) {
                        this.mv = j2;
                        com.bytedance.sdk.component.widget.u.u.u();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
