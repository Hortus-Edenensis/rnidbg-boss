package com.bytedance.sdk.component.b;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@ATSKeep
public class iz implements pn {
    Function u;

    public iz(Function function) {
        this.u = function;
    }

    public byte[] encrypt(byte[] bArr, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, bArr);
        sparseArray.put(2, Integer.valueOf(i));
        return (byte[]) this.u.apply(sparseArray);
    }

    public String getDid() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.u.apply(sparseArray);
    }

    public String getOAID() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.u.apply(sparseArray);
    }
}
