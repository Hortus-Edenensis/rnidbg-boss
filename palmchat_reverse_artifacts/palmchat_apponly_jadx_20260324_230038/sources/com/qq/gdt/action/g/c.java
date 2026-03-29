package com.qq.gdt.action.g;

import com.qq.gdt.action.j.o;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f10522a;

    public static c a() {
        if (f10522a == null) {
            synchronized (c.class) {
                if (f10522a == null) {
                    f10522a = new c();
                }
            }
        }
        return f10522a;
    }

    private boolean b() {
        boolean z = com.qq.gdt.action.d.a().g() != null;
        if (!z) {
            o.a("event sendToNetwork 上下文 未准备好！！！！ ", new Object[0]);
        }
        return z;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x008a -> B:23:0x0091). Please report as a decompilation issue!!! */
    public void a(int i, com.qq.gdt.action.c.a aVar, JSONObject jSONObject) {
        String strC;
        String strA;
        long jB;
        long jD;
        if (aVar != null) {
            try {
                strC = aVar.c();
                strA = aVar.a();
                jB = aVar.b();
                jD = aVar.d();
            } catch (Exception e) {
                o.b("RecorderWrapper event e ", e);
                return;
            }
        } else {
            strC = null;
            strA = null;
            jD = -1;
            jB = -1;
        }
        try {
        } catch (Exception e2) {
            o.b("RecorderWrapper event e ", e2);
        }
        if (d.a(strC, i)) {
            com.qq.gdt.action.g.a.a aVar2 = new com.qq.gdt.action.g.a.a(i, System.currentTimeMillis(), com.qq.gdt.action.d.a().n(), strC, strA, jD, jSONObject, jB, com.qq.gdt.action.d.a().p());
            if (b()) {
                b.a().a(aVar2);
            } else {
                com.qq.gdt.action.i.a.a(aVar2);
                o.a("event不落DB直接发送，eventId:  " + aVar2.b() + ", eventLogId:" + aVar2.k(), new Object[0]);
            }
        }
    }
}
