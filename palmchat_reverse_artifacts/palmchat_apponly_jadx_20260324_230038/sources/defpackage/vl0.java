package defpackage;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.lantern.core.business.ParamHelper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class vl0 extends SQLiteOpenHelper {
    public static final String b = "vl0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21472a;

    public vl0(Context context) {
        super(context, "cx_config.db", (SQLiteDatabase.CursorFactory) null, 1000);
        this.f21472a = context;
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            boolean zD = bm0.d(sQLiteDatabase, "configuration_data");
            Log.e("CX_EVENT", "createConfigTable, exist:" + zD);
            if (zD) {
                return;
            }
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS configuration_data(_id INTEGER PRIMARY KEY AUTOINCREMENT,eventid TEXT, level INTEGER, availbletime LONG, eventlimit INTEGER); ");
            bm0.e(this.f21472a);
        } catch (SQLException unused) {
            Log.e(b, "couldn't create config table in database");
        } catch (Exception e) {
            Log.e(b, "couldn't create config table in database, ex:" + e.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Log.i("CX_EVENT", "ConfigOpenHelper onCreate!");
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        super.onDowngrade(sQLiteDatabase, i, i2);
        Log.i("CX_EVENT", "onDowngrade oldVersion:" + i + "; newVersion:" + i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Log.i("CX_EVENT", "onUpgrade oldVersion:" + i + "; newVersion:" + i2);
        StringBuilder sb = new StringBuilder();
        sb.append("onUpgrade advanceList size:");
        sb.append(ParamHelper.getAdvancedPresetEventList().size());
        Log.i("CX_EVENT", sb.toString());
    }
}
