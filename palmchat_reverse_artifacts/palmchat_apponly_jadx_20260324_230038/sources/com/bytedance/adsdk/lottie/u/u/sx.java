package com.bytedance.adsdk.lottie.u.u;

import android.graphics.Path;
import com.bytedance.adsdk.lottie.model.nr.bg;
import com.bytedance.adsdk.lottie.u.nr.u;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class sx implements u.InterfaceC0166u, mv {
    private final com.bytedance.adsdk.lottie.n b;
    private final boolean fx;
    private boolean iz;
    private final String nr;
    private final com.bytedance.adsdk.lottie.u.nr.mv pn;
    private final Path u = new Path();
    private final nr x = new nr();

    public sx(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar, com.bytedance.adsdk.lottie.model.nr.o oVar) {
        this.nr = oVar.u();
        this.fx = oVar.fx();
        this.b = nVar;
        com.bytedance.adsdk.lottie.u.nr.mv mvVarU = oVar.nr().u();
        this.pn = mvVarU;
        fxVar.u(mvVarU);
        mvVarU.u(this);
    }

    private void nr() {
        this.iz = false;
        this.b.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.u.u.mv
    public Path b() {
        if (this.iz) {
            return this.u;
        }
        this.u.reset();
        if (this.fx) {
            this.iz = true;
            return this.u;
        }
        Path pathX = this.pn.x();
        if (pathX == null) {
            return this.u;
        }
        this.u.set(pathX);
        this.u.setFillType(Path.FillType.EVEN_ODD);
        this.x.u(this.u);
        this.iz = true;
        return this.u;
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u.InterfaceC0166u
    public void u() {
        nr();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    @Override // com.bytedance.adsdk.lottie.u.u.fx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(List<fx> list, List<fx> list2) {
        ArrayList arrayList = null;
        for (int i = 0; i < list.size(); i++) {
            fx fxVar = list.get(i);
            if (fxVar instanceof dw) {
                dw dwVar = (dw) fxVar;
                if (dwVar.getType() == bg.u.SIMULTANEOUSLY) {
                    this.x.u(dwVar);
                    dwVar.u(this);
                } else if (fxVar instanceof bg) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((bg) fxVar);
                }
            }
        }
        this.pn.u((List<bg>) arrayList);
    }
}
