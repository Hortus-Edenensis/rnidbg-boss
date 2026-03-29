package com.wifi.ad.core.feedbanner;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BG\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/wifi/ad/core/feedbanner/WkFeedBannerShowMg;", "", "adRequestId", "", "activity", "Landroid/app/Activity;", "parentView", "Landroid/view/ViewGroup;", "adList", "", "Lcom/wifi/ad/core/data/NestAdData;", "adShowConfig", "Lcom/wifi/ad/core/config/AdShowConfig;", "showListener", "Lcom/wifi/ad/core/listener/FeedBannerShowListener;", "(Ljava/lang/String;Landroid/app/Activity;Landroid/view/ViewGroup;Ljava/util/List;Lcom/wifi/ad/core/config/AdShowConfig;Lcom/wifi/ad/core/listener/FeedBannerShowListener;)V", "initListener", "", "curAdData", "showAd", "core_release"}, k = 1, mv = {1, 1, 16})
public final class WkFeedBannerShowMg {
    private Activity activity;
    private List<NestAdData> adList;
    private String adRequestId;
    private AdShowConfig adShowConfig;
    private ViewGroup parentView;
    private FeedBannerShowListener showListener;

    public WkFeedBannerShowMg(String str, Activity activity, ViewGroup viewGroup, List<NestAdData> list, AdShowConfig adShowConfig, FeedBannerShowListener feedBannerShowListener) {
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
        curAdData.setAdInteractionListener(new NestAdData.AdInteractionListener() { // from class: com.wifi.ad.core.feedbanner.WkFeedBannerShowMg.initListener.1
            @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
            public void onAdClicked(NestAdData adData) {
                WifiLog.d("H5BannerAd NativeAdapter onBindViewHolder onAdClicked " + adData);
                FeedBannerShowListener feedBannerShowListener = WkFeedBannerShowMg.this.showListener;
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
                WifiLog.d("H5BannerAd NativeAdapter onBindViewHolder onAdExposed " + adData);
                FeedBannerShowListener feedBannerShowListener = WkFeedBannerShowMg.this.showListener;
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
        curAdData.setAppDownloadListener(new NestAdData.AppDownloadListener() { // from class: com.wifi.ad.core.feedbanner.WkFeedBannerShowMg.initListener.2
            @Override // com.wifi.ad.core.data.NestAdData.AppDownloadListener
            public void onDownloadComplete(NestAdData adData) {
                WifiLog.d("H5BannerAd NativeAdapter onBindViewHolder onDownloadComplete");
                FeedBannerShowListener feedBannerShowListener = WkFeedBannerShowMg.this.showListener;
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
                WifiLog.d("H5BannerAd NativeAdapter onBindViewHolder onDownloadFailed");
                FeedBannerShowListener feedBannerShowListener = WkFeedBannerShowMg.this.showListener;
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
                WifiLog.d("H5BannerAd NativeAdapter onBindViewHolder onDownloadInstalled");
                FeedBannerShowListener feedBannerShowListener = WkFeedBannerShowMg.this.showListener;
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
                WifiLog.d("H5BannerAd NativeAdapter onBindViewHolder onDownloadPause");
                FeedBannerShowListener feedBannerShowListener = WkFeedBannerShowMg.this.showListener;
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
                WifiLog.d("H5BannerAd NativeAdapter onBindViewHolder onDownloadStart progress = " + progress);
                FeedBannerShowListener feedBannerShowListener = WkFeedBannerShowMg.this.showListener;
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
                WifiLog.d("H5BannerAd NativeAdapter onBindViewHolder onDownloadStart");
                FeedBannerShowListener feedBannerShowListener = WkFeedBannerShowMg.this.showListener;
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
        curAdData.setVideoAdListener(new NestAdData.VideoAdListener() { // from class: com.wifi.ad.core.feedbanner.WkFeedBannerShowMg.initListener.3
            @Override // com.wifi.ad.core.data.NestAdData.VideoAdListener
            public void onVideoComplete(NestAdData adData) {
                WifiLog.d("H5BannerAd NativeAdapter onBindViewHolder onVideoComplete");
                FeedBannerShowListener feedBannerShowListener = WkFeedBannerShowMg.this.showListener;
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
                WifiLog.d("H5BannerAd NativeAdapter onBindViewHolder onVideoError");
                FeedBannerShowListener feedBannerShowListener = WkFeedBannerShowMg.this.showListener;
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
                WifiLog.d("H5BannerAd NativeAdapter onBindViewHolder onVideoPause");
                FeedBannerShowListener feedBannerShowListener = WkFeedBannerShowMg.this.showListener;
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
                WifiLog.d("H5BannerAd NativeAdapter onBindViewHolder onVideoStart");
                FeedBannerShowListener feedBannerShowListener = WkFeedBannerShowMg.this.showListener;
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

    private final void showAd() {
        int adHeight;
        String bgColor;
        int closeType;
        String downloadBtnBgColor;
        String downloadBtnTextColor;
        String str;
        WifiLog.d("H5Banner WkFeedBannerShowMg showAd");
        if (this.adList == null) {
            Intrinsics.throwNpe();
        }
        boolean z = true;
        if (!r1.isEmpty()) {
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
            int dimension = (int) context.getResources().getDimension(R.dimen.adfeedbanner_width);
            int dimension2 = (int) context.getResources().getDimension(R.dimen.adfeedbanner_height);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            ViewGroup viewGroup = this.parentView;
            if (viewGroup == null) {
                Intrinsics.throwNpe();
            }
            viewGroup.addView(relativeLayout, layoutParams);
            String str2 = this.adRequestId;
            if (!(str2 == null || str2.length() == 0)) {
                HashMap<String, View> allAdAdView = SdkStrategy.INSTANCE.getAllAdAdView();
                String str3 = this.adRequestId;
                if (str3 == null) {
                    Intrinsics.throwNpe();
                }
                allAdAdView.put(str3, relativeLayout);
            }
            WifiLog.d("H5Banner WkFeedBannerShowMg parentView!!.addView(adLayout, allLp)");
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
                if (this.adShowConfig == null) {
                    Intrinsics.throwNpe();
                }
                adHeight = (int) (r4.getAdHeight() * 0.84375f);
            } else {
                adHeight = dimension2;
            }
            AdShowConfig adShowConfig4 = this.adShowConfig;
            if (adShowConfig4 == null) {
                Intrinsics.throwNpe();
            }
            String bgColor2 = adShowConfig4.getBgColor();
            if (bgColor2 == null || bgColor2.length() == 0) {
                bgColor = "#E9D8BB";
            } else {
                AdShowConfig adShowConfig5 = this.adShowConfig;
                if (adShowConfig5 == null) {
                    Intrinsics.throwNpe();
                }
                bgColor = adShowConfig5.getBgColor();
                if (bgColor == null) {
                    Intrinsics.throwNpe();
                }
            }
            String str4 = bgColor;
            AdShowConfig adShowConfig6 = this.adShowConfig;
            if (adShowConfig6 == null) {
                Intrinsics.throwNpe();
            }
            if (adShowConfig6.getCloseType() > 0) {
                AdShowConfig adShowConfig7 = this.adShowConfig;
                if (adShowConfig7 == null) {
                    Intrinsics.throwNpe();
                }
                closeType = adShowConfig7.getCloseType();
            } else {
                closeType = 0;
            }
            AdShowConfig adShowConfig8 = this.adShowConfig;
            if (adShowConfig8 == null) {
                Intrinsics.throwNpe();
            }
            String downloadBtnBgColor2 = adShowConfig8.getDownloadBtnBgColor();
            if (downloadBtnBgColor2 == null || downloadBtnBgColor2.length() == 0) {
                downloadBtnBgColor = "#D33C33";
            } else {
                AdShowConfig adShowConfig9 = this.adShowConfig;
                if (adShowConfig9 == null) {
                    Intrinsics.throwNpe();
                }
                downloadBtnBgColor = adShowConfig9.getDownloadBtnBgColor();
                if (downloadBtnBgColor == null) {
                    Intrinsics.throwNpe();
                }
            }
            String str5 = downloadBtnBgColor;
            AdShowConfig adShowConfig10 = this.adShowConfig;
            if (adShowConfig10 == null) {
                Intrinsics.throwNpe();
            }
            String downloadBtnTextColor2 = adShowConfig10.getDownloadBtnTextColor();
            if (downloadBtnTextColor2 == null || downloadBtnTextColor2.length() == 0) {
                downloadBtnTextColor = "#FFFFFF";
            } else {
                AdShowConfig adShowConfig11 = this.adShowConfig;
                if (adShowConfig11 == null) {
                    Intrinsics.throwNpe();
                }
                downloadBtnTextColor = adShowConfig11.getDownloadBtnTextColor();
                if (downloadBtnTextColor == null) {
                    Intrinsics.throwNpe();
                }
            }
            String str6 = downloadBtnTextColor;
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
            WkFeedBannerView wkFeedBannerView = new WkFeedBannerView(activity2, i, adHeight, str4, str5, str6, viewGroup2, relativeLayout, feedBannerShowListener, nestAdData, closeType);
            WifiLog.d("H5Banner WkFeedBannerShowMg adLayout.addView");
            String title = nestAdData.getTitle();
            if (title == null || title.length() == 0) {
                title = nestAdData.getDescription();
            }
            Integer interactionType = nestAdData.getInteractionType();
            String str7 = (interactionType != null && interactionType.intValue() == 1) ? "立即下载" : "查看详情";
            List<String> imageList = nestAdData.getImageList();
            if (imageList != null && !imageList.isEmpty()) {
                z = false;
            }
            if (z) {
                str = null;
            } else {
                List<String> imageList2 = nestAdData.getImageList();
                if (imageList2 == null) {
                    Intrinsics.throwNpe();
                }
                str = imageList2.get(0);
            }
            WifiLog.d("H5Banner WkFeedBannerShowMg registerViewAndAction && setAdView imgUlr+" + str + " title+" + title + " btnText+" + str7 + ' ');
            Integer adMode = nestAdData.getAdMode();
            if (adMode == null) {
                Intrinsics.throwNpe();
            }
            wkFeedBannerView.setAdView(adMode.intValue(), str, nestAdData.getAdView(), title, str7, nestAdData.getAdLogo());
            if (!Intrinsics.areEqual(nestAdData.getAdType(), SDKAlias.GDT.getType())) {
                relativeLayout.addView(wkFeedBannerView, -1, -1);
                WifiNestAd.INSTANCE.createAdFeed().registerViewAndAction(wkFeedBannerView, wkFeedBannerView.getClickListAd(), nestAdData);
            } else {
                NestNativeAdFeedContainer nestNativeAdFeedContainer = new NestNativeAdFeedContainer(context);
                relativeLayout.addView(nestNativeAdFeedContainer, -1, -1);
                nestNativeAdFeedContainer.addView(wkFeedBannerView, -1, -1);
                WifiNestAd.INSTANCE.createAdFeed().registerViewAndAction(nestNativeAdFeedContainer, wkFeedBannerView.getClickListAd(), nestAdData);
            }
        }
    }
}
