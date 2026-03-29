package defpackage;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.util.GlUtil;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class w25 implements yb6, ry {
    public int i;
    public SurfaceTexture j;

    @Nullable
    public byte[] m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f21592a = new AtomicBoolean();
    public final AtomicBoolean b = new AtomicBoolean(true);
    public final lo4 c = new lo4();
    public final e32 d = new e32();
    public final dy5<Long> e = new dy5<>();
    public final dy5<jo4> f = new dy5<>();
    public final float[] g = new float[16];
    public final float[] h = new float[16];
    public volatile int k = 0;
    public int l = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(SurfaceTexture surfaceTexture) {
        this.f21592a.set(true);
    }

    @Override // defpackage.yb6
    public void a(long j, long j2, m mVar, @Nullable MediaFormat mediaFormat) {
        this.e.a(j2, Long.valueOf(j));
        g(mVar.v, mVar.w, j2);
    }

    public void c(float[] fArr, boolean z) {
        GLES20.glClear(16384);
        try {
            GlUtil.b();
        } catch (GlUtil.GlException e) {
            y53.d("SceneRenderer", "Failed to draw a frame", e);
        }
        if (this.f21592a.compareAndSet(true, false)) {
            ((SurfaceTexture) vh.e(this.j)).updateTexImage();
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e2) {
                y53.d("SceneRenderer", "Failed to draw a frame", e2);
            }
            if (this.b.compareAndSet(true, false)) {
                GlUtil.j(this.g);
            }
            long timestamp = this.j.getTimestamp();
            Long lG = this.e.g(timestamp);
            if (lG != null) {
                this.d.c(this.g, lG.longValue());
            }
            jo4 jo4VarJ = this.f.j(timestamp);
            if (jo4VarJ != null) {
                this.c.d(jo4VarJ);
            }
        }
        Matrix.multiplyMM(this.h, 0, fArr, 0, this.g, 0);
        this.c.a(this.i, this.h, z);
    }

    public SurfaceTexture d() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            GlUtil.b();
            this.c.b();
            GlUtil.b();
            this.i = GlUtil.f();
        } catch (GlUtil.GlException e) {
            y53.d("SceneRenderer", "Failed to initialize the renderer", e);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.i);
        this.j = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: v25
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                this.f21340a.e(surfaceTexture2);
            }
        });
        return this.j;
    }

    public void f(int i) {
        this.k = i;
    }

    public final void g(@Nullable byte[] bArr, int i, long j) {
        byte[] bArr2 = this.m;
        int i2 = this.l;
        this.m = bArr;
        if (i == -1) {
            i = this.k;
        }
        this.l = i;
        if (i2 == i && Arrays.equals(bArr2, this.m)) {
            return;
        }
        byte[] bArr3 = this.m;
        jo4 jo4VarA = bArr3 != null ? ko4.a(bArr3, this.l) : null;
        if (jo4VarA == null || !lo4.c(jo4VarA)) {
            jo4VarA = jo4.b(this.l);
        }
        this.f.a(j, jo4VarA);
    }

    @Override // defpackage.ry
    public void onCameraMotion(long j, float[] fArr) {
        this.d.e(j, fArr);
    }

    @Override // defpackage.ry
    public void onCameraMotionReset() {
        this.e.c();
        this.d.d();
        this.b.set(true);
    }
}
