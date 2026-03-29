package com.qq.gdt.action.j;

import android.content.Context;
import com.qq.gdt.action.e.d;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class x {
    public static void a(JSONObject jSONObject, Context context) {
        try {
            d.b bVarD = h.d(context);
            jSONObject.putOpt("taid", bVarD.b);
            jSONObject.putOpt("taid_standard", bVarD.b);
            jSONObject.putOpt("taid_ticket_standard", bVarD.c);
            jSONObject.putOpt("m10", bVarD.f10488a);
            jSONObject.putOpt("m10_standard", bVarD.f10488a);
            jSONObject.putOpt("m10Error", Integer.valueOf(bVarD.d));
        } catch (Throwable th) {
            o.a("appendTuringDID err", th);
        }
    }
}
