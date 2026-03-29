package com.bytedance.sdk.component.adexpress.pn;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.UiThread;
import com.bytedance.sdk.component.u.kj;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile pn f5102a = null;
    private static int iz = 10;
    private static final byte[] pn = new byte[0];
    private static int x = 10;
    private final AtomicBoolean n = new AtomicBoolean(false);
    private final List<SSWebView> u = new ArrayList();
    private final List<SSWebView> nr = new ArrayList();
    private final WeakHashMap<com.bytedance.sdk.component.mv.fx, fx> fx = new WeakHashMap<>();
    private final WeakHashMap<com.bytedance.sdk.component.mv.fx, b> b = new WeakHashMap<>();

    private pn() {
        com.bytedance.sdk.component.adexpress.u.u.fx fxVarFx = com.bytedance.sdk.component.adexpress.u.u.u.u().fx();
        if (fxVarFx != null) {
            iz = fxVarFx.n();
            x = fxVarFx.a();
        }
    }

    public static pn u() {
        if (f5102a == null) {
            synchronized (pn.class) {
                if (f5102a == null) {
                    f5102a = new pn();
                }
            }
        }
        return f5102a;
    }

    public void b(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.u.size() >= iz) {
            sSWebView.destroy();
        } else {
            if (this.u.contains(sSWebView)) {
                return;
            }
            this.u.add(sSWebView);
            fx();
        }
    }

    @UiThread
    public void fx(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        sSWebView.I_();
        iz(sSWebView);
        b(sSWebView);
    }

    public void iz(SSWebView sSWebView) {
        fx fxVar;
        if (sSWebView == null || (fxVar = this.fx.get(sSWebView)) == null) {
            return;
        }
        fxVar.u(null);
    }

    @UiThread
    public void nr(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        sSWebView.I_();
        iz(sSWebView);
        u(sSWebView);
    }

    public boolean pn(SSWebView sSWebView) {
        if (sSWebView == null) {
            return false;
        }
        sSWebView.destroy();
        return true;
    }

    public int pn() {
        return this.u.size() + b();
    }

    public int fx() {
        return this.u.size();
    }

    public SSWebView nr(Context context, String str) {
        SSWebView sSWebViewRemove;
        if (fx() <= 0 || (sSWebViewRemove = this.u.remove(0)) == null) {
            return null;
        }
        fx();
        return sSWebViewRemove;
    }

    public int b() {
        return this.nr.size();
    }

    public void nr() {
        for (SSWebView sSWebView : this.u) {
            if (sSWebView != null) {
                sSWebView.destroy();
            }
        }
        this.u.clear();
        for (SSWebView sSWebView2 : this.nr) {
            if (sSWebView2 != null) {
                sSWebView2.destroy();
            }
        }
        this.nr.clear();
        synchronized (this.b) {
            this.b.clear();
        }
    }

    public SSWebView u(Context context, String str) {
        SSWebView sSWebViewRemove;
        if (b() <= 0 || (sSWebViewRemove = this.nr.remove(0)) == null) {
            return null;
        }
        this.nr.size();
        return sSWebViewRemove;
    }

    public void u(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.nr.size() >= x) {
            sSWebView.destroy();
        } else {
            if (this.nr.contains(sSWebView)) {
                return;
            }
            this.nr.add(sSWebView);
            this.nr.size();
        }
    }

    @SuppressLint({"JavascriptInterface"})
    public void u(SSWebView sSWebView, nr nrVar) {
        if (sSWebView == null || nrVar == null) {
            return;
        }
        fx fxVar = this.fx.get(sSWebView);
        if (fxVar != null) {
            fxVar.u(nrVar);
        } else {
            fxVar = new fx(nrVar);
            this.fx.put(sSWebView, fxVar);
        }
        sSWebView.addJavascriptInterface(fxVar, "SDK_INJECT_GLOBAL");
    }

    private static void u(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            jk.nr().post(runnable);
        }
    }

    @SuppressLint({"JavascriptInterface"})
    public void u(final com.bytedance.sdk.component.mv.fx fxVar, kj kjVar, final String str) {
        final b bVar;
        if (fxVar == null || kjVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.b) {
            bVar = this.b.get(fxVar);
            if (bVar != null) {
                bVar.u(kjVar);
            } else {
                bVar = new b(kjVar);
                this.b.put(fxVar, bVar);
            }
        }
        u(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.pn.pn.1
            @Override // java.lang.Runnable
            public void run() {
                fxVar.addJavascriptInterface(bVar, str);
            }
        });
    }

    public void u(final com.bytedance.sdk.component.mv.fx fxVar, final String str) {
        if (fxVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.b) {
            b bVar = this.b.get(fxVar);
            if (bVar != null) {
                bVar.u(null);
            }
        }
        u(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.pn.pn.2
            @Override // java.lang.Runnable
            public void run() {
                fxVar.removeJavascriptInterface(str);
            }
        });
    }
}
