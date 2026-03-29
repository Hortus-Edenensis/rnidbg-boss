package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.huawei.hms.ads.ContentClassification;
import com.huawei.openalliance.ad.constant.az;
import com.lantern.auth.server.WkParams;
import com.wifi.WkInitManager;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.WxMiniProgramListener;
import com.wifi.ad.core.callback.AdRequestCallBack;
import com.wifi.ad.core.callback.CsjInitCallBack;
import com.wifi.ad.core.callback.LXReqHttpCallBack;
import com.wifi.ad.core.callback.LXRespHttpCallBack;
import com.wifi.ad.core.callback.RealLocationCallBack;
import com.wifi.ad.core.compliance.AdDownViVoConfig;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.SDKConfig;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.reporter.AbstractReporter;
import com.wifi.ad.core.spstrategy.SPMdaLogUtil;
import com.wifi.ad.core.spstrategy.SPPriceEventManager;
import com.wifi.ad.core.spstrategy.SPTaiChiManager;
import com.wifi.ad.core.spstrategy.data.AllStrategiesResponse;
import com.wifi.ad.core.spstrategy.data.Response;
import com.wifi.ad.core.spstrategy.data.SdkRequest;
import com.wifi.ad.core.utils.Async;
import com.wifi.adsdk.entity.LxAdBaseView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.conversations.threadsnew.SeeMeManager;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.MdidSdkConfigHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class tu3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f21071a = new AtomicBoolean(false);
    public static int b = 27;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            kt3.a();
            zv3.l();
            uv3.n();
            rl0.h().d().getDynamicConfig(DynamicConfig.Type.USERDETAIL_ADSTRATEGY_CONFIG);
            rl0.h().d().getDynamicConfig(DynamicConfig.Type.USERDETAIL_ADTYPE_CONFIG);
            dc1.a();
            DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEW_FRIEND_ADSTRATEGY_CONFIG);
            DynamicItem dynamicConfig2 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEW_FRIEND_ADTYPE_CONFIG);
            zt4.y().k(dynamicConfig == null ? null : dynamicConfig.getExtra(), dynamicConfig2 == null ? null : dynamicConfig2.getExtra(), false);
            DynamicItem dynamicConfig3 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEW_FRIEND_NEARBY_ADSTRATEGY_CONFIG);
            DynamicItem dynamicConfig4 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEW_FRIEND_NEARBY_ADTYPE_CONFIG);
            du3.y().k(dynamicConfig3 == null ? null : dynamicConfig3.getExtra(), dynamicConfig4 == null ? null : dynamicConfig4.getExtra(), false);
            DynamicItem dynamicConfig5 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.USERINFO_ADSTRATEGY_CONFIG);
            DynamicItem dynamicConfig6 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.USERINFO_ADTYPE_CONFIG);
            db1.e(dynamicConfig5 == null ? null : dynamicConfig5.getExtra(), dynamicConfig6 == null ? null : dynamicConfig6.getExtra());
            eb1.e(dynamicConfig5 == null ? null : dynamicConfig5.getExtra(), dynamicConfig6 == null ? null : dynamicConfig6.getExtra());
            DynamicItem dynamicConfig7 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.USERDETAIL_FEED_ADTYPE_CONFIG);
            if (dynamicConfig7 != null && dynamicConfig7.isEnable()) {
                p66.c(dynamicConfig7.getExtra());
            }
            DynamicItem dynamicConfig8 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.USERDETAIL_FEED_ADTYPE_CONFIGV2);
            if (dynamicConfig8 != null && dynamicConfig8.isEnable()) {
                p66.d(dynamicConfig8.getExtra());
            }
            DynamicItem dynamicConfig9 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEARBY_REWARD_ADTYPE);
            ju3.k(dynamicConfig9 == null ? null : dynamicConfig9.getExtra());
            DynamicItem dynamicConfig10 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.POP_AD_VIP);
            a92.c(dynamicConfig10 == null ? null : dynamicConfig10.getExtra());
            p93.l();
            DynamicItem dynamicConfig11 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.INCOME_TASK_CONFIG);
            js2.n(dynamicConfig11 == null ? null : dynamicConfig11.getExtra());
            DynamicItem dynamicConfig12 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.MINE_PROFIT);
            is2.a(dynamicConfig12 != null ? dynamicConfig12.getExtra() : null);
            DynamicItem dynamicConfig13 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.SQUARE_NEARBY_ADTYPE_CONFIG);
            if (dynamicConfig13 != null && dynamicConfig13.isEnable() && dynamicConfig13.getExtra() != null) {
                wh5.b0(dynamicConfig13.getExtra());
            }
            DynamicItem dynamicConfig14 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.SQUARE_NEWFRIEND_ADTYPE_CONFIG);
            if (dynamicConfig14 != null && dynamicConfig14.isEnable() && dynamicConfig14.getExtra() != null) {
                wh5.c0(dynamicConfig14.getExtra());
            }
            DynamicItem dynamicConfig15 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ADCLEARCONFIG);
            if (dynamicConfig15 != null && dynamicConfig15.getExtra() != null) {
                b6.c(dynamicConfig15.getExtra());
            }
            DynamicItem dynamicConfig16 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.AD_DISCOUNT_INFO_SWITCH);
            if (dynamicConfig16 == null || !dynamicConfig16.isEnable() || dynamicConfig16.getExtra() == null) {
                return;
            }
            f6.a(dynamicConfig16.getExtra());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends LXReqHttpCallBack {
        @Override // com.wifi.ad.core.callback.LXReqHttpCallBack
        public void startRequest(SdkRequest sdkRequest, LXRespHttpCallBack lXRespHttpCallBack) {
            if (sdkRequest != null) {
                int i = sdkRequest.valuetype;
                if (i == 4) {
                    tu3.C(sdkRequest, lXRespHttpCallBack);
                } else if (i == 3) {
                    tu3.D(sdkRequest, lXRespHttpCallBack);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements WxMiniProgramListener {
        @Override // com.wifi.ad.core.WxMiniProgramListener
        public boolean onLaunchWechatMinProgram(String str, String str2) {
            return so6.a().d(str, str2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends RealLocationCallBack {
        @Override // com.wifi.ad.core.callback.RealLocationCallBack
        public String getLatitude() {
            if (com.zenmen.palmchat.location.d.g().h() == null) {
                return "0.0";
            }
            return com.zenmen.palmchat.location.d.g().h().getLatitude() + "";
        }

        @Override // com.wifi.ad.core.callback.RealLocationCallBack
        public String getLongitude() {
            if (com.zenmen.palmchat.location.d.g().h() == null) {
                return "0.0";
            }
            return com.zenmen.palmchat.location.d.g().h().getLongitude() + "";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends AbstractReporter {
        public f(Context context) {
            super(context);
        }

        @Override // com.wifi.ad.core.reporter.AbstractReporter
        public void onEvent(String str, String str2) {
            if (i6.a(str)) {
                String strE = tu3.e(str, str2);
                LogUtil.d("NestAdSdkManager", "onEvent() eventId = " + str + " json = " + strE);
                zn6.d(str, null, strE);
                tu3.j(str, strE);
            }
        }

        @Override // com.wifi.ad.core.reporter.AbstractReporter
        public void onThirdEvent(String str, String str2) {
            if (i6.a(str)) {
                LogUtil.d("NestAdSdkManager", "onThirdEvent() eventId = " + str + " json = " + str2);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("onThirdEvent", str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                zn6.d(str, null, jSONObject.toString());
                tu3.j(str, str2);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends AdRequestCallBack {
        @Override // com.wifi.ad.core.callback.AdRequestCallBack
        public Object addVideoAdView(String str, ViewGroup viewGroup, Object obj) {
            if (!(obj instanceof LxAdBaseView) || TextUtils.isEmpty(str) || viewGroup == null) {
                return null;
            }
            return wu3.e(AppContext.getContext()).a(str, viewGroup, (LxAdBaseView) obj);
        }

        @Override // com.wifi.ad.core.callback.AdRequestCallBack
        public void changeVoiceStatus(Object obj, boolean z) {
            if (obj instanceof StyledPlayerView) {
                wu3.e(AppContext.getContext()).b(z, (StyledPlayerView) obj);
            }
        }

        @Override // com.wifi.ad.core.callback.AdRequestCallBack
        public void checkVideoResumeOrPause(boolean z, Object obj) {
            if (obj instanceof StyledPlayerView) {
                wu3.e(AppContext.getContext()).c((StyledPlayerView) obj, z);
            }
        }

        @Override // com.wifi.ad.core.callback.AdRequestCallBack
        public void deleteDownApp(String str, String str2) {
            av3.c(str, str2);
        }

        @Override // com.wifi.ad.core.callback.AdRequestCallBack
        public void destroyVideo(@NonNull Object obj) {
            if (obj instanceof StyledPlayerView) {
                wu3.e(AppContext.getContext()).d((StyledPlayerView) obj);
            }
        }

        @Override // com.wifi.ad.core.callback.AdRequestCallBack
        public int getNativeStyleView(int i) {
            if (n6.a()) {
                int iB = n6.b(i);
                int i2 = n6.c;
                if (iB == i2) {
                    return i2;
                }
            }
            return n6.b;
        }

        @Override // com.wifi.ad.core.callback.AdRequestCallBack
        public long getVideoCurPosition(Object obj) {
            if (obj instanceof StyledPlayerView) {
                return wu3.e(AppContext.getContext()).f((StyledPlayerView) obj);
            }
            return 0L;
        }

        @Override // com.wifi.ad.core.callback.AdRequestCallBack
        public boolean hasDownPkg(String str) {
            return av3.e(str);
        }

        @Override // com.wifi.ad.core.callback.AdRequestCallBack
        public boolean isAppBackGround() {
            return AppContext.getContext().isBackground();
        }

        @Override // com.wifi.ad.core.callback.AdRequestCallBack
        public boolean isShowComplianceInfo(String str, int i) {
            return n6.c(str, i);
        }

        @Override // com.wifi.ad.core.callback.AdRequestCallBack
        public void onAdRequest() {
            tu3.z();
            v5.l();
        }

        @Override // com.wifi.ad.core.callback.AdRequestCallBack
        public void restartVideo(Object obj) {
            if (obj instanceof StyledPlayerView) {
                wu3.e(AppContext.getContext()).g((StyledPlayerView) obj);
            }
        }

        @Override // com.wifi.ad.core.callback.AdRequestCallBack
        public void resumeDlAd(String str, String str2) {
            av3.f(str2);
        }

        @Override // com.wifi.ad.core.callback.AdRequestCallBack
        public boolean showBlurImg(String str, ImageView imageView) {
            nv3.b(str, imageView);
            return false;
        }

        @Override // com.wifi.ad.core.callback.AdRequestCallBack
        public void startDlAd(String str, String str2, String str3, JSONObject jSONObject) {
            av3.g(str, str2, str3, jSONObject);
        }

        @Override // com.wifi.ad.core.callback.AdRequestCallBack
        public void stopDlAd(String str, String str2) {
            av3.h(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LXRespHttpCallBack f21072a;
        public final /* synthetic */ SdkRequest b;

        public h(LXRespHttpCallBack lXRespHttpCallBack, SdkRequest sdkRequest) {
            this.f21072a = lXRespHttpCallBack;
            this.b = sdkRequest;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            LogUtil.d("", "MLxReq startLxAllAdConfig Exception error " + exc);
            LXRespHttpCallBack lXRespHttpCallBack = this.f21072a;
            if (lXRespHttpCallBack != null) {
                lXRespHttpCallBack.onError(exc.toString());
            }
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.d("", "MLxReq startLxAllAdConfig oriData " + jSONObject);
            if (jSONObject == null) {
                onFail(new Exception("data is null"));
                return;
            }
            if (yy2Var == null) {
                onFail(new Exception("response is null"));
                return;
            }
            if (yy2Var.b != 0) {
                onFail(new Exception("resultCode is error"));
                return;
            }
            AllStrategiesResponse allStrategiesResponse = (AllStrategiesResponse) az2.a(jSONObject.toString(), AllStrategiesResponse.class);
            if (allStrategiesResponse == null || this.f21072a == null) {
                return;
            }
            LogUtil.d("", "MLxReq startLxAllAdConfig success ");
            LXRespHttpCallBack lXRespHttpCallBack = this.f21072a;
            SdkRequest sdkRequest = this.b;
            lXRespHttpCallBack.onSuccess(allStrategiesResponse, sdkRequest.scene, sdkRequest.app.appid);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LXRespHttpCallBack f21073a;
        public final /* synthetic */ SdkRequest b;

        public i(LXRespHttpCallBack lXRespHttpCallBack, SdkRequest sdkRequest) {
            this.f21073a = lXRespHttpCallBack;
            this.b = sdkRequest;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            LogUtil.d("", "MLxReq startLxOneAdConfig Exception error " + exc);
            LXRespHttpCallBack lXRespHttpCallBack = this.f21073a;
            if (lXRespHttpCallBack != null) {
                lXRespHttpCallBack.onError(exc.toString());
            }
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.d("", "MLxReq startLxOneAdConfig oriData " + jSONObject);
            if (jSONObject == null) {
                onFail(new Exception("data is null"));
                return;
            }
            if (yy2Var == null) {
                onFail(new Exception("response is null"));
                return;
            }
            if (yy2Var.b != 0) {
                onFail(new Exception("resultCode is error"));
                return;
            }
            Response response = (Response) az2.a(jSONObject.toString(), Response.class);
            if (response == null || this.f21073a == null) {
                return;
            }
            LogUtil.d("", "MLxReq startLxOneAdConfig success ");
            LXRespHttpCallBack lXRespHttpCallBack = this.f21073a;
            SdkRequest sdkRequest = this.b;
            lXRespHttpCallBack.onSuccess(response, sdkRequest.scene, sdkRequest.app.appid);
        }
    }

    public static void A(boolean z) {
        WifiNestAd.INSTANCE.setPersonalizedAd(z);
    }

    public static void B() {
        SPPriceEventManager.INSTANCE.setLX_45488_TAI(WkAdxAdConfigMg.DSP_NAME_BAIDU);
    }

    public static void C(SdkRequest sdkRequest, LXRespHttpCallBack lXRespHttpCallBack) {
        LogUtil.d("", "MLxReq startLxAllAdConfig ");
        try {
            String strC = az2.c(sdkRequest);
            LogUtil.d("", "MLxReq startLxAllAdConfig result " + strC);
            zw4.j(nl0.c + "/sdkconfig/alladstrategies2?ReqType=androidJson", 1, new JSONObject(strC), new h(lXRespHttpCallBack, sdkRequest), false, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void D(SdkRequest sdkRequest, LXRespHttpCallBack lXRespHttpCallBack) {
        LogUtil.d("", "MLxReq startLxOneAdConfig ");
        try {
            String strC = az2.c(sdkRequest);
            LogUtil.d("", "MLxReq startLxOneAdConfig result " + strC);
            zw4.j(nl0.c + "/sdkconfig/adstrategy2?ReqType=androidJson", 1, new JSONObject(strC), new i(lXRespHttpCallBack, sdkRequest), false, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void E(String str) {
        q(str);
        if (TextUtils.isEmpty(str) || Build.VERSION.SDK_INT > b) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("LX-43178");
            sb.append("_");
            sb.append(WkAdxAdConfigMg.DSP_NAME_BAIDU);
            LogUtil.d("", "initAd updateAdInitConfig taichiKey " + ((Object) sb));
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(sb.toString());
            LogUtil.d("", "initAd updateAdInitConfig resAdConfigObject " + jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject != null) {
                WkInitManager.INSTANCE.initAllConfig(jSONObjectOptJSONObject.toString(), true);
            }
        } catch (Exception unused) {
        }
    }

    public static void F(boolean z) {
        try {
            DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ADSWITCH);
            if (dynamicConfig == null || dynamicConfig.getExtra() == null) {
                return;
            }
            l6.i(z, new JSONObject(dynamicConfig.getExtra()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static String e(String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        try {
            if (WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK.equals(str) && !TextUtils.isEmpty(str2) && (jSONObjectOptJSONObject = (jSONObject = new JSONObject(str2)).optJSONObject("ext")) != null) {
                String oaid = MdidSdkConfigHelper.getInstance().getOAID();
                if (!TextUtils.isEmpty(oaid)) {
                    jSONObjectOptJSONObject.put("oaid", oaid);
                }
                String str3 = ac1.p;
                if (!TextUtils.isEmpty(str3)) {
                    jSONObjectOptJSONObject.put("androidID", str3);
                }
                String str4 = ac1.i;
                if (!TextUtils.isEmpty(str4)) {
                    jSONObjectOptJSONObject.put(WkParams.IMEI, str4);
                }
                return jSONObject.put("ext", jSONObjectOptJSONObject).toString();
            }
        } catch (Exception unused) {
        }
        return str2;
    }

    public static boolean f() {
        try {
            PackageInfo packageInfo = com.zenmen.palmchat.c.b().getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            if (packageInfo != null) {
                String str = packageInfo.versionName;
                LogUtil.d("", "HWAD checkAllHWInit verName " + str);
                if (!TextUtils.isEmpty(str) && k("4.0.0.300", str) != 1) {
                    LogUtil.d("", "HWAD checkAllHWInit allow ");
                    return true;
                }
            }
        } catch (Exception e2) {
            LogUtil.d("", "HWAD checkAllHWInit Exception " + e2.toString());
        }
        LogUtil.d("", "HWAD checkAllHWInit not allow ");
        return false;
    }

    public static boolean g() {
        String str = ac1.m;
        boolean z = str == null || str.contains("OPPO");
        boolean zD = py4.d();
        boolean z2 = Build.VERSION.SDK_INT < 29;
        LogUtil.d("", "checkAllOppoInit channelOppo " + z + " deviceOppo " + zD + " buildOppo " + z2);
        if (z && zD && !z2) {
            return true;
        }
        LogUtil.d("", "checkAllOppoInit not allow ");
        return false;
    }

    public static boolean h() {
        if (!dm1.d() || Build.VERSION.SDK_INT > 27) {
            return true;
        }
        LogUtil.d("", "CSJAD checkCsjInit not allow init");
        return false;
    }

    public static void i(Context context) {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.AD_SDK_DELAY_INIT_CONFIG);
        LogUtil.d("", "initAd checkInitAppAd adInitConfig " + dynamicConfig);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            return;
        }
        E(dynamicConfig.getExtra());
        v(dynamicConfig.getExtra());
    }

    public static void j(String str, String str2) {
        try {
            if (!"nest_ad_sdk_shenhe_id".equals(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            LogUtil.d("", "eventShenHeShow checkShenheEventId nest_ad_sdk_shenhe_id paramsJson " + str2);
            HashMap map = new HashMap();
            map.put("values", str2);
            LogUtil.log4ClientError("nest_ad_sdk_shenhe_id", map, null, true);
        } catch (Exception unused) {
        }
    }

    public static int k(String str, String str2) {
        int i2 = 0;
        try {
            String strY = y(str);
            String strY2 = y(str2);
            String[] strArrSplit = strY.split("\\.");
            String[] strArrSplit2 = strY2.split("\\.");
            int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
            int i3 = 0;
            while (i2 < iMax) {
                try {
                    String str3 = i2 < strArrSplit.length ? strArrSplit[i2] : "0";
                    String str4 = i2 < strArrSplit2.length ? strArrSplit2[i2] : "0";
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "0";
                    }
                    i3 = Integer.parseInt(y(str3)) - Integer.parseInt(y(TextUtils.isEmpty(str4) ? "0" : str4));
                    if (i3 != 0) {
                        return i3;
                    }
                    i2++;
                } catch (Exception e2) {
                    e = e2;
                    i2 = i3;
                    e.printStackTrace();
                    return i2;
                }
            }
            return i3;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static void l(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(AppContext.getContext()));
            jSONObject.put("deviceId", ac1.h);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("taichikey", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("resultConfig", str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        zn6.d("ad_sdk_init_result", null, jSONObject.toString());
    }

    public static String m() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ADALL_SDK_CONFIG_JSON);
        LogUtil.d("", "HWAD getAdAllSDKConfig item " + dynamicConfig);
        return (dynamicConfig == null || !dynamicConfig.isEnable()) ? "" : dynamicConfig.getExtra();
    }

    public static String n(String str) {
        return "LX-29267".equals(str) ? WkAdxAdConfigMg.DSP_NAME_BAIDU : "LX-34097".equals(str) ? ContentClassification.AD_CONTENT_CLASSIFICATION_J : "LX-24769".equals(str) ? WkAdxAdConfigMg.DSP_NAME_BAIDU : "LX-29497".equals(str) ? WkAdxAdConfigMg.DSP_NAME_GDT : "LX-31425".equals(str) ? ExifInterface.LONGITUDE_EAST : ("LX-31249".equals(str) || "LX-35416".equals(str)) ? WkAdxAdConfigMg.DSP_NAME_CSJ : ("LX-43408".equals(str) || "LX-37955".equals(str) || "LX-44460".equals(str) || "LX-37924".equals(str) || "LX-39904".equals(str) || "LX-39895".equals(str) || "LX-39896".equals(str)) ? WkAdxAdConfigMg.DSP_NAME_BAIDU : "LX-40038".equals(str) ? WkAdxAdConfigMg.DSP_NAME_CSJ : ("LX-44444".equals(str) || "LX-24115".equals(str) || "LX-28472".equals(str) || "LX-20860".equals(str)) ? WkAdxAdConfigMg.DSP_NAME_BAIDU : "LX-28913".equals(str) ? WkAdxAdConfigMg.DSP_NAME_CSJ : ("LX-20444".equals(str) || "LX-24412".equals(str)) ? WkAdxAdConfigMg.DSP_NAME_BAIDU : "A";
    }

    public static String o() {
        StringBuilder sb = new StringBuilder();
        sb.append("LX-28151");
        if (!"A".equals(jo6.f("LX-29267", WkAdxAdConfigMg.DSP_NAME_BAIDU))) {
            if (!TextUtils.isEmpty(sb) && !sb.toString().endsWith(",")) {
                sb.append(",");
            }
            sb.append("LX-29267");
        }
        if (!"A".equals(jo6.e(SPTaiChiManager.SP_KEY_MATERIAL_CONTROL_TAICHI))) {
            if (!TextUtils.isEmpty(sb) && !sb.toString().endsWith(",")) {
                sb.append(",");
            }
            sb.append(SPTaiChiManager.SP_KEY_MATERIAL_CONTROL_TAICHI);
        }
        if (!TextUtils.isEmpty(sb) && !sb.toString().endsWith(",")) {
            sb.append(",");
        }
        sb.append("LX-34227");
        if (!"A".equals(jo6.e("LX-44356"))) {
            if (!TextUtils.isEmpty(sb) && !sb.toString().endsWith(",")) {
                sb.append(",");
            }
            sb.append("LX-44356");
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String p() {
        String str;
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.ADTAICHI);
        if (dynamicConfig != null) {
            try {
                String strOptString = dynamicConfig.getExtra() != null ? new JSONObject(dynamicConfig.getExtra()).optString("adtai") : "LX-29276,LX-29278,LX-29279,LX-29280,LX-29277,LX-29281,LX-29285,LX-29284,LX-22375,LX-30042,LX-31900,LX-31974,LX-29616,LX-29497,LX-31425,LX-29360,LX-29361,LX-32386,LX-33785,LX-33784,LX-30418,LX-34097,LX-34098,LX-35416,LX-35417,LX-28472,LX-28913,LX-38802,LX-37924,LX-31249,LX-37955,LX-39904,LX-39895,LX-39896,LX-40038,LX-42300,LX-43408,LX-44460,LX-44445,LX-44444,LX-32436,LX-56379,LX-58414,LX-58597,LX-58421,LX-60751";
                if (TextUtils.isEmpty(strOptString)) {
                    str = "";
                } else {
                    String[] strArrSplit = strOptString.replace(" ", "").split(",");
                    str = "";
                    for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                        try {
                            String str2 = strArrSplit[i2];
                            String str3 = str2 + "_" + (lo6.a(str2) ? jo6.f(str2, n(str2)) : ap3.a().n(str2, "A"));
                            str = i2 == 0 ? str3 : str + "," + str3;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
                str = "";
                e.printStackTrace();
                LogUtil.d("", "taichis result " + str);
                return str;
            }
        }
        LogUtil.d("", "taichis result " + str);
        return str;
    }

    public static void q(String str) {
        LogUtil.d("", "initAd  getInitAppSdkVersion res " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            b = new JSONObject(str).optInt("initAppSdkVersion");
            LogUtil.d("", "initAd  getInitAppSdkVersion initAppSdkVersion " + b);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x009e, code lost:
    
        r1 = r5.optJSONObject(com.qq.gdt.action.ActionUtils.PAYMENT_AMOUNT).toString();
        r3 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String r() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.SDK_PRIVILEGE_CONTROLLER);
        LogUtil.d("", "sdkPrivilegeController sdkPrivilegeControllerItem " + dynamicConfig);
        String string = "{\"csj\":{\"isCanUseLocation\":true,\"isCanUsePhoneState\":true,\"isCanUseWifiState\":false,\"isCanUseWriteExternal\":true,\"isCanUseInstalledPackages\":false,\"isCanUseAndroidId\":true,\"isCanUsePermissionRecordAudio\":true,\"isCanUseOaid\":true,\"isCanUseMacAddress\":false},\"gdt\":{\"isCanUseMacAddress\":false,\"isCanUseAndroidId\":true,\"isCanUseDeviceId\":true,\"isCanUseInstalledPackages\":false},\"ks\":{\"isCanUseLocation\":true,\"isCanUsePhoneState\":true,\"isCanUseOaid\":true,\"isCanUseMacAddress\":false,\"isCanUseWifiState\":true,\"isCanUseStoragePermission\":true,\"isCanUseInstalledPackages\":false,\"isCanUseAndroidId\":true},\"bd\":{\"isCanUseDeviceId\":true,\"isCanUseLocation\":true,\"isCanUseStoragePermission\":true,\"isCanUseInstalledPackages\":false},\"oppo\":{\"isCanUseLocation\":true,\"isCanUsePhoneState\":false,\"isCanUseAndroidId\":true,\"isCanUseWifiState\":true,\"isCanUseWriteExternal\":true,\"isCanUseInstalledPackages\":false,\"isCanUseMacAddress\":false},\"huawei\":{\"isCanUseLocation\":true},\"beizi\":{\"isCanUseLocation\":true,\"isCanUseWifiState\":true,\"isCanUsePhoneState\":false,\"isCanUseOaid\":true,\"isCanUseGaid\":true},\"qumeng\":{\"isCanUsePhoneState\":true,\"isCanUseInstalledPackages\":false,\"isCanUseAndroidId\":true,\"isCanUseLocation\":true,\"isCanUseMacAddress\":false,\"isCanUseOaid\":true}}";
        String str = "def";
        if (dynamicConfig != null && !TextUtils.isEmpty(dynamicConfig.getExtra()) && !TextUtils.isEmpty(ac1.m)) {
            try {
                JSONArray jSONArrayOptJSONArray = new JSONObject(dynamicConfig.getExtra()).optJSONArray("allconfig");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 < jSONArrayOptJSONArray.length()) {
                            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                            String strOptString = jSONObjectOptJSONObject.optString("key");
                            LogUtil.d("", "sdkPrivilegeController for i " + i2 + " key " + strOptString);
                            if (ac1.m.equals(strOptString) || "all".equals(strOptString)) {
                                try {
                                    break;
                                } catch (Exception e2) {
                                    e = e2;
                                    str = strOptString;
                                    LogUtil.d("", "sdkPrivilegeController Exception " + e.toString());
                                }
                            } else {
                                i2++;
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkPrivilegeValue", string);
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(AppContext.getContext()));
            jSONObject.put("deviceId", ac1.h);
            zn6.d("sdkPrivilegeController_result", null, jSONObject.toString());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        LogUtil.d("", "sdkPrivilegeController curKey " + str + " sdkPrivilegeValue " + string);
        return string;
    }

    public static void s(Context context) {
        if (f21071a.get()) {
            return;
        }
        t(context);
        u(context);
    }

    public static void t(Context context) {
        B();
        WifiNestAd.INSTANCE.setSwitch58414(l6.a());
        i(context);
        SDKConfig sDKConfigBuild = new SDKConfig.Builder().setAlias(SDKAlias.CSJ).setAppId("5108233").setAllowInit(h()).build();
        SDKConfig sDKConfigBuild2 = new SDKConfig.Builder().setAlias(SDKAlias.BEIZI).setAppId("22291").build();
        SDKConfig sDKConfigBuild3 = new SDKConfig.Builder().setAlias(SDKAlias.KS).setAppId("559300002").build();
        SDKConfig sDKConfigBuild4 = new SDKConfig.Builder().setAlias(SDKAlias.GDT).setAppId("1111288618").build();
        SDKConfig sDKConfigBuild5 = new SDKConfig.Builder().setAlias(SDKAlias.WIFI).setSensitiveTaker(new w6(context)).build();
        SDKConfig sDKConfigBuild6 = new SDKConfig.Builder().setAlias(SDKAlias.LXAD).setAppId("1272705205").build();
        SDKConfig sDKConfigBuild7 = new SDKConfig.Builder().setAlias(SDKAlias.OPPO).setAllowInit(g()).setAppId("3443210").build();
        SDKConfig sDKConfigBuild8 = new SDKConfig.Builder().setAlias(SDKAlias.HUAWEI).setAllowInit(f()).setAppId("hwappid").build();
        SDKConfig sDKConfigBuild9 = new SDKConfig.Builder().setAlias(SDKAlias.FEISUO).setAppId("LIANXIN").build();
        np3.d();
        uv3.u();
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.SDK_ANDROID_AD_REPORT_RATIO);
        if (dynamicConfig != null && !TextUtils.isEmpty(dynamicConfig.getExtra())) {
            i6.b(dynamicConfig.getExtra());
        }
        DynamicItem dynamicConfig2 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.SDK_ANDROID_AD_MDA_LOG);
        if (dynamicConfig2 != null && !TextUtils.isEmpty(dynamicConfig2.getExtra())) {
            try {
                SPMdaLogUtil.INSTANCE.setConfigMdaSwitch(new JSONObject(dynamicConfig2.getExtra()).optInt("debug_report", 1));
            } catch (Exception unused) {
            }
        }
        DynamicItem dynamicConfig3 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.SDK_PRICE_EVENT_SCENE_CONFIG);
        if (dynamicConfig3 != null) {
            String extra = dynamicConfig3.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                try {
                    int iOptInt = new JSONObject(extra).optInt("eventRandom");
                    LogUtil.d("", "sdkPriceEventItem randNum " + iOptInt);
                    if (iOptInt > 0) {
                        SPPriceEventManager.INSTANCE.setRandomInt_num(iOptInt);
                    }
                } catch (Exception unused2) {
                }
            }
            SPPriceEventManager.INSTANCE.initConfig(extra, v4.e(com.zenmen.palmchat.c.b()), ac1.h);
        }
        DynamicItem dynamicConfig4 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.SDK_VIVO_COM_CONFIG);
        LogUtil.d("", "AdDownViVoConfig sdkVivoConfigItem " + dynamicConfig4);
        if (dynamicConfig4 != null) {
            LogUtil.d("", "AdDownViVoConfig sdkVivoConfigItem.getExtra() " + dynamicConfig4.getExtra());
            AdDownViVoConfig.initAllConfig(dynamicConfig4.getExtra());
        } else {
            AdDownViVoConfig.initAllConfig(null);
        }
        DynamicItem dynamicConfig5 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NATIVE_COM_CONFIG);
        LogUtil.d("", "DDT sdkNativeConfigItem sdkNativeConfigItem " + dynamicConfig5);
        if (dynamicConfig5 != null) {
            LogUtil.d("", "DDT sdkNativeConfigItem.getExtra() " + dynamicConfig5.getExtra());
            m6.b(dynamicConfig5.getExtra());
        }
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        wifiNestAd.setSwitch77583(b6.d());
        if ("A".equals(jo6.f("LX-46021", WkAdxAdConfigMg.DSP_NAME_BAIDU))) {
            wifiNestAd.setHeguiTai(false);
        } else {
            wifiNestAd.setHeguiTai(true);
        }
        if ("A".equals(t66.h().e("LX-70647", "A"))) {
            wifiNestAd.setSwitch70647(false);
        } else {
            wifiNestAd.setSwitch70647(true);
        }
        if ("A".equals(t66.h().e("LX-58140", "A"))) {
            wifiNestAd.setNewRequestUrl(false);
        } else {
            wifiNestAd.setNewRequestUrl(true);
        }
        wifiNestAd.setMLxRequestCallBack(new b());
        wifiNestAd.setWxMiniProgramListener(new c());
        wifiNestAd.setLxadtoken("lzegQNuuwBxOutcqzfRwalHGARjvczyE");
        wifiNestAd.setFeisuotoken("1yhm9oyi680d03iad4j1f9r510a65dqv");
        wifiNestAd.initSdkPrivilege(r());
        wifiNestAd.addAdConfigs(sDKConfigBuild3, sDKConfigBuild, sDKConfigBuild4, sDKConfigBuild5, sDKConfigBuild7, sDKConfigBuild8, sDKConfigBuild2, sDKConfigBuild9, sDKConfigBuild6).setEventReporter(new f(context)).setCsjInitCallBack(new e()).setLoactionCallBack(new d()).setDebug(LogUtil.isLogEnable(), !nl0.c().equals("release")).setAdConfigTais(p()).setTaiChiKeys(o()).setPersonalizedAd(w()).setAdSDKConfig(m()).setSwitchAd315(true).setSupplier(new yu3(context)).init(context);
        if (x()) {
            wifiNestAd.updatePersonAd(w());
        }
        f21071a.set(true);
        wifiNestAd.setAdRequestCallBack(new g());
        qv1.h.set(true);
        z64.v();
        vu3.h();
        w50.D();
        vq3.q();
        mp3.b();
        dw3.A();
        ns5.b();
        gp3.d();
        DynamicItem dynamicConfig6 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.AI_CHAT_UIDS_CONFIG);
        if (dynamicConfig6 != null) {
            v8.B(dynamicConfig6.getExtra());
        }
        o30.n();
        DynamicItem dynamicConfig7 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.AI_CHAT_PEOPLE_CONFIG);
        if (dynamicConfig7 != null) {
            v8.A(dynamicConfig7.getExtra());
        }
        DynamicItem dynamicConfig8 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.SQUARE_ADSTRATEGY_CONFIG);
        DynamicItem dynamicConfig9 = rl0.h().d().getDynamicConfig(DynamicConfig.Type.SQUARE_ADTYPE_CONFIG);
        wh5.E(dynamicConfig8 == null ? null : dynamicConfig8.getExtra(), dynamicConfig9 == null ? null : dynamicConfig9.getExtra());
        wv3.b();
        SeeMeManager.j();
        fo5.e();
        dw1.K();
        ew1.G();
        MdidSdkConfigHelper.getInstance().initConfig();
        MdidSdkConfigHelper.getInstance().requestPemFileUrl();
    }

    public static void u(Context context) {
        Async.INSTANCE.getCache().execute(new a());
    }

    public static void v(String str) {
        String str2;
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        try {
            WkInitManager wkInitManager = WkInitManager.INSTANCE;
            wkInitManager.setInitSdkTimeTaiValue(t66.h().e("LX-53929", "A"));
            if (!wkInitManager.allowSdkTimeDelay() || (str2 = ac1.m) == null) {
                return;
            }
            String str3 = "{\"sdkConfig\":[{\"sdk\":\"csj\",\"initTime\":0},{\"sdk\":\"gdt\",\"initTime\":0},{\"sdk\":\"ks\",\"initTime\":0},{\"sdk\":\"bd\",\"initTime\":0},{\"sdk\":\"huawei\",\"initTime\":-1},{\"sdk\":\"oppo\",\"initTime\":-1},{\"sdk\":\"beizi\",\"initTime\":-1},{\"sdk\":\"qumeng\",\"initTime\":-1},{\"sdk\":\"feisuo\",\"initTime\":0}]}";
            if ("HWEX2_B6C90A2E7847865C".equals(str2)) {
                str3 = "{\"sdkConfig\":[{\"sdk\":\"csj\",\"initTime\":0},{\"sdk\":\"gdt\",\"initTime\":0},{\"sdk\":\"ks\",\"initTime\":0},{\"sdk\":\"bd\",\"initTime\":0},{\"sdk\":\"huawei\",\"initTime\":0},{\"sdk\":\"oppo\",\"initTime\":-1},{\"sdk\":\"beizi\",\"initTime\":-1},{\"sdk\":\"qumeng\",\"initTime\":-1},{\"sdk\":\"feisuo\",\"initTime\":0}]}";
            } else if ("OPPO_A56925F58B07B8B6".equals(ac1.m)) {
                str3 = "{\"sdkConfig\":[{\"sdk\":\"csj\",\"initTime\":0},{\"sdk\":\"gdt\",\"initTime\":0},{\"sdk\":\"ks\",\"initTime\":0},{\"sdk\":\"bd\",\"initTime\":0},{\"sdk\":\"huawei\",\"initTime\":-1},{\"sdk\":\"oppo\",\"initTime\":0},{\"sdk\":\"beizi\",\"initTime\":-1},{\"sdk\":\"qumeng\",\"initTime\":-1},{\"sdk\":\"feisuo\",\"initTime\":0}]}";
            }
            if (!TextUtils.isEmpty(str) && (jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("allSdkDelay")) != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                    String strOptString = jSONObjectOptJSONObject.optString("channel");
                    String strOptString2 = jSONObjectOptJSONObject.optString(az.aW);
                    String strOptString3 = jSONObjectOptJSONObject.optString("versionName");
                    String strOptString4 = jSONObjectOptJSONObject.optString("manufacturer");
                    boolean z = true;
                    boolean z2 = ac1.m.equals(strOptString) || "all".equals(strOptString);
                    boolean z3 = (TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(ac1.f) || (!strOptString2.contains(ac1.f) && !strOptString2.contains("all"))) ? false : true;
                    boolean z4 = (TextUtils.isEmpty(strOptString3) || TextUtils.isEmpty(ac1.g) || (!strOptString3.contains(ac1.g) && !strOptString3.contains("all"))) ? false : true;
                    if (TextUtils.isEmpty(strOptString4) || TextUtils.isEmpty(ac1.f1194a) || (!strOptString4.contains(ac1.f1194a) && !strOptString4.contains("all"))) {
                        z = false;
                    }
                    LogUtil.d("", "initSdkDelayConfig channelAllow " + z2 + " versionCodeAllow " + z3 + " versionNameAllow " + z4 + " manufacturerAllow " + z);
                    if (z2 && z3 && z4 && z) {
                        String str4 = "LX-56379_" + t66.h().e("LX-56379", "A");
                        LogUtil.d("", "initSdkDelayConfig key56379:" + str4);
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str4);
                        if (jSONObjectOptJSONObject2 == null) {
                            str4 = "LX-56379_A";
                            LogUtil.d("", "initSdkDelayConfig key56379: dftA LX-56379_A");
                            jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("LX-56379_A");
                        }
                        if (jSONObjectOptJSONObject2 != null && (jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("sdkConfig")) != null && jSONArrayOptJSONArray2.length() > 0) {
                            l(str4, jSONArrayOptJSONArray2.toString());
                            WkInitManager.INSTANCE.initSdkDelayTime(jSONArrayOptJSONArray2);
                            return;
                        }
                    }
                }
            }
            JSONArray jSONArrayOptJSONArray3 = new JSONObject(str3).optJSONArray("sdkConfig");
            l("", jSONArrayOptJSONArray3.toString());
            WkInitManager.INSTANCE.initSdkDelayTime(jSONArrayOptJSONArray3);
        } catch (Exception unused) {
        }
    }

    public static boolean w() {
        return nh4.e().g();
    }

    public static boolean x() {
        return !"A".equals(jo6.c("LX-45094", "A"));
    }

    public static String y(Object obj) {
        return obj == null ? "" : String.valueOf(obj);
    }

    public static void z() {
        try {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.AD;
            long jI = sPUtil.i(scene, "key_ad_request_date_cache_time", 0L);
            int iF = sPUtil.f(scene, "key_ad_request_cache_time", 0);
            long jCurrentTimeMillis = System.currentTimeMillis();
            int i2 = 1;
            if (jI == 0) {
                LogUtil.d("", "saveAdRequestTimes date == 0 ");
            } else {
                if (iv0.a(jCurrentTimeMillis, "yyyy-MM-dd").equals(iv0.a(jI, "yyyy-MM-dd"))) {
                    i2 = 1 + iF;
                    LogUtil.d("", "saveAdRequestTimes 当天 ");
                } else {
                    LogUtil.d("", "saveAdRequestTimes 隔天了 ");
                }
            }
            sPUtil.t(scene, "key_ad_request_date_cache_time", Long.valueOf(jCurrentTimeMillis));
            sPUtil.t(scene, "key_ad_request_cache_time", Integer.valueOf(i2));
            LogUtil.d("", "saveAdRequestTimes adRequestTime " + i2);
        } catch (Exception e2) {
            LogUtil.d("", "saveAdRequestTimes exce " + e2.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends CsjInitCallBack {
        @Override // com.wifi.ad.core.callback.CsjInitCallBack
        public void onInitSuccess() {
        }

        @Override // com.wifi.ad.core.callback.CsjInitCallBack
        public void onInitFail(int i, String str) {
        }
    }
}
