package com.bytedance.sdk.openadsdk.core.q.u;

import com.bytedance.sdk.openadsdk.core.q.fx;
import com.bytedance.sdk.openadsdk.core.q.iz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends fx<com.bytedance.sdk.openadsdk.core.q.b.u, com.bytedance.sdk.openadsdk.core.component.u> {
    private final com.bytedance.sdk.openadsdk.core.q.nr.u nr = new com.bytedance.sdk.openadsdk.core.q.nr.u() { // from class: com.bytedance.sdk.openadsdk.core.q.u.u.1
        @Override // com.bytedance.sdk.openadsdk.core.q.nr.u
        public void b(com.bytedance.sdk.openadsdk.core.component.u uVar, iz izVar) {
            com.bytedance.sdk.openadsdk.core.q.nr nrVar;
            if (uVar == null || uVar.u() == null || (nrVar = (com.bytedance.sdk.openadsdk.core.q.nr) ((fx) u.this).u.remove(uVar.u())) == null) {
                return;
            }
            nrVar.nr(u.this.nr);
        }

        @Override // com.bytedance.sdk.openadsdk.core.q.nr.u
        public void fx(com.bytedance.sdk.openadsdk.core.component.u uVar, iz izVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.q.nr.u
        public void nr(com.bytedance.sdk.openadsdk.core.component.u uVar, iz izVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.q.nr.u
        public void u(com.bytedance.sdk.openadsdk.core.component.u uVar, iz izVar) {
        }
    };

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.q.u.u$2, reason: invalid class name */
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

    public void fx(String str) {
        if (str == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.q.fx.u uVar = new com.bytedance.sdk.openadsdk.core.q.fx.u(str);
        uVar.u(this.nr);
        u(str, uVar);
    }

    public void u(String str, com.bytedance.sdk.openadsdk.core.q.b.u uVar) {
        com.bytedance.sdk.openadsdk.core.q.nr<com.bytedance.sdk.openadsdk.core.q.b.u, com.bytedance.sdk.openadsdk.core.component.u> nrVarU = u(str);
        if (nrVarU instanceof com.bytedance.sdk.openadsdk.core.q.fx.u) {
            int i = AnonymousClass2.u[uVar.ordinal()];
            if (i == 1) {
                ((com.bytedance.sdk.openadsdk.core.q.fx.u) nrVarU).u();
                return;
            }
            if (i == 2) {
                ((com.bytedance.sdk.openadsdk.core.q.fx.u) nrVarU).nr();
            } else if (i == 3) {
                ((com.bytedance.sdk.openadsdk.core.q.fx.u) nrVarU).fx();
            } else {
                if (i != 4) {
                    return;
                }
                ((com.bytedance.sdk.openadsdk.core.q.fx.u) nrVarU).b();
            }
        }
    }
}
