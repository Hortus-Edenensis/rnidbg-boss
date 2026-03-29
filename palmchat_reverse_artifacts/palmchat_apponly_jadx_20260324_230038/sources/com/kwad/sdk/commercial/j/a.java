package com.kwad.sdk.commercial.j;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.commercial.e;
import com.kwad.sdk.core.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    private static C0599a aAT;

    /* JADX INFO: renamed from: com.kwad.sdk.commercial.j.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    @KsJson
    public static class C0599a extends com.kwad.sdk.core.response.a.a {
        public List<String> aAU;
    }

    private static C0599a FS() {
        String strDB = ((h) ServiceProvider.get(h.class)).DB();
        if (!TextUtils.isEmpty(strDB)) {
            aAT = (C0599a) aa.b(strDB, new c<C0599a>() { // from class: com.kwad.sdk.commercial.j.a.1
                private static C0599a FT() {
                    return new C0599a();
                }

                @Override // com.kwad.sdk.core.c
                public final /* synthetic */ com.kwad.sdk.core.b FU() {
                    return FT();
                }
            });
        }
        return aAT;
    }

    private static void a(AdTemplate adTemplate, b bVar) {
        a(adTemplate, false, bVar);
    }

    private static boolean dn(String str) {
        C0599a c0599aFS;
        List<String> list;
        if (TextUtils.isEmpty(str) || (c0599aFS = FS()) == null || (list = c0599aFS.aAU) == null) {
            return false;
        }
        for (String str2 : list) {
            if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void n(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.FV().cY(4).cZ(i).m62do(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void o(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.FV().cY(1).cZ(i).m62do(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(AdTemplate adTemplate, boolean z, b bVar) {
        if (dn(bVar.aAN)) {
            return;
        }
        com.kwad.sdk.commercial.c.d(d.FH().cR(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.001d).b(e.bh(adTemplate)).O("ad_sdk_track_performance", "status").z(bVar));
    }

    public static void a(AdTemplate adTemplate, String str, String str2, String str3, String str4) {
        try {
            com.kwad.sdk.commercial.c.d(d.FH().cR(ILoggerReporter.Category.ERROR_LOG).i(1.0d).b(e.bh(adTemplate)).O("ad_sdk_macro_check_performance", "error_name").z(com.kwad.sdk.commercial.i.a.FR().dg(str).di(str2).dj(str3).dh(str4).setAdTemplate(adTemplate)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i, String str, int i2, int i3) {
        try {
            a(adTemplate, b.FV().cY(2).cZ(i).m62do(str).da(i3).setErrorCode(i2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i, String str, String str2, int i2, String str3, int i3) {
        try {
            a(adTemplate, true, b.FV().cY(3).cZ(i).m62do(str).dp(str2).setErrorCode(i2).setErrorMsg(str3).da(i3).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
