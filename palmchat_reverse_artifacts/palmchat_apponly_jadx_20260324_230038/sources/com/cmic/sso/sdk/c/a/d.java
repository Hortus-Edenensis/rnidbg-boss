package com.cmic.sso.sdk.c.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import com.cmic.sso.sdk.e.n;
import com.cmic.sso.sdk.e.r;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f5494a;

    @Override // com.cmic.sso.sdk.c.a.b
    public void a(final com.cmic.sso.sdk.c.c.c cVar, final com.cmic.sso.sdk.c.d.c cVar2, final com.cmic.sso.sdk.a aVar) {
        if (!cVar.b()) {
            b(cVar, cVar2, aVar);
        } else {
            final r rVarA = r.a((Context) null);
            rVarA.a(new r.a() { // from class: com.cmic.sso.sdk.c.a.d.1
                private final AtomicBoolean f = new AtomicBoolean(false);

                @Override // com.cmic.sso.sdk.e.r.a
                public void a(final Network network, final ConnectivityManager.NetworkCallback networkCallback) {
                    if (this.f.getAndSet(true)) {
                        return;
                    }
                    n.a(new n.a(null, aVar) { // from class: com.cmic.sso.sdk.c.a.d.1.1
                        @Override // com.cmic.sso.sdk.e.n.a
                        public void a() {
                            if (network != null) {
                                com.cmic.sso.sdk.e.c.b("WifiChangeInterceptor", "onAvailable");
                                cVar.a(network);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                d.this.b(cVar, cVar2, aVar);
                            } else {
                                cVar2.a(com.cmic.sso.sdk.c.d.a.a(102508));
                            }
                            rVarA.a(networkCallback);
                        }
                    });
                }
            });
        }
    }

    public void b(com.cmic.sso.sdk.c.c.c cVar, final com.cmic.sso.sdk.c.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        b bVar = this.f5494a;
        if (bVar != null) {
            bVar.a(cVar, new com.cmic.sso.sdk.c.d.c() { // from class: com.cmic.sso.sdk.c.a.d.2
                @Override // com.cmic.sso.sdk.c.d.c
                public void a(com.cmic.sso.sdk.c.d.b bVar2) {
                    cVar2.a(bVar2);
                }

                @Override // com.cmic.sso.sdk.c.d.c
                public void a(com.cmic.sso.sdk.c.d.a aVar2) {
                    cVar2.a(aVar2);
                }
            }, aVar);
        }
    }

    public void a(b bVar) {
        this.f5494a = bVar;
    }
}
