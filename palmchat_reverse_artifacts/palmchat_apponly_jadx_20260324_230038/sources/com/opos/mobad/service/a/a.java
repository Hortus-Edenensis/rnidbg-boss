package com.opos.mobad.service.a;

import com.opos.cmn.an.d.b;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Long> f9192a = new ConcurrentHashMap();

    public long a(String str) {
        long jLongValue = 60000;
        try {
            if (!b.a(str) && this.f9192a.containsKey(str)) {
                jLongValue = this.f9192a.get(str).longValue();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("CommonConfig", "", (Throwable) e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getRefreshTime posId=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",result=");
        sb.append(jLongValue);
        com.opos.cmn.an.f.a.b("CommonConfig", sb.toString());
        return jLongValue;
    }

    public void a(String str, int i) {
        try {
            if (!b.a(str) && i > 0) {
                this.f9192a.put(str, Long.valueOf(i * 1000));
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("CommonConfig", "", (Throwable) e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("setRefreshTime posId=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",refreshTime=");
        sb.append(i);
        com.opos.cmn.an.f.a.b("CommonConfig", sb.toString());
    }
}
