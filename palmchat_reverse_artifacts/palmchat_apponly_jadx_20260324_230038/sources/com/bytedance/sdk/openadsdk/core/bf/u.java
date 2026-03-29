package com.bytedance.sdk.openadsdk.core.bf;

import android.os.Build;
import com.bytedance.sdk.openadsdk.core.bf.u.fx;
import com.bytedance.sdk.openadsdk.core.bf.u.nr;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.fx.b;
import com.bytedance.sdk.openadsdk.core.n;
import com.huawei.openalliance.ad.constant.bq;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static u u = new u();
    private volatile int nr = -1;
    private volatile long fx = 0;
    private volatile long b = 0;

    private u() {
    }

    public static u u() {
        return u;
    }

    public void b() {
        JSONObject jSONObjectTr = dw.nr().tr();
        if (jSONObjectTr == null) {
            this.nr = 1;
        }
        if (u(jSONObjectTr)) {
            new fx().u(jSONObjectTr, this.nr);
        } else if (nr(jSONObjectTr)) {
            new nr().u(jSONObjectTr, this.nr);
        } else {
            this.nr = 1;
        }
    }

    public long fx() {
        return this.b;
    }

    public int iz() {
        if (!n.o().pn()) {
            return 0;
        }
        if (this.nr == -1) {
            int iBq = b.u().bq();
            if (iBq != -1) {
                this.nr = iBq;
            } else if (dw.nr().tr() == null) {
                this.nr = 1;
            } else {
                this.nr = 2;
            }
        }
        return this.nr;
    }

    public long nr() {
        return this.fx;
    }

    public boolean pn() {
        return this.nr == 0 || this.nr == 3;
    }

    public boolean nr(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray(bq.f.L)) != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                if (u(jSONArrayOptJSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void u(long j, long j2) {
        this.fx = j;
        this.b = j2;
    }

    public boolean u(String str) {
        String str2 = Build.MANUFACTURER;
        String str3 = Build.BRAND;
        if (str2 != null && str3 != null) {
            return str2.equalsIgnoreCase(str) || str3.equalsIgnoreCase(str);
        }
        if (str2 != null) {
            return str2.equalsIgnoreCase(str);
        }
        if (str3 != null) {
            return str3.equalsIgnoreCase(str);
        }
        return false;
    }

    public void u(int i) {
        if (this.nr != i) {
            b.u().iz(i);
        }
        this.nr = i;
    }

    public boolean u(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("register")) != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                if (u(jSONArrayOptJSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
