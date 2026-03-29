package defpackage;

import com.ss.bytertc.engine.data.AudioRoute;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class qx implements ex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<ex> f20345a = new LinkedHashSet<>(3);
    public boolean b = false;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(boolean z, ex exVar) {
        synchronized (this.f20345a) {
            if (z) {
                this.f20345a.add(exVar);
            } else {
                this.f20345a.remove(exVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(ek2 ek2Var) {
        synchronized (this.f20345a) {
            this.b = true;
            Iterator<ex> it = this.f20345a.iterator();
            while (it.hasNext()) {
                ek2Var.a(it.next());
            }
            this.b = false;
        }
    }

    public void I(ex exVar) {
        if (exVar == null) {
            return;
        }
        v(exVar, false);
    }

    @Override // defpackage.ex
    public void a(final String str, final String str2) {
        w(new ek2() { // from class: gx
            @Override // defpackage.ek2
            public final void a(Object obj) {
                ((ex) obj).a(str, str2);
            }
        });
    }

    @Override // defpackage.ex
    public void b(final String str) {
        w(new ek2() { // from class: nx
            @Override // defpackage.ek2
            public final void a(Object obj) {
                ((ex) obj).b(str);
            }
        });
    }

    @Override // defpackage.ex
    public void c(final AudioRoute audioRoute) {
        w(new ek2() { // from class: fx
            @Override // defpackage.ek2
            public final void a(Object obj) {
                ((ex) obj).c(audioRoute);
            }
        });
    }

    @Override // defpackage.ex
    public void d(final String str, final boolean z) {
        w(new ek2() { // from class: kx
            @Override // defpackage.ek2
            public final void a(Object obj) {
                ((ex) obj).d(str, z);
            }
        });
    }

    @Override // defpackage.ex
    public void e(final int i) {
        w(new ek2() { // from class: hx
            @Override // defpackage.ek2
            public final void a(Object obj) {
                ((ex) obj).e(i);
            }
        });
    }

    @Override // defpackage.ex
    public void f(final HashMap<String, Boolean> map) {
        w(new ek2() { // from class: ox
            @Override // defpackage.ek2
            public final void a(Object obj) {
                ((ex) obj).f(map);
            }
        });
    }

    @Override // gy.b
    public void g(final VoipState voipState, final VoipState voipState2, final rh6 rh6Var) {
        w(new ek2() { // from class: lx
            @Override // defpackage.ek2
            public final void a(Object obj) {
                ((ex) obj).g(voipState, voipState2, rh6Var);
            }
        });
    }

    @Override // defpackage.ex
    public void h(final String str, final boolean z) {
        w(new ek2() { // from class: ix
            @Override // defpackage.ek2
            public final void a(Object obj) {
                ((ex) obj).h(str, z);
            }
        });
    }

    @Override // defpackage.ex
    public void i() {
        w(new ek2() { // from class: px
            @Override // defpackage.ek2
            public final void a(Object obj) {
                ((ex) obj).i();
            }
        });
    }

    public void u(ex exVar) {
        if (exVar == null) {
            return;
        }
        v(exVar, true);
    }

    public final void v(final ex exVar, final boolean z) {
        Runnable runnable = new Runnable() { // from class: jx
            @Override // java.lang.Runnable
            public final void run() {
                this.f18527a.x(z, exVar);
            }
        };
        if (this.b) {
            rg.b().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public final void w(final ek2<ex> ek2Var) {
        rg.a(new Runnable() { // from class: mx
            @Override // java.lang.Runnable
            public final void run() {
                this.f19382a.y(ek2Var);
            }
        });
    }
}
