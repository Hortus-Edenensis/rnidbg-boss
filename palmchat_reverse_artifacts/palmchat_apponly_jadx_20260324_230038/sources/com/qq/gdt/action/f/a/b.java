package com.qq.gdt.action.f.a;

import android.text.TextUtils;
import com.qq.gdt.action.f.b.i;
import com.qq.gdt.action.f.b.j;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class b extends a<com.qq.gdt.action.f.a> {
    public b() {
        super(false);
    }

    @Override // com.qq.gdt.action.f.a.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.qq.gdt.action.f.a b(i iVar) throws Exception {
        j jVarE;
        com.qq.gdt.action.f.a aVar = new com.qq.gdt.action.f.a(-1, "Unknown message");
        if (iVar != null && (jVarE = iVar.e()) != null) {
            String strB = jVarE.b();
            if (!TextUtils.isEmpty(strB)) {
                JSONObject jSONObject = new JSONObject(strB);
                aVar.a(jSONObject.optInt("ret", -1));
                aVar.a(jSONObject.optString("msg", "Unknown message"));
            }
        }
        return aVar;
    }
}
