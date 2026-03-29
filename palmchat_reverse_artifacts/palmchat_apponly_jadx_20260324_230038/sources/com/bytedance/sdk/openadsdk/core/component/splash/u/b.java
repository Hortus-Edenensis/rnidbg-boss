package com.bytedance.sdk.openadsdk.core.component.splash.u;

import android.text.TextUtils;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz;
import com.bytedance.sdk.openadsdk.core.component.splash.u.u;
import com.bytedance.sdk.openadsdk.core.component.splash.x;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.lf;
import com.bytedance.sdk.openadsdk.core.kj.n;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.y.bf;
import com.bytedance.sdk.openadsdk.core.y.jp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends com.bytedance.sdk.openadsdk.core.component.splash.u.u {
    private nr x;
    private volatile com.bytedance.sdk.component.b.nr.fx n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.component.b.nr.fx f5272a = bf.u(nr("tt_materialMeta"));

    /* JADX INFO: compiled from: SearchBox */
    public class nr extends a {
        private lf nr;

        public nr(lf lfVar) {
            super("WriteCacheTask");
            this.nr = lfVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            u();
        }

        public void u(lf lfVar) {
            this.nr = lfVar;
        }

        private void u() {
            try {
                int iU = x.u(this.nr);
                if (iU <= 0) {
                    return;
                }
                String str = b.this.f5272a.get("net_ad_already_shown", "");
                if (!TextUtils.isEmpty(str) && str.equals(this.nr.u().xx())) {
                    com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "该缓存已show-则不再save： rit: " + iU + "   reqId: " + this.nr.u().xx());
                    return;
                }
                JSONObject jSONObjectFx = this.nr.nr().fx();
                if (jSONObjectFx != null) {
                    b.this.f5272a.put("materialMeta".concat(String.valueOf(iU)), jSONObjectFx.toString());
                }
                b.this.f5272a.put("net_ad_save_success".concat(String.valueOf(iU)), this.nr.u().xx());
                com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "缓存成功： rit: " + iU + "   reqId: " + this.nr.u().xx());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        boolean u = true;
        long nr = 0;
        long fx = 0;
        long b = 0;
    }

    private boolean b(final String str) {
        final u uVarFx = fx(str);
        if (uVarFx.u) {
            s.u().x(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.u.b.1
                @Override // com.bytedance.sdk.openadsdk.t.u.u
                public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                    u uVar = uVarFx;
                    long j = uVar.b - uVar.nr;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("available_type", 0);
                    jSONObject.putOpt("creative_timeout_duration", Long.valueOf(j / 3600));
                    return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u(4).fx(str).nr(jSONObject.toString());
                }
            });
        }
        pn pnVar = this.iz;
        long j = pnVar == null ? 0L : pnVar.u;
        if (j <= 0 || uVarFx.nr * 1000 >= j) {
            return uVarFx.u;
        }
        return true;
    }

    private u fx(String str) {
        u uVar = new u();
        if (TextUtils.isEmpty(str)) {
            return uVar;
        }
        com.bytedance.sdk.component.b.nr.fx fxVarPn = pn();
        long j = fxVarPn.get("expiration" + str, 0L);
        long j2 = fxVarPn.get("update" + str, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        uVar.u = jCurrentTimeMillis < j2 || jCurrentTimeMillis >= j;
        uVar.nr = j2;
        uVar.fx = j;
        uVar.b = jCurrentTimeMillis;
        return uVar;
    }

    private com.bytedance.sdk.openadsdk.core.kj.u iz(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.f5272a.get("materialMeta" + str, (String) null);
        if (!TextUtils.isEmpty(str2)) {
            try {
                kj.u uVarU = kj.u.u(new JSONObject(str2));
                if (uVarU != null) {
                    com.bytedance.sdk.openadsdk.core.kj.u uVar = uVarU.n;
                    if (uVar != null) {
                        return uVar;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private com.bytedance.sdk.component.b.nr.fx pn() {
        if (this.n == null) {
            this.n = bf.u(nr("tt_splash"));
        }
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.u.u
    public void nr() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.u.u
    public void u(String str, String str2, boolean z, boolean z2, Object obj) {
    }

    private String nr(String str) {
        n.nr nrVarU = n.u(3);
        return (nrVarU == null || nrVarU.n()) ? str + "_7232" : str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.u.u
    public void u(lf lfVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, boolean z) {
        int iU;
        if (lfVar != null && (iU = x.u(lfVar)) > 0) {
            u(iU, lfVar.u().qn());
            u(lfVar);
        }
    }

    private void pn(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.b.nr.fx fxVarPn = pn();
        this.f5272a.remove("materialMeta" + str);
        if (fxVarPn != null) {
            fxVarPn.remove("has_ad_cache" + str);
            fxVarPn.remove("expiration" + str);
        }
        com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "清除成功： rit: " + str);
    }

    private void u(lf lfVar) {
        nr nrVar = this.x;
        if (nrVar == null) {
            this.x = new nr(lfVar);
        } else {
            nrVar.u(lfVar);
        }
        com.bytedance.sdk.component.jk.x.u(this.x, 10);
    }

    public static void b() {
        dw.nr().de();
    }

    private void u(int i, long j) {
        com.bytedance.sdk.component.b.nr.fx fxVarPn = pn();
        fxVarPn.put("expiration" + i, j);
        fxVarPn.put("update" + i, System.currentTimeMillis() / 1000);
        fxVarPn.put("has_ad_cache" + i, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.u.u
    public void fx() {
        try {
            bf.u(nr("tt_materialMeta")).clear();
            bf.u(nr("tt_splash")).clear();
        } catch (Throwable unused) {
        }
    }

    private boolean u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x xVar, String str) {
        if (u(str)) {
            return true;
        }
        if (xVar != null) {
            xVar.b(0);
            xVar.nr(1);
            xVar.u("no cache");
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    @Override // com.bytedance.sdk.openadsdk.core.component.splash.u.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x xVar, String str, u.InterfaceC0257u interfaceC0257u, pn pnVar) {
        bc bcVar;
        if (TextUtils.isEmpty(str) || interfaceC0257u == null) {
            return;
        }
        this.iz = pnVar;
        if (!u(xVar, str)) {
            interfaceC0257u.u();
            return;
        }
        iz izVar = null;
        try {
            com.bytedance.sdk.openadsdk.core.kj.u uVarIz = iz(str);
            iz izVar2 = new iz(uVarIz, true);
            if (uVarIz != null) {
                try {
                    bcVar = (uVarIz.nr() == null || uVarIz.nr().isEmpty()) ? null : uVarIz.nr().get(0);
                    if (bcVar != null) {
                        izVar2.u(bcVar);
                    }
                } catch (Throwable unused) {
                }
                if (com.bytedance.sdk.openadsdk.core.live.nr.u().fx(bcVar) != 3) {
                    izVar = izVar2;
                } else {
                    izVar2.u((bc) null);
                }
            }
        } catch (Throwable unused2) {
        }
        interfaceC0257u.u(izVar);
        if (com.bytedance.sdk.openadsdk.core.fx.pn.u().jk()) {
            return;
        }
        pn(str);
    }

    public boolean u(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.bytedance.sdk.component.b.nr.fx fxVarPn = pn();
        StringBuilder sb = new StringBuilder("has_ad_cache");
        sb.append(str);
        return fxVarPn.get(sb.toString(), false) && !b(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.u.u
    public void u(com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.b<com.bytedance.sdk.openadsdk.core.component.splash.fx.u.a, com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x> bVar, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, boolean z) {
        if (bcVar == null) {
            return;
        }
        if (z) {
            this.f5272a.put("net_ad_already_shown", bcVar.xx());
        }
        if (this.pn.get()) {
            return;
        }
        String str = this.f5272a.get("net_ad_save_success" + jp.t(bcVar), "");
        if (TextUtils.isEmpty(str) || !str.equals(bcVar.xx())) {
            return;
        }
        this.pn.set(true);
        com.bytedance.sdk.openadsdk.core.x.u.u("lqmt", "计划清除缓存 reqId:  " + str);
        pn(nrVar != null ? nrVar.b() : null);
        if (bVar != null) {
            bVar.u();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.u.u
    public void u(String str, bc bcVar) {
        pn(str);
    }
}
