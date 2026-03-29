package com.bytedance.sdk.openadsdk.core.live;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jp;
import com.bytedance.sdk.openadsdk.core.live.u.b;
import com.bytedance.sdk.openadsdk.core.live.u.pn;
import com.bytedance.sdk.openadsdk.core.live.u.x;
import com.bytedance.sdk.openadsdk.core.pb.a;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private final b u;

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        private static final nr u = new nr();
    }

    public static final nr u() {
        return u.u;
    }

    public long a() {
        return this.u.fx();
    }

    public void b() {
        this.u.b();
    }

    public int fx() {
        return this.u.nr();
    }

    public int iz() {
        return com.bytedance.sdk.openadsdk.core.fx.b.u().fx();
    }

    public JSONObject n() {
        return this.u.n();
    }

    public int nr(Context context, bc bcVar, Map<String, Object> map) {
        return this.u.nr(context, bcVar, map);
    }

    public int pn() {
        return this.u.pn();
    }

    public String x() {
        return this.u.x();
    }

    private nr() {
        if (!a.u()) {
            this.u = new com.bytedance.sdk.openadsdk.core.live.u.nr();
            return;
        }
        if (d.iz) {
            this.u = new x();
        } else if (d.x()) {
            this.u = new pn();
        } else {
            this.u = new com.bytedance.sdk.openadsdk.core.live.u.nr();
        }
    }

    public void b(final bc bcVar) {
        if (bcVar == null) {
            return;
        }
        pn(bcVar);
        if (TextUtils.isEmpty(bcVar.uu())) {
            return;
        }
        int iFx = com.bytedance.sdk.openadsdk.core.fx.b.u().fx() + 1;
        if (iFx > 100) {
            iFx = 100;
        }
        com.bytedance.sdk.openadsdk.core.fx.b.u().u(iFx);
        final int iFx2 = fx();
        final int iPn = pn();
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime();
        if (bcVar.gq() == 1 && bcVar.ud() == 1) {
            com.bytedance.sdk.openadsdk.core.qq.nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.live.nr.1
                @Override // com.bytedance.sdk.openadsdk.t.u.u
                public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ext", bcVar.ap());
                        jSONObject.put("live_sdk_status", iFx2);
                        jSONObject.put("live_auth_status", iPn);
                        jSONObject.put("app_start_time", jElapsedRealtime);
                        jSONObject.put("is_web", bcVar.nr());
                    } catch (Throwable unused) {
                    }
                    return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("saas_miss").nr(jSONObject.toString());
                }
            }, "saas_miss", true);
        }
    }

    public int fx(bc bcVar) {
        if (dw.nr().is()) {
            return this.u.b_(bcVar);
        }
        return 0;
    }

    public boolean iz(bc bcVar) {
        return bcVar != null && bcVar.xw() == 2;
    }

    public boolean nr(bc bcVar) {
        if (bcVar == null || TextUtils.isEmpty(bcVar.uu())) {
            return false;
        }
        return u(bcVar.uu(), bcVar.gq());
    }

    public void pn(bc bcVar) {
        this.u.b(bcVar);
    }

    public void u(Function<SparseArray<Object>, Object> function) {
        this.u.u(function);
    }

    public int u(Context context, bc bcVar, Map<String, Object> map) {
        if (context == null || bcVar == null) {
            return 5;
        }
        return this.u.u(context, bcVar, map);
    }

    public void nr() {
        this.u.u();
    }

    public void u(String str, boolean z) {
        this.u.u(str, z);
    }

    public int u(bc bcVar, com.bytedance.sdk.openadsdk.core.live.u.fx fxVar, String str) {
        return this.u.u(bcVar, fxVar, str);
    }

    public boolean u(bc bcVar) {
        return this.u.u(bcVar);
    }

    public void u(String str, bc bcVar, long j) {
        this.u.u(str, bcVar, j);
    }

    public boolean u(String str, int i) {
        return this.u.u(str, i);
    }

    public void u(View view, jp jpVar, Map<String, Object> map, Map<String, Object> map2) {
        Object tag;
        if (view == null || jpVar == null || (tag = view.getTag(67108864)) == null || !(tag instanceof Integer)) {
            return;
        }
        int iIntValue = ((Integer) tag).intValue();
        int i = iIntValue & 255;
        int i2 = (iIntValue & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8;
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (i == 101 && !jpVar.fx()) {
            i = 102;
        }
        map.put("live_saas_param_interaction_type", Integer.valueOf(i));
        map2.put("click_saas_area", Integer.valueOf(i2));
    }

    public int u(String str) {
        return this.u.u(str);
    }

    public int u(com.bytedance.sdk.openadsdk.core.live.nr.nr nrVar, boolean z) {
        return this.u.u(nrVar, z);
    }

    public void u(com.bytedance.sdk.openadsdk.k.b bVar) {
        this.u.u(bVar);
    }
}
