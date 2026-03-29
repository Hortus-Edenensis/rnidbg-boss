package com.bytedance.sdk.openadsdk.core.nativeexpress;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class l implements t {
    private Queue<Runnable> nr = new LinkedList();
    private WeakReference<t> u;

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void a() {
        WeakReference<t> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            this.nr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.l.13
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.u == null || l.this.u.get() == null) {
                        return;
                    }
                    ((t) l.this.u.get()).a();
                }
            });
        } else {
            this.u.get().a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void b(final int i) {
        WeakReference<t> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            this.nr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.l.16
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.u == null || l.this.u.get() == null) {
                        return;
                    }
                    ((t) l.this.u.get()).b(i);
                }
            });
        } else {
            this.u.get().b(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public int fx() {
        WeakReference<t> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return this.u.get().fx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void iz() {
        WeakReference<t> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            this.nr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.l.8
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.u == null || l.this.u.get() == null) {
                        return;
                    }
                    ((t) l.this.u.get()).iz();
                }
            });
        } else {
            this.u.get().iz();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void jk() {
        WeakReference<t> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            this.nr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.l.14
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.u == null || l.this.u.get() == null) {
                        return;
                    }
                    ((t) l.this.u.get()).jk();
                }
            });
        } else {
            this.u.get().jk();
        }
    }

    public t l() {
        WeakReference<t> weakReference = this.u;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void n() {
        WeakReference<t> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            this.nr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.l.11
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.u == null || l.this.u.get() == null) {
                        return;
                    }
                    ((t) l.this.u.get()).n();
                }
            });
        } else {
            this.u.get().n();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public int nr() {
        WeakReference<t> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return this.u.get().nr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void pn() {
        WeakReference<t> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            this.nr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.l.4
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.u == null || l.this.u.get() == null) {
                        return;
                    }
                    ((t) l.this.u.get()).pn();
                }
            });
        } else {
            this.u.get().pn();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void setPauseFromExpressView(final boolean z) {
        WeakReference<t> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            this.nr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.l.6
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.u == null || l.this.u.get() == null) {
                        return;
                    }
                    ((t) l.this.u.get()).setPauseFromExpressView(z);
                }
            });
        } else {
            this.u.get().setPauseFromExpressView(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void t() {
        WeakReference<t> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            this.nr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.l.15
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.u == null || l.this.u.get() == null) {
                        return;
                    }
                    ((t) l.this.u.get()).t();
                }
            });
        } else {
            this.u.get().t();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void x() {
        WeakReference<t> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            this.nr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.l.10
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.u == null || l.this.u.get() == null) {
                        return;
                    }
                    ((t) l.this.u.get()).x();
                }
            });
        } else {
            this.u.get().x();
        }
    }

    public void u(t tVar) {
        this.u = new WeakReference<>(tVar);
        while (!this.nr.isEmpty()) {
            try {
                Runnable runnablePoll = this.nr.poll();
                if (runnablePoll != null) {
                    runnablePoll.run();
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void fx(final int i) {
        WeakReference<t> weakReference = this.u;
        if (weakReference != null && weakReference.get() != null) {
            this.u.get().fx(i);
        } else {
            this.nr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.l.9
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.u == null || l.this.u.get() == null) {
                        return;
                    }
                    ((t) l.this.u.get()).fx(i);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void nr(final int i) {
        WeakReference<t> weakReference = this.u;
        if (weakReference != null && weakReference.get() != null) {
            this.u.get().nr(i);
        } else {
            this.nr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.l.3
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.u == null || l.this.u.get() == null) {
                        return;
                    }
                    ((t) l.this.u.get()).nr(i);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void b() {
        WeakReference<t> weakReference = this.u;
        if (weakReference != null && weakReference.get() != null) {
            this.u.get().b();
        } else {
            this.nr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.l.2
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.u == null || l.this.u.get() == null) {
                        return;
                    }
                    ((t) l.this.u.get()).b();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(final boolean z) {
        WeakReference<t> weakReference = this.u;
        if (weakReference != null && weakReference.get() != null) {
            this.u.get().u(z);
        } else {
            this.nr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.l.1
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.u == null || l.this.u.get() == null) {
                        return;
                    }
                    ((t) l.this.u.get()).u(z);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(final int i) {
        WeakReference<t> weakReference = this.u;
        if (weakReference != null && weakReference.get() != null) {
            this.u.get().u(i);
        } else {
            this.nr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.l.12
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.u == null || l.this.u.get() == null) {
                        return;
                    }
                    ((t) l.this.u.get()).u(i);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public long u() {
        WeakReference<t> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            return 0L;
        }
        return this.u.get().u();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(final float f, final float f2, final float f3, final float f4, final int i) {
        WeakReference<t> weakReference = this.u;
        if (weakReference != null && weakReference.get() != null) {
            this.u.get().u(f, f2, f3, f4, i);
        } else {
            this.nr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.l.17
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.u == null || l.this.u.get() == null) {
                        return;
                    }
                    ((t) l.this.u.get()).u(f, f2, f3, f4, i);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(final int i, final String str) {
        WeakReference<t> weakReference = this.u;
        if (weakReference != null && weakReference.get() != null) {
            this.u.get().u(i, str);
        } else {
            this.nr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.l.5
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.u == null || l.this.u.get() == null) {
                        return;
                    }
                    ((t) l.this.u.get()).u(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
    public void u(final float f) {
        WeakReference<t> weakReference = this.u;
        if (weakReference != null && weakReference.get() != null) {
            this.u.get().u(f);
        } else {
            this.nr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.l.7
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.u == null || l.this.u.get() == null) {
                        return;
                    }
                    ((t) l.this.u.get()).u(f);
                }
            });
        }
    }
}
