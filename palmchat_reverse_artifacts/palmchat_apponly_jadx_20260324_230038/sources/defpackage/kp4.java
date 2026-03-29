package defpackage;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class kp4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Mode f18804a;
    public ErrorCorrectionLevel b;
    public t96 c;
    public int d = -1;
    public tv e;

    public static boolean b(int i) {
        return i >= 0 && i < 8;
    }

    public tv a() {
        return this.e;
    }

    public void c(ErrorCorrectionLevel errorCorrectionLevel) {
        this.b = errorCorrectionLevel;
    }

    public void d(int i) {
        this.d = i;
    }

    public void e(tv tvVar) {
        this.e = tvVar;
    }

    public void f(Mode mode) {
        this.f18804a = mode;
    }

    public void g(t96 t96Var) {
        this.c = t96Var;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f18804a);
        sb.append("\n ecLevel: ");
        sb.append(this.b);
        sb.append("\n version: ");
        sb.append(this.c);
        sb.append("\n maskPattern: ");
        sb.append(this.d);
        if (this.e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.e);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}
