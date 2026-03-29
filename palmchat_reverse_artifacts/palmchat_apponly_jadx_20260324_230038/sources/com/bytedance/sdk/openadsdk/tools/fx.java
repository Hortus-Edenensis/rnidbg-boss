package com.bytedance.sdk.openadsdk.tools;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.n;
import defpackage.ll7;
import j$.util.function.Function$CC;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements Function<SparseArray<Object>, Object> {
    private static volatile fx u;

    private fx() {
    }

    public static fx u() {
        if (u == null) {
            u = new fx();
        }
        return u;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
        int iIntValue = pluginValueSetA.intValue(-99999987);
        if (iIntValue == 10001) {
            n.o().a(pluginValueSetA.booleanValue(1));
        } else {
            if (iIntValue == 10002) {
                return Boolean.valueOf(n.o().kw());
            }
            if (iIntValue == 10003) {
                dw.u().u((Function<SparseArray<Object>, Object>) pluginValueSetA.objectValue(0, Function.class));
            } else if (iIntValue == 10004) {
                Function<SparseArray<Object>, Object> function = (Function) pluginValueSetA.objectValue(0, Function.class);
                String str = (String) pluginValueSetA.objectValue(1, String.class);
                String str2 = (String) pluginValueSetA.objectValue(2, String.class);
                String str3 = (String) pluginValueSetA.objectValue(3, String.class);
                String str4 = (String) pluginValueSetA.objectValue(4, String.class);
                HashMap map = new HashMap();
                map.put("adtype", str2);
                map.put("rit", str);
                map.put("image_mode", str3);
                map.put("preview_extra", str4);
                dw.u().u(map, function);
            } else {
                if (iIntValue == 10005) {
                    ll7 ll7VarB = ll7.b();
                    ll7VarB.h(0, n.o().za());
                    ll7VarB.h(1, n.o().tm());
                    ll7VarB.h(2, n.o().rv());
                    ll7VarB.h(3, n.o().ge());
                    ll7VarB.h(4, n.o().ob());
                    return ll7VarB.a().sparseArray();
                }
                if (iIntValue == 10006) {
                    dw.u().u((Map<String, Object>) pluginValueSetA.objectValue(0, Map.class), (Function<SparseArray<Object>, Object>) pluginValueSetA.objectValue(1, Function.class));
                } else if (iIntValue == 10007) {
                    n.o().u((n.b) null);
                } else if (iIntValue == 10008) {
                    return Boolean.valueOf(n.o().xw());
                }
            }
        }
        return null;
    }
}
