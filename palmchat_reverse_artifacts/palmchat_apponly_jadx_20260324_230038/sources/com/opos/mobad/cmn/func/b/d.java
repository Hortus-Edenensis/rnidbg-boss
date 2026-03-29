package com.opos.mobad.cmn.func.b;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d {
    public static final boolean a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return a(context, str, str2, str3, str4, str5, str6, null, str7, true);
    }

    public static final boolean a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str8)) {
            map.put("clk_score", str8);
        }
        return com.opos.cmn.g.c.a.a(context, str, str2, str3, str4, str5, str6, BaseWrapper.ENTER_ID_AD_SDK, str7, map, z);
    }
}
