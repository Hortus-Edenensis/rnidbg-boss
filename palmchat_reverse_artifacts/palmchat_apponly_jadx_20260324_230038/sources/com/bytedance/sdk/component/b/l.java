package com.bytedance.sdk.component.b;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@ATSKeep
public class l implements t {
    Function u;

    public l(Function function) {
        this.u = function;
    }

    @Override // com.bytedance.sdk.component.b.t
    public String get(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        return (String) this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.t
    public boolean getBoolean(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.b.t
    public int getInt(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        return ((Integer) this.u.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.component.b.t
    public long getLong(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        return ((Long) this.u.apply(sparseArray)).longValue();
    }

    @Override // com.bytedance.sdk.component.b.t
    public void set(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.u.apply(sparseArray);
    }
}
