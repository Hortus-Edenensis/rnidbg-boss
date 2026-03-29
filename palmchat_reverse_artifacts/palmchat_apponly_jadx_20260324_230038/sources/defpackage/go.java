package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import com.zenmen.palmchat.AppContext;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class go {
    public static boolean a(Context context, String str, String str2, boolean z) {
        return context.getSharedPreferences(str, 4).getBoolean(str2, z);
    }

    public static boolean b(String str, String str2, boolean z) {
        return a(AppContext.getContext(), str, str2, z);
    }

    public static boolean c(String str, boolean z) {
        return b(AppContext.getContext().getPackageName(), str, z);
    }

    public static long d(Context context, String str, String str2, long j) {
        return context.getSharedPreferences(str, 0).getLong(str2, j);
    }

    public static long e(String str, String str2, long j) {
        return d(AppContext.getContext(), str, str2, j);
    }

    public static String f(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 4).getString(str2, str3);
    }

    public static String g(String str, String str2) {
        return h(AppContext.getContext().getPackageName(), str, str2);
    }

    public static String h(String str, String str2, String str3) {
        return f(AppContext.getContext(), str, str2, str3);
    }

    public static boolean i(Context context, String str, String str2, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 4).edit();
        editorEdit.putBoolean(str2, z);
        return editorEdit.commit();
    }

    public static boolean j(String str, String str2, boolean z) {
        return i(AppContext.getContext(), str, str2, z);
    }

    public static boolean k(String str, boolean z) {
        return j(AppContext.getContext().getPackageName(), str, z);
    }

    public static boolean l(Context context, String str, String str2, long j) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        editorEdit.putLong(str2, j);
        return editorEdit.commit();
    }

    public static boolean m(String str, String str2, long j) {
        return l(AppContext.getContext(), str, str2, j);
    }

    public static boolean n(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 4).edit();
        editorEdit.putString(str2, str3);
        return editorEdit.commit();
    }

    public static boolean o(String str, String str2) {
        return p(AppContext.getContext().getPackageName(), str, str2);
    }

    public static boolean p(String str, String str2, String str3) {
        return n(AppContext.getContext(), str, str2, str3);
    }
}
