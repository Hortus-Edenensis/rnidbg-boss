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
public class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4051a;
    public static String b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f4052a;
        public final /* synthetic */ Context b;

        public a(JSONObject jSONObject, Context context) {
            this.f4052a = jSONObject;
            this.b = context;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            String str;
            int i;
            String str2;
            JSONObject jSONObject;
            String str3;
            JSONObject jSONObject2;
            String str4;
            String str5 = "4";
            String str6 = "1";
            try {
                int iOptInt = this.f4052a.optInt("1", 0);
                String strOptString = this.f4052a.optString("4", "");
                int iOptInt2 = this.f4052a.has("7") ? this.f4052a.optJSONObject("7").optInt("1", 1) : 0;
                String strValueOf = String.valueOf(System.currentTimeMillis());
                com.baidu.mshield.b.c.a.b("detect app encryptStr====" + c.b);
                String strB = com.baidu.xclient.gdid.a.b(c.b);
                com.baidu.mshield.b.c.a.b("detect app decryptStr====" + strB);
                JSONObject jSONObject3 = !TextUtils.isEmpty(strB) ? new JSONObject(strB) : new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                String str7 = "8";
                String str8 = "0";
                if (jSONObject3.length() > 0) {
                    Iterator<String> itKeys = jSONObject3.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        Iterator<String> it = itKeys;
                        JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject(next);
                        JSONObject jSONObject5 = jSONObject3;
                        String strOptString2 = jSONObjectOptJSONObject.optString("p");
                        String str9 = strOptString;
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("f");
                        JSONObject jSONObject6 = new JSONObject();
                        String str10 = strValueOf;
                        PackageInfo packageInfoB = b.b(this.b, strOptString2);
                        if (packageInfoB != null) {
                            str2 = next;
                            if (iOptInt == 1) {
                                i = iOptInt;
                                jSONObject6.put(str8, e.a(new File(packageInfoB.applicationInfo.sourceDir)));
                            } else {
                                i = iOptInt;
                            }
                            jSONObject6.put(str6, str6);
                            if (b.c(this.b, strOptString2)) {
                                jSONObject6.put(str5, str6);
                            } else {
                                jSONObject6.put(str5, str8);
                            }
                            ArrayList arrayList = new ArrayList();
                            JSONObject jSONObject7 = new JSONObject();
                            str = str5;
                            if (jSONObjectOptJSONObject2 != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                                while (itKeys2.hasNext()) {
                                    JSONObject jSONObject8 = jSONObject4;
                                    StringBuffer stringBuffer = new StringBuffer();
                                    int i2 = iOptInt2;
                                    String next2 = itKeys2.next();
                                    String str11 = str8;
                                    String strOptString3 = jSONObjectOptJSONObject2.optString(next2);
                                    if (TextUtils.isEmpty(strOptString3)) {
                                        jSONObject4 = jSONObject8;
                                        str8 = str11;
                                        iOptInt2 = i2;
                                    } else {
                                        String str12 = str6;
                                        if (new File(strOptString3).exists()) {
                                            String[] strArrA = com.baidu.mshield.b.a.b.a(strOptString3);
                                            str4 = str7;
                                            stringBuffer.append(strArrA[0]);
                                            stringBuffer.append("#");
                                            jSONObject2 = jSONObjectOptJSONObject2;
                                            stringBuffer.append(strArrA[1]);
                                            stringBuffer.append("#");
                                            stringBuffer.append(strArrA[2]);
                                            stringBuffer.append("#");
                                            stringBuffer.append(strArrA[3]);
                                        } else {
                                            jSONObject2 = jSONObjectOptJSONObject2;
                                            str4 = str7;
                                        }
                                        arrayList.add(strOptString3);
                                        jSONObject7.put(next2, stringBuffer.toString());
                                        jSONObject4 = jSONObject8;
                                        str8 = str11;
                                        iOptInt2 = i2;
                                        str6 = str12;
                                        str7 = str4;
                                        jSONObjectOptJSONObject2 = jSONObject2;
                                    }
                                }
                            }
                            String str13 = str6;
                            String str14 = str8;
                            JSONObject jSONObject9 = jSONObjectOptJSONObject2;
                            int i3 = iOptInt2;
                            jSONObject = jSONObject4;
                            String str15 = str7;
                            jSONObject6.put("3", String.valueOf(b.a(this.b, strOptString2, arrayList)));
                            jSONObject6.put("5", jSONObject7.toString());
                            jSONObject6.put("6", packageInfoB.firstInstallTime);
                            jSONObject6.put("7", packageInfoB.lastUpdateTime);
                            if (jSONObject9 == null || jSONObject9.length() <= 0) {
                                str6 = str13;
                                str3 = str15;
                                str8 = str14;
                                jSONObject6.put(str3, str8);
                            } else {
                                str6 = str13;
                                str3 = str15;
                                jSONObject6.put(str3, str6);
                                str8 = str14;
                            }
                            jSONObject6.put("9", packageInfoB.versionName);
                            iOptInt2 = i3;
                            if (iOptInt2 == 1) {
                                String[] strArrA2 = b.a(this.b, strOptString2);
                                for (int i4 = 0; i4 < strArrA2.length; i4++) {
                                    String str16 = strArrA2[i4];
                                    StringBuffer stringBuffer2 = new StringBuffer();
                                    if (!TextUtils.isEmpty(str16)) {
                                        String[] strArrA3 = com.baidu.mshield.b.a.b.a(str16);
                                        stringBuffer2.append(strArrA3[0]);
                                        stringBuffer2.append("#");
                                        stringBuffer2.append(strArrA3[1]);
                                        stringBuffer2.append("#");
                                        stringBuffer2.append(strArrA3[2]);
                                        stringBuffer2.append("#");
                                        stringBuffer2.append(strArrA3[3]);
                                    }
                                    jSONObject6.put(String.valueOf(i4 + 10), stringBuffer2.toString());
                                }
                            }
                        } else {
                            str = str5;
                            i = iOptInt;
                            str2 = next;
                            jSONObject = jSONObject4;
                            str3 = str7;
                            jSONObject6.put(str6, str8);
                        }
                        JSONObject jSONObject10 = jSONObject;
                        jSONObject10.put(str2, jSONObject6);
                        jSONObject4 = jSONObject10;
                        str7 = str3;
                        itKeys = it;
                        jSONObject3 = jSONObject5;
                        strOptString = str9;
                        strValueOf = str10;
                        iOptInt = i;
                        str5 = str;
                    }
                }
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject11 = new JSONObject();
                jSONObject11.put("3", jSONObject4);
                jSONObject11.put(str8, strValueOf);
                jSONObject11.put("5", strOptString);
                jSONObject11.put(str7, EngineImpl.getInstance(this.b).getPropertyByType("mod"));
                jSONArray.put(jSONObject11);
                com.baidu.mshield.b.c.a.b("handleNativeCollect: upArray=" + jSONArray);
                d.b(this.b, jSONArray, "1001159");
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    public static void a(Context context) {
        try {
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(context);
            String strC = aVar.c("plc115");
            com.baidu.mshield.b.c.a.b("handleCollectRoutine: policy=" + strC);
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strC);
            boolean z = true;
            if (jSONObject.optInt("1", 0) != 1) {
                z = false;
            }
            com.baidu.mshield.b.c.a.b("handleCollectRoutine: sw=" + z);
            if (z) {
                if (System.currentTimeMillis() - aVar.h() < ((long) jSONObject.optInt("3", 24)) * 3600000) {
                    com.baidu.mshield.b.c.a.b("handleCollectRoutine not time");
                    return;
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("5").optJSONObject("uv4");
                if (jSONObjectOptJSONObject != null) {
                    int iOptInt = jSONObjectOptJSONObject.optInt("3", 10);
                    if ((jSONObjectOptJSONObject.has("7") ? jSONObjectOptJSONObject.optJSONObject("7").optInt("2", 0) : 0) == 0) {
                        b = f4051a;
                    } else {
                        b = jSONObjectOptJSONObject.optString("2");
                    }
                    if (TextUtils.isEmpty(b)) {
                        return;
                    }
                    new Timer().schedule(new a(jSONObjectOptJSONObject, context), iOptInt * 1000);
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
