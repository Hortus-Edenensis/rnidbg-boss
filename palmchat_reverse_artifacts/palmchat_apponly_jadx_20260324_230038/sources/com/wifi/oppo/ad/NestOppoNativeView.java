package com.wifi.oppo.ad;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener;
import com.heytap.msp.mobad.api.params.INativeAdData;
import com.heytap.msp.mobad.api.params.INativeAdFile;
import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import com.heytap.msp.mobad.api.params.INativeComplianceListener;
import com.heytap.msp.mobad.api.params.INativeTempletAdView;
import com.heytap.msp.mobad.api.params.MediaView;
import com.heytap.msp.mobad.api.params.NativeAdvanceContainer;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.SDKAlias;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.custom.flow.BaseNativeView;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.feedbanner.NestOppoNativeAdContainer;
import com.wifi.ad.core.listener.NativeViewListener;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.reporter.EventReporter;
import com.wifi.ad.core.utils.WifiLog;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002JF\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J*\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J*\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J*\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J4\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016¨\u0006\u001a"}, d2 = {"Lcom/wifi/oppo/ad/NestOppoNativeView;", "Lcom/wifi/ad/core/custom/flow/BaseNativeView;", "()V", "registerViewAndActionFeedAd", "", "adProviderType", "", "container", "Landroid/view/ViewGroup;", "clickViews", "", "Landroid/view/View;", "creativeViews", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", bq.f.s, "Lcom/wifi/ad/core/listener/NativeViewListener;", "showDrawVideoAd", "adObject", "showNative", "", "showNativeDrawVideoAd", "showTemplateFeedAd", "activity", "Landroid/app/Activity;", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestOppoNativeView extends BaseNativeView {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/wifi/oppo/ad/NestOppoNativeView$Companion;", "", "()V", "onEvent", "", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "eventKey", "", "errorCode", "", MediationConstant.KEY_ERROR_MSG, BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
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
            String desc;
            String nestType;
            String url = null;
            if (nestAdData.getAdData() instanceof INativeAdData) {
                Object adData = nestAdData.getAdData();
                if (adData == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.heytap.msp.mobad.api.params.INativeAdData");
                }
                INativeAdData iNativeAdData = (INativeAdData) adData;
                String title = iNativeAdData.getTitle();
                List<INativeAdFile> imgFiles = iNativeAdData.getImgFiles();
                if (!(imgFiles == null || imgFiles.isEmpty())) {
                    List<INativeAdFile> imgFiles2 = iNativeAdData.getImgFiles();
                    if (imgFiles2 == null) {
                        Intrinsics.throwNpe();
                    }
                    INativeAdFile iNativeAdFile = imgFiles2.get(0);
                    if (iNativeAdFile != null) {
                        url = iNativeAdFile.getUrl();
                    }
                }
                desc = iNativeAdData.getDesc();
                str = url;
                url = title;
            } else {
                str = null;
                desc = null;
            }
            EventParams.Builder nestSid = new EventParams.Builder().setDspName(NestOppoProvider.DSP_NAME).setSdkFrom("oppo").setInventoryId(nestAdData.getInventoryId()).setPosition(nestAdData.getPosition()).setTmAdBtnShow(nestAdData.getShowAdButtonTime()).setRedAdBtnShow(nestAdData.getChangeAdBtnColorTime()).setCtAdBtnShow(nestAdData.getShowAdCardTime()).setMediaId(WifiNestAd.INSTANCE.getAppIds().get(SDKAlias.OPPO)).setRenderStyle(nestAdData.getRenderStyle()).setSrcId(nestAdData.getAdCode()).setNestSid(nestAdData.getNestSid());
            AdParams adParams = nestAdData.getAdParams();
            if (adParams == null || (nestType = adParams.getNestType()) == null) {
                nestType = "";
            }
            EventParams.Builder nestType2 = nestSid.setNestType(nestType);
            Integer adMode = nestAdData.getAdMode();
            EventParams.Builder params = nestType2.setAdMode((adMode != null ? adMode : "").toString()).setAdTitle(url).setAdImage(str).setAdDesc(desc);
            params.setErrorCode(String.valueOf(errorCode));
            params.setErrorMsg(errorMsg);
            EventReporter eventReporter = EventReporter.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(params, "params");
            eventReporter.reportViewEvent(params, nestAdData, eventKey);
        }
    }

    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void registerViewAndActionFeedAd(final String adProviderType, ViewGroup container, List<View> clickViews, List<View> creativeViews, final NestAdData nestAdData, final NativeViewListener listener) throws JSONException {
        Companion companion = INSTANCE;
        companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        Object adData = nestAdData.getAdData();
        if (adData == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.heytap.msp.mobad.api.params.INativeAdvanceData");
        }
        final INativeAdvanceData iNativeAdvanceData = (INativeAdvanceData) adData;
        if (!iNativeAdvanceData.isAdValid()) {
            companion.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW_FAIL, -1001, "oppoAd isAdValid");
            return;
        }
        NativeAdvanceContainer nativeAdvanceContainer = (NativeAdvanceContainer) container.findViewWithTag(NestOppoNativeAdContainer.TAG);
        WifiLog.d("NestOppoNativeView registerViewAndActionFeedAd feedAd = " + iNativeAdvanceData.getDesc() + " nativeAdContainer " + nativeAdvanceContainer);
        if (nativeAdvanceContainer instanceof NativeAdvanceContainer) {
            TextView adButtonView = getAdButtonView(clickViews, creativeViews);
            boolean z = iNativeAdvanceData.getComplianceInfo() != null;
            WifiLog.d("NestOppoNativeView registerViewAndActionFeedAd feedAd = " + iNativeAdvanceData.getDesc() + " isDownApp " + z);
            if (adButtonView != null && z) {
                Context context = container.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "container.context");
                adButtonView.setText(context.getResources().getString(R.string.download_quick));
                CharSequence text = adButtonView.getText();
                if (text != null) {
                    nestAdData.setRespbtnwd(text.toString());
                    nestAdData.setShowbtnwd(text.toString());
                }
            }
            iNativeAdvanceData.setInteractListener(new INativeAdvanceInteractListener() { // from class: com.wifi.oppo.ad.NestOppoNativeView.registerViewAndActionFeedAd.2
                @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
                public void onClick() throws JSONException {
                    WifiLog.d("NestOppoNativeView registerViewAndActionFeedAd onADClicked: " + iNativeAdvanceData.getTitle());
                    NestOppoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_CLICK);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onAdClicked(adProviderType, nestAdData);
                    }
                }

                @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
                public void onError(int errorCode, String errorMsg) throws JSONException {
                    WifiLog.d("NestOppoNativeView registerViewAndActionFeedAd onADError error code :" + errorCode + "  error msg: " + errorMsg);
                    NestOppoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW_FAIL, errorCode, errorMsg);
                }

                @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
                public void onShow() throws JSONException {
                    WifiLog.d("NestOppoNativeView registerViewAndActionFeedAd onADExposed: " + iNativeAdvanceData.getTitle());
                    NestOppoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_SHOW);
                    NativeViewListener nativeViewListener = listener;
                    if (nativeViewListener != null) {
                        nativeViewListener.onAdExposed(adProviderType, nestAdData);
                    }
                }
            });
            iNativeAdvanceData.bindToView(container.getContext(), nativeAdvanceContainer, creativeViews);
            if (iNativeAdvanceData.getCreativeType() == 13 || iNativeAdvanceData.getCreativeType() == 16) {
                View adView = nestAdData.getAdView();
                if (adView instanceof MediaView) {
                    iNativeAdvanceData.bindMediaView(container.getContext(), (MediaView) adView, new INativeAdvanceMediaListener() { // from class: com.wifi.oppo.ad.NestOppoNativeView.registerViewAndActionFeedAd.3
                        @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
                        public void onVideoPlayComplete() throws JSONException {
                            Companion companion2 = NestOppoNativeView.INSTANCE;
                            companion2.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOE);
                            companion2.onEvent(nestAdData, WifiNestConst.EventKey.NEST_SDK_ENDPLAY_SHOW);
                            NestAdData.VideoAdListener videoAdListener = nestAdData.getVideoAdListener();
                            if (videoAdListener != null) {
                                videoAdListener.onVideoComplete(nestAdData);
                            }
                        }

                        @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
                        public void onVideoPlayError(int errorCode, String msg) throws JSONException {
                            NestOppoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOT, errorCode, msg);
                            NestAdData.VideoAdListener videoAdListener = nestAdData.getVideoAdListener();
                            if (videoAdListener != null) {
                                videoAdListener.onVideoError(nestAdData);
                            }
                        }

                        @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
                        public void onVideoPlayStart() throws JSONException {
                            NestOppoNativeView.INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_VIDEOS);
                            NestAdData.VideoAdListener videoAdListener = nestAdData.getVideoAdListener();
                            if (videoAdListener != null) {
                                videoAdListener.onVideoStart(nestAdData);
                            }
                        }
                    });
                }
            }
            if ((nestAdData.getOppoDescView() instanceof TextView) && (nestAdData.getOppoPermissionsView() instanceof TextView) && (nestAdData.getOppoPrivacyView() instanceof TextView)) {
                WifiLog.d("OPPOCOMINFO showAd  data " + nestAdData);
                iNativeAdvanceData.bindToComplianceView(container.getContext(), new LinkedList<View>() { // from class: com.wifi.oppo.ad.NestOppoNativeView.registerViewAndActionFeedAd.4
                    {
                        add(this.$nestAdData.getOppoPrivacyView());
                    }

                    public /* bridge */ boolean contains(View view) {
                        return super.contains((Object) view);
                    }

                    public /* bridge */ int getSize() {
                        return super.size();
                    }

                    public /* bridge */ int indexOf(View view) {
                        return super.indexOf((Object) view);
                    }

                    public /* bridge */ int lastIndexOf(View view) {
                        return super.lastIndexOf((Object) view);
                    }

                    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
                    public final /* bridge */ View remove(int i) {
                        return removeAt(i);
                    }

                    public /* bridge */ View removeAt(int i) {
                        return (View) super.remove(i);
                    }

                    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
                    public final /* bridge */ int size() {
                        return getSize();
                    }

                    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
                    public final /* bridge */ boolean contains(Object obj) {
                        if (obj != null ? obj instanceof View : true) {
                            return contains((View) obj);
                        }
                        return false;
                    }

                    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
                    public final /* bridge */ int indexOf(Object obj) {
                        if (obj != null ? obj instanceof View : true) {
                            return indexOf((View) obj);
                        }
                        return -1;
                    }

                    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
                    public final /* bridge */ int lastIndexOf(Object obj) {
                        if (obj != null ? obj instanceof View : true) {
                            return lastIndexOf((View) obj);
                        }
                        return -1;
                    }

                    public /* bridge */ boolean remove(View view) {
                        return super.remove((Object) view);
                    }

                    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
                    public final /* bridge */ boolean remove(Object obj) {
                        if (obj != null ? obj instanceof View : true) {
                            return remove((View) obj);
                        }
                        return false;
                    }
                }, new INativeComplianceListener() { // from class: com.wifi.oppo.ad.NestOppoNativeView.registerViewAndActionFeedAd.5
                    @Override // com.heytap.msp.mobad.api.params.INativeComplianceListener
                    public void onClose() {
                    }

                    @Override // com.heytap.msp.mobad.api.params.INativeComplianceListener
                    public void onClick(View view) {
                    }
                }, new LinkedList<View>() { // from class: com.wifi.oppo.ad.NestOppoNativeView.registerViewAndActionFeedAd.6
                    {
                        add(this.$nestAdData.getOppoPermissionsView());
                    }

                    public /* bridge */ boolean contains(View view) {
                        return super.contains((Object) view);
                    }

                    public /* bridge */ int getSize() {
                        return super.size();
                    }

                    public /* bridge */ int indexOf(View view) {
                        return super.indexOf((Object) view);
                    }

                    public /* bridge */ int lastIndexOf(View view) {
                        return super.lastIndexOf((Object) view);
                    }

                    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
                    public final /* bridge */ View remove(int i) {
                        return removeAt(i);
                    }

                    public /* bridge */ View removeAt(int i) {
                        return (View) super.remove(i);
                    }

                    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
                    public final /* bridge */ int size() {
                        return getSize();
                    }

                    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
                    public final /* bridge */ boolean contains(Object obj) {
                        if (obj != null ? obj instanceof View : true) {
                            return contains((View) obj);
                        }
                        return false;
                    }

                    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
                    public final /* bridge */ int indexOf(Object obj) {
                        if (obj != null ? obj instanceof View : true) {
                            return indexOf((View) obj);
                        }
                        return -1;
                    }

                    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
                    public final /* bridge */ int lastIndexOf(Object obj) {
                        if (obj != null ? obj instanceof View : true) {
                            return lastIndexOf((View) obj);
                        }
                        return -1;
                    }

                    public /* bridge */ boolean remove(View view) {
                        return super.remove((Object) view);
                    }

                    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
                    public final /* bridge */ boolean remove(Object obj) {
                        if (obj != null ? obj instanceof View : true) {
                            return remove((View) obj);
                        }
                        return false;
                    }
                }, new INativeComplianceListener() { // from class: com.wifi.oppo.ad.NestOppoNativeView.registerViewAndActionFeedAd.7
                    @Override // com.heytap.msp.mobad.api.params.INativeComplianceListener
                    public void onClose() {
                    }

                    @Override // com.heytap.msp.mobad.api.params.INativeComplianceListener
                    public void onClick(View view) {
                    }
                }, new LinkedList<View>() { // from class: com.wifi.oppo.ad.NestOppoNativeView.registerViewAndActionFeedAd.8
                    {
                        add(this.$nestAdData.getOppoDescView());
                    }

                    public /* bridge */ boolean contains(View view) {
                        return super.contains((Object) view);
                    }

                    public /* bridge */ int getSize() {
                        return super.size();
                    }

                    public /* bridge */ int indexOf(View view) {
                        return super.indexOf((Object) view);
                    }

                    public /* bridge */ int lastIndexOf(View view) {
                        return super.lastIndexOf((Object) view);
                    }

                    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
                    public final /* bridge */ View remove(int i) {
                        return removeAt(i);
                    }

                    public /* bridge */ View removeAt(int i) {
                        return (View) super.remove(i);
                    }

                    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
                    public final /* bridge */ int size() {
                        return getSize();
                    }

                    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
                    public final /* bridge */ boolean contains(Object obj) {
                        if (obj != null ? obj instanceof View : true) {
                            return contains((View) obj);
                        }
                        return false;
                    }

                    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
                    public final /* bridge */ int indexOf(Object obj) {
                        if (obj != null ? obj instanceof View : true) {
                            return indexOf((View) obj);
                        }
                        return -1;
                    }

                    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
                    public final /* bridge */ int lastIndexOf(Object obj) {
                        if (obj != null ? obj instanceof View : true) {
                            return lastIndexOf((View) obj);
                        }
                        return -1;
                    }

                    public /* bridge */ boolean remove(View view) {
                        return super.remove((Object) view);
                    }

                    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
                    public final /* bridge */ boolean remove(Object obj) {
                        if (obj != null ? obj instanceof View : true) {
                            return remove((View) obj);
                        }
                        return false;
                    }
                }, new INativeComplianceListener() { // from class: com.wifi.oppo.ad.NestOppoNativeView.registerViewAndActionFeedAd.9
                    @Override // com.heytap.msp.mobad.api.params.INativeComplianceListener
                    public void onClose() {
                    }

                    @Override // com.heytap.msp.mobad.api.params.INativeComplianceListener
                    public void onClick(View view) {
                    }
                });
            }
        }
    }

    @Override // com.wifi.ad.core.custom.flow.BaseNativeView
    public void showTemplateFeedAd(String adProviderType, NestAdData nestAdData, ViewGroup container, NativeViewListener listener, Activity activity) throws JSONException {
        INSTANCE.onEvent(nestAdData, WifiNestConst.EventKey.UNIFIEDAD_SDK_TOSHOW);
        View adView = nestAdData.getAdView();
        WifiLog.d("oppoView showTemplateFeedAd adView " + adView);
        if (adView == null || !(nestAdData.getAdData() instanceof INativeTempletAdView)) {
            return;
        }
        if (adView.getParent() instanceof ViewGroup) {
            ViewParent parent = adView.getParent();
            if (parent == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ((ViewGroup) parent).removeView(adView);
        }
        container.addView(adView);
        Object adData = nestAdData.getAdData();
        if (adData == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.heytap.msp.mobad.api.params.INativeTempletAdView");
        }
        ((INativeTempletAdView) adData).render();
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
