package defpackage;

import android.content.Context;
import androidx.core.content.ContextCompat;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class l67 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f18919a = new HashSet();

    public static boolean a(Context context, String str) {
        Class<?> cls;
        try {
            if (f18919a.contains(str)) {
                return true;
            }
            try {
                cls = Class.forName("android.support.v4.content.ContextCompat");
            } catch (Exception unused) {
                cls = null;
            }
            if (cls == null) {
                try {
                    int i = ContextCompat.f1266a;
                    cls = ContextCompat.class;
                } catch (Exception unused2) {
                }
            }
            if (cls == null) {
                f18919a.add(str);
                return true;
            }
            if (((Integer) cls.getMethod("checkSelfPermission", Context.class, String.class).invoke(null, context, str)).intValue() == 0) {
                f18919a.add(str);
                return true;
            }
            g57.b("PermissionUtils", "缺少 " + str + " 权限");
            return false;
        } catch (Exception e) {
            g57.b("PermissionUtils", e.toString());
            return true;
        }
    }
}
