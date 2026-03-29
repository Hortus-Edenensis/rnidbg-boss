package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.inner.data.H5Ad;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.inter.listeners.e;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class er extends ag {

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements com.huawei.openalliance.ad.inter.listeners.n {
        private int B;
        private String Code;
        private String I;
        private Context V;
        private RemoteCallResultCallback<String> Z;

        public a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback, String str2, int i) {
            this.Code = str;
            this.V = context;
            this.Z = remoteCallResultCallback;
            this.I = str2;
            this.B = i;
        }

        private ArrayList<FeedbackInfo> Code(com.huawei.openalliance.ad.inter.data.g gVar) {
            if (!com.huawei.openalliance.ad.utils.ag.Code(gVar.t()) || com.huawei.openalliance.ad.utils.ag.Code(gVar.L()) || com.huawei.openalliance.ad.utils.ag.Code(gVar.a()) || gVar.L().size() != gVar.a().size()) {
                return null;
            }
            ArrayList<FeedbackInfo> arrayList = new ArrayList<>();
            for (int i = 0; i < gVar.L().size(); i++) {
                FeedbackInfo feedbackInfo = new FeedbackInfo();
                feedbackInfo.Code(gVar.L().get(i));
                feedbackInfo.Code(com.huawei.openalliance.ad.utils.bc.Code(gVar.a().get(i), -1L));
                feedbackInfo.Code(1);
                arrayList.add(feedbackInfo);
            }
            return arrayList;
        }

        private <T> void I(List<T> list) {
            if (!com.huawei.openalliance.ad.utils.ag.Code(list)) {
                ah.Code(this.Z, this.I, 1000, list, true);
            } else {
                fh.V("JsbReqNativeAd", " ads list is empty.");
                ah.Code(this.Z, this.I, 1005, null, true);
            }
        }

        private void V(List<com.huawei.openalliance.ad.inter.data.g> list) {
            ArrayList arrayList = new ArrayList();
            Code(list, arrayList);
            I(arrayList);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.n
        public void Code(int i) {
            ah.Code(this.Z, this.I, bx.Code(i), null, true);
        }

        private void Code(List<com.huawei.openalliance.ad.inter.data.g> list) {
            ArrayList arrayList = new ArrayList();
            Code(list, arrayList);
            I(arrayList);
        }

        private <T> void Code(List<com.huawei.openalliance.ad.inter.data.g> list, List<T> list2) {
            if (com.huawei.openalliance.ad.utils.ag.Code(list)) {
                return;
            }
            for (com.huawei.openalliance.ad.inter.data.g gVar : list) {
                if (gVar != null && gVar.q() != null) {
                    int i = this.B;
                    if (i == 3) {
                        AdContentData adContentDataQ = gVar.q();
                        adContentDataQ.L(adContentDataQ.aC());
                        if (!com.huawei.openalliance.ad.utils.ag.Code(Code(gVar))) {
                            adContentDataQ.L(Code(gVar));
                        }
                        adContentDataQ.a(adContentDataQ.aQ());
                        list2.add(gVar.q());
                    } else if (i == 2) {
                        list2.add(new H5Ad(gVar.q()));
                    }
                }
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.n
        public void Code(Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map) {
            if (com.huawei.openalliance.ad.utils.al.Code(map)) {
                fh.Code("JsbReqNativeAd", " ads map is empty.");
                ah.Code(this.Z, this.I, 1005, null, true);
                return;
            }
            List<com.huawei.openalliance.ad.inter.data.g> list = map.get(this.Code);
            int i = this.B;
            if (i == 2) {
                Code(list);
            } else {
                if (i != 3) {
                    return;
                }
                V(list);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements e {
        private String Code;
        private RemoteCallResultCallback<String> V;

        public b(RemoteCallResultCallback<String> remoteCallResultCallback, String str) {
            this.V = remoteCallResultCallback;
            this.Code = str;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.e
        public void Code(List<String> list) {
            ah.Code(this.V, this.Code, 1000, new JsbCallBackData(com.huawei.openalliance.ad.utils.ad.V(list), false, ai.Code));
        }
    }

    public er() {
        super(ak.V);
    }

    private List<Integer> Code(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                int iOptInt = jSONArray.optInt(i, -111111);
                if (iOptInt != -111111) {
                    arrayList.add(Integer.valueOf(iOptInt));
                }
            }
        }
        return arrayList;
    }

    private String D(String str) {
        HashMap map = new HashMap();
        Map map2 = (Map) com.huawei.openalliance.ad.utils.ad.V(str, Map.class, new Class[0]);
        if (map2 != null && map2.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map2.entrySet()) {
                if (entry != null) {
                    arrayList.add(new ImpEX((String) entry.getKey(), com.huawei.openalliance.ad.utils.bc.S((String) entry.getValue())));
                }
            }
            if (arrayList.size() > 0) {
                map.put("contentBundle", arrayList);
            }
        }
        if (map.size() > 0) {
            return com.huawei.openalliance.ad.utils.ad.V(map);
        }
        return null;
    }

    private List<String> V(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String strOptString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(strOptString)) {
                    arrayList.add(strOptString);
                }
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.ads.ag
    public void Code(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("slotId");
        String strOptString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.az.W);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(com.huawei.openalliance.ad.constant.az.X);
        String strOptString3 = jSONObject.optString(com.huawei.openalliance.ad.constant.az.aR);
        int iOptInt = jSONObject.optInt(com.huawei.openalliance.ad.constant.az.aQ, 2);
        int iOptInt2 = jSONObject.optInt("adType", 3);
        int iOptInt3 = jSONObject.optInt(com.huawei.openalliance.ad.constant.az.b, -111111);
        int iOptInt4 = jSONObject.optInt(com.huawei.openalliance.ad.constant.az.c, -111111);
        int iOptInt5 = jSONObject.optInt(com.huawei.openalliance.ad.constant.az.d, -111111);
        int iOptInt6 = jSONObject.optInt(com.huawei.openalliance.ad.constant.az.e, 4);
        int iOptInt7 = jSONObject.optInt(com.huawei.openalliance.ad.constant.az.g, -111111);
        int iOptInt8 = jSONObject.optInt("maxCount", 0);
        List<String> listV = V(jSONObject.optJSONArray(com.huawei.openalliance.ad.constant.az.f));
        boolean zOptBoolean = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.az.aJ, true);
        boolean zOptBoolean2 = jSONObject.optBoolean("directCacheVideo", false);
        boolean zOptBoolean3 = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.az.aK, false);
        RequestOptions requestOptionsCode = com.huawei.hms.ads.utils.c.Code(V(context, str));
        com.huawei.openalliance.ad.inter.n nVar = new com.huawei.openalliance.ad.inter.n(context, new String[]{strOptString}, iOptInt2, listV);
        if (iOptInt7 != -111111) {
            nVar.Z(Integer.valueOf(iOptInt7));
        }
        if (iOptInt3 != -111111) {
            nVar.Code(Integer.valueOf(iOptInt3));
        }
        if (iOptInt4 != -111111) {
            nVar.V(Integer.valueOf(iOptInt4));
        }
        if (iOptInt5 != -111111) {
            nVar.I(Integer.valueOf(iOptInt5));
        }
        if (iOptInt8 > 0) {
            nVar.V(iOptInt8);
        }
        nVar.Code(requestOptionsCode);
        nVar.Code(D(strOptString2));
        nVar.Z(Z(strOptString2));
        nVar.Code(Code(jSONArrayOptJSONArray));
        nVar.Code(zOptBoolean);
        nVar.V(zOptBoolean2);
        nVar.Code(new b(remoteCallResultCallback, this.Code));
        nVar.Code(new a(context, strOptString, remoteCallResultCallback, this.Code, iOptInt));
        nVar.B((Integer) 3);
        nVar.Code(I(str));
        nVar.Z(zOptBoolean3);
        nVar.C(strOptString3);
        nVar.Code(iOptInt6, false);
    }
}
