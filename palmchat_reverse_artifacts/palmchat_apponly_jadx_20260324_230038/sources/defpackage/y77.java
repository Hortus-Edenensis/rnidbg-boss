package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import com.apm.lite.CrashType;
import com.apm.lite.Npth;
import com.apm.lite.j.e;
import defpackage.vi7;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class y77 {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile y77 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Context f22156a;

    public y77(Context context) {
        this.f22156a = context;
    }

    public static y77 a() {
        if (b == null) {
            b = new y77(x97.m());
        }
        return b;
    }

    public void b(JSONObject jSONObject, long j, boolean z) {
        File[] fileArr;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        try {
            String strS = e.s();
            int i = 0;
            File file = new File(wi7.b(this.f22156a), x97.b(j, CrashType.ANR, false, false));
            re7.f(file, file.getName(), strS, jSONObject, e.q());
            if (z && !Npth.isStopUpload()) {
                jSONObject.put("upload_scene", "direct");
                jSONObject.put("crash_uuid", file.getName());
                if (nv6.q()) {
                    HashMap<String, vi7.b> mapB = vi7.b(j, "anr_trace");
                    fileArr = new File[mapB.size() + 2];
                    for (Map.Entry<String, vi7.b> entry : mapB.entrySet()) {
                        if (!entry.getKey().equals(kv6.m(this.f22156a))) {
                            fileArr[i] = wi7.c(this.f22156a, entry.getValue().b);
                            i++;
                        }
                    }
                } else {
                    fileArr = new File[2];
                }
                fileArr[fileArr.length - 1] = wi7.c(this.f22156a, x97.l());
                fileArr[fileArr.length - 2] = vi7.a(j);
                if (e.g(strS, jSONObject.toString(), fileArr).a()) {
                    re7.r(file);
                    if (!Npth.hasCrash()) {
                        re7.r(wi7.r(x97.m()));
                    }
                    nd7.a(wi7.F(x97.m()), CrashType.ANR, file.getName());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean c(JSONObject jSONObject, File file, File file2) {
        try {
            return e.g(e.w(), jSONObject.toString(), file, file2, vi7.a(System.currentTimeMillis())).a();
        } catch (Throwable th) {
            kj7.g(th);
            return false;
        }
    }
}
