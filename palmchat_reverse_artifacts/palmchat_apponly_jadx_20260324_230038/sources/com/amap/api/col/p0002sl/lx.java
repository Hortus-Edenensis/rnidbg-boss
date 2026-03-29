package com.amap.api.col.p0002sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.col.p0002sl.id;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class lx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f2983a = 1;
    public static int b = 2;
    private static lx e;
    private Context j;
    private String k;
    private long c = 0;
    private boolean d = false;
    private ArrayList<String> f = new ArrayList<>();
    private le g = new le();
    private le h = new le();
    private long i = 120000;
    private boolean l = false;

    private lx(Context context) {
        this.j = context;
    }

    private static String c(int i) {
        return i == b ? "last_ip_6" : "last_ip_4";
    }

    private void d(int i) {
        if (b(i).d()) {
            SharedPreferences.Editor editorA = ml.a(this.j, "cbG9jaXA");
            ml.a(editorA, c(i));
            ml.a(editorA);
            b(i).a(false);
        }
    }

    private String e(int i) {
        String str;
        int i2 = 0;
        b(false, i);
        String[] strArrA = b(i).a();
        if (strArrA == null || strArrA.length <= 0) {
            g(i);
            return b(i).b();
        }
        int length = strArrA.length;
        while (true) {
            if (i2 >= length) {
                str = null;
                break;
            }
            str = strArrA[i2];
            if (!this.f.contains(str)) {
                break;
            }
            i2++;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b(i).a(str);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        if (b(i).a() == null || b(i).a().length <= 0) {
            return;
        }
        String str = b(i).a()[0];
        if (str.equals(this.k) || this.f.contains(str)) {
            return;
        }
        this.k = str;
        SharedPreferences.Editor editorA = ml.a(this.j, "cbG9jaXA");
        ml.a(editorA, c(i), str);
        ml.a(editorA);
    }

    private void g(int i) {
        String strA = ml.a(this.j, "cbG9jaXA", c(i), (String) null);
        if (TextUtils.isEmpty(strA) || this.f.contains(strA)) {
            return;
        }
        b(i).a(strA);
        b(i).b(strA);
        b(i).a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public le b(int i) {
        return i == b ? this.h : this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0 || strArr.length != strArr2.length) {
            return false;
        }
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (!strArr[i].equals(strArr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static synchronized lx a(Context context) {
        if (e == null) {
            e = new lx(context);
        }
        return e;
    }

    public final String a(ma maVar, int i) {
        try {
            if (md.q() && maVar != null) {
                String strF = maVar.f();
                String host = new URL(strF).getHost();
                if (!"http://abroad.apilocate.amap.com/mobile/binary".equals(strF) && !"abroad.apilocate.amap.com".equals(host)) {
                    String str = "apilocate.amap.com".equalsIgnoreCase(host) ? "httpdns.apilocate.amap.com" : host;
                    if (!fs.g(str)) {
                        return null;
                    }
                    String strE = e(i);
                    if (!TextUtils.isEmpty(strE)) {
                        maVar.c(strF.replace(host, strE));
                        maVar.d().put("host", str);
                        maVar.e(str);
                        maVar.a(i == b);
                        return strE;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0017 A[Catch: all -> 0x008e, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:10:0x000f, B:12:0x0017, B:21:0x0031, B:23:0x004b, B:24:0x0080), top: B:30:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004b A[Catch: all -> 0x008e, LOOP:0: B:22:0x0049->B:23:0x004b, LOOP_END, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:10:0x000f, B:12:0x0017, B:21:0x0031, B:23:0x004b, B:24:0x0080), top: B:30:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void b(boolean z, final int i) {
        if (!z) {
            if (!md.p() && this.l) {
                return;
            }
            if (this.c != 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = this.c;
                if (jCurrentTimeMillis - j < this.i) {
                    return;
                }
                if (jCurrentTimeMillis - j < 60000) {
                    return;
                }
            }
            this.c = System.currentTimeMillis();
            this.l = true;
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuffer stringBuffer = new StringBuffer();
            for (StackTraceElement stackTraceElement : stackTrace) {
                stringBuffer.append(stackTraceElement.getClassName() + "(" + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber() + "),");
            }
            jc.a().b(new jd() { // from class: com.amap.api.col.2sl.lx.1
                @Override // com.amap.api.col.p0002sl.jd
                public final void a() {
                    int i2;
                    StringBuilder sb = new StringBuilder("http://");
                    sb.append(md.r());
                    sb.append("?host=dualstack-a.apilocate.amap.com&query=");
                    sb.append(i == lx.b ? 6 : 4);
                    String string = sb.toString();
                    ly lyVar = new ly();
                    lyVar.a(string);
                    lyVar.b(string);
                    lyVar.a(id.a.SINGLE);
                    lyVar.a(id.c.HTTP);
                    try {
                        hx.a();
                        JSONObject jSONObject = new JSONObject(new String(hx.c(lyVar).f2902a));
                        String[] strArrB = lx.b(jSONObject.optJSONArray("ips"), lx.f2983a);
                        if (strArrB != null && strArrB.length > 0 && !lx.b(strArrB, lx.this.b(lx.f2983a).a())) {
                            lx.this.b(lx.f2983a).a(strArrB);
                            lx.this.f(lx.f2983a);
                        }
                        String[] strArrB2 = lx.b(jSONObject.optJSONArray("ipsv6"), lx.b);
                        if (strArrB2 != null && strArrB2.length > 0 && !lx.b(strArrB2, lx.this.b(lx.b).a())) {
                            lx.this.b(lx.b).a(strArrB2);
                            lx.this.f(lx.b);
                        }
                        if ((jSONObject.has("ips") || jSONObject.has("ipsv6")) && jSONObject.has(RemoteMessageConst.TTL) && (i2 = jSONObject.getInt(RemoteMessageConst.TTL)) > 30) {
                            lx.this.i = i2 * 1000;
                        }
                    } catch (Throwable th) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("key", "dnsError");
                            jSONObject2.put("reason", th.getMessage());
                        } catch (Throwable unused) {
                        }
                        mk.a(lx.this.j, "O018", jSONObject2);
                    }
                }
            });
            return;
        }
        if (this.c != 0) {
        }
        this.c = System.currentTimeMillis();
        this.l = true;
        StackTraceElement[] stackTrace2 = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer2 = new StringBuffer();
        while (i < r1) {
        }
        jc.a().b(new jd() { // from class: com.amap.api.col.2sl.lx.1
            @Override // com.amap.api.col.p0002sl.jd
            public final void a() {
                int i2;
                StringBuilder sb = new StringBuilder("http://");
                sb.append(md.r());
                sb.append("?host=dualstack-a.apilocate.amap.com&query=");
                sb.append(i == lx.b ? 6 : 4);
                String string = sb.toString();
                ly lyVar = new ly();
                lyVar.a(string);
                lyVar.b(string);
                lyVar.a(id.a.SINGLE);
                lyVar.a(id.c.HTTP);
                try {
                    hx.a();
                    JSONObject jSONObject = new JSONObject(new String(hx.c(lyVar).f2902a));
                    String[] strArrB = lx.b(jSONObject.optJSONArray("ips"), lx.f2983a);
                    if (strArrB != null && strArrB.length > 0 && !lx.b(strArrB, lx.this.b(lx.f2983a).a())) {
                        lx.this.b(lx.f2983a).a(strArrB);
                        lx.this.f(lx.f2983a);
                    }
                    String[] strArrB2 = lx.b(jSONObject.optJSONArray("ipsv6"), lx.b);
                    if (strArrB2 != null && strArrB2.length > 0 && !lx.b(strArrB2, lx.this.b(lx.b).a())) {
                        lx.this.b(lx.b).a(strArrB2);
                        lx.this.f(lx.b);
                    }
                    if ((jSONObject.has("ips") || jSONObject.has("ipsv6")) && jSONObject.has(RemoteMessageConst.TTL) && (i2 = jSONObject.getInt(RemoteMessageConst.TTL)) > 30) {
                        lx.this.i = i2 * 1000;
                    }
                } catch (Throwable th) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("key", "dnsError");
                        jSONObject2.put("reason", th.getMessage());
                    } catch (Throwable unused) {
                    }
                    mk.a(lx.this.j, "O018", jSONObject2);
                }
            }
        });
        return;
    }

    public final void a(int i) {
        if (!b(i).e()) {
            this.f.add(b(i).b());
            d(i);
            b(true, i);
            return;
        }
        d(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] b(JSONArray jSONArray, int i) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new String[0];
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String string = jSONArray.getString(i2);
            if (!TextUtils.isEmpty(string)) {
                if (i == b) {
                    string = "[" + string + "]";
                }
                strArr[i2] = string;
            }
        }
        return strArr;
    }

    public final void a(boolean z, int i) {
        b(i).b(z);
        if (z) {
            String strC = b(i).c();
            String strB = b(i).b();
            if (TextUtils.isEmpty(strB) || strB.equals(strC)) {
                return;
            }
            SharedPreferences.Editor editorA = ml.a(this.j, "cbG9jaXA");
            ml.a(editorA, c(i), strB);
            ml.a(editorA);
        }
    }
}
