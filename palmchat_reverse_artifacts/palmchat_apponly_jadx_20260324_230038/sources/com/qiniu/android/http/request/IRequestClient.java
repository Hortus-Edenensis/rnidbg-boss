package com.qiniu.android.http.request;

import com.qiniu.android.http.ProxyConfiguration;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.metrics.UploadSingleRequestMetrics;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class IRequestClient {

    /* JADX INFO: compiled from: SearchBox */
    public interface CompleteHandler {
        void complete(ResponseInfo responseInfo, UploadSingleRequestMetrics uploadSingleRequestMetrics, JSONObject jSONObject);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface Progress {
        void progress(long j, long j2);
    }

    public abstract void cancel();

    public abstract void request(Request request, boolean z, ProxyConfiguration proxyConfiguration, Progress progress, CompleteHandler completeHandler);
}
