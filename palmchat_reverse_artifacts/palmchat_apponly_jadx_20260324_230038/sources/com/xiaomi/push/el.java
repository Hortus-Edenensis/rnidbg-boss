package com.xiaomi.push;

import com.xiaomi.push.em;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
class el implements am.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11541a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private fa f382a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private XMPushService f383a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private am.b f384a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f386a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private am.c f385a = am.c.binding;

    /* JADX INFO: renamed from: com.xiaomi.push.el$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11543a;

        static {
            int[] iArr = new int[am.c.values().length];
            f11543a = iArr;
            try {
                iArr[am.c.unbind.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11543a[am.c.binding.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11543a[am.c.binded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public el(XMPushService xMPushService, am.b bVar) {
        this.f383a = xMPushService;
        this.f384a = bVar;
    }

    private void b() {
        this.f384a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        if (this.f386a && this.f11541a != 11) {
            ej ejVarM408a = eo.m406a().m408a();
            int i = AnonymousClass2.f11543a[this.f385a.ordinal()];
            if (i == 1) {
                int i2 = this.f11541a;
                if (i2 == 17) {
                    ejVarM408a.f368a = ei.BIND_TCP_READ_TIMEOUT.a();
                } else if (i2 == 21) {
                    ejVarM408a.f368a = ei.BIND_TIMEOUT.a();
                } else {
                    try {
                        em.a aVarC = em.c(eo.a().a());
                        ejVarM408a.f368a = aVarC.f11544a.a();
                        ejVarM408a.c(aVarC.f387a);
                    } catch (NullPointerException unused) {
                        ejVarM408a = null;
                    }
                }
            } else if (i == 3) {
                ejVarM408a.f368a = ei.BIND_SUCCESS.a();
            }
            if (ejVarM408a != null) {
                ejVarM408a.b(this.f382a.mo438a());
                ejVarM408a.d(this.f384a.f939b);
                ejVarM408a.f371b = 1;
                try {
                    ejVarM408a.a((byte) Integer.parseInt(this.f384a.g));
                } catch (NumberFormatException unused2) {
                }
                eo.m406a().a(ejVarM408a);
            }
        }
    }

    public void a() {
        this.f384a.a(this);
        this.f382a = this.f383a.m684a();
    }

    @Override // com.xiaomi.push.service.am.b.a
    public void a(am.c cVar, am.c cVar2, int i) {
        if (!this.f386a && cVar == am.c.binding) {
            this.f385a = cVar2;
            this.f11541a = i;
            this.f386a = true;
        }
        this.f383a.a(new XMPushService.j(4) { // from class: com.xiaomi.push.el.1
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "Handling bind stats";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public void mo403a() {
                el.this.c();
            }
        });
    }
}
