package com.bytedance.sdk.openadsdk.core.pn.fx;

import android.text.TextUtils;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.n;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.gi.x;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements com.bytedance.sdk.openadsdk.core.pn.fx.u {
    static ReferenceQueue<Object> nr = new ReferenceQueue<>();
    private final int fx;
    Map<Object, u> u = new ConcurrentHashMap();

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        String nr;
        String u;

        public u(String str, String str2) {
            this.u = str;
            this.nr = str2;
        }
    }

    public b(int i) {
        this.fx = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void nr(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final List<bc> list) {
        if (TextUtils.isEmpty(nrVar.dw())) {
            x.b(new a("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.pn.fx.b.3
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    for (bc bcVar : list) {
                        if (bcVar.qn() <= 0) {
                            bcVar.pn((10500000 + jCurrentTimeMillis) / 1000);
                        }
                        com.bytedance.sdk.openadsdk.core.pn.b.pn.u(b.this.fx).u(nrVar.b(), bcVar.nu(), false);
                        int unused = b.this.fx;
                        nrVar.b();
                        System.currentTimeMillis();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public boolean u(String str) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void nr(String str) {
        System.currentTimeMillis();
        for (Reference<? extends Object> referencePoll = nr.poll(); referencePoll != null; referencePoll = nr.poll()) {
            u uVar = this.u.get(referencePoll);
            if (uVar != null) {
                com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.fx).u(uVar.u, uVar.nr, false);
            }
        }
        com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.fx).nr(str);
        System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.fx).fx(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final bc bcVar) {
        if (TextUtils.isEmpty(nrVar.dw())) {
            if (bcVar.qn() <= 0) {
                bcVar.pn((System.currentTimeMillis() + 10500000) / 1000);
            }
            x.b(new a("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.pn.fx.b.1
                @Override // java.lang.Runnable
                public void run() {
                    System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.core.pn.b.pn.u(b.this.fx).u(nrVar, bcVar, false);
                    int unused = b.this.fx;
                    nrVar.b();
                    System.currentTimeMillis();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final List<bc> list) {
        if (TextUtils.isEmpty(nrVar.dw())) {
            n.nr nrVarU = n.u(this.fx);
            bc bcVar = list.get(0);
            if (nrVarU != null && bcVar != null) {
                try {
                    if (nrVarU.u("disable_trans_cache", null, bcVar)) {
                        return;
                    }
                } catch (Exception unused) {
                }
            }
            if (((nrVarU != null ? nrVarU.jk() : 0) & 1) == 1) {
                x.b(new a("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.pn.fx.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        for (bc bcVar2 : list) {
                            if (bcVar2.qn() <= 0) {
                                bcVar2.pn((10500000 + jCurrentTimeMillis) / 1000);
                            }
                            com.bytedance.sdk.openadsdk.core.pn.b.pn.u(b.this.fx).u(nrVar, bcVar2, false);
                            int unused2 = b.this.fx;
                            nrVar.b();
                            System.currentTimeMillis();
                        }
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public bc u(String str, long j) {
        n.nr nrVarU = n.u(this.fx);
        System.currentTimeMillis();
        bc bcVarU = com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.fx).u(str, true, j);
        if (bcVarU != null && nrVarU != null) {
            try {
                if (nrVarU.u("delete_on_load", null, bcVarU)) {
                    com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.fx).u(str, bcVarU.nu());
                }
            } catch (Exception unused) {
            }
        }
        System.currentTimeMillis();
        return bcVarU;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public List<bc> u(String str, long j, int i) {
        n.nr nrVarU = n.u(this.fx);
        System.currentTimeMillis();
        List<bc> listU = com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.fx).u(str, true, j, i);
        for (bc bcVar : listU) {
            if (bcVar != null && nrVarU != null) {
                try {
                    if (nrVarU.u("delete_on_load", null, bcVar)) {
                        com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.fx).u(str, bcVar.nu());
                    }
                } catch (Exception unused) {
                }
            }
        }
        listU.size();
        System.currentTimeMillis();
        return listU;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final bc bcVar, final Object obj, final boolean z) {
        final String strB = nrVar.b();
        x.b(new a("PreloadStrategyRecovery-onLoad") { // from class: com.bytedance.sdk.openadsdk.core.pn.fx.b.4
            @Override // java.lang.Runnable
            public void run() {
                n.nr nrVarU = n.u(b.this.fx);
                if (nrVarU != null) {
                    try {
                        if (nrVarU.u("disable_trans_cache", null, bcVar)) {
                            return;
                        }
                    } catch (Exception unused) {
                    }
                }
                System.currentTimeMillis();
                if (bcVar.ln() != 0) {
                    b.this.u.put(new PhantomReference(obj, b.nr), new u(strB, bcVar.nu()));
                }
                if (z) {
                    return;
                }
                if (((nrVarU != null ? nrVarU.jk() : 0) & 2) == 2) {
                    com.bytedance.sdk.openadsdk.core.pn.b.pn.u(b.this.fx).u(nrVar, bcVar, true);
                    System.currentTimeMillis();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void u(final bc bcVar) {
        final int iT = jp.t(bcVar);
        x.b(new a("PreloadStrategyRecovery-onShow") { // from class: com.bytedance.sdk.openadsdk.core.pn.fx.b.5
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                com.bytedance.sdk.openadsdk.core.pn.b.pn pnVarU = com.bytedance.sdk.openadsdk.core.pn.b.pn.u(b.this.fx);
                StringBuilder sb = new StringBuilder();
                sb.append(iT);
                pnVarU.u(sb.toString(), bcVar.nu());
                System.currentTimeMillis();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.fx.u
    public void u(String str, bc bcVar) {
        com.bytedance.sdk.openadsdk.core.pn.b.pn.u(this.fx).u(str, bcVar.nu());
    }
}
