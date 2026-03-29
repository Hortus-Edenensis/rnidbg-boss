package com.wifi.ad.core.feedbanner;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.wifi.ad.core.R;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.listener.FeedBannerShowListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.reporter.AbstractReporter;
import com.wifi.ad.core.strategy.SdkStrategy;
import com.wifi.ad.core.utils.ScreenUtil;
import com.wifi.ad.core.utils.WifiLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0005¢\u0006\u0002\u0010\u0014J`\u0010'\u001a\u00020(2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020(H\u0014J@\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\b2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\b\u0010/\u001a\u0004\u0018\u00010\b2\b\u00100\u001a\u0004\u0018\u00010\b2\b\u00101\u001a\u0004\u0018\u000102R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/wifi/ad/core/feedbanner/WkFeedBannerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "allWidth", "", "allHeight", "bgColor", "", "downloadBtnBgColor", "downloadBtnTextColor", "parent", "Landroid/view/ViewGroup;", "adLayout", "Landroid/view/View;", "showListener", "Lcom/wifi/ad/core/listener/FeedBannerShowListener;", "adData", "Lcom/wifi/ad/core/data/NestAdData;", "closeType", "(Landroid/content/Context;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/ViewGroup;Landroid/view/View;Lcom/wifi/ad/core/listener/FeedBannerShowListener;Lcom/wifi/ad/core/data/NestAdData;I)V", "clickListAd", "", "getClickListAd", "()Ljava/util/List;", "logoLayout", "Landroid/widget/LinearLayout;", "mAllClicks", "mBtnView", "Landroid/widget/TextView;", "mCloseType", "mContext", "mCurAdData", "mSdkView", "Lcom/wifi/ad/core/feedbanner/WkFeedBannerSdkView;", "mShowListener", "mSmallDsp", "Landroid/widget/ImageView;", "mTitleView", "initView", "", "layout", "onAttachedToWindow", "setAdView", "adType", "imgUrl", "adView", "title", "btnText", "logoUrl", "Landroid/graphics/Bitmap;", "core_release"}, k = 1, mv = {1, 1, 16})
public final class WkFeedBannerView extends FrameLayout {
    private HashMap _$_findViewCache;
    private LinearLayout logoLayout;
    private final List<View> mAllClicks;
    private TextView mBtnView;
    private int mCloseType;
    private Context mContext;
    private NestAdData mCurAdData;
    private WkFeedBannerSdkView mSdkView;
    private FeedBannerShowListener mShowListener;
    private ImageView mSmallDsp;
    private TextView mTitleView;

    public WkFeedBannerView(Context context, int i, int i2, String str, String str2, String str3, ViewGroup viewGroup, View view, FeedBannerShowListener feedBannerShowListener, NestAdData nestAdData, int i3) {
        super(context);
        this.mAllClicks = new ArrayList();
        initView(context, i, i2, str, str2, str3, viewGroup, view, feedBannerShowListener, nestAdData, i3);
    }

    private final void initView(Context context, int allWidth, int allHeight, String bgColor, String downloadBtnBgColor, String downloadBtnTextColor, final ViewGroup parent, final View layout, final FeedBannerShowListener showListener, NestAdData adData, final int closeType) {
        this.mContext = context;
        this.mShowListener = showListener;
        this.mCurAdData = adData;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        try {
            linearLayout.setBackgroundColor(Color.parseColor(bgColor));
        } catch (Exception unused) {
        }
        this.mAllClicks.add(linearLayout);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(allWidth, allHeight);
        layoutParams.gravity = 80;
        addView(linearLayout, layoutParams);
        FrameLayout frameLayout = new FrameLayout(context);
        this.mAllClicks.add(frameLayout);
        float f = allWidth;
        float f2 = allHeight;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((int) (f * 0.20833333f), (int) (0.7777778f * f2));
        layoutParams2.leftMargin = (int) (0.027777778f * f);
        layoutParams2.gravity = 16;
        linearLayout.addView(frameLayout, layoutParams2);
        frameLayout.setBackgroundColor(Color.parseColor("#4E4E4E"));
        WkFeedBannerSdkView wkFeedBannerSdkView = new WkFeedBannerSdkView(context);
        this.mSdkView = wkFeedBannerSdkView;
        frameLayout.addView(wkFeedBannerSdkView, new FrameLayout.LayoutParams(-1, -1));
        WifiLog.d("H5Banner WkFeedBannerView adView.addView mSdkView");
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.logoLayout = linearLayout2;
        linearLayout2.setGravity(16);
        LinearLayout linearLayout3 = this.logoLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwNpe();
        }
        linearLayout3.setOrientation(0);
        LinearLayout linearLayout4 = this.logoLayout;
        if (linearLayout4 == null) {
            Intrinsics.throwNpe();
        }
        linearLayout4.setBackgroundResource(R.drawable.icon_dsp_default_bg);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, (int) (f2 * 0.18518518f));
        layoutParams3.gravity = 8388693;
        frameLayout.addView(this.logoLayout, layoutParams3);
        ImageView imageView = new ImageView(context);
        this.mSmallDsp = imageView;
        imageView.setImageResource(R.drawable.icon_dsp_360);
        int i = (int) ((allWidth * 12) / 360.0f);
        int i2 = (int) ((allHeight * 10) / 54.0f);
        LinearLayout linearLayout5 = this.logoLayout;
        if (linearLayout5 == null) {
            Intrinsics.throwNpe();
        }
        linearLayout5.addView(this.mSmallDsp, i, i2);
        TextView textView = new TextView(context);
        textView.setText(WifiNestAd.INSTANCE.getMPersonalizedAd() ? "个性化广告" : "广告");
        textView.setTextSize(0, context.getResources().getDimension(R.dimen.sp_7));
        textView.setTextColor(Color.parseColor("#99ffffff"));
        LinearLayout linearLayout6 = this.logoLayout;
        if (linearLayout6 == null) {
            Intrinsics.throwNpe();
        }
        linearLayout6.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(context);
        this.mTitleView = textView2;
        this.mAllClicks.add(textView2);
        TextView textView3 = this.mTitleView;
        if (textView3 == null) {
            Intrinsics.throwNpe();
        }
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView4 = this.mTitleView;
        if (textView4 == null) {
            Intrinsics.throwNpe();
        }
        textView4.setLines(1);
        TextView textView5 = this.mTitleView;
        if (textView5 == null) {
            Intrinsics.throwNpe();
        }
        textView5.setTextColor(Color.parseColor("#4B2D1B"));
        TextView textView6 = this.mTitleView;
        if (textView6 == null) {
            Intrinsics.throwNpe();
        }
        textView6.setTextSize(0, context.getResources().getDimension(R.dimen.sp_14));
        TextView textView7 = this.mTitleView;
        if (textView7 == null) {
            Intrinsics.throwNpe();
        }
        textView7.setText("点击发现更多精彩内容");
        TextView textView8 = this.mTitleView;
        if (textView8 == null) {
            Intrinsics.throwNpe();
        }
        textView8.setIncludeFontPadding(false);
        int i3 = (int) ((allWidth * 8) / 360.0f);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams((int) ((allWidth * EffectConstants.ROTATION_DEGREES_180) / 360.0f), -2);
        layoutParams4.leftMargin = i3;
        layoutParams4.gravity = 16;
        linearLayout.addView(this.mTitleView, layoutParams4);
        TextView textView9 = new TextView(context);
        this.mBtnView = textView9;
        this.mAllClicks.add(textView9);
        try {
            TextView textView10 = this.mBtnView;
            if (textView10 == null) {
                Intrinsics.throwNpe();
            }
            textView10.setTextColor(Color.parseColor(downloadBtnTextColor));
        } catch (Exception unused2) {
            TextView textView11 = this.mBtnView;
            if (textView11 == null) {
                Intrinsics.throwNpe();
            }
            textView11.setTextColor(Color.parseColor("#FFFFFF"));
        }
        TextView textView12 = this.mBtnView;
        if (textView12 == null) {
            Intrinsics.throwNpe();
        }
        textView12.setTextSize(0, context.getResources().getDimension(R.dimen.sp_11));
        TextView textView13 = this.mBtnView;
        if (textView13 == null) {
            Intrinsics.throwNpe();
        }
        textView13.setText("立即下载");
        TextView textView14 = this.mBtnView;
        if (textView14 == null) {
            Intrinsics.throwNpe();
        }
        textView14.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        try {
            gradientDrawable.setColor(Color.parseColor(downloadBtnBgColor));
        } catch (Exception unused3) {
            gradientDrawable.setColor(Color.parseColor("#00e800"));
        }
        ScreenUtil screenUtil = ScreenUtil.INSTANCE;
        if (this.mContext == null) {
            Intrinsics.throwNpe();
        }
        gradientDrawable.setCornerRadius(screenUtil.dp2px(r11, 4.0f));
        TextView textView15 = this.mBtnView;
        if (textView15 == null) {
            Intrinsics.throwNpe();
        }
        textView15.setBackgroundDrawable(gradientDrawable);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams((int) ((allWidth * 70) / 360.0f), (int) ((allHeight * 26) / 54.0f));
        layoutParams5.leftMargin = i3;
        layoutParams5.gravity = 16;
        linearLayout.addView(this.mBtnView, layoutParams5);
        ImageView imageView2 = new ImageView(context);
        int i4 = (int) ((allWidth * 18) / 360.0f);
        imageView2.setImageResource(R.drawable.ic_bottom_banner_close);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(i4, i4);
        layoutParams6.gravity = 8388661;
        addView(imageView2, layoutParams6);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.feedbanner.WkFeedBannerView.initView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    if (closeType == 0) {
                        parent.removeView(layout);
                        FeedBannerShowListener feedBannerShowListener = showListener;
                        NestAdData nestAdData = WkFeedBannerView.this.mCurAdData;
                        if (nestAdData == null) {
                            Intrinsics.throwNpe();
                        }
                        String adType = nestAdData.getAdType();
                        if (adType == null) {
                            Intrinsics.throwNpe();
                        }
                        SdkStrategy.Companion companion = SdkStrategy.INSTANCE;
                        NestAdData nestAdData2 = WkFeedBannerView.this.mCurAdData;
                        if (nestAdData2 == null) {
                            Intrinsics.throwNpe();
                        }
                        String strCreateStringByAdData = companion.createStringByAdData(nestAdData2);
                        if (strCreateStringByAdData == null) {
                            Intrinsics.throwNpe();
                        }
                        NestAdData nestAdData3 = WkFeedBannerView.this.mCurAdData;
                        if (nestAdData3 == null) {
                            Intrinsics.throwNpe();
                        }
                        String requestId = nestAdData3.getRequestId();
                        if (requestId == null) {
                            Intrinsics.throwNpe();
                        }
                        feedBannerShowListener.onAdRemove(adType, strCreateStringByAdData, requestId);
                    }
                    FeedBannerShowListener feedBannerShowListener2 = showListener;
                    NestAdData nestAdData4 = WkFeedBannerView.this.mCurAdData;
                    if (nestAdData4 == null) {
                        Intrinsics.throwNpe();
                    }
                    String adType2 = nestAdData4.getAdType();
                    if (adType2 == null) {
                        Intrinsics.throwNpe();
                    }
                    SdkStrategy.Companion companion2 = SdkStrategy.INSTANCE;
                    NestAdData nestAdData5 = WkFeedBannerView.this.mCurAdData;
                    if (nestAdData5 == null) {
                        Intrinsics.throwNpe();
                    }
                    String strCreateStringByAdData2 = companion2.createStringByAdData(nestAdData5);
                    if (strCreateStringByAdData2 == null) {
                        Intrinsics.throwNpe();
                    }
                    NestAdData nestAdData6 = WkFeedBannerView.this.mCurAdData;
                    if (nestAdData6 == null) {
                        Intrinsics.throwNpe();
                    }
                    String requestId2 = nestAdData6.getRequestId();
                    if (requestId2 == null) {
                        Intrinsics.throwNpe();
                    }
                    feedBannerShowListener2.onAdCloseClick(adType2, strCreateStringByAdData2, requestId2);
                    EventParams.Builder builder = new EventParams.Builder();
                    NestAdData nestAdData7 = WkFeedBannerView.this.mCurAdData;
                    if (nestAdData7 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder nestSid = builder.setNestSid(nestAdData7.getNestSid());
                    NestAdData nestAdData8 = WkFeedBannerView.this.mCurAdData;
                    if (nestAdData8 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder dspName = nestSid.setDspName(nestAdData8.getDspName());
                    NestAdData nestAdData9 = WkFeedBannerView.this.mCurAdData;
                    if (nestAdData9 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder mediaId = dspName.setMediaId(nestAdData9.getAppId());
                    NestAdData nestAdData10 = WkFeedBannerView.this.mCurAdData;
                    if (nestAdData10 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder srcId = mediaId.setSrcId(nestAdData10.getAdCode());
                    NestAdData nestAdData11 = WkFeedBannerView.this.mCurAdData;
                    if (nestAdData11 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder inventoryId = srcId.setInventoryId(nestAdData11.getInventoryId());
                    NestAdData nestAdData12 = WkFeedBannerView.this.mCurAdData;
                    if (nestAdData12 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder sdkFrom = inventoryId.setSdkFrom(nestAdData12.getSdkFrom());
                    NestAdData nestAdData13 = WkFeedBannerView.this.mCurAdData;
                    if (nestAdData13 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder renderStyle = sdkFrom.setRenderStyle(nestAdData13.getRenderStyle());
                    NestAdData nestAdData14 = WkFeedBannerView.this.mCurAdData;
                    if (nestAdData14 == null) {
                        Intrinsics.throwNpe();
                    }
                    Object adMode = nestAdData14.getAdMode();
                    if (adMode == null) {
                        adMode = "";
                    }
                    EventParams eventParams = renderStyle.setAdMode(adMode.toString()).build();
                    AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
                    Intrinsics.checkExpressionValueIsNotNull(eventParams, "eventParams");
                    NestAdData nestAdData15 = WkFeedBannerView.this.mCurAdData;
                    if (nestAdData15 == null) {
                        Intrinsics.throwNpe();
                    }
                    AdParams adParams = nestAdData15.getAdParams();
                    if (adParams == null) {
                        Intrinsics.throwNpe();
                    }
                    reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_CLOSE_CLICK, eventParams, adParams.getExt());
                } catch (Exception unused4) {
                }
            }
        });
        NestAdData nestAdData = this.mCurAdData;
        if (nestAdData == null) {
            Intrinsics.throwNpe();
        }
        if (Intrinsics.areEqual(nestAdData.getAdType(), SDKAlias.GDT.getType())) {
            TextView textView16 = this.mBtnView;
            if (textView16 == null) {
                Intrinsics.throwNpe();
            }
            textView16.setTag(WifiNestConst.OtherConst.TAG_AD_BUTTON);
        }
        WifiLog.d("H5Banner WkFeedBannerView adView end");
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this._$_findViewCache;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final List<View> getClickListAd() {
        return this.mAllClicks;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public final void setAdView(int adType, String imgUrl, View adView, String title, String btnText, Bitmap logoUrl) {
        WifiLog.d("H5Banner WkFeedBannerView setAdView mSdkView+" + this.mSdkView + " mBtnView+" + this.mBtnView + " mTitleView+" + this.mTitleView + " mSmallDsp+" + this.mSmallDsp);
        WkFeedBannerSdkView wkFeedBannerSdkView = this.mSdkView;
        if (wkFeedBannerSdkView != null) {
            if (wkFeedBannerSdkView == null) {
                Intrinsics.throwNpe();
            }
            wkFeedBannerSdkView.setAdView(adType, imgUrl, adView);
        }
        if (this.mBtnView != null && !TextUtils.isEmpty(btnText)) {
            TextView textView = this.mBtnView;
            if (textView == null) {
                Intrinsics.throwNpe();
            }
            textView.setText(btnText);
        }
        if (this.mTitleView != null && !TextUtils.isEmpty(title)) {
            TextView textView2 = this.mTitleView;
            if (textView2 == null) {
                Intrinsics.throwNpe();
            }
            textView2.setText(title);
        }
        if (this.mSmallDsp != null) {
            NestAdData nestAdData = this.mCurAdData;
            if (nestAdData == null) {
                Intrinsics.throwNpe();
            }
            if (Intrinsics.areEqual(nestAdData.getAdType(), SDKAlias.GDT.getType())) {
                ImageView imageView = this.mSmallDsp;
                if (imageView == null) {
                    Intrinsics.throwNpe();
                }
                imageView.setImageResource(R.drawable.icon_gdt_logo);
                return;
            }
            NestAdData nestAdData2 = this.mCurAdData;
            if (nestAdData2 == null) {
                Intrinsics.throwNpe();
            }
            if (Intrinsics.areEqual(nestAdData2.getAdType(), SDKAlias.CSJ.getType())) {
                ImageView imageView2 = this.mSmallDsp;
                if (imageView2 == null) {
                    Intrinsics.throwNpe();
                }
                imageView2.setImageResource(R.drawable.icon_csj_logo);
                return;
            }
            NestAdData nestAdData3 = this.mCurAdData;
            if (nestAdData3 == null) {
                Intrinsics.throwNpe();
            }
            if (Intrinsics.areEqual(nestAdData3.getAdType(), SDKAlias.KS.getType())) {
                ImageView imageView3 = this.mSmallDsp;
                if (imageView3 == null) {
                    Intrinsics.throwNpe();
                }
                imageView3.setImageResource(R.drawable.icon_ks_logo);
                return;
            }
            NestAdData nestAdData4 = this.mCurAdData;
            if (nestAdData4 == null) {
                Intrinsics.throwNpe();
            }
            if (Intrinsics.areEqual(nestAdData4.getAdType(), SDKAlias.OPPO.getType())) {
                ImageView imageView4 = this.mSmallDsp;
                if (imageView4 == null) {
                    Intrinsics.throwNpe();
                }
                imageView4.setImageResource(R.drawable.icon_oppo_logo);
                return;
            }
            NestAdData nestAdData5 = this.mCurAdData;
            if (nestAdData5 == null) {
                Intrinsics.throwNpe();
            }
            if (Intrinsics.areEqual(nestAdData5.getAdType(), SDKAlias.HUAWEI.getType())) {
                ImageView imageView5 = this.mSmallDsp;
                if (imageView5 == null) {
                    Intrinsics.throwNpe();
                }
                imageView5.setImageResource(R.drawable.icon_huawei_logo);
                return;
            }
            NestAdData nestAdData6 = this.mCurAdData;
            if (nestAdData6 == null) {
                Intrinsics.throwNpe();
            }
            if (Intrinsics.areEqual(nestAdData6.getAdType(), SDKAlias.FEISUO.getType())) {
                ImageView imageView6 = this.mSmallDsp;
                if (imageView6 == null) {
                    Intrinsics.throwNpe();
                }
                imageView6.setImageResource(R.drawable.icon_feisuo_logo);
                return;
            }
            NestAdData nestAdData7 = this.mCurAdData;
            if (nestAdData7 == null) {
                Intrinsics.throwNpe();
            }
            if (Intrinsics.areEqual(nestAdData7.getAdType(), SDKAlias.LXAD.getType())) {
                ImageView imageView7 = this.mSmallDsp;
                if (imageView7 == null) {
                    Intrinsics.throwNpe();
                }
                imageView7.setImageResource(R.drawable.icon_lxad_logo);
                return;
            }
            if (logoUrl != null) {
                ImageView imageView8 = this.mSmallDsp;
                if (imageView8 == null) {
                    Intrinsics.throwNpe();
                }
                imageView8.setImageBitmap(logoUrl);
            }
        }
    }
}
