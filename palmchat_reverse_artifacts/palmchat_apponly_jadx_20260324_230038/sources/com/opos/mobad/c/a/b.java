package com.opos.mobad.c.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.func.a.a.d;
import com.opos.cmn.i.a;
import com.opos.mobad.b.a.j;
import com.opos.mobad.b.a.k;
import com.opos.mobad.b.a.m;
import com.opos.mobad.b.a.n;
import com.opos.mobad.b.a.o;
import com.opos.mobad.provider.record.ControlEntity;
import com.opos.mobad.service.c.a;
import defpackage.g23;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8571a;
    private String b;
    private int c;
    private int d;
    private com.opos.mobad.provider.record.a e;
    private AtomicReference<ControlEntity> f = new AtomicReference<>(null);
    private com.opos.cmn.i.a g = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.c.a.b.1
        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0673a interfaceC0673a) {
            if (b.this.e == null) {
                interfaceC0673a.b();
            } else {
                b.this.a(interfaceC0673a);
            }
        }
    }, 10000, 0);

    private String f() {
        return "https://uapi.ads.heytapmobi.com/union/strategy/ability/select";
    }

    public boolean c() {
        ControlEntity controlEntity = this.f.get();
        if (controlEntity != null) {
            return controlEntity.c;
        }
        this.g.a();
        return k.g.booleanValue();
    }

    public boolean d() {
        ControlEntity controlEntity = this.f.get();
        if (controlEntity != null) {
            return controlEntity.e;
        }
        this.g.a();
        return k.m.booleanValue();
    }

    public boolean e() {
        ControlEntity controlEntity = this.f.get();
        if (controlEntity != null) {
            return controlEntity.f;
        }
        this.g.a();
        return k.o.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a.InterfaceC0673a interfaceC0673a) {
        try {
            m.a aVarM = new m.a().b(com.opos.mobad.service.d.b.a().getAndroidId()).c("").g(com.opos.mobad.service.c.a.a().h()).h(com.opos.mobad.service.c.a.a().i()).i(com.opos.mobad.service.c.a.a().j()).m(com.opos.mobad.service.c.a.a().b());
            a.C0768a c0768aM = com.opos.mobad.service.c.a.a().m();
            if (c0768aM != null) {
                aVarM.a(c0768aM.f9210a).a((Integer) 1);
            } else {
                aVarM.a("");
            }
            n nVarB = new n.a().a(aVarM.b()).a(new o.a().c(com.opos.cmn.an.c.c.c()).a(com.opos.cmn.an.c.d.b()).b(com.opos.cmn.an.c.d.a()).b()).c(com.opos.cmn.an.c.a.a(this.f8571a)).a(com.opos.cmn.an.c.c.a()).b();
            HashMap map = new HashMap();
            map.put("Content-Type", "application/x-protobuf");
            map.put("Route-Data", com.opos.cmn.biz.a.e.a(this.f8571a));
            d.a aVarB = new d.a().a(j.c.b(new j.a().a(this.b).a(nVarB).b(this.f8571a.getPackageName()).b(Integer.valueOf(this.c)).a(Integer.valueOf(this.d)).a(Boolean.valueOf(com.opos.mobad.service.c.a.a().l())).b(Boolean.valueOf(com.opos.mobad.service.c.a.a().f())).b())).a(map).b(f());
            aVarB.a("POST");
            com.opos.cmn.func.a.a.e eVarA = com.opos.cmn.func.a.a.b.a().a(this.f8571a, aVarB.a());
            if (eVarA == null || 200 != eVarA.f7934a) {
                interfaceC0673a.b();
                return;
            }
            k kVarA = k.c.a(eVarA.c);
            com.opos.cmn.an.f.a.b("ControlConfig", "control succ:", kVarA);
            Boolean bool = kVarA.s;
            if (bool == null) {
                bool = k.e;
            }
            boolean zBooleanValue = bool.booleanValue();
            Boolean bool2 = kVarA.t;
            if (bool2 == null) {
                bool2 = k.f;
            }
            boolean zBooleanValue2 = bool2.booleanValue();
            Boolean bool3 = kVarA.u;
            if (bool3 == null) {
                bool3 = k.g;
            }
            boolean zBooleanValue3 = bool3.booleanValue();
            Boolean bool4 = kVarA.A;
            if (bool4 == null) {
                bool4 = k.m;
            }
            boolean zBooleanValue4 = bool4.booleanValue();
            Boolean bool5 = kVarA.C;
            if (bool5 == null) {
                bool5 = k.o;
            }
            ControlEntity controlEntity = new ControlEntity(zBooleanValue, zBooleanValue2, zBooleanValue3, System.currentTimeMillis(), zBooleanValue4, bool5.booleanValue());
            this.f.set(controlEntity);
            try {
                this.e.a(controlEntity);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ControlConfig", "set local fail", e);
            }
            interfaceC0673a.a();
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("ControlConfig", "refresh fail", th);
            interfaceC0673a.b();
        }
    }

    public void a(Context context, String str, int i, int i2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f8571a = context;
        this.b = str;
        this.e = new com.opos.mobad.provider.record.a(context);
        this.c = i;
        this.d = i2;
        this.g.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.InterfaceC0673a interfaceC0673a) {
        if (this.f.get() == null) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (b.this.f.get() == null) {
                            ControlEntity controlEntityD = b.this.e.d();
                            g23.a(b.this.f, null, controlEntityD);
                            com.opos.cmn.an.f.a.b("ControlConfig", "control local:" + controlEntityD);
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.c("ControlConfig", "loal fail", e);
                    }
                }
            });
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(interfaceC0673a);
            }
        });
    }

    public boolean b() {
        ControlEntity controlEntity = this.f.get();
        if (controlEntity != null) {
            return controlEntity.b;
        }
        this.g.a();
        return k.f.booleanValue();
    }

    public boolean a() {
        ControlEntity controlEntity = this.f.get();
        if (controlEntity != null) {
            return controlEntity.f9171a;
        }
        this.g.a();
        return k.e.booleanValue();
    }
}
