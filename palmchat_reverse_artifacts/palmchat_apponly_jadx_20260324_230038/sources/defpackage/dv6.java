package defpackage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class dv6<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17143a = "_id";
    public final String b;

    public dv6(String str) {
        this.b = str;
    }

    public abstract ContentValues a(T t);

    public abstract HashMap<String, String> b();

    public void c(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(this.b);
            sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> mapB = b();
            if (mapB != null) {
                for (String str : mapB.keySet()) {
                    sb.append(str);
                    sb.append(" ");
                    sb.append(mapB.get(str));
                    sb.append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(")");
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Throwable th) {
            n37.a();
            n37.b("NPTH_CATCH", th);
        }
    }

    public void d(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase == null || t == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.b, null, a(t));
        } catch (Throwable th) {
            kj7.g(th);
        }
    }
}
