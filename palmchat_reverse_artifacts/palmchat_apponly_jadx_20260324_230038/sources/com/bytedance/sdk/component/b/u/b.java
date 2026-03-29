package com.bytedance.sdk.component.b.u;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@ATSKeep
public class b implements fx, Function {
    fx nr;
    Function u;

    public b(fx fxVar) {
        this.nr = fxVar;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        int iIntValue = ((Integer) ((SparseArray) obj).get(0)).intValue();
        if (iIntValue == 1) {
            return Float.valueOf(this.nr.getLatitude());
        }
        if (iIntValue == 2) {
            return Float.valueOf(this.nr.getLongitude());
        }
        if (iIntValue != 3) {
            return null;
        }
        return Long.valueOf(this.nr.getLastTime());
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // com.bytedance.sdk.component.b.u.fx
    public long getLastTime() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Long) this.u.apply(sparseArray)).longValue();
    }

    @Override // com.bytedance.sdk.component.b.u.fx
    public float getLatitude() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Float) this.u.apply(sparseArray)).floatValue();
    }

    @Override // com.bytedance.sdk.component.b.u.fx
    public float getLongitude() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Float) this.u.apply(sparseArray)).floatValue();
    }

    public b(Function function) {
        this.u = function;
    }
}
