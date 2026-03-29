package com.android.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import com.android.volley.Cache;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.aw;
import defpackage.g13;
import java.util.concurrent.BlockingQueue;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class NetworkDispatcher extends g13 {
    private final Cache mCache;
    private final ResponseDelivery mDelivery;
    private final Network mNetwork;
    private final BlockingQueue<Request<?>> mQueue;
    private volatile boolean mQuit = false;

    public NetworkDispatcher(BlockingQueue<Request<?>> blockingQueue, Network network, Cache cache, ResponseDelivery responseDelivery) {
        this.mQueue = blockingQueue;
        this.mNetwork = network;
        this.mCache = cache;
        this.mDelivery = responseDelivery;
    }

    @TargetApi(14)
    private void addTrafficStatsTag(Request<?> request) {
        TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
    }

    private void fixNetworkErrorWithCache(Request<?> request, VolleyError volleyError) {
        if (request.queryCacheOnRequestError()) {
            Cache.Entry entry = this.mCache.get(request.getCacheKey());
            if (entry != null) {
                Response<?> networkResponse = request.parseNetworkResponse(new NetworkResponse(entry.data, entry.responseHeaders));
                request.addMarker("cache-hit-parsed-on-error");
                LogUtil.i("NetCache", "parseAndDeliverNetworkError hit cache key=" + request.getCacheKey());
                request.markDelivered();
                this.mDelivery.postResponse(request, networkResponse);
                return;
            }
            LxRetryCacheHelper.logCacheFail(request);
        }
        this.mDelivery.postError(request, volleyError);
    }

    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        aw cacheConfig;
        Cache.Entry entry;
        Process.setThreadPriority(10);
        while (true) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                Request<?> requestTake = this.mQueue.take();
                try {
                    requestTake.addMarker("network-queue-take");
                    if (requestTake.isCanceled()) {
                        requestTake.finish("network-discard-cancelled");
                    } else {
                        addTrafficStatsTag(requestTake);
                        NetworkResponse networkResponsePerformRequest = this.mNetwork.performRequest(requestTake);
                        requestTake.addMarker("network-http-complete");
                        if (networkResponsePerformRequest.notModified && requestTake.hasHadResponseDelivered()) {
                            requestTake.finish("not-modified");
                        } else {
                            Response<?> networkResponse = requestTake.parseNetworkResponse(networkResponsePerformRequest);
                            requestTake.addMarker("network-parse-complete");
                            if (requestTake.shouldCache()) {
                                if (networkResponse.cacheEntry != null) {
                                    this.mCache.put(requestTake.getCacheKey(), networkResponse.cacheEntry);
                                    requestTake.addMarker("network-cache-written");
                                }
                                if ((networkResponse.result instanceof JSONObject) && (cacheConfig = requestTake.getCacheConfig()) != null && !cacheConfig.e((JSONObject) networkResponse.result) && (entry = this.mCache.get(requestTake.getCacheKey())) != null) {
                                    networkResponse = requestTake.parseNetworkResponse(new NetworkResponse(entry.data, entry.responseHeaders));
                                    requestTake.addMarker("cache-hit-parsed-on-request-success-withFix");
                                }
                            }
                            requestTake.markDelivered();
                            this.mDelivery.postResponse(requestTake, networkResponse);
                        }
                    }
                } catch (VolleyError e) {
                    e.setNetworkTimeMs(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    fixNetworkErrorWithCache(requestTake, requestTake.parseNetworkError(e));
                } catch (Exception e2) {
                    VolleyLog.e(e2, "Unhandled exception %s", e2.toString());
                    VolleyError volleyError = new VolleyError(e2);
                    volleyError.setNetworkTimeMs(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    fixNetworkErrorWithCache(requestTake, volleyError);
                }
            } catch (InterruptedException unused) {
                if (this.mQuit) {
                    return;
                }
            }
        }
    }
}
