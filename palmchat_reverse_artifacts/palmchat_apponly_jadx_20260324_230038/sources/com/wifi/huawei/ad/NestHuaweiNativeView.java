package com.wifi.huawei.ad;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.ads.AppDownloadButton;
import com.huawei.hms.ads.Image;
import com.huawei.hms.ads.nativead.MediaView;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeView;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.custom.flow.BaseNativeView;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.feedbanner.NestHuaWeiNativeAdContainer;
import com.wifi.ad.core.listener.NativeViewListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.huawei.ad.NativeViewFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002JF\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J*\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J*\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J*\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J4\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016¨\u0006\u001a"}, d2 = {"Lcom/wifi/huawei/ad/NestHuaweiNativeView;", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "()V", "registerViewAndActionFeedAd", "", "adProviderType", "", "container", "Landroid/view/ViewGroup;", "clickViews", "", "Landroid/view/View;", "creativeViews", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", bq.f.s, "Lcom/wifi/ad/core/listener/NativeViewListener;", "showDrawVideoAd", "adObject", "showNative", "", "showNativeDrawVideoAd", "showTemplateFeedAd", "activity", "Landroid/app/Activity;", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestHuaweiNativeView extends BaseNativeView {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/wifi/huawei/ad/NestHuaweiNativeView$Companion;", "", "()V", "onEvent", "", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "eventKey", "", "errorCode", "", MediationConstant.KEY_ERROR_MSG, BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final void onEvent(NestAdData nestAdData, String eventKey) throws JSONException {
            onEvent(nestAdData, eventKey, 0, "");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void onEvent(NestAdData nestAdData, String eventKey, int errorCode, String errorMsg) throws JSONException {
            String str;
            String description;
            String nestType;
            Uri uri;
            String string = null;
            if (nestAdData.getAdData() instanceof NativeAd) {
                Object adData = nestAdData.getAdData();
                if (adData == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.huawei.hms.ads.nativead.NativeAd");
                }
                NativeAd nativeAd = (NativeAd) adData;
                String title = nativeAd.getTitle();
                List<Image> images = nativeAd.getImages();
                if (!(images == null || images.isEmpty())) {
                    List<Image> images2 = nativeAd.getImages();
                    if (images2 == null) {
                        Intrinsics.throwNpe();
                    }
                    Image image = images2.get(0);
                    if (image != null && (uri = image.getUri()) != null) {
                        string = uri.toString();
                    }
                }
                description = nativeAd.getDescription();
                str = string;
                string = title;
            } else {
                str = null;
                description = null;
            }
            EventParams.Builder nestSid = new EventParams.Builder().setDspName(NestHuaweiProvider.DSP_NAME).setSdkFrom("huawei").setPosition(nestAdData.getPosition()).setInventoryId(nestAdData.getInventoryId()).setTmAdBtnShow(nestAdData.getShowAdButtonTime()).setRedAdBtnShow(nestAdData.getChangeAdBtnColorTime()).setCtAdBtnShow(nestAdData.getShowAdCardTime()).setMediaId(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.OPPO)).setRenderStyle(nestAdData.getRenderStyle()).setSrcId(nestAdData.getAdCode()).setNestSid(nestAdData.getNestSid());
            AdParams adParams = nestAdData.getAdParams();
            if (adParams == null || (nestType = adParams.getNestType()) == null) {
                nestType = "";
            }
            EventParams.Builder nestType2 = nestSid.setNestType(nestType);
            Integer adMode = nestAdData.getAdMode();
            EventParams.Builder params = nestType2.setAdMode((adMode != null ? adMode : "").toString()).setAdTitle(string).setAdImage(str).setAdDesc(description);
            params.setErrorCode(String.valueOf(errorCode));
            params.setErrorMsg(errorMsg);
            EventReporter eventReporter = EventReporter.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(params, "params");
            eventReporter.reportViewEvent(params, nestAdData, eventKey);
        }
    }

    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    @RequiresApi(16)
    public void registerViewAndActionFeedAd(String adProviderType, ViewGroup container, List<View> clickViews, List<View> creativeViews, NestAdData nestAdData, NativeViewListener listener) throws JSONException {
        INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        Object adData = nestAdData.getAdData();
        if (adData == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.huawei.hms.ads.nativead.NativeAd");
        }
        NativeAd nativeAd = (NativeAd) adData;
        NativeView nativeView = (NativeView) container.findViewWithTag(NestHuaWeiNativeAdContainer.TAG);
        int creativeType = nativeAd.getCreativeType();
        String hwDownBtnTag = nestAdData.getHwDownBtnTag();
        WifiLog.d("HWAD NestHWNativeView registerViewAndActionFeedAd feedAd = " + nativeAd.getTitle() + " nativeAdContainer " + nativeView + " nestAdData.adMode " + nestAdData.getAdMode() + " type " + creativeType + " downTag " + hwDownBtnTag);
        if (nativeView instanceof NestHuaWeiNativeAdContainer) {
            TextView adButtonView = getAdButtonView(clickViews, creativeViews);
            if (adButtonView != null) {
                WifiLog.d("HWAD NestHWNativeView registerViewAndActionFeedAd feedAd = " + nativeAd.getTitle() + " button " + adButtonView);
                ((NestHuaWeiNativeAdContainer) nativeView).setCallToActionView(adButtonView);
            }
            Integer adMode = nestAdData.getAdMode();
            if (adMode != null && adMode.intValue() == 4) {
                View adView = nestAdData.getAdView();
                WifiLog.d("HWAD NestHWNativeView registerViewAndActionFeedAd feedAd = " + nativeAd.getTitle() + " adVideoView " + adView);
                if (adView instanceof MediaView) {
                    ((NestHuaWeiNativeAdContainer) nativeView).setMediaView((MediaView) adView);
                }
            }
            nativeView.setNativeAd(nativeAd);
            if (creativeType == 103 || creativeType == 106) {
                AppDownloadButton appDownloadButton = !TextUtils.isEmpty(hwDownBtnTag) ? (AppDownloadButton) container.findViewWithTag(hwDownBtnTag) : null;
                WifiLog.d("HWAD NestHWNativeView registerViewAndActionFeedAd feedAd = " + nativeAd.getTitle() + " downloadBtn " + appDownloadButton + " nestAdData.adDownTextView " + nestAdData.getAdDownTextView());
                if (appDownloadButton != null) {
                    appDownloadButton.setAppDownloadButtonStyle(new NativeViewFactory.MyAppDownloadStyle(container.getContext(), nestAdData.getRoundResId() > 0 ? nestAdData.getRoundResId() : -1));
                    if (nativeView.register(appDownloadButton)) {
                        WifiLog.d("HWAD NestHWNativeView registerViewAndActionFeedAd feedAd = " + nativeAd.getTitle() + " register(downloadBtn)");
                        appDownloadButton.setVisibility(0);
                        if (nestAdData.getAdDownTextView() != null) {
                            View adDownTextView = nestAdData.getAdDownTextView();
                            if (adDownTextView == null) {
                                Intrinsics.throwNpe();
                            }
                            adDownTextView.setVisibility(8);
                        }
                        appDownloadButton.refreshAppStatus();
                        View callToActionView = ((NestHuaWeiNativeAdContainer) nativeView).getCallToActionView();
                        if (callToActionView != null) {
                            callToActionView.setVisibility(8);
                        }
                        try {
                            View viewFindViewWithTag = container.findViewWithTag(WifiNestConst.OtherConst.TAG_AD_BUTTON);
                            if (viewFindViewWithTag != null) {
                                viewFindViewWithTag.setBackground(null);
                            }
                        } catch (Throwable unused) {
                        }
                    } else {
                        if (nestAdData.getAdDownTextView() != null) {
                            View adDownTextView2 = nestAdData.getAdDownTextView();
                            if (adDownTextView2 == null) {
                                Intrinsics.throwNpe();
                            }
                            adDownTextView2.setVisibility(0);
                        }
                        appDownloadButton.setVisibility(8);
                        View callToActionView2 = ((NestHuaWeiNativeAdContainer) nativeView).getCallToActionView();
                        if (callToActionView2 != null) {
                            callToActionView2.setVisibility(0);
                        }
                    }
                    nestAdData.setAdDownTextView(null);
                }
            }
        }
    }

    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void showTemplateFeedAd(String adProviderType, NestAdData nestAdData, ViewGroup container, NativeViewListener listener, Activity activity) throws JSONException {
        INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
    }

    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void showDrawVideoAd(String adProviderType, NestAdData adObject, ViewGroup container, NativeViewListener listener) {
    }

    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void showNative(String adProviderType, Object adObject, ViewGroup container, NativeViewListener listener) {
    }

    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void showNativeDrawVideoAd(String adProviderType, NestAdData adObject, ViewGroup container, NativeViewListener listener) {
    }
}
