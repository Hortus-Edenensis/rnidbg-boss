package com.qiniu.android.http.request.handler;

import com.qiniu.android.http.ResponseInfo;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface RequestShouldRetryHandler {
    boolean shouldRetry(ResponseInfo responseInfo, JSONObject jSONObject);
}
