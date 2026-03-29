package com.cmic.sso.sdk.c.b;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class g {
    public abstract String a();

    public abstract String a_(String str);

    public abstract JSONObject b();

    public String v(String str) {
        return com.cmic.sso.sdk.e.d.a(a_(str)).toLowerCase();
    }
}
