package com.bytedance.sdk.component.b.nr;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@ATSKeep
public class nr implements u, Function {
    u nr;
    Function u;

    public nr(u uVar) {
        this.nr = uVar;
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
            return this.nr.encrypt((String) sparseArray.get(1));
        }
        if (iIntValue == 2) {
            return this.nr.decrypt((String) sparseArray.get(1));
        }
        if (iIntValue != 3) {
            return null;
        }
        return Integer.valueOf(this.nr.type());
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // com.bytedance.sdk.component.b.nr.u
    public String decrypt(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        return (String) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.nr.u
    public String encrypt(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        return (String) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.nr.u
    public int type() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.u.apply(sparseArray)).intValue();
    }

    public nr(Function function) {
        this.u = function;
    }
}
