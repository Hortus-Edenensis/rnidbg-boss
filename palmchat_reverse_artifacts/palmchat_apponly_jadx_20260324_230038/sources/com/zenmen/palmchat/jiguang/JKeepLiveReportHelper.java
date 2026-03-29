package com.zenmen.palmchat.jiguang;

import android.text.TextUtils;
import defpackage.ap3;
import defpackage.zn6;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public enum JKeepLiveReportHelper {
    instance;

    public static final String EVENT_INIT_JIGUANG = "lx_client_jiguang_0";
    public static final String EVENT_RECEIVER_ALIVE = "lx_client_jiguang_1";
    public static final String EVENT_SEND_ALIVE = "lx_client_jiguang_2";
    private long processInitTime = System.currentTimeMillis();

    JKeepLiveReportHelper() {
    }

    public static JKeepLiveReportHelper getInstance() {
        return instance;
    }

    public void reportInit(int i) {
        HashMap map = new HashMap();
        map.put("result", Integer.valueOf(i));
        zn6.j(EVENT_INIT_JIGUANG, null, map);
    }

    public void reportReceiver(String str, int i) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.processInitTime;
        int i2 = jCurrentTimeMillis < 2000 ? 1 : 0;
        ap3.a().Z("from_jiguang");
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str)) {
            str = "unKnow";
        }
        map.put("package", str);
        map.put("wake_type", Integer.valueOf(i));
        map.put("processState", Integer.valueOf(i2));
        map.put("timeSpace", Long.valueOf(jCurrentTimeMillis));
        zn6.j(EVENT_RECEIVER_ALIVE, null, map);
    }

    public void reportSend(JSONObject jSONObject) {
        zn6.f(EVENT_SEND_ALIVE, null, jSONObject);
    }
}
