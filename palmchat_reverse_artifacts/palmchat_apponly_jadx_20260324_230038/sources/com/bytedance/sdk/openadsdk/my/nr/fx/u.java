package com.bytedance.sdk.openadsdk.my.nr.fx;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.my.nr.b;
import com.bytedance.sdk.openadsdk.my.nr.fx;
import com.bytedance.sdk.openadsdk.my.nr.nr;
import com.bytedance.sdk.openadsdk.my.nr.pn;
import defpackage.ji7;
import defpackage.wc7;
import j$.util.Map;
import j$.util.function.BiConsumer$CC;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static Object b(Object obj) {
        final HashMap map = new HashMap();
        Map.EL.forEach((java.util.Map) obj, new BiConsumer<Object, Object>() { // from class: com.bytedance.sdk.openadsdk.my.nr.fx.u.3
            @Override // java.util.function.BiConsumer
            public void accept(Object obj2, Object obj3) {
                if (obj3 instanceof Bridge) {
                    map.put(obj2, new fx((Bridge) obj3));
                    return;
                }
                if (obj3 instanceof ValueSet) {
                    map.put(obj2, new com.bytedance.sdk.openadsdk.my.nr.u((ValueSet) obj3));
                    return;
                }
                if (obj3 instanceof EventListener) {
                    map.put(obj2, new b((EventListener) obj3));
                    return;
                }
                if (obj3 == Bridge.class) {
                    map.put(obj2, Function.class);
                } else if (obj3 == ValueSet.class) {
                    map.put(obj2, SparseArray.class);
                } else {
                    map.put(obj2, obj3);
                }
            }

            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        });
        return map;
    }

    public static Object fx(Object obj) {
        final HashMap map = new HashMap();
        Map.EL.forEach((java.util.Map) obj, new BiConsumer<Object, Object>() { // from class: com.bytedance.sdk.openadsdk.my.nr.fx.u.2
            @Override // java.util.function.BiConsumer
            public void accept(Object obj2, Object obj3) {
                if (obj3 instanceof Function) {
                    if ((obj3 instanceof LongSupplier) && ((LongSupplier) obj3).getAsLong() == -99999981) {
                        map.put(obj2, new pn((Function) obj3));
                        return;
                    } else {
                        map.put(obj2, new nr((Function) obj3));
                        return;
                    }
                }
                if (obj3 instanceof SparseArray) {
                    map.put(obj2, u.nr((SparseArray<Object>) obj3));
                    return;
                }
                if (obj3 == Function.class) {
                    map.put(obj2, Bridge.class);
                } else if (obj3 == SparseArray.class) {
                    map.put(obj2, ValueSet.class);
                } else {
                    map.put(obj2, obj3);
                }
            }

            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        });
        return map;
    }

    public static ValueSet nr(SparseArray<Object> sparseArray) {
        SparseArray<Object> sparseArrayU;
        if (sparseArray == null) {
            return null;
        }
        wc7 wc7VarB = wc7.b();
        for (int i = 0; i < sparseArray.size(); i++) {
            int iKeyAt = sparseArray.keyAt(i);
            u(wc7VarB, iKeyAt, sparseArray.get(iKeyAt));
        }
        if ((sparseArray instanceof com.bytedance.sdk.openadsdk.my.nr) && (sparseArrayU = ((com.bytedance.sdk.openadsdk.my.nr) sparseArray).u()) != null && sparseArrayU.size() > 0) {
            for (int i2 = 0; i2 < sparseArrayU.size(); i2++) {
                int iKeyAt2 = sparseArrayU.keyAt(i2);
                u(wc7VarB, iKeyAt2, sparseArrayU.get(iKeyAt2));
            }
        }
        return wc7VarB.a();
    }

    public static Result u(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetA = wc7.k(sparseArray).a();
        return ji7.b().c(valueSetA.intValue(-999900)).e(valueSetA.stringValue(-999901)).f(valueSetA.booleanValue(-999903)).d(nr((SparseArray<Object>) valueSetA.objectValue(-999902, SparseArray.class))).a();
    }

    private static void u(wc7 wc7Var, int i, final Object obj) {
        boolean z = obj instanceof Function;
        if (z) {
            if ((obj instanceof LongSupplier) && ((LongSupplier) obj).getAsLong() == -99999981) {
                wc7Var.h(i, new pn((Function) obj));
                return;
            } else {
                wc7Var.h(i, new nr((Function) obj));
                return;
            }
        }
        if (obj instanceof SparseArray) {
            if (i == -99999979) {
                wc7Var.h(i, u((SparseArray<Object>) obj));
                return;
            } else {
                wc7Var.h(i, nr((SparseArray<Object>) obj));
                return;
            }
        }
        if ((obj instanceof Supplier) && !z && !(obj instanceof ValueSet)) {
            wc7Var.h(i, new Supplier<Object>() { // from class: com.bytedance.sdk.openadsdk.my.nr.fx.u.1
                @Override // java.util.function.Supplier
                public Object get() {
                    return u.nr(((Supplier) obj).get());
                }
            });
            return;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (!list.isEmpty() && (list.get(0) instanceof Function)) {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new nr((Function) it.next()));
                }
                wc7Var.h(i, arrayList);
                return;
            }
            wc7Var.h(i, obj);
            return;
        }
        if (obj instanceof java.util.Map) {
            wc7Var.h(i, fx(obj));
        } else {
            wc7Var.h(i, obj);
        }
    }

    public static Object nr(Object obj) {
        if (obj instanceof Function) {
            return new nr((Function) obj);
        }
        if (obj instanceof SparseArray) {
            return nr((SparseArray<Object>) obj);
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.isEmpty() || !(list.get(0) instanceof Function)) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new nr((Function) it.next()));
            }
            return arrayList;
        }
        if (obj instanceof java.util.Map) {
            return fx(obj);
        }
        if (obj == Function.class) {
            return Bridge.class;
        }
        return obj == SparseArray.class ? ValueSet.class : obj;
    }

    public static SparseArray<Object> u(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return new SparseArray<>();
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            return (SparseArray) objApply;
        }
        return new SparseArray<>();
    }

    public static Object u(Object obj) {
        if (obj instanceof Bridge) {
            return new fx((Bridge) obj);
        }
        if (obj instanceof ValueSet) {
            return new com.bytedance.sdk.openadsdk.my.nr.u((ValueSet) obj);
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.isEmpty() || !(list.get(0) instanceof Bridge)) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new fx((Bridge) it.next()));
            }
            return arrayList;
        }
        if (obj instanceof java.util.Map) {
            return b(obj);
        }
        if (obj == Bridge.class) {
            return Function.class;
        }
        return obj == ValueSet.class ? SparseArray.class : obj;
    }

    public static SparseArray<Object> u(Result result) {
        if (result == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-999900, Integer.valueOf(result.code()));
        sparseArray.put(-999901, result.message());
        sparseArray.put(-999903, Boolean.valueOf(result.isSuccess()));
        sparseArray.put(-999902, new com.bytedance.sdk.openadsdk.my.nr.u(result.values()));
        return sparseArray;
    }
}
