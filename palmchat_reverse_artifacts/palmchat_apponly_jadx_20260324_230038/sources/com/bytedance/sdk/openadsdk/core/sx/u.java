package com.bytedance.sdk.openadsdk.core.sx;

import android.text.TextUtils;
import com.bytedance.sdk.component.a.nr;
import com.bytedance.sdk.component.a.nr.b;
import com.bytedance.sdk.component.a.nr.fx;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.gi.pn;
import com.bytedance.sdk.openadsdk.core.kj.pb;
import com.bytedance.sdk.openadsdk.core.y.bf;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static String nr = "";
    public static String u = "";

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.sx.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class RunnableC0286u implements Runnable {
        private WeakReference<Runnable> u;

        public RunnableC0286u(Runnable runnable) {
            if (runnable != null) {
                this.u = new WeakReference<>(runnable);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<Runnable> weakReference = this.u;
            Runnable runnable = weakReference != null ? weakReference.get() : null;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public static void u(final RunnableC0286u runnableC0286u) {
        pb pbVarF = dw.nr().f();
        final String strU = pbVarF == null ? null : pbVarF.u();
        if (TextUtils.isEmpty(strU)) {
            return;
        }
        if (TextUtils.isEmpty(nr)) {
            nr = strU;
        }
        x.nr(new a("loadPfJs") { // from class: com.bytedance.sdk.openadsdk.core.sx.u.1
            @Override // java.lang.Runnable
            public void run() {
                RunnableC0286u runnableC0286u2;
                String str = strU;
                if (str != null && str.equalsIgnoreCase(u.nr)) {
                    if (TextUtils.isEmpty(u.u)) {
                        u.u = bf.u("js_pform").get(com.bytedance.sdk.component.utils.x.nr(strU), "");
                    }
                    if (!TextUtils.isEmpty(u.u) && (runnableC0286u2 = runnableC0286u) != null) {
                        runnableC0286u2.run();
                        return;
                    }
                }
                fx fxVarFx = pn.u().nr().fx();
                fxVarFx.u(strU);
                HashMap map = new HashMap();
                map.put("content-type", "application/json; charset=utf-8");
                fxVarFx.b(map);
                fxVarFx.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.sx.u.1.1
                    @Override // com.bytedance.sdk.component.a.u.u
                    public void u(b bVar, IOException iOException) {
                    }

                    @Override // com.bytedance.sdk.component.a.u.u
                    public void u(b bVar, nr nrVar) {
                        try {
                            u.u = nrVar.pn();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            u.nr = strU;
                            RunnableC0286u runnableC0286u3 = runnableC0286u;
                            if (runnableC0286u3 != null) {
                                runnableC0286u3.run();
                            }
                            bf.u("js_pform").clear();
                            bf.u("js_pform").put(com.bytedance.sdk.component.utils.x.nr(strU), u.u);
                        } catch (Throwable th) {
                            k.u("performanceH5", "TTWebViewClient : onPageFinished", th);
                        }
                    }
                });
            }
        });
    }

    public static void u(StringBuilder sb, String str, String str2) {
        int iIndexOf;
        if (sb == null || TextUtils.isEmpty(str) || (iIndexOf = sb.indexOf(str)) <= 0) {
            return;
        }
        sb.replace(iIndexOf, str.length() + iIndexOf, str2);
    }
}
