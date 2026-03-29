package com.bytedance.sdk.openadsdk.core.y;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class xg {
    private static final Set<Integer> u = new CopyOnWriteArraySet();
    private static final com.bytedance.sdk.component.utils.kj nr = new com.bytedance.sdk.component.utils.kj() { // from class: com.bytedance.sdk.openadsdk.core.y.xg.1
        @Override // com.bytedance.sdk.component.utils.kj
        public boolean u(int i) {
            if (com.bytedance.sdk.openadsdk.core.dw.nr().na()) {
                return xg.u.contains(Integer.valueOf(i));
            }
            return true;
        }
    };

    public static com.bytedance.sdk.component.widget.nr.u u(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        com.bytedance.sdk.component.widget.nr.u uVar = new com.bytedance.sdk.component.widget.nr.u();
        uVar.u(bcVar.n());
        uVar.u(bcVar.ap());
        uVar.nr(bcVar.lk());
        return uVar;
    }

    public static void nr(int i) {
        u.remove(Integer.valueOf(i));
        nr.nr(i);
    }

    public static void u() {
        if (com.bytedance.sdk.openadsdk.core.dw.nr().na()) {
            com.bytedance.sdk.component.utils.qq.u(nr);
        } else {
            u.clear();
        }
    }

    public static void u(int i) {
        if (com.bytedance.sdk.openadsdk.core.dw.nr().na()) {
            u.add(Integer.valueOf(i));
        }
        nr.fx(i);
    }
}
