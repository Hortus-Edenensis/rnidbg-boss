package com.zenmen.palmchat.location;

import com.amap.api.services.core.AMapException;
import com.zenmen.palmchat.location.LxMapServiceRetryConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AliMapConfig f14364a;
    public static LxMapServiceRetryConfig b;

    public static int a(LocationScene locationScene) {
        int i;
        boolean zD = d(locationScene);
        int i2 = zD ? 0 : AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
        LxMapServiceRetryConfig lxMapServiceRetryConfigC = c();
        LxMapServiceRetryConfig.RetryConfig retryConfig = zD ? lxMapServiceRetryConfigC.scene_1 : lxMapServiceRetryConfigC.scene_2;
        return (retryConfig == null || (i = retryConfig.location_cache_interval) <= 0) ? i2 : i;
    }

    public static AliMapConfig b() {
        if (f14364a == null) {
            f14364a = AliMapConfig.initSearchConfig();
        }
        return f14364a;
    }

    public static LxMapServiceRetryConfig c() {
        if (b == null) {
            b = LxMapServiceRetryConfig.initConfig();
        }
        return b;
    }

    public static boolean d(LocationScene locationScene) {
        return locationScene == LocationScene.FIND_MAP || locationScene == LocationScene.CHAT_SEND_LOCATION;
    }
}
