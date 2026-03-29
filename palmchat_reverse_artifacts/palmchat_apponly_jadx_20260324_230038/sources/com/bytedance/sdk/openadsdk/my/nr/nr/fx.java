package com.bytedance.sdk.openadsdk.my.nr.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements Loader {
    private Function<SparseArray<Object>, Object> u;

    public fx(Function<SparseArray<Object>, Object> function) {
        this.u = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Loader
    public void load(int i, ValueSet valueSet, EventListener eventListener) {
        if (valueSet == null || this.u == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.my.nr.u uVar = new com.bytedance.sdk.openadsdk.my.nr.u(valueSet);
        uVar.put(-99999987, Integer.valueOf(i));
        uVar.put(-99999982, Integer.valueOf(i));
        this.u.apply(uVar);
    }
}
