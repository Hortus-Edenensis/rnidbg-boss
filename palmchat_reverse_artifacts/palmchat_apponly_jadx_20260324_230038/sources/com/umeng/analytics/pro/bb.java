package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class bb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f10867a = {"um_plus_game_level", "um_plus_game_pay", "um_plus_game_buy", "um_plus_game_use", "um_plus_game_bonus"};
    public static final String[] b = {"id", "ts", f.ac, "__ct__", "pn", "ds"};
    public static final String c = "^(?!\\d)[a-zA-Z0-9_\\-\\+\\.]{1,}$";
    public static final int d = 128;
    public static final int e = 256;
    public static final int f = 100;
    private a h;
    private String i;
    private String j;
    private boolean k;
    private Map<String, String> l = null;
    private Map<String, Object> m = null;
    JSONObject g = null;

    /* JADX INFO: renamed from: com.umeng.analytics.pro.bb$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10868a;

        static {
            int[] iArr = new int[a.values().length];
            f10868a = iArr;
            try {
                iArr[a.ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10868a[a.LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10868a[a.STRING_MAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10868a[a.OBJECT_MAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        ID,
        LABEL,
        STRING_MAP,
        OBJECT_MAP
    }

    private void h() {
        String str;
        try {
            JSONArray jSONArray = new JSONArray();
            String str2 = this.i;
            String strSubstring = "";
            if (str2 == null) {
                jSONArray.put(ay.f10862a);
            } else if (TextUtils.isEmpty(str2.trim())) {
                jSONArray.put(ay.b);
            } else {
                boolean z = this.i.trim().getBytes().length > 128;
                if (Arrays.asList(f10867a).contains(this.i)) {
                    jSONArray.put(ay.c);
                    str = this.i;
                } else {
                    str = null;
                }
                if (!Pattern.matches(c, this.i)) {
                    jSONArray.put(ay.e);
                    str = this.i;
                }
                if (z) {
                    jSONArray.put(ay.d);
                    strSubstring = this.i.length() > 128 ? this.i.substring(0, 128) : this.i;
                } else {
                    strSubstring = str;
                }
            }
            if (strSubstring != null) {
                this.g.put("eID", strSubstring);
                if (jSONArray.length() > 0) {
                    this.g.put("code", jSONArray);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void i() {
        try {
            h();
            JSONObject jSONObjectA = a(this.i, this.j, true);
            if (jSONObjectA.length() > 0) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObjectA);
                if (this.g == null) {
                    this.g = new JSONObject();
                }
                if (!this.g.has("eID")) {
                    this.g.put("eID", this.i);
                }
                this.g.put("epps", jSONArray);
            }
        } catch (Throwable unused) {
        }
    }

    private void j() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            h();
            if (this.l == null) {
                this.m = null;
            } else {
                this.m = new HashMap(this.l);
            }
            a(this.m, jSONObject, jSONArray);
            a(jSONObject, jSONArray);
        } catch (Throwable unused) {
        }
    }

    private void k() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            h();
            a(this.m, jSONObject, jSONArray);
            a(jSONObject, jSONArray);
        } catch (Throwable unused) {
        }
    }

    public a a() {
        return this.h;
    }

    public String b() {
        return this.i;
    }

    public String c() {
        return this.j;
    }

    public boolean d() {
        return this.k;
    }

    public Map<String, String> e() {
        return this.l;
    }

    public Map<String, Object> f() {
        return this.m;
    }

    public JSONObject g() {
        this.g = new JSONObject();
        int i = AnonymousClass1.f10868a[this.h.ordinal()];
        if (i == 1) {
            h();
            JSONObject jSONObject = this.g;
            if (jSONObject == null || jSONObject.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.g);
            }
        } else if (i == 2) {
            i();
            JSONObject jSONObject2 = this.g;
            if (jSONObject2 == null || jSONObject2.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.g);
            }
        } else if (i == 3) {
            j();
            JSONObject jSONObject3 = this.g;
            if (jSONObject3 == null || jSONObject3.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.g);
            }
        } else if (i != 4) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "unknown CkItem type!");
        } else {
            k();
            JSONObject jSONObject4 = this.g;
            if (jSONObject4 == null || jSONObject4.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.g);
            }
        }
        return this.g;
    }

    private JSONObject c(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (obj instanceof String) {
                jSONObject = a(str, (String) obj, false);
            } else if (!(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof Float) && !(obj instanceof Double)) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(ay.q);
                jSONObject.put("code", jSONArray);
                jSONObject.put("pid", obj.getClass().getName());
                jSONObject.put("msg", str);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public bb a(a aVar) {
        this.h = aVar;
        return this;
    }

    public bb b(String str) {
        this.j = str;
        return this;
    }

    public bb a(String str) {
        this.i = str;
        return this;
    }

    public bb b(Map<String, Object> map) {
        this.m = map;
        return this;
    }

    private void b(Map<String, Object> map, JSONObject jSONObject, JSONArray jSONArray) {
        try {
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                JSONArray jSONArrayA = a(str, obj);
                if (jSONArrayA != null && jSONArrayA.length() > 0) {
                    for (int i = 0; i < jSONArrayA.length(); i++) {
                        jSONArray.put(jSONArrayA.get(i));
                    }
                } else {
                    jSONObject.put(str, obj);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public bb a(boolean z) {
        this.k = z;
        return this;
    }

    public bb a(Map<String, String> map) {
        this.l = map;
        return this;
    }

    private void a(JSONObject jSONObject, JSONArray jSONArray) throws JSONException {
        if (this.g == null) {
            this.g = new JSONObject();
        }
        if (jSONArray.length() > 0) {
            this.g.put("epps", jSONArray);
            if (jSONObject.length() > 0) {
                this.g.put("pps", jSONObject);
            }
        }
        if (!this.g.has("epps") || this.g.has("code")) {
            return;
        }
        this.g.put("eID", this.i);
    }

    private JSONObject b(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (str == null) {
                jSONArray.put(ay.o);
                jSONObject.put("pid", "");
            } else if (TextUtils.isEmpty(str.trim())) {
                jSONArray.put(ay.l);
                jSONObject.put("pid", "");
            } else {
                boolean z = str.trim().getBytes().length > 128;
                if (Arrays.asList(b).contains(str)) {
                    jSONArray.put(ay.g);
                    jSONObject.put("pid", str);
                }
                if (!Pattern.matches(c, str)) {
                    jSONArray.put(ay.p);
                    jSONObject.put("pid", str);
                }
                if (z) {
                    jSONArray.put(ay.h);
                    if (str.length() > 128) {
                        str = str.substring(0, 128);
                    }
                    jSONObject.put("pid", str);
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("code", jSONArray);
                jSONObject.put("msg", obj);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private void a(Map<String, Object> map, JSONObject jSONObject, JSONArray jSONArray) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            if (map == null) {
                jSONArray2.put(ay.n);
            } else if (map.isEmpty()) {
                jSONArray2.put(ay.k);
            } else if (map.size() > 100) {
                jSONArray2.put(ay.f);
            }
            if (jSONArray2.length() > 0) {
                jSONObject2.put("code", jSONArray2);
                jSONArray.put(jSONObject2);
            } else {
                b(map, jSONObject, jSONArray);
            }
        } catch (Throwable unused) {
        }
    }

    private JSONArray a(String str, Object obj) {
        JSONArray jSONArray = null;
        try {
            JSONObject jSONObjectB = b(str, obj);
            if (jSONObjectB.length() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                try {
                    jSONArray2.put(jSONObjectB);
                    jSONArray = jSONArray2;
                } catch (Throwable unused) {
                    return jSONArray2;
                }
            }
            JSONObject jSONObjectC = c(str, obj);
            if (jSONObjectC.length() <= 0) {
                return jSONArray;
            }
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            jSONArray.put(jSONObjectC);
            return jSONArray;
        } catch (Throwable unused2) {
            return jSONArray;
        }
    }

    private JSONObject a(String str, String str2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (str2 == null) {
                jSONArray.put(ay.i);
                jSONObject.put("code", jSONArray);
                jSONObject.put("pid", "");
                jSONObject.put("msg", str);
            } else if (str2.getBytes().length > 256) {
                if (z) {
                    jSONArray.put(ay.m);
                } else {
                    jSONArray.put(ay.j);
                }
                jSONObject.put("code", jSONArray);
                if (str2.length() > 256) {
                    str2 = str2.substring(0, 256);
                }
                jSONObject.put("pid", str2);
                jSONObject.put("msg", str);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
