package defpackage;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class j07 {
    public static j07 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f18299a;

    public static j07 e() {
        if (b == null) {
            b = new j07();
        }
        return b;
    }

    public static boolean f() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i = 0; i < 10; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public b07 a() {
        return b07.e();
    }

    public void b(Context context) {
        b07.e();
        this.f18299a = context.getApplicationContext();
    }

    public Context c() {
        return this.f18299a;
    }

    public String d() {
        return rz6.d(null, this.f18299a);
    }
}
