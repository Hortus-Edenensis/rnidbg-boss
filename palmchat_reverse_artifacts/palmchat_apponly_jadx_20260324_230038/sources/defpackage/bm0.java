package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.lantern.core.configuration.ConfigConstant;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bm0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1750a = false;

    public static ContentValues[] a(Context context) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(ConfigConstant.getContentURI(context), null, null, null, null);
            } catch (Exception e) {
                Log.e("CX_EVENT", "copyOldDatabase exception:" + e.getMessage());
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery == null) {
                return new ContentValues[0];
            }
            ContentValues[] contentValuesArr = new ContentValues[cursorQuery.getCount()];
            if (cursorQuery.moveToFirst()) {
                cursorQuery.getColumnIndex("_id");
                int columnIndex = cursorQuery.getColumnIndex(ConfigConstant.COLUMN_EVENTID);
                int columnIndex2 = cursorQuery.getColumnIndex("level");
                int columnIndex3 = cursorQuery.getColumnIndex(ConfigConstant.COLUMN_AVAILABLETIME);
                int columnIndex4 = cursorQuery.getColumnIndex(ConfigConstant.COLUMN_LIMIT);
                int i = 0;
                do {
                    ContentValues contentValues = new ContentValues();
                    if (columnIndex >= 0) {
                        contentValues.put(ConfigConstant.COLUMN_EVENTID, cursorQuery.getString(columnIndex));
                    }
                    if (columnIndex2 >= 0) {
                        contentValues.put("level", Integer.valueOf(cursorQuery.getInt(columnIndex2)));
                    }
                    if (columnIndex3 >= 0) {
                        contentValues.put(ConfigConstant.COLUMN_AVAILABLETIME, Integer.valueOf(cursorQuery.getInt(columnIndex3)));
                    }
                    int i2 = -1;
                    if (columnIndex4 >= 0) {
                        int i3 = cursorQuery.getInt(columnIndex4);
                        if (i3 > 0) {
                            i2 = i3;
                        }
                        contentValues.put(ConfigConstant.COLUMN_LIMIT, Integer.valueOf(i2));
                    } else {
                        contentValues.put(ConfigConstant.COLUMN_LIMIT, (Integer) (-1));
                    }
                    contentValuesArr[i] = contentValues;
                    i++;
                } while (cursorQuery.moveToNext());
            }
            cursorQuery.close();
            return contentValuesArr;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public static int b(Context context, ContentValues[] contentValuesArr) {
        try {
            f1750a = false;
            ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
            if (contentValuesArr == null || contentValuesArr.length <= 0 || contentResolver == null) {
                return 0;
            }
            return contentResolver.bulkInsert(ql0.b(context), contentValuesArr);
        } catch (Exception e) {
            Log.e("CX_EVENT", "insertOldDatabase failed, ex:" + e.getMessage());
            return 0;
        }
    }

    public static boolean c() {
        Log.i("CX_EVENT", "ConfigVirginUtils isNeedCopyDatabase:" + f1750a);
        return f1750a;
    }

    public static boolean d(SQLiteDatabase sQLiteDatabase, String str) {
        if (sQLiteDatabase != null && !TextUtils.isEmpty(str)) {
            try {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name=?", new String[]{str});
                try {
                    boolean zMoveToFirst = cursorRawQuery.moveToFirst();
                    cursorRawQuery.close();
                    return zMoveToFirst;
                } finally {
                }
            } catch (Exception e) {
                Log.e("CX_EVENT", "isTabExist Exception ex:" + e.getMessage());
            }
        }
        return false;
    }

    public static void e(Context context) {
        f1750a = true;
        Log.i("CX_EVENT", "ConfigVirginUtils database need copy!");
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.cxpt.core.event.ACTION_COPY_DB"));
    }

    public static int f(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return b(context, a(context));
        } catch (Throwable th) {
            Log.e("CX_EVENT", "ConfigVirginUtils startCopyDatabase Exception ex:" + th.getMessage());
            return -1;
        }
    }
}
