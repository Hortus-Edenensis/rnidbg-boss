package defpackage;

import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ja3 implements bb3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f18356a;
    public String b;
    public boolean c;

    public ja3(String str, boolean z) {
        this.b = str;
        this.c = z;
        File file = new File(str);
        if (file.exists()) {
            c(ga3.f(file, "UTF-8"));
            ma3.g("%s init ok", str);
        } else {
            ma3.g("%s not exsit", str);
            this.f18356a = new JSONObject();
        }
    }

    @Override // defpackage.bb3
    public boolean a(String str, Object obj) {
        synchronized (this) {
            JSONObject jSONObject = this.f18356a;
            if (jSONObject != null) {
                try {
                    jSONObject.put(str, obj);
                    if (!this.c) {
                        return true;
                    }
                    return commit();
                } catch (JSONException e) {
                    ma3.c(e);
                }
            }
            return false;
        }
    }

    @Override // defpackage.bb3
    public Object b(String str) {
        synchronized (this) {
            JSONObject jSONObject = this.f18356a;
            if (jSONObject != null && jSONObject.has(str)) {
                try {
                    return this.f18356a.get(str);
                } catch (JSONException e) {
                    ma3.c(e);
                }
            }
            return null;
        }
    }

    public final void c(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            this.f18356a = new JSONObject(str);
        } catch (JSONException e) {
            ma3.c(e);
        }
    }

    @Override // defpackage.bb3
    public boolean clear() {
        synchronized (this) {
            if (this.f18356a == null) {
                return false;
            }
            this.f18356a = new JSONObject();
            if (!this.c) {
                return true;
            }
            return commit();
        }
    }

    @Override // defpackage.bb3
    public boolean commit() {
        JSONObject jSONObject = this.f18356a;
        if (jSONObject == null) {
            return false;
        }
        return ga3.g(new File(this.b).getAbsolutePath(), jSONObject.toString(), "UTF-8");
    }

    @Override // defpackage.bb3
    public Object remove(String str) {
        synchronized (this) {
            JSONObject jSONObject = this.f18356a;
            if (jSONObject == null) {
                return null;
            }
            return jSONObject.remove(str);
        }
    }

    public String toString() {
        JSONObject jSONObject = this.f18356a;
        return jSONObject != null ? jSONObject.toString() : "empty config";
    }

    public ja3(String str) {
        this(str, false);
    }
}
