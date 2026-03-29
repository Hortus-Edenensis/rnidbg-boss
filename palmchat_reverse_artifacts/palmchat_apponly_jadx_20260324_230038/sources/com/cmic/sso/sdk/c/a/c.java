package com.cmic.sso.sdk.c.a;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f5492a;
    private com.cmic.sso.sdk.c.d.c b;
    private final com.cmic.sso.sdk.c.b c = new com.cmic.sso.sdk.c.b();

    public void b(final com.cmic.sso.sdk.c.c.c cVar, final com.cmic.sso.sdk.c.d.c cVar2, final com.cmic.sso.sdk.a aVar) {
        if (this.f5492a != null) {
            this.b = new com.cmic.sso.sdk.c.d.c() { // from class: com.cmic.sso.sdk.c.a.c.1
                @Override // com.cmic.sso.sdk.c.d.c
                public void a(com.cmic.sso.sdk.c.d.b bVar) {
                    if (bVar.d()) {
                        c.this.b(c.this.c.a(cVar, bVar, aVar), cVar2, aVar);
                    } else if (TextUtils.isEmpty(c.this.c.a())) {
                        cVar2.a(bVar);
                    } else {
                        c.this.b(c.this.c.b(cVar, bVar, aVar), cVar2, aVar);
                    }
                }

                @Override // com.cmic.sso.sdk.c.d.c
                public void a(com.cmic.sso.sdk.c.d.a aVar2) {
                    if (cVar.j()) {
                        com.cmic.sso.sdk.e.c.a("RetryAndRedirectInterceptor", "retry: " + cVar.a());
                        c.this.b(cVar, cVar2, aVar);
                        return;
                    }
                    cVar2.a(aVar2);
                }
            };
            if (cVar.g()) {
                this.f5492a.a(cVar, this.b, aVar);
            } else {
                cVar2.a(com.cmic.sso.sdk.c.d.a.a(200025));
            }
        }
    }

    @Override // com.cmic.sso.sdk.c.a.b
    public void a(com.cmic.sso.sdk.c.c.c cVar, com.cmic.sso.sdk.c.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        b(cVar, cVar2, aVar);
    }

    public void a(b bVar) {
        this.f5492a = bVar;
    }
}
