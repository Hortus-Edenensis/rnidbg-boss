package com.wifi.ad.core.helper;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.config.AdProviderLoader;
import com.wifi.ad.core.custom.flow.BaseNativeView;
import com.wifi.ad.core.custom.flow.NestBaseTemplate;
import com.wifi.ad.core.listener.NativeListener;
import com.wifi.ad.core.listener.NativeViewListener;
import com.wifi.ad.core.provider.BaseAdProvider;
import com.wifi.ad.core.utils.AdRandomUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B#\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001b\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tB9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\u0012\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J*\u0010\u0018\u001a\u00020\u00152\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/wifi/ad/core/helper/AdHelperNativePro;", "Lcom/wifi/ad/core/helper/BaseHelper;", "activity", "Landroid/app/Activity;", "alias", "", "maxCount", "", "(Landroid/app/Activity;Ljava/lang/String;I)V", "(Landroid/app/Activity;Ljava/lang/String;)V", "radioMap", "", "(Landroid/app/Activity;Ljava/lang/String;Ljava/util/Map;I)V", "adProvider", "Lcom/wifi/ad/core/provider/BaseAdProvider;", "mActivity", "Ljava/lang/ref/WeakReference;", "mAlias", "mMaxCount", "mRadioMap", "getList", "", bq.f.s, "Lcom/wifi/ad/core/listener/NativeListener;", "getListForMap", "Companion", "core_release"}, k = 1, mv = {1, 1, 16})
public final class AdHelperNativePro extends BaseHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int defaultMaxCount = 4;
    private BaseAdProvider adProvider;
    private WeakReference<Activity> mActivity;
    private String mAlias;
    private int mMaxCount;
    private Map<String, Integer> mRadioMap;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0001J\u0016\u0010\u0005\u001a\u00020\u00062\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tJ\u0010\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0001J\u0016\u0010\n\u001a\u00020\u00062\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tJ0\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00012\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/wifi/ad/core/helper/AdHelperNativePro$Companion;", "", "()V", "defaultMaxCount", "", "destroyAd", "", "adObject", "adObjectList", "", "resumeAd", bq.b.V, "container", "Landroid/view/ViewGroup;", "nativeTemplate", "Lcom/wifi/ad/core/custom/flow/NestBaseTemplate;", bq.f.s, "Lcom/wifi/ad/core/listener/NativeViewListener;", "core_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, Object obj, ViewGroup viewGroup, NestBaseTemplate nestBaseTemplate, NativeViewListener nativeViewListener, int i, Object obj2) {
            if ((i & 8) != 0) {
                nativeViewListener = null;
            }
            companion.show(obj, viewGroup, nestBaseTemplate, nativeViewListener);
        }

        public final void destroyAd(@NonNull Object adObject) {
            Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
            while (it.hasNext()) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
                if (baseAdProviderLoadAdProvider != null) {
                    baseAdProviderLoadAdProvider.destroyNativeAd(adObject);
                }
            }
        }

        public final void resumeAd(@NonNull Object adObject) {
            Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
            while (it.hasNext()) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) ((Map.Entry) it.next()).getKey());
                if (baseAdProviderLoadAdProvider != null) {
                    baseAdProviderLoadAdProvider.resumeNativeAd(adObject);
                }
            }
        }

        public final void show(@NonNull Object adObject, @NonNull ViewGroup container, @NonNull NestBaseTemplate nativeTemplate, @Nullable NativeViewListener listener) {
            BaseNativeView nativeView;
            Iterator<T> it = TogetherAd.INSTANCE.getMProviders().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider((String) entry.getKey());
                if (baseAdProviderLoadAdProvider != null && baseAdProviderLoadAdProvider.nativeAdIsBelongTheProvider(adObject) && (nativeView = nativeTemplate.getNativeView((String) entry.getKey())) != null) {
                    nativeView.showNative((String) entry.getKey(), adObject, container, listener);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void destroyAd(@NonNull List<? extends Object> adObjectList) {
            Iterator<T> it = adObjectList.iterator();
            while (it.hasNext()) {
                AdHelperNativePro.INSTANCE.destroyAd(it.next());
            }
        }

        public final void resumeAd(@NonNull List<? extends Object> adObjectList) {
            Iterator<T> it = adObjectList.iterator();
            while (it.hasNext()) {
                AdHelperNativePro.INSTANCE.resumeAd(it.next());
            }
        }
    }

    public /* synthetic */ AdHelperNativePro(Activity activity, String str, Map map, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, str, (i2 & 4) != 0 ? null : map, i);
    }

    public static /* synthetic */ void getList$default(AdHelperNativePro adHelperNativePro, NativeListener nativeListener, int i, Object obj) {
        if ((i & 1) != 0) {
            nativeListener = null;
        }
        adHelperNativePro.getList(nativeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getListForMap(@NonNull final Map<String, Integer> radioMap, final NativeListener listener) {
        int i = this.mMaxCount;
        int i2 = i <= 0 ? 4 : i;
        final String randomAdProvider = AdRandomUtil.INSTANCE.getRandomAdProvider(radioMap);
        if (randomAdProvider != null) {
            if (!(randomAdProvider.length() == 0) && this.mActivity.get() != null) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider(randomAdProvider);
                this.adProvider = baseAdProviderLoadAdProvider;
                if (baseAdProviderLoadAdProvider == null) {
                    getListForMap(filterType(radioMap, randomAdProvider), listener);
                    return;
                }
                if (baseAdProviderLoadAdProvider != null) {
                    Activity activity = this.mActivity.get();
                    if (activity == null) {
                        Intrinsics.throwNpe();
                    }
                    Intrinsics.checkExpressionValueIsNotNull(activity, "mActivity.get()!!");
                    baseAdProviderLoadAdProvider.getNativeAdList(activity, randomAdProvider, this.mAlias, i2, new NativeListener() { // from class: com.wifi.ad.core.helper.AdHelperNativePro.getListForMap.1
                        @Override // com.wifi.ad.core.listener.NativeListener
                        public void onAdFailed(String providerType, String failedMsg) {
                            NativeListener nativeListener = listener;
                            if (nativeListener != null) {
                                nativeListener.onAdFailed(providerType, failedMsg);
                            }
                            AdHelperNativePro adHelperNativePro = AdHelperNativePro.this;
                            adHelperNativePro.getListForMap(adHelperNativePro.filterType(radioMap, randomAdProvider), listener);
                        }

                        @Override // com.wifi.ad.core.listener.NativeListener
                        public void onAdFailedAll() {
                            NativeListener nativeListener = listener;
                            if (nativeListener != null) {
                                nativeListener.onAdFailedAll();
                            }
                        }

                        @Override // com.wifi.ad.core.listener.NativeListener
                        public void onAdLoaded(String providerType, List<? extends Object> adList) {
                            NativeListener nativeListener = listener;
                            if (nativeListener != null) {
                                nativeListener.onAdLoaded(providerType, adList);
                            }
                        }

                        @Override // com.wifi.ad.core.listener.NativeListener
                        public void onAdStartRequest(String providerType) {
                            NativeListener nativeListener = listener;
                            if (nativeListener != null) {
                                nativeListener.onAdStartRequest(providerType);
                            }
                        }
                    });
                    return;
                }
                return;
            }
        }
        if (listener != null) {
            listener.onAdFailedAll();
        }
    }

    public static /* synthetic */ void getListForMap$default(AdHelperNativePro adHelperNativePro, Map map, NativeListener nativeListener, int i, Object obj) {
        if ((i & 2) != 0) {
            nativeListener = null;
        }
        adHelperNativePro.getListForMap(map, nativeListener);
    }

    public final void getList(NativeListener listener) {
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
        getListForMap(publicProviderRadio, listener);
    }

    public AdHelperNativePro(@NonNull Activity activity, @NonNull String str, Map<String, Integer> map, int i) {
        this.mActivity = new WeakReference<>(activity);
        this.mAlias = str;
        this.mRadioMap = map;
        this.mMaxCount = i;
    }

    public AdHelperNativePro(@NonNull Activity activity, @NonNull String str, int i) {
        this(activity, str, null, i);
    }

    public AdHelperNativePro(@NonNull Activity activity, @NonNull String str) {
        this(activity, str, null, 4);
    }
}
