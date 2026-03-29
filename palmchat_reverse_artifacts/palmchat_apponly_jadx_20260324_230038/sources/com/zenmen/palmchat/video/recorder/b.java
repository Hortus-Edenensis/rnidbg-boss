package com.zenmen.palmchat.video.recorder;

import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.ttvecamera.TECameraSettings;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.video.recorder.CameraView;
import com.zenmen.palmchat.video.recorder.a;
import com.zenmen.palmchat.video.recorder.gles.Drawable2d;
import com.zenmen.palmchat.video.recorder.gles.Texture2dProgram;
import defpackage.g13;
import defpackage.gc2;
import defpackage.kh5;
import defpackage.lv4;
import defpackage.o25;
import defpackage.ok1;
import defpackage.uy;
import defpackage.xn6;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class b extends g13 implements SurfaceTexture.OnFrameAvailableListener, Camera.AutoFocusCallback, Camera.PreviewCallback {
    public static final String M = "b";
    public int A;
    public long B;
    public List<Camera.Area> C;
    public List<Camera.Area> E;
    public Matrix F;
    public byte[][] G;
    public int H;
    public int I;
    public long J;
    public long K;
    public long L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile lv4 f15807a;
    public CameraView.e d;
    public boolean e;
    public com.zenmen.palmchat.video.recorder.a f;
    public boolean g;
    public Camera h;
    public int j;
    public int k;
    public ok1 l;
    public xn6 m;
    public int n;
    public int o;
    public SurfaceTexture p;
    public Texture2dProgram r;
    public final o25 s;
    public final kh5 t;
    public int u;
    public int v;
    public int w;
    public float x;
    public float y;
    public ByteBuffer z;
    public Object b = new Object();
    public boolean c = false;
    public Camera.CameraInfo i = new Camera.CameraInfo();
    public float[] q = new float[16];

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("detail", "Error finishSurfaceSetup get IOException");
        }
    }

    public b(CameraView.e eVar, com.zenmen.palmchat.video.recorder.a aVar, boolean z, boolean z2) {
        this.g = false;
        o25 o25Var = new o25(Drawable2d.Prefab.RECTANGLE);
        this.s = o25Var;
        this.t = new kh5(o25Var);
        this.u = 0;
        this.v = 50;
        this.w = 0;
        this.z = null;
        this.C = null;
        this.E = null;
        this.F = null;
        this.G = new byte[3][];
        this.H = 0;
        this.I = 0;
        this.J = 0L;
        this.K = 0L;
        this.L = 0L;
        this.d = eVar;
        this.f = aVar;
        this.e = z;
        this.g = z2;
    }

    public static boolean j(String str, List<String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    public int a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public void b() {
        gc2.a("draw start");
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        this.t.a(this.r, this.q);
        com.zenmen.palmchat.video.recorder.a aVar = this.f;
        if (aVar != null) {
            if (aVar.t()) {
                this.f.y(this.A);
                this.f.l(this.p, this.q, this.t.b());
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.B > 100) {
                    this.B = jCurrentTimeMillis;
                    this.f.v(this.m, new Rect(0, 0, this.n, this.o));
                }
            }
        }
        this.m.k();
        gc2.a("draw done");
    }

    public void c() {
        int i = this.n;
        int i2 = this.o;
        String str = M;
        Log.i(str, "finishSurfaceSetup size=" + i + "x" + i2 + " camera=" + this.j + "x" + this.k);
        this.d.a(this.n, this.o);
        GLES20.glViewport(0, 0, i, i2);
        float f = (float) i;
        float f2 = (float) i2;
        android.opengl.Matrix.orthoM(this.q, 0, 0.0f, f, 0.0f, f2, -1.0f, 1.0f);
        this.x = f / 2.0f;
        this.y = f2 / 2.0f;
        x();
        Log.d(str, "starting camera preview");
        try {
            this.h.setPreviewTexture(this.p);
            this.h.startPreview();
            if (this.i.facing == 0) {
                i(null);
            }
        } catch (IOException e) {
            LogUtil.i(M, 3, new a(), e);
            throw new RuntimeException(e);
        }
    }

    public int d(int i) {
        if (i > 1000) {
            return 1000;
        }
        if (i < -1000) {
            return -1000;
        }
        return i;
    }

    public void e() {
        this.p.updateTexImage();
        b();
    }

    public Camera f() {
        return this.h;
    }

    public lv4 g() {
        return this.f15807a;
    }

    public final float h(int i, int i2) {
        float f;
        int i3;
        int i4;
        if (i == 0 || (i3 = this.n) == 0 || i2 == 0 || (i4 = this.o) == 0 || (i > i3 && i2 > i4)) {
            f = 1.0f;
        } else {
            float f2 = i;
            float f3 = i2;
            f = f2 / f3 > ((float) i3) / ((float) i4) ? i4 / f3 : i3 / f2;
        }
        LogUtil.i(M, "getPreviewScale" + f);
        return f;
    }

    public void i(Rect rect) {
        Camera camera = this.h;
        if (camera == null || this.g) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        if (this.C == null) {
            this.C = new ArrayList();
            this.E = new ArrayList();
        }
        if (this.F == null) {
            this.F = new Matrix();
        }
        if (rect == null) {
            if (parameters.getMaxNumFocusAreas() > 0 && j("auto", parameters.getSupportedFocusModes())) {
                this.C.clear();
                this.E.clear();
                Rect rect2 = new Rect(-200, -200, 200, 200);
                this.C.add(new Camera.Area(rect2, 1));
                this.E.add(new Camera.Area(rect2, 1));
                parameters.setFocusAreas(this.C);
            }
        } else if (parameters.getMaxNumFocusAreas() > 0 && j("auto", parameters.getSupportedFocusModes())) {
            int iWidth = rect.width();
            int iHeight = rect.height();
            int i = rect.left;
            int i2 = iWidth / 2;
            int iA = a(((int) ((i * r4) / this.n)) - i2, 0, this.j - i2);
            int i3 = iHeight / 2;
            RectF rectF = new RectF(iA, a(((int) ((rect.top * this.k) / this.o)) - i3, 0, this.k - i3), iA + iWidth, r3 + iHeight);
            l(this.F, false, this.i.orientation, this.j, this.k);
            Matrix matrix = this.F;
            matrix.invert(matrix);
            this.F.mapRect(rectF);
            Rect rect3 = new Rect();
            m(rectF, rect3);
            this.C.clear();
            this.E.clear();
            this.C.add(new Camera.Area(rect3, 1));
            this.E.add(new Camera.Area(rect3, 1));
            parameters.setFocusAreas(this.C);
        }
        if (parameters.getMaxNumMeteringAreas() > 0) {
            parameters.setMeteringAreas(this.E);
        }
        if (j("auto", parameters.getSupportedFocusModes())) {
            parameters.setFocusMode("auto");
            this.h.setParameters(parameters);
            this.h.autoFocus(this);
        }
    }

    public void k(int i, int i2, int i3) throws RuntimeException {
        String str;
        if (this.h != null) {
            Log.e(M, "error exception mCamera should be null");
            throw new RuntimeException("camera already initialized");
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 >= numberOfCameras) {
                break;
            }
            Camera.getCameraInfo(i5, this.i);
            if (this.i.facing == this.g) {
                this.h = Camera.open(i5);
                break;
            }
            i5++;
        }
        if (this.h == null) {
            Log.d(M, "No front-facing camera found; opening default");
            this.h = Camera.open();
        }
        Camera camera = this.h;
        if (camera == null) {
            Log.e(M, "error exception mCamera should not be null");
            throw new RuntimeException("Unable to open camera");
        }
        Camera.Parameters parameters = camera.getParameters();
        uy.a(parameters, i, i2);
        if (j("continuous-video", parameters.getSupportedFocusModes())) {
            parameters.setFocusMode("continuous-video");
        } else if (j("auto", parameters.getSupportedFocusModes())) {
            parameters.setFocusMode("auto");
        }
        this.h.setParameters(parameters);
        int[] iArr = new int[2];
        Camera.Size previewSize = parameters.getPreviewSize();
        parameters.getPreviewFpsRange(iArr);
        String str2 = previewSize.width + "x" + previewSize.height;
        if (iArr[0] == iArr[1]) {
            str = str2 + " @" + (((double) iArr[0]) / 1000.0d) + SharePluginInfo.ISSUE_FPS;
        } else {
            str = str2 + " @[" + (((double) iArr[0]) / 1000.0d) + " - " + (((double) iArr[1]) / 1000.0d) + "] fps";
        }
        Log.i(M, "Camera config: " + str);
        this.j = previewSize.width;
        this.k = previewSize.height;
        this.h.setPreviewCallbackWithBuffer(this);
        this.I = (((((this.j + 15) >> 4) << 4) * this.k) * ImageFormat.getBitsPerPixel(parameters.getPreviewFormat())) / 8;
        this.H = parameters.getPreviewFormat();
        while (true) {
            byte[][] bArr = this.G;
            if (i4 >= bArr.length) {
                return;
            }
            byte[] bArr2 = new byte[this.I];
            bArr[i4] = bArr2;
            this.h.addCallbackBuffer(bArr2);
            i4++;
        }
    }

    public void l(Matrix matrix, boolean z, int i, int i2, int i3) {
        matrix.setScale(z ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate(i);
        float f = i2;
        float f2 = i3;
        matrix.postScale(f / 2000.0f, f2 / 2000.0f);
        matrix.postTranslate(f / 2.0f, f2 / 2.0f);
    }

    public void m(RectF rectF, Rect rect) {
        rect.left = Math.round(rectF.left);
        rect.top = Math.round(rectF.top);
        rect.right = Math.round(rectF.right);
        rect.bottom = Math.round(rectF.bottom);
        rect.left = d(rect.left);
        rect.top = d(rect.top);
        rect.right = d(rect.right);
        rect.bottom = d(rect.bottom);
    }

    public final void n() {
        Camera camera = this.h;
        if (camera != null) {
            camera.stopPreview();
            this.h.release();
            this.h = null;
            Log.d(M, "releaseCamera -- done");
        }
    }

    public void o() {
        gc2.a("releaseGl start");
        xn6 xn6Var = this.m;
        if (xn6Var != null) {
            xn6Var.h();
            this.m = null;
        }
        Texture2dProgram texture2dProgram = this.r;
        if (texture2dProgram != null) {
            texture2dProgram.d();
            this.r = null;
        }
        gc2.a("releaseGl done");
        this.l.d();
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z, Camera camera) {
        Camera.Parameters parameters = this.h.getParameters();
        if (j("continuous-video", parameters.getSupportedFocusModes())) {
            parameters.setFocusMode("continuous-video");
            this.h.setParameters(parameters);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f15807a.b();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        this.J++;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.L == 0) {
            this.L = jCurrentTimeMillis;
        }
        if (jCurrentTimeMillis - this.L > 50) {
            Log.e(M, "onPreviewFrame call back is not smooth diff time is " + (jCurrentTimeMillis - this.L) + "model Id: " + Build.MODEL);
        }
        this.L = jCurrentTimeMillis;
        long j = this.K;
        if (j == 0) {
            this.K = jCurrentTimeMillis;
        } else if (jCurrentTimeMillis - j > 1000) {
            Log.e(M, "=====> frame rate is " + this.J);
            this.J = 0L;
            this.K = 0L;
        }
        this.h.addCallbackBuffer(bArr);
    }

    public void p(int i, int i2) {
        this.x = i;
        this.y = this.o - i2;
        x();
    }

    public void q(int i) {
        this.w = i;
        x();
    }

    public void r(int i) {
        this.v = i;
        x();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f15807a = new lv4(this);
        synchronized (this.b) {
            this.c = true;
            this.b.notify();
        }
        this.l = ok1.a();
        try {
            k(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, TECameraSettings.FPS_480, 30);
            try {
                Looper.loop();
                Log.d(M, "looper quit");
                n();
                o();
                this.l.e();
                synchronized (this.b) {
                    this.c = false;
                }
            } catch (Throwable th) {
                try {
                    Log.d(M, th.toString());
                    if (this.f != null) {
                        this.f.onOpenCameraFailed();
                    }
                    Log.d(M, "looper quit");
                    n();
                    o();
                    this.l.e();
                    synchronized (this.b) {
                        this.c = false;
                    }
                } catch (Throwable th2) {
                    Log.d(M, "looper quit");
                    n();
                    o();
                    this.l.e();
                    synchronized (this.b) {
                        this.c = false;
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            Log.d(M, th3.toString());
            if (this.f != null) {
                this.f.onOpenCameraFailed();
            }
            o();
            this.l.e();
        }
    }

    public void s(int i) {
        this.u = i;
        x();
    }

    public void t() {
        Log.d(M, "shutdown");
        Looper.myLooper().quit();
    }

    public void u(SurfaceHolder surfaceHolder, boolean z) {
        xn6 xn6VarA = xn6.a(this.l, surfaceHolder.getSurface(), surfaceHolder, false);
        this.m = xn6VarA;
        xn6VarA.g();
        Texture2dProgram texture2dProgram = new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT);
        this.r = texture2dProgram;
        this.A = texture2dProgram.a();
        this.p = new SurfaceTexture(this.A);
        this.t.g(this.A);
        if (!z) {
            this.n = this.m.e();
            this.o = this.m.d();
            c();
        }
        this.p.setOnFrameAvailableListener(this);
        com.zenmen.palmchat.video.recorder.a aVar = this.f;
        if (aVar == null || !aVar.t()) {
            return;
        }
        this.f.C(new a.c(this.l.c(), 1.0f));
    }

    public void v(int i, int i2) {
        Log.d(M, "RenderThread surfaceChanged " + i + "x" + i2);
        this.n = i;
        this.o = i2;
        c();
    }

    public void w() {
        Log.d(M, "RenderThread surfaceDestroyed");
        o();
    }

    public void x() {
        float f = 1.0f - (this.u / 100.0f);
        Camera.CameraInfo cameraInfo = this.i;
        int iRound = ((Math.round((this.w / 100.0f) * 360.0f) - (cameraInfo != null ? cameraInfo.orientation : 0)) + 360) % 360;
        float fH = (iRound == 90 || iRound == 270) ? h(this.k, this.j) : h(this.j, this.k);
        this.t.f(this.j * fH, this.k * fH);
        this.t.d(this.x, this.y);
        this.t.e(iRound);
        this.s.g(f);
    }

    public void y() {
        synchronized (this.b) {
            while (!this.c) {
                try {
                    this.b.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }
}
