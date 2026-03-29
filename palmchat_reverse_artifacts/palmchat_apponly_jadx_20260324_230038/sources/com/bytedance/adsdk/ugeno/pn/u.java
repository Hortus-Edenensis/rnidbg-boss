package com.bytedance.adsdk.ugeno.pn;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u implements n {
    @Override // com.bytedance.adsdk.ugeno.pn.n
    public List<x> u() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new x("slide") { // from class: com.bytedance.adsdk.ugeno.pn.u.1
            @Override // com.bytedance.adsdk.ugeno.pn.x
            public com.bytedance.adsdk.ugeno.pn.fx.nr u(Context context) {
                return new com.bytedance.adsdk.ugeno.pn.fx.b(context);
            }
        });
        arrayList.add(new x("tap") { // from class: com.bytedance.adsdk.ugeno.pn.u.2
            @Override // com.bytedance.adsdk.ugeno.pn.x
            public com.bytedance.adsdk.ugeno.pn.fx.nr u(Context context) {
                return new com.bytedance.adsdk.ugeno.pn.fx.pn(context);
            }
        });
        arrayList.add(new x("timer") { // from class: com.bytedance.adsdk.ugeno.pn.u.3
            @Override // com.bytedance.adsdk.ugeno.pn.x
            public com.bytedance.adsdk.ugeno.pn.fx.nr u(Context context) {
                return new com.bytedance.adsdk.ugeno.pn.fx.iz(context);
            }
        });
        arrayList.add(new x("touchStart") { // from class: com.bytedance.adsdk.ugeno.pn.u.4
            @Override // com.bytedance.adsdk.ugeno.pn.x
            public com.bytedance.adsdk.ugeno.pn.fx.nr u(Context context) {
                return new com.bytedance.adsdk.ugeno.pn.fx.n(context);
            }
        });
        arrayList.add(new x("touchEnd") { // from class: com.bytedance.adsdk.ugeno.pn.u.5
            @Override // com.bytedance.adsdk.ugeno.pn.x
            public com.bytedance.adsdk.ugeno.pn.fx.nr u(Context context) {
                return new com.bytedance.adsdk.ugeno.pn.fx.x(context);
            }
        });
        arrayList.add(new x("animateState") { // from class: com.bytedance.adsdk.ugeno.pn.u.6
            @Override // com.bytedance.adsdk.ugeno.pn.x
            public com.bytedance.adsdk.ugeno.pn.fx.nr u(Context context) {
                return new com.bytedance.adsdk.ugeno.pn.fx.u(context);
            }
        });
        return arrayList;
    }
}
