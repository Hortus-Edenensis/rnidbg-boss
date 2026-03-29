package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdHelperFeed;
import com.wifi.ad.core.helper.AdHelperH5Ad;
import com.wifi.ad.core.listener.FeedLoadListener;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.io6;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ao6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static NestAdData f1541a = null;
    public static String b = null;
    public static boolean c = false;
    public static Long d;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements NestAdData.AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1543a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public b(String str, String str2, int i) {
            this.f1543a = str;
            this.b = str2;
            this.c = i;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdClicked(NestAdData nestAdData) {
            gn1.a(this.f1543a, "LX-33784", ns5.d(), 33, nestAdData, this.b, this.c);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdExposed(NestAdData nestAdData) {
            gn1.i(this.f1543a, "LX-33784", ns5.d(), 33, nestAdData, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements io6.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1544a;
        public final /* synthetic */ LinearLayout b;

        public c(ViewGroup viewGroup, LinearLayout linearLayout) {
            this.f1544a = viewGroup;
            this.b = linearLayout;
        }

        @Override // io6.h
        public void a(View view) {
            this.f1544a.removeView(this.b);
        }
    }

    public static void f() {
        if (!b6.d()) {
            if (b6.i) {
                LogUtil.d("ClearAd", "clearCacheAd WkNestBannerAd clearAllAd");
                f1541a = null;
                SPCacheManager.INSTANCE.clearCacheAd(33);
                return;
            }
            return;
        }
        if (b6.i || b6.f1653a) {
            LogUtil.d("ClearAd", "clearCacheAd WkNestBannerAd clearAllAd");
            f1541a = null;
            SPCacheManager.INSTANCE.clearCacheAd(33);
        }
    }

    public static boolean g() {
        return f1541a != null;
    }

    public static boolean h(View view, LinearLayout linearLayout) {
        if (view == null) {
            return false;
        }
        ViewParent parent = view.getParent();
        boolean z = parent instanceof ViewGroup;
        if (z) {
            ((ViewGroup) parent).removeView(view);
        }
        if (parent != null && !z) {
            return false;
        }
        linearLayout.setOrientation(1);
        linearLayout.addView(view, new ViewGroup.LayoutParams(-1, -2));
        linearLayout.addView(new View(linearLayout.getContext()), new ViewGroup.LayoutParams(-1, me1.b(linearLayout.getContext(), 10)));
        return true;
    }

    public static void i(String str, Activity activity, String str2, boolean z) {
        WifiLog.d("TTTT requestPreAd mPreAd " + f1541a);
        if (!l6.f(33)) {
            ma3.a("[WkNestBannerAd-requestPreAd] ad config has not opened.", new Object[0]);
            gn1.f("LX-33784", ns5.d(), str2, 5);
            return;
        }
        if (g()) {
            gn1.f("LX-33784", ns5.d(), str2, 6);
            return;
        }
        if (c) {
            gn1.f("LX-33784", ns5.d(), str2, 7);
            return;
        }
        if (!z && d != null && Math.abs(System.currentTimeMillis() - d.longValue()) < ns5.d) {
            gn1.f("LX-33784", ns5.d(), str2, 8);
            return;
        }
        c = true;
        String adRequestId = AdHelperH5Ad.INSTANCE.getAdRequestId();
        HashMap map = new HashMap();
        map.put("requestId", adRequestId);
        map.put("taiChiKey", "LX-33784");
        map.put("exp_group", ns5.d());
        AdHelperFeed adHelperFeedCreateAdFeed = WifiNestAd.INSTANCE.createAdFeed();
        gn1.h(adRequestId, "LX-33784", ns5.d(), null);
        adHelperFeedCreateAdFeed.getNativeFeedAd(activity, new AdParams.Builder().setExt(map).setScene(33).setAdUnitId("5c5c6564f682a0f6c187").setFullStrategyJson(str).build(), new a(adRequestId));
    }

    public static void j(String str, ViewGroup viewGroup, Activity activity, int i) {
        WifiLog.d("WkNestBannerAd showAd: ad is " + f1541a);
        if (!g()) {
            gn1.g("LX-33784", ns5.d(), str, 4);
            return;
        }
        WifiLog.d("WkNestBannerAd showAd: title is " + f1541a.getTitle() + ", appName is " + f1541a.getAdAppName());
        if (f1541a.getAdSPStrategy()) {
            NestAdData nestAdDataChangeCheckMaxAd = SPCacheManager.INSTANCE.changeCheckMaxAd(f1541a);
            if (nestAdDataChangeCheckMaxAd != null) {
                f1541a = nestAdDataChangeCheckMaxAd;
            }
            WifiLog.d("WkNestBannerAd showAd: title is " + f1541a.getTitle() + ", appName is " + f1541a.getAdAppName());
        }
        if (!TextUtils.isEmpty(str) && f1541a.getAdParams() != null && f1541a.getAdParams().getExt() != null) {
            f1541a.getAdParams().getExt().put("tabBannerName", str);
        }
        b bVar = new b(b, str, i);
        f1541a.setAdInteractionListener(bVar);
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        if (!h(io6.a(activity, f1541a, 1, new c(viewGroup, linearLayout), bVar), linearLayout)) {
            gn1.g("LX-33784", ns5.d(), str, 5);
            return;
        }
        f1541a = null;
        viewGroup.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
        ns5.h(activity, false, str, true);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FeedLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1542a;

        public a(String str) {
            this.f1542a = str;
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
            ao6.c = false;
            ao6.d = Long.valueOf(System.currentTimeMillis());
            gn1.e(str, str2, 33);
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            ao6.c = false;
            ao6.d = Long.valueOf(System.currentTimeMillis());
            if (list == null || list.size() <= 0) {
                return;
            }
            ao6.f1541a = list.get(0);
            ao6.b = this.f1542a;
            gn1.d(this.f1542a, "LX-33784", ns5.d(), 33, ao6.f1541a);
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onStart() {
        }
    }
}
