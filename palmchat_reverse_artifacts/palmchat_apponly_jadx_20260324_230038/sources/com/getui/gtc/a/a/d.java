package com.getui.gtc.a.a;

import android.net.Network;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends f {
    private final int o;
    private final k p;

    public d(String str, k kVar, Network network) {
        super(str);
        this.o = 1;
        this.l = true;
        this.p = kVar;
        this.c = network;
    }

    @Override // com.getui.gtc.a.a.f
    public final void a() {
        try {
            com.getui.gtc.i.c.a.a("exceptionHandler type = " + this.o);
            if (this.e != null) {
                j jVar = new j();
                jVar.c = this.o;
                jVar.d = this.p;
                this.e.a(jVar);
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
        }
    }

    @Override // com.getui.gtc.a.a.f
    public final void a(int i) {
        try {
            com.getui.gtc.i.c.a.a("requestFailed type = ".concat(String.valueOf(i)));
            if (this.e != null) {
                j jVar = new j();
                jVar.c = this.o;
                jVar.d = this.p;
                this.e.a(jVar);
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
        }
    }

    @Override // com.getui.gtc.a.a.f
    public final void a(Map<String, List<String>> map, byte[] bArr) {
        try {
            String str = new String(bArr, "UTF-8");
            if (this.e != null) {
                j jVar = new j();
                jVar.c = this.o;
                jVar.d = this.p;
                jVar.f5669a = map;
                jVar.b = str;
                this.e.a(jVar);
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
        }
    }
}
