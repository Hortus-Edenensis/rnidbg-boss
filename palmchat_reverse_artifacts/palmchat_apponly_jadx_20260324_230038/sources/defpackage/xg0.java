package defpackage;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.f;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class xg0 implements f {
    public static final xg0 f = new xg0(1, 2, 3, null);
    public static final xg0 g = new b().c(1).b(1).d(2).a();
    public static final String h = g86.w0(0);
    public static final String i = g86.w0(1);
    public static final String j = g86.w0(2);
    public static final String k = g86.w0(3);
    public static final f.a<xg0> l = new f.a() { // from class: wg0
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return xg0.j(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21949a;
    public final int b;
    public final int c;

    @Nullable
    public final byte[] d;
    public int e;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21950a;
        public int b;
        public int c;

        @Nullable
        public byte[] d;

        public xg0 a() {
            return new xg0(this.f21950a, this.b, this.c, this.d);
        }

        public b b(int i) {
            this.b = i;
            return this;
        }

        public b c(int i) {
            this.f21950a = i;
            return this;
        }

        public b d(int i) {
            this.c = i;
            return this;
        }

        public b() {
            this.f21950a = -1;
            this.b = -1;
            this.c = -1;
        }

        public b(xg0 xg0Var) {
            this.f21950a = xg0Var.f21949a;
            this.b = xg0Var.b;
            this.c = xg0Var.c;
            this.d = xg0Var.d;
        }
    }

    @Deprecated
    public xg0(int i2, int i3, int i4, @Nullable byte[] bArr) {
        this.f21949a = i2;
        this.b = i3;
        this.c = i4;
        this.d = bArr;
    }

    public static String c(int i2) {
        return i2 != -1 ? i2 != 1 ? i2 != 2 ? "Undefined color range" : "Limited range" : "Full range" : "Unset color range";
    }

    public static String d(int i2) {
        return i2 != -1 ? i2 != 6 ? i2 != 1 ? i2 != 2 ? "Undefined color space" : "BT601" : "BT709" : "BT2020" : "Unset color space";
    }

    public static String e(int i2) {
        return i2 != -1 ? i2 != 10 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 6 ? i2 != 7 ? "Undefined color transfer" : "HLG" : "ST2084 PQ" : "SDR SMPTE 170M" : "sRGB" : "Linear" : "Gamma 2.2" : "Unset color transfer";
    }

    public static boolean f(@Nullable xg0 xg0Var) {
        int i2;
        return xg0Var != null && ((i2 = xg0Var.c) == 7 || i2 == 6);
    }

    public static int h(int i2) {
        if (i2 == 1) {
            return 1;
        }
        if (i2 != 9) {
            return (i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int i(int i2) {
        if (i2 == 1) {
            return 3;
        }
        if (i2 == 4) {
            return 10;
        }
        if (i2 == 13) {
            return 2;
        }
        if (i2 == 16) {
            return 6;
        }
        if (i2 != 18) {
            return (i2 == 6 || i2 == 7) ? 3 : -1;
        }
        return 7;
    }

    public static /* synthetic */ xg0 j(Bundle bundle) {
        return new xg0(bundle.getInt(h, -1), bundle.getInt(i, -1), bundle.getInt(j, -1), bundle.getByteArray(k));
    }

    public b b() {
        return new b();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || xg0.class != obj.getClass()) {
            return false;
        }
        xg0 xg0Var = (xg0) obj;
        return this.f21949a == xg0Var.f21949a && this.b == xg0Var.b && this.c == xg0Var.c && Arrays.equals(this.d, xg0Var.d);
    }

    public boolean g() {
        return (this.f21949a == -1 || this.b == -1 || this.c == -1) ? false : true;
    }

    public int hashCode() {
        if (this.e == 0) {
            this.e = ((((((527 + this.f21949a) * 31) + this.b) * 31) + this.c) * 31) + Arrays.hashCode(this.d);
        }
        return this.e;
    }

    public String k() {
        return !g() ? "NA" : g86.C("%s/%s/%s", d(this.f21949a), c(this.b), e(this.c));
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(h, this.f21949a);
        bundle.putInt(i, this.b);
        bundle.putInt(j, this.c);
        bundle.putByteArray(k, this.d);
        return bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(d(this.f21949a));
        sb.append(", ");
        sb.append(c(this.b));
        sb.append(", ");
        sb.append(e(this.c));
        sb.append(", ");
        sb.append(this.d != null);
        sb.append(")");
        return sb.toString();
    }
}
