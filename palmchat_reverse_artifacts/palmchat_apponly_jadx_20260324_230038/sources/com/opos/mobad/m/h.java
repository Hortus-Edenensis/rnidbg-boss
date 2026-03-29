package com.opos.mobad.m;

import android.app.Activity;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class h extends k implements com.opos.mobad.ad.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.f.b f8979a;

    public h(com.opos.mobad.ad.f.b bVar) {
        super(bVar);
        this.f8979a = bVar;
    }

    public final void a(long j) {
        com.opos.mobad.ad.f.b bVar;
        if (c() == 5 || (bVar = this.f8979a) == null) {
            return;
        }
        bVar.onAdClick(j);
    }

    public final void b(long j) {
        com.opos.mobad.ad.f.b bVar;
        if (c() == 5 || (bVar = this.f8979a) == null) {
            return;
        }
        bVar.onVideoPlayClose(j);
    }

    public abstract boolean b(boolean z);

    public final void e(String str) {
        com.opos.mobad.ad.f.b bVar;
        if (c() == 5 || (bVar = this.f8979a) == null) {
            return;
        }
        bVar.onVideoPlayError(str);
    }

    public boolean h() {
        return false;
    }

    public final void i() {
        com.opos.mobad.ad.f.b bVar;
        if (c() == 5 || (bVar = this.f8979a) == null) {
            return;
        }
        bVar.onVideoPlayStart();
    }

    public final void j() {
        com.opos.mobad.ad.f.b bVar;
        if (c() == 5 || (bVar = this.f8979a) == null) {
            return;
        }
        bVar.onVideoPlayComplete();
    }

    public final void k() {
        com.opos.mobad.ad.f.b bVar;
        if (c() == 5 || (bVar = this.f8979a) == null) {
            return;
        }
        bVar.onLandingPageOpen();
    }

    public final void m() {
        com.opos.mobad.ad.f.b bVar;
        if (c() == 5 || (bVar = this.f8979a) == null) {
            return;
        }
        bVar.onLandingPageClose();
    }

    @Override // com.opos.mobad.ad.f.a
    public void a(final boolean z) {
        d(new Callable<Boolean>() { // from class: com.opos.mobad.m.h.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(h.this.b(z));
            }
        });
    }

    @Override // com.opos.mobad.m.k
    public boolean b(Activity activity) {
        return b(false);
    }

    public final void a(Object... objArr) {
        com.opos.mobad.ad.f.b bVar;
        if (c() == 5 || (bVar = this.f8979a) == null) {
            return;
        }
        bVar.onReward(objArr);
    }

    public void g() {
    }
}
