package com.bytedance.sdk.component.adexpress.u.nr;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.u.fx.u;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.bq;
import com.bytedance.sdk.component.utils.k;
import com.wifi.ad.core.config.EventParams;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends fx {
    private static volatile pn nr;
    private static File u;
    private AtomicBoolean fx = new AtomicBoolean(true);
    private AtomicBoolean b = new AtomicBoolean(false);
    private boolean pn = false;
    private AtomicBoolean iz = new AtomicBoolean(false);
    private AtomicInteger x = new AtomicInteger(0);
    private AtomicLong n = new AtomicLong();

    private pn() {
        n();
    }

    private void a() {
        if (this.x.getAndSet(0) <= 0 || System.currentTimeMillis() - this.n.get() <= 600000) {
            return;
        }
        iz();
    }

    private void n() {
        com.bytedance.sdk.component.adexpress.b.pn.nr(new a("init") { // from class: com.bytedance.sdk.component.adexpress.u.nr.pn.1
            @Override // java.lang.Runnable
            public void run() {
                n.u();
                pn.this.fx.set(false);
                pn.this.fx();
                pn.this.iz();
                if (com.bytedance.sdk.component.adexpress.u.u.u.u().fx() == null || !bq.u(com.bytedance.sdk.component.adexpress.u.u.u.u().fx().getContext())) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.u.u.u.u().fx().nr().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.u.nr.pn.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.bytedance.sdk.component.adexpress.u.u.u.u().fx() != null) {
                            com.bytedance.sdk.component.adexpress.u.u.u.u();
                        }
                    }
                });
            }
        }, 10);
    }

    public static pn nr() {
        if (nr == null) {
            synchronized (pn.class) {
                if (nr == null) {
                    nr = new pn();
                }
            }
        }
        return nr;
    }

    public static File x() {
        if (u == null) {
            try {
                File file = new File(new File(b.u(), "tt_tmpl_pkg"), EventParams.KEY_PARAM_TEMPLATE);
                file.mkdirs();
                u = file;
            } catch (Throwable th) {
                k.u("TemplateManager", "getTemplateDir error", th);
            }
        }
        return u;
    }

    public boolean b() {
        return this.pn;
    }

    public void fx() {
        com.bytedance.sdk.component.adexpress.u.fx.u uVarNr = n.nr();
        if (uVarNr == null || !uVarNr.iz()) {
            return;
        }
        boolean zU = u(uVarNr);
        if (!zU) {
            n.b();
        }
        this.pn = zU;
    }

    public void iz() {
        u(false);
    }

    public com.bytedance.sdk.component.adexpress.u.fx.u pn() {
        return n.nr();
    }

    public boolean u(com.bytedance.sdk.component.adexpress.u.fx.u uVar) {
        if (uVar == null) {
            return false;
        }
        return u(uVar.u()) || u(uVar.pn()) || u(uVar.getResources());
    }

    @Override // com.bytedance.sdk.component.adexpress.u.nr.fx
    public File u() {
        return x();
    }

    public void u(boolean z) {
        List<u.C0206u> listU;
        boolean z2;
        if (this.fx.get()) {
            return;
        }
        try {
            if (this.b.get()) {
                if (z) {
                    this.x.getAndIncrement();
                    return;
                }
                return;
            }
            boolean z3 = true;
            this.b.set(true);
            com.bytedance.sdk.component.adexpress.u.fx.u uVarFx = com.bytedance.sdk.component.adexpress.u.u.u.u().fx().fx();
            com.bytedance.sdk.component.adexpress.u.fx.u uVarNr = n.nr();
            if (uVarFx != null && uVarFx.iz()) {
                if (!n.nr(uVarFx)) {
                    this.b.set(false);
                    this.n.set(System.currentTimeMillis());
                    return;
                }
                if (com.bytedance.sdk.component.adexpress.u.u.u.u().fx() != null) {
                    com.bytedance.sdk.component.adexpress.u.u.u.u().fx().nr().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.u.nr.pn.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.component.adexpress.pn.pn.u().nr();
                        }
                    });
                }
                n.u(uVarFx);
                boolean zU = (uVarFx.pn() == null || TextUtils.isEmpty(uVarFx.pn().u())) ? false : u(uVarFx.pn().u());
                if (uVarFx.u().size() != 0) {
                    listU = u(uVarFx, uVarNr);
                    z2 = listU != null;
                } else {
                    listU = null;
                    z2 = zU;
                }
                if (!zU) {
                    List<u.C0206u> listNr = nr(uVarFx, uVarNr);
                    if (listU == null || listNr == null) {
                        listU = listNr;
                    } else {
                        listU.addAll(listNr);
                    }
                    if (listNr == null) {
                        z3 = false;
                    }
                    if (listNr == null) {
                        this.b.set(false);
                    }
                    z2 = z3;
                }
                if (z2 && u(uVarFx)) {
                    n.u(uVarFx);
                    n.fx();
                    nr(listU);
                }
                fx();
                this.b.set(false);
                this.n.set(System.currentTimeMillis());
                a();
                return;
            }
            this.b.set(false);
            u(109);
        } catch (Throwable unused) {
        }
    }
}
