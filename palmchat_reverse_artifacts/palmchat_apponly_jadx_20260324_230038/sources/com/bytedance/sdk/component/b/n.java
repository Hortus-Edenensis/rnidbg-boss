package com.bytedance.sdk.component.b;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@ATSKeep
public class n implements x {
    Function u;

    public n(Function function) {
        this.u = function;
    }

    @Override // com.bytedance.sdk.component.b.x
    public void onExceptionEvent(String str, JSONObject jSONObject, Throwable th) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        sparseArray.put(3, th);
        this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.x
    public void onStatsEvent(String str, JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        this.u.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.b.x
    public void onStatsEvent(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        sparseArray.put(3, jSONObject2);
        this.u.apply(sparseArray);
    }
}
