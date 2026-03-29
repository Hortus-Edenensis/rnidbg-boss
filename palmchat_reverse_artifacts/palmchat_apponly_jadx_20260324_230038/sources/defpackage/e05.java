package defpackage;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.zenmen.palmchat.utils.SqliteRecover;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class e05 implements DatabaseErrorHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f17188a = "DatabaseErrorHandler";

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FileFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17189a;

        public a(String str) {
            this.f17189a = str;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().startsWith(this.f17189a);
        }
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        boolean zDelete = file.delete() | false | new File(file.getPath() + "-journal").delete() | new File(file.getPath() + "-shm").delete() | new File(file.getPath() + "-wal").delete();
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            File[] fileArrListFiles = parentFile.listFiles(new a(file.getName() + "-mj"));
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    zDelete |= file2.delete();
                }
            }
        }
        return zDelete;
    }

    public final void b(String str) {
        if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
            return;
        }
        Log.e(f17188a, "deleting the database file: " + str);
        try {
            SqliteRecover.backupDatabases();
            File file = new File(str + "-corrupted");
            if (file.exists()) {
                file.delete();
            }
            new File(str).renameTo(new File(str + "-corrupted"));
            Log.e(f17188a, "deleting the database file: " + str);
            try {
                a(new File(str));
            } catch (Exception e) {
                Log.w(f17188a, "delete failed: " + e.getMessage());
            }
        } catch (Exception e2) {
            Log.w(f17188a, "delete failed: " + e2.getMessage());
        }
    }

    @Override // android.database.DatabaseErrorHandler
    public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        Log.e(f17188a, "Corruption reported by sqlite on database, deleting: " + sQLiteDatabase.getPath());
        if (sQLiteDatabase.isOpen()) {
            Log.e(f17188a, "Database object for corrupted database is already open, closing");
            try {
                sQLiteDatabase.close();
            } catch (Exception e) {
                Log.e(f17188a, "Exception closing Database object for corrupted database, ignored", e);
            }
        }
        LogUtil.log4ClientError("onCorruption", null);
        b(sQLiteDatabase.getPath());
    }
}
