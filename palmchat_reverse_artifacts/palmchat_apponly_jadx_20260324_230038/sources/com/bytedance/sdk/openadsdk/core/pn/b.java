package com.bytedance.sdk.openadsdk.core.pn;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.pn.u;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.kj.za;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.qq;
import com.bytedance.sdk.openadsdk.core.pn.nr;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.my.fx.nr.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends nr<List<s>> {
    private final int fx;
    List<Long> nr;

    public b(com.bytedance.sdk.openadsdk.core.pn.pn.nr nrVar, int i) {
        super(nrVar);
        this.nr = new CopyOnWriteArrayList();
        this.fx = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list, nr.u<List<s>> uVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<bc> it = list.iterator();
        while (it.hasNext()) {
            s sVarU = u(nrVar, it.next());
            if (sVarU != null) {
                arrayList.add(sVarU);
            }
        }
        if (uVar != null) {
            uVar.u(arrayList);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.nr
    public /* bridge */ /* synthetic */ void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List list, List<s> list2) {
        u2(nrVar, (List<bc>) list, list2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.nr
    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final List<bc> list, final nr.u<List<s>> uVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.nr.add(Long.valueOf(jCurrentTimeMillis));
        final int[] iArr = {0};
        final int[] iArr2 = {list.size()};
        if (dw.nr().ah() > 0) {
            jk.u().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pn.b.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (this) {
                        if (b.this.nr.contains(Long.valueOf(jCurrentTimeMillis))) {
                            b.this.nr.remove(Long.valueOf(jCurrentTimeMillis));
                            b.this.nr(nrVar, list, uVar);
                        }
                    }
                }
            }, dw.nr().ah());
        }
        Iterator<bc> it = list.iterator();
        while (it.hasNext()) {
            final long j = jCurrentTimeMillis;
            u(it.next(), new com.bytedance.sdk.openadsdk.core.ugeno.fx() { // from class: com.bytedance.sdk.openadsdk.core.pn.b.2
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.fx
                public void u(String str) {
                    synchronized (this) {
                        int[] iArr3 = iArr;
                        int i = iArr3[0] + 1;
                        iArr3[0] = i;
                        b.this.u(j, nrVar, (List<bc>) list, (nr.u<List<s>>) uVar, i, iArr2[0]);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.fx
                public void u() {
                    synchronized (this) {
                        int[] iArr3 = iArr2;
                        int i = iArr3[0] - 1;
                        iArr3[0] = i;
                        b.this.u(j, nrVar, (List<bc>) list, (nr.u<List<s>>) uVar, iArr[0], i);
                    }
                }
            });
            jCurrentTimeMillis = jCurrentTimeMillis;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list, nr.u<List<s>> uVar, int i, int i2) {
        if (this.nr.contains(Long.valueOf(j))) {
            if (dw.nr().ln() != 1 || i == i2) {
                this.nr.remove(Long.valueOf(j));
                nr(nrVar, list, uVar);
            }
        }
    }

    private void u(bc bcVar, com.bytedance.sdk.openadsdk.core.ugeno.fx fxVar) {
        if (tk.t(bcVar)) {
            com.bytedance.sdk.openadsdk.core.mv.u.u(bcVar, fxVar);
            return;
        }
        if (tk.jk(bcVar)) {
            za zaVarIz = tk.iz(bcVar);
            if (zaVarIz != null) {
                com.bytedance.sdk.openadsdk.core.ugeno.jk.u(zaVarIz.a(), zaVarIz.jk(), fxVar);
                return;
            }
            return;
        }
        fxVar.u(null);
    }

    /* JADX INFO: renamed from: u, reason: avoid collision after fix types in other method */
    public void u2(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list, List<s> list2) {
        for (int i = 0; i < list2.size(); i++) {
            s sVar = list2.get(i);
            bc bcVar = list.get(i);
            com.bytedance.sdk.openadsdk.core.pn.pn.nr nrVar2 = this.u;
            if (nrVar2 != null) {
                nrVar2.u().u(nrVar, bcVar, sVar, false);
            }
        }
    }

    private s u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, bc bcVar) {
        boolean z = zx.k(bcVar) != null;
        int i = this.fx;
        if (i == 1) {
            if (z) {
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.fx(dw.getContext(), bcVar, nrVar);
            }
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.nr(dw.getContext(), bcVar, nrVar);
        }
        if (i != 5) {
            if (i != 9) {
                return null;
            }
            return new q(dw.getContext(), bcVar, nrVar);
        }
        if (z) {
            return new qq(dw.getContext(), bcVar, nrVar);
        }
        return new c(dw.getContext(), bcVar, nrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.nr, com.bytedance.sdk.openadsdk.core.pn.u.u
    public void u(int i, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, bc bcVar) {
        int i2;
        if (bcVar == null) {
            return;
        }
        String strPn = (nrVar == null || !((i2 = this.fx) == 3 || i2 == 4)) ? null : com.bytedance.sdk.openadsdk.gi.jk.pn();
        com.bytedance.sdk.openadsdk.core.video.fx.u.nr(bcVar);
        if (bcVar.fq() && bcVar.zu() != null && !bcVar.zu().isEmpty()) {
            for (rh rhVar : bcVar.zu()) {
                if (!TextUtils.isEmpty(rhVar.u())) {
                    com.bytedance.sdk.openadsdk.core.gi.pn.u().fx().u(new com.bytedance.sdk.openadsdk.mv.nr(rhVar.u(), rhVar.x()), com.bytedance.sdk.openadsdk.core.gi.u.u.nr(), rhVar.nr(), rhVar.fx(), strPn);
                }
            }
        }
        if (TextUtils.isEmpty(zx.u(bcVar))) {
            return;
        }
        if (dw.nr().b(String.valueOf(jp.t(bcVar))) && dw.nr().nu()) {
            com.bykv.vk.openvk.component.video.api.fx.iz izVarU = zx.u(4, bcVar);
            izVarU.u("material_meta", bcVar);
            izVarU.u("ad_slot", Integer.valueOf(i));
            com.bytedance.sdk.openadsdk.core.video.b.nr.u(izVarU, (u.InterfaceC0155u) null);
        }
    }
}
