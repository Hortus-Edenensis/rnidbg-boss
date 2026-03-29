package com.bytedance.sdk.openadsdk.core.fx;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm.common.utility.Logger;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.y.d;
import com.bytedance.sdk.openadsdk.core.y.jk;
import com.bytedance.sdk.openadsdk.core.y.kj;
import com.bytedance.sdk.openadsdk.core.y.t;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class fx {
    private static volatile fx nr;
    private SharedPreferences jk;
    private volatile boolean n;
    private AtomicBoolean u = new AtomicBoolean(false);
    private AtomicBoolean fx = new AtomicBoolean(false);
    private AtomicInteger b = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger pn = new AtomicInteger(Integer.MAX_VALUE);
    private volatile String iz = null;
    private AtomicInteger x = new AtomicInteger(Integer.MAX_VALUE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicInteger f5281a = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger t = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger l = new AtomicInteger(Integer.MAX_VALUE);

    private fx() {
    }

    private SharedPreferences l() {
        return com.bytedance.sdk.openadsdk.api.plugin.nr.nr(dw.getContext(), "sp_bidding_opt_libra", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mv() {
        boolean zFx = fx();
        if (zFx) {
            com.bytedance.sdk.openadsdk.core.component.splash.u.b.b();
            b.u();
            nr.u();
        }
        try {
            if (!com.bytedance.sdk.openadsdk.core.b.u.fx()) {
                String strU = u("/api/ad/union/ping");
                if (!TextUtils.isEmpty(strU)) {
                    com.bytedance.sdk.component.a.nr.fx fxVarFx = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().fx();
                    fxVarFx.u(strU);
                    fxVarFx.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.fx.fx.2
                        @Override // com.bytedance.sdk.component.a.u.u
                        public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                        }

                        @Override // com.bytedance.sdk.component.a.u.u
                        public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                        }
                    });
                }
            }
        } catch (Throwable unused) {
        }
        if (zFx) {
            t.u(3, false);
            u.u(dw.getContext(), 3);
            kj.iz();
            int i = com.bytedance.sdk.openadsdk.core.s.b.u;
            LogAdapter logAdapter = LogAdapter.u;
            s();
            d.u(259200000L);
        }
    }

    private void s() {
        com.bytedance.sdk.openadsdk.core.h.u uVar = new com.bytedance.sdk.openadsdk.core.h.u();
        jk.nr(uVar);
        jk.u();
        jk.b(uVar);
        jk.u(uVar);
        jk.pn(uVar);
        jk.fx(uVar);
        jk.b();
    }

    private boolean u(int i, int i2) {
        if (i2 == 0) {
            return false;
        }
        if (i2 == 1) {
            return true;
        }
        return i2 == 3 && i != 5;
    }

    public boolean a() {
        try {
            if (this.l.get() == Integer.MAX_VALUE) {
                if (this.u.get()) {
                    this.l.set(com.bytedance.sdk.component.x.fx.u.nr.u("sp_bidding_opt_libra", "boost_save_config", 0));
                } else {
                    if (this.jk == null) {
                        this.jk = l();
                    }
                    this.l.set(this.jk.getInt("boost_save_config", 0));
                }
                Logger.i("bstsdk", "isBstTwConf get: " + this.l.get());
            }
            return this.l.get() == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    public String b() {
        try {
            if (TextUtils.isEmpty(this.iz)) {
                if (this.u.get()) {
                    this.iz = com.bytedance.sdk.component.x.fx.u.nr.nr("sp_bidding_opt_libra", "key_url_ads", "api-access.pangolin-sdk-toutiao.com");
                } else {
                    if (this.jk == null) {
                        this.jk = l();
                    }
                    this.iz = this.jk.getString("key_url_ads", "api-access.pangolin-sdk-toutiao.com");
                }
            }
        } catch (Throwable unused) {
        }
        this.iz = TextUtils.isEmpty(this.iz) ? "api-access.pangolin-sdk-toutiao.com" : this.iz;
        return this.iz;
    }

    public boolean fx() {
        try {
            if (this.b.get() == Integer.MAX_VALUE) {
                if (this.u.get()) {
                    this.b.set(com.bytedance.sdk.component.x.fx.u.nr.u("sp_bidding_opt_libra", "key_req_body_opt", 1));
                } else {
                    if (this.jk == null) {
                        this.jk = l();
                    }
                    this.b.set(this.jk.getInt("key_req_body_opt", 1));
                }
            }
        } catch (Throwable unused) {
        }
        return this.b.get() == 1;
    }

    public int iz() {
        try {
            if (this.x.get() == Integer.MAX_VALUE) {
                if (this.u.get()) {
                    this.x.set(com.bytedance.sdk.component.x.fx.u.nr.u("sp_bidding_opt_libra", "key_network_module", 1));
                } else {
                    if (this.jk == null) {
                        this.jk = l();
                    }
                    this.x.set(this.jk.getInt("key_network_module", 1));
                }
            }
            return this.x.get();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public void jk() {
        try {
            com.bytedance.sdk.component.x.fx.u.nr.u("sp_bidding_opt_libra");
            SharedPreferences.Editor editorEdit = l().edit();
            editorEdit.clear();
            editorEdit.apply();
            this.b.set(0);
            this.pn.set(7);
            this.f5281a.set(0);
        } catch (Throwable unused) {
        }
    }

    public boolean n() {
        try {
            if (this.t.get() == Integer.MAX_VALUE) {
                if (this.u.get()) {
                    this.t.set(com.bytedance.sdk.component.x.fx.u.nr.u("sp_bidding_opt_libra", "_use_pl_", 0));
                } else {
                    if (this.jk == null) {
                        this.jk = l();
                    }
                    this.t.set(this.jk.getInt("_use_pl_", 0));
                }
            }
        } catch (Throwable unused) {
        }
        return this.t.get() == 1;
    }

    public int pn() {
        try {
            if (this.pn.get() == Integer.MAX_VALUE) {
                if (this.u.get()) {
                    this.pn.set(com.bytedance.sdk.component.x.fx.u.nr.u("sp_bidding_opt_libra", "key_net_queue_limit", 7));
                } else {
                    if (this.jk == null) {
                        this.jk = l();
                    }
                    this.pn.set(this.jk.getInt("key_net_queue_limit", 7));
                }
            }
            return this.pn.get();
        } catch (Throwable unused) {
            return 7;
        }
    }

    public void t() {
        x.u(new a("advance_init_rb") { // from class: com.bytedance.sdk.openadsdk.core.fx.fx.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (fx.this.fx.get()) {
                        return;
                    }
                    fx.this.fx.set(true);
                    fx.this.mv();
                } catch (Throwable unused) {
                }
            }
        }, 10);
    }

    public int x() {
        try {
            if (this.f5281a.get() == Integer.MAX_VALUE) {
                if (this.u.get()) {
                    this.f5281a.set(com.bytedance.sdk.component.x.fx.u.nr.u("sp_bidding_opt_libra", "key_req_build_opt", 1));
                } else {
                    if (this.jk == null) {
                        this.jk = l();
                    }
                    this.f5281a.set(this.jk.getInt("key_req_build_opt", 1));
                }
            }
            return this.f5281a.get();
        } catch (Exception unused) {
            return 0;
        }
    }

    public boolean nr() {
        if (!this.n) {
            this.u.set(com.bytedance.sdk.component.x.fx.u.nr.u("sp_bidding_opt_libra", "key_support_multiprocess", 2) == 1);
            this.n = true;
        }
        return this.u.get();
    }

    public static fx u() {
        if (nr == null) {
            synchronized (fx.class) {
                if (nr == null) {
                    nr = new fx();
                }
            }
        }
        return nr;
    }

    public void u(boolean z) {
        this.u.set(z);
        if (z) {
            u("key_support_multiprocess", 1);
        }
    }

    private void u(String str, int i) {
        try {
            if (this.u.get()) {
                com.bytedance.sdk.component.x.fx.u.nr.u("sp_bidding_opt_libra", str, Integer.valueOf(i));
                return;
            }
            if (this.jk == null) {
                this.jk = l();
            }
            SharedPreferences.Editor editorEdit = this.jk.edit();
            editorEdit.putInt(str, i);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    private void u(String str, String str2) {
        try {
            if (this.u.get()) {
                com.bytedance.sdk.component.x.fx.u.nr.u("sp_bidding_opt_libra", str, str2);
                return;
            }
            if (this.jk == null) {
                this.jk = l();
            }
            SharedPreferences.Editor editorEdit = this.jk.edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public static String u(String str) {
        String strB = u().b();
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        return String.format("https://%s%s", strB, str);
    }

    public void u(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("ads_url", "api-access.pangolin-sdk-toutiao.com");
            this.iz = strOptString;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
            if (jSONObjectOptJSONObject == null) {
                if (com.bytedance.sdk.openadsdk.core.b.u.iz()) {
                    return;
                }
                u("key_url_ads", strOptString);
                return;
            }
            int i = 1;
            int iOptInt = jSONObjectOptJSONObject.optInt("network_module", 1);
            int iOptInt2 = jSONObjectOptJSONObject.optInt("if_req_body_opt", 1);
            this.b.set(iOptInt2);
            int iOptInt3 = jSONObjectOptJSONObject.optInt("net_queue_limit", 7);
            this.pn.set(iOptInt3);
            int iOptInt4 = jSONObjectOptJSONObject.optInt("req_build_opt", 0);
            this.f5281a.set(iOptInt4);
            if (!jSONObjectOptJSONObject.optBoolean("_use_pl_", false)) {
                i = 0;
            }
            int iOptInt5 = jSONObjectOptJSONObject.optInt("boost_save_config", 0);
            this.l.set(iOptInt5);
            if (com.bytedance.sdk.openadsdk.core.b.u.iz()) {
                return;
            }
            if (this.u.get()) {
                try {
                    com.bytedance.sdk.component.x.fx.u.nr.u("sp_bidding_opt_libra", "key_network_module", Integer.valueOf(iOptInt));
                    com.bytedance.sdk.component.x.fx.u.nr.u("sp_bidding_opt_libra", "key_req_body_opt", Integer.valueOf(iOptInt2));
                    com.bytedance.sdk.component.x.fx.u.nr.u("sp_bidding_opt_libra", "key_net_queue_limit", Integer.valueOf(iOptInt3));
                    com.bytedance.sdk.component.x.fx.u.nr.u("sp_bidding_opt_libra", "key_req_build_opt", Integer.valueOf(iOptInt4));
                    com.bytedance.sdk.component.x.fx.u.nr.u("sp_bidding_opt_libra", "_use_pl_", Integer.valueOf(i));
                    com.bytedance.sdk.component.x.fx.u.nr.u("sp_bidding_opt_libra", "key_url_ads", strOptString);
                    com.bytedance.sdk.component.x.fx.u.nr.u("sp_bidding_opt_libra", "boost_save_config", Integer.valueOf(iOptInt5));
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            if (this.jk == null) {
                this.jk = l();
            }
            SharedPreferences.Editor editorEdit = this.jk.edit();
            editorEdit.putInt("key_network_module", iOptInt);
            editorEdit.putInt("key_req_body_opt", iOptInt2);
            editorEdit.putInt("key_net_queue_limit", iOptInt3);
            editorEdit.putInt("key_req_build_opt", iOptInt4);
            editorEdit.putInt("_use_pl_", i);
            editorEdit.putString("key_url_ads", strOptString);
            editorEdit.putInt("boost_save_config", iOptInt5);
            editorEdit.commit();
        } catch (Throwable unused2) {
        }
    }

    public boolean u(int i) {
        if (i <= 0) {
            return false;
        }
        return u(i, x());
    }
}
