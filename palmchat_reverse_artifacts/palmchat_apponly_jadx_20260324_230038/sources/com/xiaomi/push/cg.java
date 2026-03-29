package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.services.district.DistrictSearchQuery;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class cg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static Context f11468a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static a f192a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static cg f193a;
    private static String c;
    private static String d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private cf f196a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected b f197a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f198a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected final Map<String, cd> f199a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final long f200b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String f201b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private long f202c;
    protected static final Map<String, cc> b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected static boolean f194a = false;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        cg a(Context context, cf cfVar, b bVar, String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        String a(String str);
    }

    public cg(Context context, cf cfVar, b bVar, String str) {
        this(context, cfVar, bVar, str, null, null);
    }

    public static synchronized cg a() {
        cg cgVar;
        cgVar = f193a;
        if (cgVar == null) {
            throw new IllegalStateException("the host manager is not initialized yet.");
        }
        return cgVar;
    }

    private String f() {
        return "host_fallbacks";
    }

    private String g() {
        try {
            PackageInfo packageInfo = f11468a.getPackageManager().getPackageInfo(f11468a.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (Exception unused) {
            return "0";
        }
    }

    public String b() {
        return "resolver.msg.xiaomi.net";
    }

    public cc c(String str) {
        cd cdVar;
        cc ccVarA;
        synchronized (this.f199a) {
            m257a();
            cdVar = this.f199a.get(str);
        }
        if (cdVar == null || (ccVarA = cdVar.a()) == null) {
            return null;
        }
        return ccVarA;
    }

    public cc d(String str) {
        cc ccVar;
        Map<String, cc> map = b;
        synchronized (map) {
            ccVar = map.get(str);
        }
        return ccVar;
    }

    public cc e(String str) {
        if (System.currentTimeMillis() - this.f202c <= this.f195a * 60 * 1000) {
            return null;
        }
        this.f202c = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        cc ccVar = a(arrayList).get(0);
        if (ccVar != null) {
            this.f195a = 0L;
            return ccVar;
        }
        long j = this.f195a;
        if (j >= 15) {
            return null;
        }
        this.f195a = j + 1;
        return null;
    }

    public cg(Context context, cf cfVar, b bVar, String str, String str2, String str3) {
        this.f199a = new HashMap();
        this.f198a = "0";
        this.f195a = 0L;
        this.f200b = 15L;
        this.f202c = 0L;
        this.f201b = "isp_prov_city_country_ip";
        this.f197a = bVar;
        if (cfVar == null) {
            this.f196a = new cf() { // from class: com.xiaomi.push.cg.1
                @Override // com.xiaomi.push.cf
                public boolean a(String str4) {
                    return true;
                }
            };
        } else {
            this.f196a = cfVar;
        }
        this.f198a = str;
        c = str2 == null ? context.getPackageName() : str2;
        d = str3 == null ? g() : str3;
    }

    public cc b(String str) {
        return a(str, true);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m258b() {
        ArrayList<String> arrayList;
        synchronized (this.f199a) {
            m257a();
            arrayList = new ArrayList<>(this.f199a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                cd cdVar = this.f199a.get(arrayList.get(size));
                if (cdVar != null && cdVar.a() != null) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<cc> arrayListA = a(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayListA.get(i) != null) {
                a(arrayList.get(i), arrayListA.get(i));
            }
        }
    }

    public static synchronized void a(a aVar) {
        f192a = aVar;
        f193a = null;
    }

    public String d() {
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        File file;
        try {
            file = new File(f11468a.getFilesDir(), f());
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = null;
            fileInputStream = null;
        }
        try {
            if (file.isFile()) {
                fileInputStream = new FileInputStream(file);
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                    try {
                        String str = new String(h.a(m252a(), w.a((InputStream) bufferedInputStream)), StandardCharsets.UTF_8);
                        com.xiaomi.channel.commonutils.logger.b.b("load host fallbacks = " + str);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = null;
                }
            } else {
                w.a((Closeable) null);
                w.a((Closeable) null);
                return null;
            }
            com.xiaomi.channel.commonutils.logger.b.m74a("load host exception " + th.getMessage());
            return null;
        } finally {
            w.a((Closeable) bufferedInputStream);
            w.a((Closeable) fileInputStream);
        }
    }

    public static synchronized void a(Context context, cf cfVar, b bVar, String str, String str2, String str3) {
        Context applicationContext = context.getApplicationContext();
        f11468a = applicationContext;
        if (applicationContext == null) {
            f11468a = context;
        }
        if (f193a == null) {
            a aVar = f192a;
            if (aVar == null) {
                f193a = new cg(context, cfVar, bVar, str, str2, str3);
            } else {
                f193a = aVar.a(context, cfVar, bVar, str);
            }
        }
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f199a) {
            for (Map.Entry<String, cd> entry : this.f199a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":\n");
                sb.append(entry.getValue().toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String e() {
        if ("com.xiaomi.xmsf".equals(c)) {
            return c;
        }
        return c + ":pushservice";
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public void m262e() {
        String next;
        synchronized (this.f199a) {
            Iterator<cd> it = this.f199a.values().iterator();
            while (it.hasNext()) {
                it.next().a(true);
            }
            while (true) {
                for (boolean z = false; !z; z = true) {
                    Iterator<String> it2 = this.f199a.keySet().iterator();
                    while (it2.hasNext()) {
                        next = it2.next();
                        if (this.f199a.get(next).m247a().isEmpty()) {
                            break;
                        }
                    }
                }
                this.f199a.remove(next);
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m251a() {
        if (f11468a == null) {
            return "unknown";
        }
        try {
            av avVarM168a = au.m168a();
            if (avVarM168a == null) {
                return "unknown";
            }
            if (avVarM168a.a() == 1) {
                return "WIFI-UNKNOWN";
            }
            return avVarM168a.m178a() + "-" + avVarM168a.m180b();
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m259b(String str) {
        synchronized (this.f199a) {
            this.f199a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") == 2) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("data");
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        cd cdVarA = new cd().a(jSONArrayOptJSONArray.getJSONObject(i));
                        this.f199a.put(cdVarA.m246a(), cdVarA);
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("reserved");
                if (jSONArrayOptJSONArray2 != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i2);
                        String strOptString = jSONObject2.optString("host");
                        if (!TextUtils.isEmpty(strOptString)) {
                            try {
                                cc ccVarA = new cc(strOptString).a(jSONObject2);
                                b.put(ccVarA.f189b, ccVarA);
                                com.xiaomi.channel.commonutils.logger.b.m74a("load local reserved host for " + ccVarA.f189b);
                            } catch (JSONException unused) {
                                com.xiaomi.channel.commonutils.logger.b.m74a("parse reserved host fail.");
                            }
                        }
                    }
                }
            } else {
                throw new JSONException("Bad version");
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public cc m253a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return a(new URL(str).getHost(), true);
        }
        throw new IllegalArgumentException("the url is empty");
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void m260c() {
        FileOutputStream fileOutputStreamOpenFileOutput;
        Closeable closeable;
        BufferedOutputStream bufferedOutputStream;
        Exception e;
        synchronized (this.f199a) {
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    String string = m254a().toString();
                    com.xiaomi.channel.commonutils.logger.b.b("persist host fallbacks = " + string);
                    if (TextUtils.isEmpty(string)) {
                        fileOutputStreamOpenFileOutput = null;
                    } else {
                        fileOutputStreamOpenFileOutput = f11468a.openFileOutput(f(), 0);
                        try {
                            bufferedOutputStream = new BufferedOutputStream(fileOutputStreamOpenFileOutput);
                            try {
                                bufferedOutputStream.write(h.b(m252a(), string.getBytes(StandardCharsets.UTF_8)));
                                bufferedOutputStream.flush();
                                bufferedOutputStream2 = bufferedOutputStream;
                            } catch (Exception e2) {
                                e = e2;
                                com.xiaomi.channel.commonutils.logger.b.m74a("persist bucket failure: " + e.getMessage());
                                w.a(bufferedOutputStream);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            bufferedOutputStream = null;
                            e = e;
                            com.xiaomi.channel.commonutils.logger.b.m74a("persist bucket failure: " + e.getMessage());
                            w.a(bufferedOutputStream);
                            w.a(fileOutputStreamOpenFileOutput);
                        } catch (Throwable th) {
                            th = th;
                            closeable = null;
                            th = th;
                            w.a(closeable);
                            w.a(fileOutputStreamOpenFileOutput);
                            throw th;
                        }
                    }
                    w.a(bufferedOutputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    w.a(closeable);
                    w.a(fileOutputStreamOpenFileOutput);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStreamOpenFileOutput = null;
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStreamOpenFileOutput = null;
                closeable = null;
            }
            w.a(fileOutputStreamOpenFileOutput);
        }
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public void m261d() {
        String strE = e();
        try {
            File file = new File(f11468a.getFilesDir(), strE);
            if (file.exists()) {
                boolean zDelete = file.delete();
                StringBuilder sb = new StringBuilder();
                sb.append("Delete old host fallbacks file ");
                sb.append(strE);
                sb.append(zDelete ? " successful." : " failed.");
                com.xiaomi.channel.commonutils.logger.b.m74a(sb.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.b("Old host fallbacks file " + strE + " does not exist.");
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m74a("Delete old host fallbacks file " + strE + " error: " + e.getMessage());
        }
    }

    public cc a(String str, boolean z) {
        cc ccVarE;
        com.xiaomi.channel.commonutils.logger.b.b("HostManager", "-->getFallbacksByHost(): host=", str, ", fetchRemoteIfNeed=", Boolean.valueOf(z));
        if (!TextUtils.isEmpty(str)) {
            if (!this.f196a.a(str)) {
                return null;
            }
            cc ccVarC = c(str);
            return (ccVarC == null || !ccVarC.b()) ? (z && au.m175a(f11468a) && (ccVarE = e(str)) != null) ? ccVarE : new cc(str, ccVarC) { // from class: com.xiaomi.push.cg.2

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                cc f11470a;
                final /* synthetic */ cc b;

                {
                    this.b = ccVarC;
                    this.f11470a = ccVarC;
                    ((cc) this).f189b = ((cc) this).f189b;
                    if (ccVarC != null) {
                        this.f = ccVarC.f;
                    }
                }

                @Override // com.xiaomi.push.cc
                public synchronized ArrayList<String> a(boolean z2) {
                    ArrayList<String> arrayList;
                    arrayList = new ArrayList<>();
                    cc ccVar = this.f11470a;
                    if (ccVar != null) {
                        arrayList.addAll(ccVar.a(true));
                    }
                    Map<String, cc> map = cg.b;
                    synchronized (map) {
                        cc ccVar2 = map.get(((cc) this).f189b);
                        if (ccVar2 != null) {
                            for (String str2 : ccVar2.a(true)) {
                                if (arrayList.indexOf(str2) == -1) {
                                    arrayList.add(str2);
                                }
                            }
                            arrayList.remove(((cc) this).f189b);
                            arrayList.add(((cc) this).f189b);
                        }
                    }
                    return arrayList;
                }

                @Override // com.xiaomi.push.cc
                public boolean b() {
                    return false;
                }

                @Override // com.xiaomi.push.cc
                public synchronized void a(String str2, cb cbVar) {
                    cc ccVar = this.f11470a;
                    if (ccVar != null) {
                        ccVar.a(str2, cbVar);
                    }
                }
            } : ccVarC;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    private ArrayList<cc> a(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        m262e();
        synchronized (this.f199a) {
            m257a();
            for (String str : this.f199a.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        Map<String, cc> map = b;
        synchronized (map) {
            for (Object obj : map.values().toArray()) {
                cc ccVar = (cc) obj;
                if (!ccVar.b()) {
                    b.remove(ccVar.f189b);
                }
            }
        }
        if (!arrayList.contains(b())) {
            arrayList.add(b());
        }
        ArrayList<cc> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(null);
        }
        try {
            String str2 = au.d(f11468a) ? "wifi" : "wap";
            String strA = a(arrayList, str2, this.f198a, true);
            if (!TextUtils.isEmpty(strA)) {
                JSONObject jSONObject3 = new JSONObject(strA);
                com.xiaomi.channel.commonutils.logger.b.b(strA);
                if ("OK".equalsIgnoreCase(jSONObject3.getString(ExifInterface.LATITUDE_SOUTH))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString(DistrictSearchQuery.KEYWORDS_PROVINCE);
                    String string2 = jSONObject4.getString(DistrictSearchQuery.KEYWORDS_CITY);
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString("ip");
                    String string5 = jSONObject4.getString("country");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str2);
                    com.xiaomi.channel.commonutils.logger.b.c("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i2 = 0;
                    while (i2 < arrayList.size()) {
                        String str3 = arrayList.get(i2);
                        JSONArray jSONArrayOptJSONArray = jSONObject5.optJSONArray(str3);
                        if (jSONArrayOptJSONArray == null) {
                            com.xiaomi.channel.commonutils.logger.b.m74a("no bucket found for " + str3);
                            jSONObject = jSONObject5;
                        } else {
                            cc ccVar2 = new cc(str3);
                            int i3 = 0;
                            while (i3 < jSONArrayOptJSONArray.length()) {
                                String string6 = jSONArrayOptJSONArray.getString(i3);
                                if (TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                } else {
                                    jSONObject2 = jSONObject5;
                                    ccVar2.a(new cj(string6, jSONArrayOptJSONArray.length() - i3));
                                }
                                i3++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList2.set(i2, ccVar2);
                            ccVar2.g = string5;
                            ccVar2.c = string;
                            ccVar2.e = string3;
                            ccVar2.f = string4;
                            ccVar2.d = string2;
                            if (jSONObject4.has("stat-percent")) {
                                ccVar2.a(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                ccVar2.b(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has(RemoteMessageConst.TTL)) {
                                ccVar2.a(((long) jSONObject4.getInt(RemoteMessageConst.TTL)) * 1000);
                            }
                            m256a(ccVar2.a());
                        }
                        i2++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject4.optJSONObject("reserved");
                    if (jSONObjectOptJSONObject != null) {
                        long j = jSONObject4.has("reserved-ttl") ? ((long) jSONObject4.getInt("reserved-ttl")) * 1000 : com.igexin.push.f.b.d.b;
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(next);
                            if (jSONArrayOptJSONArray2 == null) {
                                com.xiaomi.channel.commonutils.logger.b.m74a("no bucket found for " + next);
                            } else {
                                cc ccVar3 = new cc(next);
                                ccVar3.a(j);
                                for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                                    String string7 = jSONArrayOptJSONArray2.getString(i4);
                                    if (!TextUtils.isEmpty(string7)) {
                                        ccVar3.a(new cj(string7, jSONArrayOptJSONArray2.length() - i4));
                                    }
                                }
                                Map<String, cc> map2 = b;
                                synchronized (map2) {
                                    if (this.f196a.a(next)) {
                                        map2.put(next, ccVar3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m74a("failed to get bucket " + e.getMessage());
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            cc ccVar4 = arrayList2.get(i5);
            if (ccVar4 != null) {
                a(arrayList.get(i5), ccVar4);
            }
        }
        m260c();
        return arrayList2;
    }

    public String a(ArrayList<String> arrayList, String str, String str2, boolean z) throws IOException {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<at> arrayList3 = new ArrayList();
        arrayList3.add(new ar("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new ar("conpt", a(au.m171a(f11468a))));
        }
        if (z) {
            arrayList3.add(new ar("reserved", "1"));
        }
        arrayList3.add(new ar(Constant.MAP_KEY_UUID, str2));
        arrayList3.add(new ar("list", bb.a(arrayList, ",")));
        arrayList3.add(new ar("countrycode", com.xiaomi.push.service.b.a(f11468a).b()));
        arrayList3.add(new ar("push_sdk_vc", String.valueOf(BuildConfig.VERSION_CODE)));
        String strB = b();
        cc ccVarC = c(strB);
        String str3 = String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", strB);
        if (ccVarC == null) {
            arrayList2.add(str3);
            Map<String, cc> map = b;
            synchronized (map) {
                cc ccVar = map.get(strB);
                if (ccVar != null) {
                    Iterator<String> it = ccVar.a(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", it.next()));
                    }
                }
            }
        } else {
            arrayList2 = ccVarC.a(str3);
        }
        Iterator<String> it2 = arrayList2.iterator();
        IOException e = null;
        while (it2.hasNext()) {
            Uri.Builder builderBuildUpon = Uri.parse(it2.next()).buildUpon();
            for (at atVar : arrayList3) {
                builderBuildUpon.appendQueryParameter(atVar.a(), atVar.b());
            }
            try {
                b bVar = this.f197a;
                if (bVar == null) {
                    return au.a(f11468a, new URL(builderBuildUpon.toString()));
                }
                return bVar.a(builderBuildUpon.toString());
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e == null) {
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("network exception: " + e.getMessage());
        throw e;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m255a() {
        synchronized (this.f199a) {
            this.f199a.clear();
        }
    }

    public void a(String str, cc ccVar) {
        if (!TextUtils.isEmpty(str) && ccVar != null) {
            if (this.f196a.a(str)) {
                synchronized (this.f199a) {
                    m257a();
                    if (this.f199a.containsKey(str)) {
                        this.f199a.get(str).a(ccVar);
                    } else {
                        cd cdVar = new cd(str);
                        cdVar.a(ccVar);
                        this.f199a.put(str, cdVar);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("the argument is invalid " + str + ", " + ccVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m257a() {
        synchronized (this.f199a) {
            if (f194a) {
                return true;
            }
            f194a = true;
            this.f199a.clear();
            try {
                String strD = d();
                if (!TextUtils.isEmpty(strD)) {
                    m259b(strD);
                    com.xiaomi.channel.commonutils.logger.b.b("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m74a("load bucket failure: " + th.getMessage());
            }
            return false;
        }
    }

    public static void a(String str, String str2) {
        Map<String, cc> map = b;
        cc ccVar = map.get(str);
        synchronized (map) {
            if (ccVar == null) {
                cc ccVar2 = new cc(str);
                ccVar2.a(com.igexin.push.f.b.d.b);
                ccVar2.m244a(str2);
                map.put(str, ccVar2);
            } else {
                ccVar.m244a(str2);
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private byte[] m252a() {
        return ba.m200a(f11468a.getPackageName() + "_key_salt");
    }

    public static String a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i = 0; i < bytes.length; i++) {
                byte b2 = bytes[i];
                int i2 = b2 & 240;
                if (i2 != 240) {
                    bytes[i] = (byte) (((b2 & 15) ^ ((byte) (((b2 >> 4) + length) & 15))) | i2);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m256a(String str) {
        this.f201b = str;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public JSONObject m254a() {
        JSONObject jSONObject;
        synchronized (this.f199a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            Iterator<cd> it = this.f199a.values().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().m248a());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            Iterator<cc> it2 = b.values().iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next().m243a());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }
}
