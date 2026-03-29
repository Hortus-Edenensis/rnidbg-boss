package com.wifi.huawei.ad;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeView;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.entity.SensitiveInfo;
import com.wifi.ad.core.helper.ActivityPacker;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.strategy.IStrategyListener;
import com.wifi.ad.core.utils.ScreenUtil;
import com.wifi.ad.core.utils.WifiLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wifi/huawei/ad/NestHuaweiProvider$getTemplateFeedAd$nativeAdLoaderListener$1", "Lcom/huawei/hms/ads/nativead/NativeAd$NativeAdLoadedListener;", "onNativeAdLoaded", "", "ad", "Lcom/huawei/hms/ads/nativead/NativeAd;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestHuaweiProvider$getTemplateFeedAd$nativeAdLoaderListener$1 implements NativeAd.NativeAdLoadedListener {
    final /* synthetic */ EventParams.Builder $builder;
    final /* synthetic */ IStrategyListener $listenerStrategy;
    final /* synthetic */ NestAdData $nestAdData;
    final /* synthetic */ ActivityPacker $packer;
    final /* synthetic */ NestHuaweiProvider this$0;

    public NestHuaweiProvider$getTemplateFeedAd$nativeAdLoaderListener$1(NestHuaweiProvider nestHuaweiProvider, NestAdData nestAdData, EventParams.Builder builder, IStrategyListener iStrategyListener, ActivityPacker activityPacker) {
        this.this$0 = nestHuaweiProvider;
        this.$nestAdData = nestAdData;
        this.$builder = builder;
        this.$listenerStrategy = iStrategyListener;
        this.$packer = activityPacker;
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v10, types: [T, java.util.ArrayList] */
    @Override // com.huawei.hms.ads.nativead.NativeAd.NativeAdLoadedListener
    public void onNativeAdLoaded(final NativeAd ad) {
        if (ad == null) {
            EventReporter eventReporter = EventReporter.INSTANCE;
            NestAdData nestAdData = this.$nestAdData;
            EventParams.Builder builder = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder, "builder");
            eventReporter.reportNoRespDi(nestAdData, builder, "30200", "");
            IStrategyListener iStrategyListener = this.$listenerStrategy;
            if (iStrategyListener != null) {
                iStrategyListener.onAdFailed(this.$nestAdData, "list is empty", -1);
                return;
            }
            return;
        }
        int creativeType = ad.getCreativeType();
        WifiLog.d("HWAD NestHWProvider getTemplateFeedAd onADLoaded type " + creativeType + " code " + this.$nestAdData.getAdCode());
        if (creativeType != 99) {
            EventReporter eventReporter2 = EventReporter.INSTANCE;
            NestAdData nestAdData2 = this.$nestAdData;
            EventParams.Builder builder2 = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder2, "builder");
            eventReporter2.reportNoRespDi(nestAdData2, builder2, "30300", "");
            IStrategyListener iStrategyListener2 = this.$listenerStrategy;
            if (iStrategyListener2 != null) {
                iStrategyListener2.onAdFailed(this.$nestAdData, "creativeType error " + creativeType, -1);
                return;
            }
            return;
        }
        int testPriceSwitchEcpm = this.this$0.getTestPriceSwitchEcpm(this.this$0.getHwEcpm(ad.getBiddingInfo()), this.$nestAdData);
        WifiLog.d("HWAD NestHwProvider getTemplateFeedAd onAdLoaded priceSwitch price " + testPriceSwitchEcpm + " code " + this.$nestAdData.getAdCode());
        if (testPriceSwitchEcpm > 0) {
            NestHuaweiProvider nestHuaweiProvider = this.this$0;
            NestAdData nestAdData3 = this.$nestAdData;
            EventParams.Builder builder3 = this.$builder;
            Intrinsics.checkExpressionValueIsNotNull(builder3, "builder");
            if (nestHuaweiProvider.checkAdEcpmDone(testPriceSwitchEcpm, nestAdData3, builder3, this.$listenerStrategy)) {
                return;
            }
        }
        NestHuaweiProvider nestHuaweiProvider2 = this.this$0;
        NestAdData nestAdData4 = this.$nestAdData;
        EventParams.Builder builder4 = this.$builder;
        Intrinsics.checkExpressionValueIsNotNull(builder4, "builder");
        if (nestHuaweiProvider2.checkAdPriceSwitch(testPriceSwitchEcpm, nestAdData4, builder4, this.$listenerStrategy)) {
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        NestHuaweiProvider nestHuaweiProvider3 = this.this$0;
        String adCode = this.$nestAdData.getAdCode();
        AdParams adParams = this.$nestAdData.getAdParams();
        objectRef.element = nestHuaweiProvider3.catchHuaweiSensitiveInfo(ad, adCode, adParams != null ? adParams.getExt() : null, this.$nestAdData.getAdLevel());
        this.$builder.setAdTitle(ad.getTitle()).setAdDesc(ad.getDescription());
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = new ArrayList();
        NestAdData nestAdData5 = this.$nestAdData;
        nestAdData5.setDspName(NestHuaweiProvider.DSP_NAME);
        nestAdData5.setAppId(String.valueOf(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.HUAWEI)));
        nestAdData5.setSdkFrom("huawei");
        nestAdData5.setAdData(ad);
        if (((List) objectRef.element) != null && (!((List) r4).isEmpty())) {
            nestAdData5.setSensitiveInfo((SensitiveInfo) ((List) objectRef.element).get(0));
        }
        FrameLayout frameLayout = new FrameLayout(this.$packer.getAppContext());
        NativeView nativeView = new NativeView(this.$packer.getAppContext());
        frameLayout.addView(nativeView, new ViewGroup.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(this.$packer.getAppContext());
        ScreenUtil screenUtil = ScreenUtil.INSTANCE;
        Context appContext = this.$packer.getAppContext();
        Intrinsics.checkExpressionValueIsNotNull(appContext, "packer.appContext");
        int iDp2px = screenUtil.dp2px(appContext, 16.0f);
        Context appContext2 = this.$packer.getAppContext();
        Intrinsics.checkExpressionValueIsNotNull(appContext2, "packer.appContext");
        int iDp2px2 = screenUtil.dp2px(appContext2, 4.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDp2px, iDp2px);
        imageView.setImageResource(R.drawable.hw_temp_close);
        layoutParams.gravity = 5;
        layoutParams.topMargin = iDp2px2;
        layoutParams.rightMargin = iDp2px2 * 3;
        frameLayout.addView(imageView, layoutParams);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.huawei.ad.NestHuaweiProvider$getTemplateFeedAd$nativeAdLoaderListener$1$onNativeAdLoaded$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IStrategyListener iStrategyListener3;
                WifiLog.d("HWAD temp close click addata " + this.this$0.$nestAdData);
                NestHuaweiProvider$getTemplateFeedAd$nativeAdLoaderListener$1 nestHuaweiProvider$getTemplateFeedAd$nativeAdLoaderListener$1 = this.this$0;
                NestAdData nestAdData6 = nestHuaweiProvider$getTemplateFeedAd$nativeAdLoaderListener$1.$nestAdData;
                if (nestAdData6 == null || (iStrategyListener3 = nestHuaweiProvider$getTemplateFeedAd$nativeAdLoaderListener$1.$listenerStrategy) == null) {
                    return;
                }
                iStrategyListener3.onDislikeClicked(nestAdData6, "");
            }
        });
        nativeView.setNativeAd(ad);
        nestAdData5.setAdView(frameLayout);
        this.this$0.checkEcpm(this.$nestAdData, ad.getBiddingInfo());
        ((List) objectRef2.element).add(this.$nestAdData);
        EventReporter eventReporter3 = EventReporter.INSTANCE;
        NestAdData nestAdData6 = this.$nestAdData;
        EventParams.Builder builder5 = this.$builder;
        Intrinsics.checkExpressionValueIsNotNull(builder5, "builder");
        eventReporter3.reportRespDi(nestAdData6, builder5, 1);
        IStrategyListener iStrategyListener3 = this.$listenerStrategy;
        if (iStrategyListener3 != null) {
            iStrategyListener3.onAdLoaded((List) objectRef2.element);
        }
    }
}
