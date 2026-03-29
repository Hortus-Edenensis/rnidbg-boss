package defpackage;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fp4 {
    public static volatile fp4 l = null;
    public static boolean m = false;
    public static boolean n = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17576a = null;
    public String b = null;
    public long c = 30;
    public long d = 0;
    public long e = 0;
    public boolean f = true;
    public boolean g = false;
    public boolean h = true;
    public long i = 0;
    public JSONObject j = null;
    public final Object k = new Object();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends xw2 {
        public final /* synthetic */ Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Context context) {
            super(str);
            this.c = context;
        }

        @Override // defpackage.xw2
        public void a() {
            try {
                fp4.this.q(this.c);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends xw2 {
        public final /* synthetic */ Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Context context) {
            super(str);
            this.c = context;
        }

        @Override // defpackage.xw2
        public void a() {
            try {
                fp4.this.p(this.c);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends xw2 {
        public final /* synthetic */ Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Context context) {
            super(str);
            this.c = context;
        }

        @Override // defpackage.xw2
        public void a() {
            try {
                fp4.this.p(this.c);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d extends xw2 {
        public boolean c;
        public Context d;
        public fp4 e;

        public d(boolean z, Context context, fp4 fp4Var) {
            this.c = z;
            this.d = context;
            this.e = fp4Var;
            this.f22065a = "PushSA";
        }

        @Override // defpackage.xw2
        public void a() {
            try {
                if (this.c) {
                    this.e.q(this.d);
                } else {
                    this.e.p(this.d);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static fp4 g() {
        if (l == null) {
            synchronized (fp4.class) {
                l = new fp4();
            }
        }
        return l;
    }

    public final void c(Context context) {
        nw4.A(context, "push_stat_cache.json", null);
    }

    public final JSONObject d(Context context, long j) {
        this.b = e(context, j);
        lg5.h(context, zz2.r().a0(Long.valueOf(this.d)), zz2.q().a0(this.b));
        JSONObject jSONObject = new JSONObject();
        try {
            v(jSONObject);
            fv2.b(context, jSONObject, "active_launch");
            jSONObject.put("session_id", this.b);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final String e(Context context, long j) {
        StringBuilder sb = new StringBuilder();
        String strE = fv2.e(context);
        if (!TextUtils.isEmpty(strE)) {
            sb.append(strE);
        }
        sb.append(j);
        return nl5.g(sb.toString());
    }

    public final JSONObject f(Context context) {
        if (this.j == null) {
            this.j = fv2.p(context, "push_stat_cache.json");
        }
        return this.j;
    }

    public final boolean h(Context context, String str) {
        if (!this.h) {
            k63.g("PushSA", "stat function has been disabled");
            return false;
        }
        if (context == null) {
            k63.g("PushSA", "context is null");
            return false;
        }
        if (!(context instanceof Application)) {
            return true;
        }
        k63.e("PushSA", "Context should be an Activity on this method : " + str);
        return false;
    }

    public final boolean i(Context context) {
        if (this.f) {
            this.f = false;
            k63.a("PushSA", "statistics start");
            long jLongValue = ((Long) lg5.c(context, zz2.p())).longValue();
            k63.a("PushSA", "lastPause:" + jLongValue + ",latestResumeTime:" + this.d + ",interval:" + (this.c * 1000) + ",a:" + (this.d - jLongValue));
            if (jLongValue > 0 && this.d - jLongValue <= this.c * 1000) {
                return false;
            }
        } else if (this.d - this.e <= this.c * 1000) {
            return false;
        }
        return true;
    }

    public void j(Context context, String str) {
        if (!this.g) {
            k63.a("PushSA", "JCoreInterface.onPause() must be called after called JCoreInterface.onResume() in this Activity or Fragment");
            return;
        }
        this.g = false;
        String str2 = this.f17576a;
        if (str2 == null || !str2.equals(str)) {
            k63.e("PushSA", "page name didn't match the last one passed by onResume");
            return;
        }
        this.e = System.currentTimeMillis();
        try {
            wz4.a("FUTURE_TASK", new b("PushSA#onFragmentPause", context.getApplicationContext()));
        } catch (Throwable unused) {
        }
    }

    public void k(Context context, String str) {
        if (this.g) {
            k63.a("PushSA", "JCoreInterface.onResume() must be called after called JCoreInterface.onPause() in last Activity or Fragment");
            return;
        }
        this.g = true;
        this.f17576a = str;
        this.d = System.currentTimeMillis();
        try {
            wz4.a("FUTURE_TASK", new a("PushSA#onFragmentResume", context.getApplicationContext()));
        } catch (Throwable unused) {
        }
    }

    public void l(Context context) {
        try {
            if (this.f17576a == null || !this.g) {
                return;
            }
            this.e = System.currentTimeMillis();
            wz4.a("FUTURE_TASK", new c("PushSA#onKillProcess", context.getApplicationContext()));
        } catch (Throwable unused) {
        }
    }

    public void m(Context context) {
        if (h(context, "onPause")) {
            n = true;
            try {
                this.g = true;
            } catch (ClassCastException unused) {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.g) {
                this.g = false;
                String str = this.f17576a;
                if (str == null || !str.equals(context.getClass().getName())) {
                    k63.g("PushSA", "the activity pass by onPause didn't match last one passed by onResume");
                    return;
                }
                this.e = System.currentTimeMillis();
                this.i = this.d;
                try {
                    wz4.a("FUTURE_TASK", new d(false, context.getApplicationContext(), this));
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public void n(Context context) {
        if (h(context, "onResume")) {
            m = true;
            try {
                this.g = false;
            } catch (ClassCastException | Exception unused) {
            }
            if (this.g) {
                return;
            }
            this.g = true;
            this.d = System.currentTimeMillis();
            this.f17576a = context.getClass().getName();
            try {
                wz4.a("FUTURE_TASK", new d(true, context.getApplicationContext(), this));
            } catch (Throwable unused2) {
            }
        }
    }

    public final void o(Context context, JSONObject jSONObject) {
        nw4.A(context, "push_stat_cache.json", jSONObject);
    }

    public final void p(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.k) {
            lg5.h(context, zz2.p().a0(Long.valueOf(this.e)), zz2.o().a0(Long.valueOf(this.e)));
            JSONObject jSONObjectF = f(context);
            if (jSONObjectF == null) {
                jSONObjectF = new JSONObject();
            }
            try {
                u(jSONObjectF, context);
            } catch (Exception unused) {
            }
            t(jSONObjectF);
            o(context, jSONObjectF);
        }
    }

    public final void q(Context context) {
        JSONObject jSONObjectF;
        if (!i(context)) {
            this.b = (String) lg5.f(context, zz2.q());
            return;
        }
        k63.g("PushSA", "new statistics session");
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObjectD = d(context, this.d);
        if (jSONObjectD != null) {
            jSONArray.put(jSONObjectD);
        }
        synchronized (this.k) {
            jSONObjectF = f(context);
            if (jSONObjectF != null && jSONObjectF.length() > 0) {
                try {
                    fv2.b(context, jSONObjectF, "active_terminate");
                } catch (Exception unused) {
                }
                c(context);
                this.j = null;
            }
        }
        if (jSONObjectF != null && jSONObjectF.length() > 0) {
            jSONArray.put(jSONObjectF);
        }
        fv2.q(context, jSONArray);
    }

    public void r(long j) {
        this.c = j;
    }

    public void s(boolean z) {
        this.h = z;
    }

    public final void t(JSONObject jSONObject) {
        this.j = jSONObject;
    }

    public final void u(JSONObject jSONObject, Context context) throws Exception {
        long j;
        long jLongValue = ((Long) lg5.c(context, zz2.r())).longValue();
        if (jLongValue <= 0) {
            long j2 = this.e - this.i;
            j = j2 > 0 ? j2 / 1000 : 10L;
            lg5.h(context, zz2.r().a0(Long.valueOf(this.i)));
        } else {
            j = (this.e - jLongValue) / 1000;
        }
        jSONObject.put("duration", j);
        jSONObject.put("itime", System.currentTimeMillis() / 1000);
        jSONObject.put("session_id", this.b);
        v(jSONObject);
    }

    public final void v(JSONObject jSONObject) throws JSONException {
        String strC = hv0.c();
        String str = strC.split("_")[0];
        String str2 = strC.split("_")[1];
        jSONObject.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, str);
        jSONObject.put("time", str2);
    }
}
