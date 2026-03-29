package defpackage;

import android.os.Process;
import android.util.Log;
import com.zenmen.palmchat.utils.HttpsHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ft0 implements Runnable, pn2 {
    public static final String d = "ft0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gt0 f17593a;
    public ct0 b;
    public hl2 c;

    public ft0(gt0 gt0Var, ct0 ct0Var, hl2 hl2Var) {
        this.f17593a = gt0Var;
        this.c = hl2Var;
        this.b = ct0Var;
    }

    @Override // defpackage.pn2
    public HttpURLConnection a(String str, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(20000);
        httpURLConnection.setReadTimeout(20000);
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            HttpsHelper.getmInstance();
            httpsURLConnection.setSSLSocketFactory(HttpsHelper.getmSSLSocketFactory());
            httpsURLConnection.setHostnameVerifier(HttpsHelper.DO_NOT_VERIFY);
        }
        b(httpURLConnection);
        return httpURLConnection;
    }

    public final void b(HttpURLConnection httpURLConnection) {
        for (bt0 bt0Var : this.b.o) {
            httpURLConnection.addRequestProperty(bt0Var.f1813a, bt0Var.b);
        }
        httpURLConnection.setRequestProperty(HttpHeaders.RANGE, "bytes=" + this.f17593a.c + "-" + this.f17593a.d);
        String str = d;
        StringBuilder sb = new StringBuilder();
        sb.append("url:");
        sb.append(this.b.f);
        Log.d(str, sb.toString());
        Log.d(str, "Range:bytes=" + this.f17593a.c + "-" + this.f17593a.d);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0140 A[Catch: IOException -> 0x013c, TRY_LEAVE, TryCatch #8 {IOException -> 0x013c, blocks: (B:57:0x0138, B:61:0x0140), top: B:73:0x0138 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0138 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() throws Throwable {
        HttpURLConnection httpURLConnectionA;
        zu zuVar;
        InputStream inputStream;
        int i;
        Process.setThreadPriority(10);
        InputStream inputStream2 = null;
        inputStream2 = null;
        inputStream2 = null;
        HttpURLConnection httpURLConnection = null;
        try {
            LogUtil.i("DnsHelper", "DLThread");
            httpURLConnectionA = oe1.a(this, k86.R(this.b.f), null, true, false);
            try {
                zuVar = new zu(this.b.r, "rwd");
                try {
                    zuVar.seek(this.f17593a.c);
                    InputStream inputStream3 = httpURLConnectionA.getInputStream();
                    byte[] bArr = new byte[4096];
                    while (!this.f17593a.e && (i = inputStream3.read(bArr)) != -1) {
                        zuVar.write(bArr, 0, i);
                        this.f17593a.c += i;
                        this.c.onProgress(i);
                    }
                    if (this.f17593a.e) {
                        String str = d;
                        Log.d(str, "下一次开始：" + this.f17593a.c + "");
                        Log.d(str, "Thread " + this.f17593a.f17802a + " will be stopped.");
                        this.c.b(this.f17593a);
                    } else {
                        Log.d(d, "Thread " + this.f17593a.f17802a + " will be finished.");
                        this.c.c(this.f17593a);
                    }
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    zuVar.close();
                    httpURLConnectionA.disconnect();
                } catch (IOException e2) {
                    e = e2;
                    inputStream = null;
                    httpURLConnection = httpURLConnectionA;
                    try {
                        this.c.b(this.f17593a);
                        ct0 ct0Var = this.b;
                        ct0Var.j = true;
                        if (!ct0Var.p.isEmpty()) {
                            Iterator<gt0> it = this.b.p.iterator();
                            while (it.hasNext()) {
                                it.next().e = true;
                            }
                        }
                        e.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                if (httpURLConnection == null) {
                                    httpURLConnection.disconnect();
                                    return;
                                }
                                return;
                            }
                        }
                        if (zuVar != null) {
                            zuVar.close();
                        }
                        if (httpURLConnection == null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        InputStream inputStream4 = inputStream;
                        httpURLConnectionA = httpURLConnection;
                        inputStream2 = inputStream4;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                if (httpURLConnectionA == null) {
                                }
                            }
                        }
                        if (zuVar != null) {
                            zuVar.close();
                        }
                        if (httpURLConnectionA == null) {
                            throw th;
                        }
                        httpURLConnectionA.disconnect();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream2 != null) {
                    }
                    if (zuVar != null) {
                    }
                    if (httpURLConnectionA == null) {
                    }
                }
            } catch (IOException e5) {
                e = e5;
                zuVar = null;
                httpURLConnection = httpURLConnectionA;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                zuVar = null;
            }
        } catch (IOException e6) {
            e = e6;
            inputStream = null;
            zuVar = null;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnectionA = null;
            zuVar = null;
        }
    }
}
