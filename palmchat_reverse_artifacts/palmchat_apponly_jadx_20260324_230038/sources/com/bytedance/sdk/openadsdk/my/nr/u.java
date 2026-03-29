package com.bytedance.sdk.openadsdk.my.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import defpackage.ll7;
import defpackage.wc7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u<E> extends SparseArray<E> {
    private final PluginValueSet nr;
    private final ValueSet u;

    public u(ValueSet valueSet) {
        this.u = valueSet == null ? wc7.c : valueSet;
        this.nr = ll7.c;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [E, java.util.ArrayList, java.util.List] */
    private E u(int i) {
        List list = (E) this.u.objectValue(i, Object.class);
        if (list == null) {
            list = (E) this.nr.objectValue(i, Object.class);
        }
        if (list != null) {
            if (i == 9) {
                if (list == Bridge.class) {
                    return Function.class;
                }
                if (list == ValueSet.class) {
                    return SparseArray.class;
                }
            } else {
                if (list instanceof Bridge) {
                    return (E) new fx((Bridge) list);
                }
                if (list instanceof ValueSet) {
                    return (E) new u((ValueSet) list);
                }
                if (list instanceof EventListener) {
                    return (E) new b((EventListener) list);
                }
                if (list instanceof Result) {
                    return (E) com.bytedance.sdk.openadsdk.my.nr.fx.u.u((Result) list);
                }
                if (list instanceof List) {
                    List list2 = list;
                    if (!list2.isEmpty() && (list2.get(0) instanceof Bridge)) {
                        ?? r0 = (E) new ArrayList();
                        Iterator<E> it = list2.iterator();
                        while (it.hasNext()) {
                            r0.add(new fx((Bridge) it.next()));
                        }
                        return r0;
                    }
                } else if (list instanceof Map) {
                    return (E) com.bytedance.sdk.openadsdk.my.nr.fx.u.b(list);
                }
            }
        }
        return (E) list;
    }

    @Override // android.util.SparseArray
    public boolean contains(int i) {
        return super.contains(i) || this.u.containsKey(i) || this.nr.containsKey(i);
    }

    @Override // android.util.SparseArray
    public E get(int i, E e) {
        E e2 = (E) super.get(i, null);
        if (e2 != null) {
            return e2;
        }
        E eU = u(i);
        return eU != null ? eU : e;
    }

    public u(PluginValueSet pluginValueSet) {
        this.nr = pluginValueSet == null ? ll7.c : pluginValueSet;
        this.u = wc7.c;
    }
}
