package com.opos.exoplayer.core.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.opos.exoplayer.core.util.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@TargetApi(17)
public final class DummySurface extends Surface {
    private static int b;
    private static boolean c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f8412a;
    private final b d;
    private boolean e;

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int[] f8413a;
        private EGLDisplay b;
        private EGLContext c;
        private EGLSurface d;
        private Handler e;
        private SurfaceTexture f;
        private Error g;
        private RuntimeException h;
        private DummySurface i;

        public b() {
            super("dummySurface");
            this.f8413a = new int[1];
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void b() {
            try {
                SurfaceTexture surfaceTexture = this.f;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                    GLES20.glDeleteTextures(1, this.f8413a, 0);
                }
            } finally {
                EGLSurface eGLSurface = this.d;
                if (eGLSurface != null) {
                    EGL14.eglDestroySurface(this.b, eGLSurface);
                }
                EGLContext eGLContext = this.c;
                if (eGLContext != null) {
                    EGL14.eglDestroyContext(this.b, eGLContext);
                }
                this.d = null;
                this.c = null;
                this.b = null;
                this.i = null;
                this.f = null;
            }
        }

        public DummySurface a(int i) {
            boolean z;
            start();
            this.e = new Handler(getLooper(), this);
            synchronized (this) {
                z = false;
                this.e.obtainMessage(1, i, 0).sendToTarget();
                while (this.i == null && this.h == null && this.g == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.h;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.g;
            if (error == null) {
                return this.i;
            }
            throw error;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            try {
                if (i != 1) {
                    if (i == 2) {
                        this.f.updateTexImage();
                        return true;
                    }
                    if (i != 3) {
                        return true;
                    }
                    try {
                        b();
                    } finally {
                        try {
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    try {
                        b(message.arg1);
                        synchronized (this) {
                            notify();
                        }
                    } catch (Error e) {
                        com.opos.cmn.an.f.a.d("DummySurface", "Failed to initialize dummy surface", e);
                        this.g = e;
                        synchronized (this) {
                            notify();
                        }
                    }
                } catch (RuntimeException e2) {
                    com.opos.cmn.an.f.a.d("DummySurface", "Failed to initialize dummy surface", e2);
                    this.h = e2;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.e.sendEmptyMessage(2);
        }

        private void b(int i) {
            EGLSurface eGLSurface;
            EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
            this.b = eGLDisplayEglGetDisplay;
            com.opos.exoplayer.core.util.a.b(eGLDisplayEglGetDisplay != null, "eglGetDisplay failed");
            int[] iArr = new int[2];
            com.opos.exoplayer.core.util.a.b(EGL14.eglInitialize(this.b, iArr, 0, iArr, 1), "eglInitialize failed");
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr2 = new int[1];
            com.opos.exoplayer.core.util.a.b(EGL14.eglChooseConfig(this.b, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0) && iArr2[0] > 0 && eGLConfigArr[0] != null, "eglChooseConfig failed");
            EGLConfig eGLConfig = eGLConfigArr[0];
            EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.b, eGLConfig, EGL14.EGL_NO_CONTEXT, i == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
            this.c = eGLContextEglCreateContext;
            com.opos.exoplayer.core.util.a.b(eGLContextEglCreateContext != null, "eglCreateContext failed");
            if (i == 1) {
                eGLSurface = EGL14.EGL_NO_SURFACE;
            } else {
                EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.b, eGLConfig, i == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                this.d = eGLSurfaceEglCreatePbufferSurface;
                com.opos.exoplayer.core.util.a.b(eGLSurfaceEglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
                eGLSurface = this.d;
            }
            com.opos.exoplayer.core.util.a.b(EGL14.eglMakeCurrent(this.b, eGLSurface, eGLSurface, this.c), "eglMakeCurrent failed");
            GLES20.glGenTextures(1, this.f8413a, 0);
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.f8413a[0]);
            this.f = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            this.i = new DummySurface(this, this.f, i != 0);
        }

        public void a() {
            this.e.sendEmptyMessage(3);
        }
    }

    private DummySurface(b bVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.d = bVar;
        this.f8412a = z;
    }

    public static DummySurface a(Context context, boolean z) {
        a();
        com.opos.exoplayer.core.util.a.b(!z || a(context));
        return new b().a(z ? b : 0);
    }

    @TargetApi(24)
    private static int b(Context context) {
        String strEglQueryString;
        int i = y.f8407a;
        if (i < 26 && ("samsung".equals(y.c) || "XT1650".equals(y.d))) {
            return 0;
        }
        if ((i >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains("EGL_EXT_protected_content")) {
            return strEglQueryString.contains("EGL_KHR_surfaceless_context") ? 1 : 2;
        }
        return 0;
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.d) {
            if (!this.e) {
                this.d.a();
                this.e = true;
            }
        }
    }

    private static void a() {
        if (y.f8407a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    public static synchronized boolean a(Context context) {
        if (!c) {
            b = y.f8407a < 24 ? 0 : b(context);
            c = true;
        }
        return b != 0;
    }
}
