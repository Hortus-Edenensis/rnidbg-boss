package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.entity.AdSize;
import com.wifi.ad.core.helper.AdHelperFeed;
import com.wifi.ad.core.helper.AdHelperH5Ad;
import com.wifi.ad.core.listener.DislikeListener;
import com.wifi.ad.core.listener.FeedLoadListener;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.ad.AdTempViewHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.io6;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class jp3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static NestAdData f18464a = null;
    public static h b = null;
    public static g c = null;
    public static boolean d = false;
    public static String e = null;
    public static boolean f = false;
    public static Long g;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements NestAdData.AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18466a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ WeakReference e;
        public final /* synthetic */ boolean f;

        public b(String str, int i, String str2, int i2, WeakReference weakReference, boolean z) {
            this.f18466a = str;
            this.b = i;
            this.c = str2;
            this.d = i2;
            this.e = weakReference;
            this.f = z;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdClicked(NestAdData nestAdData) {
            gn1.a(this.f18466a, "LX-34097", gp3.f(), this.b, nestAdData, this.c, this.d);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdExposed(NestAdData nestAdData) {
            Activity activity = (Activity) this.e.get();
            if (activity == null) {
                return;
            }
            gn1.i(this.f18466a, "LX-34097", gp3.f(), this.b, nestAdData, this.c, this.d);
            if (this.f) {
                jp3.f18464a = null;
                if (WkAdxAdConfigMg.DSP_NAME_BAIDU.equalsIgnoreCase(gp3.g())) {
                    LogUtil.d("", "lx_client_nestad_noreqmineAd requestPreTabBanner Switch58597 is not A EXPOSED 不允许请求 tabName " + this.c);
                } else {
                    LogUtil.d("", "lx_client_nestad_noreqmineAd requestPreTabBanner Switch58597 is A EXPOSED 允许请求 tabName " + this.c);
                    gp3.j(activity, 4, this.c);
                }
            }
            if (l6.a()) {
                jp3.f18464a = null;
                WifiLog.d("MineNestBannerAd onAdExpose mPreAd = null");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f18467a;

        public c(WeakReference weakReference) {
            this.f18467a = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = (ViewGroup) this.f18467a.get();
            if (viewGroup == null) {
                return;
            }
            viewGroup.removeAllViews();
            viewGroup.setVisibility(8);
            jp3.d = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements io6.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f18468a;

        public d(Runnable runnable) {
            this.f18468a = runnable;
        }

        @Override // io6.h
        public void a(View view) {
            this.f18468a.run();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements DislikeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f18469a;

        public e(Runnable runnable) {
            this.f18469a = runnable;
        }

        @Override // com.wifi.ad.core.listener.DislikeListener
        public void onDislikeClicked(NestAdData nestAdData, String str) {
            this.f18469a.run();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements AdTempViewHelper.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f18470a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Runnable runnable = f.this.f18470a;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        public f(Runnable runnable) {
            this.f18470a = runnable;
        }

        @Override // com.zenmen.palmchat.ad.AdTempViewHelper.a
        public void a(View view) {
            LogUtil.d("", "AdTempViewHelper AdUiHelper adShowError ");
            if (view != null) {
                view.setVisibility(0);
                view.setOnClickListener(new a());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g implements NestAdData.AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NestAdData.AdInteractionListener f18472a;

        public void a() {
            if (b6.d()) {
                this.f18472a = null;
            }
        }

        public void b(NestAdData.AdInteractionListener adInteractionListener) {
            this.f18472a = adInteractionListener;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdClicked(NestAdData nestAdData) {
            NestAdData.AdInteractionListener adInteractionListener = this.f18472a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked(nestAdData);
            }
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdExposed(NestAdData nestAdData) {
            NestAdData.AdInteractionListener adInteractionListener = this.f18472a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdExposed(nestAdData);
            }
        }

        public g() {
            this.f18472a = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class h implements DislikeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DislikeListener f18473a;

        public void a() {
            if (b6.d()) {
                this.f18473a = null;
            }
        }

        public void b(DislikeListener dislikeListener) {
            this.f18473a = dislikeListener;
        }

        @Override // com.wifi.ad.core.listener.DislikeListener
        public void onDislikeClicked(NestAdData nestAdData, String str) {
            DislikeListener dislikeListener = this.f18473a;
            if (dislikeListener != null) {
                dislikeListener.onDislikeClicked(nestAdData, str);
            }
        }

        public h() {
            this.f18473a = null;
        }
    }

    public static void g() {
        if (!b6.d()) {
            if (b6.g) {
                LogUtil.d("ClearAd", "clearCacheAd MineNestBannerAd clearAllAd");
                f18464a = null;
                SPCacheManager sPCacheManager = SPCacheManager.INSTANCE;
                sPCacheManager.clearCacheAd(40);
                sPCacheManager.clearCacheAd(45);
                return;
            }
            return;
        }
        if (b6.g || b6.f1653a) {
            LogUtil.d("ClearAd", "clearCacheAd MineNestBannerAd clearAllAd");
            if (f18464a != null) {
                SPCacheManager.INSTANCE.destroyOneAd(f18464a);
                f18464a = null;
            }
            SPCacheManager sPCacheManager2 = SPCacheManager.INSTANCE;
            sPCacheManager2.clearCacheAd(40);
            sPCacheManager2.clearCacheAd(45);
            h hVar = b;
            if (hVar != null) {
                hVar.a();
            }
            g gVar = c;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    public static boolean h() {
        return f18464a != null;
    }

    public static boolean i(View view, LinearLayout linearLayout, boolean z) {
        if (view == null) {
            return false;
        }
        ViewParent parent = view.getParent();
        boolean z2 = parent instanceof ViewGroup;
        if (z2) {
            ((ViewGroup) parent).removeView(view);
        }
        if (parent != null && !z2) {
            return false;
        }
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        if (z) {
            linearLayout.addView(view, new ViewGroup.LayoutParams(-1, -2));
        } else {
            linearLayout.addView(view, new ViewGroup.LayoutParams(-2, -2));
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void j(String str, Activity activity, String str2, int i) {
        WifiLog.d("TTTT requestPreAd mPreAd " + f18464a);
        boolean zI = gp3.i();
        int i2 = zI ? 40 : 45;
        if (!l6.f(i2)) {
            ma3.a("[MineNestBannerAd-requestPreAd] ad config has not opened.", new Object[0]);
            gn1.f("LX-34097", gp3.f(), str2, 5);
            return;
        }
        if (h()) {
            gn1.f("LX-34097", gp3.f(), str2, 6);
            return;
        }
        if (f) {
            gn1.f("LX-34097", gp3.f(), str2, 7);
            return;
        }
        if (i != 4 && g != null && Math.abs(System.currentTimeMillis() - g.longValue()) < gp3.d) {
            gn1.f("LX-34097", gp3.f(), str2, 8);
            return;
        }
        f = true;
        String adRequestId = AdHelperH5Ad.INSTANCE.getAdRequestId();
        HashMap map = new HashMap();
        map.put("requestId", adRequestId);
        map.put("taiChiKey", "LX-34097");
        map.put("exp_group", gp3.f());
        AdHelperFeed adHelperFeedCreateAdFeed = WifiNestAd.INSTANCE.createAdFeed();
        gn1.h(adRequestId, "LX-34097", gp3.f(), Integer.valueOf(i));
        AdParams adParamsBuild = new AdParams.Builder().setExt(map).setScene(i2).setAdUnitId(zI ? "1eb7e107427689169c21" : "c9ann02ch5lbaothp310").setFullStrategyJson(str).setAdSize(new AdSize(336.0f, 0.0f)).build();
        Object[] objArr = 0;
        FeedLoadListener aVar = new a(zI, adRequestId, i2, i, b6.d() ? new WeakReference(activity) : null, str2, activity);
        LogUtil.d("", "lx_client_nestad_noreqmineAd requestBanner success tabName " + str2);
        if (zI) {
            adHelperFeedCreateAdFeed.getNativeFeedAd(activity, adParamsBuild, aVar);
            return;
        }
        h hVar = new h();
        b = hVar;
        g gVar = new g();
        c = gVar;
        adHelperFeedCreateAdFeed.getFeedAd(activity, adParamsBuild, aVar, hVar, gVar);
    }

    public static void k(String str, ViewGroup viewGroup, Activity activity, int i, int i2) {
        View viewI;
        WifiLog.d("WkNestBannerAd showAd: ad is " + f18464a);
        if (!h() || f18464a == null) {
            gn1.g("LX-34097", gp3.f(), str, 4);
            return;
        }
        if (d) {
            gn1.g("LX-34097", gp3.f(), str, 6);
            return;
        }
        WifiLog.d("WkNestBannerAd showAd: title is " + f18464a.getTitle() + ", appName is " + f18464a.getAdAppName());
        if (f18464a.getAdSPStrategy()) {
            NestAdData nestAdDataChangeCheckMaxAd = SPCacheManager.INSTANCE.changeCheckMaxAd(f18464a);
            if (nestAdDataChangeCheckMaxAd != null) {
                f18464a = nestAdDataChangeCheckMaxAd;
            }
            WifiLog.d("WkNestBannerAd showAd: title is " + f18464a.getTitle() + ", appName is " + f18464a.getAdAppName());
        }
        if (!TextUtils.isEmpty(str) && f18464a.getAdParams() != null && f18464a.getAdParams().getExt() != null) {
            f18464a.getAdParams().getExt().put("tabBannerName", str);
        }
        String str2 = e;
        boolean isNativeAd = f18464a.getIsNativeAd();
        int i3 = isNativeAd ? 40 : 45;
        b bVar = new b(str2, i3, str, i2, new WeakReference(activity), isNativeAd);
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        c cVar = new c(new WeakReference(viewGroup));
        bw3.a(f18464a.getRequestId(), "LX-34097", gp3.f(), i3, f18464a);
        if (isNativeAd) {
            f18464a.setAdInteractionListener(bVar);
            viewI = io6.a(viewGroup.getContext(), f18464a, i == 1 ? 3 : 2, new d(cVar), bVar);
        } else {
            g gVar = c;
            if (gVar != null) {
                gVar.b(bVar);
            }
            h hVar = b;
            if (hVar != null) {
                hVar.b(new e(cVar));
            }
            h hVar2 = b;
            DislikeListener dislikeListenerYWF = f18464a.getStrategyListener() != null ? f18464a.getStrategyListener().getDislikeListenerYWF() : null;
            if (dislikeListenerYWF != null && dislikeListenerYWF != hVar2) {
                f18464a.getStrategyListener().setAdDislikeListenerYWF(hVar2);
                WifiLog.d("DislikeAD change ok ");
            }
            WifiNestAd.INSTANCE.createAdFeed().showTemplateFeedAd(linearLayout, f18464a, activity);
            linearLayout.removeAllViews();
            View adView = f18464a.getAdView();
            if (AdTempViewHelper.j("LX-56967", f18464a.getAdType())) {
                y6 y6VarA = y6.a(f18464a);
                y6VarA.v("LX-34097");
                y6VarA.o(gp3.f());
                viewI = new AdTempViewHelper(y6VarA, adView, new f(cVar), y6VarA.h()).i();
            } else {
                viewI = adView;
            }
            f18464a = null;
            if (WkAdxAdConfigMg.DSP_NAME_BAIDU.equalsIgnoreCase(gp3.g())) {
                LogUtil.d("", "lx_client_nestad_noreqmineAd requestPreTabBanner temp Switch58597 is not A EXPOSED 不允许请求 tabName " + str);
            } else {
                LogUtil.d("", "lx_client_nestad_noreqmineAd requestPreTabBanner temp Switch58597 is A EXPOSED 允许请求 tabName " + str);
                gp3.j(activity, 4, str);
            }
        }
        if (!i(viewI, linearLayout, isNativeAd)) {
            gn1.g("LX-34097", gp3.f(), str, 5);
            return;
        }
        viewGroup.removeAllViews();
        d = true;
        viewGroup.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
        viewGroup.setVisibility(0);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FeedLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18465a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ WeakReference e;
        public final /* synthetic */ String f;
        public final /* synthetic */ Activity g;

        public a(boolean z, String str, int i, int i2, WeakReference weakReference, String str2, Activity activity) {
            this.f18465a = z;
            this.b = str;
            this.c = i;
            this.d = i2;
            this.e = weakReference;
            this.f = str2;
            this.g = activity;
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(String str, String str2) {
            jp3.f = false;
            jp3.g = Long.valueOf(System.currentTimeMillis());
            gn1.e(str, str2, this.c);
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(String str, List<NestAdData> list) {
            jp3.f = false;
            jp3.g = Long.valueOf(System.currentTimeMillis());
            if (list == null || list.size() <= 0) {
                return;
            }
            jp3.f18464a = list.get(0);
            jp3.f18464a.setNativeAd(this.f18465a);
            jp3.d = false;
            jp3.e = this.b;
            gn1.d(this.b, "LX-34097", gp3.f(), this.c, jp3.f18464a);
            if (this.d == 4 || !gp3.i) {
                return;
            }
            if (!b6.d()) {
                gp3.k(this.f, this.g);
                return;
            }
            WeakReference weakReference = this.e;
            if (weakReference != null) {
                gp3.k(this.f, (Activity) weakReference.get());
            }
        }

        @Override // com.wifi.ad.core.listener.FeedLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onStart() {
        }
    }
}
