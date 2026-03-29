package com.xiaomi.push;

import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class cc {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f186a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f187a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f189b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    protected String h;
    private String i;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ArrayList<cj> f188a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f11465a = 0.1d;
    private String j = "s.mi1.cc";
    private long b = 86400000;

    public cc(String str) {
        this.f187a = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f186a = System.currentTimeMillis();
        this.f188a.add(new cj(str, -1));
        this.f187a = cg.m251a();
        this.f189b = str;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m245a() {
        return TextUtils.equals(this.f187a, cg.m251a());
    }

    public boolean b() {
        return System.currentTimeMillis() - this.f186a < this.b;
    }

    public boolean c() {
        long j = this.b;
        if (864000000 >= j) {
            j = 864000000;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = this.f186a;
        return jCurrentTimeMillis - j2 > j || (jCurrentTimeMillis - j2 > this.b && this.f187a.startsWith("WIFI-"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f187a);
        sb.append("\n");
        sb.append(a());
        for (cj cjVar : this.f188a) {
            sb.append("\n");
            sb.append(cjVar.toString());
        }
        sb.append("\n");
        return sb.toString();
    }

    public boolean a(cc ccVar) {
        return TextUtils.equals(this.f187a, ccVar.f187a);
    }

    public void b(String str, long j, long j2) {
        a(str, 0, j, j2, null);
    }

    public void a(long j) {
        if (j > 0) {
            this.b = j;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j);
    }

    public void b(String str, long j, long j2, Exception exc) {
        a(str, -1, j, j2, exc);
    }

    public void b(String str) {
        this.j = str;
    }

    private synchronized void c(String str) {
        Iterator<cj> it = this.f188a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f205a, str)) {
                it.remove();
            }
        }
    }

    public ArrayList<String> a(String str) {
        if (!TextUtils.isEmpty(str)) {
            URL url = new URL(str);
            if (TextUtils.equals(url.getHost(), this.f189b)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it = a(true).iterator();
                while (it.hasNext()) {
                    ce ceVarA = ce.a(it.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), ceVarA.m250a(), ceVarA.a(), url.getFile()).toString());
                }
                return arrayList;
            }
            throw new IllegalArgumentException("the url is not supported by the fallback");
        }
        throw new IllegalArgumentException("the url is empty.");
    }

    public void a(String str, long j, long j2) {
        try {
            b(new URL(str).getHost(), j, j2);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, long j, long j2, Exception exc) {
        try {
            b(new URL(str).getHost(), j, j2, exc);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, int i, long j, long j2, Exception exc) {
        a(str, new cb(i, j, j2, exc));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        r1.a(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(String str, cb cbVar) {
        Iterator<cj> it = this.f188a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            cj next = it.next();
            if (TextUtils.equals(str, next.f205a)) {
                break;
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized ArrayList<String> m242a() {
        return a(false);
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        int size = this.f188a.size();
        cj[] cjVarArr = new cj[size];
        this.f188a.toArray(cjVarArr);
        Arrays.sort(cjVarArr);
        arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            cj cjVar = cjVarArr[i];
            if (z) {
                arrayList.add(cjVar.f205a);
            } else {
                int iIndexOf = cjVar.f205a.indexOf(":");
                if (iIndexOf != -1) {
                    arrayList.add(cjVar.f205a.substring(0, iIndexOf));
                } else {
                    arrayList.add(cjVar.f205a);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m244a(String str) {
        a(new cj(str));
    }

    public synchronized void a(cj cjVar) {
        c(cjVar.f205a);
        this.f188a.add(cjVar);
    }

    public synchronized void a(String[] strArr) {
        int i;
        int size = this.f188a.size() - 1;
        while (true) {
            i = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i < length) {
                    if (TextUtils.equals(this.f188a.get(size).f205a, strArr[i])) {
                        this.f188a.remove(size);
                        break;
                    }
                    i++;
                }
            }
            size--;
        }
        Iterator<cj> it = this.f188a.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int i3 = it.next().f11472a;
            if (i3 > i2) {
                i2 = i3;
            }
        }
        while (i < strArr.length) {
            a(new cj(strArr[i], (strArr.length + i2) - i));
            i++;
        }
    }

    public synchronized String a() {
        if (!TextUtils.isEmpty(this.i)) {
            return this.i;
        }
        if (TextUtils.isEmpty(this.e)) {
            return "hardcode_isp";
        }
        String strA = bb.a(new String[]{this.e, this.c, this.d, this.g, this.f}, "_");
        this.i = strA;
        return strA;
    }

    public void a(double d) {
        this.f11465a = d;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized JSONObject m243a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(TKDownloadReason.KSAD_TK_NET, this.f187a);
        jSONObject.put(RemoteMessageConst.TTL, this.b);
        jSONObject.put("pct", this.f11465a);
        jSONObject.put("ts", this.f186a);
        jSONObject.put(DistrictSearchQuery.KEYWORDS_CITY, this.d);
        jSONObject.put("prv", this.c);
        jSONObject.put(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE, this.g);
        jSONObject.put("isp", this.e);
        jSONObject.put("ip", this.f);
        jSONObject.put("host", this.f189b);
        jSONObject.put("xf", this.h);
        JSONArray jSONArray = new JSONArray();
        Iterator<cj> it = this.f188a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized cc a(JSONObject jSONObject) {
        this.f187a = jSONObject.optString(TKDownloadReason.KSAD_TK_NET);
        this.b = jSONObject.getLong(RemoteMessageConst.TTL);
        this.f11465a = jSONObject.getDouble("pct");
        this.f186a = jSONObject.getLong("ts");
        this.d = jSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY);
        this.c = jSONObject.optString("prv");
        this.g = jSONObject.optString(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
        this.e = jSONObject.optString("isp");
        this.f = jSONObject.optString("ip");
        this.f189b = jSONObject.optString("host");
        this.h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            a(new cj().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }
}
