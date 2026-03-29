package com.bytedance.sdk.openadsdk.core.q.fx;

import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.q.iz;
import com.bytedance.sdk.openadsdk.core.q.pn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends com.bytedance.sdk.openadsdk.core.q.nr<com.bytedance.sdk.openadsdk.core.q.b.u, com.bytedance.sdk.openadsdk.core.component.u> {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.q.fx.u$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] u;

        static {
            int[] iArr = new int[com.bytedance.sdk.openadsdk.core.q.b.u.values().length];
            u = iArr;
            try {
                iArr[com.bytedance.sdk.openadsdk.core.q.b.u.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                u[com.bytedance.sdk.openadsdk.core.q.b.u.REQ.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                u[com.bytedance.sdk.openadsdk.core.q.b.u.RECEIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                u[com.bytedance.sdk.openadsdk.core.q.b.u.LOADED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public u(String str) {
        this.fx = new com.bytedance.sdk.openadsdk.core.component.u(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.bytedance.sdk.openadsdk.core.q.b.u] */
    public void b() {
        ?? r0 = com.bytedance.sdk.openadsdk.core.q.b.u.LOADED;
        this.nr = r0;
        u((com.bytedance.sdk.openadsdk.core.q.b.u) r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.bytedance.sdk.openadsdk.core.q.b.u] */
    public void fx() {
        ?? r0 = com.bytedance.sdk.openadsdk.core.q.b.u.RECEIVE;
        this.nr = r0;
        u((com.bytedance.sdk.openadsdk.core.q.b.u) r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.bytedance.sdk.openadsdk.core.q.b.u] */
    public void nr() {
        ?? r0 = com.bytedance.sdk.openadsdk.core.q.b.u.REQ;
        this.nr = r0;
        u((com.bytedance.sdk.openadsdk.core.q.b.u) r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.bytedance.sdk.openadsdk.core.q.b.u] */
    public void u() {
        ?? r0 = com.bytedance.sdk.openadsdk.core.q.b.u.START;
        this.nr = r0;
        u((com.bytedance.sdk.openadsdk.core.q.b.u) r0);
    }

    private void u(final com.bytedance.sdk.openadsdk.core.q.b.u uVar) {
        final iz izVar = new iz(System.currentTimeMillis());
        jk.fx().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.q.fx.u.1
            @Override // java.lang.Runnable
            public void run() {
                for (pn pnVar : ((com.bytedance.sdk.openadsdk.core.q.nr) u.this).u) {
                    if (pnVar instanceof com.bytedance.sdk.openadsdk.core.q.nr.u) {
                        int i = AnonymousClass2.u[uVar.ordinal()];
                        if (i == 1) {
                            ((com.bytedance.sdk.openadsdk.core.q.nr.u) pnVar).u(u.this.getContext(), izVar);
                        } else if (i == 2) {
                            ((com.bytedance.sdk.openadsdk.core.q.nr.u) pnVar).nr(u.this.getContext(), izVar);
                        } else if (i == 3) {
                            ((com.bytedance.sdk.openadsdk.core.q.nr.u) pnVar).fx(u.this.getContext(), izVar);
                        } else if (i == 4) {
                            ((com.bytedance.sdk.openadsdk.core.q.nr.u) pnVar).b(u.this.getContext(), izVar);
                        }
                    }
                }
            }
        });
    }
}
