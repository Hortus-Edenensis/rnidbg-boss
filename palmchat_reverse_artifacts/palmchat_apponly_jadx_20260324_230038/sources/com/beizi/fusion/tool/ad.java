package com.beizi.fusion.tool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.d.a.b;
import com.beizi.fusion.model.RequestInfo;
import com.wifi.adsdk.entity.LxEventReplace;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f4701a = "OaidUtil";
    private static String c;
    public static b.a b = new b.a() { // from class: com.beizi.fusion.tool.ad.1
        @Override // com.beizi.fusion.d.a.b.a
        public void a(@NonNull String str) {
            Log.e(ad.f4701a, "code cn Oaid:" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String unused = ad.c = str;
            Context contextE = com.beizi.fusion.c.b.a().e();
            an.a(contextE, LxEventReplace.__OAID__, (Object) ad.c);
            an.a(contextE, "__CNOAID__", (Object) ad.c);
            if (RequestInfo.getInstance(contextE).getDevInfo() != null) {
                if (ae.b() && BeiZis.isLimitPersonalAds()) {
                    return;
                }
                RequestInfo.getInstance(contextE).getDevInfo().setOaid(ad.c);
                RequestInfo.getInstance(contextE).getDevInfo().setCnOaid(ad.c);
            }
        }
    };
    private static boolean d = true;
}
