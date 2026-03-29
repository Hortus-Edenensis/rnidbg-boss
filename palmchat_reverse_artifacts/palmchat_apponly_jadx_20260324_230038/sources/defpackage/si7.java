package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsWrapper;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class si7 extends dl7<el7> {
    public si7() {
        super("duplicatelog");
    }

    @Override // defpackage.dl7
    public HashMap<String, String> c() {
        HashMap<String, String> map = new HashMap<>();
        map.put(OapsWrapper.KEY_PATH, "TEXT");
        map.put("insert_time", "INTEGER");
        map.put("ext1", "TEXT");
        map.put("ext2", "TEXT");
        return map;
    }

    public void e(SQLiteDatabase sQLiteDatabase, el7 el7Var) {
        if (el7Var == null || g(sQLiteDatabase, el7Var.f17314a)) {
            return;
        }
        super.a(sQLiteDatabase, el7Var);
        try {
            sQLiteDatabase.execSQL("delete from " + this.b + " where _id in (select _id from " + this.b + " order by insert_time desc limit 1000 offset 500)");
        } catch (Exception e) {
            mf7.a(e);
        }
    }

    @Override // defpackage.dl7
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public ContentValues b(el7 el7Var) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(OapsWrapper.KEY_PATH, el7Var.f17314a);
        contentValues.put("insert_time", Long.valueOf(el7Var.b));
        return contentValues;
    }

    public boolean g(SQLiteDatabase sQLiteDatabase, String str) {
        int count;
        Cursor cursorQuery;
        if (sQLiteDatabase != null && !TextUtils.isEmpty(str)) {
            try {
                cursorQuery = sQLiteDatabase.query(this.b, null, "path=?", new String[]{str}, null, null, null);
                count = cursorQuery.getCount();
            } catch (Exception e) {
                e = e;
                count = 0;
            }
            try {
                cursorQuery.close();
            } catch (Exception e2) {
                e = e2;
                mf7.a(e);
            }
            if (count > 0) {
                return true;
            }
        }
        return false;
    }
}
