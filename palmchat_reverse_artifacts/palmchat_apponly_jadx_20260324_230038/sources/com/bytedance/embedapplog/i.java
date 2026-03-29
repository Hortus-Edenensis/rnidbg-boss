package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class i extends ju {
    public int k = 0;
    long l;
    long mv;
    String s;

    @Override // com.bytedance.embedapplog.ju
    @NonNull
    public String b() {
        return "terminate";
    }

    @Override // com.bytedance.embedapplog.ju
    public String n() {
        return String.valueOf(this.l);
    }

    @Override // com.bytedance.embedapplog.ju
    public JSONObject nr() throws JSONException {
        dc dcVar;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.nr);
        jSONObject.put("tea_event_index", this.fx);
        jSONObject.put("session_id", this.b);
        jSONObject.put("stop_timestamp", this.mv / 1000);
        jSONObject.put("duration", this.l / 1000);
        jSONObject.put("datetime", this.t);
        long j = this.pn;
        if (j > 0) {
            jSONObject.put("user_id", j);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.iz) ? JSONObject.NULL : this.iz);
        if (!TextUtils.isEmpty(this.x)) {
            jSONObject.put("ssid", this.x);
        }
        if (!TextUtils.isEmpty(this.n)) {
            jSONObject.put("ab_sdk_version", this.n);
        }
        if (!TextUtils.isEmpty(this.s)) {
            jSONObject.put("uuid_changed", true);
            if (!TextUtils.equals(this.s, this.b)) {
                jSONObject.put("original_session_id", this.s);
            }
        }
        if (this.k == 0 && (dcVar = (dc) zx.nr.get("launch")) != null && !dcVar.bq) {
            this.k = 6;
        }
        jSONObject.put("launch_from", this.k);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.ju
    public List<String> u() {
        return null;
    }

    @Override // com.bytedance.embedapplog.ju
    public int u(@NonNull Cursor cursor) {
        ti.nr((Throwable) null);
        return 0;
    }

    @Override // com.bytedance.embedapplog.ju
    public void u(@NonNull ContentValues contentValues) {
        ti.nr((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.ju
    public void u(@NonNull JSONObject jSONObject) {
        ti.nr((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.ju
    public ju nr(@NonNull JSONObject jSONObject) {
        ti.nr((Throwable) null);
        return this;
    }
}
