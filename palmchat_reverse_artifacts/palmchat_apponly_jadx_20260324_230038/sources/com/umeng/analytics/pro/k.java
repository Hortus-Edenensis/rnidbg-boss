package com.umeng.analytics.pro;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.g;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpHeaders;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f10960a = 2049;
    public static final int b = 2050;
    private static final int c = 1000;
    private static Context d = null;
    private static String e = null;
    private static final String f = "umeng+";
    private static final String g = "ek__id";
    private static final String h = "ek_key";
    private List<String> i;
    private List<Integer> j;
    private String k;
    private List<String> l;

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final k f10962a = new k();

        private b() {
        }
    }

    public static k a(Context context) {
        k kVar = b.f10962a;
        if (d == null && context != null) {
            d = context.getApplicationContext();
            kVar.k();
        }
        return kVar;
    }

    private void k() {
        synchronized (this) {
            l();
            this.i.clear();
            this.l.clear();
            this.j.clear();
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(d, g);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = PreferenceWrapper.getDefault(d).getString(g, null);
                    if (TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = UMUtils.genId();
                    }
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(d, g, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String strSubstring = multiProcessSP.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < strSubstring.length(); i++) {
                        char cCharAt = strSubstring.charAt(i);
                        if (!Character.isDigit(cCharAt)) {
                            sb.append(cCharAt);
                        } else if (Integer.parseInt(Character.toString(cCharAt)) == 0) {
                            sb.append(0);
                        } else {
                            sb.append(10 - Integer.parseInt(Character.toString(cCharAt)));
                        }
                    }
                    e = sb.toString();
                }
                if (TextUtils.isEmpty(e)) {
                    return;
                }
                e += new StringBuilder(e).reverse().toString();
                String multiProcessSP2 = UMUtils.getMultiProcessSP(d, h);
                if (TextUtils.isEmpty(multiProcessSP2)) {
                    UMUtils.setMultiProcessSP(d, h, c(f));
                } else {
                    if (f.equals(d(multiProcessSP2))) {
                        return;
                    }
                    b(true, false);
                    a(true, false);
                    h();
                    i();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        this.l.clear();
    }

    public boolean c() {
        return this.l.isEmpty();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(3:35|3|(4:33|5|6|7)(5:8|9|(1:11)|38|12))|29|15|16|20|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                String strC = w.a().c();
                if (TextUtils.isEmpty(strC)) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                    i.a(d).b();
                    return;
                }
                String[] strArr = {"", "-1"};
                for (int i = 0; i < 2; i++) {
                    sQLiteDatabaseA.execSQL("update __et set __i=\"" + strC + "\" where __i=\"" + strArr[i] + "\"");
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused2) {
                    }
                }
                i.a(d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused3) {
            j.a(d);
            if (sQLiteDatabaseA != null) {
            }
        } catch (Throwable unused4) {
        }
    }

    public boolean e() {
        return this.i.isEmpty();
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0089 A[EXC_TOP_SPLITTER, PHI: r2 r5
      0x0089: PHI (r2v5 android.database.sqlite.SQLiteDatabase) = (r2v4 android.database.sqlite.SQLiteDatabase), (r2v6 android.database.sqlite.SQLiteDatabase) binds: [B:28:0x0087, B:35:0x00a3] A[DONT_GENERATE, DONT_INLINE]
      0x0089: PHI (r5v3 org.json.JSONObject) = (r5v2 org.json.JSONObject), (r5v5 org.json.JSONObject) binds: [B:28:0x0087, B:35:0x00a3] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject f() {
        SQLiteDatabase sQLiteDatabaseA;
        JSONObject jSONObject;
        Cursor cursor = null;
        jSONObject = null;
        jSONObject = null;
        jSONObject = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        Cursor cursor2 = null;
        if (this.l.isEmpty()) {
            return null;
        }
        try {
            sQLiteDatabaseA = i.a(d).a();
            try {
                sQLiteDatabaseA.beginTransaction();
                Cursor cursorA = a(g.c.f10950a, sQLiteDatabaseA, null, "__ii=? ", new String[]{this.l.get(0)}, null, null, null, null);
                if (cursorA != null) {
                    try {
                        if (cursorA.moveToNext()) {
                            jSONObject = new JSONObject();
                            try {
                                String string = cursorA.getString(cursorA.getColumnIndex("__av"));
                                String string2 = cursorA.getString(cursorA.getColumnIndex("__vc"));
                                jSONObject.put("__av", string);
                                jSONObject.put("__vc", string2);
                                jSONObject2 = jSONObject;
                            } catch (SQLiteDatabaseCorruptException unused) {
                                cursor2 = cursorA;
                                try {
                                    j.a(d);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabaseA != null) {
                                        try {
                                            sQLiteDatabaseA.endTransaction();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    i.a(d).b();
                                    return jSONObject;
                                } catch (Throwable th) {
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabaseA != null) {
                                        try {
                                            sQLiteDatabaseA.endTransaction();
                                        } catch (Throwable unused3) {
                                        }
                                    }
                                    i.a(d).b();
                                    throw th;
                                }
                            } catch (Throwable unused4) {
                                cursor = cursorA;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabaseA != null) {
                                }
                                i.a(d).b();
                                return jSONObject;
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException unused5) {
                        jSONObject = jSONObject2;
                    } catch (Throwable unused6) {
                        jSONObject = jSONObject2;
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                if (cursorA != null) {
                    cursorA.close();
                }
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused7) {
                }
                i.a(d).b();
                return jSONObject2;
            } catch (SQLiteDatabaseCorruptException unused8) {
                jSONObject = null;
            } catch (Throwable unused9) {
                jSONObject = null;
            }
        } catch (SQLiteDatabaseCorruptException unused10) {
            sQLiteDatabaseA = null;
            jSONObject = null;
        } catch (Throwable unused11) {
            sQLiteDatabaseA = null;
            jSONObject = null;
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0089 A[EXC_TOP_SPLITTER, PHI: r2 r5
      0x0089: PHI (r2v5 android.database.sqlite.SQLiteDatabase) = (r2v4 android.database.sqlite.SQLiteDatabase), (r2v6 android.database.sqlite.SQLiteDatabase) binds: [B:28:0x0087, B:35:0x00a3] A[DONT_GENERATE, DONT_INLINE]
      0x0089: PHI (r5v3 org.json.JSONObject) = (r5v2 org.json.JSONObject), (r5v5 org.json.JSONObject) binds: [B:28:0x0087, B:35:0x00a3] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject g() {
        SQLiteDatabase sQLiteDatabaseA;
        JSONObject jSONObject;
        Cursor cursor = null;
        jSONObject = null;
        jSONObject = null;
        jSONObject = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        Cursor cursor2 = null;
        if (this.i.isEmpty()) {
            return null;
        }
        try {
            sQLiteDatabaseA = i.a(d).a();
            try {
                sQLiteDatabaseA.beginTransaction();
                Cursor cursorA = a(g.d.f10953a, sQLiteDatabaseA, null, "__ii=? ", new String[]{this.i.get(0)}, null, null, null, null);
                if (cursorA != null) {
                    try {
                        if (cursorA.moveToNext()) {
                            jSONObject = new JSONObject();
                            try {
                                String string = cursorA.getString(cursorA.getColumnIndex("__av"));
                                String string2 = cursorA.getString(cursorA.getColumnIndex("__vc"));
                                jSONObject.put("__av", string);
                                jSONObject.put("__vc", string2);
                                jSONObject2 = jSONObject;
                            } catch (SQLiteDatabaseCorruptException unused) {
                                cursor2 = cursorA;
                                try {
                                    j.a(d);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabaseA != null) {
                                        try {
                                            sQLiteDatabaseA.endTransaction();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    i.a(d).b();
                                    return jSONObject;
                                } catch (Throwable th) {
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabaseA != null) {
                                        try {
                                            sQLiteDatabaseA.endTransaction();
                                        } catch (Throwable unused3) {
                                        }
                                    }
                                    i.a(d).b();
                                    throw th;
                                }
                            } catch (Throwable unused4) {
                                cursor = cursorA;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabaseA != null) {
                                }
                                i.a(d).b();
                                return jSONObject;
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException unused5) {
                        jSONObject = jSONObject2;
                    } catch (Throwable unused6) {
                        jSONObject = jSONObject2;
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                if (cursorA != null) {
                    cursorA.close();
                }
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused7) {
                }
                i.a(d).b();
                return jSONObject2;
            } catch (SQLiteDatabaseCorruptException unused8) {
                jSONObject = null;
            } catch (Throwable unused9) {
                jSONObject = null;
            }
        } catch (SQLiteDatabaseCorruptException unused10) {
            sQLiteDatabaseA = null;
            jSONObject = null;
        } catch (Throwable unused11) {
            sQLiteDatabaseA = null;
            jSONObject = null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(4:29|3|(3:5|(2:8|6)|32)|9)|27|12|13|17|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h() {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                if (this.j.size() > 0) {
                    for (int i = 0; i < this.j.size(); i++) {
                        sQLiteDatabaseA.delete(g.b.f10947a, "rowid=?", new String[]{String.valueOf(this.j.get(i).intValue())});
                    }
                }
                this.j.clear();
                sQLiteDatabaseA.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            j.a(d);
            if (sQLiteDatabaseA != null) {
            }
        } catch (Throwable unused3) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(2:23|3)|21|6|7|11|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i() {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                sQLiteDatabaseA.execSQL("delete from __er");
                sQLiteDatabaseA.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            j.a(d);
            if (sQLiteDatabaseA != null) {
            }
        } catch (Throwable unused3) {
        }
    }

    public void j() {
        SQLiteDatabase sQLiteDatabaseA;
        if (!TextUtils.isEmpty(this.k)) {
            try {
                sQLiteDatabaseA = i.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    sQLiteDatabaseA.delete(g.a.f10944a, "__i=?", new String[]{this.k});
                    sQLiteDatabaseA.delete(g.b.f10947a, "__i=?", new String[]{this.k});
                    sQLiteDatabaseA.setTransactionSuccessful();
                } catch (SQLiteDatabaseCorruptException unused) {
                    try {
                        j.a(d);
                        if (sQLiteDatabaseA != null) {
                        }
                        this.k = null;
                    } finally {
                        if (sQLiteDatabaseA != null) {
                            try {
                                sQLiteDatabaseA.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        i.a(d).b();
                    }
                } catch (Throwable unused3) {
                    this.k = null;
                }
            } catch (SQLiteDatabaseCorruptException unused4) {
                sQLiteDatabaseA = null;
            } catch (Throwable unused5) {
                sQLiteDatabaseA = null;
            }
        }
        this.k = null;
    }

    private k() {
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = null;
        this.l = new ArrayList();
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long jLongValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__pp");
            String strC = "";
            String strC2 = (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) ? "" : c(jSONObjectOptJSONObject.toString());
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                strC = c(jSONObjectOptJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(jLongValue));
            contentValues.put("__sp", strC2);
            contentValues.put("__pp", strC);
            contentValues.put("__av", UMGlobalContext.getInstance(d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(d));
            sQLiteDatabase.insert(g.c.f10950a, null, contentValues);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        JSONObject jSONObject2;
        String str2;
        Cursor cursor2;
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(g.d.a.e);
            if (jSONObjectOptJSONObject != null) {
                jSONObject2 = jSONObjectOptJSONObject;
                Cursor cursorA = a(g.d.f10953a, sQLiteDatabase, new String[]{g.d.a.e}, "__ii=? ", new String[]{str}, null, null, null, null);
                if (cursorA != null) {
                    String strD = null;
                    while (cursorA.moveToNext()) {
                        try {
                            strD = d(cursorA.getString(cursorA.getColumnIndex(g.d.a.e)));
                        } catch (Throwable unused) {
                            cursor = cursorA;
                            if (cursor == null) {
                            }
                        }
                    }
                    String str3 = strD;
                    cursor2 = cursorA;
                    str2 = str3;
                } else {
                    cursor2 = cursorA;
                    str2 = null;
                }
            } else {
                jSONObject2 = jSONObjectOptJSONObject;
                str2 = null;
                cursor2 = null;
            }
            if (jSONObject2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONArray = new JSONArray(str2);
                    }
                    jSONArray.put(jSONObject2);
                    String strC = c(jSONArray.toString());
                    if (!TextUtils.isEmpty(strC)) {
                        sQLiteDatabase.execSQL("update  __sd set __d=\"" + strC + "\" where __ii=\"" + str + "\"");
                    }
                } catch (Throwable unused2) {
                    cursor = cursor2;
                    if (cursor == null) {
                        cursor.close();
                        return;
                    }
                    return;
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(g.d.a.d);
            if (jSONObjectOptJSONObject2 != null) {
                String strC2 = c(jSONObjectOptJSONObject2.toString());
                if (!TextUtils.isEmpty(strC2)) {
                    sQLiteDatabase.execSQL("update  __sd set __c=\"" + strC2 + "\" where __ii=\"" + str + "\"");
                }
            }
            sQLiteDatabase.execSQL("update  __sd set __f=\"" + String.valueOf(jSONObject.optLong(g.d.a.g)) + "\" where __ii=\"" + str + "\"");
            if (cursor2 != null) {
                cursor2.close();
            }
        } catch (Throwable unused3) {
            cursor = null;
        }
    }

    private Cursor a(String str, SQLiteDatabase sQLiteDatabase, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            if (sQLiteDatabase.isOpen()) {
                return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a() {
        this.i.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0098, code lost:
    
        if (r2 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009a, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ac, code lost:
    
        if (r2 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(JSONArray jSONArray) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseA = i.a(d).a();
                try {
                    try {
                        sQLiteDatabaseA.beginTransaction();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                ContentValues contentValues = new ContentValues();
                                String strOptString = jSONObject.optString("__i");
                                if (TextUtils.isEmpty(strOptString) || "-1".equals(strOptString)) {
                                    strOptString = w.a().b();
                                    if (TextUtils.isEmpty(strOptString)) {
                                        strOptString = "-1";
                                    }
                                }
                                contentValues.put("__i", strOptString);
                                contentValues.put("__e", jSONObject.optString("id"));
                                contentValues.put("__t", Integer.valueOf(jSONObject.optInt("__t")));
                                contentValues.put("__av", UMUtils.getAppVersionName(d));
                                contentValues.put("__vc", UMUtils.getAppVersionCode(d));
                                jSONObject.remove("__i");
                                jSONObject.remove("__t");
                                contentValues.put("__s", c(jSONObject.toString()));
                                sQLiteDatabaseA.insert(g.b.f10947a, null, contentValues);
                            } catch (Exception unused) {
                            }
                        }
                        sQLiteDatabaseA.setTransactionSuccessful();
                        sQLiteDatabaseA.endTransaction();
                    } catch (SQLiteDatabaseCorruptException unused2) {
                        sQLiteDatabase = sQLiteDatabaseA;
                        try {
                            j.a(d);
                        } catch (Throwable th) {
                            if (sQLiteDatabase != null) {
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (Throwable unused3) {
                                }
                            }
                            i.a(d).b();
                            throw th;
                        }
                    }
                } catch (Throwable unused4) {
                    sQLiteDatabase = sQLiteDatabaseA;
                }
            } catch (Throwable unused5) {
            }
        } catch (SQLiteDatabaseCorruptException unused6) {
        } catch (Throwable unused7) {
        }
        i.a(d).b();
    }

    public String d(String str) {
        try {
            return TextUtils.isEmpty(e) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), e.getBytes()));
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMStoreManager decrypt failed, return origin data.");
                    return str;
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return null;
        }
    }

    public JSONObject b(boolean z) {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z);
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0094 A[PHI: r0 r1
      0x0094: PHI (r0v4 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v3 android.database.Cursor), (r0v5 android.database.Cursor) binds: [B:26:0x0081, B:32:0x008f, B:33:0x0091] A[DONT_GENERATE, DONT_INLINE]
      0x0094: PHI (r1v5 android.database.sqlite.SQLiteDatabase) = 
      (r1v3 android.database.sqlite.SQLiteDatabase)
      (r1v4 android.database.sqlite.SQLiteDatabase)
      (r1v6 android.database.sqlite.SQLiteDatabase)
     binds: [B:26:0x0081, B:32:0x008f, B:33:0x0091] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(JSONObject jSONObject, String str) {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorA;
        Cursor cursor = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    if (!TextUtils.isEmpty(str)) {
                        cursorA = a(g.a.f10944a, sQLiteDatabaseA, null, "__i=? ", new String[]{str}, null, null, null, null);
                    } else {
                        cursorA = a(g.a.f10944a, sQLiteDatabaseA, null, null, null, null, null, null, null);
                    }
                    cursor = cursorA;
                    if (cursor != null) {
                        JSONArray jSONArray = new JSONArray();
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex("__a"));
                            if (!TextUtils.isEmpty(string)) {
                                jSONArray.put(new JSONObject(d(string)));
                            }
                        }
                        if (jSONArray.length() > 0) {
                            jSONObject.put("error", jSONArray);
                        }
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SQLiteDatabaseCorruptException unused) {
                    j.a(d);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabaseA != null) {
                    }
                    i.a(d).b();
                } catch (Throwable unused2) {
                    j.a(d);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabaseA != null) {
                    }
                    i.a(d).b();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused3) {
                    }
                }
                i.a(d).b();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused4) {
            sQLiteDatabaseA = null;
        } catch (Throwable unused5) {
            sQLiteDatabaseA = null;
        }
        try {
            sQLiteDatabaseA.endTransaction();
        } catch (Throwable unused6) {
        }
        i.a(d).b();
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0056, code lost:
    
        if (r0 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0058, code lost:
    
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006a, code lost:
    
        if (r0 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, String str2, int i) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseA = i.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("__i", str);
                    String strC = c(str2);
                    if (!TextUtils.isEmpty(strC)) {
                        contentValues.put("__a", strC);
                        contentValues.put("__t", Integer.valueOf(i));
                        contentValues.put("__av", UMUtils.getAppVersionName(d));
                        contentValues.put("__vc", UMUtils.getAppVersionCode(d));
                        sQLiteDatabaseA.insert(g.a.f10944a, null, contentValues);
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    sQLiteDatabaseA.endTransaction();
                } catch (SQLiteDatabaseCorruptException unused) {
                    sQLiteDatabase = sQLiteDatabaseA;
                    try {
                        j.a(d);
                    } catch (Throwable th) {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        i.a(d).b();
                        throw th;
                    }
                } catch (Throwable unused3) {
                    sQLiteDatabase = sQLiteDatabaseA;
                }
            } catch (Throwable unused4) {
            }
        } catch (SQLiteDatabaseCorruptException unused5) {
        } catch (Throwable unused6) {
        }
        i.a(d).b();
        return false;
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("duration") > 0) {
                jSONArray2.put(jSONObjectOptJSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e6 A[EXC_TOP_SPLITTER, PHI: r1 r13
      0x00e6: PHI (r1v4 android.database.sqlite.SQLiteDatabase) = (r1v3 android.database.sqlite.SQLiteDatabase), (r1v6 android.database.sqlite.SQLiteDatabase) binds: [B:37:0x00d5, B:43:0x00e4] A[DONT_GENERATE, DONT_INLINE]
      0x00e6: PHI (r13v5 ??) = (r13v4 ??), (r13v7 ??) binds: [B:37:0x00d5, B:43:0x00e4] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(JSONObject jSONObject, boolean z) {
        ?? r13;
        SQLiteDatabase sQLiteDatabaseA;
        ?? r0 = 0;
        String string = null;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        cursor = null;
        cursor = null;
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    Cursor cursorA = a(g.c.f10950a, sQLiteDatabaseA, null, null, null, null, null, null, null);
                    if (cursorA != null) {
                        try {
                            JSONArray jSONArray = new JSONArray();
                            while (cursorA.moveToNext()) {
                                JSONObject jSONObject2 = new JSONObject();
                                String string2 = cursorA.getString(cursorA.getColumnIndex("__e"));
                                string = cursorA.getString(cursorA.getColumnIndex("__ii"));
                                this.l.add(string);
                                String string3 = cursorA.getString(cursorA.getColumnIndex("__sp"));
                                String string4 = cursorA.getString(cursorA.getColumnIndex("__pp"));
                                if (!TextUtils.isEmpty(string3)) {
                                    jSONObject2.put(f.aA, new JSONObject(d(string3)));
                                }
                                if (!TextUtils.isEmpty(string4)) {
                                    jSONObject2.put(f.aB, new JSONObject(d(string4)));
                                }
                                if (!TextUtils.isEmpty(string2)) {
                                    jSONObject2.put("id", string);
                                    jSONObject2.put(f.p, string2);
                                    if (jSONObject2.length() > 0) {
                                        jSONArray.put(jSONObject2);
                                    }
                                    if (z) {
                                        break;
                                    }
                                }
                            }
                            r0 = string;
                            if (jSONArray.length() > 0) {
                                jSONObject.put(f.n, jSONArray);
                                r0 = string;
                            }
                        } catch (SQLiteDatabaseCorruptException unused) {
                            r13 = r0;
                            cursor = cursorA;
                            j.a(d);
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabaseA != null) {
                                try {
                                    sQLiteDatabaseA.endTransaction();
                                } catch (Throwable unused2) {
                                }
                            }
                            i.a(d).b();
                            r0 = r13;
                        } catch (Throwable unused3) {
                            r13 = r0;
                            cursor2 = cursorA;
                            j.a(d);
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            if (sQLiteDatabaseA != null) {
                            }
                            i.a(d).b();
                            r0 = r13;
                        }
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused4) {
                    }
                    i.a(d).b();
                } catch (SQLiteDatabaseCorruptException unused5) {
                    r13 = 0;
                } catch (Throwable unused6) {
                    r13 = 0;
                }
            } catch (Throwable th) {
                if (r0 != 0) {
                    r0.close();
                }
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused7) {
                    }
                }
                i.a(d).b();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused8) {
            r13 = 0;
            sQLiteDatabaseA = null;
        } catch (Throwable unused9) {
            r13 = 0;
            sQLiteDatabaseA = null;
        }
        return r0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0085, code lost:
    
        if (r2 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0099, code lost:
    
        if (r2 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, JSONObject jSONObject, a aVar) {
        if (jSONObject == null) {
            return false;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseA = i.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    if (aVar == a.BEGIN) {
                        long jLongValue = ((Long) jSONObject.opt("__e")).longValue();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("__ii", str);
                        contentValues.put("__e", String.valueOf(jLongValue));
                        contentValues.put("__av", UMUtils.getAppVersionName(d));
                        contentValues.put("__vc", UMUtils.getAppVersionCode(d));
                        sQLiteDatabaseA.insert(g.d.f10953a, null, contentValues);
                    } else if (aVar == a.INSTANTSESSIONBEGIN) {
                        b(str, jSONObject, sQLiteDatabaseA);
                    } else if (aVar == a.END) {
                        a(str, jSONObject, sQLiteDatabaseA);
                    } else if (aVar == a.PAGE) {
                        a(str, jSONObject, sQLiteDatabaseA, "__a");
                    } else if (aVar == a.AUTOPAGE) {
                        a(str, jSONObject, sQLiteDatabaseA, g.d.a.c);
                    } else if (aVar == a.NEWSESSION) {
                        c(str, jSONObject, sQLiteDatabaseA);
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    sQLiteDatabaseA.endTransaction();
                } catch (SQLiteDatabaseCorruptException unused) {
                    sQLiteDatabase = sQLiteDatabaseA;
                    try {
                        j.a(d);
                    } catch (Throwable th) {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        i.a(d).b();
                        throw th;
                    }
                } catch (Throwable unused3) {
                    sQLiteDatabase = sQLiteDatabaseA;
                }
            } catch (Throwable unused4) {
            }
        } catch (SQLiteDatabaseCorruptException unused5) {
        } catch (Throwable unused6) {
        }
        i.a(d).b();
        return false;
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long jLongValue = ((Long) jSONObject.opt(g.d.a.g)).longValue();
            Object objOpt = jSONObject.opt(g.d.a.h);
            long jLongValue2 = (objOpt == null || !(objOpt instanceof Long)) ? 0L : ((Long) objOpt).longValue();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__pp");
            String strC = "";
            String strC2 = (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) ? "" : c(jSONObjectOptJSONObject.toString());
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                strC = c(jSONObjectOptJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + jLongValue + "\", " + g.d.a.h + "=\"" + jLongValue2 + "\", __sp=\"" + strC2 + "\", __pp=\"" + strC + "\" where __ii=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(4:33|3|(1:(1:6))(2:7|(3:9|(2:12|10)|36))|13)|31|16|17|21|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(boolean z, boolean z2) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                if (z2) {
                    if (z) {
                        sQLiteDatabaseA.execSQL("delete from __sd");
                    }
                } else if (this.i.size() > 0) {
                    for (int i = 0; i < this.i.size(); i++) {
                        sQLiteDatabaseA.delete(g.d.f10953a, "__ii=?", new String[]{this.i.get(i)});
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            j.a(d);
            if (sQLiteDatabaseA != null) {
            }
        } catch (Throwable unused3) {
        }
    }

    public long a(String str) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorA = null;
        long j = 0;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
            } catch (Exception unused) {
            }
            try {
                sQLiteDatabaseA.beginTransaction();
                cursorA = a(g.d.f10953a, sQLiteDatabaseA, new String[]{g.d.a.g}, "__ii=? ", new String[]{str}, null, null, null, null);
                if (cursorA != null) {
                    cursorA.moveToFirst();
                    j = cursorA.getLong(cursorA.getColumnIndex(g.d.a.g));
                }
                if (cursorA != null) {
                    cursorA.close();
                }
            } catch (Exception unused2) {
                if (cursorA != null) {
                    cursorA.close();
                }
                if (sQLiteDatabaseA != null) {
                }
                i.a(d).b();
                return j;
            } catch (Throwable th) {
                th = th;
                if (cursorA != null) {
                    try {
                        cursorA.close();
                    } catch (Exception unused3) {
                        i.a(d).b();
                        throw th;
                    }
                }
                if (sQLiteDatabaseA != null) {
                    sQLiteDatabaseA.endTransaction();
                }
                i.a(d).b();
                throw th;
            }
        } catch (Exception unused4) {
            sQLiteDatabaseA = null;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabaseA = null;
        }
        sQLiteDatabaseA.endTransaction();
        i.a(d).b();
        return j;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(4:26|3|(1:5)|6)|24|9|10|14|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(String str) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    sQLiteDatabaseA.delete(g.c.f10950a, "__ii=?", new String[]{str});
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            j.a(d);
            if (sQLiteDatabaseA != null) {
            }
        } catch (Throwable unused3) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0071 A[Catch: all -> 0x0062, TryCatch #0 {all -> 0x0062, blocks: (B:22:0x004f, B:24:0x0055, B:26:0x0066, B:28:0x0071, B:29:0x0076, B:36:0x0085, B:38:0x008b, B:40:0x0091, B:42:0x0097, B:44:0x00a5, B:41:0x0094), top: B:52:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x004f A[EXC_TOP_SPLITTER, LOOP:1: B:52:0x004f->B:24:0x0055, LOOP_START, PHI: r13
      0x004f: PHI (r13v2 java.lang.String) = (r13v7 java.lang.String), (r13v3 java.lang.String) binds: [B:21:0x004d, B:24:0x0055] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @SuppressLint({HttpHeaders.RANGE})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase, String str2) throws JSONException {
        JSONArray jSONArray;
        JSONArray jSONArrayOptJSONArray;
        Cursor cursorA;
        JSONArray jSONArray2;
        Cursor cursor = null;
        strD = null;
        String strD = null;
        try {
            if ("__a".equals(str2)) {
                jSONArrayOptJSONArray = jSONObject.optJSONArray("__a");
                if (jSONArrayOptJSONArray == null) {
                    return;
                }
                if (jSONArrayOptJSONArray.length() <= 0) {
                    return;
                }
            } else if (g.d.a.c.equals(str2)) {
                jSONArrayOptJSONArray = jSONObject.optJSONArray(g.d.a.c);
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                    return;
                }
            } else {
                jSONArray = null;
                cursorA = a(g.d.f10953a, sQLiteDatabase, new String[]{str2}, "__ii=? ", new String[]{str}, null, null, null, null);
                if (cursorA != null) {
                    while (cursorA.moveToNext()) {
                        try {
                            strD = d(cursorA.getString(cursorA.getColumnIndex(str2)));
                        } catch (Throwable unused) {
                            cursor = cursorA;
                            if (cursor != null) {
                                cursor.close();
                                return;
                            }
                            return;
                        }
                    }
                }
                jSONArray2 = new JSONArray();
                if (!TextUtils.isEmpty(strD)) {
                    jSONArray2 = new JSONArray(strD);
                }
                if (jSONArray2.length() <= 1000) {
                    if (cursorA != null) {
                        cursorA.close();
                        return;
                    }
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            jSONArray2.put(jSONObject2);
                        }
                    } catch (JSONException unused2) {
                    }
                }
                String strC = c(jSONArray2.toString());
                if (!TextUtils.isEmpty(strC)) {
                    sQLiteDatabase.execSQL("update __sd set " + str2 + "=\"" + strC + "\" where __ii=\"" + str + "\"");
                }
                if (cursorA != null) {
                    cursorA.close();
                    return;
                }
                return;
            }
            jSONArray = jSONArrayOptJSONArray;
            cursorA = a(g.d.f10953a, sQLiteDatabase, new String[]{str2}, "__ii=? ", new String[]{str}, null, null, null, null);
            if (cursorA != null) {
            }
            jSONArray2 = new JSONArray();
            if (!TextUtils.isEmpty(strD)) {
            }
            if (jSONArray2.length() <= 1000) {
            }
        } catch (Throwable unused3) {
        }
    }

    public JSONObject a(boolean z) {
        a();
        this.j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            a(jSONObject, z);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
        } else {
            String strA = a(jSONObject, z);
            if (!TextUtils.isEmpty(strA)) {
                b(jSONObject, strA);
                a(jSONObject, strA);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|(2:94|3)|(7:97|4|(1:6)(1:7)|8|(7:10|(6:13|(2:17|(2:107|19)(2:114|108))(1:106)|20|(3:105|22|(5:103|27|(1:29)(1:30)|31|112))(3:100|32|(5:104|34|(1:36)(1:37)|38|110)(1:109))|108|11)|99|39|(5:41|(4:44|(3:116|46|119)(1:118)|117|42)|115|47|(1:49))|50|(5:52|(4:55|(3:121|57|124)(1:123)|122|53)|120|58|(1:60)))|61|(1:63))|89|75|93|76|77|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0192 A[PHI: r0 r1
      0x0192: PHI (r0v4 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v3 android.database.Cursor), (r0v5 android.database.Cursor) binds: [B:68:0x017f, B:74:0x018d, B:75:0x018f] A[DONT_GENERATE, DONT_INLINE]
      0x0192: PHI (r1v5 android.database.sqlite.SQLiteDatabase) = 
      (r1v3 android.database.sqlite.SQLiteDatabase)
      (r1v4 android.database.sqlite.SQLiteDatabase)
      (r1v6 android.database.sqlite.SQLiteDatabase)
     binds: [B:68:0x017f, B:74:0x018d, B:75:0x018f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(JSONObject jSONObject, String str) {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorA;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Cursor cursor = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(d).b();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            sQLiteDatabaseA = null;
        } catch (Throwable unused3) {
            sQLiteDatabaseA = null;
        }
        try {
            sQLiteDatabaseA.beginTransaction();
            if (!TextUtils.isEmpty(str)) {
                cursorA = a(g.b.f10947a, sQLiteDatabaseA, null, "__i=? ", new String[]{str}, null, null, null, null);
            } else {
                cursorA = a(g.b.f10947a, sQLiteDatabaseA, null, null, null, null, null, null, null);
            }
            cursor = cursorA;
            if (cursor != null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                String strB = w.a().b();
                while (cursor.moveToNext()) {
                    int i = cursor.getInt(cursor.getColumnIndex("__t"));
                    String string = cursor.getString(cursor.getColumnIndex("__i"));
                    String string2 = cursor.getString(cursor.getColumnIndex("__s"));
                    if (TextUtils.isEmpty(string) || "-1".equals(string)) {
                        if (!TextUtils.isEmpty(strB)) {
                            string = strB;
                        }
                    }
                    this.j.add(Integer.valueOf(cursor.getInt(0)));
                    if (i != 2049) {
                        if (i == 2050 && !TextUtils.isEmpty(string2)) {
                            JSONObject jSONObject4 = new JSONObject(d(string2));
                            if (jSONObject3.has(string)) {
                                jSONArray = jSONObject3.optJSONArray(string);
                            } else {
                                jSONArray = new JSONArray();
                            }
                            jSONArray.put(jSONObject4);
                            jSONObject3.put(string, jSONArray);
                        }
                    } else if (!TextUtils.isEmpty(string2)) {
                        JSONObject jSONObject5 = new JSONObject(d(string2));
                        if (jSONObject2.has(string)) {
                            jSONArray2 = jSONObject2.optJSONArray(string);
                        } else {
                            jSONArray2 = new JSONArray();
                        }
                        jSONArray2.put(jSONObject5);
                        jSONObject2.put(string, jSONArray2);
                    }
                }
                if (jSONObject2.length() > 0) {
                    JSONArray jSONArray3 = new JSONArray();
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        JSONObject jSONObject6 = new JSONObject();
                        String next = itKeys.next();
                        jSONObject6.put(next, new JSONArray(jSONObject2.optString(next)));
                        if (jSONObject6.length() > 0) {
                            jSONArray3.put(jSONObject6);
                        }
                    }
                    if (jSONArray3.length() > 0) {
                        jSONObject.put("ekv", jSONArray3);
                    }
                }
                if (jSONObject3.length() > 0) {
                    JSONArray jSONArray4 = new JSONArray();
                    Iterator<String> itKeys2 = jSONObject3.keys();
                    while (itKeys2.hasNext()) {
                        JSONObject jSONObject7 = new JSONObject();
                        String next2 = itKeys2.next();
                        jSONObject7.put(next2, new JSONArray(jSONObject3.optString(next2)));
                        if (jSONObject7.length() > 0) {
                            jSONArray4.put(jSONObject7);
                        }
                    }
                    if (jSONArray4.length() > 0) {
                        jSONObject.put(f.Z, jSONArray4);
                    }
                }
            }
            sQLiteDatabaseA.setTransactionSuccessful();
            if (cursor != null) {
                cursor.close();
            }
        } catch (SQLiteDatabaseCorruptException unused4) {
            j.a(d);
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabaseA != null) {
            }
            i.a(d).b();
        } catch (Throwable unused5) {
            j.a(d);
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabaseA != null) {
            }
            i.a(d).b();
        }
        sQLiteDatabaseA.endTransaction();
        i.a(d).b();
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0230 A[EXC_TOP_SPLITTER, PHI: r0 r12 r14
      0x0230: PHI (r0v6 java.lang.String) = (r0v2 java.lang.String), (r0v3 java.lang.String), (r0v39 java.lang.String), (r0v39 java.lang.String) binds: [B:91:0x021f, B:97:0x022e, B:83:0x0209, B:84:0x020b] A[DONT_GENERATE, DONT_INLINE]
      0x0230: PHI (r12v6 android.database.sqlite.SQLiteDatabase) = 
      (r12v3 android.database.sqlite.SQLiteDatabase)
      (r12v4 android.database.sqlite.SQLiteDatabase)
      (r12v7 android.database.sqlite.SQLiteDatabase)
      (r12v7 android.database.sqlite.SQLiteDatabase)
     binds: [B:91:0x021f, B:97:0x022e, B:83:0x0209, B:84:0x020b] A[DONT_GENERATE, DONT_INLINE]
      0x0230: PHI (r14v6 android.database.Cursor) = 
      (r14v3 android.database.Cursor)
      (r14v4 android.database.Cursor)
      (r14v33 android.database.Cursor)
      (r14v33 android.database.Cursor)
     binds: [B:91:0x021f, B:97:0x022e, B:83:0x0209, B:84:0x020b] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0233 A[PHI: r0 r12 r14
      0x0233: PHI (r0v5 java.lang.String) = (r0v2 java.lang.String), (r0v3 java.lang.String), (r0v6 java.lang.String) binds: [B:91:0x021f, B:97:0x022e, B:98:0x0230] A[DONT_GENERATE, DONT_INLINE]
      0x0233: PHI (r12v5 android.database.sqlite.SQLiteDatabase) = 
      (r12v3 android.database.sqlite.SQLiteDatabase)
      (r12v4 android.database.sqlite.SQLiteDatabase)
      (r12v6 android.database.sqlite.SQLiteDatabase)
     binds: [B:91:0x021f, B:97:0x022e, B:98:0x0230] A[DONT_GENERATE, DONT_INLINE]
      0x0233: PHI (r14v5 android.database.Cursor) = (r14v3 android.database.Cursor), (r14v4 android.database.Cursor), (r14v6 android.database.Cursor) binds: [B:91:0x021f, B:97:0x022e, B:98:0x0230] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x022b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(JSONObject jSONObject, boolean z) {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursor;
        JSONArray jSONArray;
        String str;
        JSONArray jSONArray2;
        String string = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    Cursor cursorA = a(g.d.f10953a, sQLiteDatabaseA, null, null, null, null, null, null, null);
                    if (cursorA != null) {
                        try {
                            JSONArray jSONArray3 = new JSONArray();
                            while (true) {
                                if (!cursorA.moveToNext()) {
                                    cursor = cursorA;
                                    jSONArray = jSONArray3;
                                    break;
                                }
                                JSONObject jSONObject2 = new JSONObject();
                                String string2 = cursorA.getString(cursorA.getColumnIndex(g.d.a.g));
                                String string3 = cursorA.getString(cursorA.getColumnIndex("__e"));
                                String string4 = cursorA.getString(cursorA.getColumnIndex(g.d.a.h));
                                string = cursorA.getString(cursorA.getColumnIndex("__ii"));
                                try {
                                    if (TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                                        str = string;
                                        cursor = cursorA;
                                        jSONArray = jSONArray3;
                                    } else {
                                        if (Long.parseLong(string2) - Long.parseLong(string3) > 0) {
                                            String string5 = cursorA.getString(cursorA.getColumnIndex("__a"));
                                            String string6 = cursorA.getString(cursorA.getColumnIndex(g.d.a.c));
                                            String string7 = cursorA.getString(cursorA.getColumnIndex(g.d.a.d));
                                            String string8 = cursorA.getString(cursorA.getColumnIndex(g.d.a.e));
                                            this.i.add(string);
                                            String string9 = cursorA.getString(cursorA.getColumnIndex("__sp"));
                                            String string10 = cursorA.getString(cursorA.getColumnIndex("__pp"));
                                            jSONObject2.put("id", string);
                                            jSONObject2.put(f.p, string3);
                                            jSONObject2.put(f.q, string2);
                                            str = string;
                                            if (!FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                                                cursor = cursorA;
                                                jSONArray2 = jSONArray3;
                                                jSONObject2.put("duration", Long.parseLong(string2) - Long.parseLong(string3));
                                            } else {
                                                try {
                                                    if (Long.parseLong(string4) <= 0) {
                                                        jSONObject2.put("duration", Long.parseLong(string2) - Long.parseLong(string3));
                                                        cursor = cursorA;
                                                        jSONArray2 = jSONArray3;
                                                    } else {
                                                        cursor = cursorA;
                                                        jSONArray2 = jSONArray3;
                                                        jSONObject2.put("duration", Long.parseLong(string4));
                                                        jSONObject2.put(f.s, Long.parseLong(string2) - Long.parseLong(string3));
                                                    }
                                                } catch (SQLiteDatabaseCorruptException unused) {
                                                    cursor = cursorA;
                                                    string = str;
                                                    j.a(d);
                                                    if (cursor != null) {
                                                    }
                                                    if (sQLiteDatabaseA == null) {
                                                    }
                                                    i.a(d).b();
                                                    return string;
                                                } catch (Throwable unused2) {
                                                    cursor = cursorA;
                                                    string = str;
                                                    j.a(d);
                                                    if (cursor != null) {
                                                    }
                                                    if (sQLiteDatabaseA == null) {
                                                    }
                                                    i.a(d).b();
                                                    return string;
                                                }
                                            }
                                            if (!TextUtils.isEmpty(string5)) {
                                                try {
                                                    jSONObject2.put(f.t, new JSONArray(d(string5)));
                                                } catch (SQLiteDatabaseCorruptException unused3) {
                                                    string = str;
                                                    j.a(d);
                                                    if (cursor != null) {
                                                    }
                                                    if (sQLiteDatabaseA == null) {
                                                    }
                                                    i.a(d).b();
                                                    return string;
                                                } catch (Throwable unused4) {
                                                    string = str;
                                                    j.a(d);
                                                    if (cursor != null) {
                                                    }
                                                    if (sQLiteDatabaseA == null) {
                                                    }
                                                    i.a(d).b();
                                                    return string;
                                                }
                                            }
                                            boolean z2 = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO;
                                            if (!TextUtils.isEmpty(string6) && z2) {
                                                JSONArray jSONArray4 = new JSONArray(d(string6));
                                                JSONArray jSONArray5 = new JSONArray();
                                                if (jSONArray4.length() > 0) {
                                                    jSONArray5 = b(jSONArray4);
                                                }
                                                jSONObject2.put(f.u, jSONArray5);
                                            }
                                            if (!TextUtils.isEmpty(string7)) {
                                                jSONObject2.put(f.F, new JSONObject(d(string7)));
                                            }
                                            if (!TextUtils.isEmpty(string8)) {
                                                jSONObject2.put(f.B, new JSONArray(d(string8)));
                                            }
                                            if (!TextUtils.isEmpty(string9)) {
                                                jSONObject2.put(f.aA, new JSONObject(d(string9)));
                                            }
                                            if (!TextUtils.isEmpty(string10)) {
                                                jSONObject2.put(f.aB, new JSONObject(d(string10)));
                                            }
                                            if (jSONObject2.length() > 0) {
                                                jSONArray = jSONArray2;
                                                jSONArray.put(jSONObject2);
                                            } else {
                                                jSONArray = jSONArray2;
                                            }
                                        } else {
                                            str = string;
                                            cursor = cursorA;
                                            jSONArray = jSONArray3;
                                        }
                                        if (z) {
                                            string = str;
                                            break;
                                        }
                                    }
                                    jSONArray3 = jSONArray;
                                    cursorA = cursor;
                                    string = str;
                                } catch (SQLiteDatabaseCorruptException unused5) {
                                    cursor = cursorA;
                                    j.a(d);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (sQLiteDatabaseA == null) {
                                        sQLiteDatabaseA.endTransaction();
                                    }
                                    i.a(d).b();
                                    return string;
                                } catch (Throwable unused6) {
                                    cursor = cursorA;
                                    j.a(d);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (sQLiteDatabaseA == null) {
                                    }
                                    i.a(d).b();
                                    return string;
                                }
                            }
                        } catch (SQLiteDatabaseCorruptException unused7) {
                        } catch (Throwable unused8) {
                        }
                        try {
                            if (this.i.size() < 1) {
                                cursor.close();
                                try {
                                    sQLiteDatabaseA.endTransaction();
                                } catch (Throwable unused9) {
                                }
                                i.a(d).b();
                                return string;
                            }
                            if (jSONArray.length() > 0) {
                                jSONObject.put(f.n, jSONArray);
                            }
                        } catch (SQLiteDatabaseCorruptException unused10) {
                            j.a(d);
                            if (cursor != null) {
                            }
                            if (sQLiteDatabaseA == null) {
                            }
                            i.a(d).b();
                            return string;
                        } catch (Throwable unused11) {
                            j.a(d);
                            if (cursor != null) {
                            }
                            if (sQLiteDatabaseA == null) {
                            }
                            i.a(d).b();
                            return string;
                        }
                    } else {
                        cursor = cursorA;
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SQLiteDatabaseCorruptException unused12) {
                    cursor = null;
                } catch (Throwable unused13) {
                    cursor = null;
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused14) {
                    }
                }
                i.a(d).b();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused15) {
            sQLiteDatabaseA = null;
            cursor = null;
        } catch (Throwable unused16) {
            sQLiteDatabaseA = null;
            cursor = null;
        }
        try {
            sQLiteDatabaseA.endTransaction();
        } catch (Throwable unused17) {
        }
        i.a(d).b();
        return string;
    }

    public void a(boolean z, boolean z2) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                try {
                    sQLiteDatabaseA = i.a(d).a();
                    sQLiteDatabaseA.beginTransaction();
                    if (!z2) {
                        int size = this.l.size();
                        int i = 0;
                        if (size > 0) {
                            int i2 = 0;
                            while (i < size) {
                                String str = this.l.get(i);
                                if (str == null) {
                                    i2 = 1;
                                }
                                sQLiteDatabaseA.delete(g.c.f10950a, "__ii=?", new String[]{str});
                                i++;
                            }
                            i = i2;
                        }
                        if (i != 0) {
                            sQLiteDatabaseA.execSQL("delete from __is where __ii is null");
                        }
                    } else if (z) {
                        sQLiteDatabaseA.execSQL("delete from __is");
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                } catch (Throwable unused) {
                    j.a(d);
                    if (sQLiteDatabaseA != null) {
                    }
                    i.a(d).b();
                }
            } catch (SQLiteDatabaseCorruptException unused2) {
                j.a(d);
                if (sQLiteDatabaseA != null) {
                }
                i.a(d).b();
            }
            try {
                sQLiteDatabaseA.endTransaction();
            } catch (Throwable unused3) {
            }
            i.a(d).b();
        } catch (Throwable th) {
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused4) {
                }
            }
            i.a(d).b();
            throw th;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(4:26|3|(1:5)|6)|22|9|10|14|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, String str) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    sQLiteDatabaseA.delete(g.a.f10944a, "__i=?", new String[]{str});
                    sQLiteDatabaseA.delete(g.b.f10947a, "__i=?", new String[]{str});
                    this.j.clear();
                    sQLiteDatabaseA.delete(g.d.f10953a, "__ii=?", new String[]{str});
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            j.a(d);
            if (sQLiteDatabaseA != null) {
            }
        } catch (Throwable unused3) {
        }
    }
}
