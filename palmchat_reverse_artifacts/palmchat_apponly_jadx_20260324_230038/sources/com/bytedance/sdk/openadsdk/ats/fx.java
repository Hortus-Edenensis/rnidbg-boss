package com.bytedance.sdk.openadsdk.ats;

import com.bytedance.sdk.openadsdk.core.d;
import j$.util.function.Function$CC;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class fx implements Function<Object, Object> {
    private int fx = d.u;
    private static List<Function> u = new ArrayList();
    private static final u nr = new u();

    public static <T> T u(String str) {
        T t = (T) nr.u(str);
        if (t == null && u.size() > 0) {
            Iterator<Function> it = u.iterator();
            while (it.hasNext()) {
                Object objApply = it.next().apply(str);
                if (objApply != null) {
                    return (T) nr.u(str, objApply);
                }
            }
        }
        return t;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        if (obj == null) {
            return Collections.unmodifiableMap(nr.u());
        }
        if (obj instanceof Function) {
            u((Function) obj);
            return null;
        }
        if (obj instanceof String) {
            return nr.u(String.valueOf(obj));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(this.fx);
        }
        return null;
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    private void u(Function function) {
        u.add(function);
        Object objApply = function.apply(null);
        if (objApply instanceof Map) {
            Object objApply2 = function.apply(0);
            int iIntValue = objApply2 instanceof Integer ? ((Integer) objApply2).intValue() : 0;
            for (Map.Entry entry : ((Map) objApply).entrySet()) {
                nr.u((String) entry.getKey(), entry.getValue(), iIntValue);
            }
        }
    }
}
