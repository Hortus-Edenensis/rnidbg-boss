package com.bytedance.sdk.openadsdk.my.nr.nr;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import defpackage.wc7;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements Bridge, Manager {
    private final Function<SparseArray<Object>, Object> u;

    public b(Function<SparseArray<Object>, Object> function) {
        this.u = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.u == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.my.nr.u uVar = new com.bytedance.sdk.openadsdk.my.nr.u(valueSet);
        uVar.put(-99999987, Integer.valueOf(i));
        uVar.put(-99999985, cls);
        T t = (T) com.bytedance.sdk.openadsdk.my.nr.fx.u.nr(this.u.apply(uVar));
        return t != null ? t : (T) wc7.e.apply(uVar);
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Loader createLoader(Context context) {
        if (this.u == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -999800);
        sparseArray.put(-99999985, Function.class);
        sparseArray.put(-998000, context);
        Object objApply = this.u.apply(sparseArray);
        if (objApply instanceof Function) {
            return new fx((Function) objApply);
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Bridge getBridge(int i) {
        if (this.u == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i == 1) {
            i = 999801;
        }
        sparseArray.put(-99999987, Integer.valueOf(i));
        sparseArray.put(-99999985, Function.class);
        Object objApply = this.u.apply(sparseArray);
        if (objApply instanceof Function) {
            return new com.bytedance.sdk.openadsdk.my.nr.nr((Function) objApply);
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        if (this.u == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        Object objApply = this.u.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            return com.bytedance.sdk.openadsdk.my.nr.fx.u.nr((SparseArray<Object>) objApply);
        }
        return null;
    }
}
