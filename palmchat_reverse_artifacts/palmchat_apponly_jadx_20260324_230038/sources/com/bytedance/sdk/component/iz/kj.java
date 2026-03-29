package com.bytedance.sdk.component.iz;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@ATSKeep
public class kj implements qq, Function {
    qq nr;
    Function u;

    public kj(qq qqVar) {
        this.nr = qqVar;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            Object oVar = sparseArray.get(1);
            if (oVar != null) {
                oVar = new o((Function) oVar);
            }
            this.nr.onSuccess((my) oVar);
            return null;
        }
        if (iIntValue != 2) {
            return null;
        }
        this.nr.onFailed(((Integer) sparseArray.get(1)).intValue(), (String) sparseArray.get(2), (Throwable) sparseArray.get(3));
        return null;
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // com.bytedance.sdk.component.iz.qq
    public void onFailed(int i, String str, Throwable th) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, str);
        sparseArray.put(3, th);
        this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.iz.qq
    public void onSuccess(my myVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (myVar != null) {
            myVar = new o(myVar);
        }
        sparseArray.put(1, myVar);
        this.u.apply(sparseArray);
    }

    public kj(Function function) {
        this.u = function;
    }
}
