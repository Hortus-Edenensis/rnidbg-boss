package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class sf extends ju {
    public int bg;
    public String bq;
    public String k;
    public long l;
    public String mv;
    public String my;
    public String o;
    public String s;
    public String sx;

    private JSONObject l() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_key", this.s);
        jSONObject.put("refer_page_key", this.mv);
        jSONObject.put("is_back", this.bg);
        jSONObject.put("duration", this.l);
        jSONObject.put("page_title", this.k);
        jSONObject.put("refer_page_title", this.my);
        jSONObject.put("page_path", this.o);
        jSONObject.put("referrer_page_path", this.sx);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.ju
    @NonNull
    public String b() {
        return "page";
    }

    public boolean jk() {
        return this.l == -1;
    }

    @Override // com.bytedance.embedapplog.ju
    public String n() {
        return this.s + ", " + this.l;
    }

    @Override // com.bytedance.embedapplog.ju
    public ju nr(@NonNull JSONObject jSONObject) {
        super.nr(jSONObject);
        this.s = jSONObject.optString("page_key", null);
        this.mv = jSONObject.optString("refer_page_key", null);
        this.l = jSONObject.optLong("duration", 0L);
        this.bg = jSONObject.optInt("is_back", 0);
        this.k = jSONObject.optString("page_title", null);
        this.my = jSONObject.optString("refer_page_title", null);
        this.o = jSONObject.optString("page_path", null);
        this.sx = jSONObject.optString("referrer_page_path", null);
        return this;
    }

    public boolean t() {
        return this.s.contains(":");
    }

    @Override // com.bytedance.embedapplog.ju
    public List<String> u() {
        List<String> listU = super.u();
        ArrayList arrayList = new ArrayList(listU.size());
        arrayList.addAll(listU);
        arrayList.addAll(Arrays.asList("page_key", "varchar", "refer_page_key", "varchar", "duration", "integer", "is_back", "integer", "last_session", "varchar", "page_title", "varchar", "refer_page_title", "varchar", "page_path", "varchar", "referrer_page_path", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.ju
    public int u(@NonNull Cursor cursor) {
        int iU = super.u(cursor);
        int i = iU + 1;
        this.s = cursor.getString(iU);
        int i2 = i + 1;
        this.mv = cursor.getString(i);
        int i3 = i2 + 1;
        this.l = cursor.getLong(i2);
        int i4 = i3 + 1;
        this.bg = cursor.getInt(i3);
        int i5 = i4 + 1;
        this.bq = cursor.getString(i4);
        int i6 = i5 + 1;
        this.k = cursor.getString(i5);
        int i7 = i6 + 1;
        this.my = cursor.getString(i6);
        int i8 = i7 + 1;
        this.o = cursor.getString(i7);
        int i9 = i8 + 1;
        this.sx = cursor.getString(i8);
        return i9;
    }

    @Override // com.bytedance.embedapplog.ju
    public JSONObject nr() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.nr);
        jSONObject.put("tea_event_index", this.fx);
        jSONObject.put("session_id", this.b);
        long j = this.pn;
        if (j > 0) {
            jSONObject.put("user_id", j);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.iz) ? JSONObject.NULL : this.iz);
        if (!TextUtils.isEmpty(this.x)) {
            jSONObject.put("ssid", this.x);
        }
        jSONObject.put("event", "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put("params", l());
        jSONObject.put("datetime", this.t);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.ju
    public void u(@NonNull ContentValues contentValues) {
        super.u(contentValues);
        contentValues.put("page_key", this.s);
        contentValues.put("refer_page_key", this.mv);
        contentValues.put("duration", Long.valueOf(this.l));
        contentValues.put("is_back", Integer.valueOf(this.bg));
        contentValues.put("last_session", this.bq);
        contentValues.put("page_title", this.k);
        contentValues.put("refer_page_title", this.my);
        contentValues.put("page_path", this.o);
        contentValues.put("referrer_page_path", this.sx);
    }

    @Override // com.bytedance.embedapplog.ju
    public void u(@NonNull JSONObject jSONObject) throws JSONException {
        super.u(jSONObject);
        jSONObject.put("page_key", this.s);
        jSONObject.put("refer_page_key", this.mv);
        jSONObject.put("duration", this.l);
        jSONObject.put("is_back", this.bg);
        jSONObject.put("page_title", this.k);
        jSONObject.put("refer_page_title", this.my);
        jSONObject.put("page_path", this.o);
        jSONObject.put("referrer_page_path", this.sx);
    }
}
