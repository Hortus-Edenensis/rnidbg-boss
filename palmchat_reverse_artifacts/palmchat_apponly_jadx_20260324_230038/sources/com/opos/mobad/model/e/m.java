package com.opos.mobad.model.e;

import android.text.TextUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.net.URLEncoder;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l f9104a = new l();
    private Map<String, n> b = new ConcurrentHashMap();

    public m a(int i, String str) {
        this.f9104a.a(str, String.valueOf(i));
        return this;
    }

    public String g() {
        String strValueOf;
        for (String str : this.b.keySet()) {
            String strA = this.b.get(str).a();
            if (TextUtils.isEmpty(strA)) {
                this.f9104a.a(str, String.valueOf(0));
            } else {
                try {
                    strValueOf = URLEncoder.encode("0-" + strA);
                } catch (Exception unused) {
                    strValueOf = String.valueOf(0);
                }
                this.f9104a.a(str, strValueOf);
            }
        }
        String strA2 = this.f9104a.a();
        if (TextUtils.isEmpty(strA2)) {
            return strA2;
        }
        try {
            return URLEncoder.encode(strA2);
        } catch (Exception unused2) {
            return "";
        }
    }

    public m a(String str, n nVar) {
        if (!TextUtils.isEmpty(str) && nVar != null) {
            this.b.put(str, nVar);
        }
        return this;
    }

    public void a(String str, int i) {
        Map<String, n> map = this.b;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (n nVar : this.b.values()) {
            if (nVar != null) {
                nVar.a(str, i);
            }
        }
    }
}
