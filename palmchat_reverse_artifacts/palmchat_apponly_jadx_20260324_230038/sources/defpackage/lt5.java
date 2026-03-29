package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class lt5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xs0 f19075a;

    public lt5(Context context) {
        this.f19075a = xs0.a(context);
    }

    public void a(String str) {
        try {
            SQLiteDatabase writableDatabase = this.f19075a.getWritableDatabase();
            try {
                writableDatabase.execSQL("DELETE FROM task_info WHERE base_url=?", new String[]{str});
            } catch (SQLiteFullException unused) {
            }
            writableDatabase.close();
        } catch (SQLiteCantOpenDatabaseException unused2) {
        }
    }

    public void b(ct0 ct0Var) {
        try {
            SQLiteDatabase writableDatabase = this.f19075a.getWritableDatabase();
            try {
                writableDatabase.execSQL("INSERT INTO task_info(base_url, real_url, file_path, file_name, mime_type, e_tag, disposition, location, currentBytes, totalBytes) values (?,?,?,?,?,?,?,?,?,?)", new Object[]{ct0Var.e, ct0Var.f, ct0Var.d, ct0Var.c, ct0Var.k, ct0Var.l, ct0Var.m, ct0Var.n, Integer.valueOf(ct0Var.b), Integer.valueOf(ct0Var.f16909a)});
            } catch (SQLiteFullException unused) {
            } catch (Exception e) {
                e.printStackTrace();
            }
            writableDatabase.close();
        } catch (SQLiteCantOpenDatabaseException unused2) {
        }
    }

    public ct0 c(String str) {
        ct0 ct0Var = null;
        try {
            SQLiteDatabase writableDatabase = this.f19075a.getWritableDatabase();
            Cursor cursorRawQuery = writableDatabase.rawQuery("SELECT base_url, real_url, file_path, file_name, mime_type, e_tag, disposition, location, currentBytes, totalBytes FROM task_info WHERE base_url=?", new String[]{str});
            if (cursorRawQuery.moveToFirst()) {
                ct0Var = new ct0();
                ct0Var.e = cursorRawQuery.getString(0);
                ct0Var.f = cursorRawQuery.getString(1);
                ct0Var.d = cursorRawQuery.getString(2);
                ct0Var.c = cursorRawQuery.getString(3);
                ct0Var.k = cursorRawQuery.getString(4);
                ct0Var.l = cursorRawQuery.getString(5);
                ct0Var.m = cursorRawQuery.getString(6);
                ct0Var.n = cursorRawQuery.getString(7);
                ct0Var.b = cursorRawQuery.getInt(8);
                ct0Var.f16909a = cursorRawQuery.getInt(9);
            }
            cursorRawQuery.close();
            writableDatabase.close();
        } catch (SQLiteCantOpenDatabaseException unused) {
        }
        return ct0Var;
    }

    public void d(ct0 ct0Var) {
        try {
            SQLiteDatabase writableDatabase = this.f19075a.getWritableDatabase();
            writableDatabase.execSQL("UPDATE task_info SET disposition=?,location=?,mime_type=?,totalBytes=?,file_name=?,currentBytes=? WHERE base_url=?", new Object[]{ct0Var.m, ct0Var.n, ct0Var.k, Integer.valueOf(ct0Var.f16909a), ct0Var.c, Integer.valueOf(ct0Var.b), ct0Var.e});
            writableDatabase.close();
        } catch (SQLiteCantOpenDatabaseException unused) {
        }
    }
}
