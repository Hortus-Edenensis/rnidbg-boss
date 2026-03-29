package com.kwad.sdk.core.config;

import android.text.TextUtils;
import java.net.URI;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    private static final String[] aDc = {"gifshow.com", "kuaishou.com", "static.yximgs.com"};

    public static boolean cs(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URI(str).getHost();
            if (dJ(host)) {
                return true;
            }
            return dK(host);
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean dJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : aDc) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dK(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = e.GO().iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }
}
