package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class mw5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xs0 f19381a;

    public mw5(Context context) {
        this.f19381a = xs0.a(context);
    }

    public void a(String str) {
        SQLiteDatabase writableDatabase = this.f19381a.getWritableDatabase();
        writableDatabase.execSQL("DELETE FROM thread_info WHERE base_url=?", new String[]{str});
        writableDatabase.close();
    }

    public void b(String str) {
        SQLiteDatabase writableDatabase = this.f19381a.getWritableDatabase();
        writableDatabase.execSQL("DELETE FROM thread_info WHERE id=?", new String[]{str});
        writableDatabase.close();
    }

    public void c(gt0 gt0Var) {
        SQLiteDatabase writableDatabase = this.f19381a.getWritableDatabase();
        writableDatabase.execSQL("INSERT INTO thread_info(base_url, start, end, id) VALUES (?,?,?,?)", new Object[]{gt0Var.b, Integer.valueOf(gt0Var.c), Integer.valueOf(gt0Var.d), gt0Var.f17802a});
        writableDatabase.close();
    }

    public List<gt0> d(String str) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase writableDatabase = this.f19381a.getWritableDatabase();
        Cursor cursorRawQuery = writableDatabase.rawQuery("SELECT base_url, start, end, id FROM thread_info WHERE base_url=?", new String[]{str});
        while (cursorRawQuery.moveToNext()) {
            arrayList.add(new gt0(cursorRawQuery.getString(3), cursorRawQuery.getString(0), cursorRawQuery.getInt(1), cursorRawQuery.getInt(2)));
        }
        cursorRawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    public void e(gt0 gt0Var) {
        SQLiteDatabase writableDatabase = this.f19381a.getWritableDatabase();
        writableDatabase.execSQL("UPDATE thread_info SET start=? WHERE base_url=? AND id=?", new Object[]{Integer.valueOf(gt0Var.c), gt0Var.b, gt0Var.f17802a});
        writableDatabase.close();
    }
}
