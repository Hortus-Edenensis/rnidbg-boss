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
/* JADX INFO: loaded from: classes5.dex */
public class i27 {
    public static volatile i27 g = null;
    public static boolean h = false;
    public BroadcastReceiver f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o84 f18094a = new o84("udid");
    public o84 b = new o84("oaid");
    public o84 d = new o84("vaid");
    public o84 c = new o84("aaid");
    public uo5 e = new uo5();

    public static g96 a(Cursor cursor) {
        String str;
        g96 g96Var = new g96(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(ActionUtils.PAYMENT_AMOUNT);
                if (columnIndex >= 0) {
                    g96Var.f17689a = cursor.getString(columnIndex);
                } else {
                    e("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    g96Var.b = cursor.getInt(columnIndex2);
                } else {
                    e("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    g96Var.c = cursor.getLong(columnIndex3);
                } else {
                    e("parseExpired fail, index < 0.");
                }
                return g96Var;
            }
            str = "parseValue fail, cursor is closed.";
        }
        e(str);
        return g96Var;
    }

    public static final i27 b() {
        if (g == null) {
            synchronized (i27.class) {
                if (g == null) {
                    g = new i27();
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

    /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
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
            if (cursorQuery == null) {
                return false;
            }
            g96 g96VarA = a(cursorQuery);
            if (1000 == g96VarA.b) {
                z = "0".equals(g96VarA.f17689a);
            }
            cursorQuery.close();
            return z;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
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

    public final String c(Context context, o84 o84Var) {
        String str;
        if (o84Var == null) {
            str = "getId, openId = null.";
        } else {
            if (o84Var.d()) {
                return o84Var.b;
            }
            if (g(context, true)) {
                return h(context, o84Var);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0095  */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String h(Context context, o84 o84Var) throws Throwable {
        String str;
        Cursor cursorQuery;
        String strConcat;
        e("queryId : " + o84Var.c);
        ?? r0 = 0;
        str = null;
        r0 = 0;
        String str2 = null;
        Cursor cursor = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{o84Var.c}, null);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
            str = null;
        }
        try {
            if (cursorQuery != null) {
                g96 g96VarA = a(cursorQuery);
                String str3 = g96VarA.f17689a;
                o84Var.c(str3);
                o84Var.b(g96VarA.c);
                o84Var.a(g96VarA.b);
                e(o84Var.c + " errorCode : " + o84Var.d);
                r0 = str3;
                if (g96VarA.b != 1000) {
                    j(context);
                    r0 = str3;
                    if (!g(context, false)) {
                        strConcat = "not support, forceQuery isSupported: ".concat(String.valueOf(g(context, true)));
                        str2 = str3;
                        e(strConcat);
                        r0 = str2;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } else {
                if (g(context, false)) {
                    strConcat = "forceQuery isSupported : ".concat(String.valueOf(g(context, true)));
                    e(strConcat);
                    r0 = str2;
                }
                if (cursorQuery != null) {
                }
            }
        } catch (Exception e2) {
            e = e2;
            str = str2;
            cursor = cursorQuery;
            e("queryId, Exception : " + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            r0 = str;
        } catch (Throwable th2) {
            th = th2;
            r0 = cursorQuery;
            if (r0 != 0) {
                r0.close();
            }
            throw th;
        }
        return r0;
    }

    public final synchronized void j(Context context) {
        if (this.f != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        hx6 hx6Var = new hx6();
        this.f = hx6Var;
        context.registerReceiver(hx6Var, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }
}
