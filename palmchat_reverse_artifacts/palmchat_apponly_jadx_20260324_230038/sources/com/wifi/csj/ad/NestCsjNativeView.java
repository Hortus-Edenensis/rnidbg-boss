package com.wifi.csj.ad;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.compliance.AdDownViVoConfig;
import com.wifi.ad.core.compliance.AdNativeStyleManagerSDK;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.custom.flow.AdImageLoader;
import com.wifi.ad.core.custom.flow.BaseNativeView;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.listener.NativeViewListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.utils.ScreenUtil;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.ad.core.view.WifiAdMagicTopView;
import com.wifi.ad.core.view.WifiAdMagicView;
import com.wifi.ad.core.view.WifiDownWebButton;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J2\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\rH\u0002JF\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J*\u0010#\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J*\u0010$\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J*\u0010&\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J4\u0010'\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006+"}, d2 = {"Lcom/wifi/csj/ad/NestCsjNativeView;", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "()V", "mHasShowDownloadActive", "", "getMHasShowDownloadActive", "()Z", "setMHasShowDownloadActive", "(Z)V", "mHasShowDownloadActiveNative", "getMHasShowDownloadActiveNative", "setMHasShowDownloadActiveNative", "checkCsjAdInteractionType", "", "context", "Landroid/content/Context;", "ad", "Lcom/bytedance/sdk/openadsdk/TTDrawFeedAd;", "initAdViewAndAction", "", "adObject", "Lcom/wifi/ad/core/data/NestAdData;", "adImage", "Landroid/widget/ImageView;", "container", "Landroid/view/ViewGroup;", bq.f.s, "Lcom/wifi/ad/core/listener/NativeViewListener;", "adProviderType", "registerViewAndActionFeedAd", "clickViews", "", "Landroid/view/View;", "creativeViews", "nestAdData", "showDrawVideoAd", "showNative", "", "showNativeDrawVideoAd", "showTemplateFeedAd", "activity", "Landroid/app/Activity;", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestCsjNativeView extends BaseNativeView {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean mHasShowDownloadActive;
    private boolean mHasShowDownloadActiveNative;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ/\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/wifi/csj/ad/NestCsjNativeView$Companion;", "", "()V", "onEvent", "", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "eventKey", "", "errorCode", "", "message", "(Lcom/wifi/ad/core/data/NestAdData;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final void onEvent(NestAdData nestAdData, String eventKey, Integer errorCode, String message) {
            String str;
            String description;
            String nestType;
            String imageUrl = null;
            if (nestAdData.getAdData() instanceof TTDrawFeedAd) {
                Object adData = nestAdData.getAdData();
                if (adData == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.bytedance.sdk.openadsdk.TTDrawFeedAd");
                }
                TTDrawFeedAd tTDrawFeedAd = (TTDrawFeedAd) adData;
                String title = tTDrawFeedAd.getTitle();
                List<TTImage> imageList = tTDrawFeedAd.getImageList();
                if (!(imageList == null || imageList.isEmpty())) {
                    List<TTImage> imageList2 = tTDrawFeedAd.getImageList();
                    if (imageList2 == null) {
                        Intrinsics.throwNpe();
                    }
                    TTImage tTImage = imageList2.get(0);
                    if (tTImage != null) {
                        imageUrl = tTImage.getImageUrl();
                    }
                }
                description = tTDrawFeedAd.getDescription();
                str = imageUrl;
                imageUrl = title;
            } else {
                str = null;
                description = null;
            }
            EventParams.Builder srcId = new EventParams.Builder().setDspName(NestCsjProvider.DSP_NAME).setNestSid(nestAdData.getNestSid()).setPosition(nestAdData.getPosition()).setTmAdBtnShow(nestAdData.getShowAdButtonTime()).setRedAdBtnShow(nestAdData.getChangeAdBtnColorTime()).setCtAdBtnShow(nestAdData.getShowAdCardTime()).setSdkFrom(NestCsjProvider.SDK_FROM).setInventoryId(nestAdData.getInventoryId()).setRenderStyle(nestAdData.getRenderStyle()).setMediaId(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.CSJ)).setSrcId(nestAdData.getAdCode());
            AdParams adParams = nestAdData.getAdParams();
            if (adParams == null || (nestType = adParams.getNestType()) == null) {
                nestType = "";
            }
            EventParams.Builder nestType2 = srcId.setNestType(nestType);
            Integer adMode = nestAdData.getAdMode();
            EventParams.Builder params = nestType2.setAdMode((adMode != null ? adMode : "").toString()).setDiscountInfo(nestAdData.getDiscountInfo()).setAdTitle(imageUrl).setAdImage(str).setAdDesc(description);
            if (errorCode != null) {
                params.setErrorCode(String.valueOf(errorCode.intValue()));
            }
            EventReporter eventReporter = EventReporter.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(params, "params");
            eventReporter.reportViewEvent(params, nestAdData, eventKey);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void onEvent(NestAdData nestAdData, String eventKey) {
            onEvent(nestAdData, eventKey, null, null);
        }
    }

    private final String checkCsjAdInteractionType(Context context, TTDrawFeedAd ad) {
        WifiLog.d("NestCsjNativeView showNativeDrawVideoAd checkCsjAdInteractionType ad type " + ad.getInteractionType() + ' ');
        int iIntValue = Integer.valueOf(ad.getInteractionType()).intValue();
        if (iIntValue == 2) {
            if (context != null) {
                return context.getString(R.string.see_detail);
            }
            return null;
        }
        if (iIntValue != 4) {
            return ad.getButtonText();
        }
        if (context != null) {
            return context.getString(R.string.download_quick);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, com.wifi.ad.core.view.WifiAdMagicView] */
    private final void initAdViewAndAction(final NestAdData adObject, ImageView adImage, ViewGroup container, final NativeViewListener listener, final String adProviderType) {
        if ((adObject != null ? adObject.getAdData() : null) == null || !(adObject.getAdData() instanceof TTDrawFeedAd) || container == null || container.getContext() == null) {
            return;
        }
        Object adData = adObject.getAdData();
        if (adData == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.bytedance.sdk.openadsdk.TTDrawFeedAd");
        }
        TTDrawFeedAd tTDrawFeedAd = (TTDrawFeedAd) adData;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? wifiAdMagicView = new WifiAdMagicView(container.getContext());
        objectRef.element = wifiAdMagicView;
        wifiAdMagicView.setOnAdViewListener(new WifiAdMagicView.OnAdViewListener() { // from class: com.wifi.csj.ad.NestCsjNativeView.initAdViewAndAction.1
            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onAdTagClick(View view) {
                WifiLog.d("NestCsjNativeView initAdViewAndAction  onAdTagClick");
            }

            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onCardCloseClick(View view) {
                WifiLog.d("NestCsjNativeView initAdViewAndAction onCardCloseClick");
                NestCsjNativeView.INSTANCE.onEvent(adObject, "nest_sdk_cancle_click");
            }

            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onCardShow() {
                WifiLog.d("NestCsjNativeView initAdViewAndAction  onCardShow");
                NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.NEST_SDK_CHUANGTI_SHOW);
            }

            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onCompleteBgShow() {
                WifiLog.d("NestCsjNativeView initAdViewAndAction  onCompleteBgShow");
                NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.NEST_SDK_ENDPLAY_SHOW);
            }

            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onRedBtnShow() {
                WifiLog.d("NestCsjNativeView initAdViewAndAction  onRedBtnShow");
                NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.NEST_SDK_REDBTN_SHOW);
            }

            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onReplayClick(View view) {
                WifiLog.d("NestCsjNativeView initAdViewAndAction  onReplayClick");
            }

            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onTransparentBtnShow() {
                WifiLog.d("NestCsjNativeView initAdViewAndAction  onTransparentBtnShow");
                NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.NEST_SDK_TM_ADBTNSHOW);
            }
        });
        int i = tTDrawFeedAd.getInteractionType() != 4 ? 2 : 1;
        WifiAdMagicView.Config.Builder cardTitle = new WifiAdMagicView.Config.Builder().setAuthorInfo(tTDrawFeedAd.getDescription()).setAuthorName(tTDrawFeedAd.getTitle()).setCardInfo(tTDrawFeedAd.getDescription()).setCardTitle(tTDrawFeedAd.getTitle());
        TTImage icon = tTDrawFeedAd.getIcon();
        WifiAdMagicView.Config.Builder bgInfo = cardTitle.setCardIcon(icon != null ? icon.getImageUrl() : null).setBgName(tTDrawFeedAd.getTitle()).setBgInfo(tTDrawFeedAd.getDescription());
        Context context = container.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "container.context");
        WifiAdMagicView.Config.Builder downLoadType = bgInfo.setButton(checkCsjAdInteractionType(context, tTDrawFeedAd)).setShowAdBtnTime(adObject.getShowAdButtonTime()).setChangeAdBtnColorTime(adObject.getChangeAdBtnColorTime()).setShowAdCardTime(adObject.getShowAdCardTime()).setScene(adObject.getAdScene()).setDownLoadType(i);
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        ((WifiAdMagicView) objectRef.element).configViewData(downLoadType.setLogoResId(wifiNestAd.getMPersonalizedAd() ? R.drawable.icon_personalized_csj_logo : R.drawable.icon_csj_logo_with_txt).setAdType(SDKAlias.CSJ.getType()).setAppName(adObject.getAdAppName()).setDeveloperName(adObject.getAdAppDeveloperName()).setPermissionsUrl(adObject.getAdAppPermissionsUrl()).setPrivacyUrl(adObject.getAdAppPrivacyUrl()).setFunctionUrl(adObject.getAdAppFunctionDescUrl()).setAppVersion(adObject.getAdAppVersion()).setNewStyleEnable(wifiNestAd.isDrawVideoNewStyleEnable()).build());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        tTDrawFeedAd.setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: com.wifi.csj.ad.NestCsjNativeView.initAdViewAndAction.2
            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdComplete(TTFeedAd p0) {
                WifiLog.d("NestCsjNativeView onVideoAdComplete adProviderType = " + adProviderType);
                Companion companion = NestCsjNativeView.INSTANCE;
                companion.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOE);
                companion.onEvent(adObject, WifiNestConst.EventKey.NEST_SDK_ENDPLAY_SHOW);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onVideoComplete(adProviderType, adObject);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdPaused(TTFeedAd p0) {
                WifiLog.d("NestCsjNativeView onVideoAdPaused adProviderType = " + adProviderType);
                NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOB);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onVideoPause(adProviderType, adObject);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdStartPlay(TTFeedAd p0) {
                WifiLog.d("NestCsjNativeView onVideoAdStartPlay adProviderType = " + adProviderType);
                NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOS);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onVideoStart(adProviderType, adObject);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoError(int p0, int p1) {
                NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOT);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onVideoError(adProviderType, adObject);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdContinuePlay(TTFeedAd p0) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoLoad(TTFeedAd p0) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onProgressUpdate(long p0, long p1) {
            }
        });
        tTDrawFeedAd.setDownloadListener(new TTAppDownloadListener() { // from class: com.wifi.csj.ad.NestCsjNativeView.initAdViewAndAction.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long total, long current, String p2, String p3) {
                if (!NestCsjNativeView.this.getMHasShowDownloadActiveNative()) {
                    NestCsjNativeView.this.setMHasShowDownloadActiveNative(true);
                    adObject.setDownloadStatus(1);
                    WifiLog.d("NestCsjNativeView setDownloadListener onDownloadStart mHasShowDownloadActiveNative = " + NestCsjNativeView.this.getMHasShowDownloadActiveNative() + ' ' + p2 + ' ' + p3);
                    NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADING);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadStart(adProviderType, adObject);
                    }
                }
                if (current > 0) {
                    adObject.setDownloadStatus(3);
                    ((WifiAdMagicView) objectRef.element).updateAdBtnShow(WifiAdMagicView.getDownloadingString(current, total));
                    int i2 = (int) ((current * ((long) 100)) / total);
                    NativeViewListener nativeViewListener2 = listener;
                    if (nativeViewListener2 != null) {
                        nativeViewListener2.onDownloadProgress(adProviderType, adObject, i2);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long p0, long p1, String p2, String p3) {
                adObject.setDownloadStatus(6);
                WifiLog.d("NestCsjNativeView setDownloadListener onDownloadFailed " + p0 + ' ' + p1 + ' ' + p2 + ' ' + p3);
                NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_NODOWNLOAD);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onDownloadFailed(adProviderType, adObject);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long p0, String p1, String p2) {
                WifiLog.d("NestCsjNativeView setDownloadListener onDownloadFinished " + p0 + ' ' + p1 + ' ' + p2);
                adObject.setDownloadStatus(4);
                NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADED);
                ((WifiAdMagicView) objectRef.element).updateAdBtnShow(WifiAdMagicView.getInstallText());
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onDownloadComplete(adProviderType, adObject);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long p0, long p1, String p2, String p3) {
                adObject.setDownloadStatus(2);
                WifiLog.d("NestCsjNativeView setDownloadListener onDownloadPaused " + p0 + ' ' + p1 + ' ' + p2 + ' ' + p3);
                ((WifiAdMagicView) objectRef.element).updateAdBtnShow(WifiAdMagicView.getContinueText());
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                NestCsjNativeView.this.setMHasShowDownloadActiveNative(false);
                adObject.setDownloadStatus(0);
                WifiLog.d("NestCsjNativeView setDownloadListener onIdle mHasShowDownloadActiveNative = " + NestCsjNativeView.this.getMHasShowDownloadActiveNative());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String p0, String p1) {
                WifiLog.d("NestCsjNativeView setDownloadListener onInstalled " + p0 + ' ' + p1);
                adObject.setDownloadStatus(5);
                NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_INSTALLED);
                ((WifiAdMagicView) objectRef.element).updateAdBtnShow(WifiAdMagicView.getOpenText());
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onDownloadInstalled(adProviderType, adObject);
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add(new View(container.getContext()));
        ArrayList arrayList2 = new ArrayList();
        WifiLog.d("downAd csj nativeDraw adObject.interactionType " + adObject.getInteractionType() + " ad.interactionType " + tTDrawFeedAd.getInteractionType());
        if (tTDrawFeedAd.getInteractionType() == 4) {
            adObject.setInteractionType(1);
            if (((WifiAdMagicView) objectRef.element).getFirstButton() != null) {
                WifiDownWebButton firstButton = ((WifiAdMagicView) objectRef.element).getFirstButton();
                Intrinsics.checkExpressionValueIsNotNull(firstButton, "adView.firstButton");
                firstButton.setTag(WifiNestConst.OtherConst.TAG_AD_BUTTON);
                arrayList.add(((WifiAdMagicView) objectRef.element).getFirstButton());
            }
            if (((WifiAdMagicView) objectRef.element).getSecondButton() != null) {
                WifiDownWebButton secondButton = ((WifiAdMagicView) objectRef.element).getSecondButton();
                Intrinsics.checkExpressionValueIsNotNull(secondButton, "adView.secondButton");
                secondButton.setTag(WifiNestConst.OtherConst.TAG_AD_BUTTON);
                arrayList.add(((WifiAdMagicView) objectRef.element).getSecondButton());
            }
        }
        if (((WifiAdMagicView) objectRef.element).getFirstButton() != null) {
            arrayList2.add(((WifiAdMagicView) objectRef.element).getFirstButton());
        }
        if (((WifiAdMagicView) objectRef.element).getSecondButton() != null) {
            arrayList2.add(((WifiAdMagicView) objectRef.element).getSecondButton());
        }
        if (((WifiAdMagicView) objectRef.element).getBgDownload() != null) {
            arrayList2.add(((WifiAdMagicView) objectRef.element).getBgDownload());
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(((WifiAdMagicView) objectRef.element).getClickViews());
        arrayList3.add(adImage);
        List<View> listCreateClickView = AdDownViVoConfig.createClickView(arrayList3, arrayList2, adObject, arrayList3);
        Intrinsics.checkExpressionValueIsNotNull(listCreateClickView, "AdDownViVoConfig.createC… adObject, creativeViews)");
        if (arrayList.size() == 0) {
            arrayList.add(new View(container.getContext()));
        }
        tTDrawFeedAd.registerViewForInteraction(container, arrayList, listCreateClickView, new TTNativeAd.AdInteractionListener() { // from class: com.wifi.csj.ad.NestCsjNativeView.initAdViewAndAction.4
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdClicked(View view, TTNativeAd ad) {
                WifiLog.d("NestCsjNativeView registerViewForInteraction onAdClicked");
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdCreativeClick(View view, TTNativeAd ad) {
                try {
                    WifiLog.d("NestCsjNativeView registerViewForInteraction onAdCreativeClick");
                    NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onAdClicked(adProviderType, adObject);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdShow(TTNativeAd ad) {
                StringBuilder sb = new StringBuilder();
                sb.append("NestCsjNativeView registerViewForInteraction onAdShow ad = ");
                sb.append(ad != null ? ad.getTitle() : null);
                WifiLog.d(sb.toString());
                NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onAdExposed(adProviderType, adObject);
                }
            }
        });
        if (!wifiNestAd.isDrawVideoNewStyleEnable()) {
            WifiAdMagicTopView wifiAdMagicTopView = new WifiAdMagicTopView(container.getContext());
            WifiAdMagicTopView.Config.Builder appName = new WifiAdMagicTopView.Config.Builder().setAppName(tTDrawFeedAd.getTitle());
            TTImage icon2 = tTDrawFeedAd.getIcon();
            wifiAdMagicTopView.configViewData(appName.setCardIcon(icon2 != null ? icon2.getImageUrl() : null).build());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(10);
            ScreenUtil screenUtil = ScreenUtil.INSTANCE;
            Context context2 = container.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "container.context");
            layoutParams2.leftMargin = screenUtil.dp2px(context2, 42.0f);
            container.addView(wifiAdMagicTopView, layoutParams2);
        }
        AdDownViVoConfig.checkVideoViewClick(adObject);
        container.addView((WifiAdMagicView) objectRef.element, layoutParams);
    }

    public final boolean getMHasShowDownloadActive() {
        return this.mHasShowDownloadActive;
    }

    public final boolean getMHasShowDownloadActiveNative() {
        return this.mHasShowDownloadActiveNative;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6  */
    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void registerViewAndActionFeedAd(final String adProviderType, ViewGroup container, List<View> clickViews, List<View> creativeViews, final NestAdData nestAdData, final NativeViewListener listener) {
        List<View> list;
        int i;
        Context context;
        WifiLog.d("NestCsjNativeView showNativeDrawVideoAd bind");
        if (nestAdData.getAdData() instanceof TTFeedAd) {
            INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
            Object adData = nestAdData.getAdData();
            if (adData == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.bytedance.sdk.openadsdk.TTFeedAd");
            }
            TTFeedAd tTFeedAd = (TTFeedAd) adData;
            try {
                context = container.getContext();
            } catch (Exception unused) {
            }
            if (context == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
            }
            tTFeedAd.setActivityForDownloadApp((Activity) context);
            tTFeedAd.setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: com.wifi.csj.ad.NestCsjNativeView.registerViewAndActionFeedAd.1
                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdComplete(TTFeedAd p0) {
                    WifiLog.d("NestCsjNativeView onVideoAdComplete adProviderType = " + adProviderType);
                    Companion companion = NestCsjNativeView.INSTANCE;
                    companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOE);
                    companion.onEvent(nestAdData, WifiNestConst.EventKey.NEST_SDK_ENDPLAY_SHOW);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoComplete(adProviderType, nestAdData);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdPaused(TTFeedAd p0) {
                    WifiLog.d("NestCsjNativeView onVideoAdPaused adProviderType = " + adProviderType);
                    NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOB);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoPause(adProviderType, nestAdData);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdStartPlay(TTFeedAd p0) {
                    WifiLog.d("NestCsjNativeView onVideoAdStartPlay adProviderType = " + adProviderType);
                    NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOS);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoStart(adProviderType, nestAdData);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoError(int p0, int p1) {
                    NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOT);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoError(adProviderType, nestAdData);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdContinuePlay(TTFeedAd p0) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoLoad(TTFeedAd p0) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onProgressUpdate(long p0, long p1) {
                }
            });
            tTFeedAd.setDownloadListener(new TTAppDownloadListener() { // from class: com.wifi.csj.ad.NestCsjNativeView.registerViewAndActionFeedAd.2
                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadActive(long total, long current, String p2, String p3) {
                    if (!NestCsjNativeView.this.getMHasShowDownloadActiveNative()) {
                        NestCsjNativeView.this.setMHasShowDownloadActiveNative(true);
                        WifiLog.d("NestCsjNativeView setDownloadListener onDownloadStart mHasShowDownloadActiveNative = " + NestCsjNativeView.this.getMHasShowDownloadActiveNative() + ' ' + p2 + ' ' + p3);
                        NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADING);
                        NativeViewListener nativeViewListener = listener;
                        if (nativeViewListener != null) {
                            nativeViewListener.onDownloadStart(adProviderType, nestAdData);
                        }
                    }
                    if (current <= 0 || total <= 0) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("NestCsjNativeView setDownloadListener onDownloadProgress ");
                    sb.append(total);
                    sb.append(' ');
                    sb.append(current);
                    sb.append(' ');
                    sb.append(p2);
                    sb.append(' ');
                    int i2 = (int) ((current / total) * 100);
                    sb.append(i2);
                    WifiLog.d(sb.toString());
                    NativeViewListener nativeViewListener2 = listener;
                    if (nativeViewListener2 != null) {
                        nativeViewListener2.onDownloadProgress(adProviderType, nestAdData, i2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFailed(long p0, long p1, String p2, String p3) {
                    WifiLog.d("NestCsjNativeView setDownloadListener onDownloadFailed " + p0 + ' ' + p1 + ' ' + p2 + ' ' + p3);
                    NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_NODOWNLOAD);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadFailed(adProviderType, nestAdData);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFinished(long p0, String p1, String p2) {
                    WifiLog.d("NestCsjNativeView setDownloadListener onDownloadFinished " + p0 + ' ' + p1 + ' ' + p2);
                    NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADED);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadComplete(adProviderType, nestAdData);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadPaused(long p0, long p1, String p2, String p3) {
                    WifiLog.d("NestCsjNativeView setDownloadListener onDownloadPaused " + p0 + ' ' + p1 + ' ' + p2 + ' ' + p3);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadPause(adProviderType, nestAdData);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onIdle() {
                    NestCsjNativeView.this.setMHasShowDownloadActiveNative(false);
                    WifiLog.d("NestCsjNativeView setDownloadListener onIdle mHasShowDownloadActiveNative = " + NestCsjNativeView.this.getMHasShowDownloadActiveNative());
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onInstalled(String p0, String p1) {
                    WifiLog.d("NestCsjNativeView setDownloadListener onInstalled " + p0 + ' ' + p1);
                    NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_INSTALLED);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadInstalled(adProviderType, nestAdData);
                    }
                }
            });
            if (clickViews == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new View(container.getContext()));
                list = arrayList;
            } else {
                list = clickViews;
            }
            TextView adButtonView = getAdButtonView(clickViews, creativeViews);
            if (adButtonView != null) {
                CharSequence text = adButtonView.getText();
                if (text != null) {
                    nestAdData.setRespbtnwd(text.toString());
                    nestAdData.setShowbtnwd(text.toString());
                }
                if (WifiNestAd.INSTANCE.getSwitch315() && 4 == tTFeedAd.getInteractionType()) {
                    Context context2 = container.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context2, "container.context");
                    adButtonView.setText(context2.getResources().getString(R.string.download_quick));
                    nestAdData.setShowbtnwd(adButtonView.getText().toString());
                }
            }
            TTNativeAd.AdInteractionListener adInteractionListener = new TTNativeAd.AdInteractionListener() { // from class: com.wifi.csj.ad.NestCsjNativeView$registerViewAndActionFeedAd$ttAdInListener$1
                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdClicked(View view, TTNativeAd ad) {
                    WifiLog.d("NestCsjNativeView registerViewForInteraction onAdClicked");
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdCreativeClick(View view, TTNativeAd ad) {
                    WifiLog.d("NestCsjNativeView registerViewForInteraction onAdCreativeClick");
                    NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onAdClicked(adProviderType, nestAdData);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdShow(TTNativeAd ad) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("NestCsjNativeView registerViewForInteraction onAdShow ad = ");
                    sb.append(ad != null ? ad.getTitle() : null);
                    WifiLog.d(sb.toString());
                    NestCsjNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onAdExposed(adProviderType, nestAdData);
                    }
                }
            };
            Integer interactionType = nestAdData.getInteractionType();
            if (interactionType == null) {
                i = 2;
            } else {
                i = 1;
                if (interactionType.intValue() != 1) {
                }
            }
            boolean zIsShowComplianceInfo = AdNativeStyleManagerSDK.isShowComplianceInfo(String.valueOf(nestAdData.getAdScene()), i);
            WifiLog.d("AdDownViVoConfig csj registerViewAndActionFeedAd showInfo " + zIsShowComplianceInfo + " button " + adButtonView);
            try {
                if (zIsShowComplianceInfo) {
                    ArrayList arrayList2 = new ArrayList();
                    if (adButtonView != null) {
                        arrayList2.add(adButtonView);
                    }
                    WifiLog.d("AdDownViVoConfig csj registerViewAndActionFeedAd clickOnlyViews " + arrayList2 + " creativeViews " + creativeViews);
                    tTFeedAd.registerViewForInteraction(container, (List<View>) null, list, creativeViews, arrayList2, (View) null, adInteractionListener);
                } else {
                    tTFeedAd.registerViewForInteraction(container, list, creativeViews, adInteractionListener);
                }
                AdDownViVoConfig.checkVideoViewClick(nestAdData);
            } catch (Exception unused2) {
            }
        }
    }

    public final void setMHasShowDownloadActive(boolean z) {
        this.mHasShowDownloadActive = z;
    }

    public final void setMHasShowDownloadActiveNative(boolean z) {
        this.mHasShowDownloadActiveNative = z;
    }

    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void showDrawVideoAd(final String adProviderType, final NestAdData adObject, final ViewGroup container, final NativeViewListener listener) {
        if (adObject.getAdData() instanceof TTNativeExpressAd) {
            INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
            Object adData = adObject.getAdData();
            if (adData == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.bytedance.sdk.openadsdk.TTNativeExpressAd");
            }
            TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) adData;
            tTNativeExpressAd.setDownloadListener(new TTAppDownloadListener() { // from class: com.wifi.csj.ad.NestCsjNativeView.showDrawVideoAd.1
                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadActive(long p0, long p1, String p2, String p3) {
                    if (NestCsjNativeView.this.getMHasShowDownloadActive()) {
                        return;
                    }
                    NestCsjNativeView.this.setMHasShowDownloadActive(true);
                    NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADING);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadStart(adProviderType, adObject);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFailed(long p0, long p1, String p2, String p3) {
                    NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_NODOWNLOAD);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadFailed(adProviderType, adObject);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFinished(long p0, String p1, String p2) {
                    NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADED);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadComplete(adProviderType, adObject);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onIdle() {
                    NestCsjNativeView.this.setMHasShowDownloadActive(false);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onInstalled(String p0, String p1) {
                    NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_INSTALLED);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadInstalled(adProviderType, adObject);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadPaused(long p0, long p1, String p2, String p3) {
                }
            });
            tTNativeExpressAd.setVideoAdListener(new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.wifi.csj.ad.NestCsjNativeView.showDrawVideoAd.2
                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onVideoAdComplete() {
                    WifiLog.d("NestCsjNativeView onVideoAdComplete adProviderType = " + adProviderType);
                    NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOE);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoComplete(adProviderType, adObject);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onVideoAdPaused() {
                    WifiLog.d("NestCsjNativeView onVideoAdPaused adProviderType = " + adProviderType);
                    NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOB);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoPause(adProviderType, adObject);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onVideoAdStartPlay() {
                    WifiLog.d("NestCsjNativeView onVideoAdStartPlay adProviderType = " + adProviderType);
                    NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOS);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoStart(adProviderType, adObject);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onVideoError(int errorCode, int extraCode) {
                    NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOT, Integer.valueOf(errorCode), null);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoError(adProviderType, adObject);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onClickRetry() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onVideoAdContinuePlay() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onVideoLoad() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onProgressUpdate(long current, long duration) {
                }
            });
            tTNativeExpressAd.setCanInterruptVideoPlay(true);
            tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.wifi.csj.ad.NestCsjNativeView.showDrawVideoAd.3
                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdClicked(View view, int type) {
                    WifiLog.d("NestCsjNativeView onAdClicked type " + type);
                    NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onAdClicked(adProviderType, adObject);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdShow(View view, int type) {
                    WifiLog.d("NestCsjNativeView onAdShow type " + type);
                    NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onAdExposed(adProviderType, adObject);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderFail(View view, String msg, int code) {
                    WifiLog.d("NestCsjNativeView onRenderFail msg = " + msg);
                    NestCsjNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW_FAIL, Integer.valueOf(code), msg);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onRenderFail(adProviderType, adObject, code, msg);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderSuccess(View view, float width, float height) {
                    WifiLog.d("NestCsjNativeView onRenderSuccess width = " + width + " height=" + height);
                    container.removeAllViews();
                    container.addView(view);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onRenderSuccess(adProviderType, adObject);
                    }
                }
            });
            tTNativeExpressAd.render();
            WifiLog.d("NestCsjNativeView showDrawNativeAd render ");
        }
    }

    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void showNative(String adProviderType, Object adObject, ViewGroup container, NativeViewListener listener) {
        AdImageLoader mImageLoader;
        AdImageLoader mImageLoader2;
        AdImageLoader mImageLoader3;
        AdImageLoader mImageLoader4;
        AdImageLoader mImageLoader5;
        if (adObject instanceof TTFeedAd) {
            View viewInflate = View.inflate(container.getContext(), R.layout.layout_native_view_csj_common, container);
            LinearLayout mLlSuper = (LinearLayout) viewInflate.findViewById(R.id.ll_super);
            FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.fl_parent);
            LinearLayout mLlAdContainer = (LinearLayout) viewInflate.findViewById(R.id.ll_ad_container);
            ImageView mImgPoster0 = (ImageView) viewInflate.findViewById(R.id.img_poster1);
            ImageView mImgPoster1 = (ImageView) viewInflate.findViewById(R.id.img_poster2);
            ImageView mImgPoster2 = (ImageView) viewInflate.findViewById(R.id.img_poster3);
            FrameLayout mFlVideoContainer = (FrameLayout) viewInflate.findViewById(R.id.fl_ad_container);
            TextView mTvTitle = (TextView) viewInflate.findViewById(R.id.tv_title);
            TextView mTvDesc = (TextView) viewInflate.findViewById(R.id.tv_desc);
            ViewGroup.LayoutParams layoutParams = frameLayout != null ? frameLayout.getLayoutParams() : null;
            if (layoutParams != null) {
                ScreenUtil screenUtil = ScreenUtil.INSTANCE;
                Context context = container.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "container.context");
                layoutParams.height = (screenUtil.getDisplayMetricsWidth(context) * 9) / 16;
            }
            ArrayList arrayList = new ArrayList();
            Intrinsics.checkExpressionValueIsNotNull(mLlSuper, "mLlSuper");
            arrayList.add(mLlSuper);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(mLlSuper);
            TTFeedAd tTFeedAd = (TTFeedAd) adObject;
            tTFeedAd.registerViewForInteraction(mLlSuper, arrayList, arrayList2, new TTNativeAd.AdInteractionListener() { // from class: com.wifi.csj.ad.NestCsjNativeView.showNative.1
                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdShow(TTNativeAd ad) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdClicked(View view, TTNativeAd ad) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdCreativeClick(View view, TTNativeAd ad) {
                }
            });
            Intrinsics.checkExpressionValueIsNotNull(mTvTitle, "mTvTitle");
            mTvTitle.setText(tTFeedAd.getTitle());
            Intrinsics.checkExpressionValueIsNotNull(mTvDesc, "mTvDesc");
            mTvDesc.setText(tTFeedAd.getDescription());
            int imageMode = tTFeedAd.getImageMode();
            if (imageMode != 2 && imageMode != 3) {
                if (imageMode == 4) {
                    Intrinsics.checkExpressionValueIsNotNull(mLlAdContainer, "mLlAdContainer");
                    mLlAdContainer.setVisibility(0);
                    Intrinsics.checkExpressionValueIsNotNull(mFlVideoContainer, "mFlVideoContainer");
                    mFlVideoContainer.setVisibility(8);
                    Intrinsics.checkExpressionValueIsNotNull(mImgPoster1, "mImgPoster1");
                    mImgPoster1.setVisibility(0);
                    Intrinsics.checkExpressionValueIsNotNull(mImgPoster2, "mImgPoster2");
                    mImgPoster2.setVisibility(0);
                    List<TTImage> imageList = tTFeedAd.getImageList();
                    Intrinsics.checkExpressionValueIsNotNull(imageList, "imageList");
                    List<TTImage> list = imageList;
                    if ((!list.isEmpty()) && imageList.get(0) != null) {
                        TTImage tTImage = imageList.get(0);
                        Intrinsics.checkExpressionValueIsNotNull(tTImage, "imageList[0]");
                        if (tTImage.isValid() && (mImageLoader4 = TogetherAd.INSTANCE.getMImageLoader()) != null) {
                            Context context2 = container.getContext();
                            Intrinsics.checkExpressionValueIsNotNull(context2, "container.context");
                            Intrinsics.checkExpressionValueIsNotNull(mImgPoster0, "mImgPoster0");
                            TTImage tTImage2 = imageList.get(0);
                            Intrinsics.checkExpressionValueIsNotNull(tTImage2, "imageList[0]");
                            String imageUrl = tTImage2.getImageUrl();
                            Intrinsics.checkExpressionValueIsNotNull(imageUrl, "imageList[0].imageUrl");
                            mImageLoader4.loadImage(context2, mImgPoster0, imageUrl);
                        }
                    }
                    if ((!list.isEmpty()) && imageList.size() > 1 && imageList.get(1) != null) {
                        TTImage tTImage3 = imageList.get(1);
                        Intrinsics.checkExpressionValueIsNotNull(tTImage3, "imageList[1]");
                        if (tTImage3.isValid() && (mImageLoader3 = TogetherAd.INSTANCE.getMImageLoader()) != null) {
                            Context context3 = container.getContext();
                            Intrinsics.checkExpressionValueIsNotNull(context3, "container.context");
                            TTImage tTImage4 = imageList.get(1);
                            Intrinsics.checkExpressionValueIsNotNull(tTImage4, "imageList[1]");
                            String imageUrl2 = tTImage4.getImageUrl();
                            Intrinsics.checkExpressionValueIsNotNull(imageUrl2, "imageList[1].imageUrl");
                            mImageLoader3.loadImage(context3, mImgPoster1, imageUrl2);
                        }
                    }
                    if (!(!list.isEmpty()) || imageList.size() <= 2) {
                        return;
                    }
                    TTImage tTImage5 = imageList.get(2);
                    Intrinsics.checkExpressionValueIsNotNull(tTImage5, "imageList[2]");
                    if (!tTImage5.isValid() || (mImageLoader2 = TogetherAd.INSTANCE.getMImageLoader()) == null) {
                        return;
                    }
                    Context context4 = container.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context4, "container.context");
                    TTImage tTImage6 = imageList.get(2);
                    Intrinsics.checkExpressionValueIsNotNull(tTImage6, "imageList[2]");
                    String imageUrl3 = tTImage6.getImageUrl();
                    Intrinsics.checkExpressionValueIsNotNull(imageUrl3, "imageList[2].imageUrl");
                    mImageLoader2.loadImage(context4, mImgPoster2, imageUrl3);
                    return;
                }
                if (imageMode == 5 || imageMode == 15) {
                    Intrinsics.checkExpressionValueIsNotNull(mLlAdContainer, "mLlAdContainer");
                    mLlAdContainer.setVisibility(0);
                    Intrinsics.checkExpressionValueIsNotNull(mFlVideoContainer, "mFlVideoContainer");
                    mFlVideoContainer.setVisibility(8);
                    Intrinsics.checkExpressionValueIsNotNull(mImgPoster1, "mImgPoster1");
                    mImgPoster1.setVisibility(8);
                    Intrinsics.checkExpressionValueIsNotNull(mImgPoster2, "mImgPoster2");
                    mImgPoster2.setVisibility(8);
                    TTImage videoCoverImage = tTFeedAd.getVideoCoverImage();
                    if (videoCoverImage == null || videoCoverImage.getImageUrl() == null || (mImageLoader5 = TogetherAd.INSTANCE.getMImageLoader()) == null) {
                        return;
                    }
                    Context context5 = container.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context5, "container.context");
                    Intrinsics.checkExpressionValueIsNotNull(mImgPoster0, "mImgPoster0");
                    String imageUrl4 = videoCoverImage.getImageUrl();
                    Intrinsics.checkExpressionValueIsNotNull(imageUrl4, "videoCoverImage.imageUrl");
                    mImageLoader5.loadImage(context5, mImgPoster0, imageUrl4);
                    return;
                }
                if (imageMode != 16) {
                    return;
                }
            }
            Intrinsics.checkExpressionValueIsNotNull(mLlAdContainer, "mLlAdContainer");
            mLlAdContainer.setVisibility(0);
            Intrinsics.checkExpressionValueIsNotNull(mFlVideoContainer, "mFlVideoContainer");
            mFlVideoContainer.setVisibility(8);
            Intrinsics.checkExpressionValueIsNotNull(mImgPoster1, "mImgPoster1");
            mImgPoster1.setVisibility(8);
            Intrinsics.checkExpressionValueIsNotNull(mImgPoster2, "mImgPoster2");
            mImgPoster2.setVisibility(8);
            List<TTImage> imageList2 = tTFeedAd.getImageList();
            Intrinsics.checkExpressionValueIsNotNull(imageList2, "imageList");
            if (!(!imageList2.isEmpty()) || imageList2.get(0) == null) {
                return;
            }
            TTImage tTImage7 = imageList2.get(0);
            Intrinsics.checkExpressionValueIsNotNull(tTImage7, "imageList[0]");
            if (!tTImage7.isValid() || (mImageLoader = TogetherAd.INSTANCE.getMImageLoader()) == null) {
                return;
            }
            Context context6 = container.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context6, "container.context");
            Intrinsics.checkExpressionValueIsNotNull(mImgPoster0, "mImgPoster0");
            TTImage tTImage8 = imageList2.get(0);
            Intrinsics.checkExpressionValueIsNotNull(tTImage8, "imageList[0]");
            String imageUrl5 = tTImage8.getImageUrl();
            Intrinsics.checkExpressionValueIsNotNull(imageUrl5, "imageList[0].imageUrl");
            mImageLoader.loadImage(context6, mImgPoster0, imageUrl5);
        }
    }

    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void showNativeDrawVideoAd(String adProviderType, NestAdData adObject, ViewGroup container, NativeViewListener listener) {
        WifiLog.d("NestCsjNativeView showNativeDrawVideoAd render ");
        if (adObject.getAdData() instanceof TTDrawFeedAd) {
            INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
            Object adData = adObject.getAdData();
            if (adData == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.bytedance.sdk.openadsdk.TTDrawFeedAd");
            }
            TTDrawFeedAd tTDrawFeedAd = (TTDrawFeedAd) adData;
            Context context = container.getContext();
            if (context == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
            }
            tTDrawFeedAd.setActivityForDownloadApp((Activity) context);
            tTDrawFeedAd.setDrawVideoListener(new TTDrawFeedAd.DrawVideoListener() { // from class: com.wifi.csj.ad.NestCsjNativeView.showNativeDrawVideoAd.1
                @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd.DrawVideoListener
                public void onClick() {
                    WifiLog.d("NestCsjNativeView  showNativeDrawVideoAd onClick download or view detail page ! !");
                }

                @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd.DrawVideoListener
                public void onClickRetry() {
                    WifiLog.d("NestCsjNativeView  showNativeDrawVideoAd onClickRetry!");
                }
            });
            tTDrawFeedAd.setCanInterruptVideoPlay(true);
            Context context2 = container.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "container.context");
            tTDrawFeedAd.setPauseIcon(BitmapFactory.decodeResource(context2.getResources(), adObject.getPauseIcon()), 50);
            View adView = tTDrawFeedAd.getAdView();
            ImageView imageView = new ImageView(container.getContext());
            if (adView != null) {
                container.removeAllViews();
                container.addView(adView);
                AdDownViVoConfig.checkVideoViewClick(adObject, container);
            } else {
                container.removeAllViews();
                if (tTDrawFeedAd.getImageList() != null) {
                    List<TTImage> imageList = tTDrawFeedAd.getImageList();
                    if (imageList == null) {
                        Intrinsics.throwNpe();
                    }
                    if (imageList.size() > 0) {
                        List<TTImage> imageList2 = tTDrawFeedAd.getImageList();
                        if (imageList2 == null) {
                            Intrinsics.throwNpe();
                        }
                        TTImage tTImage = imageList2.get(0);
                        Intrinsics.checkExpressionValueIsNotNull(tTImage, "ad!!.imageList!![0]");
                        if (tTImage.getImageUrl() != null) {
                            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                            AdImageLoader mImageLoader = TogetherAd.INSTANCE.getMImageLoader();
                            if (mImageLoader != null) {
                                Context context3 = container.getContext();
                                Intrinsics.checkExpressionValueIsNotNull(context3, "container.context");
                                List<TTImage> imageList3 = tTDrawFeedAd.getImageList();
                                if (imageList3 == null) {
                                    Intrinsics.throwNpe();
                                }
                                TTImage tTImage2 = imageList3.get(0);
                                Intrinsics.checkExpressionValueIsNotNull(tTImage2, "ad!!.imageList!![0]");
                                String imageUrl = tTImage2.getImageUrl();
                                Intrinsics.checkExpressionValueIsNotNull(imageUrl, "ad!!.imageList!![0].imageUrl");
                                mImageLoader.loadImage(context3, imageView, imageUrl);
                            }
                            LinearLayout linearLayout = new LinearLayout(container.getContext());
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
                            linearLayout.setOrientation(1);
                            layoutParams2.gravity = 16;
                            linearLayout.addView(imageView, layoutParams);
                            container.addView(linearLayout, layoutParams2);
                        }
                    }
                }
            }
            initAdViewAndAction(adObject, imageView, container, listener, adProviderType);
        }
    }

    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void showTemplateFeedAd(String adProviderType, NestAdData adObject, ViewGroup container, NativeViewListener listener, Activity activity) {
        if (adObject.getAdData() instanceof TTNativeExpressAd) {
            INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
            Object adData = adObject.getAdData();
            if (adData == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.bytedance.sdk.openadsdk.TTNativeExpressAd");
            }
            WifiLog.d("NestCsjNativeView showTemplateFeedAd render ");
        }
    }
}
