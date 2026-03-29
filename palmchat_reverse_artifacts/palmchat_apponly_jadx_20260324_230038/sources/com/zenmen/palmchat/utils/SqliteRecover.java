package com.zenmen.palmchat.utils;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.core.view.MotionEventCompat;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import defpackage.a5;
import defpackage.bd1;
import defpackage.dx5;
import defpackage.ho0;
import defpackage.ho3;
import defpackage.hq5;
import defpackage.iq5;
import defpackage.je2;
import defpackage.pu1;
import defpackage.qt1;
import defpackage.s56;
import defpackage.ue6;
import defpackage.vn0;
import defpackage.wf5;
import defpackage.xf5;
import defpackage.ye2;
import defpackage.yf1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class SqliteRecover {
    public static final String CHECK_DATABASE = "checkDatabase";
    private static String TAG = "SqliteRecover";
    private static int mCopyIdx;
    private static AtomicBoolean mDoing = new AtomicBoolean(false);
    private static String mCurrentUid = null;
    private static int mOldVersion = 0;
    public static boolean DEBUG = true;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(String str);

        boolean b();
    }

    static {
        try {
            System.loadLibrary("sqliterecover");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
        mCopyIdx = 0;
    }

    public static void backupDatabases() {
        String strP = AccountUtils.p(AppContext.getContext());
        mCurrentUid = strP;
        if (strP == null) {
            return;
        }
        Date date = new Date();
        checkDir(pu1.m + "/");
        String str = pu1.m + "/" + date.toString() + "_backup_databases/";
        if (DEBUG) {
            Log.i(TAG, "rxx backup databases dir = " + str);
        }
        String dbFile = getDbFile();
        if (dbFile == null) {
            return;
        }
        try {
            copyDir(new File(dbFile).getParentFile().getPath(), str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean backupSocialDB() {
        String strP = AccountUtils.p(AppContext.getContext());
        mCurrentUid = strP;
        if (strP == null) {
            return false;
        }
        copyFile(getDbFile(), getBackupDbName());
        return true;
    }

    public static boolean checkDatabase() {
        String dbFile = getDbFile();
        return dbFile != null && tryopen(dbFile) >= 0;
    }

    public static boolean checkDir(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
            return true;
        }
        if (file.isDirectory()) {
            return true;
        }
        Log.i(TAG, str + "is file not a directory");
        return false;
    }

    public static void checkTable(SQLiteDatabase sQLiteDatabase, String str, b bVar) {
        try {
            sQLiteDatabase.execSQL(String.format("SELECT * FROM %s limit 1;", str));
        } catch (SQLiteException unused) {
            throw null;
        }
    }

    public static void copyDB() {
        mCopyIdx++;
        String dbFile = getDbFile();
        File file = new File(dbFile);
        if (!file.exists()) {
            Log.i(TAG, "rxx " + dbFile + " is not exists");
            return;
        }
        File file2 = new File(pu1.m + "copydb" + mCopyIdx + com.umeng.analytics.process.a.d);
        try {
            if (file2.exists()) {
                file2.delete();
            }
            file2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr, 0, 1024);
                if (i <= 0) {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public static void copyDatabase(boolean z) {
        String dbFile = getDbFile();
        if (dbFile == null) {
            return;
        }
        File file = new File(dbFile);
        if (!file.exists()) {
            Log.i(TAG, "rxx " + dbFile + " is not exists");
            return;
        }
        String name = file.getName();
        if (DEBUG) {
            Log.i(TAG, "rxx sqlite base name is :" + name);
        }
        File file2 = new File(pu1.m);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        String str = pu1.m + "/" + name;
        if (DEBUG) {
            Log.i(TAG, "rxx copyFileName base name is :" + str);
        }
        File file3 = new File(str);
        if (z) {
            try {
                if (file3.exists()) {
                    file3.delete();
                }
                file3.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = fileInputStream.read(bArr, 0, 1024);
                    if (i <= 0) {
                        fileInputStream.close();
                        fileOutputStream.close();
                        return;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } else {
            if (!file3.exists()) {
                return;
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileInputStream fileInputStream2 = new FileInputStream(file3);
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int i2 = fileInputStream2.read(bArr2, 0, 1024);
                    if (i2 <= 0) {
                        fileInputStream2.close();
                        fileOutputStream2.close();
                        return;
                    }
                    fileOutputStream2.write(bArr2, 0, i2);
                }
            } catch (FileNotFoundException e4) {
                e4.printStackTrace();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
    }

    public static void copyDir(String str, String str2) throws IOException {
        File file = new File(str);
        String[] list = file.isDirectory() ? file.list() : null;
        if (!new File(str2).exists()) {
            new File(str2).mkdirs();
        }
        if (list == null) {
            copyFile(str, str2 + File.separator + file.getName());
            return;
        }
        for (int i = 0; i < list.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String str3 = File.separator;
            sb.append(str3);
            sb.append(list[i]);
            if (new File(sb.toString()).isDirectory()) {
                copyDir(str + str3 + list[i], str2 + str3 + list[i]);
            }
            if (new File(str + str3 + list[i]).isFile()) {
                copyFile(str + str3 + list[i], str2 + str3 + list[i]);
            }
        }
    }

    public static void copyFile(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        File file2 = new File(str2);
        if (file2.exists()) {
            file2.delete();
        } else {
            file2.getParentFile().mkdirs();
        }
        Log.i(TAG, "copy file " + str + "===>" + str2);
        try {
            file2.createNewFile();
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr, 0, 1024);
                if (i <= 0) {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void copyFile2(String str, String str2) throws IOException {
        File file = new File(str);
        File file2 = new File(str2);
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bArr = new byte[2097152];
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i == -1) {
                fileInputStream.close();
                fileOutputStream.close();
                return;
            }
            fileOutputStream.write(bArr, 0, i);
        }
    }

    public static void deleteCorruptedDBFiles() {
        String[] strArr = {"-corrupted", "-currupted"};
        String strP = AccountUtils.p(AppContext.getContext());
        mCurrentUid = strP;
        if (strP == null) {
            return;
        }
        String strE = wf5.e(strP);
        String path = AppContext.getContext().getDatabasePath(strE).getPath();
        String strSubstring = path.substring(0, path.indexOf(strE));
        for (int i = 0; i < 2; i++) {
            try {
                String str = strSubstring + strE + strArr[i];
                if (DEBUG) {
                    Log.i(TAG, "rxx remove  file= " + str);
                }
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteDatabase() {
        String dbFile = getDbFile();
        if (dbFile == null) {
            return;
        }
        File file = new File(dbFile);
        if (file.exists()) {
            file.delete();
            return;
        }
        Log.i(TAG, "rxx " + dbFile + " is not exists");
    }

    public static void deleteTempFiles() {
        String[] strArr = {"-journal", "-journalcorrupted", "-walcorrupted", "-wal"};
        String strP = AccountUtils.p(AppContext.getContext());
        mCurrentUid = strP;
        if (strP == null) {
            return;
        }
        String strE = wf5.e(strP);
        String path = AppContext.getContext().getDatabasePath(strE).getPath();
        String strSubstring = path.substring(0, path.indexOf(strE));
        for (int i = 0; i < 4; i++) {
            try {
                String str = strSubstring + strE + strArr[i];
                if (DEBUG) {
                    Log.i(TAG, "rxx remove  file= " + str);
                }
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void destroyDB() {
        Log.i(TAG, "rxx start destory db ");
        String strP = AccountUtils.p(AppContext.getContext());
        mCurrentUid = strP;
        SQLiteDatabase writableDatabase = xf5.a(strP).getWritableDatabase();
        writableDatabase.execSQL("PRAGMA writable_schema=ON");
        writableDatabase.execSQL("update sqlite_master set rootpage = rootpage +1 where name = \"tb_messages\";");
        writableDatabase.execSQL("PRAGMA writable_schema=OFF");
        Log.i(TAG, "rxx end destory db ");
    }

    private static int doRecover(String str, String str2, String str3, c cVar) {
        int iRecover;
        synchronized (mDoing) {
            mDoing.set(true);
            if (new File(str).exists()) {
                mOldVersion = getDBFileUserVersion(str);
                iRecover = recover(str, str2, str3);
                Log.i(TAG, "rxx recover ret = " + iRecover);
                if (iRecover >= 0) {
                    if (!cVar.b()) {
                        Log.i(TAG, "account table data destroy rxx ret = -1");
                        iRecover = -1;
                    }
                    cVar.a(mCurrentUid);
                }
            } else {
                Log.i(TAG, "rxx " + str + " is not exists and do nothing");
                iRecover = 0;
            }
            mDoing.set(false);
            mDoing.notifyAll();
        }
        return iRecover;
    }

    public static native int dump(String str, String str2, String str3, String str4);

    public static void forceSync() {
        Log.i(TAG, "rxx Start sync");
        String strP = AccountUtils.p(AppContext.getContext());
        mCurrentUid = strP;
        xf5.a(strP).getWritableDatabase().execSQL("delete from tb_synckey;");
        iq5.d().g(true, new String[0]);
    }

    public static String getBackupDbName() {
        String strP = AccountUtils.p(AppContext.getContext());
        mCurrentUid = strP;
        if (strP == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        checkDir(pu1.m + "/");
        String str = pu1.m + "/" + jCurrentTimeMillis + "_backup_" + wf5.e(mCurrentUid);
        if (DEBUG) {
            Log.i(TAG, "rxx mBackupDBFile  = " + str);
        }
        return str;
    }

    public static String getCurruptedDbFile() {
        return getDbFile() + "-corrupted";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public static int getDBFileUserVersion(String str) throws Throwable {
        ?? r3;
        FileInputStream fileInputStream;
        IOException e;
        FileNotFoundException e2;
        byte[] bArr = new byte[100];
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                fileInputStream = new FileInputStream(new File(str));
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            try {
            } catch (FileNotFoundException e4) {
                e2 = e4;
                e2.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                Log.i(TAG, " " + ((int) bArr[62]) + " " + ((int) bArr[63]));
                r3 = 65280;
                int i = ((bArr[60] << 24) & (-16777216)) | ((bArr[61] << 16) & 16711680) | ((bArr[62] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (bArr[63] & UByte.MAX_VALUE);
                Log.i(TAG, "rxx db version is :" + i);
                return i;
            } catch (IOException e5) {
                e = e5;
                e.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                Log.i(TAG, " " + ((int) bArr[62]) + " " + ((int) bArr[63]));
                r3 = 65280;
                int i2 = ((bArr[60] << 24) & (-16777216)) | ((bArr[61] << 16) & 16711680) | ((bArr[62] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (bArr[63] & UByte.MAX_VALUE);
                Log.i(TAG, "rxx db version is :" + i2);
                return i2;
            }
        } catch (FileNotFoundException e6) {
            fileInputStream = null;
            e2 = e6;
        } catch (IOException e7) {
            fileInputStream = null;
            e = e7;
        } catch (Throwable th2) {
            r3 = 0;
            th = th2;
            if (r3 != 0) {
                try {
                    r3.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            throw th;
        }
        if (fileInputStream.read(bArr) < 100) {
            try {
                fileInputStream.close();
                return 30;
            } catch (IOException e9) {
                e9.printStackTrace();
                return 30;
            }
        }
        fileInputStream.close();
        Log.i(TAG, " " + ((int) bArr[62]) + " " + ((int) bArr[63]));
        r3 = 65280;
        int i22 = ((bArr[60] << 24) & (-16777216)) | ((bArr[61] << 16) & 16711680) | ((bArr[62] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (bArr[63] & UByte.MAX_VALUE);
        Log.i(TAG, "rxx db version is :" + i22);
        return i22;
    }

    public static String getDbFile() {
        String strP = AccountUtils.p(AppContext.getContext());
        mCurrentUid = strP;
        if (strP == null) {
            return null;
        }
        String path = AppContext.getContext().getDatabasePath(wf5.e(mCurrentUid)).getPath();
        if (DEBUG) {
            Log.i(TAG, "rxx get DB file= " + path);
        }
        return path;
    }

    public static boolean getStatus() {
        return mDoing.get();
    }

    public static String getTempfile() {
        String strP = AccountUtils.p(AppContext.getContext());
        mCurrentUid = strP;
        if (strP == null) {
            return null;
        }
        String str = pu1.m + "/";
        checkDir(str);
        String str2 = str + "dbtmp" + mCurrentUid + ".tmp";
        if (DEBUG) {
            Log.i(TAG, "rxx get temp file path = " + str2);
        }
        return str2;
    }

    public static boolean hasCorruptedDatabaseFile() {
        return new File(getCurruptedDbFile()).exists();
    }

    public static boolean hasCorruptedDatabaseFileForLauncher() {
        File file = new File(getCurruptedDbFile());
        if (!file.exists() || file.length() < 51200 || System.currentTimeMillis() - file.lastModified() > 259200000) {
            return false;
        }
        File file2 = new File(getDbFile());
        return !file2.exists() || file2.length() <= 1048576;
    }

    public static void onCreate(SQLiteDatabase sQLiteDatabase) {
        Log.i(TAG, "rxx recover database to create tables if not exist");
        sQLiteDatabase.execSQL(ho3.b("tb_messages"));
        sQLiteDatabase.execSQL(ho0.a());
        sQLiteDatabase.execSQL(vn0.a());
        sQLiteDatabase.execSQL(dx5.a());
        sQLiteDatabase.execSQL(yf1.a());
        sQLiteDatabase.execSQL(hq5.a());
        sQLiteDatabase.execSQL(ye2.a("tb_groups"));
        sQLiteDatabase.execSQL(je2.a());
        sQLiteDatabase.execSQL(qt1.a());
        sQLiteDatabase.execSQL(a5.a());
        sQLiteDatabase.execSQL(s56.a());
        sQLiteDatabase.execSQL(ue6.a());
        sQLiteDatabase.execSQL(bd1.a());
        sQLiteDatabase.execSQL(ho3.c("tb_messages"));
    }

    public static void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Log.d(TAG, "onUpgrade oldVersion:" + i + " newVersion:" + i2);
        switch (i) {
            case 30:
                sQLiteDatabase.execSQL("alter table tb_contacts add column account_type int default 0;");
            case 31:
                sQLiteDatabase.execSQL(ue6.a());
            case 32:
                sQLiteDatabase.execSQL("alter table tb_groups add column group_extra_info TEXT; ");
                sQLiteDatabase.execSQL("alter table tb_groups add column group_categoryId TEXT; ");
            case 33:
                sQLiteDatabase.execSQL(s56.a());
            case 34:
            case 35:
                sQLiteDatabase.execSQL("alter table tb_account add column refresh_key TEXT; ");
            case 36:
                sQLiteDatabase.execSQL("alter table tb_contact_requests add column applyFriendTime TEXT; ");
                sQLiteDatabase.execSQL("alter table tb_contact_requests add column cycleTime TEXT; ");
            case 37:
                sQLiteDatabase.execSQL("alter table tb_contact_requests add column blankTime TEXT; ");
            case 38:
            case 39:
                sQLiteDatabase.execSQL("alter table tb_contact_requests add column expireTime TEXT; ");
                sQLiteDatabase.execSQL("alter table tb_contact_requests add column operateTime TEXT; ");
                sQLiteDatabase.execSQL("alter table tb_contact_requests add column deleteTime TEXT; ");
                sQLiteDatabase.execSQL("alter table tb_contact_requests add column recommendTitle TEXT; ");
                sQLiteDatabase.execSQL("alter table tb_contact_requests add column recommendText TEXT; ");
            case 40:
                sQLiteDatabase.execSQL(bd1.a());
            case 41:
                sQLiteDatabase.execSQL("alter table tb_contact_requests add column commonFrds int default 0; ");
            case 42:
                sQLiteDatabase.execSQL("alter table tb_contact_requests add column applyTime LONG; ");
                sQLiteDatabase.execSQL("alter table tb_contact_requests add column applyExpireSec LONG; ");
            case 43:
                sQLiteDatabase.execSQL("alter table tb_contact_requests add column readTime LONG; ");
            case 44:
                sQLiteDatabase.execSQL("update tb_contact_requests set read_status = 1 where read_status = 2");
                sQLiteDatabase.execSQL("alter table tb_contact_requests add column disShowTime LONG; ");
            case 45:
                sQLiteDatabase.execSQL("alter table tb_contact_requests add column insert_date TEXT; ");
                break;
        }
    }

    private static boolean rebuildDatabaseLocked(int i) {
        Log.i(TAG, "rxx rebuildDatabaseLocked new version is: " + i);
        try {
            SQLiteDatabase sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(getDbFile(), null, 0);
            sQLiteDatabaseOpenDatabase.beginTransaction();
            try {
                onCreate(sQLiteDatabaseOpenDatabase);
                sQLiteDatabaseOpenDatabase.setVersion(mOldVersion);
                int version = sQLiteDatabaseOpenDatabase.getVersion();
                Log.i(TAG, "rxx current version is " + version);
                if (version < i) {
                    onUpgrade(sQLiteDatabaseOpenDatabase, version, i);
                }
                sQLiteDatabaseOpenDatabase.setVersion(i);
                sQLiteDatabaseOpenDatabase.setTransactionSuccessful();
                sQLiteDatabaseOpenDatabase.endTransaction();
                sQLiteDatabaseOpenDatabase.close();
                return true;
            } catch (Throwable th) {
                sQLiteDatabaseOpenDatabase.endTransaction();
                throw th;
            }
        } catch (SQLiteException e) {
            Log.i(TAG, "rxx Couldn't open " + getDbFile() + " for writing :", e);
            return false;
        }
    }

    private static native int recover(String str, String str2, String str3);

    public static boolean recoverSocialDB() {
        String strP = AccountUtils.p(AppContext.getContext());
        mCurrentUid = strP;
        if (strP == null) {
            return false;
        }
        String tempfile = getTempfile();
        if (DEBUG) {
            Log.i(TAG, "rxx start recover db ");
        }
        String dbFile = getDbFile();
        String curruptedDbFile = getCurruptedDbFile();
        backupDatabases();
        deleteTempFiles();
        int iDoRecover = doRecover(curruptedDbFile, tempfile, dbFile, new a());
        if (iDoRecover >= 0) {
            Log.i(TAG, "rxx recover successfully");
        }
        Log.i(TAG, "rxx rebuild tables if not-exist begin");
        boolean zRebuildDatabaseLocked = rebuildDatabaseLocked(50);
        Log.i(TAG, "rxx rebuild tables if not-exist end");
        if (!zRebuildDatabaseLocked) {
            Log.i(TAG, "rxx rebuild tables failed and force to delete database file");
            File file = new File(tempfile);
            if (file.exists()) {
                file.delete();
            }
            return false;
        }
        if (DEBUG) {
            Log.i(TAG, "rxx end recover db ");
        } else {
            File file2 = new File(tempfile);
            if (file2.exists()) {
                file2.delete();
            }
        }
        return iDoRecover >= 0;
    }

    public static void restoreDatabases() {
        String strP = AccountUtils.p(AppContext.getContext());
        mCurrentUid = strP;
        if (strP == null) {
            return;
        }
        checkDir(pu1.m + "/");
        String str = pu1.m + "/databases/";
        if (DEBUG) {
            Log.i(TAG, "rxx backup databases dir = " + str);
        }
        String dbFile = getDbFile();
        if (dbFile == null) {
            return;
        }
        try {
            copyDir(str, new File(dbFile).getParentFile().getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static native int tryopen(String str);

    /* JADX INFO: compiled from: SearchBox */
    public class a implements c {
        @Override // com.zenmen.palmchat.utils.SqliteRecover.c
        public boolean b() {
            SqliteRecover.deleteCorruptedDBFiles();
            return SqliteRecover.checkDatabase();
        }

        @Override // com.zenmen.palmchat.utils.SqliteRecover.c
        public void a(String str) {
        }
    }
}
