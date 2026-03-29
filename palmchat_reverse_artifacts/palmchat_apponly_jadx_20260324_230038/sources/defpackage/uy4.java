package defpackage;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class uy4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f21326a;
    public int b;

    public uy4(Bitmap bitmap, int i) {
        this.f21326a = bitmap;
        this.b = i % 360;
    }

    public Bitmap a() {
        return this.f21326a;
    }

    public int b() {
        if (this.f21326a == null) {
            return 0;
        }
        return f() ? this.f21326a.getWidth() : this.f21326a.getHeight();
    }

    public Matrix c() {
        Matrix matrix = new Matrix();
        if (this.f21326a != null && this.b != 0) {
            matrix.preTranslate(-(r1.getWidth() / 2), -(this.f21326a.getHeight() / 2));
            matrix.postRotate(this.b);
            matrix.postTranslate(e() / 2, b() / 2);
        }
        return matrix;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        if (this.f21326a == null) {
            return 0;
        }
        return f() ? this.f21326a.getHeight() : this.f21326a.getWidth();
    }

    public boolean f() {
        return (this.b / 90) % 2 != 0;
    }

    public void g() {
        Bitmap bitmap = this.f21326a;
        if (bitmap != null) {
            bitmap.recycle();
            this.f21326a = null;
        }
    }

    public void h(Bitmap bitmap) {
        this.f21326a = bitmap;
    }

    public void i(int i) {
        this.b = i;
    }
}
