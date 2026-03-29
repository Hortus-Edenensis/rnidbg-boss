package com.wifi.baidu.ad;

import android.content.Context;
import androidx.annotation.NonNull;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u000bJ.\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u000b2\b\b\u0001\u0010\u0019\u001a\u00020\u000b2\b\b\u0001\u0010\u001a\u001a\u00020\u000bJF\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u000b2\b\b\u0001\u0010\u0019\u001a\u00020\u000b2\b\b\u0001\u0010\u001a\u001a\u00020\u000b2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/wifi/baidu/ad/NestBdManager;", "", "()V", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", "idMapBaidu", "", "", "getIdMapBaidu", "()Ljava/util/Map;", "setIdMapBaidu", "(Ljava/util/Map;)V", "initDone", "getInitDone", "setInitDone", "getVersion", "init", "", "context", "Landroid/content/Context;", "adProviderType", "appId", WfConstant.EVENT_KEY_APP_NAME, "baiduIdMap", "updatePersonAd", "enablePersonal", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestBdManager {
    private static boolean debug;
    private static boolean initDone;
    public static final NestBdManager INSTANCE = new NestBdManager();
    private static Map<String, String> idMapBaidu = MapsKt__MapsKt.emptyMap();

    private NestBdManager() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$default(NestBdManager nestBdManager, Context context, String str, String str2, String str3, Map map, int i, Object obj) {
        if ((i & 16) != 0) {
            map = null;
        }
        nestBdManager.init(context, str, str2, str3, map);
    }

    public final boolean getDebug() {
        return debug;
    }

    public final Map<String, String> getIdMapBaidu() {
        return idMapBaidu;
    }

    public final boolean getInitDone() {
        return initDone;
    }

    public final String getVersion() {
        return "";
    }

    public final void init(@NonNull Context context, @NonNull String adProviderType, @NonNull String appId, @NonNull String appName, Map<String, String> baiduIdMap) {
    }

    public final void setDebug(boolean z) {
        debug = z;
    }

    public final void setIdMapBaidu(Map<String, String> map) {
        idMapBaidu = map;
    }

    public final void setInitDone(boolean z) {
        initDone = z;
    }

    public final void init(@NonNull Context context, @NonNull String adProviderType, @NonNull String appId, @NonNull String appName) {
        init(context, adProviderType, appId, appName, null);
    }

    public final void updatePersonAd(boolean enablePersonal) {
    }
}
