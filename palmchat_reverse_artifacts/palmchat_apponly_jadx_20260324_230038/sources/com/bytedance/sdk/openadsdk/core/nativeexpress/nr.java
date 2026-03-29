package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.bg.u;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class nr extends com.bytedance.sdk.openadsdk.my.fx.nr.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Dialog f5343a;
    protected u n;
    private Integer[] u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements com.bytedance.sdk.openadsdk.core.l.nr.u {
        private String nr;
        private WeakReference<com.bytedance.sdk.openadsdk.core.l.nr.u> u;

        public u(com.bytedance.sdk.openadsdk.core.l.nr.u uVar, String str) {
            this.nr = "";
            this.u = new WeakReference<>(uVar);
            this.nr = str;
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void fx(long j, long j2, String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.l.nr.u> weakReference = this.u;
            if (weakReference != null && weakReference.get() != null) {
                this.u.get().fx(j, j2, str, str2);
            }
            if (j > 0) {
                u.C0239u.u(this.nr, 4, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void nr(long j, long j2, String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.l.nr.u> weakReference = this.u;
            if (weakReference != null && weakReference.get() != null) {
                this.u.get().nr(j, j2, str, str2);
            }
            if (j > 0) {
                u.C0239u.u(this.nr, 2, (int) ((j2 * 100) / j));
            }
        }

        public void u(com.bytedance.sdk.openadsdk.core.l.nr.u uVar) {
            this.u = new WeakReference<>(uVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void u() {
            WeakReference<com.bytedance.sdk.openadsdk.core.l.nr.u> weakReference = this.u;
            if (weakReference != null && weakReference.get() != null) {
                this.u.get().u();
            }
            u.C0239u.u(this.nr, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void u(long j, long j2, String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.l.nr.u> weakReference = this.u;
            if (weakReference != null && weakReference.get() != null) {
                this.u.get().u(j, j2, str, str2);
            }
            if (j > 0) {
                u.C0239u.u(this.nr, 3, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void u(long j, String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.l.nr.u> weakReference = this.u;
            if (weakReference != null && weakReference.get() != null) {
                this.u.get().u(j, str, str2);
            }
            u.C0239u.u(this.nr, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
        public void u(String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.l.nr.u> weakReference = this.u;
            if (weakReference != null && weakReference.get() != null) {
                this.u.get().u(str, str2);
            }
            u.C0239u.u(this.nr, 6, 100);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public int b() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public com.bytedance.sdk.openadsdk.my.fx.nr.b fx() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void iz() {
        if (x() != null) {
            com.bytedance.sdk.openadsdk.core.c.u(x().dv());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public Map<String, Object> n() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public int nr() {
        return 0;
    }

    public com.bytedance.sdk.openadsdk.core.multipro.nr.u t() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public View u() {
        return null;
    }

    public abstract bc x();

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void nr(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public com.bytedance.sdk.openadsdk.my.fx.nr.x u(Activity activity) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(Activity activity, com.bytedance.sdk.openadsdk.bg.u.nr.u.u uVar) {
    }

    public void u(Dialog dialog) {
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(com.bytedance.sdk.openadsdk.kj.u.nr.u.fx fxVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(com.bytedance.sdk.openadsdk.kj.u.nr.u.nr nrVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(com.bytedance.sdk.openadsdk.kj.u.nr.u.u uVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(Double d, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(Dialog dialog, Integer[] numArr) {
        this.f5343a = dialog;
        this.u = numArr;
        try {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.nr.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    if (nr.this.x() != null) {
                        nr nrVar = nr.this;
                        nrVar.u(nrVar.x().vz());
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
        } catch (Throwable unused) {
        }
        u(this.f5343a);
    }

    public void u(com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar) {
        Dialog dialog;
        if (nrVar == null || (dialog = this.f5343a) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.u.nr.u(nrVar, dialog, this.u);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(com.bytedance.sdk.openadsdk.my.fx.u.nr nrVar) {
        if (x() != null) {
            com.bytedance.sdk.openadsdk.core.c.u(x().dv(), nrVar, com.bytedance.sdk.openadsdk.my.fx.u.nr.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void pn() {
    }
}
