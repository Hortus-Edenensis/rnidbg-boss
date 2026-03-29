package com.wifi.ad.core.chapterad;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
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
import com.wifi.ad.core.utils.AdComplianceUtil;
import com.wifi.ad.core.utils.ScreenUtil;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.ad.core.view.WifiLinearLayout;
import com.wifi.adsdk.download.LxAdDLManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B¥\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0005¢\u0006\u0002\u0010\u001dJ¨\u0001\u0010=\u001a\u00020>2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010@\u001a\u00020>H\u0014Jp\u0010A\u001a\u00020>2\u0006\u0010B\u001a\u00020\u00052\b\u0010C\u001a\u0004\u0018\u00010\t2\b\u0010D\u001a\u0004\u0018\u00010\u00162\b\u0010E\u001a\u0004\u0018\u00010\t2\b\u0010F\u001a\u0004\u0018\u00010\t2\b\u0010G\u001a\u0004\u0018\u00010\t2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010\t2\b\u0010K\u001a\u0004\u0018\u00010\t2\b\u0010L\u001a\u0004\u0018\u00010\t2\u0006\u0010M\u001a\u00020\u0005R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00160!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/wifi/ad/core/chapterad/WkChapterAdView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "allWidth", "", "allHeight", "userDefaultBg", "bgColor", "", "contentBgColor", "chapterNameColor", "adTitleTextColor", "textLinkColor", "rewardBtnBgColor", "rewardBtnStrokeColor", "rewardBtnTextColor", "downloadBtnBgColor", "downloadBtnTextColor", "parent", "Landroid/view/ViewGroup;", "adLayout", "Landroid/view/View;", "showListener", "Lcom/wifi/ad/core/listener/FeedBannerShowListener;", "adData", "Lcom/wifi/ad/core/data/NestAdData;", EventParams.KEY_RENDERTYPE, "rewardBtnClickHide", "(Landroid/content/Context;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/ViewGroup;Landroid/view/View;Lcom/wifi/ad/core/listener/FeedBannerShowListener;Lcom/wifi/ad/core/data/NestAdData;II)V", "appInfoContainerView", "Landroid/widget/LinearLayout;", "clickListAd", "", "getClickListAd", "()Ljava/util/List;", "closeLayout", "complianceContainerView", "mAllClicks", "mBtnView", "Landroid/widget/TextView;", "mChapterNameView", "mCloseImg", "Landroid/widget/ImageView;", "mContext", "mCurAdData", "mDescView", "mDeveloperView", "mDislikeView", "mLinkTextView", "mPermissionsView", "mPrivacyView", "mRenderType", "mRewardBtnView", "mSdkView", "Lcom/wifi/ad/core/chapterad/WkChapterAdSdkView;", "mShowListener", "mSmallDsp", "mTitleView", "mVersionView", "permissionsPrivacyContainerView", "initView", "", "layout", "onAttachedToWindow", "setAdView", "adType", "imgUrl", "adView", "title", LxAdDLManager.ITEM_DESC, "btnText", "logoUrl", "Landroid/graphics/Bitmap;", "textLink", "rewardBtnText", "chapterNameText", "closeType", "core_release"}, k = 1, mv = {1, 1, 16})
public final class WkChapterAdView extends FrameLayout {
    private HashMap _$_findViewCache;
    private LinearLayout appInfoContainerView;
    private LinearLayout closeLayout;
    private LinearLayout complianceContainerView;
    private final List<View> mAllClicks;
    private TextView mBtnView;
    private TextView mChapterNameView;
    private ImageView mCloseImg;
    private Context mContext;
    private NestAdData mCurAdData;
    private TextView mDescView;
    private TextView mDeveloperView;
    private TextView mDislikeView;
    private TextView mLinkTextView;
    private TextView mPermissionsView;
    private TextView mPrivacyView;
    private int mRenderType;
    private TextView mRewardBtnView;
    private WkChapterAdSdkView mSdkView;
    private FeedBannerShowListener mShowListener;
    private ImageView mSmallDsp;
    private TextView mTitleView;
    private TextView mVersionView;
    private LinearLayout permissionsPrivacyContainerView;

    public WkChapterAdView(Context context, int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, ViewGroup viewGroup, View view, FeedBannerShowListener feedBannerShowListener, NestAdData nestAdData, int i4, int i5) {
        super(context);
        this.mAllClicks = new ArrayList();
        initView(context, i, i2, i3, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, viewGroup, view, feedBannerShowListener, nestAdData, i4, i5);
    }

