package com.alipay.mobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import defpackage.xu6;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class SecurityClientMobile {
    public static synchronized String GetApdid(Context context, Map<String, String> map) {
        HashMap map2 = new HashMap();
        map2.put("utdid", xu6.b(map, "utdid", ""));
        map2.put("tid", xu6.b(map, "tid", ""));
        map2.put("userId", xu6.b(map, "userId", ""));
        APSecuritySdk.getInstance(context).initToken(0, map2, null);
        return a.a(context);
    }
}
