package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.inner.data.H5Ad;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class eq extends ag {

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements com.huawei.openalliance.ad.inter.listeners.i {
        private String Code;
        private String I;
        private Context V;
        private RemoteCallResultCallback<String> Z;

        public a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback, String str2) {
            this.Code = str;
            this.V = context;
            this.Z = remoteCallResultCallback;
            this.I = str2;
        }

        private List<H5Ad> Code(List<AdContentData> list) {
            ArrayList arrayList = new ArrayList(4);
            if (list != null && list.size() > 0) {
                for (AdContentData adContentData : list) {
                    if (adContentData != null && adContentData.d() > System.currentTimeMillis()) {
                        if (TextUtils.isEmpty(adContentData.aa())) {
                            adContentData.S(UUID.randomUUID().toString());
                        }
                        arrayList.add(new H5Ad(adContentData));
                    }
                }
            }
            return arrayList;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.i
        public void Code(int i) {
            ah.Code(this.Z, this.I, bx.Code(i), null, true);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.i
        public void Code(Map<String, List<AdContentData>> map) {
            if (map == null || map.size() <= 0) {
                fh.V("JsbReqInterstitialAd", " ads map is empty.");
            } else {
                List<H5Ad> listCode = Code(map.get(this.Code));
                if (listCode.size() > 0) {
                    ah.Code(this.Z, this.I, 1000, com.huawei.openalliance.ad.utils.ad.V(listCode), true);
                    return;
                }
                fh.Code("JsbReqInterstitialAd", " ads is empty.");
            }
            ah.Code(this.Z, this.I, 1005, null, true);
        }
    }

    public eq() {
        super(ak.Z);
    }

    @Override // com.huawei.hms.ads.ag
    public void Code(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        String strOptString = new JSONObject(str).optString("slotId");
        AdParam adParamI = I(context, str);
        ab abVar = new ab(context);
        abVar.Code(strOptString);
        abVar.Code((Integer) 3);
        abVar.Code(new a(context, strOptString, remoteCallResultCallback, this.Code));
        abVar.Code(adParamI);
    }
}
