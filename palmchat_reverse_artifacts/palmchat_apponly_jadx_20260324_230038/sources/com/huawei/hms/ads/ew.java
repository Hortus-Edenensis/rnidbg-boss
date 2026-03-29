package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.RewardItem;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ew extends ah {

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements com.huawei.openalliance.ad.inter.listeners.g {
        RewardItem Code;
        private RemoteCallResultCallback<String> I;
        private String V;

        public a(RemoteCallResultCallback<String> remoteCallResultCallback, String str, RewardItem rewardItem) {
            this.Code = rewardItem;
            this.I = remoteCallResultCallback;
            this.V = str;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void B() {
            ah.Code(this.I, this.V, 1000, new JsbCallBackData(this.Code, false, ai.Z));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void Code() {
            ah.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ai.I));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void I() {
            ah.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ai.S));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void V() {
            ah.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ai.C));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void Z() {
            ah.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ai.V));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void Code(int i, int i2) {
            ah.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ai.B));
        }
    }

    public ew() {
        super(ak.j);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, true, new ad() { // from class: com.huawei.hms.ads.ew.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                if (adContentData == null) {
                    fh.V("JsbStartRewardAdActivity", "adContentData is null, start activity failed");
                    ah.Code(remoteCallResultCallback, ew.this.Code, 3002, null, true);
                    return;
                }
                com.huawei.openalliance.ad.inter.data.q qVar = new com.huawei.openalliance.ad.inter.data.q(adContentData);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String strOptString = jSONObject.optString(com.huawei.openalliance.ad.constant.az.u);
                    String strOptString2 = jSONObject.optString("userId");
                    boolean zOptBoolean = jSONObject.optBoolean("muted", true);
                    boolean zOptBoolean2 = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.az.aA, true);
                    int iOptInt = jSONObject.optInt("audioFocusType", 1);
                    if (!TextUtils.isEmpty(strOptString)) {
                        qVar.Code(strOptString);
                    }
                    if (!TextUtils.isEmpty(strOptString2)) {
                        qVar.V(strOptString2);
                    }
                    if (iOptInt == 1 || iOptInt == 2 || iOptInt == 0) {
                        qVar.Code(iOptInt);
                    }
                    qVar.Code(zOptBoolean);
                    qVar.V(zOptBoolean2);
                    qVar.a_(true);
                } catch (Throwable unused) {
                    fh.I("JsbStartRewardAdActivity", "content parse error");
                }
                qVar.Code(ew.this.Code(context), new a(remoteCallResultCallback, ew.this.Code, qVar.S()));
                ew.this.V(remoteCallResultCallback, false);
            }
        });
    }
}
