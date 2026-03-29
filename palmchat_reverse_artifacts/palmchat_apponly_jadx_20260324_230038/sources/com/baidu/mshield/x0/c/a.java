package com.baidu.mshield.x0.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x0.d.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4049a = "";

    /* JADX INFO: renamed from: com.baidu.mshield.x0.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0096a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f4050a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ com.baidu.mshield.x0.l.a c;

        public C0096a(JSONObject jSONObject, Context context, com.baidu.mshield.x0.l.a aVar) {
            this.f4050a = jSONObject;
            this.b = context;
            this.c = aVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            String str;
            int i;
            String str2;
            String str3;
            int i2;
            String str4;
            String[] strArr;
            String str5;
            JSONObject jSONObject;
            String str6 = "4";
            String str7 = "7";
            String str8 = "1";
            try {
                int iOptInt = this.f4050a.optInt("1", 0);
                String strOptString = this.f4050a.optString("4", "");
                String strOptString2 = this.f4050a.optString("5", "");
                String strOptString3 = this.f4050a.optString("6", "");
                int iOptInt2 = this.f4050a.has("7") ? this.f4050a.optJSONObject("7").optInt("1", 1) : 0;
                String strValueOf = String.valueOf(System.currentTimeMillis());
                com.baidu.mshield.b.c.a.b("detect app encryptStr====" + a.f4049a);
                String strB = com.baidu.xclient.gdid.a.b(a.f4049a);
                com.baidu.mshield.b.c.a.b("detect app decryptStr====" + strB);
                JSONObject jSONObject2 = !TextUtils.isEmpty(strB) ? new JSONObject(strB) : new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                String str9 = "8";
                String str10 = "0";
                if (jSONObject2.length() > 0) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        Iterator<String> it = itKeys;
                        String next = itKeys.next();
                        String str11 = strOptString;
                        JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(next);
                        JSONObject jSONObject4 = jSONObject2;
                        String strOptString4 = jSONObjectOptJSONObject.optString("p");
                        String str12 = strValueOf;
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("f");
                        JSONObject jSONObject5 = new JSONObject();
                        JSONObject jSONObject6 = jSONObject3;
                        PackageInfo packageInfoB = b.b(this.b, strOptString4);
                        if (packageInfoB != null) {
                            str4 = next;
                            if (iOptInt == 1) {
                                i = iOptInt;
                                jSONObject5.put(str10, e.a(new File(packageInfoB.applicationInfo.sourceDir)));
                            } else {
                                i = iOptInt;
                            }
                            jSONObject5.put(str8, str8);
                            if (b.c(this.b, strOptString4)) {
                                jSONObject5.put(str6, str8);
                            } else {
                                jSONObject5.put(str6, str10);
                            }
                            ArrayList arrayList = new ArrayList();
                            JSONObject jSONObject7 = new JSONObject();
                            str = str6;
                            if (jSONObjectOptJSONObject2 != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                                while (itKeys2.hasNext()) {
                                    int i3 = iOptInt2;
                                    StringBuffer stringBuffer = new StringBuffer();
                                    String str13 = str10;
                                    String next2 = itKeys2.next();
                                    String str14 = str8;
                                    String strOptString5 = jSONObjectOptJSONObject2.optString(next2);
                                    if (TextUtils.isEmpty(strOptString5)) {
                                        iOptInt2 = i3;
                                        str8 = str14;
                                        str10 = str13;
                                    } else {
                                        String str15 = str9;
                                        if (new File(strOptString5).exists()) {
                                            String[] strArrA = com.baidu.mshield.b.a.b.a(strOptString5);
                                            jSONObject = jSONObjectOptJSONObject2;
                                            stringBuffer.append(strArrA[0]);
                                            stringBuffer.append("#");
                                            str5 = str7;
                                            stringBuffer.append(strArrA[1]);
                                            stringBuffer.append("#");
                                            stringBuffer.append(strArrA[2]);
                                            stringBuffer.append("#");
                                            stringBuffer.append(strArrA[3]);
                                        } else {
                                            str5 = str7;
                                            jSONObject = jSONObjectOptJSONObject2;
                                        }
                                        arrayList.add(strOptString5);
                                        jSONObject7.put(next2, stringBuffer.toString());
                                        iOptInt2 = i3;
                                        str8 = str14;
                                        str10 = str13;
                                        str9 = str15;
                                        jSONObjectOptJSONObject2 = jSONObject;
                                        str7 = str5;
                                    }
                                }
                            }
                            String str16 = str8;
                            JSONObject jSONObject8 = jSONObjectOptJSONObject2;
                            String str17 = str10;
                            String str18 = str9;
                            int i4 = iOptInt2;
                            jSONObject5.put("3", String.valueOf(b.a(this.b, strOptString4, arrayList)));
                            jSONObject5.put("5", jSONObject7.toString());
                            jSONObject5.put("6", packageInfoB.firstInstallTime);
                            str7 = str7;
                            jSONObject5.put(str7, packageInfoB.lastUpdateTime);
                            if (jSONObject8 == null || jSONObject8.length() <= 0) {
                                str8 = str16;
                                str3 = str18;
                                str2 = str17;
                                jSONObject5.put(str3, str2);
                            } else {
                                str8 = str16;
                                str3 = str18;
                                jSONObject5.put(str3, str8);
                                str2 = str17;
                            }
                            jSONObject5.put("9", packageInfoB.versionName);
                            i2 = i4;
                            if (i2 == 1) {
                                String[] strArrA2 = b.a(this.b, strOptString4);
                                int i5 = 0;
                                while (i5 < strArrA2.length) {
                                    String str19 = strArrA2[i5];
                                    StringBuffer stringBuffer2 = new StringBuffer();
                                    if (TextUtils.isEmpty(str19)) {
                                        strArr = strArrA2;
                                    } else {
                                        String[] strArrA3 = com.baidu.mshield.b.a.b.a(str19);
                                        strArr = strArrA2;
                                        stringBuffer2.append(strArrA3[0]);
                                        stringBuffer2.append("#");
                                        stringBuffer2.append(strArrA3[1]);
                                        stringBuffer2.append("#");
                                        stringBuffer2.append(strArrA3[2]);
                                        stringBuffer2.append("#");
                                        stringBuffer2.append(strArrA3[3]);
                                    }
                                    jSONObject5.put(String.valueOf(i5 + 10), stringBuffer2.toString());
                                    i5++;
                                    strArrA2 = strArr;
                                }
                            }
                        } else {
                            str = str6;
                            i = iOptInt;
                            str2 = str10;
                            str3 = str9;
                            i2 = iOptInt2;
                            str4 = next;
                            jSONObject5.put(str8, str2);
                        }
                        jSONObject6.put(str4, jSONObject5);
                        str9 = str3;
                        iOptInt2 = i2;
                        str10 = str2;
                        strOptString = str11;
                        itKeys = it;
                        jSONObject2 = jSONObject4;
                        strValueOf = str12;
                        iOptInt = i;
                        jSONObject3 = jSONObject6;
                        str6 = str;
                    }
                }
                String str20 = strOptString;
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject9 = new JSONObject();
                jSONObject9.put("3", jSONObject3);
                jSONObject9.put(str10, strValueOf);
                jSONObject9.put("5", str20);
                jSONObject9.put("6", strOptString2);
                jSONObject9.put(str7, strOptString3);
                jSONObject9.put(str9, EngineImpl.getInstance(this.b).getPropertyByType("mod"));
                jSONArray.put(jSONObject9);
                com.baidu.mshield.b.c.a.b("handleNativeCollect: upArray=" + jSONArray);
                d.b(this.b, jSONArray, "1001159");
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(str20);
                stringBuffer3.append("_");
                stringBuffer3.append(strOptString2);
                stringBuffer3.append("_");
                stringBuffer3.append(strOptString3);
                this.c.f(stringBuffer3.toString());
                a.f4049a = "";
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    public static void a(Context context) {
        JSONObject jSONObjectOptJSONObject;
        try {
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(context);
            String strC = aVar.c("plc114");
            com.baidu.mshield.b.c.a.b("handleNativeCollect: policy=" + strC);
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strC);
            boolean z = jSONObject.optInt("1", 0) == 1;
            com.baidu.mshield.b.c.a.b("handleNativeCollect: sw=" + z);
            if (z && (jSONObjectOptJSONObject = jSONObject.optJSONObject("5").optJSONObject("uv6")) != null) {
                com.baidu.mshield.b.c.a.b("detect app encrypt===" + f4049a);
                int iOptInt = jSONObjectOptJSONObject.optInt("3", 10);
                if (TextUtils.isEmpty(f4049a)) {
                    return;
                }
                new Timer().schedule(new C0096a(jSONObjectOptJSONObject, context, aVar), iOptInt * 1000);
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
