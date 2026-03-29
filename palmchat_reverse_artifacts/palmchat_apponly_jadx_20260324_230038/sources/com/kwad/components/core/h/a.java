package com.kwad.components.core.h;

import android.os.Handler;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a implements Runnable {
    private InterfaceC0540a Rf;

    @Nullable
    private volatile Handler iK;
    private long Rc = 1000;
    private boolean Rd = true;
    private long Re = 0;
    private float mSpeed = 1.0f;

    /* JADX INFO: renamed from: com.kwad.components.core.h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0540a {
        void D(long j);
    }

    public a(Handler handler) {
        this.iK = handler;
    }

    public final void a(InterfaceC0540a interfaceC0540a) {
        this.Rf = interfaceC0540a;
    }

    public final void destroy() {
        stop();
        this.iK = null;
    }

    public final void pause() {
        this.Rd = true;
    }

    public final void resume() {
        this.Rd = false;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        InterfaceC0540a interfaceC0540a;
        if (this.iK != null) {
            if (!this.Rd && (interfaceC0540a = this.Rf) != null) {
                interfaceC0540a.D(this.Re);
                this.Re += this.Rc;
            }
            if (this.iK != null) {
                this.iK.postDelayed(this, (long) (this.Rc / this.mSpeed));
            }
        }
    }

    public final void setSpeed(float f) {
        if (f > 0.0f) {
            this.mSpeed = f;
        }
    }

    public final void start() {
        this.Rd = false;
        if (this.iK != null) {
            this.iK.post(this);
        }
    }

    public final void stop() {
        if (this.iK != null) {
            this.iK.removeCallbacks(this);
        }
    }
}
