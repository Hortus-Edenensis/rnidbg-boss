package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.qq.gdt.action.ActionUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class jc7 {
    public static volatile jc7 g = null;
    public static boolean h = false;
    public BroadcastReceiver f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public eu6 f18384a = new eu6("udid");
    public eu6 b = new eu6("oaid");
    public eu6 d = new eu6("vaid");
    public eu6 c = new eu6("aaid");
    public g37 e = new g37();

    public static a97 a(Cursor cursor) {
        String str;
        a97 a97Var = new a97(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(ActionUtils.PAYMENT_AMOUNT);
                if (columnIndex >= 0) {
                    a97Var.f1182a = cursor.getString(columnIndex);
                } else {
                    e("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    a97Var.b = cursor.getInt(columnIndex2);
                } else {
                    e("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    a97Var.c = cursor.getLong(columnIndex3);
                } else {
                    e("parseExpired fail, index < 0.");
                }
                return a97Var;
            }
            str = "parseValue fail, cursor is closed.";
        }
        e(str);
        return a97Var;
    }

    public static final jc7 b() {
        if (g == null) {
            synchronized (jc7.class) {
                if (g == null) {
                    g = new jc7();
                }
            }
        }
        return g;
    }

    public static String d(PackageManager packageManager, String str) {
        ProviderInfo providerInfoResolveContentProvider;
        if (packageManager == null || (providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return providerInfoResolveContentProvider.packageName;
    }

    public static void e(String str) {
        if (h) {
            Log.d("OpenIdManager", str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0057 A[PHI: r7
      0x0057: PHI (r7v3 android.database.Cursor) = (r7v2 android.database.Cursor), (r7v4 android.database.Cursor) binds: [B:20:0x0055, B:14:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean f(Context context) {
        boolean z;
        e("querySupport version : 1.0.8");
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
            } catch (Exception e) {
                e("querySupport, Exception : " + e.getMessage());
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null) {
                a97 a97VarA = a(cursorQuery);
                if (1000 == a97VarA.b) {
                    z = "0".equals(a97VarA.f1182a);
                }
                cursorQuery.close();
                return z;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return false;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public static String i(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            e("getAppVersion, Exception : " + e.getMessage());
            return null;
        }
    }

    public final String c(Context context, eu6 eu6Var) {
        String str;
        if (eu6Var == null) {
            str = "getId, openId = null.";
        } else {
            if (eu6Var.d()) {
                return eu6Var.b;
            }
            if (g(context, true)) {
                return h(context, eu6Var);
            }
            str = "getId, isSupported = false.";
        }
        e(str);
        return null;
    }

    public final boolean g(Context context, boolean z) {
        if (this.e.b() && !z) {
            return this.e.e();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String strD = d(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(strD)) {
            return false;
        }
        String strI = i(packageManager, strD);
        if (this.e.b() && this.e.c(strI)) {
            e("use same version cache, safeVersion : ".concat(String.valueOf(strI)));
            return this.e.e();
        }
        this.e.d(strI);
        boolean zF = f(context);
        e("query support, result : ".concat(String.valueOf(zF)));
        this.e.a(zF);
        return zF;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String h(Context context, eu6 eu6Var) throws Throwable {
        String str;
        Cursor cursorQuery;
        String str2;
        String strValueOf;
        e("queryId : " + eu6Var.c);
        Cursor cursor = null;
        str = null;
        str = null;
        String str3 = null;
        cursor = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{eu6Var.c}, null);
            } catch (Exception e) {
                e = e;
                str = null;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (cursorQuery != null) {
                a97 a97VarA = a(cursorQuery);
                str3 = a97VarA.f1182a;
                eu6Var.c(str3);
                eu6Var.b(a97VarA.c);
                eu6Var.a(a97VarA.b);
                e(eu6Var.c + " errorCode : " + eu6Var.d);
                if (a97VarA.b != 1000) {
                    j(context);
                    if (!g(context, false)) {
                        str2 = "not support, forceQuery isSupported: ";
                        strValueOf = String.valueOf(g(context, true));
                        e(str2.concat(strValueOf));
                    }
                }
                if (cursorQuery == null) {
                    return str3;
                }
            } else {
                if (g(context, false)) {
                    str2 = "forceQuery isSupported : ";
                    strValueOf = String.valueOf(g(context, true));
                    e(str2.concat(strValueOf));
                }
                if (cursorQuery == null) {
                }
            }
        } catch (Exception e2) {
            e = e2;
            str = str3;
            cursor = cursorQuery;
            e("queryId, Exception : " + e.getMessage());
            if (cursor == null) {
                return str;
            }
            cursorQuery = cursor;
            str3 = str;
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        cursorQuery.close();
        return str3;
    }

    public final synchronized void j(Context context) {
        if (this.f != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        ra7 ra7Var = new ra7();
        this.f = ra7Var;
        context.registerReceiver(ra7Var, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }
}
