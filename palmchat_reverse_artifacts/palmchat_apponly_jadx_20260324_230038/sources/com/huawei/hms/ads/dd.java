package com.huawei.hms.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class dd {
    private static final String Code = "EngineAnalysisUtil";
    private Context V;

    public dd(Context context) {
        this.V = context;
    }

    public void Code(Bundle bundle, AdContentData adContentData) {
        String str;
        if (bundle == null || adContentData == null) {
            str = "param or ad is null";
        } else {
            ej ejVar = new ej(bundle);
            String strW = ejVar.w(bq.f.K);
            if (TextUtils.isEmpty(strW)) {
                str = "analysisType is null";
            } else {
                String strW2 = ejVar.w(bq.f.T);
                boolean zCode = ejVar.Code(bq.f.W, false);
                boolean zCode2 = ejVar.Code(bq.f.Y, false);
                if (!TextUtils.isEmpty(strW2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(strW2);
                        jSONObject.put(bq.f.K, strW);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(bq.f.T, jSONObject.toString());
                        jSONObject2.put(bq.f.X, zCode);
                        jSONObject2.put(bq.f.aa, zCode2);
                        jSONObject2.put("content_id", adContentData.a());
                        jSONObject2.put("slotid", adContentData.L());
                        if (adContentData.aF() == 3) {
                            jSONObject2.put("templateId", adContentData.aE());
                        } else {
                            jSONObject2.put("templateId", adContentData.E());
                        }
                        jSONObject2.put("apiVer", adContentData.aF());
                        jSONObject2.put("unique_id", adContentData.aa());
                        fh.V(Code, "start report analysis, analysisType: %s, uniqueId: %s", strW, adContentData.aa());
                        db.Code(this.V, jSONObject2.toString());
                        return;
                    } catch (JSONException unused) {
                        fh.V(Code, "onAnalysis json error, type: %s", strW);
                        return;
                    }
                }
                str = "analysisInfo is empty";
            }
        }
        fh.V(Code, str);
    }
}
