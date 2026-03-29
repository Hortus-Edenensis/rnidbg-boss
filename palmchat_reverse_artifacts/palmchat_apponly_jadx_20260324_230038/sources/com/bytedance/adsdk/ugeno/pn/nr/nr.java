package com.bytedance.adsdk.ugeno.pn.nr;

import com.bytedance.adsdk.ugeno.pn.iz;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<com.bytedance.adsdk.ugeno.pn.u.b> f5040a;

    public nr(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
        super(fxVar, str, uVar);
        this.f5040a = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.pn.nr.u
    public void u() {
        com.bytedance.adsdk.ugeno.pn.u.fx fxVarU;
        Map<String, String> map = this.iz;
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = this.iz.get("name");
        com.bytedance.adsdk.ugeno.pn.u.u uVarY = this.fx.y();
        if (uVarY == null || (fxVarU = uVarY.u(str)) == null) {
            return;
        }
        fxVarU.u(str);
    }
}
