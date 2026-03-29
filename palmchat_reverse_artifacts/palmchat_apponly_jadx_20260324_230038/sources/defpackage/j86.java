package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class j86 {
    public static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getInstallerPackageName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
