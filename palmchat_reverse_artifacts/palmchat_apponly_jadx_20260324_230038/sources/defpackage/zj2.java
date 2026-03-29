package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class zj2 {
    /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|(2:69|3)|(9:57|5|60|(8:7|8|63|9|67|10|11|12)(2:19|(5:21|22|54|23|12)(1:27))|43|65|44|48|49)(1:30)|(1:32)|33|59|43|65|44|48|49|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bd, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00be, code lost:
    
        r9.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00dd  */
    /* JADX WARN: Type inference failed for: r10v10, types: [int] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) throws Throwable {
        Cursor cursorQuery;
        Throwable th;
        ?? string;
        ?? string2;
        ?? string3;
        ?? r3;
        ?? columnCount;
        int i;
        ?? r1;
        ?? r10;
        ?? r32;
        ?? string4;
        Uri uri = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
        ContentResolver contentResolver = context.getContentResolver();
        ?? r9 = 0;
        r9 = 0;
        r9 = 0;
         = 0;
        String string5 = null;
         = 0;
        ?? r92 = 0;
        int i2 = -1;
        try {
            cursorQuery = contentResolver.query(uri, null, null, new String[]{str}, null);
        } catch (Exception e) {
            e = e;
            string = 0;
            cursorQuery = null;
            string2 = 0;
        } catch (Throwable th2) {
            cursorQuery = null;
            th = th2;
            if (cursorQuery != null) {
            }
            throw th;
        }
        if (cursorQuery != null) {
            try {
                try {
                    cursorQuery.moveToFirst();
                    LogUtil.i("HwMarketInfoReader", "packageName=" + str);
                    columnCount = cursorQuery.getColumnCount();
                    i = 1;
                } catch (Exception e2) {
                    e = e2;
                    string = 0;
                    string2 = 0;
                    string3 = string2;
                    e.printStackTrace();
                    if (cursorQuery != null) {
                    }
                    r3 = string2;
                    ?? r8 = string;
                    columnCount = r9;
                    r92 = r8;
                    ?? jSONObject = new JSONObject();
                    jSONObject.put("version", i2);
                    jSONObject.put("referrer", r92);
                    jSONObject.put("enterAgTime", r3);
                    jSONObject.put("finishInstallTime", string3);
                    jSONObject.put("trackId", columnCount);
                    LogUtil.i("HwMarketInfoReader", "trackId=" + jSONObject);
                    return jSONObject.toString();
                }
                try {
                    if (columnCount > 4) {
                        string = cursorQuery.getString(0);
                        string2 = cursorQuery.getString(1);
                        try {
                            string3 = cursorQuery.getString(2);
                        } catch (Exception e3) {
                            e = e3;
                            string3 = 0;
                        }
                        try {
                            string5 = cursorQuery.getString(4);
                            r32 = string2;
                            string4 = string3;
                            i = 2;
                            r10 = string;
                            ?? r82 = r10;
                            columnCount = string5;
                            r92 = r82;
                            r1 = string4;
                            r3 = r32;
                        } catch (Exception e4) {
                            e = e4;
                            e.printStackTrace();
                            if (cursorQuery != null) {
                            }
                            r3 = string2;
                            ?? r83 = string;
                            columnCount = r9;
                            r92 = r83;
                        }
                    } else if (cursorQuery.getColumnCount() > 2) {
                        string = cursorQuery.getString(0);
                        String string6 = cursorQuery.getString(1);
                        try {
                            string4 = cursorQuery.getString(2);
                            r32 = string6;
                            r10 = string;
                            ?? r822 = r10;
                            columnCount = string5;
                            r92 = r822;
                            r1 = string4;
                            r3 = r32;
                        } catch (Exception e5) {
                            string3 = 0;
                            string2 = string6;
                            e = e5;
                            e.printStackTrace();
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            r3 = string2;
                            ?? r832 = string;
                            columnCount = r9;
                            r92 = r832;
                        }
                    } else {
                        columnCount = 0;
                        r1 = 0;
                        r3 = 0;
                        i = 0;
                    }
                } catch (Exception e6) {
                    e = e6;
                    string2 = r92;
                    r9 = r92;
                    string = columnCount;
                    string3 = string2;
                    e.printStackTrace();
                    if (cursorQuery != null) {
                    }
                    r3 = string2;
                    ?? r8322 = string;
                    columnCount = r9;
                    r92 = r8322;
                    ?? jSONObject2 = new JSONObject();
                    jSONObject2.put("version", i2);
                    jSONObject2.put("referrer", r92);
                    jSONObject2.put("enterAgTime", r3);
                    jSONObject2.put("finishInstallTime", string3);
                    jSONObject2.put("trackId", columnCount);
                    LogUtil.i("HwMarketInfoReader", "trackId=" + jSONObject2);
                    return jSONObject2.toString();
                }
                ?? jSONObject22 = new JSONObject();
                jSONObject22.put("version", i2);
                jSONObject22.put("referrer", r92);
                jSONObject22.put("enterAgTime", r3);
                jSONObject22.put("finishInstallTime", string3);
                jSONObject22.put("trackId", columnCount);
                LogUtil.i("HwMarketInfoReader", "trackId=" + jSONObject22);
                return jSONObject22.toString();
            } catch (Throwable th3) {
                th = th3;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        }
        columnCount = 0;
        r1 = 0;
        r3 = 0;
        i = -1;
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        string3 = r1;
        i2 = i;
        ?? jSONObject222 = new JSONObject();
        jSONObject222.put("version", i2);
        jSONObject222.put("referrer", r92);
        jSONObject222.put("enterAgTime", r3);
        jSONObject222.put("finishInstallTime", string3);
        jSONObject222.put("trackId", columnCount);
        LogUtil.i("HwMarketInfoReader", "trackId=" + jSONObject222);
        return jSONObject222.toString();
    }
}
