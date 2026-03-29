package defpackage;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(18)
public final class nk1 extends ok1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EGLDisplay f19525a;
    public EGLContext b;
    public EGLConfig c;
    public int d;

    public nk1() {
        this(null, 0);
    }

    @Override // defpackage.ok1
    public tj1 c() {
        EGLContext eGLContext = this.b;
        if (eGLContext != EGL14.EGL_NO_CONTEXT) {
            return new tj1(eGLContext);
        }
        return null;
    }

    @Override // defpackage.ok1
    public void d() {
        EGLDisplay eGLDisplay = this.f19525a;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    @Override // defpackage.ok1
    public void e() {
        EGLDisplay eGLDisplay = this.f19525a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f19525a, this.b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f19525a);
        }
        this.f19525a = EGL14.EGL_NO_DISPLAY;
        this.b = EGL14.EGL_NO_CONTEXT;
        this.c = null;
    }

    public final void f(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(iEglGetError));
    }

    public void finalize() throws Throwable {
        try {
            if (this.f19525a != EGL14.EGL_NO_DISPLAY) {
                Log.w("Grafika", "WARNING: EglCore was not explicitly released -- state may be leaked");
                e();
            }
        } finally {
            super.finalize();
        }
    }

    public EGLSurface g(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + obj);
        }
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f19525a, this.c, obj, new int[]{12344}, 0);
        f("eglCreateWindowSurface");
        if (eGLSurfaceEglCreateWindowSurface != null) {
            return eGLSurfaceEglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public final EGLConfig h(int i, int i2) {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i2 >= 3 ? 68 : 4, 12344, 0, 12344};
        if ((i & 1) != 0) {
            iArr[10] = 12610;
            iArr[11] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f19525a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        Log.w("Grafika", "unable to find RGB8888 / " + i2 + " EGLConfig");
        return null;
    }

    public boolean i(EGLSurface eGLSurface) {
        return this.b.equals(EGL14.eglGetCurrentContext()) && eGLSurface.equals(EGL14.eglGetCurrentSurface(12377));
    }

    public void j(EGLSurface eGLSurface) {
        if (this.f19525a == EGL14.EGL_NO_DISPLAY) {
            Log.d("Grafika", "NOTE: makeCurrent w/o display");
        }
        if (!EGL14.eglMakeCurrent(this.f19525a, eGLSurface, eGLSurface, this.b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public int k(EGLSurface eGLSurface, int i) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f19525a, eGLSurface, i, iArr, 0);
        return iArr[0];
    }

    public void l(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.f19525a, eGLSurface);
    }

    public boolean m(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers(this.f19525a, eGLSurface);
    }

    public nk1(tj1 tj1Var, int i) {
        EGLConfig eGLConfigH;
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.f19525a = eGLDisplay;
        this.b = EGL14.EGL_NO_CONTEXT;
        this.c = null;
        this.d = -1;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        tj1Var = tj1Var == null ? new tj1(EGL14.EGL_NO_CONTEXT) : tj1Var;
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.f19525a = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            this.f19525a = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        if ((i & 2) != 0 && (eGLConfigH = h(i, 3)) != null) {
            EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.f19525a, eGLConfigH, (EGLContext) tj1Var.a(), new int[]{12440, 3, 12344}, 0);
            if (EGL14.eglGetError() == 12288) {
                this.c = eGLConfigH;
                this.b = eGLContextEglCreateContext;
                this.d = 3;
            }
        }
        if (this.b == EGL14.EGL_NO_CONTEXT) {
            EGLConfig eGLConfigH2 = h(i, 2);
            if (eGLConfigH2 == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            EGLContext eGLContextEglCreateContext2 = EGL14.eglCreateContext(this.f19525a, eGLConfigH2, (EGLContext) tj1Var.a(), new int[]{12440, 2, 12344}, 0);
            f("eglCreateContext");
            this.c = eGLConfigH2;
            this.b = eGLContextEglCreateContext2;
            this.d = 2;
        }
        int[] iArr2 = new int[1];
        EGL14.eglQueryContext(this.f19525a, this.b, 12440, iArr2, 0);
        Log.d("Grafika", "EGLContext created, client version " + iArr2[0]);
    }
}
