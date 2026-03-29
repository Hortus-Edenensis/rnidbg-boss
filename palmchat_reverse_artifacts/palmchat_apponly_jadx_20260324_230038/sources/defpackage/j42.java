package defpackage;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class j42 {
    public static boolean a(Context context) {
        return !b();
    }

    public static synchronized boolean b() {
        boolean zExists;
        zExists = false;
        try {
            zExists = new File("/data/local/tmp/re.frida.server/frida-agent-64.so").exists();
            z53.d("SafeChecker", "checkFridaFile " + zExists);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zExists;
    }
}
