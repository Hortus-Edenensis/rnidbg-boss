package com.opos.cmn.func.dl.base.c;

import android.content.Context;
import com.opos.cmn.func.dl.base.c.d;
import java.io.InputStream;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a implements d {
    private d b;
    private d c;
    private int d = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f7974a = new f();

    public a(d.a aVar) {
        this.b = aVar.a();
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final InputStream a() {
        d dVar = this.c;
        return dVar != null ? dVar.a() : this.b.a();
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final String b() {
        d dVar = this.c;
        return dVar != null ? dVar.b() : this.b.b();
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final void c() {
        d dVar = this.c;
        if (dVar != null) {
            dVar.c();
        } else {
            this.b.c();
        }
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final int d() {
        d dVar = this.c;
        return dVar != null ? dVar.d() : this.b.d();
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final long e() {
        d dVar = this.c;
        if (dVar == null) {
            dVar = this.b;
        }
        long jE = dVar.e();
        return jE == -1 ? com.opos.cmn.func.dl.base.i.a.b(a(HttpHeaders.CONTENT_RANGE)) : jE;
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final InputStream a(Context context, String str, b bVar) {
        int i;
        InputStream inputStreamA;
        do {
            this.b.a(context, str, bVar);
            this.f7974a.a(context, this, str, bVar);
            if (com.opos.cmn.func.dl.base.i.a.a(d()) && (inputStreamA = a()) != null) {
                return inputStreamA;
            }
            i = this.d;
            this.d = i - 1;
        } while (i >= 0);
        return null;
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final String a(String str) {
        d dVar = this.c;
        return dVar != null ? dVar.a(str) : this.b.a(str);
    }

    public final void a(d dVar) {
        if (this != dVar) {
            this.c = dVar;
        }
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final void a(String str, String str2) {
        this.b.a(str, str2);
    }
}
