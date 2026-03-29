package com.tide.host.a;

import com.qq.gdt.action.ActionUtils;
import com.tide.protocol.model.JsonFactory;
import com.tide.protocol.util.TdLogUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class z implements JsonFactory {
    @Override // com.tide.protocol.model.JsonFactory
    public final Object fromJson(String str) {
        Throwable th;
        d dVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            dVar = new d();
            try {
                dVar.f10786a = jSONObject.getInt("code");
                dVar.b = jSONObject.getString("message");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (jSONObjectOptJSONObject != null) {
                    c cVar = new c();
                    cVar.f10785a = jSONObjectOptJSONObject.getString(ActionUtils.PAYMENT_AMOUNT);
                    dVar.c = cVar;
                }
            } catch (Throwable th2) {
                th = th2;
                TdLogUtils.error("BaseResponse fromJson ", th.toString());
            }
        } catch (Throwable th3) {
            th = th3;
            dVar = null;
        }
        return dVar;
    }
}
