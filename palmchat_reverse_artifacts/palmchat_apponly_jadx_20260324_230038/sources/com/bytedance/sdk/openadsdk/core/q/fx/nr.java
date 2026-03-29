package com.bytedance.sdk.openadsdk.core.q.fx;

import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.q.iz;
import com.bytedance.sdk.openadsdk.core.q.pn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends com.bytedance.sdk.openadsdk.core.q.nr<com.bytedance.sdk.openadsdk.core.q.b.nr, com.bytedance.sdk.openadsdk.core.component.nr> {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.q.fx.nr$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] u;

        static {
            int[] iArr = new int[com.bytedance.sdk.openadsdk.core.q.b.nr.values().length];
            u = iArr;
            try {
                iArr[com.bytedance.sdk.openadsdk.core.q.b.nr.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                u[com.bytedance.sdk.openadsdk.core.q.b.nr.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                u[com.bytedance.sdk.openadsdk.core.q.b.nr.SHOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                u[com.bytedance.sdk.openadsdk.core.q.b.nr.CLICK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                u[com.bytedance.sdk.openadsdk.core.q.b.nr.END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public nr(String str) {
        this.fx = new com.bytedance.sdk.openadsdk.core.component.nr(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.bytedance.sdk.openadsdk.core.q.b.nr] */
    public void b() {
        ?? r0 = com.bytedance.sdk.openadsdk.core.q.b.nr.CLICK;
        this.nr = r0;
        u((com.bytedance.sdk.openadsdk.core.q.b.nr) r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.bytedance.sdk.openadsdk.core.q.b.nr] */
    public void fx() {
        ?? r0 = com.bytedance.sdk.openadsdk.core.q.b.nr.SHOW;
        this.nr = r0;
        u((com.bytedance.sdk.openadsdk.core.q.b.nr) r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.bytedance.sdk.openadsdk.core.q.b.nr] */
    public void nr() {
        ?? r0 = com.bytedance.sdk.openadsdk.core.q.b.nr.START;
        this.nr = r0;
        u((com.bytedance.sdk.openadsdk.core.q.b.nr) r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.bytedance.sdk.openadsdk.core.q.b.nr] */
    public void pn() {
        ?? r0 = com.bytedance.sdk.openadsdk.core.q.b.nr.END;
        this.nr = r0;
        u((com.bytedance.sdk.openadsdk.core.q.b.nr) r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.bytedance.sdk.openadsdk.core.q.b.nr] */
    public void u() {
        ?? r0 = com.bytedance.sdk.openadsdk.core.q.b.nr.CREATE;
        this.nr = r0;
        u((com.bytedance.sdk.openadsdk.core.q.b.nr) r0);
    }

    private void u(final com.bytedance.sdk.openadsdk.core.q.b.nr nrVar) {
        final iz izVar = new iz(System.currentTimeMillis());
        jk.fx().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.q.fx.nr.1
            @Override // java.lang.Runnable
            public void run() {
                for (pn pnVar : ((com.bytedance.sdk.openadsdk.core.q.nr) nr.this).u) {
                    if (pnVar instanceof com.bytedance.sdk.openadsdk.core.q.nr.nr) {
                        int i = AnonymousClass2.u[nrVar.ordinal()];
                        if (i == 1) {
                            ((com.bytedance.sdk.openadsdk.core.q.nr.nr) pnVar).u(nr.this.getContext(), izVar);
                        } else if (i == 2) {
                            ((com.bytedance.sdk.openadsdk.core.q.nr.nr) pnVar).nr(nr.this.getContext(), izVar);
                        } else if (i == 3) {
                            ((com.bytedance.sdk.openadsdk.core.q.nr.nr) pnVar).fx(nr.this.getContext(), izVar);
                        } else if (i == 4) {
                            ((com.bytedance.sdk.openadsdk.core.q.nr.nr) pnVar).b(nr.this.getContext(), izVar);
                        } else if (i == 5) {
                            ((com.bytedance.sdk.openadsdk.core.q.nr.nr) pnVar).pn(nr.this.getContext(), izVar);
                        }
                    }
                }
            }
        });
    }
}
