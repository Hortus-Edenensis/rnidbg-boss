package defpackage;

import android.app.Activity;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.NestSdkVersion;
import com.wifi.ad.core.config.WifiConstConfig;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdHelperReward;
import com.wifi.ad.core.listener.RewardListener;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.adsdk.utils.LxAdConst;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class cw3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f16936a = "NestSdkRewardManager";
    public static RewardListener b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements RewardListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f16937a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public a(String str, int i, String str2, String str3) {
            this.f16937a = str;
            this.b = i;
            this.c = str2;
            this.d = str3;
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdClicked(NestAdData nestAdData) {
            LogUtil.d(cw3.f16936a, "onAdClicked");
            if (cw3.b != null) {
                cw3.b.onAdClicked(nestAdData);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("requestId", vq3.j(nestAdData));
                jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
                jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_ADMODE, nestAdData.getAdMode());
                jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(c.b()));
                jSONObject.put(EventParams.KEY_CT_SDK_FROM, nestAdData.getSdkFrom());
                jSONObject.put("appid", nestAdData.getAppId());
                jSONObject.put("srcid", nestAdData.getAdCode());
                jSONObject.put(EventParams.KEY_PARAM_NEST_SID, nestAdData.getNestSid());
                jSONObject.put("scene", 4);
                jSONObject.put("taichi", this.c);
                jSONObject.put("exp_group", this.d);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.d("lx_client_nestad_click", null, jSONObject.toString());
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdClose(NestAdData nestAdData) {
            LogUtil.d(cw3.f16936a, "onAdClose");
            if (cw3.b != null) {
                cw3.b.onAdClose(nestAdData);
            }
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdExpose(NestAdData nestAdData) {
            LogUtil.d(cw3.f16936a, "onAdExposed");
            if (cw3.b != null) {
                cw3.b.onAdExpose(nestAdData);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("requestId", vq3.j(nestAdData));
                jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
                jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_ADMODE, nestAdData.getAdMode());
                jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(c.b()));
                jSONObject.put(EventParams.KEY_CT_SDK_FROM, nestAdData.getSdkFrom());
                jSONObject.put("appid", nestAdData.getAppId());
                jSONObject.put("srcid", nestAdData.getAdCode());
                jSONObject.put(EventParams.KEY_PARAM_NEST_SID, nestAdData.getNestSid());
                jSONObject.put("scene", 4);
                jSONObject.put("taichi", this.c);
                jSONObject.put("exp_group", this.d);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.d("lx_client_nestad_show", null, jSONObject.toString());
        }

        @Override // com.wifi.ad.core.listener.RewardListener, com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
            LogUtil.d(cw3.f16936a, "onAdFailed code = " + str + ", errorMsg = " + str2);
            if (cw3.b != null) {
                cw3.b.onAdFailed(str, str2);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", str);
                jSONObject.put("msg", str2);
                jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
                jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(c.b()));
                jSONObject.put("scene", this.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.d("lx_client_nestad_get_fail", null, jSONObject.toString());
        }

        @Override // com.wifi.ad.core.listener.RewardListener, com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            LogUtil.d(cw3.f16936a, "onAdLoaded");
            if (cw3.b != null) {
                cw3.b.onAdLoaded(str, list);
            }
            if (list == null || list.size() <= 0) {
                LogUtil.d(cw3.f16936a, "onAdLoaded size = 0");
                return;
            }
            LogUtil.d(cw3.f16936a, "onAdLoaded size = " + list.size());
            NestAdData nestAdData = list.get(0);
            if (nestAdData == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("requestId", this.f16937a);
                jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
                jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_ADMODE, nestAdData.getAdMode());
                jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(c.b()));
                jSONObject.put(EventParams.KEY_CT_SDK_FROM, nestAdData.getSdkFrom());
                jSONObject.put("appid", nestAdData.getAppId());
                jSONObject.put("srcid", nestAdData.getAdCode());
                jSONObject.put(EventParams.KEY_PARAM_NEST_SID, nestAdData.getNestSid());
                jSONObject.put("scene", this.b);
                jSONObject.put("taichi", this.c);
                jSONObject.put("exp_group", this.d);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.d("lx_client_nestad_get", null, jSONObject.toString());
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdRewardVerify(NestAdData nestAdData) {
            LogUtil.d(cw3.f16936a, "onAdRewardVerify");
            if (cw3.b != null) {
                cw3.b.onAdRewardVerify(nestAdData);
            }
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdShow(NestAdData nestAdData) {
            LogUtil.d(cw3.f16936a, "onAdShow");
            if (cw3.b != null) {
                cw3.b.onAdShow(nestAdData);
            }
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdVideoCached(NestAdData nestAdData) {
            LogUtil.d(cw3.f16936a, "onAdVideoCached");
            if (cw3.b != null) {
                cw3.b.onAdVideoCached(nestAdData);
            }
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdVideoComplete(NestAdData nestAdData) {
            LogUtil.d(cw3.f16936a, "onAdVideoComplete");
            if (cw3.b != null) {
                cw3.b.onAdVideoComplete(nestAdData);
            }
        }

        @Override // com.wifi.ad.core.listener.RewardListener, com.wifi.ad.core.listener.BaseListener
        public void onStart() {
            LogUtil.d(cw3.f16936a, "onStart");
            if (cw3.b != null) {
                cw3.b.onStart();
            }
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onVideoPreloadFailed(NestAdData nestAdData) {
            LogUtil.d(cw3.f16936a, "onVideoPreloadFailed");
        }
    }

    public static void c(Activity activity, AdHelperReward adHelperReward, String str, int i, String str2, String str3, RewardListener rewardListener) {
        if (adHelperReward == null) {
            LogUtil.d(f16936a + " logad", "adHelperReward null");
            return;
        }
        b = rewardListener;
        String strValueOf = String.valueOf(ir5.b());
        HashMap map = new HashMap();
        map.put("requestId", strValueOf);
        map.put("taiChiKey", str2);
        map.put("exp_group", str3);
        adHelperReward.getRewardAd(activity, new AdParams.Builder().setExt(map).setFullStrategyJson(str).build(), new a(strValueOf, i, str2, str3));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", strValueOf);
            jSONObject.put("taichi", str2);
            jSONObject.put("exp_group", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("lx_client_nestad_req", null, jSONObject.toString());
    }

    public static void d() {
        b = null;
        if (b6.o) {
            SPCacheManager sPCacheManager = SPCacheManager.INSTANCE;
            String str = WifiConstConfig.LX_APPID;
            sPCacheManager.clearCacheAd(8);
        }
    }

    public static boolean e(Activity activity, NestAdData nestAdData, RewardListener rewardListener) {
        if (activity == null || activity.isFinishing()) {
            LogUtil.d(f16936a, "showAd activity is destroyed");
            return false;
        }
        if (nestAdData == null) {
            LogUtil.d(f16936a, "showAd nestAdData=null");
            return false;
        }
        AdHelperReward adHelperRewardCreateRewardAd = WifiNestAd.INSTANCE.createRewardAd();
        if (adHelperRewardCreateRewardAd == null) {
            LogUtil.d(f16936a, "showAd adHelperReward=null");
            return false;
        }
        b = rewardListener;
        adHelperRewardCreateRewardAd.showRewardAd(activity, nestAdData);
        return true;
    }
}
