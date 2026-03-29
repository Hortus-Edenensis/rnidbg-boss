package com.wifi.self.ad;

import android.content.Context;
import androidx.annotation.NonNull;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.entity.AdProviderEntity;
import com.wifi.ad.core.listener.IAdSensitiveTaker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\"\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006!"}, d2 = {"Lcom/wifi/self/ad/NestWifiManager;", "", "()V", "changeAdBtnColorTime", "", "getChangeAdBtnColorTime", "()I", "setChangeAdBtnColorTime", "(I)V", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", "debugUrl", "getDebugUrl", "setDebugUrl", "showAdButtonTime", "getShowAdButtonTime", "setShowAdButtonTime", "showAdCardTime", "getShowAdCardTime", "setShowAdCardTime", "getVersion", "", "init", "", "context", "Landroid/content/Context;", "adProviderType", "sensitiveTaker", "Lcom/wifi/ad/core/listener/IAdSensitiveTaker;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestWifiManager {
    public static final NestWifiManager INSTANCE = new NestWifiManager();
    private static int changeAdBtnColorTime;
    private static boolean debug;
    private static boolean debugUrl;
    private static int showAdButtonTime;
    private static int showAdCardTime;

    private NestWifiManager() {
    }

    public final int getChangeAdBtnColorTime() {
        return changeAdBtnColorTime;
    }

    public final boolean getDebug() {
        return debug;
    }

    public final boolean getDebugUrl() {
        return debugUrl;
    }

    public final int getShowAdButtonTime() {
        return showAdButtonTime;
    }

    public final int getShowAdCardTime() {
        return showAdCardTime;
    }

    public final String getVersion() {
        return "8888";
    }

    public final void init(@NonNull Context context, @NonNull String adProviderType, IAdSensitiveTaker sensitiveTaker) {
        TogetherAd togetherAd = TogetherAd.INSTANCE;
        String name = NestWifiProvider.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "NestWifiProvider::class.java.name");
        togetherAd.addProvider(new AdProviderEntity(adProviderType, name, null, 4, null));
    }

    public final void setChangeAdBtnColorTime(int i) {
        changeAdBtnColorTime = i;
    }

    public final void setDebug(boolean z) {
        debug = z;
    }

    public final void setDebugUrl(boolean z) {
        debugUrl = z;
    }

    public final void setShowAdButtonTime(int i) {
        showAdButtonTime = i;
    }

    public final void setShowAdCardTime(int i) {
        showAdCardTime = i;
    }
}
