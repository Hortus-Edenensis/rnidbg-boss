package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import android.widget.Toast;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.compliance.AdDownViVoConfig;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdHelperFeed;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.ad.ShakeView;
import com.zenmen.palmchat.ad.VisibleDetectView;
import com.zenmen.palmchat.ad.compliance.AdComInfoAllLayout;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$string;
import com.zenmen.square.databinding.SquareNearbyAdListItemBigpicBinding;
import com.zenmen.square.databinding.SquareNearbyAdListItemMultipicBinding;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class pv1 {
    public static final float[][] f = {new float[]{208.0f, 117.0f}, new float[]{208.0f, 138.0f}};
    public static je1 g = null;
    public static je1 h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qv1 f20100a;
    public NestAdData b;
    public int c;
    public NestAdData d;
    public View e;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements NestAdData.AdInteractionListener {
        public a() {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdClicked(NestAdData nestAdData) {
            vv1.a(nestAdData.getRequestId(), nestAdData, pv1.this.c, pv1.this.f20100a, 0);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdExposed(NestAdData nestAdData) {
            vv1.f(nestAdData.getRequestId(), nestAdData, pv1.this.c, pv1.this.f20100a, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements VisibleDetectView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareNearbyAdListItemBigpicBinding f20102a;

        public b(SquareNearbyAdListItemBigpicBinding squareNearbyAdListItemBigpicBinding) {
            this.f20102a = squareNearbyAdListItemBigpicBinding;
        }

        @Override // com.zenmen.palmchat.ad.VisibleDetectView.d
        public void a(boolean z) {
            if (!z) {
                this.f20102a.p.setVisibility(8);
            } else if (ShakeView.shakeEnabled(pv1.this.d)) {
                this.f20102a.p.setVisibility(0);
                ShakeView.eventShakeShow(pv1.this.d);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l6.k(pv1.this.f20100a.l());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f20104a;

        public d(Runnable runnable) {
            this.f20104a = runnable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f20104a.run();
            AdHelperFeed.INSTANCE.adClose(pv1.this.d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements NestAdData.AppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f20105a;

        public e(TextView textView) {
            this.f20105a = textView;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadComplete(NestAdData nestAdData) {
            this.f20105a.setText(R$string.ad_download_install);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadFailed(NestAdData nestAdData) {
            Toast.makeText(this.f20105a.getContext(), R$string.ad_download_failed, 0).show();
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadInstalled(NestAdData nestAdData) {
            this.f20105a.setText(R$string.ad_download_open);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadPause(NestAdData nestAdData) {
            this.f20105a.setText(R$string.ad_download_resume);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadProgress(NestAdData nestAdData, int i) {
            this.f20105a.setText(R$string.ad_download_pause);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadStart(NestAdData nestAdData) {
            this.f20105a.setText(R$string.ad_download_start);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements NestAdData.AdInteractionListener {
        public f() {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdClicked(NestAdData nestAdData) {
            vv1.a(nestAdData.getRequestId(), nestAdData, pv1.this.c, pv1.this.f20100a, 0);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdExposed(NestAdData nestAdData) {
            vv1.f(nestAdData.getRequestId(), nestAdData, pv1.this.c, pv1.this.f20100a, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements VisibleDetectView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareNearbyAdListItemMultipicBinding f20107a;

        public g(SquareNearbyAdListItemMultipicBinding squareNearbyAdListItemMultipicBinding) {
            this.f20107a = squareNearbyAdListItemMultipicBinding;
        }

        @Override // com.zenmen.palmchat.ad.VisibleDetectView.d
        public void a(boolean z) {
            if (!z) {
                this.f20107a.t.setVisibility(8);
            } else if (ShakeView.shakeEnabled(pv1.this.d)) {
                this.f20107a.t.setVisibility(0);
                ShakeView.eventShakeShow(pv1.this.d);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l6.k(pv1.this.f20100a.l());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f20109a;

        public i(Runnable runnable) {
            this.f20109a = runnable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f20109a.run();
            AdHelperFeed.INSTANCE.adClose(pv1.this.d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements NestAdData.AppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f20110a;

        public j(TextView textView) {
            this.f20110a = textView;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadComplete(NestAdData nestAdData) {
            this.f20110a.setText(R$string.ad_download_install);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadFailed(NestAdData nestAdData) {
            Toast.makeText(this.f20110a.getContext(), R$string.ad_download_failed, 0).show();
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadInstalled(NestAdData nestAdData) {
            this.f20110a.setText(R$string.ad_download_open);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadPause(NestAdData nestAdData) {
            this.f20110a.setText(R$string.ad_download_resume);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadProgress(NestAdData nestAdData, int i) {
            this.f20110a.setText(R$string.ad_download_pause);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadStart(NestAdData nestAdData) {
            this.f20110a.setText(R$string.ad_download_start);
        }
    }

    public pv1(qv1 qv1Var, NestAdData nestAdData, int i2) {
        this.f20100a = qv1Var;
        this.b = nestAdData;
        this.c = i2;
    }

    public static String g(NestAdData nestAdData) {
        List<String> imageList;
        if (nestAdData == null || (imageList = nestAdData.getImageList()) == null || imageList.isEmpty()) {
            return null;
        }
        return imageList.get(0);
    }

    public static boolean k(NestAdData nestAdData) {
        int iIntValue = nestAdData.getAdMode().intValue();
        return iIntValue == 4 || iIntValue == 5;
    }

    public final View d(Context context, Runnable runnable) {
        int i2;
        SquareNearbyAdListItemBigpicBinding squareNearbyAdListItemBigpicBindingB = SquareNearbyAdListItemBigpicBinding.b(LayoutInflater.from(context));
        ViewGroup viewGroupWrapDecorationIfGDT = AdHelperFeed.INSTANCE.wrapDecorationIfGDT((ViewGroup) squareNearbyAdListItemBigpicBindingB.getRoot(), this.d);
        squareNearbyAdListItemBigpicBindingB.r.setFullyVisibleListener(new b(squareNearbyAdListItemBigpicBindingB));
        float nativeAdImgWidth = this.d.getNativeAdImgWidth();
        float nativeAdImgHeight = this.d.getNativeAdImgHeight();
        WifiLog.d("NestAdDataItem->createBigPic img width = " + nativeAdImgWidth + ", height = " + nativeAdImgHeight);
        if (nativeAdImgWidth > 0.0f && nativeAdImgHeight > 0.0f) {
            float f2 = nativeAdImgWidth / nativeAdImgHeight;
            Float fValueOf = null;
            int i3 = 0;
            i2 = 0;
            while (true) {
                float[][] fArr = f;
                if (i3 >= fArr.length) {
                    break;
                }
                float[] fArr2 = fArr[i3];
                float fAbs = Math.abs((fArr2[0] / fArr2[1]) - f2);
                if (fValueOf == null || fAbs < fValueOf.floatValue()) {
                    fValueOf = Float.valueOf(fAbs);
                    i2 = i3;
                }
                i3++;
            }
        } else {
            i2 = 0;
        }
        ViewGroup.LayoutParams layoutParams = squareNearbyAdListItemBigpicBindingB.j.getLayoutParams();
        float[][] fArr3 = f;
        layoutParams.width = me1.a(context, fArr3[i2][0]);
        layoutParams.height = me1.a(context, fArr3[i2][1]);
        squareNearbyAdListItemBigpicBindingB.j.setLayoutParams(layoutParams);
        String adIcon = this.d.getAdIcon();
        if (g == null) {
            g = a46.i(R$drawable.default_portrait);
        }
        gr2 gr2VarJ = gr2.j();
        if (adIcon == null) {
            adIcon = "";
        }
        gr2VarJ.h(adIcon, squareNearbyAdListItemBigpicBindingB.b, g);
        String adAppName = this.d.getAdAppName();
        TextView textView = squareNearbyAdListItemBigpicBindingB.c;
        if (TextUtils.isEmpty(adAppName)) {
            adAppName = context.getString(com.zenmen.palmchat.framework.R$string.ad_moments_name);
        }
        textView.setText(adAppName);
        String title = this.d.getTitle();
        if (!TextUtils.isEmpty(title) && title.equals(this.d.getAdAppName())) {
            title = this.d.getDescription();
        }
        squareNearbyAdListItemBigpicBindingB.m.setText(TextUtils.isEmpty(title) ? context.getString(com.zenmen.palmchat.framework.R$string.ad_moments_default_desc) : title);
        l6.l(this.f20100a.l());
        squareNearbyAdListItemBigpicBindingB.q.setOnClickListener(new c());
        squareNearbyAdListItemBigpicBindingB.g.setOnClickListener(new d(runnable));
        if (WifiNestAd.INSTANCE.getMPersonalizedAd()) {
            squareNearbyAdListItemBigpicBindingB.l.setText(R$string.personalize_ad);
        } else {
            squareNearbyAdListItemBigpicBindingB.l.setText(R$string.common_ad);
        }
        if (h == null) {
            h = a46.i(R$drawable.bg_feed_item_loading);
        }
        if (k(this.d)) {
            View adView = this.d.getAdView();
            if (adView != null) {
                ViewParent parent = adView.getParent();
                boolean z = parent instanceof ViewGroup;
                if (z) {
                    ((ViewGroup) parent).removeView(adView);
                }
                if (parent == null || z) {
                    squareNearbyAdListItemBigpicBindingB.n.addView(adView, new ViewGroup.LayoutParams(-1, -1));
                    AdDownViVoConfig.checkVideoViewClick(this.d, squareNearbyAdListItemBigpicBindingB.n);
                }
            }
        } else {
            String strG = g(this.d);
            gr2 gr2VarJ2 = gr2.j();
            if (strG == null) {
                strG = "";
            }
            gr2VarJ2.h(strG, squareNearbyAdListItemBigpicBindingB.h, h);
        }
        squareNearbyAdListItemBigpicBindingB.i.setImageResource(this.d.getAdLogoResId());
        TextView textView2 = squareNearbyAdListItemBigpicBindingB.f16240a;
        if (this.d.getInteractionType().intValue() == 1) {
            textView2.setText(R$string.ad_download_start);
            this.d.setAppDownloadListener(new e(textView2));
        } else {
            textView2.setText(R$string.ad_show_more);
        }
        this.d.setAdInteractionListener(new f());
        LogUtil.d("", "rrrr FindAdDataItem bigPic getDiscountInfo " + this.d.getDiscountInfo() + " infoSwitch " + f6.f17462a + " title " + title);
        if (TextUtils.isEmpty(this.d.getDiscountInfo()) || !f6.f17462a) {
            squareNearbyAdListItemBigpicBindingB.e.setVisibility(8);
        } else {
            squareNearbyAdListItemBigpicBindingB.e.setVisibility(0);
            squareNearbyAdListItemBigpicBindingB.f.setText(this.d.getDiscountInfo());
        }
        bw3.a(this.d.getRequestId(), "", "", this.d.getAdScene(), this.d);
        AdComInfoAllLayout adComInfoAllLayout = squareNearbyAdListItemBigpicBindingB.d;
        if (adComInfoAllLayout != null) {
            adComInfoAllLayout.initComInfo(this.d);
        }
        AdHelperFeed.INSTANCE.registerViewAndAction(viewGroupWrapDecorationIfGDT, textView2, new View[]{squareNearbyAdListItemBigpicBindingB.getRoot()}, null, null, this.d);
        return viewGroupWrapDecorationIfGDT;
    }

    public final View e(Context context, Runnable runnable) {
        TextView textView;
        SquareNearbyAdListItemMultipicBinding squareNearbyAdListItemMultipicBindingB = SquareNearbyAdListItemMultipicBinding.b(LayoutInflater.from(context));
        AdHelperFeed adHelperFeed = AdHelperFeed.INSTANCE;
        ViewGroup viewGroupWrapDecorationIfGDT = adHelperFeed.wrapDecorationIfGDT((ViewGroup) squareNearbyAdListItemMultipicBindingB.getRoot(), this.d);
        squareNearbyAdListItemMultipicBindingB.t.setShowDesc(false);
        squareNearbyAdListItemMultipicBindingB.v.setFullyVisibleListener(new g(squareNearbyAdListItemMultipicBindingB));
        String adIcon = this.d.getAdIcon();
        if (g == null) {
            g = a46.i(R$drawable.default_portrait);
        }
        gr2 gr2VarJ = gr2.j();
        if (adIcon == null) {
            adIcon = "";
        }
        gr2VarJ.h(adIcon, squareNearbyAdListItemMultipicBindingB.c, g);
        String adAppName = this.d.getAdAppName();
        TextView textView2 = squareNearbyAdListItemMultipicBindingB.d;
        if (TextUtils.isEmpty(adAppName)) {
            adAppName = context.getString(com.zenmen.palmchat.framework.R$string.ad_moments_name);
        }
        textView2.setText(adAppName);
        String title = this.d.getTitle();
        if (!TextUtils.isEmpty(title) && title.equals(this.d.getAdAppName())) {
            title = this.d.getDescription();
        }
        squareNearbyAdListItemMultipicBindingB.r.setText(TextUtils.isEmpty(title) ? context.getString(com.zenmen.palmchat.framework.R$string.ad_moments_default_desc) : title);
        l6.l(this.f20100a.l());
        squareNearbyAdListItemMultipicBindingB.u.setOnClickListener(new h());
        squareNearbyAdListItemMultipicBindingB.j.setOnClickListener(new i(runnable));
        if (WifiNestAd.INSTANCE.getMPersonalizedAd()) {
            squareNearbyAdListItemMultipicBindingB.q.setText(R$string.personalize_ad);
        } else {
            squareNearbyAdListItemMultipicBindingB.q.setText(R$string.common_ad);
        }
        if (h == null) {
            h = a46.i(R$drawable.bg_feed_item_loading);
        }
        List<String> imageList = this.d.getImageList();
        int size = imageList != null ? imageList.size() : 0;
        if (size == 2) {
            String str = imageList.get(0);
            gr2 gr2VarJ2 = gr2.j();
            if (str == null) {
                str = "";
            }
            gr2VarJ2.h(str, squareNearbyAdListItemMultipicBindingB.k, h);
            String str2 = imageList.get(1);
            gr2 gr2VarJ3 = gr2.j();
            if (str2 == null) {
                str2 = "";
            }
            gr2VarJ3.h(str2, squareNearbyAdListItemMultipicBindingB.l, h);
            squareNearbyAdListItemMultipicBindingB.e.setVisibility(0);
            squareNearbyAdListItemMultipicBindingB.n.setImageResource(this.d.getAdLogoResId());
            textView = squareNearbyAdListItemMultipicBindingB.f16241a;
        } else if (size > 2) {
            String str3 = imageList.get(0);
            gr2 gr2VarJ4 = gr2.j();
            if (str3 == null) {
                str3 = "";
            }
            gr2VarJ4.h(str3, squareNearbyAdListItemMultipicBindingB.k, h);
            String str4 = imageList.get(1);
            gr2 gr2VarJ5 = gr2.j();
            if (str4 == null) {
                str4 = "";
            }
            gr2VarJ5.h(str4, squareNearbyAdListItemMultipicBindingB.l, h);
            String str5 = imageList.get(2);
            gr2 gr2VarJ6 = gr2.j();
            if (str5 == null) {
                str5 = "";
            }
            gr2VarJ6.h(str5, squareNearbyAdListItemMultipicBindingB.m, h);
            squareNearbyAdListItemMultipicBindingB.f.setVisibility(0);
            squareNearbyAdListItemMultipicBindingB.o.setImageResource(this.d.getAdLogoResId());
            textView = squareNearbyAdListItemMultipicBindingB.b;
        } else {
            textView = squareNearbyAdListItemMultipicBindingB.f16241a;
        }
        if (this.d.getInteractionType().intValue() == 1) {
            textView.setText(R$string.ad_download_start);
            this.d.setAppDownloadListener(new j(textView));
        } else {
            textView.setText(R$string.ad_show_more);
        }
        this.d.setAdInteractionListener(new a());
        LogUtil.d("", "rrrr FindAdDataItem createMultiPic getDiscountInfo " + this.d.getDiscountInfo() + " infoSwitch " + f6.f17462a + " title " + title);
        if (TextUtils.isEmpty(this.d.getDiscountInfo()) || !f6.f17462a) {
            squareNearbyAdListItemMultipicBindingB.h.setVisibility(8);
        } else {
            squareNearbyAdListItemMultipicBindingB.h.setVisibility(0);
            squareNearbyAdListItemMultipicBindingB.i.setText(this.d.getDiscountInfo());
        }
        AdComInfoAllLayout adComInfoAllLayout = squareNearbyAdListItemMultipicBindingB.g;
        if (adComInfoAllLayout != null) {
            adComInfoAllLayout.initComInfo(this.d);
        }
        adHelperFeed.registerViewAndAction(viewGroupWrapDecorationIfGDT, textView, new View[]{squareNearbyAdListItemMultipicBindingB.getRoot()}, null, null, this.d);
        return viewGroupWrapDecorationIfGDT;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View f(Context context, Runnable runnable) {
        boolean z;
        NestAdData nestAdDataChangeCheckMaxAd;
        if (b6.d() && this.b == null) {
            return this.e;
        }
        NestAdData nestAdData = this.b;
        if (nestAdData.getAdSPStrategy() && (nestAdDataChangeCheckMaxAd = SPCacheManager.INSTANCE.changeCheckMaxAd(this.b)) != null) {
            nestAdData = nestAdDataChangeCheckMaxAd;
        }
        if (nestAdData == this.d) {
            return this.e;
        }
        this.d = nestAdData;
        List<String> imageList = nestAdData.getImageList();
        if (imageList != null) {
            z = imageList.size() > 1;
        }
        View viewE = z ? e(context, runnable) : d(context, runnable);
        this.e = viewE;
        return viewE;
    }

    public qv1 h() {
        return this.f20100a;
    }

    public int i() {
        return this.c;
    }

    public NestAdData j() {
        return this.b;
    }

    public void l() {
        if (!b6.d() || this.b == null) {
            return;
        }
        LogUtil.d("ClearAd", "clearCacheAd77583 FindAdDataItem srcAdData = null");
        SPCacheManager.INSTANCE.destroyOneAd(this.b);
        this.b = null;
    }

    public void m() {
        this.f20100a.t(this.c);
    }
}
