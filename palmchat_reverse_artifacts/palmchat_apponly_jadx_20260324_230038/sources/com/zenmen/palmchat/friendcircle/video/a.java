package com.zenmen.palmchat.friendcircle.video;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import com.zenmen.palmchat.framework.httpdns.DNSNode;
import com.zenmen.palmchat.utils.HttpsHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.b13;
import defpackage.it0;
import defpackage.k86;
import defpackage.pu1;
import defpackage.te1;
import defpackage.vw5;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.mime.MIME;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final String c = "a";
    public static volatile a d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f14056a = vw5.d(c);
    public final ConcurrentHashMap<String, List<b>> b = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(String str, String str2);

        void b(String str);

        void g(Exception exc);

        void i(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f14057a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public final ConcurrentHashMap<String, List<b>> g;

        /* JADX INFO: renamed from: com.zenmen.palmchat.friendcircle.video.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C1052a extends Exception {
            public C1052a() {
            }
        }

        public c(Context context, String str, String str2, String str3, ConcurrentHashMap<String, List<b>> concurrentHashMap) {
            this.f14057a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.g = concurrentHashMap;
        }

        public HttpURLConnection a(String str, Map<String, String> map) throws IOException {
            HttpURLConnection httpURLConnectionD = k86.d(new URL(k86.R(str)));
            httpURLConnectionD.setConnectTimeout(10000);
            httpURLConnectionD.setReadTimeout(60000);
            httpURLConnectionD.setInstanceFollowRedirects(false);
            if (map != null) {
                for (String str2 : map.keySet()) {
                    httpURLConnectionD.addRequestProperty(str2, map.get(str2));
                }
            }
            b13.a(httpURLConnectionD);
            if (httpURLConnectionD instanceof HttpsURLConnection) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnectionD;
                HttpsHelper.getmInstance();
                httpsURLConnection.setSSLSocketFactory(HttpsHelper.getmSSLSocketFactory());
                httpsURLConnection.setHostnameVerifier(HttpsHelper.DO_NOT_VERIFY);
            }
            return httpURLConnectionD;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
        
            r3 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
        
            if (r3 >= 2) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
        
            r5 = defpackage.it0.k().i(r4.f20971a);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
        
            if (r5 == null) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
        
            r3 = r5.length;
            r6 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x005f, code lost:
        
            if (defpackage.it0.k().n() == false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
        
            if (r3 != 0) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
        
            defpackage.it0.k().t("dns cache is empty when doing HTTP request");
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
        
            r3 = r3 + 1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Exception b(String str, boolean z) {
            te1 next;
            int i;
            Exception e = null;
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    Iterator<te1> it = it0.k().g().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            if (next.a(str)) {
                                break;
                            }
                        }
                    }
                    try {
                        return c(str, null, z);
                    } catch (C1052a e2) {
                        throw e2;
                    } catch (Exception e3) {
                        e = e3;
                        it0.k().s("all ip failed");
                    }
                } catch (C1052a e4) {
                    e4.printStackTrace();
                    return e4;
                }
            }
            return e;
            for (DNSNode dNSNode : r5) {
                String strQ = it0.q(str, next, dNSNode);
                HashMap map = new HashMap();
                map.put("Host", next.f20971a);
                try {
                    return c(strQ, map, z);
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return c(str, null, z);
        }

        public final Exception c(String str, Map<String, String> map, boolean z) throws IOException, C1052a {
            HttpURLConnection httpURLConnectionA = a(str, map);
            int i = 0;
            while (true) {
                try {
                    if (httpURLConnectionA.getResponseCode() / 100 != 3 || i >= 5) {
                        break;
                    }
                    httpURLConnectionA = a(httpURLConnectionA.getHeaderField(HttpHeaders.LOCATION), null);
                    i++;
                } catch (Exception e) {
                    if (httpURLConnectionA != null) {
                        httpURLConnectionA.disconnect();
                    }
                    return e;
                } catch (Throwable th) {
                    if (httpURLConnectionA != null) {
                        httpURLConnectionA.disconnect();
                    }
                    throw th;
                }
            }
            httpURLConnectionA.connect();
            if (httpURLConnectionA.getResponseCode() == 200) {
                String headerField = httpURLConnectionA.getHeaderField("Media-ZX-Warning");
                if (!TextUtils.isEmpty(headerField) && headerField.equals("404")) {
                    throw new C1052a();
                }
            }
            pu1.t();
            File file = new File(pu1.l);
            if (!file.exists()) {
                file.mkdir();
            }
            String str2 = pu1.l + File.separator + d(httpURLConnectionA.getHeaderField(MIME.CONTENT_DISPOSITION));
            if (!z) {
                this.e = str2;
            }
            int contentLength = httpURLConnectionA.getContentLength();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnectionA.getInputStream(), 4096);
            String str3 = str2 + ".tmp";
            FileOutputStream fileOutputStream = new FileOutputStream(str3);
            byte[] bArr = new byte[1024];
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z2 = true;
            int i2 = 0;
            while (true) {
                int i3 = bufferedInputStream.read(bArr);
                if (i3 == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, i3);
                i2 += i3;
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                if (z && (z2 || jCurrentTimeMillis2 >= 500 || i2 == contentLength)) {
                    if (!z2) {
                        jCurrentTimeMillis = System.currentTimeMillis();
                    }
                    if (e((int) ((i2 / contentLength) * 100.0f))) {
                        break;
                    }
                    z2 = false;
                }
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            File file2 = new File(str3);
            if (file2.exists()) {
                file2.renameTo(new File(str2));
            }
            bufferedInputStream.close();
            httpURLConnectionA.disconnect();
            if (z) {
                this.f = str2;
            }
            return null;
        }

        public final String d(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(str) || (strArrSplit = str.split(x.aQ)) == null) {
                return null;
            }
            for (String str2 : strArrSplit) {
                String strTrim = str2.trim();
                if (strTrim.toLowerCase().startsWith("filename=")) {
                    StringBuilder sb = new StringBuilder(strTrim.substring(9));
                    if (sb.charAt(0) == '\"') {
                        sb.deleteCharAt(0);
                    }
                    if (sb.charAt(sb.length() - 1) == '\"') {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return null;
        }

        public final boolean e(int i) {
            ConcurrentHashMap<String, List<b>> concurrentHashMap = this.g;
            if (concurrentHashMap == null) {
                return false;
            }
            synchronized (concurrentHashMap) {
                List<b> list = this.g.get(this.b);
                if (list != null) {
                    Iterator<b> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().i(i);
                    }
                }
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            ConcurrentHashMap<String, List<b>> concurrentHashMap = this.g;
            if (concurrentHashMap != null) {
                synchronized (concurrentHashMap) {
                    List<b> list = this.g.get(this.b);
                    if (list != null) {
                        Iterator<b> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().b(this.b);
                        }
                    }
                }
            }
            Exception excB = b(this.c, true);
            ConcurrentHashMap<String, List<b>> concurrentHashMap2 = this.g;
            if (concurrentHashMap2 != null) {
                synchronized (concurrentHashMap2) {
                    List<b> list2 = this.g.get(this.b);
                    if (list2 != null) {
                        for (b bVar : list2) {
                            if (excB == null) {
                                bVar.a(this.b, this.f);
                            } else {
                                bVar.g(excB);
                            }
                        }
                    }
                    this.g.remove(this.b);
                }
            }
        }
    }

    public static a c() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    public void a(Context context, String str, String str2, String str3, b bVar) {
        synchronized (this.b) {
            List<b> list = this.b.get(str);
            if (list == null || list.isEmpty()) {
                LogUtil.d("logvideo", "host: download=" + str);
                ArrayList arrayList = new ArrayList();
                arrayList.add(bVar);
                this.b.put(str, arrayList);
                this.f14056a.submit(new c(context, str, str2, str3, this.b));
            } else {
                LogUtil.d("logvideo", "host: downloadAgain=" + str);
                list.add(bVar);
            }
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }
}
