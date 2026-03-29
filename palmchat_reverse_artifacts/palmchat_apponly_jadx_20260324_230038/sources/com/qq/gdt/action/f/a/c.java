package com.qq.gdt.action.f.a;

import com.qq.gdt.action.d;
import com.qq.gdt.action.f.b.i;
import com.qq.gdt.action.f.f;
import com.qq.gdt.action.j.o;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class c extends a<f> {
    public c() {
        this(false);
    }

    @Override // com.qq.gdt.action.f.a.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public f b(i iVar) throws Exception {
        f fVar = new f(-1, "Unknown message");
        if (iVar != null) {
            try {
                JSONObject jSONObject = new JSONObject(iVar.e().b());
                fVar.a(jSONObject.optInt("code", -3));
                fVar.a(jSONObject.optString("message", "Deserialize message error"));
                if (jSONObject.has("data")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    if (jSONObject2.has("conf")) {
                        com.qq.gdt.action.b.a(d.a().g()).a(jSONObject2.getJSONObject("conf"));
                    }
                }
            } catch (IOException | JSONException unused) {
                o.a("Deserialize service response error", new Object[0]);
                fVar.a(-3);
                fVar.a("Deserialize service response error");
            }
        }
        return fVar;
    }

    public c(boolean z) {
        super(z);
    }
}
