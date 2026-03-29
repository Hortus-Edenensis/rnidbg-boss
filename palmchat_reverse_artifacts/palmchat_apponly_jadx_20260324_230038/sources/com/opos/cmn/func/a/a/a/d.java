package com.opos.cmn.func.a.a.a;

import com.opos.cmn.func.a.a.a.a;
import com.opos.cmn.func.a.a.a.b;
import com.opos.cmn.func.a.a.a.c;
import com.opos.cmn.func.a.a.a.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.opos.cmn.func.a.a.a.b f7924a;
    public final c b;
    public final com.opos.cmn.func.a.a.a.a c;
    public final f d;
    public final e e;
    public final boolean f;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.opos.cmn.func.a.a.a.b f7925a;
        private c b;
        private f c;
        private com.opos.cmn.func.a.a.a.a d;
        private e e;
        private boolean f = true;

        public d a() {
            if (this.f7925a == null) {
                this.f7925a = new b.C0663b().a();
            }
            if (this.b == null) {
                this.b = new c.a().a();
            }
            if (this.c == null) {
                this.c = new f.a().a();
            }
            if (this.d == null) {
                this.d = new a.C0662a().a();
            }
            return new d(this);
        }
    }

    private d(a aVar) {
        this.f7924a = aVar.f7925a;
        this.b = aVar.b;
        this.d = aVar.c;
        this.c = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
    }

    public String toString() {
        return "HttpExtConfig{cloudConfig=" + this.f7924a + ", httpDnsConfig=" + this.b + ", appTraceConfig=" + this.c + ", iPv6Config=" + this.d + ", httpStatConfig=" + this.e + ", closeNetLog=" + this.f + '}';
    }
}
