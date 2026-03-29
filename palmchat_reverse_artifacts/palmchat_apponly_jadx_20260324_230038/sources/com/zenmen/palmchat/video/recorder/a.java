package com.zenmen.palmchat.video.recorder;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import android.view.SurfaceHolder;
import androidx.media3.muxer.MuxerUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.video.recorder.gles.Drawable2d;
import com.zenmen.palmchat.video.recorder.gles.Texture2dProgram;
import defpackage.g13;
import defpackage.ok1;
import defpackage.qm4;
import defpackage.tj1;
import defpackage.x96;
import defpackage.xn6;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a implements qm4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xn6 f15802a;
    public ok1 b;
    public com.zenmen.palmchat.video.recorder.gles.a c;
    public tj1 d;
    public SurfaceHolder e;
    public ByteBuffer f;
    public int g;
    public Rect h = new Rect(0, 0, 0, 0);
    public AtomicBoolean i = new AtomicBoolean(false);
    public AtomicBoolean j = new AtomicBoolean(false);
    public Thread k;
    public d l;
    public qm4 m;

    /* JADX INFO: renamed from: com.zenmen.palmchat.video.recorder.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class RunnableC1127a implements Runnable {
        public RunnableC1127a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            a.this.l = new d();
            a.this.i.set(true);
            Looper.loop();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("detail", "handleUpdateSharedContext is null");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final tj1 f15805a;
        public final float b;

        public c(tj1 tj1Var, float f) {
            this.f15805a = tj1Var;
            this.b = f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            switch (i) {
                case 1:
                    a.this.m((Pair) obj, (((long) message.arg1) << 32) | (((long) message.arg2) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                    return;
                case 2:
                    a.this.p(message.arg1);
                    return;
                case 3:
                    c cVar = (c) obj;
                    a.this.r(cVar.f15805a, cVar.b);
                    return;
                case 4:
                    a.this.s((SurfaceHolder) obj);
                    return;
                case 5:
                    a.this.o((Rect) obj);
                    return;
                case 6:
                    a.this.q(((Float) obj).floatValue());
                    return;
                case 7:
                    a.this.n(message.arg1, message.arg2);
                    return;
                case 8:
                    a.this.u();
                    Looper.myLooper().quit();
                    return;
                default:
                    throw new RuntimeException("Unhandled msg what=" + i);
            }
        }

        public d() {
        }
    }

    public void A() {
        if (this.i.get()) {
            this.l.removeMessages(1);
            d dVar = this.l;
            dVar.sendMessageAtFrontOfQueue(dVar.obtainMessage(8));
        }
    }

    public void B(SurfaceHolder surfaceHolder) {
        if (this.i.get()) {
            d dVar = this.l;
            dVar.sendMessage(dVar.obtainMessage(4, surfaceHolder));
        }
    }

    public void C(c cVar) {
        if (this.i.get()) {
            d dVar = this.l;
            dVar.sendMessage(dVar.obtainMessage(3, cVar));
        }
    }

    public void D() {
        A();
        try {
            this.k.join();
            this.k = null;
            this.l = null;
            this.i.set(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public final void k() {
        ok1 ok1VarB = ok1.b(this.d, 1);
        this.b = ok1VarB;
        xn6 xn6VarA = xn6.a(ok1VarB, this.e.getSurface(), this.e, false);
        this.f15802a = xn6VarA;
        xn6VarA.g();
        com.zenmen.palmchat.video.recorder.gles.a aVar = new com.zenmen.palmchat.video.recorder.gles.a(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT), Drawable2d.Prefab.RECTANGLE);
        this.c = aVar;
        aVar.c(1.0f);
    }

    public void l(SurfaceTexture surfaceTexture, float[] fArr, float[] fArr2) {
        if (this.i.get()) {
            long timestamp = surfaceTexture.getTimestamp();
            if (timestamp == 0) {
                Log.w("FrameProvider", "HEY: got SurfaceTexture with timestamp of zero");
            } else if (this.j.get()) {
                this.l.removeMessages(1);
            } else {
                d dVar = this.l;
                dVar.sendMessage(dVar.obtainMessage(1, (int) (timestamp >> 32), (int) timestamp, new Pair(fArr, fArr2)));
            }
        }
    }

    public final void m(Pair<float[], float[]> pair, long j) {
        int iWidth;
        int iHeight;
        if (this.c == null) {
            return;
        }
        this.j.set(true);
        this.c.a(this.g, (float[]) pair.first, (float[]) pair.second);
        System.currentTimeMillis();
        Rect surfaceFrame = this.e.getSurfaceFrame();
        Rect rect = this.h;
        if (rect != null) {
            int i = rect.right - rect.left;
            int i2 = rect.bottom - rect.top;
            iWidth = ((i + 15) >> 4) << 4;
            iHeight = ((i2 + 15) >> 4) << 4;
            if (iWidth == 0 || iHeight == 0) {
                iWidth = surfaceFrame.width();
                iHeight = surfaceFrame.height();
                this.h.set(0, 0, iWidth, iHeight);
            }
        } else {
            iWidth = surfaceFrame.width();
            iHeight = surfaceFrame.height();
        }
        int i3 = iWidth * iHeight * 4;
        ByteBuffer byteBuffer = this.f;
        if (byteBuffer == null || byteBuffer.capacity() != i3) {
            Log.d("FrameProvider", "alloc direct:" + i3);
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i3);
            this.f = byteBufferAllocateDirect;
            byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        }
        Rect rect2 = this.h;
        if (rect2 != null) {
            this.f15802a.c(this.f, rect2);
        } else {
            this.f15802a.c(this.f, null);
        }
        qm4 qm4Var = this.m;
        if (qm4Var != null) {
            qm4Var.onPreviewFrame(this.f.array(), iWidth, iHeight);
        }
        this.f.clear();
        this.j.set(false);
    }

    public final void n(int i, int i2) {
        qm4 qm4Var = this.m;
        if (qm4Var != null) {
            qm4Var.onPreviewFrame(this.f.array(), i, i2);
        }
        this.f.clear();
        this.j.set(false);
    }

    public final void o(Rect rect) {
        this.h = rect;
    }

    @Override // defpackage.qm4
    public void onOpenCameraFailed() {
        qm4 qm4Var = this.m;
        if (qm4Var != null) {
            qm4Var.onOpenCameraFailed();
        }
    }

    @Override // defpackage.qm4
    public void onPreviewFrame(byte[] bArr, int i, int i2) {
        qm4 qm4Var = this.m;
        if (qm4Var != null) {
            qm4Var.onPreviewFrame(bArr, i, i2);
        }
    }

    public final void p(int i) {
        this.g = i;
    }

    public final void q(float f) {
        com.zenmen.palmchat.video.recorder.gles.a aVar = this.c;
        if (aVar != null) {
            aVar.c(f);
        }
    }

    public final void r(tj1 tj1Var, float f) {
        this.d = tj1Var;
        if (tj1Var == null) {
            LogUtil.i("FrameProvider", 3, new b(), (Throwable) null);
        }
        SurfaceHolder surfaceHolder = this.e;
        if (surfaceHolder == null || this.b != null || surfaceHolder.getSurface() == null || !this.e.getSurface().isValid()) {
            return;
        }
        k();
    }

    public final void s(SurfaceHolder surfaceHolder) {
        this.e = surfaceHolder;
        if (this.d == null || surfaceHolder == null || this.b != null || surfaceHolder.getSurface() == null || !this.e.getSurface().isValid()) {
            return;
        }
        k();
    }

    public boolean t() {
        return x96.b();
    }

    public final void u() {
        if (this.d != null) {
            this.d = null;
        }
        if (this.e != null) {
            this.e = null;
        }
        xn6 xn6Var = this.f15802a;
        if (xn6Var != null) {
            xn6Var.h();
            this.f15802a = null;
        }
        com.zenmen.palmchat.video.recorder.gles.a aVar = this.c;
        if (aVar != null) {
            aVar.b(false);
            this.c = null;
        }
        ok1 ok1Var = this.b;
        if (ok1Var != null) {
            ok1Var.e();
            this.b = null;
        }
    }

    public void v(xn6 xn6Var, Rect rect) {
        int iWidth;
        int iHeight;
        if (this.j.get()) {
            return;
        }
        this.j.set(true);
        Rect rect2 = this.h;
        if (rect2 != null) {
            int i = rect2.right - rect2.left;
            int i2 = rect2.bottom - rect2.top;
            iWidth = ((i + 15) >> 4) << 4;
            iHeight = ((i2 + 15) >> 4) << 4;
            if (iWidth == 0 || iHeight == 0) {
                iWidth = rect.width();
                iHeight = rect.height();
                this.h.set(0, 0, iWidth, iHeight);
            }
        } else {
            iWidth = rect.width();
            iHeight = rect.height();
        }
        Log.d("FrameProvider", "###bitmap map sWidth = " + iWidth + "  sHeight = " + iHeight);
        int i3 = iWidth * iHeight * 4;
        ByteBuffer byteBuffer = this.f;
        if (byteBuffer == null || byteBuffer.capacity() != i3) {
            Log.d("FrameProvider", "alloc direct:" + i3);
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i3);
            this.f = byteBufferAllocateDirect;
            byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        }
        Rect rect3 = this.h;
        if (rect3 != null) {
            xn6Var.c(this.f, rect3);
        } else {
            xn6Var.c(this.f, null);
        }
        d dVar = this.l;
        dVar.sendMessage(dVar.obtainMessage(7, iWidth, iHeight));
    }

    public void w(qm4 qm4Var) {
        this.m = qm4Var;
    }

    public void x(Rect rect) {
        if (this.i.get()) {
            d dVar = this.l;
            dVar.sendMessage(dVar.obtainMessage(5, rect));
        }
    }

    public void y(int i) {
        if (this.i.get()) {
            d dVar = this.l;
            dVar.sendMessage(dVar.obtainMessage(2, i, 0, null));
        }
    }

    public void z() {
        if (this.i.get()) {
            return;
        }
        g13 g13Var = new g13(new RunnableC1127a());
        this.k = g13Var;
        g13Var.start();
    }
}
