package defpackage;

import android.content.Context;
import com.opos.acs.st.STManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class w17 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rw6 f21585a = new rw6();

    public static String a(Context context) {
        return f21585a.c(STManager.KEY_SSO_ID, "0");
    }

    public static void b(Context context, String str, long j) {
        f21585a.e(str, j);
    }

    public static void c(Context context, String str, String str2) {
        f21585a.f(str, str2);
    }

    public static long d(Context context, String str, long j) {
        return f21585a.b(str, j);
    }

    public static String e(Context context, String str, String str2) {
        return f21585a.c(str, str2);
    }
}
