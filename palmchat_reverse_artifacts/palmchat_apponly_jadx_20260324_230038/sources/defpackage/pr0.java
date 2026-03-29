package defpackage;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class pr0 implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final CharSequence f20082a;

    @Nullable
    public final Layout.Alignment b;

    @Nullable
    public final Layout.Alignment c;

    @Nullable
    public final Bitmap d;
    public final float e;
    public final int f;
    public final int g;
    public final float h;
    public final int i;
    public final float j;
    public final float k;
    public final boolean l;
    public final int m;
    public final int n;
    public final float o;
    public final int p;
    public final float q;
    public static final pr0 r = new b().o("").a();
    public static final String s = g86.w0(0);
    public static final String t = g86.w0(1);
    public static final String u = g86.w0(2);
    public static final String v = g86.w0(3);
    public static final String w = g86.w0(4);
    public static final String x = g86.w0(5);
    public static final String y = g86.w0(6);
    public static final String z = g86.w0(7);
    public static final String A = g86.w0(8);
    public static final String B = g86.w0(9);
    public static final String C = g86.w0(10);
    public static final String E = g86.w0(11);
    public static final String F = g86.w0(12);
    public static final String G = g86.w0(13);
    public static final String H = g86.w0(14);
    public static final String I = g86.w0(15);
    public static final String J = g86.w0(16);
    public static final f.a<pr0> K = new f.a() { // from class: or0
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return pr0.c(bundle);
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public CharSequence f20083a;

        @Nullable
        public Bitmap b;

        @Nullable
        public Layout.Alignment c;

        @Nullable
        public Layout.Alignment d;
        public float e;
        public int f;
        public int g;
        public float h;
        public int i;
        public int j;
        public float k;
        public float l;
        public float m;
        public boolean n;

        @ColorInt
        public int o;
        public int p;
        public float q;

        public pr0 a() {
            return new pr0(this.f20083a, this.c, this.d, this.b, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q);
        }

        public b b() {
            this.n = false;
            return this;
        }

        public int c() {
            return this.g;
        }

        public int d() {
            return this.i;
        }

        @Nullable
        public CharSequence e() {
            return this.f20083a;
        }

        public b f(Bitmap bitmap) {
            this.b = bitmap;
            return this;
        }

        public b g(float f) {
            this.m = f;
            return this;
        }

        public b h(float f, int i) {
            this.e = f;
            this.f = i;
            return this;
        }

        public b i(int i) {
            this.g = i;
            return this;
        }

        public b j(@Nullable Layout.Alignment alignment) {
            this.d = alignment;
            return this;
        }

        public b k(float f) {
            this.h = f;
            return this;
        }

        public b l(int i) {
            this.i = i;
            return this;
        }

        public b m(float f) {
            this.q = f;
            return this;
        }

        public b n(float f) {
            this.l = f;
            return this;
        }

        public b o(CharSequence charSequence) {
            this.f20083a = charSequence;
            return this;
        }

        public b p(@Nullable Layout.Alignment alignment) {
            this.c = alignment;
            return this;
        }

        public b q(float f, int i) {
            this.k = f;
            this.j = i;
            return this;
        }

        public b r(int i) {
            this.p = i;
            return this;
        }

        public b s(@ColorInt int i) {
            this.o = i;
            this.n = true;
            return this;
        }

        public b() {
            this.f20083a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = -3.4028235E38f;
            this.f = Integer.MIN_VALUE;
            this.g = Integer.MIN_VALUE;
            this.h = -3.4028235E38f;
            this.i = Integer.MIN_VALUE;
            this.j = Integer.MIN_VALUE;
            this.k = -3.4028235E38f;
            this.l = -3.4028235E38f;
            this.m = -3.4028235E38f;
            this.n = false;
            this.o = -16777216;
            this.p = Integer.MIN_VALUE;
        }

        public b(pr0 pr0Var) {
            this.f20083a = pr0Var.f20082a;
            this.b = pr0Var.d;
            this.c = pr0Var.b;
            this.d = pr0Var.c;
            this.e = pr0Var.e;
            this.f = pr0Var.f;
            this.g = pr0Var.g;
            this.h = pr0Var.h;
            this.i = pr0Var.i;
            this.j = pr0Var.n;
            this.k = pr0Var.o;
            this.l = pr0Var.j;
            this.m = pr0Var.k;
            this.n = pr0Var.l;
            this.o = pr0Var.m;
            this.p = pr0Var.p;
            this.q = pr0Var.q;
        }
    }

    public static final pr0 c(Bundle bundle) {
        b bVar = new b();
        CharSequence charSequence = bundle.getCharSequence(s);
        if (charSequence != null) {
            bVar.o(charSequence);
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(t);
        if (alignment != null) {
            bVar.p(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(u);
        if (alignment2 != null) {
            bVar.j(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(v);
        if (bitmap != null) {
            bVar.f(bitmap);
        }
        String str = w;
        if (bundle.containsKey(str)) {
            String str2 = x;
            if (bundle.containsKey(str2)) {
                bVar.h(bundle.getFloat(str), bundle.getInt(str2));
            }
        }
        String str3 = y;
        if (bundle.containsKey(str3)) {
            bVar.i(bundle.getInt(str3));
        }
        String str4 = z;
        if (bundle.containsKey(str4)) {
            bVar.k(bundle.getFloat(str4));
        }
        String str5 = A;
        if (bundle.containsKey(str5)) {
            bVar.l(bundle.getInt(str5));
        }
        String str6 = C;
        if (bundle.containsKey(str6)) {
            String str7 = B;
            if (bundle.containsKey(str7)) {
                bVar.q(bundle.getFloat(str6), bundle.getInt(str7));
            }
        }
        String str8 = E;
        if (bundle.containsKey(str8)) {
            bVar.n(bundle.getFloat(str8));
        }
        String str9 = F;
        if (bundle.containsKey(str9)) {
            bVar.g(bundle.getFloat(str9));
        }
        String str10 = G;
        if (bundle.containsKey(str10)) {
            bVar.s(bundle.getInt(str10));
        }
        if (!bundle.getBoolean(H, false)) {
            bVar.b();
        }
        String str11 = I;
        if (bundle.containsKey(str11)) {
            bVar.r(bundle.getInt(str11));
        }
        String str12 = J;
        if (bundle.containsKey(str12)) {
            bVar.m(bundle.getFloat(str12));
        }
        return bVar.a();
    }

    public b b() {
        return new b();
    }

    public boolean equals(@Nullable Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || pr0.class != obj.getClass()) {
            return false;
        }
        pr0 pr0Var = (pr0) obj;
        return TextUtils.equals(this.f20082a, pr0Var.f20082a) && this.b == pr0Var.b && this.c == pr0Var.c && ((bitmap = this.d) != null ? !((bitmap2 = pr0Var.d) == null || !bitmap.sameAs(bitmap2)) : pr0Var.d == null) && this.e == pr0Var.e && this.f == pr0Var.f && this.g == pr0Var.g && this.h == pr0Var.h && this.i == pr0Var.i && this.j == pr0Var.j && this.k == pr0Var.k && this.l == pr0Var.l && this.m == pr0Var.m && this.n == pr0Var.n && this.o == pr0Var.o && this.p == pr0Var.p && this.q == pr0Var.q;
    }

    public int hashCode() {
        return m54.b(this.f20082a, this.b, this.c, this.d, Float.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Float.valueOf(this.h), Integer.valueOf(this.i), Float.valueOf(this.j), Float.valueOf(this.k), Boolean.valueOf(this.l), Integer.valueOf(this.m), Integer.valueOf(this.n), Float.valueOf(this.o), Integer.valueOf(this.p), Float.valueOf(this.q));
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(s, this.f20082a);
        bundle.putSerializable(t, this.b);
        bundle.putSerializable(u, this.c);
        bundle.putParcelable(v, this.d);
        bundle.putFloat(w, this.e);
        bundle.putInt(x, this.f);
        bundle.putInt(y, this.g);
        bundle.putFloat(z, this.h);
        bundle.putInt(A, this.i);
        bundle.putInt(B, this.n);
        bundle.putFloat(C, this.o);
        bundle.putFloat(E, this.j);
        bundle.putFloat(F, this.k);
        bundle.putBoolean(H, this.l);
        bundle.putInt(G, this.m);
        bundle.putInt(I, this.p);
        bundle.putFloat(J, this.q);
        return bundle;
    }

    public pr0(@Nullable CharSequence charSequence, @Nullable Layout.Alignment alignment, @Nullable Layout.Alignment alignment2, @Nullable Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z2, int i5, int i6, float f6) {
        if (charSequence == null) {
            vh.e(bitmap);
        } else {
            vh.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f20082a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f20082a = charSequence.toString();
        } else {
            this.f20082a = null;
        }
        this.b = alignment;
        this.c = alignment2;
        this.d = bitmap;
        this.e = f;
        this.f = i;
        this.g = i2;
        this.h = f2;
        this.i = i3;
        this.j = f4;
        this.k = f5;
        this.l = z2;
        this.m = i5;
        this.n = i4;
        this.o = f3;
        this.p = i6;
        this.q = f6;
    }
}
