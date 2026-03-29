package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import defpackage.ju6;
import defpackage.xu6;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        HashMap map2;
        String strB = xu6.b(map, "appchannel", "");
        map2 = new HashMap();
        map2.put("AA1", context.getPackageName());
        ju6.a();
        map2.put("AA2", ju6.b(context));
        map2.put("AA3", "APPSecuritySDK-ALIPAYSDK");
        map2.put("AA4", "3.4.0.202203211140");
        map2.put("AA6", strB);
        return map2;
    }
}
