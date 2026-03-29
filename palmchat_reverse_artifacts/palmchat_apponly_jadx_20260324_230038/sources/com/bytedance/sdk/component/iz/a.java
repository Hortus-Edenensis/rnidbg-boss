package com.bytedance.sdk.component.iz;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@ATSKeep
public class a implements n, Function {
    n nr;
    Function u;

    public a(n nVar) {
        this.nr = nVar;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        int iIntValue = ((Integer) ((SparseArray) obj).get(0)).intValue();
        if (iIntValue == 1) {
            return Long.valueOf(this.nr.getStartRequestTime());
        }
        if (iIntValue == 2) {
            return Long.valueOf(this.nr.getFirstFrameTime());
        }
        if (iIntValue != 3) {
            return null;
        }
        return Long.valueOf(this.nr.getEndRequestTime());
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // com.bytedance.sdk.component.iz.n
    public long getEndRequestTime() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Long) this.u.apply(sparseArray)).longValue();
    }

    @Override // com.bytedance.sdk.component.iz.n
    public long getFirstFrameTime() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Long) this.u.apply(sparseArray)).longValue();
    }

    @Override // com.bytedance.sdk.component.iz.n
    public long getStartRequestTime() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Long) this.u.apply(sparseArray)).longValue();
    }

    public a(Function function) {
        this.u = function;
    }
}
