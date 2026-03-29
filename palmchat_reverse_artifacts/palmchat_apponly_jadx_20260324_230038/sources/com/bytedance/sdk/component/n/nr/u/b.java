package com.bytedance.sdk.component.n.nr.u;

import android.content.Context;
import com.bytedance.sdk.component.n.nr.u.u.nr.n;
import com.bytedance.sdk.component.n.nr.u.u.nr.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.component.n.nr.b.nr.u f5158a;
    private x b;
    private com.bytedance.sdk.component.n.nr.u.u.nr.pn fx;
    private n iz;
    private com.bytedance.sdk.component.n.nr.b.nr.u jk;
    private com.bytedance.sdk.component.n.nr.b.nr.u l;
    private com.bytedance.sdk.component.n.u.pn mv;
    private com.bytedance.sdk.component.n.nr.b.nr.u n;
    private com.bytedance.sdk.component.n.nr.u.u.nr.iz nr;
    private com.bytedance.sdk.component.n.nr.u.u.nr.u pn;
    private List<com.bytedance.sdk.component.n.nr.u.u.nr.nr> s = new ArrayList();
    private com.bytedance.sdk.component.n.nr.b.nr.u t;
    private com.bytedance.sdk.component.n.nr.u.u.nr.b u;
    private com.bytedance.sdk.component.n.nr.b.nr.u x;

    public b(com.bytedance.sdk.component.n.u.pn pnVar) {
        this.mv = pnVar;
        Context context = pnVar.getContext();
        if (com.bytedance.sdk.component.n.nr.nr.u.u(pnVar)) {
            com.bytedance.sdk.component.n.nr.b.nr.u uVarX = this.mv.x();
            this.x = uVarX;
            com.bytedance.sdk.component.n.nr.u.u.nr.b bVar = new com.bytedance.sdk.component.n.nr.u.u.nr.b(context, uVarX, this.mv);
            this.u = bVar;
            this.s.add(bVar);
        }
        if (com.bytedance.sdk.component.n.nr.nr.u.pn(pnVar)) {
            if (this.mv.u() != null) {
                this.f5158a = this.mv.u();
            } else {
                this.f5158a = this.mv.n();
            }
            com.bytedance.sdk.component.n.nr.u.u.nr.pn pnVar2 = new com.bytedance.sdk.component.n.nr.u.u.nr.pn(context, this.f5158a, this.mv);
            this.fx = pnVar2;
            this.s.add(pnVar2);
        }
        if (com.bytedance.sdk.component.n.nr.nr.u.nr(pnVar)) {
            com.bytedance.sdk.component.n.nr.b.nr.u uVarN = this.mv.n();
            this.n = uVarN;
            com.bytedance.sdk.component.n.nr.u.u.nr.iz izVar = new com.bytedance.sdk.component.n.nr.u.u.nr.iz(context, uVarN, this.mv);
            this.nr = izVar;
            this.s.add(izVar);
        }
        if (com.bytedance.sdk.component.n.nr.nr.u.fx(pnVar)) {
            com.bytedance.sdk.component.n.nr.b.nr.u uVarN2 = this.mv.n();
            this.jk = uVarN2;
            x xVar = new x(context, uVarN2, this.mv);
            this.b = xVar;
            this.s.add(xVar);
        }
        if (com.bytedance.sdk.component.n.nr.nr.u.b(pnVar)) {
            com.bytedance.sdk.component.n.nr.b.nr.u uVarA = this.mv.a();
            this.t = uVarA;
            com.bytedance.sdk.component.n.nr.u.u.nr.u uVar = new com.bytedance.sdk.component.n.nr.u.u.nr.u(context, uVarA, this.mv);
            this.pn = uVar;
            this.s.add(uVar);
        }
        if (com.bytedance.sdk.component.n.nr.nr.u.iz(pnVar)) {
            com.bytedance.sdk.component.n.nr.b.nr.u uVarIz = this.mv.iz();
            this.l = uVarIz;
            n nVar = new n(context, uVarIz, this.mv);
            this.iz = nVar;
            this.s.add(nVar);
        }
    }

    @Override // com.bytedance.sdk.component.n.nr.u.pn
    public List<com.bytedance.sdk.component.n.u.nr> u(int i, com.bytedance.sdk.component.n.u.nr nrVar, boolean z, String str) {
        return null;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.pn
    public void u(com.bytedance.sdk.component.n.u.nr nrVar) {
        if (nrVar == null) {
            return;
        }
        try {
            nrVar.nr(System.currentTimeMillis());
            Iterator<com.bytedance.sdk.component.n.nr.u.u.nr.nr> it = this.s.iterator();
            while (it.hasNext()) {
                it.next().nr(nrVar);
            }
        } catch (Throwable unused) {
            com.bytedance.sdk.component.n.nr.fx.nr.u(com.bytedance.sdk.component.n.nr.nr.nr.u.u(), 1, this.mv);
        }
    }

    @Override // com.bytedance.sdk.component.n.nr.u.pn
    public nr u(int i, List<com.bytedance.sdk.component.n.u.nr> list, int i2) {
        Iterator<com.bytedance.sdk.component.n.nr.u.u.nr.nr> it = this.s.iterator();
        nr nrVarU = null;
        while (it.hasNext()) {
            nrVarU = it.next().u(i, list);
            if (nrVarU.u()) {
                break;
            }
        }
        return nrVarU;
    }

    public List<com.bytedance.sdk.component.n.u.nr> u(com.bytedance.sdk.component.n.u.nr nrVar, int i, int i2, boolean z) {
        Iterator<com.bytedance.sdk.component.n.nr.u.u.nr.nr> it = this.s.iterator();
        while (it.hasNext()) {
            List<com.bytedance.sdk.component.n.u.nr> listU = it.next().u(i2, i, nrVar, z);
            if (listU != null && listU.size() != 0) {
                return listU;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.pn
    public List<com.bytedance.sdk.component.n.u.nr> u(int i, com.bytedance.sdk.component.n.u.nr nrVar, boolean z, List<String> list) {
        Iterator<com.bytedance.sdk.component.n.nr.u.u.nr.nr> it = this.s.iterator();
        while (it.hasNext()) {
            List<com.bytedance.sdk.component.n.u.nr> listU = it.next().u(i, nrVar, z, list, "db");
            if (listU != null && listU.size() != 0) {
                return listU;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.pn
    public boolean u(int i, String str, com.bytedance.sdk.component.n.u.nr nrVar) {
        Iterator<com.bytedance.sdk.component.n.nr.u.u.nr.nr> it = this.s.iterator();
        while (it.hasNext()) {
            if (it.next().u(i, str, nrVar)) {
                return true;
            }
        }
        return false;
    }
}
