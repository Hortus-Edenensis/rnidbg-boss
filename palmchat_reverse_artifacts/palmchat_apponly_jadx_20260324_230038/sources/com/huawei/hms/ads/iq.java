package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.openalliance.ad.utils.d;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class iq extends ga<lt> implements jc<lt> {
    private Context B;
    private SplashView.SplashAdLoadListener C;
    private eh I;
    private com.huawei.openalliance.ad.inter.listeners.b Z;

    public iq(Context context, lt ltVar) {
        Code(ltVar);
        this.B = context.getApplicationContext();
        this.I = eh.Code(context);
    }

    private void D() {
        fh.I("SplashPresenter", "notifyNotSupport");
        com.huawei.openalliance.ad.inter.listeners.b bVar = this.Z;
        if (bVar != null) {
            bVar.Code(1001);
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.C;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdFailedToLoad(com.huawei.hms.ads.utils.b.Code(1001));
        }
    }

    @Override // com.huawei.hms.ads.jc
    public void F() {
        fh.Code("SplashPresenter", "notifyAdDismissed");
        com.huawei.openalliance.ad.inter.listeners.b bVar = this.Z;
        if (bVar != null) {
            bVar.V();
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.C;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdDismissed();
        }
        com.huawei.openalliance.ad.utils.bf.V(this.B);
    }

    @Override // com.huawei.hms.ads.jc
    public boolean S() {
        return d.L(this.B);
    }

    @Override // com.huawei.hms.ads.jc
    public boolean V() {
        if (com.huawei.openalliance.ad.utils.z.Code(this.B)) {
            return true;
        }
        D();
        F();
        return false;
    }

    @Override // com.huawei.hms.ads.jc
    public void Code() {
        I().Code(((Integer) com.huawei.openalliance.ad.utils.be.Code(new Callable<Integer>() { // from class: com.huawei.hms.ads.iq.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
            public Integer call() {
                return Integer.valueOf(iq.this.I.Z());
            }
        }, 1)).intValue());
    }

    @Override // com.huawei.hms.ads.jc
    public void Code(SplashView.SplashAdLoadListener splashAdLoadListener) {
        this.C = splashAdLoadListener;
    }

    @Override // com.huawei.hms.ads.jc
    public void Code(com.huawei.openalliance.ad.inter.listeners.b bVar) {
        this.Z = bVar;
    }

    @Override // com.huawei.hms.ads.jc
    public void Code(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("slotid", str);
            jSONObject.put("adType", i);
            com.huawei.openalliance.ad.ipc.g.V(this.B).Code("rptSplashDismissForExSplash", jSONObject.toString(), null, null);
        } catch (JSONException unused) {
            fh.I("SplashPresenter", "onSplashDismissForExsplash JSONException");
        }
    }

    public static boolean Code(Integer num, boolean z) {
        if (num == null) {
            return false;
        }
        return num.intValue() == 0 || (num.intValue() == 1 && z);
    }
}
