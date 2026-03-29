package com.bytedance.adsdk.ugeno.pn;

import com.bytedance.adsdk.ugeno.pn.iz;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pn implements fx {
    @Override // com.bytedance.adsdk.ugeno.pn.fx
    public List<nr> u() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new nr("update") { // from class: com.bytedance.adsdk.ugeno.pn.pn.1
            @Override // com.bytedance.adsdk.ugeno.pn.nr
            public com.bytedance.adsdk.ugeno.pn.nr.u u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
                return new com.bytedance.adsdk.ugeno.pn.nr.pn(fxVar, str, uVar);
            }
        });
        arrayList.add(new nr("emit") { // from class: com.bytedance.adsdk.ugeno.pn.pn.2
            @Override // com.bytedance.adsdk.ugeno.pn.nr
            public com.bytedance.adsdk.ugeno.pn.nr.u u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
                return new com.bytedance.adsdk.ugeno.pn.nr.nr(fxVar, str, uVar);
            }
        });
        arrayList.add(new nr("startAnimate") { // from class: com.bytedance.adsdk.ugeno.pn.pn.3
            @Override // com.bytedance.adsdk.ugeno.pn.nr
            public com.bytedance.adsdk.ugeno.pn.nr.u u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
                return new com.bytedance.adsdk.ugeno.pn.nr.b(fxVar, str, uVar);
            }
        });
        return arrayList;
    }
}
