package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class uq extends ju {

    @NonNull
    private String l;

    @NonNull
    private String mv;

    public uq(@NonNull String str, @NonNull JSONObject jSONObject) {
        this.mv = str;
        this.l = jSONObject.toString();
        this.jk = 0;
    }

    @Override // com.bytedance.embedapplog.ju
    public String a() {
        return this.l;
    }

    @Override // com.bytedance.embedapplog.ju
    @NonNull
    public String b() {
        return "event_misc";
    }

    @Override // com.bytedance.embedapplog.ju
    public String n() {
        return "param:" + this.l + " logType:" + this.mv;
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
        jSONObject.put("log_type", this.mv);
        try {
            JSONObject jSONObject2 = new JSONObject(this.l);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    ti.nr("misc事件存在重复的key", null);
                }
                jSONObject.put(next, obj);
            }
        } catch (Exception e) {
            ti.fx("解析 event misc 失败", e);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.ju
    public List<String> u() {
        List<String> listU = super.u();
        ArrayList arrayList = new ArrayList(listU.size());
        arrayList.addAll(listU);
        arrayList.addAll(Arrays.asList("params", "varchar", "log_type", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.ju
    public int u(@NonNull Cursor cursor) {
        int iU = super.u(cursor);
        int i = iU + 1;
        this.l = cursor.getString(iU);
        int i2 = i + 1;
        this.mv = cursor.getString(i);
        return i2;
    }

    @Override // com.bytedance.embedapplog.ju
    public void u(@NonNull ContentValues contentValues) {
        super.u(contentValues);
        contentValues.put("params", this.l);
        contentValues.put("log_type", this.mv);
    }

    @Override // com.bytedance.embedapplog.ju
    public void u(@NonNull JSONObject jSONObject) throws JSONException {
        super.u(jSONObject);
        jSONObject.put("params", this.l);
        jSONObject.put("log_type", this.mv);
    }

    @Override // com.bytedance.embedapplog.ju
    public ju nr(@NonNull JSONObject jSONObject) {
        super.nr(jSONObject);
        this.l = jSONObject.optString("params", null);
        this.mv = jSONObject.optString("log_type", null);
        return this;
    }
}
