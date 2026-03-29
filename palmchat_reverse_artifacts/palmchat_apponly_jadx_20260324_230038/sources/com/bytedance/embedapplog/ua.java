package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.bytedance.embedapplog.zx;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ua extends ju {
    dc bg;
    JSONArray bq;
    private JSONArray c;
    long dw;
    JSONArray k;
    public byte[] l;
    int mv;
    long my;
    JSONArray o;
    private i q;
    private JSONObject qq;
    public int s;
    long sx;

    @Override // com.bytedance.embedapplog.ju
    @NonNull
    public String b() {
        return "pack";
    }

    public byte[] jk() {
        this.l = null;
        try {
            byte[] bArrU = tr.u(iz().toString());
            this.l = bArrU;
            return bArrU;
        } catch (OutOfMemoryError e) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                zx.nr[] nrVarArr = zx.fx;
                if (i >= nrVarArr.length) {
                    throw new RuntimeException(sb.toString(), e);
                }
                zx.nr nrVar = nrVarArr[i];
                if (nrVar != null) {
                    sb.append(nrVar.toString());
                    sb.append(com.huawei.openalliance.ad.constant.x.aQ);
                }
                i++;
            }
        }
    }

    @Override // com.bytedance.embedapplog.ju
    public String n() {
        return String.valueOf(this.u);
    }

    @Override // com.bytedance.embedapplog.ju
    public JSONObject nr() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.qq);
        jSONObject.put("time_sync", rv.u);
        jSONObject.put("local_time", System.currentTimeMillis() / 1000);
        if (this.bg != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.bg.iz());
            jSONObject.put("launch", jSONArray);
        }
        i iVar = this.q;
        int i = 0;
        if (iVar != null) {
            JSONObject jSONObjectIz = iVar.iz();
            JSONArray jSONArray2 = this.c;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            int i2 = 0;
            long j = 0;
            while (i2 < length) {
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(this.c.optString(i2));
                JSONObject jSONObject3 = new JSONObject(jSONObject2.optString("params"));
                jSONArray4.put(i, jSONObject3.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject3.optInt("duration", i) + 999) / 1000);
                jSONArray3.put(jSONArray4);
                int i3 = length;
                long jOptLong = jSONObject2.optLong("local_time_ms", 0L);
                if (jOptLong > j) {
                    jSONObjectIz.put("$page_title", jSONObject3.optString("page_title", ""));
                    jSONObjectIz.put("$page_key", jSONObject3.optString("page_key", ""));
                    j = jOptLong;
                }
                i2++;
                length = i3;
                i = 0;
            }
            if (length > 0) {
                jSONObjectIz.put("activites", jSONArray3);
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(jSONObjectIz);
            jSONObject.put("terminate", jSONArray5);
        }
        JSONArray jSONArray6 = this.k;
        int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
        if (length2 > 0) {
            jSONObject.put("event", this.k);
        }
        JSONArray jSONArray7 = this.c;
        int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
        JSONArray jSONArray8 = this.o;
        int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.o);
        }
        JSONArray jSONArray9 = this.bq;
        int length5 = jSONArray9 != null ? jSONArray9.length() : 0;
        if (length5 > 0) {
            jSONObject.put(com.igexin.c.a.c.a.d.d, this.bq);
        }
        StringBuilder sb = new StringBuilder("pack {");
        sb.append("ts:");
        sb.append(this.nr);
        sb.append(", la:");
        Object obj = this.bg;
        if (obj == null) {
            obj = "0";
        }
        sb.append(obj);
        sb.append(", te:");
        i iVar2 = this.q;
        sb.append(iVar2 != null ? iVar2 : "0");
        sb.append(", p:");
        sb.append(length3);
        sb.append(", v1:");
        sb.append(length2);
        sb.append(", v3:");
        sb.append(length4);
        sb.append(", m:");
        sb.append(length5);
        ti.u(sb.toString());
        return jSONObject;
    }

    public void u(JSONObject jSONObject, dc dcVar, i iVar, JSONArray jSONArray, JSONArray[] jSONArrayArr, long[] jArr, int i) {
        u(0L);
        this.qq = jSONObject;
        this.bg = dcVar;
        this.q = iVar;
        this.c = jSONArray;
        this.k = jSONArrayArr[0];
        this.my = jArr[0];
        this.o = jSONArrayArr[1];
        this.sx = jArr[1];
        this.bq = jSONArrayArr[2];
        this.dw = jArr[2];
        this.jk = i;
    }

    @Override // com.bytedance.embedapplog.ju
    public List<String> u() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", "integer", "_data", "blob", "_fail", "integer", "event_type", "integer");
    }

    @Override // com.bytedance.embedapplog.ju
    public int u(@NonNull Cursor cursor) {
        this.u = cursor.getLong(0);
        this.nr = cursor.getLong(1);
        this.l = cursor.getBlob(2);
        this.mv = cursor.getInt(3);
        this.jk = cursor.getInt(4);
        this.b = "";
        this.qq = null;
        this.bg = null;
        this.q = null;
        this.c = null;
        this.k = null;
        this.o = null;
        this.bq = null;
        return 5;
    }

    @Override // com.bytedance.embedapplog.ju
    public void u(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.nr));
        contentValues.put("_data", jk());
        contentValues.put("event_type", Integer.valueOf(this.jk));
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
