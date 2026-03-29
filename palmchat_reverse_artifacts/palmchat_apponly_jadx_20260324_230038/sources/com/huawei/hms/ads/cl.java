package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.ISplashApi;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.utils.SafeIntent;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class cl extends ISplashApi.b {
    private ft p;
    private AdContentData q;
    private WeakReference<Context> r;
    private Context s;
    private String t;

    public cl(Context context, ft ftVar, AdContentData adContentData) {
        this.s = context.getApplicationContext();
        this.r = new WeakReference<>(context);
        this.p = ftVar;
        this.q = adContentData;
    }

    private void B(Bundle bundle) {
        AdContentData adContentData = this.q;
        if (adContentData == null) {
            fh.V("SplashProxy", "contentRecord is null");
            return;
        }
        if (bundle != null) {
            try {
                if (adContentData.D() != null && this.q.D().equals(this.t)) {
                    fh.V("SplashProxy", "Duplicate escalation videoTime event for %s", this.q.D());
                    return;
                }
                this.q.B(bundle.getLong(bq.f.H));
                jk.V(this.s, this.q, com.huawei.openalliance.ad.constant.aj.h);
                this.t = this.q.D();
            } catch (Throwable th) {
                fh.I("SplashProxy", "reportPlayTime err: %s", th.getClass().getSimpleName());
            }
        }
    }

    private int Code(int i) {
        Integer numB = com.huawei.openalliance.ad.utils.z.b(this.s);
        if (com.huawei.openalliance.ad.utils.z.I()) {
            return i;
        }
        if (numB != null && numB.intValue() >= 30454100) {
            return i;
        }
        fh.V("SplashProxy", "HMS version is low, interactMode is %s", Integer.valueOf(i));
        if (i == 4) {
            i = 1;
        }
        if (i == 3) {
            return 2;
        }
        return i;
    }

    private void I(Bundle bundle) {
        try {
            jk.Code(this.s, this.q, com.huawei.openalliance.ad.constant.aj.Z, Long.valueOf(bundle.getLong("startTime")), Long.valueOf(bundle.getLong(bq.f.h)), Integer.valueOf((int) bundle.getLong(bq.f.i)), Integer.valueOf((int) bundle.getLong(bq.f.j)));
        } catch (Throwable th) {
            fh.I("SplashProxy", "reportPlayEnd err: %s", th.getClass().getSimpleName());
        }
    }

    private void V(Bundle bundle) {
        jk.Code(this.s, this.q, com.huawei.openalliance.ad.constant.aj.B, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    private void Z(Bundle bundle) {
        try {
            db.Code(this.s, bundle.getInt("errCode"), bundle.getString("reason"), this.q);
        } catch (Throwable th) {
            fh.I("SplashProxy", "report img loadFailed err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        fh.V("SplashProxy", "callMethod: %s", str);
        str.hashCode();
        if (str.equals("reportCommonEvent")) {
            new jj(this.s).Code(bundle, this.q);
        } else if (str.equals("onCommonAnalysis")) {
            new dd(this.s).Code(bundle, this.q);
        } else {
            fh.V("SplashProxy", "call method fall to default.");
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public Bundle callMethodForResult(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
        return null;
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public boolean isDestroyed() {
        Context context = this.r.get();
        if (context == null || !(context instanceof Activity)) {
            return false;
        }
        return ((Activity) context).isDestroyed();
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public boolean isFinishing() {
        Context context = this.r.get();
        if (context == null || !(context instanceof Activity)) {
            return false;
        }
        return ((Activity) context).isFinishing();
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void notifyAdDismissed() {
        ft ftVar = this.p;
        if (ftVar != null) {
            ftVar.a();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void notifyAdFailedToLoad(int i) {
        ft ftVar = this.p;
        if (ftVar != null) {
            ftVar.I(i);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public String notifyAdLoaded() {
        ft ftVar = this.p;
        if (ftVar == null) {
            return null;
        }
        ftVar.Code(this.q);
        return null;
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onAdFailToDisplay() {
        ft ftVar = this.p;
        if (ftVar != null) {
            ftVar.r();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onAdShowEnd(long j, int i) {
        ft ftVar = this.p;
        if (ftVar != null) {
            ftVar.Code(this.q, j, i);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onDisplayTimeUp() {
        ft ftVar = this.p;
        if (ftVar != null) {
            ftVar.n();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onEasterEggPrepare() {
        jn.Code(this.s).Code(this.q);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onFeedback(int i) {
        fh.V("SplashProxy", "onFeedback");
        dm.Code(this.s).Code();
        db.Code(this.s);
        SafeIntent safeIntent = new SafeIntent(com.huawei.openalliance.ad.constant.x.an);
        safeIntent.setPackage(com.huawei.openalliance.ad.utils.z.Z(this.s));
        safeIntent.putExtra(com.huawei.openalliance.ad.constant.be.aj, Code(i));
        if (!(this.s instanceof Activity)) {
            safeIntent.addFlags(268435456);
        }
        com.huawei.openalliance.ad.utils.bg.Code(this.s, safeIntent);
        ft ftVar = this.p;
        if (ftVar != null) {
            ftVar.C();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onMaterialLoadFailed() {
        ft ftVar = this.p;
        if (ftVar != null) {
            ftVar.I(this.q);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onMaterialLoaded() {
        ft ftVar = this.p;
        if (ftVar != null) {
            ftVar.F();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onSkipAd(int i, int i2) {
        ft ftVar = this.p;
        if (ftVar != null) {
            ftVar.Code(i, i2);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onStartEasterEggFailed(Bundle bundle) {
        jn.Code(this.s).I(this.q, bundle);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public boolean onTouch(int i, int i2, long j, String str, int i3) {
        fh.V("SplashProxy", "onTouch");
        ft ftVar = this.p;
        if (ftVar != null) {
            return ftVar.Code(i, i2, this.q, Long.valueOf(j), (MaterialClickInfo) com.huawei.openalliance.ad.utils.ad.V(str, MaterialClickInfo.class, new Class[0]), i3);
        }
        return false;
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public boolean processWhyEventUnified() {
        return com.huawei.openalliance.ad.utils.z.Code(this.s, this.q);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void removeExSplashBlock() {
        com.huawei.openalliance.ad.utils.bf.V(this.s);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void reportEvents(String str, Bundle bundle) {
        if (com.huawei.openalliance.ad.utils.bc.Code(str)) {
        }
        str.hashCode();
        switch (str) {
            case "playStart":
                V(bundle);
                break;
            case "rptImageLoadFailedEvent":
                Z(bundle);
                break;
            case "playEnd":
                I(bundle);
                break;
            case "rptSoundBtnEvent":
                Code(bundle);
                break;
            case "playTime":
                B(bundle);
                break;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void reportShowStartEvent() {
        ft ftVar = this.p;
        if (ftVar != null) {
            ftVar.L();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void reportSplashEvent(Bundle bundle) {
        db.Code(this.s, bundle, this.q);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void toShowSpare(int i) {
        ft ftVar = this.p;
        if (ftVar != null) {
            ftVar.V(i);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void updatePhyShowStart(long j) {
        ft ftVar = this.p;
        if (ftVar != null) {
            ftVar.Code(j);
        }
    }

    private void Code(Bundle bundle) {
        try {
            boolean z = bundle.getBoolean(bq.f.l);
            AdEventReport adEventReportCode = jk.Code(this.q);
            adEventReportCode.I(z);
            com.huawei.openalliance.ad.ipc.g.V(this.s).Code(com.huawei.openalliance.ad.constant.s.j, com.huawei.openalliance.ad.utils.ad.V(adEventReportCode), null, null);
        } catch (Throwable th) {
            fh.I("SplashProxy", "reportSoundClickEvent err: %s", th.getClass().getSimpleName());
        }
    }
}
