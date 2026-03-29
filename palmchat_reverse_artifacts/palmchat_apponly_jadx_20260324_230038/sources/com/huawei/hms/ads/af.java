package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class af extends ah {
    private static final String Z = "JsbAdClick";

    public af() {
        super(ak.C);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fh.Code(Z, "start");
        final JSONObject jSONObject = new JSONObject(str);
        final int iOptInt = jSONObject.optInt("adType", -1);
        Code(context, str, true, new ad() { // from class: com.huawei.hms.ads.af.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                int i;
                if (adContentData != null) {
                    MetaData metaDataS = adContentData.S();
                    if (metaDataS != null) {
                        HashMap map = new HashMap();
                        map.put("appId", metaDataS.b());
                        map.put(kk.V, metaDataS.a());
                        if (iOptInt == 3 && adContentData.t() != null) {
                            VideoInfo videoInfo = new VideoInfo(adContentData.t());
                            map.put(com.huawei.openalliance.ad.constant.be.m, adContentData.D());
                            map.put(com.huawei.openalliance.ad.constant.be.p, String.valueOf(adContentData.J()));
                            map.put(com.huawei.openalliance.ad.constant.be.s, adContentData.H() ? ex.Code : ex.V);
                            map.put(com.huawei.openalliance.ad.constant.be.r, videoInfo.a());
                        }
                        kr krVarCode = ks.Code(af.this.Code(context), adContentData, map);
                        if (!krVarCode.Code()) {
                            fh.Code(af.Z, "fail open land page");
                            i = 3003;
                        } else if (af.this.Code(adContentData)) {
                            MaterialClickInfo materialClickInfoC = af.this.C(str);
                            Integer numB = af.this.B(str);
                            boolean z = materialClickInfoC.D() == null && materialClickInfoC.L() == null;
                            if (numB != null && 13 == numB.intValue() && z) {
                                materialClickInfoC.B((Integer) 1);
                            }
                            adContentData.Code(af.this.S(jSONObject.optString(com.huawei.openalliance.ad.constant.az.aW)));
                            af.this.Code(krVarCode, context, adContentData, materialClickInfoC, numB);
                            i = 1000;
                        } else {
                            fh.V(af.Z, "ad is not in whitelist");
                            i = 3004;
                        }
                    } else {
                        i = 1000;
                    }
                } else {
                    fh.Code(af.Z, "ad not exist");
                    i = 3002;
                }
                ah.Code(remoteCallResultCallback, af.this.Code, i, null, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(kr krVar, Context context, AdContentData adContentData, MaterialClickInfo materialClickInfo, Integer num) {
        Integer numValueOf = Integer.valueOf(num == null ? 12 : num.intValue());
        fh.V(Z, "source = %s", numValueOf);
        jk.Code(context, adContentData, (String) null, 0, 0, krVar.Z(), numValueOf.intValue(), com.huawei.openalliance.ad.utils.b.Code(context), materialClickInfo);
    }
}
