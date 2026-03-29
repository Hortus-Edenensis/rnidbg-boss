package com.zx.a.I8b7;

import android.net.Network;
import com.zx.a.I8b7.l2;
import com.zx.a.I8b7.m2;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class m implements m2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16826a;

    public m(String str) {
        this.f16826a = str;
    }

    @Override // com.zx.a.I8b7.m2.b
    public void a(int i, String str) {
    }

    public final void b(Network network) {
        try {
            JSONArray jSONArray = new JSONObject(this.f16826a).getJSONArray(com.igexin.push.core.b.Y);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                m3.k.put(network != null ? d0.a(network, jSONObject) : e0.a(jSONObject));
            }
            l2 l2Var = l2.a.f16824a;
            u3 u3Var = l2Var.f16823a;
            JSONArray jSONArray2 = m3.k;
            u3Var.getClass();
            if (jSONArray2 == null) {
                return;
            }
            l2Var.f16823a.a(63, jSONArray2.toString(), true);
            r2.a("reqBZ had changed refresh:" + jSONArray2);
        } catch (Throwable th) {
            r2.a(th.getMessage());
        }
    }

    @Override // com.zx.a.I8b7.m2.b
    public void a(Network network) {
        b(network);
    }

    @Override // com.zx.a.I8b7.m2.b
    public void a() {
        b(null);
    }
}
