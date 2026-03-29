package com.opos.exoplayer.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.exoplayer.core.C;
import com.opos.exoplayer.core.Player;
import com.opos.exoplayer.core.i;
import com.opos.exoplayer.core.w;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f8443a;
    private final StringBuilder b;
    private final Formatter c;
    private final w.a d;
    private final w.b e;
    private Player f;
    private com.opos.exoplayer.core.b g;
    private InterfaceC0709a h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private long[] r;
    private boolean[] s;
    private long[] t;
    private boolean[] u;
    private final Runnable v;
    private final Runnable w;

    /* JADX INFO: renamed from: com.opos.exoplayer.ui.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0709a {
        void a(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.l();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.c();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class d extends Player.a implements View.OnClickListener {
        private d() {
        }

        @Override // com.opos.exoplayer.core.Player.a, com.opos.exoplayer.core.Player.b
        public void a(int i) {
            a.this.i();
            a.this.h();
        }

        @Override // com.opos.exoplayer.core.Player.a, com.opos.exoplayer.core.Player.b
        public void b(int i) {
            a.this.h();
            a.this.l();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Player unused = a.this.f;
            a.this.e();
        }

        public /* synthetic */ d(a aVar, b bVar) {
            this();
        }

        @Override // com.opos.exoplayer.core.Player.a, com.opos.exoplayer.core.Player.b
        public void a(w wVar, Object obj, int i) {
            a.this.h();
            a.this.k();
            a.this.l();
        }

        @Override // com.opos.exoplayer.core.Player.a, com.opos.exoplayer.core.Player.b
        public void a(boolean z, int i) {
            a.this.g();
            a.this.l();
        }
    }

    static {
        i.a("goog.exo.ui");
    }

    public a(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        this.v = new b();
        this.w = new c();
        this.l = 5000;
        this.m = 15000;
        this.n = 5000;
        this.o = 0;
        this.q = -9223372036854775807L;
        this.p = false;
        this.d = new w.a();
        this.e = new w.b();
        StringBuilder sb = new StringBuilder();
        this.b = sb;
        this.c = new Formatter(sb, Locale.getDefault());
        this.r = new long[0];
        this.s = new boolean[0];
        this.t = new long[0];
        this.u = new boolean[0];
        this.f8443a = new d(this, null);
        this.g = new com.opos.exoplayer.core.d();
        setDescendantFocusability(262144);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        removeCallbacks(this.w);
        if (this.n <= 0) {
            this.q = -9223372036854775807L;
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = this.n;
        this.q = jUptimeMillis + j;
        if (this.i) {
            postDelayed(this.w, j);
        }
    }

    private void f() {
        g();
        h();
        i();
        j();
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (d() && this.i) {
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (d() && this.i) {
            Player player = this.f;
            w wVarH = player != null ? player.h() : null;
            if (!((wVarH == null || wVarH.a()) ? false : true) || this.f.o()) {
                return;
            }
            wVarH.a(this.f.i(), this.e);
            w.b bVar = this.e;
            if (!bVar.d && bVar.e) {
                this.f.k();
            }
            if (this.e.e) {
                return;
            }
            this.f.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Player player = this.f;
        if (player == null) {
            return;
        }
        this.k = this.j && a(player.h(), this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0172  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l() {
        long j;
        long j2;
        long j3;
        int iB;
        w.b bVar;
        int i;
        if (d() && this.i) {
            Player player = this.f;
            long jM = 0;
            boolean z = true;
            if (player != null) {
                w wVarH = player.h();
                if (wVarH.a()) {
                    j2 = 0;
                } else {
                    int i2 = this.f.i();
                    boolean z2 = this.k;
                    int i3 = z2 ? 0 : i2;
                    if (z2) {
                        iB = wVarH.b() - 1;
                        j2 = 0;
                        j3 = 0;
                    } else {
                        j2 = 0;
                        j3 = 0;
                        iB = i2;
                    }
                    int i4 = 0;
                    while (true) {
                        if (i3 > iB) {
                            break;
                        }
                        if (i3 == i2) {
                            j3 = j2;
                        }
                        wVarH.a(i3, this.e);
                        w.b bVar2 = this.e;
                        int i5 = i3;
                        if (bVar2.i == -9223372036854775807L) {
                            com.opos.exoplayer.core.util.a.b(this.k ^ z);
                            break;
                        }
                        int i6 = bVar2.f;
                        while (true) {
                            bVar = this.e;
                            if (i6 <= bVar.g) {
                                wVarH.a(i6, this.d);
                                int iD = this.d.d();
                                int i7 = 0;
                                while (i7 < iD) {
                                    long jA = this.d.a(i7);
                                    if (jA == Long.MIN_VALUE) {
                                        i = i2;
                                        long j4 = this.d.d;
                                        if (j4 == -9223372036854775807L) {
                                            i7++;
                                            i2 = i;
                                        } else {
                                            jA = j4;
                                        }
                                    } else {
                                        i = i2;
                                    }
                                    long jC = jA + this.d.c();
                                    if (jC >= 0 && jC <= this.e.i) {
                                        long[] jArr = this.r;
                                        if (i4 == jArr.length) {
                                            int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                            this.r = Arrays.copyOf(jArr, length);
                                            this.s = Arrays.copyOf(this.s, length);
                                        }
                                        this.r[i4] = C.a(j2 + jC);
                                        this.s[i4] = this.d.c(i7);
                                        i4++;
                                    }
                                    i7++;
                                    i2 = i;
                                }
                                i6++;
                            }
                        }
                        j2 += bVar.i;
                        i3 = i5 + 1;
                        i2 = i2;
                        z = true;
                    }
                    jM = j3;
                }
                C.a(j2);
                long jA2 = C.a(jM);
                if (this.f.o()) {
                    jM = jA2 + this.f.p();
                } else {
                    jM = jA2 + this.f.m();
                    this.f.n();
                }
            }
            removeCallbacks(this.v);
            Player player2 = this.f;
            int iC = player2 == null ? 1 : player2.c();
            if (iC == 1 || iC == 4) {
                return;
            }
            if (this.f.d() && iC == 3) {
                float f = this.f.e().b;
                if (f > 0.1f) {
                    if (f <= 5.0f) {
                        long jMax = 1000 / Math.max(1, Math.round(1.0f / f));
                        j = jMax - (jM % jMax);
                        if (j < jMax / 5) {
                            j += jMax;
                        }
                        if (f != 1.0f) {
                            j = (long) (j / f);
                        }
                    } else {
                        j = 200;
                    }
                }
            } else {
                j = 1000;
            }
            postDelayed(this.v, j);
        }
    }

    private void m() {
        r();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
    
        if (r1.d == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void n() {
        w wVarH = this.f.h();
        if (wVarH.a()) {
            return;
        }
        wVarH.a(this.f.i(), this.e);
        int iK = this.f.k();
        if (iK != -1) {
            if (this.f.m() > 3000) {
                w.b bVar = this.e;
                if (bVar.e) {
                }
            }
            a(iK, -9223372036854775807L);
            return;
        }
        a(0L);
    }

    private void o() {
        w wVarH = this.f.h();
        if (wVarH.a()) {
            return;
        }
        int i = this.f.i();
        int iJ = this.f.j();
        if (iJ != -1) {
            a(iJ, -9223372036854775807L);
        } else if (wVarH.a(i, this.e, false).e) {
            a(i, -9223372036854775807L);
        }
    }

    private void p() {
        if (this.l <= 0) {
            return;
        }
        a(Math.max(this.f.m() - ((long) this.l), 0L));
    }

    private void q() {
        if (this.m <= 0) {
            return;
        }
        long jL = this.f.l();
        long jM = this.f.m() + ((long) this.m);
        if (jL != -9223372036854775807L) {
            jM = Math.min(jM, jL);
        }
        a(jM);
    }

    private boolean r() {
        Player player = this.f;
        return (player == null || player.c() == 4 || this.f.c() == 1 || !this.f.d()) ? false : true;
    }

    public int a() {
        return this.n;
    }

    public void c() {
        if (d()) {
            setVisibility(8);
            InterfaceC0709a interfaceC0709a = this.h;
            if (interfaceC0709a != null) {
                interfaceC0709a.a(getVisibility());
            }
            removeCallbacks(this.v);
            removeCallbacks(this.w);
            this.q = -9223372036854775807L;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.i = true;
        long j = this.q;
        if (j != -9223372036854775807L) {
            long jUptimeMillis = j - SystemClock.uptimeMillis();
            if (jUptimeMillis <= 0) {
                c();
            } else {
                postDelayed(this.w, jUptimeMillis);
            }
        } else if (d()) {
            e();
        }
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = false;
        removeCallbacks(this.v);
        removeCallbacks(this.w);
    }

    public void a(int i) {
        this.n = i;
        if (d()) {
            e();
        }
    }

    public void b() {
        if (!d()) {
            setVisibility(0);
            InterfaceC0709a interfaceC0709a = this.h;
            if (interfaceC0709a != null) {
                interfaceC0709a.a(getVisibility());
            }
            f();
            m();
        }
        e();
    }

    public boolean d() {
        return getVisibility() == 0;
    }

    private void a(int i, long j) {
        if (this.g.a(this.f, i, j)) {
            return;
        }
        l();
    }

    @SuppressLint({"InlinedApi"})
    private static boolean b(int i) {
        return i == 90 || i == 89 || i == 85 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    private void a(long j) {
        a(this.f.i(), j);
    }

    public void a(Player player) {
        Player player2 = this.f;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            player2.b(this.f8443a);
        }
        this.f = player;
        if (player != null) {
            player.a(this.f8443a);
        }
        f();
    }

    public boolean a(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.f == null || !b(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() == 0) {
            if (keyCode == 90) {
                q();
            } else if (keyCode == 89) {
                p();
            } else if (keyEvent.getRepeatCount() == 0) {
                if (keyCode == 85) {
                    this.g.a(this.f, !r0.d());
                } else if (keyCode == 87) {
                    o();
                } else if (keyCode == 88) {
                    n();
                } else if (keyCode == 126) {
                    this.g.a(this.f, true);
                } else if (keyCode == 127) {
                    this.g.a(this.f, false);
                }
            }
        }
        return true;
    }

    private static boolean a(w wVar, w.b bVar) {
        if (wVar.b() > 100) {
            return false;
        }
        int iB = wVar.b();
        for (int i = 0; i < iB; i++) {
            if (wVar.a(i, bVar).i == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
    }

    private void j() {
    }
}
