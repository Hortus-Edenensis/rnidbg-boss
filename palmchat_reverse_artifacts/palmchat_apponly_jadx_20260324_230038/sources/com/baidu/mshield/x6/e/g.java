package com.baidu.mshield.x6.e;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.x6.EngineImpl;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f4085a;

    public g(Context context, int i) {
        this.f4085a = context;
    }

    public JSONObject a() {
        try {
            return b();
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(50:5|6|7|8|9|10|11|12|13|14|15|16|(1:18)(1:19)|20|21|22|23|24|25|124|26|(1:30)|31|(1:33)(1:34)|35|36|(1:38)(1:39)|40|41|42|(1:44)(1:45)|46|50|51|52|(2:128|53)|(15:55|(1:57)(1:59)|120|60|118|61|76|77|78|(1:80)|81|(9:83|84|85|(4:89|(2:92|90)|130|93)|94|95|96|97|98)|99|(2:101|(3:103|(4:107|(2:110|108)|131|111)|112))|113)(9:67|77|78|(0)|81|(0)|99|(0)|113)|70|71|126|72|76|77|78|(0)|81|(0)|99|(0)|113) */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019a, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x019b, code lost:
    
        com.baidu.mshield.x6.f.f.b(r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0278 A[Catch: all -> 0x02f6, TryCatch #2 {all -> 0x02f6, blocks: (B:3:0x0008, B:5:0x0022, B:7:0x002b, B:9:0x0034, B:11:0x0045, B:13:0x0056, B:15:0x0078, B:20:0x0087, B:22:0x008c, B:24:0x0095, B:50:0x00fc, B:52:0x0112, B:78:0x01a2, B:81:0x01a9, B:83:0x01d2, B:85:0x01fa, B:87:0x0208, B:89:0x020e, B:90:0x0212, B:92:0x0218, B:93:0x0222, B:94:0x0236, B:96:0x025e, B:98:0x0267, B:99:0x026e, B:101:0x0278, B:103:0x0284, B:105:0x02a3, B:107:0x02a9, B:108:0x02ad, B:110:0x02b3, B:111:0x02bd, B:112:0x02d1, B:113:0x02d6, B:70:0x018d, B:75:0x019b, B:49:0x00f9, B:26:0x00b5, B:35:0x00dc, B:40:0x00e6, B:42:0x00eb, B:46:0x00f4, B:72:0x0192), top: B:122:0x0008, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d2 A[Catch: all -> 0x02f6, TRY_LEAVE, TryCatch #2 {all -> 0x02f6, blocks: (B:3:0x0008, B:5:0x0022, B:7:0x002b, B:9:0x0034, B:11:0x0045, B:13:0x0056, B:15:0x0078, B:20:0x0087, B:22:0x008c, B:24:0x0095, B:50:0x00fc, B:52:0x0112, B:78:0x01a2, B:81:0x01a9, B:83:0x01d2, B:85:0x01fa, B:87:0x0208, B:89:0x020e, B:90:0x0212, B:92:0x0218, B:93:0x0222, B:94:0x0236, B:96:0x025e, B:98:0x0267, B:99:0x026e, B:101:0x0278, B:103:0x0284, B:105:0x02a3, B:107:0x02a9, B:108:0x02ad, B:110:0x02b3, B:111:0x02bd, B:112:0x02d1, B:113:0x02d6, B:70:0x018d, B:75:0x019b, B:49:0x00f9, B:26:0x00b5, B:35:0x00dc, B:40:0x00e6, B:42:0x00eb, B:46:0x00f4, B:72:0x0192), top: B:122:0x0008, inners: #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JSONObject b() {
        String strOptString;
        String str;
        String str2;
        String strB;
        String strOptString2 = "";
        try {
            JSONObject jSONObjectA = com.baidu.xclient.gdid.a.a();
            com.baidu.mshield.b.c.a.a("praseJsonData jsonObject=" + jSONObjectA);
            if (jSONObjectA != null) {
                com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(this.f4085a);
                jSONObjectA.put("15004", com.baidu.mshield.x6.f.f.a());
                jSONObjectA.put("15101", EngineImpl.getInstance(this.f4085a).getPropertyByType(EngineImpl.KEY_CUID));
                jSONObjectA.put("15110", EngineImpl.getInstance(this.f4085a).getPropertyByType("aid"));
                jSONObjectA.put("15018", EngineImpl.getInstance(this.f4085a).getPropertyByType("oid"));
                String propertyByType = EngineImpl.getInstance(this.f4085a).getPropertyByType("sl");
                jSONObjectA.put("07001", propertyByType);
                jSONObjectA.put("02037", com.baidu.mshield.x6.f.f.a(this.f4085a) ? "1" : "0");
                jSONObjectA.put("17001", com.baidu.mshield.x6.c.b.a());
                jSONObjectA.put("06005", a(this.f4085a));
                com.baidu.mshield.b.c.a.b("07001 sensor list=" + propertyByType);
                try {
                    jSONObjectA.put("15100", com.baidu.mshield.x6.f.f.g(this.f4085a));
                    boolean zA = a.a(this.f4085a, com.baidu.mshield.x6.b.b.n);
                    jSONObjectA.put("15090", zA && a.a(this.f4085a, com.baidu.mshield.x6.b.b.n, "2", true) ? "1" : "0");
                    jSONObjectA.put("15093", zA ? "1" : "0");
                    jSONObjectA.put("15099", bVar.C() ? "0" : "1");
                } catch (Throwable th) {
                    com.baidu.mshield.x6.f.f.b(th);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("3", EngineImpl.getInstance(this.f4085a).getPropertyByType("p"));
                jSONObject.put("4", EngineImpl.getInstance(this.f4085a).getPropertyByType("s"));
                EngineImpl.getInstance(this.f4085a).getSecApi().a(this.f4085a, jSONObject);
                jSONObjectA.put("1011105", jSONObject);
                try {
                    strB = com.baidu.mshield.x6.f.f.b(this.f4085a);
                } catch (Throwable th2) {
                    th = th2;
                    strOptString = "";
                    str = strOptString;
                }
                if (TextUtils.isEmpty(strB)) {
                    str2 = "";
                    strOptString = str2;
                    jSONObjectA.put("15091", TextUtils.isEmpty(strOptString2) ? "0" : "1");
                    jSONObjectA.put("15082", str2 + "#" + bVar.E());
                    jSONObjectA.put("15083", strOptString);
                    if (!TextUtils.isEmpty(strOptString2)) {
                    }
                    if (a.a(this.f4085a, com.baidu.mshield.x6.b.b.o)) {
                    }
                    jSONObjectA.put("15086", com.baidu.mshield.x6.f.f.e() + "#" + com.baidu.mshield.x6.f.f.d());
                } else {
                    JSONObject jSONObject2 = new JSONObject(strB);
                    String strOptString3 = jSONObject2.optString("1");
                    if (TextUtils.isEmpty(strOptString3)) {
                        str = "";
                    } else {
                        str = new String(com.baidu.mshield.b.a.c.b(Base64.decode(strOptString3.getBytes(), 0)), "utf-8");
                        com.baidu.mshield.b.c.a.a("getJsonDataPart18 ungzDrf : " + str);
                    }
                    try {
                        strOptString = jSONObject2.optString("3");
                        try {
                            strOptString2 = jSONObject2.optString("2");
                        } catch (Throwable th3) {
                            th = th3;
                            com.baidu.mshield.x6.f.f.b(th);
                            jSONObjectA.put("15094", com.baidu.mshield.x6.f.f.a(th));
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        strOptString = "";
                    }
                    str2 = strOptString2;
                    strOptString2 = str;
                    jSONObjectA.put("15091", TextUtils.isEmpty(strOptString2) ? "0" : "1");
                    jSONObjectA.put("15082", str2 + "#" + bVar.E());
                    jSONObjectA.put("15083", strOptString);
                    if (!TextUtils.isEmpty(strOptString2)) {
                        com.baidu.mshield.b.c.a.a("real machine sig is not empty");
                        com.baidu.mshield.b.c.a.a("getEmulatorResultPolicy datas===" + strOptString2);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        List<String> listA = com.baidu.mshield.x6.c.a.a(strOptString2);
                        jSONObjectA.put("d0005", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        JSONArray jSONArray = new JSONArray();
                        if (listA != null && listA.size() > 0) {
                            Iterator<String> it = listA.iterator();
                            while (it.hasNext()) {
                                jSONArray.put(it.next());
                            }
                            com.baidu.mshield.b.c.a.a("getEmulatorResult 15084===" + jSONArray);
                        }
                        jSONObjectA.put("15084", jSONArray);
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        JSONObject jSONObjectB = com.baidu.mshield.x6.c.a.b(strOptString2);
                        long jCurrentTimeMillis3 = System.currentTimeMillis();
                        com.baidu.mshield.b.c.a.a("cpp param 2 result : " + jSONObjectB);
                        jSONObjectA.put("d0006", String.valueOf(jCurrentTimeMillis3 - jCurrentTimeMillis2));
                        jSONObjectA.put("15085", jSONObjectB.toString());
                    }
                    if (a.a(this.f4085a, com.baidu.mshield.x6.b.b.o)) {
                        String strC = com.baidu.mshield.x6.f.f.c(this.f4085a);
                        if (!TextUtils.isEmpty(strC)) {
                            com.baidu.mshield.b.c.a.a("getEmulatorResultPolicy===" + strC);
                            List<String> listA2 = com.baidu.mshield.x6.c.a.a(strC);
                            JSONArray jSONArray2 = new JSONArray();
                            if (listA2 != null && listA2.size() > 0) {
                                Iterator<String> it2 = listA2.iterator();
                                while (it2.hasNext()) {
                                    jSONArray2.put(it2.next());
                                }
                                com.baidu.mshield.b.c.a.a("getEmulatorResult 14001===" + jSONArray2);
                            }
                            jSONObjectA.put("14001", jSONArray2);
                        }
                    }
                    jSONObjectA.put("15086", com.baidu.mshield.x6.f.f.e() + "#" + com.baidu.mshield.x6.f.f.d());
                }
                com.baidu.mshield.x6.f.f.b(th);
                jSONObjectA.put("15094", com.baidu.mshield.x6.f.f.a(th));
                str2 = strOptString2;
                strOptString2 = str;
                jSONObjectA.put("15091", TextUtils.isEmpty(strOptString2) ? "0" : "1");
                jSONObjectA.put("15082", str2 + "#" + bVar.E());
                jSONObjectA.put("15083", strOptString);
                if (!TextUtils.isEmpty(strOptString2)) {
                }
                if (a.a(this.f4085a, com.baidu.mshield.x6.b.b.o)) {
                }
                jSONObjectA.put("15086", com.baidu.mshield.x6.f.f.e() + "#" + com.baidu.mshield.x6.f.f.d());
            }
            return jSONObjectA;
        } catch (Throwable th5) {
            a(th5);
            return null;
        }
    }

    public final void a(Throwable th) {
        com.baidu.mshield.x6.f.f.b(th);
    }

    public static String a(Context context) {
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver == null) {
                return null;
            }
            String stringExtra = intentRegisterReceiver.getStringExtra("technology");
            return TextUtils.isEmpty(stringExtra) ? "unknown" : stringExtra;
        } catch (Exception e) {
            com.baidu.mshield.x6.f.f.b(e);
            return null;
        }
    }
}
