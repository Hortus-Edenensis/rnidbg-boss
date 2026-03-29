package com.kwad.components.core.e.d;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {
    private static int E(AdInfo adInfo) {
        com.kwad.sdk.core.download.a.J(adInfo);
        return 3;
    }

    private static int a(a.C0539a c0539a, AdTemplate adTemplate, Context context) {
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0552a().aI(com.kwad.sdk.core.response.b.b.cR(adTemplate)).aG(adTemplate).aK(c0539a.px()).aQ(1).rV());
        a.d(adTemplate, 14);
        return 14;
    }

    private static int b(a.C0539a c0539a) {
        Context context = c0539a.getContext();
        AdTemplate adTemplate = c0539a.getAdTemplate();
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0552a().aI(com.kwad.sdk.core.response.b.b.cR(adTemplate)).aG(adTemplate).aJ(true).rV());
        a.d(adTemplate, 20);
        return 20;
    }

    private static int d(final AdTemplate adTemplate, AdInfo adInfo) {
        h.execute(new bg() { // from class: com.kwad.components.core.e.d.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
            }
        });
        as.av(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.az(adInfo));
        return 6;
    }

    private static boolean j(a.C0539a c0539a) {
        AdTemplate adTemplate = c0539a.getAdTemplate();
        boolean zL = com.kwad.sdk.utils.e.l(c0539a.getContext(), adTemplate);
        if (zL) {
            t(c0539a);
            a.d(adTemplate, 11);
        }
        return zL;
    }

    public static int q(a.C0539a c0539a) {
        e.aC(false);
        Context context = c0539a.getContext();
        AdTemplate adTemplate = c0539a.getAdTemplate();
        AdInfo adInfoEr = com.kwad.sdk.core.response.b.e.er(adTemplate);
        if (c0539a.pA()) {
            return b(c0539a);
        }
        int iF = e.F(c0539a);
        if (iF == 1) {
            t(c0539a);
            return 13;
        }
        if (iF == 2) {
            return 16;
        }
        int iS = s(c0539a);
        if (iS == 1) {
            return 12;
        }
        if (iS == 2) {
            return 17;
        }
        if (!com.kwad.sdk.core.response.b.a.aG(adInfoEr)) {
            if (adTemplate.isWebViewDownload) {
                int iA = a(c0539a, adTemplate, adInfoEr);
                t(c0539a);
                adTemplate.isWebViewDownload = false;
                return iA;
            }
            if (j(c0539a)) {
                return 11;
            }
            t(c0539a);
            return a(c0539a, adTemplate, context);
        }
        if (c0539a.pM() == 2 || c0539a.pM() == 1) {
            c0539a.av(false);
            t(c0539a);
            return a(c0539a, adTemplate, adInfoEr);
        }
        if (!c0539a.pH() || !com.kwad.sdk.core.response.b.a.b(adInfoEr, com.kwad.sdk.core.config.e.Hc()) || TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aT(adInfoEr)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity) {
            t(c0539a);
            c0539a.av(true);
            return a(c0539a, adTemplate, adInfoEr);
        }
        int iU = c0539a.ik().u(c0539a);
        if (iU == 0) {
            t(c0539a);
            return a(c0539a, adTemplate, context);
        }
        t(c0539a);
        a.d(adTemplate, iU);
        return iU;
    }

    private static int r(a.C0539a c0539a) {
        Context context = c0539a.getContext();
        AdTemplate adTemplate = c0539a.getAdTemplate();
        AdInfo adInfoEr = com.kwad.sdk.core.response.b.e.er(adTemplate);
        if (com.kwad.sdk.utils.e.a(context, com.kwad.sdk.core.response.b.a.cX(adInfoEr), adTemplate) || a(c0539a, adTemplate)) {
            return 11;
        }
        if (ao.isNetworkConnected(context)) {
            return E(adInfoEr);
        }
        ac.S(context, ae.cZ(context));
        return 2;
    }

    private static int s(a.C0539a c0539a) {
        Context context = c0539a.getContext();
        AdTemplate adTemplate = c0539a.getAdTemplate();
        int iF = f.f(context, adTemplate);
        if (iF == 1) {
            t(c0539a);
            a.d(adTemplate, 12);
        }
        return iF;
    }

    private static void t(a.C0539a c0539a) {
        if (c0539a.pw() != null) {
            try {
                c0539a.pw().onAdClicked();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    private static int a(a.C0539a c0539a, AdTemplate adTemplate, AdInfo adInfo) {
        int iR;
        d dVarIk = c0539a.ik();
        dVarIk.pW();
        switch (adInfo.status) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                iR = r(c0539a);
                break;
            case 2:
            case 3:
            case 10:
            default:
                iR = 0;
                break;
            case 4:
                iR = dVarIk.qe();
                break;
            case 8:
            case 9:
            case 11:
                iR = dVarIk.qb();
                break;
            case 12:
                iR = d(adTemplate, adInfo);
                break;
        }
        a.d(c0539a.getAdTemplate(), iR);
        return iR;
    }

    private static boolean a(a.C0539a c0539a, AdTemplate adTemplate) {
        return com.kwad.sdk.utils.e.l(c0539a.getContext(), adTemplate);
    }
}
