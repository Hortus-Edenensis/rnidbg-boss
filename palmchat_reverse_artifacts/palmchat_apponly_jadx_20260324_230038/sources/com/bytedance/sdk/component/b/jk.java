package com.bytedance.sdk.component.b;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@ATSKeep
public class jk implements a {
    Function u;

    public jk(Function function) {
        this.u = function;
    }

    public void clear() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        this.u.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    @Override // com.bytedance.sdk.component.b.a
    public com.bytedance.sdk.component.b.nr.fx get(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        ?? Apply = this.u.apply(sparseArray);
        ?? bVar = Apply;
        if (Apply != 0) {
            bVar = new com.bytedance.sdk.component.b.nr.b((Function) Apply);
        }
        return (com.bytedance.sdk.component.b.nr.fx) bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    @Override // com.bytedance.sdk.component.b.a
    public com.bytedance.sdk.component.b.nr.u getEncrypt(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Integer.valueOf(i));
        ?? Apply = this.u.apply(sparseArray);
        ?? nrVar = Apply;
        if (Apply != 0) {
            nrVar = new com.bytedance.sdk.component.b.nr.nr((Function) Apply);
        }
        return (com.bytedance.sdk.component.b.nr.u) nrVar;
    }

    @Override // com.bytedance.sdk.component.b.a
    public void store() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        this.u.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    public com.bytedance.sdk.component.b.nr.fx get(String str, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        sparseArray.put(2, Integer.valueOf(i));
        ?? Apply = this.u.apply(sparseArray);
        ?? bVar = Apply;
        if (Apply != 0) {
            bVar = new com.bytedance.sdk.component.b.nr.b((Function) Apply);
        }
        return (com.bytedance.sdk.component.b.nr.fx) bVar;
    }
}
