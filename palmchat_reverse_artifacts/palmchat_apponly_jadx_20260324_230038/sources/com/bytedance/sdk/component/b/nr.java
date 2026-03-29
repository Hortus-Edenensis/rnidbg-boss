package com.bytedance.sdk.component.b;

import android.util.SparseArray;
import com.bytedance.sdk.component.b.u;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import j$.util.function.Function$CC;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@ATSKeep
public class nr implements u.InterfaceC0214u, Function {
    u.InterfaceC0214u nr;
    Function u;

    public nr(u.InterfaceC0214u interfaceC0214u) {
        this.nr = interfaceC0214u;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        this.nr.reportSensorData((JSONObject) sparseArray.get(1));
        return null;
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // com.bytedance.sdk.component.b.u.InterfaceC0214u
    public void reportSensorData(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, jSONObject);
        this.u.apply(sparseArray);
    }

    public nr(Function function) {
        this.u = function;
    }
}
