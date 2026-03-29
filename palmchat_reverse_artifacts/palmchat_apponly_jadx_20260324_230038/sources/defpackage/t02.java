package defpackage;

import androidx.annotation.RestrictTo;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class t02 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e75> f20881a;
    public final char b;
    public final double c;
    public final double d;
    public final String e;
    public final String f;

    public t02(List<e75> list, char c, double d, double d2, String str, String str2) {
        this.f20881a = list;
        this.b = c;
        this.c = d;
        this.d = d2;
        this.e = str;
        this.f = str2;
    }

    public static int c(char c, String str, String str2) {
        return ((((0 + c) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<e75> a() {
        return this.f20881a;
    }

    public double b() {
        return this.d;
    }

    public int hashCode() {
        return c(this.b, this.f, this.e);
    }
}
