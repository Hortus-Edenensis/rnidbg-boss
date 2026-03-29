package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsWrapper;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class r07 extends dv6<bv6> {
    public r07() {
        super("duplicatelog");
    }

    @Override // defpackage.dv6
    public HashMap<String, String> b() {
        HashMap<String, String> map = new HashMap<>();
        map.put(OapsWrapper.KEY_PATH, "TEXT");
        map.put("insert_time", "INTEGER");
        map.put("ext1", "TEXT");
        map.put("ext2", "TEXT");
        return map;
    }

    @Override // defpackage.dv6
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public ContentValues a(bv6 bv6Var) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(OapsWrapper.KEY_PATH, bv6Var.f1829a);
        contentValues.put("insert_time", Long.valueOf(bv6Var.b));
        return contentValues;
    }

    public void f(SQLiteDatabase sQLiteDatabase, bv6 bv6Var) {
        if (bv6Var == null || g(sQLiteDatabase, bv6Var.f1829a)) {
            return;
        }
        super.d(sQLiteDatabase, bv6Var);
        try {
            sQLiteDatabase.execSQL("delete from " + this.b + " where _id in (select _id from " + this.b + " order by insert_time desc limit 1000 offset 500)");
        } catch (Exception e) {
            kj7.g(e);
        }
    }

    public boolean g(SQLiteDatabase sQLiteDatabase, String str) {
        int count;
        if (sQLiteDatabase == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Cursor cursorQuery = sQLiteDatabase.query(this.b, null, "path=?", new String[]{str}, null, null, null);
            count = cursorQuery.getCount();
            try {
                cursorQuery.close();
            } catch (Throwable th) {
                th = th;
                kj7.g(th);
            }
        } catch (Throwable th2) {
            th = th2;
            count = 0;
        }
        return count > 0;
    }
}
