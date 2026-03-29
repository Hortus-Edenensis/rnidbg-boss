package defpackage;

import com.apm.lite.CrashType;
import com.tencent.matrix.trace.config.SharePluginInfo;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class u37 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ConcurrentLinkedQueue<u37> f21128a = new ConcurrentLinkedQueue<>();

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21129a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f21129a = iArr;
            try {
                iArr[CrashType.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21129a[CrashType.LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21129a[CrashType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public JSONObject f21130a;
        public JSONObject b;
        public CrashType c;

        public b(JSONObject jSONObject, CrashType crashType) {
            this.c = crashType;
            if (crashType == CrashType.LAUNCH) {
                this.f21130a = ((JSONArray) jSONObject.opt("data")).optJSONObject(0);
            } else {
                this.f21130a = jSONObject;
            }
            this.b = jSONObject.optJSONObject("header");
        }

        public String a() {
            return this.f21130a.optString("crash_thread_name", null);
        }

        public long b() {
            return this.f21130a.optLong("app_start_time", -1L);
        }

        public String c() {
            int i = a.f21129a[this.c.ordinal()];
            if (i == 1) {
                return this.f21130a.optString("data", null);
            }
            if (i == 2) {
                return this.f21130a.optString(SharePluginInfo.ISSUE_TRACE_STACK, null);
            }
            if (i != 3) {
                return null;
            }
            return this.f21130a.optString("data", null);
        }
    }

    public static void b(CrashType crashType, JSONObject jSONObject) {
        ConcurrentLinkedQueue<u37> concurrentLinkedQueue = f21128a;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return;
        }
        b bVar = new b(jSONObject, crashType);
        while (!f21128a.isEmpty()) {
            u37 u37VarPoll = f21128a.poll();
            if (u37VarPoll != null) {
                u37VarPoll.a(crashType, bVar);
            }
        }
        f21128a = null;
    }

    public abstract void a(CrashType crashType, b bVar);
}
