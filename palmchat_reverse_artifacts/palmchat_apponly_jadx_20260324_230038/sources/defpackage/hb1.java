package defpackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.compliance.AdDownViVoConfig;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdHelperFeed;
import com.wifi.ad.core.listener.DislikeListener;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.ad.AdTempViewHelper;
import com.zenmen.palmchat.ad.ShakeView;
import com.zenmen.palmchat.ad.VisibleDetectView;
import com.zenmen.palmchat.ad.compliance.AdComInfoAllLayout;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.databinding.SquareUserdetailAdBannerContentBinding;
import com.zenmen.square.databinding.SquareUserdetailAdLargedivContentBinding;
import defpackage.cb1;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class hb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static je1 f17907a;
    public static ShakeView b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements NestAdData.AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17908a;
        public final /* synthetic */ int b;
        public final /* synthetic */ fb1 c;
        public final /* synthetic */ cb1 d;

        public a(String str, int i, fb1 fb1Var, cb1 cb1Var) {
            this.f17908a = str;
            this.b = i;
            this.c = fb1Var;
            this.d = cb1Var;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdClicked(NestAdData nestAdData) {
            gb1.a(this.f17908a, "LX-39904", db1.f(), this.b, nestAdData, this.c.b);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdExposed(NestAdData nestAdData) {
            gb1.h(this.f17908a, "LX-39904", db1.f(), this.b, nestAdData, this.c.b);
            if (this.d.d) {
                if (!b6.d()) {
                    db1.c = null;
                    eb1.c = null;
                    return;
                }
                cb1 cb1Var = db1.c;
                if (cb1Var != null) {
                    cb1Var.b();
                    db1.c = null;
                }
                cb1 cb1Var2 = eb1.c;
                if (cb1Var2 != null) {
                    cb1Var2.b();
                    eb1.c = null;
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements VisibleDetectView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cb1 f17909a;

        public b(cb1 cb1Var) {
            this.f17909a = cb1Var;
        }

        @Override // com.zenmen.palmchat.ad.VisibleDetectView.d
        public void a(boolean z) {
            ShakeView shakeView = hb1.b;
            if (shakeView != null) {
                if (!z) {
                    shakeView.setVisibility(8);
                } else if (ShakeView.shakeEnabled(this.f17909a.c)) {
                    hb1.b.setVisibility(0);
                    ShakeView.eventShakeShow(this.f17909a.c);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements DislikeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f17910a;
        public final /* synthetic */ LinearLayout b;

        public c(j jVar, LinearLayout linearLayout) {
            this.f17910a = jVar;
            this.b = linearLayout;
        }

        @Override // com.wifi.ad.core.listener.DislikeListener
        public void onDislikeClicked(@NonNull NestAdData nestAdData, @Nullable String str) {
            WifiLog.d("AdUIHelper onDislikeClicked2: " + this.f17910a);
            j jVar = this.f17910a;
            if (jVar != null) {
                jVar.a(this.b);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements AdTempViewHelper.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f17911a;
        public final /* synthetic */ LinearLayout b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar = d.this;
                j jVar = dVar.f17911a;
                if (jVar != null) {
                    jVar.a(dVar.b);
                }
            }
        }

        public d(j jVar, LinearLayout linearLayout) {
            this.f17911a = jVar;
            this.b = linearLayout;
        }

        @Override // com.zenmen.palmchat.ad.AdTempViewHelper.a
        public void a(View view) {
            LogUtil.d("", "AdTempViewHelper DetailUIHelper adShowError ");
            if (view != null) {
                view.setVisibility(0);
                view.setOnClickListener(new a());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f17913a;
        public final /* synthetic */ ViewGroup b;

        public e(j jVar, ViewGroup viewGroup) {
            this.f17913a = jVar;
            this.b = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar = this.f17913a;
            if (jVar != null) {
                jVar.a(this.b);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements NestAdData.AppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f17914a;

        public f(TextView textView) {
            this.f17914a = textView;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadComplete(NestAdData nestAdData) {
            this.f17914a.setText(R.string.ad_download_install);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadFailed(NestAdData nestAdData) {
            Toast.makeText(this.f17914a.getContext(), R.string.ad_download_failed, 0).show();
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadInstalled(NestAdData nestAdData) {
            this.f17914a.setText(R.string.ad_download_open);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadPause(NestAdData nestAdData) {
            this.f17914a.setText(R.string.ad_download_resume);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadProgress(NestAdData nestAdData, int i) {
            this.f17914a.setText(R.string.ad_download_pause);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadStart(NestAdData nestAdData) {
            this.f17914a.setText(R.string.ad_download_start);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f17915a;
        public final /* synthetic */ ViewGroup b;

        public h(j jVar, ViewGroup viewGroup) {
            this.f17915a = jVar;
            this.b = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar = this.f17915a;
            if (jVar != null) {
                jVar.a(this.b);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements NestAdData.AppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f17916a;

        public i(TextView textView) {
            this.f17916a = textView;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadComplete(NestAdData nestAdData) {
            this.f17916a.setText(R.string.ad_download_install);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadFailed(NestAdData nestAdData) {
            Toast.makeText(this.f17916a.getContext(), R.string.ad_download_failed, 0).show();
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadInstalled(NestAdData nestAdData) {
            this.f17916a.setText(R.string.ad_download_open);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadPause(NestAdData nestAdData) {
            this.f17916a.setText(R.string.ad_download_resume);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadProgress(NestAdData nestAdData, int i) {
            this.f17916a.setText(R.string.ad_download_pause);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadStart(NestAdData nestAdData) {
            this.f17916a.setText(R.string.ad_download_start);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface j {
        void a(View view);
    }

    public static View a(Context context, NestAdData nestAdData, j jVar) {
        SquareUserdetailAdBannerContentBinding squareUserdetailAdBannerContentBindingB = SquareUserdetailAdBannerContentBinding.b(LayoutInflater.from(context));
        AdHelperFeed adHelperFeed = AdHelperFeed.INSTANCE;
        ViewGroup viewGroupWrapDecorationIfGDT = adHelperFeed.wrapDecorationIfGDT((ViewGroup) squareUserdetailAdBannerContentBindingB.getRoot(), nestAdData);
        ShakeView shakeView = squareUserdetailAdBannerContentBindingB.k;
        b = shakeView;
        shakeView.setShowDesc(false);
        if (f(nestAdData)) {
            View adView = nestAdData.getAdView();
            if (adView != null) {
                ViewParent parent = adView.getParent();
                boolean z = parent instanceof ViewGroup;
                if (z) {
                    ((ViewGroup) parent).removeView(adView);
                }
                if (parent == null || z) {
                    squareUserdetailAdBannerContentBindingB.i.addView(adView, new ViewGroup.LayoutParams(-1, -1));
                    AdDownViVoConfig.checkVideoViewClick(nestAdData, squareUserdetailAdBannerContentBindingB.i);
                }
            }
        } else {
            if (f17907a == null) {
                f17907a = a46.i(R.drawable.bg_feed_item_loading);
            }
            String strE = e(nestAdData);
            gr2 gr2VarJ = gr2.j();
            if (strE == null) {
                strE = "";
            }
            gr2VarJ.h(strE, squareUserdetailAdBannerContentBindingB.f, f17907a);
        }
        squareUserdetailAdBannerContentBindingB.c.setOnClickListener(new e(jVar, viewGroupWrapDecorationIfGDT));
        String title = nestAdData.getTitle();
        TextView textView = squareUserdetailAdBannerContentBindingB.g;
        if (TextUtils.isEmpty(title)) {
            title = context.getString(R.string.ad_moments_name);
        }
        textView.setText(title);
        String adAppName = nestAdData.getAdAppName();
        TextView textView2 = squareUserdetailAdBannerContentBindingB.b;
        if (TextUtils.isEmpty(adAppName)) {
            adAppName = context.getString(R.string.ad_moments_name);
        }
        textView2.setText(adAppName);
        if (nestAdData.supportAdLogo()) {
            squareUserdetailAdBannerContentBindingB.e.setImageResource(nestAdData.getAdLogoResId());
        } else {
            squareUserdetailAdBannerContentBindingB.e.setVisibility(8);
        }
        if (WifiNestAd.INSTANCE.getMPersonalizedAd()) {
            squareUserdetailAdBannerContentBindingB.h.setText(R.string.personalize_ad);
        } else {
            squareUserdetailAdBannerContentBindingB.h.setText(R.string.common_ad);
        }
        TextView textView3 = squareUserdetailAdBannerContentBindingB.f16243a;
        if (nestAdData.getInteractionType().intValue() == 1) {
            textView3.setText(R.string.ad_download_start);
            nestAdData.setAppDownloadListener(new f(textView3));
        } else {
            textView3.setText(R.string.ad_show_more);
        }
        AdComInfoAllLayout adComInfoAllLayout = squareUserdetailAdBannerContentBindingB.d;
        if (adComInfoAllLayout != null) {
            adComInfoAllLayout.initComInfo(nestAdData);
        }
        adHelperFeed.registerViewAndAction(viewGroupWrapDecorationIfGDT, textView3, new View[]{squareUserdetailAdBannerContentBindingB.getRoot()}, null, null, nestAdData);
        return viewGroupWrapDecorationIfGDT;
    }

    public static View b(Context context, NestAdData nestAdData, j jVar) {
        SquareUserdetailAdLargedivContentBinding squareUserdetailAdLargedivContentBindingB = SquareUserdetailAdLargedivContentBinding.b(LayoutInflater.from(context));
        AdHelperFeed adHelperFeed = AdHelperFeed.INSTANCE;
        ViewGroup viewGroupWrapDecorationIfGDT = adHelperFeed.wrapDecorationIfGDT((ViewGroup) squareUserdetailAdLargedivContentBindingB.getRoot(), nestAdData);
        b = squareUserdetailAdLargedivContentBindingB.k;
        if (f(nestAdData)) {
            View adView = nestAdData.getAdView();
            if (adView != null) {
                ViewParent parent = adView.getParent();
                boolean z = parent instanceof ViewGroup;
                if (z) {
                    ((ViewGroup) parent).removeView(adView);
                }
                if (parent == null || z) {
                    squareUserdetailAdLargedivContentBindingB.i.addView(adView, new ViewGroup.LayoutParams(-1, -1));
                    AdDownViVoConfig.checkVideoViewClick(nestAdData, squareUserdetailAdLargedivContentBindingB.i);
                }
            }
        } else {
            if (f17907a == null) {
                f17907a = a46.i(R.drawable.bg_feed_item_loading);
            }
            String strE = e(nestAdData);
            gr2 gr2VarJ = gr2.j();
            if (strE == null) {
                strE = "";
            }
            gr2VarJ.h(strE, squareUserdetailAdLargedivContentBindingB.f, f17907a);
        }
        squareUserdetailAdLargedivContentBindingB.c.setOnClickListener(new h(jVar, viewGroupWrapDecorationIfGDT));
        String title = nestAdData.getTitle();
        TextView textView = squareUserdetailAdLargedivContentBindingB.g;
        if (TextUtils.isEmpty(title)) {
            title = context.getString(R.string.ad_moments_name);
        }
        textView.setText(title);
        String adAppName = nestAdData.getAdAppName();
        TextView textView2 = squareUserdetailAdLargedivContentBindingB.b;
        if (TextUtils.isEmpty(adAppName)) {
            adAppName = context.getString(R.string.ad_moments_name);
        }
        textView2.setText(adAppName);
        if (nestAdData.supportAdLogo()) {
            squareUserdetailAdLargedivContentBindingB.e.setImageResource(nestAdData.getAdLogoResId());
        } else {
            squareUserdetailAdLargedivContentBindingB.e.setVisibility(8);
        }
        if (WifiNestAd.INSTANCE.getMPersonalizedAd()) {
            squareUserdetailAdLargedivContentBindingB.h.setText(R.string.personalize_ad);
        } else {
            squareUserdetailAdLargedivContentBindingB.h.setText(R.string.common_ad);
        }
        TextView textView3 = squareUserdetailAdLargedivContentBindingB.f16245a;
        if (nestAdData.getInteractionType().intValue() == 1) {
            textView3.setText(R.string.ad_download_start);
            nestAdData.setAppDownloadListener(new i(textView3));
        } else {
            textView3.setText(R.string.ad_show_more);
        }
        AdComInfoAllLayout adComInfoAllLayout = squareUserdetailAdLargedivContentBindingB.d;
        if (adComInfoAllLayout != null) {
            adComInfoAllLayout.initComInfo(nestAdData);
        }
        adHelperFeed.registerViewAndAction(viewGroupWrapDecorationIfGDT, textView3, new View[]{squareUserdetailAdLargedivContentBindingB.getRoot()}, null, null, nestAdData);
        return viewGroupWrapDecorationIfGDT;
    }

    public static View c(Context context, NestAdData nestAdData, j jVar) {
        if (context == null || nestAdData == null || jVar == null) {
            return null;
        }
        iv3 iv3Var = new iv3(nestAdData.getAdScene(), nestAdData, new dv3(jVar, new g()));
        View viewD = nv3.d(iv3Var, context);
        if (!(viewD instanceof ViewGroup)) {
            return null;
        }
        nv3.a(iv3Var, context, (ViewGroup) viewD);
        return viewD;
    }

    public static View d(Activity activity, cb1 cb1Var, fb1 fb1Var, j jVar) {
        String str = cb1Var.f1940a;
        int i2 = cb1Var.d ? 59 : 60;
        a aVar = new a(str, i2, fb1Var, cb1Var);
        View viewA = null;
        if (cb1Var.d) {
            cb1Var.c.setAdInteractionListener(aVar);
            int iB = n6.b;
            if (n6.a()) {
                iB = n6.b(59);
            }
            int i3 = fb1Var.f17495a;
            if (i3 == 0) {
                viewA = a(activity, cb1Var.c, jVar);
            } else if (i3 == 1) {
                viewA = iB == n6.c ? c(activity, cb1Var.c, jVar) : b(activity, cb1Var.c, jVar);
            }
            if (viewA != null) {
                if (iB != n6.b) {
                    return viewA;
                }
                VisibleDetectView visibleDetectView = new VisibleDetectView(activity.getApplicationContext());
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                ViewParent parent = viewA.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(viewA);
                }
                visibleDetectView.addView(viewA, layoutParams);
                visibleDetectView.setFullyVisibleListener(new b(cb1Var));
                return visibleDetectView;
            }
        } else {
            LinearLayout linearLayout = new LinearLayout(activity);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            cb1.a aVar2 = cb1Var.f;
            if (aVar2 != null) {
                aVar2.b(aVar);
            }
            cb1.b bVar = cb1Var.e;
            if (bVar != null) {
                bVar.b(new c(jVar, linearLayout));
            }
            cb1.b bVar2 = cb1Var.e;
            NestAdData nestAdData = cb1Var.c;
            DislikeListener dislikeListenerYWF = (nestAdData == null || nestAdData.getStrategyListener() == null) ? null : cb1Var.c.getStrategyListener().getDislikeListenerYWF();
            if (dislikeListenerYWF != null && dislikeListenerYWF != bVar2) {
                cb1Var.c.getStrategyListener().setAdDislikeListenerYWF(bVar2);
                WifiLog.d("DislikeAD change ok ");
            }
            WifiNestAd.INSTANCE.createAdFeed().showTemplateFeedAd(linearLayout, cb1Var.c, activity);
            linearLayout.removeAllViews();
            View adView = cb1Var.c.getAdView();
            if (AdTempViewHelper.j("LX-56968", cb1Var.c.getAdType())) {
                y6 y6VarA = y6.a(cb1Var.c);
                y6VarA.v("LX-39904");
                y6VarA.o(db1.f());
                adView = new AdTempViewHelper(y6VarA, adView, new d(jVar, linearLayout), i2).i();
            }
            if (adView == null || !g(adView)) {
                linearLayout = null;
            } else {
                linearLayout.addView(adView, new ViewGroup.LayoutParams(-2, -2));
            }
            if (b6.d()) {
                cb1 cb1Var2 = db1.c;
                if (cb1Var2 != null) {
                    cb1Var2.b();
                    db1.c = null;
                }
                cb1 cb1Var3 = eb1.c;
                if (cb1Var3 != null) {
                    cb1Var3.b();
                    eb1.c = null;
                }
            } else {
                db1.c = null;
                eb1.c = null;
            }
            viewA = linearLayout;
        }
        if (viewA != null) {
            return viewA;
        }
        Space space = new Space(activity);
        gb1.f("LX-39904", db1.f(), 5);
        return space;
    }

    public static String e(NestAdData nestAdData) {
        List<String> imageList;
        if (nestAdData == null || (imageList = nestAdData.getImageList()) == null || imageList.isEmpty()) {
            return null;
        }
        return imageList.get(0);
    }

    public static boolean f(NestAdData nestAdData) {
        int iIntValue = nestAdData.getAdMode().intValue();
        return iIntValue == 4 || iIntValue == 5;
    }

    public static boolean g(View view) {
        ViewParent parent = view.getParent();
        if (parent == null) {
            return true;
        }
        if (!(parent instanceof ViewGroup)) {
            return false;
        }
        ((ViewGroup) parent).removeView(view);
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements on2 {
        @Override // defpackage.on2
        public void a(int i, Object obj) {
            if (obj instanceof j) {
                ((j) obj).a(null);
            }
        }

        @Override // defpackage.on2
        public void onAdExposed(NestAdData nestAdData) {
            if (l6.a()) {
                if (b6.d()) {
                    cb1 cb1Var = db1.c;
                    if (cb1Var != null) {
                        cb1Var.b();
                        db1.c = null;
                    }
                    cb1 cb1Var2 = eb1.c;
                    if (cb1Var2 != null) {
                        cb1Var2.b();
                        eb1.c = null;
                    }
                } else {
                    db1.c = null;
                    eb1.c = null;
                }
                WifiLog.d("DetailAdManager onAdExpose sAd = null");
            }
        }

        @Override // defpackage.on2
        public void onAdClicked(NestAdData nestAdData) {
        }
    }
}
