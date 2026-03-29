package com.opos.mobad.service;

import android.os.SystemClock;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9238a = 1;
    private JSONObject b;
    private long c;
    private long d;
    private String e;

    public g(String str) {
        this.e = str;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.d = jElapsedRealtime;
        this.c = jElapsedRealtime;
        this.b = new JSONObject();
    }

    private String a(int i, String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.e)) {
            sb.append(this.e);
            sb.append("-");
        }
        sb.append(i);
        if (!TextUtils.isEmpty(str)) {
            sb.append("-");
            sb.append(str);
        }
        return sb.toString();
    }

    public String toString() {
        return a().toString();
    }

    private JSONObject a() {
        try {
            this.b.put(a(0, "all"), SystemClock.elapsedRealtime() - this.c);
        } catch (JSONException unused) {
        }
        return this.b;
    }
}
