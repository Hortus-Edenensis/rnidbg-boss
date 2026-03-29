package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.compliance.AdDownViVoConfig;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdHelperFeed;
import com.wifi.ad.core.listener.DislikeListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.self.ad.NestWifiNativeView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.ad.ShakeView;
import com.zenmen.palmchat.ad.VisibleDetectView;
import com.zenmen.palmchat.ad.compliance.AdComInfoAllLayoutLine;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.LXPortraitView;
import defpackage.zv3;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class l10 extends SimpleChatViewAdapter {
    public boolean i = false;
    public iv3 j = null;
    public final float[][] k = {new float[]{208.0f, 117.0f}, new float[]{208.0f, 138.0f}, new float[]{135.0f, 240.0f}};
    public je1 l = null;
    public je1 m = null;
    public Activity n;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f18872a;

        public a(MessageVo messageVo) {
            this.f18872a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatterAdapter.h hVarE = l10.this.E();
            AdHelperFeed.INSTANCE.adClose(this.f18872a.nestAdData);
            if (hVarE != null) {
                hVarE.S(this.f18872a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements NestAdData.AppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a6 f18873a;

        public b(a6 a6Var) {
            this.f18873a = a6Var;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadComplete(NestAdData nestAdData) {
            this.f18873a.D.setText(R.string.ad_download_install);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadFailed(NestAdData nestAdData) {
            Toast.makeText(l10.this.f, R.string.ad_download_failed, 0).show();
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadInstalled(NestAdData nestAdData) {
            this.f18873a.D.setText(R.string.ad_download_open);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadPause(NestAdData nestAdData) {
            this.f18873a.D.setText(R.string.ad_download_resume);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadProgress(NestAdData nestAdData, int i) {
            this.f18873a.D.setText(R.string.ad_download_pause);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadStart(NestAdData nestAdData) {
            this.f18873a.D.setText(R.string.ad_download_start);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements NestAdData.AdInteractionListener {
        public c() {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdClicked(NestAdData nestAdData) {
            h6.a(nestAdData.getRequestId(), "LX-40038", zv3.o(), 62, nestAdData);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdExposed(NestAdData nestAdData) {
            h6.h(nestAdData.getRequestId(), "LX-40038", zv3.o(), 62, nestAdData);
            zv3.k = true;
            l6.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements on2 {
        public d() {
        }

        @Override // defpackage.on2
        public void a(int i, Object obj) {
            if (obj instanceof MessageVo) {
                MessageVo messageVo = (MessageVo) obj;
                ChatterAdapter.h hVarE = l10.this.E();
                AdHelperFeed.INSTANCE.adClose(messageVo.nestAdData);
                if (hVarE != null) {
                    hVarE.S(messageVo);
                }
            }
        }

        @Override // defpackage.on2
        public void onAdClicked(NestAdData nestAdData) {
            h6.a(nestAdData.getRequestId(), "LX-40038", zv3.o(), 67, nestAdData);
        }

        @Override // defpackage.on2
        public void onAdExposed(NestAdData nestAdData) {
            h6.h(nestAdData.getRequestId(), "LX-40038", zv3.o(), 67, nestAdData);
            zv3.m = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements VisibleDetectView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NestAdData f18876a;
        public final /* synthetic */ a6 b;

        public e(NestAdData nestAdData, a6 a6Var) {
            this.f18876a = nestAdData;
            this.b = a6Var;
        }

        @Override // com.zenmen.palmchat.ad.VisibleDetectView.d
        public void a(boolean z) {
            if (!z) {
                this.b.G.setVisibility(8);
            } else if (ShakeView.shakeEnabled(this.f18876a)) {
                this.b.G.setVisibility(0);
                ShakeView.eventShakeShow(this.f18876a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements VisibleDetectView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NestAdData f18877a;
        public final /* synthetic */ a6 b;

        public f(NestAdData nestAdData, a6 a6Var) {
            this.f18877a = nestAdData;
            this.b = a6Var;
        }

        @Override // com.zenmen.palmchat.ad.VisibleDetectView.d
        public void a(boolean z) {
            if (!z) {
                this.b.G.setVisibility(8);
            } else if (ShakeView.shakeEnabled(this.f18877a)) {
                this.b.G.setVisibility(0);
                ShakeView.eventShakeShow(this.f18877a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements NestAdData.AdInteractionListener {
        public g() {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdClicked(NestAdData nestAdData) {
            h6.a(nestAdData.getRequestId(), "LX-40038", zv3.o(), 63, nestAdData);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdExposed(NestAdData nestAdData) {
            h6.h(nestAdData.getRequestId(), "LX-40038", zv3.o(), 63, nestAdData);
            zv3.o = true;
            l6.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f18879a;

        public h(MessageVo messageVo) {
            this.f18879a = messageVo;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatterAdapter.h hVarE = l10.this.E();
            if (hVarE != null) {
                hVarE.S(this.f18879a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements DislikeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f18880a;

        public i(Runnable runnable) {
            this.f18880a = runnable;
        }

        @Override // com.wifi.ad.core.listener.DislikeListener
        public void onDislikeClicked(NestAdData nestAdData, String str) {
            this.f18880a.run();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f18881a;

        public j(MessageVo messageVo) {
            this.f18881a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatterAdapter.h hVarE = l10.this.E();
            AdHelperFeed.INSTANCE.adClose(this.f18881a.nestAdData);
            if (hVarE != null) {
                hVarE.S(this.f18881a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements NestAdData.AppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a6 f18882a;

        public k(a6 a6Var) {
            this.f18882a = a6Var;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadComplete(NestAdData nestAdData) {
            this.f18882a.D.setText(R.string.ad_download_install);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadFailed(NestAdData nestAdData) {
            Toast.makeText(l10.this.f, R.string.ad_download_failed, 0).show();
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadInstalled(NestAdData nestAdData) {
            this.f18882a.D.setText(R.string.ad_download_open);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadPause(NestAdData nestAdData) {
            this.f18882a.D.setText(R.string.ad_download_resume);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadProgress(NestAdData nestAdData, int i) {
            this.f18882a.D.setText(R.string.ad_download_pause);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadStart(NestAdData nestAdData) {
            this.f18882a.D.setText(R.string.ad_download_start);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements NestAdData.AdInteractionListener {
        public l() {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdClicked(NestAdData nestAdData) {
            h6.a(nestAdData.getRequestId(), "LX-40038", zv3.o(), 67, nestAdData);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdExposed(NestAdData nestAdData) {
            h6.h(nestAdData.getRequestId(), "LX-40038", zv3.o(), 67, nestAdData);
            zv3.m = true;
            l6.a();
        }
    }

    public static String D(NestAdData nestAdData) {
        List<String> imageList;
        if (nestAdData == null || (imageList = nestAdData.getImageList()) == null || imageList.isEmpty()) {
            return null;
        }
        return imageList.get(0);
    }

    public static boolean F(View view, LinearLayout linearLayout) {
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
        linearLayout.setGravity(1);
        linearLayout.addView(view, new ViewGroup.LayoutParams(-2, -2));
        return true;
    }

    public static boolean G(NestAdData nestAdData) {
        if (nestAdData.getAdMode() != null) {
            return nestAdData.getAdMode().intValue() == 4 || nestAdData.getAdMode().intValue() == 5;
        }
        return false;
    }

    public final void A(a6 a6Var, MessageVo messageVo, NestAdData nestAdData) {
        String adAppName = nestAdData.getAdAppName();
        TextView textView = a6Var.v;
        if (TextUtils.isEmpty(adAppName)) {
            adAppName = this.f.getString(R.string.ad_moments_name);
        }
        textView.setText(adAppName);
        String description = nestAdData.getDescription();
        TextView textView2 = a6Var.w;
        if (TextUtils.isEmpty(description)) {
            description = this.f.getString(R.string.ad_moments_default_desc);
        }
        textView2.setText(description);
        a6Var.x.setOnClickListener(new j(messageVo));
        if (WifiNestAd.INSTANCE.getMPersonalizedAd()) {
            a6Var.y.setText(R.string.personalize_ad);
        } else {
            a6Var.y.setText(R.string.common_ad);
        }
        if (this.m == null) {
            this.m = a46.i(R.drawable.bg_feed_item_loading);
        }
        a6Var.A.removeAllViews();
        if (G(nestAdData)) {
            a6Var.z.setVisibility(0);
            a6Var.B.setVisibility(8);
            View adView = nestAdData.getAdView();
            if (adView != null) {
                ViewParent parent = adView.getParent();
                boolean z = parent instanceof ViewGroup;
                if (z) {
                    ((ViewGroup) parent).removeView(adView);
                }
                if (parent == null || z) {
                    a6Var.A.addView(adView, new ViewGroup.LayoutParams(-1, -1));
                    AdDownViVoConfig.checkVideoViewClick(nestAdData, a6Var.A);
                }
            }
        } else {
            a6Var.z.setVisibility(8);
            a6Var.B.setVisibility(0);
            String strD = D(nestAdData);
            gr2 gr2VarJ = gr2.j();
            if (strD == null) {
                strD = "";
            }
            gr2VarJ.h(strD, a6Var.B, this.m);
        }
        a6Var.C.setImageResource(nestAdData.getAdLogoResId());
        if (nestAdData.getInteractionType() == null || nestAdData.getInteractionType().intValue() != 1) {
            a6Var.D.setText(R.string.ad_show_more);
        } else {
            a6Var.D.setText(R.string.ad_download_start);
            nestAdData.setAppDownloadListener(new k(a6Var));
        }
        l lVar = new l();
        nestAdData.setAdInteractionListener(lVar);
        AdHelperFeed adHelperFeed = AdHelperFeed.INSTANCE;
        View view = a6Var.t;
        adHelperFeed.registerViewAndAction((ViewGroup) view, a6Var.D, new View[]{view}, null, null, nestAdData);
        if (SDKAlias.WIFI.getType().equals(nestAdData.getAdType())) {
            NestWifiNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
            lVar.onAdExposed(nestAdData);
        }
        AdComInfoAllLayoutLine adComInfoAllLayoutLine = a6Var.E;
        if (adComInfoAllLayoutLine != null) {
            adComInfoAllLayoutLine.initComInfo(nestAdData);
        }
    }

    public final void B(a6 a6Var, MessageVo messageVo, NestAdData nestAdData) {
        g gVar = new g();
        LinearLayout linearLayout = new LinearLayout(this.f);
        int iB = me1.b(this.f, 12);
        linearLayout.setPadding(0, iB, 0, iB);
        linearLayout.setBackground(this.f.getDrawable(R.drawable.chat_template_ad_bg));
        h hVar = new h(messageVo);
        zv3.d dVar = zv3.i;
        if (dVar != null) {
            dVar.b(gVar);
        }
        zv3.e eVar = zv3.h;
        if (eVar != null) {
            eVar.b(new i(hVar));
        }
        WifiNestAd.INSTANCE.createAdFeed().showTemplateFeedAd(linearLayout, nestAdData, this.n);
        linearLayout.removeAllViews();
        if (!F(nestAdData.getAdView(), linearLayout)) {
            h6.f("LX-40038", zv3.o(), 8);
        } else {
            a6Var.s.removeAllViews();
            a6Var.s.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public final void C(Context context, NestAdData nestAdData, ViewGroup viewGroup, Object obj) {
        if (context == null || nestAdData == null || viewGroup == null) {
            return;
        }
        iv3 iv3Var = new iv3(67, nestAdData, new cv3(null, new d()));
        this.j = iv3Var;
        View viewD = nv3.d(iv3Var, context);
        if (viewD instanceof ViewGroup) {
            LogUtil.d("", "CHATAD createNativeStyle2 viewAd " + viewD);
            this.j.b().d(obj);
            viewGroup.removeAllViews();
            viewGroup.addView(viewD);
            nv3.a(this.j, this.f, (ViewGroup) viewD);
        }
    }

    public ChatterAdapter.h E() {
        return r().o();
    }

    public void H(Activity activity) {
        this.n = activity;
    }

    @Override // defpackage.o40
    public int a() {
        return 45;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (36 != messageVo.mimeType) {
            return null;
        }
        if (messageVo.adType != 2) {
            return this.e.inflate(R.layout.list_item_chat_ad_card, (ViewGroup) null);
        }
        if (!n6.a() || n6.b(67) != n6.c) {
            return this.e.inflate(R.layout.list_item_chat_ad_card_2, (ViewGroup) null);
        }
        this.i = true;
        return new FrameLayout(this.f);
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new a6(this.f, view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 1;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        y(messageVo, (a6) t);
    }

    @Override // defpackage.o40
    public int m(boolean z, int i2, MessageVo messageVo) {
        return i2 == 36 ? 45 : -1;
    }

    public void y(MessageVo messageVo, a6 a6Var) {
        NestAdData nestAdData;
        NestAdData nestAdDataChangeCheckMaxAd;
        if (messageVo == null || (nestAdData = messageVo.nestAdData) == null) {
            return;
        }
        if (nestAdData.getAdSPStrategy() && (nestAdDataChangeCheckMaxAd = SPCacheManager.INSTANCE.changeCheckMaxAd(nestAdData)) != null) {
            nestAdData = nestAdDataChangeCheckMaxAd;
        }
        int i2 = messageVo.adType;
        if (i2 == 1) {
            a6Var.r.setVisibility(8);
            a6Var.s.setVisibility(0);
            B(a6Var, messageVo, nestAdData);
            a6Var.F.setFullyVisibleListener(null);
            return;
        }
        if (i2 != 2) {
            a6Var.r.setVisibility(0);
            a6Var.s.setVisibility(8);
            z(a6Var, messageVo, nestAdData);
            a6Var.F.setFullyVisibleListener(new f(nestAdData, a6Var));
            return;
        }
        if (this.i) {
            C(this.f, nestAdData, (ViewGroup) a6Var.t, messageVo);
            return;
        }
        a6Var.r.setVisibility(0);
        a6Var.s.setVisibility(8);
        A(a6Var, messageVo, nestAdData);
        a6Var.F.setFullyVisibleListener(new e(nestAdData, a6Var));
    }

    public final void z(a6 a6Var, MessageVo messageVo, NestAdData nestAdData) {
        int i2;
        float nativeAdImgWidth = nestAdData.getNativeAdImgWidth();
        float nativeAdImgHeight = nestAdData.getNativeAdImgHeight();
        WifiLog.d("ChatVideoAd in bind img width = " + nativeAdImgWidth + ", height = " + nativeAdImgHeight);
        if (nativeAdImgWidth > 0.0f && nativeAdImgHeight > 0.0f) {
            float f2 = nativeAdImgWidth / nativeAdImgHeight;
            Float fValueOf = null;
            int i3 = 0;
            i2 = 0;
            while (true) {
                float[][] fArr = this.k;
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
        a6Var.u.setLayoutParams(new LinearLayout.LayoutParams(me1.a(this.f, this.k[i2][0]), me1.a(this.f, this.k[i2][1])));
        String adIcon = nestAdData.getAdIcon();
        if (this.l == null) {
            this.l = a46.i(R.drawable.default_portrait);
        }
        LXPortraitView lXPortraitView = a6Var.i;
        if (adIcon == null) {
            adIcon = "";
        }
        lXPortraitView.setAvatarView(adIcon, null);
        String adAppName = nestAdData.getAdAppName();
        TextView textView = a6Var.v;
        if (TextUtils.isEmpty(adAppName)) {
            adAppName = this.f.getString(R.string.ad_moments_name);
        }
        textView.setText(adAppName);
        String description = nestAdData.getDescription();
        TextView textView2 = a6Var.w;
        if (TextUtils.isEmpty(description)) {
            description = this.f.getString(R.string.ad_moments_default_desc);
        }
        textView2.setText(description);
        a6Var.x.setOnClickListener(new a(messageVo));
        if (WifiNestAd.INSTANCE.getMPersonalizedAd()) {
            a6Var.y.setText(R.string.personalize_ad);
        } else {
            a6Var.y.setText(R.string.common_ad);
        }
        if (this.m == null) {
            this.m = a46.i(R.drawable.bg_feed_item_loading);
        }
        a6Var.A.removeAllViews();
        if (G(nestAdData)) {
            a6Var.z.setVisibility(0);
            a6Var.B.setVisibility(8);
            View adView = nestAdData.getAdView();
            if (adView != null) {
                ViewParent parent = adView.getParent();
                boolean z = parent instanceof ViewGroup;
                if (z) {
                    ((ViewGroup) parent).removeView(adView);
                }
                if (parent == null || z) {
                    a6Var.A.addView(adView, new ViewGroup.LayoutParams(-1, -1));
                    AdDownViVoConfig.checkVideoViewClick(nestAdData, a6Var.A);
                }
            }
        } else {
            a6Var.z.setVisibility(8);
            a6Var.B.setVisibility(0);
            String strD = D(nestAdData);
            gr2.j().h(strD != null ? strD : "", a6Var.B, this.m);
        }
        a6Var.C.setImageResource(nestAdData.getAdLogoResId());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#B3000000"));
        gradientDrawable.setCornerRadius(me1.b(this.f, 100));
        gradientDrawable.setStroke(me1.a(this.f, 0.5f), Color.parseColor("#99FFFFFF"));
        a6Var.D.setBackgroundDrawable(gradientDrawable);
        a6Var.D.setTextColor(Color.parseColor("#FFFFFF"));
        if (nestAdData.getInteractionType() == null || nestAdData.getInteractionType().intValue() != 1) {
            a6Var.D.setText(R.string.ad_show_more);
        } else {
            a6Var.D.setText(R.string.ad_download_start);
            nestAdData.setAppDownloadListener(new b(a6Var));
        }
        c cVar = new c();
        nestAdData.setAdInteractionListener(cVar);
        AdHelperFeed adHelperFeed = AdHelperFeed.INSTANCE;
        View view = a6Var.t;
        adHelperFeed.registerViewAndAction((ViewGroup) view, a6Var.D, new View[]{view}, null, null, nestAdData);
        if (SDKAlias.WIFI.getType().equals(nestAdData.getAdType())) {
            NestWifiNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
            cVar.onAdExposed(nestAdData);
        }
        AdComInfoAllLayoutLine adComInfoAllLayoutLine = a6Var.E;
        if (adComInfoAllLayoutLine != null) {
            adComInfoAllLayoutLine.initComInfo(nestAdData);
        }
    }
}
