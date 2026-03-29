package com.android.volley;

import android.text.TextUtils;
import android.util.Pair;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class VolleyError extends Exception {
    public final NetworkResponse networkResponse;
    private long networkTimeMs;

    public VolleyError() {
        this.networkResponse = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, String> getExceptionCodeAndMessage(Exception exc) {
        int i;
        String string = "";
        if (exc instanceof VolleyError) {
            VolleyError volleyError = (VolleyError) exc;
            NetworkResponse networkResponse = volleyError.networkResponse;
            if (networkResponse != null) {
                i = networkResponse.statusCode;
                try {
                    string = new String(networkResponse.data);
                } catch (Exception unused) {
                }
            } else if (volleyError instanceof NetworkError) {
                i = -1009;
                string = "似乎已断开与互联网的连接。";
            } else if (volleyError instanceof TimeoutError) {
                i = -1001;
                string = "请求超时。";
            }
        } else {
            i = 0;
        }
        if (i == 0) {
            i = -123456;
        }
        if (TextUtils.isEmpty(string)) {
            string = exc.toString();
        }
        return new Pair<>(Integer.valueOf(i), string);
    }

    public long getNetworkTimeMs() {
        return this.networkTimeMs;
    }

    public void setNetworkTimeMs(long j) {
        this.networkTimeMs = j;
    }

    public VolleyError(NetworkResponse networkResponse) {
        this.networkResponse = networkResponse;
    }

    public VolleyError(String str) {
        super(str);
        this.networkResponse = null;
    }

    public VolleyError(String str, Throwable th) {
        super(str, th);
        this.networkResponse = null;
    }

    public VolleyError(Throwable th) {
        super(th);
        this.networkResponse = null;
    }
}
