package com.wifi.ad.core.helper;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.config.AdProviderLoader;
import com.wifi.ad.core.listener.InterListener;
import com.wifi.ad.core.provider.BaseAdProvider;
import com.wifi.ad.core.utils.AdRandomUtil;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB=\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\fJ\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u00020\u00152\u0014\b\u0001\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0006\u0010\u0017\u001a\u00020\u0015R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/wifi/ad/core/helper/AdHelperInter;", "Lcom/wifi/ad/core/helper/BaseHelper;", "activity", "Landroid/app/Activity;", "alias", "", bq.f.s, "Lcom/wifi/ad/core/listener/InterListener;", "(Landroid/app/Activity;Ljava/lang/String;Lcom/wifi/ad/core/listener/InterListener;)V", "radioMap", "", "", "(Landroid/app/Activity;Ljava/lang/String;Ljava/util/Map;Lcom/wifi/ad/core/listener/InterListener;)V", "adProvider", "Lcom/wifi/ad/core/provider/BaseAdProvider;", "mActivity", "Ljava/lang/ref/WeakReference;", "mAlias", "mListener", "mRadioMap", "load", "", "reload", bq.b.V, "core_release"}, k = 1, mv = {1, 1, 16})
public final class AdHelperInter extends BaseHelper {
    private BaseAdProvider adProvider;
    private WeakReference<Activity> mActivity;
    private String mAlias;
    private InterListener mListener;
    private Map<String, Integer> mRadioMap;

    public /* synthetic */ AdHelperInter(Activity activity, String str, Map map, InterListener interListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, str, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : interListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reload(@NonNull final Map<String, Integer> radioMap) {
        final String randomAdProvider = AdRandomUtil.INSTANCE.getRandomAdProvider(radioMap);
        if (randomAdProvider != null) {
            if (!(randomAdProvider.length() == 0) && this.mActivity.get() != null) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider(randomAdProvider);
                this.adProvider = baseAdProviderLoadAdProvider;
                if (baseAdProviderLoadAdProvider == null) {
                    reload(filterType(radioMap, randomAdProvider));
                    return;
                }
                if (baseAdProviderLoadAdProvider != null) {
                    Activity activity = this.mActivity.get();
                    if (activity == null) {
                        Intrinsics.throwNpe();
                    }
                    Intrinsics.checkExpressionValueIsNotNull(activity, "mActivity.get()!!");
                    baseAdProviderLoadAdProvider.requestInterAd(activity, randomAdProvider, this.mAlias, new InterListener() { // from class: com.wifi.ad.core.helper.AdHelperInter.reload.1
                        @Override // com.wifi.ad.core.listener.InterListener
                        public void onAdClicked(String providerType) {
                            InterListener interListener = AdHelperInter.this.mListener;
                            if (interListener != null) {
                                interListener.onAdClicked(providerType);
                            }
                        }

                        @Override // com.wifi.ad.core.listener.InterListener
                        public void onAdClose(String providerType) {
                            InterListener interListener = AdHelperInter.this.mListener;
                            if (interListener != null) {
                                interListener.onAdClose(providerType);
                            }
                        }

                        @Override // com.wifi.ad.core.listener.InterListener
                        public void onAdExpose(String providerType) {
                            InterListener interListener = AdHelperInter.this.mListener;
                            if (interListener != null) {
                                interListener.onAdExpose(providerType);
                            }
                        }

                        @Override // com.wifi.ad.core.listener.InterListener
                        public void onAdFailed(String providerType, String failedMsg) {
                            InterListener interListener = AdHelperInter.this.mListener;
                            if (interListener != null) {
                                interListener.onAdFailed(providerType, failedMsg);
                            }
                            AdHelperInter adHelperInter = AdHelperInter.this;
                            adHelperInter.reload(adHelperInter.filterType(radioMap, randomAdProvider));
                        }

                        @Override // com.wifi.ad.core.listener.InterListener
                        public void onAdFailedAll() {
                            InterListener interListener = AdHelperInter.this.mListener;
                            if (interListener != null) {
                                interListener.onAdFailedAll();
                            }
                        }

                        @Override // com.wifi.ad.core.listener.InterListener
                        public void onAdLoaded(String providerType) {
                            InterListener interListener = AdHelperInter.this.mListener;
                            if (interListener != null) {
                                interListener.onAdLoaded(providerType);
                            }
                        }

                        @Override // com.wifi.ad.core.listener.InterListener
                        public void onAdStartRequest(String providerType) {
                            InterListener interListener = AdHelperInter.this.mListener;
                            if (interListener != null) {
                                interListener.onAdStartRequest(providerType);
                            }
                        }
                    });
                    return;
                }
                return;
            }
        }
        InterListener interListener = this.mListener;
        if (interListener != null) {
            interListener.onAdFailedAll();
        }
    }

    public final void load() {
        Map<String, Integer> publicProviderRadio;
        Map<String, Integer> map = this.mRadioMap;
        if (map == null || map.isEmpty()) {
            publicProviderRadio = TogetherAd.INSTANCE.getPublicProviderRadio();
        } else {
            publicProviderRadio = this.mRadioMap;
            if (publicProviderRadio == null) {
                Intrinsics.throwNpe();
            }
        }
        reload(publicProviderRadio);
    }

    public final void show() {
        BaseAdProvider baseAdProvider;
        Activity it = this.mActivity.get();
        if (it == null || (baseAdProvider = this.adProvider) == null) {
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(it, "it");
        baseAdProvider.showInterAd(it);
    }

    public AdHelperInter(@NonNull Activity activity, @NonNull String str, Map<String, Integer> map, InterListener interListener) {
        this.mActivity = new WeakReference<>(activity);
        this.mAlias = str;
        this.mRadioMap = map;
        this.mListener = interListener;
    }

    public /* synthetic */ AdHelperInter(Activity activity, String str, InterListener interListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, str, (i & 4) != 0 ? null : interListener);
    }

    public AdHelperInter(@NonNull Activity activity, @NonNull String str, InterListener interListener) {
        this(activity, str, null, interListener);
    }
}
