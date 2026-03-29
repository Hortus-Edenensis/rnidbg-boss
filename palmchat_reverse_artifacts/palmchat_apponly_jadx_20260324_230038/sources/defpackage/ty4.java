package defpackage;

import android.annotation.SuppressLint;
import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ty4 {
    public static final String b = "RootKeyUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f21093a = null;

    public static ty4 d(String str, String str2, String str3, String str4) {
        ty4 ty4Var = new ty4();
        ty4Var.a(str, str2, str3, str4);
        return ty4Var;
    }

    public final void a(String str, String str2, String str3, String str4) {
        b(str, str2, str3, oh2.b(str4));
    }

    @SuppressLint({"NewApi"})
    public final void b(String str, String str2, String str3, byte[] bArr) {
        if (Build.VERSION.SDK_INT < 26) {
            g17.d(b, "initRootKey: sha1");
            this.f21093a = rq.h(str, str2, str3, bArr, false);
        } else {
            g17.d(b, "initRootKey: sha256");
            this.f21093a = rq.h(str, str2, str3, bArr, true);
        }
    }

    public byte[] c() {
        return (byte[]) this.f21093a.clone();
    }
}
