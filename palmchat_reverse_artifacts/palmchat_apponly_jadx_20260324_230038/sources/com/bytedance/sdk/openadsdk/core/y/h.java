package com.bytedance.sdk.openadsdk.core.y;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.my.fx.fx.nr;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class h {
    public static final nr.u nr(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        return new nr.u(nrVar);
    }

    public static com.bytedance.sdk.openadsdk.my.fx.fx.nr u(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            nr.u uVar = new nr.u();
            uVar.u(jSONObject.optString("mAdId", ""));
            uVar.nr(jSONObject.optString("mCreativeId", ""));
            uVar.fx(jSONObject.optString("mExt", ""));
            uVar.b(jSONObject.optString("mCodeId", ""));
            uVar.a(jSONObject.optString("mUserData"));
            uVar.u(jSONObject.optBoolean("mIsAutoPlay", true));
            int iOptInt = jSONObject.optInt("mImgAcceptedWidth", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK);
            uVar.nr(jSONObject.optInt("mImgAcceptedHeight", MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME));
            uVar.u(iOptInt);
            double dOptDouble = jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
            double dOptDouble2 = jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
            uVar.nr(Double.valueOf(dOptDouble).floatValue());
            uVar.u(Double.valueOf(dOptDouble2).floatValue());
            uVar.nr(jSONObject.optBoolean("mSupportDeepLink", true));
            uVar.fx(jSONObject.optInt("mAdCount", 1));
            uVar.pn(jSONObject.optString("mMediaExtra", ""));
            uVar.iz(jSONObject.optString("mUserID", ""));
            uVar.b(jSONObject.optInt("mOrientation", 2));
            uVar.pn(jSONObject.optInt("mNativeAdType"));
            uVar.u(jp.t(jSONObject.optString("mExternalABVid", "")));
            uVar.iz(jSONObject.optInt("mAdLoadSeq", 0));
            uVar.x(jSONObject.optString("mPrimeRit", ""));
            uVar.n(jSONObject.optString("mBidAdm"));
            uVar.n(jSONObject.optInt("mRewardAmount", 0));
            uVar.jk(jSONObject.optString("mRewardName", ""));
            return uVar.u();
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mAdId", nrVar.u());
            jSONObject.put("mCreativeId", nrVar.nr());
            jSONObject.put("mExt", nrVar.fx());
            jSONObject.put("mCodeId", str);
            jSONObject.put("mUserData", nrVar.c());
            jSONObject.put("mIsAutoPlay", nrVar.pn());
            jSONObject.put("mImgAcceptedWidth", nrVar.iz());
            jSONObject.put("mImgAcceptedHeight", nrVar.x());
            jSONObject.put("mExpressViewAcceptedWidth", nrVar.n());
            jSONObject.put("mExpressViewAcceptedHeight", nrVar.a());
            jSONObject.put("mSupportDeepLink", nrVar.jk());
            jSONObject.put("mSupportRenderControl", nrVar.t());
            if (com.bytedance.sdk.openadsdk.core.d.fx >= 5900) {
                jSONObject.put("mSupportIconStyle", nrVar.z());
            }
            jSONObject.put("mAdCount", nrVar.l());
            jSONObject.put("mMediaExtra", nrVar.mv());
            jSONObject.put("mUserID", nrVar.s());
            jSONObject.put("mOrientation", nrVar.k());
            jSONObject.put("mNativeAdType", nrVar.my());
            jSONObject.put("mExternalABVid", jp.u(nrVar.o()));
            jSONObject.put("mAdLoadSeq", nrVar.sx());
            jSONObject.put("mPrimeRit", nrVar.bg());
            jSONObject.put("mBidAdm", nrVar.dw());
            jSONObject.put("mRewardAmount", nrVar.kj());
            jSONObject.put("mRewardName", nrVar.qq());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        return u(nrVar, nrVar.b());
    }

    public static com.bytedance.sdk.openadsdk.my.fx.fx.nr u(int i, String str, float f, float f2) {
        return u().b(str).x(i).nr(f2).u(f).u();
    }

    public static com.bytedance.sdk.openadsdk.my.fx.fx.nr u(int i) {
        return u().x(i).u();
    }

    public static com.bytedance.sdk.openadsdk.my.fx.fx.nr u(int i, PluginValueSet pluginValueSet) {
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar = new com.bytedance.sdk.openadsdk.my.fx.fx.nr(pluginValueSet != null ? pluginValueSet.sparseArray() : new SparseArray<>());
        nr.u uVar = new nr.u(nrVar);
        float fN = nrVar.n();
        float fA = nrVar.a();
        if (fN <= 0.0f) {
            fN = y.b(com.bytedance.sdk.openadsdk.core.dw.getContext(), nrVar.iz());
            fA = y.b(com.bytedance.sdk.openadsdk.core.dw.getContext(), nrVar.x());
        }
        if (fN > 0.0f || fA > 0.0f) {
            int iB = (int) (((double) y.b(com.bytedance.sdk.openadsdk.core.dw.getContext(), y.pn(com.bytedance.sdk.openadsdk.core.dw.getContext()))) * 1.3d);
            int iB2 = (int) (((double) y.b(com.bytedance.sdk.openadsdk.core.dw.getContext(), y.b(com.bytedance.sdk.openadsdk.core.dw.getContext()))) * 1.3d);
            int iMax = Math.max(iB, iB2);
            int iMin = Math.min(iB, iB2);
            if (fN > fA) {
                if (iB2 > 0) {
                    float f = iMax;
                    if (fN > f) {
                        fA = iMin;
                        fN = f;
                    }
                }
            } else if (iB > 0) {
                float f2 = iMax;
                if (fA > f2) {
                    fN = iMin;
                    fA = f2;
                }
            }
        }
        uVar.u(fN).nr(fA);
        return new com.bytedance.sdk.openadsdk.core.kj.fx(nr(uVar.u()).x(i).u());
    }

    private static final nr.u u() {
        return new nr.u().fx(1).nr(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME).u(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK).nr(true).iz("defaultUser").b(2).u(true);
    }

    public static boolean u(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject.has(str)) {
            return jSONObject.optBoolean(str, z);
        }
        return ((Boolean) com.bytedance.sdk.openadsdk.core.dw.nr().u(str, Boolean.valueOf(z))).booleanValue();
    }

    public static long u(JSONObject jSONObject, String str, long j) {
        if (jSONObject.has(str)) {
            return jSONObject.optLong(str, j);
        }
        return ((Long) com.bytedance.sdk.openadsdk.core.dw.nr().u(str, Long.valueOf(j))).longValue();
    }

    public static int u(JSONObject jSONObject, String str, int i) {
        if (jSONObject.has(str)) {
            return jSONObject.optInt(str, i);
        }
        return ((Integer) com.bytedance.sdk.openadsdk.core.dw.nr().u(str, Integer.valueOf(i))).intValue();
    }
}
