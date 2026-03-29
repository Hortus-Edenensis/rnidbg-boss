package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class z57 extends d57 {
    public z57(Context context) {
        super(context);
        this.f16980a = "EncryptEventDataManager";
    }

    @Override // defpackage.d57
    public int b(Uri uri, JSONObject jSONObject, boolean z) {
        try {
            if (a(uri) != 0) {
                return -2;
            }
            ContentValues contentValues = new ContentValues();
            String string = jSONObject.toString();
            String strQ = e67.q(16);
            String strQ2 = e67.q(16);
            contentValues.put("data", new String(i57.c(e67.t(strQ, strQ2, string.getBytes()), 0)).replaceAll("[\\s*\t\n\r]", ""));
            contentValues.put("delay", Boolean.valueOf(z));
            contentValues.put("created_time", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("aeskey", strQ);
            contentValues.put("aesiv", strQ2);
            this.b.insert(uri, contentValues);
        } catch (Throwable th) {
            g57.b(this.f16980a, th.getMessage());
        }
        return 0;
    }

    @Override // defpackage.d57
    public void c(Uri uri, String str) {
        super.c(uri, str);
    }

    @Override // defpackage.d57
    public void d(Uri uri, String[] strArr) {
        super.d(uri, strArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d2 A[PHI: r11 r12 r13
      0x00d2: PHI (r11v3 android.database.Cursor) = (r11v2 android.database.Cursor), (r11v6 android.database.Cursor) binds: [B:43:0x00d0, B:35:0x00c4] A[DONT_GENERATE, DONT_INLINE]
      0x00d2: PHI (r12v7 java.lang.String) = (r12v6 java.lang.String), (r12v12 java.lang.String) binds: [B:43:0x00d0, B:35:0x00c4] A[DONT_GENERATE, DONT_INLINE]
      0x00d2: PHI (r13v2 java.lang.String) = (r13v1 java.lang.String), (r13v9 java.lang.String) binds: [B:43:0x00d0, B:35:0x00c4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e7  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    @Override // defpackage.d57
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String[] e(Uri uri, int i, boolean z) throws Throwable {
        Cursor cursorQuery;
        String string;
        String string2;
        ?? r0 = 0;
        try {
            try {
                ContentResolver contentResolver = this.b;
                String[] strArr = new String[1];
                strArr[0] = z ? "1" : "0";
                cursorQuery = contentResolver.query(uri, null, "delay = ?", strArr, "created_time ASC LIMIT " + i);
                if (cursorQuery != null) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sb2 = new StringBuilder();
                        sb.append("[");
                        String str = ",";
                        String str2 = ",";
                        while (cursorQuery.moveToNext()) {
                            if (cursorQuery.isLast()) {
                                str2 = "]";
                                str = "";
                            }
                            try {
                                String string3 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_id"));
                                String string4 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("data"));
                                String string5 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("aeskey"));
                                String string6 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("aesiv"));
                                if (!TextUtils.isEmpty(string3)) {
                                    sb2.append(string3);
                                    sb2.append(str);
                                }
                                if (!TextUtils.isEmpty(string4)) {
                                    JSONObject jSONObject = new JSONObject(new String(e67.l(string5, string6, i57.a(string4, 0))));
                                    jSONObject.put("sequence", string3);
                                    jSONObject.put("flushTime", System.currentTimeMillis());
                                    sb.append(jSONObject);
                                    sb.append(str2);
                                }
                            } catch (Exception e) {
                                g57.a(e);
                            }
                        }
                        string2 = sb2.toString();
                        string = sb.toString();
                    } catch (SQLiteException e2) {
                        e = e2;
                        g57.a(e);
                        string = null;
                        string2 = null;
                        if (cursorQuery != null) {
                        }
                    }
                } else {
                    string = null;
                    string2 = null;
                }
            } catch (Throwable th) {
                th = th;
                r0 = uri;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r0 != 0) {
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (string2 == null || TextUtils.isEmpty(string2)) {
            return null;
        }
        return new String[]{string2, string};
    }
}
