package com.bytedance.sdk.openadsdk.core.q.u;

import com.bytedance.sdk.openadsdk.core.q.fx;
import com.bytedance.sdk.openadsdk.core.q.iz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends fx<com.bytedance.sdk.openadsdk.core.q.b.nr, com.bytedance.sdk.openadsdk.core.component.nr> {
    private final com.bytedance.sdk.openadsdk.core.q.nr.nr nr = new com.bytedance.sdk.openadsdk.core.q.nr.nr() { // from class: com.bytedance.sdk.openadsdk.core.q.u.nr.1
        @Override // com.bytedance.sdk.openadsdk.core.q.nr.nr
        public void pn(com.bytedance.sdk.openadsdk.core.component.nr nrVar, iz izVar) {
            com.bytedance.sdk.openadsdk.core.q.nr nrVar2;
            if (nrVar == null || nrVar.u() == null || (nrVar2 = (com.bytedance.sdk.openadsdk.core.q.nr) ((fx) nr.this).u.remove(nrVar.u())) == null) {
                return;
            }
            nrVar2.nr(nr.this.nr);
        }

        @Override // com.bytedance.sdk.openadsdk.core.q.nr.nr
        public void b(com.bytedance.sdk.openadsdk.core.component.nr nrVar, iz izVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.q.nr.nr
        public void fx(com.bytedance.sdk.openadsdk.core.component.nr nrVar, iz izVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.q.nr.nr
        public void nr(com.bytedance.sdk.openadsdk.core.component.nr nrVar, iz izVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.q.nr.nr
        public void u(com.bytedance.sdk.openadsdk.core.component.nr nrVar, iz izVar) {
        }
    };

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.q.u.nr$2, reason: invalid class name */
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

    public void fx(String str) {
        if (str == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.q.fx.nr nrVar = new com.bytedance.sdk.openadsdk.core.q.fx.nr(str);
        nrVar.u(this.nr);
        u(str, nrVar);
    }

    public void u(String str, com.bytedance.sdk.openadsdk.core.q.b.nr nrVar, fx.u uVar) {
        com.bytedance.sdk.openadsdk.core.q.nr<com.bytedance.sdk.openadsdk.core.q.b.nr, com.bytedance.sdk.openadsdk.core.component.nr> nrVarU;
        if (uVar != null && str != null && (nrVarU = u(str)) != null) {
            uVar.u(nrVarU.getContext());
        }
        u(str, nrVar);
    }

    public void u(String str, com.bytedance.sdk.openadsdk.core.q.b.nr nrVar) {
        com.bytedance.sdk.openadsdk.core.q.nr<com.bytedance.sdk.openadsdk.core.q.b.nr, com.bytedance.sdk.openadsdk.core.component.nr> nrVarU = u(str);
        if (nrVarU instanceof com.bytedance.sdk.openadsdk.core.q.fx.nr) {
            int i = AnonymousClass2.u[nrVar.ordinal()];
            if (i == 1) {
                ((com.bytedance.sdk.openadsdk.core.q.fx.nr) nrVarU).u();
                return;
            }
            if (i == 2) {
                ((com.bytedance.sdk.openadsdk.core.q.fx.nr) nrVarU).nr();
                return;
            }
            if (i == 3) {
                ((com.bytedance.sdk.openadsdk.core.q.fx.nr) nrVarU).fx();
            } else if (i == 4) {
                ((com.bytedance.sdk.openadsdk.core.q.fx.nr) nrVarU).b();
            } else {
                if (i != 5) {
                    return;
                }
                ((com.bytedance.sdk.openadsdk.core.q.fx.nr) nrVarU).pn();
            }
        }
    }
}
