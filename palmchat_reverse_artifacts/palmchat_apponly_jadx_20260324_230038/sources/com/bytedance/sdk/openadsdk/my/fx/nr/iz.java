package com.bytedance.sdk.openadsdk.my.fx.nr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import j$.util.function.Function$CC;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements Function<SparseArray<Object>, Object> {
    private Function<SparseArray<Object>, Object> u;

    public iz(Function<SparseArray<Object>, Object> function) {
        Function<SparseArray<Object>, Object> function2 = ll7.d;
        this.u = function2;
        this.u = function == null ? function2 : function;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public List<iz> b() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241108);
        sparseArray.put(-99999985, List.class);
        List arrayList = (List) this.u.apply(sparseArray);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new iz(com.bytedance.sdk.openadsdk.d.fx.u(it.next())));
        }
        return arrayList2;
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public boolean fx() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241105);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }

    public boolean iz() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241107);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }

    public String nr() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241104);
        sparseArray.put(-99999985, String.class);
        return (String) this.u.apply(sparseArray);
    }

    public String u() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241103);
        sparseArray.put(-99999985, String.class);
        return (String) this.u.apply(sparseArray);
    }

    public boolean x() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241106);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }

    public void u(iz izVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, izVar);
        sparseArray.put(-99999987, 241101);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    public void u(boolean z) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, Boolean.valueOf(z));
        sparseArray.put(-99999987, 241102);
        sparseArray.put(-99999985, Void.class);
        this.u.apply(sparseArray);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
        int iIntValue = pluginValueSetA.intValue(-99999987);
        pluginValueSetA.objectValue(-99999985, Class.class);
        if (iIntValue != -99999986) {
            switch (iIntValue) {
                case 241101:
                    u(new iz((Function) pluginValueSetA.objectValue(0, Function.class)));
                    return null;
                case 241102:
                    u(pluginValueSetA.booleanValue(0));
                    return null;
                case 241103:
                    return u();
                case 241104:
                    return nr();
                case 241105:
                    return Boolean.class.cast(Boolean.valueOf(fx()));
                case 241106:
                    return Boolean.class.cast(Boolean.valueOf(x()));
                case 241107:
                    return Boolean.class.cast(Boolean.valueOf(iz()));
                case 241108:
                    return b();
                default:
                    return null;
            }
        }
        return new SparseArray();
    }
}
