package com.bytedance.sdk.openadsdk.core.component.splash.fx.u;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.kj.tm;
import com.bytedance.sdk.openadsdk.core.kj.za;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.y.jp;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5263a;
    private int b;
    private int iz;
    private boolean jk;
    private boolean l;
    private boolean mv;
    private com.bykv.vk.openvk.component.video.api.fx.b n;
    private com.bytedance.sdk.openadsdk.mv.nr pn;
    private com.bytedance.sdk.openadsdk.core.kj.u t;
    private int x;

    public nr(bc bcVar, boolean z) {
        if (bcVar == null) {
            return;
        }
        this.nr = bcVar;
        this.mv = z;
        this.l = tk.u(bcVar) == 2;
        nr(bcVar);
    }

    private boolean fx(bc bcVar) {
        return tk.u(bcVar) == 2;
    }

    private void iz(bc bcVar) {
        this.n = zx.k(bcVar);
        this.f5263a = jp.t(bcVar);
        this.jk = bcVar.az();
    }

    private void nr(bc bcVar) {
        int iJu = bcVar.ju();
        za zaVarIz = tk.iz(bcVar);
        tm tmVarX = tk.x(bcVar);
        if (TextUtils.isEmpty(zx.u(bcVar))) {
            this.b = 1;
        } else if (fx(bcVar)) {
            if (u(zaVarIz) || u(tmVarX)) {
                this.b = 2;
            } else {
                if (nr(zaVarIz) || nr(tmVarX)) {
                    tk.u(bcVar, 1);
                }
                this.b = 1;
            }
        } else if (iJu == 1) {
            this.b = 1;
        } else {
            this.b = 2;
        }
        b(bcVar);
    }

    private void pn(bc bcVar) {
        rh rhVar;
        if (bcVar.zu() == null || (rhVar = bcVar.zu().get(0)) == null) {
            return;
        }
        String strU = rhVar.u();
        if (TextUtils.isEmpty(strU)) {
            return;
        }
        this.iz = rhVar.nr();
        this.x = rhVar.fx();
        this.pn = new com.bytedance.sdk.openadsdk.mv.nr(strU, rhVar.x());
    }

    private boolean u(za zaVar) {
        return zaVar != null && u(zaVar.n()) == 2;
    }

    public int a() {
        return this.f5263a;
    }

    public boolean b() {
        return this.b == 2;
    }

    public boolean jk() {
        return this.jk;
    }

    public com.bytedance.sdk.openadsdk.core.kj.u l() {
        return this.t;
    }

    public boolean mv() {
        return this.l;
    }

    public com.bykv.vk.openvk.component.video.api.fx.b n() {
        return this.n;
    }

    public boolean s() {
        return this.mv;
    }

    public int t() {
        return this.b;
    }

    public int x() {
        return this.x;
    }

    private void b(bc bcVar) {
        pn(bcVar);
        iz(bcVar);
    }

    private boolean u(tm tmVar) {
        return tmVar != null && tmVar.x() == 2;
    }

    private int u(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public int iz() {
        return this.iz;
    }

    public void u(com.bytedance.sdk.openadsdk.core.kj.u uVar) {
        this.t = uVar;
    }

    public void u(boolean z) {
        this.mv = z;
    }

    public com.bytedance.sdk.openadsdk.mv.nr pn() {
        return this.pn;
    }

    private boolean nr(za zaVar) {
        return zaVar != null && u(zaVar.n()) == 0;
    }

    private boolean nr(tm tmVar) {
        return tmVar != null && tmVar.x() == 0;
    }
}
