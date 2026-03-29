package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ju implements Cloneable {
    private static final SimpleDateFormat l = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5060a;
    public String b;
    public long fx;
    public String iz;
    public int jk;
    public String n;
    public long nr;
    public long pn;
    String t;
    long u;
    public String x;

    public ju() {
        u(0L);
    }

    public static String nr(long j) {
        return l.format(new Date(j));
    }

    public String a() {
        return null;
    }

    @NonNull
    public abstract String b();

    public final String fx() {
        List<String> listU = u();
        if (listU == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ");
        sb.append(b());
        sb.append("(");
        for (int i = 0; i < listU.size(); i += 2) {
            sb.append(listU.get(i));
            sb.append(" ");
            sb.append(listU.get(i + 1));
            sb.append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        return sb.toString();
    }

    @NonNull
    public final JSONObject iz() {
        try {
            this.t = nr(this.nr);
            return nr();
        } catch (JSONException e) {
            ti.nr(e);
            return null;
        }
    }

    public String n() {
        return "sid:" + this.b;
    }

    public abstract JSONObject nr();

    @NonNull
    public final JSONObject pn() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", b());
            u(jSONObject);
        } catch (JSONException e) {
            ti.nr(e);
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        String strB = b();
        if (!getClass().getSimpleName().equalsIgnoreCase(strB)) {
            strB = strB + ", " + getClass().getSimpleName();
        }
        String strSubstring = this.b;
        String str = "-";
        if (strSubstring != null) {
            int iIndexOf = strSubstring.indexOf("-");
            if (iIndexOf >= 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
            str = strSubstring;
        }
        return "{" + strB + ", " + n() + ", " + str + ", " + this.nr + "}";
    }

    public void u(long j) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        this.nr = j;
    }

    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public ju clone() {
        try {
            return (ju) super.clone();
        } catch (CloneNotSupportedException e) {
            ti.nr(e);
            return null;
        }
    }

    public ju nr(@NonNull JSONObject jSONObject) {
        this.nr = jSONObject.optLong("local_time_ms", 0L);
        this.u = 0L;
        this.fx = 0L;
        this.f5060a = 0;
        this.pn = 0L;
        this.b = null;
        this.iz = null;
        this.x = null;
        this.n = null;
        return this;
    }

    public List<String> u() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", "integer", "tea_event_index", "integer", "nt", "integer", "user_id", "integer", "session_id", "varchar", "user_unique_id", "varchar", "ssid", "varchar", "ab_sdk_version", "varchar", "event_type", "integer");
    }

    public int u(@NonNull Cursor cursor) {
        this.u = cursor.getLong(0);
        this.nr = cursor.getLong(1);
        this.fx = cursor.getLong(2);
        this.f5060a = cursor.getInt(3);
        this.pn = cursor.getLong(4);
        this.b = cursor.getString(5);
        this.iz = cursor.getString(6);
        this.x = cursor.getString(7);
        this.n = cursor.getString(8);
        this.jk = cursor.getInt(9);
        return 10;
    }

    public final ContentValues nr(@Nullable ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        u(contentValues);
        return contentValues;
    }

    public void u(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.nr));
        contentValues.put("tea_event_index", Long.valueOf(this.fx));
        contentValues.put("nt", Integer.valueOf(this.f5060a));
        contentValues.put("user_id", Long.valueOf(this.pn));
        contentValues.put("session_id", this.b);
        contentValues.put("user_unique_id", this.iz);
        contentValues.put("ssid", this.x);
        contentValues.put("ab_sdk_version", this.n);
        contentValues.put("event_type", Integer.valueOf(this.jk));
    }

    public void u(@NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("local_time_ms", this.nr);
    }

    public static ju u(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return zx.nr.get(jSONObject.optString("k_cls", "")).clone().nr(jSONObject);
        } catch (Throwable th) {
            ti.nr(th);
            return null;
        }
    }
}
