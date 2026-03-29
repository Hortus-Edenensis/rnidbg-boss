package com.bytedance.adsdk.ugeno.fx;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class t implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private bg f5032a;
    private AtomicInteger b;
    private AtomicInteger fx;
    private float iz;
    private c n;
    private AtomicInteger nr;
    private AtomicInteger pn;
    private AtomicInteger u;
    private l x;

    public boolean fx() {
        return this.u.get() > 0;
    }

    public int nr() {
        int i = (int) (this.iz * this.nr.get());
        this.u.set(i);
        return i;
    }

    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if ((TextUtils.equals(str, "src") || TextUtils.equals(str, "backgroundImage")) && str2.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.nr.incrementAndGet();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.fx.x
    public void nr(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str) {
        int iIncrementAndGet = this.pn.incrementAndGet();
        if (iIncrementAndGet > this.nr.get() - this.u.get()) {
            synchronized (this) {
                if (iIncrementAndGet > this.nr.get() - this.u.get() && this.f5032a != null) {
                    dw dwVar = new dw();
                    dwVar.u(-3);
                    dwVar.u("image download fail");
                    dwVar.u(fxVar.nr(fxVar));
                }
            }
        }
    }

    public void u(bg bgVar) {
        this.f5032a = bgVar;
    }

    public void u(c cVar) {
        this.n = cVar;
    }

    @Override // com.bytedance.adsdk.ugeno.fx.x
    public void u() {
        this.b.incrementAndGet();
        if (this.b.get() == 1) {
            synchronized (this) {
                this.b.get();
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.fx.x
    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str) {
        if (this.fx.incrementAndGet() == this.u.get()) {
            synchronized (this) {
                if (this.fx.get() == this.u.get()) {
                    if (this.x != null) {
                        this.nr.get();
                    }
                    if (this.f5032a != null) {
                        dw dwVar = new dw();
                        dwVar.u(0);
                        dwVar.u(fxVar.nr(fxVar));
                    }
                }
            }
        }
    }
}
