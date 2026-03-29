package com.kwad.sdk.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class f {
    public static final String TAG = "Ranger_" + f.class.getSimpleName();

    private static void a(@NonNull d dVar) {
        try {
            a.a(dVar);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e(TAG, Log.getStackTraceString(th));
        }
    }

    public static void d(@NonNull d dVar) {
        if (new Random().nextFloat() >= dVar.sampleRate) {
            com.kwad.sdk.core.d.c.d(TAG, "config.sampleRate：" + dVar.sampleRate + " return");
            return;
        }
        if (dVar.QN()) {
            a(dVar);
        }
        if (dVar.QO()) {
            e(dVar);
        }
        if (dVar.QP()) {
            f(dVar);
        }
    }

    public static void df(final String str) {
        h.schedule(new bg() { // from class: com.kwad.sdk.n.f.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    com.kwad.sdk.core.d.c.w(f.TAG, "config is empty");
                    return;
                }
                d dVarGX = f.gX(str2);
                if (dVarGX != null) {
                    com.kwad.sdk.core.d.c.d(f.TAG, "config:" + dVarGX.toJson().toString());
                }
                if (dVarGX == null || dVarGX.QM()) {
                    return;
                }
                f.d(dVarGX);
            }
        }, 0L, TimeUnit.SECONDS);
    }

    private static void e(d dVar) {
        c.QK().c(dVar);
    }

    private static void f(final d dVar) {
        GlobalThreadPools.Lf().execute(new Runnable() { // from class: com.kwad.sdk.n.f.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    b.QF().b(dVar);
                    b.QF().QH();
                    b.QF().clearAll();
                    b.QF().start();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.e(f.TAG, Log.getStackTraceString(e));
                }
            }
        });
    }

    public static d gX(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w(TAG, e);
            return null;
        }
    }
}
