package com.bykv.vk.openvk.component.video.u.b;

import com.bykv.vk.openvk.component.video.u.b.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class u implements fx {
    private fx.u b;
    private fx.nr fx;
    private fx.x iz;
    private fx.b n;
    private fx.pn nr;
    private fx.iz pn;
    protected boolean u = false;
    private fx.InterfaceC0157fx x;

    public final void b() {
        try {
            fx.iz izVar = this.pn;
            if (izVar != null) {
                izVar.fx(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.iz.fx.u("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    public final void fx() {
        try {
            fx.nr nrVar = this.fx;
            if (nrVar != null) {
                nrVar.u(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.iz.fx.u("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    public final void nr() {
        try {
            fx.pn pnVar = this.nr;
            if (pnVar != null) {
                pnVar.nr(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.iz.fx.u("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public final void u(fx.pn pnVar) {
        this.nr = pnVar;
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public final void u(fx.nr nrVar) {
        this.fx = nrVar;
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public final void u(fx.u uVar) {
        this.b = uVar;
    }

    public final boolean nr(int i, int i2) {
        try {
            fx.b bVar = this.n;
            if (bVar != null) {
                if (bVar.nr(this, i, i2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.iz.fx.u("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public final void u(fx.iz izVar) {
        this.pn = izVar;
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public final void u(fx.InterfaceC0157fx interfaceC0157fx) {
        this.x = interfaceC0157fx;
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public final void u(fx.b bVar) {
        this.n = bVar;
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public final void u(fx.x xVar) {
        this.iz = xVar;
    }

    public void u() {
        this.nr = null;
        this.b = null;
        this.fx = null;
        this.pn = null;
        this.iz = null;
        this.x = null;
        this.n = null;
    }

    public final void u(int i) {
        try {
            fx.u uVar = this.b;
            if (uVar != null) {
                uVar.u(this, i);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.iz.fx.u("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    public final void u(int i, int i2, int i3, int i4) {
        try {
            fx.x xVar = this.iz;
            if (xVar != null) {
                xVar.u(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.iz.fx.u("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    public final boolean u(int i, int i2) {
        try {
            fx.InterfaceC0157fx interfaceC0157fx = this.x;
            if (interfaceC0157fx != null) {
                if (interfaceC0157fx.u(this, i, i2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.iz.fx.u("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx
    public void u(boolean z) {
        this.u = z;
    }
}
