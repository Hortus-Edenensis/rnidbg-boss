package com.bytedance.embedapplog;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class qe implements fx {
    private static volatile qe u;
    private final CopyOnWriteArraySet<fx> nr = new CopyOnWriteArraySet<>();

    private qe() {
    }

    public static qe u() {
        if (u == null) {
            synchronized (qe.class) {
                if (u == null) {
                    u = new qe();
                }
            }
        }
        return u;
    }

    @Override // com.bytedance.embedapplog.fx
    public void nr(boolean z, JSONObject jSONObject) {
        Iterator<fx> it = this.nr.iterator();
        while (it.hasNext()) {
            it.next().nr(z, jSONObject);
        }
    }

    @Override // com.bytedance.embedapplog.fx
    public void u(String str, String str2, String str3) {
        Iterator<fx> it = this.nr.iterator();
        while (it.hasNext()) {
            it.next().u(str, str2, str3);
        }
    }

    @Override // com.bytedance.embedapplog.fx
    public void u(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<fx> it = this.nr.iterator();
        while (it.hasNext()) {
            it.next().u(z, str, str2, str3, str4, str5, str6);
        }
    }

    @Override // com.bytedance.embedapplog.fx
    public void u(boolean z, JSONObject jSONObject) {
        Iterator<fx> it = this.nr.iterator();
        while (it.hasNext()) {
            it.next().u(z, jSONObject);
        }
    }
}