    private final void initView(Context context, int allWidth, int allHeight, int userDefaultBg, String bgColor, String contentBgColor, String chapterNameColor, String adTitleTextColor, String textLinkColor, String rewardBtnBgColor, String rewardBtnStrokeColor, String rewardBtnTextColor, String downloadBtnBgColor, String downloadBtnTextColor, ViewGroup parent, View layout, final FeedBannerShowListener showListener, NestAdData adData, int renderType, final int rewardBtnClickHide) {
        final FeedBannerShowListener feedBannerShowListener;
        final int i;
        this.mContext = context;
        this.mShowListener = showListener;
        this.mCurAdData = adData;
        this.mRenderType = renderType;
        WifiLinearLayout wifiLinearLayout = new WifiLinearLayout(context);
        try {
            if (userDefaultBg > 0) {
                wifiLinearLayout.setBackgroundResource(R.drawable.icon_reader_default_bg);
            } else {
                wifiLinearLayout.setBackgroundColor(Color.parseColor(bgColor));
            }
        } catch (Exception unused) {
            wifiLinearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        wifiLinearLayout.setOrientation(1);
        addView(wifiLinearLayout, new FrameLayout.LayoutParams(-1, -1));
        wifiLinearLayout.setOnCustomTouchEventListener(new WifiLinearLayout.OnCustomTouchEventListener() { // from class: com.wifi.ad.core.chapterad.WkChapterAdView.initView.1
            @Override // com.wifi.ad.core.view.WifiLinearLayout.OnCustomTouchEventListener
            public final void onTouchEvent(int i2) throws JSONException {
                SdkStrategy.Companion companion = SdkStrategy.INSTANCE;
                NestAdData nestAdData = WkChapterAdView.this.mCurAdData;
                if (nestAdData == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = companion.createStringByAdData(nestAdData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                JSONObject jSONObject = new JSONObject(strCreateStringByAdData);
                jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, i2);
                FeedBannerShowListener feedBannerShowListener2 = showListener;
                NestAdData nestAdData2 = WkChapterAdView.this.mCurAdData;
                if (nestAdData2 == null) {
                    Intrinsics.throwNpe();
                }
                String adType = nestAdData2.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String string = jSONObject.toString();
                Intrinsics.checkExpressionValueIsNotNull(string, "jsonObject.toString()");
                NestAdData nestAdData3 = WkChapterAdView.this.mCurAdData;
                if (nestAdData3 == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = nestAdData3.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                feedBannerShowListener2.onAdRemove(adType, string, requestId);
                WifiLog.d("adLayout ontouch direction = " + i2);
            }
        });
        TextView textView = new TextView(context);
        this.mChapterNameView = textView;
        textView.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView2 = this.mChapterNameView;
        if (textView2 == null) {
            Intrinsics.throwNpe();
        }
        textView2.setLines(1);
        try {
            TextView textView3 = this.mChapterNameView;
            if (textView3 == null) {
                Intrinsics.throwNpe();
            }
            textView3.setTextColor(Color.parseColor(chapterNameColor));
        } catch (Exception unused2) {
        }
        TextView textView4 = this.mChapterNameView;
        if (textView4 == null) {
            Intrinsics.throwNpe();
        }
        textView4.setTextSize(0, context.getResources().getDimension(R.dimen.sp_10));
        TextView textView5 = this.mChapterNameView;
        if (textView5 == null) {
            Intrinsics.throwNpe();
        }
        textView5.setText("章节名称");
        TextView textView6 = this.mChapterNameView;
        if (textView6 == null) {
            Intrinsics.throwNpe();
        }
        textView6.setIncludeFontPadding(false);
        int i2 = (int) ((allWidth * 20) / 360.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i2;
        layoutParams.topMargin = (int) ((allHeight * 14) / 640.0f);
        layoutParams.gravity = 16;
        wifiLinearLayout.addView(this.mChapterNameView, layoutParams);
        if (this.mRenderType == 1) {
            TextView textView7 = new TextView(context);
            this.mLinkTextView = textView7;
            textView7.setEllipsize(TextUtils.TruncateAt.END);
            TextView textView8 = this.mLinkTextView;
            if (textView8 == null) {
                Intrinsics.throwNpe();
            }
            textView8.setLines(1);
            try {
                TextView textView9 = this.mLinkTextView;
                if (textView9 == null) {
                    Intrinsics.throwNpe();
                }
                textView9.setTextColor(Color.parseColor(textLinkColor));
            } catch (Exception unused3) {
            }
            TextView textView10 = this.mLinkTextView;
            if (textView10 == null) {
                Intrinsics.throwNpe();
            }
            textView10.setTextSize(0, context.getResources().getDimension(R.dimen.sp_31));
            TextView textView11 = this.mLinkTextView;
            if (textView11 == null) {
                Intrinsics.throwNpe();
            }
            textView11.setText("测试文字链");
            TextView textView12 = this.mLinkTextView;
            if (textView12 == null) {
                Intrinsics.throwNpe();
            }
            textView12.setTypeface(Typeface.DEFAULT_BOLD);
            TextView textView13 = this.mLinkTextView;
            if (textView13 == null) {
                Intrinsics.throwNpe();
            }
            textView13.setIncludeFontPadding(false);
            int i3 = (int) ((allWidth * 28) / 360.0f);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = i3;
            layoutParams2.rightMargin = i3;
            layoutParams2.topMargin = (int) ((allHeight * 22) / 640.0f);
            layoutParams2.gravity = 16;
            wifiLinearLayout.addView(this.mLinkTextView, layoutParams2);
            RelativeLayout relativeLayout = new RelativeLayout(context);
            float f = allHeight;
            int i4 = ((allHeight - ((int) (0.1515625f * f))) - ((int) (0.2078125f * f))) - ((int) (0.03125f * f));
            float f2 = allWidth;
            int i5 = (int) (f2 * 0.13333334f);
            int i6 = (int) (f2 * 0.13055556f);
            int i7 = (int) (f * 0.0234375f);
            int i8 = (allWidth - i5) - i6;
            int i9 = (int) (i8 * 1.7777778f);
            if (i9 <= i4) {
                i4 = i9;
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i8, i4);
            layoutParams3.leftMargin = i5;
            layoutParams3.rightMargin = i6;
            layoutParams3.topMargin = i7;
            wifiLinearLayout.addView(relativeLayout, layoutParams3);
            relativeLayout.setBackgroundResource(R.drawable.shape_chapter_ad_main_bg);
            WkChapterAdSdkView wkChapterAdSdkView = new WkChapterAdSdkView(context);
            this.mSdkView = wkChapterAdSdkView;
            relativeLayout.addView(wkChapterAdSdkView, new FrameLayout.LayoutParams(-1, -1));
            List<View> list = this.mAllClicks;
            WkChapterAdSdkView wkChapterAdSdkView2 = this.mSdkView;
            if (wkChapterAdSdkView2 == null) {
                Intrinsics.throwNpe();
            }
            list.add(wkChapterAdSdkView2);
            WifiLog.d("H5ChapterAd WkChapterAdView adView.addView mSdkView");
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(5);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(10);
            layoutParams4.addRule(11);
            relativeLayout.addView(linearLayout, layoutParams4);
            LinearLayout linearLayout2 = new LinearLayout(context);
            this.closeLayout = linearLayout2;
            linearLayout2.setGravity(16);
            LinearLayout linearLayout3 = this.closeLayout;
            if (linearLayout3 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout3.setOrientation(0);
            LinearLayout linearLayout4 = this.closeLayout;
            if (linearLayout4 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout4.setBackgroundResource(R.drawable.shape_chapter_ad_close_bg);
            int i10 = (int) (f * 0.025f);
            int i11 = (int) (f2 * 0.033333335f);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, i10);
            layoutParams5.topMargin = i11;
            layoutParams5.rightMargin = i11;
            linearLayout.addView(this.closeLayout, layoutParams5);
            ImageView imageView = new ImageView(context);
            this.mSmallDsp = imageView;
            imageView.setImageResource(R.drawable.icon_dsp_360);
            int i12 = (int) ((allWidth * 10) / 360.0f);
            int i13 = (int) ((allWidth * 4) / 360.0f);
            FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, i12);
            layoutParams6.leftMargin = i13;
            layoutParams6.rightMargin = i13;
            LinearLayout linearLayout5 = this.closeLayout;
            if (linearLayout5 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout5.addView(this.mSmallDsp, layoutParams6);
            TextView textView14 = new TextView(context);
            textView14.setText(WifiNestAd.INSTANCE.getMPersonalizedAd() ? "个性化广告" : "广告");
            Resources resources = context.getResources();
            int i14 = R.dimen.sp_10;
            textView14.setTextSize(0, resources.getDimension(i14));
            textView14.setTextColor(Color.parseColor("#ffdbdbdb"));
            LinearLayout linearLayout6 = this.closeLayout;
            if (linearLayout6 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout6.addView(textView14, new LinearLayout.LayoutParams(-2, -2));
            ImageView imageView2 = new ImageView(context);
            imageView2.setImageResource(R.drawable.icon_chapter_ad_down_arrow);
            int i15 = (int) ((allWidth * 6) / 360.0f);
            int i16 = (int) ((allHeight * 4) / 640.0f);
            FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(i15, i16);
            layoutParams7.leftMargin = i16;
            layoutParams7.rightMargin = i16;
            LinearLayout linearLayout7 = this.closeLayout;
            if (linearLayout7 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout7.addView(imageView2, layoutParams7);
            TextView textView15 = new TextView(context);
            this.mDislikeView = textView15;
            textView15.setTextColor(Color.parseColor("#ffdbdbdb"));
            TextView textView16 = this.mDislikeView;
            if (textView16 == null) {
                Intrinsics.throwNpe();
            }
            textView16.setTextSize(0, context.getResources().getDimension(R.dimen.sp_12));
            TextView textView17 = this.mDislikeView;
            if (textView17 == null) {
                Intrinsics.throwNpe();
            }
            textView17.setText("不感兴趣");
            TextView textView18 = this.mDislikeView;
            if (textView18 == null) {
                Intrinsics.throwNpe();
            }
            textView18.setBackgroundResource(R.drawable.icon_chapter_ad_dislike_bg);
            int i17 = (int) ((allWidth * 5) / 360.0f);
            int i18 = (int) ((allWidth * 3) / 360.0f);
            int i19 = (int) ((allWidth * 12) / 360.0f);
            int i20 = (int) ((allHeight * 3) / 640.0f);
            TextView textView19 = this.mDislikeView;
            if (textView19 == null) {
                Intrinsics.throwNpe();
            }
            textView19.setPadding(i12, i17, i12, i18);
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams8.rightMargin = i19;
            layoutParams8.topMargin = i20;
            layoutParams8.addRule(14);
            linearLayout.addView(this.mDislikeView, layoutParams8);
            TextView textView20 = this.mDislikeView;
            if (textView20 == null) {
                Intrinsics.throwNpe();
            }
            textView20.setVisibility(8);
            LinearLayout linearLayout8 = new LinearLayout(context);
            NestAdData nestAdData = this.mCurAdData;
            if (nestAdData == null) {
                Intrinsics.throwNpe();
            }
            Integer adMode = nestAdData.getAdMode();
            if (adMode != null && adMode.intValue() == 4) {
                linearLayout8.setBackgroundResource(R.drawable.shape_horizontal_ad_compliance_bg);
            } else {
                linearLayout8.setBackgroundResource(R.drawable.shape_vertical_ad_compliance_bg);
            }
            linearLayout8.setOrientation(1);
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams9.addRule(12);
            relativeLayout.addView(linearLayout8, layoutParams9);
            TextView textView21 = new TextView(context);
            this.mTitleView = textView21;
            this.mAllClicks.add(textView21);
            TextView textView22 = this.mTitleView;
            if (textView22 == null) {
                Intrinsics.throwNpe();
            }
            textView22.setEllipsize(TextUtils.TruncateAt.END);
            TextView textView23 = this.mTitleView;
            if (textView23 == null) {
                Intrinsics.throwNpe();
            }
            textView23.setLines(1);
            TextView textView24 = this.mTitleView;
            if (textView24 == null) {
                Intrinsics.throwNpe();
            }
            textView24.setTextColor(-1);
            TextView textView25 = this.mTitleView;
            if (textView25 == null) {
                Intrinsics.throwNpe();
            }
            Resources resources2 = context.getResources();
            int i21 = R.dimen.sp_11;
            textView25.setTextSize(0, resources2.getDimension(i21));
            TextView textView26 = this.mTitleView;
            if (textView26 == null) {
                Intrinsics.throwNpe();
            }
            textView26.setText("点击发现更多精彩内容");
            TextView textView27 = this.mTitleView;
            if (textView27 == null) {
                Intrinsics.throwNpe();
            }
            textView27.setIncludeFontPadding(false);
            int i22 = (int) ((allWidth * 15) / 360.0f);
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams10.leftMargin = i22;
            layoutParams10.rightMargin = i22;
            layoutParams10.topMargin = i22;
            layoutParams10.gravity = 16;
            linearLayout8.addView(this.mTitleView, layoutParams10);
            TextView textView28 = new TextView(context);
            this.mDescView = textView28;
            this.mAllClicks.add(textView28);
            TextView textView29 = this.mDescView;
            if (textView29 == null) {
                Intrinsics.throwNpe();
            }
            textView29.setEllipsize(TextUtils.TruncateAt.END);
            TextView textView30 = this.mDescView;
            if (textView30 == null) {
                Intrinsics.throwNpe();
            }
            textView30.setMaxLines(2);
            TextView textView31 = this.mDescView;
            if (textView31 == null) {
                Intrinsics.throwNpe();
            }
            textView31.setTextColor(Color.parseColor("#e5e5e5"));
            TextView textView32 = this.mDescView;
            if (textView32 == null) {
                Intrinsics.throwNpe();
            }
            textView32.setTextSize(0, context.getResources().getDimension(i21));
            TextView textView33 = this.mDescView;
            if (textView33 == null) {
                Intrinsics.throwNpe();
            }
            textView33.setText("点击发现更多精彩内容");
            TextView textView34 = this.mDescView;
            if (textView34 == null) {
                Intrinsics.throwNpe();
            }
            textView34.setIncludeFontPadding(false);
            LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams11.leftMargin = i22;
            layoutParams11.rightMargin = i22;
            layoutParams11.topMargin = i16;
            layoutParams11.gravity = 16;
            linearLayout8.addView(this.mDescView, layoutParams11);
            LinearLayout linearLayout9 = new LinearLayout(context);
            this.complianceContainerView = linearLayout9;
            linearLayout9.setOrientation(1);
            RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams12.leftMargin = i22;
            layoutParams12.rightMargin = i22;
            linearLayout8.addView(this.complianceContainerView, layoutParams12);
            LinearLayout linearLayout10 = new LinearLayout(context);
            this.permissionsPrivacyContainerView = linearLayout10;
            linearLayout10.setOrientation(0);
            RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams13.topMargin = i19;
            LinearLayout linearLayout11 = this.complianceContainerView;
            if (linearLayout11 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout11.addView(this.permissionsPrivacyContainerView, layoutParams13);
            TextView textView35 = new TextView(context);
            this.mPermissionsView = textView35;
            textView35.setAlpha(1.0f);
            TextView textView36 = this.mPermissionsView;
            if (textView36 == null) {
                Intrinsics.throwNpe();
            }
            textView36.setTextColor(Color.parseColor("#e5e5e5"));
            TextView textView37 = this.mPermissionsView;
            if (textView37 == null) {
                Intrinsics.throwNpe();
            }
            textView37.setTextSize(0, context.getResources().getDimension(i14));
            TextView textView38 = this.mPermissionsView;
            if (textView38 == null) {
                Intrinsics.throwNpe();
            }
            int i23 = R.drawable.video_first_ad_permission_privacy_bg;
            textView38.setBackgroundResource(i23);
            TextView textView39 = this.mPermissionsView;
            if (textView39 == null) {
                Intrinsics.throwNpe();
            }
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwNpe();
            }
            textView39.setText(context2.getString(R.string.ad_permission_list));
            TextView textView40 = this.mPermissionsView;
            if (textView40 == null) {
                Intrinsics.throwNpe();
            }
            textView40.setIncludeFontPadding(false);
            TextView textView41 = this.mPermissionsView;
            if (textView41 == null) {
                Intrinsics.throwNpe();
            }
            int i24 = (int) ((allWidth * 16) / 360.0f);
            textView41.setMinHeight(i24);
            TextView textView42 = this.mPermissionsView;
            if (textView42 == null) {
                Intrinsics.throwNpe();
            }
            textView42.setPadding(i13, 0, i13, 0);
            TextView textView43 = this.mPermissionsView;
            if (textView43 == null) {
                Intrinsics.throwNpe();
            }
            textView43.setGravity(17);
            LinearLayout linearLayout12 = this.permissionsPrivacyContainerView;
            if (linearLayout12 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout12.addView(this.mPermissionsView, -2, -2);
            TextView textView44 = new TextView(context);
            this.mPrivacyView = textView44;
            textView44.setAlpha(1.0f);
            TextView textView45 = this.mPrivacyView;
            if (textView45 == null) {
                Intrinsics.throwNpe();
            }
            textView45.setTextColor(Color.parseColor("#e5e5e5"));
            TextView textView46 = this.mPrivacyView;
            if (textView46 == null) {
                Intrinsics.throwNpe();
            }
            textView46.setTextSize(0, context.getResources().getDimension(i14));
            TextView textView47 = this.mPrivacyView;
            if (textView47 == null) {
                Intrinsics.throwNpe();
            }
            textView47.setBackgroundResource(i23);
            TextView textView48 = this.mPrivacyView;
            if (textView48 == null) {
                Intrinsics.throwNpe();
            }
            Context context3 = this.mContext;
            if (context3 == null) {
                Intrinsics.throwNpe();
            }
            textView48.setText(context3.getString(R.string.ad_privacy));
            TextView textView49 = this.mPrivacyView;
            if (textView49 == null) {
                Intrinsics.throwNpe();
            }
            textView49.setIncludeFontPadding(false);
            TextView textView50 = this.mPrivacyView;
            if (textView50 == null) {
                Intrinsics.throwNpe();
            }
            textView50.setMinHeight(i24);
            TextView textView51 = this.mPrivacyView;
            if (textView51 == null) {
                Intrinsics.throwNpe();
            }
            textView51.setPadding(i13, 0, i13, 0);
            LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams14.leftMargin = (int) ((allWidth * 8) / 360.0f);
            TextView textView52 = this.mPrivacyView;
            if (textView52 == null) {
                Intrinsics.throwNpe();
            }
            textView52.setGravity(17);
            LinearLayout linearLayout13 = this.permissionsPrivacyContainerView;
            if (linearLayout13 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout13.addView(this.mPrivacyView, layoutParams14);
            LinearLayout linearLayout14 = new LinearLayout(context);
            this.appInfoContainerView = linearLayout14;
            this.mAllClicks.add(linearLayout14);
            LinearLayout linearLayout15 = this.appInfoContainerView;
            if (linearLayout15 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout15.setOrientation(0);
            RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams15.topMargin = i15;
            LinearLayout linearLayout16 = this.complianceContainerView;
            if (linearLayout16 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout16.addView(this.appInfoContainerView, layoutParams15);
            TextView textView53 = new TextView(context);
            this.mDeveloperView = textView53;
            this.mAllClicks.add(textView53);
            TextView textView54 = this.mDeveloperView;
            if (textView54 == null) {
                Intrinsics.throwNpe();
            }
            textView54.setAlpha(0.7f);
            TextView textView55 = this.mDeveloperView;
            if (textView55 == null) {
                Intrinsics.throwNpe();
            }
            textView55.setEllipsize(TextUtils.TruncateAt.END);
            TextView textView56 = this.mDeveloperView;
            if (textView56 == null) {
                Intrinsics.throwNpe();
            }
            textView56.setMaxWidth((int) ((allWidth * 120) / 360.0f));
            TextView textView57 = this.mDeveloperView;
            if (textView57 == null) {
                Intrinsics.throwNpe();
            }
            textView57.setTextColor(Color.parseColor("#ffffff"));
            TextView textView58 = this.mDeveloperView;
            if (textView58 == null) {
                Intrinsics.throwNpe();
            }
            textView58.setTextSize(0, context.getResources().getDimension(i14));
            TextView textView59 = this.mDeveloperView;
            if (textView59 == null) {
                Intrinsics.throwNpe();
            }
            textView59.setText("浙江简信科技有限公司");
            TextView textView60 = this.mDeveloperView;
            if (textView60 == null) {
                Intrinsics.throwNpe();
            }
            textView60.setIncludeFontPadding(false);
            TextView textView61 = this.mDeveloperView;
            if (textView61 == null) {
                Intrinsics.throwNpe();
            }
            textView61.setSingleLine(true);
            LinearLayout linearLayout17 = this.appInfoContainerView;
            if (linearLayout17 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout17.addView(this.mDeveloperView, -2, -2);
            TextView textView62 = new TextView(context);
            this.mVersionView = textView62;
            this.mAllClicks.add(textView62);
            TextView textView63 = this.mVersionView;
            if (textView63 == null) {
                Intrinsics.throwNpe();
            }
            textView63.setAlpha(0.7f);
            TextView textView64 = this.mVersionView;
            if (textView64 == null) {
                Intrinsics.throwNpe();
            }
            textView64.setTextColor(Color.parseColor("#ffffff"));
            TextView textView65 = this.mVersionView;
            if (textView65 == null) {
                Intrinsics.throwNpe();
            }
            textView65.setTextSize(0, context.getResources().getDimension(i14));
            TextView textView66 = this.mVersionView;
            if (textView66 == null) {
                Intrinsics.throwNpe();
            }
            textView66.setText("版本号：5.2.3");
            TextView textView67 = this.mVersionView;
            if (textView67 == null) {
                Intrinsics.throwNpe();
            }
            textView67.setIncludeFontPadding(false);
            TextView textView68 = this.mVersionView;
            if (textView68 == null) {
                Intrinsics.throwNpe();
            }
            textView68.setSingleLine(true);
            RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams16.leftMargin = i12;
            LinearLayout linearLayout18 = this.appInfoContainerView;
            if (linearLayout18 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout18.addView(this.mVersionView, layoutParams16);
            TextView textView69 = new TextView(context);
            this.mBtnView = textView69;
            this.mAllClicks.add(textView69);
            try {
                TextView textView70 = this.mBtnView;
                if (textView70 == null) {
                    Intrinsics.throwNpe();
                }
                textView70.setTextColor(Color.parseColor(downloadBtnTextColor));
            } catch (Exception unused4) {
                TextView textView71 = this.mBtnView;
                if (textView71 == null) {
                    Intrinsics.throwNpe();
                }
                textView71.setTextColor(Color.parseColor("#FFFFFF"));
            }
            TextView textView72 = this.mBtnView;
            if (textView72 == null) {
                Intrinsics.throwNpe();
            }
            textView72.setTextSize(0, context.getResources().getDimension(R.dimen.sp_11));
            TextView textView73 = this.mBtnView;
            if (textView73 == null) {
                Intrinsics.throwNpe();
            }
            textView73.setText("立即下载");
            TextView textView74 = this.mBtnView;
            if (textView74 == null) {
                Intrinsics.throwNpe();
            }
            textView74.setGravity(17);
            GradientDrawable gradientDrawable = new GradientDrawable();
            try {
                gradientDrawable.setColor(Color.parseColor(downloadBtnBgColor));
            } catch (Exception unused5) {
                gradientDrawable.setColor(Color.parseColor("#D33C33"));
            }
            ScreenUtil screenUtil = ScreenUtil.INSTANCE;
            if (this.mContext == null) {
                Intrinsics.throwNpe();
            }
            gradientDrawable.setCornerRadius(screenUtil.dp2px(r6, 13.0f));
            TextView textView75 = this.mBtnView;
            if (textView75 == null) {
                Intrinsics.throwNpe();
            }
            textView75.setBackgroundDrawable(gradientDrawable);
            int i25 = (int) ((allWidth * 18) / 360.0f);
            LinearLayout.LayoutParams layoutParams17 = new LinearLayout.LayoutParams((i8 - i25) - i2, (int) ((allHeight * 35) / 640.0f));
            layoutParams17.topMargin = (int) ((allHeight * 12) / 640.0f);
            layoutParams17.bottomMargin = i25;
            layoutParams17.leftMargin = i25;
            layoutParams17.rightMargin = i2;
            linearLayout8.addView(this.mBtnView, layoutParams17);
            TextView textView76 = new TextView(context);
            this.mRewardBtnView = textView76;
            textView76.setLines(1);
            try {
                TextView textView77 = this.mRewardBtnView;
                if (textView77 == null) {
                    Intrinsics.throwNpe();
                }
                textView77.setTextColor(Color.parseColor(rewardBtnTextColor));
            } catch (Exception unused6) {
                TextView textView78 = this.mRewardBtnView;
                if (textView78 == null) {
                    Intrinsics.throwNpe();
                }
                textView78.setTextColor(Color.parseColor("#D33C33"));
            }
            TextView textView79 = this.mRewardBtnView;
            if (textView79 == null) {
                Intrinsics.throwNpe();
            }
            textView79.setTextSize(0, context.getResources().getDimension(R.dimen.sp_14));
            TextView textView80 = this.mRewardBtnView;
            if (textView80 == null) {
                Intrinsics.throwNpe();
            }
            textView80.setText("测试激励视频");
            TextView textView81 = this.mRewardBtnView;
            if (textView81 == null) {
                Intrinsics.throwNpe();
            }
            textView81.setGravity(17);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            try {
                gradientDrawable2.setColor(Color.parseColor(rewardBtnBgColor));
            } catch (Exception unused7) {
                gradientDrawable2.setColor(Color.parseColor("#EDE1CA"));
            }
            ScreenUtil screenUtil2 = ScreenUtil.INSTANCE;
            if (this.mContext == null) {
                Intrinsics.throwNpe();
            }
            gradientDrawable2.setCornerRadius(screenUtil2.dp2px(r5, 13.0f));
            try {
                Context context4 = this.mContext;
                if (context4 == null) {
                    Intrinsics.throwNpe();
                }
                gradientDrawable2.setStroke(screenUtil2.dp2px(context4, 1.0f), Color.parseColor(rewardBtnStrokeColor));
            } catch (Exception unused8) {
                ScreenUtil screenUtil3 = ScreenUtil.INSTANCE;
                Context context5 = this.mContext;
                if (context5 == null) {
                    Intrinsics.throwNpe();
                }
                gradientDrawable2.setStroke(screenUtil3.dp2px(context5, 1.0f), Color.parseColor("#D33C33"));
            }
            TextView textView82 = this.mRewardBtnView;
            if (textView82 == null) {
                Intrinsics.throwNpe();
            }
            textView82.setBackgroundDrawable(gradientDrawable2);
            int i26 = (int) ((allWidth * 75) / 360.0f);
            LinearLayout.LayoutParams layoutParams18 = new LinearLayout.LayoutParams(-1, (int) ((allHeight * 38) / 640.0f));
            layoutParams18.leftMargin = i26;
            layoutParams18.rightMargin = i26;
            layoutParams18.topMargin = (int) ((allHeight * 19) / 640.0f);
            layoutParams18.gravity = 16;
            wifiLinearLayout.addView(this.mRewardBtnView, layoutParams18);
            feedBannerShowListener = showListener;
            i = renderType;
        } else {
            TextView textView83 = new TextView(context);
            this.mLinkTextView = textView83;
            textView83.setEllipsize(TextUtils.TruncateAt.END);
            TextView textView84 = this.mLinkTextView;
            if (textView84 == null) {
                Intrinsics.throwNpe();
            }
            textView84.setLines(1);
            try {
                TextView textView85 = this.mLinkTextView;
                if (textView85 == null) {
                    Intrinsics.throwNpe();
                }
                textView85.setTextColor(Color.parseColor(textLinkColor));
            } catch (Exception unused9) {
            }
            TextView textView86 = this.mLinkTextView;
            if (textView86 == null) {
                Intrinsics.throwNpe();
            }
            textView86.setTextSize(0, context.getResources().getDimension(R.dimen.sp_31));
            TextView textView87 = this.mLinkTextView;
            if (textView87 == null) {
                Intrinsics.throwNpe();
            }
            textView87.setText("测试文字链");
            TextView textView88 = this.mLinkTextView;
            if (textView88 == null) {
                Intrinsics.throwNpe();
            }
            textView88.setTypeface(Typeface.DEFAULT_BOLD);
            TextView textView89 = this.mLinkTextView;
            if (textView89 == null) {
                Intrinsics.throwNpe();
            }
            textView89.setIncludeFontPadding(false);
            int i27 = (int) ((allWidth * 28) / 360.0f);
            LinearLayout.LayoutParams layoutParams19 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams19.leftMargin = i27;
            layoutParams19.rightMargin = i27;
            layoutParams19.topMargin = (int) ((allHeight * 89) / 640.0f);
            layoutParams19.gravity = 16;
            wifiLinearLayout.addView(this.mLinkTextView, layoutParams19);
            LinearLayout linearLayout19 = new LinearLayout(context);
            this.mAllClicks.add(linearLayout19);
            linearLayout19.setOrientation(1);
            float f3 = allHeight;
            int i28 = (int) (0.025f * f3);
            int i29 = (int) (f3 * 0.01875f);
            LinearLayout.LayoutParams layoutParams20 = new LinearLayout.LayoutParams(allWidth, -2);
            layoutParams20.topMargin = i28;
            linearLayout19.setPadding(0, 0, 0, i29);
            wifiLinearLayout.addView(linearLayout19, layoutParams20);
            try {
                linearLayout19.setBackgroundColor(Color.parseColor(contentBgColor));
            } catch (Exception unused10) {
            }
            RelativeLayout relativeLayout2 = new RelativeLayout(context);
            float f4 = allWidth;
            int i30 = (int) (0.041666668f * f4);
            FrameLayout.LayoutParams layoutParams21 = new FrameLayout.LayoutParams(allWidth - (i30 * 2), (int) (0.5625f * f4));
            layoutParams21.leftMargin = i30;
            layoutParams21.rightMargin = i30;
            layoutParams21.topMargin = i29;
            linearLayout19.addView(relativeLayout2, layoutParams21);
            WkChapterAdSdkView wkChapterAdSdkView3 = new WkChapterAdSdkView(context);
            this.mSdkView = wkChapterAdSdkView3;
            this.mAllClicks.add(wkChapterAdSdkView3);
            relativeLayout2.addView(this.mSdkView, new FrameLayout.LayoutParams(-1, -1));
            WifiLog.d("H5ChapterAd WkChapterAdView adView.addView mSdkView");
            LinearLayout linearLayout20 = new LinearLayout(context);
            linearLayout20.setOrientation(1);
            linearLayout20.setGravity(5);
            RelativeLayout.LayoutParams layoutParams22 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams22.addRule(10);
            layoutParams22.addRule(11);
            relativeLayout2.addView(linearLayout20, layoutParams22);
            LinearLayout linearLayout21 = new LinearLayout(context);
            this.closeLayout = linearLayout21;
            linearLayout21.setGravity(16);
            LinearLayout linearLayout22 = this.closeLayout;
            if (linearLayout22 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout22.setOrientation(0);
            LinearLayout linearLayout23 = this.closeLayout;
            if (linearLayout23 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout23.setBackgroundResource(R.drawable.shape_chapter_ad_close_bg);
            int i31 = (int) (f4 * 0.033333335f);
            RelativeLayout.LayoutParams layoutParams23 = new RelativeLayout.LayoutParams(-2, i28);
            layoutParams23.topMargin = i31;
            layoutParams23.rightMargin = i31;
            linearLayout20.addView(this.closeLayout, layoutParams23);
            ImageView imageView3 = new ImageView(context);
            this.mSmallDsp = imageView3;
            imageView3.setImageResource(R.drawable.icon_dsp_360);
            int i32 = (int) ((allWidth * 10) / 360.0f);
            int i33 = (int) ((allWidth * 4) / 360.0f);
            FrameLayout.LayoutParams layoutParams24 = new FrameLayout.LayoutParams(-2, i32);
            layoutParams24.leftMargin = i33;
            layoutParams24.rightMargin = i33;
            LinearLayout linearLayout24 = this.closeLayout;
            if (linearLayout24 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout24.addView(this.mSmallDsp, layoutParams24);
            TextView textView90 = new TextView(context);
            textView90.setText(WifiNestAd.INSTANCE.getMPersonalizedAd() ? "个性化广告" : "广告");
            Resources resources3 = context.getResources();
            int i34 = R.dimen.sp_10;
            textView90.setTextSize(0, resources3.getDimension(i34));
            textView90.setTextColor(Color.parseColor("#ffdbdbdb"));
            LinearLayout linearLayout25 = this.closeLayout;
            if (linearLayout25 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout25.addView(textView90, new LinearLayout.LayoutParams(-2, -2));
            ImageView imageView4 = new ImageView(context);
            imageView4.setImageResource(R.drawable.icon_chapter_ad_down_arrow);
            int i35 = (int) ((allHeight * 4) / 640.0f);
            FrameLayout.LayoutParams layoutParams25 = new FrameLayout.LayoutParams((int) ((allWidth * 6) / 360.0f), i35);
            layoutParams25.leftMargin = i35;
            layoutParams25.rightMargin = i35;
            LinearLayout linearLayout26 = this.closeLayout;
            if (linearLayout26 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout26.addView(imageView4, layoutParams25);
            TextView textView91 = new TextView(context);
            this.mDislikeView = textView91;
            textView91.setTextColor(Color.parseColor("#ffdbdbdb"));
            TextView textView92 = this.mDislikeView;
            if (textView92 == null) {
                Intrinsics.throwNpe();
            }
            textView92.setTextSize(0, context.getResources().getDimension(R.dimen.sp_12));
            TextView textView93 = this.mDislikeView;
            if (textView93 == null) {
                Intrinsics.throwNpe();
            }
            textView93.setText("不感兴趣");
            TextView textView94 = this.mDislikeView;
            if (textView94 == null) {
                Intrinsics.throwNpe();
            }
            textView94.setBackgroundResource(R.drawable.icon_chapter_ad_dislike_bg);
            int i36 = (int) ((allWidth * 5) / 360.0f);
            int i37 = (int) ((allWidth * 3) / 360.0f);
            int i38 = (int) ((allWidth * 12) / 360.0f);
            int i39 = (int) ((allHeight * 3) / 640.0f);
            TextView textView95 = this.mDislikeView;
            if (textView95 == null) {
                Intrinsics.throwNpe();
            }
            textView95.setPadding(i32, i36, i32, i37);
            RelativeLayout.LayoutParams layoutParams26 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams26.rightMargin = i38;
            layoutParams26.topMargin = i39;
            layoutParams26.addRule(14);
            linearLayout20.addView(this.mDislikeView, layoutParams26);
            TextView textView96 = this.mDislikeView;
            if (textView96 == null) {
                Intrinsics.throwNpe();
            }
            textView96.setVisibility(8);
            LinearLayout linearLayout27 = new LinearLayout(context);
            this.complianceContainerView = linearLayout27;
            linearLayout27.setBackgroundResource(R.drawable.shape_horizontal_ad_compliance_bg);
            LinearLayout linearLayout28 = this.complianceContainerView;
            if (linearLayout28 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout28.setOrientation(1);
            int i40 = (int) ((allWidth * 8) / 360.0f);
            int i41 = (int) ((allWidth * 14) / 360.0f);
            LinearLayout linearLayout29 = this.complianceContainerView;
            if (linearLayout29 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout29.setPadding(i40, i41, i40, i40);
            RelativeLayout.LayoutParams layoutParams27 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams27.addRule(12);
            layoutParams27.addRule(9);
            relativeLayout2.addView(this.complianceContainerView, layoutParams27);
            LinearLayout linearLayout30 = new LinearLayout(context);
            this.permissionsPrivacyContainerView = linearLayout30;
            linearLayout30.setOrientation(0);
            LinearLayout linearLayout31 = this.complianceContainerView;
            if (linearLayout31 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout31.addView(this.permissionsPrivacyContainerView, -2, -2);
            TextView textView97 = new TextView(context);
            this.mPermissionsView = textView97;
            textView97.setAlpha(1.0f);
            TextView textView98 = this.mPermissionsView;
            if (textView98 == null) {
                Intrinsics.throwNpe();
            }
            textView98.setTextColor(Color.parseColor("#e5e5e5"));
            TextView textView99 = this.mPermissionsView;
            if (textView99 == null) {
                Intrinsics.throwNpe();
            }
            textView99.setTextSize(0, context.getResources().getDimension(i34));
            TextView textView100 = this.mPermissionsView;
            if (textView100 == null) {
                Intrinsics.throwNpe();
            }
            int i42 = R.drawable.video_first_ad_permission_privacy_bg;
            textView100.setBackgroundResource(i42);
            TextView textView101 = this.mPermissionsView;
            if (textView101 == null) {
                Intrinsics.throwNpe();
            }
            Context context6 = this.mContext;
            if (context6 == null) {
                Intrinsics.throwNpe();
            }
            textView101.setText(context6.getString(R.string.ad_permission_list));
            TextView textView102 = this.mPermissionsView;
            if (textView102 == null) {
                Intrinsics.throwNpe();
            }
            textView102.setIncludeFontPadding(false);
            TextView textView103 = this.mPermissionsView;
            if (textView103 == null) {
                Intrinsics.throwNpe();
            }
            int i43 = (int) ((allWidth * 16) / 360.0f);
            textView103.setMinHeight(i43);
            TextView textView104 = this.mPermissionsView;
            if (textView104 == null) {
                Intrinsics.throwNpe();
            }
            textView104.setPadding(i33, 0, i33, 0);
            TextView textView105 = this.mPermissionsView;
            if (textView105 == null) {
                Intrinsics.throwNpe();
            }
            textView105.setGravity(17);
            LinearLayout linearLayout32 = this.permissionsPrivacyContainerView;
            if (linearLayout32 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout32.addView(this.mPermissionsView, -2, -2);
            TextView textView106 = new TextView(context);
            this.mPrivacyView = textView106;
            textView106.setAlpha(1.0f);
            TextView textView107 = this.mPrivacyView;
            if (textView107 == null) {
                Intrinsics.throwNpe();
            }
            textView107.setTextColor(Color.parseColor("#e5e5e5"));
            TextView textView108 = this.mPrivacyView;
            if (textView108 == null) {
                Intrinsics.throwNpe();
            }
            textView108.setTextSize(0, context.getResources().getDimension(i34));
            TextView textView109 = this.mPrivacyView;
            if (textView109 == null) {
                Intrinsics.throwNpe();
            }
            textView109.setBackgroundResource(i42);
            TextView textView110 = this.mPrivacyView;
            if (textView110 == null) {
                Intrinsics.throwNpe();
            }
            Context context7 = this.mContext;
            if (context7 == null) {
                Intrinsics.throwNpe();
            }
            textView110.setText(context7.getString(R.string.ad_privacy));
            TextView textView111 = this.mPrivacyView;
            if (textView111 == null) {
                Intrinsics.throwNpe();
            }
            textView111.setIncludeFontPadding(false);
            TextView textView112 = this.mPrivacyView;
            if (textView112 == null) {
                Intrinsics.throwNpe();
            }
            textView112.setMinHeight(i43);
            TextView textView113 = this.mPrivacyView;
            if (textView113 == null) {
                Intrinsics.throwNpe();
            }
            textView113.setPadding(i33, 0, i33, 0);
            LinearLayout.LayoutParams layoutParams28 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams28.leftMargin = i40;
            TextView textView114 = this.mPrivacyView;
            if (textView114 == null) {
                Intrinsics.throwNpe();
            }
            textView114.setGravity(17);
            LinearLayout linearLayout33 = this.permissionsPrivacyContainerView;
            if (linearLayout33 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout33.addView(this.mPrivacyView, layoutParams28);
            LinearLayout linearLayout34 = new LinearLayout(context);
            this.appInfoContainerView = linearLayout34;
            this.mAllClicks.add(linearLayout34);
            LinearLayout linearLayout35 = this.appInfoContainerView;
            if (linearLayout35 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout35.setOrientation(0);
            RelativeLayout.LayoutParams layoutParams29 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams29.topMargin = (int) ((allWidth * 7) / 360.0f);
            layoutParams29.bottomMargin = (int) ((allWidth * 9) / 360.0f);
            LinearLayout linearLayout36 = this.complianceContainerView;
            if (linearLayout36 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout36.addView(this.appInfoContainerView, layoutParams29);
            TextView textView115 = new TextView(context);
            this.mDeveloperView = textView115;
            this.mAllClicks.add(textView115);
            TextView textView116 = this.mDeveloperView;
            if (textView116 == null) {
                Intrinsics.throwNpe();
            }
            textView116.setAlpha(0.7f);
            TextView textView117 = this.mDeveloperView;
            if (textView117 == null) {
                Intrinsics.throwNpe();
            }
            textView117.setEllipsize(TextUtils.TruncateAt.END);
            TextView textView118 = this.mDeveloperView;
            if (textView118 == null) {
                Intrinsics.throwNpe();
            }
            textView118.setMaxWidth((int) ((allWidth * 120) / 360.0f));
            TextView textView119 = this.mDeveloperView;
            if (textView119 == null) {
                Intrinsics.throwNpe();
            }
            textView119.setTextColor(Color.parseColor("#ffffff"));
            TextView textView120 = this.mDeveloperView;
            if (textView120 == null) {
                Intrinsics.throwNpe();
            }
            textView120.setTextSize(0, context.getResources().getDimension(i34));
            TextView textView121 = this.mDeveloperView;
            if (textView121 == null) {
                Intrinsics.throwNpe();
            }
            textView121.setText("浙江简信科技有限公司");
            TextView textView122 = this.mDeveloperView;
            if (textView122 == null) {
                Intrinsics.throwNpe();
            }
            textView122.setIncludeFontPadding(false);
            TextView textView123 = this.mDeveloperView;
            if (textView123 == null) {
                Intrinsics.throwNpe();
            }
            textView123.setSingleLine(true);
            LinearLayout linearLayout37 = this.appInfoContainerView;
            if (linearLayout37 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout37.addView(this.mDeveloperView, -2, -2);
            TextView textView124 = new TextView(context);
            this.mVersionView = textView124;
            this.mAllClicks.add(textView124);
            TextView textView125 = this.mVersionView;
            if (textView125 == null) {
                Intrinsics.throwNpe();
            }
            textView125.setAlpha(0.7f);
            TextView textView126 = this.mVersionView;
            if (textView126 == null) {
                Intrinsics.throwNpe();
            }
            textView126.setTextColor(Color.parseColor("#ffffff"));
            TextView textView127 = this.mVersionView;
            if (textView127 == null) {
                Intrinsics.throwNpe();
            }
            textView127.setTextSize(0, context.getResources().getDimension(i34));
            TextView textView128 = this.mVersionView;
            if (textView128 == null) {
                Intrinsics.throwNpe();
            }
            textView128.setText("版本号：5.2.3");
            TextView textView129 = this.mVersionView;
            if (textView129 == null) {
                Intrinsics.throwNpe();
            }
            textView129.setIncludeFontPadding(false);
            TextView textView130 = this.mVersionView;
            if (textView130 == null) {
                Intrinsics.throwNpe();
            }
            textView130.setSingleLine(true);
            RelativeLayout.LayoutParams layoutParams30 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams30.leftMargin = i32;
            LinearLayout linearLayout38 = this.appInfoContainerView;
            if (linearLayout38 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout38.addView(this.mVersionView, layoutParams30);
            LinearLayout linearLayout39 = new LinearLayout(context);
            this.mAllClicks.add(linearLayout19);
            linearLayout39.setOrientation(0);
            linearLayout19.addView(linearLayout39);
            TextView textView131 = new TextView(context);
            this.mTitleView = textView131;
            this.mAllClicks.add(textView131);
            TextView textView132 = this.mTitleView;
            if (textView132 == null) {
                Intrinsics.throwNpe();
            }
            textView132.setEllipsize(TextUtils.TruncateAt.END);
            TextView textView133 = this.mTitleView;
            if (textView133 == null) {
                Intrinsics.throwNpe();
            }
            textView133.setLines(1);
            try {
                TextView textView134 = this.mTitleView;
                if (textView134 == null) {
                    Intrinsics.throwNpe();
                }
                textView134.setTextColor(Color.parseColor(adTitleTextColor));
            } catch (Exception unused11) {
            }
            TextView textView135 = this.mTitleView;
            if (textView135 == null) {
                Intrinsics.throwNpe();
            }
            textView135.setTextSize(0, context.getResources().getDimension(R.dimen.sp_15));
            TextView textView136 = this.mTitleView;
            if (textView136 == null) {
                Intrinsics.throwNpe();
            }
            textView136.setText("点击发现更多精彩内容");
            TextView textView137 = this.mTitleView;
            if (textView137 == null) {
                Intrinsics.throwNpe();
            }
            textView137.setIncludeFontPadding(false);
            int i44 = (int) ((allWidth * 15) / 360.0f);
            LinearLayout.LayoutParams layoutParams31 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams31.leftMargin = i44;
            layoutParams31.rightMargin = i44;
            layoutParams31.topMargin = (int) ((allHeight * 5) / 640.0f);
            layoutParams31.gravity = 16;
            layoutParams31.weight = 1.0f;
            linearLayout39.addView(this.mTitleView, layoutParams31);
            ImageView imageView5 = new ImageView(context);
            this.mCloseImg = imageView5;
            int i45 = (int) ((allWidth * 23) / 360.0f);
            imageView5.setImageResource(R.drawable.ic_chapter_ad_delete);
            FrameLayout.LayoutParams layoutParams32 = new FrameLayout.LayoutParams(i45, i45);
            layoutParams32.topMargin = i35;
            linearLayout39.addView(this.mCloseImg, layoutParams32);
            ImageView imageView6 = this.mCloseImg;
            if (imageView6 == null) {
                Intrinsics.throwNpe();
            }
            feedBannerShowListener = showListener;
            i = renderType;
            imageView6.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.chapterad.WkChapterAdView.initView.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedBannerShowListener feedBannerShowListener2 = feedBannerShowListener;
                    NestAdData nestAdData2 = WkChapterAdView.this.mCurAdData;
                    if (nestAdData2 == null) {
                        Intrinsics.throwNpe();
                    }
                    String adType = nestAdData2.getAdType();
                    if (adType == null) {
                        Intrinsics.throwNpe();
                    }
                    SdkStrategy.Companion companion = SdkStrategy.INSTANCE;
                    NestAdData nestAdData3 = WkChapterAdView.this.mCurAdData;
                    if (nestAdData3 == null) {
                        Intrinsics.throwNpe();
                    }
                    String strCreateStringByAdData = companion.createStringByAdData(nestAdData3);
                    if (strCreateStringByAdData == null) {
                        Intrinsics.throwNpe();
                    }
                    NestAdData nestAdData4 = WkChapterAdView.this.mCurAdData;
                    if (nestAdData4 == null) {
                        Intrinsics.throwNpe();
                    }
                    String requestId = nestAdData4.getRequestId();
                    if (requestId == null) {
                        Intrinsics.throwNpe();
                    }
                    feedBannerShowListener2.onAdCloseClick(adType, strCreateStringByAdData, requestId);
                    EventParams.Builder builder = new EventParams.Builder();
                    NestAdData nestAdData5 = WkChapterAdView.this.mCurAdData;
                    if (nestAdData5 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder nestSid = builder.setNestSid(nestAdData5.getNestSid());
                    NestAdData nestAdData6 = WkChapterAdView.this.mCurAdData;
                    if (nestAdData6 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder dspName = nestSid.setDspName(nestAdData6.getDspName());
                    NestAdData nestAdData7 = WkChapterAdView.this.mCurAdData;
                    if (nestAdData7 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder mediaId = dspName.setMediaId(nestAdData7.getAppId());
                    NestAdData nestAdData8 = WkChapterAdView.this.mCurAdData;
                    if (nestAdData8 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder srcId = mediaId.setSrcId(nestAdData8.getAdCode());
                    NestAdData nestAdData9 = WkChapterAdView.this.mCurAdData;
                    if (nestAdData9 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder inventoryId = srcId.setInventoryId(nestAdData9.getInventoryId());
                    NestAdData nestAdData10 = WkChapterAdView.this.mCurAdData;
                    if (nestAdData10 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder sdkFrom = inventoryId.setSdkFrom(nestAdData10.getSdkFrom());
                    NestAdData nestAdData11 = WkChapterAdView.this.mCurAdData;
                    if (nestAdData11 == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams.Builder renderStyle = sdkFrom.setRenderStyle(nestAdData11.getRenderStyle());
                    NestAdData nestAdData12 = WkChapterAdView.this.mCurAdData;
                    if (nestAdData12 == null) {
                        Intrinsics.throwNpe();
                    }
                    Object adMode2 = nestAdData12.getAdMode();
                    if (adMode2 == null) {
                        adMode2 = "";
                    }
                    EventParams.Builder adMode3 = renderStyle.setAdMode(adMode2.toString());
                    NestAdData nestAdData13 = WkChapterAdView.this.mCurAdData;
                    if (nestAdData13 == null) {
                        Intrinsics.throwNpe();
                    }
                    Integer adLevel = nestAdData13.getAdLevel();
                    if (adLevel == null) {
                        Intrinsics.throwNpe();
                    }
                    EventParams eventParams = adMode3.setAdLevel(adLevel.intValue()).setRenderType(i).build();
                    AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
                    Intrinsics.checkExpressionValueIsNotNull(eventParams, "eventParams");
                    NestAdData nestAdData14 = WkChapterAdView.this.mCurAdData;
                    if (nestAdData14 == null) {
                        Intrinsics.throwNpe();
                    }
                    AdParams adParams = nestAdData14.getAdParams();
                    if (adParams == null) {
                        Intrinsics.throwNpe();
                    }
                    reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_CLOSE_CLICK, eventParams, adParams.getExt());
                }
            });
            TextView textView138 = new TextView(context);
            this.mDescView = textView138;
            this.mAllClicks.add(textView138);
            TextView textView139 = this.mDescView;
            if (textView139 == null) {
                Intrinsics.throwNpe();
            }
            textView139.setEllipsize(TextUtils.TruncateAt.END);
            TextView textView140 = this.mDescView;
            if (textView140 == null) {
                Intrinsics.throwNpe();
            }
            textView140.setTypeface(Typeface.DEFAULT_BOLD);
            TextView textView141 = this.mDescView;
            if (textView141 == null) {
                Intrinsics.throwNpe();
            }
            textView141.setMaxLines(1);
            try {
                TextView textView142 = this.mDescView;
                if (textView142 == null) {
                    Intrinsics.throwNpe();
                }
                textView142.setTextColor(Color.parseColor(textLinkColor));
            } catch (Exception unused12) {
            }
            TextView textView143 = this.mDescView;
            if (textView143 == null) {
                Intrinsics.throwNpe();
            }
            textView143.setTextSize(0, context.getResources().getDimension(R.dimen.sp_15));
            TextView textView144 = this.mDescView;
            if (textView144 == null) {
                Intrinsics.throwNpe();
            }
            textView144.setText("点击发现更多精彩内容");
            TextView textView145 = this.mDescView;
            if (textView145 == null) {
                Intrinsics.throwNpe();
            }
            textView145.setIncludeFontPadding(false);
            int i46 = (int) ((allHeight * 8) / 640.0f);
            LinearLayout.LayoutParams layoutParams33 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams33.leftMargin = i44;
            layoutParams33.rightMargin = i44;
            layoutParams33.topMargin = i46;
            layoutParams33.gravity = 16;
            linearLayout19.addView(this.mDescView, layoutParams33);
            TextView textView146 = new TextView(context);
            this.mBtnView = textView146;
            this.mAllClicks.add(textView146);
            try {
                TextView textView147 = this.mBtnView;
                if (textView147 == null) {
                    Intrinsics.throwNpe();
                }
                textView147.setTextColor(Color.parseColor(downloadBtnTextColor));
            } catch (Exception unused13) {
                TextView textView148 = this.mBtnView;
                if (textView148 == null) {
                    Intrinsics.throwNpe();
                }
                textView148.setTextColor(Color.parseColor("#FFFFFF"));
            }
            TextView textView149 = this.mBtnView;
            if (textView149 == null) {
                Intrinsics.throwNpe();
            }
            textView149.setTextSize(0, context.getResources().getDimension(R.dimen.sp_15));
            TextView textView150 = this.mBtnView;
            if (textView150 == null) {
                Intrinsics.throwNpe();
            }
            textView150.setText("立即下载");
            TextView textView151 = this.mBtnView;
            if (textView151 == null) {
                Intrinsics.throwNpe();
            }
            textView151.setGravity(17);
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            try {
                gradientDrawable3.setColor(Color.parseColor(downloadBtnBgColor));
            } catch (Exception unused14) {
                gradientDrawable3.setColor(Color.parseColor("#D33C33"));
            }
            ScreenUtil screenUtil4 = ScreenUtil.INSTANCE;
            if (this.mContext == null) {
                Intrinsics.throwNpe();
            }
            gradientDrawable3.setCornerRadius(screenUtil4.dp2px(r11, 13.0f));
            TextView textView152 = this.mBtnView;
            if (textView152 == null) {
                Intrinsics.throwNpe();
            }
            textView152.setBackgroundDrawable(gradientDrawable3);
            LinearLayout.LayoutParams layoutParams34 = new LinearLayout.LayoutParams(allWidth - (i44 * 2), (int) ((allHeight * 31) / 640.0f));
            layoutParams34.topMargin = i46;
            layoutParams34.leftMargin = i44;
            layoutParams34.rightMargin = i44;
            linearLayout19.addView(this.mBtnView, layoutParams34);
            TextView textView153 = new TextView(context);
            this.mRewardBtnView = textView153;
            textView153.setLines(1);
            try {
                TextView textView154 = this.mRewardBtnView;
                if (textView154 == null) {
                    Intrinsics.throwNpe();
                }
                textView154.setTextColor(Color.parseColor(rewardBtnTextColor));
            } catch (Exception unused15) {
                TextView textView155 = this.mRewardBtnView;
                if (textView155 == null) {
                    Intrinsics.throwNpe();
                }
                textView155.setTextColor(Color.parseColor("#D33C33"));
            }
            TextView textView156 = this.mRewardBtnView;
            if (textView156 == null) {
                Intrinsics.throwNpe();
            }
            textView156.setTextSize(0, context.getResources().getDimension(R.dimen.sp_14));
            TextView textView157 = this.mRewardBtnView;
            if (textView157 == null) {
                Intrinsics.throwNpe();
            }
            textView157.setText("测试激励视频");
            TextView textView158 = this.mRewardBtnView;
            if (textView158 == null) {
                Intrinsics.throwNpe();
            }
            textView158.setGravity(17);
            GradientDrawable gradientDrawable4 = new GradientDrawable();
            try {
                gradientDrawable4.setColor(Color.parseColor(rewardBtnBgColor));
            } catch (Exception unused16) {
                gradientDrawable4.setColor(Color.parseColor("#EDE1CA"));
            }
            ScreenUtil screenUtil5 = ScreenUtil.INSTANCE;
            if (this.mContext == null) {
                Intrinsics.throwNpe();
            }
            gradientDrawable4.setCornerRadius(screenUtil5.dp2px(r5, 13.0f));
            try {
                Context context8 = this.mContext;
                if (context8 == null) {
                    Intrinsics.throwNpe();
                }
                gradientDrawable4.setStroke(screenUtil5.dp2px(context8, 1.0f), Color.parseColor(rewardBtnStrokeColor));
            } catch (Exception unused17) {
                ScreenUtil screenUtil6 = ScreenUtil.INSTANCE;
                Context context9 = this.mContext;
                if (context9 == null) {
                    Intrinsics.throwNpe();
                }
                gradientDrawable4.setStroke(screenUtil6.dp2px(context9, 1.0f), Color.parseColor("#D33C33"));
            }
            TextView textView159 = this.mRewardBtnView;
            if (textView159 == null) {
                Intrinsics.throwNpe();
            }
            textView159.setBackgroundDrawable(gradientDrawable4);
            int i47 = (int) ((allWidth * 75) / 360.0f);
            LinearLayout.LayoutParams layoutParams35 = new LinearLayout.LayoutParams(-1, (int) ((allHeight * 38) / 640.0f));
            layoutParams35.leftMargin = i47;
            layoutParams35.rightMargin = i47;
            layoutParams35.topMargin = (int) ((allHeight * 34) / 640.0f);
            layoutParams35.gravity = 16;
            wifiLinearLayout.addView(this.mRewardBtnView, layoutParams35);
        }
        NestAdData nestAdData2 = this.mCurAdData;
        if (nestAdData2 == null) {
            Intrinsics.throwNpe();
        }
        if (Intrinsics.areEqual(nestAdData2.getAdType(), SDKAlias.GDT.getType())) {
            TextView textView160 = this.mBtnView;
            if (textView160 == null) {
                Intrinsics.throwNpe();
            }
            textView160.setTag(WifiNestConst.OtherConst.TAG_AD_BUTTON);
        }
        TextView textView161 = this.mLinkTextView;
        if (textView161 == null) {
            Intrinsics.throwNpe();
        }
        textView161.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.chapterad.WkChapterAdView.initView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedBannerShowListener feedBannerShowListener2 = feedBannerShowListener;
                NestAdData nestAdData3 = WkChapterAdView.this.mCurAdData;
                if (nestAdData3 == null) {
                    Intrinsics.throwNpe();
                }
                String adType = nestAdData3.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                SdkStrategy.Companion companion = SdkStrategy.INSTANCE;
                NestAdData nestAdData4 = WkChapterAdView.this.mCurAdData;
                if (nestAdData4 == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = companion.createStringByAdData(nestAdData4);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                NestAdData nestAdData5 = WkChapterAdView.this.mCurAdData;
                if (nestAdData5 == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = nestAdData5.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                feedBannerShowListener2.onTextLinkClicked(adType, strCreateStringByAdData, requestId);
                EventParams.Builder builder = new EventParams.Builder();
                NestAdData nestAdData6 = WkChapterAdView.this.mCurAdData;
                if (nestAdData6 == null) {
                    Intrinsics.throwNpe();
                }
                EventParams.Builder nestSid = builder.setNestSid(nestAdData6.getNestSid());
                NestAdData nestAdData7 = WkChapterAdView.this.mCurAdData;
                if (nestAdData7 == null) {
                    Intrinsics.throwNpe();
                }
                EventParams.Builder dspName = nestSid.setDspName(nestAdData7.getDspName());
                NestAdData nestAdData8 = WkChapterAdView.this.mCurAdData;
                if (nestAdData8 == null) {
                    Intrinsics.throwNpe();
                }
                EventParams.Builder mediaId = dspName.setMediaId(nestAdData8.getAppId());
                NestAdData nestAdData9 = WkChapterAdView.this.mCurAdData;
                if (nestAdData9 == null) {
                    Intrinsics.throwNpe();
                }
                EventParams.Builder srcId = mediaId.setSrcId(nestAdData9.getAdCode());
                NestAdData nestAdData10 = WkChapterAdView.this.mCurAdData;
                if (nestAdData10 == null) {
                    Intrinsics.throwNpe();
                }
                EventParams.Builder inventoryId = srcId.setInventoryId(nestAdData10.getInventoryId());
                NestAdData nestAdData11 = WkChapterAdView.this.mCurAdData;
                if (nestAdData11 == null) {
                    Intrinsics.throwNpe();
                }
                EventParams.Builder sdkFrom = inventoryId.setSdkFrom(nestAdData11.getSdkFrom());
                NestAdData nestAdData12 = WkChapterAdView.this.mCurAdData;
                if (nestAdData12 == null) {
                    Intrinsics.throwNpe();
                }
                EventParams.Builder renderStyle = sdkFrom.setRenderStyle(nestAdData12.getRenderStyle());
                NestAdData nestAdData13 = WkChapterAdView.this.mCurAdData;
                if (nestAdData13 == null) {
                    Intrinsics.throwNpe();
                }
                Object adMode2 = nestAdData13.getAdMode();
                if (adMode2 == null) {
                    adMode2 = "";
                }
                EventParams.Builder adMode3 = renderStyle.setAdMode(adMode2.toString());
                NestAdData nestAdData14 = WkChapterAdView.this.mCurAdData;
                if (nestAdData14 == null) {
                    Intrinsics.throwNpe();
                }
                Integer adLevel = nestAdData14.getAdLevel();
                if (adLevel == null) {
                    Intrinsics.throwNpe();
                }
                EventParams eventParams = adMode3.setAdLevel(adLevel.intValue()).setRenderType(i).build();
                AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
                Intrinsics.checkExpressionValueIsNotNull(eventParams, "eventParams");
                NestAdData nestAdData15 = WkChapterAdView.this.mCurAdData;
                if (nestAdData15 == null) {
                    Intrinsics.throwNpe();
                }
                AdParams adParams = nestAdData15.getAdParams();
                if (adParams == null) {
                    Intrinsics.throwNpe();
                }
                reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_TEXT_LINK_CLICK, eventParams, adParams.getExt());
            }
        });
        TextView textView162 = this.mRewardBtnView;
        if (textView162 == null) {
            Intrinsics.throwNpe();
        }
        textView162.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.chapterad.WkChapterAdView.initView.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedBannerShowListener feedBannerShowListener2 = feedBannerShowListener;
                NestAdData nestAdData3 = WkChapterAdView.this.mCurAdData;
                if (nestAdData3 == null) {
                    Intrinsics.throwNpe();
                }
                String adType = nestAdData3.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                SdkStrategy.Companion companion = SdkStrategy.INSTANCE;
                NestAdData nestAdData4 = WkChapterAdView.this.mCurAdData;
                if (nestAdData4 == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = companion.createStringByAdData(nestAdData4);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                NestAdData nestAdData5 = WkChapterAdView.this.mCurAdData;
                if (nestAdData5 == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = nestAdData5.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                feedBannerShowListener2.onRewardBtnClick(adType, strCreateStringByAdData, requestId);
                if (rewardBtnClickHide == 1) {
                    TextView textView163 = WkChapterAdView.this.mRewardBtnView;
                    if (textView163 == null) {
                        Intrinsics.throwNpe();
                    }
                    textView163.setVisibility(8);
                }
                EventParams.Builder builder = new EventParams.Builder();
                NestAdData nestAdData6 = WkChapterAdView.this.mCurAdData;
                if (nestAdData6 == null) {
                    Intrinsics.throwNpe();
                }
                EventParams.Builder nestSid = builder.setNestSid(nestAdData6.getNestSid());
                NestAdData nestAdData7 = WkChapterAdView.this.mCurAdData;
                if (nestAdData7 == null) {
                    Intrinsics.throwNpe();
                }
                EventParams.Builder dspName = nestSid.setDspName(nestAdData7.getDspName());
                NestAdData nestAdData8 = WkChapterAdView.this.mCurAdData;
                if (nestAdData8 == null) {
                    Intrinsics.throwNpe();
                }
                EventParams.Builder mediaId = dspName.setMediaId(nestAdData8.getAppId());
                NestAdData nestAdData9 = WkChapterAdView.this.mCurAdData;
                if (nestAdData9 == null) {
                    Intrinsics.throwNpe();
                }
                EventParams.Builder srcId = mediaId.setSrcId(nestAdData9.getAdCode());
                NestAdData nestAdData10 = WkChapterAdView.this.mCurAdData;
                if (nestAdData10 == null) {
                    Intrinsics.throwNpe();
                }
                EventParams.Builder inventoryId = srcId.setInventoryId(nestAdData10.getInventoryId());
                NestAdData nestAdData11 = WkChapterAdView.this.mCurAdData;
                if (nestAdData11 == null) {
                    Intrinsics.throwNpe();
                }
                EventParams.Builder sdkFrom = inventoryId.setSdkFrom(nestAdData11.getSdkFrom());
                NestAdData nestAdData12 = WkChapterAdView.this.mCurAdData;
                if (nestAdData12 == null) {
                    Intrinsics.throwNpe();
                }
                EventParams.Builder renderStyle = sdkFrom.setRenderStyle(nestAdData12.getRenderStyle());
                NestAdData nestAdData13 = WkChapterAdView.this.mCurAdData;
                if (nestAdData13 == null) {
                    Intrinsics.throwNpe();
                }
                Object adMode2 = nestAdData13.getAdMode();
                if (adMode2 == null) {
                    adMode2 = "";
                }
                EventParams.Builder adMode3 = renderStyle.setAdMode(adMode2.toString());
                NestAdData nestAdData14 = WkChapterAdView.this.mCurAdData;
                if (nestAdData14 == null) {
                    Intrinsics.throwNpe();
                }
                Integer adLevel = nestAdData14.getAdLevel();
                if (adLevel == null) {
                    Intrinsics.throwNpe();
                }
                EventParams eventParams = adMode3.setAdLevel(adLevel.intValue()).setRenderType(i).build();
                AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
                Intrinsics.checkExpressionValueIsNotNull(eventParams, "eventParams");
                NestAdData nestAdData15 = WkChapterAdView.this.mCurAdData;
                if (nestAdData15 == null) {
                    Intrinsics.throwNpe();
                }
                AdParams adParams = nestAdData15.getAdParams();
                if (adParams == null) {
                    Intrinsics.throwNpe();
                }
                reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_REWARD_BTN_CLICK, eventParams, adParams.getExt());
            }
        });
        LinearLayout linearLayout40 = this.closeLayout;
        if (linearLayout40 == null) {
            Intrinsics.throwNpe();
        }
        linearLayout40.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.chapterad.WkChapterAdView.initView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextView textView163 = WkChapterAdView.this.mDislikeView;
                if (textView163 == null) {
                    Intrinsics.throwNpe();
                }
                if (textView163.getVisibility() == 0) {
                    TextView textView164 = WkChapterAdView.this.mDislikeView;
                    if (textView164 == null) {
                        Intrinsics.throwNpe();
                    }
                    textView164.setVisibility(8);
                    return;
                }
                TextView textView165 = WkChapterAdView.this.mDislikeView;
                if (textView165 == null) {
                    Intrinsics.throwNpe();
                }
                textView165.setVisibility(0);
            }
        });
        TextView textView163 = this.mDislikeView;
        if (textView163 == null) {
            Intrinsics.throwNpe();
        }
        textView163.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.chapterad.WkChapterAdView.initView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException {
                TextView textView164 = WkChapterAdView.this.mDislikeView;
                if (textView164 == null) {
                    Intrinsics.throwNpe();
                }
                textView164.setVisibility(8);
                SdkStrategy.Companion companion = SdkStrategy.INSTANCE;
                NestAdData nestAdData3 = WkChapterAdView.this.mCurAdData;
                if (nestAdData3 == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = companion.createStringByAdData(nestAdData3);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                JSONObject jSONObject = new JSONObject(strCreateStringByAdData);
                jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, 0);
                FeedBannerShowListener feedBannerShowListener2 = feedBannerShowListener;
                NestAdData nestAdData4 = WkChapterAdView.this.mCurAdData;
                if (nestAdData4 == null) {
                    Intrinsics.throwNpe();
                }
                String adType = nestAdData4.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String string = jSONObject.toString();
                Intrinsics.checkExpressionValueIsNotNull(string, "jsonObject.toString()");
                NestAdData nestAdData5 = WkChapterAdView.this.mCurAdData;
                if (nestAdData5 == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = nestAdData5.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                feedBannerShowListener2.onAdRemove(adType, string, requestId);
            }
        });
        TextView textView164 = this.mPrivacyView;
        if (textView164 == null) {
            Intrinsics.throwNpe();
        }
        textView164.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.chapterad.WkChapterAdView.initView.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NestAdData nestAdData3 = WkChapterAdView.this.mCurAdData;
                if (nestAdData3 == null) {
                    Intrinsics.throwNpe();
                }
                if (TextUtils.isEmpty(nestAdData3.getAdAppPrivacyUrl())) {
                    return;
                }
                NestAdData nestAdData4 = WkChapterAdView.this.mCurAdData;
                if (nestAdData4 == null) {
                    Intrinsics.throwNpe();
                }
                AdComplianceUtil.startCommonWebView(nestAdData4.getAdAppPrivacyUrl(), WkChapterAdView.this.getContext().getString(R.string.ad_privacy), WkChapterAdView.this.getContext());
            }
        });
        TextView textView165 = this.mPermissionsView;
        if (textView165 == null) {
            Intrinsics.throwNpe();
        }
        textView165.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.ad.core.chapterad.WkChapterAdView.initView.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NestAdData nestAdData3 = WkChapterAdView.this.mCurAdData;
                if (nestAdData3 == null) {
                    Intrinsics.throwNpe();
                }
                if (TextUtils.isEmpty(nestAdData3.getAdAppPermissionsUrl())) {
                    return;
                }
                NestAdData nestAdData4 = WkChapterAdView.this.mCurAdData;
                if (nestAdData4 == null) {
                    Intrinsics.throwNpe();
                }
                AdComplianceUtil.startCommonWebView(nestAdData4.getAdAppPermissionsUrl(), WkChapterAdView.this.getContext().getString(R.string.ad_permission_list), WkChapterAdView.this.getContext());
            }
        });
        WifiLog.d("H5ChapterAd WkChapterAdView adView end");
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

    public final void setAdView(int adType, String imgUrl, View adView, String title, String desc, String btnText, Bitmap logoUrl, String textLink, String rewardBtnText, String chapterNameText, int closeType) {
        WifiLog.d("H5ChapterAd WkChapterAdView setAdView mSdkView+" + this.mSdkView + " mBtnView+" + this.mBtnView + " mTitleView+" + this.mTitleView + " mSmallDsp+" + this.mSmallDsp);
        WkChapterAdSdkView wkChapterAdSdkView = this.mSdkView;
        if (wkChapterAdSdkView != null) {
            if (wkChapterAdSdkView == null) {
                Intrinsics.throwNpe();
            }
            wkChapterAdSdkView.setAdView(adType, imgUrl, adView, this.mRenderType);
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
        if (this.mDescView != null && !TextUtils.isEmpty(desc)) {
            TextView textView3 = this.mDescView;
            if (textView3 == null) {
                Intrinsics.throwNpe();
            }
            textView3.setText(desc);
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
            } else {
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
                } else {
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
                    } else {
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
                        } else {
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
                            } else {
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
                                } else {
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
                                    } else if (logoUrl != null) {
                                        ImageView imageView8 = this.mSmallDsp;
                                        if (imageView8 == null) {
                                            Intrinsics.throwNpe();
                                        }
                                        imageView8.setImageBitmap(logoUrl);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        NestAdData nestAdData8 = this.mCurAdData;
        if (nestAdData8 == null) {
            Intrinsics.throwNpe();
        }
        if (Intrinsics.areEqual(nestAdData8.getAdType(), SDKAlias.GDT.getType())) {
            LinearLayout linearLayout = this.permissionsPrivacyContainerView;
            if (linearLayout == null) {
                Intrinsics.throwNpe();
            }
            linearLayout.setVisibility(0);
            LinearLayout linearLayout2 = this.appInfoContainerView;
            if (linearLayout2 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout2.setVisibility(0);
            NestAdData nestAdData9 = this.mCurAdData;
            if (nestAdData9 == null) {
                Intrinsics.throwNpe();
            }
            if (!TextUtils.isEmpty(nestAdData9.getAdAppDeveloperName())) {
                TextView textView4 = this.mDeveloperView;
                if (textView4 == null) {
                    Intrinsics.throwNpe();
                }
                NestAdData nestAdData10 = this.mCurAdData;
                if (nestAdData10 == null) {
                    Intrinsics.throwNpe();
                }
                textView4.setText(nestAdData10.getAdAppDeveloperName());
            }
            NestAdData nestAdData11 = this.mCurAdData;
            if (nestAdData11 == null) {
                Intrinsics.throwNpe();
            }
            if (!TextUtils.isEmpty(nestAdData11.getAdAppVersion())) {
                TextView textView5 = this.mVersionView;
                if (textView5 == null) {
                    Intrinsics.throwNpe();
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Context context = this.mContext;
                if (context == null) {
                    Intrinsics.throwNpe();
                }
                String string = context.getString(R.string.ad_version);
                Intrinsics.checkExpressionValueIsNotNull(string, "mContext!!.getString(R.string.ad_version)");
                Object[] objArr = new Object[1];
                NestAdData nestAdData12 = this.mCurAdData;
                if (nestAdData12 == null) {
                    Intrinsics.throwNpe();
                }
                objArr[0] = nestAdData12.getAdAppVersion();
                String str = String.format(string, Arrays.copyOf(objArr, 1));
                Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(format, *args)");
                textView5.setText(str);
            }
            NestAdData nestAdData13 = this.mCurAdData;
            if (nestAdData13 == null) {
                Intrinsics.throwNpe();
            }
            if (TextUtils.isEmpty(nestAdData13.getAdAppDeveloperName())) {
                NestAdData nestAdData14 = this.mCurAdData;
                if (nestAdData14 == null) {
                    Intrinsics.throwNpe();
                }
                if (TextUtils.isEmpty(nestAdData14.getAdAppVersion())) {
                    LinearLayout linearLayout3 = this.appInfoContainerView;
                    if (linearLayout3 == null) {
                        Intrinsics.throwNpe();
                    }
                    linearLayout3.setVisibility(8);
                }
            }
        } else {
            LinearLayout linearLayout4 = this.permissionsPrivacyContainerView;
            if (linearLayout4 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout4.setVisibility(8);
            LinearLayout linearLayout5 = this.appInfoContainerView;
            if (linearLayout5 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout5.setVisibility(8);
        }
        if (this.mLinkTextView == null || TextUtils.isEmpty(textLink)) {
            TextView textView6 = this.mLinkTextView;
            if (textView6 == null) {
                Intrinsics.throwNpe();
            }
            textView6.setVisibility(4);
        } else {
            TextView textView7 = this.mLinkTextView;
            if (textView7 == null) {
                Intrinsics.throwNpe();
            }
            textView7.setText(textLink);
            TextView textView8 = this.mLinkTextView;
            if (textView8 == null) {
                Intrinsics.throwNpe();
            }
            textView8.setVisibility(0);
        }
        if (this.mRewardBtnView == null || TextUtils.isEmpty(rewardBtnText)) {
            TextView textView9 = this.mRewardBtnView;
            if (textView9 == null) {
                Intrinsics.throwNpe();
            }
            textView9.setVisibility(8);
        } else {
            TextView textView10 = this.mRewardBtnView;
            if (textView10 == null) {
                Intrinsics.throwNpe();
            }
            textView10.setText(rewardBtnText);
            TextView textView11 = this.mRewardBtnView;
            if (textView11 == null) {
                Intrinsics.throwNpe();
            }
            textView11.setVisibility(0);
        }
        if (this.mChapterNameView == null || TextUtils.isEmpty(chapterNameText)) {
            TextView textView12 = this.mChapterNameView;
            if (textView12 == null) {
                Intrinsics.throwNpe();
            }
            textView12.setVisibility(4);
        } else {
            TextView textView13 = this.mChapterNameView;
            if (textView13 == null) {
                Intrinsics.throwNpe();
            }
            textView13.setText(chapterNameText);
            TextView textView14 = this.mChapterNameView;
            if (textView14 == null) {
                Intrinsics.throwNpe();
            }
            textView14.setVisibility(0);
        }
        ImageView imageView9 = this.mCloseImg;
        if (imageView9 != null && closeType > 0) {
            if (imageView9 == null) {
                Intrinsics.throwNpe();
            }
            imageView9.setVisibility(0);
        } else if (imageView9 != null) {
            if (imageView9 == null) {
                Intrinsics.throwNpe();
            }
            imageView9.setVisibility(8);
        }
    }
}
