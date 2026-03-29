package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.ad.beans.metadata.Om;
import com.iab.omid.library.huawei.Omid;
import com.iab.omid.library.huawei.adsession.AdSession;
import com.iab.omid.library.huawei.adsession.AdSessionConfiguration;
import com.iab.omid.library.huawei.adsession.AdSessionContext;
import com.iab.omid.library.huawei.publisher.AdSessionStatePublisher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class gq implements gy, hm {
    public static final String Code = "1.2.4";
    private static boolean I = hc.Code(hc.f);
    private static final String V = "AdsessionAgent";
    private Context B;
    private final List<AdSession> Z = new ArrayList();

    private static AdSessionStatePublisher Code(AdSession adSession) {
        if (adSession != null) {
            return adSession.getAdSessionStatePublisher();
        }
        return null;
    }

    private static String V(AdSession adSession) {
        if (adSession != null) {
            return adSession.getAdSessionId();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.hm
    public void B() {
        if (!this.Z.isEmpty()) {
            try {
                Iterator<AdSession> it = this.Z.iterator();
                while (it.hasNext()) {
                    it.next().finish();
                    fh.Code(V, " adSession finish");
                }
            } catch (Throwable unused) {
                fh.V(V, "finish, fail");
            }
        }
        this.Z.clear();
    }

    @Override // com.huawei.hms.ads.hm
    public void C() {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            Iterator<AdSession> it = this.Z.iterator();
            while (it.hasNext()) {
                it.next().removeAllFriendlyObstructions();
            }
        } catch (Throwable unused) {
            fh.V(V, "removeAllFriendlyObstructions, fail");
        }
    }

    @Override // com.huawei.hms.ads.hm
    public String F() {
        if (this.Z.isEmpty()) {
            return null;
        }
        return V(this.Z.get(0));
    }

    public Context I() {
        return this.B;
    }

    @Override // com.huawei.hms.ads.hm
    public hi S() {
        if (this.Z.isEmpty() || !hi.Code()) {
            return null;
        }
        return new hi(Code(this.Z.get(0)));
    }

    @Override // com.huawei.hms.ads.hm
    public void Z() {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (AdSession adSession : this.Z) {
                fh.Code(V, "adsession start");
                adSession.start();
            }
        } catch (Throwable unused) {
            fh.V(V, "start, fail");
        }
    }

    public void Code(Context context, List<Om> list, hg hgVar) {
        if (!Code() || context == null || list == null) {
            fh.V(V, "not available, not init");
            return;
        }
        if (list.isEmpty() || hgVar == null) {
            fh.V(V, "oms is empty or sessionWrapper is null, not init");
            return;
        }
        fh.V(V, "init");
        this.B = context;
        Code(list, hgVar);
    }

    @Override // com.huawei.hms.ads.hm
    public void I(View view) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            Iterator<AdSession> it = this.Z.iterator();
            while (it.hasNext()) {
                it.next().removeFriendlyObstruction(view);
            }
        } catch (Throwable unused) {
            fh.V(V, "addFriendlyObstruction, fail");
        }
    }

    public List<AdSession> V() {
        return this.Z;
    }

    @Override // com.huawei.hms.ads.hm
    public void Code(View view) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            Iterator<AdSession> it = this.Z.iterator();
            while (it.hasNext()) {
                it.next().registerAdView(view);
            }
        } catch (Throwable unused) {
            fh.V(V, "registerAdView, fail");
        }
    }

    @Override // com.huawei.hms.ads.hm
    public void V(View view) {
    }

    @Override // com.huawei.hms.ads.hm
    public void Code(View view, hl hlVar, String str) {
        if (this.Z.isEmpty() || hlVar == null || !hl.Code()) {
            return;
        }
        try {
            Iterator<AdSession> it = this.Z.iterator();
            while (it.hasNext()) {
                it.next().addFriendlyObstruction(view, hl.Code(hlVar), str);
            }
        } catch (Throwable unused) {
            fh.V(V, "addFriendlyObstruction-f, fail");
        }
    }

    private void Code(hg hgVar, hq hqVar) {
        String str;
        if (hqVar == null) {
            str = "init AdSessionContext failed";
        } else {
            if (!hh.Code()) {
                return;
            }
            AdSessionContext adSessionContextCode = new hh(this.B).Code(hqVar, null);
            if (adSessionContextCode != null) {
                Code(adSessionContextCode, hgVar);
                return;
            }
            str = "adSessionContext is null";
        }
        fh.V(V, str);
    }

    @Override // com.huawei.hms.ads.hm
    public void Code(hk hkVar, String str) {
        if (this.Z.isEmpty() || hkVar == null || !hk.Code()) {
            return;
        }
        try {
            Iterator<AdSession> it = this.Z.iterator();
            while (it.hasNext()) {
                it.next().error(hk.Code(hkVar), str);
            }
        } catch (Throwable unused) {
            fh.V(V, "error, fail");
        }
    }

    private void Code(AdSessionContext adSessionContext, hg hgVar) {
        try {
            if (hg.Code() && hgVar != null) {
                AdSessionConfiguration adSessionConfigurationV = hgVar.V();
                if (adSessionConfigurationV == null) {
                    fh.V(V, "adSessionConfiguration is null");
                    return;
                }
                fh.V(V, "initAdSession");
                AdSession adSessionCreateAdSession = Code(this.B) ? AdSession.createAdSession(adSessionConfigurationV, adSessionContext) : null;
                if (adSessionCreateAdSession == null) {
                    fh.V(V, "adSession is null");
                    return;
                } else {
                    this.Z.add(adSessionCreateAdSession);
                    return;
                }
            }
            fh.V(V, "init AdSession failed");
        } catch (Throwable unused) {
            fh.I(V, "initAdSession error");
        }
    }

    private void Code(List<Om> list, hg hgVar) {
        if (!hq.Code()) {
            fh.V(V, "init VerficationScriptResourceWrapper failed");
            return;
        }
        for (Om om : list) {
            fh.V(V, "Init Verfication Script");
            hq hqVar = new hq();
            hqVar.Code(om);
            Code(hgVar, hqVar);
        }
    }

    public static boolean Code() {
        return I;
    }

    private static boolean Code(Context context) {
        Omid.activate(context);
        return true;
    }
}
