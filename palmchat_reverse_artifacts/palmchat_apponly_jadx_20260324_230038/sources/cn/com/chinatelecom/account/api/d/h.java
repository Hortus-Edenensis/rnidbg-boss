package cn.com.chinatelecom.account.api.d;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static i f2055a = new k();

    public static String a() {
        return f2055a.a(true);
    }

    public static String b() {
        return f2055a.a(false);
    }

    public static String a(Context context, String str, String str2, String str3, long j, String str4) {
        return f2055a.a(context, str, str2, str3, j, true, str4);
    }

    public static String b(Context context, String str, String str2, String str3, long j, String str4) {
        return f2055a.a(context, str, str2, str3, j, false, str4);
    }

    public static String a(String str, String str2) {
        return f2055a.a(str, str2);
    }
}
