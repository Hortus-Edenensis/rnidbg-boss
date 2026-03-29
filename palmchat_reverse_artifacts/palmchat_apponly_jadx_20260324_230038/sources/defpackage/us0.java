package defpackage;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class us0 implements fl2 {
    @Override // defpackage.fl2
    public int a(String str, int i) {
        return ts0.o().g() != null ? ts0.o().g().optInt(str, i) : i;
    }

    @Override // defpackage.fl2
    public String b(String str) {
        if (ts0.o().g() != null) {
            return ts0.o().g().optString(str);
        }
        return null;
    }

    @Override // defpackage.fl2
    public JSONArray c(String str) {
        if (ts0.o().g() != null) {
            return ts0.o().g().optJSONArray(str);
        }
        return null;
    }

    @Override // defpackage.fl2
    public long d(String str, long j) {
        return ts0.o().g() != null ? ts0.o().g().optLong(str, j) : j;
    }

    @Override // defpackage.fl2
    public boolean e(String str, boolean z) {
        return ts0.o().g() != null ? ts0.o().g().optBoolean(str, z) : z;
    }

    @Override // defpackage.fl2
    public JSONObject getConfig(String str) {
        if (ts0.o().g() != null) {
            return ts0.o().g().optJSONObject(str);
        }
        return null;
    }
}
