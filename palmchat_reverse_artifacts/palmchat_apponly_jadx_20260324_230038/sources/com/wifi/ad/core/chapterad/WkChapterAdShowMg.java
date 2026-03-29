package com.wifi.ad.core.chapterad;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.wifi.ad.core.R;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdShowConfig;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.listener.FeedBannerShowListener;
import com.wifi.ad.core.strategy.SdkStrategy;
import com.wifi.ad.core.utils.WifiLog;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BG\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/wifi/ad/core/chapterad/WkChapterAdShowMg;", "", "adRequestId", "", "activity", "Landroid/app/Activity;", "parentView", "Landroid/view/ViewGroup;", "adList", "", "Lcom/wifi/ad/core/data/NestAdData;", "adShowConfig", "Lcom/wifi/ad/core/config/AdShowConfig;", "showListener", "Lcom/wifi/ad/core/listener/FeedBannerShowListener;", "(Ljava/lang/String;Landroid/app/Activity;Landroid/view/ViewGroup;Ljava/util/List;Lcom/wifi/ad/core/config/AdShowConfig;Lcom/wifi/ad/core/listener/FeedBannerShowListener;)V", "initListener", "", "curAdData", "showAd", "core_release"}, k = 1, mv = {1, 1, 16})
public final class WkChapterAdShowMg {
    private Activity activity;
    private List<NestAdData> adList;
    private String adRequestId;
    private AdShowConfig adShowConfig;
    private ViewGroup parentView;
    private FeedBannerShowListener showListener;

    public WkChapterAdShowMg(String str, Activity activity, ViewGroup viewGroup, List<NestAdData> list, AdShowConfig adShowConfig, FeedBannerShowListener feedBannerShowListener) {
        this.adRequestId = str;
        this.activity = activity;
        this.parentView = viewGroup;
        this.adList = list;
        this.adShowConfig = adShowConfig;
        this.showListener = feedBannerShowListener;
        if (activity == null || viewGroup == null || list == null || adShowConfig == null || feedBannerShowListener == null) {
            return;
        }
        showAd();
    }

