package com.bytedance.sdk.component.iz;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.io.InputStream;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@ATSKeep
public class q implements c {
    Function u;

    public q(Function function) {
        this.u = function;
    }

    public void clearAllCache() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        this.u.apply(sparseArray);
    }

    public void clearCache(double d) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Double.valueOf(d));
        this.u.apply(sparseArray);
    }

    public void clearDiskCache(double d) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Double.valueOf(d));
        this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.iz.c
    public void clearMemoryCache(double d) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Double.valueOf(d));
        this.u.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    @Override // com.bytedance.sdk.component.iz.c
    public s from(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        ?? Apply = this.u.apply(sparseArray);
        ?? kVar = Apply;
        if (Apply != 0) {
            kVar = new k((Function) Apply);
        }
        return (s) kVar;
    }

    @Override // com.bytedance.sdk.component.iz.c
    public InputStream getCacheStream(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return (InputStream) this.u.apply(sparseArray);
    }

    public InputStream getDiskCacheStream(String str, String str2, String str3) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, str3);
        return (InputStream) this.u.apply(sparseArray);
    }

    public boolean hasDiskCache(String str, String str2, String str3) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, str3);
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }
}
