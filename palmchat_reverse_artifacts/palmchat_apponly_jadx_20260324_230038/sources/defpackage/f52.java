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
public class f52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f17458a;
    public float b;
    public float c;
    public d75 i;
    public final int d = 6;
    public float[] e = new float[24];
    public float[] f = new float[24];
    public short[] g = new short[18];
    public final String h = "GLCircleVertex";
    public ShortBuffer j = null;
    public FloatBuffer k = null;
    public FloatBuffer l = null;

    public f52(float f, float f2, float f3, d75 d75Var) {
        this.b = f;
        this.c = f2;
        this.f17458a = f3;
        this.i = d75Var;
        a();
    }

    public final void a() {
        float[] fArr = this.e;
        fArr[0] = this.b;
        fArr[1] = this.c;
        fArr[2] = 0.0f;
        float f = 1.5707964f;
        for (int i = 1; i < 8; i++) {
            double d = f;
            float fCos = ((float) Math.cos(d)) < 0.0f ? 0.0f : (float) Math.cos(d);
            float[] fArr2 = this.e;
            int i2 = i * 3;
            fArr2[i2] = this.b + (fCos * this.f17458a);
            fArr2[i2 + 1] = this.c + (((float) Math.sin(d)) * this.f17458a);
            this.e[i2 + 2] = 0.0f;
            f -= 0.2617994f;
        }
        short[] sArr = this.g;
        sArr[0] = 0;
        sArr[1] = 1;
        sArr[2] = 2;
        sArr[3] = 0;
        sArr[4] = 2;
        sArr[5] = 3;
        sArr[6] = 0;
        sArr[7] = 3;
        sArr[8] = 4;
        sArr[9] = 0;
        sArr[10] = 4;
        sArr[11] = 5;
        sArr[12] = 0;
        sArr[13] = 5;
        sArr[14] = 6;
        sArr[15] = 0;
        sArr[16] = 6;
        sArr[17] = 7;
        f();
    }

    public final void b(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        Log.e("GLCircleVertex", str + ": glError " + iGlGetError);
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
        GLES20.glDrawElements(4, 18, 5123, this.j);
    }

    public void d() {
        for (int i = 0; i < 8; i++) {
            float[] fArr = this.e;
            int i2 = i * 3;
            fArr[i2] = (this.b * 2.0f) - fArr[i2];
        }
        f();
    }

    public void e() {
        for (int i = 0; i < 8; i++) {
            float[] fArr = this.e;
            int i2 = (i * 3) + 1;
            fArr[i2] = (this.c * 2.0f) - fArr[i2];
        }
        f();
    }

    public final void f() {
        for (int i = 0; i < 8; i++) {
            int i2 = i * 3;
            this.f[i2] = this.i.a(this.e[i2]);
            int i3 = i2 + 1;
            this.f[i3] = this.i.a(this.e[i3]);
        }
        FloatBuffer floatBuffer = this.k;
        if (floatBuffer != null) {
            floatBuffer.clear();
        } else {
            this.k = ByteBuffer.allocateDirect(this.e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.k.put(this.e);
        this.k.position(0);
        FloatBuffer floatBuffer2 = this.l;
        if (floatBuffer2 != null) {
            floatBuffer2.clear();
        } else {
            this.l = ByteBuffer.allocateDirect(this.f.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.l.put(this.f);
        this.l.position(0);
        ShortBuffer shortBuffer = this.j;
        if (shortBuffer != null) {
            shortBuffer.clear();
        } else {
            this.j = ByteBuffer.allocateDirect(this.g.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        }
        this.j.put(this.g).position(0);
    }
}
