package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class sx4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f20869a;
    public final float b;

    public sx4(float f, float f2) {
        this.f20869a = f;
        this.b = f2;
    }

    public static float a(sx4 sx4Var, sx4 sx4Var2, sx4 sx4Var3) {
        float f = sx4Var2.f20869a;
        float f2 = sx4Var2.b;
        return ((sx4Var3.f20869a - f) * (sx4Var.b - f2)) - ((sx4Var3.b - f2) * (sx4Var.f20869a - f));
    }

    public static float b(sx4 sx4Var, sx4 sx4Var2) {
        return ae3.a(sx4Var.f20869a, sx4Var.b, sx4Var2.f20869a, sx4Var2.b);
    }

    public static void e(sx4[] sx4VarArr) {
        sx4 sx4Var;
        sx4 sx4Var2;
        sx4 sx4Var3;
        float fB = b(sx4VarArr[0], sx4VarArr[1]);
        float fB2 = b(sx4VarArr[1], sx4VarArr[2]);
        float fB3 = b(sx4VarArr[0], sx4VarArr[2]);
        if (fB2 >= fB && fB2 >= fB3) {
            sx4Var = sx4VarArr[0];
            sx4Var2 = sx4VarArr[1];
            sx4Var3 = sx4VarArr[2];
        } else if (fB3 < fB2 || fB3 < fB) {
            sx4Var = sx4VarArr[2];
            sx4Var2 = sx4VarArr[0];
            sx4Var3 = sx4VarArr[1];
        } else {
            sx4Var = sx4VarArr[1];
            sx4Var2 = sx4VarArr[0];
            sx4Var3 = sx4VarArr[2];
        }
        if (a(sx4Var2, sx4Var, sx4Var3) < 0.0f) {
            sx4 sx4Var4 = sx4Var3;
            sx4Var3 = sx4Var2;
            sx4Var2 = sx4Var4;
        }
        sx4VarArr[0] = sx4Var2;
        sx4VarArr[1] = sx4Var;
        sx4VarArr[2] = sx4Var3;
    }

    public final float c() {
        return this.f20869a;
    }

    public final float d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof sx4) {
            sx4 sx4Var = (sx4) obj;
            if (this.f20869a == sx4Var.f20869a && this.b == sx4Var.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f20869a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(25);
        sb.append('(');
        sb.append(this.f20869a);
        sb.append(',');
        sb.append(this.b);
        sb.append(')');
        return sb.toString();
    }
}
