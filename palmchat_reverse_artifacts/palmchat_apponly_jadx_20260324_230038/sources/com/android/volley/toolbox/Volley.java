package com.android.volley.toolbox;

import android.content.Context;
import com.android.volley.RequestQueue;
import defpackage.b13;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class Volley {
    private static final String DEFAULT_CACHE_DIR = "volley";

    public static String getUserAgent() {
        return b13.d();
    }

    public static RequestQueue newCoreRequestQueue(Context context) {
        File file = new File(context.getCacheDir(), "volley-core");
        RequestQueue requestQueue = new RequestQueue(new DiskBasedCache(file), new BasicNetwork(new HurlStack()), 1);
        requestQueue.start();
        return requestQueue;
    }

    public static RequestQueue newRequestQueue(Context context, HttpStack httpStack) {
        File file = new File(context.getCacheDir(), DEFAULT_CACHE_DIR);
        if (httpStack == null) {
            httpStack = new HurlStack();
        }
        RequestQueue requestQueue = new RequestQueue(new DiskBasedCache(file), new BasicNetwork(httpStack));
        requestQueue.start();
        return requestQueue;
    }

    public static RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, null);
    }
}
