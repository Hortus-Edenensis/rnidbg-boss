package com.bytedance.sdk.openadsdk.core.qq;

import android.util.SparseArray;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements com.bytedance.sdk.component.b.pn, Function {
    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            return u();
        }
        if (iIntValue == 2) {
            return nr();
        }
        if (iIntValue != 3) {
            return null;
        }
        return u((byte[]) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Deprecated
    public String nr() {
        return com.bytedance.sdk.openadsdk.core.y.jk.fx(false);
    }

    @Deprecated
    public String u() {
        return com.bytedance.sdk.openadsdk.core.y.jk.o();
    }

    public byte[] u(byte[] bArr, int i) {
        return com.bytedance.sdk.openadsdk.gi.nr.u(bArr, i);
    }
}
