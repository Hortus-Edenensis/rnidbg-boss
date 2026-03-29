package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.content.Context;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.adsdk.ugeno.fx.dw;
import com.bytedance.sdk.component.adexpress.nr.jk;
import com.bytedance.sdk.component.adexpress.nr.k;
import com.bytedance.sdk.component.adexpress.nr.mv;
import com.bytedance.sdk.component.adexpress.nr.n;
import com.bytedance.sdk.component.adexpress.nr.s;
import com.bytedance.sdk.component.jk.x;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements jk {
    private ScheduledFuture<?> b;
    private mv fx;
    private b nr;
    private AtomicBoolean pn = new AtomicBoolean(false);
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
                pn.this.nr.u(true);
                pn.this.u(this.u, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
            }
        }
    }

    public pn(Context context, b bVar, n nVar, mv mvVar) {
        this.u = context;
        this.nr = bVar;
        this.fx = mvVar;
        this.nr.u(nVar);
    }

    private void nr() {
        try {
            ScheduledFuture<?> scheduledFuture = this.b;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.b.cancel(false);
            this.b = null;
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.jk
    public boolean u(final jk.u uVar) {
        int iN = this.fx.n();
        if (iN < 0) {
            u(uVar, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
        } else {
            this.b = x.b().schedule(new u(1, uVar), iN, TimeUnit.MILLISECONDS);
            this.nr.u(new com.bytedance.sdk.component.adexpress.nr.x() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.pn.1
                @Override // com.bytedance.sdk.component.adexpress.nr.x
                public void u(View view, s sVar) {
                    if (uVar.fx()) {
                        return;
                    }
                    dw dwVar = new dw();
                    dwVar.u(0);
                    ((nr) pn.this.fx).pb().u(dwVar);
                    pn.this.fx.x().mv();
                    k kVarNr = uVar.nr();
                    if (kVarNr == null) {
                        return;
                    }
                    kVarNr.u(pn.this.nr, sVar);
                    uVar.u(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.nr.x
                public void u(int i, String str) {
                    k kVarNr;
                    dw dwVar = new dw();
                    dwVar.u(i);
                    dwVar.u(str);
                    ((nr) pn.this.fx).pb().u(dwVar);
                    if (uVar.nr(pn.this)) {
                        uVar.u(pn.this);
                    } else {
                        if (uVar.fx() || (kVarNr = uVar.nr()) == null) {
                            return;
                        }
                        kVarNr.a_(i);
                    }
                }
            });
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.jk
    public void u() {
        b bVar = this.nr;
        if (bVar != null) {
            bVar.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(jk.u uVar, int i) {
        k kVarNr;
        if (uVar.fx() || this.pn.get()) {
            return;
        }
        nr();
        dw dwVar = new dw();
        dwVar.u(i);
        ((nr) this.fx).pb().u(dwVar);
        if (uVar.nr(this)) {
            uVar.u(this);
        } else {
            if (uVar.fx() || (kVarNr = uVar.nr()) == null) {
                return;
            }
            uVar.u(true);
            kVarNr.a_(i);
        }
        this.pn.getAndSet(true);
    }
}
