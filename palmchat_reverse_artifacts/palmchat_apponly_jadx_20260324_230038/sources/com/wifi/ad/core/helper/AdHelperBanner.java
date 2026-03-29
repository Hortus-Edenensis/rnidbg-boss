package com.wifi.ad.core.helper;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.config.AdProviderLoader;
import com.wifi.ad.core.listener.BannerListener;
import com.wifi.ad.core.provider.BaseAdProvider;
import com.wifi.ad.core.utils.AdRandomUtil;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J0\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fJH\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\b\b\u0001\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/wifi/ad/core/helper/AdHelperBanner;", "Lcom/wifi/ad/core/helper/BaseHelper;", "()V", "adProvider", "Lcom/wifi/ad/core/provider/BaseAdProvider;", "destroy", "", bq.b.V, "activity", "Landroid/app/Activity;", "alias", "", "container", "Landroid/view/ViewGroup;", bq.f.s, "Lcom/wifi/ad/core/listener/BannerListener;", "radioMap", "", "", "core_release"}, k = 1, mv = {1, 1, 16})
public final class AdHelperBanner extends BaseHelper {
    public static final AdHelperBanner INSTANCE = new AdHelperBanner();
    private static BaseAdProvider adProvider;

    private AdHelperBanner() {
    }

    public static /* synthetic */ void show$default(AdHelperBanner adHelperBanner, Activity activity, String str, ViewGroup viewGroup, BannerListener bannerListener, int i, Object obj) {
        if ((i & 8) != 0) {
            bannerListener = null;
        }
        adHelperBanner.show(activity, str, viewGroup, bannerListener);
    }

    public final void destroy() {
        BaseAdProvider baseAdProvider = adProvider;
        if (baseAdProvider != null) {
            baseAdProvider.destroyBannerAd();
        }
        adProvider = null;
    }

    public final void show(@NonNull Activity activity, @NonNull String alias, @NonNull ViewGroup container, BannerListener listener) {
        show(activity, alias, null, container, listener);
    }

    public final void show(@NonNull final Activity activity, @NonNull final String alias, Map<String, Integer> radioMap, @NonNull final ViewGroup container, final BannerListener listener) {
        final Map<String, Integer> publicProviderRadio = (radioMap == null || radioMap.isEmpty()) ? TogetherAd.INSTANCE.getPublicProviderRadio() : radioMap;
        final String randomAdProvider = AdRandomUtil.INSTANCE.getRandomAdProvider(publicProviderRadio);
        if (randomAdProvider != null) {
            if (!(randomAdProvider.length() == 0)) {
                BaseAdProvider baseAdProviderLoadAdProvider = AdProviderLoader.INSTANCE.loadAdProvider(randomAdProvider);
                adProvider = baseAdProviderLoadAdProvider;
                if (baseAdProviderLoadAdProvider == null) {
                    show(activity, alias, filterType(publicProviderRadio, randomAdProvider), container, listener);
                    return;
                } else {
                    if (baseAdProviderLoadAdProvider != null) {
                        baseAdProviderLoadAdProvider.showBannerAd(activity, randomAdProvider, alias, container, new BannerListener() { // from class: com.wifi.ad.core.helper.AdHelperBanner.show.1
                            @Override // com.wifi.ad.core.listener.BannerListener
                            public void onAdClicked(String providerType) {
                                BannerListener bannerListener = listener;
                                if (bannerListener != null) {
                                    bannerListener.onAdClicked(providerType);
                                }
                            }

                            @Override // com.wifi.ad.core.listener.BannerListener
                            public void onAdClose(String providerType) {
                                BannerListener bannerListener = listener;
                                if (bannerListener != null) {
                                    bannerListener.onAdClose(providerType);
                                }
                            }

                            @Override // com.wifi.ad.core.listener.BannerListener
                            public void onAdExpose(String providerType) {
                                BannerListener bannerListener = listener;
                                if (bannerListener != null) {
                                    bannerListener.onAdExpose(providerType);
                                }
                            }

                            @Override // com.wifi.ad.core.listener.BannerListener
                            public void onAdFailed(String providerType, String failedMsg) {
                                BannerListener bannerListener = listener;
                                if (bannerListener != null) {
                                    bannerListener.onAdFailed(providerType, failedMsg);
                                }
                                AdHelperBanner adHelperBanner = AdHelperBanner.INSTANCE;
                                adHelperBanner.show(activity, alias, adHelperBanner.filterType(publicProviderRadio, randomAdProvider), container, listener);
                            }

                            @Override // com.wifi.ad.core.listener.BannerListener
                            public void onAdFailedAll() {
                                BannerListener bannerListener = listener;
                                if (bannerListener != null) {
                                    bannerListener.onAdFailedAll();
                                }
                            }

                            @Override // com.wifi.ad.core.listener.BannerListener
                            public void onAdLoaded(String providerType) {
                                BannerListener bannerListener = listener;
                                if (bannerListener != null) {
                                    bannerListener.onAdLoaded(providerType);
                                }
                            }

                            @Override // com.wifi.ad.core.listener.BannerListener
                            public void onAdStartRequest(String providerType) {
                                BannerListener bannerListener = listener;
                                if (bannerListener != null) {
                                    bannerListener.onAdStartRequest(randomAdProvider);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
            }
        }
        if (listener != null) {
            listener.onAdFailedAll();
        }
    }
}
