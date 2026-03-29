package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.u.nr.fx;
import com.bytedance.u.nr.x.nr;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class vc7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f21408a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FilenameFilter {
        public a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str != null && str.endsWith(".npth");
        }
    }

    public vc7(Context context) {
        this.f21408a = context;
    }

    public final void a() {
        File[] fileArrE = e(vh7.d(this.f21408a), ".npth");
        if (fileArrE == null) {
            return;
        }
        Arrays.sort(fileArrE, Collections.reverseOrder());
        for (int i = 0; i < fileArrE.length && i < 50; i++) {
            File file = fileArrE[i];
            try {
                if (cl7.a().d(file.getAbsolutePath())) {
                    z07.h(file);
                } else {
                    yc7 yc7VarA = z07.a(file.getAbsolutePath());
                    if (yc7VarA != null && yc7VarA.b() != null) {
                        JSONObject jSONObjectB = yc7VarA.b();
                        b(file.getName(), jSONObjectB);
                        yc7VarA.b().put("upload_scene", "launch_scan");
                        if (nr.g(yc7VarA.d(), jSONObjectB.toString(), yc7VarA.a()).a() && !z07.h(file)) {
                            cl7.a().c(el7.a(file.getAbsolutePath()));
                        }
                    }
                }
            } catch (Exception e) {
                mf7.a(e);
            }
        }
    }

    public final fx b(String str, JSONObject jSONObject) {
        if (jSONObject == null && TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("launch_")) {
            return fx.LAUNCH;
        }
        if (str.startsWith("anr_")) {
            return fx.ANR;
        }
        if (str.startsWith("java_")) {
            if (jSONObject.optInt("is_dart") == 1) {
                return fx.DART;
            }
            if (jSONObject.optInt("isJava") == 1) {
                return fx.JAVA;
            }
        }
        return null;
    }

    public final void c() {
        try {
            SharedPreferences sharedPreferencesNr = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(this.f21408a, "npth", 0);
            long j = sharedPreferencesNr.getLong("history_time", -1L);
            if (j < 0) {
                sharedPreferencesNr.edit().putLong("history_time", System.currentTimeMillis()).apply();
            } else if (System.currentTimeMillis() - j > 86400000) {
                z07.h(vh7.b(this.f21408a));
                sharedPreferencesNr.edit().putLong("history_time", System.currentTimeMillis()).apply();
            }
        } catch (Exception unused) {
        }
    }

    public void d(boolean z) {
        c();
        if (z) {
            a();
        }
    }

    @Nullable
    public final File[] e(File file, String str) {
        if (file.exists()) {
            return TextUtils.isEmpty(str) ? file.listFiles() : file.listFiles(new a());
        }
        return null;
    }
}
