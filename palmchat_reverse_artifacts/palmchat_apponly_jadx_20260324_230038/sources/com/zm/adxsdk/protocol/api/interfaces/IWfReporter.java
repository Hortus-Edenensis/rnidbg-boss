package com.zm.adxsdk.protocol.api.interfaces;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IWfReporter {
    String getOaid();

    void initOaidGet(Context context, boolean z);

    void onEvent(String str);

    void onEvent(String str, Map<String, Object> map);

    void onEvent(String str, JSONObject jSONObject);
}
