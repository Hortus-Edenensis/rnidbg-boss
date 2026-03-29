package defpackage;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class x83 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21902a;
    public final int b;
    public final String c;
    public final String d;
    public final String e;

    @Nullable
    public Bitmap f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public x83(int i, int i2, String str, String str2, String str3) {
        this.f21902a = i;
        this.b = i2;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    @Nullable
    public Bitmap a() {
        return this.f;
    }

    public String b() {
        return this.d;
    }

    public int c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public int e() {
        return this.f21902a;
    }

    public void f(@Nullable Bitmap bitmap) {
        this.f = bitmap;
    }
}
