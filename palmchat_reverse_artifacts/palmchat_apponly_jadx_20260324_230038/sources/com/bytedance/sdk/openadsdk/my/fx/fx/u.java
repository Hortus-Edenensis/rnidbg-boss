package com.bytedance.sdk.openadsdk.my.fx.fx;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public final PluginValueSet u;

    public u(SparseArray<Object> sparseArray) {
        this.u = ll7.j(sparseArray).a();
    }

    public int[] a() {
        return (int[]) this.u.objectValue(261009, int[].class);
    }

    public String b() {
        return (String) this.u.objectValue(261004, String.class);
    }

    public boolean fx() {
        return this.u.booleanValue(261003);
    }

    public int iz() {
        return this.u.intValue(261006);
    }

    public boolean jk() {
        return this.u.booleanValue(261011);
    }

    public boolean k() {
        return this.u.booleanValue(261017);
    }

    public int l() {
        return this.u.intValue(261013);
    }

    public int mv() {
        return this.u.intValue(261014);
    }

    public Map<String, Object> my() {
        return (Map) this.u.objectValue(261018, Map.class);
    }

    public boolean n() {
        return this.u.booleanValue(261008);
    }

    public String nr() {
        return (String) this.u.objectValue(261002, String.class);
    }

    public Function<SparseArray<Object>, Object> o() {
        Map<String, Object> mapMy = my();
        if (mapMy != null && !mapMy.isEmpty()) {
            Object obj = mapMy.get("qa_common_tool");
            if (obj instanceof Function) {
                return (Function) obj;
            }
        }
        return null;
    }

    public String pn() {
        return (String) this.u.objectValue(261005, String.class);
    }

    public int s() {
        return this.u.intValue(261015);
    }

    public b t() {
        SparseArray sparseArray = (SparseArray) this.u.objectValue(261012, SparseArray.class);
        if (sparseArray != null) {
            return new b(sparseArray);
        }
        return null;
    }

    public String u() {
        return (String) this.u.objectValue(261001, String.class);
    }

    public boolean x() {
        return this.u.booleanValue(261007);
    }
}
