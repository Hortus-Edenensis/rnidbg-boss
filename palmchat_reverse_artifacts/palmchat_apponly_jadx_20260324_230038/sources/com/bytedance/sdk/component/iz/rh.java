package com.bytedance.sdk.component.iz;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@ATSKeep
public class rh implements h, Function {
    h nr;
    Function u;

    public rh(h hVar) {
        this.nr = hVar;
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
            Object obj2 = sparseArray.get(1);
            Object mvVar = sparseArray.get(2);
            if (mvVar != null) {
                mvVar = new mv((Function) mvVar);
            }
            this.nr.onStepStart((String) obj2, (l) mvVar);
            return null;
        }
        if (iIntValue != 2) {
            return null;
        }
        Object obj3 = sparseArray.get(1);
        Object mvVar2 = sparseArray.get(2);
        if (mvVar2 != null) {
            mvVar2 = new mv((Function) mvVar2);
        }
        this.nr.onStepEnd((String) obj3, (l) mvVar2);
        return null;
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // com.bytedance.sdk.component.iz.h
    public void onStepEnd(String str, l lVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        if (lVar != null) {
            lVar = new mv(lVar);
        }
        sparseArray.put(2, lVar);
        this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.iz.h
    public void onStepStart(String str, l lVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        if (lVar != null) {
            lVar = new mv(lVar);
        }
        sparseArray.put(2, lVar);
        this.u.apply(sparseArray);
    }

    public rh(Function function) {
        this.u = function;
    }
}
