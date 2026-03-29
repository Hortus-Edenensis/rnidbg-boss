package com.opos.mobad.f.a.d;

import com.opos.cmn.i.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f8846a = new AtomicInteger(0);
    private final AtomicBoolean b = new AtomicBoolean(false);
    private com.opos.cmn.i.a c = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.f.a.d.a.1
        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0673a interfaceC0673a) {
            a.this.b();
            interfaceC0673a.a();
        }
    }, Integer.MAX_VALUE, 6000);

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        if (this.b.get()) {
            return true;
        }
        if (this.f8846a.incrementAndGet() < 3) {
            return false;
        }
        com.opos.cmn.an.f.a.b("Ads-Intercept", "meet server intercept count");
        return this.b.compareAndSet(false, true);
    }

    public boolean a() {
        return this.b.get();
    }
}
