package com.bytedance.sdk.openadsdk.core.jk.u;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.component.n.nr.iz.iz;
import com.bytedance.sdk.component.n.nr.u.u.nr.b;
import com.bytedance.sdk.component.n.nr.u.u.nr.x;
import com.bytedance.sdk.component.utils.k;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends fx {
    private final String nr;

    public nr(Context context, int i) {
        super(context, "ttopensdk.db", i);
        this.nr = "OldSqliteDatabase";
    }

    private void fx(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(iz.fx());
        sQLiteDatabase.execSQL(iz.b());
    }

    private void nr(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.n.nr.u.u.nr.iz.pn("adevent"));
        sQLiteDatabase.execSQL(b.fx("loghighpriority"));
        sQLiteDatabase.execSQL(x.pn("logstats"));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.n.nr.u.u.nr.u.fx("logstatsbatch"));
        fx(sQLiteDatabase, i, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.jk.u.fx
    public void u(SQLiteDatabase sQLiteDatabase, Context context) {
        com.bytedance.sdk.openadsdk.core.qq.nr.fx.get();
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.n.nr.u.u.nr.iz.b("adevent"));
        sQLiteDatabase.execSQL(b.nr("loghighpriority"));
        sQLiteDatabase.execSQL(x.b("logstats"));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.n.nr.u.u.nr.u.nr("logstatsbatch"));
        sQLiteDatabase.execSQL(iz.nr());
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.u.nr.nr.fx());
        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tools.nr.fx());
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.nativeexpress.u.fx.fx());
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS union_meta_cache (id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT,uuid TEXT,create_time TEXT,meta_data TEXT,save_version TEXT,expire_time TEXT,slot_type TEXT,is_using INTEGER,priority TEXT,ad_index INTEGER)");
    }

    @Override // com.bytedance.sdk.openadsdk.core.jk.u.fx
    public void u(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            switch (i) {
                case 1:
                    nr(sQLiteDatabase, i, i2);
                    break;
                case 2:
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                    nr(sQLiteDatabase, i, i2);
                    break;
                case 3:
                    sQLiteDatabase.execSQL(x.b("logstats"));
                    nr(sQLiteDatabase, i, i2);
                    break;
                case 4:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.u.nr.nr.fx());
                    nr(sQLiteDatabase, i, i2);
                    break;
                case 5:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.component.n.nr.u.u.nr.u.nr("logstatsbatch"));
                    nr(sQLiteDatabase, i, i2);
                    break;
                case 6:
                case 8:
                case 9:
                    nr(sQLiteDatabase, i, i2);
                    break;
                case 7:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tools.nr.fx());
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
                    nr(sQLiteDatabase, i, i2);
                    break;
                case 10:
                case 11:
                    try {
                        fx(sQLiteDatabase, i, i2);
                    } catch (Exception e) {
                        k.nr("OldSqliteDatabase", "database onUpgrade error version: " + i + ", msg: " + e.getMessage());
                    }
                    break;
            }
            i++;
        }
    }
}
