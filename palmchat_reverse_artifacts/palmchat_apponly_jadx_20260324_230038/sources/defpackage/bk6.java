package defpackage;

import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class bk6 {

    @ColorInt
    public int f;
    public int h;
    public float o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1741a = "";
    public String b = "";
    public Set<String> c = Collections.emptySet();
    public String d = "";

    @Nullable
    public String e = null;
    public boolean g = false;
    public boolean i = false;
    public int j = -1;
    public int k = -1;
    public int l = -1;
    public int m = -1;
    public int n = -1;
    public int p = -1;
    public boolean q = false;

    public static int B(int i, String str, @Nullable String str2, int i2) {
        if (str.isEmpty() || i == -1) {
            return i;
        }
        if (str.equals(str2)) {
            return i + i2;
        }
        return -1;
    }

    public bk6 A(boolean z) {
        this.k = z ? 1 : 0;
        return this;
    }

    public int a() {
        if (this.i) {
            return this.h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.q;
    }

    public int c() {
        if (this.g) {
            return this.f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    @Nullable
    public String d() {
        return this.e;
    }

    public float e() {
        return this.o;
    }

    public int f() {
        return this.n;
    }

    public int g() {
        return this.p;
    }

    public int h(@Nullable String str, @Nullable String str2, Set<String> set, @Nullable String str3) {
        if (this.f1741a.isEmpty() && this.b.isEmpty() && this.c.isEmpty() && this.d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int iB = B(B(B(0, this.f1741a, str, 1073741824), this.b, str2, 2), this.d, str3, 4);
        if (iB == -1 || !set.containsAll(this.c)) {
            return 0;
        }
        return iB + (this.c.size() * 4);
    }

    public int i() {
        int i = this.l;
        if (i == -1 && this.m == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.m == 1 ? 2 : 0);
    }

    public boolean j() {
        return this.i;
    }

    public boolean k() {
        return this.g;
    }

    public boolean l() {
        return this.j == 1;
    }

    public boolean m() {
        return this.k == 1;
    }

    public bk6 n(int i) {
        this.h = i;
        this.i = true;
        return this;
    }

    public bk6 o(boolean z) {
        this.l = z ? 1 : 0;
        return this;
    }

    public bk6 p(boolean z) {
        this.q = z;
        return this;
    }

    public bk6 q(int i) {
        this.f = i;
        this.g = true;
        return this;
    }

    public bk6 r(@Nullable String str) {
        this.e = str == null ? null : th.e(str);
        return this;
    }

    public bk6 s(float f) {
        this.o = f;
        return this;
    }

    public bk6 t(int i) {
        this.n = i;
        return this;
    }

    public bk6 u(boolean z) {
        this.m = z ? 1 : 0;
        return this;
    }

    public bk6 v(int i) {
        this.p = i;
        return this;
    }

    public void w(String[] strArr) {
        this.c = new HashSet(Arrays.asList(strArr));
    }

    public void x(String str) {
        this.f1741a = str;
    }

    public void y(String str) {
        this.b = str;
    }

    public void z(String str) {
        this.d = str;
    }
}
