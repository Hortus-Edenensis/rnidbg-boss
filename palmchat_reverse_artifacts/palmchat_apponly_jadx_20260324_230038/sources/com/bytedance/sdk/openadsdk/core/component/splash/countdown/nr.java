package com.bytedance.sdk.openadsdk.core.component.splash.countdown;

import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.component.utils.rh;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements rh.u {
    private u nr;
    private AtomicBoolean fx = new AtomicBoolean(true);
    protected final rh u = new rh(Looper.getMainLooper(), this);
    private int b = 5;
    private int pn = 1;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u();

        void u(int i);
    }

    private void b() {
        try {
            this.u.removeMessages(1);
        } catch (Throwable unused) {
        }
    }

    private void fx() {
        this.u.removeMessages(1);
        this.pn = 1;
    }

    private void iz() {
        try {
            int i = this.pn;
            if (i >= this.b + 1) {
                u uVar = this.nr;
                if (uVar != null) {
                    uVar.u();
                    return;
                }
                return;
            }
            int i2 = i + 1;
            this.pn = i2;
            u uVar2 = this.nr;
            if (uVar2 != null) {
                uVar2.u(i2);
            }
            this.u.sendEmptyMessageDelayed(1, 1000L);
        } catch (Exception unused) {
        }
    }

    private void pn() {
        try {
            this.u.sendEmptyMessage(1);
        } catch (Throwable unused) {
        }
    }

    public void nr() {
        fx();
        this.u.sendEmptyMessage(1);
    }

    public void u() {
        fx();
    }

    public void u(boolean z) {
        this.fx.set(z);
        if (this.fx.get()) {
            pn();
        } else {
            b();
        }
    }

    public void u(u uVar) {
        this.nr = uVar;
    }

    public void u(int i) {
        this.b = i;
        fx();
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        if (message.what == 1) {
            iz();
        }
    }
}
