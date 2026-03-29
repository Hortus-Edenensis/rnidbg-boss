package com.bytedance.sdk.openadsdk.core.l.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bq;
import com.bytedance.sdk.openadsdk.core.y.wq;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qiniu.android.collect.ReportItem;
import com.ss.android.download.api.constant.BaseConstants;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends com.bytedance.sdk.component.jk.a {
        private boolean b;
        private bc fx;
        private com.bytedance.sdk.openadsdk.core.l.fx.nr.nr nr;
        private Function<SparseArray<Object>, Object> pn;
        private n u;

        private u(n nVar, boolean z) {
            JSONObject jSONObjectB;
            JSONObject jSONObjectPn;
            bc bcVar;
            super("LogTask");
            this.u = nVar;
            this.b = z;
            this.pn = com.bytedance.sdk.openadsdk.core.n.o().y();
            n nVar2 = this.u;
            if (nVar2 == null || nVar2.b() == null || (jSONObjectB = this.u.b()) == null) {
                return;
            }
            String strOptString = jSONObjectB.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(strOptString).optJSONObject(com.bytedance.sdk.openadsdk.core.l.u.jk.EXTRA_DOWN_INFO_KEY);
                com.bytedance.sdk.openadsdk.core.l.fx.nr.nr nrVarU = com.bytedance.sdk.openadsdk.core.l.fx.nr.nr.u(jSONObjectOptJSONObject);
                this.nr = nrVarU;
                if (nrVarU == null) {
                    return;
                }
                nrVarU.u(nVar.nr());
                this.nr.nr(this.u.fx());
                this.fx = this.nr.u;
                if (d.fx < 4400 || (jSONObjectPn = nVar.pn()) == null || (bcVar = this.fx) == null || u(jSONObjectPn, bcVar.tq())) {
                    return;
                }
                this.fx.q(jSONObjectPn.toString());
                this.fx.c(String.valueOf(jSONObjectPn.optLong("creative_id")));
                JSONObject jSONObjectEt = this.fx.et();
                jSONObjectOptJSONObject.put("material_meta", jSONObjectEt);
                com.bytedance.sdk.openadsdk.core.l.fx.nr.nr nrVarU2 = com.bytedance.sdk.openadsdk.core.l.fx.nr.nr.u(jSONObjectOptJSONObject);
                if (nrVarU2 == null) {
                    return;
                }
                this.nr = nrVarU2;
                nrVarU2.nr(nVar.fx());
                this.u = n.u().u(nVar.nr()).nr(nVar.fx()).u(jSONObjectEt).nr(jSONObjectB);
                this.fx = this.nr.u;
            } catch (Exception unused) {
            }
        }

        private Context getContext() {
            return dw.getContext();
        }

        public static u u(n nVar, boolean z) {
            return new u(nVar, z);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                n nVar = this.u;
                if (nVar == null) {
                    return;
                }
                String strNr = nVar.nr();
                com.bytedance.sdk.openadsdk.core.l.fx.nr.nr nrVar = this.nr;
                if (nrVar != null && !TextUtils.isEmpty(nrVar.nr)) {
                    strNr = this.nr.nr;
                }
                if (this.pn != null) {
                    Object objApply = this.pn.apply(com.bytedance.sdk.openadsdk.my.b.u().u(2).u(Boolean.class).u(0, new wq().u("tagIntercept", strNr).u("label", this.u.fx()).u("meta", this.fx.et().toString())).nr());
                    if (objApply != null && ((Boolean) objApply).booleanValue()) {
                        return;
                    }
                }
                if (this.nr != null && this.fx != null && !TextUtils.isEmpty(this.u.nr()) && !TextUtils.isEmpty(this.u.fx())) {
                    JSONObject jSONObjectU = a.u(this.u.b());
                    String str = this.nr.nr;
                    if (!u(this.u.nr()) || "click".equals(this.u.fx())) {
                        return;
                    }
                    jSONObjectU.remove(com.bytedance.sdk.openadsdk.core.l.u.jk.EXTRA_DOWN_INFO_KEY);
                    jSONObjectU.putOpt("obm_convert", bq.fx(this.fx));
                    com.bytedance.sdk.openadsdk.core.s.b.nr(this.fx, str, this.u.fx(), jSONObjectU);
                }
            } catch (Throwable unused) {
            }
        }

        private boolean u(JSONObject jSONObject, JSONObject jSONObject2) {
            if (jSONObject != null && jSONObject2 != null) {
                long jOptLong = jSONObject.optLong(MediationConstant.EXTRA_ADID);
                long jOptLong2 = jSONObject2.optLong(MediationConstant.EXTRA_ADID);
                String strOptString = jSONObject.optString(ReportItem.RequestKeyRequestId);
                String strOptString2 = jSONObject2.optString(ReportItem.RequestKeyRequestId);
                long jOptLong3 = jSONObject.optLong("creative_id");
                long jOptLong4 = jSONObject2.optLong("creative_id");
                String strOptString3 = jSONObject.optString("origin_req_id");
                String strOptString4 = jSONObject2.optString("origin_req_id");
                if (jOptLong != 0 && jOptLong == jOptLong2 && jOptLong3 != 0 && jOptLong3 == jOptLong4) {
                    return (TextUtils.isEmpty(strOptString3) || TextUtils.isEmpty(strOptString4)) ? TextUtils.equals(strOptString, strOptString2) : TextUtils.equals(strOptString3, strOptString4);
                }
            }
            return false;
        }

        private boolean u(String str) {
            return this.b || a.fx(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean fx(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "embeded_ad".equals(str) || WifiNestConst.NestTypeConst.NEST_DRAW_AD.equals(str) || "draw_ad_landingpage".equals(str) || "banner_ad".equals(str) || "banner_call".equals(str) || "banner_ad_landingpage".equals(str) || "feed_call".equals(str) || "embeded_ad_landingpage".equals(str) || "interaction".equals(str) || "interaction_call".equals(str) || "interaction_landingpage".equals(str) || "slide_banner_ad".equals(str) || WifiNestConst.NestTypeConst.NEST_SPLASH_AD.equals(str) || "fullscreen_interstitial_ad".equals(str) || "splash_ad_landingpage".equals(str) || "rewarded_video".equals(str) || "rewarded_video_landingpage".equals(str) || "openad_sdk_download_complete_tag".equals(str) || "fullscreen_interstitial_ad_landingpage".equals(str) || "stream".equals(str);
    }

    public static JSONObject u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        try {
            return new JSONObject(strOptString);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static boolean u(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(com.bytedance.sdk.openadsdk.core.l.u.jk.EXTRA_DOWN_INFO_KEY);
    }
}
