package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    private static List<WeakReference<k.b>> Ps;

    /* JADX INFO: renamed from: com.kwad.components.core.e.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0539a {
        private b PA;
        private d PB;
        private boolean PC;
        private boolean PD;
        private long PE;
        private boolean PF;
        private boolean PG;
        public String PI;
        public a.C0601a PJ;
        private JSONObject PM;
        private boolean PO;
        private int PP;
        private int PQ;
        private int PR;
        private int PS;
        private Callable<String> PT;
        private String PU;
        private boolean PV;
        private boolean Pt;
        private boolean Pu;
        private boolean Pv;
        private boolean Pw;
        private boolean Px;
        private boolean Py;
        private boolean Pz;
        private AdTemplate adTemplate;
        private final Context context;
        private int mF;
        private int mH;
        public aj.a mJ;
        public long yY;
        public int PH = -1;
        public int PK = 0;
        public int PL = -1;
        private boolean PN = false;

        public C0539a(Context context) {
            this.context = context;
        }

        public final C0539a A(long j) {
            this.PE = j;
            return this;
        }

        public final C0539a B(long j) {
            this.yY = j;
            return this;
        }

        public final C0539a a(@Nullable Callable<String> callable) {
            this.PT = callable;
            return this;
        }

        public final void aA(int i) {
            this.PQ = i;
        }

        public final C0539a aB(int i) {
            this.PS = i;
            return this;
        }

        public final C0539a aC(int i) {
            this.mH = i;
            return this;
        }

        public final C0539a aD(int i) {
            this.mF = i;
            return this;
        }

        public final C0539a aE(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final C0539a aF(int i) {
            this.PL = i;
            return this;
        }

        public final C0539a aG(int i) {
            this.PP = i;
            return this;
        }

        public final C0539a aH(int i) {
            this.PR = i;
            return this;
        }

        public final C0539a ao(String str) {
            this.PU = str;
            return this;
        }

        public final C0539a ap(boolean z) {
            this.Py = z;
            return this;
        }

        public final C0539a aq(boolean z) {
            this.Pz = true;
            return this;
        }

        public final C0539a ar(boolean z) {
            this.Px = true;
            return this;
        }

        public final C0539a as(boolean z) {
            this.PC = z;
            return this;
        }

        public final C0539a at(boolean z) {
            this.PF = z;
            return this;
        }

        public final C0539a au(boolean z) {
            this.PG = z;
            return this;
        }

        public final C0539a av(boolean z) {
            this.PN = z;
            return this;
        }

        public final C0539a aw(boolean z) {
            this.Pu = z;
            return this;
        }

        public final C0539a ax(boolean z) {
            this.Pw = true;
            return this;
        }

        public final C0539a ay(boolean z) {
            this.Pt = z;
            return this;
        }

        public final C0539a az(boolean z) {
            this.PO = z;
            return this;
        }

        public final C0539a b(d dVar) {
            this.PB = dVar;
            return this;
        }

        public final C0539a d(aj.a aVar) {
            this.mJ = aVar;
            return this;
        }

        public final int dX() {
            return this.mF;
        }

        public final int ea() {
            return this.mH;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final Context getContext() {
            return this.context;
        }

        public final d ik() {
            return this.PB;
        }

        public final JSONObject iy() {
            return this.PM;
        }

        public final boolean pA() {
            return this.Pz;
        }

        public final boolean pB() {
            return this.PC;
        }

        public final long pC() {
            return this.PE;
        }

        public final boolean pD() {
            return this.PF;
        }

        public final boolean pE() {
            return this.PG;
        }

        public final com.kwad.sdk.core.adlog.c.a pF() {
            return com.kwad.sdk.core.adlog.c.a.Gz().dp(this.mH).dE(this.PI).e(this.mJ).dq(this.PK).dr(this.PL).au(this.yY).a(this.PJ).ds(this.PH);
        }

        public final boolean pG() {
            return this.PN;
        }

        public final boolean pH() {
            return this.Pu;
        }

        public final boolean pI() {
            return this.Pw;
        }

        public final boolean pJ() {
            return this.Pt;
        }

        public final boolean pK() {
            return this.PO;
        }

        public final int pL() {
            return this.PP;
        }

        public final int pM() {
            return this.PR;
        }

        public final boolean pN() {
            return this.Pv;
        }

        public final boolean pO() {
            return this.PV;
        }

        public final String ps() {
            return this.PU;
        }

        public final Callable<String> pt() {
            return this.PT;
        }

        public final boolean pu() {
            return this.PD;
        }

        public final int pv() {
            return this.PQ;
        }

        public final b pw() {
            return this.PA;
        }

        public final boolean px() {
            return this.Px;
        }

        public final int py() {
            return this.PS;
        }

        public final boolean pz() {
            return this.Py;
        }

        public final C0539a a(b bVar) {
            this.PA = bVar;
            return this;
        }

        public final C0539a aA(boolean z) {
            this.Pv = true;
            return this;
        }

        public final void aB(boolean z) {
            this.PV = true;
        }

        public final C0539a aE(int i) {
            this.PK = i;
            return this;
        }

        public final void ao(boolean z) {
            this.PD = true;
        }

        public final C0539a ap(String str) {
            this.PI = str;
            return this;
        }

        public final C0539a d(JSONObject jSONObject) {
            this.PM = jSONObject;
            return this;
        }

        public final C0539a a(String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
            if (this.PJ == null) {
                this.PJ = new a.C0601a();
            }
            this.PJ.a(this.adTemplate, null, null, null);
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onAdClicked();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable d dVar, boolean z, boolean z2, boolean z3, boolean z4) {
        com.kwad.sdk.commercial.d.a.f(adTemplate, true);
        adTemplate.converted = true;
        e.aC(false);
        AdInfo adInfoEr = com.kwad.sdk.core.response.b.e.er(adTemplate);
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        C0539a c0539aAv = new C0539a(context).aE(adTemplate).a(bVar).b(dVar).as(z).at(z2).ap(z4).av(false);
        int iAo = com.kwad.sdk.core.response.b.a.ao(adInfoEr);
        if (!(z3 || c0539aAv.pM() == 2 || c0539aAv.pM() == 1) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aT(adInfoEr)) && !c0539aAv.pI()) {
            if (iAo == 1) {
                return com.kwad.sdk.core.response.b.a.bj(adInfoEr) ? k(c0539aAv) : l(c0539aAv);
            }
            if (iAo == 2) {
                int iH = h(c0539aAv);
                if (iH == 1) {
                    return 13;
                }
                if (iH == 2) {
                    return 16;
                }
                return com.kwad.sdk.core.response.b.a.bj(adInfoEr) ? k(c0539aAv) : l(c0539aAv);
            }
        }
        int iH2 = h(c0539aAv);
        if (iH2 == 1) {
            return 13;
        }
        if (iH2 == 2) {
            return 16;
        }
        if (!com.kwad.sdk.core.response.b.a.aG(adInfoEr)) {
            if (j(c0539aAv)) {
                return 11;
            }
            return l(c0539aAv);
        }
        int iM = m(c0539aAv);
        int i = adInfoEr.status;
        if (i != 2 && i != 3) {
            e(c0539aAv);
        }
        return iM;
    }

    private static int b(C0539a c0539a) {
        Context context = c0539a.getContext();
        AdTemplate adTemplate = c0539a.getAdTemplate();
        AdInfo adInfoEr = com.kwad.sdk.core.response.b.e.er(adTemplate);
        Activity activityFromContext = m.getActivityFromContext(context);
        if (activityFromContext == null || !com.kwad.sdk.core.response.b.a.W(adInfoEr) || c0539a.pu() || c0539a.pz()) {
            AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0552a().aI(com.kwad.sdk.core.response.b.b.cR(adTemplate)).aG(adTemplate).aJ(true).rV());
            d(adTemplate, 20);
            return 20;
        }
        c0539a.aA(2);
        com.kwad.components.core.e.e.e.a(activityFromContext, c0539a);
        d(adTemplate, 19);
        return 19;
    }

    public static boolean c(C0539a c0539a) {
        return com.kwad.sdk.core.response.b.a.aG(com.kwad.sdk.core.response.b.e.er(c0539a.getAdTemplate())) ? !c0539a.pK() && d.E(c0539a) == 3 : d(c0539a) == 1;
    }

    private static int d(C0539a c0539a) {
        AdInfo adInfoEr = com.kwad.sdk.core.response.b.e.er(c0539a.getAdTemplate());
        if (adInfoEr.unDownloadConf.unDownloadRegionConf == null) {
            return 0;
        }
        int iDX = c0539a.dX();
        return iDX != 2 ? iDX != 3 ? adInfoEr.unDownloadConf.unDownloadRegionConf.actionBarType : adInfoEr.unDownloadConf.unDownloadRegionConf.materialJumpType : adInfoEr.unDownloadConf.unDownloadRegionConf.describeBarType;
    }

    private static void e(C0539a c0539a) {
        if (c0539a.pu() || c0539a.pO()) {
            return;
        }
        g(c0539a);
        f(c0539a);
        if (c0539a.pw() != null) {
            try {
                c0539a.pw().onAdClicked();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        com.kwad.sdk.commercial.d.a.br(c0539a.getAdTemplate());
    }

    private static void f(C0539a c0539a) {
        if (c0539a.pE()) {
            com.kwad.sdk.core.adlog.c.a(c0539a.adTemplate, c0539a.pF(), c0539a.iy());
        }
    }

    private static void g(C0539a c0539a) {
        k.b bVar;
        List<WeakReference<k.b>> list = Ps;
        if (list == null || list.isEmpty() || c0539a.adTemplate == null) {
            return;
        }
        for (WeakReference<k.b> weakReference : Ps) {
            if (weakReference != null && (bVar = weakReference.get()) != null) {
                bVar.S(com.kwad.sdk.core.response.b.e.eB(c0539a.adTemplate));
            }
        }
    }

    private static int h(C0539a c0539a) {
        AdTemplate adTemplate = c0539a.getAdTemplate();
        AdInfo adInfoEr = com.kwad.sdk.core.response.b.e.er(adTemplate);
        int iA = e.a(c0539a, 1);
        if (iA == 1) {
            e.aC(true);
            e(c0539a);
            if ((com.kwad.sdk.core.response.b.a.cR(adInfoEr) || com.kwad.sdk.core.response.b.a.cS(adInfoEr)) && !c0539a.pN()) {
                com.kwad.sdk.core.adlog.c.m(c0539a.getAdTemplate(), (int) Math.ceil(c0539a.pC() / 1000.0f));
            }
            d(adTemplate, 13);
        } else if (iA == 2) {
            e(c0539a);
            d(adTemplate, 16);
        }
        return iA;
    }

    private static int i(C0539a c0539a) {
        Context context = c0539a.getContext();
        AdTemplate adTemplate = c0539a.getAdTemplate();
        AdInfo adInfoEr = com.kwad.sdk.core.response.b.e.er(c0539a.getAdTemplate());
        Activity activityFromContext = m.getActivityFromContext(c0539a.getContext());
        if (activityFromContext == null || !com.kwad.sdk.core.response.b.a.U(adInfoEr) || c0539a.pu() || !f.F(adInfoEr) || c0539a.pz()) {
            int iE = f.e(context, adTemplate);
            if (iE == 1) {
                e(c0539a);
                d(adTemplate, 12);
            }
            return iE;
        }
        c0539a.aA(1);
        com.kwad.components.core.e.e.e.a(activityFromContext, c0539a);
        e(c0539a);
        d(adTemplate, 17);
        return 2;
    }

    private static boolean j(C0539a c0539a) {
        AdTemplate adTemplate = c0539a.getAdTemplate();
        boolean zL = com.kwad.sdk.utils.e.l(c0539a.getContext(), adTemplate);
        if (zL) {
            e(c0539a);
            com.kwad.sdk.core.adlog.c.k(adTemplate, 0);
            d(adTemplate, 11);
        }
        return zL;
    }

    private static int k(C0539a c0539a) {
        e(c0539a);
        AdTemplate adTemplate = c0539a.getAdTemplate();
        AdInfo adInfoEr = com.kwad.sdk.core.response.b.e.er(c0539a.getAdTemplate());
        Activity activityFromContext = m.getActivityFromContext(c0539a.getContext());
        if (activityFromContext == null || !com.kwad.sdk.core.response.b.a.W(adInfoEr) || c0539a.pu() || c0539a.pz()) {
            AdWebViewVideoActivityProxy.launch(c0539a.getContext(), adTemplate);
            d(adTemplate, 15);
            return 15;
        }
        c0539a.aA(2);
        com.kwad.components.core.e.e.e.a(activityFromContext, c0539a);
        d(adTemplate, 19);
        return 19;
    }

    private static int l(C0539a c0539a) {
        e(c0539a);
        Context context = c0539a.getContext();
        AdTemplate adTemplate = c0539a.getAdTemplate();
        AdInfo adInfoEr = com.kwad.sdk.core.response.b.e.er(adTemplate);
        Activity activityFromContext = m.getActivityFromContext(context);
        if (activityFromContext == null || !com.kwad.sdk.core.response.b.a.W(adInfoEr) || c0539a.pu() || c0539a.pz()) {
            AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0552a().aI(com.kwad.sdk.core.response.b.b.cR(adTemplate)).aG(adTemplate).aK(c0539a.px()).aQ(com.kwad.sdk.core.response.b.a.dA(adInfoEr) ? 2 : 1).rV());
            d(adTemplate, 14);
            return 14;
        }
        c0539a.aA(2);
        com.kwad.components.core.e.e.e.a(activityFromContext, c0539a);
        d(adTemplate, 19);
        return 19;
    }

    private static int m(C0539a c0539a) {
        d dVarIk = c0539a.ik();
        if (dVarIk == null) {
            dVarIk = new d(c0539a.adTemplate);
            c0539a.b(dVarIk);
        }
        int iV = dVarIk.v(c0539a);
        d(c0539a.getAdTemplate(), iV);
        return iV;
    }

    private static int n(C0539a c0539a) {
        AdTemplate adTemplate = c0539a.getAdTemplate();
        AdInfo adInfoEr = com.kwad.sdk.core.response.b.e.er(adTemplate);
        if (j(c0539a)) {
            return 11;
        }
        return (!com.kwad.sdk.core.response.b.a.b(adInfoEr, com.kwad.sdk.core.config.e.Hc()) || adTemplate.mAdWebVideoPageShowing) ? l(c0539a) : k(c0539a);
    }

    public static void d(AdTemplate adTemplate, int i) {
        switch (i) {
            case 0:
                com.kwad.sdk.commercial.d.a.bH(adTemplate);
                break;
            case 1:
                com.kwad.sdk.commercial.d.a.bw(adTemplate);
                break;
            case 2:
                com.kwad.sdk.commercial.d.a.bG(adTemplate);
                break;
            case 3:
                com.kwad.sdk.commercial.d.a.by(adTemplate);
                break;
            case 4:
                com.kwad.sdk.commercial.d.a.bE(adTemplate);
                break;
            case 5:
                com.kwad.sdk.commercial.d.a.bF(adTemplate);
                break;
            case 6:
                com.kwad.sdk.commercial.d.a.bz(adTemplate);
                break;
            case 7:
                com.kwad.sdk.commercial.d.a.bA(adTemplate);
                break;
            case 8:
                com.kwad.sdk.commercial.d.a.bB(adTemplate);
                break;
            case 9:
                com.kwad.sdk.commercial.d.a.bD(adTemplate);
                break;
            case 10:
                com.kwad.sdk.commercial.d.a.bC(adTemplate);
                break;
            case 11:
                com.kwad.sdk.commercial.d.a.bv(adTemplate);
                break;
            case 12:
                com.kwad.sdk.commercial.d.a.bu(adTemplate);
                break;
            case 13:
                com.kwad.sdk.commercial.d.a.bt(adTemplate);
                break;
            case 14:
                com.kwad.sdk.commercial.d.a.bs(adTemplate);
                break;
            case 15:
                com.kwad.sdk.commercial.d.a.bx(adTemplate);
                break;
            case 16:
                com.kwad.sdk.commercial.d.a.bJ(adTemplate);
                break;
            case 17:
                com.kwad.sdk.commercial.d.a.bM(adTemplate);
                break;
            case 18:
                com.kwad.sdk.commercial.d.a.bI(adTemplate);
                break;
            case 19:
                com.kwad.sdk.commercial.d.a.bK(adTemplate);
                break;
            case 20:
                com.kwad.sdk.commercial.d.a.bL(adTemplate);
                break;
        }
    }

    public static void b(k.b bVar) {
        if (Ps == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= Ps.size()) {
                i = -1;
                break;
            }
            WeakReference<k.b> weakReference = Ps.get(i);
            if (weakReference != null && weakReference.get() != null && bVar == weakReference.get()) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            Ps.remove(i);
        }
    }

    public static int a(C0539a c0539a) {
        Context context = c0539a.getContext();
        AdTemplate adTemplate = c0539a.getAdTemplate();
        AdInfo adInfoEr = com.kwad.sdk.core.response.b.e.er(adTemplate);
        e.aC(false);
        if (c0539a.pA()) {
            return b(c0539a);
        }
        if (c0539a.pJ()) {
            return a(context, adTemplate, c0539a.pw(), c0539a.ik(), c0539a.PC, c0539a.pD(), false, c0539a.pz());
        }
        com.kwad.sdk.commercial.d.a.f(adTemplate, false);
        if (c(c0539a)) {
            d(adTemplate, 1);
            return 1;
        }
        adTemplate.converted = true;
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        if (com.kwad.sdk.core.response.b.a.dA(adInfoEr) && !adTemplate.hasInnerEcFailed()) {
            e(c0539a);
            c0539a.aB(true);
            int iA = com.kwad.components.core.innerEc.f.a(context, adTemplate, c0539a);
            if (iA == 1) {
                return 14;
            }
            if (iA == 2) {
                com.kwad.components.core.innerEc.qcpx.b.h(context, adTemplate);
                com.kwad.components.core.innerEc.f.g(context, adTemplate);
                return 14;
            }
            if (iA == 3) {
                return com.kwad.components.core.innerEc.f.G(c0539a);
            }
        }
        int iAo = com.kwad.sdk.core.response.b.a.ao(adInfoEr);
        if (!(c0539a.pM() == 2 || c0539a.pM() == 1) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aT(adInfoEr)) && !c0539a.pI()) {
            if (iAo == 1) {
                if (com.kwad.sdk.core.response.b.a.bj(adInfoEr)) {
                    return k(c0539a);
                }
                return l(c0539a);
            }
            if (iAo == 2) {
                int iH = h(c0539a);
                if (iH == 1) {
                    return 13;
                }
                if (iH == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.b.a.bj(adInfoEr)) {
                    return k(c0539a);
                }
                return l(c0539a);
            }
        }
        int iH2 = h(c0539a);
        if (iH2 == 1) {
            return 13;
        }
        if (iH2 == 2) {
            return 16;
        }
        int i = i(c0539a);
        if (i == 1) {
            return 12;
        }
        if (i == 2) {
            return 17;
        }
        if (c0539a.pH() && !com.kwad.sdk.core.response.b.a.aG(adInfoEr)) {
            return n(c0539a);
        }
        if (!com.kwad.sdk.core.response.b.a.aG(adInfoEr)) {
            if (adTemplate.isWebViewDownload) {
                int iM = m(c0539a);
                adTemplate.isWebViewDownload = false;
                return iM;
            }
            if (j(c0539a)) {
                return 11;
            }
            return l(c0539a);
        }
        if (c0539a.pM() != 2 && c0539a.pM() != 1) {
            if (c0539a.pH() && com.kwad.sdk.core.response.b.a.b(adInfoEr, com.kwad.sdk.core.config.e.Hc()) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aT(adInfoEr)) && !AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity) {
                int iU = c0539a.ik().u(c0539a);
                if (iU == 0) {
                    return k(c0539a);
                }
                e(c0539a);
                d(adTemplate, iU);
                return iU;
            }
            e(c0539a);
            c0539a.av(true);
            return m(c0539a);
        }
        c0539a.av(false);
        e(c0539a);
        return m(c0539a);
    }

    public static void a(k.b bVar) {
        if (Ps == null) {
            Ps = new CopyOnWriteArrayList();
        }
        Ps.add(new WeakReference<>(bVar));
    }
}
