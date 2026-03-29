package com.wifi.gdt.ad;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.ad.constant.bq;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.compliance.AdDownViVoConfig;
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
import com.wifi.gdt.ad.NestGdtNativeView;
import com.wifi.gdt.ad.view.GdtSdkDownloadFixWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000eH\u0002JF\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J*\u0010\"\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J*\u0010#\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J*\u0010%\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J4\u0010&\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010'\u001a\u0004\u0018\u00010(H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006*"}, d2 = {"Lcom/wifi/gdt/ad/NestGdtNativeView;", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "()V", "mHasShowDownloadActive", "", "getMHasShowDownloadActive", "()Z", "setMHasShowDownloadActive", "(Z)V", "changeDownloadStatus", "", "adObject", "Lcom/wifi/ad/core/data/NestAdData;", "ad", "Lcom/qq/e/ads/nativ/NativeUnifiedADData;", "adView", "Lcom/wifi/ad/core/view/WifiAdMagicView;", "button", "Landroid/widget/TextView;", bq.f.s, "Lcom/wifi/ad/core/listener/NativeViewListener;", "checkGdtAdInteractionType", "", "context", "Landroid/content/Context;", "registerViewAndActionFeedAd", "adProviderType", "container", "Landroid/view/ViewGroup;", "clickViews", "", "Landroid/view/View;", "creativeViews", "nestAdData", "showDrawVideoAd", "showNative", "", "showNativeDrawVideoAd", "showTemplateFeedAd", "activity", "Landroid/app/Activity;", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestGdtNativeView extends BaseNativeView {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean mHasShowDownloadActive;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ/\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/wifi/gdt/ad/NestGdtNativeView$Companion;", "", "()V", "onEvent", "", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "eventKey", "", "errorCode", "", "message", "(Lcom/wifi/ad/core/data/NestAdData;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final void onEvent(NestAdData nestAdData, String eventKey) {
            onEvent(nestAdData, eventKey, null, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void onEvent(NestAdData nestAdData, String eventKey, Integer errorCode, String message) throws JSONException {
            String title;
            String desc;
            String imgUrl;
            String nestType;
            if (nestAdData.getAdData() instanceof NativeUnifiedADData) {
                Object adData = nestAdData.getAdData();
                if (adData == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.qq.e.ads.nativ.NativeUnifiedADData");
                }
                NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) adData;
                title = nativeUnifiedADData.getTitle();
                imgUrl = nativeUnifiedADData.getImgUrl();
                desc = nativeUnifiedADData.getDesc();
            } else {
                title = null;
                desc = null;
                imgUrl = null;
            }
            EventParams.Builder srcId = new EventParams.Builder().setDspName(NestGdtProvider.DSP_NAME).setNestSid(nestAdData.getNestSid()).setPosition(nestAdData.getPosition()).setTmAdBtnShow(nestAdData.getShowAdButtonTime()).setRedAdBtnShow(nestAdData.getChangeAdBtnColorTime()).setCtAdBtnShow(nestAdData.getShowAdCardTime()).setSdkFrom("guangdiantong").setInventoryId(nestAdData.getInventoryId()).setRenderStyle(nestAdData.getRenderStyle()).setMediaId(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.GDT)).setSrcId(nestAdData.getAdCode());
            AdParams adParams = nestAdData.getAdParams();
            if (adParams == null || (nestType = adParams.getNestType()) == null) {
                nestType = "";
            }
            EventParams.Builder nestType2 = srcId.setNestType(nestType);
            Integer adMode = nestAdData.getAdMode();
            EventParams.Builder params = nestType2.setAdMode((adMode != null ? adMode : "").toString()).setAdTitle(title).setAdImage(imgUrl).setAdDesc(desc);
            if (errorCode != null) {
                params.setErrorCode(String.valueOf(errorCode.intValue()));
            }
            EventReporter eventReporter = EventReporter.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(params, "params");
            eventReporter.reportViewEvent(params, nestAdData, eventKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeDownloadStatus(NestAdData adObject, NativeUnifiedADData ad, WifiAdMagicView adView, TextView button, NativeViewListener listener) {
        try {
            WifiLog.d("changeDownloadStatus ad.appStatus = " + ad.getAppStatus());
            int appStatus = ad.getAppStatus();
            if (appStatus == 0) {
                this.mHasShowDownloadActive = false;
                adObject.setDownloadStatus(0);
                return;
            }
            if (appStatus == 1) {
                if (adView != null) {
                    adView.updateAdBtnShow(WifiAdMagicView.getOpenText());
                }
                if (button != null) {
                    button.setText(WifiAdMagicView.getOpenText());
                }
                INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_INSTALLED);
                NestAdData.AppDownloadListener appDownloadListener = adObject.getAppDownloadListener();
                if (appDownloadListener != null) {
                    appDownloadListener.onDownloadInstalled(adObject);
                }
                adObject.setDownloadStatus(5);
                return;
            }
            if (appStatus == 2) {
                if (adView != null) {
                    Context context = adView.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context, "adView.context");
                    adView.updateAdBtnShow(checkGdtAdInteractionType(context, ad));
                }
                if (button != null) {
                    Context context2 = button.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context2, "button!!.context");
                    button.setText(checkGdtAdInteractionType(context2, ad));
                    return;
                }
                return;
            }
            if (appStatus == 4) {
                if (adView != null) {
                    StringBuilder sb = new StringBuilder();
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str = String.format("下载中... %s", Arrays.copyOf(new Object[]{Integer.valueOf(ad.getProgress())}, 1));
                    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(format, *args)");
                    sb.append(str);
                    sb.append("%");
                    adView.updateAdBtnShow(sb.toString());
                }
                if (!this.mHasShowDownloadActive) {
                    this.mHasShowDownloadActive = true;
                    INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADING);
                    NestAdData.AppDownloadListener appDownloadListener2 = adObject.getAppDownloadListener();
                    if (appDownloadListener2 != null) {
                        appDownloadListener2.onDownloadStart(adObject);
                    }
                    adObject.setDownloadStatus(1);
                }
                if (listener != null) {
                    listener.onDownloadProgress(SDKAlias.GDT.getType(), adObject, ad.getProgress());
                }
                adObject.setDownloadStatus(3);
                return;
            }
            if (appStatus == 8) {
                if (adView != null) {
                    adView.updateAdBtnShow(WifiAdMagicView.getInstallText());
                }
                if (button != null) {
                    button.setText(WifiAdMagicView.getInstallText());
                }
                INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADED);
                NestAdData.AppDownloadListener appDownloadListener3 = adObject.getAppDownloadListener();
                if (appDownloadListener3 != null) {
                    appDownloadListener3.onDownloadComplete(adObject);
                }
                adObject.setDownloadStatus(4);
                return;
            }
            if (appStatus == 16) {
                if (adView != null) {
                    Context context3 = adView.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context3, "adView.context");
                    adView.updateAdBtnShow(checkGdtAdInteractionType(context3, ad));
                }
                if (button != null) {
                    Context context4 = button.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context4, "button!!.context");
                    button.setText(checkGdtAdInteractionType(context4, ad));
                }
                INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_NODOWNLOAD);
                NestAdData.AppDownloadListener appDownloadListener4 = adObject.getAppDownloadListener();
                if (appDownloadListener4 != null) {
                    appDownloadListener4.onDownloadFailed(adObject);
                }
                adObject.setDownloadStatus(6);
                return;
            }
            if (appStatus == 32) {
                if (adView != null) {
                    adView.updateAdBtnShow(WifiAdMagicView.getContinueText());
                }
                if (button != null) {
                    button.setText(WifiAdMagicView.getContinueText());
                }
                NestAdData.AppDownloadListener appDownloadListener5 = adObject.getAppDownloadListener();
                if (appDownloadListener5 != null) {
                    appDownloadListener5.onDownloadPause(adObject);
                }
                adObject.setDownloadStatus(2);
                return;
            }
            if (appStatus != 64) {
                return;
            }
            if (adView != null) {
                Context context5 = adView.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context5, "adView.context");
                adView.updateAdBtnShow(checkGdtAdInteractionType(context5, ad));
            }
            if (button != null) {
                if (adView == null) {
                    Intrinsics.throwNpe();
                }
                Context context6 = adView.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context6, "adView!!.context");
                button.setText(checkGdtAdInteractionType(context6, ad));
            }
            adObject.setDownloadStatus(0);
        } catch (Exception unused) {
        }
    }

    private final String checkGdtAdInteractionType(Context context, NativeUnifiedADData ad) {
        WifiLog.d("NestCsjNativeView showNativeDrawVideoAd checkCsjAdInteractionType ad type " + ad.isAppAd() + ' ');
        boolean zBooleanValue = Boolean.valueOf(ad.isAppAd()).booleanValue();
        if (!zBooleanValue) {
            if (context != null) {
                return context.getString(R.string.see_detail);
            }
            return null;
        }
        if (!zBooleanValue) {
            throw new NoWhenBranchMatchedException();
        }
        if (context != null) {
            return context.getString(R.string.download_quick);
        }
        return null;
    }

    public final boolean getMHasShowDownloadActive() {
        return this.mHasShowDownloadActive;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5, types: [T, android.view.View] */
    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void registerViewAndActionFeedAd(final String adProviderType, ViewGroup container, List<View> clickViews, List<View> creativeViews, final NestAdData nestAdData, final NativeViewListener listener) {
        INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        Object adData = nestAdData.getAdData();
        if (adData == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.qq.e.ads.nativ.NativeUnifiedADData");
        }
        final NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) adData;
        WifiLog.d("NestGdtNativeView registerViewAndActionFeedAd feedAd = " + nativeUnifiedADData.getDesc());
        NativeAdContainer nativeAdContainer = (NativeAdContainer) container.findViewWithTag("gdtAdContainer");
        if (nativeAdContainer instanceof NativeAdContainer) {
            final TextView adButtonView = getAdButtonView(clickViews, creativeViews);
            if (adButtonView != null) {
                CharSequence text = adButtonView.getText();
                if (text != null) {
                    nestAdData.setRespbtnwd(text.toString());
                    nestAdData.setShowbtnwd(text.toString());
                }
                if (WifiNestAd.INSTANCE.getSwitch315() && nativeUnifiedADData.isAppAd()) {
                    Context context = container.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context, "container.context");
                    adButtonView.setText(context.getResources().getString(R.string.download_quick));
                    nestAdData.setShowbtnwd(adButtonView.getText().toString());
                    GdtSdkDownloadFixWrapper gdtSdkDownloadFixWrapper = new GdtSdkDownloadFixWrapper(container.getContext());
                    gdtSdkDownloadFixWrapper.setNestAdData(nestAdData);
                    gdtSdkDownloadFixWrapper.wrapView(adButtonView);
                    gdtSdkDownloadFixWrapper.wrapData(nativeUnifiedADData);
                }
            }
            nativeUnifiedADData.bindAdToView(container.getContext(), nativeAdContainer, null, creativeViews);
            nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListener() { // from class: com.wifi.gdt.ad.NestGdtNativeView.registerViewAndActionFeedAd.2
                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADClicked() {
                    WifiLog.d("NestGdtNativeView registerViewAndActionFeedAd onADClicked: " + nativeUnifiedADData.getTitle());
                    NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onAdClicked(adProviderType, nestAdData);
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADError(AdError error) throws JSONException {
                    WifiLog.d("NestGdtNativeView registerViewAndActionFeedAd onADError error code :" + error.getErrorCode() + "  error msg: " + error.getErrorMsg());
                    NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW_FAIL, Integer.valueOf(error.getErrorCode()), error.getErrorMsg());
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADExposed() {
                    WifiLog.d("NestGdtNativeView registerViewAndActionFeedAd onADExposed: " + nativeUnifiedADData.getTitle());
                    NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onAdExposed(adProviderType, nestAdData);
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADStatusChanged() {
                    WifiLog.d("NestGdtNativeView registerViewAndActionFeedAd onADStatusChanged");
                    NestGdtNativeView.this.changeDownloadStatus(nestAdData, nativeUnifiedADData, null, adButtonView, listener);
                }
            });
            if (nativeUnifiedADData.getAdPatternType() == 2) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ?? adView = nestAdData.getAdView();
                objectRef.element = adView;
                if (!(adView instanceof MediaView) || adView == 0) {
                    return;
                }
                VideoOption videoOptionBuild = new VideoOption.Builder().setAutoPlayPolicy(1).setAutoPlayMuted(true).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build();
                Intrinsics.checkExpressionValueIsNotNull(videoOptionBuild, "VideoOption.Builder()\n  …                 .build()");
                nativeUnifiedADData.bindMediaView((MediaView) ((View) objectRef.element), videoOptionBuild, new NativeADMediaListener() { // from class: com.wifi.gdt.ad.NestGdtNativeView$registerViewAndActionFeedAd$$inlined$let$lambda$1
                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoClicked() {
                        WifiLog.d("NestGdtNativeView registerViewAndActionFeedAd onVideoClicked");
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoCompleted() {
                        WifiLog.d("NestGdtNativeView registerViewAndActionFeedAd onVideoCompleted: ");
                        NestGdtNativeView.Companion companion = NestGdtNativeView.INSTANCE;
                        companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOE);
                        companion.onEvent(nestAdData, WifiNestConst.EventKey.NEST_SDK_ENDPLAY_SHOW);
                        NestAdData.VideoAdListener videoAdListener = nestAdData.getVideoAdListener();
                        if (videoAdListener != null) {
                            videoAdListener.onVideoComplete(nestAdData);
                        }
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoError(AdError adError) {
                        WifiLog.d("NestGdtNativeView registerViewAndActionFeedAd onVideoError: ");
                        NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOT);
                        NestAdData.VideoAdListener videoAdListener = nestAdData.getVideoAdListener();
                        if (videoAdListener != null) {
                            videoAdListener.onVideoError(nestAdData);
                        }
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoInit() {
                        WifiLog.d("NestGdtNativeView registerViewAndActionFeedAd onVideoInit: ");
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoLoaded(int i) {
                        WifiLog.d("NestGdtNativeView registerViewAndActionFeedAd onVideoLoaded: ");
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoLoading() {
                        WifiLog.d("NestGdtNativeView registerViewAndActionFeedAd onVideoLoading: ");
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoPause() {
                        WifiLog.d("NestGdtNativeView registerViewAndActionFeedAd onVideoPause: ");
                        NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOB);
                        NestAdData.VideoAdListener videoAdListener = nestAdData.getVideoAdListener();
                        if (videoAdListener != null) {
                            videoAdListener.onVideoPause(nestAdData);
                        }
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoReady() {
                        WifiLog.d("NestGdtNativeView registerViewAndActionFeedAd onVideoReady ");
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoResume() {
                        WifiLog.d("NestGdtNativeView registerViewAndActionFeedAd onVideoResume: ");
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoStart() {
                        WifiLog.d("NestGdtNativeView registerViewAndActionFeedAd onVideoStart ");
                        NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOS);
                        NestAdData.VideoAdListener videoAdListener = nestAdData.getVideoAdListener();
                        if (videoAdListener != null) {
                            videoAdListener.onVideoStart(nestAdData);
                        }
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoStop() {
                        WifiLog.d("NestGdtNativeView registerViewAndActionFeedAd onVideoStop");
                    }
                });
                AdDownViVoConfig.checkVideoViewClick(nestAdData);
            }
        }
    }

    public final void setMHasShowDownloadActive(boolean z) {
        this.mHasShowDownloadActive = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b3  */
    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void showNative(String adProviderType, Object adObject, ViewGroup container, NativeViewListener listener) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        if (adObject instanceof NativeUnifiedADData) {
            View viewInflate = View.inflate(container.getContext(), R.layout.layout_native_view_gdt_common, container);
            NativeAdContainer nativeAdContainer = (NativeAdContainer) viewInflate.findViewById(R.id.native_ad_container);
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ll_super);
            ImageView mImgPoster = (ImageView) viewInflate.findViewById(R.id.img_poster);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_desc);
            MediaView mAdGdtMediaPlayer = (MediaView) viewInflate.findViewById(R.id.gdt_media_view);
            if (mImgPoster != null && (layoutParams2 = mImgPoster.getLayoutParams()) != null) {
                ScreenUtil screenUtil = ScreenUtil.INSTANCE;
                Context context = container.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "container.context");
                layoutParams2.height = (screenUtil.getDisplayMetricsWidth(context) * 9) / 16;
            }
            if (mAdGdtMediaPlayer != null && (layoutParams = mAdGdtMediaPlayer.getLayoutParams()) != null) {
                ScreenUtil screenUtil2 = ScreenUtil.INSTANCE;
                Context context2 = container.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "container.context");
                layoutParams.height = (screenUtil2.getDisplayMetricsWidth(context2) * 9) / 16;
            }
            if (textView != null) {
                textView.setText(((NativeUnifiedADData) adObject).getTitle());
            }
            if (textView2 != null) {
                textView2.setText(((NativeUnifiedADData) adObject).getDesc());
            }
            NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) adObject;
            int adPatternType = nativeUnifiedADData.getAdPatternType();
            if (adPatternType == 1) {
                Intrinsics.checkExpressionValueIsNotNull(mAdGdtMediaPlayer, "mAdGdtMediaPlayer");
                mAdGdtMediaPlayer.setVisibility(8);
                Intrinsics.checkExpressionValueIsNotNull(mImgPoster, "mImgPoster");
                mImgPoster.setVisibility(0);
                AdImageLoader mImageLoader = TogetherAd.INSTANCE.getMImageLoader();
                if (mImageLoader != null) {
                    Context context3 = container.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context3, "container.context");
                    String imgUrl = nativeUnifiedADData.getImgUrl();
                    Intrinsics.checkExpressionValueIsNotNull(imgUrl, "adObject.imgUrl");
                    mImageLoader.loadImage(context3, mImgPoster, imgUrl);
                }
            } else if (adPatternType == 2) {
                Intrinsics.checkExpressionValueIsNotNull(mAdGdtMediaPlayer, "mAdGdtMediaPlayer");
                mAdGdtMediaPlayer.setVisibility(0);
                Intrinsics.checkExpressionValueIsNotNull(mImgPoster, "mImgPoster");
                mImgPoster.setVisibility(8);
            } else if (adPatternType == 3) {
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(linearLayout);
            arrayList.add(mImgPoster);
            arrayList.add(mAdGdtMediaPlayer);
            nativeUnifiedADData.bindAdToView(container.getContext(), nativeAdContainer, null, arrayList);
            nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListener() { // from class: com.wifi.gdt.ad.NestGdtNativeView.showNative.1
                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADClicked() {
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADExposed() {
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADStatusChanged() {
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADError(AdError error) {
                }
            });
            if (nativeUnifiedADData.getAdPatternType() != 2) {
                return;
            }
            nativeUnifiedADData.bindMediaView(mAdGdtMediaPlayer, new VideoOption.Builder().setAutoPlayMuted(true).setAutoPlayPolicy(1).build(), new NativeADMediaListener() { // from class: com.wifi.gdt.ad.NestGdtNativeView.showNative.2
                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoClicked() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoCompleted() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoInit() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoLoading() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoPause() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoReady() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoResume() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoStart() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoStop() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoError(AdError p0) {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoLoaded(int p0) {
                }
            });
            nativeUnifiedADData.startVideo();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, com.wifi.ad.core.view.WifiAdMagicView] */
    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void showNativeDrawVideoAd(final String adProviderType, final NestAdData adObject, ViewGroup container, final NativeViewListener listener) {
        INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        Object adData = adObject.getAdData();
        if (adData == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.qq.e.ads.nativ.NativeUnifiedADData");
        }
        final NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) adData;
        WifiLog.d("NestGdtNativeView showNativeDrawVideoAd drawAd = " + nativeUnifiedADData.getDesc());
        View viewInflate = LayoutInflater.from(container.getContext()).inflate(R.layout.layout_nest_gdt_draw_view, (ViewGroup) null, false);
        ImageView mImgPoster = (ImageView) viewInflate.findViewById(R.id.img_poster);
        MediaView mediaView = (MediaView) viewInflate.findViewById(R.id.gdt_media_view);
        NativeAdContainer nativeAdContainer = (NativeAdContainer) viewInflate.findViewById(R.id.native_ad_container);
        container.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new WifiAdMagicView(container.getContext());
        int i = !nativeUnifiedADData.isAppAd() ? 2 : 1;
        WifiAdMagicView.Config.Builder bgInfo = new WifiAdMagicView.Config.Builder().setAuthorInfo(nativeUnifiedADData.getDesc()).setAuthorName(nativeUnifiedADData.getTitle()).setCardInfo(nativeUnifiedADData.getDesc()).setCardTitle(nativeUnifiedADData.getTitle()).setCardIcon(nativeUnifiedADData.getImgUrl()).setBgName(nativeUnifiedADData.getTitle()).setBgInfo(nativeUnifiedADData.getDesc());
        Context context = container.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "container.context");
        WifiAdMagicView.Config.Builder downLoadType = bgInfo.setButton(checkGdtAdInteractionType(context, nativeUnifiedADData)).setShowAdBtnTime(adObject.getShowAdButtonTime()).setChangeAdBtnColorTime(adObject.getChangeAdBtnColorTime()).setShowAdCardTime(adObject.getShowAdCardTime()).setScene(adObject.getAdScene()).setDownLoadType(i);
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        ((WifiAdMagicView) objectRef.element).configViewData(downLoadType.setLogoResId(wifiNestAd.getMPersonalizedAd() ? R.drawable.icon_personalized_gdt_logo : R.drawable.icon_gdt_logo_with_txt).setAppName(adObject.getAdAppName()).setDeveloperName(adObject.getAdAppDeveloperName()).setPermissionsUrl(adObject.getAdAppPermissionsUrl()).setPrivacyUrl(adObject.getAdAppPrivacyUrl()).setFunctionUrl(adObject.getAdAppFunctionDescUrl()).setAppVersion(adObject.getAdAppVersion()).setAdType(SDKAlias.GDT.getType()).setNewStyleEnable(wifiNestAd.isDrawVideoNewStyleEnable()).build());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        nativeAdContainer.addView((WifiAdMagicView) objectRef.element, layoutParams);
        if (!wifiNestAd.isDrawVideoNewStyleEnable()) {
            WifiAdMagicTopView wifiAdMagicTopView = new WifiAdMagicTopView(container.getContext());
            wifiAdMagicTopView.configViewData(new WifiAdMagicTopView.Config.Builder().setAppName(nativeUnifiedADData.getTitle()).setCardIcon(nativeUnifiedADData.getImgUrl()).build());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(10);
            ScreenUtil screenUtil = ScreenUtil.INSTANCE;
            Context context2 = container.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "container.context");
            layoutParams2.leftMargin = screenUtil.dp2px(context2, 42.0f);
            nativeAdContainer.addView(wifiAdMagicTopView, layoutParams2);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(((WifiAdMagicView) objectRef.element).getClickViews());
        arrayList.add(mImgPoster);
        ArrayList arrayList2 = new ArrayList();
        WifiLog.d("downAd gdt nativeDraw adObject.interactionType " + adObject.getInteractionType() + " ad.isAppAd " + nativeUnifiedADData.isAppAd());
        if (nativeUnifiedADData.isAppAd()) {
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
        List<View> listCreateClickView = AdDownViVoConfig.createClickView(arrayList, arrayList2, adObject, arrayList);
        Intrinsics.checkExpressionValueIsNotNull(listCreateClickView, "AdDownViVoConfig.createC… clickableViews\n        )");
        nativeUnifiedADData.bindAdToView(container.getContext(), nativeAdContainer, null, listCreateClickView);
        WifiDownWebButton firstButton2 = ((WifiAdMagicView) objectRef.element).getFirstButton();
        Intrinsics.checkExpressionValueIsNotNull(firstButton2, "adView.firstButton");
        CharSequence text = firstButton2.getText();
        if (text != null) {
            adObject.setRespbtnwd(text.toString());
            adObject.setShowbtnwd(text.toString());
        }
        GdtSdkDownloadFixWrapper gdtSdkDownloadFixWrapper = new GdtSdkDownloadFixWrapper(container.getContext());
        gdtSdkDownloadFixWrapper.setNestAdData(adObject);
        gdtSdkDownloadFixWrapper.wrapView(((WifiAdMagicView) objectRef.element).getFirstButton());
        gdtSdkDownloadFixWrapper.wrapData(nativeUnifiedADData);
        GdtSdkDownloadFixWrapper gdtSdkDownloadFixWrapper2 = new GdtSdkDownloadFixWrapper(container.getContext());
        gdtSdkDownloadFixWrapper2.setNestAdData(adObject);
        gdtSdkDownloadFixWrapper2.wrapView(((WifiAdMagicView) objectRef.element).getSecondButton());
        gdtSdkDownloadFixWrapper2.wrapData(nativeUnifiedADData);
        GdtSdkDownloadFixWrapper gdtSdkDownloadFixWrapper3 = new GdtSdkDownloadFixWrapper(container.getContext());
        gdtSdkDownloadFixWrapper3.setNestAdData(adObject);
        gdtSdkDownloadFixWrapper3.wrapView(((WifiAdMagicView) objectRef.element).getBgDownload());
        gdtSdkDownloadFixWrapper3.wrapData(nativeUnifiedADData);
        ((WifiAdMagicView) objectRef.element).setOnAdViewListener(new WifiAdMagicView.OnAdViewListener() { // from class: com.wifi.gdt.ad.NestGdtNativeView.showNativeDrawVideoAd.2
            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onAdTagClick(View view) {
                WifiLog.d("NestGdtNativeView showNativeDrawVideoAd  onAdTagClick");
            }

            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onCardCloseClick(View view) {
                WifiLog.d("NestGdtNativeView showNativeDrawVideoAd onCardCloseClick");
                NestGdtNativeView.INSTANCE.onEvent(adObject, "nest_sdk_cancle_click");
            }

            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onCardShow() {
                WifiLog.d("NestGdtNativeView showNativeDrawVideoAd  onCardShow");
                NestGdtNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.NEST_SDK_CHUANGTI_SHOW);
            }

            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onCompleteBgShow() {
                WifiLog.d("NestGdtNativeView showNativeDrawVideoAd  onCompleteBgShow");
                NestGdtNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.NEST_SDK_ENDPLAY_SHOW);
            }

            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onRedBtnShow() {
                WifiLog.d("NestGdtNativeView showNativeDrawVideoAd  onRedBtnShow");
                NestGdtNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.NEST_SDK_REDBTN_SHOW);
            }

            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onReplayClick(View view) {
                WifiLog.d("NestGdtNativeView showNativeDrawVideoAd  onReplayClick");
                nativeUnifiedADData.startVideo();
            }

            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onTransparentBtnShow() {
                WifiLog.d("NestGdtNativeView showNativeDrawVideoAd  onTransparentBtnShow");
                NestGdtNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.NEST_SDK_TM_ADBTNSHOW);
            }
        });
        nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListener() { // from class: com.wifi.gdt.ad.NestGdtNativeView.showNativeDrawVideoAd.3
            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADClicked() {
                WifiLog.d("NestGdtNativeView showNativeDrawVideoAd onADClicked: " + nativeUnifiedADData.getTitle());
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onAdClicked(adProviderType, adObject);
                }
                NestGdtNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError error) throws JSONException {
                WifiLog.d("NestGdtNativeView showNativeDrawVideoAd onADError error code :" + error.getErrorCode() + "  error msg: " + error.getErrorMsg());
                NestGdtNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW_FAIL, Integer.valueOf(error.getErrorCode()), error.getErrorMsg());
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                WifiLog.d("NestGdtNativeView showNativeDrawVideoAd onADExposed: " + nativeUnifiedADData.getTitle());
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onAdExposed(adProviderType, adObject);
                }
                NestGdtNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
                WifiLog.d("NestGdtNativeView showNativeDrawVideoAd onADStatusChanged");
                NestGdtNativeView.this.changeDownloadStatus(adObject, nativeUnifiedADData, (WifiAdMagicView) objectRef.element, null, listener);
            }
        });
        if (nativeUnifiedADData.getAdPatternType() == 2) {
            AdDownViVoConfig.checkVideoViewClick(adObject, (ViewGroup) viewInflate.findViewById(R.id.gdt_media_view_parent));
            Intrinsics.checkExpressionValueIsNotNull(mediaView, "mediaView");
            mediaView.setVisibility(0);
            Intrinsics.checkExpressionValueIsNotNull(mImgPoster, "mImgPoster");
            mImgPoster.setVisibility(8);
            VideoOption videoOptionBuild = new VideoOption.Builder().setAutoPlayPolicy(1).setAutoPlayMuted(false).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build();
            Intrinsics.checkExpressionValueIsNotNull(videoOptionBuild, "VideoOption.Builder()\n  …\n                .build()");
            nativeUnifiedADData.bindMediaView(mediaView, videoOptionBuild, new NativeADMediaListener() { // from class: com.wifi.gdt.ad.NestGdtNativeView.showNativeDrawVideoAd.4
                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoClicked() {
                    WifiLog.d("NestGdtNativeView showNativeDrawVideoAd onVideoClicked");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoCompleted() {
                    WifiLog.d("NestGdtNativeView showNativeDrawVideoAd onVideoCompleted: ");
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoComplete(adProviderType, adObject);
                    }
                    Companion companion = NestGdtNativeView.INSTANCE;
                    companion.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOE);
                    companion.onEvent(adObject, WifiNestConst.EventKey.NEST_SDK_ENDPLAY_SHOW);
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoError(AdError error) {
                    WifiLog.d("NestGdtNativeView showNativeDrawVideoAd onVideoError: ");
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoError(adProviderType, adObject);
                    }
                    NestGdtNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOT);
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoInit() {
                    WifiLog.d("NestGdtNativeView showNativeDrawVideoAd onVideoInit: ");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoLoaded(int videoDuration) {
                    WifiLog.d("NestGdtNativeView showNativeDrawVideoAd onVideoLoaded: ");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoLoading() {
                    WifiLog.d("NestGdtNativeView showNativeDrawVideoAd onVideoLoading: ");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoPause() {
                    WifiLog.d("NestGdtNativeView showNativeDrawVideoAd onVideoPause: ");
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoPause(adProviderType, adObject);
                    }
                    NestGdtNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOB);
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoReady() {
                    WifiLog.d("NestGdtNativeView showNativeDrawVideoAd onVideoReady ");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoResume() {
                    WifiLog.d("NestGdtNativeView showNativeDrawVideoAd onVideoResume: ");
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoStart() {
                    WifiLog.d("NestGdtNativeView showNativeDrawVideoAd onVideoStart ");
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoStart(adProviderType, adObject);
                    }
                    NestGdtNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOS);
                    ((WifiAdMagicView) objectRef.element).hideFinishBgView();
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoStop() {
                    WifiLog.d("NestGdtNativeView showNativeDrawVideoAd onVideoStop");
                }
            });
            AdDownViVoConfig.checkVideoViewClick(adObject);
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(mediaView, "mediaView");
        mediaView.setVisibility(8);
        Intrinsics.checkExpressionValueIsNotNull(mImgPoster, "mImgPoster");
        mImgPoster.setVisibility(0);
        AdImageLoader mImageLoader = TogetherAd.INSTANCE.getMImageLoader();
        if (mImageLoader != null) {
            Context context3 = container.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context3, "container.context");
            String imgUrl = nativeUnifiedADData.getImgUrl();
            Intrinsics.checkExpressionValueIsNotNull(imgUrl, "ad.imgUrl");
            mImageLoader.loadImage(context3, mImgPoster, imgUrl);
        }
    }

    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void showTemplateFeedAd(final String adProviderType, final NestAdData nestAdData, ViewGroup container, final NativeViewListener listener, Activity activity) {
        INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        View adView = nestAdData.getAdView();
        if (adView instanceof NativeExpressADView) {
            NativeExpressADView nativeExpressADView = (NativeExpressADView) adView;
            nativeExpressADView.setMediaListener(new NativeExpressMediaListener() { // from class: com.wifi.gdt.ad.NestGdtNativeView.showTemplateFeedAd.1
                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoComplete(NativeExpressADView p0) {
                    WifiLog.d("NestGdtNativeView showTemplateFeedAd onVideoComplete: ");
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoComplete(adProviderType, nestAdData);
                    }
                    Companion companion = NestGdtNativeView.INSTANCE;
                    companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOE);
                    companion.onEvent(nestAdData, WifiNestConst.EventKey.NEST_SDK_ENDPLAY_SHOW);
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoError(NativeExpressADView p0, AdError p1) {
                    WifiLog.d("NestGdtNativeView showTemplateFeedAd onVideoError: ");
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoError(adProviderType, nestAdData);
                    }
                    NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOT);
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoPause(NativeExpressADView p0) {
                    WifiLog.d("NestGdtNativeView showTemplateFeedAd onVideoPause: ");
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoPause(adProviderType, nestAdData);
                    }
                    NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOB);
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoStart(NativeExpressADView p0) {
                    WifiLog.d("NestGdtNativeView showTemplateFeedAd onVideoStart: ");
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoStart(adProviderType, nestAdData);
                    }
                    NestGdtNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOS);
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoCached(NativeExpressADView p0) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoInit(NativeExpressADView p0) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoLoading(NativeExpressADView p0) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoPageClose(NativeExpressADView p0) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoPageOpen(NativeExpressADView p0) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoReady(NativeExpressADView p0, long p1) {
                }
            });
            nativeExpressADView.render();
        }
    }

    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void showDrawVideoAd(String adProviderType, NestAdData adObject, ViewGroup container, NativeViewListener listener) {
    }
}
