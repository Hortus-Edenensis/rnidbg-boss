package com.wifi.ks.ad;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.ad.constant.bq;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002JF\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002JF\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J*\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J*\u0010 \u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J*\u0010\"\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J4\u0010#\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/wifi/ks/ad/NestKsNativeView;", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "()V", "drawVideoView", "Landroid/view/View;", "getDrawVideoView", "()Landroid/view/View;", "setDrawVideoView", "(Landroid/view/View;)V", "mHasShowDownloadActive", "", "checkKsAdInteractionType", "", "context", "Landroid/content/Context;", "ad", "Lcom/kwad/sdk/api/KsNativeAd;", "registerViewAndAction", "", "adProviderType", "container", "Landroid/view/ViewGroup;", "clickViews", "", "creativeViews", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", bq.f.s, "Lcom/wifi/ad/core/listener/NativeViewListener;", "registerViewAndActionFeedAd", "showDrawVideoAd", "adObject", "showNative", "", "showNativeDrawVideoAd", "showTemplateFeedAd", "activity", "Landroid/app/Activity;", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestKsNativeView extends BaseNativeView {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private View drawVideoView;
    private boolean mHasShowDownloadActive;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/wifi/ks/ad/NestKsNativeView$Companion;", "", "()V", "onEvent", "", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "eventKey", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final void onEvent(NestAdData nestAdData, String eventKey) throws JSONException {
            String str;
            String adDescription;
            String nestType;
            String imageUrl = null;
            if (nestAdData.getAdData() instanceof KsNativeAd) {
                Object adData = nestAdData.getAdData();
                if (adData == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.kwad.sdk.api.KsNativeAd");
                }
                KsNativeAd ksNativeAd = (KsNativeAd) adData;
                String appName = ksNativeAd.getAppName();
                List<KsImage> imageList = ksNativeAd.getImageList();
                if (!(imageList == null || imageList.isEmpty())) {
                    List<KsImage> imageList2 = ksNativeAd.getImageList();
                    if (imageList2 == null) {
                        Intrinsics.throwNpe();
                    }
                    KsImage ksImage = imageList2.get(0);
                    if (ksImage != null) {
                        imageUrl = ksImage.getImageUrl();
                    }
                }
                adDescription = ksNativeAd.getAdDescription();
                str = imageUrl;
                imageUrl = appName;
            } else {
                str = null;
                adDescription = null;
            }
            EventParams.Builder nestSid = new EventParams.Builder().setDspName(NestKsProvider.DSP_NAME).setSdkFrom(NestKsProvider.SDK_FROM).setInventoryId(nestAdData.getInventoryId()).setPosition(nestAdData.getPosition()).setTmAdBtnShow(nestAdData.getShowAdButtonTime()).setRedAdBtnShow(nestAdData.getChangeAdBtnColorTime()).setCtAdBtnShow(nestAdData.getShowAdCardTime()).setMediaId(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.KS)).setRenderStyle(nestAdData.getRenderStyle()).setSrcId(nestAdData.getAdCode()).setNestSid(nestAdData.getNestSid());
            AdParams adParams = nestAdData.getAdParams();
            if (adParams == null || (nestType = adParams.getNestType()) == null) {
                nestType = "";
            }
            EventParams.Builder nestType2 = nestSid.setNestType(nestType);
            Integer adMode = nestAdData.getAdMode();
            EventParams.Builder params = nestType2.setAdMode((adMode != null ? adMode : "").toString()).setAdTitle(imageUrl).setAdImage(str).setAdDesc(adDescription);
            EventReporter eventReporter = EventReporter.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(params, "params");
            eventReporter.reportViewEvent(params, nestAdData, eventKey);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String checkKsAdInteractionType(Context context, KsNativeAd ad) {
        WifiLog.d("NestKsNativeView showNativeDrawVideoAd checkKsAdInteractionType ad type " + ad.getInteractionType() + ' ');
        int iIntValue = Integer.valueOf(ad.getInteractionType()).intValue();
        if (iIntValue == 1) {
            if (context != null) {
                return context.getString(R.string.download_quick);
            }
            return null;
        }
        if (iIntValue != 2) {
            return ad.getActionDescription();
        }
        if (context != null) {
            return context.getString(R.string.see_detail);
        }
        return null;
    }

    private final void registerViewAndAction(final String adProviderType, ViewGroup container, List<View> clickViews, List<View> creativeViews, final NestAdData nestAdData, final NativeViewListener listener) throws JSONException {
        INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        Object adData = nestAdData != null ? nestAdData.getAdData() : null;
        if (adData == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.kwad.sdk.api.KsNativeAd");
        }
        KsNativeAd ksNativeAd = (KsNativeAd) adData;
        TextView adButtonView = getAdButtonView(clickViews, creativeViews);
        if (adButtonView != null) {
            CharSequence text = adButtonView.getText();
            if (text != null) {
                nestAdData.setRespbtnwd(text.toString());
                nestAdData.setShowbtnwd(text.toString());
            }
            if (WifiNestAd.INSTANCE.getSwitch315() && 1 == ksNativeAd.getInteractionType()) {
                Context context = container.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "container.context");
                adButtonView.setText(context.getResources().getString(R.string.download_quick));
                nestAdData.setShowbtnwd(adButtonView.getText().toString());
            }
        }
        if (nestAdData.getAdView() != null) {
            View adView = nestAdData.getAdView();
            if (adView == null) {
                Intrinsics.throwNpe();
            }
            creativeViews.add(adView);
            WifiLog.d("NestKsNativeView creativeViews add nestAdData.adView ");
        }
        ksNativeAd.registerViewForInteraction(container, creativeViews, new KsNativeAd.AdInteractionListener() { // from class: com.wifi.ks.ad.NestKsNativeView.registerViewAndAction.2
            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener p0) {
                return false;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdClicked(View view, KsNativeAd ad) throws JSONException {
                WifiLog.d("NestKsNativeView registerViewAndAction onAdClicked ");
                NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onAdClicked(adProviderType, nestAdData);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdShow(KsNativeAd ad) throws JSONException {
                WifiLog.d("NestKsNativeView registerViewAndAction onAdShow ");
                NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onAdExposed(adProviderType, nestAdData);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
            }
        });
        ksNativeAd.setVideoPlayListener(new KsNativeAd.VideoPlayListener() { // from class: com.wifi.ks.ad.NestKsNativeView.registerViewAndAction.3
            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayComplete() throws JSONException {
                WifiLog.d("NestKsNativeView onVideoAdComplete adProviderType = " + adProviderType);
                Companion companion = NestKsNativeView.INSTANCE;
                companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOE);
                companion.onEvent(nestAdData, WifiNestConst.EventKey.NEST_SDK_ENDPLAY_SHOW);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onVideoComplete(adProviderType, nestAdData);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayError(int what, int extra) throws JSONException {
                WifiLog.d("NestKsNativeView onVideoPlayError adProviderType = " + adProviderType);
                NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOT);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onVideoError(adProviderType, nestAdData);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayStart() throws JSONException {
                WifiLog.d("NestKsNativeView onVideoAdStartPlay adProviderType = " + adProviderType);
                NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOS);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onVideoStart(adProviderType, nestAdData);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayPause() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayReady() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayResume() {
            }
        });
        ksNativeAd.setDownloadListener(new KsApkDownloadListener() { // from class: com.wifi.ks.ad.NestKsNativeView.registerViewAndAction.4
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() throws JSONException {
                WifiLog.d("NestKsNativeView KsAppDownloadListener onDownloadFailed");
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onDownloadFailed(adProviderType, nestAdData);
                }
                nestAdData.setDownloadStatus(6);
                NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_NODOWNLOAD);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() throws JSONException {
                WifiLog.d("NestKsNativeView KsAppDownloadListener onDownloadFinished");
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onDownloadComplete(adProviderType, nestAdData);
                }
                nestAdData.setDownloadStatus(4);
                NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADED);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                WifiLog.d("NestKsNativeView KsAppDownloadListener onIdle");
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onDownloadStart(adProviderType, nestAdData);
                }
                nestAdData.setDownloadStatus(0);
                NestKsNativeView.this.mHasShowDownloadActive = false;
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() throws JSONException {
                WifiLog.d("NestKsNativeView KsAppDownloadListener onInstalled");
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onDownloadInstalled(adProviderType, nestAdData);
                }
                nestAdData.setDownloadStatus(5);
                NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_INSTALLED);
            }

            @Override // com.kwad.sdk.api.KsApkDownloadListener
            public void onPaused(int p0) {
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onDownloadPause(adProviderType, nestAdData);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int progress) throws JSONException {
                NativeViewListener nativeViewListener;
                WifiLog.d("NestKsNativeView KsAppDownloadListener onProgressUpdate=" + progress);
                nestAdData.setDownloadStatus(3);
                if (!NestKsNativeView.this.mHasShowDownloadActive) {
                    NestKsNativeView.this.mHasShowDownloadActive = true;
                    NestKsNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADING);
                }
                if (progress <= 0 || (nativeViewListener = listener) == null) {
                    return;
                }
                nativeViewListener.onDownloadProgress(adProviderType, nestAdData, progress);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadStarted() {
            }
        });
        AdDownViVoConfig.checkVideoViewClick(nestAdData);
    }

    public final View getDrawVideoView() {
        return this.drawVideoView;
    }

    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void registerViewAndActionFeedAd(String adProviderType, ViewGroup container, List<View> clickViews, List<View> creativeViews, NestAdData nestAdData, NativeViewListener listener) throws JSONException {
        registerViewAndAction(adProviderType, container, clickViews, creativeViews, nestAdData, listener);
    }

    public final void setDrawVideoView(View view) {
        this.drawVideoView = view;
    }

    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void showDrawVideoAd(final String adProviderType, final NestAdData adObject, final ViewGroup container, final NativeViewListener listener) throws JSONException {
        if (adObject.getAdData() instanceof KsDrawAd) {
            INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
            Object adData = adObject.getAdData();
            if (adData == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.kwad.sdk.api.KsDrawAd");
            }
            final KsDrawAd ksDrawAd = (KsDrawAd) adData;
            View drawView = ksDrawAd.getDrawView(container.getContext());
            this.drawVideoView = drawView;
            if (drawView != null) {
                ksDrawAd.setAdInteractionListener(new KsDrawAd.AdInteractionListener() { // from class: com.wifi.ks.ad.NestKsNativeView$showDrawVideoAd$$inlined$let$lambda$1
                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public void onAdClicked() throws JSONException {
                        WifiLog.d("NestKsNativeView showDrawNativeAd onAdClicked ");
                        NestKsNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                        NativeViewListener nativeViewListener = listener;
                        if (nativeViewListener != null) {
                            nativeViewListener.onAdClicked(adProviderType, adObject);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public void onAdShow() throws JSONException {
                        WifiLog.d("NestKsNativeView showDrawNativeAd onAdShow ");
                        NestKsNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                        NativeViewListener nativeViewListener = listener;
                        if (nativeViewListener != null) {
                            nativeViewListener.onAdExposed(adProviderType, adObject);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public void onVideoPlayEnd() throws JSONException {
                        WifiLog.d("NestKsNativeView onVideoAdComplete adProviderType = " + adProviderType);
                        NestKsNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOE);
                        NativeViewListener nativeViewListener = listener;
                        if (nativeViewListener != null) {
                            nativeViewListener.onVideoComplete(adProviderType, adObject);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public void onVideoPlayError() throws JSONException {
                        NestKsNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOT);
                        NativeViewListener nativeViewListener = listener;
                        if (nativeViewListener != null) {
                            nativeViewListener.onVideoError(adProviderType, adObject);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public void onVideoPlayPause() throws JSONException {
                        WifiLog.d("NestKsNativeView onVideoAdPaused adProviderType = " + adProviderType);
                        NestKsNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOB);
                        NativeViewListener nativeViewListener = listener;
                        if (nativeViewListener != null) {
                            nativeViewListener.onVideoPause(adProviderType, adObject);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public void onVideoPlayStart() throws JSONException {
                        WifiLog.d("NestKsNativeView onVideoAdStartPlay adProviderType = " + adProviderType);
                        NestKsNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOS);
                        NativeViewListener nativeViewListener = listener;
                        if (nativeViewListener != null) {
                            nativeViewListener.onVideoStart(adProviderType, adObject);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                    public void onVideoPlayResume() {
                    }
                });
                container.removeAllViews();
                container.addView(this.drawVideoView);
                WifiLog.d("NestKsNativeView showDrawNativeAd addView ");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, com.wifi.ad.core.view.WifiAdMagicView] */
    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void showNativeDrawVideoAd(final String adProviderType, final NestAdData adObject, final ViewGroup container, final NativeViewListener listener) throws JSONException {
        INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        Object adData = adObject.getAdData();
        if (adData == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.kwad.sdk.api.KsNativeAd");
        }
        final KsNativeAd ksNativeAd = (KsNativeAd) adData;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? wifiAdMagicView = new WifiAdMagicView(container.getContext());
        objectRef.element = wifiAdMagicView;
        wifiAdMagicView.setOnAdViewListener(new WifiAdMagicView.OnAdViewListener() { // from class: com.wifi.ks.ad.NestKsNativeView.showNativeDrawVideoAd.1
            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onAdTagClick(View view) {
                WifiLog.d("NestKsNativeView showNativeDrawVideoAd onAdTagClick");
            }

            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onCardCloseClick(View view) throws JSONException {
                WifiLog.d("NestKsNativeView showNativeDrawVideoAd onCardCloseClick");
                NestKsNativeView.INSTANCE.onEvent(adObject, "nest_sdk_cancle_click");
            }

            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onCardShow() throws JSONException {
                WifiLog.d("NestKsNativeView showNativeDrawVideoAd onCardShow");
                NestKsNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.NEST_SDK_CHUANGTI_SHOW);
            }

            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onCompleteBgShow() throws JSONException {
                WifiLog.d("NestKsNativeView showNativeDrawVideoAd onCompleteBgShow");
                NestKsNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.NEST_SDK_CHUANGTI_SHOW);
            }

            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onRedBtnShow() throws JSONException {
                WifiLog.d("NestKsNativeView showNativeDrawVideoAd onRedBtnShow");
                NestKsNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.NEST_SDK_REDBTN_SHOW);
            }

            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onReplayClick(View view) {
                WifiLog.d("NestKsNativeView showNativeDrawVideoAd onReplayClick");
            }

            @Override // com.wifi.ad.core.view.WifiAdMagicView.OnAdViewListener
            public void onTransparentBtnShow() throws JSONException {
                WifiLog.d("NestKsNativeView showNativeDrawVideoAd onTransparentBtnShow");
                NestKsNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.NEST_SDK_TM_ADBTNSHOW);
            }
        });
        ksNativeAd.setVideoPlayListener(new KsNativeAd.VideoPlayListener() { // from class: com.wifi.ks.ad.NestKsNativeView.showNativeDrawVideoAd.2
            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayComplete() throws JSONException {
                WifiLog.d("NestKsNativeView onVideoAdComplete adProviderType = " + adProviderType);
                Companion companion = NestKsNativeView.INSTANCE;
                companion.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOE);
                companion.onEvent(adObject, WifiNestConst.EventKey.NEST_SDK_ENDPLAY_SHOW);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onVideoComplete(adProviderType, adObject);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayError(int what, int extra) throws JSONException {
                WifiLog.d("NestKsNativeView onVideoPlayError adProviderType = " + adProviderType);
                NestKsNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOT);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onVideoError(adProviderType, adObject);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayStart() throws JSONException {
                WifiLog.d("NestKsNativeView onVideoAdStartPlay adProviderType = " + adProviderType);
                NestKsNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOS);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onVideoStart(adProviderType, adObject);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayPause() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayReady() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayResume() {
            }
        });
        ksNativeAd.setDownloadListener(new KsAppDownloadListener() { // from class: com.wifi.ks.ad.NestKsNativeView.showNativeDrawVideoAd.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() throws JSONException {
                WifiLog.d("NestKsNativeView KsAppDownloadListener onDownloadFailed");
                WifiAdMagicView wifiAdMagicView2 = (WifiAdMagicView) objectRef.element;
                NestKsNativeView nestKsNativeView = NestKsNativeView.this;
                Context context = container.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "container.context");
                wifiAdMagicView2.updateAdBtnShow(nestKsNativeView.checkKsAdInteractionType(context, ksNativeAd));
                NestKsNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_NODOWNLOAD);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onDownloadFailed(adProviderType, adObject);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() throws JSONException {
                WifiLog.d("NestKsNativeView KsAppDownloadListener onDownloadFinished");
                ((WifiAdMagicView) objectRef.element).updateAdBtnShow(WifiAdMagicView.getInstallText());
                NestKsNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADED);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onDownloadComplete(adProviderType, adObject);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadStarted() {
                WifiLog.d("NestKsNativeView KsAppDownloadListener onDownloadStarted");
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                NestKsNativeView.this.mHasShowDownloadActive = false;
                WifiLog.d("NestKsNativeView KsAppDownloadListener onIdle");
                WifiAdMagicView wifiAdMagicView2 = (WifiAdMagicView) objectRef.element;
                NestKsNativeView nestKsNativeView = NestKsNativeView.this;
                Context context = container.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "container.context");
                wifiAdMagicView2.updateAdBtnShow(nestKsNativeView.checkKsAdInteractionType(context, ksNativeAd));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() throws JSONException {
                ((WifiAdMagicView) objectRef.element).updateAdBtnShow(WifiAdMagicView.getOpenText());
                WifiLog.d("NestKsNativeView KsAppDownloadListener onInstalled");
                NestKsNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_INSTALLED);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onDownloadInstalled(adProviderType, adObject);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int progress) throws JSONException {
                WifiLog.d("NestKsNativeView KsAppDownloadListener onProgressUpdate");
                if (!NestKsNativeView.this.mHasShowDownloadActive) {
                    NestKsNativeView.this.mHasShowDownloadActive = true;
                    NestKsNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADING);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadStart(adProviderType, adObject);
                    }
                }
                if (progress > 0) {
                    WifiAdMagicView wifiAdMagicView2 = (WifiAdMagicView) objectRef.element;
                    StringBuilder sb = new StringBuilder();
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str = String.format("下载中... %s", Arrays.copyOf(new Object[]{Integer.valueOf(progress)}, 1));
                    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(format, *args)");
                    sb.append(str);
                    sb.append("%");
                    wifiAdMagicView2.updateAdBtnShow(sb.toString());
                    NativeViewListener nativeViewListener2 = listener;
                    if (nativeViewListener2 != null) {
                        nativeViewListener2.onDownloadProgress(adProviderType, adObject, progress);
                    }
                }
            }
        });
        int i = ksNativeAd.getInteractionType() != 1 ? 2 : 1;
        WifiAdMagicView.Config.Builder cardIcon = new WifiAdMagicView.Config.Builder().setAuthorInfo(ksNativeAd.getAdDescription()).setAuthorName(ksNativeAd.getAppName()).setCardInfo(ksNativeAd.getAdDescription()).setCardTitle(ksNativeAd.getAppName()).setBgInfo(ksNativeAd.getAdDescription()).setBgName(ksNativeAd.getAppName()).setCardIcon(ksNativeAd.getAppIconUrl());
        Context context = container.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "container.context");
        WifiAdMagicView.Config.Builder downLoadType = cardIcon.setButton(checkKsAdInteractionType(context, ksNativeAd)).setChangeAdBtnColorTime(adObject.getChangeAdBtnColorTime()).setShowAdBtnTime(adObject.getShowAdButtonTime()).setShowAdCardTime(adObject.getShowAdCardTime()).setScene(adObject.getAdScene()).setDownLoadType(i);
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        ((WifiAdMagicView) objectRef.element).configViewData(downLoadType.setLogoResId(wifiNestAd.getMPersonalizedAd() ? R.drawable.icon_personalized_ks_logo : R.drawable.icon_ks_logo_with_txt).setAdType(SDKAlias.KS.getType()).setAppName(adObject.getAdAppName()).setDeveloperName(adObject.getAdAppDeveloperName()).setPermissionsUrl(adObject.getAdAppPermissionsUrl()).setPrivacyUrl(adObject.getAdAppPrivacyUrl()).setFunctionUrl(adObject.getAdAppFunctionDescUrl()).setAppVersion(adObject.getAdAppVersion()).setNewStyleEnable(wifiNestAd.isDrawVideoNewStyleEnable()).build());
        new RelativeLayout.LayoutParams(-1, -2).addRule(12);
        this.drawVideoView = ksNativeAd.getVideoView(container.getContext(), new KsAdVideoPlayConfig.Builder().videoSoundEnable(true).dataFlowAutoStart(true).build());
        ImageView imageView = new ImageView(container.getContext());
        if (this.drawVideoView != null) {
            container.removeAllViews();
            View view = this.drawVideoView;
            if ((view != null ? view.getParent() : null) instanceof ViewGroup) {
                View view2 = this.drawVideoView;
                ViewParent parent = view2 != null ? view2.getParent() : null;
                if (parent == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                }
                ((ViewGroup) parent).removeView(this.drawVideoView);
            }
            container.addView(this.drawVideoView);
            AdDownViVoConfig.checkVideoViewClick(adObject, container);
        } else {
            container.removeAllViews();
            if (ksNativeAd.getImageList() != null) {
                List<KsImage> imageList = ksNativeAd.getImageList();
                if (imageList == null) {
                    Intrinsics.throwNpe();
                }
                if (imageList.size() > 0) {
                    List<KsImage> imageList2 = ksNativeAd.getImageList();
                    if (imageList2 == null) {
                        Intrinsics.throwNpe();
                    }
                    KsImage ksImage = imageList2.get(0);
                    Intrinsics.checkExpressionValueIsNotNull(ksImage, "drawAd!!.imageList!![0]");
                    if (ksImage.getImageUrl() != null) {
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        AdImageLoader mImageLoader = TogetherAd.INSTANCE.getMImageLoader();
                        if (mImageLoader != null) {
                            Context context2 = container.getContext();
                            Intrinsics.checkExpressionValueIsNotNull(context2, "container.context");
                            List<KsImage> imageList3 = ksNativeAd.getImageList();
                            if (imageList3 == null) {
                                Intrinsics.throwNpe();
                            }
                            KsImage ksImage2 = imageList3.get(0);
                            Intrinsics.checkExpressionValueIsNotNull(ksImage2, "drawAd!!.imageList!![0]");
                            String imageUrl = ksImage2.getImageUrl();
                            Intrinsics.checkExpressionValueIsNotNull(imageUrl, "drawAd!!.imageList!![0].imageUrl");
                            mImageLoader.loadImage(context2, imageView, imageUrl);
                        }
                        LinearLayout linearLayout = new LinearLayout(container.getContext());
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
                        linearLayout.setOrientation(1);
                        layoutParams2.gravity = 16;
                        linearLayout.addView(imageView, layoutParams);
                        container.addView(linearLayout, layoutParams2);
                        ((WifiAdMagicView) objectRef.element).getClickViews().add(imageView);
                    }
                }
            }
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(12);
        WifiAdMagicView wifiAdMagicView2 = (WifiAdMagicView) objectRef.element;
        if ((wifiAdMagicView2 != null ? wifiAdMagicView2.getParent() : null) instanceof ViewGroup) {
            WifiAdMagicView wifiAdMagicView3 = (WifiAdMagicView) objectRef.element;
            ViewParent parent2 = wifiAdMagicView3 != null ? wifiAdMagicView3.getParent() : null;
            if (parent2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ((ViewGroup) parent2).removeView((WifiAdMagicView) objectRef.element);
        }
        container.addView((WifiAdMagicView) objectRef.element, layoutParams3);
        if (!wifiNestAd.isDrawVideoNewStyleEnable()) {
            WifiAdMagicTopView wifiAdMagicTopView = new WifiAdMagicTopView(container.getContext());
            wifiAdMagicTopView.configViewData(new WifiAdMagicTopView.Config.Builder().setAppName(ksNativeAd.getAppName()).setCardIcon(ksNativeAd.getAppIconUrl()).build());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(10);
            ScreenUtil screenUtil = ScreenUtil.INSTANCE;
            Context context3 = container.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context3, "container.context");
            layoutParams4.leftMargin = screenUtil.dp2px(context3, 42.0f);
            if (wifiAdMagicTopView.getParent() instanceof ViewGroup) {
                ViewParent parent3 = wifiAdMagicTopView.getParent();
                if (parent3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                }
                ((ViewGroup) parent3).removeView(wifiAdMagicTopView);
            }
            container.addView(wifiAdMagicTopView, layoutParams4);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(((WifiAdMagicView) objectRef.element).getClickViews());
        arrayList.add(imageView);
        ArrayList arrayList2 = new ArrayList();
        WifiLog.d("downAd ks nativeDraw adObject.interactionType " + adObject.getInteractionType() + " ad.interactionType " + ksNativeAd.getInteractionType());
        if (ksNativeAd.getInteractionType() == 1) {
            adObject.setInteractionType(1);
            if (((WifiAdMagicView) objectRef.element).getFirstButton() != null) {
                WifiDownWebButton firstButton = ((WifiAdMagicView) objectRef.element).getFirstButton();
                Intrinsics.checkExpressionValueIsNotNull(firstButton, "magicView.firstButton");
                firstButton.setTag(WifiNestConst.OtherConst.TAG_AD_BUTTON);
                arrayList.add(((WifiAdMagicView) objectRef.element).getFirstButton());
            }
            if (((WifiAdMagicView) objectRef.element).getSecondButton() != null) {
                WifiDownWebButton secondButton = ((WifiAdMagicView) objectRef.element).getSecondButton();
                Intrinsics.checkExpressionValueIsNotNull(secondButton, "magicView.secondButton");
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
        ArrayList<View> arrayListCreateClickView = AdDownViVoConfig.createClickView(arrayList, arrayList2, adObject, arrayList);
        Intrinsics.checkExpressionValueIsNotNull(arrayListCreateClickView, "AdDownViVoConfig.createC…ws, adObject, clickViews)");
        ksNativeAd.registerViewForInteraction(container, arrayListCreateClickView, new KsNativeAd.AdInteractionListener() { // from class: com.wifi.ks.ad.NestKsNativeView.showNativeDrawVideoAd.4
            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener p0) {
                return false;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdClicked(View view3, KsNativeAd ad) throws JSONException {
                WifiLog.d("NestKsNativeView showNativeDrawVideoAd onAdClicked ");
                NestKsNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onAdClicked(adProviderType, adObject);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdShow(KsNativeAd ad) throws JSONException {
                WifiLog.d("NestKsNativeView showNativeDrawVideoAd onAdShow ");
                NestKsNativeView.INSTANCE.onEvent(adObject, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                NativeViewListener nativeViewListener = listener;
                if (nativeViewListener != null) {
                    nativeViewListener.onAdExposed(adProviderType, adObject);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
            }
        });
        AdDownViVoConfig.checkVideoViewClick(adObject);
    }

    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void showTemplateFeedAd(String adProviderType, NestAdData nestAdData, ViewGroup container, NativeViewListener listener, Activity activity) throws JSONException {
        INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
    }

    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void showNative(String adProviderType, Object adObject, ViewGroup container, NativeViewListener listener) {
    }
}
