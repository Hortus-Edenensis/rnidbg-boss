package com.opos.cmn.an.f.b.a;

import android.text.TextUtils;
import com.opos.cmn.an.f.c.f;
import com.usertrace.cdo.usertrace.domain.dto.UserTraceConfigDto;
import defpackage.b37;
import defpackage.k17;
import defpackage.z27;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d implements com.opos.cmn.an.f.b.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.cmn.an.f.a.b f7752a;
    private k17 b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements b37.c {
        public a() {
        }

        @Override // b37.c
        public String a() {
            return "";
        }

        @Override // b37.c
        public String b() {
            return d.this.f7752a.i.a();
        }

        @Override // b37.c
        public String c() {
            return "";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements b37.b {
        public b() {
        }

        @Override // b37.b
        public String a() {
            return d.this.f7752a.h.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.opos.cmn.an.f.a.c f7755a;
        final /* synthetic */ com.opos.cmn.an.f.a.a b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements z27.f {

            /* JADX INFO: renamed from: com.opos.cmn.an.f.b.a.d$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C0645a implements z27.h {
                public C0645a() {
                }

                @Override // z27.h
                public void a() {
                    com.opos.cmn.an.f.a.a aVar = c.this.b;
                    if (aVar != null) {
                        aVar.onUploaderSuccess();
                    }
                }

                @Override // z27.h
                public void a(String str) {
                    com.opos.cmn.an.f.a.a aVar = c.this.b;
                    if (aVar != null) {
                        aVar.onUploaderFailed(str);
                    }
                }
            }

            public a() {
            }

            @Override // z27.f
            public void a(UserTraceConfigDto userTraceConfigDto) {
                try {
                    if (userTraceConfigDto != null) {
                        d.this.b.d(new C0645a());
                        d.this.b.e("advertise_sdk", String.valueOf(userTraceConfigDto.getTraceId()), userTraceConfigDto.getBeginTime(), userTraceConfigDto.getEndTime(), userTraceConfigDto.getForce() == 1, c.this.f7755a.f7748a);
                    } else {
                        com.opos.cmn.an.f.a.a aVar = c.this.b;
                        if (aVar != null) {
                            aVar.onDontNeedUpload("userTraceConfigDto is null");
                        }
                    }
                } catch (Throwable unused) {
                }
            }

            @Override // z27.f
            public void a(String str) {
                com.opos.cmn.an.f.a.a aVar = c.this.b;
                if (aVar != null) {
                    aVar.onDontNeedUpload(str);
                }
            }
        }

        public c(com.opos.cmn.an.f.a.c cVar, com.opos.cmn.an.f.a.a aVar) {
            this.f7755a = cVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.b.f("advertise_sdk", this.f7755a.f7748a, new a());
            } catch (Throwable unused) {
                com.opos.cmn.an.f.a.a aVar = this.b;
                if (aVar != null) {
                    aVar.onUploaderFailed("unkown error");
                }
            }
        }
    }

    private String c() {
        try {
            if (f.e()) {
                return this.f7752a.g.getExternalFilesDir(null) + File.separator + ".opos_ad_mmap_cache_log";
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private String b() {
        try {
            if (f.e()) {
                return this.f7752a.g.getExternalFilesDir(null) + File.separator + ".opos_ad_log";
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void a() {
        k17 k17Var = this.b;
        if (k17Var == null) {
            return;
        }
        try {
            k17Var.h();
        } catch (Throwable unused) {
        }
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void a(int i) {
        if (this.b != null) {
            if (f.b() || f.j()) {
                i = 1;
            }
            try {
                this.b.i(i);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void b(int i) {
        k17 k17Var = this.b;
        if (k17Var != null) {
            try {
                k17Var.b(i);
            } catch (Throwable unused) {
            }
        }
    }

    private void a(int i, String str, String str2) {
        try {
            k17 k17Var = this.b;
            if (k17Var != null && k17Var.a() != null) {
                if (i == 1) {
                    this.b.a().a(str, str2, com.opos.cmn.an.f.b.c.b());
                } else if (i == 2) {
                    this.b.a().e(str, str2, com.opos.cmn.an.f.b.c.b());
                } else if (i == 3) {
                    this.b.a().b(str, str2, com.opos.cmn.an.f.b.c.b());
                } else if (i == 4) {
                    this.b.a().c(str, str2, com.opos.cmn.an.f.b.c.b());
                } else if (i == 5) {
                    this.b.a().d(str, str2, com.opos.cmn.an.f.b.c.b());
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void a(com.opos.cmn.an.f.a.b bVar) {
        int i;
        this.f7752a = bVar;
        try {
            f.a();
            f.c(bVar.g);
            if (f.b() || f.j()) {
                com.opos.cmn.an.f.b.c.a();
                f.c();
                i = 1;
            } else {
                i = this.f7752a.c;
            }
            k17.b bVarD = k17.m().b(new com.opos.cmn.an.f.b.a.c()).l("ad").k(b()).i(c()).j(this.f7752a.d).a(this.f7752a.b).h(i).e(this.f7752a.f).c(new b()).d(new a());
            String strF = f.f();
            if (!TextUtils.isEmpty(strF)) {
                bVarD.m(strF);
            }
            this.b = bVarD.f(this.f7752a.g);
            k17.j(false);
        } catch (Throwable unused) {
        }
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void a(com.opos.cmn.an.f.a.c cVar, com.opos.cmn.an.f.a.a aVar) {
        if (cVar == null) {
            if (aVar != null) {
                aVar.onUploaderFailed("uploadParams is null");
                return;
            }
            return;
        }
        if (com.opos.cmn.an.d.b.a(cVar.f7748a)) {
            if (aVar != null) {
                aVar.onUploaderFailed("businessType is null");
            }
        } else {
            if (this.b == null) {
                if (aVar != null) {
                    aVar.onUploaderFailed("mLogger is null");
                    return;
                }
                return;
            }
            com.opos.cmn.an.f.a.b bVar = this.f7752a;
            if (bVar == null || com.opos.cmn.an.f.b.a.a(bVar.g)) {
                new Thread(new c(cVar, aVar)).start();
            } else if (aVar != null) {
                aVar.onUploaderFailed("log buried point switch is closed, cannot upload log");
            }
        }
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void a(com.opos.cmn.an.f.b.b.d dVar) {
        k17 k17Var;
        if (dVar != null) {
            try {
                if (dVar.b != null && dVar.f7761a != null && (k17Var = this.b) != null && k17Var.a() != null) {
                    int i = dVar.d;
                    String strA = f.a(dVar);
                    if (strA.length() > 3072 && com.opos.cmn.an.f.b.c.b()) {
                        int length = strA.length();
                        int i2 = 0;
                        while (length > i2) {
                            int i3 = i2 + 3072;
                            if (length <= i3) {
                                i3 = length;
                            }
                            a(i, this.f7752a.f7744a, strA.substring(i2, i3));
                            i2 = i3;
                        }
                        return;
                    }
                    a(i, this.f7752a.f7744a, strA);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void a(boolean z) {
        k17 k17Var = this.b;
        if (k17Var == null) {
            return;
        }
        try {
            k17Var.g(z);
        } catch (Throwable unused) {
        }
    }
}
