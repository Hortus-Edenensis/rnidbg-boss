package com.beizi.ad.v2.d;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.beizi.ad.d;
import com.beizi.ad.e;
import com.beizi.ad.internal.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends com.beizi.ad.v2.a.b {
    private d G;
    private String H;
    private e I;

    public b(Context context, String str, int i) {
        super(context, str, f.NATIVE);
    }

    public void f(String str) {
        this.H = str;
    }

    public String u() {
        return this.H;
    }

    @Override // com.beizi.ad.v2.a.b
    public void b(final int i) {
        if (this.G == null || this.j || this.g) {
            return;
        }
        this.j = true;
        Handler handler = this.F;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.beizi.ad.v2.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.G != null) {
                        b.this.G.a(i);
                    }
                }
            });
        }
    }

    public void a(d dVar) {
        this.G = dVar;
    }

    public void a(View view, final com.beizi.ad.internal.c.c cVar) {
        e eVar = this.I;
        if (eVar == null || view == null || cVar == null) {
            return;
        }
        eVar.a(view, new com.beizi.ad.internal.c.c() { // from class: com.beizi.ad.v2.d.b.1
            @Override // com.beizi.ad.internal.c.c
            public void a() {
                if (((com.beizi.ad.v2.a.b) b.this).t) {
                    ((com.beizi.ad.v2.a.b) b.this).u = true;
                    com.beizi.ad.internal.a.a.a().a(((com.beizi.ad.v2.a.b) b.this).r);
                }
                com.beizi.ad.internal.c.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.a();
                }
            }
        });
    }

    @Override // com.beizi.ad.v2.a.b
    public void a(com.beizi.ad.internal.d.a aVar) {
        e eVarA = aVar.a();
        this.I = eVarA;
        if (eVarA == null) {
            Handler handler = this.F;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.beizi.ad.v2.d.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.G != null) {
                            b.this.G.a(3);
                        }
                    }
                });
                return;
            }
            return;
        }
        b(aVar.b());
        c(aVar.c());
        a(aVar.A());
        f(this.I.l());
        ((com.beizi.ad.internal.c.a) this.I).a(this.t);
        ((com.beizi.ad.internal.c.a) this.I).a(this.l);
        Handler handler2 = this.F;
        if (handler2 != null) {
            handler2.post(new Runnable() { // from class: com.beizi.ad.v2.d.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.G != null) {
                        b.this.G.a(b.this.I);
                    }
                }
            });
        }
    }
}
