package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.jsb.inner.data.H5Ad;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class et extends ag {

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements com.huawei.openalliance.ad.inter.listeners.q {
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

        private List<H5Ad> Code(List<com.huawei.openalliance.ad.inter.data.i> list) {
            ArrayList arrayList = new ArrayList(4);
            if (list != null && list.size() > 0) {
                for (com.huawei.openalliance.ad.inter.data.i iVar : list) {
                    if (iVar != null) {
                        arrayList.add(new H5Ad(iVar.q()));
                    }
                }
            }
            return arrayList;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.q
        public void Code(int i) {
            ah.Code(this.Z, this.I, bx.Code(i), null, true);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.q
        public void Code(Map<String, List<com.huawei.openalliance.ad.inter.data.i>> map) {
            if (map != null && map.size() > 0) {
                List<H5Ad> listCode = Code(map.get(this.Code));
                if (listCode.size() > 0) {
                    ah.Code(this.Z, this.I, 1000, com.huawei.openalliance.ad.utils.ad.V(listCode), true);
                    return;
                }
            }
            fh.V("JsbReqRewardAd", " ads map is empty.");
            ah.Code(this.Z, this.I, 1005, null, true);
        }
    }

    public et() {
        super(ak.I);
    }

    @Override // com.huawei.hms.ads.ag
    public void Code(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("slotId");
        String strOptString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.az.W);
        int iOptInt = jSONObject.optInt(com.huawei.openalliance.ad.constant.az.e, 4);
        RequestOptions requestOptionsV = V(context, str);
        com.huawei.openalliance.ad.inter.r rVar = new com.huawei.openalliance.ad.inter.r(context, new String[]{strOptString});
        rVar.Code(requestOptionsV);
        rVar.Code((Integer) 3);
        rVar.Code(Z(strOptString2));
        rVar.Code(I(str));
        rVar.Code(new a(context, strOptString, remoteCallResultCallback, this.Code));
        rVar.Code(iOptInt, false);
    }
}
