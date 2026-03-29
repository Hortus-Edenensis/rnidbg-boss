package defpackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.compliance.AdDownViVoConfig;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdHelperFeed;
import com.wifi.ad.core.interactive.WkInteractiveManager;
import com.wifi.adsdk.entity.LxAdAbsItem;
import com.wifi.adsdk.nativefeed.LxNativeFeedAd;
import com.zenmen.palmchat.ad.ShakeView;
import com.zenmen.palmchat.ad.compliance.AdComInfoLayoutBase;
import com.zenmen.palmchat.ad.view.AdNestRoundCornerCoverView;
import com.zenmen.palmchat.framework.R$anim;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$string;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class jv3 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements NestAdData.AppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f18516a;
        public final /* synthetic */ View b;
        public final /* synthetic */ boolean c;

        public a(TextView textView, View view, boolean z) {
            this.f18516a = textView;
            this.b = view;
            this.c = z;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadComplete(NestAdData nestAdData) {
            this.f18516a.setText(R$string.ad_download_install);
            View view = this.b;
            if (view == null || view.getVisibility() != 0) {
                return;
            }
            this.b.setVisibility(8);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadFailed(NestAdData nestAdData) {
            View view;
            if (!(nestAdData != null && SDKAlias.LXAD.getType().equals(nestAdData.getAdType()))) {
                Toast.makeText(this.f18516a.getContext(), R$string.ad_download_failed, 0).show();
            }
            if (this.c && (view = this.b) != null) {
                view.setVisibility(0);
            }
            this.f18516a.setText(R$string.ad_download_start2);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadInstalled(NestAdData nestAdData) {
            this.f18516a.setText(R$string.ad_download_open);
            View view = this.b;
            if (view == null || view.getVisibility() != 0) {
                return;
            }
            this.b.setVisibility(8);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadPause(NestAdData nestAdData) {
            this.f18516a.setText(R$string.ad_download_resume);
            View view = this.b;
            if (view == null || view.getVisibility() != 0) {
                return;
            }
            this.b.setVisibility(8);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadProgress(NestAdData nestAdData, int i) {
            this.f18516a.setText(R$string.ad_download_pause);
            View view = this.b;
            if (view == null || view.getVisibility() != 0) {
                return;
            }
            this.b.setVisibility(8);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadStart(NestAdData nestAdData) {
            if (nestAdData != null && SDKAlias.FEISUO.getType().equals(nestAdData.getAdType())) {
                return;
            }
            this.f18516a.setText(R$string.ad_download_start2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ iv3 f18517a;
        public final /* synthetic */ int b;
        public final /* synthetic */ NestAdData c;

        public b(iv3 iv3Var, int i, NestAdData nestAdData) {
            this.f18517a = iv3Var;
            this.b = i;
            this.c = nestAdData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            iv3 iv3Var = this.f18517a;
            if (iv3Var != null && iv3Var.b() != null && this.f18517a.b().a() != null) {
                LogUtil.d("", "NativeType setAdViewData onAdClose scene " + this.b);
                this.f18517a.b().a().a(0, this.f18517a.b().b());
            }
            NestAdData nestAdData = this.c;
            if (nestAdData == null || !(nestAdData.getAdData() instanceof LxAdAbsItem)) {
                return;
            }
            ((LxAdAbsItem) this.c.getAdData()).adRemoveDone();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ iv3 f18518a;
        public final /* synthetic */ int b;
        public final /* synthetic */ NestAdData c;

        public c(iv3 iv3Var, int i, NestAdData nestAdData) {
            this.f18518a = iv3Var;
            this.b = i;
            this.c = nestAdData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            iv3 iv3Var = this.f18518a;
            if (iv3Var != null && iv3Var.b() != null && this.f18518a.b().a() != null) {
                LogUtil.d("", "NativeType setAdViewData adDrop click scene " + this.b);
                this.f18518a.b().a().a(0, this.f18518a.b().b());
            }
            NestAdData nestAdData = this.c;
            if (nestAdData == null || !(nestAdData.getAdData() instanceof LxAdAbsItem)) {
                return;
            }
            ((LxAdAbsItem) this.c.getAdData()).adRemoveDone();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements NestAdData.AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ iv3 f18519a;
        public final /* synthetic */ int b;

        public d(iv3 iv3Var, int i) {
            this.f18519a = iv3Var;
            this.b = i;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdClicked(NestAdData nestAdData) {
            iv3 iv3Var = this.f18519a;
            if (iv3Var == null || iv3Var.b() == null || this.f18519a.b().a() == null) {
                return;
            }
            LogUtil.d("", "NativeType setAdViewData onAdClicked scene " + this.b);
            this.f18519a.b().a().onAdClicked(nestAdData);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdExposed(NestAdData nestAdData) {
            iv3 iv3Var = this.f18519a;
            if (iv3Var == null || iv3Var.b() == null || this.f18519a.b().a() == null) {
                return;
            }
            LogUtil.d("", "NativeType setAdViewData onAdExposed scene " + this.b);
            this.f18519a.b().a().onAdExposed(nestAdData);
        }
    }

    public static void b(NestAdData nestAdData, TextView textView, View view) {
        if (textView == null || nestAdData == null) {
            return;
        }
        boolean z = view != null && view.getVisibility() == 0;
        LogUtil.d("", "NativeType NestNativeUiBase changeActionText action " + textView + " adYaoyiyaoStatus " + z);
        nestAdData.setAdDownTextView(textView);
        if (nestAdData.getInteractionType().intValue() != 1) {
            textView.setText(R$string.ad_show_more);
        } else {
            textView.setText(R$string.ad_download_start2);
            nestAdData.setAppDownloadListener(new a(textView, view, z));
        }
    }

    public static sv3 c(ViewGroup viewGroup, iv3 iv3Var, Float[][] fArr, Context context) {
        sv3 sv3Var = new sv3();
        if (viewGroup != null && iv3Var != null) {
            try {
                LogUtil.d("", "NativeType createViewAdData start adViewGroup " + viewGroup + " scene " + iv3Var.d());
                sv3Var.h0(iv3Var);
                sv3Var.V(context);
                sv3Var.P(viewGroup);
                sv3Var.L(iv3Var.c());
                sv3Var.W((AdNestRoundCornerCoverView) viewGroup.findViewById(R$id.ad_corner_view));
                sv3Var.T((ImageView) viewGroup.findViewById(R$id.ad_bg_blur));
                sv3Var.b0((ImageView) viewGroup.findViewById(R$id.ad_icon));
                sv3Var.S((TextView) viewGroup.findViewById(R$id.ad_app_name));
                sv3Var.H(viewGroup.findViewById(R$id.ad_close));
                sv3Var.j0(viewGroup.findViewById(R$id.zhibo_layout));
                sv3Var.I(viewGroup.findViewById(R$id.ad_drop));
                sv3Var.X((TextView) viewGroup.findViewById(R$id.ad_desc));
                sv3Var.M((TextView) viewGroup.findViewById(R$id.ad_sign));
                sv3Var.K((ImageView) viewGroup.findViewById(R$id.ad_logo));
                sv3Var.G((TextView) viewGroup.findViewById(R$id.ad_action));
                sv3Var.g0(viewGroup.findViewById(R$id.yy_shake_bg));
                sv3Var.J((ImageView) viewGroup.findViewById(R$id.ad_img));
                sv3Var.O((ViewGroup) viewGroup.findViewById(R$id.ad_video));
                sv3Var.U((AdComInfoLayoutBase) viewGroup.findViewById(R$id.ad_com_info_layout));
                sv3Var.R(viewGroup.findViewById(R$id.ad_yaoyiyao));
                sv3Var.Y((ImageView) viewGroup.findViewById(R$id.ad_img1));
                sv3Var.Z((ImageView) viewGroup.findViewById(R$id.ad_img2));
                sv3Var.a0((ImageView) viewGroup.findViewById(R$id.ad_img3));
                sv3Var.f0((ViewGroup) viewGroup.findViewById(R$id.ad_main_layout));
                sv3Var.d0((ViewGroup) viewGroup.findViewById(R$id.ad_img_video_layout));
                sv3Var.N(viewGroup.findViewById(R$id.ad_video_round));
                sv3Var.i0((ViewGroup) viewGroup.findViewById(R$id.ad_down_yaoyiyao_layout));
                sv3Var.c0(fArr);
                sv3Var.e0((FrameLayout) viewGroup.findViewById(R$id.interactive_type_layout));
                LogUtil.d("", "NativeType createViewAdData end adViewGroup " + viewGroup + " scene " + iv3Var.d());
            } catch (Exception e2) {
                LogUtil.d("", "NativeType createViewAdData Exception " + e2.toString() + " scene " + iv3Var.d());
            }
        }
        return sv3Var;
    }

    public static String d(NestAdData nestAdData) {
        List<String> imageList;
        if (nestAdData == null || (imageList = nestAdData.getImageList()) == null || imageList.isEmpty()) {
            return null;
        }
        return imageList.get(0);
    }

    public static void e(NestAdData nestAdData, AdComInfoLayoutBase adComInfoLayoutBase) {
        if (nestAdData == null || adComInfoLayoutBase == null) {
            return;
        }
        adComInfoLayoutBase.initComInfo(nestAdData);
        AdHelperFeed.INSTANCE.setOppoComInfoViews(nestAdData, adComInfoLayoutBase.mPrivacy, adComInfoLayoutBase.mPermission, adComInfoLayoutBase.mFunction);
    }

    public static void f(View view, TextView textView, NestAdData nestAdData) {
        if (view == null || textView == null || nestAdData == null) {
            return;
        }
        if (TextUtils.isEmpty(nestAdData.getDiscountInfo()) || !f6.f17462a) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
            textView.setText(nestAdData.getDiscountInfo());
        }
    }

    public static boolean g(int i) {
        return (i == 56 || i == 57 || i == 78 || i == 83 || i == 42) ? false : true;
    }

    public static boolean h(NestAdData nestAdData) {
        if (nestAdData == null) {
            return false;
        }
        int iIntValue = nestAdData.getAdMode().intValue();
        return iIntValue == 4 || iIntValue == 5;
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x057d  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0620  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i(sv3 sv3Var, NestAdData nestAdData) {
        int i;
        float f2;
        List<String> imageList;
        ImageView imageViewE;
        View viewL;
        TextView textViewA;
        AdComInfoLayoutBase adComInfoLayoutBaseO;
        View viewE;
        FrameLayout frameLayoutA;
        FrameLayout frameLayout;
        boolean z;
        View viewFindViewById;
        ImageView imageViewU;
        ImageView imageViewV;
        ImageView imageViewW;
        Float[][] fArrY;
        float nativeAdImgWidth;
        float nativeAdImgHeight;
        int i2;
        boolean z2;
        EffectiveShapeView effectiveShapeView;
        if (sv3Var == null || nestAdData == null || sv3Var.p() == null) {
            return;
        }
        int adScene = nestAdData.getAdScene();
        boolean z3 = (adScene == 56 || adScene == 57) && nestAdData.getZhiboAd().booleanValue();
        LogUtil.d("", "NativeType setAdViewData start scene " + adScene + " allowZhibo " + z3);
        ArrayList arrayList = new ArrayList();
        if (sv3Var.k() != null) {
            arrayList.add(sv3Var.k());
        }
        iv3 iv3VarD = sv3Var.D();
        Context contextP = sv3Var.p();
        ImageView imageViewX = sv3Var.x();
        if (imageViewX != null) {
            if (g(adScene)) {
                arrayList.add(imageViewX);
            }
            String adIcon = nestAdData.getAdIcon();
            gr2 gr2VarJ = gr2.j();
            if (adIcon == null) {
                adIcon = "";
            }
            gr2VarJ.h(adIcon, imageViewX, a46.i(R$drawable.default_portrait));
        }
        TextView textViewM = sv3Var.m();
        if (textViewM != null) {
            if (g(adScene)) {
                arrayList.add(textViewM);
            }
            String adAppName = nestAdData.getAdAppName();
            if (TextUtils.isEmpty(adAppName)) {
                adAppName = "推荐";
            }
            textViewM.setText(adAppName);
        }
        AdNestRoundCornerCoverView adNestRoundCornerCoverViewQ = sv3Var.q();
        if (adNestRoundCornerCoverViewQ != null && sv3Var.s() > 0.0f) {
            adNestRoundCornerCoverViewQ.setRadius(me1.a(contextP, sv3Var.s()));
            if (!TextUtils.isEmpty(sv3Var.r())) {
                adNestRoundCornerCoverViewQ.setBgColor(sv3Var.r());
            }
        }
        View viewB = sv3Var.b();
        if (viewB != null) {
            viewB.setOnClickListener(new b(iv3VarD, adScene, nestAdData));
        }
        View viewF = sv3Var.F();
        if (viewF != null) {
            arrayList.add(viewF);
        }
        View viewC = sv3Var.c();
        if (viewC != null) {
            viewC.setOnClickListener(new c(iv3VarD, adScene, nestAdData));
        }
        TextView textViewG = sv3Var.g();
        if (textViewG != null) {
            if (WifiNestAd.INSTANCE.getMPersonalizedAd()) {
                textViewG.setText(R$string.personalize_ad);
            } else {
                textViewG.setText(R$string.common_ad);
            }
        }
        TextView textViewT = sv3Var.t();
        if (textViewT != null) {
            arrayList.add(textViewT);
            String description = nestAdData.getDescription();
            if (TextUtils.isEmpty(description)) {
                description = nestAdData.getTitle();
            }
            if (TextUtils.isEmpty(description)) {
                description = contextP.getString(R$string.ad_moments_default_desc);
            }
            textViewT.setText(description);
        }
        float f3 = 0.5625f;
        try {
            fArrY = sv3Var.y();
            Float[][] fArr = {new Float[]{Float.valueOf(16.0f), Float.valueOf(9.0f)}, new Float[]{Float.valueOf(3.0f), Float.valueOf(2.0f)}, new Float[]{Float.valueOf(9.0f), Float.valueOf(16.0f)}};
            nativeAdImgWidth = nestAdData.getNativeAdImgWidth();
            nativeAdImgHeight = nestAdData.getNativeAdImgHeight();
            if (nativeAdImgWidth <= 0.0f || nativeAdImgHeight <= 0.0f) {
                i2 = 0;
                f2 = 0.5625f;
                i = 0;
            } else {
                f3 = nativeAdImgWidth / nativeAdImgHeight;
                Float fValueOf = null;
                int i3 = 0;
                i = 0;
                for (int i4 = 0; i4 < 3; i4++) {
                    try {
                        Float[] fArr2 = fArr[i4];
                        float fAbs = Math.abs((fArr2[0].floatValue() / fArr2[1].floatValue()) - f3);
                        if (fValueOf == null || fAbs < fValueOf.floatValue()) {
                            fValueOf = Float.valueOf(fAbs);
                            i3 = i4;
                            i = i3;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        LogUtil.d("", "NativeType setAdViewData->createBigPic Exception e = " + e.toString() + " scene " + adScene);
                        f2 = f3;
                        int i5 = i;
                        imageList = nestAdData.getImageList();
                        if (imageList != null) {
                        }
                        ImageView imageViewD = sv3Var.d();
                        ViewGroup viewGroupI = sv3Var.i();
                        if (h(nestAdData)) {
                        }
                        imageViewE = sv3Var.e();
                        if (imageViewE != null) {
                        }
                        viewL = sv3Var.l();
                        if (viewL != null) {
                        }
                        textViewA = sv3Var.a();
                        if (textViewA != null) {
                        }
                        adComInfoLayoutBaseO = sv3Var.o();
                        if (adComInfoLayoutBaseO != null) {
                        }
                        nestAdData.setAdInteractionListener(new d(iv3VarD, adScene));
                        ViewGroup viewGroupJ = sv3Var.j();
                        viewE = sv3Var.E();
                        if (viewE != null) {
                        }
                        frameLayoutA = sv3Var.A();
                        if (nestAdData.getInteractionType().intValue() == 1) {
                        }
                        frameLayout = (FrameLayout) viewGroupJ.findViewById(R$id.interactive_type_all_layout);
                        if (iv3VarD == null) {
                        }
                        if (frameLayout != null) {
                        }
                        if (frameLayoutA != null) {
                        }
                        if (!z) {
                        }
                        if (viewE != null) {
                        }
                        LogUtil.d("", "NativeType setAdViewData end scene " + adScene);
                    }
                }
                f2 = f3;
                i2 = i3;
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
        }
        if (z3) {
            if (i2 == 2) {
                try {
                    ImageView imageViewN = sv3Var.n();
                    String adIcon2 = nestAdData.getAdIcon();
                    if (imageViewN == null || TextUtils.isEmpty(adIcon2)) {
                        z2 = false;
                    } else {
                        imageViewN.setVisibility(0);
                        nv3.b(adIcon2, imageViewN);
                        z2 = true;
                    }
                    LogUtil.d("", "NativeType setAdViewData allowZhibo  scene " + adScene + " sizeIndex " + i2 + " allowShowBlurBg " + z2 + " iconurl " + nestAdData.getAdIcon());
                    i2 = 0;
                } catch (Exception e4) {
                    e = e4;
                    f3 = f2;
                    LogUtil.d("", "NativeType setAdViewData->createBigPic Exception e = " + e.toString() + " scene " + adScene);
                    f2 = f3;
                }
            }
            int i52 = i;
            imageList = nestAdData.getImageList();
            if (imageList != null && imageList.size() >= 3) {
                imageViewU = sv3Var.u();
                if (imageViewU != null) {
                    arrayList.add(imageViewU);
                    gr2.j().g(imageList.get(0), imageViewU);
                }
                imageViewV = sv3Var.v();
                if (imageViewV != null) {
                    arrayList.add(imageViewV);
                    gr2.j().g(imageList.get(1), imageViewV);
                }
                imageViewW = sv3Var.w();
                if (imageViewW != null) {
                    arrayList.add(imageViewW);
                    gr2.j().g(imageList.get(2), imageViewW);
                }
            }
            ImageView imageViewD2 = sv3Var.d();
            ViewGroup viewGroupI2 = sv3Var.i();
            if (h(nestAdData)) {
                LogUtil.d("", "NativeType setAdViewData scene " + adScene + " isVideoType ");
                imageViewD2.setVisibility(8);
                viewGroupI2.setVisibility(0);
                arrayList.add(viewGroupI2);
                View adView = nestAdData.getAdView();
                if (adView != null) {
                    ViewParent parent = adView.getParent();
                    boolean z4 = parent instanceof ViewGroup;
                    if (z4) {
                        ((ViewGroup) parent).removeView(adView);
                    }
                    if (parent == null || z4) {
                        LogUtil.d("", "NativeType setAdViewData allowZhibo " + z3 + " isVideoType scene " + adScene);
                        if (z3) {
                            try {
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (me1.b(contextP, 170) * f2), -1);
                                layoutParams.gravity = 17;
                                viewGroupI2.addView(adView, layoutParams);
                            } catch (Exception e5) {
                                LogUtil.d("", "NativeType setAdViewData Exception " + e5.toString() + " isVideoType scene " + adScene);
                            }
                        } else {
                            viewGroupI2.addView(adView, new ViewGroup.LayoutParams(-1, -1));
                        }
                        AdDownViVoConfig.checkVideoViewClick(nestAdData, viewGroupI2);
                    }
                }
            } else if (imageViewD2 != null) {
                arrayList.add(imageViewD2);
                imageViewD2.setVisibility(0);
                viewGroupI2.setVisibility(8);
                String strD = d(nestAdData);
                LogUtil.d("", "NativeType setAdViewData scene " + adScene + " imgUrl " + strD);
                gr2 gr2VarJ2 = gr2.j();
                if (strD == null) {
                    strD = "";
                }
                gr2VarJ2.g(strD, imageViewD2);
            }
            imageViewE = sv3Var.e();
            if (imageViewE != null) {
                imageViewE.setImageResource(nestAdData.getAdLogoResId());
            }
            viewL = sv3Var.l();
            if (viewL != null) {
                if (ShakeView.shakeEnabled(nestAdData)) {
                    viewL.setVisibility(0);
                    if (adScene != 6) {
                        j(sv3Var.C());
                    }
                } else {
                    viewL.setVisibility(8);
                }
            }
            textViewA = sv3Var.a();
            if (textViewA != null) {
                b(nestAdData, textViewA, viewL);
            }
            adComInfoLayoutBaseO = sv3Var.o();
            if (adComInfoLayoutBaseO != null) {
                arrayList.add(adComInfoLayoutBaseO);
                e(nestAdData, adComInfoLayoutBaseO);
            }
            nestAdData.setAdInteractionListener(new d(iv3VarD, adScene));
            ViewGroup viewGroupJ2 = sv3Var.j();
            viewE = sv3Var.E();
            if (viewE != null) {
                arrayList.add(viewE);
            }
            frameLayoutA = sv3Var.A();
            boolean z5 = nestAdData.getInteractionType().intValue() == 1;
            frameLayout = (FrameLayout) viewGroupJ2.findViewById(R$id.interactive_type_all_layout);
            z = (iv3VarD == null || iv3VarD.e()) ? false : true;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            if (frameLayoutA != null) {
                frameLayoutA.setVisibility(8);
            }
            if (!z) {
                nestAdData.setInteractiveType(0);
            } else if (frameLayoutA != null) {
                frameLayoutA.setVisibility(8);
                int interactiveStatus = iv3VarD != null ? nestAdData.getInteractiveStatus() : 0;
                LogUtil.d("", "NativeType adData scene " + adScene + " interactiveStatus " + interactiveStatus);
                if (interactiveStatus == 0) {
                    WkInteractiveManager.addInteractiveView(frameLayoutA, nestAdData, i52, z5, nv3.c(nestAdData.getAdScene()));
                    if (frameLayout != null) {
                        frameLayout.setVisibility(8);
                        if (frameLayoutA.getVisibility() == 0) {
                            frameLayout.setVisibility(0);
                            if (iv3VarD != null) {
                                nestAdData.setInteractiveStatus(1);
                            }
                        } else if (iv3VarD != null) {
                            nestAdData.setInteractiveStatus(-1);
                        }
                    }
                } else if (interactiveStatus != -1 && interactiveStatus == 1) {
                    if (frameLayout != null) {
                        frameLayout.setVisibility(0);
                    }
                    frameLayoutA.setVisibility(0);
                }
            }
            if (viewE != null) {
                if (sv3Var.f() != null) {
                    viewGroupJ2 = sv3Var.f();
                }
                if (nestAdData.getZhiboAd().booleanValue() && (viewFindViewById = viewGroupJ2.findViewById(R$id.zhibo_layout)) != null) {
                    viewE = viewFindViewById;
                }
                k(nestAdData, viewGroupJ2, viewE, arrayList, sv3Var.p());
            }
            LogUtil.d("", "NativeType setAdViewData end scene " + adScene);
        }
        z2 = false;
        LogUtil.d("", "NativeType setAdViewData->createBigPic img width = " + nativeAdImgWidth + ", height = " + nativeAdImgHeight + " scene " + adScene + " sizeIndex " + i2 + " zhibowhscale " + f2);
        ViewGroup viewGroupZ = sv3Var.z();
        if (viewGroupZ != null) {
            arrayList.add(viewGroupZ);
            if (adScene == 6) {
                if (nestAdData.getImageList() != null && nestAdData.getImageList().size() > 0) {
                    nv3.b(nestAdData.getImageList().get(0), sv3Var.n());
                }
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) viewGroupZ.getLayoutParams();
                if (i2 == 0 || i2 == 1) {
                    if (sv3Var.D() != null && sv3Var.D().b() != null) {
                        sv3Var.D().b().c = false;
                    }
                    layoutParams2.width = -1;
                    layoutParams2.height = me1.a(contextP, fArrY[i2][1].floatValue());
                    if (i2 == 0) {
                        layoutParams2.topMargin = me1.b(contextP, 92);
                    } else if (i2 == 1) {
                        layoutParams2.topMargin = me1.b(contextP, 110);
                    }
                } else {
                    if (sv3Var.D() != null && sv3Var.D().b() != null) {
                        sv3Var.D().b().c = true;
                    }
                    int i6 = qv3.f20331a;
                    if (i6 > 0) {
                        layoutParams2.height = -1;
                        layoutParams2.width = i6;
                        layoutParams2.gravity = 1;
                    }
                }
                viewGroupZ.setLayoutParams(layoutParams2);
            } else {
                ImageView imageViewN2 = sv3Var.n();
                if (imageViewN2 != null) {
                    arrayList.add(imageViewN2);
                }
                ViewGroup viewGroupZ2 = sv3Var.z();
                if (imageViewN2 != null && viewGroupZ2 != null) {
                    if (i2 == 2) {
                        imageViewN2.setVisibility(0);
                        ViewGroup.LayoutParams layoutParams3 = viewGroupZ2.getLayoutParams();
                        layoutParams3.width = me1.a(contextP, fArrY[2][0].floatValue());
                        layoutParams3.height = me1.a(contextP, fArrY[2][1].floatValue());
                        viewGroupZ2.setLayoutParams(layoutParams3);
                        if (nestAdData.getImageList() != null && nestAdData.getImageList().size() > 0) {
                            nv3.b(nestAdData.getImageList().get(0), imageViewN2);
                        }
                        if (adScene == 56 || adScene == 57) {
                            ImageView imageViewD3 = sv3Var.d();
                            if ((imageViewD3 instanceof EffectiveShapeView) && (effectiveShapeView = (EffectiveShapeView) imageViewD3) != null) {
                                effectiveShapeView.setDegreeForRoundRectangle(0, 0);
                            }
                            View viewH = sv3Var.h();
                            if (viewH != null) {
                                viewH.setVisibility(8);
                            }
                        }
                        i2 = 1;
                    } else if (!z2) {
                        imageViewN2.setVisibility(8);
                    }
                }
                ViewGroup viewGroupB = sv3Var.B();
                if (viewGroupB != null) {
                    ViewGroup.LayoutParams layoutParams4 = viewGroupB.getLayoutParams();
                    if (fArrY[i2][0].floatValue() == -1.0f) {
                        layoutParams4.width = -1;
                    } else {
                        layoutParams4.width = me1.a(contextP, fArrY[i2][0].floatValue());
                    }
                    if (fArrY[i2][1].floatValue() == -1.0f) {
                        layoutParams4.height = -1;
                    } else {
                        layoutParams4.height = me1.a(contextP, fArrY[i2][1].floatValue());
                    }
                    viewGroupB.setLayoutParams(layoutParams4);
                }
            }
        }
        int i522 = i;
        imageList = nestAdData.getImageList();
        if (imageList != null) {
            imageViewU = sv3Var.u();
            if (imageViewU != null) {
            }
            imageViewV = sv3Var.v();
            if (imageViewV != null) {
            }
            imageViewW = sv3Var.w();
            if (imageViewW != null) {
            }
        }
        ImageView imageViewD22 = sv3Var.d();
        ViewGroup viewGroupI22 = sv3Var.i();
        if (h(nestAdData)) {
        }
        imageViewE = sv3Var.e();
        if (imageViewE != null) {
        }
        viewL = sv3Var.l();
        if (viewL != null) {
        }
        textViewA = sv3Var.a();
        if (textViewA != null) {
        }
        adComInfoLayoutBaseO = sv3Var.o();
        if (adComInfoLayoutBaseO != null) {
        }
        nestAdData.setAdInteractionListener(new d(iv3VarD, adScene));
        ViewGroup viewGroupJ22 = sv3Var.j();
        viewE = sv3Var.E();
        if (viewE != null) {
        }
        frameLayoutA = sv3Var.A();
        if (nestAdData.getInteractionType().intValue() == 1) {
        }
        frameLayout = (FrameLayout) viewGroupJ22.findViewById(R$id.interactive_type_all_layout);
        if (iv3VarD == null) {
        }
        if (frameLayout != null) {
        }
        if (frameLayoutA != null) {
        }
        if (!z) {
        }
        if (viewE != null) {
        }
        LogUtil.d("", "NativeType setAdViewData end scene " + adScene);
    }

    public static void j(View view) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        view.addOnAttachStateChangeListener(new e());
    }

    public static void k(NestAdData nestAdData, ViewGroup viewGroup, View view, ArrayList<View> arrayList, Context context) {
        LogUtil.d("", "NativeType showAdByAdHelper adGroup " + viewGroup);
        if (nestAdData == null || viewGroup == null || view == null) {
            return;
        }
        bw3.a(nestAdData.getRequestId(), "", "", nestAdData.getAdScene(), nestAdData);
        View[] viewArr = {viewGroup};
        try {
            if (nestAdData.getAdType().equals(SDKAlias.GDT.getType()) && arrayList != null) {
                viewArr = (View[]) arrayList.toArray(new View[arrayList.size()]);
            }
        } catch (Exception unused) {
        }
        View[] viewArr2 = viewArr;
        if (nestAdData.getAdData() != null && (nestAdData.getAdData() instanceof LxNativeFeedAd)) {
            LxNativeFeedAd lxNativeFeedAd = (LxNativeFeedAd) nestAdData.getAdData();
            if (context instanceof Activity) {
                lxNativeFeedAd.setShowAct((Activity) context);
            }
        }
        AdHelperFeed.INSTANCE.registerViewAndAction(viewGroup, view, viewArr2, null, null, nestAdData, arrayList);
    }

    public static void l(View view) {
        if (view.getAnimation() != null) {
            view.getAnimation().cancel();
        }
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(view.getContext(), R$anim.nest_ad_shake_bg);
        animationLoadAnimation.setInterpolator(new CycleInterpolator(5.0f));
        animationLoadAnimation.setDuration(com.igexin.push.config.c.j);
        view.startAnimation(animationLoadAnimation);
        animationLoadAnimation.setAnimationListener(new f(view, animationLoadAnimation));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            jv3.l(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f18520a;
        public final /* synthetic */ Animation b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                fVar.f18520a.startAnimation(fVar.b);
            }
        }

        public f(View view, Animation animation) {
            this.f18520a = view;
            this.b = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f18520a.postDelayed(new a(), 1000L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
