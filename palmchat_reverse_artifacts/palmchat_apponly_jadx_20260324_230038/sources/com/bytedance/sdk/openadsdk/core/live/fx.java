package com.bytedance.sdk.openadsdk.core.live;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    public static String u(Uri uri, String str) {
        return (uri == null || !uri.isHierarchical() || str == null) ? "" : uri.getQueryParameter(str);
    }

    public static Uri u(Uri uri, Map<String, String> map) {
        if (uri == null || map == null || map.size() <= 0) {
            return uri;
        }
        try {
            Uri.Builder builderBuildUpon = uri.buildUpon();
            for (String str : map.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    builderBuildUpon.appendQueryParameter(str, map.get(str));
                }
            }
            return builderBuildUpon.build();
        } catch (Exception unused) {
            return uri;
        }
    }
}
