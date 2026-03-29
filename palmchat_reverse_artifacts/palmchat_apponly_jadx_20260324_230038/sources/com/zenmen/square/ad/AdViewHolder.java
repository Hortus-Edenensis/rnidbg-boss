package com.zenmen.square.ad;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager.widget.PagerAdapter;
import com.huawei.hms.framework.common.ContainerUtils;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.compliance.AdDownViVoConfig;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.feedbanner.ClearLogoNativeAdContainer;
import com.wifi.ad.core.helper.AdHelperFeed;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.self.ad.NestWifiNativeView;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.palmchat.ad.ShakeView;
import com.zenmen.palmchat.ad.VisibleDetectView;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$string;
import com.zenmen.square.databinding.SquareGenericListItemAdBinding;
import com.zenmen.square.databinding.SquareGenericListItemAdGroupItemBinding;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.a46;
import defpackage.bw3;
import defpackage.c6;
import defpackage.f6;
import defpackage.fn1;
import defpackage.gr2;
import defpackage.je1;
import defpackage.l6;
import defpackage.me1;
import defpackage.wh5;
import defpackage.zt1;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class AdViewHolder extends BaseViewHolder<SquareFeed, SquareGenericListItemAdBinding, zt1> {
    public static final float[][] i = {new float[]{208.0f, 117.0f}, new float[]{208.0f, 138.0f}, new float[]{135.0f, 240.0f}};
    public static je1 j = null;
    public static je1 k = null;
    public int f;
    public c6 g;
    public NestAdData h;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements VisibleDetectView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NestAdData f16165a;

        public b(NestAdData nestAdData) {
            this.f16165a = nestAdData;
        }

        @Override // com.zenmen.palmchat.ad.VisibleDetectView.d
        public void a(boolean z) {
            if (!z) {
                ((SquareGenericListItemAdBinding) AdViewHolder.this.d).w.setVisibility(8);
            } else if (ShakeView.shakeEnabled(this.f16165a)) {
                ((SquareGenericListItemAdBinding) AdViewHolder.this.d).w.setVisibility(0);
                ShakeView.eventShakeShow(this.f16165a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements VisibleDetectView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NestAdData f16166a;

        public c(NestAdData nestAdData) {
            this.f16166a = nestAdData;
        }

        @Override // com.zenmen.palmchat.ad.VisibleDetectView.d
        public void a(boolean z) {
            if (!z) {
                ((SquareGenericListItemAdBinding) AdViewHolder.this.d).x.setVisibility(8);
            } else if (ShakeView.shakeEnabled(this.f16166a)) {
                ((SquareGenericListItemAdBinding) AdViewHolder.this.d).x.setVisibility(0);
                ShakeView.eventShakeShow(this.f16166a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16167a;

        public d(int i) {
            this.f16167a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l6.k(this.f16167a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16168a;
        public final /* synthetic */ SquareFeed b;

        public e(int i, SquareFeed squareFeed) {
            this.f16168a = i;
            this.b = squareFeed;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((zt1) AdViewHolder.this.e).l(this.f16168a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends PagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NestAdData f16169a;

        public f(NestAdData nestAdData) {
            this.f16169a = nestAdData;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (isViewFromObject(childAt, obj)) {
                    viewGroup.removeView(childAt);
                    return;
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            SquareGenericListItemAdGroupItemBinding squareGenericListItemAdGroupItemBindingB = SquareGenericListItemAdGroupItemBinding.b(LayoutInflater.from(viewGroup.getContext()));
            List<String> imageList = this.f16169a.getImageList();
            String str = imageList.get(i % imageList.size());
            gr2 gr2VarJ = gr2.j();
            if (str == null) {
                str = "";
            }
            gr2VarJ.h(str, squareGenericListItemAdGroupItemBindingB.f16238a, AdViewHolder.k);
            View root = squareGenericListItemAdGroupItemBindingB.getRoot();
            viewGroup.addView(root);
            return root;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements NestAdData.AppDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f16170a;

        public g(TextView textView) {
            this.f16170a = textView;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadComplete(NestAdData nestAdData) {
            this.f16170a.setText(R$string.ad_download_install);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadFailed(NestAdData nestAdData) {
            Toast.makeText(this.f16170a.getContext(), R$string.ad_download_failed, 0).show();
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadInstalled(NestAdData nestAdData) {
            this.f16170a.setText(R$string.ad_download_open);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadPause(NestAdData nestAdData) {
            this.f16170a.setText(R$string.ad_download_resume);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadProgress(NestAdData nestAdData, int i) {
            this.f16170a.setText(R$string.ad_download_pause);
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadStart(NestAdData nestAdData) {
            this.f16170a.setText(R$string.ad_download_start);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements NestAdData.AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16171a;

        public h(int i) {
            this.f16171a = i;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdClicked(NestAdData nestAdData) {
            if (AdViewHolder.this.f == 1) {
                fn1.a(nestAdData.getRequestId(), nestAdData, this.f16171a, wh5.M(), AdViewHolder.this.f, "LX-35416", wh5.P());
                return;
            }
            if (AdViewHolder.this.f == 2) {
                fn1.a(nestAdData.getRequestId(), nestAdData, this.f16171a, wh5.J(), AdViewHolder.this.f, "LX-35416", wh5.P());
            } else if (AdViewHolder.this.f == 73) {
                fn1.a(nestAdData.getRequestId(), nestAdData, this.f16171a, wh5.K(), AdViewHolder.this.f, "LX-43408", wh5.N());
            } else if (AdViewHolder.this.f == 74) {
                fn1.a(nestAdData.getRequestId(), nestAdData, this.f16171a, wh5.L(), AdViewHolder.this.f, "LX-44460", wh5.O());
            }
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdExposed(NestAdData nestAdData) {
            if (AdViewHolder.this.f == 1) {
                fn1.f(nestAdData.getRequestId(), nestAdData, this.f16171a, wh5.M(), AdViewHolder.this.f, "LX-35416", wh5.P());
                return;
            }
            if (AdViewHolder.this.f == 2) {
                fn1.f(nestAdData.getRequestId(), nestAdData, this.f16171a, wh5.J(), AdViewHolder.this.f, "LX-35416", wh5.P());
            } else if (AdViewHolder.this.f == 73) {
                fn1.f(nestAdData.getRequestId(), nestAdData, this.f16171a, wh5.K(), AdViewHolder.this.f, "LX-43408", wh5.N());
            } else if (AdViewHolder.this.f == 74) {
                fn1.f(nestAdData.getRequestId(), nestAdData, this.f16171a, wh5.L(), AdViewHolder.this.f, "LX-44460", wh5.O());
            }
        }
    }

    public AdViewHolder(ViewGroup viewGroup, int i2) {
        super(viewGroup);
        this.f = i2;
        if (i2 == 1) {
            this.g = wh5.I();
        } else if (i2 == 2) {
            this.g = wh5.F();
        } else if (i2 == 73) {
            this.g = wh5.G();
        } else if (i2 == 74) {
            this.g = wh5.H();
        } else {
            this.g = new c6();
        }
        y();
    }

    public static int A(int i2, int i3) {
        return new Random().nextInt((i3 - i2) + 1) + i2;
    }

    public static String B(String str, String str2, String str3) {
        if (str2.equals("")) {
            throw new IllegalArgumentException("Old pattern must have content.");
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2, length);
            if (iIndexOf < 0) {
                stringBuffer.append(str.substring(length));
                return stringBuffer.toString();
            }
            stringBuffer.append(str.substring(length, iIndexOf));
            stringBuffer.append(str3);
            length = str2.length() + iIndexOf;
        }
    }

    public static String x(NestAdData nestAdData) {
        List<String> imageList;
        if (nestAdData == null || (imageList = nestAdData.getImageList()) == null || imageList.isEmpty()) {
            return null;
        }
        return imageList.get(0);
    }

    public static boolean z(NestAdData nestAdData) {
        int iIntValue = nestAdData.getAdMode().intValue();
        return iIntValue == 4 || iIntValue == 5;
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void l(SquareFeed squareFeed, int i2) {
        int i3;
        NestAdData nestAdDataChangeCheckMaxAd;
        int i4 = this.f;
        Float fValueOf = null;
        NestAdData nestAdDataD = i4 == 1 ? wh5.D(squareFeed.adKey.intValue()) : i4 == 2 ? wh5.A(squareFeed.adKey.intValue()) : i4 == 73 ? wh5.B(squareFeed.adKey.intValue()) : i4 == 74 ? wh5.C(squareFeed.adKey.intValue()) : null;
        if (nestAdDataD == null) {
            return;
        }
        if (nestAdDataD.getAdSPStrategy() && (nestAdDataChangeCheckMaxAd = SPCacheManager.INSTANCE.changeCheckMaxAd(nestAdDataD)) != null) {
            nestAdDataD = nestAdDataChangeCheckMaxAd;
        }
        NestAdData nestAdData = this.h;
        if (nestAdData != null) {
            nestAdData.setAppDownloadListener(new a());
        }
        this.h = nestAdDataD;
        List<String> imageList = nestAdDataD.getImageList();
        boolean z = imageList != null && imageList.size() > 1;
        if (z) {
            int i5 = this.f;
            if (i5 == 1 || i5 == 73 || i5 == 74) {
                ((SquareGenericListItemAdBinding) this.d).z.setFullyVisibleListener(new b(nestAdDataD));
            }
            ((SquareGenericListItemAdBinding) this.d).m.setVisibility(0);
            ((SquareGenericListItemAdBinding) this.d).n.setVisibility(8);
        } else {
            int i6 = this.f;
            if (i6 == 1 || i6 == 73 || i6 == 74) {
                ((SquareGenericListItemAdBinding) this.d).z.setFullyVisibleListener(new c(nestAdDataD));
            }
            ((SquareGenericListItemAdBinding) this.d).m.setVisibility(8);
            ((SquareGenericListItemAdBinding) this.d).n.setVisibility(0);
            float nativeAdImgWidth = nestAdDataD.getNativeAdImgWidth();
            float nativeAdImgHeight = nestAdDataD.getNativeAdImgHeight();
            WifiLog.d("SquareAd 3333 in bind img width = " + nativeAdImgWidth + ", height = " + nativeAdImgHeight);
            if (nativeAdImgWidth > 0.0f && nativeAdImgHeight > 0.0f) {
                float f2 = nativeAdImgWidth / nativeAdImgHeight;
                int i7 = 0;
                i3 = 0;
                while (true) {
                    float[][] fArr = i;
                    if (i7 >= fArr.length) {
                        break;
                    }
                    float[] fArr2 = fArr[i7];
                    float fAbs = Math.abs((fArr2[0] / fArr2[1]) - f2);
                    if (fValueOf == null || fAbs < fValueOf.floatValue()) {
                        fValueOf = Float.valueOf(fAbs);
                        i3 = i7;
                    }
                    i7++;
                }
            } else {
                i3 = 0;
            }
            Context context = this.itemView.getContext();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((SquareGenericListItemAdBinding) this.d).n.getLayoutParams();
            float[][] fArr3 = i;
            layoutParams.width = me1.a(context, fArr3[i3][0]);
            layoutParams.height = me1.a(context, fArr3[i3][1]);
            ((SquareGenericListItemAdBinding) this.d).n.setLayoutParams(layoutParams);
        }
        w(squareFeed, i2, nestAdDataD, z);
    }

    public final void w(SquareFeed squareFeed, int i2, NestAdData nestAdData, boolean z) {
        TextView textView;
        String adIcon = nestAdData.getAdIcon();
        if (j == null) {
            j = a46.i(R$drawable.default_portrait);
        }
        gr2 gr2VarJ = gr2.j();
        if (adIcon == null) {
            adIcon = "";
        }
        gr2VarJ.h(adIcon, ((SquareGenericListItemAdBinding) this.d).c, j);
        String adAppName = nestAdData.getAdAppName();
        TextView textView2 = ((SquareGenericListItemAdBinding) this.d).d;
        if (TextUtils.isEmpty(adAppName)) {
            adAppName = this.g.f;
        }
        textView2.setText(adAppName);
        if (TextUtils.isEmpty(this.g.h)) {
            ((SquareGenericListItemAdBinding) this.d).j.setVisibility(8);
        } else {
            ((SquareGenericListItemAdBinding) this.d).j.setVisibility(0);
            StringBuilder sb = new StringBuilder();
            c6 c6Var = this.g;
            sb.append(A(c6Var.i, c6Var.j));
            sb.append("");
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            c6 c6Var2 = this.g;
            sb2.append(A(c6Var2.k, c6Var2.l));
            sb2.append("");
            ((SquareGenericListItemAdBinding) this.d).j.setText(B(B(this.g.h, ContainerUtils.FIELD_DELIMITER, string), "$", sb2.toString()));
        }
        int i3 = this.f == 1 ? 38 : 0;
        l6.l(i3);
        ((SquareGenericListItemAdBinding) this.d).y.setOnClickListener(new d(i3));
        ((SquareGenericListItemAdBinding) this.d).h.setOnClickListener(new e(i2, squareFeed));
        if (WifiNestAd.INSTANCE.getMPersonalizedAd()) {
            ((SquareGenericListItemAdBinding) this.d).q.setText(R$string.personalize_ad);
        } else {
            ((SquareGenericListItemAdBinding) this.d).q.setText(R$string.common_ad);
        }
        if (k == null) {
            k = a46.i(R$drawable.bg_feed_item_loading);
        }
        if (z) {
            ((SquareGenericListItemAdBinding) this.d).p.setAdapter(new f(nestAdData));
            ((SquareGenericListItemAdBinding) this.d).p.setCurrentItem(0);
            ((SquareGenericListItemAdBinding) this.d).p.beginAutoScroll();
            ((SquareGenericListItemAdBinding) this.d).k.setImageResource(nestAdData.getAdLogoResId());
            textView = ((SquareGenericListItemAdBinding) this.d).f16237a;
        } else {
            ((SquareGenericListItemAdBinding) this.d).s.removeAllViews();
            if (z(nestAdData)) {
                ((SquareGenericListItemAdBinding) this.d).i.setVisibility(8);
                View adView = nestAdData.getAdView();
                if (adView != null) {
                    ViewParent parent = adView.getParent();
                    boolean z2 = parent instanceof ViewGroup;
                    if (z2) {
                        ((ViewGroup) parent).removeView(adView);
                    }
                    if (parent == null || z2) {
                        ((SquareGenericListItemAdBinding) this.d).s.addView(adView, new ViewGroup.LayoutParams(-1, -1));
                        AdDownViVoConfig.checkVideoViewClick(nestAdData, ((SquareGenericListItemAdBinding) this.d).s);
                    }
                }
            } else {
                ((SquareGenericListItemAdBinding) this.d).i.setVisibility(0);
                String strX = x(nestAdData);
                gr2 gr2VarJ2 = gr2.j();
                if (strX == null) {
                    strX = "";
                }
                gr2VarJ2.h(strX, ((SquareGenericListItemAdBinding) this.d).i, k);
            }
            ((SquareGenericListItemAdBinding) this.d).l.setImageResource(nestAdData.getAdLogoResId());
            textView = ((SquareGenericListItemAdBinding) this.d).b;
        }
        TextView textView3 = textView;
        if (nestAdData.getInteractionType().intValue() == 1) {
            textView3.setText(R$string.ad_download_start);
            nestAdData.setAppDownloadListener(new g(textView3));
        } else {
            textView3.setText(R$string.ad_show_more);
        }
        String title = nestAdData.getTitle();
        if (!TextUtils.isEmpty(title) && title.equals(nestAdData.getAdAppName())) {
            title = nestAdData.getDescription();
        }
        if (TextUtils.isEmpty(title)) {
            title = this.g.g;
        }
        ((SquareGenericListItemAdBinding) this.d).r.setText(title);
        h hVar = new h(i2);
        nestAdData.setAdInteractionListener(hVar);
        LogUtil.d("", "rrrr AdViewHolder getDiscountInfo " + nestAdData.getDiscountInfo() + " infoSwitch " + f6.f17462a + " title " + title);
        if (TextUtils.isEmpty(nestAdData.getDiscountInfo()) || !f6.f17462a) {
            ((SquareGenericListItemAdBinding) this.d).f.setVisibility(8);
        } else {
            ((SquareGenericListItemAdBinding) this.d).f.setVisibility(0);
            ((SquareGenericListItemAdBinding) this.d).g.setText(nestAdData.getDiscountInfo());
        }
        bw3.a(nestAdData.getRequestId(), "", "", nestAdData.getAdScene(), nestAdData);
        AdHelperFeed.INSTANCE.registerViewAndAction((ViewGroup) this.itemView, textView3, new View[]{((SquareGenericListItemAdBinding) this.d).getRoot()}, null, null, nestAdData);
        if (SDKAlias.WIFI.getType().equals(nestAdData.getAdType())) {
            NestWifiNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
            hVar.onAdExposed(nestAdData);
        }
        DB db = this.d;
        if (((SquareGenericListItemAdBinding) db).e != null) {
            ((SquareGenericListItemAdBinding) db).e.initComInfo(nestAdData);
        }
    }

    public final void y() {
        Context context = this.itemView.getContext();
        this.d = SquareGenericListItemAdBinding.b(LayoutInflater.from(context));
        ClearLogoNativeAdContainer clearLogoNativeAdContainer = new ClearLogoNativeAdContainer(context);
        clearLogoNativeAdContainer.addView(((SquareGenericListItemAdBinding) this.d).getRoot(), new ViewGroup.LayoutParams(-1, -1));
        ((ViewGroup) this.itemView).addView(clearLogoNativeAdContainer, new ViewGroup.LayoutParams(-1, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.g.m);
        gradientDrawable.setCornerRadius(me1.b(context, 100));
        gradientDrawable.setStroke(me1.a(context, 0.5f), this.g.n);
        ((SquareGenericListItemAdBinding) this.d).b.setBackgroundDrawable(gradientDrawable);
        ((SquareGenericListItemAdBinding) this.d).b.setTextColor(this.g.o);
        ((SquareGenericListItemAdBinding) this.d).f16237a.setBackgroundDrawable(gradientDrawable);
        ((SquareGenericListItemAdBinding) this.d).f16237a.setTextColor(this.g.o);
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements NestAdData.AppDownloadListener {
        public a() {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadComplete(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadFailed(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadInstalled(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadPause(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadStart(NestAdData nestAdData) {
        }

        @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
        public void onDownloadProgress(NestAdData nestAdData, int i) {
        }
    }
}
