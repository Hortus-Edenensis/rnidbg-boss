package defpackage;

import android.content.SharedPreferences;
import com.zenmen.palmchat.AppContext;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class nx3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<String> f19637a = new a();
    public static final ArrayList<String> b = new b();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ArrayList<String> {
        public a() {
            add("key_name_card");
            add("key_new_chat_setting");
            add("key_new_privacy_setting");
            add("key_new_common_setting");
            add("key_new_account_setting");
            add("key_new_blacklist");
            add("key_new_feedback");
            add("key_small_video");
            add("key_moments");
            add("key_hoc_new");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends ArrayList<String> {
        public b() {
            add("key_tab_discover");
            add("key_message_bottle");
            add("key_people_nearby");
        }
    }

    public static boolean a(String str) {
        return b(str, true);
    }

    public static boolean b(String str, boolean z) {
        if (str == null) {
            return z;
        }
        if (f19637a.contains(str)) {
            return false;
        }
        return c(str, z);
    }

    public static boolean c(String str, boolean z) {
        SharedPreferences sharedPreferencesD = d();
        if (sharedPreferencesD.contains(str) || !b.contains(str)) {
            return sharedPreferencesD.getBoolean(str, z);
        }
        boolean zA = AppContext.getContext().getTrayPreferences().a(str, z);
        g(str, zA);
        return zA;
    }

    public static SharedPreferences d() {
        return xp3.c("sp_new_feature");
    }

    public static void e(String str) {
        f(str, false);
    }

    public static void f(String str, boolean z) {
        if (str == null || f19637a.contains(str)) {
            return;
        }
        g(str, z);
    }

    public static void g(String str, boolean z) {
        SharedPreferences.Editor editorEdit = d().edit();
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }
}
