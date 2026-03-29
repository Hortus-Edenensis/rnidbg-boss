package com.oplus.tblplayer.monitor.sdk;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.oplus.tblplayer.config.Globals;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class CacheInfoGetter {
    public static long getCachedBytes(@Nullable String str, Uri uri) {
        Globals.getGlobalPreCache();
        if (str != null) {
            return 0L;
        }
        uri.toString();
        return 0L;
    }
}
