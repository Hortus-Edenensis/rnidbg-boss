package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.opengl.GLDebugHelper;
import android.opengl.GLException;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.platform.comapi.map.s;
import com.heytap.mcssdk.constant.MessageConstant;
import java.io.Writer;
import java.lang.ref.WeakReference;
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
class e implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final k f4200a = new k();
    private WeakReference<SurfaceView> b;
    private int c = 60;
    private final WeakReference<e> d = new WeakReference<>(this);
    private j e;
    private SurfaceRenderer f;
    private boolean g;
    private f h;
    private g i;
    private h j;
    private l k;
    private int l;
    private int m;
    private boolean n;

    /* JADX INFO: compiled from: SearchBox */
    public abstract class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int[] f4201a;

        public b(int[] iArr) {
            this.f4201a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (e.this.m != 2 && e.this.m != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (e.this.m == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // com.baidu.platform.comapi.map.e.f
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f4201a, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f4201a, eGLConfigArr, i, iArr)) {
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
    public class d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4202a;

        private d() {
            this.f4202a = 12440;
        }

        @Override // com.baidu.platform.comapi.map.e.g
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f4202a, e.this.m, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (e.this.m == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.platform.comapi.map.e.g
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (eGLContext == null || eGLDisplay == null) {
                return;
            }
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            i.b("eglDestroyContex", egl10.eglGetError());
        }
    }

    /* JADX INFO: renamed from: com.baidu.platform.comapi.map.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0106e implements h {
        private C0106e() {
        }

        @Override // com.baidu.platform.comapi.map.e.h
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLRenderControl", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.baidu.platform.comapi.map.e.h
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface h {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class j extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f4204a;
        private boolean b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean q;
        private i u;
        private long v;
        private long w;
        private WeakReference<e> y;
        private ArrayList<Runnable> r = new ArrayList<>();
        private boolean s = true;
        private Runnable t = null;
        private int x = 60;
        private int l = 0;
        private int m = 0;
        private boolean o = true;
        private int n = 1;
        private boolean p = false;

        public j(WeakReference<e> weakReference) {
            this.y = weakReference;
            setPriority(10);
        }

        /* JADX WARN: Removed duplicated region for block: B:111:0x017d A[Catch: all -> 0x0296, TryCatch #7 {all -> 0x0296, blocks: (B:4:0x001f, B:5:0x0023, B:88:0x013f, B:90:0x0147, B:92:0x014f, B:93:0x0153, B:100:0x0163, B:101:0x0164, B:102:0x0168, B:109:0x017a, B:111:0x017d, B:113:0x0189, B:116:0x01a8, B:124:0x01c9, B:127:0x01da, B:129:0x01e3, B:130:0x01ea, B:132:0x01ec, B:142:0x0210, B:146:0x021e, B:147:0x0229, B:162:0x0249, B:164:0x025b, B:165:0x025f, B:171:0x026b, B:172:0x026c, B:154:0x0238, B:140:0x020d, B:118:0x01b1, B:119:0x01b8, B:180:0x0295, B:115:0x0193, B:95:0x0155, B:96:0x015e, B:126:0x01d3, B:6:0x0024, B:8:0x0028, B:17:0x0039, B:19:0x0041, B:86:0x013c, B:20:0x004d, B:22:0x0053, B:24:0x005e, B:26:0x0062, B:28:0x006e, B:30:0x0077, B:32:0x007b, B:34:0x0080, B:36:0x0084, B:41:0x0096, B:39:0x0090, B:42:0x0099, B:44:0x009d, B:46:0x00a1, B:48:0x00a5, B:49:0x00a8, B:50:0x00b5, B:52:0x00b9, B:54:0x00bd, B:56:0x00c9, B:57:0x00d7, B:59:0x00db, B:60:0x00df, B:62:0x00e5, B:66:0x00ed, B:68:0x00f3, B:70:0x00ff, B:71:0x0106, B:72:0x0107, B:74:0x010b, B:76:0x010f, B:77:0x0115, B:79:0x0119, B:81:0x011d, B:83:0x012e, B:177:0x0289, B:176:0x027e, B:149:0x022b, B:150:0x0234, B:104:0x016a, B:105:0x0175, B:166:0x0260, B:167:0x0267, B:134:0x01fa, B:136:0x0203, B:137:0x0207), top: B:203:0x001f, inners: #0, #1, #2, #3, #5, #9, #10, #11 }] */
        /* JADX WARN: Removed duplicated region for block: B:113:0x0189 A[Catch: all -> 0x0296, TRY_LEAVE, TryCatch #7 {all -> 0x0296, blocks: (B:4:0x001f, B:5:0x0023, B:88:0x013f, B:90:0x0147, B:92:0x014f, B:93:0x0153, B:100:0x0163, B:101:0x0164, B:102:0x0168, B:109:0x017a, B:111:0x017d, B:113:0x0189, B:116:0x01a8, B:124:0x01c9, B:127:0x01da, B:129:0x01e3, B:130:0x01ea, B:132:0x01ec, B:142:0x0210, B:146:0x021e, B:147:0x0229, B:162:0x0249, B:164:0x025b, B:165:0x025f, B:171:0x026b, B:172:0x026c, B:154:0x0238, B:140:0x020d, B:118:0x01b1, B:119:0x01b8, B:180:0x0295, B:115:0x0193, B:95:0x0155, B:96:0x015e, B:126:0x01d3, B:6:0x0024, B:8:0x0028, B:17:0x0039, B:19:0x0041, B:86:0x013c, B:20:0x004d, B:22:0x0053, B:24:0x005e, B:26:0x0062, B:28:0x006e, B:30:0x0077, B:32:0x007b, B:34:0x0080, B:36:0x0084, B:41:0x0096, B:39:0x0090, B:42:0x0099, B:44:0x009d, B:46:0x00a1, B:48:0x00a5, B:49:0x00a8, B:50:0x00b5, B:52:0x00b9, B:54:0x00bd, B:56:0x00c9, B:57:0x00d7, B:59:0x00db, B:60:0x00df, B:62:0x00e5, B:66:0x00ed, B:68:0x00f3, B:70:0x00ff, B:71:0x0106, B:72:0x0107, B:74:0x010b, B:76:0x010f, B:77:0x0115, B:79:0x0119, B:81:0x011d, B:83:0x012e, B:177:0x0289, B:176:0x027e, B:149:0x022b, B:150:0x0234, B:104:0x016a, B:105:0x0175, B:166:0x0260, B:167:0x0267, B:134:0x01fa, B:136:0x0203, B:137:0x0207), top: B:203:0x001f, inners: #0, #1, #2, #3, #5, #9, #10, #11 }] */
        /* JADX WARN: Removed duplicated region for block: B:122:0x01c1  */
        /* JADX WARN: Removed duplicated region for block: B:124:0x01c9 A[Catch: all -> 0x0296, TRY_LEAVE, TryCatch #7 {all -> 0x0296, blocks: (B:4:0x001f, B:5:0x0023, B:88:0x013f, B:90:0x0147, B:92:0x014f, B:93:0x0153, B:100:0x0163, B:101:0x0164, B:102:0x0168, B:109:0x017a, B:111:0x017d, B:113:0x0189, B:116:0x01a8, B:124:0x01c9, B:127:0x01da, B:129:0x01e3, B:130:0x01ea, B:132:0x01ec, B:142:0x0210, B:146:0x021e, B:147:0x0229, B:162:0x0249, B:164:0x025b, B:165:0x025f, B:171:0x026b, B:172:0x026c, B:154:0x0238, B:140:0x020d, B:118:0x01b1, B:119:0x01b8, B:180:0x0295, B:115:0x0193, B:95:0x0155, B:96:0x015e, B:126:0x01d3, B:6:0x0024, B:8:0x0028, B:17:0x0039, B:19:0x0041, B:86:0x013c, B:20:0x004d, B:22:0x0053, B:24:0x005e, B:26:0x0062, B:28:0x006e, B:30:0x0077, B:32:0x007b, B:34:0x0080, B:36:0x0084, B:41:0x0096, B:39:0x0090, B:42:0x0099, B:44:0x009d, B:46:0x00a1, B:48:0x00a5, B:49:0x00a8, B:50:0x00b5, B:52:0x00b9, B:54:0x00bd, B:56:0x00c9, B:57:0x00d7, B:59:0x00db, B:60:0x00df, B:62:0x00e5, B:66:0x00ed, B:68:0x00f3, B:70:0x00ff, B:71:0x0106, B:72:0x0107, B:74:0x010b, B:76:0x010f, B:77:0x0115, B:79:0x0119, B:81:0x011d, B:83:0x012e, B:177:0x0289, B:176:0x027e, B:149:0x022b, B:150:0x0234, B:104:0x016a, B:105:0x0175, B:166:0x0260, B:167:0x0267, B:134:0x01fa, B:136:0x0203, B:137:0x0207), top: B:203:0x001f, inners: #0, #1, #2, #3, #5, #9, #10, #11 }] */
        /* JADX WARN: Removed duplicated region for block: B:141:0x020e  */
        /* JADX WARN: Removed duplicated region for block: B:144:0x021a  */
        /* JADX WARN: Removed duplicated region for block: B:156:0x023d  */
        /* JADX WARN: Removed duplicated region for block: B:159:0x0242  */
        /* JADX WARN: Removed duplicated region for block: B:164:0x025b A[Catch: all -> 0x0296, TryCatch #7 {all -> 0x0296, blocks: (B:4:0x001f, B:5:0x0023, B:88:0x013f, B:90:0x0147, B:92:0x014f, B:93:0x0153, B:100:0x0163, B:101:0x0164, B:102:0x0168, B:109:0x017a, B:111:0x017d, B:113:0x0189, B:116:0x01a8, B:124:0x01c9, B:127:0x01da, B:129:0x01e3, B:130:0x01ea, B:132:0x01ec, B:142:0x0210, B:146:0x021e, B:147:0x0229, B:162:0x0249, B:164:0x025b, B:165:0x025f, B:171:0x026b, B:172:0x026c, B:154:0x0238, B:140:0x020d, B:118:0x01b1, B:119:0x01b8, B:180:0x0295, B:115:0x0193, B:95:0x0155, B:96:0x015e, B:126:0x01d3, B:6:0x0024, B:8:0x0028, B:17:0x0039, B:19:0x0041, B:86:0x013c, B:20:0x004d, B:22:0x0053, B:24:0x005e, B:26:0x0062, B:28:0x006e, B:30:0x0077, B:32:0x007b, B:34:0x0080, B:36:0x0084, B:41:0x0096, B:39:0x0090, B:42:0x0099, B:44:0x009d, B:46:0x00a1, B:48:0x00a5, B:49:0x00a8, B:50:0x00b5, B:52:0x00b9, B:54:0x00bd, B:56:0x00c9, B:57:0x00d7, B:59:0x00db, B:60:0x00df, B:62:0x00e5, B:66:0x00ed, B:68:0x00f3, B:70:0x00ff, B:71:0x0106, B:72:0x0107, B:74:0x010b, B:76:0x010f, B:77:0x0115, B:79:0x0119, B:81:0x011d, B:83:0x012e, B:177:0x0289, B:176:0x027e, B:149:0x022b, B:150:0x0234, B:104:0x016a, B:105:0x0175, B:166:0x0260, B:167:0x0267, B:134:0x01fa, B:136:0x0203, B:137:0x0207), top: B:203:0x001f, inners: #0, #1, #2, #3, #5, #9, #10, #11 }] */
        /* JADX WARN: Removed duplicated region for block: B:197:0x029c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:210:0x01fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void c() throws InterruptedException {
            boolean z;
            boolean z2;
            long jCurrentTimeMillis;
            e eVar;
            int fps;
            int iG;
            long jCurrentTimeMillis2;
            boolean z3;
            this.u = new i(this.y);
            this.h = false;
            this.i = false;
            this.p = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            Runnable runnable = null;
            GL10 gl10 = null;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            int i = 0;
            int i2 = 0;
            while (true) {
                Runnable runnableRemove = null;
                while (true) {
                    try {
                        synchronized (e.f4200a) {
                            while (!this.f4204a) {
                                if (this.r.isEmpty()) {
                                    boolean z12 = this.d;
                                    boolean z13 = this.c;
                                    if (z12 != z13) {
                                        this.d = z13;
                                        e.f4200a.notifyAll();
                                    } else {
                                        z13 = false;
                                    }
                                    if (this.k) {
                                        j();
                                        i();
                                        this.k = false;
                                        z6 = true;
                                    }
                                    if (z4) {
                                        j();
                                        i();
                                        z4 = false;
                                    }
                                    if (z13 && this.i) {
                                        j();
                                    }
                                    if (z13 && this.h) {
                                        e eVar2 = this.y.get();
                                        if (!(eVar2 == null ? false : eVar2.n)) {
                                            i();
                                        }
                                    }
                                    if (!this.e && !this.g) {
                                        if (this.i) {
                                            j();
                                        }
                                        this.g = true;
                                        this.f = false;
                                        e.f4200a.notifyAll();
                                    }
                                    if (this.e && this.g) {
                                        this.g = false;
                                        e.f4200a.notifyAll();
                                    }
                                    if (z5) {
                                        this.p = false;
                                        this.q = true;
                                        e.f4200a.notifyAll();
                                        z5 = false;
                                    }
                                    Runnable runnable2 = this.t;
                                    if (runnable2 != null) {
                                        this.t = null;
                                        runnable = runnable2;
                                    }
                                    if (f()) {
                                        if (!this.h) {
                                            if (z6) {
                                                z6 = false;
                                            } else {
                                                try {
                                                    this.u.f();
                                                    this.h = true;
                                                    e.f4200a.notifyAll();
                                                    z7 = true;
                                                } catch (RuntimeException e) {
                                                    e.f4200a.a(this);
                                                    throw e;
                                                }
                                            }
                                        }
                                        if (this.h && !this.i) {
                                            this.i = true;
                                            z8 = true;
                                            z9 = true;
                                            z10 = true;
                                        }
                                        if (this.i) {
                                            if (this.s) {
                                                int i3 = this.l;
                                                int i4 = this.m;
                                                this.p = true;
                                                this.s = false;
                                                i = i3;
                                                i2 = i4;
                                                z3 = false;
                                                z8 = true;
                                                z10 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            this.o = z3;
                                            e.f4200a.notifyAll();
                                            if (this.p) {
                                                z11 = true;
                                            }
                                        }
                                    } else if (runnable != null) {
                                        Log.w("GLRenderControl", "Warning, !readyToDraw() but waiting for draw finished! Early reporting draw finished.");
                                        runnable.run();
                                        runnable = null;
                                    }
                                    e.f4200a.wait();
                                } else {
                                    runnableRemove = this.r.remove(0);
                                }
                            }
                            synchronized (e.f4200a) {
                                j();
                                i();
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        synchronized (e.f4200a) {
                        }
                    }
                    if (runnableRemove != null) {
                        break;
                    }
                    if (z8) {
                        if (this.u.b()) {
                            synchronized (e.f4200a) {
                                this.j = true;
                                e.f4200a.notifyAll();
                            }
                            z8 = false;
                            if (z9) {
                            }
                            if (z7) {
                            }
                            if (z10) {
                            }
                            jCurrentTimeMillis = System.currentTimeMillis();
                            eVar = this.y.get();
                            if (eVar == null) {
                            }
                            iG = this.u.g();
                            if (iG != 12288) {
                            }
                            if (z11) {
                            }
                            if (fps <= 60) {
                                jCurrentTimeMillis2 = ((long) (1000 / fps)) - (System.currentTimeMillis() - jCurrentTimeMillis);
                                if (jCurrentTimeMillis2 > 1) {
                                }
                            }
                            a(System.currentTimeMillis() - jCurrentTimeMillis);
                            z5 = z2;
                            z4 = z;
                        } else {
                            synchronized (e.f4200a) {
                                this.j = true;
                                this.f = true;
                                e.f4200a.notifyAll();
                            }
                        }
                        synchronized (e.f4200a) {
                            j();
                            i();
                            throw th;
                        }
                    }
                    if (z9) {
                        gl10 = (GL10) this.u.a();
                        z9 = false;
                    }
                    if (z7) {
                        z = z4;
                        z2 = z5;
                    } else {
                        e eVar3 = this.y.get();
                        if (eVar3 != null) {
                            try {
                                z = z4;
                                z2 = z5;
                                eVar3.f.onSurfaceCreated(null, eVar3.e(), eVar3.c(), 0);
                                Log.d("GLRenderControl", "mRenderer.onSurfaceCreated");
                            } catch (Throwable th2) {
                                Log.d("GLRenderControl", "mRenderer.onSurfaceCreated");
                                throw th2;
                            }
                        } else {
                            z = z4;
                            z2 = z5;
                        }
                        z7 = false;
                    }
                    if (z10) {
                        e eVar4 = this.y.get();
                        if (eVar4 != null) {
                            try {
                                eVar4.f.onSurfaceChanged(i, i2);
                                Log.d("GLRenderControl", "mRenderer.onSurfaceChanged");
                            } catch (Throwable th3) {
                                Log.d("GLRenderControl", "mRenderer.onSurfaceChanged");
                                throw th3;
                            }
                        }
                        z10 = false;
                    }
                    jCurrentTimeMillis = System.currentTimeMillis();
                    eVar = this.y.get();
                    if (eVar == null) {
                        eVar.f.onDrawFrame(gl10);
                        if (runnable != null) {
                            runnable.run();
                            runnable = null;
                        }
                        fps = eVar.getFPS();
                    } else {
                        fps = 60;
                    }
                    iG = this.u.g();
                    if (iG != 12288) {
                        if (iG != 12302) {
                            i.a("GLThread", "eglSwapBuffers", iG);
                            synchronized (e.f4200a) {
                                this.f = true;
                                e.f4200a.notifyAll();
                            }
                        } else {
                            z = true;
                        }
                    }
                    if (z11) {
                        z11 = false;
                        z2 = true;
                    }
                    if (fps <= 60 && fps > 0) {
                        jCurrentTimeMillis2 = ((long) (1000 / fps)) - (System.currentTimeMillis() - jCurrentTimeMillis);
                        if (jCurrentTimeMillis2 > 1) {
                            synchronized (e.f4200a) {
                                e.f4200a.wait(jCurrentTimeMillis2);
                            }
                        }
                    }
                    a(System.currentTimeMillis() - jCurrentTimeMillis);
                    z5 = z2;
                    z4 = z;
                }
                runnableRemove.run();
            }
        }

        private boolean f() {
            return !this.d && this.e && !this.f && this.l > 0 && this.m > 0 && (this.o || this.n == 1);
        }

        private void i() {
            if (this.h) {
                this.u.e();
                this.h = false;
                e.f4200a.a(this);
            }
        }

        private void j() {
            if (this.i) {
                this.i = false;
                this.u.c();
            }
        }

        public int b() {
            int i;
            synchronized (e.f4200a) {
                i = this.n;
            }
            return i;
        }

        public void d() {
            synchronized (e.f4200a) {
                this.c = true;
                e.f4200a.notifyAll();
                while (!this.b && !this.d) {
                    try {
                        e.f4200a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e() {
            synchronized (e.f4200a) {
                this.c = false;
                this.o = true;
                this.q = false;
                e.f4200a.notifyAll();
                while (!this.b && this.d && !this.q) {
                    try {
                        e.f4200a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g() {
            synchronized (e.f4200a) {
                this.f4204a = true;
                e.f4200a.notifyAll();
                while (!this.b) {
                    try {
                        e.f4200a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h() {
            synchronized (e.f4200a) {
                this.o = true;
                e.f4200a.notifyAll();
            }
        }

        public void k() {
            synchronized (e.f4200a) {
                this.e = true;
                this.j = false;
                e.f4200a.notifyAll();
                while (this.g && !this.j && !this.b) {
                    try {
                        e.f4200a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void l() {
            synchronized (e.f4200a) {
                this.e = false;
                e.f4200a.notifyAll();
                while (!this.g && !this.b) {
                    try {
                        e.f4200a.wait();
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
                e.f4200a.b(this);
                throw th;
            }
            e.f4200a.b(this);
        }

        private void a(long j) {
            long j2 = this.v + 1;
            this.v = j2;
            long j3 = this.w + j;
            this.w = j3;
            if (j2 >= 10) {
                int i = (int) (j3 / j2);
                if (i <= 0) {
                    this.v = 0L;
                    this.w = 0L;
                } else {
                    this.x = (this.x + (1000 / i)) / 2;
                    this.v = 0L;
                    this.w = 0L;
                }
            }
        }

        public void b(Runnable runnable) {
            synchronized (e.f4200a) {
                if (Thread.currentThread() == this) {
                    return;
                }
                this.p = true;
                this.o = true;
                this.q = false;
                this.t = runnable;
                e.f4200a.notifyAll();
            }
        }

        public boolean a() {
            return this.h && this.i && f();
        }

        public void a(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (e.f4200a) {
                    this.n = i;
                    e.f4200a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public void a(int i, int i2) {
            synchronized (e.f4200a) {
                this.l = i;
                this.m = i2;
                this.s = true;
                this.o = true;
                this.q = false;
                if (Thread.currentThread() == this) {
                    return;
                }
                e.f4200a.notifyAll();
                while (!this.b && !this.d && !this.q && a()) {
                    try {
                        e.f4200a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void a(Runnable runnable) {
            if (runnable != null) {
                synchronized (e.f4200a) {
                    this.r.add(runnable);
                    e.f4200a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k {
        private k() {
        }

        public synchronized void a(j jVar) {
            notifyAll();
        }

        public synchronized void b(j jVar) {
            jVar.b = true;
            notifyAll();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface l {
        GL a(GL gl);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class m extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private StringBuilder f4205a = new StringBuilder();

        private void a() {
            if (this.f4205a.length() > 0) {
                Log.v("GLSurfaceView26", this.f4205a.toString());
                StringBuilder sb = this.f4205a;
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
                    this.f4205a.append(c);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n extends c {
        public n(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0, 0, 0);
        }
    }

    public e(SurfaceView surfaceView) {
        this.b = new WeakReference<>(surfaceView);
    }

    @Override // com.baidu.platform.comapi.map.r
    public Bitmap captureImageFromSurface(int i2, int i3, int i4, int i5, Object obj, Bitmap.Config config) {
        return a(i2, i3, i4, i5, (GL10) obj, config);
    }

    public void finalize() throws Throwable {
        try {
            j jVar = this.e;
            if (jVar != null) {
                jVar.g();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.baidu.platform.comapi.map.r
    public int getDebugFlags() {
        return this.l;
    }

    @Override // com.baidu.platform.comapi.map.r
    public int getFPS() {
        return this.c;
    }

    @Override // com.baidu.platform.comapi.map.r
    public int getRenderMode() {
        return this.e.b();
    }

    @Override // com.baidu.platform.comapi.map.r
    public s.a getViewType() {
        return s.a.OPENGL_ES;
    }

    @Override // com.baidu.platform.comapi.map.r
    public void onAttachedToWindow() {
        if (this.g && this.f != null) {
            j jVar = this.e;
            int iB = jVar != null ? jVar.b() : 1;
            j jVar2 = new j(this.d);
            this.e = jVar2;
            if (iB != 1) {
                jVar2.a(iB);
            }
            this.e.start();
        }
        this.g = false;
    }

    @Override // com.baidu.platform.comapi.map.r
    public void onDetachedFromWindow() {
        j jVar = this.e;
        if (jVar != null) {
            jVar.g();
        }
        this.g = true;
    }

    @Override // com.baidu.platform.comapi.map.r
    public void onPause() {
        this.e.d();
    }

    @Override // com.baidu.platform.comapi.map.r
    public void onResume() {
        this.e.e();
    }

    @Override // com.baidu.platform.comapi.map.r
    public void queueEvent(Runnable runnable) {
        this.e.a(runnable);
    }

    @Override // com.baidu.platform.comapi.map.r
    public void requestRender() {
        this.e.h();
    }

    @Override // com.baidu.platform.comapi.map.r
    public void setDebugFlags(int i2) {
        this.l = i2;
    }

    @Override // com.baidu.platform.comapi.map.r
    public void setFPS(int i2) {
        if (i2 <= 0) {
            return;
        }
        if (i2 > 60) {
            i2 = 60;
        }
        this.c = i2;
    }

    @Override // com.baidu.platform.comapi.map.r
    public void setRenderMode(int i2) {
        this.e.a(i2);
    }

    @Override // com.baidu.platform.comapi.map.r
    public void setRenderer(SurfaceRenderer surfaceRenderer) {
        b();
        if (this.h == null) {
            this.h = new n(true);
        }
        if (this.i == null) {
            this.i = new d();
        }
        if (this.j == null) {
            this.j = new C0106e();
        }
        this.f = surfaceRenderer;
        j jVar = new j(this.d);
        this.e = jVar;
        jVar.start();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.e.a(i3, i4);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.e.k();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.e.l();
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        j jVar = this.e;
        if (jVar != null) {
            jVar.b(runnable);
        }
    }

    public void b(boolean z) {
        this.n = z;
    }

    public int c() {
        SurfaceView surfaceView = this.b.get();
        if (surfaceView != null) {
            return surfaceView.getHeight();
        }
        return 0;
    }

    public SurfaceHolder d() {
        SurfaceView surfaceView = this.b.get();
        if (surfaceView != null) {
            return surfaceView.getHolder();
        }
        return null;
    }

    public int e() {
        SurfaceView surfaceView = this.b.get();
        if (surfaceView != null) {
            return surfaceView.getWidth();
        }
        return 0;
    }

    private void b() {
        if (this.e != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public void a(g gVar) {
        b();
        this.i = gVar;
    }

    public void a(f fVar) {
        b();
        this.h = fVar;
    }

    public void a(boolean z) {
        a(new n(z));
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        a(new c(i2, i3, i4, i5, i6, i7, i8, i9));
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<e> f4203a;
        EGL10 b;
        EGLDisplay c;
        EGLSurface d;
        EGLConfig e;
        EGLContext f;

        public i(WeakReference<e> weakReference) {
            this.f4203a = weakReference;
        }

        private void d() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.d;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.b.eglMakeCurrent(this.c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            e eVar = this.f4203a.get();
            if (eVar != null) {
                eVar.j.destroySurface(this.b, this.c, this.d);
            }
            this.d = null;
        }

        public GL a() {
            GL gl = this.f.getGL();
            e eVar = this.f4203a.get();
            if (eVar == null) {
                return gl;
            }
            if (eVar.k != null) {
                gl = eVar.k.a(gl);
            }
            if ((eVar.l & 3) != 0) {
                return GLDebugHelper.wrap(gl, (eVar.l & 1) == 0 ? 0 : 1, (eVar.l & 2) != 0 ? new m() : null);
            }
            return gl;
        }

        public boolean b() {
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
            e eVar = this.f4203a.get();
            if (eVar != null) {
                this.d = eVar.j.createWindowSurface(this.b, this.c, this.e, eVar.d());
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
            d();
        }

        public void e() {
            if (this.f != null) {
                e eVar = this.f4203a.get();
                if (eVar != null) {
                    eVar.i.destroyContext(this.b, this.c, this.f);
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
            e eVar = this.f4203a.get();
            if (eVar == null) {
                this.e = null;
                this.f = null;
            } else {
                try {
                    this.e = eVar.h.chooseConfig(this.b, this.c);
                    this.f = eVar.i.createContext(this.b, this.c, this.e);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    return;
                }
            }
            EGLContext eGLContext = this.f;
            if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                this.f = null;
                a("createContext");
            }
            this.d = null;
        }

        public int g() {
            return !this.b.eglSwapBuffers(this.c, this.d) ? this.b.eglGetError() : MessageConstant.CommandId.COMMAND_BASE;
        }

        private void a(String str) {
            b(str, this.b.eglGetError());
        }

        public static void a(String str, String str2, int i) {
            Log.w(str, a(str2, i));
        }

        public static String a(String str, int i) {
            return str + " failed: " + a(i);
        }

        private static String a(int i) {
            switch (i) {
                case MessageConstant.CommandId.COMMAND_BASE /* 12288 */:
                    return "EGL_SUCCESS";
                case 12289:
                    return "EGL_NOT_INITIALIZED";
                case MessageConstant.CommandId.COMMAND_UNREGISTER /* 12290 */:
                    return "EGL_BAD_ACCESS";
                case MessageConstant.CommandId.COMMAND_STATISTIC /* 12291 */:
                    return "EGL_BAD_ALLOC";
                case MessageConstant.CommandId.COMMAND_SET_ALIAS /* 12292 */:
                    return "EGL_BAD_ATTRIBUTE";
                case 12293:
                    return "EGL_BAD_CONFIG";
                case 12294:
                    return "EGL_BAD_CONTEXT";
                case 12295:
                    return "EGL_BAD_CURRENT_SURFACE";
                case 12296:
                    return "EGL_BAD_DISPLAY";
                case 12297:
                    return "EGL_BAD_MATCH";
                case MessageConstant.CommandId.COMMAND_SET_PUSH_TIME /* 12298 */:
                    return "EGL_BAD_NATIVE_PIXMAP";
                case MessageConstant.CommandId.COMMAND_PAUSE_PUSH /* 12299 */:
                    return "EGL_BAD_NATIVE_WINDOW";
                case MessageConstant.CommandId.COMMAND_RESUME_PUSH /* 12300 */:
                    return "EGL_BAD_PARAMETER";
                case 12301:
                    return "EGL_BAD_SURFACE";
                case 12302:
                    return "EGL_CONTEXT_LOST";
                default:
                    return b(i);
            }
        }

        public static void b(String str, int i) {
            throw new RuntimeException(a(str, i));
        }

        private static String b(int i) {
            return "0x" + Integer.toHexString(i);
        }
    }

    public void a(int i2) {
        b();
        this.m = i2;
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
        protected int k;

        public c(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12338, i7, 12337, i8, 12344});
            this.c = new int[1];
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            this.h = i5;
            this.i = i6;
            this.j = i7;
            this.k = i8;
        }

        @Override // com.baidu.platform.comapi.map.e.b
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
                        if (a(egl10, eGLDisplay, eGLConfig2, 12337, 0) == this.k) {
                            return eGLConfig2;
                        }
                    }
                }
            }
            return eGLConfig;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.c) ? this.c[0] : i2;
        }
    }

    private Bitmap a(int i2, int i3, int i4, int i5, GL10 gl10, Bitmap.Config config) {
        Bitmap bitmapCreateBitmap;
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
                bitmapCreateBitmap = Bitmap.createBitmap(iArr2, i4, i5, Bitmap.Config.ARGB_8888);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(iArr2, i4, i5, config);
            }
            return a(bitmapCreateBitmap);
        } catch (GLException unused) {
            return null;
        }
    }

    public Bitmap a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int i2 = width * height;
        int[] iArr = new int[i2];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = (iArr[i3] & 16777215) | (-16777216);
        }
        bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmapCreateBitmap;
    }

    @Override // android.view.SurfaceHolder.Callback2
    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }
}
