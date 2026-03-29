package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.consent.bean.AdProvider;
import com.huawei.hms.ads.consent.constant.ConsentStatus;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.hms.ads.consent.inter.ConsentUpdateListener;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ar extends ah {
    public ar() {
        super(ak.v);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Consent.getInstance(context).requestConsentUpdate(new ConsentUpdateListener() { // from class: com.huawei.hms.ads.ar.1
            public void onFail(String str2) {
                ah.Code(remoteCallResultCallback, ar.this.Code, 3006, str2, true);
            }

            public void onSuccess(ConsentStatus consentStatus, boolean z, List<AdProvider> list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(com.huawei.openalliance.ad.constant.az.Q, consentStatus.getValue());
                    jSONObject.put(com.huawei.openalliance.ad.constant.az.T, z);
                    JSONArray jSONArray = new JSONArray();
                    if (!com.huawei.openalliance.ad.utils.ag.Code(list)) {
                        for (AdProvider adProvider : list) {
                            JSONObject jSONObject2 = new JSONObject();
                            if (adProvider != null) {
                                jSONObject2.put("id", adProvider.getId());
                                jSONObject2.put("name", adProvider.getName());
                                jSONObject2.put(com.huawei.openalliance.ad.constant.az.ac, adProvider.getServiceArea());
                                jSONObject2.put("privacyPolicyUrl", adProvider.getPrivacyPolicyUrl());
                            }
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject.put(com.huawei.openalliance.ad.constant.az.U, jSONArray);
                    ah.Code(remoteCallResultCallback, ar.this.Code, 1000, jSONObject.toString(), true);
                } catch (Throwable unused) {
                    ah.Code(remoteCallResultCallback, ar.this.Code, 3006, "consent info is null", true);
                }
            }
        });
    }
}
