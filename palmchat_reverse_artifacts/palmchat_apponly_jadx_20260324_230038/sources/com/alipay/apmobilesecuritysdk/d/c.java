package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.f;
import com.lantern.auth.server.WkParams;
import defpackage.o27;
import defpackage.xu6;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class c {
    public static Map<String, String> a(Context context) {
        o27 o27VarE = o27.e();
        HashMap map = new HashMap();
        f fVarA = com.alipay.apmobilesecuritysdk.e.e.a(context);
        String strB = o27VarE.b(context);
        String strF = o27VarE.f(context);
        String strZ = o27.z(context);
        if (fVarA != null) {
            if (xu6.c(strB)) {
                strB = fVarA.a();
            }
            if (xu6.c(strF)) {
                strF = fVarA.b();
            }
            if (xu6.c(strZ)) {
                strZ = fVarA.e();
            }
        }
        f fVar = new f(strB, strF, "", "", strZ);
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(WkParams.IMEI, fVar.a());
                jSONObject.put("imsi", fVar.b());
                jSONObject.put("mac", fVar.c());
                jSONObject.put("bluetoothmac", fVar.d());
                jSONObject.put("gsi", fVar.e());
                String string = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key", string);
                com.alipay.apmobilesecuritysdk.f.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key", string);
            } catch (Exception e) {
                com.alipay.apmobilesecuritysdk.c.a.a(e);
            }
        }
        map.put("AD1", strB);
        map.put("AD2", strF);
        map.put("AD3", o27.p(context));
        map.put("AD5", o27.t(context));
        map.put("AD6", o27.v(context));
        map.put("AD7", o27.x(context));
        map.put("AD9", o27VarE.h(context));
        map.put("AD10", strZ);
        map.put("AD11", o27.k());
        map.put("AD12", o27VarE.a());
        map.put("AD13", o27.m());
        map.put("AD14", o27.q());
        map.put("AD15", o27.s());
        map.put("AD16", o27.u());
        map.put("AD17", "");
        map.put("AD19", o27.B(context));
        map.put("AD20", o27.w());
        map.put("AD22", "");
        map.put("AD23", o27.D(context));
        map.put("AD24", xu6.k(o27.r(context)));
        map.put("AD26", o27.n(context));
        map.put("AD27", o27.G());
        map.put("AD28", o27.K());
        map.put("AD29", o27.N());
        map.put("AD30", o27.I());
        map.put("AD31", o27.M());
        map.put("AD32", o27.C());
        map.put("AD33", o27.E());
        map.put("AD34", o27.H(context));
        map.put("AD35", o27.J(context));
        map.put("AD36", o27.F(context));
        map.put("AD37", o27.A());
        map.put("AD38", o27.y());
        map.put("AD39", o27.j(context));
        map.put("AD40", o27.l(context));
        map.put("AD41", o27.g());
        map.put("AD42", o27.i());
        return map;
    }
}
