package com.qiniu.android.bigdata.client;

import com.qiniu.android.http.ResponseInfo;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface CompletionHandler {
    void complete(ResponseInfo responseInfo, JSONObject jSONObject);
}
