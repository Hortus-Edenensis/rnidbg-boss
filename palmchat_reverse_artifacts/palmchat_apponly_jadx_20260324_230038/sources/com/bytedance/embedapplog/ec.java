package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ec {
    private static ob<cb> u = new ob<cb>() { // from class: com.bytedance.embedapplog.ec.1
        @Override // com.bytedance.embedapplog.ob
        /* JADX INFO: renamed from: fx, reason: merged with bridge method [inline-methods] */
        public cb u(Object... objArr) {
            return new cb((Context) objArr[0]);
        }
    };

    @AnyThread
    public static void u(@NonNull Context context) {
        u.nr(context).nr();
    }

    @WorkerThread
    public static String u(SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        return ic.u(sharedPreferences);
    }

    @Nullable
    @WorkerThread
    public static Map<String, String> u(@NonNull Context context, @NonNull SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        cb cbVarNr = u.nr(context);
        return cbVarNr.u(cbVarNr.u() instanceof zn ? 200 : 100);
    }

    @Nullable
    @AnyThread
    public static String u(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    @AnyThread
    public static void u(@Nullable pn pnVar) {
        cb.u(pnVar);
    }
}
