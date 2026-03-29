package a.a.c.a.b;

import androidx.annotation.NonNull;
import com.qiniu.android.collect.ReportItem;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1106a;
    public final String b;
    public final Boolean c;
    public final Long d;
    public final Long e;
    public final Integer f;
    public final Long g;
    public String h;

    public d(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
        this.f1106a = str;
        this.b = str2;
        this.c = bool;
        this.d = l;
        this.e = l2;
        this.f = num;
        this.g = l3;
    }

    @NonNull
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "id", this.f1106a);
        b.a(jSONObject, ReportItem.RequestKeyRequestId, this.b);
        b.a(jSONObject, "is_track_limited", this.c);
        b.a(jSONObject, "take_ms", this.d);
        b.a(jSONObject, "time", this.e);
        b.a(jSONObject, "query_times", this.f);
        b.a(jSONObject, "hw_id_version_code", this.g);
        b.a(jSONObject, "error_msg", this.h);
        return jSONObject;
    }

    public String toString() {
        return a().toString();
    }
}
