package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.zenmen.palmchat.database.a;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class wf5 extends SQLiteOpenHelper {
    public static String e = "social.db";
    public static String f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21692a;
    public Context b;
    public String c;
    public a d;

    public wf5(Context context, String str) {
        super(context, e(str), null, 50, new e05());
        this.f21692a = getClass().getSimpleName();
        this.b = context;
        this.c = str;
        f = context.getDatabasePath(getDatabaseName()).getPath();
        this.d = new a(this.b, this.c);
    }

    public static String e(String str) {
        return str + e;
    }

    public void c() {
        boolean zF = f("tb_threads", "pin_gift_message");
        if (!zF) {
            d(getWritableDatabase(), "alter table tb_threads add column pin_gift_message int default 0;");
        }
        boolean zF2 = f("tb_threads", "has_unread_gift_message");
        if (!zF2) {
            d(getWritableDatabase(), "alter table tb_threads add column has_unread_gift_message int default 0;");
        }
        boolean zF3 = f("tb_threads", "pin_gift_message_last_time_stamp");
        if (!zF3) {
            d(getWritableDatabase(), "alter table tb_threads add column pin_gift_message_last_time_stamp INTEGER; ");
        }
        boolean zF4 = f("tb_threads", "is_super_greetings");
        if (!zF4) {
            d(getWritableDatabase(), "alter table tb_threads add column is_super_greetings int default 0;");
        }
        boolean zF5 = f("tb_threads", "super_greetings_time_stamp");
        if (!zF5) {
            d(getWritableDatabase(), "alter table tb_threads add column super_greetings_time_stamp INTEGER; ");
        }
        if (zF && zF2 && zF3 && zF4 && zF5) {
            return;
        }
        LogUtil.log4ClientError("checkAndFixDBError", null, null, true);
    }

    public final void d(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final boolean f(String str, String str2) {
        String[] strArr = {str, "%" + str2 + "%"};
        Cursor cursorRawQuery = null;
        boolean z = false;
        try {
            try {
                cursorRawQuery = getWritableDatabase().rawQuery("select * from sqlite_master where name = ? and sql like ?", strArr);
                if (cursorRawQuery != null) {
                    if (cursorRawQuery.moveToFirst()) {
                        z = true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursorRawQuery != null) {
                }
            }
            return z;
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    public boolean g() {
        return this.d.d();
    }

    public void h() {
        this.d.f();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
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
        LogUtil.d(this.f21692a, "onCreate");
        sQLiteDatabase.execSQL(ho3.c("tb_messages"));
        sQLiteDatabase.execSQL(ho3.b("tb_temp_messages"));
        sQLiteDatabase.execSQL(ho3.c("tb_temp_messages"));
        h();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        LogUtil.d("logdb", "social: downgrade begin --> from version " + i + " to " + i2);
        LogUtil.d("logdb", "social: downgrade end --> from version " + i + " to " + i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        LogUtil.d("logdb", "social: open version " + sQLiteDatabase.getVersion());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        LogUtil.d(this.f21692a, "onUpgrade oldVersion:" + i + " newVersion:" + i2);
        LogUtil.d("logdb", "social: upgrade begin --> from version " + i + " to " + i2);
        switch (i) {
            case 30:
                d(sQLiteDatabase, "alter table tb_contacts add column account_type int default 0;");
            case 31:
                d(sQLiteDatabase, ue6.a());
            case 32:
                d(sQLiteDatabase, "alter table tb_groups add column group_extra_info TEXT; ");
                d(sQLiteDatabase, "alter table tb_groups add column group_categoryId TEXT; ");
            case 33:
                d(sQLiteDatabase, s56.a());
            case 34:
            case 35:
                d(sQLiteDatabase, "alter table tb_account add column refresh_key TEXT; ");
            case 36:
                d(sQLiteDatabase, "alter table tb_contact_requests add column applyFriendTime TEXT; ");
                d(sQLiteDatabase, "alter table tb_contact_requests add column cycleTime TEXT; ");
            case 37:
                d(sQLiteDatabase, "alter table tb_contact_requests add column blankTime TEXT; ");
            case 38:
            case 39:
                d(sQLiteDatabase, "alter table tb_contact_requests add column expireTime TEXT; ");
                d(sQLiteDatabase, "alter table tb_contact_requests add column operateTime TEXT; ");
                d(sQLiteDatabase, "alter table tb_contact_requests add column deleteTime TEXT; ");
                d(sQLiteDatabase, "alter table tb_contact_requests add column recommendTitle TEXT; ");
                d(sQLiteDatabase, "alter table tb_contact_requests add column recommendText TEXT; ");
            case 40:
                d(sQLiteDatabase, bd1.a());
            case 41:
                d(sQLiteDatabase, "alter table tb_contact_requests add column commonFrds int default 0; ");
            case 42:
                d(sQLiteDatabase, "alter table tb_contact_requests add column applyTime LONG; ");
                d(sQLiteDatabase, "alter table tb_contact_requests add column applyExpireSec LONG; ");
            case 43:
                d(sQLiteDatabase, "alter table tb_contact_requests add column readTime LONG; ");
            case 44:
                d(sQLiteDatabase, "update tb_contact_requests set read_status = 1 where read_status = 2");
                d(sQLiteDatabase, "alter table tb_contact_requests add column disShowTime LONG; ");
            case 45:
                d(sQLiteDatabase, "alter table tb_contact_requests add column insert_date TEXT; ");
            case 46:
                sQLiteDatabase.execSQL(ho3.b("tb_temp_messages"));
                sQLiteDatabase.execSQL(ho3.c("tb_temp_messages"));
            case 47:
                d(sQLiteDatabase, "alter table tb_threads add column is_super_greetings int default 0;");
                d(sQLiteDatabase, "alter table tb_threads add column super_greetings_time_stamp INTEGER; ");
            case 48:
                d(sQLiteDatabase, "alter table tb_group_members add column extra_json TEXT; ");
            case 49:
                d(sQLiteDatabase, "alter table tb_threads add column pin_gift_message int default 0;");
                d(sQLiteDatabase, "alter table tb_threads add column pin_gift_message_last_time_stamp INTEGER; ");
                d(sQLiteDatabase, "alter table tb_threads add column has_unread_gift_message int default 0;");
                break;
        }
        LogUtil.d("logdb", "social: upgrade end --> from version " + i + " to " + i2);
    }
}
