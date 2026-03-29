package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class RequestFuture<T> implements Future<T>, Response.Listener<T>, Response.ErrorListener {
    private VolleyError mException;
    private Request<?> mRequest;
    private T mResult;
    private boolean mResultReceived = false;

    private RequestFuture() {
    }

    private synchronized T doGet(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.mException != null) {
            throw new ExecutionException(this.mException);
        }
        if (this.mResultReceived) {
            return this.mResult;
        }
        LogUtil.i("RequestFuture", "doGet start timeoutMs=" + l + this.mRequest);
        if (l == null) {
            wait(0L);
        } else if (l.longValue() > 0) {
            wait(l.longValue());
        }
        LogUtil.i("RequestFuture", "doGet enter");
        if (this.mException != null) {
            throw new ExecutionException(this.mException);
        }
        if (this.mResultReceived) {
            return this.mResult;
        }
        if (this.mRequest != null) {
            LogUtil.i("RequestFuture", LogUtil.LogType.LOG_TYPE_BACKGROUND_NETWORK, 3, new HashMap<String, Object>() { // from class: com.android.volley.toolbox.RequestFuture.1
                {
                    put("action", LogUtil.NETWORK_LOG);
                    put("status", "RequestFutureTimeoutException");
                    put("error", "RequestFuture_TimeoutException");
                    put("url", RequestFuture.this.mRequest.getUrl());
                }
            }, (Throwable) null);
            LogUtil.i("RequestFuture", "doGet prepare timeout");
            this.mRequest.cancel();
            try {
                Response<?> networkResponseFromCacheEntry = this.mRequest.getNetworkResponseFromCacheEntry();
                if (networkResponseFromCacheEntry != null) {
                    LogUtil.i("RequestFuture", "doGet hit cache");
                    return networkResponseFromCacheEntry.result;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        throw new TimeoutException();
    }

    public static <E> RequestFuture<E> newFuture() {
        return new RequestFuture<>();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (this.mRequest == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.mRequest.cancel();
        return true;
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        try {
            return doGet(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Request<?> request = this.mRequest;
        if (request == null) {
            return false;
        }
        return request.isCanceled();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0012  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isDone() {
        boolean z;
        if (this.mResultReceived || this.mException != null) {
            z = true;
        } else if (!isCancelled()) {
            z = false;
        }
        return z;
    }

    @Override // com.android.volley.Response.ErrorListener
    public synchronized void onErrorResponse(VolleyError volleyError) {
        this.mException = volleyError;
        notifyAll();
    }

    @Override // com.android.volley.Response.Listener
    public synchronized void onResponse(T t) {
        this.mResultReceived = true;
        this.mResult = t;
        notifyAll();
    }

    public void setRequest(Request<?> request) {
        this.mRequest = request;
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return doGet(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    public T get(Request request) throws ExecutionException, InterruptedException, TimeoutException {
        setRequest(request);
        int currentTimeout = request.getRetryPolicy().getCurrentTimeout() * Math.max(2, request.getRetryPolicy().getMaxRetryCount());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return doGet(Long.valueOf(timeUnit.convert(currentTimeout, timeUnit)));
    }
}
