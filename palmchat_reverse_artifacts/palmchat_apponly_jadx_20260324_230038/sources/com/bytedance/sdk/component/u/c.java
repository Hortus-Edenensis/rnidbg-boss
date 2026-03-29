package com.bytedance.sdk.component.u;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class c {
    private final Set<u> b;
    private final t fx;
    private final Map<String, dw> nr;
    private final Collection<String> u;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
    }

    public void nr(u uVar) {
        this.b.remove(uVar);
    }

    public dw u(String str) {
        if (this.u.contains(str) || TextUtils.equals(str, "host")) {
            return u(str, null);
        }
        throw new IllegalArgumentException("Namespace: " + str + " not registered.");
    }

    public void u(u uVar) {
        this.b.add(uVar);
    }

    private dw u(String str, JSONObject jSONObject) {
        dw dwVar = this.nr.get(str);
        if (dwVar == null) {
            dw dwVar2 = new dw(str, this.fx.fx(), this.fx.u(), this.fx.nr(), jSONObject);
            this.nr.put(str, dwVar2);
            return dwVar2;
        }
        if (jSONObject == null) {
            return dwVar;
        }
        dwVar.update(jSONObject);
        return dwVar;
    }
}
