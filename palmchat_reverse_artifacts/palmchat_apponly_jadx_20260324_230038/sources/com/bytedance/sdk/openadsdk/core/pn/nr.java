package com.bytedance.sdk.openadsdk.core.pn;

import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.pn.u;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.n;
import com.bytedance.sdk.openadsdk.core.kj.oa;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.pn.pn.x;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.gi.t;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class nr<V> extends com.bytedance.sdk.openadsdk.core.pn.u.u<V> {
    protected com.bytedance.sdk.openadsdk.core.pn.pn.nr u;

    /* JADX INFO: compiled from: SearchBox */
    public interface u<V> {
        void u(V v);
    }

    public nr(com.bytedance.sdk.openadsdk.core.pn.pn.nr nrVar) {
        this.u = nrVar;
    }

    public abstract void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list, u<V> uVar);

    public abstract void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list, V v);

    @Override // com.bytedance.sdk.openadsdk.core.pn.u.u
    public boolean u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.u.u
    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, int i, String str, com.bytedance.sdk.openadsdk.core.kj.nr nrVar2) {
        nrVar2.u(i);
        com.bytedance.sdk.openadsdk.core.kj.nr.u(nrVar2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.u.u
    public void u(int i, com.bytedance.sdk.openadsdk.core.kj.u uVar, com.bytedance.sdk.openadsdk.core.kj.nr nrVar, oa oaVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar2, com.bytedance.sdk.openadsdk.core.pn.pn.pn<V> pnVar, x xVar) {
        if (uVar.nr() == null || uVar.nr().isEmpty()) {
            if (xVar != null) {
                xVar.u(-3);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (uVar.nr().size() > 1 && n.u(i).u("mix_ad", nrVar2, uVar.nr().get(0))) {
            com.bytedance.sdk.openadsdk.core.u.u(uVar.nr());
            arrayList.add(uVar.nr().get(0));
        } else {
            arrayList.addAll(uVar.nr());
        }
        for (bc bcVar : arrayList) {
            if (bcVar.fq()) {
                if (bcVar.qn() <= 0) {
                    bcVar.pn((System.currentTimeMillis() + 10500000) / 1000);
                }
                u(i, nrVar2, bcVar);
            }
        }
        if (arrayList.isEmpty()) {
            if (xVar != null) {
                xVar.u(-4);
            }
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong(f.p, oaVar.n);
            u(i, arrayList, nrVar2, pnVar, bundle, xVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.u.u
    public void u(final int i, final List<bc> list, final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final com.bytedance.sdk.openadsdk.core.pn.pn.pn<V> pnVar, final Bundle bundle, final x xVar) {
        boolean z = bundle.getBoolean("is_cache", false);
        for (bc bcVar : list) {
            bcVar.n(z);
            bcVar.oa(z ? 101 : 102);
        }
        u(nrVar, list, (u) new u<V>() { // from class: com.bytedance.sdk.openadsdk.core.pn.nr.1
            @Override // com.bytedance.sdk.openadsdk.core.pn.nr.u
            public void u(V v) {
                com.bytedance.sdk.openadsdk.core.pn.pn.fx fxVarU = nr.this.u(i, nrVar, v, (List<bc>) list, bundle, pnVar);
                x xVar2 = xVar;
                if (xVar2 != null) {
                    xVar2.u(fxVarU);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.pn.pn.fx u(final int i, final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final V v, final List<bc> list, Bundle bundle, final com.bytedance.sdk.openadsdk.core.pn.pn.pn<V> pnVar) {
        final long j = bundle.getLong(f.p);
        final boolean z = bundle.getBoolean("is_cache");
        Iterator<bc> it = list.iterator();
        while (it.hasNext()) {
            it.next().pm().nr();
        }
        final bc bcVar = list.get(0);
        return new com.bytedance.sdk.openadsdk.core.pn.pn.fx() { // from class: com.bytedance.sdk.openadsdk.core.pn.nr.2
            private final AtomicBoolean jk = new AtomicBoolean(false);

            @Override // com.bytedance.sdk.openadsdk.core.pn.pn.fx
            public void fx() {
                if (this.jk.compareAndSet(false, true)) {
                    nr.this.u(z, nrVar, list);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.sdk.openadsdk.core.pn.pn.fx
            public void u() {
                nr.this.u(nrVar, (List<bc>) list, v);
                com.bytedance.sdk.openadsdk.core.s.b.nr(bcVar, jp.nr(i), j);
                com.bytedance.sdk.openadsdk.core.pn.pn.pn pnVar2 = pnVar;
                if (pnVar2 != null) {
                    pnVar2.u(v, z);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pn.pn.fx
            public void nr() {
            }
        };
    }

    public void u(boolean z, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list) {
        if (z) {
            com.bytedance.sdk.openadsdk.core.pn.pn.nr nrVar2 = this.u;
            if (nrVar2 != null) {
                nrVar2.u().nr(nrVar, list);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.pn.pn.nr nrVar3 = this.u;
        if (nrVar3 != null) {
            nrVar3.u().u(nrVar, list);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.u.u
    public void u(int i, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, bc bcVar) {
        if ((!bc.u(bcVar) || t.u(bcVar)) && !TextUtils.isEmpty(zx.u(bcVar))) {
            if (dw.nr().b(String.valueOf(jp.t(bcVar))) && dw.nr().nu()) {
                if (zx.k(bcVar) != null) {
                    zx.k(bcVar).pn(1);
                }
                if (zx.my(bcVar) != null) {
                    zx.my(bcVar).pn(1);
                }
                com.bykv.vk.openvk.component.video.api.fx.iz izVarU = zx.u(4, bcVar);
                izVarU.u("material_meta", bcVar);
                izVarU.u("ad_slot", Integer.valueOf(i));
                com.bytedance.sdk.openadsdk.core.video.b.nr.u(izVarU, (u.InterfaceC0155u) null);
            }
        }
    }
}
