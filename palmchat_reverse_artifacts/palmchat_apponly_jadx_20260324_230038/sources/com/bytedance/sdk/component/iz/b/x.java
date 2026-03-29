package com.bytedance.sdk.component.iz.b;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x extends u {
    @Override // com.bytedance.sdk.component.iz.b.a
    public String u() {
        return "check_duplicate";
    }

    @Override // com.bytedance.sdk.component.iz.b.a
    public void u(com.bytedance.sdk.component.iz.fx.fx fxVar) {
        List<com.bytedance.sdk.component.iz.fx.fx> linkedList;
        String strMy = fxVar.my();
        Map<String, List<com.bytedance.sdk.component.iz.fx.fx>> mapX = fxVar.l().x();
        synchronized (mapX) {
            linkedList = mapX.get(strMy);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
            }
        }
        synchronized (linkedList) {
            linkedList.add(fxVar);
            mapX.put(strMy, linkedList);
            if (linkedList.size() <= 1) {
                fxVar.u(new b());
            }
        }
    }
}
