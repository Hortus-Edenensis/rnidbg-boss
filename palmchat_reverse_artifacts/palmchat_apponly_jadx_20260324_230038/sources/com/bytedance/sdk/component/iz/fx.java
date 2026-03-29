package com.bytedance.sdk.component.iz;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import j$.util.function.Function$CC;
import java.io.File;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@ATSKeep
public class fx implements nr, Function {
    nr nr;
    Function u;

    public fx(nr nrVar) {
        this.nr = nrVar;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Long.valueOf(this.nr.getFileCacheSize());
            case 2:
                return Integer.valueOf(this.nr.getMemoryCacheSize());
            case 3:
                return Boolean.valueOf(this.nr.isMemoryCache());
            case 4:
                return Boolean.valueOf(this.nr.isDiskCache());
            case 5:
                return this.nr.getCacheDir();
            case 6:
                return Boolean.valueOf(this.nr.isQueryAll());
            case 7:
                return Integer.valueOf(this.nr.getRawMemoryCacheSize());
            case 8:
                return Boolean.valueOf(this.nr.isRawMemoryCache());
            default:
                return null;
        }
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // com.bytedance.sdk.component.iz.nr
    public File getCacheDir() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (File) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.iz.nr
    public long getFileCacheSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Long) this.u.apply(sparseArray)).longValue();
    }

    @Override // com.bytedance.sdk.component.iz.nr
    public int getMemoryCacheSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Integer) this.u.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.component.iz.nr
    public int getRawMemoryCacheSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return ((Integer) this.u.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.component.iz.nr
    public boolean isDiskCache() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.iz.nr
    public boolean isMemoryCache() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.iz.nr
    public boolean isQueryAll() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.iz.nr
    public boolean isRawMemoryCache() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }

    public fx(Function function) {
        this.u = function;
    }
}
