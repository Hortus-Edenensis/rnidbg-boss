package com.bytedance.sdk.openadsdk.my;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.kl7;
import defpackage.ll7;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    public static PluginValueSet nr(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return ll7.b().a();
        }
        Object objApply = ((function instanceof Supplier) && u(kl7.b().a())) ? ((Supplier) function).get() : function.apply(b.u().u(-99999986).u(SparseArray.class).nr());
        return objApply instanceof SparseArray ? ll7.j((SparseArray) objApply).a() : ll7.b().a();
    }

    public static boolean u(int i) {
        return i >= 6803 && i < 7000;
    }

    public static SparseArray<Object> u(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return new SparseArray<>();
        }
        Object objApply = function.apply(b.u().u(-99999986).u(SparseArray.class).nr());
        return objApply instanceof SparseArray ? (SparseArray) objApply : new SparseArray<>();
    }
}
