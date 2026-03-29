package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.qiniu.android.collect.ReportItem;
import com.qiniu.android.http.dns.DnsSource;
import com.zenmen.palmchat.framework.httpdns.DNSNode;
import com.zenmen.palmchat.utils.HttpsHelper;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class it0 {
    public static boolean l = false;
    public static String[] m;
    public static Object n = new Object();
    public static it0 o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f18253a;
    public String b;
    public String c;
    public String d;
    public String e;
    public HandlerThread i;
    public Handler j;
    public List<te1> f = new ArrayList();
    public ConcurrentHashMap<String, DNSNode[]> g = new ConcurrentHashMap<>();
    public String h = "";
    public int k = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            it0.this.p();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends ContentObserver {
        public b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            onChange(z, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            pe1.a("DnsHelper_DnsCache", "[onChange]");
            it0.this.p();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements Runnable {
        public static long i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f18256a;
        public String b;
        public Context c;
        public String d;
        public String e;
        public String f;
        public Handler g;
        public Map<String, DNSNode[]> h;

        public c(Context context, String str, String str2, String str3, String str4, String str5, Handler handler, Map<String, DNSNode[]> map) {
            this.f18256a = str;
            this.b = str5;
            this.c = context;
            this.d = str4;
            this.e = str3;
            this.f = str2;
            this.g = handler;
            this.h = map;
        }

        public final String a(JSONArray jSONArray, JSONArray jSONArray2) {
            JSONArray jSONArray3 = new JSONArray();
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                    try {
                        jSONObjectOptJSONObject.put("ipV6", true);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jSONArray3.put(jSONObjectOptJSONObject);
                }
            }
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    jSONArray3.put(jSONArray2.optJSONObject(i3));
                }
            }
            return jSONArray3.toString();
        }

        /* JADX WARN: Can't wrap try/catch for region: R(27:0|2|143|3|(1:5)(1:6)|7|8|(1:10)(1:11)|12|(1:14)|15|133|16|17|141|(1:19)(1:(1:23))|24|(1:26)|27|(13:139|28|(2:151|30)(1:157)|90|91|92|137|101|(2:153|103)|(1:112)|113|(1:117)|118)|36|(5:38|39|(3:41|(1:46)(1:45)|47)(1:49)|(3:51|(3:52|53|(8:135|55|56|145|57|58|147|59)(1:158))|66)(1:72)|73)(1:74)|155|75|83|(2:115|117)|118) */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0219, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x021a, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x021f, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x0220, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0225, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0226, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Removed duplicated region for block: B:131:0x029f  */
        /* JADX WARN: Removed duplicated region for block: B:149:0x0288 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:159:? A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean b(String str, boolean z) throws Throwable {
            Throwable th;
            HttpURLConnection httpURLConnection;
            String str2;
            Throwable th2;
            boolean z2;
            Handler handler;
            String str3;
            HttpURLConnection httpURLConnection2;
            StringBuilder sb;
            BufferedReader bufferedReader;
            BufferedReader bufferedReader2;
            boolean z3;
            String string;
            String str4 = "DnsHelper_DnsCache";
            BufferedReader bufferedReader3 = null;
            try {
                String str5 = it0.l ? "http://118.184.189.140/dns/v3/select" : str;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str5);
                sb2.append("?tv=");
                sb2.append(System.currentTimeMillis());
                sb2.append("&deviceId=");
                sb2.append(this.d);
                if (TextUtils.isEmpty(this.f18256a)) {
                    str3 = "";
                } else {
                    str3 = "&uid=" + this.f18256a;
                }
                sb2.append(str3);
                String string2 = sb2.toString();
                if (!nl0.k()) {
                    string2 = string2 + "&0xCAFEBABE=9";
                }
                pe1.a("DnsHelper_DnsCache", "doFetch START URL:::" + string2);
                httpURLConnection2 = (HttpURLConnection) new URL(string2).openConnection(Proxy.NO_PROXY);
                try {
                    try {
                        httpURLConnection2.setRequestMethod("GET");
                        httpURLConnection2.setConnectTimeout(5000);
                        httpURLConnection2.setReadTimeout(5000);
                        b13.a(httpURLConnection2);
                        try {
                            if (it0.l) {
                                httpURLConnection2.addRequestProperty("Host", "dn-pre.lianxinapp.com");
                            } else if (z) {
                                httpURLConnection2.addRequestProperty("Host", nl0.l.replace("https://", ""));
                            }
                            if (httpURLConnection2 instanceof HttpsURLConnection) {
                                HttpsHelper.getmInstance();
                                ((HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(HttpsHelper.getmSSLSocketFactory());
                                ((HttpsURLConnection) httpURLConnection2).setHostnameVerifier(HttpsHelper.DO_NOT_VERIFY);
                            }
                            httpURLConnection2.connect();
                            sb = new StringBuilder();
                            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream()));
                        } catch (Throwable th3) {
                            th = th3;
                            httpURLConnection = httpURLConnection2;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        httpURLConnection = httpURLConnection2;
                    }
                } catch (Exception e) {
                    e = e;
                    str2 = "DnsHelper_DnsCache";
                    httpURLConnection = httpURLConnection2;
                }
            } catch (Exception e2) {
                e = e2;
                str2 = "DnsHelper_DnsCache";
                httpURLConnection = null;
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = null;
            }
            while (true) {
                try {
                    try {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            try {
                                sb.append(line);
                            } catch (Exception e3) {
                                e = e3;
                                str2 = "DnsHelper_DnsCache";
                                httpURLConnection = httpURLConnection2;
                                bufferedReader3 = bufferedReader;
                            } catch (Throwable th6) {
                                th = th6;
                                httpURLConnection = httpURLConnection2;
                                bufferedReader3 = bufferedReader;
                                if (bufferedReader3 != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            str2 = str4;
                        }
                        httpURLConnection = httpURLConnection2;
                        bufferedReader2 = bufferedReader;
                        bufferedReader3 = bufferedReader2;
                        if (z2 && (handler = this.g) != null) {
                            handler.removeCallbacksAndMessages("update_task_token");
                        }
                        return z2;
                    } catch (Throwable th7) {
                        th2 = th7;
                        httpURLConnection = httpURLConnection2;
                    }
                    pe1.b(str2, "doFetch Exception:", e);
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        } catch (IllegalStateException e6) {
                            e6.printStackTrace();
                        } catch (NullPointerException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    z2 = false;
                } catch (Throwable th8) {
                    th2 = th8;
                    th = th2;
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        } catch (IllegalStateException e9) {
                            e9.printStackTrace();
                        } catch (NullPointerException e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        throw th;
                    }
                    httpURLConnection.disconnect();
                    throw th;
                }
            }
            JSONObject jSONObject = new JSONObject(sb.toString());
            int i2 = jSONObject.getInt("resultCode");
            pe1.a("DnsHelper_DnsCache", "doFetch resultObj:::" + jSONObject);
            if (i2 == 0) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                long j = jSONObject2.getLong("ts");
                String string3 = jSONObject2.getString("area");
                Cursor cursorQuery = this.c.getContentResolver().query(kt0.f18824a, null, null, null, null);
                if (cursorQuery != null) {
                    z3 = !cursorQuery.moveToFirst() || j >= cursorQuery.getLong(cursorQuery.getColumnIndex("timestamp"));
                    cursorQuery.close();
                } else {
                    z3 = true;
                }
                if (z3) {
                    JSONArray jSONArray = jSONObject2.getJSONArray(DnsSource.Udp);
                    ContentValues[] contentValuesArr = new ContentValues[jSONArray.length() + 1];
                    int i3 = 0;
                    while (true) {
                        str2 = str4;
                        if (i3 >= jSONArray.length()) {
                            break;
                        }
                        try {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                            httpURLConnection = httpURLConnection2;
                            try {
                                string = jSONObject3.getString("domain");
                                bufferedReader2 = bufferedReader;
                            } catch (Exception e11) {
                                e = e11;
                            } catch (Throwable th9) {
                                th2 = th9;
                                bufferedReader2 = bufferedReader;
                                bufferedReader3 = bufferedReader2;
                                th = th2;
                                if (bufferedReader3 != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                            }
                            try {
                                JSONArray jSONArray2 = jSONObject3.getJSONArray("pairs");
                                JSONArray jSONArray3 = jSONArray;
                                JSONArray jSONArrayOptJSONArray = jSONObject3.optJSONArray("pairsIpv6");
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("domain", string);
                                contentValues.put("ip_list", a(jSONArrayOptJSONArray, jSONArray2));
                                contentValues.put("timestamp", Long.valueOf(j));
                                contentValues.put("area", string3);
                                contentValuesArr[i3] = contentValues;
                                i3++;
                                bufferedReader = bufferedReader2;
                                str4 = str2;
                                httpURLConnection2 = httpURLConnection;
                                jSONArray = jSONArray3;
                            } catch (Exception e12) {
                                e = e12;
                            } catch (Throwable th10) {
                                th2 = th10;
                                bufferedReader3 = bufferedReader2;
                                th = th2;
                                if (bufferedReader3 != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                            }
                        } catch (Exception e13) {
                            e = e13;
                            httpURLConnection = httpURLConnection2;
                        }
                    }
                    httpURLConnection = httpURLConnection2;
                    bufferedReader2 = bufferedReader;
                    JSONArray jSONArray4 = jSONObject2.getJSONArray("self");
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("domain", "self");
                    contentValues2.put("ip_list", jSONArray4.toString());
                    contentValues2.put("timestamp", Long.valueOf(j));
                    contentValues2.put("area", string3);
                    contentValuesArr[jSONArray.length()] = contentValues2;
                    this.c.getContentResolver().bulkInsert(kt0.f18824a, contentValuesArr);
                } else {
                    httpURLConnection = httpURLConnection2;
                    bufferedReader2 = bufferedReader;
                }
                z2 = true;
            } else {
                httpURLConnection = httpURLConnection2;
                bufferedReader2 = bufferedReader;
                z2 = false;
            }
            bufferedReader2.close();
            httpURLConnection.disconnect();
            if (z2) {
                handler.removeCallbacksAndMessages("update_task_token");
            }
            return z2;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean c() throws Throwable {
            boolean z;
            boolean zB;
            DNSNode[] dNSNodeArr = this.h.get("self");
            ArrayList arrayList = new ArrayList();
            if (dNSNodeArr == null || dNSNodeArr.length <= 0) {
                if (it0.m != null) {
                    for (int i2 = 0; i2 < it0.m.length; i2++) {
                        arrayList.add(it0.m[i2]);
                    }
                    z = true;
                }
                Log.i("DnsHelper_DnsCache", "requestDnsData start ips=" + az2.c(arrayList) + " needUseExtraIpSeed=" + z);
                Collections.shuffle(arrayList);
                StringBuilder sb = new StringBuilder();
                sb.append((String) arrayList.get(0));
                sb.append("/dns/v3/select");
                zB = b(sb.toString(), true);
                Log.i("DnsHelper_DnsCache", "requestDnsData result1=" + zB);
                if (!zB) {
                    return zB;
                }
                if (z) {
                    ArrayList<String> arrayListD = d();
                    Log.i("DnsHelper_DnsCache", "requestDnsData requestRemoteSeedList result=" + az2.c(arrayListD));
                    if (arrayListD != null && arrayListD.size() > 0) {
                        Collections.shuffle(arrayListD);
                        boolean zB2 = b(arrayListD.get(0) + "/dns/v3/select", true);
                        Log.i("DnsHelper_DnsCache", "requestDnsData result2=" + zB2);
                        zB = zB2;
                    }
                }
                if (zB) {
                    return zB;
                }
                boolean zB3 = b(this.f, false);
                Log.i("DnsHelper_DnsCache", "requestDnsData result3=" + zB3);
                return zB3;
            }
            for (DNSNode dNSNode : dNSNodeArr) {
                arrayList.add("https://" + dNSNode.host);
            }
            z = false;
            Log.i("DnsHelper_DnsCache", "requestDnsData start ips=" + az2.c(arrayList) + " needUseExtraIpSeed=" + z);
            Collections.shuffle(arrayList);
            StringBuilder sb2 = new StringBuilder();
            sb2.append((String) arrayList.get(0));
            sb2.append("/dns/v3/select");
            zB = b(sb2.toString(), true);
            Log.i("DnsHelper_DnsCache", "requestDnsData result1=" + zB);
            if (!zB) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:77:0x0151  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x013d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:95:? A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ArrayList<String> d() throws Throwable {
            HttpURLConnection httpURLConnection;
            BufferedReader bufferedReader;
            StringBuilder sb;
            String str = nl0.k() ? "https://43.247.89.136/prod" : "https://43.247.89.136/sit";
            BufferedReader bufferedReader2 = null;
            try {
                pe1.a("DnsHelper_DnsCache", "requestRemoteSeedList START URL:::" + str);
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection(Proxy.NO_PROXY);
            } catch (Exception e) {
                e = e;
                httpURLConnection = null;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
            }
            try {
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                b13.a(httpURLConnection);
                httpURLConnection.addRequestProperty("Host", "dname.lianxinapp.com");
                if (httpURLConnection instanceof HttpsURLConnection) {
                    HttpsHelper.getmInstance();
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(HttpsHelper.getmSSLSocketFactory());
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(HttpsHelper.DO_NOT_VERIFY);
                }
                httpURLConnection.connect();
                sb = new StringBuilder();
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader2 != null) {
                }
                if (httpURLConnection != null) {
                }
            }
            while (true) {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    } catch (Exception e3) {
                        e = e3;
                        pe1.a("DnsHelper_DnsCache", "doFetch Exception:::" + e.toString());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            } catch (IllegalStateException e5) {
                                e5.printStackTrace();
                            } catch (NullPointerException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (httpURLConnection != null) {
                        }
                        return null;
                    }
                    httpURLConnection.disconnect();
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        } catch (IllegalStateException e8) {
                            e8.printStackTrace();
                        } catch (NullPointerException e9) {
                            e9.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        throw th;
                    }
                    httpURLConnection.disconnect();
                    throw th;
                }
            }
            JSONObject jSONObject = new JSONObject(sb.toString());
            pe1.a("DnsHelper_DnsCache", "requestRemoteSeedList resultObj:::" + jSONObject);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ipSeedList");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    arrayList.add("https://" + jSONArrayOptJSONArray.optString(i2));
                }
                try {
                    bufferedReader.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                } catch (IllegalStateException e11) {
                    e11.printStackTrace();
                } catch (NullPointerException e12) {
                    e12.printStackTrace();
                }
                httpURLConnection.disconnect();
                return arrayList;
            }
            try {
                bufferedReader.close();
            } catch (IOException e13) {
                e13.printStackTrace();
            } catch (IllegalStateException e14) {
                e14.printStackTrace();
            } catch (NullPointerException e15) {
                e15.printStackTrace();
            }
            httpURLConnection.disconnect();
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            pe1.a("DnsHelper_DnsCache", "UpdateTask START");
            if ((this.h.isEmpty() || System.currentTimeMillis() - i > 30000) && ap3.a().i()) {
                i = System.currentTimeMillis();
                for (int i2 = 0; i2 < 3; i2++) {
                    pe1.a("DnsHelper_DnsCache", "[run] retryCount = " + i2);
                    if (c()) {
                        break;
                    }
                    if (i2 < 2) {
                        try {
                            Thread.sleep((i2 + 1) * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.g = null;
            this.h = null;
            synchronized (it0.n) {
                it0.n.notifyAll();
            }
        }
    }

    public static it0 k() {
        if (o == null) {
            synchronized (it0.class) {
                if (o == null) {
                    o = new it0();
                }
            }
        }
        return o;
    }

    public static String q(String str, te1 te1Var, DNSNode dNSNode) {
        String strReplace;
        if (str == null || te1Var == null || dNSNode == null) {
            strReplace = str;
        } else if (str.startsWith("https://")) {
            String str2 = dNSNode.host;
            if (str2 == null || !str2.contains(":")) {
                strReplace = str.replace(te1Var.f20971a, dNSNode.host);
            } else {
                strReplace = str.replace(te1Var.f20971a, "[" + dNSNode.host + "]");
            }
        } else {
            String str3 = dNSNode.host;
            if (str3 == null || !str3.contains(":")) {
                strReplace = str.replace(te1Var.f20971a, dNSNode.host + ":" + dNSNode.port);
            } else {
                strReplace = str.replace(te1Var.f20971a, "[" + dNSNode.host + "]:" + dNSNode.port);
            }
        }
        pe1.a("DnsHelper_DnsCache", "replaceUrl ori=" + str + " result=" + strReplace);
        return strReplace;
    }

    public void e(String str) {
        c.i = 0L;
        s(str);
    }

    public String f() {
        return this.h;
    }

    public List<te1> g() {
        return this.f;
    }

    public final List<te1> h(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < arrayList.size(); i++) {
            String str = arrayList.get(i);
            String strSubstring = str.startsWith("http://") ? str.substring(7) : str.startsWith("https://") ? str.substring(8) : null;
            if (strSubstring != null) {
                linkedHashMap.put(strSubstring, new te1(strSubstring));
            }
        }
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            arrayList2.add((te1) linkedHashMap.get(it.next().toString()));
        }
        return arrayList2;
    }

    public DNSNode[] i(String str) {
        return j(str, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DNSNode[] j(String str, boolean z) {
        DNSNode[] dNSNodeArr;
        if (z) {
            DNSNode[] dNSNodeArr2 = this.g.get(str);
            if (dNSNodeArr2 == null || dNSNodeArr2.length <= 0) {
                dNSNodeArr = null;
            } else {
                ArrayList arrayList = new ArrayList();
                for (DNSNode dNSNode : dNSNodeArr2) {
                    if (!dNSNode.ipV6) {
                        arrayList.add(dNSNode);
                    }
                }
                if (arrayList.size() > 0) {
                    dNSNodeArr = (DNSNode[]) arrayList.toArray(new DNSNode[0]);
                }
            }
        } else {
            dNSNodeArr = this.g.get(str);
        }
        if (pe1.c()) {
            pe1.a("DnsHelper_DnsCache", "getIPs domain=" + str + " ignoreIpv6" + z + " result=" + az2.c(dNSNodeArr));
        }
        return dNSNodeArr;
    }

    public Pair<te1, DNSNode> l(String str) {
        DNSNode[] dNSNodeArrI;
        for (te1 te1Var : k().g()) {
            if (te1Var.a(str.toString()) && (dNSNodeArrI = k().i(te1Var.f20971a)) != null && dNSNodeArrI.length > 0) {
                ArrayList arrayList = new ArrayList(Arrays.asList(dNSNodeArrI));
                Collections.shuffle(arrayList);
                return new Pair<>(te1Var, (DNSNode) arrayList.get(0));
            }
        }
        return null;
    }

    public void m(Context context, ArrayList<String> arrayList, String str, String str2, String str3, String str4, String[] strArr, boolean z) {
        this.f18253a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4 + "/dns/v3/select";
        m = strArr;
        pe1.d(com.zenmen.palmchat.c.b ^ true);
        this.f = h(arrayList);
        HandlerThread handlerThreadA = lg2.a("dns_cache_working_thread");
        this.i = handlerThreadA;
        handlerThreadA.start();
        Handler handler = new Handler(this.i.getLooper());
        this.j = handler;
        handler.post(new a());
        try {
            context.getContentResolver().registerContentObserver(kt0.f18824a, true, new b(this.j));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean n() {
        return this.g.isEmpty();
    }

    public final boolean o() {
        return true;
    }

    public final void p() {
        Cursor cursorQuery;
        if (!ap3.a().i()) {
            pe1.a("DnsHelper_DnsCache", "[refreshCache] isNetWorkReady =false return");
            return;
        }
        pe1.a("DnsHelper_DnsCache", "[refreshCache] start");
        HashMap map = new HashMap();
        String str = null;
        try {
            cursorQuery = this.f18253a.getContentResolver().query(kt0.f18824a, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            cursorQuery = null;
        }
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("domain"));
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("ip_list"));
                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("area"));
                try {
                    JSONArray jSONArray = new JSONArray(string2);
                    DNSNode[] dNSNodeArr = new DNSNode[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        DNSNode dNSNode = new DNSNode();
                        dNSNodeArr[i] = dNSNode;
                        if (jSONObjectOptJSONObject != null) {
                            dNSNode.host = jSONObjectOptJSONObject.optString("host");
                            dNSNodeArr[i].port = jSONObjectOptJSONObject.optInt(ReportItem.RequestKeyPort);
                            dNSNodeArr[i].ipV6 = jSONObjectOptJSONObject.optBoolean("ipV6");
                        }
                    }
                    if (jSONArray.length() > 0) {
                        map.put(string, dNSNodeArr);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                str = string3;
            }
            cursorQuery.close();
            if (!TextUtils.isEmpty(str)) {
                this.h = str;
            }
            this.g.clear();
            this.g.putAll(map);
            d();
        }
        pe1.a("DnsHelper_DnsCache", "[refreshCache] end");
    }

    public String r() {
        ConcurrentHashMap<String, DNSNode[]> concurrentHashMap = this.g;
        return (concurrentHashMap == null || concurrentHashMap.size() <= 0) ? "" : az2.c(this.g);
    }

    public void s(String str) {
        pe1.a("DnsHelper_DnsCache", "[update] reason = " + str);
        if (this.j == null || !o()) {
            return;
        }
        Message messageObtain = Message.obtain(this.j, new c(this.f18253a, this.d, this.e, this.b, this.c, str, this.j, this.g));
        messageObtain.obj = "update_task_token";
        messageObtain.sendToTarget();
    }

    public void t(String str) {
        pe1.a("DnsHelper_DnsCache", "updateSync start " + str);
        if (o()) {
            synchronized (n) {
                if (this.k == 0) {
                    this.k = 1;
                    pe1.a("DnsHelper_DnsCache", "updateSync  update ");
                    s(str);
                }
                try {
                    try {
                        n.wait(10000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    this.k = 0;
                }
            }
            pe1.a("DnsHelper_DnsCache", "updateSync end ->");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ConcurrentHashMap<String, DNSNode[]> concurrentHashMap = this.g;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            for (Map.Entry<String, DNSNode[]> entry : this.g.entrySet()) {
                sb.append(entry.getKey() + ":\n");
                DNSNode[] value = entry.getValue();
                if (value != null) {
                    for (DNSNode dNSNode : value) {
                        sb.append(dNSNode.host + ":" + dNSNode.port);
                        sb.append("\n");
                    }
                }
            }
        }
        return sb.toString();
    }

    public void u(String str) {
        this.d = str;
    }

    public final void d() {
    }
}
