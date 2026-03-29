package com.wifi.ad.core;

import androidx.annotation.NonNull;
import com.wifi.ad.core.custom.flow.AdImageLoader;
import com.wifi.ad.core.custom.flow.GlideImageLoader;
import com.wifi.ad.core.entity.AdProviderEntity;
import com.wifi.ad.core.utils.LogExtKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\nJ\u0017\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\tH\u0000¢\u0006\u0002\b\u001bJ\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u001dJ\u0010\u0010\u001e\u001a\u00020\u00172\b\b\u0001\u0010\u001f\u001a\u00020\u0004J\u001c\u0010 \u001a\u00020\u00172\u0014\b\u0001\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u001dR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R6\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/wifi/ad/core/TogetherAd;", "", "()V", "<set-?>", "Lcom/wifi/ad/core/custom/flow/AdImageLoader;", "mImageLoader", "getMImageLoader", "()Lcom/wifi/ad/core/custom/flow/AdImageLoader;", "", "", "Lcom/wifi/ad/core/entity/AdProviderEntity;", "mProviders", "getMProviders", "()Ljava/util/Map;", "mRadioPublicMap", "", "printLogEnable", "", "getPrintLogEnable", "()Z", "setPrintLogEnable", "(Z)V", "addProvider", "", "adProviderEntity", "getProvider", "providerType", "getProvider$core_release", "getPublicProviderRadio", "", "setCustomImageLoader", "imageLoader", "setPublicProviderRadio", "radioMap", "core_release"}, k = 1, mv = {1, 1, 16})
public final class TogetherAd {
    private static boolean printLogEnable;
    public static final TogetherAd INSTANCE = new TogetherAd();
    private static final Map<String, Integer> mRadioPublicMap = new LinkedHashMap();
    private static Map<String, AdProviderEntity> mProviders = new LinkedHashMap();
    private static AdImageLoader mImageLoader = new GlideImageLoader();

    private TogetherAd() {
    }

    public final void addProvider(@NonNull AdProviderEntity adProviderEntity) {
        mProviders.put(adProviderEntity.getProviderType(), adProviderEntity);
        LogExtKt.logi$default("注册广告提供商：" + adProviderEntity.getProviderType(), null, 1, null);
    }

    public final AdImageLoader getMImageLoader() {
        return mImageLoader;
    }

    public final Map<String, AdProviderEntity> getMProviders() {
        return mProviders;
    }

    public final boolean getPrintLogEnable() {
        return printLogEnable;
    }

    public final AdProviderEntity getProvider$core_release(String providerType) {
        return mProviders.get(providerType);
    }

    public final Map<String, Integer> getPublicProviderRadio() {
        Map linkedHashMap = mRadioPublicMap;
        if (!(!linkedHashMap.isEmpty())) {
            linkedHashMap = new LinkedHashMap();
            Iterator<T> it = mProviders.entrySet().iterator();
            while (it.hasNext()) {
                linkedHashMap.put(((Map.Entry) it.next()).getKey(), 1);
            }
        }
        return linkedHashMap;
    }

    public final void setCustomImageLoader(@NonNull AdImageLoader imageLoader) {
        mImageLoader = imageLoader;
    }

    public final void setPrintLogEnable(boolean z) {
        printLogEnable = z;
    }

    public final void setPublicProviderRadio(@NonNull Map<String, Integer> radioMap) {
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = radioMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            sb.append(((String) entry.getKey()) + ':' + ((Number) entry.getValue()).intValue());
            sb.append(",");
        }
        LogExtKt.logi$default("设置默认广告提供商比例：" + ((Object) sb), null, 1, null);
        Map<String, Integer> map = mRadioPublicMap;
        map.clear();
        map.putAll(radioMap);
    }
}
