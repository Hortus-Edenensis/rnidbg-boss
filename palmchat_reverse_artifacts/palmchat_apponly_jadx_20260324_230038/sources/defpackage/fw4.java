package defpackage;

import android.text.TextUtils;
import java.io.File;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fw4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f17611a;
    public JSONObject b;
    public long c;
    public JSONObject d;
    public boolean e;
    public boolean f;

    public fw4(File file, JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        this.f17611a = file;
        this.b = jSONObject;
        this.d = jSONObject2;
        this.c = file.length();
        this.f = z;
        this.e = z;
    }

    public static fw4 a(File file, Set<String> set) {
        JSONObject jSONObjectD = d(file);
        if (jSONObjectD != null) {
            return new fw4(file, jSONObjectD, zw2.d(jSONObjectD, set), false);
        }
        hv1.c(file);
        return null;
    }

    public static fw4 b(File file, JSONObject jSONObject) {
        JSONObject jSONObjectD = d(file);
        if (jSONObjectD != null) {
            return new fw4(file, jSONObjectD, jSONObject, true);
        }
        hv1.c(file);
        return null;
    }

    public static JSONObject d(File file) {
        JSONObject jSONObject;
        JSONArray jSONArrayOptJSONArray;
        try {
            String strI = hv1.i(file);
            if (TextUtils.isEmpty(strI) || (jSONArrayOptJSONArray = (jSONObject = new JSONObject(strI)).optJSONArray("content")) == null) {
                return null;
            }
            if (jSONArrayOptJSONArray.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0044 A[Catch: all -> 0x007d, TryCatch #0 {all -> 0x007d, blocks: (B:4:0x0006, B:6:0x0012, B:7:0x001f, B:9:0x0025, B:10:0x002f, B:12:0x003e, B:14:0x0044, B:15:0x0047, B:17:0x0056, B:18:0x005d, B:22:0x0067, B:27:0x0078, B:25:0x006d), top: B:30:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0056 A[Catch: all -> 0x007d, TryCatch #0 {all -> 0x007d, blocks: (B:4:0x0006, B:6:0x0012, B:7:0x001f, B:9:0x0025, B:10:0x002f, B:12:0x003e, B:14:0x0044, B:15:0x0047, B:17:0x0056, B:18:0x005d, B:22:0x0067, B:27:0x0078, B:25:0x006d), top: B:30:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006d A[Catch: all -> 0x007d, TryCatch #0 {all -> 0x007d, blocks: (B:4:0x0006, B:6:0x0012, B:7:0x001f, B:9:0x0025, B:10:0x002f, B:12:0x003e, B:14:0x0044, B:15:0x0047, B:17:0x0056, B:18:0x005d, B:22:0x0067, B:27:0x0078, B:25:0x006d), top: B:30:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0078 A[Catch: all -> 0x007d, TRY_LEAVE, TryCatch #0 {all -> 0x007d, blocks: (B:4:0x0006, B:6:0x0012, B:7:0x001f, B:9:0x0025, B:10:0x002f, B:12:0x003e, B:14:0x0044, B:15:0x0047, B:17:0x0056, B:18:0x005d, B:22:0x0067, B:27:0x0078, B:25:0x006d), top: B:30:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(fw4 fw4Var, File file) {
        File file2;
        boolean z = true;
        if (fw4Var != null) {
            try {
                if (this.c + fw4Var.c <= 40960) {
                    JSONArray jSONArray = this.b.getJSONArray("content");
                    JSONArray jSONArray2 = fw4Var.b.getJSONArray("content");
                    for (int i = 0; i < jSONArray2.length(); i++) {
                        jSONArray.put(jSONArray2.getJSONObject(i));
                    }
                    this.c += fw4Var.c;
                    this.e = true;
                    hv1.c(fw4Var.f17611a);
                    return true;
                }
                if (!file.exists()) {
                    file.mkdirs();
                }
                file2 = new File(file, this.f17611a.getName());
                if (this.f) {
                    zw2.b(this.b, this.d);
                }
                if (!this.f17611a.equals(file2)) {
                    z = false;
                }
                if (!this.e || z) {
                    hv1.j(file2, this.b.toString());
                }
                if (z) {
                    hv1.c(this.f17611a);
                }
            } catch (Throwable unused) {
            }
        } else {
            if (!file.exists()) {
            }
            file2 = new File(file, this.f17611a.getName());
            if (this.f) {
            }
            if (!this.f17611a.equals(file2)) {
            }
            if (!this.e) {
                hv1.j(file2, this.b.toString());
                if (z) {
                }
            }
        }
        return false;
    }
}
