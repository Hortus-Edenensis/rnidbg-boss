package defpackage;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(17)
public class fl1 extends xn6 {
    public EGLSurface d;
    public int e;
    public int f;
    public nk1 g;

    public fl1(ok1 ok1Var, Surface surface, boolean z) {
        super(ok1Var, surface, z);
        this.d = EGL14.EGL_NO_SURFACE;
        this.e = -1;
        this.f = -1;
        this.g = (nk1) ok1Var;
        l(surface);
    }

    @Override // defpackage.xn6
    public int d() {
        int i = this.f;
        return i < 0 ? this.g.k(this.d, 12374) : i;
    }

    @Override // defpackage.xn6
    public int e() {
        int i = this.e;
        return i < 0 ? this.g.k(this.d, 12375) : i;
    }

    @Override // defpackage.xn6
    public boolean f() {
        return this.g.i(this.d);
    }

    @Override // defpackage.xn6
    public void g() {
        this.g.j(this.d);
    }

    @Override // defpackage.xn6
    public void i() {
        this.g.l(this.d);
        this.d = EGL14.EGL_NO_SURFACE;
        this.f = -1;
        this.e = -1;
    }

    @Override // defpackage.xn6
    public boolean k() {
        boolean zM = this.g.m(this.d);
        if (!zM) {
            Log.d("Grafika", "WARNING: swapBuffers() failed");
        }
        return zM;
    }

    public void l(Object obj) {
        if (this.d != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.d = this.g.g(obj);
    }
}
