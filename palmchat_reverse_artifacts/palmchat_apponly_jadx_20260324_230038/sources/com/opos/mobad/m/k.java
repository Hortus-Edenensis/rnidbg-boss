package com.opos.mobad.m;

import android.app.Activity;
import com.oplus.tbl.exoplayer2.Renderer;
import com.opos.mobad.ad.m;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class k extends j implements com.opos.mobad.ad.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m.a f8991a;

    public k(m.a aVar) {
        super(aVar);
        this.f8991a = aVar;
    }

    @Override // com.opos.mobad.ad.m
    public void a(final Activity activity) {
        d(new Callable<Boolean>() { // from class: com.opos.mobad.m.k.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(k.this.b(activity));
            }
        });
    }

    public abstract boolean b(Activity activity);

    public final void d(Callable<Boolean> callable) {
        int iA = this.f.a(3, callable);
        com.opos.cmn.an.f.a.b("SyncStateController", "showAd state=" + iA + ",Ad =" + this);
        switch (iA) {
            case 0:
            case 1:
            case 6:
                b(10006, "ad data is null");
                break;
            case 2:
            case 3:
                break;
            case 4:
                b(10008, "ad had showed, please reload");
                break;
            case 5:
                b(Renderer.MSG_ENABLE_VIDEO_RENDER_STUCK_DETECTOR, "ad has destroyed.");
                break;
            default:
                b(-1, "show with illegal state:" + iA);
                break;
        }
    }

    public final void e(final int i, final String str) {
        if (c() == 3) {
            this.e.post(new Runnable() { // from class: com.opos.mobad.m.k.2
                @Override // java.lang.Runnable
                public void run() {
                    int iA = k.this.f.a(3, 4);
                    com.opos.cmn.an.f.a.b("SyncStateController", "onShowAdFailed state=" + iA + ",Ad = " + this);
                    if (5 == iA) {
                        return;
                    }
                    if (iA == 4) {
                        k.this.b(i, str);
                        return;
                    }
                    k.this.b(-1, "show fail with illegal state:" + iA);
                }
            });
        } else {
            super.d(i, str);
        }
    }

    @Override // com.opos.mobad.m.j
    public void n() {
        m.a aVar;
        if (4 != this.f.a(4) || (aVar = this.f8991a) == null) {
            return;
        }
        aVar.onAdClose();
    }

    @Override // com.opos.mobad.m.j
    public void o() {
        this.f = l.b();
    }

    public final void q() {
        m.a aVar;
        if (5 == c() || (aVar = this.f8991a) == null) {
            return;
        }
        aVar.onAdClick(0L);
    }

    public final void r() {
        m.a aVar;
        if (5 == c() || (aVar = this.f8991a) == null) {
            return;
        }
        aVar.onAdShow("");
    }
}
