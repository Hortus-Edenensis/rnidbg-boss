package defpackage;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdHelperH5Ad;
import com.wifi.ad.core.listener.RewardListener;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.square.fragment.NearByFragment;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class ju3 {
    public static NestAdData e;
    public static WeakReference<NearByFragment> f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static et4 f18503a = new et4();
    public static c b = new c();
    public static boolean c = false;
    public static long d = -1;
    public static Handler g = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: SearchBox */
    public class a implements RewardListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f18504a;
        public final /* synthetic */ String b;

        public a(d dVar, String str) {
            this.f18504a = dVar;
            this.b = str;
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdClicked(NestAdData nestAdData) {
            WifiLog.d("onAdClicked");
            ft4.a(this.b, nestAdData);
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdClose(NestAdData nestAdData) {
            WifiLog.d("onAdClose");
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdExpose(NestAdData nestAdData) {
            WifiLog.d("onAdExposed");
        }

        @Override // com.wifi.ad.core.listener.RewardListener, com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
            WifiLog.d("onAdFailed code = " + str + ", errorMsg = " + str2);
            boolean unused = ju3.c = false;
            ft4.d(str, str2);
            d dVar = this.f18504a;
            if (dVar != null) {
                dVar.a();
            }
        }

        @Override // com.wifi.ad.core.listener.RewardListener, com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            WifiLog.d("onAdLoaded");
            boolean unused = ju3.c = false;
            if (list == null || list.size() <= 0) {
                WifiLog.d("onAdLoaded size = 0");
                d dVar = this.f18504a;
                if (dVar != null) {
                    dVar.a();
                    return;
                }
                return;
            }
            WifiLog.d("onAdLoaded size = " + list.size());
            NestAdData unused2 = ju3.e = list.get(0);
            if (ju3.e == null) {
                d dVar2 = this.f18504a;
                if (dVar2 != null) {
                    dVar2.a();
                    return;
                }
                return;
            }
            ft4.c(this.b, ju3.e);
            d dVar3 = this.f18504a;
            if (dVar3 != null) {
                dVar3.onAdLoaded();
            }
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdRewardVerify(NestAdData nestAdData) {
            NearByFragment nearByFragment;
            WifiLog.d("onAdRewardVerify");
            ft4.h();
            ju3.j();
            if (ju3.f == null || (nearByFragment = (NearByFragment) ju3.f.get()) == null) {
                return;
            }
            nearByFragment.N0();
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdShow(NestAdData nestAdData) {
            WifiLog.d("onAdShow");
            ft4.f(this.b, nestAdData);
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdVideoCached(NestAdData nestAdData) {
            WifiLog.d("onAdVideoCached");
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onAdVideoComplete(NestAdData nestAdData) {
            WifiLog.d("onAdVideoComplete");
        }

        @Override // com.wifi.ad.core.listener.RewardListener, com.wifi.ad.core.listener.BaseListener
        public void onStart() {
            WifiLog.d("onStart");
        }

        @Override // com.wifi.ad.core.listener.RewardListener
        public void onVideoPreloadFailed(NestAdData nestAdData) {
            WifiLog.d("onVideoPreloadFailed");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f18505a;
        public final /* synthetic */ FrameworkBaseActivity b;

        public b(Activity activity, FrameworkBaseActivity frameworkBaseActivity) {
            this.f18505a = activity;
            this.b = frameworkBaseActivity;
        }

        @Override // ju3.d
        public void a() {
            if (this.f18505a.isFinishing()) {
                return;
            }
            FrameworkBaseActivity frameworkBaseActivity = this.b;
            if (frameworkBaseActivity != null) {
                frameworkBaseActivity.hideBaseProgressBar();
            }
            ry5.a("抱歉，视频不见了，请稍后再试");
        }

        @Override // ju3.d
        public void onAdLoaded() {
            if (this.f18505a.isFinishing()) {
                return;
            }
            FrameworkBaseActivity frameworkBaseActivity = this.b;
            if (frameworkBaseActivity != null) {
                frameworkBaseActivity.hideBaseProgressBar();
            }
            ju3.s(this.f18505a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f18506a = UUID.randomUUID().toString();
        public et4 b;

        public et4 b() {
            et4 et4Var = this.b;
            if (et4Var != null) {
                return et4Var;
            }
            et4 et4Var2 = ju3.f18503a;
            this.b = et4Var2;
            return et4Var2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a();

        void onAdLoaded();
    }

    public static void f(NearByFragment nearByFragment) {
        if (nearByFragment == null) {
            f = null;
        } else {
            f = new WeakReference<>(nearByFragment);
        }
    }

    public static int g(int i) {
        if (!i()) {
            return -1;
        }
        et4 et4VarB = b.b();
        int iN = et4VarB.l + (et4VarB.g * n());
        if (i > iN) {
            return iN;
        }
        return -1;
    }

    public static et4 h(JSONObject jSONObject) {
        et4 et4Var = new et4();
        if (jSONObject == null) {
            return et4Var;
        }
        String strP = p();
        WifiLog.d("NearByRdAd createConfigModel configKey " + strP);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(strP);
        if (jSONObjectOptJSONObject == null) {
            return et4Var;
        }
        String strOptString = jSONObjectOptJSONObject.optString("dialogTitle", et4Var.f17359a);
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = et4Var.f17359a;
        }
        et4Var.f17359a = strOptString;
        String strOptString2 = jSONObjectOptJSONObject.optString("buttonTitleUp", et4Var.b);
        if (TextUtils.isEmpty(strOptString2)) {
            strOptString2 = et4Var.b;
        }
        et4Var.b = strOptString2;
        String strOptString3 = jSONObjectOptJSONObject.optString("buttonTitleDown", et4Var.c);
        if (TextUtils.isEmpty(strOptString3)) {
            strOptString3 = et4Var.c;
        }
        et4Var.c = strOptString3;
        et4Var.d = jSONObjectOptJSONObject.optInt("popShow", et4Var.d);
        String strOptString4 = jSONObjectOptJSONObject.optString("popText", et4Var.e);
        if (TextUtils.isEmpty(strOptString4)) {
            strOptString4 = et4Var.e;
        }
        et4Var.e = strOptString4;
        String strOptString5 = jSONObjectOptJSONObject.optString("popButton", et4Var.f);
        if (TextUtils.isEmpty(strOptString5)) {
            strOptString5 = et4Var.f;
        }
        et4Var.f = strOptString5;
        int iOptInt = jSONObjectOptJSONObject.optInt("unlockNum", et4Var.g);
        if (iOptInt < 1) {
            iOptInt = et4Var.g;
        }
        et4Var.g = iOptInt;
        int iOptInt2 = jSONObjectOptJSONObject.optInt("limit", et4Var.h);
        if (iOptInt2 < 1) {
            iOptInt2 = et4Var.h;
        }
        et4Var.h = iOptInt2;
        int iOptInt3 = jSONObjectOptJSONObject.optInt("interval", et4Var.i);
        if (iOptInt3 < 0) {
            iOptInt3 = et4Var.i;
        }
        et4Var.i = iOptInt3;
        et4Var.j = jSONObjectOptJSONObject.optInt("requestTime", et4Var.j);
        int iOptInt4 = jSONObjectOptJSONObject.optInt("minValue", et4Var.k);
        if (iOptInt4 < 0) {
            iOptInt4 = et4Var.k;
        }
        et4Var.k = iOptInt4;
        int iOptInt5 = jSONObjectOptJSONObject.optInt("bannerP", et4Var.l);
        if (iOptInt5 <= 0) {
            iOptInt5 = et4Var.l;
        }
        et4Var.l = iOptInt5;
        return et4Var;
    }

    public static boolean i() {
        return r() && !l6.c() && Build.VERSION.SDK_INT >= 23;
    }

    public static void j() {
        String strA = k86.a("key_nearby_ad_reward_times");
        String strA2 = k86.a("key_nearby_ad_reward_date");
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.SQUARE;
        int iF = sPUtil.f(scene, strA, 0);
        String strN = sPUtil.n(scene, strA2, "");
        String strQ = q();
        if (strQ.equals(strN)) {
            sPUtil.t(scene, strA, Integer.valueOf(iF + 1));
        } else {
            sPUtil.t(scene, strA, 1);
            sPUtil.t(scene, strA2, strQ);
        }
        d = System.currentTimeMillis();
    }

    public static void k(String str) {
        boolean z;
        WifiLog.d("NearByRdAd 1111 getAdJsonAndConfig ");
        f18503a = new et4();
        if (r()) {
            if (TextUtils.isEmpty(str)) {
                z = false;
            } else {
                try {
                    f18503a = h(new JSONObject(str));
                    z = true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    z = false;
                }
            }
            if (z) {
                ft4.b();
            }
        }
    }

    public static et4 l() {
        return b.b();
    }

    public static String m() {
        return b.f18506a;
    }

    public static int n() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.SQUARE;
        if (q().equals(sPUtil.n(scene, k86.a("key_nearby_ad_reward_date"), ""))) {
            return sPUtil.f(scene, k86.a("key_nearby_ad_reward_times"), 0);
        }
        return 0;
    }

    public static String o() {
        return "LX-41040";
    }

    public static String p() {
        String strC = jo6.c(o(), "A");
        WifiLog.d("NearByRdAd getBannerTaiValue result " + strC);
        return strC;
    }

    public static String q() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
    }

    public static boolean r() {
        return !"A".equalsIgnoreCase(p());
    }

    public static void s(Activity activity) {
        et4 et4VarL = l();
        if (n() >= et4VarL.h) {
            ry5.a("今日次数用完啦，明天再来~");
            return;
        }
        if (d != -1 && (Math.abs(System.currentTimeMillis() - d) / 1000) / 60 < et4VarL.i) {
            ry5.a("操作太频繁啦，请" + et4VarL.i + "分钟后再来");
            return;
        }
        if (e != null) {
            WifiNestAd.INSTANCE.createRewardAd().showRewardAd(activity, e);
            e = null;
        } else {
            FrameworkBaseActivity frameworkBaseActivity = activity instanceof FrameworkBaseActivity ? (FrameworkBaseActivity) activity : null;
            if (frameworkBaseActivity != null) {
                frameworkBaseActivity.showBaseProgressBar("请稍等...", false);
            }
            u(activity, new b(activity, frameworkBaseActivity));
        }
    }

    public static void t(Activity activity, int i) {
        if (i() && b.b().j == i + 1) {
            u(activity, null);
        }
    }

    public static void u(Activity activity, d dVar) {
        if (e != null) {
            if (dVar != null) {
                dVar.a();
            }
        } else {
            if (c) {
                if (dVar != null) {
                    dVar.a();
                    return;
                }
                return;
            }
            String adRequestId = AdHelperH5Ad.INSTANCE.getAdRequestId();
            c = true;
            ft4.e(adRequestId);
            HashMap map = new HashMap();
            map.put("requestId", adRequestId);
            map.put("taiChiKey", o());
            map.put("exp_group", p());
            WifiNestAd.INSTANCE.createRewardAd().getRewardAd(activity, new AdParams.Builder().setExt(map).setScene(68).setAdUnitId("cboshmj8mea6ah75nodg").build(), new a(dVar, adRequestId));
        }
    }

    public static void v(String str) {
        WifiLog.d("NearByRdAd  updateAdConfig ");
        f18503a = new et4();
        if (!r() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            f18503a = h(new JSONObject(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
