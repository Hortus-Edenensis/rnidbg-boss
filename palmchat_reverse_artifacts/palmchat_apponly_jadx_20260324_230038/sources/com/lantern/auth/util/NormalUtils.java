package com.lantern.auth.util;

import android.content.Context;
import android.text.TextUtils;
import com.lantern.auth.app.AuthUtils;
import com.lantern.auth.server.WkPlatform;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class NormalUtils {
    public static String getNetworkType(Context context) {
        String networkType = WkPlatform.getNetworkType(context);
        return (!TextUtils.isEmpty(networkType) && RXScreenCaptureService.KEY_WIDTH.equals(networkType) && AuthUtils.isMobileDataOpen(context)) ? "wg" : networkType;
    }
}
