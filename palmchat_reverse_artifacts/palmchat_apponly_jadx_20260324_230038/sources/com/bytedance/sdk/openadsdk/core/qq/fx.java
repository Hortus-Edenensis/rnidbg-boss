package com.bytedance.sdk.openadsdk.core.qq;

import android.util.SparseArray;
import j$.util.function.Function$CC;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements com.bytedance.sdk.component.b.x, Function {
    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            onExceptionEvent((String) sparseArray.get(1), (JSONObject) sparseArray.get(2), (Throwable) sparseArray.get(3));
            return null;
        }
        if (iIntValue == 2) {
            onStatsEvent((String) sparseArray.get(1), (JSONObject) sparseArray.get(2));
            return null;
        }
        if (iIntValue != 3) {
            return null;
        }
        onStatsEvent((String) sparseArray.get(1), (JSONObject) sparseArray.get(2), (JSONObject) sparseArray.get(3));
        return null;
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // com.bytedance.sdk.component.b.x
    public void onExceptionEvent(String str, JSONObject jSONObject, Throwable th) {
        if (pn.u(str, 1.0d)) {
            s.u().u(str, jSONObject, th);
        }
    }

    @Override // com.bytedance.sdk.component.b.x
    public void onStatsEvent(String str, JSONObject jSONObject) {
        s.u().u(str, jSONObject);
    }

    @Override // com.bytedance.sdk.component.b.x
    public void onStatsEvent(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        s.u().u(str, jSONObject, jSONObject2);
    }
}
