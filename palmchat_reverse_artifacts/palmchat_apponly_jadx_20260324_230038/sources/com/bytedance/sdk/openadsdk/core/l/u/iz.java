package com.bytedance.sdk.openadsdk.core.l.u;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bq;
import com.bytedance.sdk.openadsdk.core.y.wq;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qiniu.android.collect.ReportItem;
import com.ss.android.download.api.constant.BaseConstants;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    private static final String TAG = "pl_LibEventLogger";

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends com.bytedance.sdk.component.jk.a {
        private Function<SparseArray<Object>, Object> mBridge;
        private boolean mCheckTag;
        private com.bytedance.sdk.openadsdk.core.l.fx.nr.nr mEventExtra;
        private TTDownloadEventModel mEventModel;
        private bc mMeta;

        private u(TTDownloadEventModel tTDownloadEventModel, boolean z) {
            JSONObject extJson;
            JSONObject materialMeta;
            bc bcVar;
            super("LogTask");
            this.mEventModel = tTDownloadEventModel;
            this.mCheckTag = z;
            this.mBridge = com.bytedance.sdk.openadsdk.core.n.o().y();
            TTDownloadEventModel tTDownloadEventModel2 = this.mEventModel;
            if (tTDownloadEventModel2 == null || tTDownloadEventModel2.getExtJson() == null || (extJson = this.mEventModel.getExtJson()) == null) {
                return;
            }
            String strOptString = extJson.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(strOptString).optJSONObject(jk.EXTRA_DOWN_INFO_KEY);
                com.bytedance.sdk.openadsdk.core.l.fx.nr.nr nrVarU = com.bytedance.sdk.openadsdk.core.l.fx.nr.nr.u(jSONObjectOptJSONObject);
                this.mEventExtra = nrVarU;
                if (nrVarU == null) {
                    return;
                }
                nrVarU.u(tTDownloadEventModel.getTag());
                this.mEventExtra.nr(this.mEventModel.getLabel());
                this.mMeta = this.mEventExtra.u;
                if (d.fx < 4400 || (materialMeta = tTDownloadEventModel.getMaterialMeta()) == null || (bcVar = this.mMeta) == null || equalExt(materialMeta, bcVar.tq())) {
                    return;
                }
                this.mMeta.q(materialMeta.toString());
                this.mMeta.c(String.valueOf(materialMeta.optLong("creative_id")));
                JSONObject jSONObjectEt = this.mMeta.et();
                jSONObjectOptJSONObject.put("material_meta", jSONObjectEt);
                com.bytedance.sdk.openadsdk.core.l.fx.nr.nr nrVarU2 = com.bytedance.sdk.openadsdk.core.l.fx.nr.nr.u(jSONObjectOptJSONObject);
                if (nrVarU2 == null) {
                    return;
                }
                this.mEventExtra = nrVarU2;
                nrVarU2.nr(tTDownloadEventModel.getLabel());
                this.mEventModel = TTDownloadEventModel.builder().setTag(tTDownloadEventModel.getTag()).setLabel(tTDownloadEventModel.getLabel()).setMaterialMeta(jSONObjectEt).setExtJson(extJson);
                this.mMeta = this.mEventExtra.u;
            } catch (Exception unused) {
            }
        }

        public static u build(TTDownloadEventModel tTDownloadEventModel, boolean z) {
            return new u(tTDownloadEventModel, z);
        }

        private boolean checkTag(String str) {
            return this.mCheckTag || iz.checkTag(str);
        }

        private boolean equalExt(JSONObject jSONObject, JSONObject jSONObject2) {
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

        private Context getContext() {
            return dw.getContext();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TTDownloadEventModel tTDownloadEventModel = this.mEventModel;
                if (tTDownloadEventModel == null) {
                    return;
                }
                String tag = tTDownloadEventModel.getTag();
                this.mEventModel.getLabel();
                com.bytedance.sdk.openadsdk.core.l.fx.nr.nr nrVar = this.mEventExtra;
                if (nrVar != null && !TextUtils.isEmpty(nrVar.nr)) {
                    tag = this.mEventExtra.nr;
                }
                if (this.mBridge != null) {
                    Object objApply = this.mBridge.apply(com.bytedance.sdk.openadsdk.my.b.u().u(2).u(Boolean.class).u(0, new wq().u("tagIntercept", tag).u("label", this.mEventModel.getLabel()).u("meta", this.mMeta.et().toString())).nr());
                    if (objApply != null && ((Boolean) objApply).booleanValue()) {
                        return;
                    }
                }
                if (this.mEventExtra != null && this.mMeta != null && !TextUtils.isEmpty(this.mEventModel.getTag()) && !TextUtils.isEmpty(this.mEventModel.getLabel())) {
                    JSONObject libAdExtraData = iz.getLibAdExtraData(this.mEventModel.getExtJson());
                    String str = this.mEventExtra.nr;
                    if (!checkTag(this.mEventModel.getTag()) || "click".equals(this.mEventModel.getLabel())) {
                        return;
                    }
                    libAdExtraData.remove(jk.EXTRA_DOWN_INFO_KEY);
                    libAdExtraData.putOpt("obm_convert", bq.fx(this.mMeta));
                    com.bytedance.sdk.openadsdk.core.s.b.nr(this.mMeta, str, this.mEventModel.getLabel(), libAdExtraData);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkTag(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "embeded_ad".equals(str) || WifiNestConst.NestTypeConst.NEST_DRAW_AD.equals(str) || "draw_ad_landingpage".equals(str) || "banner_ad".equals(str) || "banner_call".equals(str) || "banner_ad_landingpage".equals(str) || "feed_call".equals(str) || "embeded_ad_landingpage".equals(str) || "interaction".equals(str) || "interaction_call".equals(str) || "interaction_landingpage".equals(str) || "slide_banner_ad".equals(str) || WifiNestConst.NestTypeConst.NEST_SPLASH_AD.equals(str) || "fullscreen_interstitial_ad".equals(str) || "splash_ad_landingpage".equals(str) || "rewarded_video".equals(str) || "rewarded_video_landingpage".equals(str) || "openad_sdk_download_complete_tag".equals(str) || "fullscreen_interstitial_ad_landingpage".equals(str) || "stream".equals(str);
    }

    public static JSONObject getLibAdExtraData(JSONObject jSONObject) {
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

    public static boolean isOpenSdkEvent(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(jk.EXTRA_DOWN_INFO_KEY);
    }
}
