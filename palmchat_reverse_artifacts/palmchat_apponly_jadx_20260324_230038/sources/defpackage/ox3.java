package defpackage;

import android.content.SharedPreferences;
import com.zenmen.palmchat.c;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ox3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<String> f19895a = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ArrayList<String> {
    }

    public static boolean a(String str) {
        return b(str, true);
    }

    public static boolean b(String str, boolean z) {
        return str != null ? c(str, z) : z;
    }

    public static boolean c(String str, boolean z) {
        SharedPreferences sharedPreferencesD = d();
        if (sharedPreferencesD.contains(str) || !f19895a.contains(str)) {
            return sharedPreferencesD.getBoolean(str, z);
        }
        boolean zA = c.e().a(str, z);
        g(str, zA);
        return zA;
    }

    public static SharedPreferences d() {
        return c.b().getSharedPreferences("sp_new_feature", 0);
    }

    public static void e(String str) {
        f(str, false);
    }

    public static void f(String str, boolean z) {
        if (str != null) {
            g(str, z);
        }
    }

    public static void g(String str, boolean z) {
        SharedPreferences.Editor editorEdit = d().edit();
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }
}
