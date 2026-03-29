package defpackage;

import android.opengl.Matrix;
import com.zenmen.palmchat.video.recorder.gles.Drawable2d;
import com.zenmen.palmchat.video.recorder.gles.Texture2dProgram;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class kh5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable2d f18690a;
    public float[] b;
    public int c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float[] i;
    public boolean j;
    public float[] k = new float[16];

    public kh5(Drawable2d drawable2d) {
        this.f18690a = drawable2d;
        float[] fArr = new float[4];
        this.b = fArr;
        fArr[3] = 1.0f;
        this.c = -1;
        this.i = new float[16];
        this.j = false;
    }

    public void a(Texture2dProgram texture2dProgram, float[] fArr) {
        Matrix.multiplyMM(this.k, 0, fArr, 0, b(), 0);
        texture2dProgram.b(this.k, this.f18690a.d(), 0, this.f18690a.e(), this.f18690a.a(), this.f18690a.f(), gc2.f17699a, this.f18690a.b(), this.c, this.f18690a.c());
    }

    public float[] b() {
        if (!this.j) {
            c();
        }
        return this.i;
    }

    public final void c() {
        float[] fArr = this.i;
        Matrix.setIdentityM(fArr, 0);
        Matrix.translateM(fArr, 0, this.g, this.h, 0.0f);
        float f = this.d;
        if (f != 0.0f) {
            Matrix.rotateM(fArr, 0, f, 0.0f, 0.0f, 1.0f);
        }
        Matrix.scaleM(fArr, 0, this.e, this.f, 1.0f);
        this.j = true;
    }

    public void d(float f, float f2) {
        this.g = f;
        this.h = f2;
        this.j = false;
    }

    public void e(float f) {
        while (f >= 360.0f) {
            f -= 360.0f;
        }
        while (f <= -360.0f) {
            f += 360.0f;
        }
        this.d = f;
        this.j = false;
    }

    public void f(float f, float f2) {
        this.e = f;
        this.f = f2;
        this.j = false;
    }

    public void g(int i) {
        this.c = i;
    }

    public String toString() {
        return "[Sprite2d pos=" + this.g + "," + this.h + " scale=" + this.e + "," + this.f + " angle=" + this.d + " color={" + this.b[0] + "," + this.b[1] + "," + this.b[2] + "} drawable=" + this.f18690a + "]";
    }
}
