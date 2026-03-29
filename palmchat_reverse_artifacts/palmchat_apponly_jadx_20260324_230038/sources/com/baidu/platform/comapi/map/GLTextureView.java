package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.baidu.platform.comapi.util.EglConfigUtils;
import com.baidu.platform.gl.GLThreadShareLock;
import com.heytap.mcssdk.constant.MessageConstant;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final h f4148a = new h(null);
    private int b;
    private final View.OnLayoutChangeListener c;
    private final WeakReference<GLTextureView> d;
    private g e;
    private SurfaceRenderer f;
    private boolean g;
    private GLSurfaceView.EGLConfigChooser h;
    private GLSurfaceView.EGLContextFactory i;
    private GLSurfaceView.EGLWindowSurfaceFactory j;
    private GLSurfaceView.GLWrapper k;
    private int l;
    private int m;
    private boolean n;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            GLTextureView gLTextureView = GLTextureView.this;
            gLTextureView.onSurfaceTextureSizeChanged(gLTextureView.getSurfaceTexture(), i3 - i, i4 - i2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public abstract class b implements GLSurfaceView.EGLConfigChooser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int[] f4150a;

        public b(int[] iArr) {
            this.f4150a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (GLTextureView.this.m != 2 && GLTextureView.this.m != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (GLTextureView.this.m == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f4150a, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f4150a, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig eGLConfigA = a(egl10, eGLDisplay, eGLConfigArr);
            if (eGLConfigA != null) {
                return eGLConfigA;
            }
            throw new IllegalArgumentException("No config chosen");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e implements GLSurfaceView.EGLWindowSurfaceFactory {
        private e() {
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLTextureView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<GLTextureView> f4152a;
        EGL10 b;
        EGLDisplay c;
        EGLSurface d;
        EGLConfig e;
        EGLContext f;

        public f(WeakReference<GLTextureView> weakReference) {
            this.f4152a = weakReference;
        }

        public static void a(String str, String str2, int i) {
        }

        private void d() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.d;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.b.eglMakeCurrent(this.c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            GLTextureView gLTextureView = this.f4152a.get();
            if (gLTextureView != null) {
                gLTextureView.j.destroySurface(this.b, this.c, this.d);
            }
            this.d = null;
        }

        public boolean b() {
            Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            if (this.b == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.c == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.e == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            d();
            GLTextureView gLTextureView = this.f4152a.get();
            if (gLTextureView != null) {
                this.d = gLTextureView.j.createWindowSurface(this.b, this.c, this.e, gLTextureView.getSurfaceTexture());
            } else {
                this.d = null;
            }
            EGLSurface eGLSurface = this.d;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                if (this.b.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            }
            if (this.b.eglMakeCurrent(this.c, eGLSurface, eGLSurface, this.f)) {
                return true;
            }
            a("EGLHelper", "eglMakeCurrent", this.b.eglGetError());
            return false;
        }

        public void c() {
            Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
            d();
        }

        public void e() {
            Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
            if (this.f != null) {
                GLTextureView gLTextureView = this.f4152a.get();
                if (gLTextureView != null) {
                    gLTextureView.i.destroyContext(this.b, this.c, this.f);
                }
                this.f = null;
            }
            EGLDisplay eGLDisplay = this.c;
            if (eGLDisplay != null) {
                this.b.eglTerminate(eGLDisplay);
                this.c = null;
            }
        }

        public void f() {
            Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.b = egl10;
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.c = eGLDisplayEglGetDisplay;
            if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.b.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            GLTextureView gLTextureView = this.f4152a.get();
            if (gLTextureView == null) {
                this.e = null;
                this.f = null;
            } else {
                this.e = gLTextureView.h.chooseConfig(this.b, this.c);
                this.f = gLTextureView.i.createContext(this.b, this.c, this.e);
            }
            EGLContext eGLContext = this.f;
            if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                this.f = null;
                a("createContext");
            }
            Log.w("EglHelper", "createContext " + this.f + " tid=" + Thread.currentThread().getId());
            this.d = null;
        }

        public int g() {
            return !this.b.eglSwapBuffers(this.c, this.d) ? this.b.eglGetError() : MessageConstant.CommandId.COMMAND_BASE;
        }

        public GL a() {
            GL gl = this.f.getGL();
            GLTextureView gLTextureView = this.f4152a.get();
            if (gLTextureView == null) {
                return gl;
            }
            if (gLTextureView.k != null) {
                gl = gLTextureView.k.wrap(gl);
            }
            if ((gLTextureView.l & 3) != 0) {
                return GLDebugHelper.wrap(gl, (gLTextureView.l & 1) == 0 ? 0 : 1, (gLTextureView.l & 2) != 0 ? new i() : null);
            }
            return gl;
        }

        private void a(String str) {
            b(str, this.b.eglGetError());
        }

        public static String a(String str, int i) {
            return str + " EGL failed code: " + i;
        }

        public static void b(String str, int i) {
            throw new RuntimeException(a(str, i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f4153a;
        private boolean b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean o;
        private f r;
        private WeakReference<GLTextureView> s;
        private ArrayList<Runnable> p = new ArrayList<>();
        private boolean q = true;
        private int k = 0;
        private int l = 0;
        private boolean n = true;
        private int m = 1;

        public g(WeakReference<GLTextureView> weakReference) {
            this.s = weakReference;
        }

        /* JADX WARN: Removed duplicated region for block: B:159:0x0356  */
        /* JADX WARN: Removed duplicated region for block: B:162:0x035f A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:165:0x036e A[Catch: all -> 0x0393, TryCatch #2 {all -> 0x0393, blocks: (B:4:0x001c, B:5:0x001e, B:107:0x0248, B:109:0x0252, B:111:0x0261, B:112:0x0263, B:119:0x0272, B:122:0x0276, B:125:0x028c, B:127:0x029d, B:134:0x02bf, B:136:0x02ea, B:138:0x02f2, B:140:0x0300, B:142:0x030e, B:146:0x031c, B:147:0x0325, B:154:0x0330, B:156:0x0334, B:160:0x0357, B:163:0x0361, B:165:0x036e, B:166:0x0370, B:172:0x0378, B:179:0x0392, B:114:0x0265, B:115:0x026a, B:6:0x001f, B:8:0x0023, B:17:0x0032, B:19:0x003a, B:105:0x0245, B:20:0x0048, B:22:0x004e, B:24:0x0059, B:26:0x0086, B:29:0x008c, B:31:0x00b0, B:33:0x00b9, B:36:0x00bf, B:38:0x00dc, B:40:0x00e0, B:42:0x00ea, B:47:0x00f5, B:49:0x00ff, B:51:0x0104, B:53:0x011e, B:55:0x0128, B:57:0x012f, B:58:0x0147, B:60:0x014b, B:63:0x0151, B:65:0x016d, B:66:0x0170, B:67:0x017b, B:69:0x017f, B:72:0x0185, B:75:0x01a9, B:76:0x01cb, B:78:0x01d1, B:91:0x01ff, B:93:0x0203, B:95:0x0207, B:96:0x020d, B:98:0x0211, B:100:0x0215, B:102:0x021b, B:104:0x023e, B:176:0x0385, B:82:0x01db, B:84:0x01e5, B:86:0x01eb, B:88:0x01f5, B:89:0x01fc, B:167:0x0371, B:168:0x0374, B:149:0x0327, B:150:0x032c), top: B:192:0x001c, inners: #0, #1, #4, #5 }] */
        /* JADX WARN: Removed duplicated region for block: B:174:0x0380  */
        /* JADX WARN: Removed duplicated region for block: B:212:0x0211 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void c() throws InterruptedException {
            GL10 gl10;
            GL10 gl102;
            boolean z;
            int fps;
            GL10 gl103;
            long jCurrentTimeMillis;
            long j;
            boolean z2;
            boolean z3;
            boolean z4;
            g gVar = this;
            gVar.r = new f(gVar.s);
            gVar.h = false;
            gVar.i = false;
            boolean z5 = false;
            GL10 gl104 = null;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            int i = 0;
            int i2 = 0;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            while (true) {
                Runnable runnableRemove = null;
                while (true) {
                    try {
                        synchronized (GLThreadShareLock.LOCK) {
                            while (!gVar.f4153a) {
                                if (gVar.p.isEmpty()) {
                                    boolean z13 = gVar.d;
                                    boolean z14 = gVar.c;
                                    if (z13 != z14) {
                                        gVar.d = z14;
                                        GLThreadShareLock.LOCK.notifyAll();
                                        z3 = z14;
                                        StringBuilder sb = new StringBuilder();
                                        gl10 = gl104;
                                        sb.append("mPaused is now ");
                                        sb.append(gVar.d);
                                        sb.append(" tid=");
                                        z2 = z6;
                                        sb.append(getId());
                                        Log.i("GLThread", sb.toString());
                                    } else {
                                        gl10 = gl104;
                                        z2 = z6;
                                        z3 = false;
                                    }
                                    if (gVar.j) {
                                        Log.i("GLThread", "releasing EGL context because asked to tid=" + getId());
                                        k();
                                        j();
                                        gVar.j = false;
                                        z12 = true;
                                    }
                                    if (z5) {
                                        k();
                                        j();
                                        z5 = false;
                                    }
                                    if (z3 && gVar.i) {
                                        Log.i("GLThread", "releasing EGL surface because paused tid=" + getId());
                                        k();
                                    }
                                    if (z3 && gVar.h) {
                                        GLTextureView gLTextureView = gVar.s.get();
                                        if (!(gLTextureView != null && gLTextureView.n) || GLTextureView.f4148a.b()) {
                                            j();
                                            Log.i("GLThread", "releasing EGL context because paused tid=" + getId());
                                        }
                                    }
                                    if (z3 && GLTextureView.f4148a.c()) {
                                        gVar.r.e();
                                        Log.i("GLThread", "terminating EGL because paused tid=" + getId());
                                    }
                                    if (!gVar.e && !gVar.g) {
                                        Log.i("GLThread", "noticed surfaceView surface lost tid=" + getId());
                                        if (gVar.i) {
                                            k();
                                        }
                                        gVar.g = true;
                                        gVar.f = false;
                                        GLThreadShareLock.LOCK.notifyAll();
                                    }
                                    if (gVar.e && gVar.g) {
                                        Log.i("GLThread", "noticed surfaceView surface acquired tid=" + getId());
                                        gVar.g = false;
                                        GLThreadShareLock.LOCK.notifyAll();
                                    }
                                    if (z11) {
                                        Log.i("GLThread", "sending render notification tid=" + getId());
                                        gVar.o = true;
                                        GLThreadShareLock.LOCK.notifyAll();
                                        z10 = false;
                                        z11 = false;
                                    }
                                    if (f()) {
                                        if (!gVar.h) {
                                            if (z12) {
                                                z6 = z2;
                                                z12 = false;
                                            } else if (GLTextureView.f4148a.c(gVar)) {
                                                try {
                                                    gVar.r.f();
                                                    gVar.h = true;
                                                    GLThreadShareLock.LOCK.notifyAll();
                                                    z6 = true;
                                                } catch (RuntimeException e) {
                                                    GLTextureView.f4148a.a(gVar);
                                                    throw e;
                                                }
                                            }
                                            if (gVar.h && !gVar.i) {
                                                gVar.i = true;
                                                z7 = true;
                                                z8 = true;
                                                z9 = true;
                                            }
                                            if (!gVar.i) {
                                                if (gVar.q) {
                                                    int i3 = gVar.k;
                                                    int i4 = gVar.l;
                                                    Log.i("GLThread", "noticing that we want render notification tid=" + getId());
                                                    gVar.q = false;
                                                    i = i3;
                                                    i2 = i4;
                                                    z4 = false;
                                                    z7 = true;
                                                    z9 = true;
                                                    z10 = true;
                                                } else {
                                                    z4 = false;
                                                }
                                                gVar.n = z4;
                                                GLThreadShareLock.LOCK.notifyAll();
                                            }
                                        }
                                        z6 = z2;
                                        if (gVar.h) {
                                            gVar.i = true;
                                            z7 = true;
                                            z8 = true;
                                            z9 = true;
                                        }
                                        if (!gVar.i) {
                                        }
                                    } else {
                                        z6 = z2;
                                    }
                                    GLThreadShareLock.LOCK.wait();
                                    gVar = this;
                                    gl104 = gl10;
                                } else {
                                    runnableRemove = gVar.p.remove(0);
                                    gl10 = gl104;
                                }
                            }
                            synchronized (GLThreadShareLock.LOCK) {
                                k();
                                j();
                            }
                            return;
                        }
                        if (runnableRemove != null) {
                            break;
                        }
                        if (z7) {
                            Log.w("GLThread", "egl createSurface");
                            if (gVar.r.b()) {
                                z7 = false;
                            } else {
                                Object obj = GLThreadShareLock.LOCK;
                                synchronized (obj) {
                                    gVar.f = true;
                                    obj.notifyAll();
                                }
                                gl104 = gl10;
                            }
                        }
                        if (z8) {
                            gl102 = (GL10) gVar.r.a();
                            GLTextureView.f4148a.a(gl102);
                            z8 = false;
                        } else {
                            gl102 = gl10;
                        }
                        if (z6) {
                            Log.w("GLThread", "onSurfaceCreated");
                            GLTextureView gLTextureView2 = gVar.s.get();
                            if (gLTextureView2 != null) {
                                z = z5;
                                gLTextureView2.f.onSurfaceCreated(null, gLTextureView2.getWidth(), gLTextureView2.getHeight(), 0);
                            } else {
                                z = z5;
                            }
                            z6 = false;
                        } else {
                            z = z5;
                        }
                        if (z9) {
                            Log.w("GLThread", "onSurfaceChanged(" + i + ", " + i2 + ")");
                            GLTextureView gLTextureView3 = gVar.s.get();
                            if (gLTextureView3 != null) {
                                gLTextureView3.f.onSurfaceChanged(i, i2);
                            }
                            z9 = false;
                        }
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        GLTextureView gLTextureView4 = gVar.s.get();
                        if (gLTextureView4 != null) {
                            gLTextureView4.f.onDrawFrame(gl102);
                            fps = gLTextureView4.getFPS();
                        } else {
                            fps = 60;
                        }
                        int iG = gVar.r.g();
                        if (iG == 12288) {
                            gl103 = gl102;
                            z5 = z;
                            if (z10) {
                                z11 = true;
                            }
                            jCurrentTimeMillis = System.currentTimeMillis();
                            if (fps < 60 && fps > 0) {
                                j = ((long) (1000 / fps)) - (jCurrentTimeMillis - jCurrentTimeMillis2);
                                if (j > 1) {
                                    Object obj2 = GLThreadShareLock.LOCK;
                                    synchronized (obj2) {
                                        obj2.wait(j);
                                    }
                                }
                            }
                            gVar = this;
                            gl104 = gl103;
                        } else if (iG != 12302) {
                            f.a("GLThread", "eglSwapBuffers", iG);
                            Object obj3 = GLThreadShareLock.LOCK;
                            synchronized (obj3) {
                                gVar.f = true;
                                obj3.notifyAll();
                            }
                            gl103 = gl102;
                            z5 = z;
                            if (z10) {
                            }
                            jCurrentTimeMillis = System.currentTimeMillis();
                            if (fps < 60) {
                                j = ((long) (1000 / fps)) - (jCurrentTimeMillis - jCurrentTimeMillis2);
                                if (j > 1) {
                                }
                            }
                            gVar = this;
                            gl104 = gl103;
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("egl context lost tid=");
                            gl103 = gl102;
                            sb2.append(getId());
                            Log.i("GLThread", sb2.toString());
                            z5 = true;
                            if (z10) {
                            }
                            jCurrentTimeMillis = System.currentTimeMillis();
                            if (fps < 60) {
                            }
                            gVar = this;
                            gl104 = gl103;
                        }
                    } catch (Throwable th) {
                        synchronized (GLThreadShareLock.LOCK) {
                            k();
                            j();
                            throw th;
                        }
                    }
                }
                runnableRemove.run();
                gl104 = gl10;
            }
        }

        private boolean f() {
            return !this.d && this.e && !this.f && this.k > 0 && this.l > 0 && (this.n || this.m == 1);
        }

        private void j() {
            if (this.h) {
                this.r.e();
                this.h = false;
                GLTextureView.f4148a.a(this);
            }
        }

        private void k() {
            if (this.i) {
                this.i = false;
                this.r.c();
            }
        }

        public int b() {
            int i;
            synchronized (GLThreadShareLock.LOCK) {
                i = this.m;
            }
            return i;
        }

        public void d() {
            Object obj = GLThreadShareLock.LOCK;
            synchronized (obj) {
                Log.i("GLThread", "onPause tid=" + getId());
                this.c = true;
                obj.notifyAll();
                while (!this.b && !this.d) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        GLThreadShareLock.LOCK.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e() {
            Object obj = GLThreadShareLock.LOCK;
            synchronized (obj) {
                Log.i("GLThread", "onResume tid=" + getId());
                this.c = false;
                this.n = true;
                this.o = false;
                obj.notifyAll();
                while (!this.b && this.d && !this.o) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        GLThreadShareLock.LOCK.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g() {
            Object obj = GLThreadShareLock.LOCK;
            synchronized (obj) {
                this.f4153a = true;
                obj.notifyAll();
                while (!this.b) {
                    try {
                        GLThreadShareLock.LOCK.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h() {
            this.j = true;
            GLThreadShareLock.LOCK.notifyAll();
        }

        public void i() {
            Object obj = GLThreadShareLock.LOCK;
            synchronized (obj) {
                this.n = true;
                obj.notifyAll();
            }
        }

        public void l() {
            Object obj = GLThreadShareLock.LOCK;
            synchronized (obj) {
                this.e = true;
                obj.notifyAll();
                while (this.g && !this.b) {
                    try {
                        GLThreadShareLock.LOCK.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void m() {
            Object obj = GLThreadShareLock.LOCK;
            synchronized (obj) {
                this.e = false;
                obj.notifyAll();
                while (!this.g && !this.b) {
                    try {
                        GLThreadShareLock.LOCK.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                c();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                GLTextureView.f4148a.b(this);
                throw th;
            }
            GLTextureView.f4148a.b(this);
        }

        public boolean a() {
            return this.h && this.i && f();
        }

        public void a(int i) {
            if (i >= 0 && i <= 1) {
                Object obj = GLThreadShareLock.LOCK;
                synchronized (obj) {
                    this.m = i;
                    obj.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public void a(int i, int i2) {
            Object obj = GLThreadShareLock.LOCK;
            synchronized (obj) {
                this.k = i;
                this.l = i2;
                this.q = true;
                this.n = true;
                this.o = false;
                obj.notifyAll();
                while (!this.b && !this.d && !this.o && a()) {
                    Log.i("Main thread", "onWindowResize waiting for render complete from tid=" + getId());
                    try {
                        GLThreadShareLock.LOCK.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void a(Runnable runnable) {
            if (runnable != null) {
                Object obj = GLThreadShareLock.LOCK;
                synchronized (obj) {
                    this.p.add(runnable);
                    obj.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static String f4154a = "GLThreadManager";
        private static final Class b;
        private static final Method c;
        private boolean d;
        private int e;
        private boolean f;
        private boolean g;
        private boolean h;
        private g i;

        static {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                b = cls;
                Method declaredMethod = cls.getDeclaredMethod("getInt", String.class, Integer.TYPE);
                c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private h() {
        }

        public void a(g gVar) {
            if (this.i == gVar) {
                this.i = null;
            }
            GLThreadShareLock.LOCK.notifyAll();
        }

        public void b(g gVar) {
            Object obj = GLThreadShareLock.LOCK;
            synchronized (obj) {
                gVar.b = true;
                if (this.i == gVar) {
                    this.i = null;
                }
                obj.notifyAll();
            }
        }

        public boolean c(g gVar) {
            g gVar2 = this.i;
            if (gVar2 == gVar || gVar2 == null) {
                this.i = gVar;
                GLThreadShareLock.LOCK.notifyAll();
                return true;
            }
            a();
            if (this.g) {
                return true;
            }
            g gVar3 = this.i;
            if (gVar3 == null) {
                return false;
            }
            gVar3.h();
            return false;
        }

        public /* synthetic */ h(a aVar) {
            this();
        }

        public void a(GL10 gl10) {
            Object obj = GLThreadShareLock.LOCK;
            synchronized (obj) {
                if (!this.f) {
                    a();
                    String strGlGetString = gl10.glGetString(7937);
                    if (this.e < 131072) {
                        this.g = !strGlGetString.startsWith("Q3Dimension MSM7500 ");
                        obj.notifyAll();
                    }
                    this.h = !this.g;
                    Log.w(f4154a, "checkGLDriver renderer = \"" + strGlGetString + "\" multipleContextsAllowed = " + this.g + " mLimitedGLESContexts = " + this.h);
                    this.f = true;
                }
            }
        }

        public boolean b() {
            boolean z;
            synchronized (GLThreadShareLock.LOCK) {
                z = this.h;
            }
            return z;
        }

        public boolean c() {
            boolean z;
            synchronized (GLThreadShareLock.LOCK) {
                a();
                z = !this.g;
            }
            return z;
        }

        private void a() {
            if (this.d) {
                return;
            }
            try {
                this.e = ((Integer) c.invoke(null, "ro.opengles.version", 0)).intValue();
            } catch (Exception unused) {
                this.e = 65536;
            }
            if (this.e >= 131072) {
                this.g = true;
            }
            Log.w(f4154a, "checkGLESVersion mGLESVersion = " + this.e + " mMultipleGLESContextsAllowed = " + this.g);
            this.d = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class i extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private StringBuilder f4155a = new StringBuilder();

        private void a() {
            if (this.f4155a.length() > 0) {
                StringBuilder sb = this.f4155a;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            a();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    a();
                } else {
                    this.f4155a.append(c);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends c {
        public j(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public GLTextureView(Context context) {
        super(context);
        this.b = 60;
        this.c = new a();
        this.d = new WeakReference<>(this);
        c();
    }

    public Bitmap captureImageFromSurface(int i2, int i3, int i4, int i5, Object obj, Bitmap.Config config) {
        return a(i2, i3, i4, i5, (GL10) obj, config);
    }

    public void finalize() throws Throwable {
        try {
            g gVar = this.e;
            if (gVar != null) {
                gVar.g();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.l;
    }

    public int getFPS() {
        return this.b;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.n;
    }

    public int getRenderMode() {
        return this.e.b();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("GLTextureView", "onAttachedToWindow reattach =" + this.g);
        if (this.g && this.f != null) {
            g gVar = this.e;
            int iB = gVar != null ? gVar.b() : 1;
            g gVar2 = new g(this.d);
            this.e = gVar2;
            if (iB != 1) {
                gVar2.a(iB);
            }
            this.e.start();
        }
        this.g = false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Log.d("GLTextureView", "onDetachedFromWindow");
        g gVar = this.e;
        if (gVar != null) {
            gVar.g();
        }
        this.g = true;
        super.onDetachedFromWindow();
    }

    public void onPause() {
        g gVar = this.e;
        if (gVar != null) {
            gVar.d();
        }
    }

    public void onResume() {
        g gVar = this.e;
        if (gVar != null) {
            gVar.e();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        surfaceCreated(surfaceTexture);
        surfaceChanged(surfaceTexture, 0, i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        surfaceDestroyed(surfaceTexture);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        surfaceChanged(surfaceTexture, 0, i2, i3);
    }

    public void queueEvent(Runnable runnable) {
        g gVar = this.e;
        if (gVar != null) {
            gVar.a(runnable);
        }
    }

    public void requestRender() {
        g gVar = this.e;
        if (gVar != null) {
            gVar.i();
        }
    }

    public void setDebugFlags(int i2) {
        this.l = i2;
    }

    public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser eGLConfigChooser) {
        b();
        this.h = eGLConfigChooser;
    }

    public void setEGLContextClientVersion(int i2) {
        b();
        this.m = i2;
    }

    public void setEGLContextFactory(GLSurfaceView.EGLContextFactory eGLContextFactory) {
        b();
        this.i = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(GLSurfaceView.EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        b();
        this.j = eGLWindowSurfaceFactory;
    }

    public void setFPS(int i2) {
        this.b = i2;
    }

    public void setGLWrapper(GLSurfaceView.GLWrapper gLWrapper) {
        this.k = gLWrapper;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.n = z;
    }

    public void setRenderMode(int i2) {
        this.e.a(i2);
    }

    public void setRenderer(SurfaceRenderer surfaceRenderer) {
        b();
        if (this.h == null) {
            try {
                if (EglConfigUtils.isSupportConfig(8, 8, 8, 0, 24, 8, 0, 0)) {
                    setEGLConfigChooser(8, 8, 8, 0, 24, 8);
                } else {
                    setEGLConfigChooser(true);
                }
            } catch (IllegalArgumentException unused) {
                setEGLConfigChooser(true);
            }
        }
        a aVar = null;
        if (this.i == null) {
            this.i = new d(this, aVar);
        }
        if (this.j == null) {
            this.j = new e(aVar);
        }
        this.f = surfaceRenderer;
        g gVar = new g(this.d);
        this.e = gVar;
        gVar.start();
    }

    public void surfaceChanged(SurfaceTexture surfaceTexture, int i2, int i3, int i4) {
        g gVar = this.e;
        if (gVar != null) {
            gVar.a(i3, i4);
        }
    }

    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        g gVar = this.e;
        if (gVar != null) {
            gVar.l();
        }
    }

    public void surfaceDestroyed(SurfaceTexture surfaceTexture) {
        g gVar = this.e;
        if (gVar != null) {
            gVar.m();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements GLSurfaceView.EGLContextFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4151a;

        private d() {
            this.f4151a = 12440;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f4151a, GLTextureView.this.m, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.m == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            f.b("eglDestroyContex", egl10.eglGetError());
        }

        public /* synthetic */ d(GLTextureView gLTextureView, a aVar) {
            this();
        }
    }

    private void b() {
        if (this.e != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private void c() {
        setSurfaceTextureListener(this);
        addOnLayoutChangeListener(this.c);
    }

    private Bitmap a(int i2, int i3, int i4, int i5, GL10 gl10, Bitmap.Config config) {
        int i6 = i4 * i5;
        int[] iArr = new int[i6];
        int[] iArr2 = new int[i6];
        IntBuffer intBufferWrap = IntBuffer.wrap(iArr);
        intBufferWrap.position(0);
        try {
            gl10.glReadPixels(i2, i3, i4, i5, 6408, 5121, intBufferWrap);
            for (int i7 = 0; i7 < i5; i7++) {
                int i8 = i7 * i4;
                int i9 = ((i5 - i7) - 1) * i4;
                for (int i10 = 0; i10 < i4; i10++) {
                    int i11 = iArr[i8 + i10];
                    iArr2[i9 + i10] = (i11 & (-16711936)) | ((i11 << 16) & 16711680) | ((i11 >> 16) & 255);
                }
            }
            if (config == null) {
                return Bitmap.createBitmap(iArr2, i4, i5, Bitmap.Config.ARGB_8888);
            }
            return Bitmap.createBitmap(iArr2, i4, i5, config);
        } catch (GLException unused) {
            return null;
        } catch (OutOfMemoryError e2) {
            Log.e("OutOfMemoryError", " createBitmap cause OutOfMemoryError : " + e2.getMessage());
            return null;
        }
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new j(z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new c(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        setEGLConfigChooser(new c(i2, i3, i4, i5, i6, i7, i8));
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 60;
        this.c = new a();
        this.d = new WeakReference<>(this);
        c();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends b {
        private int[] c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        protected int i;
        protected int j;

        public c(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.c = new int[1];
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            this.h = i5;
            this.i = i6;
            this.j = 1;
        }

        @Override // com.baidu.platform.comapi.map.GLTextureView.b
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            EGLConfig eGLConfig = null;
            for (EGLConfig eGLConfig2 : eGLConfigArr) {
                int iA = a(egl10, eGLDisplay, eGLConfig2, 12325, 0);
                int iA2 = a(egl10, eGLDisplay, eGLConfig2, 12326, 0);
                if (iA >= this.h && iA2 >= this.i) {
                    int iA3 = a(egl10, eGLDisplay, eGLConfig2, 12324, 0);
                    int iA4 = a(egl10, eGLDisplay, eGLConfig2, 12323, 0);
                    int iA5 = a(egl10, eGLDisplay, eGLConfig2, 12322, 0);
                    int iA6 = a(egl10, eGLDisplay, eGLConfig2, 12321, 0);
                    if (iA3 == this.d && iA4 == this.e && iA5 == this.f && iA6 == this.g) {
                        if (eGLConfig == null) {
                            eGLConfig = eGLConfig2;
                        }
                        if (a(egl10, eGLDisplay, eGLConfig2, 12337, 0) == this.j) {
                            return eGLConfig2;
                        }
                    }
                }
            }
            return eGLConfig;
        }

        public c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12338, 1, 12337, i7, 12344});
            this.c = new int[1];
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            this.h = i5;
            this.i = i6;
            this.j = i7;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.c) ? this.c[0] : i2;
        }
    }

    public GLTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = 60;
        this.c = new a();
        this.d = new WeakReference<>(this);
        c();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
