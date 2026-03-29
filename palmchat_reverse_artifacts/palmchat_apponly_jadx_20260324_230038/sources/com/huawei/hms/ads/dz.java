package com.huawei.hms.ads;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class dz {
    private final int[] B = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344};
    private EGLContext I;
    private EGLDisplay V;
    private EGLConfig Z;

    public dz() {
        Z();
        I();
        EGL14.eglQueryContext(this.V, this.I, 12440, new int[1], 0);
    }

    private EGLConfig B() {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.V, this.B, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        fh.I("GlEngine", "fail to choose gl config");
        return null;
    }

    private void I() {
        EGLConfig eGLConfigB = B();
        if (eGLConfigB == null) {
            throw new IllegalStateException("fail to get config");
        }
        this.I = EGL14.eglCreateContext(this.V, eGLConfigB, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        Code("create context fail");
        this.Z = eGLConfigB;
    }

    private void Z() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.V = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new IllegalStateException("fail to get gl display");
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            return;
        }
        this.V = null;
        throw new IllegalStateException("fail to init gl");
    }

    public int Code(EGLSurface eGLSurface, int i) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.V, eGLSurface, i, iArr, 0);
        return iArr[0];
    }

    public void V() {
        EGLDisplay eGLDisplay = this.V;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT)) {
            throw new IllegalStateException("set no current fail");
        }
    }

    public void finalize() throws Throwable {
        try {
            if (this.V != EGL14.EGL_NO_DISPLAY) {
                Code();
            }
        } finally {
            super.finalize();
        }
    }

    public EGLSurface Code(Surface surface) {
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.V, this.Z, surface, new int[]{12344}, 0);
        Code("create window surface fail");
        if (eGLSurfaceEglCreateWindowSurface != null) {
            return eGLSurfaceEglCreateWindowSurface;
        }
        throw new IllegalStateException("gl surface is null");
    }

    public void I(EGLSurface eGLSurface) {
        if (EGL14.eglSwapBuffers(this.V, eGLSurface)) {
            return;
        }
        fh.Code("GlEngine", "fail to update buffer");
    }

    public void V(EGLSurface eGLSurface) {
        if (!EGL14.eglMakeCurrent(this.V, eGLSurface, eGLSurface, this.I)) {
            throw new IllegalStateException("set current fail");
        }
    }

    public void Code() {
        EGLDisplay eGLDisplay = this.V;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.V, this.I);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.V);
        }
        this.V = EGL14.EGL_NO_DISPLAY;
        this.I = EGL14.EGL_NO_CONTEXT;
        this.Z = null;
    }

    public void Code(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.V, eGLSurface);
    }

    private void Code(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new IllegalStateException(str + " err code " + Integer.toHexString(iEglGetError));
    }
}
