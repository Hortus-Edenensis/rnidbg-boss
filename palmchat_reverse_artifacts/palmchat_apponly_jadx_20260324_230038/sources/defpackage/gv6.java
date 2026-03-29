package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class gv6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile UUID f17821a = null;
    public static String b = "";

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public gv6(Context context) {
        if (f17821a == null) {
            synchronized (gv6.class) {
                if (f17821a == null) {
                    String string = null;
                    String strB = xi7.d().b(null);
                    if (strB != null) {
                        f17821a = UUID.fromString(strB);
                    } else {
                        try {
                            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                        } catch (Throwable unused) {
                        }
                        try {
                            f17821a = string != null ? UUID.nameUUIDFromBytes(string.getBytes("utf8")) : UUID.randomUUID();
                        } catch (Throwable unused2) {
                        }
                        try {
                            xi7.d().l(f17821a.toString());
                        } catch (Throwable unused3) {
                        }
                    }
                }
            }
        }
    }

    public static synchronized String a(Context context) {
        UUID uuidB;
        if (TextUtils.isEmpty(b) && (uuidB = new gv6(context).b()) != null) {
            b = uuidB.toString();
        }
        return b;
    }

    public UUID b() {
        return f17821a;
    }
}
