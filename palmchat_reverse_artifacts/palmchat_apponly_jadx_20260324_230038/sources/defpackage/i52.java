package defpackage;

import android.opengl.GLES20;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class i52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f18102a;
    public float b;
    public float c;
    public float d;
    public final int e = 2;
    public float[] f = new float[12];
    public float[] g = new float[12];
    public short[] h = new short[6];
    public final String i = "GLRectangeVertex";
    public ShortBuffer j = null;
    public FloatBuffer k = null;
    public FloatBuffer l = null;
    public d75 m;

    public i52(float f, float f2, float f3, float f4, d75 d75Var) {
        this.f18102a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.m = d75Var;
        a();
    }

    public final void a() {
        float[] fArr = this.f;
        float f = this.f18102a;
        fArr[0] = f;
        float f2 = this.b;
        fArr[1] = f2;
        fArr[2] = 0.0f;
        float f3 = this.c;
        fArr[3] = f + f3;
        fArr[4] = f2;
        fArr[5] = 0.0f;
        fArr[6] = f3 + f;
        float f4 = this.d;
        fArr[7] = f2 - f4;
        fArr[8] = 0.0f;
        fArr[9] = f;
        fArr[10] = f2 - f4;
        fArr[11] = 0.0f;
        short[] sArr = this.h;
        sArr[0] = 0;
        sArr[1] = 1;
        sArr[2] = 2;
        sArr[3] = 0;
        sArr[4] = 2;
        sArr[5] = 3;
        d();
    }

    public final void b(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        Log.e("GLRectangeVertex", str + ": glError " + iGlGetError);
        throw new RuntimeException(str + ": glError " + iGlGetError);
    }

    public void c(int i, int i2) {
        GLES20.glVertexAttribPointer(i, 3, 5126, false, 12, (Buffer) this.k);
        b("drawCircle");
        GLES20.glEnableVertexAttribArray(i);
        b("drawCircle");
        GLES20.glVertexAttribPointer(i2, 3, 5126, false, 12, (Buffer) this.l);
        b("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(i2);
        GLES20.glDrawElements(4, 6, 5123, this.j);
    }

    public final void d() {
        for (int i = 0; i < 4; i++) {
            int i2 = i * 3;
            this.g[i2] = this.m.a(this.f[i2]);
            int i3 = i2 + 1;
            this.g[i3] = this.m.b(this.f[i3]);
        }
        FloatBuffer floatBuffer = this.k;
        if (floatBuffer != null) {
            floatBuffer.clear();
        } else {
            FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(this.f.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.k = floatBufferAsFloatBuffer;
            floatBufferAsFloatBuffer.put(this.f);
            this.k.position(0);
        }
        FloatBuffer floatBuffer2 = this.l;
        if (floatBuffer2 != null) {
            floatBuffer2.clear();
        } else {
            FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(this.g.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.l = floatBufferAsFloatBuffer2;
            floatBufferAsFloatBuffer2.put(this.g);
            this.l.position(0);
        }
        ShortBuffer shortBuffer = this.j;
        if (shortBuffer != null) {
            shortBuffer.clear();
        } else {
            this.j = ByteBuffer.allocateDirect(this.h.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        }
        this.j.put(this.h).position(0);
    }
}
