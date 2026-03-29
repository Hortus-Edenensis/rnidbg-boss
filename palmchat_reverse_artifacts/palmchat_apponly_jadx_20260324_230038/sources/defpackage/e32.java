package defpackage;

import android.opengl.Matrix;
import com.google.android.exoplayer2.util.GlUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class e32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f17207a = new float[16];
    public final float[] b = new float[16];
    public final dy5<float[]> c = new dy5<>();
    public boolean d;

    public static void a(float[] fArr, float[] fArr2) {
        GlUtil.j(fArr);
        float f = fArr2[10];
        float f2 = fArr2[8];
        float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
        float f3 = fArr2[10];
        fArr[0] = f3 / fSqrt;
        float f4 = fArr2[8];
        fArr[2] = f4 / fSqrt;
        fArr[8] = (-f4) / fSqrt;
        fArr[10] = f3 / fSqrt;
    }

    public static void b(float[] fArr, float[] fArr2) {
        float f = fArr2[0];
        float f2 = -fArr2[1];
        float f3 = -fArr2[2];
        float length = Matrix.length(f, f2, f3);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr, 0, (float) Math.toDegrees(length), f / length, f2 / length, f3 / length);
        } else {
            GlUtil.j(fArr);
        }
    }

    public boolean c(float[] fArr, long j) {
        float[] fArrJ = this.c.j(j);
        if (fArrJ == null) {
            return false;
        }
        b(this.b, fArrJ);
        if (!this.d) {
            a(this.f17207a, this.b);
            this.d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f17207a, 0, this.b, 0);
        return true;
    }

    public void d() {
        this.c.c();
        this.d = false;
    }

    public void e(long j, float[] fArr) {
        this.c.a(j, fArr);
    }
}
