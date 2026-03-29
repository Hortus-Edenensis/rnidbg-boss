package com.bytedance.sdk.openadsdk.core.rh;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@ATSKeep
public class b implements fx {
    Function u;

    public b(Function function) {
        this.u = function;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.fx
    public void init(Context context, Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        sparseArray.put(2, function);
        this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.fx
    public boolean isPitayaEnvAvailable() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.fx
    public boolean isPitayaInitSuccess() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Boolean) this.u.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.fx
    public void queryPackage(String str, Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        sparseArray.put(2, function);
        this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.fx
    public void runTask(String str, JSONObject jSONObject, Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        sparseArray.put(3, function);
        this.u.apply(sparseArray);
    }
}
