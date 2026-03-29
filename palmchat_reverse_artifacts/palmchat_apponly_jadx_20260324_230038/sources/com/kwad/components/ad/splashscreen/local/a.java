package com.kwad.components.ad.splashscreen.local;

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
    public long jC = 0;
    public int jD = 0;

    public static void V(Context context) {
        String strSm = ag.Sm();
        a aVar = new a();
        if (TextUtils.isEmpty(strSm)) {
            aVar.jD = 1;
            aVar.jC = System.currentTimeMillis();
            ag.ah(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(strSm));
            if (b(aVar.jC, System.currentTimeMillis())) {
                aVar.jD++;
            } else {
                aVar.jD = 1;
            }
            aVar.jC = System.currentTimeMillis();
            ag.ah(context, aVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }

    private static boolean b(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return jB.format(new Date(j)).equals(jB.format(new Date(j2)));
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        return false;
    }
}
