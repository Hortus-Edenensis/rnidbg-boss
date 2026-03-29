package com.baidu.mshield.x6.e;

import android.content.Context;
import com.baidu.mshield.x6.f.l;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f4080a;
    public g b;
    public com.baidu.mshield.x6.b.b c;
    public int d;

    public c(Context context, int i) {
        this.f4080a = context;
        this.d = i;
        this.b = new g(context, i);
        this.c = new com.baidu.mshield.x6.b.b(this.f4080a);
    }

    public final long a() {
        long j = 300000;
        try {
            int i = h.d;
            if (i == 0 || i == 1 || i == 2) {
                j = 5000;
            } else if ((i < 3 || i >= 10) && i >= 10) {
                j = -1;
            }
            h.d = i + 1;
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
        return j;
    }

    public void b() {
        JSONObject jSONObjectA;
        try {
            com.baidu.mshield.b.c.a.a("report static alive for start");
            JSONObject jSONObjectA2 = this.b.a();
            if (jSONObjectA2 != null) {
                jSONObjectA = com.baidu.mshield.x6.f.f.a(this.f4080a, jSONObjectA2, com.baidu.mshield.x6.f.g.c, true);
            } else {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("11111", "-1");
                jSONObjectA = com.baidu.mshield.x6.f.f.a(this.f4080a, jSONObject, com.baidu.mshield.x6.f.g.c, true);
            }
            com.baidu.mshield.b.c.a.a("sendJson:" + jSONObjectA);
        } finally {
            try {
            } finally {
            }
        }
        if (!com.baidu.mshield.b.a.d.b(this.f4080a)) {
            h.c = false;
            return;
        }
        int iA = l.a(this.f4080a, jSONObjectA.toString());
        com.baidu.mshield.b.c.a.c("result: " + iA);
        if (iA == 0) {
            this.c.s(com.baidu.mshield.x6.f.f.c());
            this.c.b(true);
            this.c.e(false);
        } else {
            long jA = a();
            if (com.baidu.mshield.b.a.d.b(this.f4080a) && jA > 0) {
                f.b(this.f4080a).a(jA);
            }
        }
    }
}
