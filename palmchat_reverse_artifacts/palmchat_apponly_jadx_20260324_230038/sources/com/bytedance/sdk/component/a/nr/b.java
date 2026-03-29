package com.bytedance.sdk.component.a.nr;

import android.text.TextUtils;
import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.nr.u.s;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b {
    protected l fx;
    private Object nr;
    private Map<String, Object> u;
    protected String b = null;
    protected final Map<String, String> pn = new HashMap();
    protected String iz = null;
    protected boolean x = false;

    public b(l lVar) {
        this.fx = lVar;
        nr(UUID.randomUUID().toString());
    }

    public void b(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.pn.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public Map<String, Object> fx() {
        return this.u;
    }

    public void nr(String str, String str2) {
        this.pn.put(str, str2);
    }

    public void pn(Map<String, Object> map) {
        this.u = map;
    }

    public abstract com.bytedance.sdk.component.a.nr u();

    public void u(String str) {
        this.iz = str;
    }

    public void nr(String str) {
        this.b = str;
    }

    public void u(s.u uVar) {
        if (uVar != null && this.pn.size() > 0) {
            for (Map.Entry<String, String> entry : this.pn.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    uVar.nr(key, value);
                }
            }
        }
    }

    public Object b() {
        return this.nr;
    }

    public String nr() {
        return this.b;
    }

    public void u(boolean z) {
        this.x = z;
    }
}
