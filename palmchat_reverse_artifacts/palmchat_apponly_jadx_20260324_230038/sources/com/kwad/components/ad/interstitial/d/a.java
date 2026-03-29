package com.kwad.components.ad.interstitial.d;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@KsJson
public class a extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat jB = new SimpleDateFormat("yyyy-MM-dd");
    public long lX = -1;
    public int lY = 0;

    public static void L(Context context) {
        String strSo = ag.So();
        a aVar = new a();
        if (TextUtils.isEmpty(strSo)) {
            aVar.lY = 1;
            aVar.lX = System.currentTimeMillis();
            ag.aj(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(strSo));
            if (b(aVar.lX, System.currentTimeMillis())) {
                aVar.lY++;
            } else {
                aVar.lY = 1;
                aVar.lX = System.currentTimeMillis();
            }
            ag.aj(context, aVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTrace(e);
        }
    }

    private static boolean b(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return jB.format(new Date(j)).equals(jB.format(new Date(j2)));
            } catch (Exception e) {
                c.printStackTrace(e);
            }
        }
        return false;
    }

    public static int dR() {
        String strSo = ag.So();
        if (TextUtils.isEmpty(strSo)) {
            return 0;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(strSo));
            if (b(aVar.lX, System.currentTimeMillis())) {
                return aVar.lY;
            }
            return 0;
        } catch (Exception e) {
            c.printStackTrace(e);
            return 0;
        }
    }
}
