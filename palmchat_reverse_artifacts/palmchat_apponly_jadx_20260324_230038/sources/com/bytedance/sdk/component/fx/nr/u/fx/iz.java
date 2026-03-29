package com.bytedance.sdk.component.fx.nr.u.fx;

import com.android.volley.toolbox.HttpClientStack;
import com.baidu.mapapi.http.wrapper.HttpManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class iz {
    public static boolean b(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean fx(String str) {
        return nr(str) || str.equals("OPTIONS") || str.equals(HttpManager.HTTP_DELETE) || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }

    public static boolean nr(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals(HttpClientStack.HttpPatch.METHOD_NAME) || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean pn(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean u(String str) {
        return str.equals("POST") || str.equals(HttpClientStack.HttpPatch.METHOD_NAME) || str.equals("PUT") || str.equals(HttpManager.HTTP_DELETE) || str.equals("MOVE");
    }
}
