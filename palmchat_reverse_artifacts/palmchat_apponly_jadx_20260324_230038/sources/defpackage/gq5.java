package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class gq5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f17772a = "gq5";

    public static boolean a(String str, long j) {
        boolean z;
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(hq5.f18030a, null, "resource_type=? ", new String[]{str}, null);
        if (cursorQuery != null) {
            z = false;
            if (cursorQuery.moveToNext() && (cursorQuery.getLong(cursorQuery.getColumnIndex("resource_version")) + 1 == j || j <= 0)) {
                z = true;
            }
            cursorQuery.close();
        } else {
            z = true;
        }
        LogUtil.i(f17772a, "updateSyncKeysOnSendSuccess syncKey=" + str + "version=" + j + "result=" + z, 1);
        return z;
    }

    public static int b(String str, long j) {
        LogUtil.i(f17772a, "updateSyncKeysOnSendSuccess syncKey=" + str + "version=" + j, 1);
        ContentValues contentValues = new ContentValues();
        contentValues.put("resource_type", str);
        contentValues.put("resource_version", Long.valueOf(j));
        AppContext.getContext().getContentResolver().bulkInsert(hq5.f18030a, new ContentValues[]{contentValues});
        return 0;
    }
}
