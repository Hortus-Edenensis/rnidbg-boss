package com.zenmen.palmchat.chat.imp.BigText;

import android.content.Context;
import android.text.TextUtils;
import com.zenmen.palmchat.framework.httpdns.DNSNode;
import com.zenmen.palmchat.utils.HttpsHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.b13;
import defpackage.it0;
import defpackage.k86;
import defpackage.pu1;
import defpackage.rb3;
import defpackage.te1;
import defpackage.v02;
import defpackage.vw5;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class c {
    public static final String c = "c";
    public static volatile c d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f12888a = vw5.d("FontDownLoader");
    public ConcurrentHashMap<Integer, Boolean> b = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(Exception exc, int i);

        void b(int i, String str);

        void c(int i, int i2);

        void d(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f12889a;
        public v02 b;
        public a c;
        public ConcurrentHashMap<Integer, Boolean> d;

        public b(Context context, v02 v02Var, a aVar, ConcurrentHashMap<Integer, Boolean> concurrentHashMap) {
            this.f12889a = context;
            this.b = v02Var;
            this.c = aVar;
            this.d = concurrentHashMap;
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

        public final void b(String str, boolean z) throws Throwable {
            for (te1 te1Var : it0.k().g()) {
                if (te1Var.a(str)) {
                    for (int i = 0; i < 2; i++) {
                        DNSNode[] dNSNodeArrI = it0.k().i(te1Var.f20971a);
                        if (dNSNodeArrI != null) {
                            for (DNSNode dNSNode : dNSNodeArrI) {
                                String strQ = it0.q(str, te1Var, dNSNode);
                                HashMap map = new HashMap();
                                map.put("Host", te1Var.f20971a);
                                try {
                                    c(strQ, map, z);
                                    return;
                                } catch (IOException e) {
                                    this.c.a(e, this.b.f21335a);
                                    e.printStackTrace();
                                }
                            }
                            return;
                        }
                        if (!it0.k().n() || i != 0) {
                            return;
                        }
                        it0.k().t("dns cache is empty when doing HTTP request");
                    }
                    return;
                }
                try {
                    c(str, null, z);
                    return;
                } catch (Exception e2) {
                    this.c.a(e2, this.b.f21335a);
                    it0.k().s("all ip failed");
                }
            }
        }

        public final void c(String str, Map<String, String> map, boolean z) throws Throwable {
            HttpURLConnection httpURLConnectionA = a(str, map);
            for (int i = 0; httpURLConnectionA.getResponseCode() / 100 == 3 && i < 5; i++) {
                try {
                    try {
                        httpURLConnectionA = a(httpURLConnectionA.getHeaderField(HttpHeaders.LOCATION), null);
                    } catch (Exception e) {
                        this.c.a(e, this.b.f21335a);
                        if (httpURLConnectionA != null) {
                            httpURLConnectionA.disconnect();
                            return;
                        }
                        return;
                    }
                } catch (Throwable th) {
                    if (httpURLConnectionA != null) {
                        httpURLConnectionA.disconnect();
                    }
                    throw th;
                }
            }
            httpURLConnectionA.connect();
            httpURLConnectionA.getResponseCode();
            pu1.t();
            File file = new File(pu1.h);
            if (!file.exists()) {
                file.mkdir();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(com.zenmen.palmchat.c.b().getExternalCacheDir());
            String str2 = File.separator;
            sb.append(str2);
            sb.append(this.b.b);
            sb.append(".zip");
            String string = sb.toString();
            int contentLength = httpURLConnectionA.getContentLength();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnectionA.getInputStream(), 4096);
            String str3 = com.zenmen.palmchat.c.b().getExternalCacheDir() + str2 + this.b.b + ".tmp";
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
                    if (d((int) ((i2 / contentLength) * 100.0f), this.b.f21335a)) {
                        break;
                    } else {
                        z2 = false;
                    }
                }
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            File file2 = new File(str3);
            if (file2.exists()) {
                file2.renameTo(new File(string));
            }
            bufferedInputStream.close();
            httpURLConnectionA.disconnect();
            e(string);
        }

        public final boolean d(int i, int i2) {
            a aVar = this.c;
            if (aVar == null) {
                return false;
            }
            aVar.c(i, i2);
            return false;
        }

        public final void e(String str) throws Throwable {
            ZipInputStream zipInputStream;
            Throwable th;
            BufferedInputStream bufferedInputStream;
            BufferedInputStream bufferedInputStream2 = null;
            try {
                try {
                    String strB = rb3.b(new File(str));
                    if (TextUtils.isEmpty(strB) || !strB.equals(this.b.f)) {
                        throw new IOException("md5 dismatch");
                    }
                    String str2 = c.c;
                    LogUtil.i(str2, "md5 match ");
                    zipInputStream = new ZipInputStream(new FileInputStream(str));
                    try {
                        bufferedInputStream = new BufferedInputStream(zipInputStream);
                        try {
                            File file = new File(new File(pu1.h, "font_config"), this.b.b);
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            LogUtil.i(str2, "unzip font outputDir = " + file.getAbsolutePath());
                            byte[] bArr = new byte[512];
                            while (true) {
                                ZipEntry nextEntry = zipInputStream.getNextEntry();
                                if (nextEntry != null) {
                                    LogUtil.i(c.c, "decompress file :" + nextEntry.getName());
                                    String name = nextEntry.getName();
                                    if (name != null && name.contains("../")) {
                                        throw new RuntimeException("find unsafe zip file");
                                    }
                                    if (nextEntry.isDirectory()) {
                                        File file2 = new File(file, nextEntry.getName());
                                        if (!file2.exists()) {
                                            file2.mkdirs();
                                        }
                                    } else {
                                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(file, nextEntry.getName())));
                                        while (true) {
                                            int i = bufferedInputStream.read(bArr, 0, 512);
                                            if (i == -1) {
                                                break;
                                            } else {
                                                bufferedOutputStream.write(bArr, 0, i);
                                            }
                                        }
                                        bufferedOutputStream.close();
                                    }
                                } else {
                                    a aVar = this.c;
                                    if (aVar != null) {
                                        aVar.b(this.b.f21335a, file.getPath());
                                    }
                                    bufferedInputStream.close();
                                }
                            }
                        } catch (IOException unused) {
                            bufferedInputStream2 = bufferedInputStream;
                            if (bufferedInputStream2 != null) {
                                bufferedInputStream2.close();
                            }
                            if (zipInputStream == null) {
                                return;
                            }
                            zipInputStream.close();
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException unused2) {
                                    throw th;
                                }
                            }
                            if (zipInputStream != null) {
                                zipInputStream.close();
                            }
                            throw th;
                        }
                    } catch (IOException unused3) {
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream = null;
                    }
                } catch (IOException unused4) {
                }
            } catch (IOException unused5) {
                zipInputStream = null;
            } catch (Throwable th4) {
                zipInputStream = null;
                th = th4;
                bufferedInputStream = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            a aVar = this.c;
            if (aVar != null) {
                aVar.d(this.b.f21335a);
            }
            this.d.remove(Integer.valueOf(this.b.f21335a));
            b(this.b.e, true);
        }
    }

    public static String b(v02 v02Var) {
        String strC;
        File file = new File(new File(pu1.h, "font_config"), v02Var.b);
        if (!file.exists() || (strC = c(file.getPath())) == null) {
            return null;
        }
        return strC;
    }

    public static String c(String str) {
        File[] fileArrListFiles;
        File file = new File(str);
        String absolutePath = null;
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null) {
            return null;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isFile() && (file2.getName().endsWith("otf") || file2.getName().endsWith("ttf"))) {
                absolutePath = file2.getAbsolutePath();
                LogUtil.i(c, "getFontFilePath : " + absolutePath);
            }
        }
        return absolutePath;
    }

    public static c d() {
        if (d == null) {
            synchronized (c.class) {
                if (d == null) {
                    d = new c();
                }
            }
        }
        return d;
    }

    public void a(Context context, v02 v02Var, a aVar) {
        if (this.b.containsKey(Integer.valueOf(v02Var.f21335a))) {
            LogUtil.i(c, "mDownloadingFontset contains");
        } else {
            this.b.put(Integer.valueOf(v02Var.f21335a), Boolean.TRUE);
            this.f12888a.submit(new b(context, v02Var, aVar, this.b));
        }
    }
}
