package com.bytedance.sdk.openadsdk.my.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import defpackage.wc7;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements Bridge {
    private final Function<SparseArray<Object>, Object> u;

    public nr(Function<SparseArray<Object>, Object> function) {
        this.u = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == -99999977) {
            if (this.u instanceof fx) {
                T t = (T) this.u.apply(com.bytedance.sdk.openadsdk.my.b.u().u(-99999977).u(Bridge.class).nr());
                if (t instanceof Bridge) {
                    return t;
                }
            }
            return (T) this.u;
        }
        if (this.u == null) {
            return null;
        }
        u uVar = new u(valueSet);
        uVar.put(-99999987, Integer.valueOf(i));
        uVar.put(-99999985, cls);
        T t2 = (T) com.bytedance.sdk.openadsdk.my.nr.fx.u.nr(this.u.apply(uVar));
        return t2 != null ? t2 : (T) wc7.e.apply(uVar);
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        Function<SparseArray<Object>, Object> function = this.u;
        if (function != null) {
            return com.bytedance.sdk.openadsdk.my.nr.fx.u.nr(com.bytedance.sdk.openadsdk.my.nr.fx.u.u(function));
        }
        return null;
    }
}
