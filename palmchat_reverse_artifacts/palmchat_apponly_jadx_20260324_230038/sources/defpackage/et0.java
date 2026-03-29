package defpackage;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tblplayer.config.PreCacheConfig;
import com.zenmen.palmchat.utils.HttpsHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.mime.MIME;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class et0 implements Runnable, hl2, pn2 {
    public static final String f = "et0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ct0 f17353a;
    public Context b;
    public int c;
    public int d;
    public long e = System.currentTimeMillis();

    public et0(Context context, ct0 ct0Var) {
        this.f17353a = ct0Var;
        this.b = context;
        this.c = ct0Var.b;
        if (ct0Var.i) {
            return;
        }
        ys0.d(context).e(ct0Var);
    }

    @Override // defpackage.pn2
    public HttpURLConnection a(String str, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setConnectTimeout(20000);
        httpURLConnection.setReadTimeout(20000);
        if (map != null) {
            for (String str2 : map.keySet()) {
                this.f17353a.o.add(new bt0(str2, map.get(str2)));
            }
        }
        d(httpURLConnection);
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            HttpsHelper.getmInstance();
            httpsURLConnection.setSSLSocketFactory(HttpsHelper.getmSSLSocketFactory());
            httpsURLConnection.setHostnameVerifier(HttpsHelper.DO_NOT_VERIFY);
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    @Override // defpackage.hl2
    public synchronized void b(gt0 gt0Var) {
        if (gt0Var == null) {
            dt0.k(this.b).n(this.f17353a.e);
            ys0.d(this.b).b(this.f17353a.e);
            ct0 ct0Var = this.f17353a;
            if (ct0Var.h) {
                ct0Var.q.onProgress(ct0Var.f16909a);
                ct0 ct0Var2 = this.f17353a;
                ct0Var2.q.onStop(ct0Var2.f16909a);
            }
            return;
        }
        ys0.d(this.b).j(gt0Var);
        int i = this.d + 1;
        this.d = i;
        if (i >= this.f17353a.p.size()) {
            Log.d(f, "All the threads was stopped.");
            this.f17353a.b = this.c;
            dt0.k(this.b).c(this.f17353a).n(this.f17353a.e);
            ys0.d(this.b).i(this.f17353a);
            this.d = 0;
            ct0 ct0Var3 = this.f17353a;
            if (ct0Var3.h) {
                ct0Var3.q.onStop(this.c);
            }
        }
    }

    @Override // defpackage.hl2
    public synchronized void c(gt0 gt0Var) {
        if (gt0Var == null) {
            dt0.k(this.b).n(this.f17353a.e);
            ys0.d(this.b).b(this.f17353a.e);
            ct0 ct0Var = this.f17353a;
            if (ct0Var.h) {
                ct0Var.q.onProgress(ct0Var.f16909a);
                ct0 ct0Var2 = this.f17353a;
                ct0Var2.q.onFinish(ct0Var2.r);
            }
            return;
        }
        this.f17353a.b(gt0Var);
        ys0.d(this.b).c(gt0Var.f17802a);
        String str = f;
        Log.d(str, "Thread size " + this.f17353a.p.size());
        if (this.f17353a.p.isEmpty()) {
            Log.d(str, "Task was finished.");
            dt0.k(this.b).n(this.f17353a.e);
            ys0.d(this.b).b(this.f17353a.e);
            ct0 ct0Var3 = this.f17353a;
            if (ct0Var3.h) {
                ct0Var3.q.onProgress(ct0Var3.f16909a);
                ct0 ct0Var4 = this.f17353a;
                ct0Var4.q.onFinish(ct0Var4.r);
            }
            dt0.k(this.b).a();
        }
    }

    public final void d(HttpURLConnection httpURLConnection) {
        for (bt0 bt0Var : this.f17353a.o) {
            httpURLConnection.addRequestProperty(bt0Var.f1813a, bt0Var.b);
        }
    }

    public final void e(HttpURLConnection httpURLConnection) throws IOException {
        int i;
        InputStream inputStream = httpURLConnection.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(this.f17353a.r);
        byte[] bArr = new byte[4096];
        while (!this.f17353a.j && (i = inputStream.read(bArr)) != -1) {
            fileOutputStream.write(bArr, 0, i);
            onProgress(i);
        }
        if (this.f17353a.j) {
            b(null);
        } else {
            c(null);
        }
        fileOutputStream.close();
        inputStream.close();
    }

    public final void f() {
        int i;
        int i2 = this.f17353a.f16909a;
        int i3 = PreCacheConfig.DEFAULT_MAX_CACHE_DIR_SIZE;
        if (i2 <= 104857600) {
            i3 = i2 / 1;
            i = 1;
        } else {
            i = i2 / PreCacheConfig.DEFAULT_MAX_CACHE_DIR_SIZE;
        }
        int i4 = i2 % i3;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i5 * i3;
            int i7 = i6 + i3;
            int i8 = i7 - 1;
            if (i5 == i - 1) {
                i8 = (i7 + i4) - 1;
            }
            gt0 gt0Var = new gt0(UUID.randomUUID().toString(), this.f17353a.e, i6, i8);
            this.f17353a.a(gt0Var);
            ys0.d(this.b).f(gt0Var);
            dt0.k(this.b).b(new ft0(gt0Var, this.f17353a, this));
        }
    }

    public final void g(HttpURLConnection httpURLConnection, int i) throws Exception {
        h(httpURLConnection);
        ys0.d(this.b).i(this.f17353a);
        ct0 ct0Var = this.f17353a;
        if (!ht0.b(ct0Var.d, ct0Var.c)) {
            throw new at0("Can not create file");
        }
        ct0 ct0Var2 = this.f17353a;
        ct0 ct0Var3 = this.f17353a;
        ct0Var2.r = new File(ct0Var3.d, ct0Var3.c);
        if (this.f17353a.r.exists() && this.f17353a.r.length() == this.f17353a.f16909a) {
            Log.d(f, "The file which we want to download was already here.");
            if (this.f17353a.h) {
                c(null);
                return;
            }
            return;
        }
        if (dt0.j() != null && this.f17353a.r.exists() && dt0.j().i()) {
            Log.d(f, "The file which we want to download was already here.");
            if (!ht0.c(this.f17353a.r)) {
                ct0 ct0Var4 = this.f17353a;
                if (ct0Var4.h) {
                    ct0Var4.q.onError(3, "The file which we want to download was already here.");
                    return;
                }
            }
        }
        ct0 ct0Var5 = this.f17353a;
        if (ct0Var5.h) {
            ct0Var5.q.onStart(ct0Var5.c, ct0Var5.f, ct0Var5.f16909a);
        }
        if (i == 200) {
            e(httpURLConnection);
            return;
        }
        if (i != 206) {
            return;
        }
        ct0 ct0Var6 = this.f17353a;
        if (ct0Var6.f16909a <= 0) {
            e(httpURLConnection);
            return;
        }
        if (!ct0Var6.i) {
            f();
            return;
        }
        Iterator<gt0> it = ct0Var6.p.iterator();
        while (it.hasNext()) {
            dt0.k(this.b).b(new ft0(it.next(), this.f17353a, this));
        }
    }

    public final void h(HttpURLConnection httpURLConnection) {
        this.f17353a.m = httpURLConnection.getHeaderField(MIME.CONTENT_DISPOSITION);
        this.f17353a.n = httpURLConnection.getHeaderField(HttpHeaders.CONTENT_LOCATION);
        this.f17353a.k = ht0.g(httpURLConnection.getContentType());
        String headerField = httpURLConnection.getHeaderField("Transfer-Encoding");
        if (TextUtils.isEmpty(headerField)) {
            try {
                this.f17353a.f16909a = Integer.parseInt(httpURLConnection.getHeaderField("Content-Length"));
            } catch (NumberFormatException unused) {
                this.f17353a.f16909a = -1;
            }
        } else {
            this.f17353a.f16909a = -1;
        }
        if (this.f17353a.f16909a == -1 && (TextUtils.isEmpty(headerField) || !headerField.equalsIgnoreCase(HTTP.CHUNK_CODING))) {
            throw new RuntimeException("Can not obtain size of download file.");
        }
        if (TextUtils.isEmpty(this.f17353a.c)) {
            ct0 ct0Var = this.f17353a;
            ct0Var.c = ht0.h(ct0Var.f, ct0Var.m, ct0Var.n);
        }
    }

    @Override // defpackage.hl2
    public synchronized void onProgress(int i) {
        this.c += i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.e > 1000) {
            Log.d(f, this.c + "");
            int i2 = this.c;
            ct0 ct0Var = this.f17353a;
            int i3 = ct0Var.f16909a;
            if (i2 > i3) {
                this.c = i3;
            }
            if (ct0Var.h) {
                ct0Var.q.onProgress(this.c);
            }
            this.e = jCurrentTimeMillis;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Process.setThreadPriority(10);
        while (this.f17353a.g < 5) {
            HttpURLConnection httpURLConnection = null;
            try {
                try {
                    LogUtil.i("DnsHelper", "DLTask");
                    HttpURLConnection httpURLConnectionA = oe1.a(this, k86.R(this.f17353a.f), null, true, false);
                    int responseCode = httpURLConnectionA.getResponseCode();
                    Log.d("AigeStudio", responseCode + "");
                    if (responseCode == 200 || responseCode == 206) {
                        String headerField = httpURLConnectionA.getHeaderField("Media-ZX-Block-Type");
                        if (!TextUtils.isEmpty(headerField) && headerField.equals("1")) {
                            ct0 ct0Var = this.f17353a;
                            if (ct0Var.h) {
                                ct0Var.q.onError(404, httpURLConnectionA.getResponseMessage());
                            }
                            dt0.k(this.b).n(this.f17353a.e);
                        } else if (TextUtils.isEmpty(headerField) || !headerField.equals("2")) {
                            g(httpURLConnectionA, responseCode);
                        } else {
                            ct0 ct0Var2 = this.f17353a;
                            if (ct0Var2.h) {
                                ct0Var2.q.onError(403, httpURLConnectionA.getResponseMessage());
                            }
                            dt0.k(this.b).n(this.f17353a.e);
                        }
                        httpURLConnectionA.disconnect();
                        return;
                    }
                    if (responseCode != 307) {
                        switch (responseCode) {
                            case 301:
                            case 302:
                            case 303:
                            case 304:
                                break;
                            default:
                                ct0 ct0Var3 = this.f17353a;
                                if (ct0Var3.h) {
                                    ct0Var3.q.onError(responseCode, httpURLConnectionA.getResponseMessage());
                                }
                                dt0.k(this.b).n(this.f17353a.e);
                                httpURLConnectionA.disconnect();
                                return;
                        }
                        while (this.f17353a.g < 5) {
                        }
                    }
                    String headerField2 = httpURLConnectionA.getHeaderField("location");
                    if (TextUtils.isEmpty(headerField2)) {
                        throw new at0("Can not obtain real url from location in header.");
                    }
                    ct0 ct0Var4 = this.f17353a;
                    ct0Var4.f = headerField2;
                    ct0Var4.g++;
                    List<bt0> list = ct0Var4.o;
                    if (list != null && list.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (bt0 bt0Var : this.f17353a.o) {
                            String str = bt0Var.f1813a;
                            if (str != null && !str.equalsIgnoreCase("host")) {
                                arrayList.add(bt0Var);
                            }
                        }
                        this.f17353a.o = arrayList;
                    }
                    httpURLConnectionA.disconnect();
                } catch (Exception e) {
                    ct0 ct0Var5 = this.f17353a;
                    if (ct0Var5.h) {
                        ct0Var5.q.onError(138, e.toString());
                    }
                    dt0.k(this.b).n(this.f17353a.e);
                    if (0 != 0) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
        try {
            throw new RuntimeException("Too many redirects");
        } catch (Exception e2) {
            ct0 ct0Var6 = this.f17353a;
            if (ct0Var6.h) {
                ct0Var6.q.onError(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_FRAME_META_CALLBACK, e2.toString());
            }
        }
    }
}
