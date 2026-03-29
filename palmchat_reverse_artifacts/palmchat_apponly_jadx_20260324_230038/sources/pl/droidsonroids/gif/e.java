package pl.droidsonroids.gif;

import android.os.SystemClock;
import defpackage.x15;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class e extends x15 {
    public e(a aVar) {
        super(aVar);
    }

    @Override // defpackage.x15
    public void a() {
        a aVar = this.f21857a;
        long jU = aVar.g.u(aVar.f);
        if (jU >= 0) {
            this.f21857a.c = SystemClock.uptimeMillis() + jU;
            if (this.f21857a.isVisible() && this.f21857a.b) {
                a aVar2 = this.f21857a;
                if (!aVar2.l) {
                    aVar2.f20042a.remove(this);
                    a aVar3 = this.f21857a;
                    aVar3.p = aVar3.f20042a.schedule(this, jU, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.f21857a.h.isEmpty() && this.f21857a.b() == this.f21857a.g.l() - 1) {
                a aVar4 = this.f21857a;
                aVar4.m.sendEmptyMessageAtTime(aVar4.c(), this.f21857a.c);
            }
        } else {
            a aVar5 = this.f21857a;
            aVar5.c = Long.MIN_VALUE;
            aVar5.b = false;
        }
        if (!this.f21857a.isVisible() || this.f21857a.m.hasMessages(-1)) {
            return;
        }
        this.f21857a.m.sendEmptyMessageAtTime(-1, 0L);
    }
}
