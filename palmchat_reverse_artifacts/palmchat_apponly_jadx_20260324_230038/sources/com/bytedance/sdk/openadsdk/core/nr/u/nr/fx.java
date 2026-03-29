package com.bytedance.sdk.openadsdk.core.nr.u.nr;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.mv;
import com.bytedance.sdk.openadsdk.core.qq;
import com.bytedance.sdk.openadsdk.gi.x;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private final AtomicBoolean b = new AtomicBoolean(true);
    private String fx;
    private final Context nr;
    private nr pn;
    private final bc u;

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void u();

        void u(String str, boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u();
    }

    public fx(bc bcVar, Context context) {
        this.u = bcVar;
        this.nr = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(mv mvVar) {
        if (this.b.getAndSet(false)) {
            nr(mvVar);
        }
    }

    private void nr(final mv mvVar) {
        if (mvVar == null) {
            return;
        }
        try {
            dw.u().u(mvVar.nr(), new qq.fx<com.bytedance.sdk.component.a.nr>() { // from class: com.bytedance.sdk.openadsdk.core.nr.u.nr.fx.3
                @Override // com.bytedance.sdk.openadsdk.core.qq.fx
                public void u(int i, String str) {
                    fx.this.u();
                    fx.this.fx(mvVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.qq.fx
                public void u(com.bytedance.sdk.component.a.nr nrVar) {
                    if (nrVar == null || !nrVar.a() || TextUtils.isEmpty(nrVar.pn())) {
                        fx.this.u();
                        fx.this.fx(mvVar);
                    } else {
                        try {
                            fx.this.u(new JSONObject(nrVar.pn()));
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private void nr(JSONObject jSONObject) {
        boolean zOptBoolean = jSONObject.optBoolean("is_apply_coupon");
        String strOptString = jSONObject.optString("error_type");
        if (zOptBoolean && "success".equals(strOptString)) {
            com.bytedance.sdk.openadsdk.core.s.b.nr(this.u, this.fx, 1);
        } else if (zOptBoolean && "has_applied".equals(strOptString)) {
            com.bytedance.sdk.openadsdk.core.s.b.nr(this.u, this.fx, 2);
        } else if (!zOptBoolean) {
            com.bytedance.sdk.openadsdk.core.s.b.nr(this.u, this.fx, 3);
        }
        if (this.pn != null) {
            if (zOptBoolean && "success".equals(strOptString)) {
                this.pn.u();
            } else {
                this.pn.u(strOptString, zOptBoolean);
            }
        }
    }

    public fx u(String str) {
        this.fx = str;
        return this;
    }

    public void u(nr nrVar) {
        this.pn = nrVar;
    }

    public static boolean u(bc bcVar, boolean z) {
        mv mvVarBb = bcVar != null ? bcVar.bb() : null;
        return mvVarBb != null && mvVarBb.u(z);
    }

    public int u(final u uVar) {
        bc bcVar = this.u;
        mv mvVarBb = bcVar != null ? bcVar.bb() : null;
        u(mvVarBb);
        nr(mvVarBb);
        bg.iz().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nr.u.nr.fx.1
            @Override // java.lang.Runnable
            public void run() {
                u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.u();
                }
            }
        }, 500L);
        return 1;
    }

    private void u(mv mvVar) {
        if (mvVar == null || TextUtils.isEmpty(mvVar.b())) {
            return;
        }
        final String strB = mvVar.b();
        x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nr.u.nr.fx.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h.nr(fx.this.nr.getApplicationContext(), strB, 0, 17, 0, 0);
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        com.bytedance.sdk.openadsdk.core.s.b.nr(this.u, this.fx, 4);
        nr nrVar = this.pn;
        if (nrVar != null) {
            nrVar.u("net_fail", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(JSONObject jSONObject) {
        try {
            if (jSONObject.has("is_apply_coupon")) {
                nr(jSONObject);
            }
        } catch (Throwable unused) {
            u();
        }
    }
}
