package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.y.u;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements u.nr {
    private final Map<Integer, WeakReference<u.nr>> u = new HashMap();

    @Override // com.bytedance.sdk.openadsdk.core.y.u.nr
    public void nr() {
        Iterator<Map.Entry<Integer, WeakReference<u.nr>>> it = this.u.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<u.nr> value = it.next().getValue();
            if (value != null) {
                u.nr nrVar = value.get();
                if (nrVar != null) {
                    nrVar.nr();
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }

    public void u(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return;
        }
        function.apply(com.bytedance.sdk.openadsdk.my.b.u().u(9).u(Boolean.class).u(0, new com.bytedance.sdk.openadsdk.core.bc.u() { // from class: com.bytedance.sdk.openadsdk.core.pn.1
            @Override // com.bytedance.sdk.openadsdk.core.bc.u
            public void nr() {
                pn.this.nr();
            }

            @Override // com.bytedance.sdk.openadsdk.core.bc.u
            public void u() {
                pn.this.u();
            }
        }).nr());
    }

    public void u(u.nr nrVar) {
        if (nrVar == null) {
            return;
        }
        this.u.put(Integer.valueOf(nrVar.hashCode()), new WeakReference<>(nrVar));
    }

    @Override // com.bytedance.sdk.openadsdk.core.y.u.nr
    public void u() {
        Iterator<Map.Entry<Integer, WeakReference<u.nr>>> it = this.u.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<u.nr> value = it.next().getValue();
            if (value != null) {
                u.nr nrVar = value.get();
                if (nrVar != null) {
                    nrVar.u();
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }
}
