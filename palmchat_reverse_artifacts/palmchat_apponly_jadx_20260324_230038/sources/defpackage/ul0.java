package defpackage;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.lantern.core.configuration.ConfigConstant;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ul0 {

    @SuppressLint({"StaticFieldLeak"})
    public static ul0 d;
    public static final String[] e = {ConfigConstant.COLUMN_EVENTID, "level", ConfigConstant.COLUMN_AVAILABLETIME, ConfigConstant.COLUMN_LIMIT};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, cm0> f21237a = new ConcurrentHashMap();
    public final ContentResolver b;
    public final Uri c;

    public ul0(Context context) {
        this.b = context.getApplicationContext().getContentResolver();
        this.c = ql0.b(context);
        f();
    }

    public static ul0 b(Context context) {
        if (d == null) {
            synchronized (ul0.class) {
                if (d == null) {
                    d = new ul0(context);
                }
            }
        }
        return d;
    }

    public synchronized cm0 a(String str) {
        return this.f21237a.get(str);
    }

    public int c(List<cm0> list) {
        if (list == null) {
            return 0;
        }
        ContentValues[] contentValuesArr = new ContentValues[list.size()];
        for (int i = 0; i < list.size(); i++) {
            cm0 cm0Var = list.get(i);
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConfigConstant.COLUMN_EVENTID, cm0Var.b());
            contentValues.put("level", Integer.valueOf(cm0Var.c()));
            contentValues.put(ConfigConstant.COLUMN_AVAILABLETIME, Long.valueOf(cm0Var.a()));
            contentValues.put(ConfigConstant.COLUMN_LIMIT, Integer.valueOf(cm0Var.d()));
            contentValuesArr[i] = contentValues;
            this.f21237a.put(cm0Var.b(), cm0Var);
        }
        return this.b.bulkInsert(this.c, contentValuesArr);
    }

    public long d(cm0 cm0Var) {
        if (e(cm0Var)) {
            return g(cm0Var);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConfigConstant.COLUMN_EVENTID, cm0Var.b());
        contentValues.put("level", Integer.valueOf(cm0Var.c()));
        contentValues.put(ConfigConstant.COLUMN_AVAILABLETIME, Long.valueOf(cm0Var.a()));
        contentValues.put(ConfigConstant.COLUMN_LIMIT, Integer.valueOf(cm0Var.d()));
        this.f21237a.put(cm0Var.b(), cm0Var);
        Uri uriInsert = this.b.insert(this.c, contentValues);
        if (uriInsert == null || uriInsert.getLastPathSegment() == null) {
            return 0L;
        }
        return Long.parseLong(uriInsert.getLastPathSegment());
    }

    public final boolean e(cm0 cm0Var) {
        Cursor cursorQuery = this.b.query(this.c, null, "eventid = ? ", new String[]{cm0Var.b()}, null);
        if (cursorQuery == null || cursorQuery.getCount() == 0) {
            return false;
        }
        try {
            Log.e("CX_EVENT", "isExist:TRUE");
            cursorQuery.close();
            return true;
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    @SuppressLint({HttpHeaders.RANGE})
    public final synchronized void f() {
        Cursor cursorQuery = this.b.query(this.c, e, null, null, null);
        try {
            if (cursorQuery == null) {
                return;
            }
            try {
                cursorQuery.moveToFirst();
                while (!cursorQuery.isAfterLast()) {
                    cm0 cm0Var = new cm0();
                    cm0Var.f(cursorQuery.getString(cursorQuery.getColumnIndex(ConfigConstant.COLUMN_EVENTID)));
                    cm0Var.g(cursorQuery.getInt(cursorQuery.getColumnIndex("level")));
                    cm0Var.e(cursorQuery.getLong(cursorQuery.getColumnIndex(ConfigConstant.COLUMN_AVAILABLETIME)));
                    cm0Var.h(cursorQuery.getInt(cursorQuery.getColumnIndex(ConfigConstant.COLUMN_LIMIT)));
                    this.f21237a.put(cm0Var.b(), cm0Var);
                    cursorQuery.moveToNext();
                }
            } catch (Exception e2) {
                Log.e("CX_EVENT", "ex:" + e2.getMessage());
            }
        } finally {
            cursorQuery.close();
        }
    }

    public final long g(cm0 cm0Var) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("level", Integer.valueOf(cm0Var.c()));
        contentValues.put(ConfigConstant.COLUMN_AVAILABLETIME, Long.valueOf(cm0Var.a()));
        contentValues.put(ConfigConstant.COLUMN_LIMIT, Integer.valueOf(cm0Var.d()));
        return this.b.update(this.c, contentValues, "eventid = ? ", new String[]{cm0Var.b()});
    }

    public void h(List<cm0> list) {
        Iterator<cm0> it = list.iterator();
        while (it.hasNext()) {
            Log.i("CX_EVENT", "update row:" + d(it.next()));
        }
    }
}
