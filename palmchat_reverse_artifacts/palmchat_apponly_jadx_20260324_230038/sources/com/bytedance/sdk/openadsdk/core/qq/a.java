package com.bytedance.sdk.openadsdk.core.qq;

import android.content.Context;
import android.os.Looper;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.dw;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a implements com.bytedance.sdk.component.n.u.b {
    @Override // com.bytedance.sdk.component.n.u.b
    public boolean a() {
        return dw.nr().h();
    }

    @Override // com.bytedance.sdk.component.n.u.b
    public String b() {
        return "csj_";
    }

    @Override // com.bytedance.sdk.component.n.u.b
    public boolean fx() {
        return false;
    }

    @Override // com.bytedance.sdk.component.n.u.b
    public boolean jk() {
        return true;
    }

    @Override // com.bytedance.sdk.component.n.u.b
    public boolean k() {
        return false;
    }

    @Override // com.bytedance.sdk.component.n.u.b
    public com.bytedance.sdk.component.n.u.u.nr l() {
        return new jk(com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().fx());
    }

    @Override // com.bytedance.sdk.component.n.u.b
    public com.bytedance.sdk.component.n.nr.fx mv() {
        return null;
    }

    @Override // com.bytedance.sdk.component.n.u.b
    /* JADX INFO: renamed from: my, reason: merged with bridge method [inline-methods] */
    public ExecutorService iz() {
        return com.bytedance.sdk.component.jk.x.nr();
    }

    @Override // com.bytedance.sdk.component.n.u.b
    public int n() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.n.u.b
    public Looper nr() {
        return com.bytedance.sdk.component.jk.nr.u.u().nr().getLooper();
    }

    @Override // com.bytedance.sdk.component.n.u.b
    public boolean pn() {
        return com.bytedance.sdk.openadsdk.core.pb.a.u();
    }

    @Override // com.bytedance.sdk.component.n.u.b
    public com.bytedance.sdk.component.n.u.n s() {
        return u.u;
    }

    @Override // com.bytedance.sdk.component.n.u.b
    public String t() {
        return com.bytedance.sdk.openadsdk.core.y.jk.mv();
    }

    @Override // com.bytedance.sdk.component.n.u.b
    public boolean u() {
        return dw.nr().d();
    }

    @Override // com.bytedance.sdk.component.n.u.b
    public Executor x() {
        return com.bytedance.sdk.component.jk.x.u();
    }

    @Override // com.bytedance.sdk.component.n.u.b
    public String nr(String str) {
        return com.bytedance.sdk.component.utils.u.nr(str);
    }

    @Override // com.bytedance.sdk.component.n.u.b
    public com.bytedance.sdk.component.n.u.nr u(JSONObject jSONObject) {
        try {
            jSONObject.put("is_new", true);
            jSONObject.put("sdk_session_id", nr.u);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.component.n.nr.b.u.u uVar = new com.bytedance.sdk.component.n.nr.b.u.u(UUID.randomUUID().toString(), com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("new_adlog_monitor").nr(jSONObject.toString()).u());
        uVar.fx((byte) 0);
        uVar.nr((byte) 2);
        uVar.u((byte) 1);
        return uVar;
    }

    @Override // com.bytedance.sdk.component.n.u.b
    public boolean u(Context context) {
        return o.u(context);
    }

    @Override // com.bytedance.sdk.component.n.u.b
    public String u(String str) {
        return com.bytedance.sdk.component.utils.u.fx(str);
    }

    @Override // com.bytedance.sdk.component.n.u.b
    public void u(JSONObject jSONObject, JSONObject jSONObject2) {
        boolean zKi = dw.nr().ki();
        boolean z = false;
        if (jSONObject2 != null && jSONObject2.optInt("success") == 1) {
            z = true;
        }
        if (z && zKi) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.s.b.u(jSONObject, jSONObject2);
    }
}
