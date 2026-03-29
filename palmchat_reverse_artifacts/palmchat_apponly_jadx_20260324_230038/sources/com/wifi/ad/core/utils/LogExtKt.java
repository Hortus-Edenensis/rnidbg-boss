package com.wifi.ad.core.utils;

import android.util.Log;
import com.wifi.ad.core.TogetherAd;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u001a\u0016\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u001a\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"logd", "", "", "tag", "loge", "logi", "logv", "logw", "core_release"}, k = 2, mv = {1, 1, 16})
public final class LogExtKt {
    public static final void logd(String str, String str2) {
        if (TogetherAd.INSTANCE.getPrintLogEnable()) {
            Log.d(str2, str);
        }
    }

    public static /* synthetic */ void logd$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "TogetherAd";
        }
        logd(str, str2);
    }

    public static final void loge(String str, String str2) {
        if (TogetherAd.INSTANCE.getPrintLogEnable()) {
            Log.e(str2, str);
        }
    }

    public static /* synthetic */ void loge$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "TogetherAd";
        }
        loge(str, str2);
    }

    public static final void logi(String str, String str2) {
        if (TogetherAd.INSTANCE.getPrintLogEnable()) {
            Log.i(str2, str);
        }
    }

    public static /* synthetic */ void logi$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "TogetherAd";
        }
        logi(str, str2);
    }

    public static final void logv(String str, String str2) {
        if (TogetherAd.INSTANCE.getPrintLogEnable()) {
            Log.v(str2, str);
        }
    }

    public static /* synthetic */ void logv$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "TogetherAd";
        }
        logv(str, str2);
    }

    public static final void logw(String str, String str2) {
        if (TogetherAd.INSTANCE.getPrintLogEnable()) {
            Log.w(str2, str);
        }
    }

    public static /* synthetic */ void logw$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "TogetherAd";
        }
        logw(str, str2);
    }
}
