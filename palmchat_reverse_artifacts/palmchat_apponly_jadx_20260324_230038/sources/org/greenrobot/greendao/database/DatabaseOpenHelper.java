package org.greenrobot.greendao.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class DatabaseOpenHelper extends SQLiteOpenHelper {
    private final Context context;
    private EncryptedHelper encryptedHelper;
    private boolean loadSQLCipherNativeLibs;
    private final String name;
    private final int version;

    /* JADX INFO: compiled from: SearchBox */
    public class EncryptedHelper extends net.sqlcipher.database.SQLiteOpenHelper {
        public EncryptedHelper(Context context, String str, int i, boolean z) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
            if (z) {
                SQLiteDatabase.loadLibs(context);
            }
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            DatabaseOpenHelper.this.onCreate(wrap(sQLiteDatabase));
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            DatabaseOpenHelper.this.onOpen(wrap(sQLiteDatabase));
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            DatabaseOpenHelper.this.onUpgrade(wrap(sQLiteDatabase), i, i2);
        }

        public Database wrap(SQLiteDatabase sQLiteDatabase) {
            return new EncryptedDatabase(sQLiteDatabase);
        }
    }

    public DatabaseOpenHelper(Context context, String str, int i) {
        this(context, str, null, i);
    }

    private EncryptedHelper checkEncryptedHelper() {
        if (this.encryptedHelper == null) {
            this.encryptedHelper = new EncryptedHelper(this.context, this.name, this.version, this.loadSQLCipherNativeLibs);
        }
        return this.encryptedHelper;
    }

    public Database getEncryptedReadableDb(String str) {
        EncryptedHelper encryptedHelperCheckEncryptedHelper = checkEncryptedHelper();
        return encryptedHelperCheckEncryptedHelper.wrap(encryptedHelperCheckEncryptedHelper.getReadableDatabase(str));
    }

    public Database getEncryptedWritableDb(String str) {
        EncryptedHelper encryptedHelperCheckEncryptedHelper = checkEncryptedHelper();
        return encryptedHelperCheckEncryptedHelper.wrap(encryptedHelperCheckEncryptedHelper.getWritableDatabase(str));
    }

    public Database getReadableDb() {
        return wrap(getReadableDatabase());
    }

    public Database getWritableDb() {
        return wrap(getWritableDatabase());
    }

    public void onCreate(Database database) {
    }

    public void onOpen(Database database) {
    }

    public void onUpgrade(Database database, int i, int i2) {
    }

    public void setLoadSQLCipherNativeLibs(boolean z) {
        this.loadSQLCipherNativeLibs = z;
    }

    public Database wrap(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        return new StandardDatabase(sQLiteDatabase);
    }

    public DatabaseOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.loadSQLCipherNativeLibs = true;
        this.context = context;
        this.name = str;
        this.version = i;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        onCreate(wrap(sQLiteDatabase));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        onOpen(wrap(sQLiteDatabase));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(wrap(sQLiteDatabase), i, i2);
    }

    public Database getEncryptedReadableDb(char[] cArr) {
        EncryptedHelper encryptedHelperCheckEncryptedHelper = checkEncryptedHelper();
        return encryptedHelperCheckEncryptedHelper.wrap(encryptedHelperCheckEncryptedHelper.getReadableDatabase(cArr));
    }

    public Database getEncryptedWritableDb(char[] cArr) {
        EncryptedHelper encryptedHelperCheckEncryptedHelper = checkEncryptedHelper();
        return encryptedHelperCheckEncryptedHelper.wrap(encryptedHelperCheckEncryptedHelper.getWritableDatabase(cArr));
    }
}
