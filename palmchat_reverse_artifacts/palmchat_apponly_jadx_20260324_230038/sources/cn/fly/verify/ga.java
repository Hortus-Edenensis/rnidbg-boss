package cn.fly.verify;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ga {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2381a;
        private String b;
        private SQLiteDatabase c;
        private LinkedHashMap<String, String> d;
        private HashMap<String, Boolean> e;
        private String f;
        private boolean g;

        private a(String str, String str2) {
            this.f2381a = str;
            this.b = str2;
            this.d = new LinkedHashMap<>();
            this.e = new HashMap<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0093  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a() throws Throwable {
            boolean z;
            if (TextUtils.isEmpty(this.f2381a)) {
                throw new Throwable("path is null");
            }
            File file = new File(this.f2381a);
            Cursor cursorQuery = null;
            if (this.c != null && !file.exists()) {
                this.c.close();
                try {
                    File parentFile = file.getParentFile();
                    if (parentFile != null && (!parentFile.exists() || !parentFile.isDirectory())) {
                        parentFile.delete();
                        parentFile.mkdirs();
                    }
                } catch (Throwable unused) {
                }
                this.c = null;
            }
            if (this.c == null) {
                if (!file.exists()) {
                    try {
                        File parentFile2 = file.getParentFile();
                        if (parentFile2 != null && (!parentFile2.exists() || !parentFile2.isDirectory())) {
                            parentFile2.delete();
                            parentFile2.mkdirs();
                            file.createNewFile();
                        }
                    } catch (Throwable unused2) {
                    }
                }
                SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                this.c = sQLiteDatabaseOpenOrCreateDatabase;
                try {
                    cursorQuery = sQLiteDatabaseOpenOrCreateDatabase.query(ed.a("013,fhde_gAdi9if?dhdfXdHfh]if[dj"), null, ed.a("017iFdkOjf'iiihif:deAdcif;ed)df$f@iiih"), new String[]{ed.a("005idQfeDgf"), this.b}, null, null, null);
                    if (cursorQuery != null) {
                        z = cursorQuery.getCount() <= 0;
                    }
                    if (z) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("create table  ");
                        sb.append(this.b);
                        sb.append("(");
                        for (Map.Entry<String, String> entry : this.d.entrySet()) {
                            String key = entry.getKey();
                            String value = entry.getValue();
                            boolean zBooleanValue = this.e.get(key).booleanValue();
                            boolean zEquals = key.equals(this.f);
                            boolean z2 = zEquals ? this.g : false;
                            sb.append(key);
                            sb.append(" ");
                            sb.append(value);
                            sb.append(zBooleanValue ? " not null" : "");
                            sb.append(zEquals ? " primary key" : "");
                            sb.append(z2 ? " autoincrement," : ",");
                        }
                        sb.replace(sb.length() - 1, sb.length(), ");");
                        try {
                            SQLiteDatabase.class.getMethod(ed.a("007f[ecIfcEejjjfc"), String.class).invoke(this.c, sb.toString());
                        } catch (Throwable th) {
                            en.a().a(th);
                        }
                    }
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.b;
        }

        public void a(String str, String str2, boolean z) {
            if (this.c == null) {
                this.d.put(str, str2);
                this.e.put(str, Boolean.valueOf(z));
            }
        }
    }

    public static int a(a aVar, String str, String[] strArr) throws Throwable {
        aVar.a();
        return aVar.c.delete(aVar.b(), str, strArr);
    }

    public static long a(a aVar, ContentValues contentValues) throws Throwable {
        aVar.a();
        return aVar.c.replace(aVar.b(), null, contentValues);
    }

    public static Cursor a(a aVar, String[] strArr, String str, String[] strArr2, String str2) throws Throwable {
        aVar.a();
        return aVar.c.query(aVar.b(), strArr, str, strArr2, null, null, str2);
    }

    public static a a(String str, String str2) {
        return new a(str, str2);
    }
}
