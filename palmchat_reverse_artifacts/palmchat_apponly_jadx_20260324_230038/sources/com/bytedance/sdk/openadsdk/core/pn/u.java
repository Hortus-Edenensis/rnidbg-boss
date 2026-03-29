package com.bytedance.sdk.openadsdk.core.pn;

import android.util.LruCache;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.oa;
import com.bytedance.sdk.openadsdk.my.fx.nr.s;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u<T, V> {
    com.bytedance.sdk.openadsdk.core.pn.pn.b u = new com.bytedance.sdk.openadsdk.core.pn.pn.b(u());
    private static LruCache<String, Integer> nr = new LruCache<>(20);
    private static LruCache<String, Integer> fx = new LruCache<>(20);

    public static LruCache<String, Integer> fx() {
        return fx;
    }

    public static LruCache<String, Integer> nr() {
        return nr;
    }

    public abstract int u();

    public oa u(boolean z, boolean z2, long j, int i, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        oa oaVar = new oa();
        oaVar.n = j;
        if (z) {
            oaVar.u = 2;
        }
        if (z2) {
            oaVar.iz = 2;
        }
        if (nrVar != null) {
            oaVar.u(i, nrVar.b(), nrVar.l());
        } else {
            oaVar.u(i, "", 1);
        }
        return oaVar;
    }

    public abstract void u(T t, int i, String str);

    public abstract void u(T t, V v);

    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final T t, long j) {
        final oa oaVarU = u(false, false, j, u(), nrVar);
        com.bytedance.sdk.openadsdk.core.pn.pn.b bVar = this.u;
        if (bVar != null) {
            bVar.u(nrVar, oaVarU, -1, new com.bytedance.sdk.openadsdk.core.pn.pn.pn<V>() { // from class: com.bytedance.sdk.openadsdk.core.pn.u.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.bytedance.sdk.openadsdk.core.pn.pn.pn
                public void u(V v, boolean z) {
                    oaVarU.u(v, z ? 3 : 2);
                    nrVar.b();
                    u.this.u(t, v);
                }

                @Override // com.bytedance.sdk.openadsdk.core.pn.pn.pn
                public void u(V v) {
                    nrVar.b();
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.bytedance.sdk.openadsdk.core.pn.pn.pn
                public void u(int i, String str) {
                    oaVarU.u((Object) null, 1);
                    nrVar.b();
                    u.this.u(t, i, str);
                }
            });
        }
    }

    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final com.bytedance.sdk.openadsdk.bq.u.nr.u.iz izVar, long j) {
        final oa oaVarU = u(false, true, j, u(), nrVar);
        com.bytedance.sdk.openadsdk.core.pn.pn.b bVar = this.u;
        if (bVar != null) {
            bVar.u(nrVar, oaVarU, -1, new com.bytedance.sdk.openadsdk.core.pn.pn.pn<List<s>>() { // from class: com.bytedance.sdk.openadsdk.core.pn.u.2
                @Override // com.bytedance.sdk.openadsdk.core.pn.pn.pn
                public void u(List<s> list, boolean z) {
                    oaVarU.u(list, z ? 3 : 2);
                    nrVar.b();
                    com.bytedance.sdk.openadsdk.bq.u.nr.u.iz izVar2 = izVar;
                    if (izVar2 != null) {
                        izVar2.u(list);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.pn.pn.pn
                public void u(List<s> list) {
                    nrVar.b();
                }

                @Override // com.bytedance.sdk.openadsdk.core.pn.pn.pn
                public void u(int i, String str) {
                    oaVarU.u((Object) null, 1);
                    nrVar.b();
                    com.bytedance.sdk.openadsdk.bq.u.nr.u.iz izVar2 = izVar;
                    if (izVar2 != null) {
                        izVar2.u(i, str);
                    }
                }
            });
        }
    }

    public static u u(int i) {
        if (i == 1) {
            return com.bytedance.sdk.openadsdk.core.component.u.u.b();
        }
        if (i == 9) {
            return com.bytedance.sdk.openadsdk.core.component.nr.u.b();
        }
        if (i == 5) {
            return com.bytedance.sdk.openadsdk.core.component.fx.u.b();
        }
        if (i != 6) {
            return null;
        }
        return com.bytedance.sdk.openadsdk.core.component.b.u.b();
    }

    public void u(bc bcVar) {
        com.bytedance.sdk.openadsdk.core.pn.pn.b bVar = this.u;
        if (bVar != null) {
            bVar.u().u(bcVar);
        }
    }

    public static void u(int i, bc bcVar) {
        u uVarU = u(i);
        if (uVarU != null) {
            uVarU.u(bcVar);
        }
    }
}
