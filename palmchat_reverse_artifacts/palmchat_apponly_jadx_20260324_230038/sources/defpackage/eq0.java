package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import com.wifi.adsdk.download.LxAdDLManager;
import java.security.SecureRandom;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class eq0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static eq0 f17330a;
    public static Object b;
    public static String c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17331a;
        public int b;
        public int c;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17332a;
        public String b;
        public long c;
        public long d;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends gt5 {
        public Context c;

        public c(Context context) {
            this.c = context;
        }

        @Override // defpackage.gt5
        public void a(Message message) {
            switch (message.what) {
                case 2003:
                    eq0.o(this.c);
                    break;
                case 2004:
                    try {
                        System.currentTimeMillis();
                        a aVarM = eq0.m(this.c);
                        if (aVarM != null) {
                            int i = aVarM.f17331a;
                            if (i > 0) {
                                long jF = kv2.f(this.c);
                                if (m86.g(jF, aVarM.f17331a * 1000)) {
                                    kv2.A(this.c, System.currentTimeMillis());
                                    eq0.d(this.c);
                                } else {
                                    p63.a("CopyManager", "won't collect, last at " + m86.c(jF));
                                }
                            } else if (i == 0) {
                                kv2.A(this.c, System.currentTimeMillis());
                                eq0.d(this.c);
                            }
                            if (aVarM.b > 0) {
                                long jE = kv2.e(this.c);
                                if (!m86.g(jE, aVarM.b * 1000)) {
                                    p63.a("CopyManager", "won't report, last at " + m86.c(jE));
                                } else {
                                    kv2.z(this.c, System.currentTimeMillis());
                                    eq0.p(this.c);
                                }
                            }
                        } else {
                            p63.a("CopyManager", "collect disabled");
                        }
                    } catch (Throwable th) {
                        p63.f("CopyManager", "onHeartbeat e:" + th);
                        return;
                    }
                    break;
                case 2005:
                    eq0.d(null);
                    break;
            }
        }
    }

    public static void d(Context context) {
        a aVarM;
        b bVarI;
        JSONArray jSONArray;
        Context appContext = JCoreManager.getAppContext(context);
        if (appContext == null || (aVarM = m(appContext)) == null || (bVarI = i(appContext, true)) == null) {
            return;
        }
        String strD = kv2.d(appContext);
        JSONArray jSONArray2 = null;
        if (!TextUtils.isEmpty(strD)) {
            try {
                jSONArray = new JSONArray(strD);
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (jSONArray.length() > 0 && jSONArray.getJSONObject(jSONArray.length() - 1).getString("board").equals(bVarI.f17332a)) {
                    p63.a("CopyManager", "same as last, won't update");
                    return;
                }
                jSONArray2 = jSONArray;
            } catch (Throwable th2) {
                th = th2;
                jSONArray2 = jSONArray;
                p63.f("CopyManager", "deal history e:" + th);
            }
        }
        JSONObject jSONObjectF = f(bVarI);
        if (jSONObjectF != null) {
            if (jSONArray2 == null) {
                jSONArray2 = new JSONArray();
            }
            JSONArray jSONArrayPut = jSONArray2.put(jSONObjectF);
            int i = aVarM.c;
            if (i < -1 || i == 0) {
                aVarM.c = 20;
            }
            if (aVarM.c != -1 && jSONArray2.length() > aVarM.c) {
                try {
                    int length = jSONArray2.length() - aVarM.c;
                    p63.a("CopyManager", "need remove first " + length);
                    JSONArray jSONArray3 = new JSONArray();
                    while (length < jSONArray2.length()) {
                        try {
                            jSONArray3.put(jSONArray2.get(length));
                            length++;
                        } catch (Throwable unused) {
                        }
                    }
                    jSONArrayPut = jSONArray3;
                } catch (Throwable unused2) {
                }
            }
            String string = jSONArrayPut.toString();
            try {
                p63.a("CopyManager", "save history=" + jSONArrayPut.toString(2));
            } catch (JSONException unused3) {
            }
            kv2.y(appContext, string);
        }
    }

    public static b e(Context context, Object obj, boolean z) {
        Object objB;
        String string;
        if (obj != null) {
            try {
                Object objOnEvent = JCoreManager.onEvent(context, null, 20, null, null, new Object[0]);
                if ((objOnEvent instanceof Long) && ((Long) objOnEvent).longValue() > 0) {
                    String strD = dq0.d(context, obj);
                    if (TextUtils.isEmpty(strD)) {
                        return null;
                    }
                    String strG = nl5.g(strD);
                    if (z && !TextUtils.isEmpty(c) && c.equals(strG)) {
                        p63.a("CopyManager", "same as last, skip");
                        return null;
                    }
                    c = strG;
                    long jNextLong = new SecureRandom().nextLong();
                    String strB = n45.b(m86.f(strD.getBytes()), jNextLong);
                    b bVar = new b();
                    bVar.c = jNextLong;
                    bVar.f17332a = strB;
                    try {
                        objB = dq0.b(obj);
                    } catch (Throwable unused) {
                        objB = null;
                    }
                    if (objB != null) {
                        try {
                            string = objB.toString();
                        } catch (Throwable unused2) {
                            string = null;
                        }
                    } else {
                        string = null;
                    }
                    if (!TextUtils.isEmpty(string)) {
                        bVar.b = n45.b(m86.f(string.getBytes()), jNextLong);
                    }
                    long jE = (Build.VERSION.SDK_INT < 26 || objB == null) ? 0L : dq0.e(objB);
                    if (jE == 0) {
                        bVar.d = System.currentTimeMillis();
                    } else {
                        bVar.d = jE;
                    }
                    return bVar;
                }
                return null;
            } catch (Throwable th) {
                p63.f("CopyManager", "convert e:" + th);
            }
        }
        return null;
    }

    public static JSONObject f(b bVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("board", bVar.f17332a);
            jSONObject.put(LxAdDLManager.ITEM_DESC, bVar.b);
            jSONObject.put("time", bVar.d);
            jSONObject.put("seed", bVar.c);
            return jSONObject;
        } catch (Throwable th) {
            p63.f("CopyManager", "convert e:" + th);
            return null;
        }
    }

    public static Object h(Context context) {
        if (b == null && context != null) {
            synchronized (eq0.class) {
                if (b == null) {
                    try {
                        b = dq0.c(context);
                    } catch (Throwable th) {
                        p63.f("CopyManager", "getCopyMgr e:" + th);
                    }
                }
            }
        }
        return b;
    }

    public static b i(Context context, boolean z) {
        Object objA;
        try {
            Object objH = h(context);
            if (objH == null || (objA = dq0.a(objH)) == null) {
                return null;
            }
            return e(context, objA, z);
        } catch (Throwable th) {
            p63.f("CopyManager", "get Current copy e:" + th);
            return null;
        }
    }

    public static eq0 j() {
        if (f17330a == null) {
            synchronized (eq0.class) {
                if (f17330a == null) {
                    f17330a = new eq0();
                }
            }
        }
        return f17330a;
    }

    public static a m(Context context) {
        try {
            String strC = kv2.c(context);
            if (TextUtils.isEmpty(strC)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strC);
            a aVar = new a();
            aVar.f17331a = jSONObject.getInt("interval");
            int iOptInt = jSONObject.optInt("r_interval");
            aVar.b = iOptInt;
            if (iOptInt <= 0) {
                aVar.b = 3600;
            }
            int i = aVar.b;
            int i2 = aVar.f17331a;
            if (i < i2) {
                aVar.b = i2;
            }
            aVar.c = jSONObject.optInt("limit");
            return aVar;
        } catch (Throwable th) {
            p63.f("CopyManager", "readConfig e:" + th);
            return null;
        }
    }

    public static void n(Context context, JSONArray jSONArray) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("list", jSONArray);
            Object objOnEvent = JCoreManager.onEvent(context, "JCore", 26, null, null, jSONObject, "board");
            if (objOnEvent instanceof JSONObject) {
                jSONObject = (JSONObject) objOnEvent;
            }
            JCoreManager.onEvent(context, "JCore", 39, null, null, jSONObject);
        } catch (Throwable th) {
            p63.f("CopyManager", "report e:" + th);
        }
    }

    public static void o(Context context) {
        JSONObject jSONObjectF;
        try {
            b bVarI = i(context, false);
            if (bVarI == null || (jSONObjectF = f(bVarI)) == null) {
                return;
            }
            n(context, new JSONArray().put(jSONObjectF));
        } catch (Throwable th) {
            p63.f("CopyManager", "reportCurrent e:" + th);
        }
    }

    public static void p(Context context) {
        try {
            String strD = kv2.d(context);
            if (TextUtils.isEmpty(strD)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(strD);
            kv2.y(context, null);
            n(context, jSONArray);
            p63.a("CopyManager", "report history=" + jSONArray.toString(2));
        } catch (Throwable th) {
            p63.f("CopyManager", "reportHistory e:" + th);
        }
    }

    public void g(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            int i = jSONObject2.getInt("action");
            if (i == 1) {
                p63.a("CopyManager", "disable");
                kv2.a(context);
            } else if (i == 2) {
                p63.a("CopyManager", "reportCurrent");
                nt5.b().g(2003, 0L, new c(context));
            } else if (i == 3) {
                p63.a("CopyManager", "setConfig=" + jSONObject2);
                q(context, jSONObject2);
            }
        } catch (Throwable th) {
            p63.f("CopyManager", "deal report e:" + th);
        }
    }

    public void k(Context context) {
        String strC = kv2.c(context);
        p63.a("CopyManager", "int copy:" + strC);
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        try {
            nt5.b().d(context);
            q(context, new JSONObject(strC));
        } catch (JSONException unused) {
        }
    }

    public void l(Context context) {
        nt5.b().g(2004, 0L, new c(context));
    }

    public void q(Context context, JSONObject jSONObject) {
        try {
            if (jSONObject.getInt("interval") < 0) {
                return;
            }
            kv2.x(context, jSONObject.toString());
        } catch (Throwable th) {
            p63.f("CopyManager", "setConfig e:" + th);
        }
    }
}
