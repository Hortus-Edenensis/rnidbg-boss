package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.jsb.inner.data.H5Ad;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.q;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class es extends ag {

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements com.huawei.openalliance.ad.inter.listeners.p {
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

        private List<H5Ad> Code(List<com.huawei.openalliance.ad.inter.data.h> list) {
            AdContentData adContentDataQ;
            ArrayList arrayList = new ArrayList(4);
            if (list != null && list.size() > 0) {
                for (com.huawei.openalliance.ad.inter.data.h hVar : list) {
                    if (hVar != null && (adContentDataQ = hVar.q()) != null) {
                        arrayList.add(new H5Ad(adContentDataQ));
                    }
                }
            }
            return arrayList;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.p
        public void I(int i) {
            ah.Code(this.Z, this.I, bx.Code(i), null, true);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.p
        public void Code(Map<String, List<com.huawei.openalliance.ad.inter.data.h>> map) {
            if (map != null && map.size() > 0) {
                List<H5Ad> listCode = Code(map.get(this.Code));
                if (listCode.size() > 0) {
                    ah.Code(this.Z, this.I, 1000, com.huawei.openalliance.ad.utils.ad.V(listCode), true);
                    return;
                }
            }
            fh.V("JsbReqPlacementAd", " ads map is empty.");
            ah.Code(this.Z, this.I, 1005, null, true);
        }
    }

    public es() {
        super(ak.B);
    }

    @Override // com.huawei.hms.ads.ag
    public void Code(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("slotId");
        String strOptString = jSONObject.optString(com.huawei.openalliance.ad.constant.az.W);
        int iOptInt = jSONObject.optInt(com.huawei.openalliance.ad.constant.az.e, 4);
        int iOptInt2 = jSONObject.optInt("maxCount", 1);
        int iOptInt3 = jSONObject.optInt(com.huawei.openalliance.ad.constant.az.i, 300);
        com.huawei.openalliance.ad.inter.q qVarCode = new q.a(context).Code(false).Code(new String[]{string}).Code(iOptInt).Code(strOptString).Code(V(context, str)).Code((Integer) 3).Code(I(str)).Code();
        if (iOptInt3 > 0) {
            qVarCode.Code(new a(context, string, remoteCallResultCallback, this.Code));
            return;
        }
        String str2 = this.Code;
        if (iOptInt2 > 0) {
            qVarCode.Code(new a(context, string, remoteCallResultCallback, str2), iOptInt3);
        } else {
            qVarCode.Code(new a(context, string, remoteCallResultCallback, str2), iOptInt3, iOptInt2);
        }
    }
}
