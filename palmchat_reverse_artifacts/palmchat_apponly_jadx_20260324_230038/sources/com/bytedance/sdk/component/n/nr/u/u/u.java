package com.bytedance.sdk.component.n.nr.u.u;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.component.n.u.pn;
import com.qq.gdt.action.ActionUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class u {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile u fx;
    private Context nr;
    private nr u;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.n.nr.u.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0225u extends AbstractCursor {
        private C0225u() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i) {
            return true;
        }
    }

    private u(Context context) {
        try {
            this.nr = context.getApplicationContext();
            if (this.u == null) {
                this.u = new nr();
            }
        } catch (Throwable unused) {
        }
    }

    private Context getContext() {
        return this.nr;
    }

    public static u u(Context context) {
        if (fx == null) {
            synchronized (u.class) {
                if (fx == null) {
                    fx = new u(context);
                }
            }
        }
        return fx;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class nr {
        public nr() {
        }

        private boolean nr(pn pnVar) {
            SQLiteDatabase sQLiteDatabaseU = u(pnVar);
            return sQLiteDatabaseU != null && sQLiteDatabaseU.inTransaction();
        }

        private SQLiteDatabase u(pn pnVar) {
            boolean zNr;
            try {
                SQLiteDatabase sQLiteDatabaseU = pnVar.nr().u(pnVar.getContext());
                if (sQLiteDatabaseU == null || !sQLiteDatabaseU.isOpen()) {
                    return null;
                }
                sQLiteDatabaseU.setLockingEnabled(false);
                return sQLiteDatabaseU;
            } finally {
                if (!zNr) {
                }
            }
        }

        public int delete(pn pnVar, String str, String str2, String[] strArr) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabaseU = u(pnVar);
                if (sQLiteDatabaseU != null) {
                    return sQLiteDatabaseU.delete(str, str2, strArr);
                }
                return 0;
            } catch (Exception e) {
                if (nr(pnVar)) {
                    throw e;
                }
                return 0;
            }
        }

        public long insert(pn pnVar, String str, String str2, ContentValues contentValues) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabaseU = u(pnVar);
                if (sQLiteDatabaseU != null) {
                    return sQLiteDatabaseU.insert(str, str2, contentValues);
                }
                return -1L;
            } catch (Exception e) {
                if (nr(pnVar)) {
                    throw e;
                }
                return -1L;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Cursor query(pn pnVar, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Object[] objArr = 0;
            try {
                SQLiteDatabase sQLiteDatabaseU = u(pnVar);
                return sQLiteDatabaseU != null ? sQLiteDatabaseU.query(str, strArr, str2, strArr2, str3, str4, str5) : null;
            } catch (Throwable th) {
                C0225u c0225u = new C0225u();
                if (nr(pnVar)) {
                    throw th;
                }
                return c0225u;
            }
        }

        public int update(pn pnVar, String str, ContentValues contentValues, String str2, String[] strArr) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabaseU = u(pnVar);
                if (sQLiteDatabaseU != null) {
                    return sQLiteDatabaseU.update(str, contentValues, str2, strArr);
                }
                return 0;
            } catch (Exception e) {
                if (nr(pnVar)) {
                    throw e;
                }
                return 0;
            }
        }

        public synchronized void insert(pn pnVar, String str, String str2, List<com.bytedance.sdk.component.n.u.nr> list) {
            JSONObject jSONObjectX;
            SQLiteDatabase sQLiteDatabaseU = null;
            try {
                try {
                    sQLiteDatabaseU = u(pnVar);
                    if (sQLiteDatabaseU != null) {
                        sQLiteDatabaseU.beginTransaction();
                        ContentValues contentValues = new ContentValues();
                        for (int i = 0; i < list.size(); i++) {
                            com.bytedance.sdk.component.n.u.nr nrVar = list.get(i);
                            if (nrVar != null && (jSONObjectX = nrVar.x()) != null) {
                                contentValues.put("id", nrVar.fx());
                                String strNr = pnVar.b().nr(jSONObjectX.toString());
                                if (!TextUtils.isEmpty(strNr)) {
                                    contentValues.put(ActionUtils.PAYMENT_AMOUNT, strNr);
                                    contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                                    contentValues.put("retry", (Integer) 0);
                                    contentValues.put("encrypt", (Integer) 1);
                                    sQLiteDatabaseU.insert(str, str2, contentValues);
                                }
                                contentValues.clear();
                            }
                        }
                        sQLiteDatabaseU.setTransactionSuccessful();
                        list.size();
                    }
                } catch (Exception e) {
                    list.size();
                    if (nr(pnVar)) {
                        throw e;
                    }
                    if (sQLiteDatabaseU != null) {
                        sQLiteDatabaseU.endTransaction();
                    }
                }
            } finally {
                if (sQLiteDatabaseU != null) {
                    sQLiteDatabaseU.endTransaction();
                }
            }
        }

        public void u(pn pnVar, String str) throws SQLException {
            try {
                SQLiteDatabase sQLiteDatabaseU = u(pnVar);
                if (sQLiteDatabaseU != null) {
                    sQLiteDatabaseU.execSQL(str);
                }
            } catch (Throwable th) {
                if (nr(pnVar)) {
                    throw th;
                }
            }
        }
    }

    public nr u() {
        return this.u;
    }
}
