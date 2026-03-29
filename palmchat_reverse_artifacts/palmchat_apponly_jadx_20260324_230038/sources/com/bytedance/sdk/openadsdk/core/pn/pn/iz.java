package com.bytedance.sdk.openadsdk.core.pn.pn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz<T> implements pn<T> {
    private final pn<T> u;

    public iz(pn<T> pnVar) {
        this.u = pnVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.pn.pn
    public void u(final T t, final boolean z) {
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pn.pn.iz.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (iz.this.u != null) {
                    iz.this.u.u(t, z);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.pn.pn
    public void u(final T t) {
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pn.pn.iz.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (iz.this.u != null) {
                    iz.this.u.u(t);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.pn.pn
    public void u(final int i, final String str) {
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pn.pn.iz.3
            @Override // java.lang.Runnable
            public void run() {
                if (iz.this.u != null) {
                    iz.this.u.u(i, str);
                }
            }
        });
    }
}
