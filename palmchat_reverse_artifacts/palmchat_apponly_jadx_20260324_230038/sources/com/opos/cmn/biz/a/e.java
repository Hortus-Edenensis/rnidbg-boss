package com.opos.cmn.biz.a;

import android.content.Context;
import com.heytap.lib.routedata.RouteDataUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e {
    public static String a(Context context) {
        try {
            return RouteDataUtil.a(String.valueOf(com.opos.cmn.an.h.d.a.b(context, context.getPackageName())), d.a(context), b(context), "");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("RouteDataTool", "", e);
            return "";
        }
    }

    private static String b(Context context) {
        try {
            String strB = com.opos.cmn.g.a.b.b(context);
            if (com.opos.cmn.an.d.b.a(strB)) {
                strB = com.opos.cmn.g.a.c.a(context);
            }
            return (Math.abs(strB.hashCode()) % 100000) + "";
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("RouteDataTool", "", e);
            return "";
        }
    }
}
