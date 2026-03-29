package com.baidu.platform.comapi.d;

import com.baidu.platform.comapi.logstatistics.LogStatistics;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static JSONObject f4135a;
    public static a b;
    private LogStatistics c = null;

    public static a a() {
        if (b == null) {
            b = new a();
        }
        if (f4135a == null) {
            f4135a = new JSONObject();
        }
        return b;
    }

    private void b() {
        f4135a = null;
        f4135a = new JSONObject();
    }

    public synchronized boolean a(String str) {
        boolean zA;
        if (this.c == null) {
            this.c = LogStatistics.getInstance();
        }
        if (this.c != null) {
            JSONObject jSONObject = f4135a;
            if (jSONObject != null && jSONObject.length() > 0) {
                zA = this.c.a(1100, 1, str, f4135a.toString());
            } else {
                zA = this.c.a(1100, 1, str, (String) null);
            }
            b();
        } else {
            zA = false;
        }
        return zA;
    }
}
