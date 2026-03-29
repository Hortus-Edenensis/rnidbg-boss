package defpackage;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class b03 {
    public static final b03 c = new b03("COMPOSITION");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f1618a;

    @Nullable
    public c03 b;

    public b03(String... strArr) {
        this.f1618a = Arrays.asList(strArr);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public b03 a(String str) {
        b03 b03Var = new b03(this);
        b03Var.f1618a.add(str);
        return b03Var;
    }

    public final boolean b() {
        return this.f1618a.get(r0.size() - 1).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(String str, int i) {
        if (i >= this.f1618a.size()) {
            return false;
        }
        boolean z = i == this.f1618a.size() - 1;
        String str2 = this.f1618a.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.f1618a.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.f1618a.get(i + 1).equals(str)) {
            return i == this.f1618a.size() + (-2) || (i == this.f1618a.size() + (-3) && b());
        }
        if (z) {
            return true;
        }
        int i2 = i + 1;
        if (i2 < this.f1618a.size() - 1) {
            return false;
        }
        return this.f1618a.get(i2).equals(str);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public c03 d() {
        return this.b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int e(String str, int i) {
        if (f(str)) {
            return 0;
        }
        if (this.f1618a.get(i).equals("**")) {
            return (i != this.f1618a.size() - 1 && this.f1618a.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b03 b03Var = (b03) obj;
        if (!this.f1618a.equals(b03Var.f1618a)) {
            return false;
        }
        c03 c03Var = this.b;
        c03 c03Var2 = b03Var.b;
        return c03Var != null ? c03Var.equals(c03Var2) : c03Var2 == null;
    }

    public final boolean f(String str) {
        return "__container".equals(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean g(String str, int i) {
        if (f(str)) {
            return true;
        }
        if (i >= this.f1618a.size()) {
            return false;
        }
        return this.f1618a.get(i).equals(str) || this.f1618a.get(i).equals("**") || this.f1618a.get(i).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean h(String str, int i) {
        return "__container".equals(str) || i < this.f1618a.size() - 1 || this.f1618a.get(i).equals("**");
    }

    public int hashCode() {
        int iHashCode = this.f1618a.hashCode() * 31;
        c03 c03Var = this.b;
        return iHashCode + (c03Var != null ? c03Var.hashCode() : 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public b03 i(c03 c03Var) {
        b03 b03Var = new b03(this);
        b03Var.b = c03Var;
        return b03Var;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f1618a);
        sb.append(",resolved=");
        sb.append(this.b != null);
        sb.append('}');
        return sb.toString();
    }

    public b03(b03 b03Var) {
        this.f1618a = new ArrayList(b03Var.f1618a);
        this.b = b03Var.b;
    }
}
