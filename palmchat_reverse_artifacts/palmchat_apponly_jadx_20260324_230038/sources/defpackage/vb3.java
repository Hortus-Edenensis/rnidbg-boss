package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.l54;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class vb3 extends l54.a {
    public static l54<vb3> e;
    public static final Parcelable.Creator<vb3> f;
    public float c;
    public float d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Parcelable.Creator<vb3> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public vb3 createFromParcel(Parcel parcel) {
            vb3 vb3Var = new vb3(0.0f, 0.0f);
            vb3Var.e(parcel);
            return vb3Var;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public vb3[] newArray(int i) {
            return new vb3[i];
        }
    }

    static {
        l54<vb3> l54VarA = l54.a(32, new vb3(0.0f, 0.0f));
        e = l54VarA;
        l54VarA.g(0.5f);
        f = new a();
    }

    public vb3() {
    }

    public static vb3 b() {
        return (vb3) e.b();
    }

    public static vb3 c(float f2, float f3) {
        vb3 vb3Var = (vb3) e.b();
        vb3Var.c = f2;
        vb3Var.d = f3;
        return vb3Var;
    }

    public static vb3 d(vb3 vb3Var) {
        vb3 vb3Var2 = (vb3) e.b();
        vb3Var2.c = vb3Var.c;
        vb3Var2.d = vb3Var.d;
        return vb3Var2;
    }

    public static void f(vb3 vb3Var) {
        e.c(vb3Var);
    }

    @Override // l54.a
    public l54.a a() {
        return new vb3(0.0f, 0.0f);
    }

    public void e(Parcel parcel) {
        this.c = parcel.readFloat();
        this.d = parcel.readFloat();
    }

    public vb3(float f2, float f3) {
        this.c = f2;
        this.d = f3;
    }
}
