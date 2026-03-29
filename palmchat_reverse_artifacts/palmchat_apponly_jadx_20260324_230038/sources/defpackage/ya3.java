package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ya3 {
    public static boolean a(Context context, String str, String str2, boolean z) {
        return context.getSharedPreferences(str, 4).getBoolean(str2, z);
    }

    public static String b(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 4).getString(str2, str3);
    }

    public static boolean c(Context context, String str, String str2, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 4).edit();
        editorEdit.putBoolean(str2, z);
        return editorEdit.commit();
    }

    public static boolean d(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 4).edit();
        editorEdit.putString(str2, str3);
        return editorEdit.commit();
    }
}
