package com.bytedance.sdk.openadsdk.my.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements EventListener {
    private Function<SparseArray<Object>, Object> u;

    public pn(Function<SparseArray<Object>, Object> function) {
        this.u = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i, Result result) {
        if (this.u == null) {
            return null;
        }
        Object objApply = this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(i).u(-99999979, result != null ? com.bytedance.sdk.openadsdk.my.pn.u().u(result.code()).u(result.isSuccess()).u(result.message()).u(new u(result.values())).nr() : null).u(SparseArray.class).nr());
        if (objApply instanceof SparseArray) {
            return com.bytedance.sdk.openadsdk.my.nr.fx.u.nr((SparseArray<Object>) objApply);
        }
        return null;
    }
}
