package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.activity.ComplianceActivity;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class aq extends ah {
    private static final String B = "anchorViewX";
    private static final String C = "anchorViewY";
    private static final int D = -1;
    private static final String F = "anchorHeight";
    private static final String S = "anchorWidth";
    private static final String Z = "JsbStartComplianceActivity";

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements ad {
        private Context Code;
        private RemoteCallResultCallback<String> I;
        private String V;
        private String Z;

        public a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback, String str2) {
            this.Code = context;
            this.V = str;
            this.I = remoteCallResultCallback;
            this.Z = str2;
        }

        @Override // com.huawei.hms.ads.ad
        public void Code(AdContentData adContentData) {
            if (adContentData == null || com.huawei.openalliance.ad.utils.ag.Code(adContentData.aL())) {
                fh.I(aq.Z, "content is null or compliance is null.");
            }
            try {
                JSONObject jSONObject = new JSONObject(this.V);
                int iOptInt = jSONObject.optInt(aq.B, -1);
                int iOptInt2 = jSONObject.optInt(aq.C, -1);
                if (-1 == iOptInt || -1 == iOptInt2) {
                    fh.I(aq.Z, "invalid anchor loc");
                }
                int iOptInt3 = jSONObject.optInt(aq.S, -1);
                int iOptInt4 = jSONObject.optInt(aq.F, -1);
                if (-1 == iOptInt3 || -1 == iOptInt4) {
                    fh.I(aq.Z, "invalid anchor size");
                }
                int[] iArr = {iOptInt, iOptInt2};
                int[] iArr2 = {iOptInt3, iOptInt4};
                if (fh.Code()) {
                    fh.Code(aq.Z, "parse param complete, anchor loc (%s, %s), anchor size (%s, %s)", Integer.valueOf(iOptInt), Integer.valueOf(iOptInt2), Integer.valueOf(iOptInt3), Integer.valueOf(iOptInt4));
                }
                ComplianceActivity.Code(new b(this.I, this.Z));
                ComplianceActivity.Code(this.Code, iArr, iArr2, adContentData, true);
            } catch (Throwable th) {
                fh.I(aq.Z, "parse param ex: %s", th.getClass().getSimpleName());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements com.huawei.openalliance.ad.activity.b {
        private String Code;
        private RemoteCallResultCallback<String> V;

        public b(RemoteCallResultCallback<String> remoteCallResultCallback, String str) {
            this.V = remoteCallResultCallback;
            this.Code = str;
        }

        @Override // com.huawei.openalliance.ad.activity.b
        public void Code() {
            fh.V(aq.Z, "onActivityShow");
            ah.Code(this.V, this.Code, 1000, 5001, false);
        }

        @Override // com.huawei.openalliance.ad.activity.b
        public void V() {
            fh.V(aq.Z, "onActivityFinish");
            ah.Code(this.V, this.Code, 1000, 5002, false);
            ComplianceActivity.S();
        }
    }

    public aq() {
        super(ak.A);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Code(context, str, true, (ad) new a(context, str, remoteCallResultCallback, this.Code));
        } catch (Throwable th) {
            fh.I(Z, "execute ex: %s", th.getClass().getSimpleName());
        }
    }
}
