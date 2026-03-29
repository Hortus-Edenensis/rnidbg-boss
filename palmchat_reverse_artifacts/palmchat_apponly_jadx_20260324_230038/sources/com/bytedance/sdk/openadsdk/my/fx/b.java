package com.bytedance.sdk.openadsdk.my.fx;

import com.bykv.vk.openvk.api.proto.ValueSet;
import defpackage.kl7;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    public static boolean nr(int i) {
        return i >= 7000;
    }

    public static boolean u(int i) {
        return i >= 6803 && i < 7000;
    }

    public static <T> Object u(final Supplier<T> supplier) {
        return u(kl7.b().a()) ? new ValueSet.ValueGetter<Object>() { // from class: com.bytedance.sdk.openadsdk.my.fx.b.1
            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            public T get() {
                return supplier.get();
            }
        } : supplier;
    }

    public static Object u(Object obj) {
        return (kl7.b().a() < 6803 || kl7.b().a() >= 6900 || !(obj instanceof Function)) ? obj : new com.bytedance.sdk.openadsdk.my.nr.u.u((Function) obj);
    }
}
