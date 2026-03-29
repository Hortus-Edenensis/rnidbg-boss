package com.bykv.vk.component.ttvideo.medialoader;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface MediaLoaderListener {
    long getInt64Value(int i, long j);

    void onDataLoaderError(int i, String str);

    void onLogInfo(int i, String str, JSONObject jSONObject);

    void onNotify(int i, long j, long j2, String str);

    void onSwitchLoaderType(int i, String str);
}
