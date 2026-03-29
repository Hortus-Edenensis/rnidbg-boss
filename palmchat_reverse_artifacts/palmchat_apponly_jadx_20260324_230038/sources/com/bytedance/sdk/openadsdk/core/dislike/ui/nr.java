package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.my.fx.nr.iz;
import com.bytedance.sdk.openadsdk.my.fx.nr.x;
import com.kwad.sdk.api.model.AdnName;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HandlerC0258nr f5276a;
    private fx b;
    private b fx;
    private AtomicBoolean iz;
    private u jk;
    private SoftReference<View> n;
    private com.bytedance.sdk.openadsdk.core.dislike.fx.nr nr;
    private TTDislikeToast pn;
    private final List<com.bytedance.sdk.openadsdk.core.dislike.nr.u> t;
    private final Context u;
    private boolean x;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.dislike.ui.nr$nr, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class HandlerC0258nr extends Handler {
        public WeakReference<Context> u;

        public HandlerC0258nr(Context context) {
            this.u = new WeakReference<>(context);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void nr();

        void u();

        void u(int i, String str, boolean z);
    }

    public nr(Context context, com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar, String str, boolean z, final com.bytedance.sdk.openadsdk.core.dislike.ui.u uVar) {
        this.iz = new AtomicBoolean(false);
        this.t = new ArrayList();
        nrVar.nr(str);
        nrVar.u(AdnName.OTHER);
        this.u = context;
        if (context == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            k.u("Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
            return;
        }
        this.nr = nrVar;
        this.x = z;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            u(uVar);
        } else {
            jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.nr.1
                @Override // java.lang.Runnable
                public void run() {
                    nr.this.u(uVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if ((this.u instanceof Activity) && (!((Activity) r0).isFinishing()) && !this.b.isShowing()) {
            this.b.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pn() {
        com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar = this.nr;
        if (nrVar == null) {
            return;
        }
        final String strN = nrVar.n();
        if ("slide_banner_ad".equals(strN) || "banner_ad".equals(strN) || "embeded_ad".equals(strN)) {
            if (this.n.get() != null && this.nr.a()) {
                this.n.get().setVisibility(8);
            }
            if (this.f5276a == null) {
                this.f5276a = new HandlerC0258nr(this.u);
            }
            this.f5276a.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.nr.5
                @Override // java.lang.Runnable
                public void run() {
                    nr.this.nr.nr("dislike");
                    if (nr.this.n == null || nr.this.n.get() == null || !((View) nr.this.n.get()).isShown()) {
                        com.bytedance.sdk.openadsdk.core.dislike.u.u.u().u(nr.this.u, nr.this.nr, "close_success");
                    } else {
                        com.bytedance.sdk.openadsdk.core.dislike.u.u.u().u(nr.this.u, nr.this.nr, "close_fail");
                    }
                    nr.this.nr.nr(strN);
                }
            }, 500L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.x
    public boolean fx() {
        if (!(this.u instanceof Activity)) {
            return false;
        }
        b bVar = this.fx;
        boolean zIsShowing = bVar != null ? bVar.isShowing() : false;
        fx fxVar = this.b;
        return fxVar != null ? zIsShowing | fxVar.isShowing() : zIsShowing;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.x
    public void nr() {
        if (this.u instanceof Activity) {
            b bVar = this.fx;
            if (bVar != null) {
                bVar.hide();
            }
            fx fxVar = this.b;
            if (fxVar != null) {
                fxVar.u();
            }
            TTDislikeToast tTDislikeToast = this.pn;
            if (tTDislikeToast != null) {
                tTDislikeToast.fx();
            }
            this.iz.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.core.dislike.ui.u uVar) {
        ViewGroup viewGroup;
        b bVar = new b(this.u, this.nr, uVar);
        this.fx = bVar;
        bVar.u(new com.bytedance.sdk.openadsdk.core.dislike.nr.fx() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.nr.2
            @Override // com.bytedance.sdk.openadsdk.core.dislike.nr.fx
            public void fx() {
                k.nr("TTAdDislikeImpl", "onDislikeHide: ");
                try {
                    if (nr.this.jk == null || nr.this.fx()) {
                        return;
                    }
                    nr.this.jk.nr();
                } catch (Throwable th) {
                    k.u("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.nr.fx
            public void nr() {
                if (nr.this.jk != null) {
                    nr.this.jk.u();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.nr.fx
            public void u() {
                nr.this.b();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.nr.fx
            public void u(int i, iz izVar) {
                try {
                    if (!nr.this.t.isEmpty()) {
                        String strB = nr.this.b != null ? nr.this.b.b() : "";
                        Iterator it = nr.this.t.iterator();
                        while (it.hasNext()) {
                            ((com.bytedance.sdk.openadsdk.core.dislike.nr.u) it.next()).u(izVar, strB, nr.this.b);
                        }
                    }
                    if (!izVar.x()) {
                        if (nr.this.jk != null) {
                            nr.this.jk.u(i, izVar.nr(), nr.this.nr != null ? nr.this.nr.a() : false);
                        }
                        nr.this.iz.set(true);
                        if ("99:1".equals(izVar.u())) {
                            return;
                        }
                        if (nr.this.pn != null) {
                            nr.this.pn.u();
                        }
                        nr.this.pn();
                    }
                    k.nr("TTAdDislikeImpl", "onDislikeSelected: " + i + ", " + izVar.nr());
                } catch (Throwable th) {
                    k.u("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }
        });
        fx fxVar = new fx(this.u, this.nr);
        this.b = fxVar;
        fxVar.u(new com.bytedance.sdk.openadsdk.core.dislike.nr.nr() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.nr.3
            @Override // com.bytedance.sdk.openadsdk.core.dislike.nr.nr
            public void u() {
                try {
                    if (nr.this.iz.get()) {
                        return;
                    }
                    nr.this.fx.show();
                    if (nr.this.b != null) {
                        String strB = nr.this.b.b();
                        if (TextUtils.isEmpty(strB)) {
                            return;
                        }
                        nr.this.fx.u(strB);
                    }
                } catch (Throwable th) {
                    k.u("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.nr.nr
            public void u(int i, iz izVar) {
                try {
                    if (izVar.x()) {
                        return;
                    }
                    if (nr.this.jk != null) {
                        nr.this.jk.u(i, izVar.nr(), nr.this.nr != null ? nr.this.nr.a() : false);
                    }
                    nr.this.iz.set(true);
                    if (nr.this.pn != null) {
                        nr.this.pn.u();
                    }
                    nr.this.pn();
                } catch (Throwable th) {
                    k.u("TTAdDislikeImpl", "comment callback selected error: ", th);
                }
            }
        });
        if ((this.u instanceof Activity) && this.x) {
            this.pn = new TTDislikeToast(this.u);
            Window window = ((Activity) this.u).getWindow();
            if (window == null || (viewGroup = (ViewGroup) window.getDecorView()) == null) {
                return;
            }
            viewGroup.addView(this.pn);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.x
    public void u() {
        TTDislikeToast tTDislikeToast;
        Context context = this.u;
        boolean z = (context instanceof Activity) && !((Activity) context).isFinishing();
        if (this.iz.get() && this.x && (tTDislikeToast = this.pn) != null) {
            tTDislikeToast.nr();
        } else {
            if (!z || fx()) {
                return;
            }
            this.fx.show();
        }
    }

    public nr(Context context, com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar, boolean z, com.bytedance.sdk.openadsdk.core.dislike.ui.u uVar) {
        this(context, nrVar, null, z, uVar);
    }

    public void u(com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar) {
        if ((this.u instanceof Activity) && nrVar != null) {
            this.fx.u(nrVar);
            this.b.u(nrVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.x
    public void u(final com.bytedance.sdk.openadsdk.bg.u.nr.u.u uVar) {
        this.jk = new u() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.nr.4
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.nr.u
            public void nr() {
                com.bytedance.sdk.openadsdk.bg.u.nr.u.u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.nr();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.nr.u
            public void u() {
                com.bytedance.sdk.openadsdk.bg.u.nr.u.u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.u();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.nr.u
            public void u(int i, String str, boolean z) {
                com.bytedance.sdk.openadsdk.bg.u.nr.u.u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.u(i, str, z);
                }
            }
        };
    }

    public void u(u uVar) {
        this.jk = uVar;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.x
    public void u(String str) {
        com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar = this.nr;
        if (nrVar != null) {
            nrVar.u(str);
        }
    }

    public void u(View view) {
        this.n = new SoftReference<>(view);
    }

    public void u(com.bytedance.sdk.openadsdk.core.dislike.nr.u uVar) {
        this.t.add(uVar);
        fx fxVar = this.b;
        if (fxVar != null) {
            fxVar.u(uVar);
        }
    }
}
