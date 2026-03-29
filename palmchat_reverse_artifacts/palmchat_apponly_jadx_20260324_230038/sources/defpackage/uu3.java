package defpackage;

import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.NestSdkVersion;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.adsdk.utils.LxAdConst;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class uu3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f21291a = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NestAdData f21292a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(NestAdData nestAdData, String str, String str2) {
            this.f21292a = nestAdData;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(1000L);
                LogUtil.d("ValidShow", "NestAdSplashSdkValidShowManager checkCsjAdShow sleep end adShow " + uu3.f21291a);
                if (uu3.f21291a) {
                    uu3.i(this.f21292a, this.b, this.c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NestAdData f21293a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(NestAdData nestAdData, String str, String str2) {
            this.f21293a = nestAdData;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(1000L);
                LogUtil.d("ValidShow", "NestAdSplashSdkValidShowManager checkKsAdShow sleep end adShow " + uu3.f21291a);
                if (uu3.f21291a) {
                    uu3.i(this.f21293a, this.b, this.c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NestAdData f21294a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public c(NestAdData nestAdData, String str, String str2) {
            this.f21294a = nestAdData;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(5000L);
                LogUtil.d("ValidShow", "NestAdSplashSdkValidShowManager checkGdtAdShow sleep end adShow " + uu3.f21291a);
                if (uu3.f21291a) {
                    uu3.i(this.f21294a, this.b, this.c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void c(NestAdData nestAdData, String str, String str2) {
        try {
            if (nestAdData.getAdType() != SDKAlias.CSJ.getType()) {
                if (nestAdData.getAdType() == SDKAlias.GDT.getType()) {
                    LogUtil.d("ValidShow", "NestAdSplashSdkValidShowManager adSkip gdt adShow " + f21291a);
                    if (f21291a) {
                        i(nestAdData, str, str2);
                    }
                } else {
                    nestAdData.getAdType();
                    SDKAlias.KS.getType();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void d(NestAdData nestAdData, String str, String str2) {
        LogUtil.d("ValidShow", "NestAdSplashSdkValidShowManager checkCsjAdShow start adShow " + f21291a);
        new Thread(new a(nestAdData, str, str2)).start();
    }

    public static void e(NestAdData nestAdData, String str, String str2) {
        LogUtil.d("ValidShow", "NestAdSplashSdkValidShowManager checkGdtAdShow start adShow " + f21291a);
        new Thread(new c(nestAdData, str, str2)).start();
    }

    public static void f(NestAdData nestAdData, String str, String str2) {
        LogUtil.d("ValidShow", "NestAdSplashSdkValidShowManager checkKsAdShow start adShow " + f21291a);
        new Thread(new b(nestAdData, str, str2)).start();
    }

    public static void g() {
        f21291a = false;
        LogUtil.d("ValidShow", "NestAdSplashSdkValidShowManager onAdPause adShow false");
    }

    public static void h() {
        f21291a = true;
        LogUtil.d("ValidShow", "NestAdSplashSdkValidShowManager onAdResume adShow true");
    }

    public static void i(NestAdData nestAdData, String str, String str2) {
        if (nestAdData != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("requestId", nestAdData.getRequestId());
                jSONObject.put(EventParams.KEY_PARAM_NETTYPE, hx3.h());
                jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_ADMODE, nestAdData.getAdMode());
                jSONObject.put(EventParams.KEY_PARAM_SDKVER, NestSdkVersion.INSTANCE.getVersion(com.zenmen.palmchat.c.b()));
                jSONObject.put(EventParams.KEY_CT_SDK_FROM, nestAdData.getSdkFrom());
                jSONObject.put("appid", nestAdData.getAppId());
                jSONObject.put("srcid", nestAdData.getAdCode());
                jSONObject.put(EventParams.KEY_PARAM_NEST_SID, nestAdData.getNestSid());
                jSONObject.put("scene", nestAdData.getAdScene());
                jSONObject.put("taichi", str);
                jSONObject.put("exp_group", str2);
                jSONObject.put("dspname", nestAdData.getDspName());
                jSONObject.put("adcost", nestAdData.getAdCost());
                jSONObject.put(EventParams.KEY_ECPM_RATIO, nestAdData.getEcpmRatio());
                jSONObject.put(EventParams.KEY_ECPM_LOW_PRICE, nestAdData.getEcpmLowPrice());
                jSONObject.put(EventParams.KEY_ADREALNAME, nestAdData.getAdRealLevelName());
                jSONObject.put(EventParams.KEY_PRICE_SWITCH, nestAdData.getPriceSwitch());
                jSONObject.put(EventParams.KEY_PRICE_RESPONSE, nestAdData.getPriceResponse());
                jSONObject.put(EventParams.KEY_AD_LEVEL, nestAdData.getAdLevel());
                jSONObject.put(EventParams.KEY_GROUP, nestAdData.getGroupId());
                jSONObject.put("newRequestId", nestAdData.getUseRequestId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            f21291a = false;
            LogUtil.d("ValidShow", "NestAdSplashSdkValidShowManager nest_sdk_ad_ValidShow adShow false:" + jSONObject);
            zn6.d("nest_sdk_ad_ValidShow", null, jSONObject.toString());
        }
    }

    public static void j(NestAdData nestAdData, String str, String str2) {
        if (nestAdData != null) {
            try {
                f21291a = true;
                if (nestAdData.getAdType() == SDKAlias.CSJ.getType()) {
                    d(nestAdData, str, str2);
                } else if (nestAdData.getAdType() == SDKAlias.GDT.getType()) {
                    e(nestAdData, str, str2);
                } else if (nestAdData.getAdType() == SDKAlias.KS.getType()) {
                    f(nestAdData, str, str2);
                }
            } catch (Exception unused) {
            }
        }
    }
}
