package com.opos.mobad.c.a;

import android.content.Context;
import android.os.Bundle;
import com.opos.mobad.n.a.u;
import com.opos.mobad.n.a.v;
import com.opos.mobad.provider.strategy.AppInfo;
import com.opos.mobad.provider.strategy.StrategyInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8575a;
    private String b;
    private com.opos.mobad.provider.strategy.b c;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void a(u uVar, long j);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a();

        void a(Bundle bundle);
    }

    public c(Context context, String str, String str2) {
        this.f8575a = str;
        this.b = str2;
        this.c = new com.opos.mobad.provider.strategy.b(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(u uVar, long j) {
        com.opos.cmn.an.f.a.b("DispatchCache", "write app:", uVar);
        try {
            this.c.a(this.b, this.f8575a, new AppInfo(j, u.c.b(uVar)));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("DispatchCache", "write app fail", e);
        }
    }

    public void a(final a aVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppInfo appInfoB = c.this.c.b(c.this.f8575a);
                    if (appInfoB == null) {
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a();
                            return;
                        }
                        return;
                    }
                    u uVarA = u.c.a(appInfoB.b);
                    long j = appInfoB.f9176a;
                    a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.a(uVarA, j);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("DispatchCache", "readAppInfo fail", e);
                    a aVar4 = aVar;
                    if (aVar4 != null) {
                        aVar4.a();
                    }
                }
            }
        });
    }

    public void a(final b bVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Bundle bundleA = c.this.c.a(c.this.f8575a);
                    if (bundleA != null) {
                        b bVar2 = bVar;
                        if (bVar2 != null) {
                            bVar2.a(bundleA);
                            return;
                        }
                        return;
                    }
                    com.opos.cmn.an.f.a.b("DispatchCache", "readPosStrategy fail with strategyInfo null");
                    b bVar3 = bVar;
                    if (bVar3 != null) {
                        bVar3.a();
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("DispatchCache", "readPosStrategy fail", e);
                    b bVar4 = bVar;
                    if (bVar4 != null) {
                        bVar4.a();
                    }
                }
            }
        });
    }

    public void a(final u uVar, final long j) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(uVar.c().a(new ArrayList(0)).b(), j);
                Long l = uVar.j;
                c.this.a(uVar.g, l != null ? l.longValue() : 0L);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<v> list, long j) {
        com.opos.cmn.an.f.a.b("DispatchCache", "write strategy:", list);
        try {
            Bundle bundle = new Bundle();
            for (v vVar : list) {
                bundle.putByteArray(vVar.q, v.c.b(vVar));
            }
            this.c.a(this.f8575a, new StrategyInfo(j, bundle));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("DispatchCache", "write strategy fail", e);
        }
    }
}