    private final void initListener(NestAdData curAdData) {
        curAdData.setAdInteractionListener(new NestAdData.AdInteractionListener() { // from class: com.wifi.ad.core.chapterad.WkChapterAdShowMg.initListener.1
            @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
            public void onAdClicked(NestAdData adData) {
                WifiLog.d("H5ChapterAd WkChapterAdShowMg onBindViewHolder onAdClicked " + adData);
                FeedBannerShowListener feedBannerShowListener = WkChapterAdShowMg.this.showListener;
                if (feedBannerShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                feedBannerShowListener.onAdClicked(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
            public void onAdExposed(NestAdData adData) {
                WifiLog.d("H5ChapterAd WkChapterAdShowMg onBindViewHolder onAdExposed " + adData);
                FeedBannerShowListener feedBannerShowListener = WkChapterAdShowMg.this.showListener;
                if (feedBannerShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                feedBannerShowListener.onAdExposed(adType, strCreateStringByAdData, requestId);
            }
        });
        curAdData.setAppDownloadListener(new NestAdData.AppDownloadListener() { // from class: com.wifi.ad.core.chapterad.WkChapterAdShowMg.initListener.2
            @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
            public void onDownloadComplete(NestAdData adData) {
                WifiLog.d("H5ChapterAd WkChapterAdShowMg onBindViewHolder onDownloadComplete");
                FeedBannerShowListener feedBannerShowListener = WkChapterAdShowMg.this.showListener;
                if (feedBannerShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                feedBannerShowListener.onDownloadComplete(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
            public void onDownloadFailed(NestAdData adData) {
                WifiLog.d("H5ChapterAd WkChapterAdShowMg onBindViewHolder onDownloadFailed");
                FeedBannerShowListener feedBannerShowListener = WkChapterAdShowMg.this.showListener;
                if (feedBannerShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                feedBannerShowListener.onDownloadFailed(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
            public void onDownloadInstalled(NestAdData adData) {
                WifiLog.d("H5ChapterAd WkChapterAdShowMg onBindViewHolder onDownloadInstalled");
                FeedBannerShowListener feedBannerShowListener = WkChapterAdShowMg.this.showListener;
                if (feedBannerShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                feedBannerShowListener.onDownloadInstalled(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
            public void onDownloadPause(NestAdData adData) {
                WifiLog.d("H5ChapterAd WkChapterAdShowMg onBindViewHolder onDownloadPause");
                FeedBannerShowListener feedBannerShowListener = WkChapterAdShowMg.this.showListener;
                if (feedBannerShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                feedBannerShowListener.onDownloadPause(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
            public void onDownloadProgress(NestAdData adData, int progress) {
                WifiLog.d("H5ChapterAd WkChapterAdShowMg onBindViewHolder onDownloadStart progress = " + progress);
                FeedBannerShowListener feedBannerShowListener = WkChapterAdShowMg.this.showListener;
                if (feedBannerShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                feedBannerShowListener.onDownloadProgress(adType, strCreateStringByAdData, progress, requestId);
            }

            @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
            public void onDownloadStart(NestAdData adData) {
                WifiLog.d("H5ChapterAd WkChapterAdShowMg onBindViewHolder onDownloadStart");
                FeedBannerShowListener feedBannerShowListener = WkChapterAdShowMg.this.showListener;
                if (feedBannerShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                feedBannerShowListener.onDownloadStart(adType, strCreateStringByAdData, requestId);
            }
        });
        curAdData.setVideoAdListener(new NestAdData.VideoAdListener() { // from class: com.wifi.ad.core.chapterad.WkChapterAdShowMg.initListener.3
            @Override // com.wifi.ad.core.data.NestAdData.VideoAdListener
            public void onVideoComplete(NestAdData adData) {
                WifiLog.d("H5ChapterAd WkChapterAdShowMg onBindViewHolder onVideoComplete");
                FeedBannerShowListener feedBannerShowListener = WkChapterAdShowMg.this.showListener;
                if (feedBannerShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                feedBannerShowListener.onVideoComplete(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.data.NestAdData.VideoAdListener
            public void onVideoError(NestAdData adData) {
                WifiLog.d("H5ChapterAd WkChapterAdShowMg onBindViewHolder onVideoError");
                FeedBannerShowListener feedBannerShowListener = WkChapterAdShowMg.this.showListener;
                if (feedBannerShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                feedBannerShowListener.onVideoError(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.data.NestAdData.VideoAdListener
            public void onVideoPause(NestAdData adData) {
                WifiLog.d("H5ChapterAd WkChapterAdShowMg onBindViewHolder onVideoPause");
                FeedBannerShowListener feedBannerShowListener = WkChapterAdShowMg.this.showListener;
                if (feedBannerShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                feedBannerShowListener.onVideoPause(adType, strCreateStringByAdData, requestId);
            }

            @Override // com.wifi.ad.core.data.NestAdData.VideoAdListener
            public void onVideoStart(NestAdData adData) {
                WifiLog.d("H5ChapterAd WkChapterAdShowMg onBindViewHolder onVideoStart");
                FeedBannerShowListener feedBannerShowListener = WkChapterAdShowMg.this.showListener;
                if (feedBannerShowListener == null) {
                    Intrinsics.throwNpe();
                }
                String adType = adData.getAdType();
                if (adType == null) {
                    Intrinsics.throwNpe();
                }
                String strCreateStringByAdData = SdkStrategy.INSTANCE.createStringByAdData(adData);
                if (strCreateStringByAdData == null) {
                    Intrinsics.throwNpe();
                }
                String requestId = adData.getRequestId();
                if (requestId == null) {
                    Intrinsics.throwNpe();
                }
                feedBannerShowListener.onVideoStart(adType, strCreateStringByAdData, requestId);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:317:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x042a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void showAd() {
        int adHeight;
        int useDefaultBg;
        String str;
        String str2;
        String textLinkColor;
        String chapterNameColor;
        String adTitleTextColor;
        int closeType;
        String chapterName;
        String textLinkText;
        String rewardBtnText;
        String rewardBtnBgColor;
        String rewardBtnStrokeColor;
        String rewardBtnTextColor;
        String downloadBtnBgColor;
        String downloadBtnTextColor;
        int rewardBtnClickHide;
        boolean z;
        List<String> imageList;
        String str3;
        Integer adMode;
        WifiLog.d("H5ChapterAd WkChapterAdShowMg showAd");
        if (this.adList == null) {
            Intrinsics.throwNpe();
        }
        if (!(!r1.isEmpty())) {
            return;
        }
        List<NestAdData> list = this.adList;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        NestAdData nestAdData = list.get(0);
        initListener(nestAdData);
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Context context = activity.getApplicationContext();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        int dimension = (int) context.getResources().getDimension(R.dimen.chapter_ad_width);
        int dimension2 = (int) context.getResources().getDimension(R.dimen.chapter_ad_height);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup viewGroup = this.parentView;
        if (viewGroup == null) {
            Intrinsics.throwNpe();
        }
        viewGroup.addView(relativeLayout, layoutParams);
        String str4 = this.adRequestId;
        if (!(str4 == null || str4.length() == 0)) {
            HashMap<String, View> allAdAdView = SdkStrategy.INSTANCE.getAllAdAdView();
            String str5 = this.adRequestId;
            if (str5 == null) {
                Intrinsics.throwNpe();
            }
            allAdAdView.put(str5, relativeLayout);
        }
        WifiLog.d("H5ChapterAd WkChapterAdShowMg parentView!!.addView(adLayout, allLp)");
        AdShowConfig adShowConfig = this.adShowConfig;
        if (adShowConfig == null) {
            Intrinsics.throwNpe();
        }
        if (adShowConfig.getAdWidth() > 0) {
            AdShowConfig adShowConfig2 = this.adShowConfig;
            if (adShowConfig2 == null) {
                Intrinsics.throwNpe();
            }
            dimension = adShowConfig2.getAdWidth();
        }
        int i = dimension;
        AdShowConfig adShowConfig3 = this.adShowConfig;
        if (adShowConfig3 == null) {
            Intrinsics.throwNpe();
        }
        if (adShowConfig3.getAdHeight() > 0) {
            AdShowConfig adShowConfig4 = this.adShowConfig;
            if (adShowConfig4 == null) {
                Intrinsics.throwNpe();
            }
            adHeight = adShowConfig4.getAdHeight();
        } else {
            adHeight = dimension2;
        }
        AdShowConfig adShowConfig5 = this.adShowConfig;
        if (adShowConfig5 == null) {
            Intrinsics.throwNpe();
        }
        if (adShowConfig5.getUseDefaultBg() > 0) {
            AdShowConfig adShowConfig6 = this.adShowConfig;
            if (adShowConfig6 == null) {
                Intrinsics.throwNpe();
            }
            useDefaultBg = adShowConfig6.getUseDefaultBg();
        } else {
            useDefaultBg = 0;
        }
        AdShowConfig adShowConfig7 = this.adShowConfig;
        if (adShowConfig7 == null) {
            Intrinsics.throwNpe();
        }
        String bgColor = adShowConfig7.getBgColor();
        if (bgColor == null || bgColor.length() == 0) {
            str = "#ffffff";
        } else {
            AdShowConfig adShowConfig8 = this.adShowConfig;
            if (adShowConfig8 == null) {
                Intrinsics.throwNpe();
            }
            String bgColor2 = adShowConfig8.getBgColor();
            if (bgColor2 == null) {
                Intrinsics.throwNpe();
            }
            str = bgColor2;
        }
        AdShowConfig adShowConfig9 = this.adShowConfig;
        if (adShowConfig9 == null) {
            Intrinsics.throwNpe();
        }
        String contentBgColor = adShowConfig9.getContentBgColor();
        if (contentBgColor == null || contentBgColor.length() == 0) {
            str2 = "#ffffff";
        } else {
            AdShowConfig adShowConfig10 = this.adShowConfig;
            if (adShowConfig10 == null) {
                Intrinsics.throwNpe();
            }
            String contentBgColor2 = adShowConfig10.getContentBgColor();
            if (contentBgColor2 == null) {
                Intrinsics.throwNpe();
            }
            str2 = contentBgColor2;
        }
        AdShowConfig adShowConfig11 = this.adShowConfig;
        if (adShowConfig11 == null) {
            Intrinsics.throwNpe();
        }
        String textLinkColor2 = adShowConfig11.getTextLinkColor();
        if (textLinkColor2 == null || textLinkColor2.length() == 0) {
            textLinkColor = "#53321B";
        } else {
            AdShowConfig adShowConfig12 = this.adShowConfig;
            if (adShowConfig12 == null) {
                Intrinsics.throwNpe();
            }
            textLinkColor = adShowConfig12.getTextLinkColor();
        }
        String str6 = textLinkColor;
        AdShowConfig adShowConfig13 = this.adShowConfig;
        if (adShowConfig13 == null) {
            Intrinsics.throwNpe();
        }
        String chapterNameColor2 = adShowConfig13.getChapterNameColor();
        if (chapterNameColor2 == null || chapterNameColor2.length() == 0) {
            chapterNameColor = "#775C4B";
        } else {
            AdShowConfig adShowConfig14 = this.adShowConfig;
            if (adShowConfig14 == null) {
                Intrinsics.throwNpe();
            }
            chapterNameColor = adShowConfig14.getChapterNameColor();
        }
        String str7 = chapterNameColor;
        AdShowConfig adShowConfig15 = this.adShowConfig;
        if (adShowConfig15 == null) {
            Intrinsics.throwNpe();
        }
        String adTitleTextColor2 = adShowConfig15.getAdTitleTextColor();
        if (adTitleTextColor2 == null || adTitleTextColor2.length() == 0) {
            adTitleTextColor = "#4B2D1B";
        } else {
            AdShowConfig adShowConfig16 = this.adShowConfig;
            if (adShowConfig16 == null) {
                Intrinsics.throwNpe();
            }
            adTitleTextColor = adShowConfig16.getAdTitleTextColor();
        }
        String str8 = adTitleTextColor;
        AdShowConfig adShowConfig17 = this.adShowConfig;
        if (adShowConfig17 == null) {
            Intrinsics.throwNpe();
        }
        if (adShowConfig17.getCloseType() > 0) {
            AdShowConfig adShowConfig18 = this.adShowConfig;
            if (adShowConfig18 == null) {
                Intrinsics.throwNpe();
            }
            closeType = adShowConfig18.getCloseType();
        } else {
            closeType = 0;
        }
        AdShowConfig adShowConfig19 = this.adShowConfig;
        if (adShowConfig19 == null) {
            Intrinsics.throwNpe();
        }
        String chapterName2 = adShowConfig19.getChapterName();
        if (chapterName2 == null || chapterName2.length() == 0) {
            chapterName = "";
        } else {
            AdShowConfig adShowConfig20 = this.adShowConfig;
            if (adShowConfig20 == null) {
                Intrinsics.throwNpe();
            }
            chapterName = adShowConfig20.getChapterName();
        }
        AdShowConfig adShowConfig21 = this.adShowConfig;
        if (adShowConfig21 == null) {
            Intrinsics.throwNpe();
        }
        String textLinkText2 = adShowConfig21.getTextLinkText();
        if (textLinkText2 == null || textLinkText2.length() == 0) {
            textLinkText = "";
        } else {
            AdShowConfig adShowConfig22 = this.adShowConfig;
            if (adShowConfig22 == null) {
                Intrinsics.throwNpe();
            }
            textLinkText = adShowConfig22.getTextLinkText();
        }
        AdShowConfig adShowConfig23 = this.adShowConfig;
        if (adShowConfig23 == null) {
            Intrinsics.throwNpe();
        }
        String rewardBtnText2 = adShowConfig23.getRewardBtnText();
        if (rewardBtnText2 == null || rewardBtnText2.length() == 0) {
            rewardBtnText = "";
        } else {
            AdShowConfig adShowConfig24 = this.adShowConfig;
            if (adShowConfig24 == null) {
                Intrinsics.throwNpe();
            }
            rewardBtnText = adShowConfig24.getRewardBtnText();
        }
        AdShowConfig adShowConfig25 = this.adShowConfig;
        if (adShowConfig25 == null) {
            Intrinsics.throwNpe();
        }
        String rewardBtnBgColor2 = adShowConfig25.getRewardBtnBgColor();
        if (rewardBtnBgColor2 == null || rewardBtnBgColor2.length() == 0) {
            rewardBtnBgColor = "#EDE1CA";
        } else {
            AdShowConfig adShowConfig26 = this.adShowConfig;
            if (adShowConfig26 == null) {
                Intrinsics.throwNpe();
            }
            rewardBtnBgColor = adShowConfig26.getRewardBtnBgColor();
        }
        String str9 = rewardBtnBgColor;
        AdShowConfig adShowConfig27 = this.adShowConfig;
        if (adShowConfig27 == null) {
            Intrinsics.throwNpe();
        }
        String rewardBtnStrokeColor2 = adShowConfig27.getRewardBtnStrokeColor();
        if (rewardBtnStrokeColor2 == null || rewardBtnStrokeColor2.length() == 0) {
            rewardBtnStrokeColor = "#D33C33";
        } else {
            AdShowConfig adShowConfig28 = this.adShowConfig;
            if (adShowConfig28 == null) {
                Intrinsics.throwNpe();
            }
            rewardBtnStrokeColor = adShowConfig28.getRewardBtnStrokeColor();
        }
        AdShowConfig adShowConfig29 = this.adShowConfig;
        if (adShowConfig29 == null) {
            Intrinsics.throwNpe();
        }
        String rewardBtnTextColor2 = adShowConfig29.getRewardBtnTextColor();
        if (rewardBtnTextColor2 == null || rewardBtnTextColor2.length() == 0) {
            rewardBtnTextColor = "#D33C33";
        } else {
            AdShowConfig adShowConfig30 = this.adShowConfig;
            if (adShowConfig30 == null) {
                Intrinsics.throwNpe();
            }
            rewardBtnTextColor = adShowConfig30.getRewardBtnTextColor();
        }
        AdShowConfig adShowConfig31 = this.adShowConfig;
        if (adShowConfig31 == null) {
            Intrinsics.throwNpe();
        }
        String downloadBtnBgColor2 = adShowConfig31.getDownloadBtnBgColor();
        if (downloadBtnBgColor2 == null || downloadBtnBgColor2.length() == 0) {
            downloadBtnBgColor = "#D33C33";
        } else {
            AdShowConfig adShowConfig32 = this.adShowConfig;
            if (adShowConfig32 == null) {
                Intrinsics.throwNpe();
            }
            downloadBtnBgColor = adShowConfig32.getDownloadBtnBgColor();
        }
        AdShowConfig adShowConfig33 = this.adShowConfig;
        if (adShowConfig33 == null) {
            Intrinsics.throwNpe();
        }
        String downloadBtnTextColor2 = adShowConfig33.getDownloadBtnTextColor();
        if (downloadBtnTextColor2 == null || downloadBtnTextColor2.length() == 0) {
            downloadBtnTextColor = "#FFFFFF";
        } else {
            AdShowConfig adShowConfig34 = this.adShowConfig;
            if (adShowConfig34 == null) {
                Intrinsics.throwNpe();
            }
            downloadBtnTextColor = adShowConfig34.getDownloadBtnTextColor();
        }
        String str10 = downloadBtnTextColor;
        AdShowConfig adShowConfig35 = this.adShowConfig;
        if (adShowConfig35 == null) {
            Intrinsics.throwNpe();
        }
        if (adShowConfig35.getRewardBtnClickHide() > 0) {
            AdShowConfig adShowConfig36 = this.adShowConfig;
            if (adShowConfig36 == null) {
                Intrinsics.throwNpe();
            }
            rewardBtnClickHide = adShowConfig36.getRewardBtnClickHide();
        } else {
            rewardBtnClickHide = 0;
        }
        int renderType = nestAdData.getRenderType();
        Activity activity2 = this.activity;
        if (activity2 == null) {
            Intrinsics.throwNpe();
        }
        ViewGroup viewGroup2 = this.parentView;
        if (viewGroup2 == null) {
            Intrinsics.throwNpe();
        }
        FeedBannerShowListener feedBannerShowListener = this.showListener;
        if (feedBannerShowListener == null) {
            Intrinsics.throwNpe();
        }
        WkChapterAdView wkChapterAdView = new WkChapterAdView(activity2, i, adHeight, useDefaultBg, str, str2, str7, str8, str6, str9, rewardBtnStrokeColor, rewardBtnTextColor, downloadBtnBgColor, str10, viewGroup2, relativeLayout, feedBannerShowListener, nestAdData, renderType, rewardBtnClickHide);
        WifiLog.d("H5ChapterAd WkChapterAdShowMg adLayout.addView");
        String title = nestAdData.getTitle();
        String description = nestAdData.getDescription();
        Integer interactionType = nestAdData.getInteractionType();
        if (interactionType != null) {
            z = true;
            String str11 = interactionType.intValue() == 1 ? "立即下载" : "查看详情";
            imageList = nestAdData.getImageList();
            if (imageList != null && !imageList.isEmpty()) {
                z = false;
            }
            if (z) {
                List<String> imageList2 = nestAdData.getImageList();
                if (imageList2 == null) {
                    Intrinsics.throwNpe();
                }
                str3 = imageList2.get(0);
            } else {
                str3 = null;
            }
            WifiLog.d("H5ChapterAd WkChapterAdShowMg registerViewAndAction && setAdView imgUlr+" + str3 + " title+" + title + " btnText+" + str11 + ' ');
            adMode = nestAdData.getAdMode();
            if (adMode == null) {
                Intrinsics.throwNpe();
            }
            wkChapterAdView.setAdView(adMode.intValue(), str3, nestAdData.getAdView(), title, description, str11, nestAdData.getAdLogo(), textLinkText, rewardBtnText, chapterName, closeType);
            if (Intrinsics.areEqual(nestAdData.getAdType(), SDKAlias.GDT.getType())) {
                relativeLayout.addView(wkChapterAdView, -1, -1);
                WifiNestAd.INSTANCE.createAdFeed().registerViewAndAction(wkChapterAdView, wkChapterAdView.getClickListAd(), nestAdData);
                return;
            } else {
                NestNativeAdChapterContainer nestNativeAdChapterContainer = new NestNativeAdChapterContainer(context);
                relativeLayout.addView(nestNativeAdChapterContainer, -1, -1);
                nestNativeAdChapterContainer.addView(wkChapterAdView, -1, -1);
                WifiNestAd.INSTANCE.createAdFeed().registerViewAndAction(nestNativeAdChapterContainer, wkChapterAdView.getClickListAd(), nestAdData);
                return;
            }
        }
        z = true;
        imageList = nestAdData.getImageList();
        if (imageList != null) {
            z = false;
        }
        if (z) {
        }
        WifiLog.d("H5ChapterAd WkChapterAdShowMg registerViewAndAction && setAdView imgUlr+" + str3 + " title+" + title + " btnText+" + str11 + ' ');
        adMode = nestAdData.getAdMode();
        if (adMode == null) {
        }
        wkChapterAdView.setAdView(adMode.intValue(), str3, nestAdData.getAdView(), title, description, str11, nestAdData.getAdLogo(), textLinkText, rewardBtnText, chapterName, closeType);
        if (Intrinsics.areEqual(nestAdData.getAdType(), SDKAlias.GDT.getType())) {
        }
    }
}
