package defpackage;

import com.igexin.push.core.b;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class b05 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1619a = true;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        Object getValue();
    }

    public static void a(Object obj) {
        e(obj, false);
    }

    public static String b(Object obj) {
        if (obj == null) {
            return b.m;
        }
        if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short)) {
            return String.valueOf(obj);
        }
        try {
            return az2.c(obj);
        } catch (Exception unused) {
            return obj.toString();
        }
    }

    public static void c(a aVar) {
        if (aVar == null) {
            LogUtil.e("sangxiang", "[callback is null]");
            return;
        }
        try {
            Object value = aVar.getValue();
            if (value == null) {
                LogUtil.e("sangxiang", b.m);
            } else {
                LogUtil.e("sangxiang", b(value));
            }
        } catch (NullPointerException e) {
            LogUtil.e("sangxiang", "[NullPointerException: " + e.getMessage() + "]");
        } catch (Exception e2) {
            LogUtil.e("sangxiang", "[Error in callback: " + e2.getMessage() + "]");
        }
    }

    public static void e(Object obj, boolean z) {
        LogUtil.e("sangxiang", obj.toString());
    }

    @Deprecated
    public static void d(String str) {
    }
}
