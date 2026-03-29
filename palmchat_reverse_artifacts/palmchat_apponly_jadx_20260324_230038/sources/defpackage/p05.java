package defpackage;

import com.zenmen.palmchat.contacts.widget.a;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class p05 {
    public static String a(String str) {
        return t66.h().e(str, "A");
    }

    public static boolean b() {
        return e("LX-70603") && !TeenagersModeManager.a().d() && a.b();
    }

    public static boolean c() {
        return e("LX-74183");
    }

    public static boolean d() {
        return e("LX-76472");
    }

    public static boolean e(String str) {
        return !"A".contains(a(str));
    }
}
