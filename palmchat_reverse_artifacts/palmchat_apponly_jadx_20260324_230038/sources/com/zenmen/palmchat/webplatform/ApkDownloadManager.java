package com.zenmen.palmchat.webplatform;

import com.baidu.location.LocationConst;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.aj6;
import defpackage.ds0;
import defpackage.k86;
import defpackage.vw5;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.apache.http.HttpHeaders;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ApkDownloadManager {
    public static final String c = "ApkDownloadManager";
    public static ApkDownloadManager d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f15874a = vw5.a(c);
    public Map<String, b> b = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public enum DownloadState {
        WAITING(0),
        DOWNLOADING(1),
        PAUSED(2),
        SUCCESS(3),
        FAILED(4);

        private int code;

        DownloadState(int i) {
            this.code = i;
        }

        public int code() {
            return this.code;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15875a;
        public String b;
        public DownloadState c;
        public int d;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f15876a;
        public boolean b;

        public b(a aVar) {
            this.f15876a = aVar;
        }

        public a a() {
            return this.f15876a;
        }

        public void b() {
            this.b = true;
        }

        public DownloadState c() {
            return this.f15876a.c;
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x0157, code lost:
        
            r20.f15876a.c = com.zenmen.palmchat.webplatform.ApkDownloadManager.DownloadState.PAUSED;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:147:0x0281  */
        /* JADX WARN: Removed duplicated region for block: B:149:0x0276 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:153:0x026b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:156:0x0228 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:167:0x021d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:191:? A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v16 */
        /* JADX WARN: Type inference failed for: r11v17 */
        /* JADX WARN: Type inference failed for: r11v18 */
        /* JADX WARN: Type inference failed for: r11v19 */
        /* JADX WARN: Type inference failed for: r11v20 */
        /* JADX WARN: Type inference failed for: r11v21 */
        /* JADX WARN: Type inference failed for: r11v3, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r11v4, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r11v5 */
        /* JADX WARN: Type inference failed for: r11v8 */
        /* JADX WARN: Type inference failed for: r11v9 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() throws Throwable {
            Throwable th;
            FileOutputStream fileOutputStream;
            ?? r11;
            HttpURLConnection httpURLConnection;
            Object obj;
            int i;
            ?? r112;
            HttpURLConnection httpURLConnectionD;
            FileOutputStream fileOutputStream2;
            int responseCode;
            a aVar = this.f15876a;
            aVar.c = DownloadState.DOWNLOADING;
            boolean z = aVar.d > 0;
            try {
                httpURLConnectionD = k86.d(new URL(this.f15876a.b));
                try {
                    httpURLConnectionD.setConnectTimeout(10000);
                    httpURLConnectionD.setReadTimeout(10000);
                    if (z) {
                        try {
                            httpURLConnectionD.addRequestProperty(HttpHeaders.RANGE, "bytes=" + this.f15876a.d + "-");
                        } catch (Exception e) {
                            e = e;
                            httpURLConnection = httpURLConnectionD;
                            i = 0;
                            fileOutputStream = null;
                            r112 = 0;
                        } catch (Throwable th2) {
                            th = th2;
                            httpURLConnection = httpURLConnectionD;
                            fileOutputStream = null;
                            r11 = 0;
                            if (fileOutputStream != null) {
                            }
                            if (r11 != 0) {
                            }
                            if (httpURLConnection == null) {
                            }
                        }
                    }
                    httpURLConnectionD.connect();
                    responseCode = httpURLConnectionD.getResponseCode();
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream2 = null;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                obj = null;
                httpURLConnection = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                r11 = 0;
                httpURLConnection = null;
            }
            try {
                try {
                    if (responseCode != 404) {
                        if (responseCode / 100 == 3) {
                            String headerField = httpURLConnectionD.getHeaderField(HttpHeaders.LOCATION);
                            httpURLConnectionD.disconnect();
                            httpURLConnectionD = k86.d(new URL(headerField));
                            httpURLConnectionD.setConnectTimeout(10000);
                            httpURLConnectionD.setReadTimeout(10000);
                            if (z) {
                                httpURLConnectionD.addRequestProperty(HttpHeaders.RANGE, "bytes=" + this.f15876a.d + "-");
                            }
                            httpURLConnectionD.connect();
                        }
                        try {
                            httpURLConnectionD.getHeaderFields();
                            String absolutePath = new File(c.b().getExternalCacheDir(), this.f15876a.f15875a + com.huawei.hms.ads.dynamicloader.b.b).getAbsolutePath();
                            int contentLength = z ? this.f15876a.d + httpURLConnectionD.getContentLength() : httpURLConnectionD.getContentLength();
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnectionD.getInputStream());
                            try {
                                FileOutputStream fileOutputStream3 = new FileOutputStream(absolutePath, z);
                                try {
                                    try {
                                        byte[] bArr = new byte[2048];
                                        long j = 0;
                                        int i2 = 0;
                                        while (true) {
                                            try {
                                                int i3 = bufferedInputStream.read(bArr);
                                                if (i3 == -1) {
                                                    httpURLConnection = httpURLConnectionD;
                                                    break;
                                                }
                                                this.f15876a.d += i3;
                                                fileOutputStream3.write(bArr, 0, i3);
                                                long jCurrentTimeMillis = System.currentTimeMillis();
                                                httpURLConnection = httpURLConnectionD;
                                                byte[] bArr2 = bArr;
                                                i2 = (int) ((((double) this.f15876a.d) * 100.0d) / ((double) contentLength));
                                                if (jCurrentTimeMillis - j > 300) {
                                                    try {
                                                        try {
                                                            aj6 aj6Var = new aj6();
                                                            aj6Var.d("download");
                                                            try {
                                                                JSONObject jSONObject = new JSONObject();
                                                                jSONObject.put("name", this.f15876a.f15875a);
                                                                jSONObject.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, this.f15876a.c.code());
                                                                jSONObject.put("progress", i2);
                                                                aj6Var.c(jSONObject);
                                                                ds0.a().b(aj6Var);
                                                            } catch (JSONException e4) {
                                                                e4.printStackTrace();
                                                            }
                                                            j = jCurrentTimeMillis;
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            th = th;
                                                            fileOutputStream = fileOutputStream3;
                                                            r11 = bufferedInputStream;
                                                            if (fileOutputStream != null) {
                                                            }
                                                            if (r11 != 0) {
                                                            }
                                                            if (httpURLConnection == null) {
                                                            }
                                                        }
                                                    } catch (Exception e5) {
                                                        e = e5;
                                                        fileOutputStream = fileOutputStream3;
                                                        i = i2;
                                                        r112 = bufferedInputStream;
                                                    }
                                                }
                                                if (this.b) {
                                                    break;
                                                }
                                                httpURLConnectionD = httpURLConnection;
                                                bArr = bArr2;
                                            } catch (Exception e6) {
                                                e = e6;
                                                httpURLConnection = httpURLConnectionD;
                                            }
                                        }
                                        i = i2;
                                        try {
                                            fileOutputStream3.flush();
                                            a aVar2 = this.f15876a;
                                            if (aVar2.d == contentLength) {
                                                aVar2.c = DownloadState.SUCCESS;
                                                try {
                                                    JSONObject jSONObject2 = new JSONObject();
                                                    jSONObject2.put("gameid", this.f15876a.f15875a);
                                                    LogUtil.uploadInfoImmediate("yx1", null, null, jSONObject2.toString());
                                                } catch (JSONException e7) {
                                                    e7.printStackTrace();
                                                }
                                            } else if (aVar2.c != DownloadState.PAUSED) {
                                                aVar2.c = DownloadState.FAILED;
                                            }
                                            try {
                                                fileOutputStream3.close();
                                            } catch (IOException e8) {
                                                e8.printStackTrace();
                                            }
                                            try {
                                                bufferedInputStream.close();
                                            } catch (IOException e9) {
                                                e9.printStackTrace();
                                            }
                                        } catch (Exception e10) {
                                            e = e10;
                                            fileOutputStream = fileOutputStream3;
                                            r112 = bufferedInputStream;
                                            this.f15876a.c = DownloadState.FAILED;
                                            e.printStackTrace();
                                            if (fileOutputStream != null) {
                                            }
                                            if (r112 != 0) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            aj6 aj6Var2 = new aj6();
                                            aj6Var2.d("download");
                                            JSONObject jSONObject3 = new JSONObject();
                                            jSONObject3.put("name", this.f15876a.f15875a);
                                            jSONObject3.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, this.f15876a.c.code());
                                            jSONObject3.put("progress", i);
                                            aj6Var2.c(jSONObject3);
                                            ds0.a().b(aj6Var2);
                                            return;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        httpURLConnection = httpURLConnectionD;
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                    httpURLConnection = httpURLConnectionD;
                                    fileOutputStream = fileOutputStream3;
                                    obj = bufferedInputStream;
                                    i = 0;
                                    r112 = obj;
                                }
                            } catch (Exception e12) {
                                e = e12;
                                httpURLConnection = httpURLConnectionD;
                                fileOutputStream = null;
                                obj = bufferedInputStream;
                            } catch (Throwable th7) {
                                httpURLConnection = httpURLConnectionD;
                                th = th7;
                                fileOutputStream = null;
                                r11 = bufferedInputStream;
                            }
                        } catch (Exception e13) {
                            e = e13;
                            httpURLConnection = httpURLConnectionD;
                            fileOutputStream2 = null;
                            fileOutputStream = fileOutputStream2;
                            obj = fileOutputStream;
                        } catch (Throwable th8) {
                            httpURLConnection = httpURLConnectionD;
                            fileOutputStream2 = null;
                            th = th8;
                            fileOutputStream = fileOutputStream2;
                            r11 = fileOutputStream;
                            if (fileOutputStream != null) {
                            }
                            if (r11 != 0) {
                            }
                            if (httpURLConnection == null) {
                            }
                        }
                        httpURLConnection.disconnect();
                        aj6 aj6Var22 = new aj6();
                        aj6Var22.d("download");
                        JSONObject jSONObject32 = new JSONObject();
                        jSONObject32.put("name", this.f15876a.f15875a);
                        jSONObject32.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, this.f15876a.c.code());
                        jSONObject32.put("progress", i);
                        aj6Var22.c(jSONObject32);
                        ds0.a().b(aj6Var22);
                        return;
                    }
                    fileOutputStream2 = null;
                    try {
                        throw new IOException("not found");
                    } catch (Exception e14) {
                        e = e14;
                    } catch (Throwable th9) {
                        th = th9;
                        th = th;
                        httpURLConnection = httpURLConnectionD;
                        fileOutputStream = fileOutputStream2;
                        r11 = fileOutputStream;
                        if (fileOutputStream != null) {
                        }
                        if (r11 != 0) {
                        }
                        if (httpURLConnection == null) {
                        }
                    }
                    JSONObject jSONObject322 = new JSONObject();
                    jSONObject322.put("name", this.f15876a.f15875a);
                    jSONObject322.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, this.f15876a.c.code());
                    jSONObject322.put("progress", i);
                    aj6Var22.c(jSONObject322);
                    ds0.a().b(aj6Var22);
                    return;
                } catch (JSONException e15) {
                    e15.printStackTrace();
                    return;
                }
                this.f15876a.c = DownloadState.FAILED;
                e.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                }
                if (r112 != 0) {
                    try {
                        r112.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                aj6 aj6Var222 = new aj6();
                aj6Var222.d("download");
            } catch (Throwable th10) {
                th = th10;
                r11 = r112;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
                if (r11 != 0) {
                    try {
                        r11.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                }
                if (httpURLConnection == null) {
                    throw th;
                }
                httpURLConnection.disconnect();
                throw th;
            }
            httpURLConnection = httpURLConnectionD;
            fileOutputStream = fileOutputStream2;
            obj = fileOutputStream;
            i = 0;
            r112 = obj;
        }
    }

    public static ApkDownloadManager d() {
        if (d == null) {
            synchronized (ApkDownloadManager.class) {
                if (d == null) {
                    d = new ApkDownloadManager();
                }
            }
        }
        return d;
    }

    public synchronized void a(String str, String str2) {
        b bVar = this.b.get(str);
        if (bVar == null || bVar.c().code() > DownloadState.PAUSED.code()) {
            this.b.remove(str);
            aj6 aj6Var = new aj6();
            aj6Var.d("download");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", str);
                jSONObject.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, DownloadState.WAITING.code());
                aj6Var.c(jSONObject);
                ds0.a().b(aj6Var);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a aVar = new a();
            aVar.f15875a = str;
            aVar.b = str2;
            aVar.c = DownloadState.WAITING;
            b bVar2 = new b(aVar);
            this.b.put(str, bVar2);
            this.f15874a.execute(bVar2);
        }
    }

    public synchronized boolean b(String str) {
        return this.b.containsKey(str);
    }

    public synchronized Map<String, Integer> c() {
        HashMap map;
        map = new HashMap();
        for (String str : this.b.keySet()) {
            map.put(str, Integer.valueOf(this.b.get(str).c().code()));
        }
        return map;
    }

    public synchronized void e(String str) {
        b bVar = this.b.get(str);
        if (bVar != null) {
            bVar.b();
        }
    }

    public synchronized void f(String str) {
        b bVar = this.b.get(str);
        if (bVar != null && bVar.c() == DownloadState.PAUSED) {
            this.b.remove(str);
            a aVar = new a();
            aVar.f15875a = str;
            aVar.b = bVar.a().b;
            aVar.c = DownloadState.WAITING;
            aVar.d = bVar.a().d;
            b bVar2 = new b(aVar);
            this.b.put(str, bVar2);
            this.f15874a.execute(bVar2);
        }
    }
}
