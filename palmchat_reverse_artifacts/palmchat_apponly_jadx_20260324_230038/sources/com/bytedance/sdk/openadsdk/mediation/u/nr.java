package com.bytedance.sdk.openadsdk.mediation.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import defpackage.wc7;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends u {
    private final Bridge u;

    public nr(Bridge bridge) {
        this.u = bridge == null ? wc7.d : bridge;
    }

    public static Function<SparseArray<Object>, Object> u(Object obj) {
        if (obj instanceof Function) {
            return (Function) obj;
        }
        if (obj instanceof Bridge) {
            return new nr((Bridge) obj);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.u.u
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        return (T) this.u.call(i, valueSet, cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.u.u
    public SparseArray<Object> get() {
        if (this.u.values() == null) {
            return null;
        }
        SparseArray<Object> sparseArray = this.u.values().sparseArray();
        return sparseArray == null ? new SparseArray<>() : sparseArray;
    }
}
