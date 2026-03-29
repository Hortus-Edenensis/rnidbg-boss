package com.bytedance.embedapplog;

import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qiniu.android.collect.ReportItem;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class qf {
    final Long b;
    final Boolean fx;
    final Integer iz;
    final String nr;
    final Long pn;
    final String u;
    final Long x;

    public qf(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
        this.u = str;
        this.nr = str2;
        this.fx = bool;
        this.b = l;
        this.pn = l2;
        this.iz = num;
        this.x = l3;
    }

    @NonNull
    public JSONObject nr() {
        JSONObject jSONObject = new JSONObject();
        cb.u(jSONObject, "id", this.u);
        cb.u(jSONObject, ReportItem.RequestKeyRequestId, this.nr);
        cb.u(jSONObject, "is_track_limited", this.fx);
        cb.u(jSONObject, "take_ms", this.b);
        cb.u(jSONObject, "time", this.pn);
        cb.u(jSONObject, "query_times", this.iz);
        cb.u(jSONObject, "hw_id_version_code", this.x);
        return jSONObject;
    }

    public String toString() {
        return nr().toString();
    }

    @NonNull
    public Map<String, String> u() {
        HashMap map = new HashMap();
        cb.u(map, "id", this.u);
        cb.u(map, ReportItem.RequestKeyRequestId, this.nr);
        cb.u(map, "is_track_limited", String.valueOf(this.fx));
        cb.u(map, "take_ms", String.valueOf(this.b));
        cb.u(map, "time", String.valueOf(this.pn));
        cb.u(map, "query_times", String.valueOf(this.iz));
        cb.u(map, "hw_id_version_code", String.valueOf(this.x));
        return map;
    }

    @Nullable
    @AnyThread
    public static qf u(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new qf(jSONObject.optString("id", null), jSONObject.optString(ReportItem.RequestKeyRequestId, null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (JSONException e) {
            ti.u(e);
            return null;
        }
    }
}
