package com.kwad.sdk.mobileid.a;

import android.annotation.SuppressLint;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.al;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b extends d {
    private static String aYk;

    private static String Pu() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @SuppressLint({"SimpleDateFormat"})
    private static String Pv() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }

    private static String Pw() {
        return "300012755841";
    }

    private static String Px() {
        return "CB607A51A7A639E532D288AB8C963DB6";
    }

    private static String am(String str, String str2) {
        return al.md5(Pw() + str + str2 + "2.0" + Px());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        try {
            aYk = Pu();
            String strPv = Pv();
            String strAm = am(strPv, aYk);
            putBody("timestamp", strPv);
            putBody("sign", strAm);
            putBody("traceId", aYk);
            putBody("appId", Pw());
            putBody("interfaceVersion", "2.0");
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.CK();
    }

    @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }
}
