package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.entity.AdSize;
import com.wifi.ad.core.helper.AdHelperFeed;
import com.wifi.ad.core.helper.AdHelperH5Ad;
import com.wifi.ad.core.listener.FeedLoadListener;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.ad.view.AdViewFrameLayout;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.cb1;
import defpackage.hb1;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class db1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f17012a = "";
    public static cb1 c;
    public static WeakReference<ViewGroup> g;
    public static fb1 b = new fb1();
    public static boolean d = false;
    public static int e = 0;
    public static Long f = null;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements hb1.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f17014a;

        public b(ViewGroup viewGroup) {
            this.f17014a = viewGroup;
        }

        @Override // hb1.j
        public void a(View view) {
            WifiLog.d("AdUIHelper onDislikeClicked4: " + this.f17014a);
            this.f17014a.removeAllViews();
            this.f17014a.setVisibility(8);
        }
    }

    public static void b(ViewGroup viewGroup) {
        if (viewGroup == null) {
            g = null;
            return;
        }
        View viewFindViewById = viewGroup.findViewById(R.id.ad_layout_wrapper);
        if (viewFindViewById != null && (viewFindViewById instanceof ViewGroup) && viewFindViewById.getParent() == viewGroup) {
            viewGroup.removeView(viewFindViewById);
            int childCount = 0;
            if (b.b != 0) {
                int i = 0;
                while (true) {
                    if (childCount >= viewGroup.getChildCount()) {
                        childCount = -1;
                        break;
                    }
                    if ("item_sign".equals(viewGroup.getChildAt(childCount).getTag())) {
                        i++;
                    }
                    if (b.b == i) {
                        childCount++;
                        break;
                    }
                    childCount++;
                }
            }
            if (childCount == -1) {
                childCount = viewGroup.getChildCount();
            }
            viewGroup.addView(viewFindViewById, childCount);
            g = new WeakReference<>((ViewGroup) viewFindViewById);
        }
    }

    public static void c() {
        if (!b6.d()) {
            if (b6.f) {
                LogUtil.d("ClearAd", "clearCacheAd DetailAdManager clearAllAd");
                c = null;
                hb1.b = null;
                SPCacheManager sPCacheManager = SPCacheManager.INSTANCE;
                sPCacheManager.clearCacheAd(60);
                sPCacheManager.clearCacheAd(59);
                return;
            }
            return;
        }
        if (b6.f || b6.e("DetailAdManager")) {
            LogUtil.d("ClearAd", "clearCacheAd DetailAdManager clearAllAd sAd " + c);
            cb1 cb1Var = c;
            if (cb1Var != null) {
                cb1Var.b();
                c = null;
            }
            SPCacheManager sPCacheManager2 = SPCacheManager.INSTANCE;
            sPCacheManager2.clearCacheAd(60);
            sPCacheManager2.clearCacheAd(59);
        }
    }

    public static fb1 d(JSONObject jSONObject) {
        WifiLog.d("DDDD 2222 createConfigModel ");
        fb1 fb1Var = new fb1();
        if (jSONObject != null) {
            try {
                String strF = f();
                WifiLog.d("DDDD createConfigModel taichikey " + strF);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(strF);
                WifiLog.d("DDDD createConfigModel allObject " + jSONObjectOptJSONObject);
                if (jSONObjectOptJSONObject != null) {
                    int iOptInt = jSONObjectOptJSONObject.optInt("showPosition", fb1Var.b);
                    if (iOptInt < 0) {
                        iOptInt = fb1Var.b;
                    }
                    fb1Var.b = iOptInt;
                    int iOptInt2 = jSONObjectOptJSONObject.optInt("frequencyInterval", fb1Var.c);
                    if (iOptInt2 <= 0) {
                        iOptInt2 = fb1Var.c;
                    }
                    fb1Var.c = iOptInt2;
                    int iOptInt3 = jSONObjectOptJSONObject.optInt("frequencyTimes", fb1Var.d);
                    if (iOptInt3 < 0) {
                        iOptInt3 = fb1Var.d;
                    }
                    fb1Var.d = iOptInt3;
                    int iOptInt4 = jSONObjectOptJSONObject.optInt("showStyle", fb1Var.f17495a);
                    if (iOptInt4 < 0) {
                        iOptInt4 = fb1Var.f17495a;
                    }
                    fb1Var.f17495a = iOptInt4;
                }
            } catch (Exception e2) {
                WifiLog.d("DDDD createConfigModel e " + e2.toString());
            }
        }
        return fb1Var;
    }

    public static void e(String str, String str2) {
        boolean z;
        WifiLog.d("DDDD 1111 getAdJsonAndConfig ");
        f17012a = "";
        b = new fb1();
        if (i()) {
            boolean z2 = true;
            if (TextUtils.isEmpty(str)) {
                z = false;
            } else {
                try {
                    f17012a = new JSONObject(str).optString(f(), "");
                    z = true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    z = false;
                }
            }
            if (TextUtils.isEmpty(str2)) {
                z2 = false;
            } else {
                try {
                    b = d(new JSONObject(str2));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    z2 = false;
                }
            }
            if (z && z2) {
                gb1.b("LX-39904", f());
            }
        }
    }

    public static String f() {
        String strC = jo6.c("LX-39904", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        WifiLog.d("DDDD getTaiValue result " + strC);
        return strC;
    }

    public static void g() {
        WeakReference<ViewGroup> weakReference = g;
        ViewGroup viewGroup = weakReference == null ? null : weakReference.get();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            viewGroup.setVisibility(8);
        }
    }

    public static boolean h() {
        int iP = v5.p("LX-39904");
        if (iP == 1) {
            return false;
        }
        if (iP == 2) {
            return true;
        }
        return "UVWXYZ".contains(f().toUpperCase());
    }

    public static boolean i() {
        return !"A".equalsIgnoreCase(f());
    }

    public static void j(Activity activity) {
        WifiLog.d("DDDD 5555 showAd ");
        if (activity == null || activity.isFinishing()) {
            gb1.f("LX-39904", f(), 3);
            return;
        }
        cb1 cb1Var = c;
        if (cb1Var == null) {
            gb1.f("LX-39904", f(), 4);
            return;
        }
        WifiLog.d("DetailAdManager showAd: " + cb1Var.c);
        cb1Var.c = cb1Var.a();
        WeakReference<ViewGroup> weakReference = g;
        ViewGroup viewGroup = weakReference == null ? null : weakReference.get();
        if (viewGroup == null) {
            gb1.f("LX-39904", f(), 2);
            return;
        }
        WifiLog.d("AdUIHelper onDislikeClicked3: " + viewGroup);
        View viewD = hb1.d(activity, cb1Var, b, new b(viewGroup));
        if (viewD instanceof Space) {
            return;
        }
        viewGroup.setVisibility(0);
        viewGroup.removeAllViews();
        AdViewFrameLayout adViewFrameLayout = new AdViewFrameLayout(viewGroup.getContext());
        adViewFrameLayout.addView(viewD, new ViewGroup.LayoutParams(-1, -1));
        viewGroup.addView(adViewFrameLayout, new ViewGroup.LayoutParams(-1, -2));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("new_user_detail", 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        bw3.b(cb1Var.f1940a, "LX-39904", f(), cb1Var.d ? 59 : 60, cb1Var.c, jSONObject);
    }

    public static void k(Activity activity, int i) {
        String adRequestId = AdHelperH5Ad.INSTANCE.getAdRequestId();
        String strB = pu3.b();
        boolean zH = h();
        int i2 = zH ? 59 : 60;
        WifiLog.d("DDDD 3333 tryRequest context " + activity + " mStrategyJson " + f17012a);
        if (!i()) {
            gb1.e("LX-39904", f(), 2);
            pu3.a(strB, 101, i2, adRequestId);
            return;
        }
        if (activity == null) {
            gb1.e("LX-39904", f(), 4);
            pu3.a(strB, 401, i2, adRequestId);
            return;
        }
        if (!l6.f(i2)) {
            gb1.e("LX-39904", f(), 5);
            pu3.a(strB, 104, i2, adRequestId);
            return;
        }
        if (d) {
            gb1.e("LX-39904", f(), 7);
            pu3.a(strB, 401, i2, adRequestId);
            return;
        }
        if (c != null) {
            gb1.e("LX-39904", f(), 6);
            pu3.a(strB, 401, i2, adRequestId);
            return;
        }
        if (f == null) {
            f = Long.valueOf(System.currentTimeMillis());
        }
        if (b.c != -1 && (Math.abs(System.currentTimeMillis() - f.longValue()) / 1000) / 60 >= b.c) {
            f = Long.valueOf(System.currentTimeMillis());
            e = 0;
        }
        int i3 = b.d;
        if (i3 != -1 && e + 1 > i3) {
            gb1.e("LX-39904", f(), 8);
            pu3.a(strB, 201, i2, adRequestId);
            return;
        }
        d = true;
        e++;
        HashMap map = new HashMap();
        map.put("requestId", adRequestId);
        map.put("taiChiKey", "LX-39904");
        map.put("exp_group", f());
        map.put(EventParams.KEY_INVENTORYID, strB);
        pu3.a(strB, 0, i2, adRequestId);
        AdHelperFeed adHelperFeedCreateAdFeed = WifiNestAd.INSTANCE.createAdFeed();
        gb1.g(adRequestId, "LX-39904", f(), Integer.valueOf(i));
        AdParams adParamsBuild = new AdParams.Builder().setExt(map).setScene(i2).setAdUnitId(zH ? "cij9hp79ntqdm53ijkeg" : "cagm9rqch5lb7q8042h0").setFullStrategyJson(f17012a).setAdSize(new AdSize(320.0f, -2.0f)).build();
        cb1.b bVar = new cb1.b();
        cb1.a aVar = new cb1.a();
        a aVar2 = new a(adRequestId, zH, bVar, aVar, i2, i, b6.d() ? new WeakReference(activity) : null, activity);
        if (zH) {
            adHelperFeedCreateAdFeed.getNativeFeedAd(activity, adParamsBuild, aVar2);
        } else {
            adHelperFeedCreateAdFeed.getFeedAd(activity, adParamsBuild, aVar2, bVar, aVar);
        }
    }

    public static void l(String str) {
        WifiLog.d("DDDD  updateAdConfig ");
        b = new fb1();
        if (!i() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            b = d(new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void m(String str) {
        WifiLog.d("DDDD  updateAdJson ");
        f17012a = "";
        if (!i() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            f17012a = new JSONObject(str).optString(f(), "");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FeedLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17013a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ cb1.b c;
        public final /* synthetic */ cb1.a d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ WeakReference g;
        public final /* synthetic */ Activity h;

        public a(String str, boolean z, cb1.b bVar, cb1.a aVar, int i, int i2, WeakReference weakReference, Activity activity) {
            this.f17013a = str;
            this.b = z;
            this.c = bVar;
            this.d = aVar;
            this.e = i;
            this.f = i2;
            this.g = weakReference;
            this.h = activity;
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
            db1.d = false;
            gb1.d(str, str2, this.e);
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            NestAdData nestAdData;
            db1.d = false;
            if (list == null || list.size() <= 0 || (nestAdData = list.get(0)) == null) {
                return;
            }
            cb1 cb1Var = new cb1(this.f17013a, nestAdData, this.b);
            if (!this.b) {
                cb1Var.e = this.c;
                cb1Var.f = this.d;
            }
            db1.c = cb1Var;
            gb1.c(this.f17013a, "LX-39904", db1.f(), this.e, nestAdData);
            if (this.f != 2) {
                if (!b6.d()) {
                    db1.j(this.h);
                    return;
                }
                WeakReference weakReference = this.g;
                if (weakReference != null) {
                    db1.j((Activity) weakReference.get());
                }
            }
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onStart() {
        }
    }
}
