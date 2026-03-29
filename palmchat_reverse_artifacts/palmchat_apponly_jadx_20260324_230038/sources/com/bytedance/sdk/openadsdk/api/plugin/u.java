package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends ContextWrapper {
    private File b;
    private File fx;
    private File iz;
    private File n;
    private File nr;
    private File pn;
    private final Object u;
    private File x;

    public u(Context context) {
        super(context);
        this.u = new Object();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        if (u() == null) {
            return super.databaseList();
        }
        String[] strArrDatabaseList = super.databaseList();
        int length = strArrDatabaseList.length;
        boolean[] zArr = new boolean[length];
        int i = 0;
        for (int i2 = 0; i2 < strArrDatabaseList.length; i2++) {
            if (strArrDatabaseList[i2].startsWith(u())) {
                zArr[i2] = true;
                i++;
            } else {
                zArr[i2] = false;
            }
        }
        String[] strArr = new String[i];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (zArr[i4]) {
                strArr[i3] = strArrDatabaseList[i4];
                i3++;
            }
        }
        return strArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        return u() == null ? super.deleteDatabase(str) : super.deleteDatabase(u(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        return u(getFilesDir(), str).delete();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(String str) {
        return u() == null ? super.deleteSharedPreferences(str) : super.deleteSharedPreferences(u(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        File fileU;
        if (u() == null) {
            return super.getCacheDir();
        }
        synchronized (this.u) {
            if (this.iz == null) {
                this.iz = new File(super.getCacheDir(), u());
            }
            fileU = u(this.iz);
        }
        return fileU;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        File fileU;
        if (u() == null) {
            return super.getCodeCacheDir();
        }
        synchronized (this.u) {
            if (this.x == null) {
                this.x = new File(super.getCodeCacheDir(), u());
            }
            fileU = u(this.x);
        }
        return fileU;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        File fileU;
        if (u() == null) {
            return super.getDataDir();
        }
        synchronized (this.u) {
            if (this.nr == null) {
                this.nr = new File(nr(), u());
            }
            fileU = u(this.nr);
        }
        return fileU;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        return u() == null ? super.getDatabasePath(str) : super.getDatabasePath(u(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i) {
        return (i != 0 || u() == null) ? super.getDir(str, i) : u(new File(super.getDir(str, i), u()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        File fileU;
        if (u() == null) {
            return super.getExternalCacheDir();
        }
        synchronized (this.u) {
            if (this.n == null) {
                this.n = new File(super.getExternalCacheDir(), u());
            }
            fileU = u(this.n);
        }
        return fileU;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        if (u() == null) {
            return super.getExternalCacheDirs();
        }
        File[] externalCacheDirs = super.getExternalCacheDirs();
        File[] fileArr = new File[externalCacheDirs.length];
        for (int i = 0; i < externalCacheDirs.length; i++) {
            fileArr[i] = u(new File(externalCacheDirs[i], u()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        return u() == null ? super.getExternalFilesDir(str) : u(new File(super.getExternalFilesDir(str), u()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        if (u() == null) {
            return super.getExternalFilesDirs(str);
        }
        File[] externalFilesDirs = super.getExternalFilesDirs(str);
        File[] fileArr = new File[externalFilesDirs.length];
        for (int i = 0; i < externalFilesDirs.length; i++) {
            fileArr[i] = u(new File(externalFilesDirs[i], u()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        if (u() == null) {
            return super.getExternalMediaDirs();
        }
        File[] externalMediaDirs = super.getExternalMediaDirs();
        File[] fileArr = new File[externalMediaDirs.length];
        for (int i = 0; i < externalMediaDirs.length; i++) {
            fileArr[i] = u(new File(externalMediaDirs[i], u()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        File fileU;
        if (u() == null) {
            return super.getFilesDir();
        }
        synchronized (this.u) {
            if (this.fx == null) {
                this.fx = new File(super.getFilesDir(), u());
            }
            fileU = u(this.fx);
        }
        return fileU;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        File fileU;
        if (u() == null) {
            return super.getNoBackupFilesDir();
        }
        synchronized (this.u) {
            if (this.b == null) {
                this.b = new File(super.getNoBackupFilesDir(), u());
            }
            fileU = u(this.b);
        }
        return fileU;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        File fileU;
        if (u() == null) {
            return super.getObbDir();
        }
        synchronized (this.u) {
            if (this.pn == null) {
                this.pn = new File(super.getObbDir(), u());
            }
            fileU = u(this.pn);
        }
        return fileU;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        if (u() == null) {
            return super.getObbDirs();
        }
        File[] obbDirs = super.getObbDirs();
        File[] fileArr = new File[obbDirs.length];
        for (int i = 0; i < obbDirs.length; i++) {
            fileArr[i] = u(new File(obbDirs[i], u()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return (i != 0 || u() == null) ? super.getSharedPreferences(str, i) : super.getSharedPreferences(u(str), i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        if (u() == null) {
            return super.moveDatabaseFrom(context, str);
        }
        throw new UnsupportedOperationException("Calling moveDatabaseFrom in plugins is not supported.");
    }

    public File nr() {
        return super.getFilesDir().getParentFile();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        return u() == null ? super.openFileInput(str) : new FileInputStream(u(getFilesDir(), str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i) throws FileNotFoundException {
        return (i != 0 || u() == null) ? super.openFileOutput(str, i) : new FileOutputStream(u(getFilesDir(), str), false);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return (i != 0 || u() == null) ? super.openOrCreateDatabase(str, i, cursorFactory) : super.openOrCreateDatabase(u(str), i, cursorFactory);
    }

    public String u() {
        return "pangle_com.byted.pangle";
    }

    private String u(String str) {
        return u() + "_" + str;
    }

    private static File u(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        if (i == 0 && u() != null) {
            return super.openOrCreateDatabase(u(str), i, cursorFactory, databaseErrorHandler);
        }
        return super.openOrCreateDatabase(str, i, cursorFactory, databaseErrorHandler);
    }

    private static File u(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }
}
