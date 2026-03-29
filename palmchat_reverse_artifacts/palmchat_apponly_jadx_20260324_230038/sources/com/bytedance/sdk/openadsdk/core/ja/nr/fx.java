package com.bytedance.sdk.openadsdk.core.ja.nr;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.component.utils.gi;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.n;
import com.igexin.sdk.PushConsts;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private final gi.u b;
    private final AtomicBoolean fx;
    private int nr;
    private final Queue<nr> u;

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void u() throws Exception;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static final fx u = new fx();
    }

    private fx() {
        this.u = new ConcurrentLinkedQueue();
        this.fx = new AtomicBoolean(false);
        gi.u uVar = new gi.u() { // from class: com.bytedance.sdk.openadsdk.core.ja.nr.fx.1
            @Override // com.bytedance.sdk.component.utils.gi.u
            public void u(Context context, Intent intent, boolean z, int i) {
                if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction())) {
                    if (n.o().ja()) {
                        fx.this.u(this);
                        return;
                    }
                    if (fx.this.nr == 0 && i != 0) {
                        fx.this.u.size();
                        fx.this.nr();
                    }
                    fx.this.nr = i;
                }
            }
        };
        this.b = uVar;
        gi.u(uVar, dw.getContext());
        this.nr = o.fx(dw.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr() {
        while (!this.u.isEmpty()) {
            nr nrVarPoll = this.u.poll();
            if (nrVarPoll != null) {
                nr(nrVarPoll);
            }
        }
    }

    public static fx u() {
        return u.u;
    }

    private void nr(final nr nrVar) {
        x.nr(new a("pl download retry") { // from class: com.bytedance.sdk.openadsdk.core.ja.nr.fx.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    nrVar.u();
                } catch (Exception e) {
                    fx.this.u(nrVar, e);
                }
            }
        });
    }

    public void u(nr nrVar) {
        if (n.o().ja()) {
            u(this.b);
        } else {
            if (this.fx.get()) {
                return;
            }
            this.nr = 0;
            this.u.offer(nrVar);
            this.u.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(nr nrVar, Exception exc) {
        Log.getStackTraceString(exc);
    }

    public void u(gi.u uVar) {
        this.fx.set(true);
        gi.u(uVar);
        this.u.clear();
    }
}
