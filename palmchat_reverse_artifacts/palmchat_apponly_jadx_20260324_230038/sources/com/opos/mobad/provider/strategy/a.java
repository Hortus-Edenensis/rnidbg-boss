package com.opos.mobad.provider.strategy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ReadWriteLock f9180a;

    public a(Context context) {
        super(context, "opos_mobad_app", (SQLiteDatabase.CursorFactory) null, 1);
        this.f9180a = new ReentrantReadWriteLock();
    }

    public AppInfo a() throws Throwable {
        Cursor cursorQuery;
        Throwable th;
        Lock lock = this.f9180a.readLock();
        try {
            lock.lock();
            cursorQuery = getWritableDatabase().query("app", null, null, null, null, null, "lmTime desc", "1");
        } catch (Exception e) {
            e = e;
            cursorQuery = null;
        } catch (Throwable th2) {
            cursorQuery = null;
            th = th2;
        }
        if (cursorQuery != null) {
            try {
                try {
                    if (cursorQuery.moveToFirst()) {
                        AppInfo appInfo = new AppInfo(cursorQuery.getLong(cursorQuery.getColumnIndex("expTime")), cursorQuery.getBlob(cursorQuery.getColumnIndex("data")));
                        try {
                            cursorQuery.close();
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.b("MobConfig", "close err", e2);
                        }
                        lock.unlock();
                        return appInfo;
                    }
                } catch (Exception e3) {
                    e = e3;
                    com.opos.cmn.an.f.a.b("MobConfig", "get app fail", e);
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Exception e4) {
                            com.opos.cmn.an.f.a.b("MobConfig", "close err", e4);
                        }
                    }
                    lock.unlock();
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            th = th3;
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception e5) {
                    com.opos.cmn.an.f.a.b("MobConfig", "close err", e5);
                }
            }
            lock.unlock();
            throw th;
        }
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Exception e6) {
                com.opos.cmn.an.f.a.b("MobConfig", "close err", e6);
            }
        }
        lock.unlock();
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0061, code lost:
    
        r15 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0062, code lost:
    
        com.opos.cmn.an.f.a.b("MobConfig", "close err", r15);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bundle b(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        Lock lock = this.f9180a.readLock();
        try {
            try {
                lock.lock();
                cursorQuery = getWritableDatabase().query("pos", null, "appId=?", new String[]{str}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            int columnIndex = cursorQuery.getColumnIndex("posId");
                            int columnIndex2 = cursorQuery.getColumnIndex("stgVer");
                            int columnIndex3 = cursorQuery.getColumnIndex("data");
                            Bundle bundle = new Bundle();
                            do {
                                bundle.putParcelable(cursorQuery.getString(columnIndex), new PosInfo(cursorQuery.getBlob(columnIndex3), cursorQuery.getLong(columnIndex2)));
                            } while (cursorQuery.moveToNext());
                            cursorQuery.close();
                            lock.unlock();
                            return bundle;
                        }
                    } catch (Exception e) {
                        e = e;
                        com.opos.cmn.an.f.a.b("MobConfig", "get pos fail", e);
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Exception e2) {
                                com.opos.cmn.an.f.a.b("MobConfig", "close err", e2);
                            }
                        }
                        lock.unlock();
                        return null;
                    }
                }
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Exception e3) {
                        com.opos.cmn.an.f.a.b("MobConfig", "close err", e3);
                    }
                }
                lock.unlock();
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (str != 0) {
                    try {
                        str.close();
                    } catch (Exception e4) {
                        com.opos.cmn.an.f.a.b("MobConfig", "close err", e4);
                    }
                }
                lock.unlock();
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            str = 0;
            if (str != 0) {
            }
            lock.unlock();
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table app(appId varchar primary key,data blob,expTime interger,lmTime interger);");
        sQLiteDatabase.execSQL("create table pos(posId varchar primary key,appId varchar,data blob,stgVer interger)");
    }

    public AppInfo a(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        Lock lock = this.f9180a.readLock();
        try {
            lock.lock();
            cursorQuery = getWritableDatabase().query("app", null, "appId=?", new String[]{str}, null, null, null);
        } catch (Exception e) {
            e = e;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
        if (cursorQuery != null) {
            try {
                try {
                    if (cursorQuery.moveToFirst()) {
                        AppInfo appInfo = new AppInfo(cursorQuery.getLong(cursorQuery.getColumnIndex("expTime")), cursorQuery.getBlob(cursorQuery.getColumnIndex("data")));
                        try {
                            cursorQuery.close();
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.b("MobConfig", "close err", e2);
                        }
                        lock.unlock();
                        return appInfo;
                    }
                } catch (Exception e3) {
                    e = e3;
                    com.opos.cmn.an.f.a.b("MobConfig", "get app fail", e);
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Exception e4) {
                            com.opos.cmn.an.f.a.b("MobConfig", "close err", e4);
                        }
                    }
                    lock.unlock();
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            th = th3;
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception e5) {
                    com.opos.cmn.an.f.a.b("MobConfig", "close err", e5);
                }
            }
            lock.unlock();
            throw th;
        }
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Exception e6) {
                com.opos.cmn.an.f.a.b("MobConfig", "close err", e6);
            }
        }
        lock.unlock();
        return null;
    }

    private void a(String str, long j) {
        try {
            com.opos.cmn.an.f.a.b("MobConfig", "remove " + getWritableDatabase().delete("pos", "appId=? and stgVer!=?", new String[]{str, String.valueOf(j)}));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("MobConfig", "remove pos fail", e);
        }
    }

    public void a(String str, Bundle bundle, long j) {
        try {
            try {
                this.f9180a.writeLock().lock();
                getWritableDatabase().beginTransaction();
                for (String str2 : bundle.keySet()) {
                    byte[] byteArray = bundle.getByteArray(str2);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appId", str);
                    contentValues.put("posId", str2);
                    contentValues.put("data", byteArray);
                    contentValues.put("stgVer", Long.valueOf(j));
                    getWritableDatabase().replace("pos", null, contentValues);
                }
                getWritableDatabase().setTransactionSuccessful();
            } catch (Throwable th) {
                try {
                    try {
                        getWritableDatabase().endTransaction();
                        a(str, j);
                    } finally {
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("MobConfig", "end err", e);
                }
                throw th;
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("MobConfig", "add pos fail", e2);
            try {
                try {
                    getWritableDatabase().endTransaction();
                    a(str, j);
                } catch (Exception e3) {
                    com.opos.cmn.an.f.a.b("MobConfig", "end err", e3);
                }
            } finally {
            }
        }
        try {
            try {
                getWritableDatabase().endTransaction();
                a(str, j);
            } catch (Exception e4) {
                com.opos.cmn.an.f.a.b("MobConfig", "end err", e4);
            }
        } finally {
        }
    }

    public void a(String str, byte[] bArr, long j) {
        Lock lockWriteLock = this.f9180a.writeLock();
        try {
            try {
                lockWriteLock.lock();
                ContentValues contentValues = new ContentValues();
                contentValues.put("appId", str);
                contentValues.put("data", bArr);
                contentValues.put("expTime", Long.valueOf(j));
                contentValues.put("lmTime", Long.valueOf(System.currentTimeMillis()));
                getWritableDatabase().replace("app", null, contentValues);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("MobConfig", "add fail", e);
            }
        } finally {
            lockWriteLock.unlock();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
