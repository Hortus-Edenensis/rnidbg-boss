package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.utils.SqliteRecover;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class vh5 {
    public static boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f21446a;
    public String b;

    public vh5(SQLiteDatabase sQLiteDatabase, String str) {
        this.f21446a = sQLiteDatabase;
        this.b = str;
    }

    public void a() {
        if (SqliteRecover.getStatus()) {
            this.f21446a = null;
            return;
        }
        SQLiteDatabase sQLiteDatabase = this.f21446a;
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
        } catch (Exception e) {
            Log.e("rxx", "begin transaction get a excepion");
            LogUtil.log4ClientError("SqliteDatabaseWrapper_beginTransaction", e);
        }
    }

    public final synchronized void b(Exception exc) {
        String message;
        if ((exc instanceof SQLiteException) && (message = exc.getMessage()) != null && message.contains("no such column") && ((message.contains("is_super_greetings") || message.contains("super_greetings_time_stamp") || message.contains("pin_gift_message") || message.contains("pin_gift_message_last_time_stamp") || message.contains("has_unread_gift_message")) && !c)) {
            c = true;
            try {
                xf5.a(AccountUtils.p(AppContext.getContext())).c();
            } catch (Exception e) {
                e.printStackTrace();
            }
            LogUtil.log4ClientError("checkAndFixColumMissing", null, exc, true);
        }
    }

    public int c(String str, String str2, String[] strArr) {
        if (SqliteRecover.getStatus()) {
            this.f21446a = null;
            return -1;
        }
        if (this.f21446a == null) {
            this.f21446a = xf5.a(this.b).getWritableDatabase();
        }
        SQLiteDatabase sQLiteDatabase = this.f21446a;
        if (sQLiteDatabase == null) {
            return -1;
        }
        try {
            return sQLiteDatabase.delete(str, str2, strArr);
        } catch (SQLiteException e) {
            Log.e("rxx", "SQLiteException");
            LogUtil.log4ClientError("SqliteDatabaseWrapperDelete", e);
            return -1;
        }
    }

    public void d() {
        if (SqliteRecover.getStatus()) {
            this.f21446a = null;
            return;
        }
        SQLiteDatabase sQLiteDatabase = this.f21446a;
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Exception e) {
            Log.e("rxx", "enter transaction get a excepion");
            LogUtil.log4ClientError("SqliteDatabaseWrapper_endTransaction", e);
        }
    }

    public void e(String str) {
        try {
            this.f21446a.execSQL(str);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.log4ClientError("SqliteDatabaseWrapper_execSQL", e);
        }
    }

    public long f(String str, String str2, ContentValues contentValues) {
        if (SqliteRecover.getStatus()) {
            this.f21446a = null;
            return -1L;
        }
        if (this.f21446a == null) {
            this.f21446a = xf5.a(this.b).getWritableDatabase();
        }
        SQLiteDatabase sQLiteDatabase = this.f21446a;
        if (sQLiteDatabase == null) {
            return -1L;
        }
        return sQLiteDatabase.insert(str, str2, contentValues);
    }

    public Cursor g(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        Cursor cursorQuery;
        if (SqliteRecover.getStatus()) {
            this.f21446a = null;
            return null;
        }
        if (this.f21446a == null) {
            this.f21446a = xf5.a(this.b).getReadableDatabase();
        }
        SQLiteDatabase sQLiteDatabase = this.f21446a;
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            cursorQuery = sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5);
            if (cursorQuery != null) {
                try {
                    cursorQuery.getCount();
                } catch (SQLiteException e) {
                    e = e;
                    LogUtil.log4ClientError("SqliteDatabaseWrapperQuery", e);
                    Log.e("rxx", "SQLiteException");
                    b(e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            }
            return cursorQuery;
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        }
    }

    public void h() {
        if (SqliteRecover.getStatus()) {
            this.f21446a = null;
            return;
        }
        SQLiteDatabase sQLiteDatabase = this.f21446a;
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e("rxx", "begin transaction get a excepion");
            LogUtil.log4ClientError("SqliteDatabaseWrapper_setTransactionSuccessful", e);
        }
    }

    public int i(String str, ContentValues contentValues, String str2, String[] strArr) {
        if (SqliteRecover.getStatus()) {
            this.f21446a = null;
            return -1;
        }
        if (this.f21446a == null) {
            this.f21446a = xf5.a(this.b).getWritableDatabase();
        }
        SQLiteDatabase sQLiteDatabase = this.f21446a;
        if (sQLiteDatabase == null) {
            return -1;
        }
        try {
            return sQLiteDatabase.update(str, contentValues, str2, strArr);
        } catch (SQLiteException e) {
            Log.e("rxx", "SQLiteException");
            LogUtil.log4ClientError("SqliteDatabaseWrapperUpdate", e);
            b(e);
            return -1;
        }
    }
}
