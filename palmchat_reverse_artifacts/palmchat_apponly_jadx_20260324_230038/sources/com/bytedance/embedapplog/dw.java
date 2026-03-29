package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class dw {
    private final gi u;
    private long nr = 5000;
    private long fx = 1800000;
    private final Map<String, JSONObject> b = new HashMap();
    private final Map<String, JSONObject> pn = new HashMap();
    private String iz = "";
    private final ReentrantLock x = new ReentrantLock();

    public dw(Context context, gi giVar) {
        this.u = giVar;
        nr(gb.nr(context).getString("d_data", ""));
    }

    private boolean fx(JSONObject jSONObject) {
        if (jSONObject.optString("message", "").equals(com.igexin.push.core.b.B)) {
            return true;
        }
        bg.u("__kite", "error response");
        return false;
    }

    private void nr(String str) {
        if (!this.b.isEmpty() && !this.pn.isEmpty()) {
            bg.fx("__kite", " map is empty");
            return;
        }
        byte[] bArrClientUnpackedBase64 = TTEncryptUtils.clientUnpackedBase64(str);
        if (bArrClientUnpackedBase64 == null || bArrClientUnpackedBase64.length == 0) {
            bg.fx("__kite", "parse is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArrClientUnpackedBase64));
            if (bg.nr()) {
                bg.u("__kite", " data:".concat(String.valueOf(jSONObject)));
            }
            this.iz = jSONObject.optString("version", "");
            u(jSONObject, "fields", this.b);
            int iOptInt = jSONObject.optInt("delay_sec", 0);
            if (iOptInt > 0) {
                this.nr = ((long) iOptInt) * 1000;
            }
            int iOptInt2 = jSONObject.optInt("dtrait_mem_ttl_sec", 0);
            if (iOptInt2 > 0) {
                this.fx = ((long) iOptInt2) * 1000;
            }
            u(jSONObject, "dtrait_fields", this.pn);
            if (bg.nr()) {
                bg.u("__kite" + String.format("parseConfigFields# fields: status_collect delay time:%s, dtraitExpireTime:%s", Long.valueOf(this.nr), Long.valueOf(this.fx)));
            }
        } catch (Exception e) {
            bg.nr("__kiteparseConfigFields# error: " + e.getMessage());
        }
    }

    private void u(String str) {
        this.u.nr("d_data", str);
        this.u.u("d_data", str);
    }

    private void u(JSONObject jSONObject, String str, Map<String, JSONObject> map) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(i);
            map.put(jSONObject2.optString("name"), jSONObject2);
        }
    }

    public long fx() {
        return this.nr;
    }

    public void u(JSONObject jSONObject) {
        this.x.lock();
        try {
            try {
                if (!fx(jSONObject)) {
                    bg.fx("__kite", "invalid response");
                } else {
                    String strOptString = jSONObject.optString("data");
                    if (TextUtils.isEmpty(strOptString)) {
                        bg.fx("__kite", "response is empty");
                    } else {
                        u(strOptString);
                        nr(strOptString);
                        if (bg.nr()) {
                            bg.u("__kiteconfig parse success");
                        }
                    }
                }
            } catch (Exception e) {
                bg.nr("__kiteerror" + e.getMessage());
            }
        } finally {
            this.x.unlock();
        }
    }

    public void nr(JSONObject jSONObject) {
        try {
            if (fx(jSONObject)) {
                String strOptString = jSONObject.optString("data");
                if (TextUtils.isEmpty(strOptString)) {
                    bg.u("__kite", "data is null");
                    return;
                }
                u(strOptString);
                nr(strOptString);
                bg.u("__kitesuccess");
            }
        } catch (Exception e) {
            bg.nr("__kiteerror " + e.getMessage());
        }
    }

    public Map<String, JSONObject> u() {
        return this.b;
    }

    public String nr() {
        return this.iz;
    }
}
