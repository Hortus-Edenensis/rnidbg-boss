package com.wifi.lxad.ad;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.custom.flow.BaseNativeView;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.listener.NativeViewListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.adsdk.listener.LxNativeDownListener;
import com.wifi.adsdk.listener.LxNativeFeedShowListener;
import com.wifi.adsdk.nativefeed.LxNativeFeedAd;
import com.wifi.adsdk.tempfeed.LxTempFeedAd;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002JF\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J*\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J*\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J*\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J4\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/wifi/lxad/ad/NestLxAdNativeView;", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "()V", "mHasShowDownloadActive", "", "registerViewAndActionFeedAd", "", "adProviderType", "", "container", "Landroid/view/ViewGroup;", "clickViews", "", "Landroid/view/View;", "creativeViews", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", bq.f.s, "Lcom/wifi/ad/core/listener/NativeViewListener;", "showDrawVideoAd", "adObject", "showNative", "", "showNativeDrawVideoAd", "showTemplateFeedAd", "activity", "Landroid/app/Activity;", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestLxAdNativeView extends BaseNativeView {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean mHasShowDownloadActive;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/wifi/lxad/ad/NestLxAdNativeView$Companion;", "", "()V", "onEvent", "", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "eventKey", "", "errorCode", "", MediationConstant.KEY_ERROR_MSG, BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
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
            String nestType;
            EventParams.Builder nestSid = new EventParams.Builder().setDspName(NestLxAdProvider.DSP_NAME).setSdkFrom("lxad").setPosition(nestAdData.getPosition()).setTmAdBtnShow(nestAdData.getShowAdButtonTime()).setRedAdBtnShow(nestAdData.getChangeAdBtnColorTime()).setCtAdBtnShow(nestAdData.getShowAdCardTime()).setMediaId(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.LXAD)).setRenderStyle(nestAdData.getRenderStyle()).setSrcId(nestAdData.getAdCode()).setNestSid(nestAdData.getNestSid());
            AdParams adParams = nestAdData.getAdParams();
            if (adParams == null || (nestType = adParams.getNestType()) == null) {
                nestType = "";
            }
            EventParams.Builder nestType2 = nestSid.setNestType(nestType);
            Integer adMode = nestAdData.getAdMode();
            EventParams.Builder params = nestType2.setAdMode((adMode != null ? adMode : "").toString()).setAdTitle(null).setAdImage(null).setAdDesc(null);
            params.setErrorCode(String.valueOf(errorCode));
            params.setErrorMsg(errorMsg);
            EventReporter eventReporter = EventReporter.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(params, "params");
            eventReporter.reportViewEvent(params, nestAdData, eventKey);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, com.wifi.adsdk.nativefeed.LxNativeFeedAd] */
    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void registerViewAndActionFeedAd(final String adProviderType, ViewGroup container, List<View> clickViews, List<View> creativeViews, final NestAdData nestAdData, final NativeViewListener listener) throws JSONException {
        WifiLog.d("NestLXADNativeView registerViewAndActionFeedAd bind");
        INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        if (!(nestAdData.getAdData() instanceof LxNativeFeedAd)) {
            WifiLog.d("NestLXADNativeView registerViewAndActionFeedAd adData !is LxNativeFeedAd");
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Object adData = nestAdData.getAdData();
        if (!(adData instanceof LxNativeFeedAd)) {
            adData = null;
        }
        ?? r1 = (LxNativeFeedAd) adData;
        if (r1 != 0) {
            objectRef.element = r1;
            if (clickViews == null) {
                new ArrayList().add(new View(container.getContext()));
            }
            TextView adButtonView = getAdButtonView(clickViews, creativeViews);
            if (adButtonView != null) {
                CharSequence text = adButtonView.getText();
                if (text != null) {
                    nestAdData.setRespbtnwd(text.toString());
                    nestAdData.setShowbtnwd(text.toString());
                }
                if (WifiNestAd.INSTANCE.getSwitch315() && ((LxNativeFeedAd) objectRef.element).isDownloadAd()) {
                    Context context = container.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context, "container.context");
                    adButtonView.setText(context.getResources().getString(R.string.download_quick));
                    nestAdData.setShowbtnwd(adButtonView.getText().toString());
                }
            }
            ((LxNativeFeedAd) objectRef.element).setShowListener(new LxNativeFeedShowListener() { // from class: com.wifi.lxad.ad.NestLxAdNativeView.registerViewAndActionFeedAd.2
                @Override // com.wifi.adsdk.listener.LxBaseShowListener
                public void onAdClick(View view) throws JSONException {
                    WifiLog.d("NestLXADNativeView registerViewAndActionFeedAd onAdClicked");
                    NestLxAdNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onAdClicked(adProviderType, nestAdData);
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.wifi.adsdk.listener.LxBaseShowListener
                public void onAdShow() throws JSONException {
                    WifiLog.d("NestLXADNativeView registerViewAndActionFeedAd onAdShow ad = " + ((LxNativeFeedAd) objectRef.element).getTitle());
                    NestLxAdNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onAdExposed(adProviderType, nestAdData);
                    }
                }

                @Override // com.wifi.adsdk.listener.LxBaseShowListener
                public void onRenderFail(int code, String message) {
                }
            });
            ((LxNativeFeedAd) objectRef.element).setDownLoadListener(new LxNativeDownListener() { // from class: com.wifi.lxad.ad.NestLxAdNativeView.registerViewAndActionFeedAd.3
                @Override // com.wifi.adsdk.listener.LxNativeDownListener
                public void onDownloadFail(int code, String error) throws JSONException {
                    WifiLog.d("NestLXADNativeView  onDownloadFail ");
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadFailed(adProviderType, nestAdData);
                    }
                    nestAdData.setDownloadStatus(6);
                    NestLxAdNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_NODOWNLOAD);
                }

                @Override // com.wifi.adsdk.listener.LxNativeDownListener
                public void onDownloadFinish() throws JSONException {
                    WifiLog.d("NestLXADNativeView  onDownloadFinished");
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadComplete(adProviderType, nestAdData);
                    }
                    nestAdData.setDownloadStatus(4);
                    NestLxAdNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADED);
                }

                @Override // com.wifi.adsdk.listener.LxNativeDownListener
                public void onDownloadPause() {
                    WifiLog.d("NestLXADNativeView  onDownloadPause");
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadPause(adProviderType, nestAdData);
                    }
                }

                @Override // com.wifi.adsdk.listener.LxNativeDownListener
                public void onDownloadProcess(int process) throws JSONException {
                    WifiLog.d("NestLXADNativeView  onDownloadActive");
                    nestAdData.setDownloadStatus(3);
                    if (!NestLxAdNativeView.this.mHasShowDownloadActive) {
                        NestLxAdNativeView.this.mHasShowDownloadActive = true;
                        NestLxAdNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADING);
                    }
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadProgress(adProviderType, nestAdData, process);
                    }
                }

                @Override // com.wifi.adsdk.listener.LxNativeDownListener
                public void onDownloadStart() {
                    WifiLog.d("NestLXADNativeView  onDownloadStart");
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadStart(adProviderType, nestAdData);
                    }
                    nestAdData.setDownloadStatus(0);
                    NestLxAdNativeView.this.mHasShowDownloadActive = false;
                }

                @Override // com.wifi.adsdk.listener.LxNativeDownListener
                public void onInstall() throws JSONException {
                    WifiLog.d("NestLXADNativeView  onInstall");
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadInstalled(adProviderType, nestAdData);
                    }
                    nestAdData.setDownloadStatus(5);
                    NestLxAdNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_INSTALLED);
                }
            });
            ((LxNativeFeedAd) objectRef.element).registerViewAndActionFeedAd(container, creativeViews);
        }
    }

    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void showTemplateFeedAd(String adProviderType, NestAdData nestAdData, ViewGroup container, NativeViewListener listener, Activity activity) throws JSONException {
        if (nestAdData.getAdData() == null || !(nestAdData.getAdData() instanceof LxTempFeedAd)) {
            return;
        }
        Object adData = nestAdData.getAdData();
        if (adData == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.wifi.adsdk.tempfeed.LxTempFeedAd");
        }
        LxTempFeedAd lxTempFeedAd = (LxTempFeedAd) adData;
        INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        lxTempFeedAd.setShowAct(activity);
        lxTempFeedAd.showTempAd();
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
