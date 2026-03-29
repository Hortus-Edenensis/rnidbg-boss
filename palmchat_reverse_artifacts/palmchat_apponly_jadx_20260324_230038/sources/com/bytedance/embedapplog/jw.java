package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.qq.gdt.action.ActionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class jw extends ju {
    public String k;
    public String l;
    public String mv;
    public long my;
    long o;
    public String s;

    @Override // com.bytedance.embedapplog.ju
    public String a() {
        return this.k;
    }

    @Override // com.bytedance.embedapplog.ju
    @NonNull
    public String b() {
        return "event";
    }

    @Override // com.bytedance.embedapplog.ju
    public String n() {
        return this.mv + ", " + this.s;
    }

    @Override // com.bytedance.embedapplog.ju
    public ju nr(@NonNull JSONObject jSONObject) {
        super.nr(jSONObject);
        this.fx = jSONObject.optLong("tea_event_index", 0L);
        this.l = jSONObject.optString(com.huawei.openalliance.ad.constant.x.cw, null);
        this.mv = jSONObject.optString("tag", null);
        this.my = jSONObject.optLong(ActionUtils.PAYMENT_AMOUNT, 0L);
        this.o = jSONObject.optLong("ext_value", 0L);
        this.k = jSONObject.optString("params", null);
        this.s = jSONObject.optString("label", null);
        return this;
    }

    @Override // com.bytedance.embedapplog.ju
    public List<String> u() {
        List<String> listU = super.u();
        ArrayList arrayList = new ArrayList(listU.size());
        arrayList.addAll(listU);
        arrayList.addAll(Arrays.asList(com.huawei.openalliance.ad.constant.x.cw, "varchar", "tag", "varchar", ActionUtils.PAYMENT_AMOUNT, "integer", "ext_value", "integer", "params", "varchar", "label", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.ju
    public int u(@NonNull Cursor cursor) {
        int iU = super.u(cursor);
        int i = iU + 1;
        this.l = cursor.getString(iU);
        int i2 = i + 1;
        this.mv = cursor.getString(i);
        int i3 = i2 + 1;
        this.my = cursor.getLong(i2);
        int i4 = i3 + 1;
        this.o = cursor.getLong(i3);
        int i5 = i4 + 1;
        this.k = cursor.getString(i4);
        int i6 = i5 + 1;
        this.s = cursor.getString(i5);
        return i6;
    }

    @Override // com.bytedance.embedapplog.ju
    public JSONObject nr() throws JSONException {
        JSONObject jSONObject = !TextUtils.isEmpty(this.k) ? new JSONObject(this.k) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
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
        jSONObject.put(com.huawei.openalliance.ad.constant.x.cw, this.l);
        jSONObject.put("tag", this.mv);
        jSONObject.put(ActionUtils.PAYMENT_AMOUNT, this.my);
        jSONObject.put("ext_value", this.o);
        jSONObject.put("label", this.s);
        jSONObject.put("datetime", this.t);
        if (!TextUtils.isEmpty(this.n)) {
            jSONObject.put("ab_sdk_version", this.n);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.ju
    public void u(@NonNull ContentValues contentValues) {
        super.u(contentValues);
        contentValues.put(com.huawei.openalliance.ad.constant.x.cw, this.l);
        contentValues.put("tag", this.mv);
        contentValues.put(ActionUtils.PAYMENT_AMOUNT, Long.valueOf(this.my));
        contentValues.put("ext_value", Long.valueOf(this.o));
        contentValues.put("params", this.k);
        contentValues.put("label", this.s);
    }

    @Override // com.bytedance.embedapplog.ju
    public void u(@NonNull JSONObject jSONObject) throws JSONException {
        super.u(jSONObject);
        jSONObject.put("tea_event_index", this.fx);
        jSONObject.put(com.huawei.openalliance.ad.constant.x.cw, this.l);
        jSONObject.put("tag", this.mv);
        jSONObject.put(ActionUtils.PAYMENT_AMOUNT, this.my);
        jSONObject.put("ext_value", this.o);
        jSONObject.put("params", this.k);
        jSONObject.put("label", this.s);
    }
}
