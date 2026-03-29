package defpackage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class dl7<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17074a = "_id";
    public final String b;

    public dl7(String str) {
        this.b = str;
    }

    public void a(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase == null || t == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.b, null, b(t));
        } catch (Exception e) {
            mf7.a(e);
        }
    }

    public abstract ContentValues b(T t);

    public abstract HashMap<String, String> c();

    public void d(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(this.b);
            sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> mapC = c();
            if (mapC != null) {
                for (String str : mapC.keySet()) {
                    sb.append(str);
                    sb.append(" ");
                    sb.append(mapC.get(str));
                    sb.append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(")");
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Exception unused) {
        }
    }
}
