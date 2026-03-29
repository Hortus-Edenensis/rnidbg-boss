package com.lantern.core.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;
import com.lantern.core.business.Event;
import defpackage.cn1;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SqliteDataStore extends SQLiteOpenHelper {
    private final String DbField_EVENT_EXTRA;
    private final String DbField_EVENT_ID;
    private final String DbField_EVENT_LEVEL;
    private final String DbField_EVENT_PUB;
    private final String DbField_EVENT_SOURCE;
    private final String DbField_EVENT_STATE;
    private final String DbField_EVENT_TC;
    private final String DbField_KEY_TIME;
    private final String EVENT_TABLE_NAME;
    private Context mContext;
    private IDbErrListener mDbErrListener;
    private SpDataStore mSpStore;

    /* JADX INFO: compiled from: SearchBox */
    public interface IDbErrListener {
        void dbError(String str);
    }

    public SqliteDataStore(Context context) {
        super(context, getDBName(context), (SQLiteDatabase.CursorFactory) null, 2);
        this.EVENT_TABLE_NAME = "wk_analytics_table";
        this.DbField_KEY_TIME = "KEY_TIME";
        this.DbField_EVENT_ID = "EVENT_ID";
        this.DbField_EVENT_LEVEL = "EVENT_LEVEL";
        this.DbField_EVENT_PUB = "EVENT_PUB";
        this.DbField_EVENT_EXTRA = "EVENT_BODY";
        this.DbField_EVENT_SOURCE = "EVENT_SOURCE";
        this.DbField_EVENT_STATE = "EVENT_APP_STATE";
        this.DbField_EVENT_TC = "EVENT_TAICHI";
        this.mContext = context;
        this.mSpStore = new SpDataStore(context);
    }

    private void createEventTable(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS wk_analytics_table ( KEY_TIME INTEGER PRIMARY KEY,EVENT_ID TEXT NOT NULL,EVENT_LEVEL INTEGER,EVENT_BODY TEXT,EVENT_SOURCE TEXT,EVENT_APP_STATE INTEGER,EVENT_TAICHI BLOB,EVENT_PUB BLOB NOT NULL);");
        } catch (SQLException e) {
            Log.i(DataStoreManager.DB_LOG, e.toString());
            if (this.mDbErrListener != null) {
                this.mDbErrListener.dbError(e.toString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static String getDBName(Context context) {
        return cn1.a(context).replace(".", "_").replace(":", "_") + "_" + DataStoreManager.DB_NAME;
    }

    private void upgradeTo(SQLiteDatabase sQLiteDatabase, int i) {
        if (i != 1) {
            return;
        }
        createEventTable(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        super.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060 A[DONT_GENERATE, PHI: r2
      0x0060: PHI (r2v4 java.lang.String) = (r2v1 java.lang.String), (r2v1 java.lang.String), (r2v6 java.lang.String) binds: [B:13:0x0057, B:14:0x0059, B:18:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void deleteExtraData() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            Cursor cursorRawQuery = writableDatabase.rawQuery("select count(*) from wk_analytics_table", null);
            String str = "";
            if (cursorRawQuery != null) {
                try {
                    try {
                        cursorRawQuery.moveToFirst();
                        long j = cursorRawQuery.getLong(0);
                        if (j > 100) {
                            str = "delete from wk_analytics_table where KEY_TIME in ( " + ("select KEY_TIME from wk_analytics_table order by KEY_TIME ASC limit " + (((int) j) / 2)) + " )";
                        }
                    } catch (Exception e) {
                        Log.i(DataStoreManager.DB_LOG, e.toString());
                        IDbErrListener iDbErrListener = this.mDbErrListener;
                        if (iDbErrListener != null) {
                            iDbErrListener.dbError(e.toString());
                        }
                    }
                    if (cursorRawQuery != null) {
                    }
                } finally {
                    cursorRawQuery.close();
                }
            } else if (cursorRawQuery != null) {
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            writableDatabase.execSQL(str);
        } catch (Exception unused) {
        }
    }

    public boolean deleteListItem(String str) {
        try {
            String str2 = "delete from wk_analytics_table where KEY_TIME in " + str;
            try {
                if (getWritableDatabase().compileStatement(str2).executeUpdateDelete() > 0) {
                    return true;
                }
                IDbErrListener iDbErrListener = this.mDbErrListener;
                if (iDbErrListener == null) {
                    return false;
                }
                iDbErrListener.dbError("delete fail, sql:[" + str2 + "]");
                return false;
            } catch (SQLException e) {
                Log.i(DataStoreManager.DB_LOG, e.toString());
                IDbErrListener iDbErrListener2 = this.mDbErrListener;
                if (iDbErrListener2 != null) {
                    iDbErrListener2.dbError(e.toString());
                }
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (Throwable unused) {
        }
    }

    public boolean deleteOneItem(String str) {
        try {
            try {
                getWritableDatabase().delete("wk_analytics_table", "KEY_TIME = ?", new String[]{str});
                return true;
            } catch (SQLException e) {
                Log.i(DataStoreManager.DB_LOG, e.toString());
                IDbErrListener iDbErrListener = this.mDbErrListener;
                if (iDbErrListener == null) {
                    return false;
                }
                iDbErrListener.dbError(e.toString());
                return false;
            }
        } catch (Exception unused) {
            return false;
        }
    }

    public void dropEventTable(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS wk_analytics_table");
        } catch (SQLException e) {
            Log.i(DataStoreManager.DB_LOG, e.toString());
            if (this.mDbErrListener != null) {
                this.mDbErrListener.dbError(e.toString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @SuppressLint({HttpHeaders.RANGE})
    public List<Event> getEventList(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            String[] strArr = {String.valueOf(str)};
            Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = readableDatabase.query("wk_analytics_table", null, "EVENT_ID = ? ", strArr, null, null, null);
                    if (cursorQuery != null) {
                        while (cursorQuery.moveToNext()) {
                            Event event = new Event();
                            event.setSaveDateTime(cursorQuery.getLong(cursorQuery.getColumnIndex("KEY_TIME")));
                            event.setEventId(cursorQuery.getString(cursorQuery.getColumnIndex("EVENT_ID")));
                            event.setLevel(cursorQuery.getInt(cursorQuery.getColumnIndex("EVENT_LEVEL")));
                            event.setPubParams(cursorQuery.getBlob(cursorQuery.getColumnIndex("EVENT_PUB")));
                            event.setExtra(cursorQuery.getString(cursorQuery.getColumnIndex("EVENT_BODY")));
                            event.setSource(cursorQuery.getString(cursorQuery.getColumnIndex("EVENT_SOURCE")));
                            event.setState(cursorQuery.getInt(cursorQuery.getColumnIndex("EVENT_APP_STATE")));
                            event.setTaiChi(cursorQuery.getBlob(cursorQuery.getColumnIndex("EVENT_TAICHI")));
                            event.setSaveSrc(0);
                            arrayList.add(event);
                        }
                    }
                } catch (Exception e) {
                    Log.i(DataStoreManager.DB_LOG, e.toString());
                    IDbErrListener iDbErrListener = this.mDbErrListener;
                    if (iDbErrListener != null) {
                        iDbErrListener.dbError(e.toString());
                    }
                    if (cursorQuery != null) {
                    }
                }
                return arrayList;
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } catch (Exception unused) {
            return arrayList;
        }
    }

    public long insertEvent(Event event) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("KEY_TIME", DataStoreUtils.getCurrentKeyTime());
            contentValues.put("EVENT_ID", event.getEventId());
            contentValues.put("EVENT_LEVEL", Integer.valueOf(event.getLevel()));
            contentValues.put("EVENT_PUB", event.getPubParams());
            contentValues.put("EVENT_BODY", event.getExtra());
            contentValues.put("EVENT_SOURCE", event.getSource());
            contentValues.put("EVENT_APP_STATE", Integer.valueOf(event.getState()));
            contentValues.put("EVENT_TAICHI", event.getTaiChi());
            try {
                return writableDatabase.insert("wk_analytics_table", null, contentValues);
            } catch (Exception e) {
                Log.i(DataStoreManager.DB_LOG, e.toString());
                IDbErrListener iDbErrListener = this.mDbErrListener;
                if (iDbErrListener == null) {
                    return -1L;
                }
                iDbErrListener.dbError(e.toString());
                return -1L;
            }
        } catch (Exception unused) {
            return -1L;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        onUpgrade(sQLiteDatabase, 1, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        super.onDowngrade(sQLiteDatabase, i, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i <= i2) {
            upgradeTo(sQLiteDatabase, i);
            i++;
        }
    }

    public void setDbErrListener(IDbErrListener iDbErrListener) {
        this.mDbErrListener = iDbErrListener;
    }

    @SuppressLint({HttpHeaders.RANGE})
    public List<Event> getEventList(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = getReadableDatabase().query(true, "wk_analytics_table", null, "EVENT_LEVEL = ? ", new String[]{String.valueOf(i)}, null, null, "KEY_TIME ASC ", i2 + "");
                    if (cursorQuery != null) {
                        while (cursorQuery.moveToNext()) {
                            Event event = new Event();
                            event.setSaveDateTime(cursorQuery.getLong(cursorQuery.getColumnIndex("KEY_TIME")));
                            event.setEventId(cursorQuery.getString(cursorQuery.getColumnIndex("EVENT_ID")));
                            event.setLevel(cursorQuery.getInt(cursorQuery.getColumnIndex("EVENT_LEVEL")));
                            event.setPubParams(cursorQuery.getBlob(cursorQuery.getColumnIndex("EVENT_PUB")));
                            event.setExtra(cursorQuery.getString(cursorQuery.getColumnIndex("EVENT_BODY")));
                            event.setSource(cursorQuery.getString(cursorQuery.getColumnIndex("EVENT_SOURCE")));
                            event.setState(cursorQuery.getInt(cursorQuery.getColumnIndex("EVENT_APP_STATE")));
                            event.setTaiChi(cursorQuery.getBlob(cursorQuery.getColumnIndex("EVENT_TAICHI")));
                            event.setSaveSrc(0);
                            arrayList.add(event);
                        }
                    }
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } catch (Exception e) {
                Log.i(DataStoreManager.DB_LOG, e.toString());
                IDbErrListener iDbErrListener = this.mDbErrListener;
                if (iDbErrListener != null) {
                    iDbErrListener.dbError(e.toString());
                }
                if (cursorQuery != null) {
                }
            }
            if (arrayList.size() < i2) {
                arrayList.addAll(this.mSpStore.getSpEventList(i, i2 - arrayList.size()));
            }
            return arrayList;
        } catch (Exception unused) {
            return arrayList;
        }
    }
}
