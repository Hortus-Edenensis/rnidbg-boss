package com.kwad.sdk.core.network;

import android.text.TextUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class q {
    private static volatile q aJX;
    private final Map<String, String> aIE = new ConcurrentHashMap();

    private q() {
    }

    public static q Jv() {
        if (aJX == null) {
            synchronized (q.class) {
                if (aJX == null) {
                    aJX = new q();
                }
            }
        }
        return aJX;
    }

    public final void V(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.aIE.put(str, str2);
    }

    public final String en(String str) {
        return this.aIE.get(str);
    }
}
