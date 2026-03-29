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
public class rg extends ju {
    protected String l;
    protected String mv;
    private boolean s;

    public rg(String str, boolean z, String str2) {
        this.mv = str;
        this.s = z;
        this.l = str2;
        this.jk = 0;
    }

    @Override // com.bytedance.embedapplog.ju
    public String a() {
        return this.l;
    }

    @Override // com.bytedance.embedapplog.ju
    @NonNull
    public String b() {
        return "eventv3";
    }

    @Override // com.bytedance.embedapplog.ju
    public String n() {
        return this.mv;
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
        jSONObject.put("event", this.mv);
        if (this.s) {
            jSONObject.put("is_bav", 1);
        }
        if (!TextUtils.isEmpty(this.l)) {
            jSONObject.put("params", new JSONObject(this.l));
        }
        jSONObject.put("datetime", this.t);
        if (!TextUtils.isEmpty(this.n)) {
            jSONObject.put("ab_sdk_version", this.n);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.ju
    public List<String> u() {
        List<String> listU = super.u();
        ArrayList arrayList = new ArrayList(listU.size());
        arrayList.addAll(listU);
        arrayList.addAll(Arrays.asList("event", "varchar", "params", "varchar", "is_bav", "integer"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.ju
    public int u(@NonNull Cursor cursor) {
        int iU = super.u(cursor);
        int i = iU + 1;
        this.mv = cursor.getString(iU);
        int i2 = i + 1;
        this.l = cursor.getString(i);
        int i3 = i2 + 1;
        this.s = cursor.getInt(i2) == 1;
        return i3;
    }

    public rg(String str, boolean z, String str2, int i) {
        this.mv = str;
        this.s = z;
        this.l = str2;
        this.jk = i;
    }

    @Override // com.bytedance.embedapplog.ju
    public void u(@NonNull ContentValues contentValues) {
        super.u(contentValues);
        contentValues.put("event", this.mv);
        contentValues.put("params", this.l);
        contentValues.put("is_bav", Integer.valueOf(this.s ? 1 : 0));
    }

    @Override // com.bytedance.embedapplog.ju
    public void u(@NonNull JSONObject jSONObject) throws JSONException {
        super.u(jSONObject);
        jSONObject.put("event", this.mv);
        jSONObject.put("params", this.l);
        jSONObject.put("is_bav", this.s);
    }

    @Override // com.bytedance.embedapplog.ju
    public ju nr(@NonNull JSONObject jSONObject) {
        super.nr(jSONObject);
        this.mv = jSONObject.optString("event", null);
        this.l = jSONObject.optString("params", null);
        this.s = jSONObject.optBoolean("is_bav", false);
        return this;
    }
}
