package com.bytedance.sdk.openadsdk.core.kj;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.core.pn.fx;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class oa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5318a;
    public int b;
    private fx.u bg;
    public int fx;
    public long jk;
    public Bundle k;
    public int my;
    public String nr;
    public String o;
    public long t;
    private String sx = com.bytedance.sdk.openadsdk.core.y.jp.n();
    public int u = -1;
    public JSONArray pn = null;
    public int iz = 1;
    public long x = System.currentTimeMillis();
    public long n = System.currentTimeMillis();
    public JSONObject l = null;
    public int mv = -1;
    public com.bytedance.sdk.openadsdk.core.q s = com.bytedance.sdk.openadsdk.core.q.u("");

    public String nr() {
        return this.sx;
    }

    public oa u() {
        oa oaVar = new oa();
        oaVar.u = this.u;
        oaVar.pn = this.pn;
        oaVar.iz = this.iz;
        oaVar.x = this.x;
        oaVar.f5318a = this.f5318a;
        oaVar.jk = this.jk;
        oaVar.t = this.t;
        oaVar.mv = this.mv;
        return oaVar;
    }

    public void u(String str) {
        this.sx = str;
    }

    public void u(String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.q qVar;
        if (!z || (qVar = this.s) == null || str == null) {
            return;
        }
        qVar.nr("cst_".concat(str));
    }

    public void u(String str, long j, boolean z) {
        com.bytedance.sdk.openadsdk.core.q qVar;
        if (!z || (qVar = this.s) == null || str == null) {
            return;
        }
        qVar.u("cst_".concat(str), j);
    }

    public void u(int i, String str, int i2) {
        this.bg = new fx.u(i, str, i2, System.currentTimeMillis());
    }

    public void u(Object obj, int i) {
        int size = obj != null ? 1 : 0;
        try {
            if (obj instanceof List) {
                size = ((List) obj).size();
            }
        } catch (Exception unused) {
        }
        fx.u uVar = this.bg;
        if (uVar != null) {
            uVar.u(size);
            com.bytedance.sdk.openadsdk.core.pn.fx.u(this.bg, i);
            this.bg = null;
        }
    }
}
