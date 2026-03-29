package defpackage;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.video.PlaceholderSurface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class fc6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zw1 f17509a = new zw1();

    @Nullable
    public final b b;

    @Nullable
    public final e c;
    public boolean d;

    @Nullable
    public Surface e;
    public float f;
    public float g;
    public float h;
    public float i;
    public int j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(30)
    public static final class a {
        @DoNotInline
        public static void a(Surface surface, float f) {
            try {
                surface.setFrameRate(f, f == 0.0f ? 0 : 1);
            } catch (IllegalStateException e) {
                y53.d("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {

        /* JADX INFO: compiled from: SearchBox */
        public interface a {
            void onDefaultDisplayChanged(@Nullable Display display);
        }

        void a(a aVar);

        void unregister();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e implements Choreographer.FrameCallback, Handler.Callback {
        public static final e f = new e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f17512a = -9223372036854775807L;
        public final Handler b;
        public final HandlerThread c;
        public Choreographer d;
        public int e;

        public e() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.c = handlerThread;
            handlerThread.start();
            Handler handlerV = g86.v(handlerThread.getLooper(), this);
            this.b = handlerV;
            handlerV.sendEmptyMessage(0);
        }

        public static e d() {
            return f;
        }

        public void a() {
            this.b.sendEmptyMessage(1);
        }

        public final void b() {
            Choreographer choreographer = this.d;
            if (choreographer != null) {
                int i = this.e + 1;
                this.e = i;
                if (i == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
        }

        public final void c() {
            try {
                this.d = Choreographer.getInstance();
            } catch (RuntimeException e) {
                y53.j("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e);
            }
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.f17512a = j;
            ((Choreographer) vh.e(this.d)).postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.b.sendEmptyMessage(2);
        }

        public final void f() {
            Choreographer choreographer = this.d;
            if (choreographer != null) {
                int i = this.e - 1;
                this.e = i;
                if (i == 0) {
                    choreographer.removeFrameCallback(this);
                    this.f17512a = -9223372036854775807L;
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                c();
                return true;
            }
            if (i == 1) {
                b();
                return true;
            }
            if (i != 2) {
                return false;
            }
            f();
            return true;
        }
    }

    public fc6(@Nullable Context context) {
        b bVarF = f(context);
        this.b = bVarF;
        this.c = bVarF != null ? e.d() : null;
        this.k = -9223372036854775807L;
        this.l = -9223372036854775807L;
        this.f = -1.0f;
        this.i = 1.0f;
        this.j = 0;
    }

    public static boolean c(long j, long j2) {
        return Math.abs(j - j2) <= 20000000;
    }

    public static long e(long j, long j2, long j3) {
        long j4;
        long j5 = j2 + (((j - j2) / j3) * j3);
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            j5 = j3 + j5;
            j4 = j5;
        }
        return j5 - j < j - j4 ? j5 : j4;
    }

    @Nullable
    public static b f(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        b bVarC = g86.f17680a >= 17 ? d.c(applicationContext) : null;
        return bVarC == null ? c.b(applicationContext) : bVarC;
    }

    public long b(long j) {
        long j2;
        if (this.p == -1 || !this.f17509a.e()) {
            j2 = j;
        } else {
            long jA = this.q + ((long) ((this.f17509a.a() * (this.m - this.p)) / this.i));
            if (c(j, jA)) {
                j2 = jA;
            } else {
                n();
                j2 = j;
            }
        }
        this.n = this.m;
        this.o = j2;
        e eVar = this.c;
        if (eVar == null || this.k == -9223372036854775807L) {
            return j2;
        }
        long j3 = eVar.f17512a;
        return j3 == -9223372036854775807L ? j2 : e(j2, j3, this.k) - this.l;
    }

    public final void d() {
        Surface surface;
        if (g86.f17680a < 30 || (surface = this.e) == null || this.j == Integer.MIN_VALUE || this.h == 0.0f) {
            return;
        }
        this.h = 0.0f;
        a.a(surface, 0.0f);
    }

    public void g(float f) {
        this.f = f;
        this.f17509a.g();
        q();
    }

    public void h(long j) {
        long j2 = this.n;
        if (j2 != -1) {
            this.p = j2;
            this.q = this.o;
        }
        this.m++;
        this.f17509a.f(j * 1000);
        q();
    }

    public void i(float f) {
        this.i = f;
        n();
        r(false);
    }

    public void j() {
        n();
    }

    public void k() {
        this.d = true;
        n();
        if (this.b != null) {
            ((e) vh.e(this.c)).a();
            this.b.a(new b.a() { // from class: dc6
                @Override // fc6.b.a
                public final void onDefaultDisplayChanged(Display display) {
                    this.f17024a.p(display);
                }
            });
        }
        r(false);
    }

    public void l() {
        this.d = false;
        b bVar = this.b;
        if (bVar != null) {
            bVar.unregister();
            ((e) vh.e(this.c)).e();
        }
        d();
    }

    public void m(@Nullable Surface surface) {
        if (surface instanceof PlaceholderSurface) {
            surface = null;
        }
        if (this.e == surface) {
            return;
        }
        d();
        this.e = surface;
        r(true);
    }

    public final void n() {
        this.m = 0L;
        this.p = -1L;
        this.n = -1L;
    }

    public void o(int i) {
        if (this.j == i) {
            return;
        }
        this.j = i;
        r(true);
    }

    public final void p(@Nullable Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            this.k = refreshRate;
            this.l = (refreshRate * 80) / 100;
        } else {
            y53.i("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            this.k = -9223372036854775807L;
            this.l = -9223372036854775807L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q() {
        if (g86.f17680a < 30 || this.e == null) {
            return;
        }
        float fB = this.f17509a.e() ? this.f17509a.b() : this.f;
        float f = this.g;
        if (fB == f) {
            return;
        }
        boolean z = true;
        if (fB != -1.0f && f != -1.0f) {
            if (Math.abs(fB - this.g) < (this.f17509a.e() && (this.f17509a.d() > 5000000000L ? 1 : (this.f17509a.d() == 5000000000L ? 0 : -1)) >= 0 ? 0.02f : 1.0f)) {
            }
        } else if (fB == -1.0f && this.f17509a.c() < 30) {
            z = false;
        }
        if (z) {
            this.g = fB;
            r(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r(boolean z) {
        Surface surface;
        float f;
        if (g86.f17680a < 30 || (surface = this.e) == null || this.j == Integer.MIN_VALUE) {
            return;
        }
        if (this.d) {
            float f2 = this.g;
            f = f2 != -1.0f ? f2 * this.i : 0.0f;
        }
        if (z || this.h != f) {
            this.h = f;
            a.a(surface, f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowManager f17510a;

        public c(WindowManager windowManager) {
            this.f17510a = windowManager;
        }

        @Nullable
        public static b b(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                return new c(windowManager);
            }
            return null;
        }

        @Override // fc6.b
        public void a(b.a aVar) {
            aVar.onDefaultDisplayChanged(this.f17510a.getDefaultDisplay());
        }

        @Override // fc6.b
        public void unregister() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(17)
    public static final class d implements b, DisplayManager.DisplayListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DisplayManager f17511a;

        @Nullable
        public b.a b;

        public d(DisplayManager displayManager) {
            this.f17511a = displayManager;
        }

        @Nullable
        public static b c(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager != null) {
                return new d(displayManager);
            }
            return null;
        }

        @Override // fc6.b
        public void a(b.a aVar) {
            this.b = aVar;
            this.f17511a.registerDisplayListener(this, g86.w());
            aVar.onDefaultDisplayChanged(b());
        }

        public final Display b() {
            return this.f17511a.getDisplay(0);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            b.a aVar = this.b;
            if (aVar == null || i != 0) {
                return;
            }
            aVar.onDefaultDisplayChanged(b());
        }

        @Override // fc6.b
        public void unregister() {
            this.f17511a.unregisterDisplayListener(this);
            this.b = null;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    }
}
