package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ev extends ah {
    public ev() {
        super(ak.k);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, true, new ad() { // from class: com.huawei.hms.ads.ev.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                if (adContentData == null) {
                    ah.Code(remoteCallResultCallback, ev.this.Code, 3002, null, true);
                    fh.Code("JsbStartInterstitialAdActivity", "adContentData is null, start activity failed");
                    return;
                }
                com.huawei.hms.ads.inter.data.a aVar = new com.huawei.hms.ads.inter.data.a(adContentData);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String strOptString = jSONObject.optString(com.huawei.openalliance.ad.constant.az.u);
                    String strOptString2 = jSONObject.optString("userId");
                    boolean zOptBoolean = jSONObject.optBoolean("muted", true);
                    boolean zOptBoolean2 = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.az.aC, true);
                    if (!TextUtils.isEmpty(strOptString)) {
                        aVar.Code(strOptString);
                    }
                    if (!TextUtils.isEmpty(strOptString2)) {
                        aVar.V(strOptString2);
                    }
                    aVar.Code(zOptBoolean);
                    aVar.setMobileDataAlertSwitch(zOptBoolean2);
                    aVar.V(true);
                } catch (Throwable unused) {
                    fh.I("JsbStartInterstitialAdActivity", "content parse error");
                }
                aVar.show(ev.this.Code(context), new a(remoteCallResultCallback, ev.this.Code));
                ev.this.V(remoteCallResultCallback, false);
            }
        });
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements IInterstitialAdStatusListener {
        private String Code;
        private RemoteCallResultCallback<String> V;

        public a(RemoteCallResultCallback<String> remoteCallResultCallback, String str) {
            this.V = remoteCallResultCallback;
            this.Code = str;
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdClicked() {
            ah.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ai.b));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdClosed() {
            ah.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ai.F));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdCompleted() {
            ah.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ai.f6528a));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdError(int i, int i2) {
            ah.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ai.L));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdShown() {
            ah.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ai.D));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onLeftApp() {
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onRewarded() {
        }
    }
}
