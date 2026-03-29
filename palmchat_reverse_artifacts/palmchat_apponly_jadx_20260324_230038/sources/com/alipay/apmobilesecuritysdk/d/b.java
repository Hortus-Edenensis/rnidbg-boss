package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.h;
import com.lantern.auth.server.WkParams;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import defpackage.xu6;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class b {
    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        HashMap map2;
        map2 = new HashMap();
        String strB = xu6.b(map, "tid", "");
        String strB2 = xu6.b(map, "utdid", "");
        String strB3 = xu6.b(map, "userId", "");
        String strB4 = xu6.b(map, WfConstant.EVENT_KEY_APP_NAME, "");
        String strB5 = xu6.b(map, "appKeyClient", "");
        String strB6 = xu6.b(map, "tmxSessionId", "");
        String strF = h.f(context);
        String strB7 = xu6.b(map, WkParams.SESSIONID, "");
        map2.put("AC1", strB);
        map2.put("AC2", strB2);
        map2.put("AC3", "");
        map2.put("AC4", strF);
        map2.put("AC5", strB3);
        map2.put("AC6", strB6);
        map2.put("AC7", "");
        map2.put("AC8", strB4);
        map2.put("AC9", strB5);
        if (xu6.f(strB7)) {
            map2.put("AC10", strB7);
        }
        return map2;
    }
}
