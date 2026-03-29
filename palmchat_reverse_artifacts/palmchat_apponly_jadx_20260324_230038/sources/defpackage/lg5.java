package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.lantern.auth.server.WkParams;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class lg5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, SharedPreferences> f18975a = new ConcurrentHashMap();

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferencesE = e(context, str);
        if (sharedPreferencesE != null) {
            sharedPreferencesE.edit().clear().apply();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [T] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public static <T> void b(SharedPreferences.Editor editor, String str, T t, boolean z) {
        if (editor != null) {
            if (t == 0) {
                editor.remove(str);
                return;
            }
            if (t instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) t).booleanValue());
                return;
            }
            boolean z2 = t instanceof String;
            ?? r3 = t;
            if (z2) {
                if (z) {
                    String str2 = (String) t;
                    r3 = t;
                    if (str2.length() > 0) {
                        r3 = (T) n45.e(str2);
                    }
                }
                editor.putString(str, (String) r3);
                return;
            }
            if (t instanceof Integer) {
                editor.putInt(str, ((Integer) t).intValue());
            } else if (t instanceof Long) {
                editor.putLong(str, ((Long) t).longValue());
            } else if (t instanceof Float) {
                editor.putFloat(str, ((Float) t).floatValue());
            }
        }
    }

    public static <T> T c(Context context, zz2<T> zz2Var) {
        T t = (T) f(context, zz2Var);
        return t != null ? t : zz2Var.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T d(SharedPreferences sharedPreferences, String str, T t) {
        if (sharedPreferences != null && sharedPreferences.contains(str)) {
            try {
                if (t instanceof Boolean) {
                    return (T) Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) t).booleanValue()));
                }
                if (t instanceof String) {
                    return (T) sharedPreferences.getString(str, (String) t);
                }
                if (t instanceof Integer) {
                    return (T) Integer.valueOf(sharedPreferences.getInt(str, ((Integer) t).intValue()));
                }
                if (t instanceof Long) {
                    return (T) Long.valueOf(sharedPreferences.getLong(str, ((Long) t).longValue()));
                }
                if (t instanceof Float) {
                    return (T) Float.valueOf(sharedPreferences.getFloat(str, ((Float) t).floatValue()));
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static SharedPreferences e(Context context, String str) {
        Context contextA;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, SharedPreferences> map = f18975a;
        SharedPreferences sharedPreferences = map.get(str);
        if (sharedPreferences != null || (contextA = tv2.a(context)) == null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = contextA.getSharedPreferences(str, 0);
        map.put(str, sharedPreferences2);
        j(contextA, str);
        return sharedPreferences2;
    }

    public static <T> T f(Context context, zz2<T> zz2Var) {
        Object objD = d(e(context, zz2Var.f22541a), zz2Var.b, zz2Var.c);
        if (objD == null && zz2Var.d) {
            objD = (T) d(g(context, zz2Var.f22541a), zz2Var.b, zz2Var.c);
        }
        if (objD == null) {
            return null;
        }
        if (zz2Var.e && (objD instanceof String)) {
            String str = objD;
            if (str.length() > 0) {
                objD = (T) n45.c(str);
            }
        }
        zz2Var.a0(objD);
        return (T) objD;
    }

    public static SharedPreferences g(Context context, String str) {
        Context contextA = tv2.a(context);
        if (contextA == null) {
            return null;
        }
        contextA.getSharedPreferences(str, 4);
        return contextA.getSharedPreferences(str, 0);
    }

    public static void h(Context context, zz2<?>... zz2VarArr) {
        SharedPreferences sharedPreferencesE;
        if (zz2VarArr == null || zz2VarArr.length <= 0) {
            return;
        }
        HashMap map = new HashMap();
        for (zz2<?> zz2Var : zz2VarArr) {
            SharedPreferences.Editor editorEdit = (SharedPreferences.Editor) map.get(zz2Var.f22541a);
            if (editorEdit == null && (sharedPreferencesE = e(context, zz2Var.f22541a)) != null) {
                editorEdit = sharedPreferencesE.edit();
                map.put(zz2Var.f22541a, editorEdit);
            }
            b(editorEdit, zz2Var.b, zz2Var.c, zz2Var.e);
        }
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((SharedPreferences.Editor) it.next()).commit();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void i(Context context, zz2<T> zz2Var, zz2<T> zz2Var2) {
        Object objF;
        if (f(context, zz2Var) != null || (objF = f(context, zz2Var2)) == null) {
            return;
        }
        h(context, zz2Var.a0(objF));
        h(context, zz2Var2.a0(null));
    }

    public static void j(Context context, String str) {
        String str2 = (String) c(context, zz2.h());
        if (TextUtils.isEmpty(str2) || str2.startsWith("1.")) {
            if (str.equals(zz2.f)) {
                i(context, zz2.z(), zz2.z().Q("cn.jpush.android.user.profile"));
                i(context, zz2.A(), zz2.A().Q("cn.jpush.android.user.profile"));
                i(context, zz2.y(), zz2.y().Q("cn.jpush.android.user.profile"));
                return;
            }
            if (str.equals("cn.jiguang.sdk.user.set.profile")) {
                i(context, zz2.E(), zz2.E().Q("cn.jpush.preferences.v2"));
                i(context, zz2.D(), zz2.D().a0("cn.jpush.android.user.profile"));
                return;
            }
            if (str.equals("cn.jiguang.sdk.user.profile")) {
                i(context, zz2.K(), zz2.K().Q("cn.jpush.android.user.profile").Y("device_uid"));
                i(context, zz2.I(), zz2.I().Q("cn.jpush.android.user.profile").Y("device_registration_id"));
                i(context, zz2.H(), zz2.H().Q("cn.jpush.android.user.profile").Y("device_password"));
            } else if (str.equals("cn.jiguang.sdk.address")) {
                i(context, zz2.L(), zz2.L().Q("cn.jpush.android.user.profile").Y("conn"));
                i(context, zz2.M(), zz2.M().Q("cn.jpush.android.user.profile").Y("srv"));
            } else if (str.equals(zz2.g)) {
                i(context, zz2.e(), zz2.e().Y("device_registered_appkey"));
                i(context, zz2.f(), zz2.f().Y(WkParams.IMEI));
            }
        }
    }
}
