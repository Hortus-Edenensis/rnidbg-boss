package com.bytedance.sdk.openadsdk.core.component.splash.nr.u;

import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x;
import com.bytedance.sdk.openadsdk.core.component.splash.u.pn;
import com.bytedance.sdk.openadsdk.core.component.splash.u.u;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.qq;
import com.bytedance.sdk.openadsdk.core.qq.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private com.bytedance.sdk.openadsdk.my.fx.fx.nr fx;
    private String nr;
    private boolean pn;
    private com.bytedance.sdk.openadsdk.core.component.splash.u.u u;
    private pn x;
    private x b = new x();
    private com.bytedance.sdk.openadsdk.core.pn.nr.u iz = new com.bytedance.sdk.openadsdk.core.pn.nr.u(4);

    public u(com.bytedance.sdk.openadsdk.core.component.splash.u.u uVar) {
        this.u = uVar;
        uVar.nr();
        this.pn = dw.nr().ob();
    }

    public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.pn pnVar, com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr<iz, x> nrVar) {
        if (pnVar == null || nrVar == null) {
            return;
        }
        this.b.nr(true);
        this.fx = pnVar.b();
        this.nr = pnVar.iz();
        this.x = pnVar.x();
        if (com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.pn.u(this.fx, pnVar.pn())) {
            this.b.nr(1);
            this.b.u("no cache");
            nrVar.u(this.b);
            return;
        }
        u(this.nr, nrVar);
    }

    private void u(final String str, final com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr<iz, x> nrVar) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.u.u(this.b, str, new u.InterfaceC0257u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.nr.u.u.1
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.u.u.InterfaceC0257u
            public void u(final iz izVar) {
                com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "缓存读取总耗时： " + (System.currentTimeMillis() - jCurrentTimeMillis));
                if (nrVar == null) {
                    return;
                }
                if (izVar == null || izVar.nr() == null) {
                    if (izVar == null) {
                        u.this.b.nr(1);
                        u.this.b.u("no ad model cache");
                        nrVar.u(u.this.b);
                        return;
                    } else if (izVar.nr() == null) {
                        u.this.b.nr(1);
                        u.this.b.u("no splash material");
                        nrVar.u(u.this.b);
                        return;
                    }
                }
                bc bcVarNr = izVar.nr();
                u.this.iz.u(jCurrentTimeMillis);
                u.this.iz.nr(System.currentTimeMillis());
                ArrayList arrayList = new ArrayList();
                arrayList.add(bcVarNr);
                u.this.iz.u(arrayList, new com.bytedance.sdk.openadsdk.core.pn.nr.pn() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.nr.u.u.1.1
                    @Override // com.bytedance.sdk.openadsdk.core.pn.nr.pn
                    public void fx(List<bc> list) {
                        Iterator<bc> it = list.iterator();
                        while (it.hasNext()) {
                            u.this.u.u(str, it.next());
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.pn.nr.pn
                    public void nr(List<bc> list) {
                        if (list != null && !list.isEmpty()) {
                            nrVar.nr(izVar);
                            return;
                        }
                        u.this.b.nr(22);
                        u.this.b.u("check server cache unavailable");
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        nrVar.u(u.this.b);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.pn.nr.pn
                    public void u(List<bc> list) {
                        if (!u.this.pn) {
                            nrVar.nr(izVar);
                        } else {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            u.this.u(izVar, (com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr<iz, x>) nrVar);
                        }
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.u.u.InterfaceC0257u
            public void u() {
                com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "缓存读取失败");
                com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr nrVar2 = nrVar;
                if (nrVar2 == null) {
                    return;
                }
                nrVar2.u(u.this.b);
            }
        }, this.x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final iz izVar, final com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr<iz, x> nrVar) {
        if (nrVar == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        bc bcVarNr = izVar.nr();
        dw.u().u(bcVarNr.lk(), bcVarNr.ap(), new qq.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.nr.u.u.2
            @Override // com.bytedance.sdk.openadsdk.core.qq.u
            public void u(boolean z, long j, long j2) {
                s.u(u.this.fx, j, j2, System.currentTimeMillis() - jCurrentTimeMillis, 4, 1, z ? 1 : 0);
                if (z) {
                    nrVar.nr(izVar);
                    return;
                }
                u.this.b.nr(22);
                u.this.b.u("check server cache unavailable");
                u.this.b.u(j);
                nrVar.u(u.this.b);
            }
        });
    }
}
