package com.wifi.feisuo.ad;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.compliance.AdDownViVoConfig;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.custom.flow.BaseNativeView;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.listener.NativeViewListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.utils.WifiLog;
import com.zm.fissionsdk.api.interfaces.IFission;
import com.zm.fissionsdk.api.interfaces.IFissionNative;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002JF\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J*\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J*\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J*\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J4\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/wifi/feisuo/ad/NestFeiSuoNativeView;", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "()V", "mHasShowDownloadActive", "", "registerViewAndActionFeedAd", "", "adProviderType", "", "container", "Landroid/view/ViewGroup;", "clickViews", "", "Landroid/view/View;", "creativeViews", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", bq.f.s, "Lcom/wifi/ad/core/listener/NativeViewListener;", "showDrawVideoAd", "adObject", "showNative", "", "showNativeDrawVideoAd", "showTemplateFeedAd", "activity", "Landroid/app/Activity;", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestFeiSuoNativeView extends BaseNativeView {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean mHasShowDownloadActive;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/wifi/feisuo/ad/NestFeiSuoNativeView$Companion;", "", "()V", "onEvent", "", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "eventKey", "", "errorCode", "", MediationConstant.KEY_ERROR_MSG, BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
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
            EventParams.Builder nestSid = new EventParams.Builder().setDspName(NestFeiSuoProvider.DSP_NAME).setSdkFrom("feisuo").setInventoryId(nestAdData.getInventoryId()).setPosition(nestAdData.getPosition()).setTmAdBtnShow(nestAdData.getShowAdButtonTime()).setRedAdBtnShow(nestAdData.getChangeAdBtnColorTime()).setCtAdBtnShow(nestAdData.getShowAdCardTime()).setMediaId(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.FEISUO)).setRenderStyle(nestAdData.getRenderStyle()).setSrcId(nestAdData.getAdCode()).setNestSid(nestAdData.getNestSid());
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

    /* JADX WARN: Type inference failed for: r6v3, types: [T, com.zm.fissionsdk.api.interfaces.IFissionNative] */
    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void registerViewAndActionFeedAd(final String adProviderType, ViewGroup container, List<View> clickViews, List<View> creativeViews, final NestAdData nestAdData, final NativeViewListener listener) throws JSONException {
        List<View> list;
        List<View> list2;
        WifiLog.d("NestFeiSuoNativeView registerViewAndActionFeedAd bind");
        INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        if (!(nestAdData.getAdData() instanceof IFissionNative)) {
            WifiLog.d("NestFeiSuoNativeView registerViewAndActionFeedAd adData !is IFissionNative");
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Object adData = nestAdData.getAdData();
        if (!(adData instanceof IFissionNative)) {
            adData = null;
        }
        ?? r6 = (IFissionNative) adData;
        if (r6 != 0) {
            objectRef.element = r6;
            if (clickViews == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new View(container.getContext()));
                list2 = arrayList;
                list = creativeViews;
            } else {
                list = creativeViews;
                list2 = clickViews;
            }
            TextView adButtonView = getAdButtonView(clickViews, list);
            if (adButtonView != null) {
                CharSequence text = adButtonView.getText();
                if (text != null) {
                    nestAdData.setRespbtnwd(text.toString());
                    nestAdData.setShowbtnwd(text.toString());
                }
                if (WifiNestAd.INSTANCE.getSwitch315() && 4 == ((IFissionNative) objectRef.element).getInteractionType()) {
                    Context context = container.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context, "container.context");
                    adButtonView.setText(context.getResources().getString(R.string.download_quick));
                    nestAdData.setShowbtnwd(adButtonView.getText().toString());
                }
            }
            ((IFissionNative) objectRef.element).setNativeInteractionListener(container, list2, creativeViews, null, null, new IFissionNative.NativeInteractionListener() { // from class: com.wifi.feisuo.ad.NestFeiSuoNativeView.registerViewAndActionFeedAd.2
                @Override // com.zm.fissionsdk.api.interfaces.IFissionInteractionListener
                public void onClick(View p0) throws JSONException {
                    WifiLog.d("NestFeiSuoNativeView registerViewAndActionFeedAd onAdClicked");
                    NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onAdClicked(adProviderType, nestAdData);
                    }
                }

                @Override // com.zm.fissionsdk.api.interfaces.IFissionNative.NativeInteractionListener
                public void onCreativeClick(View p0) throws JSONException {
                    WifiLog.d("NestFeiSuoNativeView registerViewAndActionFeedAd onCreativeClick");
                    NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onAdClicked(adProviderType, nestAdData);
                    }
                }

                @Override // com.zm.fissionsdk.api.interfaces.IFissionInteractionListener
                public void onShow() throws JSONException {
                    WifiLog.d("NestFeiSuoNativeView registerViewAndActionFeedAd onAdShow ad = " + ((IFissionNative) objectRef.element).getTitle());
                    NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onAdExposed(adProviderType, nestAdData);
                    }
                }

                @Override // com.zm.fissionsdk.api.interfaces.IFissionInteractionListener
                public void onShowFailed(int p0, String p1) {
                    WifiLog.d("NestFeiSuoNativeView registerViewAndActionFeedAd onShowFailed");
                }
            });
            ((IFissionNative) objectRef.element).setVideoListener(new IFission.VideoListener() { // from class: com.wifi.feisuo.ad.NestFeiSuoNativeView.registerViewAndActionFeedAd.3
                @Override // com.zm.fissionsdk.api.interfaces.IFission.VideoListener
                public void onVideoComplete() throws JSONException {
                    Companion companion = NestFeiSuoNativeView.INSTANCE;
                    companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOE);
                    companion.onEvent(nestAdData, WifiNestConst.EventKey.NEST_SDK_ENDPLAY_SHOW);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoComplete(adProviderType, nestAdData);
                    }
                }

                @Override // com.zm.fissionsdk.api.interfaces.IFission.VideoListener
                public void onVideoError(int p0, String p1) throws JSONException {
                    NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOT);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoError(adProviderType, nestAdData);
                    }
                }

                @Override // com.zm.fissionsdk.api.interfaces.IFission.VideoListener
                public void onVideoPause() throws JSONException {
                    NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOB);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoPause(adProviderType, nestAdData);
                    }
                }

                @Override // com.zm.fissionsdk.api.interfaces.IFission.VideoListener
                public void onVideoPlay() throws JSONException {
                    NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOS);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onVideoStart(adProviderType, nestAdData);
                    }
                }

                @Override // com.zm.fissionsdk.api.interfaces.IFission.VideoListener
                public void onVideoContinuePlay() {
                }
            });
            ((IFissionNative) objectRef.element).setDownloadListener(new IFission.AppDownloadListener() { // from class: com.wifi.feisuo.ad.NestFeiSuoNativeView.registerViewAndActionFeedAd.4
                @Override // com.zm.fissionsdk.api.interfaces.IFission.AppDownloadListener
                public void onDownloadActive(long downloadLength, long totalLength) throws JSONException {
                    WifiLog.d("NestFeiSuoNativeView  onDownloadActive");
                    nestAdData.setDownloadStatus(3);
                    if (!NestFeiSuoNativeView.this.mHasShowDownloadActive) {
                        NestFeiSuoNativeView.this.mHasShowDownloadActive = true;
                        NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADING);
                    }
                    int i = downloadLength > 0 ? (int) ((downloadLength * 100.0f) / totalLength) : 0;
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadProgress(adProviderType, nestAdData, i);
                    }
                }

                @Override // com.zm.fissionsdk.api.interfaces.IFission.AppDownloadListener
                public void onDownloadFail(int p0, String p1) throws JSONException {
                    WifiLog.d("NestFeiSuoNativeView  onDownloadFail p1 " + p1);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadFailed(adProviderType, nestAdData);
                    }
                    nestAdData.setDownloadStatus(6);
                    NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_NODOWNLOAD);
                }

                @Override // com.zm.fissionsdk.api.interfaces.IFission.AppDownloadListener
                public void onDownloadFinish() throws JSONException {
                    WifiLog.d("NestFeiSuoNativeView  onDownloadFinished");
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadComplete(adProviderType, nestAdData);
                    }
                    nestAdData.setDownloadStatus(4);
                    NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_DOWNLOADED);
                }

                @Override // com.zm.fissionsdk.api.interfaces.IFission.AppDownloadListener
                public void onDownloadPause(long p0, long p1) {
                    WifiLog.d("NestFeiSuoNativeView  onDownloadPause");
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadPause(adProviderType, nestAdData);
                    }
                }

                @Override // com.zm.fissionsdk.api.interfaces.IFission.AppDownloadListener
                public void onDownloadStart() {
                    WifiLog.d("NestFeiSuoNativeView  onDownloadStart");
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadStart(adProviderType, nestAdData);
                    }
                    nestAdData.setDownloadStatus(0);
                    NestFeiSuoNativeView.this.mHasShowDownloadActive = false;
                }

                @Override // com.zm.fissionsdk.api.interfaces.IFission.AppDownloadListener
                public void onInstall() throws JSONException {
                    WifiLog.d("NestFeiSuoNativeView  onInstall");
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onDownloadInstalled(adProviderType, nestAdData);
                    }
                    nestAdData.setDownloadStatus(5);
                    NestFeiSuoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_INSTALLED);
                }
            });
            AdDownViVoConfig.checkVideoViewClick(nestAdData);
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
