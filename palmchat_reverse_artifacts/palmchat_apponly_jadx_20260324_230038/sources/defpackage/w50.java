package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.entity.SensitiveInfo;
import com.wifi.csj.ad.CsjSensitiveCatcher;
import com.wifi.csj.ad.NestCsjProvider;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class w50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f21621a = null;
    public static Boolean b = null;
    public static int c = 1500;
    public static int d = 60;
    public static int e;
    public static final List<e6> f = new ArrayList();
    public static HashMap<e6, Long> g = new HashMap<>();
    public static final AtomicBoolean h = new AtomicBoolean(false);
    public static boolean i = false;
    public static final Set<Integer> j = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: compiled from: SearchBox */
    public class a implements TTAdNative.FeedAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21622a;
        public final /* synthetic */ long b;

        public a(int i, long j) {
            this.f21622a = i;
            this.b = j;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
        public void onError(int i, String str) {
            w50.h.set(false);
            if (this.f21622a >= 0) {
                w50.j.remove(Integer.valueOf(this.f21622a));
            }
            LogUtil.e("ChuanshanjiaSdkManager", "onError msg = " + str + ",codeID = " + i);
            w50.x("lx_client_sdkad_getfail", 0, 0, ir5.b() - this.b, 0, null, 0L, null, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
        public void onFeedAdLoad(List<TTFeedAd> list) {
            w50.h.set(false);
            if (this.f21622a >= 0) {
                w50.j.remove(Integer.valueOf(this.f21622a));
            }
            if (list == null || list.size() == 0) {
                return;
            }
            LogUtil.i("ChuanshanjiaSdkManager", "onFeedAdLoad size = " + list.size());
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                TTFeedAd tTFeedAd = list.get(i2);
                if (tTFeedAd != null) {
                    if (tTFeedAd.getImageMode() == 5 || tTFeedAd.getImageMode() == 3) {
                        e6 e6Var = new e6();
                        e6Var.b = ir5.b() + ((long) i2);
                        e6Var.f17220a = tTFeedAd;
                        w50.C(new Long(0L), e6Var);
                        w50.x("lx_client_sdkad_get", tTFeedAd.getImageMode(), tTFeedAd.getInteractionType(), ir5.b() - this.b, 0, null, e6Var.b, null, 0);
                        i++;
                    } else {
                        LogUtil.d("ChuanshanjiaSdkManager", "onFeedAdLoad, ImageMode is illeagle!! type = " + tTFeedAd.getImageMode());
                    }
                }
            }
            if (i > 0) {
                Intent intent = new Intent();
                intent.setAction(k86.i("ACTION_NOTIFY_RECIEVE_MOMENTS_AD"));
                LocalBroadcastManager.getInstance(com.zenmen.palmchat.c.b()).sendBroadcast(intent);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements TTNativeAd.AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e6 f21623a;
        public String b;

        public b(e6 e6Var, String str) {
            this.f21623a = e6Var;
            this.b = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            w50.w("lx_client_sdkad_click", this.f21623a.f17220a.getImageMode(), this.f21623a.f17220a.getInteractionType(), this.f21623a.b);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            w50.w("lx_client_sdkad_click", this.f21623a.f17220a.getImageMode(), this.f21623a.f17220a.getInteractionType(), this.f21623a.b);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            SensitiveInfo sensitiveInfoCatchCsjExpressNativeAd = CsjSensitiveCatcher.INSTANCE.catchCsjExpressNativeAd(this.f21623a.f17220a, 0);
            k6.b().e("lx_client_sdkad_show").c(this.b).i(this.f21623a.f17220a.getImageMode()).g(this.f21623a.f17220a.getInteractionType()).b(sensitiveInfoCatchCsjExpressNativeAd.getAppName()).j(sensitiveInfoCatchCsjExpressNativeAd.getTitle()).d(sensitiveInfoCatchCsjExpressNativeAd.getDownloadUrl()).a(sensitiveInfoCatchCsjExpressNativeAd.getH5Url()).f(sensitiveInfoCatchCsjExpressNativeAd.getPackageName()).h();
        }
    }

    public static void A(String str, int i2, int i3, long j2, int i4, String str2, long j3, String str3) {
        v(str, i2, i3, j2, 0L, i4, str2, m(), j3, null, 0);
    }

    public static void B(String str, int i2, int i3, long j2, String str2) {
        A(str, i2, i3, 0L, 0, null, j2, str2);
    }

    public static void C(Long l, e6 e6Var) {
        if (g == null) {
            g = new HashMap<>();
        }
        g.put(e6Var, l);
        LogUtil.d("ChuanshanjiaSdkManager", "saveMomentsAdToCache size = " + g.size());
    }

    public static void D() {
        i = true;
    }

    public static void E(String str) {
        LogUtil.d("ChuanshanjiaSdkManager", "updateExpiredConfig extra = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c = jSONObject.getInt("getTime");
            d = jSONObject.getInt("expiredTime");
            e = jSONObject.getInt("reqNum");
        } catch (Exception unused) {
        }
    }

    public static void F() {
        boolean zJ = j();
        boolean zN = n();
        LogUtil.i("ChuanshanjiaSdkManager", "updateEnable  isMomentsEnable " + zJ + ", isPMEnable = " + zN);
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.CHUANSHANJIA_AD;
        sPUtil.t(scene, k86.a("key_csj_moments_enable"), Boolean.valueOf(zJ));
        sPUtil.t(scene, k86.a("key_csj_pm_enable"), Boolean.valueOf(zN));
        f21621a = Boolean.valueOf(zJ);
        b = Boolean.valueOf(zN);
    }

    public static boolean G() {
        String strK = k();
        return WkAdxAdConfigMg.DSP_NAME_CSJ.equalsIgnoreCase(strK) || "D".equalsIgnoreCase(strK);
    }

    public static boolean H() {
        String strK = k();
        return WkAdxAdConfigMg.DSP_NAME_BAIDU.equalsIgnoreCase(strK) || "D".equalsIgnoreCase(strK);
    }

    public static void d(Activity activity) {
        HashMap<e6, Long> map = g;
        if (map != null && map.size() != 0) {
            LogUtil.d("ChuanshanjiaSdkManager", "cleanExpiredMomentsAds before size = " + g.size());
            Iterator<Map.Entry<e6, Long>> it = g.entrySet().iterator();
            while (it.hasNext()) {
                if (p(it.next().getKey())) {
                    it.remove();
                }
            }
            LogUtil.d("ChuanshanjiaSdkManager", "cleanExpiredMomentsAds after size = " + g.size());
        }
        u(activity);
    }

    public static void e() {
        HashMap<e6, Long> map = g;
        if (map != null) {
            f(map.keySet());
            g.clear();
        }
    }

    public static void f(Collection<e6> collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        Iterator<e6> it = collection.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public static int g() {
        return d;
    }

    public static e6 h(Long l) {
        HashMap<e6, Long> map = g;
        e6 e6Var = null;
        if (map == null || map.size() == 0) {
            return null;
        }
        Iterator<e6> it = g.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            e6 next = it.next();
            Long l2 = g.get(next);
            if (l != null && l.longValue() == l2.longValue()) {
                e6Var = next;
                break;
            }
        }
        if (e6Var != null) {
            return e6Var;
        }
        for (e6 e6Var2 : g.keySet()) {
            if (g.get(e6Var2).longValue() == 0) {
                e6Var2.c = ir5.b();
                g.put(e6Var2, l);
                return e6Var2;
            }
        }
        return e6Var;
    }

    public static String i() {
        if ("H".equalsIgnoreCase(jo6.c("LX-24412", WkAdxAdConfigMg.DSP_NAME_BAIDU))) {
            return "945612022";
        }
        String strK = k();
        return WkAdxAdConfigMg.DSP_NAME_BAIDU.equalsIgnoreCase(strK) ? "945612018" : WkAdxAdConfigMg.DSP_NAME_CSJ.equalsIgnoreCase(strK) ? "945612020" : "D".equalsIgnoreCase(strK) ? "945612021" : ExifInterface.LONGITUDE_EAST.equalsIgnoreCase(strK) ? "945612022" : "945556862";
    }

    public static boolean j() {
        String strC = jo6.c("LX-20444", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        if ("A".equals(strC)) {
            return false;
        }
        LogUtil.i("ChuanshanjiaSdkManager", "getMomentsTaichiKey " + strC);
        return true;
    }

    public static String k() {
        String strC = jo6.c("LX-21528", "A");
        LogUtil.i("ChuanshanjiaSdkManager", "getMultiRequestsTaichiKey " + strC);
        return strC;
    }

    public static void l(Context context, String str, int i2, TTAdNative.FeedAdListener feedAdListener) {
        if (context == null || !i) {
            return;
        }
        h.set(true);
        TTAdSdk.getAdManager().createAdNative(context.getApplicationContext()).loadFeedAd(new AdSlot.Builder().setCodeId(str).setSupportDeepLink(true).setAdCount(i2).setImageAcceptedSize(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME).build(), feedAdListener);
        if (str.equals(i())) {
            x("lx_client_sdkad_req", 0, 0, 0L, 0, null, 0L, null, i2);
        } else if (str.equals(m())) {
            z("lx_client_sdkad_req", 0, 0, 0L);
        }
    }

    public static String m() {
        return ExifInterface.LONGITUDE_EAST.equals(jo6.c("LX-24115", WkAdxAdConfigMg.DSP_NAME_BAIDU)) ? "945840809" : (!"A".equalsIgnoreCase(jo6.c("LX-24115", WkAdxAdConfigMg.DSP_NAME_BAIDU)) || "A".equalsIgnoreCase(jo6.c("LX-26836", "A"))) ? "945605066" : WkAdxAdConfigMg.DSP_NAME_BAIDU.equalsIgnoreCase(jo6.c("LX-26836", "A")) ? "946091875" : WkAdxAdConfigMg.DSP_NAME_CSJ.equalsIgnoreCase(jo6.c("LX-26836", "A")) ? "946091876" : "945605066";
    }

    public static boolean n() {
        String strC = jo6.c("LX-20860", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        if ("A".equals(strC)) {
            return false;
        }
        LogUtil.i("ChuanshanjiaSdkManager", "getPMTaichiKey " + strC);
        return true;
    }

    public static int o() {
        HashMap<e6, Long> map = g;
        int i2 = 0;
        if (map != null && map.size() != 0) {
            Iterator<e6> it = g.keySet().iterator();
            while (it.hasNext()) {
                if (it.next().c == 0) {
                    i2++;
                }
            }
        }
        LogUtil.d("ChuanshanjiaSdkManager", "cleanExpiredMomentsAds getUnShowedMomentsAdSize size = " + i2);
        return i2;
    }

    public static boolean p(e6 e6Var) {
        if (e6Var == null) {
            return true;
        }
        return e6Var.c != 0 && ir5.b() - e6Var.c > ((long) (g() * 1000));
    }

    public static boolean q() {
        if (f21621a == null) {
            f21621a = Boolean.valueOf(SPUtil.f14322a.a(SPUtil.SCENE.CHUANSHANJIA_AD, k86.a("key_csj_moments_enable"), false));
        }
        LogUtil.d("ChuanshanjiaSdkManager", "isMomentsEnable = " + f21621a);
        return f21621a.booleanValue();
    }

    public static boolean r() {
        return SPUtil.f14322a.a(SPUtil.SCENE.APP_COMMON, "key_settings_privacy_personalized_ad_new", true);
    }

    public static void s(Context context, int i2) {
        t(context, i2, -1);
    }

    public static void t(Context context, int i2, int i3) {
        if (q()) {
            if (i3 < 0 || !j.contains(Integer.valueOf(i3))) {
                if (i3 >= 0) {
                    j.add(Integer.valueOf(i3));
                }
                l(context, i(), i2, new a(i3, ir5.b()));
            }
        }
    }

    public static void u(Context context) {
        if (context == null || h.get() || 2 <= o()) {
            return;
        }
        int iO = 2 - o();
        LogUtil.d("ChuanshanjiaSdkManager", "preloadMomentsAD count = " + iO);
        if (iO == 2 && e == 1 && H()) {
            s(context, iO);
            return;
        }
        for (int i2 = 0; i2 < iO; i2++) {
            s(context, 1);
        }
    }

    public static void v(String str, int i2, int i3, long j2, long j3, int i4, String str2, String str3, long j4, String str4, int i5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("codeid", str3);
            jSONObject.put(com.umeng.ccg.a.x, NestCsjProvider.SDK_FROM);
            if (i2 != 0) {
                jSONObject.put(EventParams.KEY_PARAM_TEMPLATE, i2);
            }
            if (i3 != 0) {
                jSONObject.put("reaction", i3);
            }
            if (j2 != 0) {
                jSONObject.put("reqTime", j2);
            }
            if (j3 != 0) {
                jSONObject.put("xrTime", j3);
            }
            if (i4 != 0) {
                jSONObject.put("code", i4);
            }
            if (str2 != null) {
                jSONObject.put("msg", str2);
            }
            if (j4 != 0) {
                jSONObject.put("adid", j4);
            }
            if (str4 != null) {
                jSONObject.put(WfConstant.EVENT_KEY_APP_NAME, str4);
            }
            if (i5 != 0) {
                jSONObject.put("reqNum", i5);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.d("ChuanshanjiaSdkManager", "reportMDA eventID = " + str + ", params = " + jSONObject.toString());
        zn6.d(str, null, jSONObject.toString());
    }

    public static void w(String str, int i2, int i3, long j2) {
        x(str, i2, i3, 0L, 0, null, j2, null, 0);
    }

    public static void x(String str, int i2, int i3, long j2, int i4, String str2, long j3, String str3, int i5) {
        v(str, i2, i3, j2, 0L, i4, str2, i(), j3, str3, i5);
    }

    public static void y(String str, int i2, int i3, long j2, String str2) {
        x(str, i2, i3, 0L, 0, null, j2, str2, 0);
    }

    public static void z(String str, int i2, int i3, long j2) {
        A(str, i2, i3, 0L, 0, null, j2, null);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements TTFeedAd.VideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e6 f21624a;

        public c(e6 e6Var) {
            this.f21624a = e6Var;
        }

        public final void a(String str) {
            w50.w(str, this.f21624a.f17220a.getImageMode(), this.f21624a.f17220a.getInteractionType(), this.f21624a.b);
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdComplete(TTFeedAd tTFeedAd) {
            a("lx_client_sdkad_videoE");
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
            a("lx_client_sdkad_videoC");
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdPaused(TTFeedAd tTFeedAd) {
            a("lx_client_sdkad_videoB");
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
            a("lx_client_sdkad_videoS");
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoError(int i, int i2) {
            LogUtil.d("ChuanshanjiaSdkManager", "onVideoError：errorCode=" + i + ",extraCode=" + i2);
            a("lx_client_sdkad_videoload");
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoLoad(TTFeedAd tTFeedAd) {
            a("lx_client_sdkad_videoload");
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onProgressUpdate(long j, long j2) {
        }
    }
}
