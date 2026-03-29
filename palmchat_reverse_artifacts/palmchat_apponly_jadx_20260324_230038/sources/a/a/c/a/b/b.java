package a.a.c.a.b;

import a.a.c.a.b.c;
import a.a.c.a.d.e;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f1103a;
    public final e b;
    public final boolean c;
    public final Context d;
    public final AtomicBoolean e = new AtomicBoolean(false);
    public Future<d> f;
    public d g;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f1104a;

        public a(Context context) {
            this.f1104a = context;
        }

        public static /* synthetic */ a.a.c.a.e.a b(a aVar) {
            aVar.getClass();
            return null;
        }
    }

    @WorkerThread
    public b(a aVar) {
        Context applicationContext = aVar.f1104a.getApplicationContext();
        this.d = applicationContext;
        c cVarA = a.a.a.a.a.a.k.b.a(applicationContext);
        this.f1103a = cVarA;
        this.c = cVarA != null ? cVarA.b(applicationContext) : false;
        this.b = new e(applicationContext);
        a.b(aVar);
    }

    @WorkerThread
    public final d a(Context context, d dVar) {
        c.a aVarA;
        int iIntValue;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        c cVar = this.f1103a;
        String string = null;
        if (cVar == null || (aVarA = cVar.a(context)) == null) {
            return null;
        }
        if (dVar != null) {
            string = dVar.b;
            Integer num = dVar.f;
            iIntValue = (num == null ? 0 : num.intValue()) + 1;
        } else {
            iIntValue = -1;
        }
        if (TextUtils.isEmpty(string)) {
            string = UUID.randomUUID().toString();
        }
        return new d(aVarA.f1105a, string, Boolean.valueOf(aVarA.b), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(iIntValue > 0 ? iIntValue : 1), Long.valueOf(aVarA instanceof e.b ? ((e.b) aVarA).c : 0L));
    }

    public static <K, V> void a(Map<K, V> map, K k, V v) {
        if (v != null) {
            map.put(k, v);
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            e.getMessage();
        }
    }
}
