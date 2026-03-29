package com.zenmen.palmchat.network;

import android.content.Context;
import android.os.Build;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.messaging.CreateConnectionDelegate;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.b13;
import defpackage.g13;
import defpackage.k86;
import defpackage.st3;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class VolleyNetwork {
    private static RequestQueue mCoreRequestQueue;
    private static RequestQueue mRequestQueue;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                st3.e(false);
                new CreateConnectionDelegate().e(AccountUtils.p(AppContext.getContext()), AccountUtils.o(AppContext.getContext()), AccountUtils.m(AppContext.getContext()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private VolleyNetwork() {
    }

    public static String buildUserAgent(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(reformatInfo(Build.BRAND));
        sb.append("/");
        sb.append(reformatInfo(Build.MODEL));
        sb.append("/");
        sb.append("Android/");
        sb.append(reformatInfo(Build.VERSION.RELEASE));
        sb.append("/");
        sb.append(ac1.f);
        sb.append("/");
        sb.append(ac1.g);
        sb.append("/");
        sb.append(Locale.getDefault().toString());
        sb.append("/");
        float f = context.getResources().getDisplayMetrics().density;
        int i = (int) f;
        if (f - i > 0.0f) {
            sb.append(f);
        } else {
            sb.append(i);
        }
        sb.append("x/");
        sb.append(ac1.m);
        sb.append("/");
        sb.append(reformatInfo(ac1.f1194a));
        return sb.toString();
    }

    public static RequestQueue getNormalRequestQueue() {
        RequestQueue requestQueue = mRequestQueue;
        if (requestQueue != null) {
            return requestQueue;
        }
        throw new IllegalStateException("RequestQueue not initialized");
    }

    public static RequestQueue getRequestQueue() {
        RequestQueue requestQueue = mCoreRequestQueue;
        if (requestQueue != null) {
            return requestQueue;
        }
        throw new IllegalStateException("RequestQueue not initialized");
    }

    public static void init(Context context) {
        setUserAgent(context);
        mRequestQueue = Volley.newRequestQueue(context);
        RequestQueue requestQueueNewCoreRequestQueue = Volley.newCoreRequestQueue(context);
        mCoreRequestQueue = requestQueueNewCoreRequestQueue;
        requestQueueNewCoreRequestQueue.setCore();
        String strM = k86.m(context);
        String packageName = context.getPackageName();
        LogUtil.i("VolleyNetwork", "init " + strM);
        if (packageName != null && packageName.equals(strM) && AccountUtils.r(context)) {
            new g13(new a()).start();
        }
    }

    private static String reformatInfo(String str) {
        return str != null ? str.replace("/", "_") : "unknown";
    }

    public static void setUserAgent(Context context) {
        b13.g(context);
    }
}
