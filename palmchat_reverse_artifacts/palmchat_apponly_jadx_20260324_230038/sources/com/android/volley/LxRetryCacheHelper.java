package com.android.volley;

import android.net.Uri;
import com.android.volley.Cache;
import com.cdo.oaps.ad.OapsWrapper;
import defpackage.aw;
import defpackage.zn6;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class LxRetryCacheHelper {
    public static void fixEntryWithCacheConfig(Cache.Entry entry, aw awVar) {
        if (entry == null || awVar == null) {
            return;
        }
        long j = awVar.b;
        if (entry.maxAge <= 0 && j > 0) {
            entry.maxAge = j;
        }
        entry.softTtl = System.currentTimeMillis() + awVar.c;
    }

    private static String getPath(Request request) {
        try {
            String url = request.getUrl();
            if (url != null) {
                return Uri.parse(url).getPath();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void logCacheFail(Request request) {
        String path = getPath(request);
        HashMap map = new HashMap();
        map.put(OapsWrapper.KEY_PATH, path);
        zn6.i("request_cache_fail", map);
    }

    public static void logCacheHitSuccess(Request request) {
        String path = getPath(request);
        HashMap map = new HashMap();
        map.put(OapsWrapper.KEY_PATH, path);
        zn6.i("request_cache_hit_return_success", map);
    }

    public static boolean needRetry() {
        return true;
    }
}
