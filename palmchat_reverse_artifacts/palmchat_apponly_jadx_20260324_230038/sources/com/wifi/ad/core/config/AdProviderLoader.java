package com.wifi.ad.core.config;

import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.entity.AdProviderEntity;
import com.wifi.ad.core.provider.BaseAdProvider;
import java.lang.reflect.Constructor;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\t¨\u0006\u000e"}, d2 = {"Lcom/wifi/ad/core/config/AdProviderLoader;", "", "()V", "getConstructor", "Ljava/lang/reflect/Constructor;", "clz", "Ljava/lang/Class;", "getProviderInstance", "providerType", "", "getSDKClass", "classPath", "loadAdProvider", "Lcom/wifi/ad/core/provider/BaseAdProvider;", "core_release"}, k = 1, mv = {1, 1, 16})
public final class AdProviderLoader {
    public static final AdProviderLoader INSTANCE = new AdProviderLoader();

    private AdProviderLoader() {
    }

    private final Constructor<?> getConstructor(Class<?> clz) {
        try {
            return clz.getConstructor(new Class[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final Object getProviderInstance(String providerType) {
        String classPath;
        AdProviderLoader adProviderLoader;
        Class<?> sDKClass;
        Constructor<?> constructor;
        try {
            AdProviderEntity provider$core_release = TogetherAd.INSTANCE.getProvider$core_release(providerType);
            if (provider$core_release == null || (classPath = provider$core_release.getClassPath()) == null || (sDKClass = (adProviderLoader = INSTANCE).getSDKClass(classPath)) == null || (constructor = adProviderLoader.getConstructor(sDKClass)) == null) {
                return null;
            }
            return constructor.newInstance(new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final Class<?> getSDKClass(String classPath) {
        try {
            return Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final BaseAdProvider loadAdProvider(String providerType) {
        try {
            Object providerInstance = getProviderInstance(providerType);
            if (providerInstance instanceof BaseAdProvider) {
                return (BaseAdProvider) providerInstance;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
