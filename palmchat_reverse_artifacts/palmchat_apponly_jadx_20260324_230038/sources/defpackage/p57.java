package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.analytics.pro.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class p57 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SQLiteOpenHelper f19945a;
    public Context b;
    public boolean c = true;
    public int d = 0;
    public long e = 0;
    public boolean f = false;

    public p57(Context context, SQLiteOpenHelper sQLiteOpenHelper) {
        try {
            this.f19945a = sQLiteOpenHelper;
            this.b = context;
        } catch (Exception e) {
            g57.a(e);
        }
    }

    public Cursor a(int i) {
        Object objValueOf;
        r67 r67VarA;
        long j;
        Object objB;
        r67 r67VarA2;
        Object objC;
        String str = "zm_data_pubinfomd5";
        String str2 = "zm_data_sessionid";
        String str3 = "zm_data_thirdid";
        try {
            switch (i) {
                case 2:
                    objValueOf = Integer.valueOf(this.d);
                    str2 = "activity_started_count";
                    String str4 = str2;
                    objC = objValueOf;
                    str = str4;
                    break;
                case 3:
                    objValueOf = Long.valueOf(this.e);
                    str2 = "app_start_time";
                    String str42 = str2;
                    objC = objValueOf;
                    str = str42;
                    break;
                case 4:
                    r67VarA = r67.a();
                    j = 0L;
                    str3 = "app_end_time";
                    objB = r67VarA.b(str3, j);
                    objC = objB;
                    str = str3;
                    break;
                case 5:
                    r67VarA = r67.a();
                    j = 0L;
                    str3 = "app_first_start";
                    objB = r67VarA.b(str3, j);
                    objC = objB;
                    str = str3;
                    break;
                case 6:
                    r67VarA2 = r67.a();
                    str2 = "app_end_data";
                    objValueOf = r67VarA2.c(str2, "");
                    String str422 = str2;
                    objC = objValueOf;
                    str = str422;
                    break;
                case 7:
                    r67VarA2 = r67.a();
                    str2 = "zm_data_imei";
                    objValueOf = r67VarA2.c(str2, "");
                    String str4222 = str2;
                    objC = objValueOf;
                    str = str4222;
                    break;
                case 8:
                    r67VarA2 = r67.a();
                    str2 = "zm_data_imsi";
                    objValueOf = r67VarA2.c(str2, "");
                    String str42222 = str2;
                    objC = objValueOf;
                    str = str42222;
                    break;
                case 9:
                    r67VarA2 = r67.a();
                    str2 = "zm_data_meid";
                    objValueOf = r67VarA2.c(str2, "");
                    String str422222 = str2;
                    objC = objValueOf;
                    str = str422222;
                    break;
                case 10:
                    objC = r67.a().c("zm_data_iccid", "");
                    str = "zm_data_iccid";
                    break;
                case 11:
                    objC = r67.a().c("zm_data_mac", "");
                    str = "zm_data_mac";
                    break;
                case 12:
                    objC = r67.a().c("zm_data_sn", "");
                    str = "zm_data_sn";
                    break;
                case 13:
                    objC = r67.a().c("zm_data_androidid", "");
                    str = "zm_data_androidid";
                    break;
                case 14:
                    objC = r67.a().c("zm_data_oaid", "");
                    str = "zm_data_oaid";
                    break;
                case 15:
                    objC = r67.a().c("zm_data_lat", "");
                    str = "zm_data_lat";
                    break;
                case 16:
                    objC = r67.a().c("zm_data_lon", "");
                    str = "zm_data_lon";
                    break;
                case 17:
                    objC = r67.a().c("zm_data_carrier", "");
                    str = "zm_data_carrier";
                    break;
                case 18:
                    objC = r67.a().c("zm_data_nettype", "");
                    str = "zm_data_nettype";
                    break;
                case 19:
                    objC = r67.a().c("zm_data_installApp", "");
                    str = "zm_data_installApp";
                    break;
                case 20:
                    objValueOf = Integer.valueOf(this.f ? 1 : 0);
                    str2 = "sub_process_flush_data";
                    String str4222222 = str2;
                    objC = objValueOf;
                    str = str4222222;
                    break;
                case 21:
                    objC = r67.a().c("zm_data_loginid", "");
                    str = "zm_data_loginid";
                    break;
                case 22:
                    objB = r67.a().c("zm_data_thirdid", "");
                    objC = objB;
                    str = str3;
                    break;
                case 23:
                    r67VarA2 = r67.a();
                    objValueOf = r67VarA2.c(str2, "");
                    String str42222222 = str2;
                    objC = objValueOf;
                    str = str42222222;
                    break;
                case 24:
                    objC = r67.a().c("zm_data_pubinfomd5", "");
                    break;
                case 25:
                default:
                    str = null;
                    objC = null;
                    break;
                case 26:
                    objValueOf = r67.a().c("zm_data_remote_config", "");
                    str2 = "zm_data_remote_config";
                    String str422222222 = str2;
                    objC = objValueOf;
                    str = str422222222;
                    break;
            }
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{str});
            matrixCursor.addRow(new Object[]{objC});
            return matrixCursor;
        } catch (Exception e) {
            g57.a(e);
            return null;
        }
    }

    public final SQLiteDatabase b() {
        try {
            if (!this.b.getDatabasePath("cdadatadb").exists()) {
                this.f19945a.close();
                this.c = true;
            }
            return this.f19945a.getWritableDatabase();
        } catch (SQLiteException e) {
            g57.a(e);
            this.c = false;
            return null;
        }
    }

    public void c(int i, ContentValues contentValues) {
        r67 r67VarA;
        String str;
        long jLongValue;
        r67 r67VarA2;
        r67 r67VarA3;
        String str2;
        String str3;
        try {
            switch (i) {
                case 2:
                    this.d = contentValues.getAsInteger("activity_started_count").intValue();
                    return;
                case 3:
                    this.e = contentValues.getAsLong("app_start_time").longValue();
                    return;
                case 4:
                    r67VarA = r67.a();
                    str = "app_end_time";
                    jLongValue = contentValues.getAsLong("app_end_time").longValue();
                    r67VarA.d(str, jLongValue);
                    return;
                case 5:
                    r67VarA = r67.a();
                    str = "app_first_start";
                    jLongValue = contentValues.getAsInteger("app_first_start").intValue();
                    r67VarA.d(str, jLongValue);
                    return;
                case 6:
                    r67VarA2 = r67.a();
                    String asString = contentValues.getAsString("app_end_data");
                    synchronized (r67VarA2) {
                        r67VarA2.f20404a.edit().putString("app_end_data", asString).apply();
                        return;
                    }
                case 7:
                    r67VarA2 = r67.a();
                    String asString2 = contentValues.getAsString("zm_data_imei");
                    synchronized (r67VarA2) {
                        r67VarA2.f20404a.edit().putString("zm_data_imei", asString2).apply();
                        return;
                    }
                case 8:
                    r67VarA2 = r67.a();
                    String asString3 = contentValues.getAsString("zm_data_imsi");
                    synchronized (r67VarA2) {
                        r67VarA2.f20404a.edit().putString("zm_data_imsi", asString3).apply();
                        return;
                    }
                case 9:
                    r67VarA2 = r67.a();
                    String asString4 = contentValues.getAsString("zm_data_meid");
                    synchronized (r67VarA2) {
                        r67VarA2.f20404a.edit().putString("zm_data_meid", asString4).apply();
                        return;
                    }
                case 10:
                    r67VarA3 = r67.a();
                    str2 = "zm_data_iccid";
                    str3 = "zm_data_iccid";
                    r67VarA3.e(str2, contentValues.getAsString(str3));
                    return;
                case 11:
                    r67VarA3 = r67.a();
                    str2 = "zm_data_mac";
                    str3 = "zm_data_mac";
                    r67VarA3.e(str2, contentValues.getAsString(str3));
                    return;
                case 12:
                    r67VarA3 = r67.a();
                    str2 = "zm_data_sn";
                    str3 = "zm_data_sn";
                    r67VarA3.e(str2, contentValues.getAsString(str3));
                    return;
                case 13:
                    r67VarA3 = r67.a();
                    str2 = "zm_data_androidid";
                    str3 = "zm_data_androidid";
                    r67VarA3.e(str2, contentValues.getAsString(str3));
                    return;
                case 14:
                    r67VarA3 = r67.a();
                    str2 = "zm_data_oaid";
                    str3 = "zm_data_oaid";
                    r67VarA3.e(str2, contentValues.getAsString(str3));
                    return;
                case 15:
                    r67VarA3 = r67.a();
                    str2 = "zm_data_lat";
                    str3 = "zm_data_lat";
                    r67VarA3.e(str2, contentValues.getAsString(str3));
                    return;
                case 16:
                    r67VarA3 = r67.a();
                    str2 = "zm_data_lon";
                    str3 = "zm_data_lon";
                    r67VarA3.e(str2, contentValues.getAsString(str3));
                    return;
                case 17:
                    r67VarA3 = r67.a();
                    str2 = "zm_data_carrier";
                    str3 = "zm_data_carrier";
                    r67VarA3.e(str2, contentValues.getAsString(str3));
                    return;
                case 18:
                    r67VarA3 = r67.a();
                    str2 = "zm_data_nettype";
                    str3 = "zm_data_nettype";
                    r67VarA3.e(str2, contentValues.getAsString(str3));
                    return;
                case 19:
                    r67VarA3 = r67.a();
                    str2 = "zm_data_installApp";
                    str3 = "zm_data_installApp";
                    r67VarA3.e(str2, contentValues.getAsString(str3));
                    return;
                case 20:
                    this.f = contentValues.getAsBoolean("sub_process_flush_data").booleanValue();
                    return;
                case 21:
                    r67VarA3 = r67.a();
                    str2 = "zm_data_loginid";
                    str3 = "zm_data_loginid";
                    r67VarA3.e(str2, contentValues.getAsString(str3));
                    return;
                case 22:
                    r67VarA3 = r67.a();
                    str2 = "zm_data_thirdid";
                    str3 = "zm_data_thirdid";
                    r67VarA3.e(str2, contentValues.getAsString(str3));
                    return;
                case 23:
                    r67VarA3 = r67.a();
                    str2 = "zm_data_sessionid";
                    str3 = "zm_data_sessionid";
                    r67VarA3.e(str2, contentValues.getAsString(str3));
                    return;
                case 24:
                    r67VarA3 = r67.a();
                    str2 = "zm_data_pubinfomd5";
                    str3 = "zm_data_pubinfomd5";
                    r67VarA3.e(str2, contentValues.getAsString(str3));
                    return;
                case 25:
                default:
                    return;
                case 26:
                    r67VarA3 = r67.a();
                    str2 = "zm_data_remote_config";
                    str3 = "zm_data_remote_config";
                    r67VarA3.e(str2, contentValues.getAsString(str3));
                    return;
            }
        } catch (Exception e) {
            g57.a(e);
        }
    }

    public void d(UriMatcher uriMatcher, String str) {
        try {
            uriMatcher.addURI(str, f.ax, 1);
            uriMatcher.addURI(str, "activity_started_count", 2);
            uriMatcher.addURI(str, "app_start_time", 3);
            uriMatcher.addURI(str, "app_end_time", 4);
            uriMatcher.addURI(str, "app_first_start", 5);
            uriMatcher.addURI(str, "app_end_data", 6);
            uriMatcher.addURI(str, "zm_data_imei", 7);
            uriMatcher.addURI(str, "zm_data_imsi", 8);
            uriMatcher.addURI(str, "zm_data_meid", 9);
            uriMatcher.addURI(str, "zm_data_iccid", 10);
            uriMatcher.addURI(str, "zm_data_mac", 11);
            uriMatcher.addURI(str, "zm_data_sn", 12);
            uriMatcher.addURI(str, "zm_data_androidid", 13);
            uriMatcher.addURI(str, "zm_data_oaid", 14);
            uriMatcher.addURI(str, "zm_data_lat", 15);
            uriMatcher.addURI(str, "zm_data_lon", 16);
            uriMatcher.addURI(str, "zm_data_carrier", 17);
            uriMatcher.addURI(str, "zm_data_nettype", 18);
            uriMatcher.addURI(str, "zm_data_installApp", 19);
            uriMatcher.addURI(str, "sub_process_flush_data", 20);
            uriMatcher.addURI(str, "zm_data_loginid", 21);
            uriMatcher.addURI(str, "zm_data_thirdid", 22);
            uriMatcher.addURI(str, "zm_data_sessionid", 23);
            uriMatcher.addURI(str, "zm_data_pubinfomd5", 24);
            uriMatcher.addURI(str, "zm_data_remote_config", 26);
        } catch (Exception e) {
            g57.a(e);
        }
    }
}
