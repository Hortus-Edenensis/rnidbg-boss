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
public class j52 {
    public float[] c;
    public d75 i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18331a = "GLRectangeVertex";
    public final int b = 1;
    public float[] d = new float[9];
    public short[] e = new short[3];
    public ShortBuffer f = null;
    public FloatBuffer g = null;
    public FloatBuffer h = null;

    public j52(float[] fArr, d75 d75Var) {
        float[] fArr2 = new float[9];
        this.c = fArr2;
        System.arraycopy(fArr, 0, fArr2, 0, 9);
        short[] sArr = this.e;
        sArr[0] = 0;
        sArr[1] = 1;
        sArr[2] = 2;
        this.i = d75Var;
        c();
    }

    public final void a(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        Log.e("GLRectangeVertex", str + ": glError " + iGlGetError);
        throw new RuntimeException(str + ": glError " + iGlGetError);
    }

    public void b(int i, int i2) {
        GLES20.glVertexAttribPointer(i, 3, 5126, false, 12, (Buffer) this.g);
        a("drawCircle");
        GLES20.glEnableVertexAttribArray(i);
        a("drawCircle");
        GLES20.glVertexAttribPointer(i2, 3, 5126, false, 12, (Buffer) this.h);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(i2);
        GLES20.glDrawElements(4, 3, 5123, this.f);
    }

    public final void c() {
        for (int i = 0; i < 3; i++) {
            int i2 = i * 3;
            this.d[i2] = this.i.a(this.c[i2]);
            int i3 = i2 + 1;
            this.d[i3] = this.i.b(this.c[i3]);
        }
        FloatBuffer floatBuffer = this.g;
        if (floatBuffer != null) {
            floatBuffer.clear();
        } else {
            FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(this.c.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.g = floatBufferAsFloatBuffer;
            floatBufferAsFloatBuffer.put(this.c);
            this.g.position(0);
        }
        FloatBuffer floatBuffer2 = this.h;
        if (floatBuffer2 != null) {
            floatBuffer2.clear();
        } else {
            FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(this.d.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.h = floatBufferAsFloatBuffer2;
            floatBufferAsFloatBuffer2.put(this.d);
            this.h.position(0);
        }
        ShortBuffer shortBuffer = this.f;
        if (shortBuffer != null) {
            shortBuffer.clear();
        } else {
            this.f = ByteBuffer.allocateDirect(this.e.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        }
        this.f.put(this.e).position(0);
    }
}
