package com.android.volley;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface RetryPolicy {
    int getCurrentRetryCount();

    int getCurrentTimeout();

    int getMaxRetryCount();

    void retry(VolleyError volleyError) throws VolleyError;
}
