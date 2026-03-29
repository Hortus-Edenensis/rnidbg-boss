package defpackage;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import cn.jpush.android.service.DownloadProvider;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.kuaishou.weapon.p0.g;
import com.qiniu.android.collect.ReportItem;
import java.io.File;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class o75 extends xw2 {
    public static final String i;
    public static final Object j;
    public static Boolean k;
    public static Boolean l;
    public static o75 m;
    public int c;
    public long[] d;
    public String e;
    public volatile boolean f;
    public Context g;
    public boolean h;

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19709a = -1;
        public String b;
        public long c;
        public String d;
        public String e;
        public int f;
        public long g;

        public a() {
        }

        public String toString() {
            return "SharePrcocessBean{idc=" + this.f19709a + ", uuid='" + this.b + "', uid=" + this.c + ", pkgname='" + this.d + "', appkey='" + this.e + "', sdkVersion=" + this.f + ", uuidCreateTime=" + this.g + '}';
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(".jpush");
        String str = File.separator;
        sb.append(str);
        sb.append(".shareinfo");
        sb.append(str);
        i = sb.toString();
        j = new Object();
    }

    public o75() {
        bw2.h("share_process_executor");
        this.f22065a = "ShareProcessManager";
    }

    public static void d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            k63.l("ShareProcessManager", "deletFileIfUninstall failed ,context is null or pkgname is empty");
            return;
        }
        try {
            if (ad.s(context, g.j)) {
                File fileL = l(str);
                if (fileL.exists()) {
                    fileL.delete();
                } else {
                    k63.a("ShareProcessManager", "not found file in sdcard,filepath:" + fileL.getAbsolutePath());
                }
            } else {
                k63.a("ShareProcessManager", "no write sdcard permission when deletFileIfUninstall");
            }
        } catch (Throwable unused) {
        }
    }

    public static String i(Context context) {
        long jLongValue;
        String str;
        if (context == null) {
            return "-1";
        }
        if (!p(context) || fv2.m(context) == 1) {
            k63.a("ShareProcessManager", "[getTypeJson]share process is close by action");
            return "-4";
        }
        if (!gv2.a().b(context)) {
            k63.a("ShareProcessManager", "getAttachJson,is not support jpush or jmessage ");
            return "-7";
        }
        int iH = fv2.h(context);
        if (iH < 0) {
            k63.a("ShareProcessManager", "[getTypeJson]idc<0,need login to get it");
            return "-3";
        }
        long jN = fv2.n(context);
        if (jN <= 0) {
            k63.a("ShareProcessManager", "[getTypeJson]uid<=0,need login to get it");
            return "-2";
        }
        Map map = (Map) fv2.l(context);
        if (map != null) {
            str = (String) map.get(Constant.MAP_KEY_UUID);
            jLongValue = ((Long) map.get("ct")).longValue();
        } else {
            jLongValue = -1;
            str = "";
        }
        String strE = fv2.e(context);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("u", jN);
            jSONObject.put("p", fv2.j(context));
            jSONObject.put("ud", str);
            jSONObject.put("ak", strE);
            jSONObject.put("idc", iH);
            jSONObject.put("pn", context.getPackageName());
            jSONObject.put("sv", wv2.c);
            jSONObject.put("uct", jLongValue);
            return n45.e(jSONObject.toString());
        } catch (JSONException unused) {
            k63.a("ShareProcessManager", "[getTypeJson] to json error");
            return wv2.b;
        }
    }

    public static String j() {
        return "cn.jpush.android.intent.DaemonService";
    }

    public static ActivityInfo k(String str, Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.DownloadActivity");
            intent.addCategory(str);
            intent.setPackage(str);
            ActivityInfo activityInfo = context.getPackageManager().resolveActivity(intent, 0).activityInfo;
            if ((activityInfo instanceof ActivityInfo) && ((ComponentInfo) activityInfo).exported && ((ComponentInfo) activityInfo).enabled) {
                if (!"jpush.custom".equals(activityInfo.taskAffinity)) {
                    k63.a("ShareProcessManager", "download activity need config taskAffinity is jpush.custom");
                } else {
                    if (activityInfo.theme == 16973840) {
                        return activityInfo;
                    }
                    k63.a("ShareProcessManager", "download activity theme must config as @android:style/Theme.Translucent.NoTitleBar");
                }
            }
        } catch (Throwable th) {
            k63.l("ShareProcessManager", "check downloadActivity error:" + th.getMessage());
        }
        k63.a("ShareProcessManager", "DownloadActivity is invalid in " + str);
        return null;
    }

    public static File l(String str) {
        String strG = nl5.g(str);
        if (!TextUtils.isEmpty(strG)) {
            str = strG;
        }
        return new File(Environment.getExternalStorageDirectory(), i + str);
    }

    public static o75 m() {
        if (m == null) {
            synchronized (j) {
                if (m == null) {
                    m = new o75();
                }
            }
        }
        return m;
    }

    public static boolean o(Context context) {
        Boolean bool = l;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            String str = Build.MANUFACTURER;
            String lowerCase = "Xiaomi".toLowerCase();
            if (!TextUtils.isEmpty(str) && TextUtils.equals(lowerCase, str.toLowerCase())) {
                k63.a("ShareProcessManager", "xiaomi not use activity and sdcard");
                Boolean bool2 = Boolean.FALSE;
                l = bool2;
                return bool2.booleanValue();
            }
        } catch (Throwable th) {
            k63.l("ShareProcessManager", "get MANUFACTURER failed - error:" + th.getMessage());
        }
        if (k(context.getPackageName(), context) != null) {
            l = Boolean.TRUE;
        } else {
            l = Boolean.FALSE;
        }
        return l.booleanValue();
    }

    public static boolean p(Context context) {
        Boolean bool = k;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            k63.l("ShareProcessManager", "context is null");
            return true;
        }
        try {
            ProviderInfo providerInfoM = ad.m(context, context.getPackageName(), DownloadProvider.class);
            if (providerInfoM == null) {
                k63.a("ShareProcessManager", "not found download provider in manifest");
                Boolean bool2 = Boolean.FALSE;
                k = bool2;
                return bool2.booleanValue();
            }
            if (((ComponentInfo) providerInfoM).enabled && ((ComponentInfo) providerInfoM).exported && !TextUtils.isEmpty(providerInfoM.authority)) {
                Intent intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction("cn.jiguang.android.share.close");
                List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
                if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                    k = Boolean.TRUE;
                } else {
                    k = Boolean.FALSE;
                }
                return k.booleanValue();
            }
            k63.a("ShareProcessManager", "download provider config error,enable" + ((ComponentInfo) providerInfoM).enabled + ",exported:" + ((ComponentInfo) providerInfoM).exported + ",authority:" + providerInfoM.authority);
            Boolean bool3 = Boolean.FALSE;
            k = bool3;
            return bool3.booleanValue();
        } catch (Throwable th) {
            k63.a("ShareProcessManager", "Get isShareProcessModeOpen error#:" + th.getMessage());
            return true;
        }
    }

    public static JSONObject r(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Throwable th) {
                k63.l("ShareProcessManager", "mapToJSONObject error:" + th.getMessage());
            }
        }
        return jSONObject;
    }

    public static String t(Context context, Uri uri) {
        try {
        } catch (Throwable th) {
            k63.l("ShareProcessManager", "parseUriFromProvider failed:" + th.getMessage());
        }
        if (uri == null) {
            return wv2.b;
        }
        String queryParameter = uri.getQueryParameter("kpgt");
        if (TextUtils.isEmpty(queryParameter)) {
            return wv2.b;
        }
        String strC = n45.c(queryParameter);
        if (TextUtils.isEmpty(strC)) {
            return "-6";
        }
        JSONObject jSONObject = new JSONObject(strC);
        String strOptString = jSONObject.optString("kta");
        k63.a("ShareProcessManager", "action:" + strOptString);
        if (!TextUtils.isEmpty(strOptString)) {
            if (strOptString.equals("asai")) {
                return i(context);
            }
            if (strOptString.equals("asm")) {
                k63.a("ShareProcessManager", "recv msg:" + jSONObject.toString());
                if (p(context) && ((Integer) lg5.c(context, zz2.y())).intValue() != 1) {
                    Bundle bundle = new Bundle();
                    bundle.putString("data", jSONObject.toString());
                    xv2.m(context, "JCore", "asm", bundle);
                    return "0";
                }
                k63.a("ShareProcessManager", "share process is closed!");
                return "-4";
            }
            if (strOptString.equals("asmr")) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("data", jSONObject.toString());
                xv2.m(context, "JCore", "asmr", bundle2);
            }
        }
        return wv2.b;
    }

    @Override // defpackage.xw2
    public void a() {
        boolean z;
        long jCurrentTimeMillis;
        boolean z2;
        Set<a> setY;
        try {
            Map mapD = bw2.d(this.g);
            if (mapD != null) {
                this.e = (String) mapD.get(Constant.MAP_KEY_UUID);
                jCurrentTimeMillis = ((Long) mapD.get("ct")).longValue();
            } else {
                jCurrentTimeMillis = -1;
            }
            k63.a("ShareProcessManager", "sp uuid:" + this.e + ",createTime:" + jCurrentTimeMillis);
            if (TextUtils.isEmpty(this.e) || jCurrentTimeMillis < 0) {
                k63.a("ShareProcessManager", "not found uuid,create uuid");
                this.e = UUID.randomUUID().toString();
                jCurrentTimeMillis = System.currentTimeMillis();
                k63.a("ShareProcessManager", "save uuid and createtime to sp,uuid:" + this.e + ",createtime:" + jCurrentTimeMillis);
                bw2.l(this.g, this.e, jCurrentTimeMillis);
                z2 = true;
            } else {
                z2 = false;
            }
            setY = y(this.g);
        } catch (Throwable th) {
            try {
                k63.c("ShareProcessManager", "#unception, execute ScanAppAction failed:" + th);
                z = false;
            } catch (Throwable th2) {
                this.f = false;
                w(this.g);
                throw th2;
            }
        }
        if (setY == null || setY.isEmpty()) {
            k63.a("ShareProcessManager", "scan app list is empty");
            this.f = false;
        } else {
            int iH = fv2.h(this.g);
            k63.a("ShareProcessManager", "mine idc:" + iH);
            ArrayList arrayList = new ArrayList();
            for (a aVar : setY) {
                if (iH == aVar.f19709a && aVar.c > 0 && !this.g.getPackageName().equals(aVar.d)) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() != 0) {
                this.d = new long[arrayList.size()];
                String str = "";
                String str2 = str;
                long j2 = -1;
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    k63.a("ShareProcessManager", "found same idc app :" + arrayList.get(i2));
                    this.d[i2] = ((a) arrayList.get(i2)).c;
                    str = str + ((a) arrayList.get(i2)).c + ",";
                    if (!TextUtils.isEmpty(((a) arrayList.get(i2)).b) && ((a) arrayList.get(i2)).g > 0 && (((a) arrayList.get(i2)).g < j2 || j2 == -1)) {
                        k63.a("ShareProcessManager", "found older uuid from:" + ((a) arrayList.get(i2)).d);
                        str2 = ((a) arrayList.get(i2)).b;
                        j2 = ((a) arrayList.get(i2)).g;
                    }
                }
                k63.a("ShareProcessManager", "oldestUUID:" + str2 + ",oldestTime:" + j2 + ",localTime:" + jCurrentTimeMillis + ",localUUID:" + this.e);
                if (TextUtils.isEmpty(str2)) {
                    k63.a("ShareProcessManager", "not found other app(contains uuid) ");
                } else if (z2) {
                    if (j2 > jCurrentTimeMillis) {
                        k63.a("ShareProcessManager", "jump time");
                    }
                    this.e = str2;
                    bw2.l(this.g, str2, j2);
                } else {
                    if (jCurrentTimeMillis != j2) {
                        k63.a("ShareProcessManager", "the time exception");
                        bw2.l(this.g, this.e, jCurrentTimeMillis);
                    } else if (!this.e.equals(str2)) {
                        k63.a("ShareProcessManager", "same time but uuid is not same");
                        bw2.l(this.g, "", System.currentTimeMillis());
                    }
                    this.e = str2;
                }
                k63.a("ShareProcessManager", "use uuid:" + this.e + ",uids:" + str);
                bw2.o(this.g, "JCore", 30, 0, wt5.a(), 0L, cw2.e(fv2.n(this.g), this.e, this.d));
                z = false;
                this.f = z;
                w(this.g);
                return;
            }
            k63.a("ShareProcessManager", "not found app by same idc");
            this.f = false;
        }
        w(this.g);
    }

    public final String b(Context context, String str, String str2, HashMap<String, String> map) {
        try {
            ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
            String str3 = str + ".DownloadProvider";
            if (!str3.startsWith("content://")) {
                str3 = "content://" + str3;
            }
            Uri uri = Uri.parse(str3);
            JSONObject jSONObject = new JSONObject();
            Uri.Builder builderBuildUpon = uri.buildUpon();
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("kta", str2);
            }
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            builderBuildUpon.appendQueryParameter("kpgt", n45.e(jSONObject.toString()));
            return contentResolver.getType(builderBuildUpon.build());
        } catch (Throwable th) {
            k63.l("ShareProcessManager", "callUriToDownloadProvider error:" + th.getMessage());
            return null;
        }
    }

    public void c(Context context) {
        if (this.h) {
            this.h = false;
            if (tt5.u().C()) {
                k63.a("ShareProcessManager", "attach mine while app in foreground from background");
                bw2.o(context, "JCore", 30, 0, wt5.a(), 0L, cw2.e(fv2.n(context), this.e, new long[]{fv2.n(context)}));
            }
        }
    }

    public void e(Context context, long j2) {
        try {
            if (TextUtils.isEmpty(this.e)) {
                k63.a("ShareProcessManager", "dettachUid error,shareUUID is empty");
                return;
            }
            k63.a("ShareProcessManager", "dettach uid:" + j2);
            bw2.o(context, "JCore", 32, 0, wt5.a(), 0L, cw2.f(this.e, new long[]{j2}));
        } catch (Throwable th) {
            k63.a("ShareProcessManager", "dettach uid error:" + th.getMessage());
        }
    }

    public void f(Context context, long j2, byte[] bArr) {
        if (j2 == 0 || bArr == null) {
            return;
        }
        try {
            Pair<pw2, ByteBuffer> pairB = hv2.b(context, bArr, "");
            if (pairB != null && ((pw2) pairB.first).c == 3) {
                ByteBuffer byteBuffer = (ByteBuffer) pairB.second;
                byteBuffer.get();
                long j3 = byteBuffer.getLong();
                String strD = cw2.d(byteBuffer);
                if (TextUtils.isEmpty(strD)) {
                    k63.l("ShareProcessManager", "msgContent is empty");
                    return;
                }
                LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(strD));
                String line = lineNumberReader.readLine();
                if (TextUtils.isEmpty(line)) {
                    k63.c("ShareProcessManager", "appid is empty");
                    return;
                }
                String line2 = lineNumberReader.readLine();
                if (TextUtils.isEmpty(line2)) {
                    k63.c("ShareProcessManager", "senderId is empty");
                    return;
                }
                if (p(context) && bw2.e(context) != 1) {
                    if (!ad.v(context, line)) {
                        e(context, ((pw2) pairB.first).g);
                        k63.a("ShareProcessManager", "app not installed:" + line);
                        d(context, line);
                        return;
                    }
                    String strEncodeToString = Base64.encodeToString(bArr, 10);
                    Long lValueOf = Long.valueOf(((pw2) pairB.first).e);
                    HashMap<String, String> map = new HashMap<>();
                    map.put("ktm", strEncodeToString);
                    map.put("ktp", n45.h(fv2.n(context)));
                    map.put("ktma", line2);
                    map.put("mtmmi", j3 + "");
                    map.put("ktmfp", context.getPackageName());
                    map.put("ktmr", lValueOf + "");
                    k63.a("ShareProcessManager", "dispatch share msg,appkey:" + line2 + ",msgid:" + j3 + ",rid:" + lValueOf);
                    String strB = b(context, line, "asm", map);
                    StringBuilder sb = new StringBuilder();
                    sb.append("dispatch result:");
                    sb.append(strB);
                    k63.a("ShareProcessManager", sb.toString());
                    if (TextUtils.isEmpty(strB)) {
                        if (!o(context)) {
                            k63.a("ShareProcessManager", "app can not use downloadActivity dispatch msg");
                            e(context, ((pw2) pairB.first).g);
                        } else {
                            if (!bw2.f1842a && tv2.b(context, false, "do not startActivity in BackGround")) {
                                this.h = true;
                                e(context, fv2.n(context));
                                return;
                            }
                            ActivityInfo activityInfoK = k(line, context);
                            if (activityInfoK != null) {
                                k63.a("ShareProcessManager", "will try use downloadActivity");
                                JSONObject jSONObjectR = r(map);
                                Intent intent = new Intent("asm");
                                intent.setComponent(new ComponentName(activityInfoK.packageName, activityInfoK.name));
                                intent.setFlags(268435456);
                                intent.addCategory(line);
                                intent.putExtra("data", jSONObjectR.toString());
                                context.startActivity(intent);
                            } else {
                                e(context, ((pw2) pairB.first).g);
                            }
                        }
                    } else if (strB.equals("-4")) {
                        e(context, ((pw2) pairB.first).g);
                    } else if (strB.equals("0")) {
                        k63.a("ShareProcessManager", "wait the msg reponse");
                    } else {
                        k63.a("ShareProcessManager", "provider is :" + strB + ",app is less than jcore_v125");
                    }
                    lineNumberReader.close();
                    return;
                }
                e(context, fv2.n(context));
                k63.a("ShareProcessManager", " share process is close,will not dispatch the msg and dettach mine uid");
                return;
            }
            k63.a("ShareProcessManager", "share msg cmd is not 3");
        } catch (Throwable th) {
            k63.l("ShareProcessManager", "dispatchMsg error:" + th.getMessage());
        }
    }

    public void g(Context context, Bundle bundle) {
        try {
            k63.a("ShareProcessManager", "doMsg");
            if (bundle != null) {
                String string = bundle.getString("data");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(string);
                k63.a("ShareProcessManager", "doMsg json:" + jSONObject.toString());
                String strOptString = jSONObject.optString("ktm");
                String strOptString2 = jSONObject.optString("ktp");
                String strOptString3 = jSONObject.optString("mtmmi");
                String strOptString4 = jSONObject.optString("ktmfp");
                String strOptString5 = jSONObject.optString("ktma");
                String strOptString6 = jSONObject.optString("ktmr");
                if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString3) || TextUtils.isEmpty(strOptString4) || TextUtils.isEmpty(strOptString5)) {
                    return;
                }
                HashMap<String, String> map = new HashMap<>();
                map.put("mtmmi", strOptString3);
                map.put("ktmfp", strOptString4);
                map.put("ktma", strOptString5);
                map.put("ktmr", strOptString6);
                Pair<pw2, ByteBuffer> pairB = hv2.b(context, Base64.decode(strOptString, 10), strOptString2);
                if (pairB != null) {
                    map.put("ktmu", ((pw2) pairB.first).g + "");
                    if (!p(context) || bw2.e(context) == 1) {
                        k63.a("ShareProcessManager", "share process is closed");
                        map.put("asmrc", "3");
                    } else if (((pw2) pairB.first).g != fv2.n(context)) {
                        k63.a("ShareProcessManager", "this msg uid is :" + ((pw2) pairB.first).g + ",is not this app msg");
                        map.put("asmrc", "1");
                    } else {
                        map.put("asmrc", "0");
                        zd1.e().c(context, (pw2) pairB.first, (ByteBuffer) pairB.second);
                    }
                }
                b(context, strOptString4, "asmr", map);
            }
        } catch (Throwable th) {
            k63.a("ShareProcessManager", "doMsg error:" + th.getMessage());
        }
    }

    public void h(Context context, Bundle bundle) {
        try {
            String string = bundle.getString("data");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                String strOptString = jSONObject.optString("mtmmi");
                String strOptString2 = jSONObject.optString("ktmfp");
                String strOptString3 = jSONObject.optString("ktma");
                String strOptString4 = jSONObject.optString("ktmr");
                String strOptString5 = jSONObject.optString("ktmu");
                String strOptString6 = jSONObject.optString("asmrc", "0");
                k63.a("ShareProcessManager", "msg response,msgId:" + strOptString + ",fromPkg:" + strOptString2 + ",appKey:" + strOptString3 + ",rid:" + strOptString4 + ",uid:" + strOptString5 + ",responseCode:" + strOptString6);
                if (strOptString6.equals("0") && !TextUtils.isEmpty(strOptString5) && !TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString3) && !TextUtils.isEmpty(strOptString4)) {
                    k63.a("ShareProcessManager", "response success,will send msg response to server");
                    bw2.p(context, "JCore", 4, 2, wt5.a(), Long.parseLong(strOptString5), cw2.i(0, (byte) 0, Long.parseLong(strOptString), strOptString3));
                } else if (strOptString6.equals("1") && !TextUtils.isEmpty(strOptString5)) {
                    e(context, Long.parseLong(strOptString5));
                } else if (!strOptString6.equals("3") || TextUtils.isEmpty(strOptString5)) {
                    k63.a("ShareProcessManager", "invalid msg response");
                } else {
                    e(context, Long.parseLong(strOptString5));
                    d(context, strOptString2);
                }
            }
        } catch (Throwable th) {
            k63.l("ShareProcessManager", "doMsgResponse failed:" + th.getMessage());
        }
    }

    public final a n(Context context, String str) {
        if (tv2.b(context, false, "do not get share info from SD")) {
            return null;
        }
        if (ad.s(context, g.i)) {
            File fileL = l(str);
            String strI = hv1.i(fileL);
            if (TextUtils.isEmpty(strI)) {
                k63.a("ShareProcessManager", "read info is empty from :" + fileL.getAbsolutePath());
                return null;
            }
            a aVarS = s(n45.c(strI));
            if (aVarS == null) {
                k63.a("ShareProcessManager", "parse share process bean with target app:" + str);
            } else if (!ad.v(context, aVarS.d)) {
                k63.a("ShareProcessManager", "found target app is uninsatll when scan sdcard,pkgname:" + aVarS.d);
                d(context, aVarS.d);
            } else {
                if (k(aVarS.d, context) != null) {
                    k63.a("ShareProcessManager", "get share bean info from sdcard:" + aVarS.toString());
                    return aVarS;
                }
                k63.a("ShareProcessManager", "not config DownloadActivity in target app:" + str);
            }
        } else {
            k63.a("ShareProcessManager", "no read sdcard permission");
        }
        return null;
    }

    public final boolean q(String str, ComponentInfo componentInfo) {
        if (componentInfo == null || !(componentInfo instanceof ProviderInfo)) {
            return false;
        }
        ProviderInfo providerInfo = (ProviderInfo) componentInfo;
        k63.j("ShareProcessManager", "scan exported:" + providerInfo.exported + ",enable:" + providerInfo.enabled + ",authority:" + providerInfo.authority + ",process:" + providerInfo.processName);
        if (providerInfo.exported && providerInfo.enabled && !TextUtils.isEmpty(providerInfo.authority)) {
            if (TextUtils.equals(str + ".DownloadProvider", providerInfo.authority)) {
                return true;
            }
        }
        k63.a("ShareProcessManager", "downloadprovider config error,exported:" + providerInfo.exported + ",enable:" + providerInfo.enabled + ",authority:" + providerInfo.authority + ",process:" + providerInfo.processName);
        return false;
    }

    public final a s(String str) {
        Throwable th;
        a aVar;
        try {
        } catch (Throwable th2) {
            th = th2;
            aVar = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        aVar = new a();
        try {
            long jOptLong = jSONObject.optLong("u");
            String strOptString = jSONObject.optString("ak");
            String strOptString2 = jSONObject.optString("pn");
            String strOptString3 = jSONObject.optString("ud");
            int iOptInt = jSONObject.optInt("idc", -1);
            int iOptInt2 = jSONObject.optInt("sv");
            long jOptLong2 = jSONObject.optLong("uct", -1L);
            aVar.c = jOptLong;
            aVar.b = strOptString3;
            aVar.e = strOptString;
            aVar.f19709a = iOptInt;
            aVar.d = strOptString2;
            aVar.f = iOptInt2;
            aVar.g = jOptLong2;
        } catch (Throwable th3) {
            th = th3;
            k63.l("ShareProcessManager", "parse json to shareBean failed:" + th.getMessage());
        }
        return aVar;
        k63.l("ShareProcessManager", "parse json to shareBean failed:" + th.getMessage());
        return aVar;
    }

    public void u(Context context, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append(ReportItem.LogTypeRequest);
        sb.append(i2 == 0 ? "success" : "failed");
        sb.append(",cmd:");
        sb.append(i3);
        sb.append(",code:");
        sb.append(i2);
        k63.a("ShareProcessManager", sb.toString());
        if (i3 == 30 && i2 == 0) {
            this.c = 0;
        }
    }

    public void v(Context context, int i2) {
        k63.a("ShareProcessManager", "requestTimeOut,cmd:" + i2 + ",isAttaching:" + this.f);
        if (i2 != 30 || this.f) {
            return;
        }
        this.c++;
        k63.a("ShareProcessManager", "attachTimeoutTimes:" + this.c + ",requestUIDS:" + this.d + ",shareProcessUUID:" + this.e);
        if (this.c > 2) {
            k63.a("ShareProcessManager", "attach too many times by once scan");
            return;
        }
        long[] jArr = this.d;
        if (jArr == null || jArr.length <= 0 || TextUtils.isEmpty(this.e)) {
            return;
        }
        k63.a("ShareProcessManager", "will retry attach");
        bw2.o(context, "JCore", 30, 0, wt5.a(), 0L, cw2.e(fv2.n(context), this.e, this.d));
    }

    public final void w(Context context) {
        try {
            if (tv2.b(context, false, "do not save ShareInfo to SD")) {
                return;
            }
            if (ad.s(context, g.j)) {
                File fileL = l(context.getPackageName());
                if (o(context)) {
                    String strI = i(context);
                    k63.a("ShareProcessManager", "save info to sdcard:" + fileL.getAbsolutePath());
                    if (!TextUtils.isEmpty(strI) && strI.length() > 10) {
                        hv1.c(fileL);
                        hv1.j(fileL, strI);
                    }
                } else {
                    hv1.c(fileL);
                }
            } else {
                k63.a("ShareProcessManager", "no write sdcard permission");
            }
        } catch (Throwable th) {
            k63.l("ShareProcessManager", "saveShareInfoToSdCard failed:" + th.getMessage());
        }
    }

    public synchronized void x(Context context) {
        if (p(context) && bw2.e(context) != 1) {
            if (!gv2.a().b(context)) {
                k63.a("ShareProcessManager", "is not support jpush or jmessage ");
                return;
            }
            Object objA = qv2.a(context, "getwakeenable", null);
            if ((objA instanceof Boolean) && !((Boolean) objA).booleanValue()) {
                k63.a("ShareProcessManager", "wake disable,not scan share app");
                return;
            }
            if (this.f) {
                k63.a("ShareProcessManager", "isAttaching");
                return;
            }
            this.g = context;
            this.f = true;
            k63.a("ShareProcessManager", "scanOtherApp...");
            this.c = 0;
            bw2.g(this, new int[0]);
            return;
        }
        k63.a("ShareProcessManager", "share process is close by action");
        d(context, context.getPackageName());
    }

    public final Set<a> y(Context context) {
        int i2;
        List<ResolveInfo> listQueryIntentServices;
        HashSet hashSet = new HashSet();
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction(j());
            listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        } catch (Throwable th) {
            k63.l("ShareProcessManager", "scanOtherApp error:" + th.getMessage());
        }
        if (listQueryIntentServices != null && listQueryIntentServices.size() != 0) {
            List<String> arrayList = new ArrayList();
            for (i2 = 0; i2 < listQueryIntentServices.size(); i2++) {
                ServiceInfo serviceInfo = listQueryIntentServices.get(i2).serviceInfo;
                String str = serviceInfo.name;
                String str2 = serviceInfo.packageName;
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !context.getPackageName().equals(str2) && q(str2, ad.m(context, str2, DownloadProvider.class))) {
                    arrayList.add(str2);
                }
            }
            k63.a("ShareProcessManager", "valid size:" + arrayList.size());
            Object objA = qv2.a(context, "filter_pkg_list", arrayList);
            if (objA instanceof List) {
                arrayList = (List) objA;
            }
            k63.a("ShareProcessManager", "valid end size:" + arrayList.size());
            for (String str3 : arrayList) {
                a aVarZ = z(context, str3);
                k63.a("ShareProcessManager", "scan share bean from:" + str3);
                if (aVarZ != null) {
                    hashSet.add(aVarZ);
                }
            }
            k63.a("ShareProcessManager", "end share bean list size:" + hashSet.size());
            return hashSet;
        }
        k63.a("ShareProcessManager", "query service size is empty");
        return hashSet;
    }

    public final a z(Context context, String str) {
        a aVarN;
        try {
            String strB = b(context, str, "asai", null);
            k63.a("ShareProcessManager", "get type from:" + str + ",info:" + strB);
            if (strB != null) {
                if (TextUtils.isEmpty(strB) || strB.length() <= 10) {
                    k63.a("ShareProcessManager", "is not shareprocessbean info");
                    return null;
                }
                String strC = n45.c(strB);
                if (TextUtils.isEmpty(strC)) {
                    k63.a("ShareProcessManager", "decrypt error");
                    return null;
                }
                k63.a("ShareProcessManager", "parse success:" + strC);
                aVarN = s(strC);
            } else {
                if (!o(context)) {
                    return null;
                }
                aVarN = n(context, str);
            }
            return aVarN;
        } catch (Throwable th) {
            k63.n("ShareProcessManager", "scanShareProcessBean error:" + th.getMessage());
            return null;
        }
    }
}
