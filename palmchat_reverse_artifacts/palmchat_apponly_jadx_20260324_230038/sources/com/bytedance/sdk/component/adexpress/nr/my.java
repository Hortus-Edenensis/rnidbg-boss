package com.bytedance.sdk.component.adexpress.nr;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.nr.jk;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class my implements jk {
    private mv b;
    private n fx;
    private AtomicBoolean iz = new AtomicBoolean(false);
    private com.bytedance.sdk.component.adexpress.pn.u nr;
    private ScheduledFuture<?> pn;
    private Context u;

    /* JADX INFO: compiled from: SearchBox */
    public class u implements Runnable {
        private int fx;
        jk.u u;

        public u(int i, jk.u uVar) {
            this.fx = i;
            this.u = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.fx == 1) {
                my.this.nr.u(true);
                my.this.u(this.u, 107, null);
            }
        }
    }

    public my(Context context, mv mvVar, com.bytedance.sdk.component.adexpress.pn.u uVar, n nVar) {
        this.u = context;
        this.b = mvVar;
        this.fx = nVar;
        this.nr = uVar;
        uVar.u(this.fx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx() {
        try {
            ScheduledFuture<?> scheduledFuture = this.pn;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.pn.cancel(false);
            this.pn = null;
        } catch (Throwable unused) {
        }
    }

    public com.bytedance.sdk.component.adexpress.pn.u nr() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.jk
    public boolean u(final jk.u uVar) {
        int iN = this.b.n();
        if (iN < 0) {
            u(uVar, 107, "time is ".concat(String.valueOf(iN)));
        } else {
            this.pn = com.bytedance.sdk.component.adexpress.b.pn.u(new u(1, uVar), iN, TimeUnit.MILLISECONDS);
            this.nr.u(new x() { // from class: com.bytedance.sdk.component.adexpress.nr.my.1
                @Override // com.bytedance.sdk.component.adexpress.nr.x
                public void u(View view, s sVar) {
                    k kVarNr;
                    my.this.fx();
                    if (uVar.fx() || (kVarNr = uVar.nr()) == null) {
                        return;
                    }
                    kVarNr.u(my.this.nr, sVar);
                    uVar.u(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.nr.x
                public void u(int i, String str) {
                    my.this.u(uVar, i, str);
                }
            });
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.jk
    public void u() {
        this.nr.b();
        fx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(jk.u uVar, int i, String str) {
        k kVarNr;
        if (uVar.fx() || this.iz.get()) {
            return;
        }
        fx();
        this.b.x().u(i, str);
        if (uVar.nr(this)) {
            uVar.u(this);
        } else {
            if (uVar.fx() || (kVarNr = uVar.nr()) == null) {
                return;
            }
            uVar.u(true);
            kVarNr.a_(i);
        }
        this.iz.getAndSet(true);
    }
}
