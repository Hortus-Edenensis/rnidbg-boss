package com.bytedance.sdk.openadsdk.core.k.u;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.Window;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.t;
import com.bytedance.sdk.openadsdk.core.y.u;
import com.qq.gdt.action.ActionUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private static final fx u = new fx();
    private volatile boolean iz;
    private com.bytedance.sdk.openadsdk.core.k.u.nr.nr n;
    private volatile boolean pn;
    private volatile boolean t;
    private bc x;
    private float nr = -2.0f;
    private float fx = -2.0f;
    private double b = -2.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicInteger f5293a = new AtomicInteger();
    private AtomicInteger jk = new AtomicInteger();
    private ConcurrentHashMap<Window, com.bytedance.sdk.openadsdk.core.k.u.u.nr> l = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Window, com.bytedance.sdk.openadsdk.core.k.u.nr.nr> mv = new ConcurrentHashMap<>();

    private fx() {
        com.bytedance.sdk.openadsdk.core.y.u uVarB = n.o().b();
        if (uVarB == null) {
            return;
        }
        uVarB.nr(new u.fx() { // from class: com.bytedance.sdk.openadsdk.core.k.u.fx.1
            @Override // com.bytedance.sdk.openadsdk.core.y.u.fx, com.bytedance.sdk.openadsdk.core.y.u.InterfaceC0306u
            public void nr(String str, Window window) {
                super.nr(str, window);
                if (!TextUtils.isEmpty(str) && str.contains("com.byted.live.lite")) {
                    fx fxVar = fx.this;
                    fxVar.nr(window, fxVar.x, false);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.y.u.fx, com.bytedance.sdk.openadsdk.core.y.u.InterfaceC0306u
            public void u(String str, Window window) {
                super.u(str, window);
                if (!TextUtils.isEmpty(str) && str.contains("com.byted.live.lite")) {
                    fx fxVar = fx.this;
                    fxVar.u(window, fxVar.x, fx.this.t);
                }
            }
        });
    }

    private void a() {
        if (jp.fx(this.x)) {
            this.f5293a.incrementAndGet();
        }
    }

    private void jk() {
        if (this.f5293a.get() > 0 && jp.fx(this.x)) {
            this.f5293a.decrementAndGet();
        }
    }

    private void n() {
        if (this.jk.get() > 0 && jp.fx(this.x)) {
            this.jk.decrementAndGet();
        }
    }

    private void x() {
        if (jp.fx(this.x)) {
            this.jk.incrementAndGet();
        }
    }

    public boolean b() {
        return this.iz;
    }

    public boolean fx() {
        return this.pn;
    }

    public float iz() {
        if (this.fx == -2.0f) {
            if (((AudioManager) dw.getContext().getSystemService("audio")) == null) {
                return 0.0f;
            }
            this.fx = r0.getStreamVolume(3);
        }
        return this.fx;
    }

    public float pn() {
        return this.nr;
    }

    private void fx(Window window, bc bcVar) {
        com.bytedance.sdk.openadsdk.core.k.u.nr.nr nrVar;
        if (window == null || (nrVar = this.mv.get(window)) == null) {
            return;
        }
        if (jp.fx(bcVar)) {
            n();
            if (this.jk.get() != 0) {
                return;
            }
        }
        nrVar.pn();
    }

    public static fx u() {
        return u;
    }

    public double nr() {
        return this.b;
    }

    public void nr(float f) {
        this.fx = f;
    }

    public void u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        double dOptDouble = jSONObject.optDouble("day_factor", 0.0d);
        double dOptDouble2 = jSONObject.optDouble("week_factor", 0.0d);
        double dOptDouble3 = jSONObject.optDouble("battery_factor", 0.0d);
        this.b = u.u(((((double) (nr.u() ? 1 : -1)) * dOptDouble2) + (((double) (nr.fx() ? 1 : -1)) * dOptDouble) + (((double) (t.u.nr(dw.getContext()) < 50.0f ? -1 : 1)) * dOptDouble3)) * jSONObject.optDouble("factor", 0.0d), jSONObject);
    }

    public void nr(Context context, bc bcVar, boolean z) {
        nr(u(context), bcVar, z);
    }

    public void nr(Window window, bc bcVar, boolean z) {
        if (jp.iz(bcVar) && z) {
            nr(window, bcVar);
        }
        if (jp.pn(bcVar)) {
            fx(window, bcVar);
        }
    }

    private void nr(Window window, bc bcVar) {
        com.bytedance.sdk.openadsdk.core.k.u.u.nr nrVar;
        if (window == null || (nrVar = this.l.get(window)) == null) {
            return;
        }
        if (jp.fx(bcVar)) {
            jk();
            if (this.f5293a.get() != 0) {
                return;
            }
        }
        nrVar.pn();
    }

    public void u(boolean z) {
        this.pn = z;
    }

    public void u(float f) {
        this.nr = f;
    }

    public void u(Context context, bc bcVar, boolean z) {
        Window window = context instanceof Activity ? ((Activity) context).getWindow() : null;
        this.t = z;
        u(window, bcVar, z);
    }

    private void u(Window window, bc bcVar) {
        if (jp.iz(bcVar)) {
            this.x = bcVar;
            com.bytedance.sdk.openadsdk.core.k.u.u.nr nrVar = new com.bytedance.sdk.openadsdk.core.k.u.u.nr(window);
            boolean zB = nrVar.b();
            if (window == null || !zB) {
                return;
            }
            a();
            this.l.put(window, nrVar);
        }
    }

    private void u(boolean z, bc bcVar, Window window) {
        if (!z && jp.pn(bcVar)) {
            this.x = bcVar;
            com.bytedance.sdk.openadsdk.core.k.u.nr.nr nrVar = new com.bytedance.sdk.openadsdk.core.k.u.nr.nr();
            this.n = nrVar;
            nrVar.u(zx.x(bcVar));
            this.n.u(jp.z(bcVar));
            boolean zB = this.n.b();
            if (window == null || !zB) {
                return;
            }
            x();
            this.mv.put(window, this.n);
        }
    }

    public void u(Window window, bc bcVar, boolean z) {
        if (window == null) {
            return;
        }
        u(window, bcVar);
        u(z, bcVar, window);
    }

    private Window u(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindow();
        }
        return null;
    }

    public int u(int i, bc bcVar) {
        JSONObject jSONObjectQe;
        int i2;
        int iJk = jp.jk(bcVar);
        if ((iJk == 9 || iJk == 5) && (jSONObjectQe = dw.nr().qe()) != null) {
            int iOptInt = jSONObjectQe.optInt("enable");
            double dOptDouble = jSONObjectQe.optDouble(ActionUtils.PAYMENT_AMOUNT);
            if (iOptInt == 1 && (i2 = (int) (dOptDouble * 100.0d)) >= 0 && i2 <= 100) {
                return i2;
            }
        }
        return i;
    }

    public void u(int i) {
        com.bytedance.sdk.openadsdk.core.k.u.nr.nr nrVar = this.n;
        if (nrVar != null) {
            this.iz = nrVar.x() != i;
        }
    }
}
