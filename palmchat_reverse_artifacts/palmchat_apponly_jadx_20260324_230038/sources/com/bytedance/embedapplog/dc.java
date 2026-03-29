package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.cdo.oaps.ad.OapsKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class dc extends ju {
    public boolean bg;
    public boolean bq;
    public String k;
    public int l;
    public String mv;
    public int my;
    public String o;
    public boolean s;
    public String sx;

    public dc(boolean z) {
        this.bq = z;
    }

    @Override // com.bytedance.embedapplog.ju
    @NonNull
    public String b() {
        return "launch";
    }

    @Override // com.bytedance.embedapplog.ju
    public String n() {
        return this.s ? OapsKey.KEY_BG : "fg";
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
        boolean z = this.s;
        if (z) {
            jSONObject.put("is_background", z);
        }
        jSONObject.put("datetime", this.t);
        if (!TextUtils.isEmpty(this.n)) {
            jSONObject.put("ab_sdk_version", this.n);
        }
        if (!TextUtils.isEmpty(this.k)) {
            jSONObject.put("uuid_changed", true);
            jSONObject.put("original_session_id", this.k);
        }
        if (this.my == 1) {
            jSONObject.put("$is_first_time", com.huawei.hms.ads.ex.Code);
        }
        jSONObject.put("$resume_from_background", !this.bq);
        jSONObject.put("is_background", !this.bq);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.ju
    public List<String> u() {
        List<String> listU = super.u();
        ArrayList arrayList = new ArrayList(listU.size());
        arrayList.addAll(listU);
        arrayList.addAll(Arrays.asList("ver_name", "varchar", "ver_code", "integer", "last_session", "varchar", "is_first_time", "integer", "page_title", "varchar", "page_key", "varchar", "resume_from_background", "integer"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.ju
    public int u(@NonNull Cursor cursor) {
        int iU = super.u(cursor);
        int i = iU + 1;
        this.mv = cursor.getString(iU);
        int i2 = i + 1;
        this.l = cursor.getInt(i);
        int i3 = i2 + 1;
        this.k = cursor.getString(i2);
        int i4 = i3 + 1;
        this.my = cursor.getInt(i3);
        int i5 = i4 + 1;
        this.o = cursor.getString(i4);
        int i6 = i5 + 1;
        this.sx = cursor.getString(i5);
        int i7 = i6 + 1;
        this.bg = cursor.getInt(i6) == 0;
        return i7;
    }

    @Override // com.bytedance.embedapplog.ju
    public void u(@NonNull ContentValues contentValues) {
        super.u(contentValues);
        contentValues.put("ver_name", this.mv);
        contentValues.put("ver_code", Integer.valueOf(this.l));
        contentValues.put("last_session", this.k);
        contentValues.put("is_first_time", Integer.valueOf(this.my));
        contentValues.put("page_title", this.o);
        contentValues.put("page_key", this.sx);
        contentValues.put("resume_from_background", Integer.valueOf(this.bg ? 1 : 0));
    }

    @Override // com.bytedance.embedapplog.ju
    public void u(@NonNull JSONObject jSONObject) {
        ti.nr((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.ju
    public ju nr(@NonNull JSONObject jSONObject) {
        ti.nr((Throwable) null);
        return null;
    }
}
