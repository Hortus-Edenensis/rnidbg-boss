package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class pw1 {
    public static boolean a(Context context) {
        return j86.a(context, "org.appanalysis");
    }

    public static boolean b() {
        try {
            Class.forName("dalvik.system.Taint");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
