package com.bytedance.adsdk.ugeno;

import android.content.Context;
import com.bytedance.adsdk.ugeno.pn.jk;
import com.bytedance.adsdk.ugeno.pn.n;
import com.bytedance.adsdk.ugeno.pn.pn;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {
    private static volatile b u;
    private u b;
    private com.bytedance.adsdk.ugeno.fx.fx fx;
    private com.bytedance.adsdk.ugeno.fx.nr.b iz;
    private List<com.bytedance.adsdk.ugeno.fx.nr> nr;
    private com.bytedance.adsdk.ugeno.b.u pn;
    private com.bytedance.adsdk.ugeno.fx.u.u x;

    private b() {
    }

    private void iz() {
        ArrayList arrayList = new ArrayList();
        this.nr = arrayList;
        com.bytedance.adsdk.ugeno.fx.fx fxVar = this.fx;
        if (fxVar != null) {
            arrayList.addAll(fxVar.u());
        }
        com.bytedance.adsdk.ugeno.fx.b.u(this.nr);
    }

    public static b u() {
        if (u == null) {
            synchronized (b.class) {
                if (u == null) {
                    u = new b();
                }
            }
        }
        return u;
    }

    public com.bytedance.adsdk.ugeno.fx.nr.b b() {
        return this.iz;
    }

    public com.bytedance.adsdk.ugeno.b.u fx() {
        return this.pn;
    }

    public u nr() {
        return this.b;
    }

    public com.bytedance.adsdk.ugeno.fx.u.u pn() {
        return this.x;
    }

    public void u(Context context, com.bytedance.adsdk.ugeno.fx.fx fxVar, u uVar) {
        this.fx = fxVar;
        this.b = uVar;
        iz();
    }

    public void u(com.bytedance.adsdk.ugeno.b.u uVar) {
        this.pn = uVar;
    }

    public void u(n nVar) {
        ArrayList arrayList = new ArrayList(new com.bytedance.adsdk.ugeno.pn.u().u());
        if (nVar != null) {
            arrayList.addAll(nVar.u());
        }
        jk.u(arrayList);
    }

    public void u(com.bytedance.adsdk.ugeno.pn.fx fxVar) {
        ArrayList arrayList = new ArrayList(new pn().u());
        if (fxVar != null) {
            arrayList.addAll(fxVar.u());
        }
        com.bytedance.adsdk.ugeno.pn.b.u(arrayList);
    }

    public void u(com.bytedance.adsdk.ugeno.fx.nr.b bVar) {
        this.iz = bVar;
    }

    public void u(com.bytedance.adsdk.ugeno.fx.u.u uVar) {
        this.x = uVar;
    }
}
