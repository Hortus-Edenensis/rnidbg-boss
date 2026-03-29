package com.bytedance.sdk.openadsdk.my.u.u;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJAdError;
import defpackage.wc7;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends CSJAdError {
    private ValueSet nr;
    private final Function<SparseArray<Object>, Object> u;

    public u(Function<SparseArray<Object>, Object> function) {
        this.nr = wc7.c;
        function = function == null ? wc7.e : function;
        this.u = function;
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            this.nr = wc7.k((SparseArray) objApply).a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public int getCode() {
        return this.nr.intValue(263001);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public String getMsg() {
        return this.nr.stringValue(263002);
    }
}
