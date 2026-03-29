package com.bytedance.realx.base;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class GPUUtil {
    private static String glRenderer = "unknown";
    private static String glVendor = "unknown";
    private static boolean initialized = false;

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|118|3|(8:122|5|(0)(1:8)|(5:120|15|(3:126|17|(2:19|(2:21|(2:23|(2:25|(2:40|41)(2:29|(2:38|39)(2:33|(1:35)(2:36|37))))(2:42|43))(2:44|45))(2:46|47)))|48|49)(1:58)|124|59|(1:61)|(6:63|(1:67)|(1:71)|(1:129)|98|99)(1:127))|13|(0)(0)|124|59|(0)|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x010b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x010c, code lost:
    
        r18 = r3;
        r3 = r1;
        r1 = r4;
        r4 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0113, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0114, code lost:
    
        r18 = r3;
        r3 = r1;
        r1 = r4;
        r4 = r18;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d9 A[Catch: all -> 0x010b, Exception -> 0x0113, TRY_LEAVE, TryCatch #8 {Exception -> 0x0113, all -> 0x010b, blocks: (B:59:0x00d3, B:61:0x00d9), top: B:124:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x012d  */
    @RequiresApi(api = 17)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void Initialize() throws Throwable {
        EGLSurface eGLSurface;
        EGLContext eGLContext;
        EGLContext eGLContextEglGetCurrentContext;
        boolean z;
        EGLSurface eGLSurface2;
        initialized = true;
        boolean z2 = false;
        EGLDisplay eGLDisplay = null;
        try {
            eGLContextEglGetCurrentContext = EGL14.eglGetCurrentContext();
        } catch (Exception e) {
            e = e;
            eGLSurface = null;
            eGLContext = null;
        } catch (Throwable th) {
            th = th;
            eGLSurface = null;
            eGLContext = null;
        }
        if (eGLContextEglGetCurrentContext != null) {
            try {
                if (eGLContextEglGetCurrentContext != EGL14.EGL_NO_CONTEXT) {
                    z = false;
                }
                if (!z) {
                    try {
                        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
                        if (eGLDisplayEglGetDisplay != null) {
                            try {
                                if (eGLDisplayEglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                                    int[] iArr = new int[2];
                                    if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
                                        throw new Exception("eglInitialize error");
                                    }
                                    int[] iArr2 = new int[1];
                                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                                    if (!EGL14.eglChooseConfig(eGLDisplayEglGetDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0)) {
                                        throw new Exception("eglChooseConfig error");
                                    }
                                    if (iArr2[0] <= 0) {
                                        throw new Exception("no egl config chosen");
                                    }
                                    EGLConfig eGLConfig = eGLConfigArr[0];
                                    eGLContextEglGetCurrentContext = EGL14.eglCreateContext(eGLDisplayEglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                                    if (eGLContextEglGetCurrentContext == null || eGLContextEglGetCurrentContext == EGL14.EGL_NO_CONTEXT) {
                                        throw new Exception("eglCreateContext error");
                                    }
                                    EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplayEglGetDisplay, eGLConfig, new int[]{12375, 1, 12374, 1, 12344}, 0);
                                    if (eGLSurfaceEglCreatePbufferSurface == null || eGLSurfaceEglCreatePbufferSurface == EGL14.EGL_NO_SURFACE) {
                                        throw new Exception("eglCreatePbufferSurface error");
                                    }
                                    if (!EGL14.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglGetCurrentContext)) {
                                        throw new Exception("eglMakeCurrent error");
                                    }
                                    eGLSurface2 = eGLSurfaceEglCreatePbufferSurface;
                                    eGLDisplay = eGLDisplayEglGetDisplay;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                z2 = z;
                                eGLContext = eGLContextEglGetCurrentContext;
                                eGLSurface = null;
                                eGLDisplay = eGLDisplayEglGetDisplay;
                                try {
                                    Log.e("gpm", e.toString());
                                    if (z2) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (z2) {
                                        EGLSurface eGLSurface3 = EGL14.EGL_NO_SURFACE;
                                        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface3, eGLSurface3, EGL14.EGL_NO_CONTEXT);
                                        if (eGLSurface != null && eGLSurface != EGL14.EGL_NO_SURFACE) {
                                            EGL14.eglDestroySurface(eGLDisplay, eGLSurface);
                                        }
                                        if (eGLContext != null && eGLContext != EGL14.EGL_NO_CONTEXT) {
                                            EGL14.eglDestroyContext(eGLDisplay, eGLContext);
                                        }
                                        if (eGLDisplay != null && eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                                            EGL14.eglTerminate(eGLDisplay);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                z2 = z;
                                eGLContext = eGLContextEglGetCurrentContext;
                                eGLSurface = null;
                                eGLDisplay = eGLDisplayEglGetDisplay;
                                if (z2) {
                                }
                                throw th;
                            }
                        }
                        throw new Exception("eglGetDisplay error");
                    } catch (Exception e3) {
                        e = e3;
                        z2 = z;
                        eGLContext = eGLContextEglGetCurrentContext;
                        eGLSurface = null;
                        Log.e("gpm", e.toString());
                        if (z2) {
                            return;
                        }
                        EGLSurface eGLSurface4 = EGL14.EGL_NO_SURFACE;
                        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface4, eGLSurface4, EGL14.EGL_NO_CONTEXT);
                        if (eGLSurface != null && eGLSurface != EGL14.EGL_NO_SURFACE) {
                            EGL14.eglDestroySurface(eGLDisplay, eGLSurface);
                        }
                        if (eGLContext != null && eGLContext != EGL14.EGL_NO_CONTEXT) {
                            EGL14.eglDestroyContext(eGLDisplay, eGLContext);
                        }
                        if (eGLDisplay == null || eGLDisplay == EGL14.EGL_NO_DISPLAY) {
                            return;
                        }
                        EGL14.eglTerminate(eGLDisplay);
                        return;
                    } catch (Throwable th4) {
                        th = th4;
                        z2 = z;
                        eGLContext = eGLContextEglGetCurrentContext;
                        eGLSurface = null;
                        if (z2) {
                        }
                        throw th;
                    }
                }
                eGLSurface2 = null;
                if (Build.VERSION.SDK_INT > 22) {
                    glVendor = GLES20.glGetString(7936);
                    glRenderer = GLES20.glGetString(7937);
                }
            } catch (Exception e4) {
                e = e4;
                eGLContext = eGLContextEglGetCurrentContext;
                eGLSurface = null;
                Log.e("gpm", e.toString());
                if (z2) {
                }
            } catch (Throwable th5) {
                th = th5;
                eGLContext = eGLContextEglGetCurrentContext;
                eGLSurface = null;
                if (z2) {
                }
                throw th;
            }
            if (z) {
                return;
            }
            EGLSurface eGLSurface5 = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface5, eGLSurface5, EGL14.EGL_NO_CONTEXT);
            if (eGLSurface2 != null && eGLSurface2 != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(eGLDisplay, eGLSurface2);
            }
            if (eGLContextEglGetCurrentContext != null && eGLContextEglGetCurrentContext != EGL14.EGL_NO_CONTEXT) {
                EGL14.eglDestroyContext(eGLDisplay, eGLContextEglGetCurrentContext);
            }
            if (eGLDisplay == null || eGLDisplay == EGL14.EGL_NO_DISPLAY) {
                return;
            }
            EGL14.eglTerminate(eGLDisplay);
            return;
        }
        z = true;
        if (!z) {
        }
        if (Build.VERSION.SDK_INT > 22) {
        }
        if (z) {
        }
    }

    @RequiresApi(api = 22)
    public static String getGPURenderer() throws Throwable {
        if (!initialized) {
            Initialize();
        }
        return glRenderer;
    }

    public static String getGPURendererFallback() {
        return glRenderer;
    }
}
